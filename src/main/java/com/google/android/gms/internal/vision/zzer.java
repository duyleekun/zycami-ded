/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzeu;
import com.google.android.gms.internal.vision.zzfa;
import java.util.Iterator;
import java.util.Map;

public final class zzer
extends zzej {
    private final transient int size;
    private final transient zzef zznc;
    private final transient Object[] zznd;
    private final transient int zznm;

    public zzer(zzef zzef2, Object[] objectArray, int n10, int n11) {
        this.zznc = zzef2;
        this.zznd = objectArray;
        this.zznm = 0;
        this.size = n11;
    }

    public static /* synthetic */ int zza(zzer zzer2) {
        return zzer2.size;
    }

    public static /* synthetic */ Object[] zzb(zzer zzer2) {
        return zzer2.zznd;
    }

    public final boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            zzef zzef2;
            boolean bl3;
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            if ((object = object.getValue()) != null && (bl3 = object.equals(object2 = (zzef2 = this.zznc).get(object2)))) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return ((zzeb)this).zzcp();
    }

    public final int size() {
        return this.size;
    }

    public final int zza(Object[] objectArray, int n10) {
        return ((zzeb)((zzeb)this).zzct()).zza(objectArray, n10);
    }

    public final zzfa zzcp() {
        return (zzfa)((zzeb)((zzeb)this).zzct()).iterator();
    }

    public final boolean zzcu() {
        return true;
    }

    public final zzee zzda() {
        zzeu zzeu2 = new zzeu(this);
        return zzeu2;
    }
}

