/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;

public final class HashBiMap$EntryForKey
extends AbstractMapEntry {
    public int index;
    public final Object key;
    public final /* synthetic */ HashBiMap this$0;

    public HashBiMap$EntryForKey(HashBiMap object, int n10) {
        this.this$0 = object;
        this.key = object = ((HashBiMap)object).keys[n10];
        this.index = n10;
    }

    public Object getKey() {
        return this.key;
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
            Object[] objectArray = this.this$0.values;
            object = objectArray[n10];
        }
        return object;
    }

    public Object setValue(Object object) {
        this.updateIndex();
        int n10 = this.index;
        int n11 = -1;
        if (n10 == n11) {
            HashBiMap hashBiMap = this.this$0;
            Object object2 = this.key;
            return hashBiMap.put(object2, object);
        }
        Object object3 = this.this$0.values;
        Object object4 = object3[n10];
        n11 = (int)(Objects.equal(object4, object) ? 1 : 0);
        if (n11 != 0) {
            return object;
        }
        object3 = this.this$0;
        int n12 = this.index;
        HashBiMap.access$200((HashBiMap)object3, n12, object, false);
        return object4;
    }

    public void updateIndex() {
        block3: {
            Object object;
            Object object2;
            int n10;
            block2: {
                n10 = this.index;
                int n11 = -1;
                if (n10 == n11) break block2;
                object2 = this.this$0;
                int n12 = ((HashBiMap)object2).size;
                if (n10 <= n12 && (n10 = (int)(Objects.equal(object = ((HashBiMap)object2).keys[n10], object2 = this.key) ? 1 : 0)) != 0) break block3;
            }
            object = this.this$0;
            object2 = this.key;
            this.index = n10 = ((HashBiMap)object).findEntryByKey(object2);
        }
    }
}

