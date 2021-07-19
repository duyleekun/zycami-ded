/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.Set;

public class Synchronized$SynchronizedSetMultimap
extends Synchronized$SynchronizedMultimap
implements SetMultimap {
    private static final long serialVersionUID;
    public transient Set entrySet;

    public Synchronized$SynchronizedSetMultimap(SetMultimap setMultimap, Object object) {
        super(setMultimap, object);
    }

    public SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set entries() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.entrySet;
            if (object2 != null) return this.entrySet;
            object2 = this.delegate();
            object2 = object2.entries();
            Object object3 = this.mutex;
            this.entrySet = object2 = Synchronized.set((Set)object2, object3);
            return this.entrySet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.get(object);
            object3 = this.mutex;
            return Synchronized.set((Set)object, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multimap multimap = this.delegate();
            return multimap.removeAll(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multimap multimap = this.delegate();
            return multimap.replaceValues(object, iterable);
        }
    }
}

