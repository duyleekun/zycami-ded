/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$View$1;
import java.util.AbstractSet;
import java.util.Iterator;

public abstract class HashBiMap$View
extends AbstractSet {
    public final HashBiMap biMap;

    public HashBiMap$View(HashBiMap hashBiMap) {
        this.biMap = hashBiMap;
    }

    public void clear() {
        this.biMap.clear();
    }

    public abstract Object forEntry(int var1);

    public Iterator iterator() {
        HashBiMap$View$1 hashBiMap$View$1 = new HashBiMap$View$1(this);
        return hashBiMap$View$1;
    }

    public int size() {
        return this.biMap.size;
    }
}

