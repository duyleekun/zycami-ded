/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

public class Gson$5
extends TypeAdapter {
    public final /* synthetic */ TypeAdapter val$longAdapter;

    public Gson$5(TypeAdapter typeAdapter) {
        this.val$longAdapter = typeAdapter;
    }

    public AtomicLongArray read(JsonReader jsonReader) {
        Serializable serializable;
        boolean bl2;
        ArrayList<Serializable> arrayList = new ArrayList<Serializable>();
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            long l10 = ((Number)this.val$longAdapter.read(jsonReader)).longValue();
            serializable = Long.valueOf(l10);
            arrayList.add(serializable);
        }
        jsonReader.endArray();
        int n10 = arrayList.size();
        serializable = new AtomicLongArray(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Long l11 = (Long)arrayList.get(i10);
            long l12 = l11;
            ((AtomicLongArray)serializable).set(i10, l12);
        }
        return serializable;
    }

    public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
        jsonWriter.beginArray();
        int n10 = atomicLongArray.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            TypeAdapter typeAdapter = this.val$longAdapter;
            long l10 = atomicLongArray.get(i10);
            Long l11 = l10;
            typeAdapter.write(jsonWriter, l11);
        }
        jsonWriter.endArray();
    }
}

