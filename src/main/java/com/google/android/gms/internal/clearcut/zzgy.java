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

public final class zzgy
extends zzfu
implements Cloneable {
    private String[] zzbiw;
    private String[] zzbix;
    private int[] zzbiy;
    private long[] zzbiz;
    private long[] zzbja;

    public zzgy() {
        Object[] objectArray = zzgb.zzsc;
        this.zzbiw = objectArray;
        this.zzbix = objectArray;
        objectArray = zzgb.zzrx;
        this.zzbiy = (int[])objectArray;
        objectArray = zzgb.zzry;
        this.zzbiz = (long[])objectArray;
        this.zzbja = (long[])objectArray;
        this.zzrj = null;
        this.zzrs = -1;
    }

    private final zzgy zzgb() {
        int n10;
        zzfu zzfu2;
        try {
            zzfu2 = super.zzeo();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        zzfu2 = (zzgy)zzfu2;
        Object[] objectArray = this.zzbiw;
        if (objectArray != null && (n10 = objectArray.length) > 0) {
            ((zzgy)zzfu2).zzbiw = objectArray = (String[])objectArray.clone();
        }
        if ((objectArray = this.zzbix) != null && (n10 = objectArray.length) > 0) {
            objectArray = (String[])objectArray.clone();
            ((zzgy)zzfu2).zzbix = objectArray;
        }
        if ((objectArray = (Object[])this.zzbiy) != null && (n10 = objectArray.length) > 0) {
            objectArray = (int[])objectArray.clone();
            ((zzgy)zzfu2).zzbiy = (int[])objectArray;
        }
        if ((objectArray = (Object[])this.zzbiz) != null && (n10 = objectArray.length) > 0) {
            objectArray = (long[])objectArray.clone();
            ((zzgy)zzfu2).zzbiz = (long[])objectArray;
        }
        if ((objectArray = (Object[])this.zzbja) != null && (n10 = objectArray.length) > 0) {
            objectArray = (long[])objectArray.clone();
            ((zzgy)zzfu2).zzbja = (long[])objectArray;
        }
        return zzfu2;
    }

    public final /* synthetic */ Object clone() {
        return this.zzgb();
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof zzgy;
        if (!bl4) {
            return false;
        }
        object = (zzgy)object;
        Object object2 = this.zzbiw;
        Object[] objectArray = ((zzgy)object).zzbiw;
        bl4 = zzfy.equals((Object[])object2, objectArray);
        if (!bl4) {
            return false;
        }
        object2 = this.zzbix;
        objectArray = ((zzgy)object).zzbix;
        bl4 = zzfy.equals((Object[])object2, objectArray);
        if (!bl4) {
            return false;
        }
        object2 = this.zzbiy;
        objectArray = ((zzgy)object).zzbiy;
        bl4 = zzfy.equals((int[])object2, (int[])objectArray);
        if (!bl4) {
            return false;
        }
        object2 = this.zzbiz;
        objectArray = ((zzgy)object).zzbiz;
        bl4 = zzfy.equals((long[])object2, (long[])objectArray);
        if (!bl4) {
            return false;
        }
        object2 = this.zzbja;
        objectArray = ((zzgy)object).zzbja;
        bl4 = zzfy.equals((long[])object2, (long[])objectArray);
        if (!bl4) {
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
        String string2 = zzgy.class.getName();
        int n10 = (string2.hashCode() + 527) * 31;
        int n11 = zzfy.hashCode(this.zzbiw);
        n10 = (n10 + n11) * 31;
        n11 = zzfy.hashCode(this.zzbix);
        n10 = (n10 + n11) * 31;
        n11 = zzfy.hashCode(this.zzbiy);
        n10 = (n10 + n11) * 31;
        n11 = zzfy.hashCode(this.zzbiz);
        n10 = (n10 + n11) * 31;
        n11 = zzfy.hashCode(this.zzbja);
        n10 = (n10 + n11) * 31;
        zzfw zzfw2 = this.zzrj;
        if (zzfw2 != null && (n11 = (int)(zzfw2.isEmpty() ? 1 : 0)) == 0) {
            zzfw2 = this.zzrj;
            n11 = zzfw2.hashCode();
        } else {
            n11 = 0;
            zzfw2 = null;
        }
        return n10 + n11;
    }

    public final void zza(zzfs zzfs2) {
        Object object;
        Object object2;
        int n10;
        int n11;
        Object[] objectArray = this.zzbiw;
        int n12 = 0;
        if (objectArray != null && (n11 = objectArray.length) > 0) {
            objectArray = null;
            for (n11 = 0; n11 < (n10 = ((String[])(object2 = this.zzbiw)).length); ++n11) {
                if ((object2 = object2[n11]) == null) continue;
                n10 = 1;
                zzfs2.zza(n10, (String)object2);
            }
        }
        if ((objectArray = this.zzbix) != null && (n11 = objectArray.length) > 0) {
            objectArray = null;
            for (n11 = 0; n11 < (n10 = ((String[])(object2 = this.zzbix)).length); ++n11) {
                if ((object2 = object2[n11]) == null) continue;
                n10 = 2;
                zzfs2.zza(n10, (String)object2);
            }
        }
        if ((objectArray = (Object[])this.zzbiy) != null && (n11 = objectArray.length) > 0) {
            objectArray = null;
            for (n11 = 0; n11 < (n10 = ((String[])(object2 = (Object)this.zzbiy)).length); ++n11) {
                n10 = 3;
                object = object2[n11];
                zzfs2.zzc(n10, (int)object);
            }
        }
        if ((objectArray = (Object[])this.zzbiz) != null && (n11 = objectArray.length) > 0) {
            objectArray = null;
            for (n11 = 0; n11 < (n10 = ((String[])(object2 = (Object)this.zzbiz)).length); ++n11) {
                n10 = 4;
                String string2 = object2[n11];
                zzfs2.zzi(n10, (long)string2);
            }
        }
        if ((objectArray = (Object[])this.zzbja) != null && (n11 = objectArray.length) > 0) {
            while (n12 < (object = (objectArray = (Object[])this.zzbja).length)) {
                object = 5;
                String string3 = objectArray[n12];
                zzfs2.zzi((int)object, (long)string3);
                ++n12;
            }
        }
        super.zza(zzfs2);
    }

    public final int zzen() {
        int n10;
        Object object;
        int n11;
        Object[] objectArray;
        int n12;
        long[] lArray;
        int n13;
        int n14;
        int n15 = super.zzen();
        Object[] objectArray2 = this.zzbiw;
        int n16 = 0;
        if (objectArray2 != null && (n14 = objectArray2.length) > 0) {
            objectArray2 = null;
            n13 = 0;
            lArray = null;
            n12 = 0;
            objectArray = null;
            for (n14 = 0; n14 < (n11 = ((String[])(object = this.zzbiw)).length); ++n14) {
                if ((object = object[n14]) == null) continue;
                ++n12;
                n10 = zzfs.zzh((String)object);
                n13 += n10;
            }
            n15 += n13;
            n15 += (n12 *= 1);
        }
        if ((objectArray2 = this.zzbix) != null && (n14 = objectArray2.length) > 0) {
            objectArray2 = null;
            n13 = 0;
            lArray = null;
            n12 = 0;
            objectArray = null;
            for (n14 = 0; n14 < (n11 = ((String[])(object = this.zzbix)).length); ++n14) {
                if ((object = object[n14]) == null) continue;
                ++n12;
                n10 = zzfs.zzh((String)object);
                n13 += n10;
            }
            n15 += n13;
            n15 += (n12 *= 1);
        }
        if ((objectArray2 = (Object[])this.zzbiy) != null && (n14 = objectArray2.length) > 0) {
            objectArray2 = null;
            n13 = 0;
            lArray = null;
            for (n14 = 0; n14 < (n10 = (objectArray = this.zzbiy).length); ++n14) {
                n12 = zzfs.zzs(objectArray[n14]);
                n13 += n12;
            }
            n15 += n13;
            n14 = objectArray.length * 1;
            n15 += n14;
        }
        if ((objectArray2 = (Object[])this.zzbiz) != null && (n14 = objectArray2.length) > 0) {
            objectArray2 = null;
            n13 = 0;
            lArray = null;
            for (n14 = 0; n14 < (n10 = (objectArray = (Object[])this.zzbiz).length); ++n14) {
                int n17 = objectArray[n14];
                n12 = zzfs.zzo(n17);
                n13 += n12;
            }
            n15 += n13;
            n14 = objectArray.length * 1;
            n15 += n14;
        }
        if ((objectArray2 = (Object[])this.zzbja) != null && (n14 = objectArray2.length) > 0) {
            n14 = 0;
            objectArray2 = null;
            while (n16 < (n12 = (lArray = this.zzbja).length)) {
                long l10 = lArray[n16];
                n13 = zzfs.zzo(l10);
                n14 += n13;
                ++n16;
            }
            n15 += n14;
            n14 = lArray.length * 1;
            n15 += n14;
        }
        return n15;
    }

    public final /* synthetic */ zzfu zzeo() {
        return (zzgy)((zzfz)this).clone();
    }

    public final /* synthetic */ zzfz zzep() {
        return (zzgy)((zzfz)this).clone();
    }
}

