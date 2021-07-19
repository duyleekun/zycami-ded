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

public final class zzdc
extends zzav
implements zzcn,
RandomAccess {
    private static final zzdc zzlw;
    private int size;
    private long[] zzlx;

    static {
        zzdc zzdc2;
        zzlw = zzdc2 = new zzdc();
        zzdc2.zzv();
    }

    public zzdc() {
        long[] lArray = new long[10];
        this(lArray, 0);
    }

    private zzdc(long[] lArray, int n10) {
        this.zzlx = lArray;
        this.size = n10;
    }

    public static zzdc zzbx() {
        return zzlw;
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

    private final void zzk(int n10, long l10) {
        int n11;
        this.zzw();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            long[] lArray = this.zzlx;
            int n12 = lArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(lArray, n10, lArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                long[] lArray2 = new long[n11];
                System.arraycopy(lArray, 0, lArray2, 0, n10);
                lArray = this.zzlx;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(lArray, n10, lArray2, n12, n13);
                this.zzlx = lArray2;
            }
            this.zzlx[n10] = l10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzh(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ void add(int n10, Object object) {
        long l10 = (Long)object;
        this.zzk(n10, l10);
    }

    public final boolean addAll(Collection object) {
        this.zzw();
        zzci.checkNotNull(object);
        int n10 = object instanceof zzdc;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzdc)object;
        n10 = ((zzdc)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            long[] lArray = this.zzlx;
            n12 = lArray.length;
            if ((n11 += n10) > n12) {
                this.zzlx = lArray = Arrays.copyOf(lArray, n11);
            }
            lArray = ((zzdc)object).zzlx;
            long[] lArray2 = this.zzlx;
            int n13 = this.size;
            int n14 = ((zzdc)object).size;
            System.arraycopy(lArray, 0, lArray2, n13, n14);
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
        int n10 = object instanceof zzdc;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzdc)object;
        n10 = this.size;
        int n11 = ((zzdc)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzdc)object).zzlx;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            long[] lArray = this.zzlx;
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
        return this.getLong(n10);
    }

    public final long getLong(int n10) {
        this.zzg(n10);
        return this.zzlx[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            long[] lArray = this.zzlx;
            long l10 = lArray[i10];
            n10 = zzci.zzl(l10);
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzw();
        this.zzg(n10);
        long[] lArray = this.zzlx;
        long l10 = lArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            System.arraycopy(lArray, n12, lArray, n10, n11 -= n10);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return l10;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzw();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            long l10 = this.zzlx[i10];
            Long l11 = l10;
            n10 = (int)(object.equals(l11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzlx;
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
            long[] lArray = this.zzlx;
            int n12 = this.size - n11;
            System.arraycopy(lArray, n11, lArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        long l10 = (Long)object;
        this.zzw();
        this.zzg(n10);
        object = this.zzlx;
        Object object2 = object[n10];
        object[n10] = l10;
        return (long)object2;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            long[] lArray = Arrays.copyOf(this.zzlx, n10);
            int n12 = this.size;
            zzdc zzdc2 = new zzdc(lArray, n12);
            return zzdc2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final void zzm(long l10) {
        int n10 = this.size;
        this.zzk(n10, l10);
    }
}

