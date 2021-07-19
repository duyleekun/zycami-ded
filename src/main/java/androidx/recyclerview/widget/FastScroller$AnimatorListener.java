/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.FastScroller;

public class FastScroller$AnimatorListener
extends AnimatorListenerAdapter {
    private boolean mCanceled = false;
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$AnimatorListener(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onAnimationCancel(Animator animator2) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator object) {
        Object object2 = this.mCanceled;
        int n10 = 0;
        if (object2) {
            this.mCanceled = false;
            return;
        }
        object = (Float)this.this$0.mShowHideAnimator.getAnimatedValue();
        float f10 = ((Float)object).floatValue();
        float f11 = f10 - 0.0f;
        object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (!object2) {
            object = this.this$0;
            ((FastScroller)object).mAnimationState = 0;
            ((FastScroller)object).setState(0);
        } else {
            object = this.this$0;
            ((FastScroller)object).mAnimationState = n10 = 2;
            ((FastScroller)object).requestRedraw();
        }
    }
}

