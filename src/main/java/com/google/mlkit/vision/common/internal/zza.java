/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.mlkit.vision.common.internal.MobileVisionBase;

public final class zza
implements OnFailureListener {
    public static final OnFailureListener zza;

    static {
        zza zza2 = new zza();
        zza = zza2;
    }

    private zza() {
    }

    public final void onFailure(Exception exception) {
        MobileVisionBase.zza(exception);
    }
}

