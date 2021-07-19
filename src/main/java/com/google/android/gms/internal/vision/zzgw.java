/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgv;
import com.google.android.gms.internal.vision.zzgy;
import java.util.Arrays;

public final class zzgw
implements zzgy {
    private zzgw() {
    }

    public /* synthetic */ zzgw(zzgv zzgv2) {
        this();
    }

    public final byte[] zzd(byte[] byArray, int n10, int n11) {
        return Arrays.copyOfRange(byArray, n10, n11 += n10);
    }
}

