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

public final class zzaz
extends zzav
implements zzcn,
RandomAccess {
    private static final zzaz zzfg;
    private int size;
    private boolean[] zzfh;

    static {
        zzaz zzaz2;
        zzfg = zzaz2 = new zzaz();
        zzaz2.zzv();
    }

    public zzaz() {
        boolean[] blArray = new boolean[10];
        this(blArray, 0);
    }

    private zzaz(boolean[] blArray, int n10) {
        this.zzfh = blArray;
        this.size = n10;
    }

    private final void zza(int n10, boolean bl2) {
        int n11;
        this.zzw();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            boolean[] blArray = this.zzfh;
            int n12 = blArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(blArray, n10, blArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                boolean[] blArray2 = new boolean[n11];
                System.arraycopy(blArray, 0, blArray2, 0, n10);
                blArray = this.zzfh;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(blArray, n10, blArray2, n12, n13);
                this.zzfh = blArray2;
            }
            this.zzfh[n10] = bl2;
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
        boolean bl2 = (Boolean)object;
        this.zza(n10, bl2);
    }

    public final boolean addAll(Collection object) {
        this.zzw();
        zzci.checkNotNull(object);
        int n10 = object instanceof zzaz;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (zzaz)object;
        n10 = ((zzaz)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            boolean[] blArray = this.zzfh;
            n12 = blArray.length;
            if ((n11 += n10) > n12) {
                this.zzfh = blArray = Arrays.copyOf(blArray, n11);
            }
            blArray = ((zzaz)object).zzfh;
            boolean[] blArray2 = this.zzfh;
            int n13 = this.size;
            int n14 = ((zzaz)object).size;
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
        int n10 = this.size;
        this.zza(n10, bl2);
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof zzaz;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (zzaz)object;
        n10 = this.size;
        int n11 = ((zzaz)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((zzaz)object).zzfh;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            boolean[] blArray = this.zzfh;
            n11 = blArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public final /* synthetic */ Object get(int n10) {
        this.zzg(n10);
        return this.zzfh[n10];
    }

    public final int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            boolean[] blArray = this.zzfh;
            n10 = zzci.zzc(blArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public final /* synthetic */ Object remove(int n10) {
        this.zzw();
        this.zzg(n10);
        boolean[] blArray = this.zzfh;
        boolean bl2 = blArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            System.arraycopy(blArray, n12, blArray, n10, n11 -= n10);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return bl2;
    }

    public final boolean remove(Object object) {
        int n10;
        this.zzw();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            Boolean bl2 = this.zzfh[i10];
            n10 = (int)(object.equals(bl2) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.zzfh;
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
            boolean[] blArray = this.zzfh;
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
        this.zzw();
        this.zzg(n10);
        boolean[] blArray = this.zzfh;
        boolean bl3 = blArray[n10];
        blArray[n10] = bl2;
        return bl3;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzcn zzi(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            boolean[] blArray = Arrays.copyOf(this.zzfh, n10);
            int n12 = this.size;
            zzaz zzaz2 = new zzaz(blArray, n12);
            return zzaz2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

