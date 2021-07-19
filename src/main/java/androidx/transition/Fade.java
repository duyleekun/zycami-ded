/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Fade$1;
import androidx.transition.Fade$FadeAnimatorListener;
import androidx.transition.Styleable;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import androidx.transition.Visibility;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class Fade
extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public Fade() {
    }

    public Fade(int n10) {
        this.setMode(n10);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = Styleable.FADE;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        attributeSet = (XmlResourceParser)attributeSet;
        int n10 = this.getMode();
        int n11 = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)attributeSet, "fadingMode", 0, n10);
        this.setMode(n11);
        context.recycle();
    }

    private Animator createAnimation(View view, float f10, float f11) {
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object == false) {
            return null;
        }
        ViewUtils.setTransitionAlpha(view, f10);
        Property property = ViewUtils.TRANSITION_ALPHA;
        float[] fArray = new float[]{f11};
        property = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])fArray);
        Object object2 = new Fade$FadeAnimatorListener(view);
        property.addListener((Animator.AnimatorListener)object2);
        object2 = new Fade$1(this, view);
        this.addListener((Transition$TransitionListener)object2);
        return property;
    }

    private static float getStartAlpha(TransitionValues object, float f10) {
        if (object != null) {
            object = ((TransitionValues)object).values;
            String string2 = PROPNAME_TRANSITION_ALPHA;
            if ((object = (Float)object.get(string2)) != null) {
                f10 = ((Float)object).floatValue();
            }
        }
        return f10;
    }

    public void captureStartValues(TransitionValues object) {
        super.captureStartValues((TransitionValues)object);
        Map map = ((TransitionValues)object).values;
        object = Float.valueOf(ViewUtils.getTransitionAlpha(((TransitionValues)object).view));
        map.put(PROPNAME_TRANSITION_ALPHA, object);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f10;
        float f11 = 0.0f;
        float f12 = Fade.getStartAlpha(transitionValues, 0.0f);
        float f13 = f12 - (f10 = 1.0f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            f11 = f12;
        }
        return this.createAnimation(view, f11, f10);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        float f10 = Fade.getStartAlpha(transitionValues, 1.0f);
        return this.createAnimation(view, f10, 0.0f);
    }
}

