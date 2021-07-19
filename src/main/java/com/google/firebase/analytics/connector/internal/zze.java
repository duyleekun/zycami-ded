/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import java.util.HashSet;
import java.util.Set;

public final class zze
implements zza {
    public final Set zza;
    private final AnalyticsConnector$AnalyticsConnectorListener zzb;
    private final AppMeasurementSdk zzc;
    private final zzd zzd;

    public zze(AppMeasurementSdk hashSet, AnalyticsConnector$AnalyticsConnectorListener object) {
        this.zzb = object;
        this.zzc = hashSet;
        this.zzd = object = new zzd(this);
        ((AppMeasurementSdk)((Object)hashSet)).registerOnMeasurementEventListener((AppMeasurementSdk$OnEventListener)object);
        this.zza = hashSet = new HashSet();
    }

    public static /* synthetic */ AnalyticsConnector$AnalyticsConnectorListener zzd(zze zze2) {
        return zze2.zzb;
    }

    public final AnalyticsConnector$AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public final void zzb(Set object) {
        boolean bl2;
        this.zza.clear();
        Set set = this.zza;
        HashSet<String> hashSet = new HashSet<String>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            String string2 = (String)object.next();
            int n11 = hashSet.size();
            if (n11 >= (n10 = 50)) break;
            n11 = (int)(com.google.firebase.analytics.connector.internal.zzc.zzj(string2) ? 1 : 0);
            if (n11 == 0 || (n11 = (int)(com.google.firebase.analytics.connector.internal.zzc.zzi(string2) ? 1 : 0)) == 0) continue;
            string2 = com.google.firebase.analytics.connector.internal.zzc.zzl(string2);
            Preconditions.checkNotNull(string2);
            hashSet.add(string2);
        }
        set.addAll(hashSet);
    }

    public final void zzc() {
        this.zza.clear();
    }
}

