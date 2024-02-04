package com.example.demo.pra.pra1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Pra1Service {

    private final ObjectMapper objectMapper;

//    private final ObjectMapper mapper = new ObjectMapper();

    public String convertObjectToJson(Object obj) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(obj);
    }
}
