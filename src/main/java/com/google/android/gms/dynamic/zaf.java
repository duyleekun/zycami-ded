/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;

public final class zaf
implements DeferredLifecycleHelper$zaa {
    private final /* synthetic */ DeferredLifecycleHelper zarj;

    public zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zarj = deferredLifecycleHelper;
    }

    public final int getState() {
        return 4;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper.zab(this.zarj).onStart();
    }
}

