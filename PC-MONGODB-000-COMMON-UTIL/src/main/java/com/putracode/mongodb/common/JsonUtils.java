package com.putracode.mongodb.common;

/**
 * Created by KrisnaPutra on 12/30/2015.
 */
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils
{
    ObjectMapper objectMapper;
    Logger log = LoggerFactory.getLogger(JsonUtils.class);

    public JsonUtils()
    {
        this.objectMapper = new ObjectMapper();
    }

    public String toJson(Object obj)
            throws IOException
    {
        return this.objectMapper.writeValueAsString(obj);
    }

    public <T> Object fromJson(String json, Class<T> cls)
            throws IOException
    {
        return this.objectMapper.readValue(json, cls);
    }
}