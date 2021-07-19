/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class TreeTraverser$PreOrderIterator
extends UnmodifiableIterator {
    private final Deque stack;
    public final /* synthetic */ TreeTraverser this$0;

    public TreeTraverser$PreOrderIterator(TreeTraverser arrayDeque, Object object) {
        this.this$0 = arrayDeque;
        this.stack = arrayDeque = new ArrayDeque<Object>();
        object = Iterators.singletonIterator(Preconditions.checkNotNull(object));
        arrayDeque.addLast(object);
    }

    public boolean hasNext() {
        return this.stack.isEmpty() ^ true;
    }

    public Object next() {
        boolean bl2;
        Iterator iterator2 = (Iterator)this.stack.getLast();
        Object object = Preconditions.checkNotNull(iterator2.next());
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            iterator2 = this.stack;
            iterator2.removeLast();
        }
        if (bl2 = (iterator2 = this.this$0.children(object).iterator()).hasNext()) {
            Deque deque = this.stack;
            deque.addLast(iterator2);
        }
        return object;
    }
}

