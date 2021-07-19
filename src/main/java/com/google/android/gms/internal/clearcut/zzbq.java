/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzav;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcn;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzbq
extends zzav
implements zzcn,
RandomAccess {
    private static final zzbq zzgj;
    private int size;
    private double[] zzgk;

    static {
        zzbq zzbq2;
        zzgj = zzbq2 = new zzbq();
        zzbq2.zzv();
    }

    public zzbq() {
        double[] dArray = new double[10];
        this(dArray, 0);
    }

    private zzbq(double[] dArray, int n10) {
        this.zzgk = dArray;
        this.size = n10;
    }

    private final void zzc(int n10, double d10) {
        int n11;
        this.zzw();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            double[] dArray = this.zzgk;
            int n12 = dArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(dArray, n10, dArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                double[] dArray2 = new double[n11];
                System.arraycopy(dArray, 0, dArray2, 0, n10);
                dArray = this.zzgk;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(dArray, n10, dArray2, n12, n13);
                this.zzgk = dArray2;
            }
            this.zzgk[n10] = d10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzh(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final void zzg(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size)) {
            return;
        }
        String string2 = this.zzh(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzh(int n10) {
        int n11 = this.size;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public final /* synthetic */ void add(int n10, Object object) {
        double d10 = (Double)object;
        this.zzc(n10, d10);
    }

    public final boolean addAll(Collection object) {
        this.zzw();
        zzci.checkNotNull(object);
        int n10 = object instanceof zzbq;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzbq)object;
        n10 = ((zzbq)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            double[] dArray = this.zzgk;
            n12 = dArray.length;
            if ((n11 += n10) > n12) {
                this.zzgk = dArray = Arrays.copyOf(dArray, n11);
            }
            dArray = ((zzbq)object).zzgk;
            double[] dArray2 = this.zzgk;
            int n13 = this.size;
            int n14 = ((zzbq)object).size;
            System.arraycopy(dArray, 0, dArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof zzbq;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzbq)object;
        n10 = this.size;
        int n11 = ((zzbq)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzbq)object).zzgk;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            double[] dArray = this.zzgk;
            double d10 = dArray[n10];
            Object object2 = object[n10];
            double d11 = d10 - object2;
            n11 = (int)(d11 == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzg(n10);
        return this.zzgk[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            double[] dArray = this.zzgk;
            double d10 = dArray[i10];
            long l10 = Double.doubleToLongBits(d10);
            n11 *= 31;
            n10 = zzci.zzl(l10);
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzw();
        this.zzg(n10);
        double[] dArray = this.zzgk;
        double d10 = dArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            System.arraycopy(dArray, n12, dArray, n10, n11 -= n10);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return d10;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzw();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            double d10 = this.zzgk[i10];
            Double d11 = d10;
            n10 = (int)(object.equals(d11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzgk;
            n11 = i10 + 1;
            n10 = this.size - i10;
            System.arraycopy(object, n11, object, i10, n10);
            int n12 = this.size;
            n11 = 1;
            this.size = n12 -= n11;
            this.modCount = n12 = this.modCount + n11;
            return n11 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzw();
        if (n11 >= n10) {
            double[] dArray = this.zzgk;
            int n12 = this.size - n11;
            System.arraycopy(dArray, n11, dArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        double d10 = (Double)object;
        this.zzw();
        this.zzg(n10);
        object = this.zzgk;
        Object object2 = object[n10];
        object[n10] = d10;
        return (double)object2;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d10) {
        int n10 = this.size;
        this.zzc(n10, d10);
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            double[] dArray = Arrays.copyOf(this.zzgk, n10);
            int n12 = this.size;
            zzbq zzbq2 = new zzbq(dArray, n12);
            return zzbq2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

