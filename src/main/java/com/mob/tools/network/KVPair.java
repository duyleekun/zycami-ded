/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

public class KVPair {
    public final String name;
    public final Object value;

    public KVPair(String string2, Object object) {
        this.name = string2;
        this.value = object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append(" = ");
        object = this.value;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

