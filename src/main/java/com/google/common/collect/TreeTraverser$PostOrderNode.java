/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

public final class TreeTraverser$PostOrderNode {
    public final Iterator childIterator;
    public final Object root;

    public TreeTraverser$PostOrderNode(Object object, Iterator iterator2) {
        this.root = object = Preconditions.checkNotNull(object);
        this.childIterator = object = (Iterator)Preconditions.checkNotNull(iterator2);
    }
}

