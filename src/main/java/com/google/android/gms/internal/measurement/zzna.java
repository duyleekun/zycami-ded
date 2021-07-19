/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.internal.measurement.zzex;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzmz;

public final class zzna
implements zzmz {
    public static final zzfg zza;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        zza = zzfe2.zzb("measurement.collection.log_event_and_bundle_v2", true);
    }

    public final boolean zza() {
        return (Boolean)zza.zze();
    }
}

