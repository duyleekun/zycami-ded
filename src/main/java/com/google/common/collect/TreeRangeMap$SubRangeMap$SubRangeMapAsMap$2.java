/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2
extends Maps$EntrySet {
    public final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    public TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
    }

    public boolean isEmpty() {
        return this.iterator().hasNext() ^ true;
    }

    public Iterator iterator() {
        return this.this$2.entryIterator();
    }

    public Map map() {
        return this.this$2;
    }

    public boolean retainAll(Collection object) {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap = this.this$2;
        object = Predicates.not(Predicates.in((Collection)object));
        return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$400(treeRangeMap$SubRangeMap$SubRangeMapAsMap, (Predicate)object);
    }

    public int size() {
        return Iterators.size(this.iterator());
    }
}

