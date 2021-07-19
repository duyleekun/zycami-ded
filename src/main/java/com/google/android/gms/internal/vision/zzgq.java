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

public final class zzgq
extends zzgi
implements zzik,
zzjz,
RandomAccess {
    private static final zzgq zzto;
    private int size;
    private boolean[] zztp;

    static {
        zzgq zzgq2;
        boolean[] blArray = new boolean[]{};
        zzto = zzgq2 = new zzgq(blArray, 0);
        zzgq2.zzej();
    }

    public zzgq() {
        boolean[] blArray = new boolean[10];
        this(blArray, 0);
    }

    private zzgq(boolean[] blArray, int n10) {
        this.zztp = blArray;
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
        object = (Boolean)object;
        boolean bl2 = (Boolean)object;
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            boolean[] blArray = this.zztp;
            int n12 = blArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(blArray, n10, blArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                boolean[] blArray2 = new boolean[n11];
                System.arraycopy(blArray, 0, blArray2, 0, n10);
                blArray = this.zztp;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(blArray, n10, blArray2, n12, n13);
                this.zztp = blArray2;
            }
            this.zztp[n10] = bl2;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final /* synthetic */ boolean add(Object object) {
        boolean bl2 = (Boolean)object;
        this.addBoolean(bl2);
        return true;
    }

    public final boolean addAll(Collection object) {
        this.zzek();
        zzie.checkNotNull(object);
        int n10 = object instanceof zzgq;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzgq)object;
        n10 = ((zzgq)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            boolean[] blArray = this.zztp;
            n12 = blArray.length;
            if ((n11 += n10) > n12) {
                this.zztp = blArray = Arrays.copyOf(blArray, n11);
            }
            blArray = ((zzgq)object).zztp;
            boolean[] blArray2 = this.zztp;
            int n13 = this.size;
            int n14 = ((zzgq)object).size;
            System.arraycopy(blArray, 0, blArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public final void addBoolean(boolean bl2) {
        this.zzek();
        int n10 = this.size;
        boolean[] blArray = this.zztp;
        int n11 = blArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            boolean[] blArray2 = new boolean[n11];
            System.arraycopy(blArray, 0, blArray2, 0, n10);
            this.zztp = blArray2;
        }
        boolean[] blArray3 = this.zztp;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        blArray3[n12] = bl2;
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
        int n10 = object instanceof zzgq;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzgq)object;
        n10 = this.size;
        int n11 = ((zzgq)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzgq)object).zztp;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            boolean[] blArray = this.zztp;
            n11 = blArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzal(n10);
        return this.zztp[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            boolean[] blArray = this.zztp;
            n10 = zzie.zzm(blArray[i10]);
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
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean[] blArray = this.zztp;
            boolean bl3 = blArray[i10];
            if (bl3 != bl2) continue;
            return i10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        boolean[] blArray = this.zztp;
        boolean bl2 = blArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(blArray, n12, blArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return bl2;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzek();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            Boolean bl2 = this.zztp[i10];
            n10 = (int)(object.equals(bl2) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zztp;
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
            boolean[] blArray = this.zztp;
            int n12 = this.size - n11;
            System.arraycopy(blArray, n11, blArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public final /* synthetic */ Object set(int n10, Object object) {
        boolean bl2 = (Boolean)object;
        this.zzek();
        this.zzal(n10);
        boolean[] blArray = this.zztp;
        boolean bl3 = blArray[n10];
        blArray[n10] = bl2;
        return bl3;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            boolean[] blArray = Arrays.copyOf(this.zztp, n10);
            int n12 = this.size;
            zzgq zzgq2 = new zzgq(blArray, n12);
            return zzgq2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

