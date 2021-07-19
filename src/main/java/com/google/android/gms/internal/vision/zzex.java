/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzeo;
import com.google.android.gms.internal.vision.zzfa;
import java.util.Iterator;

public final class zzex
extends zzej {
    private final transient Object zznu;
    private transient int zznv;

    public zzex(Object object) {
        this.zznu = object = zzde.checkNotNull(object);
    }

    public zzex(Object object, int n10) {
        this.zznu = object;
        this.zznv = n10;
    }

    public final boolean contains(Object object) {
        return this.zznu.equals(object);
    }

    public final int hashCode() {
        int n10 = this.zznv;
        if (n10 == 0) {
            Object object = this.zznu;
            this.zznv = n10 = object.hashCode();
        }
        return n10;
    }

    public final /* synthetic */ Iterator iterator() {
        return ((zzeb)this).zzcp();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String string2 = this.zznu.toString();
        int n10 = String.valueOf(string2).length() + 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        stringBuilder.append(string2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final int zza(Object[] objectArray, int n10) {
        Object object;
        objectArray[n10] = object = this.zznu;
        return n10 + 1;
    }

    public final zzfa zzcp() {
        Object object = this.zznu;
        zzeo zzeo2 = new zzeo(object);
        return zzeo2;
    }

    public final boolean zzcu() {
        return false;
    }

    public final boolean zzcz() {
        int n10 = this.zznv;
        return n10 != 0;
    }

    public final zzee zzda() {
        return zzee.zzg(this.zznu);
    }
}

