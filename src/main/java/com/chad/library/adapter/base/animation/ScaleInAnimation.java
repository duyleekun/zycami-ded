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
import com.chad.library.adapter.base.animation.ScaleInAnimation$Companion;
import f.h2.t.f0;
import f.h2.t.u;

public final class ScaleInAnimation
implements BaseAnimation {
    public static final ScaleInAnimation$Companion Companion;
    private static final float DEFAULT_SCALE_FROM = 0.5f;
    private final float mFrom;

    static {
        ScaleInAnimation$Companion scaleInAnimation$Companion;
        Companion = scaleInAnimation$Companion = new ScaleInAnimation$Companion(null);
    }

    public ScaleInAnimation() {
        this(0.0f, 1, null);
    }

    public ScaleInAnimation(float f10) {
        this.mFrom = f10;
    }

    public /* synthetic */ ScaleInAnimation(float f10, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            f10 = 0.5f;
        }
        this(f10);
    }

    public Animator[] animators(View view) {
        float f10;
        float f11;
        f0.q(view, "view");
        int n10 = 2;
        Object object = new float[n10];
        object[0] = f11 = this.mFrom;
        int n11 = 1;
        object[n11] = f10 = 1.0f;
        String string2 = "scaleX";
        object = ObjectAnimator.ofFloat((Object)view, (String)string2, (float[])object);
        f0.h(object, string2);
        long l10 = 300L;
        object.setDuration(l10);
        Object object2 = new DecelerateInterpolator();
        object.setInterpolator((TimeInterpolator)object2);
        object2 = new float[n10];
        float f12 = this.mFrom;
        object2[0] = (DecelerateInterpolator)f12;
        object2[n11] = (DecelerateInterpolator)f10;
        String string3 = "scaleY";
        view = ObjectAnimator.ofFloat((Object)view, (String)string3, (float[])object2);
        f0.h(view, string3);
        view.setDuration(l10);
        string3 = new DecelerateInterpolator();
        view.setInterpolator((TimeInterpolator)string3);
        Animator[] animatorArray = new Animator[n10];
        animatorArray[0] = (Animator)object;
        animatorArray[n11] = view;
        return animatorArray;
    }
}

