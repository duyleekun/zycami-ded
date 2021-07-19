/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedQueue;
import java.util.Deque;
import java.util.Iterator;

public final class Synchronized$SynchronizedDeque
extends Synchronized$SynchronizedQueue
implements Deque {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedDeque(Deque deque, Object object) {
        super(deque, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addFirst(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object3.addFirst(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addLast(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object3.addLast(object);
            return;
        }
    }

    public Deque delegate() {
        return (Deque)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Iterator descendingIterator() {
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator2 = this.delegate();
            return iterator2.descendingIterator();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getFirst() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.getFirst();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getLast() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.getLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean offerFirst(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.offerFirst(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean offerLast(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.offerLast(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object peekFirst() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.peekFirst();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object peekLast() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.peekLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object pollFirst() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.pollFirst();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object pollLast() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.pollLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object pop() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.pop();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void push(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object3.push(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object removeFirst() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.removeFirst();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean removeFirstOccurrence(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.removeFirstOccurrence(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object removeLast() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.removeLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean removeLastOccurrence(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.removeLastOccurrence(object);
        }
    }
}

