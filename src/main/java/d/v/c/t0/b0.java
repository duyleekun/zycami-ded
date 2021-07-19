/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.ProgressBar
 */
package d.v.c.t0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import d.v.e.l.h2;
import d.v.e.l.o1;

public class b0
extends ProgressBar {
    private Animation.AnimationListener a;

    public b0(Context context) {
        this(context, null);
    }

    public b0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = o1.m(context, 2131230814);
        this.setIndeterminateDrawable((Drawable)context);
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.a;
        if (animationListener != null) {
            Animation animation = this.getAnimation();
            animationListener.onAnimationEnd(animation);
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.a;
        if (animationListener != null) {
            Animation animation = this.getAnimation();
            animationListener.onAnimationStart(animation);
        }
    }

    public void onMeasure(int n10, int n11) {
        synchronized (this) {
            n10 = 1112014848;
            float f10 = 50.0f;
            n10 = h2.b(f10);
            n11 = 1096810496;
            float f11 = 14.0f;
            n11 = h2.b(f11);
            this.setMeasuredDimension(n10, n11);
            return;
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.a = animationListener;
    }
}

