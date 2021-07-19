/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;

public final class HashBiMap$EntryForValue
extends AbstractMapEntry {
    public final HashBiMap biMap;
    public int index;
    public final Object value;

    public HashBiMap$EntryForValue(HashBiMap object, int n10) {
        this.biMap = object;
        this.value = object = ((HashBiMap)object).values[n10];
        this.index = n10;
    }

    private void updateIndex() {
        block3: {
            Object object;
            Object[] objectArray;
            int n10;
            block2: {
                Object object2;
                n10 = this.index;
                int n11 = -1;
                if (n10 == n11) break block2;
                objectArray = this.biMap;
                int n12 = objectArray.size;
                if (n10 <= n12 && (n10 = (int)(Objects.equal(object2 = this.value, object = (objectArray = objectArray.values)[n10]) ? 1 : 0)) != 0) break block3;
            }
            object = this.biMap;
            objectArray = this.value;
            this.index = n10 = ((HashBiMap)object).findEntryByValue(objectArray);
        }
    }

    public Object getKey() {
        return this.value;
    }

    public Object getValue() {
        Object object;
        this.updateIndex();
        int n10 = this.index;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
            object = null;
        } else {
            Object[] objectArray = this.biMap.keys;
            object = objectArray[n10];
        }
        return object;
    }

    public Object setValue(Object object) {
        this.updateIndex();
        int n10 = this.index;
        int n11 = -1;
        if (n10 == n11) {
            HashBiMap hashBiMap = this.biMap;
            Object object2 = this.value;
            return hashBiMap.putInverse(object2, object, false);
        }
        Object object3 = this.biMap.keys;
        Object object4 = object3[n10];
        n11 = (int)(Objects.equal(object4, object) ? 1 : 0);
        if (n11 != 0) {
            return object;
        }
        object3 = this.biMap;
        int n12 = this.index;
        HashBiMap.access$400((HashBiMap)object3, n12, object, false);
        return object4;
    }
}

