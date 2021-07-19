/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.GeneralRange;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeMultiset$2
implements Iterator {
    public TreeMultiset$AvlNode current;
    public Multiset$Entry prevEntry;
    public final /* synthetic */ TreeMultiset this$0;

    public TreeMultiset$2(TreeMultiset object) {
        this.this$0 = object;
        this.current = object = TreeMultiset.access$1200((TreeMultiset)object);
    }

    public boolean hasNext() {
        Object object;
        Object object2 = this.current;
        if (object2 == null) {
            return false;
        }
        object2 = TreeMultiset.access$1300(this.this$0);
        boolean bl2 = ((GeneralRange)object2).tooHigh(object = this.current.getElement());
        if (bl2) {
            this.current = null;
            return false;
        }
        return true;
    }

    public Multiset$Entry next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            TreeMultiset$AvlNode treeMultiset$AvlNode;
            Object object = this.this$0;
            TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.current;
            this.prevEntry = object = TreeMultiset.access$1400((TreeMultiset)object, treeMultiset$AvlNode2);
            treeMultiset$AvlNode2 = TreeMultiset$AvlNode.access$800(this.current);
            if (treeMultiset$AvlNode2 == (treeMultiset$AvlNode = TreeMultiset.access$1500(this.this$0))) {
                treeMultiset$AvlNode2 = null;
                this.current = null;
            } else {
                this.current = treeMultiset$AvlNode2 = TreeMultiset$AvlNode.access$800(this.current);
            }
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        boolean bl2;
        Object object = this.prevEntry;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        CollectPreconditions.checkRemove(bl2);
        object = this.this$0;
        Object object2 = this.prevEntry.getElement();
        ((TreeMultiset)object).setCount(object2, 0);
        this.prevEntry = null;
    }
}

