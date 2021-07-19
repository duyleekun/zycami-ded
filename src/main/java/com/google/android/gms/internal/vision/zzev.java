/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzec;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzfa;
import java.util.Iterator;

public final class zzev
extends zzej {
    public static final zzev zznq;
    private final transient int mask;
    private final transient int size;
    private final transient Object[] zznr;
    private final transient Object[] zzns;
    private final transient int zznt;

    static {
        zzev zzev2;
        Object[] objectArray = new Object[]{};
        zznq = zzev2 = new zzev(objectArray, 0, null, 0, 0);
    }

    public zzev(Object[] objectArray, int n10, Object[] objectArray2, int n11, int n12) {
        this.zznr = objectArray;
        this.zzns = objectArray2;
        this.mask = n11;
        this.zznt = n10;
        this.size = n12;
    }

    public final boolean contains(Object object) {
        Object[] objectArray = this.zzns;
        if (object != null && objectArray != null) {
            int n10 = zzec.zzf(object);
            while (true) {
                int n11;
                Object object2;
                if ((object2 = objectArray[n10 &= (n11 = this.mask)]) == null) {
                    return false;
                }
                n11 = (int)(object2.equals(object) ? 1 : 0);
                if (n11 != 0) {
                    return true;
                }
                ++n10;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zznt;
    }

    public final /* synthetic */ Iterator iterator() {
        return ((zzeb)this).zzcp();
    }

    public final int size() {
        return this.size;
    }

    public final int zza(Object[] objectArray, int n10) {
        Object[] objectArray2 = this.zznr;
        int n11 = this.size;
        System.arraycopy(objectArray2, 0, objectArray, n10, n11);
        int n12 = this.size;
        return n10 + n12;
    }

    public final zzfa zzcp() {
        return (zzfa)((zzeb)((zzeb)this).zzct()).iterator();
    }

    public final Object[] zzcq() {
        return this.zznr;
    }

    public final int zzcr() {
        return 0;
    }

    public final int zzcs() {
        return this.size;
    }

    public final boolean zzcu() {
        return false;
    }

    public final boolean zzcz() {
        return true;
    }

    public final zzee zzda() {
        Object[] objectArray = this.zznr;
        int n10 = this.size;
        return zzee.zzb(objectArray, n10);
    }
}

