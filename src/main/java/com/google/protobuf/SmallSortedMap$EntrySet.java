/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class SmallSortedMap$EntrySet
extends AbstractSet {
    public final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$EntrySet(SmallSortedMap smallSortedMap) {
        this.this$0 = smallSortedMap;
    }

    public /* synthetic */ SmallSortedMap$EntrySet(SmallSortedMap smallSortedMap, SmallSortedMap$1 smallSortedMap$1) {
        this(smallSortedMap);
    }

    public boolean add(Map.Entry entry) {
        boolean bl2 = this.contains(entry);
        if (!bl2) {
            SmallSortedMap smallSortedMap = this.this$0;
            Comparable comparable = (Comparable)entry.getKey();
            entry = entry.getValue();
            smallSortedMap.put(comparable, (Object)entry);
            return true;
        }
        return false;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        boolean bl2;
        object = (Map.Entry)object;
        Object object2 = this.this$0;
        Object k10 = object.getKey();
        if (!((object2 = ((SmallSortedMap)object2).get(k10)) == (object = object.getValue()) || object2 != null && (bl2 = object2.equals(object)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Iterator iterator() {
        SmallSortedMap smallSortedMap = this.this$0;
        SmallSortedMap$EntryIterator smallSortedMap$EntryIterator = new SmallSortedMap$EntryIterator(smallSortedMap, null);
        return smallSortedMap$EntryIterator;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object = (Map.Entry)object);
        if (bl2) {
            SmallSortedMap smallSortedMap = this.this$0;
            object = object.getKey();
            smallSortedMap.remove(object);
            return true;
        }
        return false;
    }

    public int size() {
        return this.this$0.size();
    }
}

