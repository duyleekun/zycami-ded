/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 */
package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.chad.library.adapter.base.animation.BaseAnimation;
import f.h2.t.f0;

public final class SlideInBottomAnimation
implements BaseAnimation {
    public Animator[] animators(View view) {
        float f10;
        f0.q(view, "view");
        Object object = new float[2];
        object[0] = f10 = (float)view.getMeasuredHeight();
        int n10 = 1;
        object[n10] = 0.0f;
        view = ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])object);
        f0.h(view, "animator");
        view.setDuration(400L);
        object = new DecelerateInterpolator;
        object(1.3f);
        view.setInterpolator((TimeInterpolator)object);
        object = new Animator[n10];
        object[0] = (float)view;
        return object;
    }
}

