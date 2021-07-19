/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgn;
import java.util.Arrays;

public final class zzgl
implements zzgn {
    private zzgl() {
    }

    public /* synthetic */ zzgl(zzgi zzgi2) {
    }

    public final byte[] zza(byte[] byArray, int n10, int n11) {
        return Arrays.copyOfRange(byArray, n10, n11 += n10);
    }
}

