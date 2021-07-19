/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;
import java.util.Map;

public class LinkedListMultimap$1ValuesImpl$1
extends TransformedListIterator {
    public final /* synthetic */ LinkedListMultimap$1ValuesImpl this$1;
    public final /* synthetic */ LinkedListMultimap$NodeIterator val$nodeItr;

    public LinkedListMultimap$1ValuesImpl$1(LinkedListMultimap$1ValuesImpl linkedListMultimap$1ValuesImpl, ListIterator listIterator, LinkedListMultimap$NodeIterator linkedListMultimap$NodeIterator) {
        this.this$1 = linkedListMultimap$1ValuesImpl;
        this.val$nodeItr = linkedListMultimap$NodeIterator;
        super(listIterator);
    }

    public void set(Object object) {
        this.val$nodeItr.setValue(object);
    }

    public Object transform(Map.Entry entry) {
        return entry.getValue();
    }
}

