/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealScrimColorProperty;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.google.android.material.transformation.FabTransformationBehavior$1;
import com.google.android.material.transformation.FabTransformationBehavior$2;
import com.google.android.material.transformation.FabTransformationBehavior$3;
import com.google.android.material.transformation.FabTransformationBehavior$4;
import com.google.android.material.transformation.FabTransformationBehavior$FabTransformationSpec;
import com.google.android.material.transformation.TransformationChildCard;
import com.google.android.material.transformation.TransformationChildLayout;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
extends ExpandableTransformationBehavior {
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public FabTransformationBehavior() {
        Object object;
        this.tmpRect = object = new Rect();
        this.tmpRectF1 = object;
        super();
        this.tmpRectF2 = object;
        object = new int[2];
        this.tmpArray = (int[])object;
    }

    public FabTransformationBehavior(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super();
        this.tmpRect = object;
        super();
        this.tmpRectF1 = object;
        super();
        this.tmpRectF2 = object;
        object = new int[2];
        this.tmpArray = (int[])object;
    }

    private ViewGroup calculateChildContentContainer(View view) {
        int n10 = R$id.mtrl_child_content_container;
        View view2 = view.findViewById(n10);
        if (view2 != null) {
            return this.toViewGroupOrNull(view2);
        }
        n10 = view instanceof TransformationChildLayout;
        if (n10 == 0 && (n10 = view instanceof TransformationChildCard) == 0) {
            return this.toViewGroupOrNull(view);
        }
        view = ((ViewGroup)view).getChildAt(0);
        return this.toViewGroupOrNull(view);
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View view, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f10, float f11, float f12, float f13, RectF rectF) {
        float f14 = this.calculateValueOfAnimationAtEndOfExpansion(fabTransformationBehavior$FabTransformationSpec, motionTiming, f10, f12);
        float f15 = this.calculateValueOfAnimationAtEndOfExpansion(fabTransformationBehavior$FabTransformationSpec, motionTiming2, f11, f13);
        motionTiming2 = this.tmpRect;
        view.getWindowVisibleDisplayFrame((Rect)motionTiming2);
        RectF rectF2 = this.tmpRectF1;
        rectF2.set((Rect)motionTiming2);
        motionTiming2 = this.tmpRectF2;
        this.calculateWindowBounds(view, (RectF)motionTiming2);
        motionTiming2.offset(f14, f15);
        motionTiming2.intersect(rectF2);
        rectF.set((RectF)motionTiming2);
    }

    private float calculateRevealCenterX(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        this.calculateWindowBounds(view, rectF);
        this.calculateWindowBounds(view2, rectF2);
        float f10 = -this.calculateTranslationX(view, view2, positioning);
        rectF2.offset(f10, 0.0f);
        f10 = rectF.centerX();
        float f11 = rectF2.left;
        return f10 - f11;
    }

    private float calculateRevealCenterY(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        this.calculateWindowBounds(view, rectF);
        this.calculateWindowBounds(view2, rectF2);
        float f10 = -this.calculateTranslationY(view, view2, positioning);
        rectF2.offset(0.0f, f10);
        f10 = rectF.centerY();
        float f11 = rectF2.top;
        return f10 - f11;
    }

    private float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f10;
        float f11;
        block3: {
            block4: {
                RectF rectF;
                RectF rectF2;
                block0: {
                    block1: {
                        block2: {
                            rectF2 = this.tmpRectF1;
                            rectF = this.tmpRectF2;
                            this.calculateWindowBounds(view, rectF2);
                            this.calculateWindowBounds(view2, rectF);
                            int n10 = positioning.gravity & 7;
                            int n11 = 1;
                            f11 = Float.MIN_VALUE;
                            if (n10 == n11) break block0;
                            n11 = 3;
                            f11 = 4.2E-45f;
                            if (n10 == n11) break block1;
                            n11 = 5;
                            f11 = 7.0E-45f;
                            if (n10 == n11) break block2;
                            n10 = 0;
                            f10 = 0.0f;
                            view = null;
                            break block3;
                        }
                        f10 = rectF.right;
                        f11 = rectF2.right;
                        break block4;
                    }
                    f10 = rectF.left;
                    f11 = rectF2.left;
                    break block4;
                }
                f10 = rectF.centerX();
                f11 = rectF2.centerX();
            }
            f10 -= f11;
        }
        f11 = positioning.xAdjustment;
        return f10 + f11;
    }

    private float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f10;
        float f11;
        block3: {
            block4: {
                RectF rectF;
                RectF rectF2;
                block0: {
                    block1: {
                        block2: {
                            rectF2 = this.tmpRectF1;
                            rectF = this.tmpRectF2;
                            this.calculateWindowBounds(view, rectF2);
                            this.calculateWindowBounds(view2, rectF);
                            int n10 = positioning.gravity & 0x70;
                            int n11 = 16;
                            f11 = 2.24E-44f;
                            if (n10 == n11) break block0;
                            n11 = 48;
                            f11 = 6.7E-44f;
                            if (n10 == n11) break block1;
                            n11 = 80;
                            f11 = 1.12E-43f;
                            if (n10 == n11) break block2;
                            n10 = 0;
                            f10 = 0.0f;
                            view = null;
                            break block3;
                        }
                        f10 = rectF.bottom;
                        f11 = rectF2.bottom;
                        break block4;
                    }
                    f10 = rectF.top;
                    f11 = rectF2.top;
                    break block4;
                }
                f10 = rectF.centerY();
                f11 = rectF2.centerY();
            }
            f10 -= f11;
        }
        f11 = positioning.yAdjustment;
        return f10 + f11;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationBehavior$FabTransformationSpec object, MotionTiming motionTiming, float f10, float f11) {
        long l10 = motionTiming.getDelay();
        long l11 = motionTiming.getDuration();
        object = ((FabTransformationBehavior$FabTransformationSpec)object).timings.getTiming("expansion");
        long l12 = ((MotionTiming)object).getDelay();
        long l13 = ((MotionTiming)object).getDuration();
        float f12 = l12 + l13 + (long)17 - l10;
        float f13 = l11;
        f12 /= f13;
        f12 = motionTiming.getInterpolator().getInterpolation(f12);
        return AnimationUtils.lerp(f10, f11, f12);
    }

    private void calculateWindowBounds(View view, RectF rectF) {
        float f10 = view.getWidth();
        float f11 = view.getHeight();
        rectF.set(0.0f, 0.0f, f10, f11);
        int[] nArray = this.tmpArray;
        view.getLocationInWindow(nArray);
        f11 = nArray[0];
        f10 = nArray[1];
        rectF.offsetTo(f11, f10);
        f10 = (int)(-view.getTranslationX());
        float f12 = (int)(-view.getTranslationY());
        rectF.offset(f10, f12);
    }

    /*
     * WARNING - void declaration
     */
    private void createChildrenFadeAnimation(View view, View object, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, List list, List list2) {
        void var6_7;
        void var5_6;
        int n10 = object instanceof ViewGroup;
        if (n10 == 0) {
            return;
        }
        n10 = object instanceof CircularRevealWidget;
        if (n10 != 0 && (n10 = CircularRevealHelper.STRATEGY) == 0) {
            return;
        }
        view = this.calculateChildContentContainer((View)object);
        if (view == null) {
            return;
        }
        object = null;
        int n11 = 1;
        if (bl2) {
            Object property;
            if (!bl3) {
                property = ChildrenAlphaProperty.CHILDREN_ALPHA;
                object = Float.valueOf(0.0f);
                property.set((Object)view, object);
            }
            object = ChildrenAlphaProperty.CHILDREN_ALPHA;
            property = new float[n11];
            int n12 = 1065353216;
            float f10 = 1.0f;
            property[0] = (Property)f10;
            view = ObjectAnimator.ofFloat((Object)view, (Property)object, (float[])property);
        } else {
            Property property = ChildrenAlphaProperty.CHILDREN_ALPHA;
            float[] fArray = new float[n11];
            fArray[0] = 0.0f;
            view = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])fArray);
        }
        var5_6.timings.getTiming("contentFade").apply((Animator)view);
        var6_7.add(view);
    }

    private void createColorAnimation(View view, View object, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, List list, List list2) {
        int n10 = object instanceof CircularRevealWidget;
        if (n10 == 0) {
            return;
        }
        object = (CircularRevealWidget)object;
        int n11 = this.getBackgroundTint(view);
        n10 = 0xFFFFFF & n11;
        int n12 = 1;
        if (bl2) {
            if (!bl3) {
                object.setCircularRevealScrimColor(n11);
            }
            view = CircularRevealWidget$CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR;
            int[] nArray = new int[n12];
            nArray[0] = n10;
            view = ObjectAnimator.ofInt((Object)object, (Property)view, (int[])nArray);
        } else {
            Property property = CircularRevealWidget$CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR;
            int[] nArray = new int[n12];
            nArray[0] = n11;
            view = ObjectAnimator.ofInt((Object)object, (Property)property, (int[])nArray);
        }
        object = ArgbEvaluatorCompat.getInstance();
        view.setEvaluator((TypeEvaluator)object);
        fabTransformationBehavior$FabTransformationSpec.timings.getTiming("color").apply((Animator)view);
        list.add(view);
    }

    private void createElevationAnimation(View view, View view2, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, List list, List list2) {
        float f10 = ViewCompat.getElevation(view2);
        float f11 = ViewCompat.getElevation(view);
        f10 -= f11;
        f11 = 0.0f;
        view = null;
        int n10 = 1;
        if (bl2) {
            if (!bl3) {
                float f12 = -f10;
                view2.setTranslationZ(f12);
            }
            Property property = View.TRANSLATION_Z;
            float[] fArray = new float[n10];
            f10 = 0.0f;
            fArray[0] = 0.0f;
            view = ObjectAnimator.ofFloat((Object)view2, (Property)property, (float[])fArray);
        } else {
            Property property = View.TRANSLATION_Z;
            float[] fArray = new float[n10];
            fArray[0] = f10 = -f10;
            view = ObjectAnimator.ofFloat((Object)view2, (Property)property, (float[])fArray);
        }
        fabTransformationBehavior$FabTransformationSpec.timings.getTiming("elevation").apply((Animator)view);
        list.add(view);
    }

    private void createExpansionAnimation(View view, View view2, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, float f10, float f11, List list, List list2) {
        FabTransformationBehavior fabTransformationBehavior = this;
        Object object = view;
        FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec2 = fabTransformationBehavior$FabTransformationSpec;
        boolean bl4 = view2 instanceof CircularRevealWidget;
        if (!bl4) {
            return;
        }
        Object object2 = view2;
        object2 = (CircularRevealWidget)view2;
        Object object3 = fabTransformationBehavior$FabTransformationSpec.positioning;
        float f12 = this.calculateRevealCenterX(view, view2, (Positioning)object3);
        Object object4 = fabTransformationBehavior$FabTransformationSpec.positioning;
        float f13 = this.calculateRevealCenterY(view, view2, (Positioning)object4);
        object = (FloatingActionButton)view;
        object4 = this.tmpRect;
        object.getContentRect((Rect)object4);
        int n10 = this.tmpRect.width();
        float f14 = n10;
        float f15 = 2.0f;
        float f16 = f14 / f15;
        object = fabTransformationBehavior$FabTransformationSpec.timings;
        object4 = "expansion";
        MotionTiming motionTiming = object.getTiming((String)object4);
        if (bl2) {
            if (!bl3) {
                object = new CircularRevealWidget$RevealInfo(f12, f13, f16);
                object2.setRevealInfo((CircularRevealWidget$RevealInfo)object);
            }
            if (bl3) {
                object = object2.getRevealInfo();
                f16 = f14 = object.radius;
            }
            f15 = f12;
            float f17 = f10;
            f14 = MathUtils.distanceToFurthestCorner(f12, f13, 0.0f, 0.0f, f10, f11);
            fabTransformationBehavior$FabTransformationSpec2 = CircularRevealCompat.createCircularReveal((CircularRevealWidget)object2, f12, f13, f14);
            object = new FabTransformationBehavior$4(fabTransformationBehavior, (CircularRevealWidget)object2);
            fabTransformationBehavior$FabTransformationSpec2.addListener((Animator.AnimatorListener)object);
            long l10 = motionTiming.getDelay();
            int n11 = (int)f12;
            int n12 = (int)f13;
            object = this;
            object3 = view2;
            f17 = f16;
            this.createPreFillRadialExpansion(view2, l10, n11, n12, f16, list);
        } else {
            float f18 = object2.getRevealInfo().radius;
            Animator animator2 = CircularRevealCompat.createCircularReveal((CircularRevealWidget)object2, f12, f13, f16);
            long l11 = motionTiming.getDelay();
            int n13 = (int)f12;
            int n14 = (int)f13;
            object = this;
            object3 = view2;
            int n15 = n13;
            int n16 = n14;
            this.createPreFillRadialExpansion(view2, l11, n13, n14, f18, list);
            l11 = motionTiming.getDelay();
            long l12 = motionTiming.getDuration();
            long l13 = fabTransformationBehavior$FabTransformationSpec.timings.getTotalDuration();
            object = this;
            f13 = f16;
            this.createPostFillRadialExpansion(view2, l11, l12, l13, n13, n14, f16, list);
            fabTransformationBehavior$FabTransformationSpec2 = animator2;
        }
        motionTiming.apply((Animator)fabTransformationBehavior$FabTransformationSpec2);
        object = list;
        list.add(fabTransformationBehavior$FabTransformationSpec2);
        object = CircularRevealCompat.createCircularRevealListener((CircularRevealWidget)object2);
        object3 = list2;
        list2.add(object);
    }

    private void createIconFadeAnimation(View view, View object, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, List list, List list2) {
        boolean bl4 = object instanceof CircularRevealWidget;
        if (bl4 && (bl4 = view instanceof ImageView)) {
            Object object2;
            Property property;
            Object object3 = object;
            object3 = (CircularRevealWidget)object;
            if ((view = ((ImageView)view).getDrawable()) == null) {
                return;
            }
            view.mutate();
            int n10 = 255;
            int n11 = 1;
            if (bl2) {
                if (!bl3) {
                    view.setAlpha(n10);
                }
                property = DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT;
                object2 = new int[n11];
                object2[0] = 0;
                property = ObjectAnimator.ofInt((Object)view, (Property)property, (int[])object2);
            } else {
                property = DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT;
                object2 = new int[n11];
                object2[0] = n10;
                property = ObjectAnimator.ofInt((Object)view, (Property)property, (int[])object2);
            }
            object2 = new FabTransformationBehavior$2;
            object2(this, (View)object);
            property.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
            object = fabTransformationBehavior$FabTransformationSpec.timings;
            object2 = "iconFade";
            object.getTiming((String)object2).apply((Animator)property);
            list.add(property);
            object = new FabTransformationBehavior$3(this, (CircularRevealWidget)object3, (Drawable)view);
            list2.add(object);
        }
    }

    private void createPostFillRadialExpansion(View view, long l10, long l11, long l12, int n10, int n11, float f10, List list) {
        long l13;
        long l14;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13 && (l14 = (l13 = (l10 += l11) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            view = ViewAnimationUtils.createCircularReveal((View)view, (int)n10, (int)n11, (float)f10, (float)f10);
            view.setStartDelay(l10);
            view.setDuration(l12 -= l10);
            list.add(view);
        }
    }

    private void createPreFillRadialExpansion(View view, long l10, int n10, int n11, float f10, List list) {
        long l11;
        long l12;
        long l13;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13 && (l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            view = ViewAnimationUtils.createCircularReveal((View)view, (int)n10, (int)n11, (float)f10, (float)f10);
            view.setStartDelay(l11);
            view.setDuration(l10);
            list.add(view);
        }
    }

    private void createTranslationAnimation(View view, View view2, boolean bl2, boolean bl3, FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec, List list, List list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        String string2;
        Object object;
        MotionTiming motionTiming;
        float f10;
        float f11;
        View view3 = view2;
        FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec2 = fabTransformationBehavior$FabTransformationSpec;
        List list3 = list;
        Object object2 = fabTransformationBehavior$FabTransformationSpec.positioning;
        float f12 = this.calculateTranslationX(view, view2, (Positioning)object2);
        Object object3 = fabTransformationBehavior$FabTransformationSpec.positioning;
        float f13 = this.calculateTranslationY(view, view2, (Positioning)object3);
        object3 = null;
        float f14 = f12 - 0.0f;
        Object object4 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object4 != false && (object4 = (f11 = f13 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            float f15;
            if (bl2 && (f10 = (f15 = f13 - 0.0f) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) < 0 || !bl2 && object4 > 0) {
                motionTiming = fabTransformationBehavior$FabTransformationSpec2.timings.getTiming("translationXCurveUpwards");
                object = fabTransformationBehavior$FabTransformationSpec2.timings;
                string2 = "translationYCurveUpwards";
                object = ((MotionSpec)object).getTiming(string2);
            } else {
                motionTiming = fabTransformationBehavior$FabTransformationSpec2.timings.getTiming("translationXCurveDownwards");
                object = fabTransformationBehavior$FabTransformationSpec2.timings;
                string2 = "translationYCurveDownwards";
                object = ((MotionSpec)object).getTiming(string2);
            }
        } else {
            motionTiming = fabTransformationBehavior$FabTransformationSpec2.timings.getTiming("translationXLinear");
            object = fabTransformationBehavior$FabTransformationSpec2.timings;
            string2 = "translationYLinear";
            object = ((MotionSpec)object).getTiming(string2);
        }
        MotionTiming motionTiming2 = motionTiming;
        Object object5 = object;
        object4 = false;
        float f16 = 0.0f;
        motionTiming = null;
        f10 = 1.0f;
        float f17 = Float.MIN_VALUE;
        if (bl2) {
            float f18;
            if (!bl3) {
                f18 = -f12;
                view3.setTranslationX(f18);
                f18 = -f13;
                view3.setTranslationY(f18);
            }
            string2 = View.TRANSLATION_X;
            float[] fArray = new float[f10];
            fArray[0] = 0.0f;
            objectAnimator2 = ObjectAnimator.ofFloat((Object)view3, (Property)string2, (float[])fArray);
            string2 = View.TRANSLATION_Y;
            object = new float[f10];
            object[0] = 0.0f;
            objectAnimator = ObjectAnimator.ofFloat((Object)view3, (Property)string2, (float[])object);
            f16 = -f12;
            f17 = -f13;
            f18 = 0.0f;
            string2 = null;
            fArray = null;
            view3 = view2;
            fabTransformationBehavior$FabTransformationSpec2 = fabTransformationBehavior$FabTransformationSpec;
            object2 = motionTiming2;
            object3 = object5;
            this.calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationBehavior$FabTransformationSpec, motionTiming2, (MotionTiming)object5, f16, f17, 0.0f, 0.0f, rectF);
        } else {
            fabTransformationBehavior$FabTransformationSpec2 = View.TRANSLATION_X;
            object3 = new float[f10];
            f12 = -f12;
            object3[0] = f12;
            objectAnimator2 = ObjectAnimator.ofFloat((Object)view3, (Property)fabTransformationBehavior$FabTransformationSpec2, (float[])object3);
            fabTransformationBehavior$FabTransformationSpec2 = View.TRANSLATION_Y;
            object2 = new float[f10];
            f13 = -f13;
            object2[0] = f13;
            objectAnimator = ObjectAnimator.ofFloat((Object)view3, (Property)fabTransformationBehavior$FabTransformationSpec2, (float[])object2);
        }
        motionTiming2.apply((Animator)objectAnimator2);
        ((MotionTiming)object5).apply((Animator)objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private int getBackgroundTint(View object) {
        ColorStateList colorStateList = ViewCompat.getBackgroundTintList(object);
        if (colorStateList != null) {
            object = object.getDrawableState();
            int n10 = colorStateList.getDefaultColor();
            return colorStateList.getColorForState((int[])object, n10);
        }
        return 0;
    }

    private ViewGroup toViewGroupOrNull(View view) {
        boolean bl2 = view instanceof ViewGroup;
        if (bl2) {
            return (ViewGroup)view;
        }
        return null;
    }

    public boolean layoutDependsOn(CoordinatorLayout object, View view, View object2) {
        int n10;
        int n11 = view.getVisibility();
        if (n11 != (n10 = 8)) {
            int n12;
            n11 = object2 instanceof FloatingActionButton;
            n10 = 0;
            if (n11 != 0 && ((n11 = ((FloatingActionButton)(object2 = (FloatingActionButton)object2)).getExpandedComponentIdHint()) == 0 || n11 == (n12 = view.getId()))) {
                n10 = 1;
            }
            return n10 != 0;
        }
        object = new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        throw object;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        int n10 = coordinatorLayout$LayoutParams.dodgeInsetEdges;
        if (n10 == 0) {
            coordinatorLayout$LayoutParams.dodgeInsetEdges = n10 = 80;
        }
    }

    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean bl2, boolean bl3) {
        Object object;
        FabTransformationBehavior fabTransformationBehavior = this;
        boolean bl4 = bl2;
        Object object2 = view2.getContext();
        FabTransformationBehavior$FabTransformationSpec fabTransformationBehavior$FabTransformationSpec = this.onCreateMotionSpec((Context)object2, bl2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object2 = this;
            object = view;
            this.createElevationAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, arrayList, arrayList2);
        }
        Object object3 = fabTransformationBehavior.tmpRectF1;
        object2 = this;
        object = view;
        this.createTranslationAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, arrayList, arrayList2, (RectF)object3);
        float f10 = object3.width();
        float f11 = object3.height();
        this.createIconFadeAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, arrayList, arrayList2);
        object3 = arrayList2;
        this.createExpansionAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, f10, f11, arrayList, arrayList2);
        this.createColorAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, arrayList, arrayList2);
        this.createChildrenFadeAnimation(view, view2, bl2, bl3, fabTransformationBehavior$FabTransformationSpec, arrayList, arrayList2);
        object2 = new AnimatorSet();
        AnimatorSetCompat.playTogether((AnimatorSet)object2, arrayList);
        View view3 = view2;
        object = new FabTransformationBehavior$1(this, bl4, view2, view);
        object2.addListener((Animator.AnimatorListener)object);
        object = null;
        int n12 = arrayList2.size();
        for (n11 = 0; n11 < n12; ++n11) {
            view3 = (Animator.AnimatorListener)arrayList2.get(n11);
            object2.addListener((Animator.AnimatorListener)view3);
        }
        return object2;
    }

    public abstract FabTransformationBehavior$FabTransformationSpec onCreateMotionSpec(Context var1, boolean var2);
}

