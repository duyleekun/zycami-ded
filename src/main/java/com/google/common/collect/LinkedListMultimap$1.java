/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class LinkedListMultimap$1
extends AbstractSequentialList {
    public final /* synthetic */ LinkedListMultimap this$0;
    public final /* synthetic */ Object val$key;

    public LinkedListMultimap$1(LinkedListMultimap linkedListMultimap, Object object) {
        this.this$0 = linkedListMultimap;
        this.val$key = object;
    }

    public ListIterator listIterator(int n10) {
        LinkedListMultimap linkedListMultimap = this.this$0;
        Object object = this.val$key;
        LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(linkedListMultimap, object, n10);
        return linkedListMultimap$ValueForKeyIterator;
    }

    public int size() {
        int n10;
        Object object = LinkedListMultimap.access$600(this.this$0);
        Object object2 = this.val$key;
        if ((object = (LinkedListMultimap$KeyList)object.get(object2)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((LinkedListMultimap$KeyList)object).count;
        }
        return n10;
    }
}

