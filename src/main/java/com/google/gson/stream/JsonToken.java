/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.stream;

public final class JsonToken
extends Enum {
    private static final /* synthetic */ JsonToken[] $VALUES;
    public static final /* enum */ JsonToken BEGIN_ARRAY;
    public static final /* enum */ JsonToken BEGIN_OBJECT;
    public static final /* enum */ JsonToken BOOLEAN;
    public static final /* enum */ JsonToken END_ARRAY;
    public static final /* enum */ JsonToken END_DOCUMENT;
    public static final /* enum */ JsonToken END_OBJECT;
    public static final /* enum */ JsonToken NAME;
    public static final /* enum */ JsonToken NULL;
    public static final /* enum */ JsonToken NUMBER;
    public static final /* enum */ JsonToken STRING;

    static {
        JsonToken jsonToken;
        JsonToken jsonToken2;
        JsonToken jsonToken3;
        JsonToken jsonToken4;
        JsonToken jsonToken5;
        JsonToken jsonToken6;
        JsonToken jsonToken7;
        JsonToken jsonToken8;
        JsonToken jsonToken9;
        JsonToken jsonToken10;
        BEGIN_ARRAY = jsonToken10 = new JsonToken("BEGIN_ARRAY", 0);
        int n10 = 1;
        END_ARRAY = jsonToken9 = new JsonToken("END_ARRAY", n10);
        int n11 = 2;
        BEGIN_OBJECT = jsonToken8 = new JsonToken("BEGIN_OBJECT", n11);
        int n12 = 3;
        END_OBJECT = jsonToken7 = new JsonToken("END_OBJECT", n12);
        NAME = jsonToken6 = new JsonToken("NAME", 4);
        STRING = jsonToken5 = new JsonToken("STRING", 5);
        NUMBER = jsonToken4 = new JsonToken("NUMBER", 6);
        BOOLEAN = jsonToken3 = new JsonToken("BOOLEAN", 7);
        NULL = jsonToken2 = new JsonToken("NULL", 8);
        int n13 = 9;
        END_DOCUMENT = jsonToken = new JsonToken("END_DOCUMENT", n13);
        JsonToken[] jsonTokenArray = new JsonToken[10];
        jsonTokenArray[0] = jsonToken10;
        jsonTokenArray[n10] = jsonToken9;
        jsonTokenArray[n11] = jsonToken8;
        jsonTokenArray[n12] = jsonToken7;
        jsonTokenArray[4] = jsonToken6;
        jsonTokenArray[5] = jsonToken5;
        jsonTokenArray[6] = jsonToken4;
        jsonTokenArray[7] = jsonToken3;
        jsonTokenArray[8] = jsonToken2;
        jsonTokenArray[n13] = jsonToken;
        $VALUES = jsonTokenArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private JsonToken() {
        void var2_-1;
        void var1_-1;
    }

    public static JsonToken valueOf(String string2) {
        return Enum.valueOf(JsonToken.class, string2);
    }

    public static JsonToken[] values() {
        return (JsonToken[])$VALUES.clone();
    }
}

