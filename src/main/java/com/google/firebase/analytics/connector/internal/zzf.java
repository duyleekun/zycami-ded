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
import com.google.firebase.analytics.connector.internal.zzg;

public final class zzf
implements AppMeasurementSdk$OnEventListener {
    public final /* synthetic */ zzg zza;

    public zzf(zzg zzg2) {
        this.zza = zzg2;
    }

    public final void onEvent(String string2, String object, Bundle bundle, long l10) {
        String string3;
        boolean bl2;
        if (string2 != null && !(bl2 = string2.equals(string3 = "crash")) && (bl2 = zzc.zzc((String)object))) {
            string2 = new Bundle();
            string3 = "name";
            string2.putString(string3, (String)object);
            string2.putLong("timestampInMillis", l10);
            string2.putBundle("params", bundle);
            object = zzg.zzd(this.zza);
            int n10 = 3;
            object.onMessageTriggered(n10, (Bundle)string2);
        }
    }
}

