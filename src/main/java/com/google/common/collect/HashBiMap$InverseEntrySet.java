/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$EntryForValue;
import com.google.common.collect.HashBiMap$View;
import com.google.common.collect.Hashing;
import java.util.Map;

public class HashBiMap$InverseEntrySet
extends HashBiMap$View {
    public HashBiMap$InverseEntrySet(HashBiMap hashBiMap) {
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
            Object[] objectArray = this.biMap;
            n10 = objectArray.findEntryByValue(object2);
            if (n10 != (n11 = -1) && (bl3 = Objects.equal(object2 = (objectArray = this.biMap.keys)[n10], object))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Map.Entry forEntry(int n10) {
        HashBiMap hashBiMap = this.biMap;
        HashBiMap$EntryForValue hashBiMap$EntryForValue = new HashBiMap$EntryForValue(hashBiMap, n10);
        return hashBiMap$EntryForValue;
    }

    public boolean remove(Object object) {
        int n10 = object instanceof Map.Entry;
        if (n10 != 0) {
            boolean bl2;
            int n11;
            object = (Map.Entry)object;
            Object k10 = object.getKey();
            object = object.getValue();
            Object object2 = this.biMap;
            int n12 = Hashing.smearedHash(k10);
            n10 = ((HashBiMap)object2).findEntryByValue(k10, n12);
            if (n10 != (n11 = -1) && (bl2 = Objects.equal(object2 = this.biMap.keys[n10], object))) {
                this.biMap.removeEntryValueHashKnown(n10, n12);
                return true;
            }
        }
        return false;
    }
}

