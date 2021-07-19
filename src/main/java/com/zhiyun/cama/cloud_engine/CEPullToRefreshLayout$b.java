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

public class CEPullToRefreshLayout$b
extends Animation {
    public final /* synthetic */ CEPullToRefreshLayout a;

    public CEPullToRefreshLayout$b(CEPullToRefreshLayout cEPullToRefreshLayout) {
        this.a = cEPullToRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation object) {
        object = this.a;
        int n10 = object.w;
        int n11 = Math.abs(object.v);
        object = this.a;
        int n12 = object.u;
        int n13 = (int)((float)((n10 -= n11) - n12) * f10);
        n12 += n13;
        n13 = object.s.getTop();
        this.a.setTargetOffsetTopAndBottom(n12 -= n13);
    }
}

