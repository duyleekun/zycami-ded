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
import com.google.android.gms.internal.measurement.zzld;

public final class zzle
implements zzld {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;
    public static final zzfg zze;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        boolean bl2 = true;
        zza = zzfe2.zzb("measurement.client.consent_state_v1", bl2);
        zzb = zzfe2.zzb("measurement.client.3p_consent_state_v1", false);
        zzc = zzfe2.zzb("measurement.service.consent_state_v1_W36", bl2);
        zzd = zzfe2.zza("measurement.id.service.consent_state_v1_W36", 0L);
        zze = zzfe2.zza("measurement.service.storage_consent_support_version", 203590L);
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

    public final boolean zzd() {
        return (Boolean)zzc.zze();
    }

    public final long zze() {
        return (Long)zze.zze();
    }
}

