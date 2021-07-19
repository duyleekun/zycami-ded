/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$Entry;
import java.util.HashMap;
import java.util.Map;

public class FastSafeIterableMap
extends SafeIterableMap {
    private HashMap mHashMap;

    public FastSafeIterableMap() {
        HashMap hashMap;
        this.mHashMap = hashMap = new HashMap();
    }

    public Map.Entry ceil(Object object) {
        boolean bl2 = this.contains(object);
        if (bl2) {
            return ((SafeIterableMap$Entry)this.mHashMap.get((Object)object)).mPrevious;
        }
        return null;
    }

    public boolean contains(Object object) {
        return this.mHashMap.containsKey(object);
    }

    public SafeIterableMap$Entry get(Object object) {
        return (SafeIterableMap$Entry)this.mHashMap.get(object);
    }

    public Object putIfAbsent(Object object, Object object2) {
        Object object3 = this.get(object);
        if (object3 != null) {
            return ((SafeIterableMap$Entry)object3).mValue;
        }
        object3 = this.mHashMap;
        object2 = this.put(object, object2);
        ((HashMap)object3).put(object, object2);
        return null;
    }

    public Object remove(Object object) {
        Object object2 = super.remove(object);
        this.mHashMap.remove(object);
        return object2;
    }
}

