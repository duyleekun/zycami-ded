/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbc;
import com.google.android.gms.internal.clearcut.zzbf;
import java.util.Arrays;

public final class zzbd
implements zzbf {
    private zzbd() {
    }

    public /* synthetic */ zzbd(zzbc zzbc2) {
        this();
    }

    public final byte[] zzc(byte[] byArray, int n10, int n11) {
        return Arrays.copyOfRange(byArray, n10, n11 += n10);
    }
}

