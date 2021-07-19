/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$5
extends TypeAdapter {
    public Number read(JsonReader jsonReader) {
        byte by2;
        JsonToken jsonToken;
        Object object = jsonReader.peek();
        if (object == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        try {
            by2 = (byte)jsonReader.nextInt();
        }
        catch (NumberFormatException numberFormatException) {
            object = new JsonSyntaxException(numberFormatException);
            throw object;
        }
        return by2;
    }

    public void write(JsonWriter jsonWriter, Number number) {
        jsonWriter.value(number);
    }
}

