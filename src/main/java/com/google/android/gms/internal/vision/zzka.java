/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.internal.vision.zzik;
import java.util.Arrays;
import java.util.RandomAccess;

public final class zzka
extends zzgi
implements RandomAccess {
    private static final zzka zzabg;
    private int size;
    private Object[] zznl;

    static {
        zzka zzka2;
        Object[] objectArray = new Object[]{};
        zzabg = zzka2 = new zzka(objectArray, 0);
        zzka2.zzej();
    }

    public zzka() {
        Object[] objectArray = new Object[10];
        this(objectArray, 0);
    }

    private zzka(Object[] objectArray, int n10) {
        this.zznl = objectArray;
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

    public static zzka zzij() {
        return zzabg;
    }

    public final void add(int n10, Object object) {
        int n11;
        this.zzek();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            Object[] objectArray = this.zznl;
            int n12 = objectArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(objectArray, n10, objectArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                Object[] objectArray2 = new Object[n11];
                System.arraycopy(objectArray, 0, objectArray2, 0, n10);
                objectArray = this.zznl;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(objectArray, n10, objectArray2, n12, n13);
                this.zznl = objectArray2;
            }
            this.zznl[n10] = object;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.zzam(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final boolean add(Object object) {
        int n10;
        Object[] objectArray;
        this.zzek();
        int n11 = this.size;
        Object[] objectArray2 = this.zznl;
        int n12 = objectArray2.length;
        int n13 = 1;
        if (n11 == n12) {
            n11 = n11 * 3 / 2 + n13;
            this.zznl = objectArray = Arrays.copyOf(objectArray2, n11);
        }
        objectArray = this.zznl;
        int n14 = this.size;
        this.size = n12 = n14 + 1;
        objectArray[n14] = object;
        this.modCount = n10 = this.modCount + n13;
        return n13 != 0;
    }

    public final Object get(int n10) {
        this.zzal(n10);
        return this.zznl[n10];
    }

    public final Object remove(int n10) {
        this.zzek();
        this.zzal(n10);
        Object[] objectArray = this.zznl;
        Object object = objectArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(objectArray, n12, objectArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return object;
    }

    public final Object set(int n10, Object object) {
        this.zzek();
        this.zzal(n10);
        Object[] objectArray = this.zznl;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        this.modCount = n10 = this.modCount + 1;
        return object2;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzik zzan(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            Object[] objectArray = Arrays.copyOf(this.zznl, n10);
            int n12 = this.size;
            zzka zzka2 = new zzka(objectArray, n12);
            return zzka2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}

