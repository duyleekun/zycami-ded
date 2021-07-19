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
import com.google.android.gms.internal.measurement.zzlg;

public final class zzlh
implements zzlg {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        boolean bl2 = true;
        zza = zzfe2.zzb("measurement.sdk.dynamite.allow_remote_dynamite3", bl2);
        zzb = zzfe2.zzb("measurement.collection.init_params_control_enabled", bl2);
        zzc = zzfe2.zzb("measurement.sdk.dynamite.use_dynamite3", bl2);
        zzd = zzfe2.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    public final boolean zza() {
        return (Boolean)zza.zze();
    }
}

