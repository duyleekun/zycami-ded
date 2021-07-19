/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.PriorityTaskManager$PriorityTooLowException;
import com.google.android.exoplayer2.util.Util;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority;
    private final Object lock;
    private final PriorityQueue queue;

    public PriorityTaskManager() {
        PriorityQueue priorityQueue = new PriorityQueue();
        this.lock = priorityQueue;
        Comparator comparator = Collections.reverseOrder();
        this.queue = priorityQueue = new PriorityQueue(10, comparator);
        this.highestPriority = -1 << -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(int n10) {
        Object object = this.lock;
        synchronized (object) {
            PriorityQueue priorityQueue = this.queue;
            Integer n11 = n10;
            priorityQueue.add(n11);
            int n12 = this.highestPriority;
            this.highestPriority = n10 = Math.max(n12, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void proceed(int n10) {
        Object object = this.lock;
        synchronized (object) {
            int n11;
            while ((n11 = this.highestPriority) != n10) {
                Object object2 = this.lock;
                object2.wait();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean proceedNonBlocking(int n10) {
        Object object = this.lock;
        synchronized (object) {
            int n11 = this.highestPriority;
            if (n11 != n10) return 0 != 0;
            return 1 != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void proceedOrThrow(int n10) {
        Object object = this.lock;
        synchronized (object) {
            int n11 = this.highestPriority;
            if (n11 == n10) {
                return;
            }
            int n12 = this.highestPriority;
            PriorityTaskManager$PriorityTooLowException priorityTaskManager$PriorityTooLowException = new PriorityTaskManager$PriorityTooLowException(n10, n12);
            throw priorityTaskManager$PriorityTooLowException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void remove(int n10) {
        Object object = this.lock;
        synchronized (object) {
            PriorityQueue priorityQueue = this.queue;
            Object object2 = n10;
            priorityQueue.remove(object2);
            object2 = this.queue;
            n10 = (int)(((AbstractCollection)object2).isEmpty() ? 1 : 0);
            if (n10 != 0) {
                n10 = -1 << -1;
            } else {
                object2 = this.queue;
                object2 = ((PriorityQueue)object2).peek();
                object2 = Util.castNonNull(object2);
                object2 = (Integer)object2;
                n10 = (Integer)object2;
            }
            this.highestPriority = n10;
            object2 = this.lock;
            object2.notifyAll();
            return;
        }
    }
}

