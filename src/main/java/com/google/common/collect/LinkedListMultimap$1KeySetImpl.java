/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$DistinctKeyIterator;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;

public class LinkedListMultimap$1KeySetImpl
extends Sets$ImprovedAbstractSet {
    public final /* synthetic */ LinkedListMultimap this$0;

    public LinkedListMultimap$1KeySetImpl(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public Iterator iterator() {
        LinkedListMultimap linkedListMultimap = this.this$0;
        LinkedListMultimap$DistinctKeyIterator linkedListMultimap$DistinctKeyIterator = new LinkedListMultimap$DistinctKeyIterator(linkedListMultimap, null);
        return linkedListMultimap$DistinctKeyIterator;
    }

    public boolean remove(Object object) {
        return this.this$0.removeAll(object).isEmpty() ^ true;
    }

    public int size() {
        return LinkedListMultimap.access$600(this.this$0).size();
    }
}

