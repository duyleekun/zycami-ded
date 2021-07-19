/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.SidePropagation;
import androidx.transition.Slide$1;
import androidx.transition.Slide$2;
import androidx.transition.Slide$3;
import androidx.transition.Slide$4;
import androidx.transition.Slide$5;
import androidx.transition.Slide$6;
import androidx.transition.Slide$CalculateSlide;
import androidx.transition.Styleable;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;
import androidx.transition.Visibility;
import org.xmlpull.v1.XmlPullParser;

public class Slide
extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private static final TimeInterpolator sAccelerate;
    private static final Slide$CalculateSlide sCalculateBottom;
    private static final Slide$CalculateSlide sCalculateEnd;
    private static final Slide$CalculateSlide sCalculateLeft;
    private static final Slide$CalculateSlide sCalculateRight;
    private static final Slide$CalculateSlide sCalculateStart;
    private static final Slide$CalculateSlide sCalculateTop;
    private static final TimeInterpolator sDecelerate;
    private Slide$CalculateSlide mSlideCalculator;
    private int mSlideEdge;

    static {
        Object object = new DecelerateInterpolator();
        sDecelerate = object;
        object = new AccelerateInterpolator();
        sAccelerate = object;
        object = new Slide$1();
        sCalculateLeft = object;
        object = new Slide$2();
        sCalculateStart = object;
        object = new Slide$3();
        sCalculateTop = object;
        object = new Slide$4();
        sCalculateRight = object;
        object = new Slide$5();
        sCalculateEnd = object;
        object = new Slide$6();
        sCalculateBottom = object;
    }

    public Slide() {
        int n10;
        Slide$CalculateSlide slide$CalculateSlide;
        this.mSlideCalculator = slide$CalculateSlide = sCalculateBottom;
        this.mSlideEdge = n10 = 80;
        this.setSlideEdge(n10);
    }

    public Slide(int n10) {
        Slide$CalculateSlide slide$CalculateSlide;
        this.mSlideCalculator = slide$CalculateSlide = sCalculateBottom;
        this.mSlideEdge = 80;
        this.setSlideEdge(n10);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        Slide$CalculateSlide slide$CalculateSlide;
        this.mSlideCalculator = slide$CalculateSlide = sCalculateBottom;
        this.mSlideEdge = n10 = 80;
        int[] nArray = Styleable.SLIDE;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        attributeSet = (XmlPullParser)attributeSet;
        int n11 = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)attributeSet, "slideEdge", 0, n10);
        context.recycle();
        this.setSlideEdge(n11);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int[] nArray = new int[2];
        view.getLocationOnScreen(nArray);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, nArray);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues object, TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        object = (int[])transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        float f10 = view.getTranslationX();
        float f11 = view.getTranslationY();
        float f12 = this.mSlideCalculator.getGoneX(viewGroup, view);
        float f13 = this.mSlideCalculator.getGoneY(viewGroup, view);
        Object object2 = object[0];
        Object object3 = object[1];
        TimeInterpolator timeInterpolator = sDecelerate;
        return TranslationAnimationCreator.createAnimation(view, transitionValues, (int)object2, (int)object3, f12, f13, f10, f11, timeInterpolator, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues object) {
        if (transitionValues == null) {
            return null;
        }
        object = (int[])transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        float f10 = view.getTranslationX();
        float f11 = view.getTranslationY();
        float f12 = this.mSlideCalculator.getGoneX(viewGroup, view);
        float f13 = this.mSlideCalculator.getGoneY(viewGroup, view);
        Object object2 = object[0];
        Object object3 = object[1];
        TimeInterpolator timeInterpolator = sAccelerate;
        return TranslationAnimationCreator.createAnimation(view, transitionValues, (int)object2, (int)object3, f10, f11, f12, f13, timeInterpolator, this);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSlideEdge(int n10) {
        Object object;
        block5: {
            block6: {
                block7: {
                    block8: {
                        int n11 = 3;
                        if (n10 == n11) break block6;
                        n11 = 5;
                        if (n10 == n11) break block7;
                        n11 = 48;
                        if (n10 == n11) break block8;
                        n11 = 80;
                        if (n10 != n11) {
                            n11 = 0x800003;
                            if (n10 != n11) {
                                n11 = 0x800005;
                                if (n10 != n11) {
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid slide direction");
                                    throw illegalArgumentException;
                                }
                                this.mSlideCalculator = object = sCalculateEnd;
                                break block5;
                            } else {
                                this.mSlideCalculator = object = sCalculateStart;
                            }
                            break block5;
                        } else {
                            this.mSlideCalculator = object = sCalculateBottom;
                        }
                        break block5;
                    }
                    this.mSlideCalculator = object = sCalculateTop;
                    break block5;
                }
                object = sCalculateRight;
                this.mSlideCalculator = object;
                break block5;
            }
            object = sCalculateLeft;
            this.mSlideCalculator = object;
        }
        this.mSlideEdge = n10;
        object = new SidePropagation();
        ((SidePropagation)object).setSide(n10);
        this.setPropagation((TransitionPropagation)object);
    }
}

