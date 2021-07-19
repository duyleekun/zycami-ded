/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent$1;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.TransportRuntimeComponent$Builder;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class DaggerTransportRuntimeComponent$Builder
implements TransportRuntimeComponent$Builder {
    private Context setApplicationContext;

    private DaggerTransportRuntimeComponent$Builder() {
    }

    public /* synthetic */ DaggerTransportRuntimeComponent$Builder(DaggerTransportRuntimeComponent$1 daggerTransportRuntimeComponent$1) {
        this();
    }

    public TransportRuntimeComponent build() {
        Preconditions.checkBuilderRequirement(this.setApplicationContext, Context.class);
        Context context = this.setApplicationContext;
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = new DaggerTransportRuntimeComponent(context, null);
        return daggerTransportRuntimeComponent;
    }

    public DaggerTransportRuntimeComponent$Builder setApplicationContext(Context context) {
        this.setApplicationContext = context = (Context)Preconditions.checkNotNull(context);
        return this;
    }
}

