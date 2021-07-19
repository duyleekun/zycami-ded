/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public class LinkedListMultimap$DistinctKeyIterator
implements Iterator {
    public LinkedListMultimap$Node current;
    public int expectedModCount;
    public LinkedListMultimap$Node next;
    public final Set seenKeys;
    public final /* synthetic */ LinkedListMultimap this$0;

    private LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap linkedListMultimap) {
        int n10;
        this.this$0 = linkedListMultimap;
        Object object = Sets.newHashSetWithExpectedSize(linkedListMultimap.keySet().size());
        this.seenKeys = object;
        this.next = object = LinkedListMultimap.access$200(linkedListMultimap);
        this.expectedModCount = n10 = LinkedListMultimap.access$000(linkedListMultimap);
    }

    public /* synthetic */ LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap linkedListMultimap, LinkedListMultimap$1 linkedListMultimap$1) {
        this(linkedListMultimap);
    }

    private void checkForConcurrentModification() {
        int n10;
        Serializable serializable = this.this$0;
        int n11 = LinkedListMultimap.access$000(serializable);
        if (n11 == (n10 = this.expectedModCount)) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public boolean hasNext() {
        boolean bl2;
        this.checkForConcurrentModification();
        LinkedListMultimap$Node linkedListMultimap$Node = this.next;
        if (linkedListMultimap$Node != null) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedListMultimap$Node = null;
        }
        return bl2;
    }

    public Object next() {
        boolean bl2;
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.next);
        Object object = this.next;
        this.current = object;
        Set set = this.seenKeys;
        object = ((LinkedListMultimap$Node)object).key;
        set.add(object);
        do {
            this.next = object = this.next.next;
        } while (object != null && !(bl2 = (set = this.seenKeys).add(object = ((LinkedListMultimap$Node)object).key)));
        return this.current.key;
    }

    public void remove() {
        int n10;
        this.checkForConcurrentModification();
        Object object = this.current;
        if (object != null) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        object = this.this$0;
        Object object2 = this.current.key;
        LinkedListMultimap.access$500((LinkedListMultimap)object, object2);
        this.current = null;
        this.expectedModCount = n10 = LinkedListMultimap.access$000(this.this$0);
    }
}

