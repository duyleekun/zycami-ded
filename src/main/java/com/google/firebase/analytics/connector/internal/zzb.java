/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;

public final class zzb
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzb zzb2 = new zzb();
        zza = zzb2;
    }

    private zzb() {
    }

    public final Object create(ComponentContainer object) {
        FirebaseApp firebaseApp = (FirebaseApp)object.get(FirebaseApp.class);
        Context context = (Context)object.get(Context.class);
        object = (Subscriber)object.get(Subscriber.class);
        return AnalyticsConnectorImpl.getInstance(firebaseApp, context, (Subscriber)object);
    }
}

