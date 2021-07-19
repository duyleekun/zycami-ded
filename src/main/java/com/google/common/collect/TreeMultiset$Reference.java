/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import java.util.ConcurrentModificationException;

public final class TreeMultiset$Reference {
    private Object value;

    private TreeMultiset$Reference() {
    }

    public /* synthetic */ TreeMultiset$Reference(TreeMultiset$1 treeMultiset$1) {
        this();
    }

    public void checkAndSet(Object object, Object object2) {
        Object object3 = this.value;
        if (object3 == object) {
            this.value = object2;
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    public void clear() {
        this.value = null;
    }

    public Object get() {
        return this.value;
    }
}

