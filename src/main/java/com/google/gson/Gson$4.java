/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicLong;

public class Gson$4
extends TypeAdapter {
    public final /* synthetic */ TypeAdapter val$longAdapter;

    public Gson$4(TypeAdapter typeAdapter) {
        this.val$longAdapter = typeAdapter;
    }

    public AtomicLong read(JsonReader object) {
        object = (Number)this.val$longAdapter.read((JsonReader)object);
        long l10 = ((Number)object).longValue();
        AtomicLong atomicLong = new AtomicLong(l10);
        return atomicLong;
    }

    public void write(JsonWriter jsonWriter, AtomicLong number) {
        TypeAdapter typeAdapter = this.val$longAdapter;
        number = number.get();
        typeAdapter.write(jsonWriter, number);
    }
}

