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
import com.google.android.gms.internal.measurement.zzmb;

public final class zzmc
implements zzmb {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        zza = zzfe2.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzfe2.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzfe2.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    public final boolean zza() {
        return (Boolean)zzb.zze();
    }
}

