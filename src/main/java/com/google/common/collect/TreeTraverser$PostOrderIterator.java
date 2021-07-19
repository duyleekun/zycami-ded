/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.TreeTraverser$PostOrderNode;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class TreeTraverser$PostOrderIterator
extends AbstractIterator {
    private final ArrayDeque stack;
    public final /* synthetic */ TreeTraverser this$0;

    public TreeTraverser$PostOrderIterator(TreeTraverser arrayDeque, Object object) {
        this.this$0 = arrayDeque;
        this.stack = arrayDeque = new ArrayDeque<Object>();
        object = this.expand(object);
        arrayDeque.addLast(object);
    }

    private TreeTraverser$PostOrderNode expand(Object object) {
        Iterator iterator2 = this.this$0.children(object).iterator();
        TreeTraverser$PostOrderNode treeTraverser$PostOrderNode = new TreeTraverser$PostOrderNode(object, iterator2);
        return treeTraverser$PostOrderNode;
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (!(bl2 = ((ArrayDeque)(object = this.stack)).isEmpty())) {
            object = (TreeTraverser$PostOrderNode)this.stack.getLast();
            Object object2 = ((TreeTraverser$PostOrderNode)object).childIterator;
            boolean bl3 = object2.hasNext();
            if (bl3) {
                object = ((TreeTraverser$PostOrderNode)object).childIterator.next();
                object2 = this.stack;
                object = this.expand(object);
                ((ArrayDeque)object2).addLast(object);
                continue;
            }
            this.stack.removeLast();
            return ((TreeTraverser$PostOrderNode)object).root;
        }
        return this.endOfData();
    }
}

