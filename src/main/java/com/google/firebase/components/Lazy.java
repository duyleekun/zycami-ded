/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy
implements Provider {
    private static final Object UNINITIALIZED;
    private volatile Object instance;
    private volatile Provider provider;

    static {
        Object object;
        UNINITIALIZED = object = new Object();
    }

    public Lazy(Provider provider) {
        Object object;
        this.instance = object = UNINITIALIZED;
        this.provider = provider;
    }

    public Lazy(Object object) {
        Object object2;
        this.instance = object2 = UNINITIALIZED;
        this.instance = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get() {
        Object object = this.instance;
        Object object2 = UNINITIALIZED;
        if (object != object2) return object;
        synchronized (this) {
            object = this.instance;
            if (object != object2) return object;
            object = this.provider;
            this.instance = object = object.get();
            object2 = null;
            this.provider = null;
            return object;
        }
    }

    public boolean isInitialized() {
        boolean bl2;
        Object object = this.instance;
        Object object2 = UNINITIALIZED;
        if (object != object2) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

