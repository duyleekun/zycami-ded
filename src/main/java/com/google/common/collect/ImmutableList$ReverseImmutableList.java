/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class ImmutableList$ReverseImmutableList
extends ImmutableList {
    private final transient ImmutableList forwardList;

    public ImmutableList$ReverseImmutableList(ImmutableList immutableList) {
        this.forwardList = immutableList;
    }

    private int reverseIndex(int n10) {
        return this.size() + -1 - n10;
    }

    private int reversePosition(int n10) {
        return this.size() - n10;
    }

    public boolean contains(Object object) {
        return this.forwardList.contains(object);
    }

    public Object get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        ImmutableList immutableList = this.forwardList;
        n10 = this.reverseIndex(n10);
        return immutableList.get(n10);
    }

    public int indexOf(Object object) {
        ImmutableList immutableList = this.forwardList;
        int n10 = immutableList.lastIndexOf(object);
        n10 = n10 >= 0 ? this.reverseIndex(n10) : -1;
        return n10;
    }

    public boolean isPartialView() {
        return this.forwardList.isPartialView();
    }

    public int lastIndexOf(Object object) {
        ImmutableList immutableList = this.forwardList;
        int n10 = immutableList.indexOf(object);
        n10 = n10 >= 0 ? this.reverseIndex(n10) : -1;
        return n10;
    }

    public ImmutableList reverse() {
        return this.forwardList;
    }

    public int size() {
        return this.forwardList.size();
    }

    public ImmutableList subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        ImmutableList immutableList = this.forwardList;
        n11 = this.reversePosition(n11);
        n10 = this.reversePosition(n10);
        return immutableList.subList(n11, n10).reverse();
    }
}

