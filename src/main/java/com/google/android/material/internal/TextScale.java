/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.internal.TextScale$1;

public class TextScale
extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(TransitionValues object) {
        Object object2 = ((TransitionValues)object).view;
        boolean bl2 = object2 instanceof TextView;
        if (bl2) {
            object2 = (TextView)object2;
            object = ((TransitionValues)object).values;
            float f10 = object2.getScaleX();
            object2 = Float.valueOf(f10);
            String string2 = PROPNAME_SCALE;
            object.put(string2, object2);
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup object, TransitionValues object2, TransitionValues object3) {
        boolean bl2;
        View view;
        boolean bl3;
        int n10 = 0;
        object = null;
        if (object2 != null && object3 != null && (bl3 = (view = ((TransitionValues)object2).view) instanceof TextView) && (bl2 = (view = ((TransitionValues)object3).view) instanceof TextView)) {
            float f10;
            int n11;
            float f11;
            view = (TextView)view;
            object2 = ((TransitionValues)object2).values;
            object3 = ((TransitionValues)object3).values;
            String string2 = PROPNAME_SCALE;
            Object v10 = object2.get(string2);
            int n12 = 1065353216;
            float f12 = 1.0f;
            if (v10 != null) {
                object2 = (Float)object2.get(string2);
                f11 = ((Float)object2).floatValue();
            } else {
                n11 = n12;
                f11 = f12;
            }
            v10 = object3.get(string2);
            if (v10 != null) {
                object3 = (Float)object3.get(string2);
                f12 = ((Float)object3).floatValue();
            }
            if ((f10 = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1)) == false) {
                return null;
            }
            n10 = 2;
            object = new float[n10];
            f10 = 0.0f;
            object3 = null;
            object[0] = (ViewGroup)f11;
            n11 = 1;
            f11 = Float.MIN_VALUE;
            object[n11] = (ViewGroup)f12;
            object = ValueAnimator.ofFloat((float[])object);
            object2 = new TextScale$1(this, (TextView)view);
            object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
        }
        return object;
    }
}

