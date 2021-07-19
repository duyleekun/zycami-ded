/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Transformation
 */
package com.zhiyun.cama.cloud_engine;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;

public class CEPullToRefreshLayout$c
extends Animation {
    public final /* synthetic */ CEPullToRefreshLayout a;

    public CEPullToRefreshLayout$c(CEPullToRefreshLayout cEPullToRefreshLayout) {
        this.a = cEPullToRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation transformation) {
        this.a.i(f10);
    }
}

