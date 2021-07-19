/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ForwardingConcurrentMap
extends ForwardingMap
implements ConcurrentMap {
    public abstract ConcurrentMap delegate();

    public Object putIfAbsent(Object object, Object object2) {
        return this.delegate().putIfAbsent(object, object2);
    }

    public boolean remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    public Object replace(Object object, Object object2) {
        return this.delegate().replace(object, object2);
    }

    public boolean replace(Object object, Object object2, Object object3) {
        return this.delegate().replace(object, object2, object3);
    }
}

