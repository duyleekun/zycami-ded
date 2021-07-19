/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.internal.LinkedHashTreeMap$Node;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedHashTreeMap$LinkedTreeMapIterator
implements Iterator {
    public int expectedModCount;
    public LinkedHashTreeMap$Node lastReturned;
    public LinkedHashTreeMap$Node next;
    public final /* synthetic */ LinkedHashTreeMap this$0;

    public LinkedHashTreeMap$LinkedTreeMapIterator(LinkedHashTreeMap linkedHashTreeMap) {
        int n10;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node;
        this.this$0 = linkedHashTreeMap;
        this.next = linkedHashTreeMap$Node = linkedHashTreeMap.header.next;
        this.lastReturned = null;
        this.expectedModCount = n10 = linkedHashTreeMap.modCount;
    }

    public final boolean hasNext() {
        boolean bl2;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this.next;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this.this$0.header;
        if (linkedHashTreeMap$Node != linkedHashTreeMap$Node2) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedHashTreeMap$Node = null;
        }
        return bl2;
    }

    public final LinkedHashTreeMap$Node nextNode() {
        Object object = this.next;
        Object object2 = this.this$0;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = ((LinkedHashTreeMap)object2).header;
        if (object != linkedHashTreeMap$Node) {
            int n10 = ((LinkedHashTreeMap)object2).modCount;
            int n11 = this.expectedModCount;
            if (n10 == n11) {
                this.next = object2 = ((LinkedHashTreeMap$Node)object).next;
                this.lastReturned = object;
                return object;
            }
            object = new ConcurrentModificationException();
            throw object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final void remove() {
        Object object = this.lastReturned;
        if (object != null) {
            int n10;
            this.this$0.removeInternal((LinkedHashTreeMap$Node)object, true);
            this.lastReturned = null;
            this.expectedModCount = n10 = this.this$0.modCount;
            return;
        }
        object = new IllegalStateException();
        throw object;
    }
}

