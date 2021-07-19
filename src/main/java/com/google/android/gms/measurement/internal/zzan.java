/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzan {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final zzaq zzf;

    public zzan(zzfl object, String object2, String iterator2, String object3, long l10, long l11, Bundle bundle) {
        Object object4;
        Preconditions.checkNotEmpty((String)((Object)iterator2));
        Preconditions.checkNotEmpty((String)object3);
        this.zza = iterator2;
        this.zzb = object3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        boolean bl3 = true;
        if (bl3 == bl2) {
            object4 = 0;
            object2 = null;
        }
        this.zzc = object2;
        this.zzd = l10;
        this.zze = l11;
        long l12 = 0L;
        long l13 = l11 - l12;
        object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 != 0 && (object4 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0) {
            object2 = ((zzfl)object).zzat().zze();
            iterator2 = zzei.zzl((String)((Object)iterator2));
            object3 = "Event created with reverse previous/current timestamps. appId";
            ((zzeg)object2).zzb((String)object3, iterator2);
        }
        if (bundle != null && (object4 = bundle.isEmpty()) == 0) {
            object2 = new Bundle(bundle);
            iterator2 = object2.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object5;
                object3 = (String)iterator2.next();
                if (object3 == null) {
                    object3 = ((zzfl)object).zzat().zzb();
                    object5 = "Param name can't be null";
                    ((zzeg)object3).zza((String)object5);
                    iterator2.remove();
                    continue;
                }
                object5 = ((zzfl)object).zzl();
                Object object6 = object2.get((String)object3);
                if ((object5 = ((zzkk)object5).zzE((String)object3, object6)) == null) {
                    object5 = ((zzfl)object).zzat().zze();
                    object3 = ((zzfl)object).zzm().zzd((String)object3);
                    object6 = "Param value can't be null";
                    ((zzeg)object5).zzb((String)object6, object3);
                    iterator2.remove();
                    continue;
                }
                object6 = ((zzfl)object).zzl();
                ((zzkk)object6).zzL((Bundle)object2, (String)object3, object5);
            }
            object = new zzaq((Bundle)object2);
        } else {
            object = new zzaq((Bundle)object2);
        }
        this.zzf = object;
    }

    private zzan(zzfl object, String object2, String object3, String string2, long l10, long l11, zzaq zzaq2) {
        Object object4;
        Preconditions.checkNotEmpty((String)object3);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(zzaq2);
        this.zza = object3;
        this.zzb = string2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        boolean bl3 = true;
        if (bl3 == bl2) {
            object4 = 0;
            object2 = null;
        }
        this.zzc = object2;
        this.zzd = l10;
        this.zze = l11;
        long l12 = 0L;
        long l13 = l11 - l12;
        object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 != 0 && (object4 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0) {
            object = ((zzfl)object).zzat().zze();
            object2 = zzei.zzl((String)object3);
            object3 = zzei.zzl(string2);
            string2 = "Event created with reverse previous/current timestamps. appId, name";
            ((zzeg)object).zzc(string2, object2, object3);
        }
        this.zzf = zzaq2;
    }

    public final String toString() {
        String string2 = this.zza;
        String string3 = this.zzb;
        String string4 = String.valueOf(this.zzf);
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        int n12 = String.valueOf(string4).length();
        n10 = n10 + 33 + n11 + n12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Event{appId='");
        stringBuilder.append(string2);
        stringBuilder.append("', name='");
        stringBuilder.append(string3);
        stringBuilder.append("', params=");
        stringBuilder.append(string4);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final zzan zza(zzfl zzfl2, long l10) {
        String string2 = this.zzc;
        String string3 = this.zza;
        String string4 = this.zzb;
        long l11 = this.zzd;
        zzaq zzaq2 = this.zzf;
        zzan zzan2 = new zzan(zzfl2, string2, string3, string4, l11, l10, zzaq2);
        return zzan2;
    }
}

