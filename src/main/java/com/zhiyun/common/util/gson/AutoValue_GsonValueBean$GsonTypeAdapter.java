/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.util.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zhiyun.common.util.gson.AutoValue_GsonValueBean;
import d.v.e.l.q2.b;

public final class AutoValue_GsonValueBean$GsonTypeAdapter
extends TypeAdapter {
    private final Gson a;

    public AutoValue_GsonValueBean$GsonTypeAdapter(Gson gson) {
        this.a = gson;
    }

    public b a(JsonReader object) {
        boolean bl2;
        JsonToken jsonToken;
        Object object2 = ((JsonReader)object).peek();
        if (object2 == (jsonToken = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        ((JsonReader)object).beginObject();
        while (bl2 = ((JsonReader)object).hasNext()) {
            JsonToken jsonToken2;
            object2 = ((JsonReader)object).nextName();
            jsonToken = ((JsonReader)object).peek();
            if (jsonToken == (jsonToken2 = JsonToken.NULL)) {
                ((JsonReader)object).nextNull();
                continue;
            }
            ((String)object2).hashCode();
            ((JsonReader)object).skipValue();
        }
        ((JsonReader)object).endObject();
        object = new AutoValue_GsonValueBean();
        return object;
    }

    public void b(JsonWriter jsonWriter, b b10) {
        if (b10 == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.endObject();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TypeAdapter(");
        stringBuilder.append("GsonValueBean");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

