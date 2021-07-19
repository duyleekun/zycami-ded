/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.io.Serializable;
import java.util.Set;

public class Synchronized$SynchronizedBiMap
extends Synchronized$SynchronizedMap
implements BiMap,
Serializable {
    private static final long serialVersionUID;
    private transient BiMap inverse;
    private transient Set valueSet;

    private Synchronized$SynchronizedBiMap(BiMap biMap, Object object, BiMap biMap2) {
        super(biMap, object);
        this.inverse = biMap2;
    }

    public /* synthetic */ Synchronized$SynchronizedBiMap(BiMap biMap, Object object, BiMap biMap2, Synchronized$1 synchronized$1) {
        this(biMap, object, biMap2);
    }

    public BiMap delegate() {
        return (BiMap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object forcePut(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            BiMap biMap = this.delegate();
            return biMap.forcePut(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BiMap inverse() {
        Object object = this.mutex;
        synchronized (object) {
            BiMap biMap = this.inverse;
            if (biMap != null) return this.inverse;
            BiMap biMap2 = this.delegate();
            biMap2 = biMap2.inverse();
            Object object2 = this.mutex;
            this.inverse = biMap = new Synchronized$SynchronizedBiMap(biMap2, object2, this);
            return this.inverse;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set values() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.valueSet;
            if (object2 != null) return this.valueSet;
            object2 = this.delegate();
            object2 = object2.values();
            Object object3 = this.mutex;
            this.valueSet = object2 = Synchronized.set((Set)object2, object3);
            return this.valueSet;
        }
    }
}

