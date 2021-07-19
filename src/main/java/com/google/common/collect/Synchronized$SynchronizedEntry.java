/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Map;

public class Synchronized$SynchronizedEntry
extends Synchronized$SynchronizedObject
implements Map.Entry {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedEntry(Map.Entry entry, Object object) {
        super(entry, object);
    }

    public Map.Entry delegate() {
        return (Map.Entry)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
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
    public Object getKey() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.getKey();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getValue() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.getValue();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object setValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.setValue(object);
        }
    }
}

