/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.Ordering;

public class MinMaxPriorityQueue$Heap {
    public final Ordering ordering;
    public MinMaxPriorityQueue$Heap otherHeap;
    public final /* synthetic */ MinMaxPriorityQueue this$0;

    public MinMaxPriorityQueue$Heap(MinMaxPriorityQueue minMaxPriorityQueue, Ordering ordering) {
        this.this$0 = minMaxPriorityQueue;
        this.ordering = ordering;
    }

    public static /* synthetic */ boolean access$400(MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap, int n10) {
        return minMaxPriorityQueue$Heap.verifyIndex(n10);
    }

    private int getGrandparentIndex(int n10) {
        n10 = this.getParentIndex(n10);
        return this.getParentIndex(n10);
    }

    private int getLeftChildIndex(int n10) {
        return n10 * 2 + 1;
    }

    private int getParentIndex(int n10) {
        return (n10 + -1) / 2;
    }

    private int getRightChildIndex(int n10) {
        return n10 * 2 + 2;
    }

    private boolean verifyIndex(int n10) {
        MinMaxPriorityQueue minMaxPriorityQueue;
        int n11;
        int n12 = this.getLeftChildIndex(n10);
        if (n12 < (n11 = MinMaxPriorityQueue.access$600(minMaxPriorityQueue = this.this$0))) {
            n12 = this.getLeftChildIndex(n10);
            if ((n12 = this.compareElements(n10, n12)) > 0) {
                return false;
            }
        }
        if ((n12 = this.getRightChildIndex(n10)) < (n11 = MinMaxPriorityQueue.access$600(minMaxPriorityQueue = this.this$0))) {
            n12 = this.getRightChildIndex(n10);
            if ((n12 = this.compareElements(n10, n12)) > 0) {
                return false;
            }
        }
        if (n10 > 0) {
            n12 = this.getParentIndex(n10);
            if ((n12 = this.compareElements(n10, n12)) > 0) {
                return false;
            }
        }
        return n10 <= (n12 = 2) || (n10 = this.compareElements(n12 = this.getGrandparentIndex(n10), n10)) <= 0;
    }

    public void bubbleUp(int n10, Object object) {
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap;
        int n11 = this.crossOverUp(n10, object);
        if (n11 == n10) {
            n11 = n10;
            minMaxPriorityQueue$Heap = this;
        } else {
            minMaxPriorityQueue$Heap = this.otherHeap;
        }
        minMaxPriorityQueue$Heap.bubbleUpAlternatingLevels(n11, object);
    }

