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

public final class zzif
extends zzgi
implements zzik,
zzjz,
RandomAccess {
    private static final zzif zzyv;
    private int size;
    private int[] zzyw;

    static {
        zzif zzif2;
        int[] nArray = new int[]{};
        zzyv = zzif2 = new zzif(nArray, 0);
        zzif2.zzej();
    }

    public zzif() {
        int[] nArray = new int[10];
        this(nArray, 0);
    }

    private zzif(int[] nArray, int n10) {
        this.zzyw = nArray;
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

    public static zzif zzhg() {
        return zzyv;
    }

    public final /* synthetic */ void add(int n10, Object object) {
        int n11;
        object = (Integer)object;
        int n12 = (Integer)object;
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            int[] nArray = this.zzyw;
            int n13 = nArray.length;
            if (n11 < n13) {
                n13 = n10 + 1;
                System.arraycopy(nArray, n10, nArray, n13, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                int[] nArray2 = new int[n11];
                System.arraycopy(nArray, 0, nArray2, 0, n10);
                nArray = this.zzyw;
                n13 = n10 + 1;
                int n14 = this.size - n10;
                System.arraycopy(nArray, n10, nArray2, n13, n14);
                this.zzyw = nArray2;
            }
            this.zzyw[n10] = n12;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        int n10 = (Integer)object;
        this.zzbs(n10);
        return true;
    }

    public final boolean addAll(Collection object) {
        this.zzek();
        zzie.checkNotNull(object);
        int n10 = object instanceof zzif;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzif)object;
        n10 = ((zzif)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            int[] nArray = this.zzyw;
            n12 = nArray.length;
            if ((n11 += n10) > n12) {
                this.zzyw = nArray = Arrays.copyOf(nArray, n11);
            }
            nArray = ((zzif)object).zzyw;
            int[] nArray2 = this.zzyw;
            int n13 = this.size;
            int n14 = ((zzif)object).size;
            System.arraycopy(nArray, 0, nArray2, n13, n14);
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
        int n10 = object instanceof zzif;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzif)object;
        n10 = this.size;
        int n11 = ((zzif)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzif)object).zzyw;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            int[] nArray = this.zzyw;
            n11 = nArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        return this.getInt(n10);
    }

    public final int getInt(int n10) {
        this.zzal(n10);
        return this.zzyw[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            int[] nArray = this.zzyw;
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
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.zzyw;
            int n13 = nArray[i10];
            if (n13 != n12) continue;
            return i10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        int[] nArray = this.zzyw;
        int n11 = nArray[n10];
        int n12 = this.size;
        int n13 = n12 + -1;
        if (n10 < n13) {
            n13 = n10 + 1;
            n12 = n12 - n10 + -1;
            System.arraycopy(nArray, n13, nArray, n10, n12);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return n11;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzek();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            Integer n13 = this.zzyw[i10];
            n10 = (int)(object.equals(n13) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzyw;
            n11 = i10 + 1;
            n10 = this.size - i10;
            int n14 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n14);
            this.size = n12 = this.size - n14;
            this.modCount = n12 = this.modCount + n14;
            return n14 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzek();
        if (n11 >= n10) {
            int[] nArray = this.zzyw;
            int n12 = this.size - n11;
            System.arraycopy(nArray, n11, nArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        int n11 = (Integer)object;
        this.zzek();
        this.zzal(n10);
        int[] nArray = this.zzyw;
        int n12 = nArray[n10];
        nArray[n10] = n11;
        return n12;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            int[] nArray = Arrays.copyOf(this.zzyw, n10);
            int n12 = this.size;
            zzif zzif2 = new zzif(nArray, n12);
            return zzif2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final void zzbs(int n10) {
        this.zzek();
        int n11 = this.size;
        int[] nArray = this.zzyw;
        int n12 = nArray.length;
        if (n11 == n12) {
            n12 = n11 * 3 / 2 + 1;
            int[] nArray2 = new int[n12];
            System.arraycopy(nArray, 0, nArray2, 0, n11);
            this.zzyw = nArray2;
        }
        int[] nArray3 = this.zzyw;
        int n13 = this.size;
        this.size = n12 = n13 + 1;
        nArray3[n13] = n10;
    }
}

