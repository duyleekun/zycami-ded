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
import com.google.android.gms.internal.measurement.zzlp;

public final class zzlq
implements zzlp {
    public static final zzfg zza;
    public static final zzfg zzb;
    public static final zzfg zzc;
    public static final zzfg zzd;

    static {
        Uri uri = zzex.zza("com.google.android.gms.measurement");
        zzfe zzfe2 = new zzfe(uri);
        zza = zzfe2.zzb("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzfe2.zzb("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzfe2.zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzfe2.zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean zza() {
        return true;
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

