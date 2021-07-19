/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class TypeAdapters$28
extends TypeAdapter {
    public Locale read(JsonReader object) {
        Object object2 = ((JsonReader)object).peek();
        Object object3 = JsonToken.NULL;
        String string2 = null;
        if (object2 == object3) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object2 = new StringTokenizer((String)(object = ((JsonReader)object).nextString()), (String)(object3 = "_"));
        boolean bl2 = ((StringTokenizer)object2).hasMoreElements();
        if (bl2) {
            object = ((StringTokenizer)object2).nextToken();
        } else {
            bl2 = false;
            object = null;
        }
        boolean bl3 = ((StringTokenizer)object2).hasMoreElements();
        if (bl3) {
            object3 = ((StringTokenizer)object2).nextToken();
        } else {
            bl3 = false;
            object3 = null;
        }
        boolean bl4 = ((StringTokenizer)object2).hasMoreElements();
        if (bl4) {
            string2 = ((StringTokenizer)object2).nextToken();
        }
        if (object3 == null && string2 == null) {
            object2 = new Locale((String)object);
            return object2;
        }
        if (string2 == null) {
            object2 = new Locale((String)object, (String)object3);
            return object2;
        }
        object2 = new Locale((String)object, (String)object3, string2);
        return object2;
    }

    public void write(JsonWriter jsonWriter, Locale object) {
        object = object == null ? null : ((Locale)object).toString();
        jsonWriter.value((String)object);
    }
}

