package com.cflox.task.converter.audittrail;

import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.entity.AuditLog;
import com.cflox.task.converter.repository.AuditLogRepository;
import com.cflox.task.converter.service.BinaryToRomanConversion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryToRomanConversion.class);

    private final AuditLogRepository auditLogRepository;

    public AuditLogAspect(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @AfterReturning(value = "@annotation(auditLog)", returning = "result")
    public void logConversion(JoinPoint joinPoint, AuditLogAnnotation auditLog, Object result) throws JsonProcessingException {
        ConversionRequest request = (ConversionRequest) joinPoint.getArgs()[0];
        String inputParams = new ObjectMapper().writeValueAsString(request);
        String outputParams = result.toString();

        AuditLog auditLogEntry = new AuditLog();
        auditLogEntry.setTimestamp(LocalDateTime.now());
        auditLogEntry.setConversionType(request.getFrom() + " to " + request.getTo());
        auditLogEntry.setInputParams(inputParams);
        auditLogEntry.setOutputParams(outputParams);
        LOGGER.info(auditLogEntry.toString());
        auditLogRepository.save(auditLogEntry);
    }
}
