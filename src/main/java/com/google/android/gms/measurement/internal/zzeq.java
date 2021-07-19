/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzeo;
import com.google.android.gms.measurement.internal.zzep;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzeq
extends BroadcastReceiver {
    public static final String zza = zzeq.class.getName();
    private final zzkd zzb;
    private boolean zzc;
    private boolean zzd;

    public zzeq(zzkd zzkd2) {
        Preconditions.checkNotNull(zzkd2);
        this.zzb = zzkd2;
    }

    public static /* synthetic */ zzkd zzc(zzeq zzeq2) {
        return zzeq2.zzb;
    }

    public final void onReceive(Context object, Intent object2) {
        this.zzb.zzs();
        object = object2.getAction();
        object2 = this.zzb.zzat().zzk();
        Object object3 = "NetworkBroadcastReceiver received action";
        ((zzeg)object2).zzb((String)object3, object);
        object2 = "android.net.conn.CONNECTIVITY_CHANGE";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            bl2 = this.zzd;
            object = this.zzb.zzh();
            boolean bl3 = ((zzeo)object).zzb();
            if (bl2 != bl3) {
                this.zzd = bl3;
                object2 = this.zzb.zzau();
                object3 = new zzep(this, bl3);
                ((zzfi)object2).zzh((Runnable)object3);
            }
            return;
        }
        this.zzb.zzat().zze().zzb("NetworkBroadcastReceiver received unknown action", object);
    }

    public final void zza() {
        this.zzb.zzs();
        Object object = this.zzb.zzau();
        ((zzge)object).zzg();
        boolean bl2 = this.zzc;
        if (bl2) {
            return;
        }
        object = this.zzb.zzaw();
        Object object2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        object.registerReceiver((BroadcastReceiver)this, object2);
        this.zzd = bl2 = this.zzb.zzh().zzb();
        object = this.zzb.zzat().zzk();
        object2 = this.zzd;
        ((zzeg)object).zzb("Registering connectivity change receiver. Network connected", object2);
        this.zzc = true;
    }

    public final void zzb() {
        this.zzb.zzs();
        ((zzge)this.zzb.zzau()).zzg();
        Object object = this.zzb.zzau();
        ((zzge)object).zzg();
        boolean bl2 = this.zzc;
        if (bl2) {
            object = this.zzb.zzat().zzk();
            Object object2 = "Unregistering connectivity change receiver";
            ((zzeg)object).zza((String)object2);
            bl2 = false;
            this.zzc = false;
            this.zzd = false;
            object = this.zzb.zzaw();
            try {
                object.unregisterReceiver((BroadcastReceiver)this);
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = this.zzb.zzat().zzb();
                String string2 = "Failed to unregister the network broadcast receiver";
                ((zzeg)object2).zzb(string2, illegalArgumentException);
            }
        }
    }
}

