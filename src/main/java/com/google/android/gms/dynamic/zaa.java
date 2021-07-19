/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;

public final class zaa
implements OnDelegateCreatedListener {
    private final /* synthetic */ DeferredLifecycleHelper zarj;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zarj = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(LifecycleDelegate object) {
        boolean bl2;
        Object object2 = this.zarj;
        DeferredLifecycleHelper.zaa((DeferredLifecycleHelper)object2, (LifecycleDelegate)object);
        object = DeferredLifecycleHelper.zaa(this.zarj).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (DeferredLifecycleHelper$zaa)object.next();
            LifecycleDelegate lifecycleDelegate = DeferredLifecycleHelper.zab(this.zarj);
            object2.zaa(lifecycleDelegate);
        }
        DeferredLifecycleHelper.zaa(this.zarj).clear();
        DeferredLifecycleHelper.zaa(this.zarj, null);
    }
}

