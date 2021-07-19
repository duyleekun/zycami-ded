/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class Gson$2
extends TypeAdapter {
    public final /* synthetic */ Gson this$0;

    public Gson$2(Gson gson) {
        this.this$0 = gson;
    }

    public Float read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        return Float.valueOf((float)jsonReader.nextDouble());
    }

    public void write(JsonWriter jsonWriter, Number number) {
        if (number == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson.checkValidFloatingPoint(number.floatValue());
        jsonWriter.value(number);
    }
}

