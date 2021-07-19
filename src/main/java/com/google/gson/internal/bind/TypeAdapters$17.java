/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;

public class TypeAdapters$17
extends TypeAdapter {
    public BigDecimal read(JsonReader object) {
        JsonToken jsonToken;
        Object object2 = ((JsonReader)object).peek();
        if (object2 == (jsonToken = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        try {
            object = ((JsonReader)object).nextString();
        }
        catch (NumberFormatException numberFormatException) {
            object2 = new JsonSyntaxException(numberFormatException);
            throw object2;
        }
        object2 = new BigDecimal((String)object);
        return object2;
    }

    public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
        jsonWriter.value(bigDecimal);
    }
}

