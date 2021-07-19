/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzgl;
import com.google.android.gms.internal.mlkit_vision_common.zzgm;
import com.google.android.gms.internal.mlkit_vision_common.zzgo;
import com.google.android.gms.internal.mlkit_vision_common.zzgt;
import java.util.Iterator;

public final class zzgn
extends zzgt {
    private final /* synthetic */ zzgm zza;

    private zzgn(zzgm zzgm2) {
        this.zza = zzgm2;
        super(zzgm2, null);
    }

    public /* synthetic */ zzgn(zzgm zzgm2, zzgl zzgl2) {
        this(zzgm2);
    }

    public final Iterator iterator() {
        zzgm zzgm2 = this.zza;
        zzgo zzgo2 = new zzgo(zzgm2, null);
        return zzgo2;
    }
}

