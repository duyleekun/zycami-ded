/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;

public abstract class VisibilityPropagation
extends TransitionPropagation {
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int getViewCoordinate(TransitionValues object, int n10) {
        int n11 = -1;
        if (object == null) {
            return n11;
        }
        object = ((TransitionValues)object).values;
        String string2 = PROPNAME_VIEW_CENTER;
        if ((object = (Object)((int[])object.get(string2))) == null) {
            return n11;
        }
        return (int)object[n10];
    }

    public void captureValues(TransitionValues transitionValues) {
        reference var6_13;
        reference var6_11;
        reference var6_9;
        reference var6_7;
        int n10;
        View view = transitionValues.view;
        Object object = transitionValues.values;
        Object object2 = "android:visibility:visibility";
        if ((object = (Integer)object.get(object2)) == null) {
            n10 = view.getVisibility();
            object = n10;
        }
        transitionValues.values.put(PROPNAME_VISIBILITY, object);
        n10 = 2;
        object2 = new int[n10];
        view.getLocationOnScreen((int[])object2);
        Object object3 = object2[0];
        int n11 = Math.round(view.getTranslationX());
        object2[0] = var6_7 = object3 + n11;
        Object object4 = object2[0];
        n11 = view.getWidth() / n10;
        object2[0] = var6_9 = object4 + n11;
        int n12 = 1;
        Object object5 = object2[n12];
        n11 = Math.round(view.getTranslationY());
        object2[n12] = var6_11 = object5 + n11;
        Object object6 = object2[n12];
        int n13 = view.getHeight() / n10;
        object2[n12] = var6_13 = object6 + n13;
        transitionValues.values.put(PROPNAME_VIEW_CENTER, object2);
    }

    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(TransitionValues object) {
        int n10 = 8;
        if (object == null) {
            return n10;
        }
        object = ((TransitionValues)object).values;
        String string2 = PROPNAME_VISIBILITY;
        if ((object = (Integer)object.get(string2)) == null) {
            return n10;
        }
        return (Integer)object;
    }

    public int getViewX(TransitionValues transitionValues) {
        return VisibilityPropagation.getViewCoordinate(transitionValues, 0);
    }

    public int getViewY(TransitionValues transitionValues) {
        return VisibilityPropagation.getViewCoordinate(transitionValues, 1);
    }
}

