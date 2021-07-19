/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;

public final class zad
implements DeferredLifecycleHelper$zaa {
    private final /* synthetic */ ViewGroup val$container;
    private final /* synthetic */ DeferredLifecycleHelper zarj;
    private final /* synthetic */ Bundle zarl;
    private final /* synthetic */ FrameLayout zarm;
    private final /* synthetic */ LayoutInflater zarn;

    public zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zarj = deferredLifecycleHelper;
        this.zarm = frameLayout;
        this.zarn = layoutInflater;
        this.val$container = viewGroup;
        this.zarl = bundle;
    }

    public final int getState() {
        return 2;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zarm.removeAllViews();
        lifecycleDelegate = this.zarm;
        LifecycleDelegate lifecycleDelegate2 = DeferredLifecycleHelper.zab(this.zarj);
        LayoutInflater layoutInflater = this.zarn;
        ViewGroup viewGroup = this.val$container;
        Bundle bundle = this.zarl;
        lifecycleDelegate2 = lifecycleDelegate2.onCreateView(layoutInflater, viewGroup, bundle);
        lifecycleDelegate.addView((View)lifecycleDelegate2);
    }
}

