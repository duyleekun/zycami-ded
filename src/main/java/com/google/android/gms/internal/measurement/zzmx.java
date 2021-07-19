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
import com.google.android.gms.internal.measurement.zzmw;

public final class zzmx
implements zzmw {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;
    public static final zzfg zze;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        zza = zzfe2.zzb("measurement.test.boolean_flag", false);
        zzb = zzfe2.zzc("measurement.test.double_flag", -3.0);
        zzc = zzfe2.zza("measurement.test.int_flag", -2);
        zzd = zzfe2.zza("measurement.test.long_flag", -1);
        zze = zzfe2.zzd("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return (Boolean)zza.zze();
    }

    public final double zzb() {
        return (Double)zzb.zze();
    }

    public final long zzc() {
        return (Long)zzc.zze();
    }

    public final long zzd() {
        return (Long)zzd.zze();
    }

    public final String zze() {
        return (String)zze.zze();
    }
}

