/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$Builder;
import com.google.common.collect.MinMaxPriorityQueue$Heap;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.MinMaxPriorityQueue$QueueIterator;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class MinMaxPriorityQueue
extends AbstractQueue {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 0x55555555;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue$Heap maxHeap;
    public final int maximumSize;
    private final MinMaxPriorityQueue$Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    private MinMaxPriorityQueue(MinMaxPriorityQueue$Builder objectArray, int n10) {
        int n11;
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap;
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap2;
        Ordering ordering = MinMaxPriorityQueue$Builder.access$200((MinMaxPriorityQueue$Builder)objectArray);
        this.minHeap = minMaxPriorityQueue$Heap2 = new MinMaxPriorityQueue$Heap(this, ordering);
        ordering = ordering.reverse();
        this.maxHeap = minMaxPriorityQueue$Heap = new MinMaxPriorityQueue$Heap(this, ordering);
        minMaxPriorityQueue$Heap2.otherHeap = minMaxPriorityQueue$Heap;
        minMaxPriorityQueue$Heap.otherHeap = minMaxPriorityQueue$Heap2;
        this.maximumSize = n11 = MinMaxPriorityQueue$Builder.access$300((MinMaxPriorityQueue$Builder)objectArray);
        objectArray = new Object[n10];
        this.queue = objectArray;
    }

    public /* synthetic */ MinMaxPriorityQueue(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder, int n10, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(minMaxPriorityQueue$Builder, n10);
    }

    public static /* synthetic */ Object[] access$500(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.queue;
    }

    public static /* synthetic */ int access$600(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.size;
    }

    public static /* synthetic */ int access$700(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.modCount;
    }

    private int calculateNewCapacity() {
        Object[] objectArray = this.queue;
        int n10 = objectArray.length;
        int n11 = 64;
        if (n10 < n11) {
            n10 = (n10 + 1) * 2;
        } else {
            n10 /= 2;
            n11 = 3;
            n10 = IntMath.checkedMultiply(n10, n11);
        }
        n11 = this.maximumSize;
        return MinMaxPriorityQueue.capAtMaximumSize(n10, n11);
    }

    private static int capAtMaximumSize(int n10, int n11) {
        return Math.min(n10 + -1, n11) + 1;
    }

    public static MinMaxPriorityQueue create() {
        Ordering ordering = Ordering.natural();
        MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder = new MinMaxPriorityQueue$Builder(ordering, null);
        return minMaxPriorityQueue$Builder.create();
    }

    public static MinMaxPriorityQueue create(Iterable iterable) {
        Ordering ordering = Ordering.natural();
        MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder = new MinMaxPriorityQueue$Builder(ordering, null);
        return minMaxPriorityQueue$Builder.create(iterable);
    }

    public static MinMaxPriorityQueue$Builder expectedSize(int n10) {
        Ordering ordering = Ordering.natural();
        MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder = new MinMaxPriorityQueue$Builder(ordering, null);
        return minMaxPriorityQueue$Builder.expectedSize(n10);
    }

    private MinMaxPriorityQueue$MoveDesc fillHole(int n10, Object object) {
        int n11;
        Object object2 = this.heapForIndex(n10);
        int n12 = ((MinMaxPriorityQueue$Heap)object2).bubbleUpAlternatingLevels(n11 = ((MinMaxPriorityQueue$Heap)object2).fillHoleAt(n10), object);
        if (n12 == n11) {
            return ((MinMaxPriorityQueue$Heap)object2).tryCrossOverAndBubbleUp(n10, n11, object);
        }
        if (n12 < n10) {
            Object object3 = this.elementData(n10);
            object2 = new MinMaxPriorityQueue$MoveDesc(object, object3);
        } else {
            object2 = null;
        }
        return object2;
    }

    private int getMaxElementIndex() {
        int n10 = this.size;
        int n11 = 1;
        if (n10 != n11) {
            MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap;
            int n12 = 2;
            if (n10 != n12 && (n10 = (minMaxPriorityQueue$Heap = this.maxHeap).compareElements(n11, n12)) > 0) {
                n11 = n12;
            }
            return n11;
        }
        return 0;
    }

    private void growIfNeeded() {
        int n10 = this.size;
        Object[] objectArray = this.queue;
        int n11 = objectArray.length;
        if (n10 > n11) {
            n10 = this.calculateNewCapacity();
            Object[] objectArray2 = new Object[n10];
            objectArray = this.queue;
            int n12 = objectArray.length;
            System.arraycopy(objectArray, 0, objectArray2, 0, n12);
            this.queue = objectArray2;
        }
    }

    private MinMaxPriorityQueue$Heap heapForIndex(int n10) {
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = (n10 = (int)(MinMaxPriorityQueue.isEvenLevel(n10) ? 1 : 0)) != 0 ? this.minHeap : this.maxHeap;
        return minMaxPriorityQueue$Heap;
    }

    public static int initialQueueSize(int n10, int n11, Iterable iterable) {
        int n12 = -1;
        if (n10 == n12) {
            n10 = 11;
        }
        if ((n12 = iterable instanceof Collection) != 0) {
            iterable = (Collection)iterable;
            int n13 = iterable.size();
            n10 = Math.max(n10, n13);
        }
        return MinMaxPriorityQueue.capAtMaximumSize(n10, n11);
    }

    public static boolean isEvenLevel(int n10) {
        int n11 = 1;
        int n12 = (n10 = ~(~(n10 + n11))) > 0 ? n11 : 0;
        String string2 = "negative index";
        Preconditions.checkState(n12 != 0, string2);
        n12 = 0x55555555 & n10;
        int n13 = -1431655766;
        if (n12 <= (n10 &= n13)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static MinMaxPriorityQueue$Builder maximumSize(int n10) {
        Ordering ordering = Ordering.natural();
        MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder = new MinMaxPriorityQueue$Builder(ordering, null);
        return minMaxPriorityQueue$Builder.maximumSize(n10);
    }

    public static MinMaxPriorityQueue$Builder orderedBy(Comparator comparator) {
        MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder = new MinMaxPriorityQueue$Builder(comparator, null);
        return minMaxPriorityQueue$Builder;
    }

    private Object removeAndGet(int n10) {
        Object object = this.elementData(n10);
        this.removeAt(n10);
        return object;
    }

    public boolean add(Object object) {
        this.offer(object);
        return true;
    }

    public boolean addAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        boolean bl3 = false;
        Object var3_3 = null;
        while (bl2 = object.hasNext()) {
            var3_3 = object.next();
            this.offer((Object)var3_3);
            bl3 = true;
        }
        return bl3;
    }

    public int capacity() {
        return this.queue.length;
    }

    public void clear() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            Object[] objectArray = this.queue;
            objectArray[i10] = null;
        }
        this.size = 0;
    }

    public Comparator comparator() {
        return this.minHeap.ordering;
    }

    public Object elementData(int n10) {
        return this.queue[n10];
    }

    public boolean isIntact() {
        int n10;
        int n11;
        for (int i10 = n10 = 1; i10 < (n11 = this.size); ++i10) {
            MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = this.heapForIndex(i10);
            n11 = (int)(MinMaxPriorityQueue$Heap.access$400(minMaxPriorityQueue$Heap, i10) ? 1 : 0);
            if (n11 != 0) continue;
            return false;
        }
        return n10 != 0;
    }

    public Iterator iterator() {
        MinMaxPriorityQueue$QueueIterator minMaxPriorityQueue$QueueIterator = new MinMaxPriorityQueue$QueueIterator(this, null);
        return minMaxPriorityQueue$QueueIterator;
    }

    public boolean offer(Object object) {
        Object object2;
        int n10;
        Preconditions.checkNotNull(object);
        int n11 = this.modCount;
        int n12 = 1;
        this.modCount = n11 += n12;
        n11 = this.size;
        this.size = n10 = n11 + 1;
        this.growIfNeeded();
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = this.heapForIndex(n11);
        minMaxPriorityQueue$Heap.bubbleUp(n11, object);
        n11 = this.size;
        n10 = this.maximumSize;
        if (n11 > n10 && (object2 = this.pollLast()) == object) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public Object peek() {
        Object object;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            bl2 = false;
            object = this.elementData(0);
        }
        return object;
    }

    public Object peekFirst() {
        return this.peek();
    }

    public Object peekLast() {
        Object object;
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = this.getMaxElementIndex();
            object = this.elementData(n10);
        }
        return object;
    }

    public Object poll() {
        Object object;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            bl2 = false;
            object = this.removeAndGet(0);
        }
        return object;
    }

    public Object pollFirst() {
        return this.poll();
    }

    public Object pollLast() {
        Object object;
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = this.getMaxElementIndex();
            object = this.removeAndGet(n10);
        }
        return object;
    }

    public MinMaxPriorityQueue$MoveDesc removeAt(int n10) {
        int n11 = this.size;
        Preconditions.checkPositionIndex(n10, n11);
        this.modCount = n11 = this.modCount + 1;
        this.size = n11 = this.size + -1;
        Object object = null;
        if (n11 == n10) {
            this.queue[n11] = null;
            return null;
        }
        Object object2 = this.elementData(n11);
        int n12 = this.size;
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = this.heapForIndex(n12);
        if ((n12 = minMaxPriorityQueue$Heap.swapWithConceptuallyLastElement(object2)) == n10) {
            Object[] objectArray = this.queue;
            n11 = this.size;
            objectArray[n11] = null;
            return null;
        }
        int n13 = this.size;
        Object object3 = this.elementData(n13);
        Object[] objectArray = this.queue;
        int n14 = this.size;
        objectArray[n14] = null;
        object = this.fillHole(n10, object3);
        if (n12 < n10) {
            if (object == null) {
                MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = new MinMaxPriorityQueue$MoveDesc(object2, object3);
                return minMaxPriorityQueue$MoveDesc;
            }
            object = ((MinMaxPriorityQueue$MoveDesc)object).replaced;
            MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = new MinMaxPriorityQueue$MoveDesc(object2, object);
            return minMaxPriorityQueue$MoveDesc;
        }
        return object;
    }

    public Object removeFirst() {
        return this.remove();
    }

    public Object removeLast() {
        int n10 = this.isEmpty();
        if (n10 == 0) {
            n10 = this.getMaxElementIndex();
            return this.removeAndGet(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        int n10 = this.size;
        Object[] objectArray = new Object[n10];
        System.arraycopy(this.queue, 0, objectArray, 0, n10);
        return objectArray;
    }
}

