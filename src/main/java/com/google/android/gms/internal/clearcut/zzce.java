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

public final class zzce
extends zzav
implements zzcn,
RandomAccess {
    private static final zzce zzjm;
    private int size;
    private float[] zzjn;

    static {
        zzce zzce2;
        zzjm = zzce2 = new zzce();
        zzce2.zzv();
    }

    public zzce() {
        float[] fArray = new float[10];
        this(fArray, 0);
    }

    private zzce(float[] fArray, int n10) {
        this.zzjn = fArray;
        this.size = n10;
    }

    private final void zzc(int n10, float f10) {
        int n11;
        this.zzw();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            float[] fArray = this.zzjn;
            int n12 = fArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(fArray, n10, fArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                float[] fArray2 = new float[n11];
                System.arraycopy(fArray, 0, fArray2, 0, n10);
                fArray = this.zzjn;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(fArray, n10, fArray2, n12, n13);
                this.zzjn = fArray2;
            }
            this.zzjn[n10] = f10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzh(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
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

    public final /* synthetic */ void add(int n10, Object object) {
        float f10 = ((Float)object).floatValue();
        this.zzc(n10, f10);
    }

    public final boolean addAll(Collection object) {
        this.zzw();
        zzci.checkNotNull(object);
        int n10 = object instanceof zzce;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzce)object;
        n10 = ((zzce)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            float[] fArray = this.zzjn;
            n12 = fArray.length;
            if ((n11 += n10) > n12) {
                this.zzjn = fArray = Arrays.copyOf(fArray, n11);
            }
            fArray = ((zzce)object).zzjn;
            float[] fArray2 = this.zzjn;
            int n13 = this.size;
            int n14 = ((zzce)object).size;
            System.arraycopy(fArray, 0, fArray2, n13, n14);
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
        int n10 = object instanceof zzce;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzce)object;
        n10 = this.size;
        int n11 = ((zzce)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzce)object).zzjn;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            float[] fArray = this.zzjn;
            float f10 = fArray[n10];
            Object object2 = object[n10];
            float f11 = f10 - object2;
            n11 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzg(n10);
        return Float.valueOf(this.zzjn[n10]);
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            float[] fArray = this.zzjn;
            float f10 = fArray[i10];
            n10 = Float.floatToIntBits(f10);
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzw();
        this.zzg(n10);
        float[] fArray = this.zzjn;
        float f10 = fArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            System.arraycopy(fArray, n12, fArray, n10, n11 -= n10);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return Float.valueOf(f10);
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzw();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            float f10 = this.zzjn[i10];
            Float f11 = Float.valueOf(f10);
            n10 = (int)(object.equals(f11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzjn;
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
            float[] fArray = this.zzjn;
            int n12 = this.size - n11;
            System.arraycopy(fArray, n11, fArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        float f10 = ((Float)object).floatValue();
        this.zzw();
        this.zzg(n10);
        float[] fArray = this.zzjn;
        float f11 = fArray[n10];
        fArray[n10] = f10;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f10) {
        int n10 = this.size;
        this.zzc(n10, f10);
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            float[] fArray = Arrays.copyOf(this.zzjn, n10);
            int n12 = this.size;
            zzce zzce2 = new zzce(fArray, n12);
            return zzce2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

