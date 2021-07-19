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
import com.google.android.gms.internal.measurement.zzmk;

public final class zzml
implements zzmk {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;
    public static final zzfg zze;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        boolean bl2 = true;
        zza = zzfe2.zzb("measurement.sdk.collection.enable_extend_user_property_size", bl2);
        zzb = zzfe2.zzb("measurement.sdk.collection.last_deep_link_referrer2", bl2);
        zzc = zzfe2.zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzfe2.zzb("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzfe2.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    public final boolean zza() {
        return (Boolean)zza.zze();
    }

    public final boolean zzb() {
        return (Boolean)zzb.zze();
    }

    public final boolean zzc() {
        return (Boolean)zzc.zze();
    }

    public final boolean zzd() {
        return (Boolean)zzd.zze();
    }
}

