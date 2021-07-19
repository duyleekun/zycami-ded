/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigInteger;

public class TypeAdapters$18
extends TypeAdapter {
    public BigInteger read(JsonReader object) {
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
        object2 = new BigInteger((String)object);
        return object2;
    }

    public void write(JsonWriter jsonWriter, BigInteger bigInteger) {
        jsonWriter.value(bigInteger);
    }
}

