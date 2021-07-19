/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzje;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzhb
extends zzgc
implements RandomAccess,
zzhz,
zzje {
    private static final zzhb zza;
    private double[] zzb;
    private int zzc;

    static {
        zzhb zzhb2;
        double[] dArray = new double[]{};
        zza = zzhb2 = new zzhb(dArray, 0);
        zzhb2.zzb();
    }

    public zzhb() {
        double[] dArray = new double[10];
        this(dArray, 0);
    }

    private zzhb(double[] dArray, int n10) {
        this.zzb = dArray;
        this.zzc = n10;
    }

    private final void zzf(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzg(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzg(int n10) {
        int n11 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public final boolean addAll(Collection object) {
        this.zzbL();
        zzia.zza(object);
        int n10 = object instanceof zzhb;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzhb)object;
        n10 = ((zzhb)object).zzc;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.zzc;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            double[] dArray = this.zzb;
            n12 = dArray.length;
            if ((n11 += n10) > n12) {
                this.zzb = dArray = Arrays.copyOf(dArray, n11);
            }
            dArray = ((zzhb)object).zzb;
            double[] dArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzhb)object).zzc;
            System.arraycopy(dArray, 0, dArray2, n13, n14);
            this.zzc = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public final boolean contains(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        return n11 != (n10 = -1);
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof zzhb;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzhb)object;
        n10 = this.zzc;
        int n11 = ((zzhb)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzhb)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            Object object2;
            long l10;
            double[] dArray = this.zzb;
            double d10 = dArray[n10];
            long l11 = Double.doubleToLongBits(d10);
            long l12 = l11 - (l10 = Double.doubleToLongBits((double)(object2 = object[n10])));
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            n11 *= 31;
            double[] dArray = this.zzb;
            double d10 = dArray[i10];
            long l10 = Double.doubleToLongBits(d10);
            n10 = zzia.zze(l10);
            n11 += n10;
        }
        return n11;
    }

    public final int indexOf(Object object) {
        int n10 = object instanceof Double;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Double)object;
        double d10 = (Double)object;
        int n12 = this.zzc;
        for (n10 = 0; n10 < n12; ++n10) {
            double[] dArray = this.zzb;
            double d11 = dArray[n10];
            double d12 = d11 - d10;
            Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object2 != false) continue;
            return n10;
        }
        return n11;
    }

    public final void removeRange(int n10, int n11) {
        this.zzbL();
        if (n11 >= n10) {
            double[] dArray = this.zzb;
            int n12 = this.zzc - n11;
            System.arraycopy(dArray, n11, dArray, n10, n12);
            int n13 = this.zzc;
            this.zzc = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final int size() {
        return this.zzc;
    }

    public final void zzd(double d10) {
        this.zzbL();
        int n10 = this.zzc;
        double[] dArray = this.zzb;
        int n11 = dArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            double[] dArray2 = new double[n11];
            System.arraycopy(dArray, 0, dArray2, 0, n10);
            this.zzb = dArray2;
        }
        double[] dArray3 = this.zzb;
        int n12 = this.zzc;
        this.zzc = n11 = n12 + 1;
        dArray3[n12] = d10;
    }
}

