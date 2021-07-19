/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.Logger;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LimitQueue
extends ConcurrentLinkedQueue {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int n10) {
        this.deduplication = false;
        this.limit = n10;
    }

    public LimitQueue(int n10, boolean bl2) {
        this.deduplication = false;
        this.limit = n10;
        this.deduplication = bl2;
    }

    public LimitQueue(Collection collection, boolean bl2) {
        int n10 = collection.size();
        this(n10, bl2);
        this.addAll(collection);
    }

    public boolean add(Object object) {
        int n10;
        int n11 = this.deduplication;
        if (n11 != 0) {
            super.remove(object);
        }
        if ((n11 = super.size()) >= (n10 = this.limit)) {
            super.poll();
        }
        return super.add(object);
    }

    public boolean addAll(Collection collection) {
        int n10;
        int n11 = collection.size();
        if (n11 > (n10 = this.limit)) {
            return false;
        }
        n11 = (int)(this.deduplication ? 1 : 0);
        if (n11 != 0) {
            super.removeAll(collection);
        }
        n11 = collection.size();
        n10 = super.size();
        n11 += n10;
        n10 = this.limit;
        n11 -= n10;
        while (n11 > 0) {
            super.poll();
            n11 += -1;
        }
        return super.addAll(collection);
    }

    public void clear() {
        super.clear();
    }

    public Object get(int n10) {
        boolean bl2;
        Iterator iterator2 = this.iterator();
        Object var3_3 = null;
        for (int i10 = 0; i10 <= n10 && (bl2 = iterator2.hasNext()); ++i10) {
            var3_3 = iterator2.next();
        }
        return var3_3;
    }

    public int getLimit() {
        return this.limit;
    }

    public boolean offer(Object object) {
        int n10;
        int n11 = this.deduplication;
        if (n11 != 0) {
            super.remove(object);
        }
        if ((n11 = super.size()) >= (n10 = this.limit)) {
            super.poll();
        }
        return super.offer(object);
    }

    public Object peekLast() {
        boolean bl2;
        Iterator iterator2 = this.iterator();
        Object var2_2 = null;
        while (bl2 = iterator2.hasNext()) {
            var2_2 = iterator2.next();
        }
        return var2_2;
    }

    public Object poll() {
        return super.poll();
    }

    public Object remove() {
        try {
            return super.remove();
        }
        catch (NoSuchElementException noSuchElementException) {
            Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }
}

