/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingQueue;
import java.util.Deque;
import java.util.Iterator;

public abstract class ForwardingDeque
extends ForwardingQueue
implements Deque {
    public void addFirst(Object object) {
        this.delegate().addFirst(object);
    }

    public void addLast(Object object) {
        this.delegate().addLast(object);
    }

    public abstract Deque delegate();

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    public Object getFirst() {
        return this.delegate().getFirst();
    }

    public Object getLast() {
        return this.delegate().getLast();
    }

    public boolean offerFirst(Object object) {
        return this.delegate().offerFirst(object);
    }

    public boolean offerLast(Object object) {
        return this.delegate().offerLast(object);
    }

    public Object peekFirst() {
        return this.delegate().peekFirst();
    }

    public Object peekLast() {
        return this.delegate().peekLast();
    }

    public Object pollFirst() {
        return this.delegate().pollFirst();
    }

    public Object pollLast() {
        return this.delegate().pollLast();
    }

    public Object pop() {
        return this.delegate().pop();
    }

    public void push(Object object) {
        this.delegate().push(object);
    }

    public Object removeFirst() {
        return this.delegate().removeFirst();
    }

    public boolean removeFirstOccurrence(Object object) {
        return this.delegate().removeFirstOccurrence(object);
    }

    public Object removeLast() {
        return this.delegate().removeLast();
    }

    public boolean removeLastOccurrence(Object object) {
        return this.delegate().removeLastOccurrence(object);
    }
}

