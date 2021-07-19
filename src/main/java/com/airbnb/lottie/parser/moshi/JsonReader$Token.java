/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

public final class JsonReader$Token
extends Enum {
    private static final /* synthetic */ JsonReader$Token[] $VALUES;
    public static final /* enum */ JsonReader$Token BEGIN_ARRAY;
    public static final /* enum */ JsonReader$Token BEGIN_OBJECT;
    public static final /* enum */ JsonReader$Token BOOLEAN;
    public static final /* enum */ JsonReader$Token END_ARRAY;
    public static final /* enum */ JsonReader$Token END_DOCUMENT;
    public static final /* enum */ JsonReader$Token END_OBJECT;
    public static final /* enum */ JsonReader$Token NAME;
    public static final /* enum */ JsonReader$Token NULL;
    public static final /* enum */ JsonReader$Token NUMBER;
    public static final /* enum */ JsonReader$Token STRING;

    static {
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2;
        JsonReader$Token jsonReader$Token3;
        JsonReader$Token jsonReader$Token4;
        JsonReader$Token jsonReader$Token5;
        JsonReader$Token jsonReader$Token6;
        JsonReader$Token jsonReader$Token7;
        JsonReader$Token jsonReader$Token8;
        JsonReader$Token jsonReader$Token9;
        JsonReader$Token jsonReader$Token10;
        BEGIN_ARRAY = jsonReader$Token10 = new JsonReader$Token("BEGIN_ARRAY", 0);
        int n10 = 1;
        END_ARRAY = jsonReader$Token9 = new JsonReader$Token("END_ARRAY", n10);
        int n11 = 2;
        BEGIN_OBJECT = jsonReader$Token8 = new JsonReader$Token("BEGIN_OBJECT", n11);
        int n12 = 3;
        END_OBJECT = jsonReader$Token7 = new JsonReader$Token("END_OBJECT", n12);
        NAME = jsonReader$Token6 = new JsonReader$Token("NAME", 4);
        STRING = jsonReader$Token5 = new JsonReader$Token("STRING", 5);
        NUMBER = jsonReader$Token4 = new JsonReader$Token("NUMBER", 6);
        BOOLEAN = jsonReader$Token3 = new JsonReader$Token("BOOLEAN", 7);
        NULL = jsonReader$Token2 = new JsonReader$Token("NULL", 8);
        int n13 = 9;
        END_DOCUMENT = jsonReader$Token = new JsonReader$Token("END_DOCUMENT", n13);
        JsonReader$Token[] jsonReader$TokenArray = new JsonReader$Token[10];
        jsonReader$TokenArray[0] = jsonReader$Token10;
        jsonReader$TokenArray[n10] = jsonReader$Token9;
        jsonReader$TokenArray[n11] = jsonReader$Token8;
        jsonReader$TokenArray[n12] = jsonReader$Token7;
        jsonReader$TokenArray[4] = jsonReader$Token6;
        jsonReader$TokenArray[5] = jsonReader$Token5;
        jsonReader$TokenArray[6] = jsonReader$Token4;
        jsonReader$TokenArray[7] = jsonReader$Token3;
        jsonReader$TokenArray[8] = jsonReader$Token2;
        jsonReader$TokenArray[n13] = jsonReader$Token;
        $VALUES = jsonReader$TokenArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private JsonReader$Token() {
        void var2_-1;
        void var1_-1;
    }

    public static JsonReader$Token valueOf(String string2) {
        return Enum.valueOf(JsonReader$Token.class, string2);
    }

    public static JsonReader$Token[] values() {
        return (JsonReader$Token[])$VALUES.clone();
    }
}

