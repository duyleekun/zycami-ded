/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbn$zza;
import java.nio.ByteBuffer;

public final class zzbn$zzb
extends zzbn$zza {
    private final ByteBuffer zzga;
    private int zzgb;

    public zzbn$zzb(ByteBuffer byteBuffer) {
        int n10;
        byte[] byArray = byteBuffer.array();
        int n11 = byteBuffer.arrayOffset();
        int n12 = byteBuffer.position();
        n11 += n12;
        n12 = byteBuffer.remaining();
        super(byArray, n11, n12);
        this.zzga = byteBuffer;
        this.zzgb = n10 = byteBuffer.position();
    }

    public final void flush() {
        ByteBuffer byteBuffer = this.zzga;
        int n10 = this.zzgb;
        int n11 = this.zzai();
        byteBuffer.position(n10 += n11);
    }
}

