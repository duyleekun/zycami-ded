/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContextFactory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

public final class MetadataBackendRegistry_Factory
implements Factory {
    private final Provider applicationContextProvider;
    private final Provider creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(Provider provider, Provider provider2) {
        this.applicationContextProvider = provider;
        this.creationContextFactoryProvider = provider2;
    }

    public static MetadataBackendRegistry_Factory create(Provider provider, Provider provider2) {
        MetadataBackendRegistry_Factory metadataBackendRegistry_Factory = new MetadataBackendRegistry_Factory(provider, provider2);
        return metadataBackendRegistry_Factory;
    }

    public static MetadataBackendRegistry newInstance(Context context, Object object) {
        object = (CreationContextFactory)object;
        MetadataBackendRegistry metadataBackendRegistry = new MetadataBackendRegistry(context, (CreationContextFactory)object);
        return metadataBackendRegistry;
    }

    public MetadataBackendRegistry get() {
        Context context = (Context)this.applicationContextProvider.get();
        Object object = this.creationContextFactoryProvider.get();
        return MetadataBackendRegistry_Factory.newInstance(context, object);
    }
}

