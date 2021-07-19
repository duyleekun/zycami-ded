/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class TypeAdapters$8
extends TypeAdapter {
    public AtomicInteger read(JsonReader jsonReader) {
        Serializable serializable;
        int n10;
        try {
            n10 = jsonReader.nextInt();
        }
        catch (NumberFormatException numberFormatException) {
            serializable = new JsonSyntaxException(numberFormatException);
            throw serializable;
        }
        serializable = new AtomicInteger(n10);
        return serializable;
    }

    public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
        long l10 = atomicInteger.get();
        jsonWriter.value(l10);
    }
}

