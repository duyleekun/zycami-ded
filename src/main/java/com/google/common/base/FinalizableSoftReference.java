/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public abstract class FinalizableSoftReference
extends SoftReference
implements FinalizableReference {
    public FinalizableSoftReference(Object object, FinalizableReferenceQueue finalizableReferenceQueue) {
        ReferenceQueue referenceQueue = finalizableReferenceQueue.queue;
        super(object, referenceQueue);
        finalizableReferenceQueue.cleanUp();
    }
}

