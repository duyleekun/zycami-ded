/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter$1;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter {
    public final Object fromJson(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        return this.read(jsonReader);
    }

    public final Object fromJson(String string2) {
        StringReader stringReader = new StringReader(string2);
        return this.fromJson(stringReader);
    }

    public final Object fromJsonTree(JsonElement jsonElement) {
        Object object;
        try {
            object = new JsonTreeReader(jsonElement);
        }
        catch (IOException iOException) {
            object = new JsonIOException(iOException);
            throw object;
        }
        return this.read((JsonReader)object);
    }

    public final TypeAdapter nullSafe() {
        TypeAdapter$1 typeAdapter$1 = new TypeAdapter$1(this);
        return typeAdapter$1;
    }

    public abstract Object read(JsonReader var1);

    public final String toJson(Object object) {
        Object object2 = new StringWriter();
        try {
            this.toJson((Writer)object2, object);
            return ((StringWriter)object2).toString();
        }
        catch (IOException iOException) {
            object2 = new AssertionError((Object)iOException);
            throw object2;
        }
    }

    public final void toJson(Writer writer, Object object) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        this.write(jsonWriter, object);
    }

    public final JsonElement toJsonTree(Object object) {
        Object object2;
        try {
            object2 = new JsonTreeWriter();
        }
        catch (IOException iOException) {
            object2 = new JsonIOException(iOException);
            throw object2;
        }
        this.write((JsonWriter)object2, object);
        return ((JsonTreeWriter)object2).get();
    }

    public abstract void write(JsonWriter var1, Object var2);
}

