/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;

public class TreeTraverser$3
extends FluentIterable {
    public final /* synthetic */ TreeTraverser this$0;
    public final /* synthetic */ Object val$root;

    public TreeTraverser$3(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.val$root = object;
    }

    public UnmodifiableIterator iterator() {
        TreeTraverser treeTraverser = this.this$0;
        Object object = this.val$root;
        return treeTraverser.postOrderIterator(object);
    }
}

