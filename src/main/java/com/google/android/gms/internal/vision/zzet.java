/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzee;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzfa;
import java.util.Iterator;

public final class zzet
extends zzej {
    private final transient zzee zzmv;
    private final transient zzef zznc;

    public zzet(zzef zzef2, zzee zzee2) {
        this.zznc = zzef2;
        this.zzmv = zzee2;
    }

    public final boolean contains(Object object) {
        zzef zzef2 = this.zznc;
        return (object = zzef2.get(object)) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return ((zzeb)this).zzcp();
    }

    public final int size() {
        return this.zznc.size();
    }

    public final int zza(Object[] objectArray, int n10) {
        return ((zzeb)((zzeb)this).zzct()).zza(objectArray, n10);
    }

    public final zzfa zzcp() {
        return (zzfa)((zzeb)((zzeb)this).zzct()).iterator();
    }

    public final zzee zzct() {
        return this.zzmv;
    }

    public final boolean zzcu() {
        return true;
    }
}

