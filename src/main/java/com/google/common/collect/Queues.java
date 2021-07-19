/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Synchronized;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public final class Queues {
    private Queues() {
    }

    public static int drain(BlockingQueue blockingQueue, Collection collection, int n10, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        long l11 = System.nanoTime();
        l10 = timeUnit.toNanos(l10);
        l11 += l10;
        int n11 = 0;
        while (n11 < n10) {
            int n12 = n10 - n11;
            if ((n11 += (n12 = blockingQueue.drainTo(collection, n12))) >= n10) continue;
            long l12 = System.nanoTime();
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            Object e10 = blockingQueue.poll(l12 = l11 - l12, timeUnit2);
            if (e10 == null) break;
            collection.add(e10);
            ++n11;
        }
        return n11;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int drainUninterruptibly(BlockingQueue object, Collection object2, int n10, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object2);
        long l11 = System.nanoTime();
        l10 = timeUnit.toNanos(l10);
        l11 += l10;
        int n11 = 0;
        boolean bl2 = false;
        while (n11 < n10) {
            long l12;
            int n12 = n10 - n11;
            try {
                if ((n11 += (n12 = object.drainTo(object2, n12))) >= n10) continue;
                while (true) {
                    try {
                        l12 = System.nanoTime();
                        l12 = l11 - l12;
                    }
                    catch (InterruptedException interruptedException) {
                        bl2 = true;
                        continue;
                    }
                    break;
                }
            }
            catch (Throwable throwable) {
                if (bl2) {
                    object2 = Thread.currentThread();
                    ((Thread)object2).interrupt();
                }
                throw throwable;
            }
            {
                timeUnit = TimeUnit.NANOSECONDS;
                timeUnit = object.poll(l12, timeUnit);
                if (timeUnit == null) break;
                object2.add(timeUnit);
            }
            ++n11;
        }
        if (bl2) {
            object = Thread.currentThread();
            ((Thread)object).interrupt();
        }
        return n11;
    }

    public static ArrayBlockingQueue newArrayBlockingQueue(int n10) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(n10);
        return arrayBlockingQueue;
    }

    public static ArrayDeque newArrayDeque() {
        ArrayDeque arrayDeque = new ArrayDeque();
        return arrayDeque;
    }

    public static ArrayDeque newArrayDeque(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            ArrayDeque arrayDeque = new ArrayDeque(iterable);
            return arrayDeque;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }

    public static ConcurrentLinkedQueue newConcurrentLinkedQueue() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        return concurrentLinkedQueue;
    }

    public static ConcurrentLinkedQueue newConcurrentLinkedQueue(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(iterable);
            return concurrentLinkedQueue;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        return linkedBlockingDeque;
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque(int n10) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(n10);
        return linkedBlockingDeque;
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(iterable);
            return linkedBlockingDeque;
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        return linkedBlockingQueue;
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue(int n10) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(n10);
        return linkedBlockingQueue;
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(iterable);
            return linkedBlockingQueue;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    public static PriorityBlockingQueue newPriorityBlockingQueue() {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        return priorityBlockingQueue;
    }

    public static PriorityBlockingQueue newPriorityBlockingQueue(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(iterable);
            return priorityBlockingQueue;
        }
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static PriorityQueue newPriorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue();
        return priorityQueue;
    }

    public static PriorityQueue newPriorityQueue(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            PriorityQueue priorityQueue = new PriorityQueue(iterable);
            return priorityQueue;
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }

    public static SynchronousQueue newSynchronousQueue() {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        return synchronousQueue;
    }

    public static Deque synchronizedDeque(Deque deque) {
        return Synchronized.deque(deque, null);
    }

    public static Queue synchronizedQueue(Queue queue) {
        return Synchronized.queue(queue, null);
    }
}

