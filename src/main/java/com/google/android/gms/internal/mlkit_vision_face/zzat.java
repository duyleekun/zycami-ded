/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaq;
import com.google.android.gms.internal.mlkit_vision_face.zzk;

public final class zzat
extends zzk {
    private final zzaq zza;

    public zzat(zzaq zzaq2, int n10) {
        int n11 = zzaq2.size();
        super(n11, n10);
        this.zza = zzaq2;
    }

    public final Object zza(int n10) {
        return this.zza.get(n10);
    }
}

