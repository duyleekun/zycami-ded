/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzje;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzim
extends zzgc
implements RandomAccess,
zzhy,
zzje {
    private static final zzim zza;
    private long[] zzb;
    private int zzc;

    static {
        zzim zzim2;
        long[] lArray = new long[]{};
        zza = zzim2 = new zzim(lArray, 0);
        zzim2.zzb();
    }

    public zzim() {
        long[] lArray = new long[10];
        this(lArray, 0);
    }

    private zzim(long[] lArray, int n10) {
        this.zzb = lArray;
        this.zzc = n10;
    }

    public static zzim zzf() {
        return zza;
    }

    private final void zzh(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzi(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzi(int n10) {
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
        int n10 = object instanceof zzim;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzim)object;
        n10 = ((zzim)object).zzc;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.zzc;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            long[] lArray = this.zzb;
            n12 = lArray.length;
            if ((n11 += n10) > n12) {
                this.zzb = lArray = Arrays.copyOf(lArray, n11);
            }
            lArray = ((zzim)object).zzb;
            long[] lArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzim)object).zzc;
            System.arraycopy(lArray, 0, lArray2, n13, n14);
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
        int n10 = object instanceof zzim;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzim)object;
        n10 = this.zzc;
        int n11 = ((zzim)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzim)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            long[] lArray = this.zzb;
            long l10 = lArray[n10];
            Object object2 = object[n10];
            long l11 = l10 - object2;
            n11 = (int)(l11 == 0L ? 0 : (l11 < 0L ? -1 : 1));
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
            long[] lArray = this.zzb;
            long l10 = lArray[i10];
            n10 = zzia.zze(l10);
            n11 += n10;
        }
        return n11;
    }

    public final int indexOf(Object object) {
        int n10 = object instanceof Long;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Long)object;
        long l10 = (Long)object;
        int n12 = this.zzc;
        for (n10 = 0; n10 < n12; ++n10) {
            long[] lArray = this.zzb;
            long l11 = lArray[n10];
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) continue;
            return n10;
        }
        return n11;
    }

    public final void removeRange(int n10, int n11) {
        this.zzbL();
        if (n11 >= n10) {
            long[] lArray = this.zzb;
            int n12 = this.zzc - n11;
            System.arraycopy(lArray, n11, lArray, n10, n12);
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

    public final long zzc(int n10) {
        this.zzh(n10);
        return this.zzb[n10];
    }

    public final zzhy zzd(int n10) {
        int n11 = this.zzc;
        if (n10 >= n11) {
            long[] lArray = Arrays.copyOf(this.zzb, n10);
            int n12 = this.zzc;
            zzim zzim2 = new zzim(lArray, n12);
            return zzim2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final void zzg(long l10) {
        this.zzbL();
        int n10 = this.zzc;
        long[] lArray = this.zzb;
        int n11 = lArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            long[] lArray2 = new long[n11];
            System.arraycopy(lArray, 0, lArray2, 0, n10);
            this.zzb = lArray2;
        }
        long[] lArray3 = this.zzb;
        int n12 = this.zzc;
        this.zzc = n11 = n12 + 1;
        lArray3[n12] = l10;
    }
}

