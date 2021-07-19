/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfc;
import com.google.android.gms.internal.mlkit_vision_face.zzfj;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;

public final class zzfh {
    private final zzfq zza;
    private final byte[] zzb;

    private zzfh(int n10) {
        Object object = new byte[n10];
        this.zzb = object;
        object = zzfq.zza(object);
        this.zza = object;
    }

    public /* synthetic */ zzfh(int n10, zzfc zzfc2) {
        this(n10);
    }

    public final zzez zza() {
        this.zza.zzb();
        byte[] byArray = this.zzb;
        zzfj zzfj2 = new zzfj(byArray);
        return zzfj2;
    }

    public final zzfq zzb() {
        return this.zza;
    }
}

