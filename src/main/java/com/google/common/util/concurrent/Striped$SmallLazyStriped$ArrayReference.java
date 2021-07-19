/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class Striped$SmallLazyStriped$ArrayReference
extends WeakReference {
    public final int index;

    public Striped$SmallLazyStriped$ArrayReference(Object object, int n10, ReferenceQueue referenceQueue) {
        super(object, referenceQueue);
        this.index = n10;
    }
}

