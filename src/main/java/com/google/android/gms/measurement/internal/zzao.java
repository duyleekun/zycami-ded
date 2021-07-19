/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

public final class zzao {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final Long zzh;
    public final Long zzi;
    public final Long zzj;
    public final Boolean zzk;

    public zzao(String string2, String string3, long l10, long l11, long l12, long l13, long l14, Long l15, Long l16, Long l17, Boolean bl2) {
        zzao zzao2 = this;
        long l18 = l10;
        long l19 = l11;
        long l20 = l12;
        long l21 = l14;
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotEmpty(string3);
        long l22 = 0L;
        long l23 = l10 == l22 ? 0 : (l10 < l22 ? -1 : 1);
        boolean bl3 = true;
        l23 = l23 >= 0 ? (long)bl3 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l19 == l22 ? 0 : (l19 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl3 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        l23 = l20 == l22 ? 0 : (l20 < l22 ? -1 : 1);
        l23 = l23 >= 0 ? (long)bl3 : (long)0;
        Preconditions.checkArgument((boolean)l23);
        long l24 = l21 == l22 ? 0 : (l21 < l22 ? -1 : 1);
        if (l24 < 0) {
            bl3 = false;
        }
        Preconditions.checkArgument(bl3);
        zzao2.zza = string2;
        zzao2.zzb = string3;
        zzao2.zzc = l18;
        zzao2.zzd = l19;
        zzao2.zze = l20;
        l18 = l13;
        zzao2.zzf = l13;
        zzao2.zzg = l21;
        zzao2.zzh = l15;
        zzao2.zzi = l16;
        zzao2.zzj = l17;
        zzao2.zzk = bl2;
    }

    public final zzao zza(long l10) {
        String string2 = this.zza;
        String string3 = this.zzb;
        long l11 = this.zzc;
        long l12 = this.zzd;
        long l13 = this.zze;
        long l14 = this.zzg;
        Long l15 = this.zzh;
        Long l16 = this.zzi;
        Long l17 = this.zzj;
        Boolean bl2 = this.zzk;
        zzao zzao2 = new zzao(string2, string3, l11, l12, l13, l10, l14, l15, l16, l17, bl2);
        return zzao2;
    }

    public final zzao zzb(long l10, long l11) {
        String string2 = this.zza;
        String string3 = this.zzb;
        long l12 = this.zzc;
        long l13 = this.zzd;
        long l14 = this.zze;
        long l15 = this.zzf;
        Long l16 = l11;
        Long l17 = this.zzi;
        Long l18 = this.zzj;
        Boolean bl2 = this.zzk;
        zzao zzao2 = new zzao(string2, string3, l12, l13, l14, l15, l10, l16, l17, l18, bl2);
        return zzao2;
    }

    public final zzao zzc(Long l10, Long l11, Boolean bl2) {
        Boolean bl3;
        zzao zzao2;
        boolean bl4;
        zzao zzao3 = this;
        if (bl2 != null && !(bl4 = bl2.booleanValue())) {
            bl4 = false;
            zzao2 = null;
            bl3 = null;
        } else {
            bl3 = bl2;
        }
        String string2 = zzao3.zza;
        String string3 = zzao3.zzb;
        long l12 = zzao3.zzc;
        long l13 = zzao3.zzd;
        long l14 = zzao3.zze;
        long l15 = zzao3.zzf;
        long l16 = zzao3.zzg;
        Long l17 = zzao3.zzh;
        zzao2 = new zzao(string2, string3, l12, l13, l14, l15, l16, l17, l10, l11, bl3);
        return zzao2;
    }
}

