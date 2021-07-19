/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$Node;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map;

public class LinkedListMultimap$NodeIterator
implements ListIterator {
    public LinkedListMultimap$Node current;
    public int expectedModCount;
    public LinkedListMultimap$Node next;
    public int nextIndex;
    public LinkedListMultimap$Node previous;
    public final /* synthetic */ LinkedListMultimap this$0;

    public LinkedListMultimap$NodeIterator(LinkedListMultimap object, int n10) {
        int n11;
        this.this$0 = object;
        this.expectedModCount = n11 = LinkedListMultimap.access$000((LinkedListMultimap)object);
        n11 = ((LinkedListMultimap)object).size();
        Preconditions.checkPositionIndex(n10, n11);
        int n12 = n11 / 2;
        if (n10 >= n12) {
            this.previous = object = LinkedListMultimap.access$100((LinkedListMultimap)object);
            this.nextIndex = n11;
            while (true) {
                int n13 = n10 + 1;
                if (n10 < n11) {
                    this.previous();
                    n10 = n13;
                    continue;
                }
                break;
            }
        } else {
            this.next = object = LinkedListMultimap.access$200((LinkedListMultimap)object);
            while (true) {
                int n14 = n10 + -1;
                if (n10 <= 0) break;
                this.next();
                n10 = n14;
            }
        }
        this.current = null;
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

    public void add(Map.Entry object) {
        object = new UnsupportedOperationException();
        throw object;
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

    public boolean hasPrevious() {
        boolean bl2;
        this.checkForConcurrentModification();
        LinkedListMultimap$Node linkedListMultimap$Node = this.previous;
        if (linkedListMultimap$Node != null) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedListMultimap$Node = null;
        }
        return bl2;
    }

    public LinkedListMultimap$Node next() {
        int n10;
        LinkedListMultimap$Node linkedListMultimap$Node;
        LinkedListMultimap$Node linkedListMultimap$Node2;
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.next);
        this.current = linkedListMultimap$Node2 = this.next;
        this.previous = linkedListMultimap$Node2;
        this.next = linkedListMultimap$Node = linkedListMultimap$Node2.next;
        this.nextIndex = n10 = this.nextIndex + 1;
        return linkedListMultimap$Node2;
    }

    public int nextIndex() {
        return this.nextIndex;
    }

    public LinkedListMultimap$Node previous() {
        int n10;
        LinkedListMultimap$Node linkedListMultimap$Node;
        LinkedListMultimap$Node linkedListMultimap$Node2;
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.previous);
        this.current = linkedListMultimap$Node2 = this.previous;
        this.next = linkedListMultimap$Node2;
        this.previous = linkedListMultimap$Node = linkedListMultimap$Node2.previous;
        this.nextIndex = n10 = this.nextIndex + -1;
        return linkedListMultimap$Node2;
    }

    public int previousIndex() {
        return this.nextIndex + -1;
    }

    public void remove() {
        int n10;
        this.checkForConcurrentModification();
        LinkedListMultimap$Node linkedListMultimap$Node = this.current;
        int n11 = 1;
        if (linkedListMultimap$Node != null) {
            n10 = n11;
        } else {
            n10 = 0;
            linkedListMultimap$Node = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        linkedListMultimap$Node = this.current;
        LinkedListMultimap$Node linkedListMultimap$Node2 = this.next;
        if (linkedListMultimap$Node != linkedListMultimap$Node2) {
            int n12;
            this.previous = linkedListMultimap$Node2 = linkedListMultimap$Node.previous;
            this.nextIndex = n12 = this.nextIndex - n11;
        } else {
            LinkedListMultimap$Node linkedListMultimap$Node3;
            this.next = linkedListMultimap$Node3 = linkedListMultimap$Node.next;
        }
        LinkedListMultimap.access$400(this.this$0, linkedListMultimap$Node);
        this.current = null;
        this.expectedModCount = n10 = LinkedListMultimap.access$000(this.this$0);
    }

    public void set(Map.Entry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void setValue(Object object) {
        boolean bl2;
        LinkedListMultimap$Node linkedListMultimap$Node = this.current;
        if (linkedListMultimap$Node != null) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedListMultimap$Node = null;
        }
        Preconditions.checkState(bl2);
        this.current.value = object;
    }
}

