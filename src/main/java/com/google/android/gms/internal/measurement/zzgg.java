/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzje;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzgg
extends zzgc
implements RandomAccess,
zzhz,
zzje {
    private static final zzgg zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzgg zzgg2;
        boolean[] blArray = new boolean[]{};
        zza = zzgg2 = new zzgg(blArray, 0);
        zzgg2.zzb();
    }

    public zzgg() {
        boolean[] blArray = new boolean[10];
        this(blArray, 0);
    }

    private zzgg(boolean[] blArray, int n10) {
        this.zzb = blArray;
        this.zzc = n10;
    }

    private final void zzf(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzg(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzg(int n10) {
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
        int n10 = object instanceof zzgg;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzgg)object;
        n10 = ((zzgg)object).zzc;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.zzc;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            boolean[] blArray = this.zzb;
            n12 = blArray.length;
            if ((n11 += n10) > n12) {
                this.zzb = blArray = Arrays.copyOf(blArray, n11);
            }
            blArray = ((zzgg)object).zzb;
            boolean[] blArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzgg)object).zzc;
            System.arraycopy(blArray, 0, blArray2, n13, n14);
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
        int n10 = object instanceof zzgg;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzgg)object;
        n10 = this.zzc;
        int n11 = ((zzgg)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzgg)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            boolean[] blArray = this.zzb;
            n11 = blArray[n10];
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
            boolean[] blArray = this.zzb;
            n10 = zzia.zzf(blArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public final int indexOf(Object object) {
        int n10 = object instanceof Boolean;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Boolean)object;
        boolean bl2 = (Boolean)object;
        n10 = this.zzc;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean[] blArray = this.zzb;
            boolean bl3 = blArray[i10];
            if (bl3 != bl2) continue;
            return i10;
        }
        return n11;
    }

    public final void removeRange(int n10, int n11) {
        this.zzbL();
        if (n11 >= n10) {
            boolean[] blArray = this.zzb;
            int n12 = this.zzc - n11;
            System.arraycopy(blArray, n11, blArray, n10, n12);
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

    public final void zzd(boolean bl2) {
        this.zzbL();
        int n10 = this.zzc;
        boolean[] blArray = this.zzb;
        int n11 = blArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            boolean[] blArray2 = new boolean[n11];
            System.arraycopy(blArray, 0, blArray2, 0, n10);
            this.zzb = blArray2;
        }
        boolean[] blArray3 = this.zzb;
        int n12 = this.zzc;
        this.zzc = n11 = n12 + 1;
        blArray3[n12] = bl2;
    }
}

