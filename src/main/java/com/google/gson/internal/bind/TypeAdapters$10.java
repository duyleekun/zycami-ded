/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TypeAdapters$10
extends TypeAdapter {
    public AtomicIntegerArray read(JsonReader jsonReader) {
        Serializable serializable;
        int n10;
        Serializable serializable2 = new ArrayList();
        jsonReader.beginArray();
        while ((n10 = jsonReader.hasNext()) != 0) {
            try {
                n10 = jsonReader.nextInt();
            }
            catch (NumberFormatException numberFormatException) {
                serializable2 = new JsonSyntaxException(numberFormatException);
                throw serializable2;
            }
            serializable = Integer.valueOf(n10);
            serializable2.add(serializable);
        }
        jsonReader.endArray();
        int n11 = serializable2.size();
        serializable = new AtomicIntegerArray(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            Integer n12 = (Integer)serializable2.get(i10);
            int n13 = n12;
            ((AtomicIntegerArray)serializable).set(i10, n13);
        }
        return serializable;
    }

    public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
        jsonWriter.beginArray();
        int n10 = atomicIntegerArray.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = atomicIntegerArray.get(i10);
            long l10 = n11;
            jsonWriter.value(l10);
        }
        jsonWriter.endArray();
    }
}

