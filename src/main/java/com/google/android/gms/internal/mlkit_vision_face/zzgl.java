/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgo;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import java.io.IOException;

public class zzgl
extends IOException {
    private zzhl zza = null;

    public zzgl(String string2) {
        super(string2);
    }

    public static zzgo zza() {
        zzgo zzgo2 = new zzgo("Protocol message tag had invalid wire type.");
        return zzgo2;
    }
}

