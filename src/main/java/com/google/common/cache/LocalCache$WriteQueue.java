/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$WriteQueue$1;
import com.google.common.cache.LocalCache$WriteQueue$2;
import com.google.common.cache.ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

public final class LocalCache$WriteQueue
extends AbstractQueue {
    public final ReferenceEntry head;

    public LocalCache$WriteQueue() {
        LocalCache$WriteQueue$1 localCache$WriteQueue$1 = new LocalCache$WriteQueue$1(this);
        this.head = localCache$WriteQueue$1;
    }

    public void clear() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInWriteQueue();
        while (referenceEntry2 != (referenceEntry = this.head)) {
            referenceEntry = referenceEntry2.getNextInWriteQueue();
            LocalCache.nullifyWriteOrder(referenceEntry2);
            referenceEntry2 = referenceEntry;
        }
        referenceEntry.setNextInWriteQueue(referenceEntry);
        referenceEntry2 = this.head;
        referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
    }

    public boolean contains(Object object) {
        boolean bl2;
        LocalCache$NullEntry localCache$NullEntry;
        if ((object = ((ReferenceEntry)object).getNextInWriteQueue()) != (localCache$NullEntry = LocalCache$NullEntry.INSTANCE)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isEmpty() {
        boolean bl2;
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInWriteQueue();
        if (referenceEntry2 == (referenceEntry = this.head)) {
            bl2 = true;
        } else {
            bl2 = false;
            referenceEntry2 = null;
        }
        return bl2;
    }

    public Iterator iterator() {
        ReferenceEntry referenceEntry = this.peek();
        LocalCache$WriteQueue$2 localCache$WriteQueue$2 = new LocalCache$WriteQueue$2(this, referenceEntry);
        return localCache$WriteQueue$2;
    }

    public boolean offer(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2 = referenceEntry.getPreviousInWriteQueue();
        ReferenceEntry referenceEntry3 = referenceEntry.getNextInWriteQueue();
        LocalCache.connectWriteOrder(referenceEntry2, referenceEntry3);
        LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), referenceEntry);
        referenceEntry2 = this.head;
        LocalCache.connectWriteOrder(referenceEntry, referenceEntry2);
        return true;
    }

    public ReferenceEntry peek() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInWriteQueue();
        if (referenceEntry2 == (referenceEntry = this.head)) {
            referenceEntry2 = null;
        }
        return referenceEntry2;
    }

    public ReferenceEntry poll() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInWriteQueue();
        if (referenceEntry2 == (referenceEntry = this.head)) {
            return null;
        }
        this.remove(referenceEntry2);
        return referenceEntry2;
    }

    public boolean remove(Object object) {
        boolean bl2;
        object = (ReferenceEntry)object;
        ReferenceEntry referenceEntry = object.getPreviousInWriteQueue();
        ReferenceEntry referenceEntry2 = object.getNextInWriteQueue();
        LocalCache.connectWriteOrder(referenceEntry, referenceEntry2);
        LocalCache.nullifyWriteOrder((ReferenceEntry)object);
        object = LocalCache$NullEntry.INSTANCE;
        if (referenceEntry2 != object) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int size() {
        ReferenceEntry referenceEntry;
        int n10 = 0;
        for (ReferenceEntry referenceEntry2 = this.head.getNextInWriteQueue(); referenceEntry2 != (referenceEntry = this.head); referenceEntry2 = referenceEntry2.getNextInWriteQueue()) {
            ++n10;
        }
        return n10;
    }
}

