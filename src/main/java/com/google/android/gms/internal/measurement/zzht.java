/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzje;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzht
extends zzgc
implements RandomAccess,
zzhx,
zzje {
    private static final zzht zza;
    private int[] zzb;
    private int zzc;

    static {
        zzht zzht2;
        int[] nArray = new int[]{};
        zza = zzht2 = new zzht(nArray, 0);
        zzht2.zzb();
    }

    public zzht() {
        int[] nArray = new int[10];
        this(nArray, 0);
    }

    private zzht(int[] nArray, int n10) {
        this.zzb = nArray;
        this.zzc = n10;
    }

    public static zzht zzd() {
        return zza;
    }

    private final void zzi(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzj(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzj(int n10) {
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
        int n10 = object instanceof zzht;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzht)object;
        n10 = ((zzht)object).zzc;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.zzc;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            int[] nArray = this.zzb;
            n12 = nArray.length;
            if ((n11 += n10) > n12) {
                this.zzb = nArray = Arrays.copyOf(nArray, n11);
            }
            nArray = ((zzht)object).zzb;
            int[] nArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzht)object).zzc;
            System.arraycopy(nArray, 0, nArray2, n13, n14);
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
        int n10 = object instanceof zzht;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzht)object;
        n10 = this.zzc;
        int n11 = ((zzht)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzht)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            int[] nArray = this.zzb;
            n11 = nArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            n11 *= 31;
            int[] nArray = this.zzb;
            n10 = nArray[i10];
            n11 += n10;
        }
        return n11;
    }

    public final int indexOf(Object object) {
        int n10 = object instanceof Integer;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Integer)object;
        int n12 = (Integer)object;
        n10 = this.zzc;
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.zzb;
            int n13 = nArray[i10];
            if (n13 != n12) continue;
            return i10;
        }
        return n11;
    }

    public final void removeRange(int n10, int n11) {
        this.zzbL();
        if (n11 >= n10) {
            int[] nArray = this.zzb;
            int n12 = this.zzc - n11;
            System.arraycopy(nArray, n11, nArray, n10, n12);
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

    public final zzhx zzf(int n10) {
        int n11 = this.zzc;
        if (n10 >= n11) {
            int[] nArray = Arrays.copyOf(this.zzb, n10);
            int n12 = this.zzc;
            zzht zzht2 = new zzht(nArray, n12);
            return zzht2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final int zzg(int n10) {
        this.zzi(n10);
        return this.zzb[n10];
    }

    public final void zzh(int n10) {
        this.zzbL();
        int n11 = this.zzc;
        int[] nArray = this.zzb;
        int n12 = nArray.length;
        if (n11 == n12) {
            n12 = n11 * 3 / 2 + 1;
            int[] nArray2 = new int[n12];
            System.arraycopy(nArray, 0, nArray2, 0, n11);
            this.zzb = nArray2;
        }
        int[] nArray3 = this.zzb;
        int n13 = this.zzc;
        this.zzc = n12 = n13 + 1;
        nArray3[n13] = n10;
    }
}

