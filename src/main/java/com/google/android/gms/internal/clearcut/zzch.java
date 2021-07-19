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

public final class zzch
extends zzav
implements zzcn,
RandomAccess {
    private static final zzch zzkr;
    private int size;
    private int[] zzks;

    static {
        zzch zzch2;
        zzkr = zzch2 = new zzch();
        zzch2.zzv();
    }

    public zzch() {
        int[] nArray = new int[10];
        this(nArray, 0);
    }

    private zzch(int[] nArray, int n10) {
        this.zzks = nArray;
        this.size = n10;
    }

    public static zzch zzbk() {
        return zzkr;
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

    private final void zzo(int n10, int n11) {
        int n12;
        this.zzw();
        if (n10 >= 0 && n10 <= (n12 = this.size)) {
            int[] nArray = this.zzks;
            int n13 = nArray.length;
            if (n12 < n13) {
                n13 = n10 + 1;
                System.arraycopy(nArray, n10, nArray, n13, n12 -= n10);
            } else {
                n12 = n12 * 3 / 2 + 1;
                int[] nArray2 = new int[n12];
                System.arraycopy(nArray, 0, nArray2, 0, n10);
                nArray = this.zzks;
                n13 = n10 + 1;
                int n14 = this.size - n10;
                System.arraycopy(nArray, n10, nArray2, n13, n14);
                this.zzks = nArray2;
            }
            this.zzks[n10] = n11;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzh(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ void add(int n10, Object object) {
        int n11 = (Integer)object;
        this.zzo(n10, n11);
    }

    public final boolean addAll(Collection object) {
        this.zzw();
        zzci.checkNotNull(object);
        int n10 = object instanceof zzch;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzch)object;
        n10 = ((zzch)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            int[] nArray = this.zzks;
            n12 = nArray.length;
            if ((n11 += n10) > n12) {
                this.zzks = nArray = Arrays.copyOf(nArray, n11);
            }
            nArray = ((zzch)object).zzks;
            int[] nArray2 = this.zzks;
            int n13 = this.size;
            int n14 = ((zzch)object).size;
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

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof zzch;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzch)object;
        n10 = this.size;
        int n11 = ((zzch)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzch)object).zzks;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            int[] nArray = this.zzks;
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
        this.zzg(n10);
        return this.zzks[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            int[] nArray = this.zzks;
            n10 = nArray[i10];
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzw();
        this.zzg(n10);
        int[] nArray = this.zzks;
        int n11 = nArray[n10];
        int n12 = this.size;
        int n13 = n12 + -1;
        if (n10 < n13) {
            n13 = n10 + 1;
            System.arraycopy(nArray, n13, nArray, n10, n12 -= n10);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return n11;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzw();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            Integer n12 = this.zzks[i10];
            n10 = (int)(object.equals(n12) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzks;
            n11 = i10 + 1;
            n10 = this.size - i10;
            System.arraycopy(object, n11, object, i10, n10);
            int n13 = this.size;
            n11 = 1;
            this.size = n13 -= n11;
            this.modCount = n13 = this.modCount + n11;
            return n11 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzw();
        if (n11 >= n10) {
            int[] nArray = this.zzks;
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
        this.zzw();
        this.zzg(n10);
        int[] nArray = this.zzks;
        int n12 = nArray[n10];
        nArray[n10] = n11;
        return n12;
    }

    public final int size() {
        return this.size;
    }

    public final void zzac(int n10) {
        int n11 = this.size;
        this.zzo(n11, n10);
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            int[] nArray = Arrays.copyOf(this.zzks, n10);
            int n12 = this.size;
            zzch zzch2 = new zzch(nArray, n12);
            return zzch2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

