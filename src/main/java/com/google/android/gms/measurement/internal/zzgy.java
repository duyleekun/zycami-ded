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

public final class zzgy
implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhn zzb;

    public zzgy(zzhn zzhn2, Bundle bundle) {
        this.zzb = zzhn2;
        this.zza = bundle;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void run() {
        Object object;
        Object object2 = "creation_timestamp";
        Object object3 = "origin";
        String string2 = "app_id";
        zzhn zzhn2 = this.zzb;
        Bundle bundle = this.zza;
        ((zzge)zzhn2).zzg();
        zzhn2.zzb();
        Preconditions.checkNotNull(bundle);
        Object object4 = "name";
        Preconditions.checkNotEmpty(bundle.getString((String)object4));
        Object object5 = zzhn2.zzx;
        boolean bl2 = ((zzfl)object5).zzF();
        if (!bl2) {
            zzhn2.zzx.zzat().zzk().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        object5 = bundle.getString((String)object4);
        long l10 = 0L;
        boolean bl3 = false;
        object4 = object;
        object = new zzkg((String)object5, l10, null, null);
        try {
            object4 = zzhn2.zzx;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return;
        }
        zzkk zzkk2 = ((zzfl)object4).zzl();
        Object object6 = bundle.getString(string2);
        object4 = "expired_event_name";
        String string3 = bundle.getString((String)object4);
        object4 = "expired_event_params";
        Bundle bundle2 = bundle.getBundle((String)object4);
        String string4 = bundle.getString((String)object3);
        long l11 = bundle.getLong((String)object2);
        boolean bl4 = true;
        zzas zzas2 = zzkk2.zzV((String)object6, string3, bundle2, string4, l11, bl4, false);
        object4 = bundle.getString(string2);
        object5 = bundle.getString((String)object3);
        long l12 = bundle.getLong((String)object2);
        bl3 = bundle.getBoolean("active");
        object2 = bundle.getString("trigger_event_name");
        zzkk2 = null;
        long l13 = bundle.getLong("trigger_timeout");
        bundle2 = null;
        long l14 = bundle.getLong("time_to_live");
        Object object7 = object6;
        zzkg zzkg2 = object;
        object = object2;
        object2 = object6;
        object6 = new zzaa((String)object4, (String)object5, zzkg2, l12, bl3, (String)object, null, l13, null, l14, zzas2);
        object3 = zzhn2.zzx.zzy();
        ((zzjb)object3).zzm((zzaa)object6);
    }
}

