/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzif;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import com.google.android.gms.internal.mlkit_vision_face.zzii;
import com.google.android.gms.internal.mlkit_vision_face.zzin;
import java.util.Iterator;

public final class zzih
extends zzin {
    private final /* synthetic */ zzig zza;

    private zzih(zzig zzig2) {
        this.zza = zzig2;
        super(zzig2, null);
    }

    public /* synthetic */ zzih(zzig zzig2, zzif zzif2) {
        this(zzig2);
    }

    public final Iterator iterator() {
        zzig zzig2 = this.zza;
        zzii zzii2 = new zzii(zzig2, null);
        return zzii2;
    }
}

