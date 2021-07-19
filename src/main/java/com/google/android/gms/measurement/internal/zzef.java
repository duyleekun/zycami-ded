/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzev;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgg;

public final class zzef
implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Object zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ zzei zzf;

    public zzef(zzei zzei2, int n10, String string2, Object object, Object object2, Object object3) {
        this.zzf = zzei2;
        this.zza = n10;
        this.zzb = string2;
        this.zzc = object;
        this.zzd = object2;
        this.zze = object3;
    }

    public final void run() {
        Object object = this.zzf.zzx.zzd();
        boolean c10 = ((zzgf)object).zzu();
        if (c10) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            int n10;
            zzgg zzgg2;
            Object object2 = this.zzf;
            char c11 = zzei.zzq((zzei)object2);
            if (c11 == '\u0000') {
                object2 = this.zzf.zzx.zzc();
                boolean bl2 = ((zzae)object2).zzh();
                if (bl2) {
                    object2 = this.zzf;
                    zzgg2 = ((zzge)object2).zzx;
                    ((zzfl)zzgg2).zzas();
                    n10 = 67;
                    zzei.zzr((zzei)object2, (char)n10);
                } else {
                    object2 = this.zzf;
                    zzgg2 = ((zzge)object2).zzx;
                    ((zzfl)zzgg2).zzas();
                    n10 = 99;
                    zzei.zzr((zzei)object2, (char)n10);
                }
            }
            if ((l14 = (l13 = (l12 = zzei.zzs((zzei)(object2 = this.zzf))) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                object2 = this.zzf;
                zzgg2 = ((zzge)object2).zzx.zzc();
                ((zzae)zzgg2).zzf();
                l10 = 39000L;
                zzei.zzt((zzei)object2, l10);
            }
            int n11 = this.zza;
            char c12 = "01VDIWEA?".charAt(n11);
            zzgg2 = this.zzf;
            n10 = zzei.zzq((zzei)zzgg2);
            zzei zzei2 = this.zzf;
            l11 = zzei.zzs(zzei2);
            boolean bl3 = true;
            String string2 = this.zzb;
            Object object3 = this.zzc;
            Object object4 = this.zzd;
            Object object5 = this.zze;
            String string3 = zzei.zzo(bl3, string2, object3, object4, object5);
            int n12 = String.valueOf(string3).length();
            object3 = new StringBuilder(n12 += 24);
            string2 = "2";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(c12);
            ((StringBuilder)object3).append((char)n10);
            ((StringBuilder)object3).append(l11);
            ((StringBuilder)object3).append(":");
            ((StringBuilder)object3).append(string3);
            object2 = ((StringBuilder)object3).toString();
            n10 = ((String)object2).length();
            int n13 = 1024;
            if (n10 > n13) {
                object2 = this.zzb;
                n10 = 0;
                zzgg2 = null;
                object2 = ((String)object2).substring(0, n13);
            }
            if ((object = ((zzex)object).zzb) != null) {
                l10 = 1L;
                ((zzev)object).zza((String)object2, l10);
            }
            return;
        }
        String string4 = this.zzf.zzn();
        Log.println((int)6, (String)string4, (String)"Persisted config not initialized. Not logging error/warn");
    }
}

