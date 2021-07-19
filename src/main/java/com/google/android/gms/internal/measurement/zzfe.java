/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.internal.measurement.zzfa;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzfl;

public final class zzfe {
    public final String zza;
    public final Uri zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final zzfl zzi;

    public zzfe(Uri object) {
        this.zza = null;
        this.zzb = object;
        object = "";
        this.zzc = object;
        this.zzd = object;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzfg zza(String string2, long l10) {
        Long l11 = l10;
        zzfa zzfa2 = new zzfa(this, string2, l11, true);
        return zzfa2;
    }

    public final zzfg zzb(String string2, boolean bl2) {
        Boolean bl3 = bl2;
        zzfb zzfb2 = new zzfb(this, string2, bl3, true);
        return zzfb2;
    }

    public final zzfg zzc(String object, double d10) {
        object = -3.0;
        zzfc zzfc2 = new zzfc(this, "measurement.test.double_flag", (Double)object, true);
        return zzfc2;
    }

    public final zzfg zzd(String string2, String string3) {
        zzfd zzfd2 = new zzfd(this, string2, string3, true);
        return zzfd2;
    }
}

