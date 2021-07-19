/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.CircularPropagation;
import androidx.transition.R$id;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;
import androidx.transition.Visibility;

public class Explode
extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate;
    private static final TimeInterpolator sDecelerate;
    private int[] mTempLoc;

    static {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        sDecelerate = decelerateInterpolator;
        decelerateInterpolator = new AccelerateInterpolator();
        sAccelerate = decelerateInterpolator;
    }

    public Explode() {
        Object object = new int[2];
        this.mTempLoc = object;
        object = new CircularPropagation;
        this.setPropagation((TransitionPropagation)object);
    }

    public Explode(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        object = new int[2];
        this.mTempLoc = (int[])object;
        super();
        this.setPropagation((TransitionPropagation)object);
    }

    private static float calculateDistance(float f10, float f11) {
        f10 *= f10;
        f11 *= f11;
        return (float)Math.sqrt(f10 + f11);
    }

    private static float calculateMaxDistance(View view, int n10, int n11) {
        int n12 = view.getWidth() - n10;
        n10 = Math.max(n10, n12);
        int n13 = view.getHeight() - n11;
        n13 = Math.max(n11, n13);
        float f10 = n10;
        float f11 = n13;
        return Explode.calculateDistance(f10, f11);
    }

    private void calculateOut(View view, Rect rect, int[] nArray) {
        int n10;
        float f10;
        int n11;
        float f11;
        int n12;
        int n13;
        View view2 = view;
        int[] nArray2 = this.mTempLoc;
        view.getLocationOnScreen(nArray2);
        nArray2 = this.mTempLoc;
        int n14 = nArray2[0];
        int n15 = 1;
        int n16 = nArray2[n15];
        Rect rect2 = this.getEpicenter();
        if (rect2 == null) {
            n13 = view.getWidth() / 2 + n14;
            float f12 = view.getTranslationX();
            n12 = Math.round(f12);
            n13 += n12;
            n12 = view.getHeight() / 2 + n16;
            f11 = view.getTranslationY();
            n11 = Math.round(f11);
            n12 += n11;
        } else {
            n12 = rect2.centerX();
            n13 = rect2.centerY();
            int n17 = n12;
            n12 = n13;
            n13 = n17;
        }
        n11 = rect.centerX();
        int n18 = rect.centerY();
        f11 = n11 -= n13;
        float f13 = n18 -= n12;
        boolean bl2 = false;
        float f14 = 0.0f;
        float f15 = f11 - 0.0f;
        float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (f16 == false && !(bl2 = (f10 = f13 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) {
            double d10 = Math.random();
            double d11 = 2.0;
            f11 = (float)(d10 *= d11);
            n18 = 1065353216;
            f13 = 1.0f;
            f11 -= f13;
            double d12 = Math.random() * d11;
            f14 = (float)d12;
            f13 = f14 - f13;
        }
        f14 = Explode.calculateDistance(f11, f13);
        float f17 = Explode.calculateMaxDistance(view2, n13 -= n14, n12 -= n16);
        nArray[0] = n16 = Math.round((f11 /= f14) * f17);
        nArray[n15] = n10 = Math.round(f17 * (f13 /= f14));
    }

    private void captureValues(TransitionValues object) {
        View view = ((TransitionValues)object).view;
        int[] nArray = this.mTempLoc;
        view.getLocationOnScreen(nArray);
        nArray = this.mTempLoc;
        int n10 = nArray[0];
        int n11 = nArray[1];
        int n12 = view.getWidth() + n10;
        int n13 = view.getHeight() + n11;
        object = ((TransitionValues)object).values;
        Rect rect = new Rect(n10, n11, n12, n13);
        object.put(PROPNAME_SCREEN_BOUNDS, rect);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup object, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        transitionValues = (Rect)transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float f10 = view.getTranslationX();
        float f11 = view.getTranslationY();
        Object object2 = this.mTempLoc;
        this.calculateOut((View)object, (Rect)transitionValues, (int[])object2);
        object = this.mTempLoc;
        float f12 = (float)object[0];
        float f13 = f10 + f12;
        float f14 = (float)object[1];
        float f15 = f11 + f14;
        int n10 = ((Rect)transitionValues).left;
        int n11 = ((Rect)transitionValues).top;
        TimeInterpolator timeInterpolator = sDecelerate;
        object2 = view;
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, n10, n11, f13, f15, f10, f11, timeInterpolator, this);
    }

    public Animator onDisappear(ViewGroup object, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f10;
        float f11;
        if (transitionValues == null) {
            return null;
        }
        transitionValues2 = (Rect)transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int n10 = ((Rect)transitionValues2).left;
        int n11 = ((Rect)transitionValues2).top;
        float f12 = view.getTranslationX();
        float f13 = view.getTranslationY();
        Object object2 = transitionValues.view;
        int n12 = R$id.transition_position;
        object2 = (int[])object2.getTag(n12);
        n12 = 1;
        float f14 = 0.0f;
        if (object2 != null) {
            View view2 = object2[0];
            Object object3 = ((Rect)transitionValues2).left;
            reference var12_13 = view2 - object3;
            f11 = (float)var12_13 + f12;
            object3 = object2[n12];
            Object object4 = ((Rect)transitionValues2).top;
            f10 = (float)(object3 -= object4) + f13;
            object4 = object2[0];
            View view3 = object2[n12];
            transitionValues2.offsetTo((int)object4, (int)view3);
        } else {
            f11 = f12;
            f10 = f13;
        }
        object2 = this.mTempLoc;
        this.calculateOut((View)object, (Rect)transitionValues2, (int[])object2);
        object = this.mTempLoc;
        float f15 = (float)object[0];
        f14 = f11 + f15;
        float f16 = (float)object[n12];
        f11 = f10 + f16;
        TimeInterpolator timeInterpolator = sAccelerate;
        object2 = view;
        return TranslationAnimationCreator.createAnimation(view, transitionValues, n10, n11, f12, f13, f14, f11, timeInterpolator, this);
    }
}

