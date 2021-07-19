/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.StandardTable$Row;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$Row$1
implements Iterator {
    public final /* synthetic */ StandardTable$Row this$1;
    public final /* synthetic */ Iterator val$iterator;

    public StandardTable$Row$1(StandardTable$Row row, Iterator iterator2) {
        this.this$1 = row;
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Map.Entry next() {
        StandardTable$Row standardTable$Row = this.this$1;
        Map.Entry entry = (Map.Entry)this.val$iterator.next();
        return standardTable$Row.wrapEntry(entry);
    }

    public void remove() {
        this.val$iterator.remove();
        this.this$1.maintainEmptyInvariant();
    }
}

