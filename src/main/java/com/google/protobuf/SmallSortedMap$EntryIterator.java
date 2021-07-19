/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmallSortedMap$EntryIterator
implements Iterator {
    private Iterator lazyOverflowIterator;
    private boolean nextCalledBeforeRemove;
    private int pos = -1;
    public final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$EntryIterator(SmallSortedMap smallSortedMap) {
        this.this$0 = smallSortedMap;
    }

    public /* synthetic */ SmallSortedMap$EntryIterator(SmallSortedMap smallSortedMap, SmallSortedMap$1 smallSortedMap$1) {
        this(smallSortedMap);
    }

    private Iterator getOverflowIterator() {
        Iterator iterator2 = this.lazyOverflowIterator;
        if (iterator2 == null) {
            this.lazyOverflowIterator = iterator2 = SmallSortedMap.access$700(this.this$0).entrySet().iterator();
        }
        return this.lazyOverflowIterator;
    }

    public boolean hasNext() {
        Object object;
        int n10 = this.pos;
        int n11 = 1;
        List list = SmallSortedMap.access$600(this.this$0);
        int n12 = list.size();
        if ((n10 += n11) >= n12 && ((n10 = (int)((object = SmallSortedMap.access$700(this.this$0)).isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((object = this.getOverflowIterator()).hasNext() ? 1 : 0)) == 0)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public Map.Entry next() {
        int n10;
        int n11 = 1;
        this.nextCalledBeforeRemove = n11;
        this.pos = n10 = this.pos + n11;
        List list = SmallSortedMap.access$600(this.this$0);
        n11 = list.size();
        if (n10 < n11) {
            list = SmallSortedMap.access$600(this.this$0);
            n10 = this.pos;
            return (Map.Entry)list.get(n10);
        }
        return (Map.Entry)this.getOverflowIterator().next();
    }

    public void remove() {
        int n10 = this.nextCalledBeforeRemove;
        if (n10 != 0) {
            this.nextCalledBeforeRemove = false;
            Object object = this.this$0;
            SmallSortedMap.access$300((SmallSortedMap)object);
            n10 = this.pos;
            List list = SmallSortedMap.access$600(this.this$0);
            int n11 = list.size();
            if (n10 < n11) {
                int n12;
                object = this.this$0;
                n11 = this.pos;
                this.pos = n12 = n11 + -1;
                SmallSortedMap.access$800((SmallSortedMap)object, n11);
            } else {
                object = this.getOverflowIterator();
                object.remove();
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}

