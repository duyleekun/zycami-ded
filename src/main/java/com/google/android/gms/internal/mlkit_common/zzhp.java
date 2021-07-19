/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzek;
import com.google.android.gms.internal.mlkit_common.zzfy;
import java.util.Arrays;
import java.util.RandomAccess;

public final class zzhp
extends zzek
implements RandomAccess {
    private static final zzhp zza;
    private Object[] zzb;
    private int zzc;

    static {
        zzhp zzhp2;
        Object[] objectArray = new Object[]{};
        zza = zzhp2 = new zzhp(objectArray, 0);
        zzhp2.b_();
    }

    public zzhp() {
        Object[] objectArray = new Object[10];
        this(objectArray, 0);
    }

    private zzhp(Object[] objectArray, int n10) {
        this.zzb = objectArray;
        this.zzc = n10;
    }

    private final void zza(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.zzc)) {
            return;
        }
        String string2 = this.zzc(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private final String zzc(int n10) {
        int n11 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public static zzhp zzd() {
        return zza;
    }

    public final void add(int n10, Object object) {
        int n11;
        this.zzc();
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
        String string2 = this.zzc(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final boolean add(Object object) {
        int n10;
        Object[] objectArray;
        this.zzc();
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
        this.zza(n10);
        return this.zzb[n10];
    }

    public final Object remove(int n10) {
        this.zzc();
        this.zza(n10);
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
        this.zzc();
        this.zza(n10);
        Object[] objectArray = this.zzb;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        this.modCount = n10 = this.modCount + 1;
        return object2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzfy zzb(int n10) {
        int n11 = this.zzc;
        if (n10 >= n11) {
            Object[] objectArray = Arrays.copyOf(this.zzb, n10);
            int n12 = this.zzc;
            zzhp zzhp2 = new zzhp(objectArray, n12);
            return zzhp2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

