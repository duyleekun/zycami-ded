/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzkj;

public final class zzhc
implements zzkj {
    public final /* synthetic */ zzhn zza;

    public zzhc(zzhn zzhn2) {
        this.zza = zzhn2;
    }

    public final void zza(String string2, Bundle bundle) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            zzhn zzhn2 = this.zza;
            zzfl.zzP();
            long l10 = zzhn2.zzx.zzax().currentTimeMillis();
            zzhn2.zzx("auto", "_err", l10, bundle, false, true, false, string2);
            return;
        }
        this.zza.zzs("auto", "_err", bundle);
    }
}

