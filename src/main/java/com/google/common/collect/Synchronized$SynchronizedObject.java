/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Synchronized$SynchronizedObject
implements Serializable {
    private static final long serialVersionUID;
    public final Object delegate;
    public final Object mutex;

    public Synchronized$SynchronizedObject(Object object, Object object2) {
        this.delegate = object = Preconditions.checkNotNull(object);
        if (object2 == null) {
            object2 = this;
        }
        this.mutex = object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object = this.mutex;
        synchronized (object) {
            objectOutputStream.defaultWriteObject();
            return;
        }
    }

    public Object delegate() {
        return this.delegate;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate;
            return object2.toString();
        }
    }
}

