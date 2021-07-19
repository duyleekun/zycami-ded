/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzde;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzge;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzff
extends zzde
implements zzes,
zzge,
RandomAccess {
    private static final zzff zza;
    private long[] zzb;
    private int zzc;

    static {
        zzff zzff2;
        long[] lArray = new long[]{};
        zza = zzff2 = new zzff(lArray, 0);
        zzff2.zzb();
    }

    public zzff() {
        long[] lArray = new long[10];
        this(lArray, 0);
    }

    private zzff(long[] lArray, int n10) {
        this.zzb = lArray;
        this.zzc = n10;
    }

    private final void zzc(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzd(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzd(int n10) {
        int n11 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public final /* synthetic */ void add(int n10, Object object) {
        int n11;
        object = (Long)object;
        long l10 = (Long)object;
        this.zzc();
        if (n10 >= 0 && n10 <= (n11 = this.zzc)) {
            long[] lArray = this.zzb;
            int n12 = lArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(lArray, n10, lArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                object = new long[n11];
                System.arraycopy(lArray, 0, object, 0, n10);
                lArray = this.zzb;
                n12 = n10 + 1;
                int n13 = this.zzc - n10;
                System.arraycopy(lArray, n10, object, n12, n13);
                this.zzb = (long[])object;
            }
            this.zzb[n10] = l10;
            this.zzc = n10 = this.zzc + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzd(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        object = (Long)object;
        long l10 = (Long)object;
        this.zzc();
        int n10 = this.zzc;
        long[] lArray = this.zzb;
        int n11 = lArray.length;
        int n12 = 1;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + n12;
            long[] lArray2 = new long[n11];
            System.arraycopy(lArray, 0, lArray2, 0, n10);
            this.zzb = lArray2;
        }
        object = this.zzb;
        int n13 = this.zzc;
        this.zzc = n11 = n13 + 1;
        object[n13] = l10;
        return n12 != 0;
    }

    public final boolean addAll(Collection object) {
        this.zzc();
        zzem.zza(object);
        int n10 = object instanceof zzff;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzff)object;
        n10 = ((zzff)object).zzc;
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
            lArray = ((zzff)object).zzb;
            long[] lArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzff)object).zzc;
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
        int n10 = object instanceof zzff;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzff)object;
        n10 = this.zzc;
        int n11 = ((zzff)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzff)object).zzb;
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

    public final /* synthetic */ Object get(int n10) {
        return this.zza(n10);
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            n11 *= 31;
            long[] lArray = this.zzb;
            long l10 = lArray[i10];
            n10 = zzem.zza(l10);
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
        int n12 = this.size();
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

    public final /* synthetic */ Object remove(int n10) {
        this.zzc();
        this.zzc(n10);
        long[] lArray = this.zzb;
        long l10 = lArray[n10];
        int n11 = this.zzc;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(lArray, n12, lArray, n10, n11);
        }
        this.zzc = n10 = this.zzc + -1;
        this.modCount = n10 = this.modCount + 1;
        return l10;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzc();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            int n12;
            long l10 = this.zzb[i10];
            Long l11 = l10;
            n10 = (int)(object.equals(l11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzb;
            n11 = i10 + 1;
            n10 = this.zzc - i10;
            int n13 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n13);
            this.zzc = n12 = this.zzc - n13;
            this.modCount = n12 = this.modCount + n13;
            return n13 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzc();
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

    public final /* synthetic */ Object set(int n10, Object object) {
        long l10 = (Long)object;
        this.zzc();
        this.zzc(n10);
        object = this.zzb;
        Object object2 = object[n10];
        object[n10] = l10;
        return (long)object2;
    }

    public final int size() {
        return this.zzc;
    }

    public final long zza(int n10) {
        this.zzc(n10);
        return this.zzb[n10];
    }

    public final /* synthetic */ zzes zzb(int n10) {
        int n11 = this.zzc;
        if (n10 >= n11) {
            long[] lArray = Arrays.copyOf(this.zzb, n10);
            int n12 = this.zzc;
            zzff zzff2 = new zzff(lArray, n12);
            return zzff2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

