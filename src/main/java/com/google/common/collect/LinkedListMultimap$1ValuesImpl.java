/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl$1;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class LinkedListMultimap$1ValuesImpl
extends AbstractSequentialList {
    public final /* synthetic */ LinkedListMultimap this$0;

    public LinkedListMultimap$1ValuesImpl(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
    }

    public ListIterator listIterator(int n10) {
        LinkedListMultimap linkedListMultimap = this.this$0;
        LinkedListMultimap$NodeIterator linkedListMultimap$NodeIterator = new LinkedListMultimap$NodeIterator(linkedListMultimap, n10);
        LinkedListMultimap$1ValuesImpl$1 linkedListMultimap$1ValuesImpl$1 = new LinkedListMultimap$1ValuesImpl$1(this, linkedListMultimap$NodeIterator, linkedListMultimap$NodeIterator);
        return linkedListMultimap$1ValuesImpl$1;
    }

    public int size() {
        return LinkedListMultimap.access$900(this.this$0);
    }
}

