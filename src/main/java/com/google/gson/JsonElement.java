/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
    public abstract JsonElement deepCopy();

    public BigDecimal getAsBigDecimal() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public BigInteger getAsBigInteger() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public boolean getAsBoolean() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public byte getAsByte() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public char getAsCharacter() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public double getAsDouble() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public float getAsFloat() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public int getAsInt() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public JsonArray getAsJsonArray() {
        boolean bl2 = this.isJsonArray();
        if (bl2) {
            JsonElement jsonElement = this;
            return (JsonArray)this;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Not a JSON Array: ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public JsonNull getAsJsonNull() {
        boolean bl2 = this.isJsonNull();
        if (bl2) {
            JsonElement jsonElement = this;
            return (JsonNull)this;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Not a JSON Null: ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public JsonObject getAsJsonObject() {
        boolean bl2 = this.isJsonObject();
        if (bl2) {
            JsonElement jsonElement = this;
            return (JsonObject)this;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Not a JSON Object: ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public JsonPrimitive getAsJsonPrimitive() {
        boolean bl2 = this.isJsonPrimitive();
        if (bl2) {
            JsonElement jsonElement = this;
            return (JsonPrimitive)this;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Not a JSON Primitive: ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public long getAsLong() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public Number getAsNumber() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public short getAsShort() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public String getAsString() {
        String string2 = this.getClass().getSimpleName();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        Object object;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object = new JsonWriter(stringWriter);
        boolean bl2 = true;
        ((JsonWriter)object).setLenient(bl2);
        Streams.write(this, (JsonWriter)object);
        return stringWriter.toString();
    }
}

