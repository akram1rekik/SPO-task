package com.servicepartner.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;

public class MapperUtil {

    @SuppressWarnings("unchecked")
    public static <C> C generateJsonStringToPojoForRequest(String jsonstring, Class<C> pojoClass)
            throws ParseException {
        C pojo;
        if (pojoClass.isAssignableFrom(String.class)) {
            pojo = (C) jsonstring;
        } else {
            ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
            try {
                pojo = mapper.readValue(jsonstring, pojoClass);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ParseException("Mapping failed", 0);
            }
        }
        return pojo;
    }
}