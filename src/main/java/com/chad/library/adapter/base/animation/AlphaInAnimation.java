/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.view.View
 *  android.view.animation.LinearInterpolator
 */
package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.chad.library.adapter.base.animation.AlphaInAnimation$Companion;
import com.chad.library.adapter.base.animation.BaseAnimation;
import f.h2.t.f0;
import f.h2.t.u;

public final class AlphaInAnimation
implements BaseAnimation {
    public static final AlphaInAnimation$Companion Companion;
    private static final float DEFAULT_ALPHA_FROM;
    private final float mFrom;

    static {
        AlphaInAnimation$Companion alphaInAnimation$Companion;
        Companion = alphaInAnimation$Companion = new AlphaInAnimation$Companion(null);
    }

    public AlphaInAnimation() {
        this(0.0f, 1, null);
    }

    public AlphaInAnimation(float f10) {
        this.mFrom = f10;
    }

    public /* synthetic */ AlphaInAnimation(float f10, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            f10 = 0.0f;
        }
        this(f10);
    }

    public Animator[] animators(View view) {
        float f10;
        f0.q(view, "view");
        Object object = new float[2];
        object[0] = f10 = this.mFrom;
        int n10 = 1;
        object[n10] = 1.0f;
        view = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])object);
        f0.h(view, "animator");
        view.setDuration(300L);
        object = new LinearInterpolator;
        object();
        view.setInterpolator((TimeInterpolator)object);
        object = new Animator[n10];
        object[0] = (float)view;
        return object;
    }
}

