package com.example.order.utils;

import com.example.order.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class UtilityMapper {
    public static Order responseToModel(String json)  {
        try {
            return getMapper().readValue(json, Order.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public static String getJsonString(Order json) {
        try {
            return getMapper().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static ObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
