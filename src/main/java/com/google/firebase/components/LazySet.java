/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LazySet
implements Provider {
    private volatile Set actualSet = null;
    private volatile Set providers;

    public LazySet(Collection collection) {
        Object object = new ConcurrentHashMap();
        this.providers = object = Collections.newSetFromMap(object);
        this.providers.addAll(collection);
    }

    public static LazySet fromCollection(Collection collection) {
        collection = (Set)collection;
        LazySet lazySet = new LazySet(collection);
        return lazySet;
    }

    private void updateSet() {
        synchronized (this) {
            Object object = this.providers;
            object = object.iterator();
            while (true) {
                boolean bl2 = object.hasNext();
                if (!bl2) break;
                Object object2 = object.next();
                object2 = (Provider)object2;
                Set set = this.actualSet;
                object2 = object2.get();
                set.add(object2);
                continue;
                break;
            }
            object = null;
            this.providers = null;
            return;
        }
    }

    public void add(Provider object) {
        synchronized (this) {
            Set set = this.actualSet;
            if (set == null) {
                set = this.providers;
                set.add(object);
            } else {
                set = this.actualSet;
                object = object.get();
                set.add(object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set get() {
        Object object = this.actualSet;
        if (object != null) return Collections.unmodifiableSet(this.actualSet);
        synchronized (this) {
            object = this.actualSet;
            if (object != null) return Collections.unmodifiableSet(this.actualSet);
            object = new ConcurrentHashMap();
            this.actualSet = object = Collections.newSetFromMap(object);
            this.updateSet();
            return Collections.unmodifiableSet(this.actualSet);
        }
    }
}

