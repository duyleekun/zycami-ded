/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;

public final class zab
implements DeferredLifecycleHelper$zaa {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ DeferredLifecycleHelper zarj;
    private final /* synthetic */ Bundle zark;
    private final /* synthetic */ Bundle zarl;

    public zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.zarj = deferredLifecycleHelper;
        this.val$activity = activity;
        this.zark = bundle;
        this.zarl = bundle2;
    }

    public final int getState() {
        return 0;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        lifecycleDelegate = DeferredLifecycleHelper.zab(this.zarj);
        Activity activity = this.val$activity;
        Bundle bundle = this.zark;
        Bundle bundle2 = this.zarl;
        lifecycleDelegate.onInflate(activity, bundle, bundle2);
    }
}

