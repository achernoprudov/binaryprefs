package com.ironz.binaryprefs.serialization;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerSerializerImplTest {

    private static final byte INCORRECT_FLAG = 0;

    private final Serializer<Integer> serializer = new IntegerSerializerImpl();

    @Test
    public void integerConvert() {
        int value = 53;

        byte[] bytes = serializer.serialize(value);
        int restored = serializer.deserialize(Serializer.EMPTY_KEY, bytes);

        assertTrue(serializer.isMatches(value));
        assertTrue(serializer.isMatches(bytes[0]));
        assertEquals(serializer.bytesLength(), bytes.length);
        assertEquals(value, restored);
    }

    @Test
    public void integerIncorrectFlag() {
        int value = 53;

        byte[] bytes = serializer.serialize(value);
        bytes[0] = INCORRECT_FLAG;

        assertFalse(serializer.isMatches(bytes[0]));
    }
}