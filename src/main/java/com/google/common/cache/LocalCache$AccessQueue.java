/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue$1;
import com.google.common.cache.LocalCache$AccessQueue$2;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

public final class LocalCache$AccessQueue
extends AbstractQueue {
    public final ReferenceEntry head;

    public LocalCache$AccessQueue() {
        LocalCache$AccessQueue$1 localCache$AccessQueue$1 = new LocalCache$AccessQueue$1(this);
        this.head = localCache$AccessQueue$1;
    }

    public void clear() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInAccessQueue();
        while (referenceEntry2 != (referenceEntry = this.head)) {
            referenceEntry = referenceEntry2.getNextInAccessQueue();
            LocalCache.nullifyAccessOrder(referenceEntry2);
            referenceEntry2 = referenceEntry;
        }
        referenceEntry.setNextInAccessQueue(referenceEntry);
        referenceEntry2 = this.head;
        referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
    }

    public boolean contains(Object object) {
        boolean bl2;
        LocalCache$NullEntry localCache$NullEntry;
        if ((object = ((ReferenceEntry)object).getNextInAccessQueue()) != (localCache$NullEntry = LocalCache$NullEntry.INSTANCE)) {
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
        ReferenceEntry referenceEntry2 = this.head.getNextInAccessQueue();
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
        LocalCache$AccessQueue$2 localCache$AccessQueue$2 = new LocalCache$AccessQueue$2(this, referenceEntry);
        return localCache$AccessQueue$2;
    }

    public boolean offer(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntry2 = referenceEntry.getPreviousInAccessQueue();
        ReferenceEntry referenceEntry3 = referenceEntry.getNextInAccessQueue();
        LocalCache.connectAccessOrder(referenceEntry2, referenceEntry3);
        LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), referenceEntry);
        referenceEntry2 = this.head;
        LocalCache.connectAccessOrder(referenceEntry, referenceEntry2);
        return true;
    }

    public ReferenceEntry peek() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInAccessQueue();
        if (referenceEntry2 == (referenceEntry = this.head)) {
            referenceEntry2 = null;
        }
        return referenceEntry2;
    }

    public ReferenceEntry poll() {
        ReferenceEntry referenceEntry;
        ReferenceEntry referenceEntry2 = this.head.getNextInAccessQueue();
        if (referenceEntry2 == (referenceEntry = this.head)) {
            return null;
        }
        this.remove(referenceEntry2);
        return referenceEntry2;
    }

    public boolean remove(Object object) {
        boolean bl2;
        object = (ReferenceEntry)object;
        ReferenceEntry referenceEntry = object.getPreviousInAccessQueue();
        ReferenceEntry referenceEntry2 = object.getNextInAccessQueue();
        LocalCache.connectAccessOrder(referenceEntry, referenceEntry2);
        LocalCache.nullifyAccessOrder((ReferenceEntry)object);
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
        for (ReferenceEntry referenceEntry2 = this.head.getNextInAccessQueue(); referenceEntry2 != (referenceEntry = this.head); referenceEntry2 = referenceEntry2.getNextInAccessQueue()) {
            ++n10;
        }
        return n10;
    }
}