    public int bubbleUpAlternatingLevels(int n10, Object object) {
        Object object2;
        Object[] objectArray;
        int n11;
        int n12;
        while (n10 > (n12 = 2) && (n11 = (objectArray = this.ordering).compare(object2 = this.this$0.elementData(n12 = this.getGrandparentIndex(n10)), object)) > 0) {
            objectArray = MinMaxPriorityQueue.access$500(this.this$0);
            objectArray[n10] = object2;
            n10 = n12;
        }
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n10] = object;
        return n10;
    }

    public int compareElements(int n10, int n11) {
        Ordering ordering = this.ordering;
        Object object = this.this$0.elementData(n10);
        Object object2 = this.this$0.elementData(n11);
        return ordering.compare(object, object2);
    }

    public int crossOver(int n10, Object object) {
        Object object2;
        Object[] objectArray;
        int n11;
        int n12 = this.findMinChild(n10);
        if (n12 > 0 && (n11 = (objectArray = this.ordering).compare(object2 = this.this$0.elementData(n12), object)) < 0) {
            objectArray = MinMaxPriorityQueue.access$500(this.this$0);
            objectArray[n10] = object2 = this.this$0.elementData(n12);
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n12] = object;
            return n12;
        }
        return this.crossOverUp(n10, object);
    }

    public int crossOverUp(int n10, Object object) {
        Ordering ordering;
        int n11;
        if (n10 == 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[0] = object;
            return 0;
        }
        int n12 = this.getParentIndex(n10);
        Object object2 = this.this$0.elementData(n12);
        if (n12 != 0) {
            Object object3;
            Object object4;
            int n13;
            int n14;
            n11 = this.getParentIndex(n12);
            if ((n11 = this.getRightChildIndex(n11)) != n12 && (n14 = this.getLeftChildIndex(n11)) >= (n13 = MinMaxPriorityQueue.access$600((MinMaxPriorityQueue)(object4 = this.this$0))) && (n13 = ((Ordering)(object4 = this.ordering)).compare(object3 = this.this$0.elementData(n11), object2)) < 0) {
                n12 = n11;
                object2 = object3;
            }
        }
        if ((n11 = (ordering = this.ordering).compare(object2, object)) < 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n10] = object2;
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n12] = object;
            return n12;
        }
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n10] = object;
        return n10;
    }

    public int fillHoleAt(int n10) {
        int n11;
        while ((n11 = this.findMinGrandChild(n10)) > 0) {
            Object object;
            Object[] objectArray = MinMaxPriorityQueue.access$500(this.this$0);
            objectArray[n10] = object = this.this$0.elementData(n11);
            n10 = n11;
        }
        return n10;
    }

    public int findMin(int n10, int n11) {
        MinMaxPriorityQueue minMaxPriorityQueue = this.this$0;
        int n12 = MinMaxPriorityQueue.access$600(minMaxPriorityQueue);
        if (n10 >= n12) {
            return -1;
        }
        if (n10 > 0) {
            n12 = 1;
        } else {
            n12 = 0;
            minMaxPriorityQueue = null;
        }
        Preconditions.checkState(n12 != 0);
        minMaxPriorityQueue = this.this$0;
        n12 = MinMaxPriorityQueue.access$600(minMaxPriorityQueue) - n11;
        n12 = Math.min(n10, n12) + n11;
        for (n11 = n10 + 1; n11 < n12; ++n11) {
            int n13 = this.compareElements(n11, n10);
            if (n13 >= 0) continue;
            n10 = n11;
        }
        return n10;
    }

    public int findMinChild(int n10) {
        n10 = this.getLeftChildIndex(n10);
        return this.findMin(n10, 2);
    }

    public int findMinGrandChild(int n10) {
        if ((n10 = this.getLeftChildIndex(n10)) < 0) {
            return -1;
        }
        n10 = this.getLeftChildIndex(n10);
        return this.findMin(n10, 4);
    }

    public int swapWithConceptuallyLastElement(Object objectArray) {
        Object object = this.this$0;
        int n10 = MinMaxPriorityQueue.access$600((MinMaxPriorityQueue)object);
        if ((n10 = this.getParentIndex(n10)) != 0) {
            Object object2;
            int n11;
            int n12 = this.getParentIndex(n10);
            if ((n12 = this.getRightChildIndex(n12)) != n10 && (n10 = this.getLeftChildIndex(n12)) >= (n11 = MinMaxPriorityQueue.access$600((MinMaxPriorityQueue)(object2 = this.this$0))) && (n11 = ((Ordering)(object2 = this.ordering)).compare(object = this.this$0.elementData(n12), objectArray)) < 0) {
                MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n12] = objectArray;
                objectArray = MinMaxPriorityQueue.access$500(this.this$0);
                n11 = MinMaxPriorityQueue.access$600(this.this$0);
                objectArray[n11] = object;
                return n12;
            }
        }
        return MinMaxPriorityQueue.access$600(this.this$0);
    }

    public MinMaxPriorityQueue$MoveDesc tryCrossOverAndBubbleUp(int n10, int n11, Object object) {
        Object object2;
        int n12 = this.crossOver(n11, object);
        if (n12 == n11) {
            return null;
        }
        if (n12 < n10) {
            object2 = this.this$0.elementData(n10);
        } else {
            object2 = this.this$0;
            int n13 = this.getParentIndex(n10);
            object2 = ((MinMaxPriorityQueue)object2).elementData(n13);
        }
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = this.otherHeap;
        n12 = minMaxPriorityQueue$Heap.bubbleUpAlternatingLevels(n12, object);
        if (n12 < n10) {
            MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = new MinMaxPriorityQueue$MoveDesc(object, object2);
            return minMaxPriorityQueue$MoveDesc;
        }
        return null;
    }
}

