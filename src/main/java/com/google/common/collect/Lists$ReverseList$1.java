/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Lists$ReverseList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Lists$ReverseList$1
implements ListIterator {
    public boolean canRemoveOrSet;
    public final /* synthetic */ Lists$ReverseList this$0;
    public final /* synthetic */ ListIterator val$forwardIterator;

    public Lists$ReverseList$1(Lists$ReverseList reverseList, ListIterator listIterator) {
        this.this$0 = reverseList;
        this.val$forwardIterator = listIterator;
    }

    public void add(Object object) {
        this.val$forwardIterator.add(object);
        this.val$forwardIterator.previous();
        this.canRemoveOrSet = false;
    }

    public boolean hasNext() {
        return this.val$forwardIterator.hasPrevious();
    }

    public boolean hasPrevious() {
        return this.val$forwardIterator.hasNext();
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            this.canRemoveOrSet = true;
            return this.val$forwardIterator.previous();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int nextIndex() {
        Lists$ReverseList lists$ReverseList = this.this$0;
        int n10 = this.val$forwardIterator.nextIndex();
        return Lists$ReverseList.access$000(lists$ReverseList, n10);
    }

    public Object previous() {
        boolean bl2 = this.hasPrevious();
        if (bl2) {
            this.canRemoveOrSet = true;
            return this.val$forwardIterator.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int previousIndex() {
        return this.nextIndex() + -1;
    }

    public void remove() {
        CollectPreconditions.checkRemove(this.canRemoveOrSet);
        this.val$forwardIterator.remove();
        this.canRemoveOrSet = false;
    }

    public void set(Object object) {
        Preconditions.checkState(this.canRemoveOrSet);
        this.val$forwardIterator.set(object);
    }
}

