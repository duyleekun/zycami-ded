/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzag;
import com.google.android.gms.internal.mlkit_common.zze;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.android.gms.internal.mlkit_common.zzy;
import java.util.Objects;

public final class zzg {
    private final zzag zza;
    private Boolean zzb;
    private boolean zzc;

    private zzg() {
        zzag zzag2;
        this.zza = zzag2 = zzad.zze();
        this.zzc = false;
    }

    public /* synthetic */ zzg(zze zze2) {
        this();
    }

    public final zzg zza() {
        boolean bl2;
        Boolean bl3 = this.zzb;
        if (bl3 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            bl3 = null;
        }
        zzy.zza(bl2, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = bl3 = Boolean.TRUE;
        return this;
    }

    public final zzg zzb() {
        boolean bl2;
        Boolean bl3 = this.zzb;
        if (bl3 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            bl3 = null;
        }
        zzy.zza(bl2, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = bl3 = Boolean.FALSE;
        return this;
    }

    public final zzh zzc() {
        Objects.requireNonNull(this.zzb, "Must call internal() or external() when building a SourcePolicy.");
        boolean bl2 = this.zzb;
        zzad zzad2 = this.zza.zza();
        zzh zzh2 = new zzh(bl2, false, zzad2, null);
        return zzh2;
    }
}

