/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfg;

public final class zzfj
extends zzfg {
    public final void zza(Throwable throwable) {
        throwable.printStackTrace();
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        throwable.addSuppressed(throwable2);
    }
}

