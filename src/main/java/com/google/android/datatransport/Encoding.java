/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport;

import java.util.Objects;

public final class Encoding {
    private final String name;

    private Encoding(String string2) {
        Objects.requireNonNull(string2, "name is null");
        this.name = string2;
    }

    public static Encoding of(String string2) {
        Encoding encoding = new Encoding(string2);
        return encoding;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof Encoding;
        if (!bl2) {
            return false;
        }
        String string2 = this.name;
        object = ((Encoding)object).name;
        return string2.equals(object);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Encoding{name=\"");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

