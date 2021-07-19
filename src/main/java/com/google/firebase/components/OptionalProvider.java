/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.OptionalProvider$$Lambda$1;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import com.google.firebase.components.OptionalProvider$$Lambda$5;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Provider;

public class OptionalProvider
implements Provider,
Deferred {
    private static final Provider EMPTY_PROVIDER;
    private static final Deferred$DeferredHandler NOOP_HANDLER;
    private volatile Provider delegate;
    private Deferred$DeferredHandler handler;

    static {
        NOOP_HANDLER = OptionalProvider$$Lambda$4.lambdaFactory$();
        EMPTY_PROVIDER = OptionalProvider$$Lambda$5.lambdaFactory$();
    }

    private OptionalProvider(Deferred$DeferredHandler deferred$DeferredHandler, Provider provider) {
        this.handler = deferred$DeferredHandler;
        this.delegate = provider;
    }

    public static OptionalProvider empty() {
        Deferred$DeferredHandler deferred$DeferredHandler = NOOP_HANDLER;
        Provider provider = EMPTY_PROVIDER;
        OptionalProvider optionalProvider = new OptionalProvider(deferred$DeferredHandler, provider);
        return optionalProvider;
    }

    public static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    public static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    public static /* synthetic */ void lambda$whenAvailable$2(Deferred$DeferredHandler deferred$DeferredHandler, Deferred$DeferredHandler deferred$DeferredHandler2, Provider provider) {
        deferred$DeferredHandler.handle(provider);
        deferred$DeferredHandler2.handle(provider);
    }

    public static OptionalProvider of(Provider provider) {
        OptionalProvider optionalProvider = new OptionalProvider(null, provider);
        return optionalProvider;
    }

    public Object get() {
        return this.delegate.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void set(Provider object) {
        Object object2 = this.delegate;
        Provider provider = EMPTY_PROVIDER;
        if (object2 == provider) {
            synchronized (this) {
                object2 = this.handler;
                provider = null;
                this.handler = null;
                this.delegate = object;
            }
            object2.handle((Provider)object);
            return;
        }
        object = new IllegalStateException("provide() can be called only once.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void whenAvailable(Deferred$DeferredHandler deferred$DeferredHandler) {
        Provider provider = this.delegate;
        Object object = EMPTY_PROVIDER;
        if (provider != object) {
            deferred$DeferredHandler.handle(provider);
            return;
        }
        provider = null;
        // MONITORENTER : this
        Provider provider2 = this.delegate;
        if (provider2 != object) {
            provider = provider2;
        } else {
            object = this.handler;
            this.handler = object = OptionalProvider$$Lambda$1.lambdaFactory$((Deferred$DeferredHandler)object, deferred$DeferredHandler);
        }
        // MONITOREXIT : this
        if (provider == null) return;
        deferred$DeferredHandler.handle(provider2);
    }
}

