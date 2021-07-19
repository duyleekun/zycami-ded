/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicBoolean;

public class TypeAdapters$9
extends TypeAdapter {
    public AtomicBoolean read(JsonReader jsonReader) {
        boolean bl2 = jsonReader.nextBoolean();
        AtomicBoolean atomicBoolean = new AtomicBoolean(bl2);
        return atomicBoolean;
    }

    public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
        boolean bl2 = atomicBoolean.get();
        jsonWriter.value(bl2);
    }
}

