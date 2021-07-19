/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import java.util.Map;

public class ChangeScroll
extends Transition {
    private static final String[] PROPERTIES = new String[]{"android:changeScroll:x", "android:changeScroll:y"};
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues object) {
        Map map = ((TransitionValues)object).values;
        Integer n10 = ((TransitionValues)object).view.getScrollX();
        map.put(PROPNAME_SCROLL_X, n10);
        map = ((TransitionValues)object).values;
        object = ((TransitionValues)object).view.getScrollY();
        map.put(PROPNAME_SCROLL_Y, object);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup object, TransitionValues object2, TransitionValues object3) {
        object = null;
        if (object2 != null && object3 != null) {
            View view = ((TransitionValues)object3).view;
            Object object4 = ((TransitionValues)object2).values;
            Object object5 = PROPNAME_SCROLL_X;
            object4 = (Integer)object4.get(object5);
            int n10 = (Integer)object4;
            object5 = (Integer)((TransitionValues)object3).values.get(object5);
            int n11 = (Integer)object5;
            object2 = ((TransitionValues)object2).values;
            String string2 = PROPNAME_SCROLL_Y;
            object2 = (Integer)object2.get(string2);
            int n12 = (Integer)object2;
            object3 = (Integer)((TransitionValues)object3).values.get(string2);
            int n13 = (Integer)object3;
            int n14 = 1;
            int n15 = 2;
            if (n10 != n11) {
                view.setScrollX(n10);
                int[] nArray = new int[n15];
                nArray[0] = n10;
                nArray[n14] = n11;
                object4 = ObjectAnimator.ofInt((Object)view, (String)"scrollX", (int[])nArray);
            } else {
                n10 = 0;
                object4 = null;
            }
            if (n12 != n13) {
                view.setScrollY(n12);
                object = new int[n15];
                object[0] = (ViewGroup)n12;
                object[n14] = (ViewGroup)n13;
                object2 = "scrollY";
                object = ObjectAnimator.ofInt((Object)view, (String)object2, (int[])object);
            }
            object = TransitionUtils.mergeAnimators((Animator)object4, (Animator)object);
        }
        return object;
    }

    public String[] getTransitionProperties() {
        return PROPERTIES;
    }
}

