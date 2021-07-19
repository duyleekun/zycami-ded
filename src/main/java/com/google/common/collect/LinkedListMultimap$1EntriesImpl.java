/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class LinkedListMultimap$1EntriesImpl
extends AbstractSequentialList {
    public final /* synthetic */ LinkedListMultimap this$0;

    public LinkedListMultimap$1EntriesImpl(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
    }

    public ListIterator listIterator(int n10) {
        LinkedListMultimap linkedListMultimap = this.this$0;
        LinkedListMultimap$NodeIterator linkedListMultimap$NodeIterator = new LinkedListMultimap$NodeIterator(linkedListMultimap, n10);
        return linkedListMultimap$NodeIterator;
    }

    public int size() {
        return LinkedListMultimap.access$900(this.this$0);
    }
}

