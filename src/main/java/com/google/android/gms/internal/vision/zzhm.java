/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjz;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzhm
extends zzgi
implements zzik,
zzjz,
RandomAccess {
    private static final zzhm zzup;
    private int size;
    private double[] zzuq;

    static {
        zzhm zzhm2;
        double[] dArray = new double[]{};
        zzup = zzhm2 = new zzhm(dArray, 0);
        zzhm2.zzej();
    }

    public zzhm() {
        double[] dArray = new double[10];
        this(dArray, 0);
    }

    private zzhm(double[] dArray, int n10) {
        this.zzuq = dArray;
        this.size = n10;
    }

    private final void zzal(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size)) {
            return;
        }
        String string2 = this.zzam(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzam(int n10) {
        int n11 = this.size;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public final /* synthetic */ void add(int n10, Object object) {
        int n11;
        object = (Double)object;
        double d10 = (Double)object;
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            double[] dArray = this.zzuq;
            int n12 = dArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(dArray, n10, dArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                object = new double[n11];
                System.arraycopy(dArray, 0, object, 0, n10);
                dArray = this.zzuq;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(dArray, n10, object, n12, n13);
                this.zzuq = (double[])object;
            }
            this.zzuq[n10] = d10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        double d10 = (Double)object;
        this.zzc(d10);
        return true;
    }

    public final boolean addAll(Collection object) {
        this.zzek();
        zzie.checkNotNull(object);
        int n10 = object instanceof zzhm;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzhm)object;
        n10 = ((zzhm)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            double[] dArray = this.zzuq;
            n12 = dArray.length;
            if ((n11 += n10) > n12) {
                this.zzuq = dArray = Arrays.copyOf(dArray, n11);
            }
            dArray = ((zzhm)object).zzuq;
            double[] dArray2 = this.zzuq;
            int n13 = this.size;
            int n14 = ((zzhm)object).size;
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
        int n10 = object instanceof zzhm;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzhm)object;
        n10 = this.size;
        int n11 = ((zzhm)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzhm)object).zzuq;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            Object object2;
            long l10;
            double[] dArray = this.zzuq;
            double d10 = dArray[n10];
            long l11 = Double.doubleToLongBits(d10);
            long l12 = l11 - (l10 = Double.doubleToLongBits((double)(object2 = object[n10])));
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzal(n10);
        return this.zzuq[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            double[] dArray = this.zzuq;
            double d10 = dArray[i10];
            long l10 = Double.doubleToLongBits(d10);
            n11 *= 31;
            n10 = zzie.zzab(l10);
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
        int n12 = this.size();
        for (n10 = 0; n10 < n12; ++n10) {
            double[] dArray = this.zzuq;
            double d11 = dArray[n10];
            double d12 = d11 - d10;
            Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object2 != false) continue;
            return n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        double[] dArray = this.zzuq;
        double d10 = dArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(dArray, n12, dArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return d10;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzek();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            double d10 = this.zzuq[i10];
            Double d11 = d10;
            n10 = (int)(object.equals(d11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzuq;
            n11 = i10 + 1;
            n10 = this.size - i10;
            int n13 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n13);
            this.size = n12 = this.size - n13;
            this.modCount = n12 = this.modCount + n13;
            return n13 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzek();
        if (n11 >= n10) {
            double[] dArray = this.zzuq;
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
        this.zzek();
        this.zzal(n10);
        object = this.zzuq;
        Object object2 = object[n10];
        object[n10] = d10;
        return (double)object2;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            double[] dArray = Arrays.copyOf(this.zzuq, n10);
            int n12 = this.size;
            zzhm zzhm2 = new zzhm(dArray, n12);
            return zzhm2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final void zzc(double d10) {
        this.zzek();
        int n10 = this.size;
        double[] dArray = this.zzuq;
        int n11 = dArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            double[] dArray2 = new double[n11];
            System.arraycopy(dArray, 0, dArray2, 0, n10);
            this.zzuq = dArray2;
        }
        double[] dArray3 = this.zzuq;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        dArray3[n12] = d10;
    }
}

