/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.Map;

public final class LocalCache$WriteThroughEntry
implements Map.Entry {
    public final Object key;
    public final /* synthetic */ LocalCache this$0;
    public Object value;

    public LocalCache$WriteThroughEntry(LocalCache localCache, Object object, Object object2) {
        this.this$0 = localCache;
        this.key = object;
        this.value = object2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object k10;
        Object object2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (bl3 && (bl3 = (object2 = this.key).equals(k10 = (object = (Map.Entry)object).getKey())) && (bl2 = (object2 = this.value).equals(object = object.getValue()))) {
            bl4 = true;
        }
        return bl4;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int n10 = this.key.hashCode();
        int n11 = this.value.hashCode();
        return n10 ^ n11;
    }

    public Object setValue(Object object) {
        Object object2 = this.this$0;
        Object object3 = this.key;
        object2 = ((LocalCache)object2).put(object3, object);
        this.value = object;
        return object2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getKey();
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

