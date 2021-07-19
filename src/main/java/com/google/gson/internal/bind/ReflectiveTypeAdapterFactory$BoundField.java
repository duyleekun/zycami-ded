/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public abstract class ReflectiveTypeAdapterFactory$BoundField {
    public final boolean deserialized;
    public final String name;
    public final boolean serialized;

    public ReflectiveTypeAdapterFactory$BoundField(String string2, boolean bl2, boolean bl3) {
        this.name = string2;
        this.serialized = bl2;
        this.deserialized = bl3;
    }

    public abstract void read(JsonReader var1, Object var2);

    public abstract void write(JsonWriter var1, Object var2);

    public abstract boolean writeField(Object var1);
}

