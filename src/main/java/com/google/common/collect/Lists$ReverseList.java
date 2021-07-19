/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Lists$ReverseList$1;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lists$ReverseList
extends AbstractList {
    private final List forwardList;

    public Lists$ReverseList(List list) {
        this.forwardList = list = (List)Preconditions.checkNotNull(list);
    }

    public static /* synthetic */ int access$000(Lists$ReverseList lists$ReverseList, int n10) {
        return lists$ReverseList.reversePosition(n10);
    }

    private int reverseIndex(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        return n11 + -1 - n10;
    }

    private int reversePosition(int n10) {
        int n11 = this.size();
        Preconditions.checkPositionIndex(n10, n11);
        return n11 - n10;
    }

    public void add(int n10, Object object) {
        List list = this.forwardList;
        n10 = this.reversePosition(n10);
        list.add(n10, object);
    }

    public void clear() {
        this.forwardList.clear();
    }

    public Object get(int n10) {
        List list = this.forwardList;
        n10 = this.reverseIndex(n10);
        return list.get(n10);
    }

    public List getForwardList() {
        return this.forwardList;
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    public ListIterator listIterator(int n10) {
        n10 = this.reversePosition(n10);
        ListIterator listIterator = this.forwardList.listIterator(n10);
        Lists$ReverseList$1 lists$ReverseList$1 = new Lists$ReverseList$1(this, listIterator);
        return lists$ReverseList$1;
    }

    public Object remove(int n10) {
        List list = this.forwardList;
        n10 = this.reverseIndex(n10);
        return list.remove(n10);
    }

    public void removeRange(int n10, int n11) {
        this.subList(n10, n11).clear();
    }

    public Object set(int n10, Object object) {
        List list = this.forwardList;
        n10 = this.reverseIndex(n10);
        return list.set(n10, object);
    }

    public int size() {
        return this.forwardList.size();
    }

    public List subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        List list = this.forwardList;
        n11 = this.reversePosition(n11);
        n10 = this.reversePosition(n10);
        return Lists.reverse(list.subList(n11, n10));
    }
}

