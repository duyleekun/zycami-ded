/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.ForwardingObject;
import java.util.Map;

public abstract class ForwardingMapEntry
extends ForwardingObject
implements Map.Entry {
    public abstract Map.Entry delegate();

    public boolean equals(Object object) {
        return this.delegate().equals(object);
    }

    public Object getKey() {
        return this.delegate().getKey();
    }

    public Object getValue() {
        return this.delegate().getValue();
    }

    public int hashCode() {
        return this.delegate().hashCode();
    }

    public Object setValue(Object object) {
        return this.delegate().setValue(object);
    }

    public boolean standardEquals(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            Object k10;
            object = (Map.Entry)object;
            Object object2 = this.getKey();
            bl2 = Objects.equal(object2, k10 = object.getKey());
            if (bl2 && (bl4 = Objects.equal(object2 = this.getValue(), object = object.getValue()))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int standardHashCode() {
        int n10;
        Object object = this.getKey();
        Object object2 = this.getValue();
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public String standardToString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getKey();
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

