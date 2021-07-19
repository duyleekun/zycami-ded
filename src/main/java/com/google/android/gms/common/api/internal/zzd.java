/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzc;

public final class zzd
implements Runnable {
    private final /* synthetic */ LifecycleCallback zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzc zzc;

    public zzd(zzc zzc2, LifecycleCallback lifecycleCallback, String string2) {
        this.zzc = zzc2;
        this.zza = lifecycleCallback;
        this.zzb = string2;
    }

    public final void run() {
        int n10;
        Object object = this.zzc;
        int n11 = com.google.android.gms.common.api.internal.zzc.zza((zzc)object);
        if (n11 > 0) {
            object = this.zza;
            Bundle bundle = com.google.android.gms.common.api.internal.zzc.zzb(this.zzc);
            if (bundle != null) {
                bundle = com.google.android.gms.common.api.internal.zzc.zzb(this.zzc);
                String string2 = this.zzb;
                bundle = bundle.getBundle(string2);
            } else {
                n10 = 0;
                bundle = null;
            }
            ((LifecycleCallback)object).onCreate(bundle);
        }
        if ((n11 = com.google.android.gms.common.api.internal.zzc.zza((zzc)(object = this.zzc))) >= (n10 = 2)) {
            object = this.zza;
            ((LifecycleCallback)object).onStart();
        }
        if ((n11 = com.google.android.gms.common.api.internal.zzc.zza((zzc)(object = this.zzc))) >= (n10 = 3)) {
            object = this.zza;
            ((LifecycleCallback)object).onResume();
        }
        if ((n11 = com.google.android.gms.common.api.internal.zzc.zza((zzc)(object = this.zzc))) >= (n10 = 4)) {
            object = this.zza;
            ((LifecycleCallback)object).onStop();
        }
        if ((n11 = com.google.android.gms.common.api.internal.zzc.zza((zzc)(object = this.zzc))) >= (n10 = 5)) {
            object = this.zza;
            ((LifecycleCallback)object).onDestroy();
        }
    }
}

