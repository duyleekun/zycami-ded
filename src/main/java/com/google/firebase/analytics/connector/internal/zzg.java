/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzf;
import java.util.Set;

public final class zzg
implements zza {
    private final AnalyticsConnector$AnalyticsConnectorListener zza;
    private final AppMeasurementSdk zzb;
    private final zzf zzc;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector$AnalyticsConnectorListener object) {
        this.zza = object;
        this.zzb = appMeasurementSdk;
        this.zzc = object = new zzf(this);
        appMeasurementSdk.registerOnMeasurementEventListener((AppMeasurementSdk$OnEventListener)object);
    }

    public static /* synthetic */ AnalyticsConnector$AnalyticsConnectorListener zzd(zzg zzg2) {
        return zzg2.zza;
    }

    public final AnalyticsConnector$AnalyticsConnectorListener zza() {
        return this.zza;
    }

    public final void zzb(Set set) {
    }

    public final void zzc() {
    }
}

