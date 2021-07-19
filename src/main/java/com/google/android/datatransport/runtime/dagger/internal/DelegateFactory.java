/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DelegateFactory
implements Factory {
    private Provider delegate;

    public static void setDelegate(Provider object, Provider provider) {
        Preconditions.checkNotNull(provider);
        object = (DelegateFactory)object;
        Provider provider2 = ((DelegateFactory)object).delegate;
        if (provider2 == null) {
            ((DelegateFactory)object).delegate = provider;
            return;
        }
        object = new IllegalStateException();
        throw object;
    }

    public Object get() {
        Object object = this.delegate;
        if (object != null) {
            return object.get();
        }
        object = new IllegalStateException();
        throw object;
    }

    public Provider getDelegate() {
        return (Provider)Preconditions.checkNotNull(this.delegate);
    }

    public void setDelegatedProvider(Provider provider) {
        DelegateFactory.setDelegate(this, provider);
    }
}

