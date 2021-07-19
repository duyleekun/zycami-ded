/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$EntryForKey;
import com.google.common.collect.HashBiMap$View;
import com.google.common.collect.Hashing;
import java.util.Map;

public final class HashBiMap$EntrySet
extends HashBiMap$View {
    public final /* synthetic */ HashBiMap this$0;

    public HashBiMap$EntrySet(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
        super(hashBiMap);
    }

    public boolean contains(Object object) {
        int n10 = object instanceof Map.Entry;
        boolean bl2 = false;
        if (n10 != 0) {
            boolean bl3;
            int n11;
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            object = object.getValue();
            Object[] objectArray = this.this$0;
            n10 = objectArray.findEntryByKey(object2);
            if (n10 != (n11 = -1) && (bl3 = Objects.equal(object, object2 = (objectArray = this.this$0.values)[n10]))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Map.Entry forEntry(int n10) {
        HashBiMap hashBiMap = this.this$0;
        HashBiMap$EntryForKey hashBiMap$EntryForKey = new HashBiMap$EntryForKey(hashBiMap, n10);
        return hashBiMap$EntryForKey;
    }

    public boolean remove(Object object) {
        int n10 = object instanceof Map.Entry;
        if (n10 != 0) {
            boolean bl2;
            int n11;
            object = (Map.Entry)object;
            Object k10 = object.getKey();
            object = object.getValue();
            Object object2 = this.this$0;
            int n12 = Hashing.smearedHash(k10);
            n10 = ((HashBiMap)object2).findEntryByKey(k10, n12);
            if (n10 != (n11 = -1) && (bl2 = Objects.equal(object, object2 = this.this$0.values[n10]))) {
                this.this$0.removeEntryKeyHashKnown(n10, n12);
                return true;
            }
        }
        return false;
    }
}

