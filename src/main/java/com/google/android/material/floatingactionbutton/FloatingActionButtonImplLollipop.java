/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.animation.TimeInterpolator
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop$AlwaysStatefulGradientDrawable;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawableLollipop;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

public class FloatingActionButtonImplLollipop
extends FloatingActionButtonImpl {
    private InsetDrawable insetDrawable;

    public FloatingActionButtonImplLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    private Animator createElevationAnimator(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        VisibilityAwareImageButton visibilityAwareImageButton = this.view;
        int n10 = 1;
        Object object = new float[n10];
        object[0] = f10;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)((Object)visibilityAwareImageButton), (String)"elevation", (float[])object).setDuration(0L);
        objectAnimator = animatorSet.play((Animator)objectAnimator);
        visibilityAwareImageButton = this.view;
        object = View.TRANSLATION_Z;
        float[] fArray = new float[n10];
        fArray[0] = f11;
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)((Object)visibilityAwareImageButton), (Property)object, (float[])fArray).setDuration((long)100);
        objectAnimator.with((Animator)objectAnimator2);
        objectAnimator = FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR;
        animatorSet.setInterpolator((TimeInterpolator)objectAnimator);
        return animatorSet;
    }

    public float getElevation() {
        return this.view.getElevation();
    }

    public void getPadding(Rect rect) {
        ShadowViewDelegate shadowViewDelegate = this.shadowViewDelegate;
        int n10 = shadowViewDelegate.isCompatPaddingEnabled();
        if (n10 != 0) {
            shadowViewDelegate = this.shadowViewDelegate;
            float f10 = shadowViewDelegate.getRadius();
            float f11 = this.getElevation();
            float f12 = this.pressedTranslationZ;
            f11 += f12;
            f12 = ShadowDrawableWrapper.calculateHorizontalPadding(f11, f10, false);
            double d10 = Math.ceil(f12);
            int n11 = (int)d10;
            f10 = ShadowDrawableWrapper.calculateVerticalPadding(f11, f10, false);
            double d11 = Math.ceil(f10);
            n10 = (int)d11;
            rect.set(n11, n10, n11, n10);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    public void jumpDrawableToCurrentState() {
    }

    public CircularBorderDrawable newCircularDrawable() {
        CircularBorderDrawableLollipop circularBorderDrawableLollipop = new CircularBorderDrawableLollipop();
        return circularBorderDrawableLollipop;
    }

    public GradientDrawable newGradientDrawableForShape() {
        FloatingActionButtonImplLollipop$AlwaysStatefulGradientDrawable floatingActionButtonImplLollipop$AlwaysStatefulGradientDrawable = new FloatingActionButtonImplLollipop$AlwaysStatefulGradientDrawable();
        return floatingActionButtonImplLollipop$AlwaysStatefulGradientDrawable;
    }

    public void onCompatShadowChanged() {
        this.updatePadding();
    }

    public void onDrawableStateChanged(int[] object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        float f10 = 2.9E-44f;
        if (n10 == n11) {
            object = (Object)this.view;
            n10 = (int)(object.isEnabled() ? 1 : 0);
            n11 = 0;
            f10 = 0.0f;
            if (n10 != 0) {
                object = (Object)this.view;
                float f11 = this.elevation;
                object.setElevation(f11);
                object = (Object)this.view;
                n10 = (int)(object.isPressed() ? 1 : 0);
                if (n10 != 0) {
                    object = (Object)this.view;
                    f10 = this.pressedTranslationZ;
                    object.setTranslationZ(f10);
                } else {
                    object = (Object)this.view;
                    n10 = (int)(object.isFocused() ? 1 : 0);
                    if (n10 == 0 && (n10 = (int)((object = (Object)((Object)this.view)).isHovered() ? 1 : 0)) == 0) {
                        object = (Object)this.view;
                        object.setTranslationZ(0.0f);
                    } else {
                        object = (Object)this.view;
                        f10 = this.hoveredFocusedTranslationZ;
                        object.setTranslationZ(f10);
                    }
                }
            } else {
                this.view.setElevation(0.0f);
                object = (Object)this.view;
                object.setTranslationZ(0.0f);
            }
        }
    }

    public void onElevationsChanged(float f10, float f11, float f12) {
        int n10;
        Object object;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 == n12) {
            object = this.view;
            object.refreshDrawableState();
        } else {
            Property property;
            StateListAnimator stateListAnimator = new StateListAnimator();
            Object object2 = FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET;
            Object object3 = this.createElevationAnimator(f10, f12);
            stateListAnimator.addState(object2, (Animator)object3);
            object3 = FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET;
            object2 = this.createElevationAnimator(f10, f11);
            stateListAnimator.addState((int[])object3, (Animator)object2);
            object3 = FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET;
            object2 = this.createElevationAnimator(f10, f11);
            stateListAnimator.addState((int[])object3, (Animator)object2);
            object3 = FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET;
            Animator animator2 = this.createElevationAnimator(f10, f11);
            stateListAnimator.addState((int[])object3, animator2);
            animator2 = new AnimatorSet();
            object3 = new ArrayList();
            object2 = (Object)this.view;
            int n13 = 1;
            float[] fArray = new float[n13];
            fArray[0] = f10;
            object = ObjectAnimator.ofFloat((Object)object2, (String)"elevation", (float[])fArray).setDuration(0L);
            object3.add(object);
            n10 = 22;
            f10 = 3.1E-44f;
            long l10 = 100;
            if (n11 >= n10) {
                n10 = 24;
                f10 = 3.4E-44f;
                if (n11 <= n10) {
                    object = this.view;
                    property = View.TRANSLATION_Z;
                    object2 = new float[n13];
                    float f13 = object.getTranslationZ();
                    object2[0] = (int)f13;
                    object = ObjectAnimator.ofFloat((Object)object, (Property)property, (float[])object2).setDuration(l10);
                    object3.add(object);
                }
            }
            object = this.view;
            property = View.TRANSLATION_Z;
            object2 = new float[n13];
            n13 = 0;
            object2[0] = (int)0.0f;
            object = ObjectAnimator.ofFloat((Object)object, (Property)property, (float[])object2).setDuration(l10);
            object3.add(object);
            object = new TimeInterpolator[]{};
            object = (TimeInterpolator)object3.toArray((T[])object);
            animator2.playSequentially((Animator[])object);
            object = FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR;
            animator2.setInterpolator(object);
            object = FloatingActionButtonImpl.ENABLED_STATE_SET;
            stateListAnimator.addState((int[])object, animator2);
            object = FloatingActionButtonImpl.EMPTY_STATE_SET;
            animator2 = this.createElevationAnimator(0.0f, 0.0f);
            stateListAnimator.addState((int[])object, animator2);
            object = this.view;
            object.setStateListAnimator(stateListAnimator);
        }
        object = this.shadowViewDelegate;
        n10 = object.isCompatPaddingEnabled();
        if (n10 != 0) {
            this.updatePadding();
        }
    }

    public void onPaddingUpdated(Rect object) {
        ShadowViewDelegate shadowViewDelegate = this.shadowViewDelegate;
        boolean bl2 = shadowViewDelegate.isCompatPaddingEnabled();
        if (bl2) {
            Drawable drawable2 = this.rippleDrawable;
            int n10 = ((Rect)object).left;
            int n11 = ((Rect)object).top;
            int n12 = ((Rect)object).right;
            int n13 = ((Rect)object).bottom;
            shadowViewDelegate = new InsetDrawable(drawable2, n10, n11, n12, n13);
            this.insetDrawable = shadowViewDelegate;
            object = this.shadowViewDelegate;
            object.setBackgroundDrawable((Drawable)shadowViewDelegate);
        } else {
            object = this.shadowViewDelegate;
            shadowViewDelegate = this.rippleDrawable;
            object.setBackgroundDrawable((Drawable)shadowViewDelegate);
        }
    }

    public boolean requirePreDrawListener() {
        return false;
    }

    public void setBackgroundDrawable(ColorStateList object, PorterDuff.Mode mode, ColorStateList colorStateList, int n10) {
        RippleDrawable rippleDrawable;
        Drawable drawable2;
        this.shapeDrawable = drawable2 = DrawableCompat.wrap((Drawable)this.createShapeDrawable());
        DrawableCompat.setTintList(drawable2, object);
        if (mode != null) {
            drawable2 = this.shapeDrawable;
            DrawableCompat.setTintMode(drawable2, mode);
        }
        mode = null;
        if (n10 > 0) {
            object = this.createBorderDrawable(n10, (ColorStateList)object);
            this.borderDrawable = object;
            n10 = 2;
            rippleDrawable = new Drawable[n10];
            drawable2 = null;
            CircularBorderDrawable circularBorderDrawable = this.borderDrawable;
            rippleDrawable[0] = circularBorderDrawable;
            int n11 = 1;
            circularBorderDrawable = this.shapeDrawable;
            rippleDrawable[n11] = circularBorderDrawable;
            object = new LayerDrawable((Drawable[])rippleDrawable);
        } else {
            this.borderDrawable = null;
            object = this.shapeDrawable;
        }
        colorStateList = RippleUtils.convertToRippleDrawableColor(colorStateList);
        rippleDrawable = new RippleDrawable(colorStateList, (Drawable)object, null);
        this.rippleDrawable = rippleDrawable;
        this.contentBackground = rippleDrawable;
        this.shadowViewDelegate.setBackgroundDrawable((Drawable)rippleDrawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable2 = this.rippleDrawable;
        boolean bl2 = drawable2 instanceof RippleDrawable;
        if (bl2) {
            drawable2 = (RippleDrawable)drawable2;
            colorStateList = RippleUtils.convertToRippleDrawableColor(colorStateList);
            drawable2.setColor(colorStateList);
        } else {
            super.setRippleColor(colorStateList);
        }
    }
}

