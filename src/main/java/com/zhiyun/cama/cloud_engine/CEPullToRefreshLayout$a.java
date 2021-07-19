/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package com.zhiyun.cama.cloud_engine;

import android.view.animation.Animation;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;
import d.v.c.t0.b0;

public class CEPullToRefreshLayout$a
implements Animation.AnimationListener {
    public final /* synthetic */ CEPullToRefreshLayout a;

    public CEPullToRefreshLayout$a(CEPullToRefreshLayout cEPullToRefreshLayout) {
        this.a = cEPullToRefreshLayout;
    }

    public void onAnimationEnd(Animation object) {
        object = this.a;
        int n10 = ((CEPullToRefreshLayout)object).c;
        if (n10 != 0) {
            n10 = ((CEPullToRefreshLayout)object).x;
            if (n10 != 0 && (object = ((CEPullToRefreshLayout)object).b) != null) {
                object.onRefresh();
            }
            object = this.a;
            b0 b02 = ((CEPullToRefreshLayout)object).s;
            ((CEPullToRefreshLayout)object).l = n10 = b02.getTop();
        } else {
            ((CEPullToRefreshLayout)object).k();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

