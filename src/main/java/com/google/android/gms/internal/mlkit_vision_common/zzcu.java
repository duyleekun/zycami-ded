/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_common.zzag;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzcv;
import com.google.mlkit.common.sdkinternal.MlKitContext;

public final class zzcu {
    public static void zza(int n10, int n11, long l10, int n12, int n13, int n14, int n15) {
        zzcv zzcv2;
        long l11 = SystemClock.elapsedRealtime() - l10;
        Object object = zzcv2;
        zzcv2 = new zzcv(n10, n11, n14, n12, n13, l11, n15);
        zzcq zzcq2 = (zzcq)MlKitContext.getInstance().get(zzcq.class);
        object = zzag.zza;
        zzcq2.zza(zzcv2, (zzag)object);
    }
}

