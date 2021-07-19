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
import com.google.android.gms.internal.measurement.zzmn;

public final class zzmo
implements zzmn {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;
    public static final zzfg zze;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        long l10 = 0L;
        zza = zzfe2.zza("measurement.id.lifecycle.app_in_background_parameter", l10);
        zzb = zzfe2.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzfe2.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzfe2.zzb("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzfe2.zza("measurement.id.lifecycle.app_backgrounded_tracking", l10);
    }

    public final boolean zza() {
        return (Boolean)zzb.zze();
    }

    public final boolean zzb() {
        return (Boolean)zzd.zze();
    }
}

