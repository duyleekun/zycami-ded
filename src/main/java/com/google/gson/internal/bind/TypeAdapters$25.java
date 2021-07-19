/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Currency;

public class TypeAdapters$25
extends TypeAdapter {
    public Currency read(JsonReader jsonReader) {
        return Currency.getInstance(jsonReader.nextString());
    }

    public void write(JsonWriter jsonWriter, Currency object) {
        object = ((Currency)object).getCurrencyCode();
        jsonWriter.value((String)object);
    }
}

