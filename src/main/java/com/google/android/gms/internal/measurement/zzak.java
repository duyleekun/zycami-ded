/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzfd;

public final class zzak
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ zzbr zze;

    public zzak(zzbr zzbr2, String string2, String string3, Context context, Bundle bundle) {
        this.zze = zzbr2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = context;
        this.zzd = bundle;
        super(zzbr2, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza() {
        Object object = "com.google.android.gms.measurement.dynamite";
        int n10 = 1;
        float f10 = Float.MIN_VALUE;
        try {
            int n11;
            Object object2;
            String string2;
            Object object3;
            Object object4 = this.zze;
            Object object5 = this.zza;
            Object object6 = this.zzb;
            int n12 = zzbr.zzM((zzbr)object4, (String)object5, (String)object6);
            int n13 = 0;
            object5 = null;
            if (n12 != 0) {
                object5 = this.zzb;
                object4 = this.zza;
                object6 = this.zze;
                object6 = zzbr.zzN((zzbr)object6);
                object3 = object4;
                string2 = object5;
                object2 = object6;
            } else {
                object2 = null;
                object3 = null;
                string2 = null;
            }
            object4 = this.zzc;
            zzbr.zzO((Context)object4);
            object4 = zzbr.zzP();
            n12 = ((Boolean)object4).booleanValue();
            if (n12 == 0 && object3 == null) {
                n12 = 0;
                object4 = null;
            } else {
                n12 = n10;
            }
            object5 = this.zze;
            object6 = this.zzc;
            object6 = ((zzbr)object5).zzc((Context)object6, n12 != 0);
            zzbr.zzQ((zzbr)object5, (zzp)object6);
            object5 = this.zze;
            object5 = zzbr.zzR((zzbr)object5);
            if (object5 == null) {
                object = this.zze;
                object = zzbr.zzN((zzbr)object);
                object4 = "Failed to connect to measurement client.";
                Log.w((String)object, (String)object4);
                return;
            }
            object5 = this.zzc;
            n13 = DynamiteModule.getLocalVersion((Context)object5, (String)object);
            object6 = this.zzc;
            int n14 = DynamiteModule.getRemoteVersion((Context)object6, (String)object);
            if (n12 != 0) {
                n12 = Math.max(n13, n14);
                if (n14 < n13) {
                    n14 = n10;
                } else {
                    n14 = 0;
                    object = null;
                }
                n11 = n14;
            } else {
                if (n13 > 0) {
                    n14 = n13;
                }
                n12 = n14;
                n11 = n13 > 0 ? n10 : 0;
            }
            long l10 = n12;
            long l11 = 39000L;
            Bundle bundle = this.zzd;
            object4 = this.zzc;
            String string3 = zzfd.zza((Context)object4);
            object4 = object;
            object = new zzy(l11, l10, n11 != 0, (String)object2, (String)object3, string2, bundle, string3);
            object4 = this.zze;
            object4 = zzbr.zzR((zzbr)object4);
            object5 = this.zzc;
            object5 = ObjectWrapper.wrap(object5);
            long l12 = this.zzh;
            object4.initialize((IObjectWrapper)object5, (zzy)object, l12);
            return;
        }
        catch (Exception exception) {
            zzbr.zzL(this.zze, exception, n10 != 0, false);
            return;
        }
    }
}

