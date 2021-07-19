/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.phenotype;

import com.google.android.gms.phenotype.PhenotypeFlag;
import com.google.android.gms.phenotype.PhenotypeFlag$zza;

public final class zzq
implements PhenotypeFlag$zza {
    private final String zzav;
    private final boolean zzaw;

    public zzq(String string2, boolean bl2) {
        this.zzav = string2;
        this.zzaw = false;
    }

    public final Object zzh() {
        String string2 = this.zzav;
        boolean bl2 = this.zzaw;
        return PhenotypeFlag.zzb(string2, bl2);
    }
}

