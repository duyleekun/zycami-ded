/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.backend.KeyValueHandler;
import com.google.common.flogger.util.Checks;

public class MetadataKey {
    private final boolean canRepeat;
    private final Class clazz;
    private final String label;

    public MetadataKey(String object, Class clazz, boolean bl2) {
        object = Checks.checkMetadataIdentifier((String)object);
        this.label = object;
        this.clazz = object = (Class)Checks.checkNotNull(clazz, "class");
        this.canRepeat = bl2;
    }

    public static MetadataKey repeated(String string2, Class clazz) {
        MetadataKey metadataKey = new MetadataKey(string2, clazz, true);
        return metadataKey;
    }

    public static MetadataKey single(String string2, Class clazz) {
        MetadataKey metadataKey = new MetadataKey(string2, clazz, false);
        return metadataKey;
    }

    public final boolean canRepeat() {
        return this.canRepeat;
    }

    public final Object cast(Object object) {
        return this.clazz.cast(object);
    }

    public void emit(Object object, KeyValueHandler keyValueHandler) {
        String string2 = this.getLabel();
        keyValueHandler.handle(string2, object);
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public final String getLabel() {
        return this.label;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getName();
        stringBuilder.append(string2);
        stringBuilder.append("/");
        string2 = this.label;
        stringBuilder.append(string2);
        stringBuilder.append("[");
        string2 = this.clazz.getName();
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

