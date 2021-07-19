/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Set;

public class Synchronized$SynchronizedSet
extends Synchronized$SynchronizedCollection
implements Set {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedSet(Set set, Object object) {
        super(set, object, null);
    }

    public Set delegate() {
        return (Set)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.hashCode();
        }
    }
}

