/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;

public final class zzgn {
    public final Context zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public Boolean zze;
    public long zzf;
    public zzy zzg;
    public boolean zzh;
    public final Long zzi;
    public String zzj;

    public zzgn(Context object, zzy object2, Long l10) {
        boolean bl2;
        this.zzh = bl2 = true;
        Preconditions.checkNotNull(object);
        object = object.getApplicationContext();
        Preconditions.checkNotNull(object);
        this.zza = object;
        this.zzi = l10;
        if (object2 != null) {
            long l11;
            boolean bl3;
            this.zzg = object2;
            object = ((zzy)object2).zzf;
            this.zzb = object;
            object = ((zzy)object2).zze;
            this.zzc = object;
            object = ((zzy)object2).zzd;
            this.zzd = object;
            this.zzh = bl3 = ((zzy)object2).zzc;
            this.zzf = l11 = ((zzy)object2).zzb;
            object = ((zzy)object2).zzh;
            this.zzj = object;
            object = ((zzy)object2).zzg;
            if (object != null) {
                object2 = "dataCollectionDefaultEnabled";
                bl3 = object.getBoolean((String)object2, bl2);
                object = bl3;
                this.zze = object;
            }
        }
    }
}

