package com.sample.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.io.IOException;

public class StringSerializer extends JsonSerializer {
    @Inject
    public StringSerializer() {
    }

    @Override
    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (obj == null) {
            jsonGenerator.writeNull();
        } else {
            String objAsString = obj.toString().trim();

            if (StringUtils.isEmpty(objAsString)) {
                jsonGenerator.writeNull();
            } else {
                // Uncomment the line below if you want to escape the response
                //jsonGenerator.writeString(htmlUtilsWrapper.htmlEncode(objAsString));
                jsonGenerator.writeString(objAsString);
            }
        }
    }
}
