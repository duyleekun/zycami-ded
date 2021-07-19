/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MinMaxPriorityQueue$QueueIterator
implements Iterator {
    private boolean canRemove;
    private int cursor;
    private int expectedModCount;
    private Queue forgetMeNot;
    private Object lastFromForgetMeNot;
    private int nextCursor;
    private List skipMe;
    public final /* synthetic */ MinMaxPriorityQueue this$0;

    private MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue) {
        int n10;
        int n11;
        this.this$0 = minMaxPriorityQueue;
        this.cursor = n11 = -1;
        this.nextCursor = n11;
        this.expectedModCount = n10 = MinMaxPriorityQueue.access$700(minMaxPriorityQueue);
    }

    public /* synthetic */ MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(minMaxPriorityQueue);
    }

    private void checkModCount() {
        int n10;
        Object object = this.this$0;
        int n11 = MinMaxPriorityQueue.access$700((MinMaxPriorityQueue)object);
        if (n11 == (n10 = this.expectedModCount)) {
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    private boolean foundAndRemovedExactReference(Iterable object, Object object2) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (e10 != object2) continue;
            object.remove();
            return true;
        }
        return false;
    }

    private void nextNotInSkipMe(int n10) {
        int n11 = this.nextCursor;
        if (n11 < n10) {
            Collection collection = this.skipMe;
            if (collection != null) {
                Object object;
                while (n10 < (n11 = ((MinMaxPriorityQueue)(collection = this.this$0)).size()) && (n11 = (int)(this.foundAndRemovedExactReference(collection = this.skipMe, object = this.this$0.elementData(n10)) ? 1 : 0)) != 0) {
                    ++n10;
                }
            }
            this.nextCursor = n10;
        }
    }

    private boolean removeExact(Object object) {
        Object object2;
        int n10;
        for (int i10 = 0; i10 < (n10 = MinMaxPriorityQueue.access$600((MinMaxPriorityQueue)(object2 = this.this$0))); ++i10) {
            object2 = MinMaxPriorityQueue.access$500(this.this$0)[i10];
            if (object2 != object) continue;
            this.this$0.removeAt(i10);
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        Queue queue;
        this.checkModCount();
        int n10 = this.cursor;
        int n11 = 1;
        this.nextNotInSkipMe(n10 += n11);
        n10 = this.nextCursor;
        MinMaxPriorityQueue minMaxPriorityQueue = this.this$0;
        int n12 = minMaxPriorityQueue.size();
        if (n10 >= n12 && ((queue = this.forgetMeNot) == null || (n10 = (int)(queue.isEmpty() ? 1 : 0)) != 0)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public Object next() {
        this.checkModCount();
        int n10 = this.cursor;
        int n11 = 1;
        this.nextNotInSkipMe(n10 += n11);
        n10 = this.nextCursor;
        MinMaxPriorityQueue minMaxPriorityQueue = this.this$0;
        int n12 = minMaxPriorityQueue.size();
        if (n10 < n12) {
            this.cursor = n10 = this.nextCursor;
            this.canRemove = n11;
            return this.this$0.elementData(n10);
        }
        Object object = this.forgetMeNot;
        if (object != null) {
            this.cursor = n10 = this.this$0.size();
            this.lastFromForgetMeNot = object = this.forgetMeNot.poll();
            if (object != null) {
                this.canRemove = n11;
                return object;
            }
        }
        object = new NoSuchElementException("iterator moved past last element in queue.");
        throw object;
    }

    public void remove() {
        int n10;
        CollectPreconditions.checkRemove(this.canRemove);
        this.checkModCount();
        Object object = null;
        this.canRemove = false;
        this.expectedModCount = n10 = this.expectedModCount + 1;
        n10 = this.cursor;
        Collection<Object> collection = this.this$0;
        int n11 = ((MinMaxPriorityQueue)collection).size();
        if (n10 < n11) {
            object = this.this$0;
            n11 = this.cursor;
            if ((object = ((MinMaxPriorityQueue)object).removeAt(n11)) != null) {
                Object object2;
                collection = this.forgetMeNot;
                if (collection == null) {
                    collection = new Collection<Object>();
                    this.forgetMeNot = collection;
                    int n12 = 3;
                    collection = new Collection<Object>(n12);
                    this.skipMe = collection;
                }
                if ((n11 = (int)(this.foundAndRemovedExactReference(collection = this.skipMe, object2 = ((MinMaxPriorityQueue$MoveDesc)object).toTrickle) ? 1 : 0)) == 0) {
                    collection = this.forgetMeNot;
                    object2 = ((MinMaxPriorityQueue$MoveDesc)object).toTrickle;
                    collection.add(object2);
                }
                if ((n11 = (int)(this.foundAndRemovedExactReference(collection = this.forgetMeNot, object2 = ((MinMaxPriorityQueue$MoveDesc)object).replaced) ? 1 : 0)) == 0) {
                    collection = this.skipMe;
                    object = ((MinMaxPriorityQueue$MoveDesc)object).replaced;
                    collection.add(object);
                }
            }
            this.cursor = n10 = this.cursor + -1;
            this.nextCursor = n10 = this.nextCursor + -1;
        } else {
            object = this.lastFromForgetMeNot;
            Preconditions.checkState(this.removeExact(object));
            n10 = 0;
            object = null;
            this.lastFromForgetMeNot = null;
        }
    }
}

