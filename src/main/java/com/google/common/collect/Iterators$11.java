/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Enumeration;
import java.util.Iterator;

public final class Iterators$11
implements Enumeration {
    public final /* synthetic */ Iterator val$iterator;

    public Iterators$11(Iterator iterator2) {
        this.val$iterator = iterator2;
    }

    public boolean hasMoreElements() {
        return this.val$iterator.hasNext();
    }

    public Object nextElement() {
        return this.val$iterator.next();
    }
}

