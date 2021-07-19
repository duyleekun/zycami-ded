/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import javax.inject.Provider;

public final class SchemaManager_Factory
implements Factory {
    private final Provider contextProvider;
    private final Provider dbNameProvider;
    private final Provider schemaVersionProvider;

    public SchemaManager_Factory(Provider provider, Provider provider2, Provider provider3) {
        this.contextProvider = provider;
        this.dbNameProvider = provider2;
        this.schemaVersionProvider = provider3;
    }

    public static SchemaManager_Factory create(Provider provider, Provider provider2, Provider provider3) {
        SchemaManager_Factory schemaManager_Factory = new SchemaManager_Factory(provider, provider2, provider3);
        return schemaManager_Factory;
    }

    public static SchemaManager newInstance(Context context, String string2, int n10) {
        SchemaManager schemaManager = new SchemaManager(context, string2, n10);
        return schemaManager;
    }

    public SchemaManager get() {
        Context context = (Context)this.contextProvider.get();
        String string2 = (String)this.dbNameProvider.get();
        int n10 = (Integer)this.schemaVersionProvider.get();
        return SchemaManager_Factory.newInstance(context, string2, n10);
    }
}

