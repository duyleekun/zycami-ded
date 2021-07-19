/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeClipBounds$1;
import androidx.transition.RectEvaluator;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import java.util.Map;

public class ChangeClipBounds
extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = new String[]{"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues object) {
        int n10;
        Object object2 = ((TransitionValues)object).view;
        int n11 = object2.getVisibility();
        if (n11 == (n10 = 8)) {
            return;
        }
        Rect rect = ViewCompat.getClipBounds(object2);
        Map map = ((TransitionValues)object).values;
        String string2 = PROPNAME_CLIP;
        map.put(string2, rect);
        if (rect == null) {
            n10 = object2.getWidth();
            int n12 = object2.getHeight();
            string2 = null;
            rect = new Rect(0, 0, n10, n12);
            object = ((TransitionValues)object).values;
            object2 = PROPNAME_BOUNDS;
            object.put(object2, rect);
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup object, TransitionValues transitionValues, TransitionValues object2) {
        Object object3;
        Object object4;
        boolean bl2;
        object = null;
        if (transitionValues != null && object2 != null && (bl2 = (object4 = transitionValues.values).containsKey(object3 = PROPNAME_CLIP)) && (bl2 = (object4 = object2.values).containsKey(object3))) {
            object4 = (Rect)transitionValues.values.get(object3);
            Map map = object2.values;
            object3 = (Rect)map.get(object3);
            int n10 = 1;
            int n11 = object3 == null ? n10 : 0;
            if (object4 == null && object3 == null) {
                return null;
            }
            String string2 = PROPNAME_BOUNDS;
            if (object4 == null) {
                transitionValues = transitionValues.values.get(string2);
                object4 = transitionValues;
                object4 = (Rect)transitionValues;
            } else if (object3 == null) {
                transitionValues = object2.values.get(string2);
                object3 = transitionValues;
                object3 = (Rect)transitionValues;
            }
            boolean bl3 = object4.equals(object3);
            if (bl3) {
                return null;
            }
            ViewCompat.setClipBounds(object2.view, (Rect)object4);
            transitionValues = new Rect();
            object = new RectEvaluator((Rect)transitionValues);
            transitionValues = object2.view;
            string2 = ViewUtils.CLIP_BOUNDS;
            int n12 = 2;
            Object[] objectArray = new Rect[n12];
            objectArray[0] = object4;
            objectArray[n10] = object3;
            object = ObjectAnimator.ofObject((Object)transitionValues, (Property)string2, (TypeEvaluator)object, (Object[])objectArray);
            if (n11 != 0) {
                transitionValues = object2.view;
                object2 = new ChangeClipBounds$1(this, (View)transitionValues);
                object.addListener((Animator.AnimatorListener)object2);
            }
        }
        return object;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}

