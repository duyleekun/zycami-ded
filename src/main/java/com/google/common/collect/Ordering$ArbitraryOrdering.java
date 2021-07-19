/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;
import com.google.common.collect.Platform;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Ordering$ArbitraryOrdering
extends Ordering {
    private final AtomicInteger counter;
    private final ConcurrentMap uids;

    public Ordering$ArbitraryOrdering() {
        Object object = new AtomicInteger(0);
        this.counter = object;
        object = new MapMaker();
        this.uids = object = Platform.tryWeakKeys((MapMaker)object).makeMap();
    }

    private Integer getUid(Object object) {
        int n10;
        ConcurrentMap concurrentMap;
        Object object2 = (Integer)this.uids.get(object);
        if (object2 == null && (object = (concurrentMap = this.uids).putIfAbsent(object, object2 = Integer.valueOf(n10 = this.counter.getAndIncrement()))) != null) {
            object2 = object;
        }
        return object2;
    }

    public int compare(Object object, Object object2) {
        int n10;
        if (object == object2) {
            return 0;
        }
        int n11 = -1;
        if (object == null) {
            return n11;
        }
        int n12 = 1;
        if (object2 == null) {
            return n12;
        }
        int n13 = this.identityHashCode(object);
        if (n13 != (n10 = this.identityHashCode(object2))) {
            if (n13 >= n10) {
                n11 = n12;
            }
            return n11;
        }
        int n14 = ((Integer)(object = this.getUid(object))).compareTo((Integer)(object2 = this.getUid(object2)));
        if (n14 != 0) {
            return n14;
        }
        object = new AssertionError();
        throw object;
    }

    public int identityHashCode(Object object) {
        return System.identityHashCode(object);
    }

    public String toString() {
        return "Ordering.arbitrary()";
    }
}

