/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public final class MinMaxPriorityQueue$Builder {
    private static final int UNSET_EXPECTED_SIZE = 255;
    private final Comparator comparator;
    private int expectedSize = -1;
    private int maximumSize = -1 >>> 1;

    private MinMaxPriorityQueue$Builder(Comparator comparator) {
        this.comparator = comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    public /* synthetic */ MinMaxPriorityQueue$Builder(Comparator comparator, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(comparator);
    }

    public static /* synthetic */ Ordering access$200(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder) {
        return minMaxPriorityQueue$Builder.ordering();
    }

    public static /* synthetic */ int access$300(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder) {
        return minMaxPriorityQueue$Builder.maximumSize;
    }

    private Ordering ordering() {
        return Ordering.from(this.comparator);
    }

    public MinMaxPriorityQueue create() {
        Set set = Collections.emptySet();
        return this.create(set);
    }

    public MinMaxPriorityQueue create(Iterable object) {
        int n10 = this.expectedSize;
        int n11 = this.maximumSize;
        n10 = MinMaxPriorityQueue.initialQueueSize(n10, n11, (Iterable)object);
        n11 = 0;
        MinMaxPriorityQueue minMaxPriorityQueue = new MinMaxPriorityQueue(this, n10, null);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object.next();
            minMaxPriorityQueue.offer(e10);
        }
        return minMaxPriorityQueue;
    }

    public MinMaxPriorityQueue$Builder expectedSize(int n10) {
        boolean bl2 = n10 >= 0;
        Preconditions.checkArgument(bl2);
        this.expectedSize = n10;
        return this;
    }

    public MinMaxPriorityQueue$Builder maximumSize(int n10) {
        boolean bl2 = n10 > 0;
        Preconditions.checkArgument(bl2);
        this.maximumSize = n10;
        return this;
    }
}

