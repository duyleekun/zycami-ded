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

public final class zzhl
extends zzgc
implements RandomAccess,
zzhz,
zzje {
    private static final zzhl zza;
    private float[] zzb;
    private int zzc;

    static {
        zzhl zzhl2;
        float[] fArray = new float[]{};
        zza = zzhl2 = new zzhl(fArray, 0);
        zzhl2.zzb();
    }

    public zzhl() {
        float[] fArray = new float[10];
        this(fArray, 0);
    }

    private zzhl(float[] fArray, int n10) {
        this.zzb = fArray;
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
        int n10 = object instanceof zzhl;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzhl)object;
        n10 = ((zzhl)object).zzc;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.zzc;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            float[] fArray = this.zzb;
            n12 = fArray.length;
            if ((n11 += n10) > n12) {
                this.zzb = fArray = Arrays.copyOf(fArray, n11);
            }
            fArray = ((zzhl)object).zzb;
            float[] fArray2 = this.zzb;
            int n13 = this.zzc;
            int n14 = ((zzhl)object).zzc;
            System.arraycopy(fArray, 0, fArray2, n13, n14);
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
        int n10 = object instanceof zzhl;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzhl)object;
        n10 = this.zzc;
        int n11 = ((zzhl)object).zzc;
        if (n10 != n11) {
            return false;
        }
        object = ((zzhl)object).zzb;
        for (n10 = 0; n10 < (n11 = this.zzc); ++n10) {
            Object object2;
            int n12;
            float[] fArray = this.zzb;
            float f10 = fArray[n10];
            n11 = Float.floatToIntBits(f10);
            if (n11 == (n12 = Float.floatToIntBits((float)(object2 = object[n10])))) continue;
            return false;
        }
        return bl2;
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.zzc); ++i10) {
            n11 *= 31;
            float[] fArray = this.zzb;
            float f10 = fArray[i10];
            n10 = Float.floatToIntBits(f10);
            n11 += n10;
        }
        return n11;
    }

    public final int indexOf(Object object) {
        int n10 = object instanceof Float;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Float)object;
        float f10 = ((Float)object).floatValue();
        n10 = this.zzc;
        for (int i10 = 0; i10 < n10; ++i10) {
            float[] fArray = this.zzb;
            float f11 = fArray[i10];
            float f12 = f11 - f10;
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 != false) continue;
            return i10;
        }
        return n11;
    }

    public final void removeRange(int n10, int n11) {
        this.zzbL();
        if (n11 >= n10) {
            float[] fArray = this.zzb;
            int n12 = this.zzc - n11;
            System.arraycopy(fArray, n11, fArray, n10, n12);
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

    public final void zzd(float f10) {
        this.zzbL();
        int n10 = this.zzc;
        float[] fArray = this.zzb;
        int n11 = fArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            float[] fArray2 = new float[n11];
            System.arraycopy(fArray, 0, fArray2, 0, n10);
            this.zzb = fArray2;
        }
        float[] fArray3 = this.zzb;
        int n12 = this.zzc;
        this.zzc = n11 = n12 + 1;
        fArray3[n12] = f10;
    }
}

