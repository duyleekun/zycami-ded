/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdr;
import com.google.android.gms.internal.mlkit_vision_common.zzdu;
import com.google.android.gms.internal.mlkit_vision_common.zzer;

public final class zzdt
extends zzdr {
    private final byte[] zza;
    private final boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg = -1 >>> 1;

    private zzdt(byte[] byArray, int n10, int n11, boolean bl2) {
        super(null);
        this.zza = byArray;
        this.zzc = n11 += n10;
        this.zze = n10;
        this.zzf = n10;
        this.zzb = bl2;
    }

    public /* synthetic */ zzdt(byte[] byArray, int n10, int n11, boolean bl2, zzdu zzdu2) {
        this(byArray, 0, n11, false);
    }

    public final int zza() {
        int n10 = this.zze;
        int n11 = this.zzf;
        return n10 - n11;
    }

    public final int zza(int n10) {
        if (n10 >= 0) {
            int n11 = ((zzdr)this).zza();
            if ((n10 += n11) <= (n11 = this.zzg)) {
                this.zzg = n10;
                int n12 = this.zzc;
                int n13 = this.zzd;
                this.zzc = n12 += n13;
                n13 = this.zzf;
                if ((n13 = n12 - n13) > n10) {
                    this.zzd = n13 -= n10;
                    this.zzc = n12 -= n13;
                } else {
                    n10 = 0;
                    Object var5_5 = null;
                    this.zzd = 0;
                }
                return n11;
            }
            zzer zzer2 = new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            throw zzer2;
        }
        zzer zzer3 = new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        throw zzer3;
    }
}

