/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.google.android.material.transformation.FabTransformationScrimBehavior$1;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0L;
    public static final long COLLAPSE_DURATION = 150L;
    public static final long EXPAND_DELAY = 75L;
    public static final long EXPAND_DURATION = 150L;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        MotionTiming motionTiming;
        long l10 = 150L;
        this.expandTiming = motionTiming = new MotionTiming(75, l10);
        this.collapseTiming = motionTiming = new MotionTiming(0L, l10);
    }

    public FabTransformationScrimBehavior(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        long l10 = 150L;
        super(75, l10);
        this.expandTiming = object;
        super(0L, l10);
        this.collapseTiming = object;
    }

    private void createScrimAnimation(View view, boolean bl2, boolean bl3, List list, List object) {
        object = bl2 ? this.expandTiming : this.collapseTiming;
        float f10 = 0.0f;
        int n10 = 1;
        if (bl2) {
            if (!bl3) {
                view.setAlpha(0.0f);
            }
            Property property = View.ALPHA;
            float[] fArray = new float[n10];
            fArray[0] = f10 = 1.0f;
            view = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])fArray);
        } else {
            Property property = View.ALPHA;
            float[] fArray = new float[n10];
            fArray[0] = 0.0f;
            view = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])fArray);
        }
        ((MotionTiming)object).apply((Animator)view);
        list.add(view);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public AnimatorSet onCreateExpandedStateChangeAnimation(View object, View view, boolean bl2, boolean bl3) {
        object = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.createScrimAnimation(view, bl2, bl3, (List)object, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, (List)object);
        object = new FabTransformationScrimBehavior$1(this, bl2, view);
        animatorSet.addListener((Animator.AnimatorListener)object);
        return animatorSet;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }
}

