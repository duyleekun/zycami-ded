/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$Node;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedTreeMap$LinkedTreeMapIterator
implements Iterator {
    public int expectedModCount;
    public LinkedTreeMap$Node lastReturned;
    public LinkedTreeMap$Node next;
    public final /* synthetic */ LinkedTreeMap this$0;

    public LinkedTreeMap$LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
        int n10;
        LinkedTreeMap$Node linkedTreeMap$Node;
        this.this$0 = linkedTreeMap;
        this.next = linkedTreeMap$Node = linkedTreeMap.header.next;
        this.lastReturned = null;
        this.expectedModCount = n10 = linkedTreeMap.modCount;
    }

    public final boolean hasNext() {
        boolean bl2;
        LinkedTreeMap$Node linkedTreeMap$Node = this.next;
        LinkedTreeMap$Node linkedTreeMap$Node2 = this.this$0.header;
        if (linkedTreeMap$Node != linkedTreeMap$Node2) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedTreeMap$Node = null;
        }
        return bl2;
    }

    public final LinkedTreeMap$Node nextNode() {
        Object object = this.next;
        Object object2 = this.this$0;
        LinkedTreeMap$Node linkedTreeMap$Node = ((LinkedTreeMap)object2).header;
        if (object != linkedTreeMap$Node) {
            int n10 = ((LinkedTreeMap)object2).modCount;
            int n11 = this.expectedModCount;
            if (n10 == n11) {
                this.next = object2 = ((LinkedTreeMap$Node)object).next;
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
            this.this$0.removeInternal((LinkedTreeMap$Node)object, true);
            this.lastReturned = null;
            this.expectedModCount = n10 = this.this$0.modCount;
            return;
        }
        object = new IllegalStateException();
        throw object;
    }
}

