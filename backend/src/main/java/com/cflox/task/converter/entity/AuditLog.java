package com.cflox.task.converter.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "conversion_type")
    private String conversionType;

    @Column(name = "input_params")
    private String inputParams;

    @Column(name = "output_params")
    private String outputParams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getConversionType() {
        return conversionType;
    }

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(String outputParams) {
        this.outputParams = outputParams;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                ", timestamp=" + timestamp +
                ", conversionType='" + conversionType + '\'' +
                ", inputParams='" + inputParams + '\'' +
                ", outputParams='" + outputParams + '\'' +
                '}';
    }
}
