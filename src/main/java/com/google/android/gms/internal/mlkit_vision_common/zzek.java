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

public final class zzek
extends zzde
implements zzes,
zzge,
RandomAccess {
    private static final zzek zza;
    private int[] zzb;
    private int zzc;

    static {
        zzek zzek2;
        int[] nArray = new int[]{};
        zza = zzek2 = new zzek(nArray, 0);
        zzek2.zzb();
    }

    public zzek() {
        int[] nArray = new int[10];
        this(nArray, 0);
    }

    private zzek(int[] nArray, int n10) {
        this.zzb = nArray;
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

    public static zzek zzd() {
        return zza;
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
        object = (Integer)object;
        int n12 = (Integer)object;
        this.zzc();
        if (n10 >= 0 && n10 <= (n11 = this.zzc)) {
            int[] nArray = this.zzb;
            int n13 = nArray.length;
            if (n11 < n13) {
                n13 = n10 + 1;
                System.arraycopy(nArray, n10, nArray, n13, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                int[] nArray2 = new int[n11];
                System.arraycopy(nArray, 0, nArray2, 0, n10);
                nArray = this.zzb;
                n13 = n10 + 1;
                int n14 = this.zzc - n10;
                System.arraycopy(nArray, n10, nArray2, n13, n14);
                this.zzb = nArray2;
            }
            this.zzb[n10] = n12;
            this.zzc = n10 = this.zzc + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzd(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        object = (Integer)object;
        int n10 = (Integer)object;
        this.zzc();
        int n11 = this.zzc;
        int[] nArray = this.zzb;
        int n12 = nArray.length;
        int n13 = 1;
        if (n11 == n12) {
            n12 = n11 * 3 / 2 + n13;
            int[] nArray2 = new int[n12];
            System.arraycopy(nArray, 0, nArray2, 0, n11);
            this.zzb = nArray2;
        }
        int[] nArray3 = this.zzb;
        int n14 = this.zzc;
        this.zzc = n12 = n14 + 1;
        nArray3[n14] = n10;
        return n13 != 0;
    }

    public final boolean addAll(Collection object) {
        this.zzc();
        zzem.zza(object);
        int n10 = object instanceof zzek;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzek)object;
        n10 = ((zzek)object).zzc;
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
            nArray = ((zzek)object).zzb;
            int[] nArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzek)object).zzc;
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
        int n10 = object instanceof zzek;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzek)object;
        n10 = this.zzc;
        int n11 = ((zzek)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzek)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            int[] nArray = this.zzb;
            n11 = nArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
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
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.zzb;
            int n13 = nArray[i10];
            if (n13 != n12) continue;
            return i10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzc();
        this.zzc(n10);
        int[] nArray = this.zzb;
        int n11 = nArray[n10];
        int n12 = this.zzc;
        int n13 = n12 + -1;
        if (n10 < n13) {
            n13 = n10 + 1;
            n12 = n12 - n10 + -1;
            System.arraycopy(nArray, n13, nArray, n10, n12);
        }
        this.zzc = n10 = this.zzc + -1;
        this.modCount = n10 = this.modCount + 1;
        return n11;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzc();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            int n12;
            Integer n13 = this.zzb[i10];
            n10 = (int)(object.equals(n13) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzb;
            n11 = i10 + 1;
            n10 = this.zzc - i10;
            int n14 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n14);
            this.zzc = n12 = this.zzc - n14;
            this.modCount = n12 = this.modCount + n14;
            return n14 != 0;
        }
        return false;
    }

    public final void removeRange(int n10, int n11) {
        this.zzc();
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

    public final /* synthetic */ Object set(int n10, Object object) {
        int n11 = (Integer)object;
        this.zzc();
        this.zzc(n10);
        int[] nArray = this.zzb;
        int n12 = nArray[n10];
        nArray[n10] = n11;
        return n12;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(int n10) {
        this.zzc(n10);
        return this.zzb[n10];
    }

    public final /* synthetic */ zzes zzb(int n10) {
        int n11 = this.zzc;
        if (n10 >= n11) {
            int[] nArray = Arrays.copyOf(this.zzb, n10);
            int n12 = this.zzc;
            zzek zzek2 = new zzek(nArray, n12);
            return zzek2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

