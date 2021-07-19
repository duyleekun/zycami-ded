/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Maps$UnmodifiableBiMap
extends ForwardingMap
implements BiMap,
Serializable {
    private static final long serialVersionUID;
    public final BiMap delegate;
    public BiMap inverse;
    public final Map unmodifiableMap;
    public transient Set values;

    public Maps$UnmodifiableBiMap(BiMap biMap, BiMap biMap2) {
        Map map;
        this.unmodifiableMap = map = Collections.unmodifiableMap(biMap);
        this.delegate = biMap;
        this.inverse = biMap2;
    }

    public Map delegate() {
        return this.unmodifiableMap;
    }

    public Object forcePut(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public BiMap inverse() {
        BiMap biMap = this.inverse;
        if (biMap == null) {
            BiMap biMap2 = this.delegate.inverse();
            this.inverse = biMap = new Maps$UnmodifiableBiMap(biMap2, this);
        }
        return biMap;
    }

    public Set values() {
        Set set = this.values;
        if (set == null) {
            this.values = set = Collections.unmodifiableSet(this.delegate.values());
        }
        return set;
    }
}

