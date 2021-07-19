/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import java.util.Arrays;
import java.util.RandomAccess;

public final class zzjg
extends zzgc
implements RandomAccess {
    private static final zzjg zza;
    private Object[] zzb;
    private int zzc;

    static {
        zzjg zzjg2;
        Object[] objectArray = new Object[]{};
        zza = zzjg2 = new zzjg(objectArray, 0);
        zzjg2.zzb();
    }

    public zzjg() {
        Object[] objectArray = new Object[10];
        this(objectArray, 0);
    }

    private zzjg(Object[] objectArray, int n10) {
        this.zzb = objectArray;
        this.zzc = n10;
    }

    public static zzjg zzd() {
        return zza;
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

    public final void add(int n10, Object object) {
        int n11;
        this.zzbL();
        if (n10 >= 0 && n10 <= (n11 = this.zzc)) {
            Object[] objectArray = this.zzb;
            int n12 = objectArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(objectArray, n10, objectArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                Object[] objectArray2 = new Object[n11];
                System.arraycopy(objectArray, 0, objectArray2, 0, n10);
                objectArray = this.zzb;
                n12 = n10 + 1;
                int n13 = this.zzc - n10;
                System.arraycopy(objectArray, n10, objectArray2, n12, n13);
                this.zzb = objectArray2;
            }
            this.zzb[n10] = object;
            this.zzc = n10 = this.zzc + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzg(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final boolean add(Object object) {
        int n10;
        Object[] objectArray;
        this.zzbL();
        int n11 = this.zzc;
        Object[] objectArray2 = this.zzb;
        int n12 = objectArray2.length;
        int n13 = 1;
        if (n11 == n12) {
            n11 = n11 * 3 / 2 + n13;
            this.zzb = objectArray = Arrays.copyOf(objectArray2, n11);
        }
        objectArray = this.zzb;
        int n14 = this.zzc;
        this.zzc = n12 = n14 + 1;
        objectArray[n14] = object;
        this.modCount = n10 = this.modCount + n13;
        return n13 != 0;
    }

    public final Object get(int n10) {
        this.zzf(n10);
        return this.zzb[n10];
    }

    public final Object remove(int n10) {
        this.zzbL();
        this.zzf(n10);
        Object[] objectArray = this.zzb;
        Object object = objectArray[n10];
        int n11 = this.zzc;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(objectArray, n12, objectArray, n10, n11);
        }
        this.zzc = n10 = this.zzc + -1;
        this.modCount = n10 = this.modCount + 1;
        return object;
    }

    public final Object set(int n10, Object object) {
        this.zzbL();
        this.zzf(n10);
        Object[] objectArray = this.zzb;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        this.modCount = n10 = this.modCount + 1;
        return object2;
    }

    public final int size() {
        return this.zzc;
    }
}

