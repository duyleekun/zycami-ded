/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$View;
import com.google.common.collect.Hashing;

public final class HashBiMap$ValueSet
extends HashBiMap$View {
    public final /* synthetic */ HashBiMap this$0;

    public HashBiMap$ValueSet(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
        super(hashBiMap);
    }

    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    public Object forEntry(int n10) {
        return this.this$0.values[n10];
    }

    public boolean remove(Object object) {
        int n10;
        HashBiMap hashBiMap = this.this$0;
        int n11 = Hashing.smearedHash(object);
        int n12 = hashBiMap.findEntryByValue(object, n11);
        if (n12 != (n10 = -1)) {
            this.this$0.removeEntryValueHashKnown(n12, n11);
            return true;
        }
        return false;
    }
}

