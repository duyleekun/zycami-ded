/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ProviderOfLazy
implements Provider {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private final Provider provider;

    private ProviderOfLazy(Provider provider) {
        this.provider = provider;
    }

    public static Provider create(Provider provider) {
        provider = (Provider)Preconditions.checkNotNull(provider);
        ProviderOfLazy providerOfLazy = new ProviderOfLazy(provider);
        return providerOfLazy;
    }

    public Lazy get() {
        return DoubleCheck.lazy(this.provider);
    }
}

