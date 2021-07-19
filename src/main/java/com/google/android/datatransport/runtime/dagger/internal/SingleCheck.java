/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SingleCheck
implements Provider {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object UNINITIALIZED;
    private volatile Object instance;
    private volatile Provider provider;

    static {
        Object object;
        UNINITIALIZED = object = new Object();
    }

    private SingleCheck(Provider provider) {
        Object object;
        this.instance = object = UNINITIALIZED;
        this.provider = provider;
    }

    public static Provider provider(Provider provider) {
        boolean bl2 = provider instanceof SingleCheck;
        if (!bl2 && !(bl2 = provider instanceof DoubleCheck)) {
            provider = (Provider)Preconditions.checkNotNull(provider);
            SingleCheck singleCheck = new SingleCheck(provider);
            return singleCheck;
        }
        return provider;
    }

    public Object get() {
        Object object = this.instance;
        Object object2 = UNINITIALIZED;
        if (object == object2) {
            object = this.provider;
            if (object == null) {
                object = this.instance;
            } else {
                this.instance = object = object.get();
                object2 = null;
                this.provider = null;
            }
        }
        return object;
    }
}

