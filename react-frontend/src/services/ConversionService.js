import axios from 'axios';

const CONVERT_API_BASE_URL = "http://localhost:8080/api/v1/conversions";

class ConversionService {
    convert(request){
        return axios.post(CONVERT_API_BASE_URL, request);
    }
}

export default new ConversionService()