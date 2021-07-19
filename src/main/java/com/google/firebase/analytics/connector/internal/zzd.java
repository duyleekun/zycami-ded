/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;

public final class zzd
implements AppMeasurementSdk$OnEventListener {
    public final /* synthetic */ zze zza;

    public zzd(zze zze2) {
        this.zza = zze2;
    }

    public final void onEvent(String object, String string2, Bundle bundle, long l10) {
        object = this.zza.zza;
        boolean bl2 = object.contains(string2);
        if (!bl2) {
            return;
        }
        object = new Bundle();
        string2 = zzc.zzk(string2);
        object.putString("events", string2);
        zze.zzd(this.zza).onMessageTriggered(2, (Bundle)object);
    }
}

