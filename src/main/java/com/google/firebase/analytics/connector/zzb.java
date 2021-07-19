/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector;

import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

public final class zzb
implements EventHandler {
    public static final EventHandler zza;

    static {
        zzb zzb2 = new zzb();
        zza = zzb2;
    }

    private zzb() {
    }

    public final void handle(Event event) {
        AnalyticsConnectorImpl.zza(event);
    }
}

