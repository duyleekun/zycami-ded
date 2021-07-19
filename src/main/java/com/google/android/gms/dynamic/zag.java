/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;

public final class zag
implements DeferredLifecycleHelper$zaa {
    private final /* synthetic */ DeferredLifecycleHelper zarj;

    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zarj = deferredLifecycleHelper;
    }

    public final int getState() {
        return 5;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper.zab(this.zarj).onResume();
    }
}

