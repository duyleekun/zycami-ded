/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.List;

public class Synchronized$SynchronizedListMultimap
extends Synchronized$SynchronizedMultimap
implements ListMultimap {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedListMultimap(ListMultimap listMultimap, Object object) {
        super(listMultimap, object);
    }

    public ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.get(object);
            object3 = this.mutex;
            return Synchronized.access$200((List)object, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            ListMultimap listMultimap = this.delegate();
            return listMultimap.removeAll(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            ListMultimap listMultimap = this.delegate();
            return listMultimap.replaceValues(object, iterable);
        }
    }
}

