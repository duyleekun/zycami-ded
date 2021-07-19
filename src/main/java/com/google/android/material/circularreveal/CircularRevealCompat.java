/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 */
package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.CircularRevealCompat$1;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealEvaluator;
import com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealProperty;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    public static Animator createCircularReveal(CircularRevealWidget object, float f10, float f11, float f12) {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo;
        Property property = CircularRevealWidget$CircularRevealProperty.CIRCULAR_REVEAL;
        Object object2 = CircularRevealWidget$CircularRevealEvaluator.CIRCULAR_REVEAL;
        int n10 = 1;
        Object[] objectArray = new CircularRevealWidget$RevealInfo[n10];
        objectArray[0] = circularRevealWidget$RevealInfo = new CircularRevealWidget$RevealInfo(f10, f11, f12);
        property = ObjectAnimator.ofObject((Object)object, (Property)property, (TypeEvaluator)object2, (Object[])objectArray);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            object2 = object.getRevealInfo();
            if (object2 != null) {
                float f13 = object2.radius;
                object = (View)object;
                int n13 = (int)f10;
                int n14 = (int)f11;
                object = ViewAnimationUtils.createCircularReveal((View)object, (int)n13, (int)n14, (float)f13, (float)f12);
                AnimatorSet animatorSet = new AnimatorSet();
                Animator[] animatorArray = new Animator[2];
                animatorArray[0] = property;
                animatorArray[n10] = object;
                animatorSet.playTogether(animatorArray);
                return animatorSet;
            }
            object = new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
            throw object;
        }
        return property;
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f10, float f11, float f12, float f13) {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo;
        Property property = CircularRevealWidget$CircularRevealProperty.CIRCULAR_REVEAL;
        TypeEvaluator typeEvaluator = CircularRevealWidget$CircularRevealEvaluator.CIRCULAR_REVEAL;
        int n10 = 2;
        Object[] objectArray = new CircularRevealWidget$RevealInfo[n10];
        objectArray[0] = circularRevealWidget$RevealInfo = new CircularRevealWidget$RevealInfo(f10, f11, f12);
        circularRevealWidget$RevealInfo = new CircularRevealWidget$RevealInfo(f10, f11, f13);
        int n11 = 1;
        objectArray[n11] = circularRevealWidget$RevealInfo;
        property = ObjectAnimator.ofObject((Object)circularRevealWidget, (Property)property, (TypeEvaluator)typeEvaluator, (Object[])objectArray);
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13) {
            circularRevealWidget = (View)circularRevealWidget;
            int n14 = (int)f10;
            int n15 = (int)f11;
            circularRevealWidget = ViewAnimationUtils.createCircularReveal((View)circularRevealWidget, (int)n14, (int)n15, (float)f12, (float)f13);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArray = new Animator[n10];
            animatorArray[0] = property;
            animatorArray[n11] = circularRevealWidget;
            animatorSet.playTogether(animatorArray);
            return animatorSet;
        }
        return property;
    }

    public static Animator.AnimatorListener createCircularRevealListener(CircularRevealWidget circularRevealWidget) {
        CircularRevealCompat$1 circularRevealCompat$1 = new CircularRevealCompat$1(circularRevealWidget);
        return circularRevealCompat$1;
    }
}

