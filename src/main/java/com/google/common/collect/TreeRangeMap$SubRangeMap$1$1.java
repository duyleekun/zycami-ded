/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public class TreeRangeMap$SubRangeMap$1$1
extends AbstractIterator {
    public final /* synthetic */ TreeRangeMap$SubRangeMap$1 this$2;
    public final /* synthetic */ Iterator val$backingItr;

    public TreeRangeMap$SubRangeMap$1$1(TreeRangeMap$SubRangeMap$1 treeRangeMap$SubRangeMap$1, Iterator iterator2) {
        this.this$2 = treeRangeMap$SubRangeMap$1;
        this.val$backingItr = iterator2;
    }

    public Map.Entry computeNext() {
        Object object = this.val$backingItr;
        boolean bl2 = object.hasNext();
        if (bl2) {
            Serializable serializable;
            object = (TreeRangeMap$RangeMapEntry)this.val$backingItr.next();
            Serializable serializable2 = ((TreeRangeMap$RangeMapEntry)object).getUpperBound();
            int n10 = ((Cut)serializable2).compareTo((Cut)(serializable = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)this.this$2.this$1).lowerBound));
            if (n10 <= 0) {
                return (Map.Entry)this.endOfData();
            }
            serializable2 = ((TreeRangeMap$RangeMapEntry)object).getKey();
            serializable = TreeRangeMap$SubRangeMap.access$300(this.this$2.this$1);
            serializable2 = ((Range)serializable2).intersection((Range)serializable);
            object = ((TreeRangeMap$RangeMapEntry)object).getValue();
            return Maps.immutableEntry(serializable2, object);
        }
        return (Map.Entry)this.endOfData();
    }
}

