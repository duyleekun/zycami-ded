/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.transformation.ExpandableBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior$1;

public abstract class ExpandableTransformationBehavior
extends ExpandableBehavior {
    private AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior expandableTransformationBehavior, AnimatorSet animatorSet) {
        expandableTransformationBehavior.currentAnimation = animatorSet;
        return animatorSet;
    }

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View var1, View var2, boolean var3, boolean var4);

    public boolean onExpandedStateChange(View view, View object, boolean bl2, boolean bl3) {
        AnimatorSet animatorSet = this.currentAnimation;
        boolean bl4 = true;
        boolean bl5 = animatorSet != null ? bl4 : false;
        if (bl5) {
            animatorSet.cancel();
        }
        view = this.onCreateExpandedStateChangeAnimation(view, (View)object, bl2, bl5);
        this.currentAnimation = view;
        object = new ExpandableTransformationBehavior$1(this);
        view.addListener((Animator.AnimatorListener)object);
        view = this.currentAnimation;
        view.start();
        if (!bl3) {
            view = this.currentAnimation;
            view.end();
        }
        return bl4;
    }
}

