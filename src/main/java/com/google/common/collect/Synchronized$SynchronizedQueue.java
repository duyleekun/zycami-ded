/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Queue;

public class Synchronized$SynchronizedQueue
extends Synchronized$SynchronizedCollection
implements Queue {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedQueue(Queue queue, Object object) {
        super(queue, object, null);
    }

    public Queue delegate() {
        return (Queue)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object element() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.element();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean offer(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.offer(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object peek() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.peek();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object poll() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.poll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.remove();
        }
    }
}

