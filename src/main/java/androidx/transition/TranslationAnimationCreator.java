/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.AnimatorUtils;
import androidx.transition.R$id;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator$TransitionPositionListener;

public class TranslationAnimationCreator {
    private TranslationAnimationCreator() {
    }

    public static Animator createAnimation(View view, TransitionValues object, int n10, int n11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, Transition transition) {
        TranslationAnimationCreator$TransitionPositionListener translationAnimationCreator$TransitionPositionListener;
        PropertyValuesHolder propertyValuesHolder;
        float f14;
        float f15;
        Object transitionValues = object;
        float f16 = view.getTranslationX();
        float f17 = view.getTranslationY();
        Object object2 = ((TransitionValues)object).view;
        int n12 = R$id.transition_position;
        object2 = (int[])object2.getTag(n12);
        n12 = 1;
        if (object2 != null) {
            reference var15_15 = object2[0] - n10;
            f15 = (float)var15_15 + f16;
            reference var17_17 = object2[n12] - n11;
            f14 = (float)var17_17 + f17;
        } else {
            f15 = f10;
            f14 = f11;
        }
        float f18 = f15 - f16;
        int n13 = Math.round(f18);
        n13 = n10 + n13;
        float f19 = f14 - f17;
        int n14 = Math.round(f19);
        n14 = n11 + n14;
        view.setTranslationX(f15);
        view.setTranslationY(f14);
        float f20 = f15 == f12 ? 0 : (f15 > f12 ? 1 : -1);
        if (f20 == false && (f20 = f14 == f13 ? 0 : (f14 > f13 ? 1 : -1)) == false) {
            return null;
        }
        f20 = 2;
        PropertyValuesHolder[] propertyValuesHolderArray = new PropertyValuesHolder[f20];
        Property property = View.TRANSLATION_X;
        float[] fArray = new float[f20];
        fArray[0] = f15;
        fArray[n12] = f12;
        propertyValuesHolderArray[0] = propertyValuesHolder = PropertyValuesHolder.ofFloat((Property)property, (float[])fArray);
        propertyValuesHolder = View.TRANSLATION_Y;
        float[] fArray2 = new float[f20];
        fArray2[0] = f14;
        fArray2[n12] = f13;
        object2 = PropertyValuesHolder.ofFloat((Property)propertyValuesHolder, (float[])fArray2);
        propertyValuesHolderArray[n12] = object2;
        object2 = ObjectAnimator.ofPropertyValuesHolder((Object)view, (PropertyValuesHolder[])propertyValuesHolderArray);
        transitionValues = ((TransitionValues)transitionValues).view;
        object = translationAnimationCreator$TransitionPositionListener;
        f12 = f16;
        f13 = f17;
        translationAnimationCreator$TransitionPositionListener = new TranslationAnimationCreator$TransitionPositionListener(view, (View)transitionValues, n13, n14, f16, f17);
        transition.addListener(translationAnimationCreator$TransitionPositionListener);
        object2.addListener((Animator.AnimatorListener)translationAnimationCreator$TransitionPositionListener);
        AnimatorUtils.addPauseListener((Animator)object2, translationAnimationCreator$TransitionPositionListener);
        object2.setInterpolator(timeInterpolator);
        return object2;
    }
}

