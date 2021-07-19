/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashing;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class CompactHashMap$EntrySetView
extends AbstractSet {
    public final /* synthetic */ CompactHashMap this$0;

    public CompactHashMap$EntrySetView(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        int n10;
        Object object2;
        Map map = this.this$0.delegateOrNull();
        if (map != null) {
            return map.entrySet().contains(object);
        }
        int n11 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (n11 != 0 && (n11 = CompactHashMap.access$400((CompactHashMap)(map = this.this$0), object2 = (object = (Map.Entry)object).getKey())) != (n10 = -1) && (bl2 = Objects.equal(map = (object2 = this.this$0.values)[n11], object = object.getValue()))) {
            bl3 = true;
        }
        return bl3;
    }

    public Iterator iterator() {
        return this.this$0.entrySetIterator();
    }

    public boolean remove(Object object) {
        Map map = this.this$0.delegateOrNull();
        if (map != null) {
            return map.entrySet().remove(object);
        }
        boolean n10 = object instanceof Map.Entry;
        if (n10) {
            int n11;
            object = (Map.Entry)object;
            map = this.this$0;
            boolean bl2 = ((CompactHashMap)map).needsAllocArrays();
            if (bl2) {
                return false;
            }
            map = this.this$0;
            int n12 = CompactHashMap.access$500((CompactHashMap)map);
            Object k10 = object.getKey();
            Object v10 = object.getValue();
            Object object2 = CompactHashMap.access$600(this.this$0);
            object = this.this$0;
            int[] nArray = ((CompactHashMap)object).entries;
            Object[] objectArray = ((CompactHashMap)object).keys;
            Object[] objectArray2 = ((CompactHashMap)object).values;
            int n13 = CompactHashing.remove(k10, v10, n12, object2, nArray, objectArray, objectArray2);
            if (n13 == (n11 = -1)) {
                return false;
            }
            this.this$0.moveLastEntry(n13, n12);
            CompactHashMap.access$710(this.this$0);
            this.this$0.incrementModCount();
            return true;
        }
        return false;
    }

    public int size() {
        return this.this$0.size();
    }
}

