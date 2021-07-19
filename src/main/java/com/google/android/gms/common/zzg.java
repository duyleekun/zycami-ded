/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzd;
import java.util.Arrays;

public final class zzg
extends zzd {
    private final byte[] zza;

    public zzg(byte[] byArray) {
        byte[] byArray2 = Arrays.copyOfRange(byArray, 0, 25);
        super(byArray2);
        this.zza = byArray;
    }

    public final byte[] zza() {
        return this.zza;
    }
}

