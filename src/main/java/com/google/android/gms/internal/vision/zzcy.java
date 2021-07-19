/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcv;
import com.google.android.gms.internal.vision.zzdd;
import com.google.android.gms.internal.vision.zzde;
import java.io.Serializable;

public abstract class zzcy
implements Serializable {
    public static zzcy zzb(Object object) {
        object = zzde.checkNotNull(object);
        zzdd zzdd2 = new zzdd(object);
        return zzdd2;
    }

    public static zzcy zzcb() {
        return zzcv.zzly;
    }

    public abstract Object get();

    public abstract boolean isPresent();
}

