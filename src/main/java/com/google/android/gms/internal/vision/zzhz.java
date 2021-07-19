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

public final class zzhz
extends zzgi
implements zzik,
zzjz,
RandomAccess {
    private static final zzhz zzxm;
    private int size;
    private float[] zzxn;

    static {
        zzhz zzhz2;
        float[] fArray = new float[]{};
        zzxm = zzhz2 = new zzhz(fArray, 0);
        zzhz2.zzej();
    }

    public zzhz() {
        float[] fArray = new float[10];
        this(fArray, 0);
    }

    private zzhz(float[] fArray, int n10) {
        this.zzxn = fArray;
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
        object = (Float)object;
        float f10 = ((Float)object).floatValue();
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            float[] fArray = this.zzxn;
            int n12 = fArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(fArray, n10, fArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                float[] fArray2 = new float[n11];
                System.arraycopy(fArray, 0, fArray2, 0, n10);
                fArray = this.zzxn;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(fArray, n10, fArray2, n12, n13);
                this.zzxn = fArray2;
            }
            this.zzxn[n10] = f10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        float f10 = ((Float)object).floatValue();
        this.zzu(f10);
        return true;
    }

    public final boolean addAll(Collection object) {
        this.zzek();
        zzie.checkNotNull(object);
        int n10 = object instanceof zzhz;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzhz)object;
        n10 = ((zzhz)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            float[] fArray = this.zzxn;
            n12 = fArray.length;
            if ((n11 += n10) > n12) {
                this.zzxn = fArray = Arrays.copyOf(fArray, n11);
            }
            fArray = ((zzhz)object).zzxn;
            float[] fArray2 = this.zzxn;
            int n13 = this.size;
            int n14 = ((zzhz)object).size;
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
        int n10 = object instanceof zzhz;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzhz)object;
        n10 = this.size;
        int n11 = ((zzhz)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzhz)object).zzxn;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            Object object2;
            int n12;
            float[] fArray = this.zzxn;
            float f10 = fArray[n10];
            n11 = Float.floatToIntBits(f10);
            if (n11 == (n12 = Float.floatToIntBits((float)(object2 = object[n10])))) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzal(n10);
        return Float.valueOf(this.zzxn[n10]);
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            float[] fArray = this.zzxn;
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
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            float[] fArray = this.zzxn;
            float f11 = fArray[i10];
            float f12 = f11 - f10;
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 != false) continue;
            return i10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        float[] fArray = this.zzxn;
        float f10 = fArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(fArray, n12, fArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return Float.valueOf(f10);
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzek();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            float f10 = this.zzxn[i10];
            Float f11 = Float.valueOf(f10);
            n10 = (int)(object.equals(f11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzxn;
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
            float[] fArray = this.zzxn;
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
        this.zzek();
        this.zzal(n10);
        float[] fArray = this.zzxn;
        float f11 = fArray[n10];
        fArray[n10] = f10;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            float[] fArray = Arrays.copyOf(this.zzxn, n10);
            int n12 = this.size;
            zzhz zzhz2 = new zzhz(fArray, n12);
            return zzhz2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public final void zzu(float f10) {
        this.zzek();
        int n10 = this.size;
        float[] fArray = this.zzxn;
        int n11 = fArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            float[] fArray2 = new float[n11];
            System.arraycopy(fArray, 0, fArray2, 0, n10);
            this.zzxn = fArray2;
        }
        float[] fArray3 = this.zzxn;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        fArray3[n12] = f10;
    }
}

