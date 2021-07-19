/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;

public class ConcurrentHashMultiset$3
extends ForwardingIterator {
    private Multiset$Entry last;
    public final /* synthetic */ ConcurrentHashMultiset this$0;
    public final /* synthetic */ Iterator val$readOnlyIterator;

    public ConcurrentHashMultiset$3(ConcurrentHashMultiset concurrentHashMultiset, Iterator iterator2) {
        this.this$0 = concurrentHashMultiset;
        this.val$readOnlyIterator = iterator2;
    }

    public Iterator delegate() {
        return this.val$readOnlyIterator;
    }

    public Multiset$Entry next() {
        Multiset$Entry multiset$Entry;
        this.last = multiset$Entry = (Multiset$Entry)super.next();
        return multiset$Entry;
    }

    public void remove() {
        boolean bl2;
        Object object = this.last;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        CollectPreconditions.checkRemove(bl2);
        object = this.this$0;
        Object object2 = this.last.getElement();
        ((ConcurrentHashMultiset)object).setCount(object2, 0);
        this.last = null;
    }
}

