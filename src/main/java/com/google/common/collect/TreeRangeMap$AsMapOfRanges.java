/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import java.io.Serializable;
import java.util.Iterator;

public final class TreeRangeMap$AsMapOfRanges
extends Maps$IteratorBasedAbstractMap {
    public final Iterable entryIterable;
    public final /* synthetic */ TreeRangeMap this$0;

    public TreeRangeMap$AsMapOfRanges(TreeRangeMap treeRangeMap, Iterable iterable) {
        this.this$0 = treeRangeMap;
        this.entryIterable = iterable;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Iterator entryIterator() {
        return this.entryIterable.iterator();
    }

    public Object get(Object object) {
        boolean bl2 = object instanceof Range;
        if (bl2) {
            boolean bl3;
            object = (Range)object;
            Object object2 = TreeRangeMap.access$000(this.this$0);
            Serializable serializable = ((Range)object).lowerBound;
            if ((object2 = (TreeRangeMap$RangeMapEntry)object2.get(serializable)) != null && (bl3 = ((Range)(serializable = ((TreeRangeMap$RangeMapEntry)object2).getKey())).equals(object))) {
                return ((TreeRangeMap$RangeMapEntry)object2).getValue();
            }
        }
        return null;
    }

    public int size() {
        return TreeRangeMap.access$000(this.this$0).size();
    }
}

