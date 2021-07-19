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
import com.google.android.gms.internal.measurement.zzku;

public final class zzkv
implements zzku {
    public static final zzfg zza;
    public static final zzfg zzb;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        zza = zzfe2.zzb("measurement.androidId.delete_feature", true);
        zzb = zzfe2.zzb("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return (Boolean)zza.zze();
    }
}

