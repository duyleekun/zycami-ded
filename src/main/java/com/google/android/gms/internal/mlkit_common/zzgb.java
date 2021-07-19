/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzga;
import com.google.android.gms.internal.mlkit_common.zzhb;
import java.io.IOException;

public class zzgb
extends IOException {
    private zzhb zza = null;

    public zzgb(String string2) {
        super(string2);
    }

    public static zzga zza() {
        zzga zzga2 = new zzga("Protocol message tag had invalid wire type.");
        return zzga2;
    }
}

