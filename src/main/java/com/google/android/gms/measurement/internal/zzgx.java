/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzgx
implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhn zzb;

    public zzgx(zzhn zzhn2, Bundle bundle) {
        this.zzb = zzhn2;
        this.zza = bundle;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void run() {
        zzkg zzkg2;
        Object object = "app_id";
        zzhn zzhn2 = this.zzb;
        Bundle bundle = this.zza;
        ((zzge)zzhn2).zzg();
        zzhn2.zzb();
        Preconditions.checkNotNull(bundle);
        Object object2 = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty((String)object2);
        Preconditions.checkNotEmpty(string2);
        Object object3 = "value";
        Preconditions.checkNotNull(bundle.get((String)object3));
        Object object4 = zzhn2.zzx;
        boolean bl2 = ((zzfl)object4).zzF();
        if (!bl2) {
            zzhn2.zzx.zzat().zzk().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        object4 = "triggered_timestamp";
        long l10 = bundle.getLong((String)object4);
        Object object5 = bundle.get((String)object3);
        object3 = zzkg2;
        Object object6 = string2;
        zzkg2 = new zzkg((String)object2, l10, object5, string2);
        try {
            object3 = zzhn2.zzx;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return;
        }
        object4 = ((zzfl)object3).zzl();
        String string3 = bundle.getString((String)object);
        object3 = "triggered_event_name";
        object5 = bundle.getString((String)object3);
        object3 = "triggered_event_params";
        object6 = bundle.getBundle((String)object3);
        long l11 = 0L;
        boolean bl3 = true;
        zzas zzas2 = ((zzkk)object4).zzV(string3, (String)object5, (Bundle)object6, string2, l11, bl3, false);
        object3 = zzhn2.zzx;
        object4 = ((zzfl)object3).zzl();
        string3 = bundle.getString((String)object);
        object3 = "timed_out_event_name";
        object5 = bundle.getString((String)object3);
        object3 = "timed_out_event_params";
        object6 = bundle.getBundle((String)object3);
        l11 = 0L;
        bl3 = true;
        object3 = ((zzkk)object4).zzV(string3, (String)object5, (Bundle)object6, string2, l11, bl3, false);
        object2 = zzhn2.zzx;
        object4 = ((zzfl)object2).zzl();
        string3 = bundle.getString((String)object);
        object2 = "expired_event_name";
        object5 = bundle.getString((String)object2);
        object2 = "expired_event_params";
        object6 = bundle.getBundle((String)object2);
        l11 = 0L;
        bl3 = true;
        zzas zzas3 = ((zzkk)object4).zzV(string3, (String)object5, (Bundle)object6, string2, l11, bl3, false);
        string3 = bundle.getString((String)object);
        long l12 = bundle.getLong("creation_timestamp");
        String string4 = bundle.getString("trigger_event_name");
        long l13 = bundle.getLong("trigger_timeout");
        long l14 = bundle.getLong("time_to_live");
        object4 = object2;
        object5 = string2;
        object6 = zzkg2;
        long l15 = l13;
        l13 = l14;
        object2 = new zzaa(string3, string2, zzkg2, l12, false, string4, (zzas)object3, l15, zzas2, l14, zzas3);
        object = zzhn2.zzx.zzy();
        ((zzjb)object).zzm((zzaa)object2);
    }
}

