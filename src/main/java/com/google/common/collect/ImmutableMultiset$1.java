/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

public class ImmutableMultiset$1
extends UnmodifiableIterator {
    public Object element;
    public int remaining;
    public final /* synthetic */ ImmutableMultiset this$0;
    public final /* synthetic */ Iterator val$entryIterator;

    public ImmutableMultiset$1(ImmutableMultiset immutableMultiset, Iterator iterator2) {
        this.this$0 = immutableMultiset;
        this.val$entryIterator = iterator2;
    }

    public boolean hasNext() {
        Iterator iterator2;
        int n10 = this.remaining;
        if (n10 <= 0 && !(n10 = (iterator2 = this.val$entryIterator).hasNext())) {
            n10 = 0;
            iterator2 = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.remaining;
        if (n10 <= 0) {
            Object object;
            Multiset$Entry multiset$Entry = (Multiset$Entry)this.val$entryIterator.next();
            this.element = object = multiset$Entry.getElement();
            this.remaining = n10 = multiset$Entry.getCount();
        }
        this.remaining = n10 = this.remaining + -1;
        return this.element;
    }
}

