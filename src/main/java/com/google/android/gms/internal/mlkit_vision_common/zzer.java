/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzeu;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import java.io.IOException;

public class zzer
extends IOException {
    private zzfr zza = null;

    public zzer(String string2) {
        super(string2);
    }

    public static zzeu zza() {
        zzeu zzeu2 = new zzeu("Protocol message tag had invalid wire type.");
        return zzeu2;
    }
}

