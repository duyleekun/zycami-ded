/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Iterator;

public class TreeRangeMap$SubRangeMap$1
extends TreeRangeMap$SubRangeMap$SubRangeMapAsMap {
    public final /* synthetic */ TreeRangeMap$SubRangeMap this$1;

    public TreeRangeMap$SubRangeMap$1(TreeRangeMap$SubRangeMap treeRangeMap$SubRangeMap) {
        this.this$1 = treeRangeMap$SubRangeMap;
        super(treeRangeMap$SubRangeMap);
    }

    public Iterator entryIterator() {
        Object object = TreeRangeMap$SubRangeMap.access$300(this.this$1);
        boolean bl2 = ((Range)object).isEmpty();
        if (bl2) {
            return Iterators.emptyIterator();
        }
        object = TreeRangeMap.access$000(this.this$1.this$0);
        Object object2 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)this.this$1).upperBound;
        object = object.headMap(object2, false).descendingMap().values().iterator();
        object2 = new TreeRangeMap$SubRangeMap$1$1(this, (Iterator)object);
        return object2;
    }
}

