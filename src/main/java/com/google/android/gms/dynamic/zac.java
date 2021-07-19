/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;

public final class zac
implements DeferredLifecycleHelper$zaa {
    private final /* synthetic */ DeferredLifecycleHelper zarj;
    private final /* synthetic */ Bundle zarl;

    public zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zarj = deferredLifecycleHelper;
        this.zarl = bundle;
    }

    public final int getState() {
        return 1;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        lifecycleDelegate = DeferredLifecycleHelper.zab(this.zarj);
        Bundle bundle = this.zarl;
        lifecycleDelegate.onCreate(bundle);
    }
}

