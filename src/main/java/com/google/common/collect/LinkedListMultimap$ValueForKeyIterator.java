/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import java.util.ListIterator;

public class LinkedListMultimap$ValueForKeyIterator
implements ListIterator {
    public LinkedListMultimap$Node current;
    public final Object key;
    public LinkedListMultimap$Node next;
    public int nextIndex;
    public LinkedListMultimap$Node previous;
    public final /* synthetic */ LinkedListMultimap this$0;

    public LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap object, Object object2) {
        this.this$0 = object;
        this.key = object2;
        object = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600((LinkedListMultimap)object).get(object2);
        object = object == null ? null : ((LinkedListMultimap$KeyList)object).head;
        this.next = object;
    }

    public LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap object, Object object2, int n10) {
        this.this$0 = object;
        object = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600((LinkedListMultimap)object).get(object2);
        int n11 = object == null ? 0 : ((LinkedListMultimap$KeyList)object).count;
        Preconditions.checkPositionIndex(n10, n11);
        int n12 = n11 / 2;
        if (n10 >= n12) {
            int n13;
            if (object == null) {
                n13 = 0;
                object = null;
            } else {
                object = ((LinkedListMultimap$KeyList)object).tail;
            }
            this.previous = object;
            this.nextIndex = n11;
            while (true) {
                n13 = n10 + 1;
                if (n10 < n11) {
                    this.previous();
                    n10 = n13;
                    continue;
                }
                break;
            }
        } else {
            int n14;
            if (object == null) {
                n14 = 0;
                object = null;
            } else {
                object = ((LinkedListMultimap$KeyList)object).head;
            }
            this.next = object;
            while (true) {
                n14 = n10 + -1;
                if (n10 <= 0) break;
                this.next();
                n10 = n14;
            }
        }
        this.key = object2;
        this.current = null;
    }

    public void add(Object object) {
        int n10;
        LinkedListMultimap linkedListMultimap = this.this$0;
        Object object2 = this.key;
        LinkedListMultimap$Node linkedListMultimap$Node = this.next;
        this.previous = object = LinkedListMultimap.access$700(linkedListMultimap, object2, object, linkedListMultimap$Node);
        this.nextIndex = n10 = this.nextIndex + 1;
        this.current = null;
    }

    public boolean hasNext() {
        boolean bl2;
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
        LinkedListMultimap$Node linkedListMultimap$Node = this.previous;
        if (linkedListMultimap$Node != null) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedListMultimap$Node = null;
        }
        return bl2;
    }

    public Object next() {
        int n10;
        LinkedListMultimap$Node linkedListMultimap$Node;
        LinkedListMultimap$Node linkedListMultimap$Node2;
        LinkedListMultimap.access$300(this.next);
        this.current = linkedListMultimap$Node2 = this.next;
        this.previous = linkedListMultimap$Node2;
        this.next = linkedListMultimap$Node = linkedListMultimap$Node2.nextSibling;
        this.nextIndex = n10 = this.nextIndex + 1;
        return linkedListMultimap$Node2.value;
    }

    public int nextIndex() {
        return this.nextIndex;
    }

    public Object previous() {
        int n10;
        LinkedListMultimap$Node linkedListMultimap$Node;
        LinkedListMultimap$Node linkedListMultimap$Node2;
        LinkedListMultimap.access$300(this.previous);
        this.current = linkedListMultimap$Node2 = this.previous;
        this.next = linkedListMultimap$Node2;
        this.previous = linkedListMultimap$Node = linkedListMultimap$Node2.previousSibling;
        this.nextIndex = n10 = this.nextIndex + -1;
        return linkedListMultimap$Node2.value;
    }

    public int previousIndex() {
        return this.nextIndex + -1;
    }

    public void remove() {
        int n10;
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
            this.previous = linkedListMultimap$Node2 = linkedListMultimap$Node.previousSibling;
            this.nextIndex = n12 = this.nextIndex - n11;
        } else {
            LinkedListMultimap$Node linkedListMultimap$Node3;
            this.next = linkedListMultimap$Node3 = linkedListMultimap$Node.nextSibling;
        }
        LinkedListMultimap.access$400(this.this$0, linkedListMultimap$Node);
        this.current = null;
    }

    public void set(Object object) {
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

