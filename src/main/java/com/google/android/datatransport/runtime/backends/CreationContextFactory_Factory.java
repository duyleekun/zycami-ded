/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContextFactory;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class CreationContextFactory_Factory
implements Factory {
    private final Provider applicationContextProvider;
    private final Provider monotonicClockProvider;
    private final Provider wallClockProvider;

    public CreationContextFactory_Factory(Provider provider, Provider provider2, Provider provider3) {
        this.applicationContextProvider = provider;
        this.wallClockProvider = provider2;
        this.monotonicClockProvider = provider3;
    }

    public static CreationContextFactory_Factory create(Provider provider, Provider provider2, Provider provider3) {
        CreationContextFactory_Factory creationContextFactory_Factory = new CreationContextFactory_Factory(provider, provider2, provider3);
        return creationContextFactory_Factory;
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        CreationContextFactory creationContextFactory = new CreationContextFactory(context, clock, clock2);
        return creationContextFactory;
    }

    public CreationContextFactory get() {
        Context context = (Context)this.applicationContextProvider.get();
        Clock clock = (Clock)this.wallClockProvider.get();
        Clock clock2 = (Clock)this.monotonicClockProvider.get();
        return CreationContextFactory_Factory.newInstance(context, clock, clock2);
    }
}

