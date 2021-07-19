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
import com.google.android.gms.internal.measurement.zzmq;

public final class zzmr
implements zzmq {
    public static final zzfg zza;
    public static final zzfg zzb;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        boolean bl2 = true;
        zza = zzfe2.zzb("measurement.sdk.screen.manual_screen_view_logging", bl2);
        zzb = zzfe2.zzb("measurement.sdk.screen.disabling_automatic_reporting", bl2);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return (Boolean)zza.zze();
    }

    public final boolean zzc() {
        return (Boolean)zzb.zze();
    }
}

