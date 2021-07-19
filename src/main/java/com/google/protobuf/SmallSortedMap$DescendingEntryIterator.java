/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmallSortedMap$DescendingEntryIterator
implements Iterator {
    private Iterator lazyOverflowIterator;
    private int pos;
    public final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$DescendingEntryIterator(SmallSortedMap smallSortedMap) {
        int n10;
        this.this$0 = smallSortedMap;
        this.pos = n10 = SmallSortedMap.access$600(smallSortedMap).size();
    }

    public /* synthetic */ SmallSortedMap$DescendingEntryIterator(SmallSortedMap smallSortedMap, SmallSortedMap.1 var2_2) {
        this(smallSortedMap);
    }

    private Iterator getOverflowIterator() {
        Iterator iterator2 = this.lazyOverflowIterator;
        if (iterator2 == null) {
            this.lazyOverflowIterator = iterator2 = SmallSortedMap.access$900(this.this$0).entrySet().iterator();
        }
        return this.lazyOverflowIterator;
    }

    public boolean hasNext() {
        Iterator iterator2;
        List list;
        int n10;
        int n11 = this.pos;
        if (n11 > 0 && n11 <= (n10 = (list = SmallSortedMap.access$600(this.this$0)).size()) || (n11 = (int)((iterator2 = this.getOverflowIterator()).hasNext() ? 1 : 0)) != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            iterator2 = null;
        }
        return n11 != 0;
    }

    public Map.Entry next() {
        int n10;
        Object object = this.getOverflowIterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return (Map.Entry)this.getOverflowIterator().next();
        }
        object = SmallSortedMap.access$600(this.this$0);
        this.pos = n10 = this.pos + -1;
        return (Map.Entry)object.get(n10);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

