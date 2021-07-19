/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfs;
import com.google.android.gms.internal.clearcut.zzfu;
import com.google.android.gms.internal.clearcut.zzfw;
import com.google.android.gms.internal.clearcut.zzfy;
import com.google.android.gms.internal.clearcut.zzfz;
import com.google.android.gms.internal.clearcut.zzgb;
import java.util.Arrays;

public final class zzgz
extends zzfu
implements Cloneable {
    private byte[] zzbjb;
    private String zzbjc;
    private byte[][] zzbjd;
    private boolean zzbje;

    public zzgz() {
        Object object = zzgb.zzse;
        this.zzbjb = object;
        this.zzbjc = "";
        object = zzgb.zzsd;
        this.zzbjd = (byte[][])object;
        this.zzbje = false;
        this.zzrj = null;
        this.zzrs = -1;
    }

    private final zzgz zzgc() {
        int n10;
        zzfu zzfu2;
        try {
            zzfu2 = super.zzeo();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        zzfu2 = (zzgz)zzfu2;
        byte[][] byArray = this.zzbjd;
        if (byArray != null && (n10 = byArray.length) > 0) {
            ((zzgz)zzfu2).zzbjd = byArray = (byte[][])byArray.clone();
        }
        return zzfu2;
    }

    public final /* synthetic */ Object clone() {
        return this.zzgc();
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof zzgz;
        if (!bl4) {
            return false;
        }
        object = (zzgz)object;
        Object object2 = this.zzbjb;
        Object object3 = ((zzgz)object).zzbjb;
        bl4 = Arrays.equals(object2, object3);
        if (!bl4) {
            return false;
        }
        object2 = this.zzbjc;
        if (object2 == null ? (object2 = (Object)((zzgz)object).zzbjc) != null : !(bl4 = object2.equals(object3 = (Object)((zzgz)object).zzbjc))) {
            return false;
        }
        object2 = this.zzbjd;
        object3 = ((zzgz)object).zzbjd;
        bl4 = zzfy.zza((byte[][])object2, (byte[][])object3);
        if (!bl4) {
            return false;
        }
        object2 = this.zzrj;
        if (object2 != null && !(bl4 = object2.isEmpty())) {
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
        String string2 = zzgz.class.getName();
        int n10 = (string2.hashCode() + 527) * 31;
        int n11 = Arrays.hashCode(this.zzbjb);
        n10 = (n10 + n11) * 31;
        Object object = this.zzbjc;
        int n12 = 0;
        if (object == null) {
            n11 = 0;
            object = null;
        } else {
            n11 = ((String)object).hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = zzfy.zza(this.zzbjd);
        n10 = ((n10 + n11) * 31 + 1237) * 31;
        object = this.zzrj;
        if (object != null && (n11 = (int)(((zzfw)object).isEmpty() ? 1 : 0)) == 0) {
            object = this.zzrj;
            n12 = ((zzfw)object).hashCode();
        }
        return n10 + n12;
    }

    public final void zza(zzfs zzfs2) {
        Object object = this.zzbjb;
        Object object2 = zzgb.zzse;
        int n10 = Arrays.equals(object, object2);
        if (n10 == 0) {
            object = this.zzbjb;
            int n11 = 1;
            zzfs2.zza(n11, (byte[])object);
        }
        if ((object = (Object)this.zzbjd) != null && (n10 = ((byte[])object).length) > 0) {
            int n12;
            object = null;
            for (n10 = 0; n10 < (n12 = ((byte[])(object2 = (Object)this.zzbjd)).length); ++n10) {
                if ((object2 = (Object)object2[n10]) == null) continue;
                n12 = 2;
                zzfs2.zza(n12, (byte[])object2);
            }
        }
        if ((object = (Object)this.zzbjc) != null && (n10 = (int)(object.equals(object2 = (Object)"") ? 1 : 0)) == 0) {
            n10 = 4;
            object2 = this.zzbjc;
            zzfs2.zza(n10, (String)object2);
        }
        super.zza(zzfs2);
    }

    public final int zzen() {
        int n10 = super.zzen();
        Object object = this.zzbjb;
        Object object2 = zzgb.zzse;
        int n11 = Arrays.equals((byte[])object, object2);
        int n12 = 1;
        if (n11 == 0) {
            object = this.zzbjb;
            n11 = zzfs.zzb(n12, (byte[])object);
            n10 += n11;
        }
        if ((object = (Object)this.zzbjd) != null && (n11 = ((byte[])object).length) > 0) {
            Object object3;
            int n13;
            object = null;
            int n14 = 0;
            int n15 = 0;
            for (n11 = 0; n11 < (n13 = ((byte[][])(object3 = this.zzbjd)).length); ++n11) {
                if ((object3 = (Object)object3[n11]) == null) continue;
                ++n15;
                int n16 = zzfs.zzh((byte[])object3);
                n14 += n16;
            }
            n10 += n14;
            n10 += (n15 *= n12);
        }
        if ((object = (Object)this.zzbjc) != null && (n11 = (int)(((String)object).equals(object2 = (Object)"") ? 1 : 0)) == 0) {
            object2 = this.zzbjc;
            n11 = zzfs.zzb(4, (String)object2);
            n10 += n11;
        }
        return n10;
    }

    public final /* synthetic */ zzfu zzeo() {
        return (zzgz)((zzfz)this).clone();
    }

    public final /* synthetic */ zzfz zzep() {
        return (zzgz)((zzfz)this).clone();
    }
}

