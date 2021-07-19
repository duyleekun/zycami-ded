/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import java.util.Map;

public class SafeIterableMap$Entry
implements Map.Entry {
    public final Object mKey;
    public SafeIterableMap$Entry mNext;
    public SafeIterableMap$Entry mPrevious;
    public final Object mValue;

    public SafeIterableMap$Entry(Object object, Object object2) {
        this.mKey = object;
        this.mValue = object2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof SafeIterableMap$Entry;
        if (!bl4) {
            return false;
        }
        object = (SafeIterableMap$Entry)object;
        Object object2 = this.mKey;
        Object object3 = ((SafeIterableMap$Entry)object).mKey;
        bl4 = object2.equals(object3);
        if (!bl4 || !(bl2 = (object2 = this.mValue).equals(object = ((SafeIterableMap$Entry)object).mValue))) {
            bl3 = false;
        }
        return bl3;
    }

    public Object getKey() {
        return this.mKey;
    }

    public Object getValue() {
        return this.mValue;
    }

    public int hashCode() {
        int n10 = this.mKey.hashCode();
        int n11 = this.mValue.hashCode();
        return n10 ^ n11;
    }

    public Object setValue(Object object) {
        object = new UnsupportedOperationException("An entry modification is not supported");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.mKey;
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.mValue;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

