/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.ArrayList;
import java.util.List;

public final class zzg {
    private long zzA;
    private long zzB;
    private String zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzfl zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private boolean zzq;
    private String zzr;
    private Boolean zzs;
    private long zzt;
    private List zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzg(zzfl zzfl2, String string2) {
        Preconditions.checkNotNull(zzfl2);
        Preconditions.checkNotEmpty(string2);
        this.zza = zzfl2;
        this.zzb = string2;
        ((zzge)zzfl2.zzau()).zzg();
    }

    public final void zzA(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzm;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzm = l10;
    }

    public final long zzB() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzn;
    }

    public final void zzC(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzn;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzn = l10;
    }

    public final long zzD() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzt;
    }

    public final void zzE(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzt;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzt = l10;
    }

    public final boolean zzF() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzo;
    }

    public final void zzG(boolean bl2) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        boolean bl3 = this.zzD;
        boolean bl4 = this.zzo;
        bl4 = bl4 != bl2;
        this.zzD = bl3 |= bl4;
        this.zzo = bl2;
    }

    public final void zzH(long l10) {
        zzfi zzfi2;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 >= 0) {
            l12 = n10;
        } else {
            l12 = 0;
            zzfi2 = null;
        }
        Preconditions.checkArgument((boolean)l12);
        zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        l12 = (long)this.zzD;
        long l13 = this.zzg;
        long l14 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (l14 == false) {
            n10 = 0;
        }
        l12 = l12 | n10;
        this.zzD = l12;
        this.zzg = l10;
    }

    public final long zzI() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzg;
    }

    public final long zzJ() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzE;
    }

    public final void zzK(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzE;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzE = l10;
    }

    public final long zzL() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzF;
    }

    public final void zzM(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzF;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzF = l10;
    }

    public final void zzN() {
        Object object = this.zza.zzau();
        ((zzge)object).zzg();
        long l10 = this.zzg + 1L;
        long l11 = Integer.MAX_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            object = this.zza.zzat().zze();
            Object object2 = zzei.zzl(this.zzb);
            String string2 = "Bundle index overflow. appId";
            ((zzeg)object).zzb(string2, object2);
            l10 = 0L;
        }
        this.zzD = true;
        this.zzg = l10;
    }

    public final long zzO() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzw;
    }

    public final void zzP(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzw;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzw = l10;
    }

    public final long zzQ() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzx;
    }

    public final void zzR(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzx;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzx = l10;
    }

    public final long zzS() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzy;
    }

    public final void zzT(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzy;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzy = l10;
    }

    public final long zzU() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzz;
    }

    public final void zzV(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzz;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzz = l10;
    }

    public final long zzW() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzB;
    }

    public final void zzX(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzB;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzB = l10;
    }

    public final long zzY() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzA;
    }

    public final void zzZ(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzA;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzA = l10;
    }

    public final boolean zza() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzD;
    }

    public final String zzaa() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzC;
    }

    public final String zzab() {
        ((zzge)this.zza.zzau()).zzg();
        String string2 = this.zzC;
        this.zzac(null);
        return string2;
    }

    public final void zzac(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zzC, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zzC = string2;
    }

    public final long zzad() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzp;
    }

    public final void zzae(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzp;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzp = l10;
    }

    public final boolean zzaf() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzq;
    }

    public final void zzag(boolean bl2) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        boolean bl3 = this.zzD;
        boolean bl4 = this.zzq;
        bl4 = bl4 != bl2;
        this.zzD = bl3 |= bl4;
        this.zzq = bl2;
    }

    public final Boolean zzah() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzs;
    }

    public final void zzai(Boolean bl2) {
        int n10;
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n11 = this.zzD;
        Boolean bl3 = this.zzs;
        int n12 = zzkk.zza;
        n12 = 1;
        if (bl3 == null && bl2 == null) {
            n10 = n12;
        } else if (bl3 == null) {
            n10 = 0;
            bl3 = null;
        } else {
            n10 = (int)(bl3.equals(bl2) ? 1 : 0);
        }
        int n13 = n11 | (n10 ^= n12);
        this.zzD = n13;
        this.zzs = bl2;
    }

    public final List zzaj() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzu;
    }

    public final void zzak(List list) {
        boolean bl2;
        ((zzge)this.zza.zzau()).zzg();
        ArrayList arrayList = this.zzu;
        if (arrayList == null && list == null || arrayList != null && (bl2 = arrayList.equals(list))) {
            return;
        }
        this.zzD = bl2 = true;
        if (list != null) {
            arrayList = new ArrayList(list);
        } else {
            bl2 = false;
            arrayList = null;
        }
        this.zzu = arrayList;
    }

    public final void zzb() {
        ((zzge)this.zza.zzau()).zzg();
        this.zzD = false;
    }

    public final String zzc() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzb;
    }

    public final String zzd() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzc;
    }

    public final void zze(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zzc, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zzc = string2;
    }

    public final String zzf() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzd;
    }

    public final void zzg(String string2) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (bl3 == bl2) {
            string2 = null;
        }
        bl2 = this.zzD;
        boolean bl4 = zzkk.zzS(this.zzd, string2);
        this.zzD = bl2 |= (bl3 ^= bl4);
        this.zzd = string2;
    }

    public final String zzh() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzr;
    }

    public final void zzi(String string2) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (bl3 == bl2) {
            string2 = null;
        }
        bl2 = this.zzD;
        boolean bl4 = zzkk.zzS(this.zzr, string2);
        this.zzD = bl2 |= (bl3 ^= bl4);
        this.zzr = string2;
    }

    public final String zzj() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzv;
    }

    public final void zzk(String string2) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (bl3 == bl2) {
            string2 = null;
        }
        bl2 = this.zzD;
        boolean bl4 = zzkk.zzS(this.zzv, string2);
        this.zzD = bl2 |= (bl3 ^= bl4);
        this.zzv = string2;
    }

    public final String zzl() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zze;
    }

    public final void zzm(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zze, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zze = string2;
    }

    public final String zzn() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzf;
    }

    public final void zzo(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zzf, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zzf = string2;
    }

    public final long zzp() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzh;
    }

    public final void zzq(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzh;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzh = l10;
    }

    public final long zzr() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzi;
    }

    public final void zzs(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzi;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzi = l10;
    }

    public final String zzt() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzj;
    }

    public final void zzu(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zzj, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zzj = string2;
    }

    public final long zzv() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzk;
    }

    public final void zzw(long l10) {
        zzfi zzfi2 = this.zza.zzau();
        ((zzge)zzfi2).zzg();
        int n10 = this.zzD;
        long l11 = this.zzk;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        this.zzD = n10 |= l12;
        this.zzk = l10;
    }

    public final String zzx() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzl;
    }

    public final void zzy(String string2) {
        ((zzge)this.zza.zzau()).zzg();
        boolean bl2 = this.zzD;
        boolean bl3 = zzkk.zzS(this.zzl, string2) ^ true;
        this.zzD = bl2 |= bl3;
        this.zzl = string2;
    }

    public final long zzz() {
        ((zzge)this.zza.zzau()).zzg();
        return this.zzm;
    }
}

