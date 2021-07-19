/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.TypeAdapters$36;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$14
extends TypeAdapter {
    public Number read(JsonReader object) {
        Object object2 = ((JsonReader)object).peek();
        Object object3 = TypeAdapters$36.$SwitchMap$com$google$gson$stream$JsonToken;
        int n10 = object2.ordinal();
        int n11 = object3[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 3)) {
            n10 = 4;
            if (n11 == n10) {
                ((JsonReader)object).nextNull();
                return null;
            }
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            ((StringBuilder)object3).append("Expecting number, got: ");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object = new JsonSyntaxException((String)object2);
            throw object;
        }
        object = ((JsonReader)object).nextString();
        object2 = new LazilyParsedNumber((String)object);
        return object2;
    }

    public void write(JsonWriter jsonWriter, Number number) {
        jsonWriter.value(number);
    }
}

