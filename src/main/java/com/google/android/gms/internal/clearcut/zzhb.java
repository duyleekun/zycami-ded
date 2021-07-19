/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfs;
import com.google.android.gms.internal.clearcut.zzfu;
import com.google.android.gms.internal.clearcut.zzfw;
import com.google.android.gms.internal.clearcut.zzfy;
import com.google.android.gms.internal.clearcut.zzfz;

public final class zzhb
extends zzfu
implements Cloneable {
    private static volatile zzhb[] zzbkd;
    private String value;
    private String zzbke;

    public zzhb() {
        String string2;
        this.zzbke = string2 = "";
        this.value = string2;
        this.zzrj = null;
        this.zzrs = -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzhb[] zzge() {
        Object object = zzbkd;
        if (object != null) return zzbkd;
        object = zzfy.zzrr;
        synchronized (object) {
            zzhb[] zzhbArray = zzbkd;
            if (zzhbArray != null) return zzbkd;
            zzhbArray = null;
            zzbkd = zzhbArray = new zzhb[0];
            return zzbkd;
        }
    }

    private final zzhb zzgf() {
        zzfu zzfu2;
        try {
            zzfu2 = super.zzeo();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        return (zzhb)zzfu2;
    }

    public final /* synthetic */ Object clone() {
        return this.zzgf();
    }

    public final boolean equals(Object object) {
        boolean bl2;
        String string2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof zzhb;
        if (!bl4) {
            return false;
        }
        object = (zzhb)object;
        Object object2 = this.zzbke;
        if (object2 == null ? (object2 = ((zzhb)object).zzbke) != null : !(bl4 = ((String)object2).equals(string2 = ((zzhb)object).zzbke))) {
            return false;
        }
        object2 = this.value;
        if (object2 == null ? (object2 = ((zzhb)object).value) != null : !(bl4 = ((String)object2).equals(string2 = ((zzhb)object).value))) {
            return false;
        }
        object2 = this.zzrj;
        if (object2 != null && !(bl4 = ((zzfw)object2).isEmpty())) {
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
        int n10;
        String string2 = zzhb.class.getName();
        int n11 = (string2.hashCode() + 527) * 31;
        Object object = this.zzbke;
        int n12 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        object = this.value;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 + n10) * 31;
        object = this.zzrj;
        if (object != null && (n10 = (int)(((zzfw)object).isEmpty() ? 1 : 0)) == 0) {
            object = this.zzrj;
            n12 = ((zzfw)object).hashCode();
        }
        return n11 + n12;
    }

    public final void zza(zzfs zzfs2) {
        int n10;
        String string2 = this.zzbke;
        String string3 = "";
        if (string2 != null && (n10 = string2.equals(string3)) == 0) {
            n10 = 1;
            String string4 = this.zzbke;
            zzfs2.zza(n10, string4);
        }
        if ((string2 = this.value) != null && (n10 = string2.equals(string3)) == 0) {
            n10 = 2;
            string3 = this.value;
            zzfs2.zza(n10, string3);
        }
        super.zza(zzfs2);
    }

    public final int zzen() {
        int n10;
        int n11 = super.zzen();
        String string2 = this.zzbke;
        String string3 = "";
        if (string2 != null && (n10 = string2.equals(string3)) == 0) {
            String string4 = this.zzbke;
            n10 = zzfs.zzb(1, string4);
            n11 += n10;
        }
        if ((string2 = this.value) != null && (n10 = string2.equals(string3)) == 0) {
            string3 = this.value;
            n10 = zzfs.zzb(2, string3);
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ zzfu zzeo() {
        return (zzhb)((zzfz)this).clone();
    }

    public final /* synthetic */ zzfz zzep() {
        return (zzhb)((zzfz)this).clone();
    }
}

