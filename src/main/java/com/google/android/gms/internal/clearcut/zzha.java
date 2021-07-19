/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzfs;
import com.google.android.gms.internal.clearcut.zzfu;
import com.google.android.gms.internal.clearcut.zzfw;
import com.google.android.gms.internal.clearcut.zzfy;
import com.google.android.gms.internal.clearcut.zzfz;
import com.google.android.gms.internal.clearcut.zzgb;
import com.google.android.gms.internal.clearcut.zzge$zzd;
import com.google.android.gms.internal.clearcut.zzge$zzs;
import com.google.android.gms.internal.clearcut.zzgy;
import com.google.android.gms.internal.clearcut.zzgz;
import com.google.android.gms.internal.clearcut.zzhb;
import java.util.Arrays;

public final class zzha
extends zzfu
implements Cloneable {
    private String tag;
    public long zzbjf;
    public long zzbjg;
    private long zzbjh;
    public int zzbji;
    private String zzbjj;
    private int zzbjk;
    private boolean zzbjl;
    private zzhb[] zzbjm;
    private byte[] zzbjn;
    private zzge$zzd zzbjo;
    public byte[] zzbjp;
    private String zzbjq;
    private String zzbjr;
    private zzgy zzbjs;
    private String zzbjt;
    public long zzbju;
    private zzgz zzbjv;
    public byte[] zzbjw;
    private String zzbjx;
    private int zzbjy;
    private int[] zzbjz;
    private long zzbka;
    private zzge$zzs zzbkb;
    public boolean zzbkc;

    public zzha() {
        long l10;
        this.zzbjf = l10 = 0L;
        this.zzbjg = l10;
        this.zzbjh = l10;
        Object object = "";
        this.tag = object;
        this.zzbji = 0;
        this.zzbjj = object;
        this.zzbjk = 0;
        this.zzbjl = false;
        Object[] objectArray = zzhb.zzge();
        this.zzbjm = objectArray;
        objectArray = zzgb.zzse;
        this.zzbjn = (byte[])objectArray;
        this.zzbjo = null;
        this.zzbjp = (byte[])objectArray;
        this.zzbjq = object;
        this.zzbjr = object;
        this.zzbjs = null;
        this.zzbjt = object;
        this.zzbju = 180000L;
        this.zzbjv = null;
        this.zzbjw = (byte[])objectArray;
        this.zzbjx = object;
        this.zzbjy = 0;
        object = zzgb.zzrx;
        this.zzbjz = (int[])object;
        this.zzbka = l10;
        this.zzbkb = null;
        this.zzbkc = false;
        this.zzrj = null;
        this.zzrs = -1;
    }

    private final zzha zzgd() {
        int n10;
        Object object;
        zzfu zzfu2 = super.zzeo();
        try {
            zzfu2 = (zzha)zzfu2;
            object = this.zzbjm;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        if (object != null && (n10 = ((zzhb[])object).length) > 0) {
            Object object2;
            int n11;
            ((zzha)zzfu2).zzbjm = object = new zzhb[((zzhb[])object).length];
            object = null;
            for (int i10 = 0; i10 < (n11 = ((zzhb[])(object2 = this.zzbjm)).length); ++i10) {
                zzhb[] zzhbArray = object2[i10];
                if (zzhbArray == null) continue;
                zzhbArray = ((zzha)zzfu2).zzbjm;
                zzhbArray[i10] = object2 = (zzhb)((zzfz)object2[i10]).clone();
            }
        }
        if ((object = this.zzbjo) != null) {
            ((zzha)zzfu2).zzbjo = object;
        }
        if ((object = this.zzbjs) != null) {
            object = (zzgy)object.clone();
            ((zzha)zzfu2).zzbjs = object;
        }
        if ((object = this.zzbjv) != null) {
            ((zzha)zzfu2).zzbjv = object = (zzgz)object.clone();
        }
        if ((object = (Object)this.zzbjz) != null && (n10 = ((zzhb[])object).length) > 0) {
            object = (int[])object.clone();
            ((zzha)zzfu2).zzbjz = (int[])object;
        }
        if ((object = this.zzbkb) != null) {
            ((zzha)zzfu2).zzbkb = object;
        }
        return zzfu2;
    }

    public final /* synthetic */ Object clone() {
        return this.zzgd();
    }

    public final boolean equals(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        Object object3 = object instanceof zzha;
        if (object3 == 0) {
            return false;
        }
        object = (zzha)object;
        long l10 = this.zzbjf;
        long l11 = ((zzha)object).zzbjf;
        long l12 = l10 - l11;
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != 0) {
            return false;
        }
        l10 = this.zzbjg;
        l11 = ((zzha)object).zzbjg;
        long l13 = l10 - l11;
        object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != 0) {
            return false;
        }
        Object object4 = this.tag;
        if (object4 == null ? (object4 = ((zzha)object).tag) != null : (object3 = ((String)object4).equals(object2 = ((zzha)object).tag)) == 0) {
            return false;
        }
        object3 = this.zzbji;
        int n10 = ((zzha)object).zzbji;
        if (object3 != n10) {
            return false;
        }
        object4 = this.zzbjj;
        if (object4 == null ? (object4 = ((zzha)object).zzbjj) != null : (object3 = (Object)((String)object4).equals(object2 = ((zzha)object).zzbjj)) == 0) {
            return false;
        }
        object4 = this.zzbjm;
        object2 = ((zzha)object).zzbjm;
        object3 = zzfy.equals((Object[])object4, object2);
        if (object3 == 0) {
            return false;
        }
        object4 = this.zzbjn;
        object2 = ((zzha)object).zzbjn;
        object3 = Arrays.equals((byte[])object4, (byte[])object2);
        if (object3 == 0) {
            return false;
        }
        object4 = this.zzbjo;
        if (object4 == null ? (object4 = ((zzha)object).zzbjo) != null : (object3 = (Object)((zzcg)object4).equals(object2 = ((zzha)object).zzbjo)) == 0) {
            return false;
        }
        object4 = this.zzbjp;
        object2 = ((zzha)object).zzbjp;
        object3 = Arrays.equals((byte[])object4, (byte[])object2);
        if (object3 == 0) {
            return false;
        }
        object4 = this.zzbjq;
        if (object4 == null ? (object4 = ((zzha)object).zzbjq) != null : (object3 = (Object)((String)object4).equals(object2 = ((zzha)object).zzbjq)) == 0) {
            return false;
        }
        object4 = this.zzbjr;
        if (object4 == null ? (object4 = ((zzha)object).zzbjr) != null : (object3 = (Object)((String)object4).equals(object2 = ((zzha)object).zzbjr)) == 0) {
            return false;
        }
        object4 = this.zzbjs;
        if (object4 == null ? (object4 = ((zzha)object).zzbjs) != null : (object3 = (Object)((zzgy)object4).equals(object2 = ((zzha)object).zzbjs)) == 0) {
            return false;
        }
        object4 = this.zzbjt;
        if (object4 == null ? (object4 = ((zzha)object).zzbjt) != null : (object3 = (Object)((String)object4).equals(object2 = ((zzha)object).zzbjt)) == 0) {
            return false;
        }
        l10 = this.zzbju;
        l11 = ((zzha)object).zzbju;
        long l14 = l10 - l11;
        object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 != 0) {
            return false;
        }
        object4 = this.zzbjv;
        if (object4 == null ? (object4 = ((zzha)object).zzbjv) != null : (object3 = (Object)((zzgz)object4).equals(object2 = ((zzha)object).zzbjv)) == 0) {
            return false;
        }
        object4 = this.zzbjw;
        object2 = ((zzha)object).zzbjw;
        object3 = Arrays.equals((byte[])object4, (byte[])object2);
        if (object3 == 0) {
            return false;
        }
        object4 = this.zzbjx;
        if (object4 == null ? (object4 = ((zzha)object).zzbjx) != null : (object3 = (Object)((String)object4).equals(object2 = ((zzha)object).zzbjx)) == 0) {
            return false;
        }
        object4 = this.zzbjz;
        object2 = ((zzha)object).zzbjz;
        object3 = zzfy.equals((int[])object4, (int[])object2);
        if (object3 == 0) {
            return false;
        }
        object4 = this.zzbkb;
        if (object4 == null ? (object4 = ((zzha)object).zzbkb) != null : (object3 = (Object)((zzcg)object4).equals(object2 = ((zzha)object).zzbkb)) == 0) {
            return false;
        }
        object3 = this.zzbkc;
        n10 = (int)(((zzha)object).zzbkc ? 1 : 0);
        if (object3 != n10) {
            return false;
        }
        object4 = this.zzrj;
        if (object4 != null && (object3 = (Object)((zzfw)object4).isEmpty()) == 0) {
            zzfw zzfw2 = this.zzrj;
            object = ((zzfu)object).zzrj;
            return zzfw2.equals(object);
        }
        object = ((zzfu)object).zzrj;
        if (object != null && !(bl2 = ((zzfw)object).isEmpty())) {
            return false;
        }
        return bl3;
    }

    public final int hashCode() {
        String string2 = zzha.class.getName();
        int n10 = (string2.hashCode() + 527) * 31;
        long l10 = this.zzbjf;
        int n11 = 32;
        long l11 = l10 >>> n11;
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 + n12) * 31;
        l10 = this.zzbjg;
        l11 = l10 >>> n11;
        n12 = (int)(l10 ^= l11);
        n10 = (n10 + n12) * 31 * 31;
        Object object = this.tag;
        int n13 = 0;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((String)object).hashCode();
        }
        n10 = (n10 + n12) * 31;
        n12 = this.zzbji;
        n10 = (n10 + n12) * 31;
        object = this.zzbjj;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((String)object).hashCode();
        }
        n10 = (n10 + n12) * 31 * 31;
        n12 = 1237;
        n10 = (n10 + n12) * 31;
        int n14 = zzfy.hashCode(this.zzbjm);
        n10 = (n10 + n14) * 31;
        n14 = Arrays.hashCode(this.zzbjn);
        n10 += n14;
        Object object2 = this.zzbjo;
        n10 *= 31;
        if (object2 == null) {
            n14 = 0;
            object2 = null;
        } else {
            n14 = ((zzcg)object2).hashCode();
        }
        n10 = (n10 + n14) * 31;
        n14 = Arrays.hashCode(this.zzbjp);
        n10 = (n10 + n14) * 31;
        object2 = this.zzbjq;
        if (object2 == null) {
            n14 = 0;
            object2 = null;
        } else {
            n14 = ((String)object2).hashCode();
        }
        n10 = (n10 + n14) * 31;
        object2 = this.zzbjr;
        if (object2 == null) {
            n14 = 0;
            object2 = null;
        } else {
            n14 = ((String)object2).hashCode();
        }
        n10 += n14;
        object2 = this.zzbjs;
        n10 *= 31;
        if (object2 == null) {
            n14 = 0;
            object2 = null;
        } else {
            n14 = ((zzgy)object2).hashCode();
        }
        n10 = (n10 + n14) * 31;
        object2 = this.zzbjt;
        if (object2 == null) {
            n14 = 0;
            object2 = null;
        } else {
            n14 = ((String)object2).hashCode();
        }
        n10 = (n10 + n14) * 31;
        l11 = this.zzbju;
        long l12 = l11 >>> n11;
        long l13 = l11 ^ l12;
        n11 = (int)l13;
        n10 += n11;
        Object object3 = this.zzbjv;
        n10 *= 31;
        if (object3 == null) {
            n11 = 0;
            object3 = null;
        } else {
            n11 = ((zzgz)object3).hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = Arrays.hashCode(this.zzbjw);
        n10 = (n10 + n11) * 31;
        object3 = this.zzbjx;
        if (object3 == null) {
            n11 = 0;
            object3 = null;
        } else {
            n11 = ((String)object3).hashCode();
        }
        n10 = (n10 + n11) * 31 * 31;
        n11 = zzfy.hashCode(this.zzbjz);
        n10 = (n10 + n11) * 31;
        object3 = this.zzbkb;
        n10 *= 31;
        if (object3 == null) {
            n11 = 0;
            object3 = null;
        } else {
            n11 = ((zzcg)object3).hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.zzbkc ? 1 : 0);
        if (n11 != 0) {
            n12 = 1231;
        }
        n10 = (n10 + n12) * 31;
        object = this.zzrj;
        if (object != null && (n12 = (int)(((zzfw)object).isEmpty() ? 1 : 0)) == 0) {
            object = this.zzrj;
            n13 = ((zzfw)object).hashCode();
        }
        return n10 + n13;
    }

    public final void zza(zzfs zzfs2) {
        int n10;
        Object object;
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2;
        Object object3;
        int n11;
        String string2;
        int n12;
        long l14 = this.zzbjf;
        long l15 = 0L;
        long l16 = l14 - l15;
        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 != false) {
            object4 = 1;
            zzfs2.zzi((int)object4, l14);
        }
        Object object5 = this.tag;
        String string3 = "";
        if (object5 != null && !(n12 = ((String)object5).equals(string3))) {
            n12 = 2;
            string2 = this.tag;
            zzfs2.zza(n12, string2);
        }
        object5 = this.zzbjm;
        object4 = 0;
        string2 = null;
        if (object5 != null && (n12 = ((zzhb[])object5).length) > 0) {
            object5 = null;
            for (n12 = 0; n12 < (n11 = ((byte[])(object3 = (Object)this.zzbjm)).length); n12 += 1) {
                if ((object3 = (Object)object3[n12]) == null) continue;
                n11 = 3;
                zzfs2.zza(n11, (zzfz)object3);
            }
        }
        if (!(n12 = (int)(Arrays.equals((byte[])(object5 = (Object)this.zzbjn), object3 = zzgb.zzse) ? 1 : 0))) {
            n12 = 4;
            object2 = this.zzbjn;
            zzfs2.zza(n12, (byte[])object2);
        }
        if (!(n12 = (int)(Arrays.equals((byte[])(object5 = (Object)this.zzbjp), object3) ? 1 : 0))) {
            n12 = 6;
            object2 = this.zzbjp;
            zzfs2.zza(n12, (byte[])object2);
        }
        if ((object5 = this.zzbjs) != null) {
            n11 = 7;
            zzfs2.zza(n11, (zzfz)object5);
        }
        if ((object5 = this.zzbjq) != null && !(n12 = (int)(((String)object5).equals(string3) ? 1 : 0))) {
            n12 = 8;
            object2 = this.zzbjq;
            zzfs2.zza(n12, (String)object2);
        }
        if ((object5 = this.zzbjo) != null) {
            n11 = 9;
            zzfs2.zze(n11, (zzdo)object5);
        }
        if (n12 = this.zzbji) {
            n11 = 11;
            zzfs2.zzc(n11, n12);
        }
        if ((object5 = this.zzbjr) != null && !(n12 = (int)(((String)object5).equals(string3) ? 1 : 0))) {
            n12 = 13;
            object2 = this.zzbjr;
            zzfs2.zza(n12, (String)object2);
        }
        if ((object5 = this.zzbjt) != null && !(n12 = (int)(((String)object5).equals(string3) ? 1 : 0))) {
            n12 = 14;
            object2 = this.zzbjt;
            zzfs2.zza(n12, (String)object2);
        }
        if (n12 = (int)((l13 = (l12 = this.zzbju) - (l11 = 180000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
            n12 = 15;
            zzfs2.zzb(n12, 0);
            l12 = zzfs.zzj(l12);
            zzfs2.zzn(l12);
        }
        if ((object5 = this.zzbjv) != null) {
            n11 = 16;
            zzfs2.zza(n11, (zzfz)object5);
        }
        if (n12 = (int)((l10 = (l12 = this.zzbjg) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
            n12 = 17;
            zzfs2.zzi(n12, l12);
        }
        if (!(n12 = (int)(Arrays.equals((byte[])(object5 = (Object)this.zzbjw), object3) ? 1 : 0))) {
            n12 = 18;
            object = this.zzbjw;
            zzfs2.zza(n12, (byte[])object);
        }
        if ((object5 = (Object)this.zzbjz) != null && (n12 = ((zzhb[])object5).length) > 0) {
            while (object4 < (n10 = ((zzhb[])(object5 = (Object)this.zzbjz)).length)) {
                n10 = 20;
                n12 = (int)object5[object4];
                zzfs2.zzc(n10, n12);
                ++object4;
            }
        }
        if ((object5 = this.zzbkb) != null) {
            n10 = 23;
            zzfs2.zze(n10, (zzdo)object5);
        }
        if ((object5 = this.zzbjx) != null && !(n12 = (int)(((String)object5).equals(string3) ? 1 : 0))) {
            n12 = 24;
            object = this.zzbjx;
            zzfs2.zza(n12, (String)object);
        }
        if (n12 = (int)(this.zzbkc ? 1 : 0)) {
            n10 = 25;
            zzfs2.zzb(n10, n12 != 0);
        }
        if ((object5 = this.zzbjj) != null && !(n12 = ((String)object5).equals(string3))) {
            n12 = 26;
            string3 = this.zzbjj;
            zzfs2.zza(n12, string3);
        }
        super.zza(zzfs2);
    }

    public final int zzen() {
        String string2;
        Object[] objectArray;
        long l10;
        long l11;
        long l12;
        long l13;
        Object object;
        Object object2;
        int n10;
        int n11;
        int n12 = super.zzen();
        long l14 = this.zzbjf;
        long l15 = 0L;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        int n13 = 1;
        if (l16 != false) {
            n11 = zzfs.zzd(n13, l14);
            n12 += n11;
        }
        Object object3 = this.tag;
        int n14 = 2;
        String string3 = "";
        if (object3 != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            object3 = this.tag;
            n11 = zzfs.zzb(n14, (String)object3);
            n12 += n11;
        }
        object3 = this.zzbjm;
        int n15 = 0;
        if (object3 != null && (n11 = ((zzhb[])object3).length) > 0) {
            object3 = null;
            for (n11 = 0; n11 < (n10 = ((byte[])(object2 = (Object)this.zzbjm)).length); ++n11) {
                if ((object2 = (Object)object2[n11]) == null) continue;
                n10 = 3;
                int n16 = zzfs.zzb(n10, (zzfz)object2);
                n12 += n16;
            }
        }
        if ((n11 = (int)(Arrays.equals((byte[])(object3 = (Object)this.zzbjn), object2 = zzgb.zzse) ? 1 : 0)) == 0) {
            object = this.zzbjn;
            n11 = zzfs.zzb(4, object);
            n12 += n11;
        }
        if ((n11 = (int)(Arrays.equals((byte[])(object3 = (Object)this.zzbjp), object2) ? 1 : 0)) == 0) {
            object = this.zzbjp;
            n11 = zzfs.zzb(6, object);
            n12 += n11;
        }
        if ((object3 = this.zzbjs) != null) {
            n10 = 7;
            n11 = zzfs.zzb(n10, (zzfz)object3);
            n12 += n11;
        }
        if ((object3 = this.zzbjq) != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            object = this.zzbjq;
            n11 = zzfs.zzb(8, (String)object);
            n12 += n11;
        }
        if ((object3 = this.zzbjo) != null) {
            n10 = 9;
            n11 = zzbn.zzc(n10, (zzdo)object3);
            n12 += n11;
        }
        if ((n11 = this.zzbji) != 0) {
            n10 = zzfs.zzr(11);
            n11 = zzfs.zzs(n11);
            n12 += (n10 += n11);
        }
        if ((object3 = this.zzbjr) != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            object = this.zzbjr;
            n11 = zzfs.zzb(13, (String)object);
            n12 += n11;
        }
        if ((object3 = this.zzbjt) != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            object = this.zzbjt;
            n11 = zzfs.zzb(14, (String)object);
            n12 += n11;
        }
        if ((n11 = (int)((l13 = (l12 = this.zzbju) - (l11 = 180000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            n11 = zzfs.zzr(15);
            l12 = zzfs.zzj(l12);
            n10 = zzfs.zzo(l12);
            n12 += (n11 += n10);
        }
        if ((object3 = this.zzbjv) != null) {
            n10 = 16;
            n11 = zzfs.zzb(n10, (zzfz)object3);
            n12 += n11;
        }
        if ((n11 = (int)((l10 = (l12 = this.zzbjg) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            n11 = zzfs.zzd(17, l12);
            n12 += n11;
        }
        if ((n11 = (int)(Arrays.equals((byte[])(object3 = (Object)this.zzbjw), object2) ? 1 : 0)) == 0) {
            objectArray = this.zzbjw;
            n11 = zzfs.zzb(18, objectArray);
            n12 += n11;
        }
        if ((object3 = (Object)this.zzbjz) != null && (n11 = ((zzhb[])object3).length) > 0) {
            int n17;
            n11 = 0;
            object3 = null;
            while (n15 < (n17 = (objectArray = (Object[])this.zzbjz).length)) {
                int n18 = zzfs.zzs(objectArray[n15]);
                n11 += n18;
                ++n15;
            }
            n12 += n11;
            n11 = objectArray.length * n14;
            n12 += n11;
        }
        if ((object3 = this.zzbkb) != null) {
            n14 = 23;
            n11 = zzbn.zzc(n14, (zzdo)object3);
            n12 += n11;
        }
        if ((object3 = this.zzbjx) != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            string2 = this.zzbjx;
            n11 = zzfs.zzb(24, string2);
            n12 += n11;
        }
        if ((n11 = (int)(this.zzbkc ? 1 : 0)) != 0) {
            n11 = zzfs.zzr(25) + n13;
            n12 += n11;
        }
        if ((object3 = this.zzbjj) != null && (n11 = (int)(((String)object3).equals(string3) ? 1 : 0)) == 0) {
            string2 = this.zzbjj;
            n11 = zzfs.zzb(26, string2);
            n12 += n11;
        }
        return n12;
    }

    public final /* synthetic */ zzfu zzeo() {
        return (zzha)((zzfz)this).clone();
    }

    public final /* synthetic */ zzfz zzep() {
        return (zzha)((zzfz)this).clone();
    }
}

