/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$color;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$3;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ElevateToPressedTranslationZAnimation;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ShadowAnimatorImpl;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

public class FloatingActionButtonImpl {
    public static final int ANIM_STATE_HIDING = 1;
    public static final int ANIM_STATE_NONE = 0;
    public static final int ANIM_STATE_SHOWING = 2;
    public static final long ELEVATION_ANIM_DELAY = 100L;
    public static final long ELEVATION_ANIM_DURATION = 100L;
    public static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] EMPTY_STATE_SET;
    public static final int[] ENABLED_STATE_SET;
    public static final int[] FOCUSED_ENABLED_STATE_SET;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    public static final int[] HOVERED_ENABLED_STATE_SET;
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET;
    public static final int[] PRESSED_ENABLED_STATE_SET;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    public int animState = 0;
    public CircularBorderDrawable borderDrawable;
    public Drawable contentBackground;
    public Animator currentAnimator;
    private MotionSpec defaultHideMotionSpec;
    private MotionSpec defaultShowMotionSpec;
    public float elevation;
    private ArrayList hideListeners;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public float imageMatrixScale = 1.0f;
    public int maxImageSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    private float rotation;
    public ShadowDrawableWrapper shadowDrawable;
    public final ShadowViewDelegate shadowViewDelegate;
    public Drawable shapeDrawable;
    private ArrayList showListeners;
    public MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    public final VisibilityAwareImageButton view;

    static {
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 16842919;
        nArray[1] = 16842910;
        PRESSED_ENABLED_STATE_SET = nArray;
        int[] nArray2 = nArray = new int[3];
        nArray[0] = 16843623;
        nArray2[1] = 16842908;
        nArray2[2] = 16842910;
        HOVERED_FOCUSED_ENABLED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 16842908;
        nArray[1] = 16842910;
        FOCUSED_ENABLED_STATE_SET = nArray;
        int[] nArray3 = new int[n10];
        nArray3[0] = 16843623;
        nArray3[1] = 16842910;
        HOVERED_ENABLED_STATE_SET = nArray3;
        nArray3 = new int[]{16842910};
        ENABLED_STATE_SET = nArray3;
        EMPTY_STATE_SET = new int[0];
    }

    public FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate object) {
        float f10;
        Object object2;
        this.tmpRect = object2 = new Rect();
        this.tmpRectF1 = object2;
        super();
        this.tmpRectF2 = object2;
        super();
        this.tmpMatrix = object2;
        this.view = visibilityAwareImageButton;
        this.shadowViewDelegate = object;
        this.stateListAnimator = object = new StateListAnimator();
        object2 = PRESSED_ENABLED_STATE_SET;
        FloatingActionButtonImpl$ShadowAnimatorImpl floatingActionButtonImpl$ShadowAnimatorImpl = new FloatingActionButtonImpl$ElevateToPressedTranslationZAnimation(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        object2 = HOVERED_FOCUSED_ENABLED_STATE_SET;
        super(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        object2 = FOCUSED_ENABLED_STATE_SET;
        super(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        object2 = HOVERED_ENABLED_STATE_SET;
        super(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        object2 = ENABLED_STATE_SET;
        super(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        object2 = EMPTY_STATE_SET;
        super(this);
        floatingActionButtonImpl$ShadowAnimatorImpl = this.createElevationAnimator(floatingActionButtonImpl$ShadowAnimatorImpl);
        ((StateListAnimator)object).addState((int[])object2, (ValueAnimator)floatingActionButtonImpl$ShadowAnimatorImpl);
        this.rotation = f10 = visibilityAwareImageButton.getRotation();
    }

    private void calculateImageMatrixFromScale(float f10, Matrix matrix) {
        int n10;
        matrix.reset();
        Drawable drawable2 = this.view.getDrawable();
        if (drawable2 != null && (n10 = this.maxImageSize) != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            int n11 = drawable2.getIntrinsicWidth();
            float f11 = n11;
            float f12 = drawable2.getIntrinsicHeight();
            rectF.set(0.0f, 0.0f, f11, f12);
            int n12 = this.maxImageSize;
            f11 = n12;
            f12 = n12;
            rectF2.set(0.0f, 0.0f, f11, f12);
            drawable2 = Matrix.ScaleToFit.CENTER;
            matrix.setRectToRect(rectF, rectF2, (Matrix.ScaleToFit)drawable2);
            n12 = this.maxImageSize;
            float f13 = n12;
            float f14 = 2.0f;
            f12 = (float)n12 / f14;
            matrix.postScale(f10, f10, f13 /= f14, f12);
        }
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f10, float f11, float f12) {
        ArrayList<ObjectAnimator> arrayList = new ArrayList<ObjectAnimator>();
        Object[] objectArray = this.view;
        Object object = View.ALPHA;
        int n10 = 1;
        float[] fArray = new float[n10];
        fArray[0] = f10;
        Object object2 = ObjectAnimator.ofFloat((Object)objectArray, (Property)object, (float[])fArray);
        motionSpec.getTiming("opacity").apply((Animator)object2);
        arrayList.add((ObjectAnimator)object2);
        object2 = this.view;
        objectArray = View.SCALE_X;
        object = new float[n10];
        object[0] = (Property)f11;
        object2 = ObjectAnimator.ofFloat((Object)object2, (Property)objectArray, (float[])object);
        objectArray = "scale";
        motionSpec.getTiming((String)objectArray).apply((Animator)object2);
        arrayList.add((ObjectAnimator)object2);
        object2 = this.view;
        object = View.SCALE_Y;
        fArray = new float[n10];
        fArray[0] = f11;
        object2 = ObjectAnimator.ofFloat((Object)object2, (Property)object, (float[])fArray);
        motionSpec.getTiming((String)objectArray).apply((Animator)object2);
        arrayList.add((ObjectAnimator)object2);
        object2 = this.tmpMatrix;
        this.calculateImageMatrixFromScale(f12, (Matrix)object2);
        object2 = this.view;
        ImageMatrixProperty imageMatrixProperty = new ImageMatrixProperty();
        MatrixEvaluator matrixEvaluator = new MatrixEvaluator();
        objectArray = new Matrix[n10];
        Matrix matrix = this.tmpMatrix;
        object = new Matrix(matrix);
        objectArray[0] = object;
        object2 = ObjectAnimator.ofObject((Object)object2, (Property)imageMatrixProperty, (TypeEvaluator)matrixEvaluator, (Object[])objectArray);
        motionSpec.getTiming("iconScale").apply((Animator)object2);
        arrayList.add((ObjectAnimator)object2);
        motionSpec = new AnimatorSet();
        AnimatorSetCompat.playTogether((AnimatorSet)motionSpec, arrayList);
        return motionSpec;
    }

    private ValueAnimator createElevationAnimator(FloatingActionButtonImpl$ShadowAnimatorImpl object) {
        ValueAnimator valueAnimator = new ValueAnimator();
        TimeInterpolator timeInterpolator = ELEVATION_ANIM_INTERPOLATOR;
        valueAnimator.setInterpolator(timeInterpolator);
        valueAnimator.setDuration((long)100);
        valueAnimator.addListener((Animator.AnimatorListener)object);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        Object object2 = object = (Object)new float[2];
        object2[0] = (FloatingActionButtonImpl$ShadowAnimatorImpl)0.0f;
        object2[1] = (FloatingActionButtonImpl$ShadowAnimatorImpl)1.0f;
        valueAnimator.setFloatValues((float[])object);
        return valueAnimator;
    }

    private void ensurePreDrawListener() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener == null) {
            this.preDrawListener = onPreDrawListener = new FloatingActionButtonImpl$3(this);
        }
    }

    private MotionSpec getDefaultHideMotionSpec() {
        MotionSpec motionSpec = this.defaultHideMotionSpec;
        if (motionSpec == null) {
            motionSpec = this.view.getContext();
            int n10 = R$animator.design_fab_hide_motion_spec;
            this.defaultHideMotionSpec = motionSpec = MotionSpec.createFromResource((Context)motionSpec, n10);
        }
        return this.defaultHideMotionSpec;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        MotionSpec motionSpec = this.defaultShowMotionSpec;
        if (motionSpec == null) {
            motionSpec = this.view.getContext();
            int n10 = R$animator.design_fab_show_motion_spec;
            this.defaultShowMotionSpec = motionSpec = MotionSpec.createFromResource((Context)motionSpec, n10);
        }
        return this.defaultShowMotionSpec;
    }

    private boolean shouldAnimateVisibilityChange() {
        VisibilityAwareImageButton visibilityAwareImageButton = this.view;
        boolean bl2 = ViewCompat.isLaidOut((View)visibilityAwareImageButton);
        if (bl2 && !(bl2 = (visibilityAwareImageButton = this.view).isInEditMode())) {
            bl2 = true;
        } else {
            bl2 = false;
            visibilityAwareImageButton = null;
        }
        return bl2;
    }

    private void updateFromViewRotation() {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        float f10 = 2.7E-44f;
        if (n10 == n11) {
            float f11 = this.rotation % 90.0f;
            float f12 = f11 - 0.0f;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            n11 = 0;
            f10 = 0.0f;
            if (n10 != 0) {
                int n12;
                object = this.view;
                n10 = object.getLayerType();
                if (n10 != (n12 = 1)) {
                    object = this.view;
                    object.setLayerType(n12, null);
                }
            } else {
                object = this.view;
                n10 = object.getLayerType();
                if (n10 != 0) {
                    object = this.view;
                    boolean bl2 = false;
                    object.setLayerType(0, null);
                }
            }
        }
        if ((object = this.shadowDrawable) != null) {
            f10 = -this.rotation;
            object.setRotation(f10);
        }
        if ((object = this.borderDrawable) != null) {
            f10 = -this.rotation;
            object.setRotation(f10);
        }
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.hideListeners;
        if (arrayList == null) {
            this.hideListeners = arrayList = new ArrayList();
        }
        this.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.showListeners;
        if (arrayList == null) {
            this.showListeners = arrayList = new ArrayList();
        }
        this.showListeners.add(animatorListener);
    }

    public CircularBorderDrawable createBorderDrawable(int n10, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        CircularBorderDrawable circularBorderDrawable = this.newCircularDrawable();
        int n11 = R$color.design_fab_stroke_top_outer_color;
        n11 = ContextCompat.getColor(context, n11);
        int n12 = R$color.design_fab_stroke_top_inner_color;
        n12 = ContextCompat.getColor(context, n12);
        int n13 = R$color.design_fab_stroke_end_inner_color;
        n13 = ContextCompat.getColor(context, n13);
        int n14 = R$color.design_fab_stroke_end_outer_color;
        int n15 = ContextCompat.getColor(context, n14);
        circularBorderDrawable.setGradientColors(n11, n12, n13, n15);
        float f10 = n10;
        circularBorderDrawable.setBorderWidth(f10);
        circularBorderDrawable.setBorderTint(colorStateList);
        return circularBorderDrawable;
    }

    public GradientDrawable createShapeDrawable() {
        GradientDrawable gradientDrawable = this.newGradientDrawableForShape();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(Rect rect) {
        this.shadowDrawable.getPadding(rect);
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void hide(FloatingActionButtonImpl$InternalVisibilityChangedListener iterator2, boolean bl2) {
        boolean bl3 = this.isOrWillBeHidden();
        if (bl3) {
            return;
        }
        Object object = this.currentAnimator;
        if (object != null) {
            object.cancel();
        }
        if (bl3 = this.shouldAnimateVisibilityChange()) {
            object = this.hideMotionSpec;
            if (object == null) {
                object = this.getDefaultHideMotionSpec();
            }
            boolean bl4 = false;
            object = this.createAnimator((MotionSpec)object, 0.0f, 0.0f, 0.0f);
            FloatingActionButtonImpl$1 floatingActionButtonImpl$1 = new FloatingActionButtonImpl$1(this, bl2, (FloatingActionButtonImpl$InternalVisibilityChangedListener)((Object)iterator2));
            object.addListener((Animator.AnimatorListener)floatingActionButtonImpl$1);
            iterator2 = this.hideListeners;
            if (iterator2 != null) {
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                while (bl2 = iterator2.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
                    object.addListener(animatorListener);
                }
            }
            object.start();
        } else {
            object = this.view;
            int n10 = bl2 ? 8 : 4;
            ((VisibilityAwareImageButton)((Object)object)).internalSetVisibility(n10, bl2);
            if (iterator2 != null) {
                iterator2.onHidden();
            }
        }
    }

    public boolean isOrWillBeHidden() {
        VisibilityAwareImageButton visibilityAwareImageButton = this.view;
        int bl2 = visibilityAwareImageButton.getVisibility();
        int n10 = 0;
        int n11 = 1;
        if (bl2 == 0) {
            int n12 = this.animState;
            if (n12 == n11) {
                n10 = n11;
            }
            return n10 != 0;
        }
        int n13 = this.animState;
        int n14 = 2;
        if (n13 != n14) {
            n10 = n11;
        }
        return n10 != 0;
    }

    public boolean isOrWillBeShown() {
        VisibilityAwareImageButton visibilityAwareImageButton = this.view;
        int bl2 = visibilityAwareImageButton.getVisibility();
        int n10 = 0;
        int n11 = 1;
        if (bl2 != 0) {
            int n12 = this.animState;
            int n13 = 2;
            if (n12 == n13) {
                n10 = n11;
            }
            return n10 != 0;
        }
        int n14 = this.animState;
        if (n14 != n11) {
            n10 = n11;
        }
        return n10 != 0;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public CircularBorderDrawable newCircularDrawable() {
        CircularBorderDrawable circularBorderDrawable = new CircularBorderDrawable();
        return circularBorderDrawable;
    }

    public GradientDrawable newGradientDrawableForShape() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        return gradientDrawable;
    }

    public void onAttachedToWindow() {
        boolean bl2 = this.requirePreDrawListener();
        if (bl2) {
            this.ensurePreDrawListener();
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        }
    }

    public void onCompatShadowChanged() {
    }

    public void onDetachedFromWindow() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            onPreDrawListener = this.view.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = this.preDrawListener;
            onPreDrawListener.removeOnPreDrawListener(onPreDrawListener2);
            onPreDrawListener = null;
            this.preDrawListener = null;
        }
    }

    public void onDrawableStateChanged(int[] nArray) {
        this.stateListAnimator.setState(nArray);
    }

    public void onElevationsChanged(float f10, float f11, float f12) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.shadowDrawable;
        if (shadowDrawableWrapper != null) {
            f12 = this.pressedTranslationZ + f10;
            shadowDrawableWrapper.setShadowSize(f10, f12);
            this.updatePadding();
        }
    }

    public void onPaddingUpdated(Rect rect) {
    }

    public void onPreDraw() {
        float f10 = this.rotation;
        VisibilityAwareImageButton visibilityAwareImageButton = this.view;
        float f11 = visibilityAwareImageButton.getRotation();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.rotation = f11;
            this.updateFromViewRotation();
        }
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundDrawable(ColorStateList object, PorterDuff.Mode object2, ColorStateList colorStateList, int n10) {
        Drawable[] drawableArray;
        Drawable drawable2;
        this.shapeDrawable = drawable2 = DrawableCompat.wrap((Drawable)this.createShapeDrawable());
        DrawableCompat.setTintList(drawable2, (ColorStateList)object);
        if (object2 != null) {
            drawable2 = this.shapeDrawable;
            DrawableCompat.setTintMode(drawable2, object2);
        }
        object2 = DrawableCompat.wrap((Drawable)this.createShapeDrawable());
        this.rippleDrawable = object2;
        colorStateList = RippleUtils.convertToRippleDrawableColor(colorStateList);
        DrawableCompat.setTintList((Drawable)object2, colorStateList);
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        int n12 = 2;
        drawable2 = null;
        if (n10 > 0) {
            object = this.createBorderDrawable(n10, (ColorStateList)object);
            this.borderDrawable = object;
            n10 = 3;
            drawableArray = new Drawable[n10];
            drawableArray[0] = object;
            object = this.shapeDrawable;
            drawableArray[n11] = object;
            object = this.rippleDrawable;
            drawableArray[n12] = object;
        } else {
            this.borderDrawable = null;
            drawableArray = new Drawable[n12];
            object = this.shapeDrawable;
            drawableArray[0] = object;
            object = this.rippleDrawable;
            drawableArray[n11] = object;
        }
        object = new LayerDrawable(drawableArray);
        this.contentBackground = object;
        Context context = this.view.getContext();
        Drawable drawable3 = this.contentBackground;
        float f11 = this.shadowViewDelegate.getRadius();
        float f12 = this.elevation;
        f10 = this.pressedTranslationZ;
        float f13 = f12 + f10;
        object = new ShadowDrawableWrapper(context, drawable3, f11, f12, f13);
        this.shadowDrawable = object;
        ((ShadowDrawableWrapper)((Object)object)).setAddPaddingForCorners(false);
        object = this.shadowViewDelegate;
        object2 = this.shadowDrawable;
        object.setBackgroundDrawable((Drawable)object2);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Drawable drawable2 = this.shapeDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTintList(drawable2, colorStateList);
        }
        if ((drawable2 = this.borderDrawable) != null) {
            drawable2.setBorderTint(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Drawable drawable2 = this.shapeDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTintMode(drawable2, mode);
        }
    }

    public final void setElevation(float f10) {
        float f11 = this.elevation;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.elevation = f10;
            f11 = this.hoveredFocusedTranslationZ;
            float f13 = this.pressedTranslationZ;
            this.onElevationsChanged(f10, f11, f13);
        }
    }

    public final void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public final void setHoveredFocusedTranslationZ(float f10) {
        float f11 = this.hoveredFocusedTranslationZ;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.hoveredFocusedTranslationZ = f10;
            f11 = this.elevation;
            float f13 = this.pressedTranslationZ;
            this.onElevationsChanged(f11, f10, f13);
        }
    }

    public final void setImageMatrixScale(float f10) {
        this.imageMatrixScale = f10;
        Matrix matrix = this.tmpMatrix;
        this.calculateImageMatrixFromScale(f10, matrix);
        this.view.setImageMatrix(matrix);
    }

    public final void setMaxImageSize(int n10) {
        int n11 = this.maxImageSize;
        if (n11 != n10) {
            this.maxImageSize = n10;
            this.updateImageMatrixScale();
        }
    }

    public final void setPressedTranslationZ(float f10) {
        float f11 = this.pressedTranslationZ;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.pressedTranslationZ = f10;
            f11 = this.elevation;
            float f13 = this.hoveredFocusedTranslationZ;
            this.onElevationsChanged(f11, f13, f10);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable2 = this.rippleDrawable;
        if (drawable2 != null) {
            colorStateList = RippleUtils.convertToRippleDrawableColor(colorStateList);
            DrawableCompat.setTintList(drawable2, colorStateList);
        }
    }

    public final void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void show(FloatingActionButtonImpl$InternalVisibilityChangedListener iterator2, boolean bl2) {
        int n10 = this.isOrWillBeShown();
        if (n10 != 0) {
            return;
        }
        Object object = this.currentAnimator;
        if (object != null) {
            object.cancel();
        }
        n10 = this.shouldAnimateVisibilityChange();
        float f10 = 1.0f;
        if (n10 != 0) {
            object = this.view;
            n10 = object.getVisibility();
            if (n10 != 0) {
                this.view.setAlpha(0.0f);
                this.view.setScaleY(0.0f);
                object = this.view;
                object.setScaleX(0.0f);
                this.setImageMatrixScale(0.0f);
            }
            if ((object = this.showMotionSpec) == null) {
                object = this.getDefaultShowMotionSpec();
            }
            object = this.createAnimator((MotionSpec)object, f10, f10, f10);
            FloatingActionButtonImpl$2 floatingActionButtonImpl$2 = new FloatingActionButtonImpl$2(this, bl2, (FloatingActionButtonImpl$InternalVisibilityChangedListener)((Object)iterator2));
            object.addListener((Animator.AnimatorListener)floatingActionButtonImpl$2);
            iterator2 = this.showListeners;
            if (iterator2 != null) {
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                while (bl2 = iterator2.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
                    object.addListener(animatorListener);
                }
            }
            object.start();
        } else {
            object = this.view;
            object.internalSetVisibility(0, bl2);
            this.view.setAlpha(f10);
            this.view.setScaleY(f10);
            VisibilityAwareImageButton visibilityAwareImageButton = this.view;
            visibilityAwareImageButton.setScaleX(f10);
            this.setImageMatrixScale(f10);
            if (iterator2 != null) {
                iterator2.onShown();
            }
        }
    }

    public final void updateImageMatrixScale() {
        float f10 = this.imageMatrixScale;
        this.setImageMatrixScale(f10);
    }

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        this.getPadding(rect);
        this.onPaddingUpdated(rect);
        ShadowViewDelegate shadowViewDelegate = this.shadowViewDelegate;
        int n10 = rect.left;
        int n11 = rect.top;
        int n12 = rect.right;
        int n13 = rect.bottom;
        shadowViewDelegate.setShadowPadding(n10, n11, n12, n13);
    }
}

