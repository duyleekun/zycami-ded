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
import com.google.android.gms.internal.measurement.zzly;

public final class zzlz
implements zzly {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        boolean bl2 = true;
        zza = zzfe2.zzb("measurement.client.sessions.check_on_reset_and_enable2", bl2);
        zzb = zzfe2.zzb("measurement.client.sessions.check_on_startup", bl2);
        zzc = zzfe2.zzb("measurement.client.sessions.start_session_before_view_screen", bl2);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return (Boolean)zza.zze();
    }
}

