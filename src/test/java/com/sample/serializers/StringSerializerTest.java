package com.sample.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StringSerializerTest {
    private StringSerializer underTest;
    private JsonGenerator mockJsonGenerator;
    private SerializerProvider mockSerializerProvider;

    @BeforeEach
    public void setup() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockSerializerProvider = mock(SerializerProvider.class);

        underTest = new StringSerializer();
    }

    @Test
    public void serialize_CalledWithNullObject_CallsJsonGeneratorWriteNull() throws IOException {
        underTest.serialize(null, mockJsonGenerator, mockSerializerProvider);

        verify(mockJsonGenerator).writeNull();
    }

    @Test
    public void serialize_CalledWithEmptyStringObject_CallsJsonGeneratorWriteNull() throws IOException {
        underTest.serialize("", mockJsonGenerator, mockSerializerProvider);

        verify(mockJsonGenerator).writeNull();
    }

    @Test
    public void serialize_CalledWithStringWithOnlySpacesObject_CallsJsonGeneratorWriteNull() throws IOException {
        underTest.serialize(StringUtils.repeat(" ", new Random().nextInt(5)), mockJsonGenerator, mockSerializerProvider);

        verify(mockJsonGenerator).writeNull();
    }

    @Test
    public void serialize_CalledWithValidString_CallsJsonGeneratorWriteStringWithValueFromHtmlUtilsWrapper() throws IOException {
        String expected = RandomStringUtils.randomAlphabetic(5);

        underTest.serialize(expected, mockJsonGenerator, mockSerializerProvider);

        verify(mockJsonGenerator).writeString(expected);
    }
}