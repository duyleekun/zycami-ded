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

public final class zzjb
extends zzgi
implements zzik,
zzjz,
RandomAccess {
    private static final zzjb zzzz;
    private int size;
    private long[] zzaaa;

    static {
        zzjb zzjb2;
        long[] lArray = new long[]{};
        zzzz = zzjb2 = new zzjb(lArray, 0);
        zzjb2.zzej();
    }

    public zzjb() {
        long[] lArray = new long[10];
        this(lArray, 0);
    }

    private zzjb(long[] lArray, int n10) {
        this.zzaaa = lArray;
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
        object = (Long)object;
        long l10 = (Long)object;
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            long[] lArray = this.zzaaa;
            int n12 = lArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(lArray, n10, lArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                object = new long[n11];
                System.arraycopy(lArray, 0, object, 0, n10);
                lArray = this.zzaaa;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(lArray, n10, object, n12, n13);
                this.zzaaa = (long[])object;
            }
            this.zzaaa[n10] = l10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        long l10 = (Long)object;
        this.zzac(l10);
        return true;
    }

    public final boolean addAll(Collection object) {
        this.zzek();
        zzie.checkNotNull(object);
        int n10 = object instanceof zzjb;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzjb)object;
        n10 = ((zzjb)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            long[] lArray = this.zzaaa;
            n12 = lArray.length;
            if ((n11 += n10) > n12) {
                this.zzaaa = lArray = Arrays.copyOf(lArray, n11);
            }
            lArray = ((zzjb)object).zzaaa;
            long[] lArray2 = this.zzaaa;
            int n13 = this.size;
            int n14 = ((zzjb)object).size;
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
        int n10 = object instanceof zzjb;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzjb)object;
        n10 = this.size;
        int n11 = ((zzjb)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzjb)object).zzaaa;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            long[] lArray = this.zzaaa;
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
        this.zzal(n10);
        return this.zzaaa[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            long[] lArray = this.zzaaa;
            long l10 = lArray[i10];
            n10 = zzie.zzab(l10);
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
            long[] lArray = this.zzaaa;
            long l11 = lArray[n10];
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) continue;
            return n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        long[] lArray = this.zzaaa;
        long l10 = lArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(lArray, n12, lArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return l10;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzek();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            long l10 = this.zzaaa[i10];
            Long l11 = l10;
            n10 = (int)(object.equals(l11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzaaa;
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
            long[] lArray = this.zzaaa;
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
        this.zzek();
        this.zzal(n10);
        object = this.zzaaa;
        Object object2 = object[n10];
        object[n10] = l10;
        return (long)object2;
    }

    public final int size() {
        return this.size;
    }

    public final void zzac(long l10) {
        this.zzek();
        int n10 = this.size;
        long[] lArray = this.zzaaa;
        int n11 = lArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            long[] lArray2 = new long[n11];
            System.arraycopy(lArray, 0, lArray2, 0, n10);
            this.zzaaa = lArray2;
        }
        long[] lArray3 = this.zzaaa;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        lArray3[n12] = l10;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            long[] lArray = Arrays.copyOf(this.zzaaa, n10);
            int n12 = this.size;
            zzjb zzjb2 = new zzjb(lArray, n12);
            return zzjb2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

