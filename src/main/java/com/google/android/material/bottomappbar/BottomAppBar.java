/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.bottomappbar.BottomAppBar$1;
import com.google.android.material.bottomappbar.BottomAppBar$2;
import com.google.android.material.bottomappbar.BottomAppBar$3;
import com.google.android.material.bottomappbar.BottomAppBar$4;
import com.google.android.material.bottomappbar.BottomAppBar$5;
import com.google.android.material.bottomappbar.BottomAppBar$6;
import com.google.android.material.bottomappbar.BottomAppBar$7;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;
import com.google.android.material.bottomappbar.BottomAppBar$SavedState;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePathModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BottomAppBar
extends Toolbar
implements CoordinatorLayout$AttachedBehavior {
    private static final long ANIMATION_DURATION = 300L;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    private Animator attachAnimator;
    private int fabAlignmentMode;
    public AnimatorListenerAdapter fabAnimationListener;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    private boolean hideOnScroll;
    private final MaterialShapeDrawable materialShapeDrawable;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private final BottomAppBarTopEdgeTreatment topEdgeTreatment;

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.bottomAppBarStyle;
        this(context, attributeSet, n10);
    }

    public BottomAppBar(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        int n11;
        int n12;
        boolean bl2;
        this.fabAttached = bl2 = true;
        BottomAppBar$7 bottomAppBar$7 = new BottomAppBar$7(this);
        this.fabAnimationListener = bottomAppBar$7;
        int[] nArray = R$styleable.BottomAppBar;
        int n13 = R$style.Widget_MaterialComponents_BottomAppBar;
        int[] nArray2 = new int[]{};
        object = ThemeEnforcement.obtainStyledAttributes(context, (AttributeSet)object, nArray, n10, n13, nArray2);
        n10 = R$styleable.BottomAppBar_backgroundTint;
        context = MaterialResources.getColorStateList(context, (TypedArray)object, n10);
        n10 = R$styleable.BottomAppBar_fabCradleMargin;
        float f10 = object.getDimensionPixelOffset(n10, 0);
        int n14 = R$styleable.BottomAppBar_fabCradleRoundedCornerRadius;
        float f11 = object.getDimensionPixelOffset(n14, 0);
        int n15 = R$styleable.BottomAppBar_fabCradleVerticalOffset;
        float f12 = object.getDimensionPixelOffset(n15, 0);
        int n16 = R$styleable.BottomAppBar_fabAlignmentMode;
        this.fabAlignmentMode = n16 = object.getInt(n16, 0);
        n16 = R$styleable.BottomAppBar_hideOnScroll;
        this.hideOnScroll = n12 = object.getBoolean(n16, false);
        object.recycle();
        object = this.getResources();
        n12 = R$dimen.mtrl_bottomappbar_fabOffsetEndMode;
        this.fabOffsetEndMode = n11 = object.getDimensionPixelOffset(n12);
        super(f10, f11, f12);
        this.topEdgeTreatment = object;
        ShapePathModel shapePathModel = new ShapePathModel();
        shapePathModel.setTopEdge((EdgeTreatment)object);
        super(shapePathModel);
        this.materialShapeDrawable = object;
        ((MaterialShapeDrawable)object).setShadowEnabled(bl2);
        shapePathModel = Paint.Style.FILL;
        ((MaterialShapeDrawable)object).setPaintStyle((Paint.Style)shapePathModel);
        DrawableCompat.setTintList((Drawable)object, (ColorStateList)context);
        ViewCompat.setBackground((View)this, (Drawable)object);
    }

    public static /* synthetic */ Animator access$002(BottomAppBar bottomAppBar, Animator animator2) {
        bottomAppBar.modeAnimator = animator2;
        return animator2;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$100(BottomAppBar bottomAppBar) {
        return bottomAppBar.topEdgeTreatment;
    }

    public static /* synthetic */ void access$1000(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        bottomAppBar.addFabAnimationListeners(floatingActionButton);
    }

    public static /* synthetic */ FloatingActionButton access$1100(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentFab();
    }

    public static /* synthetic */ boolean access$1200(BottomAppBar bottomAppBar) {
        return bottomAppBar.isAnimationRunning();
    }

    public static /* synthetic */ void access$1300(BottomAppBar bottomAppBar) {
        bottomAppBar.setCutoutState();
    }

    public static /* synthetic */ float access$1400(BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationY();
    }

    public static /* synthetic */ MaterialShapeDrawable access$200(BottomAppBar bottomAppBar) {
        return bottomAppBar.materialShapeDrawable;
    }

    public static /* synthetic */ Animator access$302(BottomAppBar bottomAppBar, Animator animator2) {
        bottomAppBar.menuAnimator = animator2;
        return animator2;
    }

    public static /* synthetic */ void access$400(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int n10, boolean bl2) {
        bottomAppBar.translateActionMenuView(actionMenuView, n10, bl2);
    }

    public static /* synthetic */ Animator access$502(BottomAppBar bottomAppBar, Animator animator2) {
        bottomAppBar.attachAnimator = animator2;
        return animator2;
    }

    public static /* synthetic */ boolean access$600(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAttached;
    }

    public static /* synthetic */ void access$700(BottomAppBar bottomAppBar, boolean bl2) {
        bottomAppBar.maybeAnimateAttachChange(bl2);
    }

    public static /* synthetic */ int access$800(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAlignmentMode;
    }

    public static /* synthetic */ void access$900(BottomAppBar bottomAppBar, int n10, boolean bl2) {
        bottomAppBar.maybeAnimateMenuView(n10, bl2);
    }

    private void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        this.removeFabAnimationListeners(floatingActionButton);
        AnimatorListenerAdapter animatorListenerAdapter = this.fabAnimationListener;
        floatingActionButton.addOnHideAnimationListener((Animator.AnimatorListener)animatorListenerAdapter);
        animatorListenerAdapter = this.fabAnimationListener;
        floatingActionButton.addOnShowAnimationListener((Animator.AnimatorListener)animatorListenerAdapter);
    }

    private void cancelAnimations() {
        Animator animator2 = this.attachAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        if ((animator2 = this.menuAnimator) != null) {
            animator2.cancel();
        }
        if ((animator2 = this.modeAnimator) != null) {
            animator2.cancel();
        }
    }

    /*
     * WARNING - void declaration
     */
    private void createCradleShapeAnimation(boolean bl2, List list) {
        void var2_4;
        ValueAnimator valueAnimator;
        float f10;
        float f11;
        Object object;
        if (bl2) {
            object = this.topEdgeTreatment;
            f11 = this.getFabTranslationX();
            ((BottomAppBarTopEdgeTreatment)object).setHorizontalOffset(f11);
        }
        int n10 = 2;
        object = new float[n10];
        MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
        float f12 = materialShapeDrawable.getInterpolation();
        object[0] = f12;
        int n11 = 1;
        f11 = Float.MIN_VALUE;
        if (bl2) {
            int n12 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
            valueAnimator = null;
        }
        object[n11] = f10;
        valueAnimator = ValueAnimator.ofFloat((float[])object);
        object = new BottomAppBar$6(this);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        valueAnimator.setDuration(300L);
        var2_4.add(valueAnimator);
    }

    private void createCradleTranslationAnimation(int n10, List list) {
        float f10;
        boolean bl2 = this.fabAttached;
        if (!bl2) {
            return;
        }
        float f11 = this.topEdgeTreatment.getHorizontalOffset();
        Object object = new float[]{f11, f10 = (float)this.getFabTranslationX(n10)};
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])object);
        object = new BottomAppBar$2;
        object(this);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        valueAnimator.setDuration(300L);
        list.add(valueAnimator);
    }

    private void createFabTranslationXAnimation(int n10, List list) {
        FloatingActionButton floatingActionButton = this.findDependentFab();
        float f10 = this.getFabTranslationX(n10);
        float[] fArray = new float[]{f10};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)floatingActionButton, (String)"translationX", (float[])fArray);
        objectAnimator.setDuration(300L);
        list.add(objectAnimator);
    }

    private void createFabTranslationYAnimation(boolean bl2, List list) {
        FloatingActionButton floatingActionButton = this.findDependentFab();
        if (floatingActionButton == null) {
            return;
        }
        float f10 = this.getFabTranslationY(bl2);
        float[] fArray = new float[]{f10};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)floatingActionButton, (String)"translationY", (float[])fArray);
        objectAnimator.setDuration(300L);
        list.add(objectAnimator);
    }

    /*
     * WARNING - void declaration
     */
    private void createMenuViewTranslationAnimation(int n10, boolean bl2, List list) {
        void var3_4;
        float f10;
        ActionMenuView actionMenuView = this.getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        int n11 = 1;
        Object object = new float[n11];
        object[0] = f10 = 1.0f;
        Object object2 = "alpha";
        object = ObjectAnimator.ofFloat((Object)actionMenuView, (String)object2, (float[])object);
        int n12 = this.fabAttached;
        if (n12 == 0 && (!bl2 || (n12 = (int)(this.isVisibleFab() ? 1 : 0)) == 0) || (n12 = this.fabAlignmentMode) != n11 && n10 != n11) {
            float f11 = actionMenuView.getAlpha();
            float f12 = f11 - f10;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1));
            if (n10 < 0) {
                var3_4.add(object);
            }
        } else {
            Object object3 = new float[n11];
            n12 = 0;
            object3[0] = 0.0f;
            object3 = ObjectAnimator.ofFloat((Object)actionMenuView, (String)object2, (float[])object3);
            object2 = new BottomAppBar$4(this, actionMenuView, n10, bl2);
            object3.addListener((Animator.AnimatorListener)object2);
            AnimatorSet animatorSet = new AnimatorSet();
            long l10 = 150L;
            animatorSet.setDuration(l10);
            int n13 = 2;
            Animator[] animatorArray = new Animator[n13];
            animatorArray[0] = (Animator)object3;
            animatorArray[n11] = (Animator)object;
            animatorSet.playSequentially(animatorArray);
            var3_4.add(animatorSet);
        }
    }

    private FloatingActionButton findDependentFab() {
        boolean bl2;
        Object object = this.getParent();
        boolean bl3 = object instanceof CoordinatorLayout;
        if (!bl3) {
            return null;
        }
        object = ((CoordinatorLayout)this.getParent()).getDependents((View)this).iterator();
        while (bl2 = object.hasNext()) {
            View view = (View)object.next();
            boolean bl4 = view instanceof FloatingActionButton;
            if (!bl4) continue;
            return (FloatingActionButton)view;
        }
        return null;
    }

    private ActionMenuView getActionMenuView() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            View view = this.getChildAt(i10);
            boolean bl2 = view instanceof ActionMenuView;
            if (!bl2) continue;
            return (ActionMenuView)view;
        }
        return null;
    }

    private float getFabTranslationX() {
        int n10 = this.fabAlignmentMode;
        return this.getFabTranslationX(n10);
    }

    private int getFabTranslationX(int n10) {
        int n11 = ViewCompat.getLayoutDirection((View)this);
        int n12 = 0;
        int n13 = 1;
        n11 = n11 == n13 ? n13 : 0;
        if (n10 == n13) {
            n10 = this.getMeasuredWidth() / 2;
            n12 = this.fabOffsetEndMode;
            n10 -= n12;
            if (n11 != 0) {
                n13 = -1;
            }
            n12 = n10 * n13;
        }
        return n12;
    }

    private float getFabTranslationY() {
        boolean bl2 = this.fabAttached;
        return this.getFabTranslationY(bl2);
    }

    private float getFabTranslationY(boolean bl2) {
        FloatingActionButton floatingActionButton = this.findDependentFab();
        int n10 = 0;
        float f10 = 0.0f;
        if (floatingActionButton == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        floatingActionButton.getContentRect(rect);
        int n11 = rect.height();
        float f11 = n11;
        float f12 = f11 - 0.0f;
        n10 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (n10 == 0) {
            n10 = floatingActionButton.getMeasuredHeight();
            f11 = n10;
        }
        n10 = floatingActionButton.getHeight();
        int n12 = rect.bottom;
        f10 = n10 -= n12;
        n12 = floatingActionButton.getHeight();
        int n13 = rect.height();
        float f13 = n12 -= n13;
        float f14 = -this.getCradleVerticalOffset();
        float f15 = 2.0f;
        f14 = f14 + (f11 /= f15) + f10;
        float f16 = floatingActionButton.getPaddingBottom();
        f13 -= f16;
        int n14 = -this.getMeasuredHeight();
        f16 = n14;
        if (!bl2) {
            f14 = f13;
        }
        return f16 + f14;
    }

    private boolean isAnimationRunning() {
        boolean bl2;
        Animator animator2 = this.attachAnimator;
        if (animator2 != null && (bl2 = animator2.isRunning()) || (animator2 = this.menuAnimator) != null && (bl2 = animator2.isRunning()) || (animator2 = this.modeAnimator) != null && (bl2 = animator2.isRunning())) {
            bl2 = true;
        } else {
            bl2 = false;
            animator2 = null;
        }
        return bl2;
    }

    private boolean isVisibleFab() {
        boolean bl2;
        FloatingActionButton floatingActionButton = this.findDependentFab();
        if (floatingActionButton != null && (bl2 = floatingActionButton.isOrWillBeShown())) {
            bl2 = true;
        } else {
            bl2 = false;
            floatingActionButton = null;
        }
        return bl2;
    }

    private void maybeAnimateAttachChange(boolean bl2) {
        boolean bl3;
        boolean bl4 = ViewCompat.isLaidOut((View)this);
        if (!bl4) {
            return;
        }
        Object object = this.attachAnimator;
        if (object != null) {
            object.cancel();
        }
        object = new ArrayList();
        bl3 = bl2 && (bl3 = this.isVisibleFab());
        this.createCradleShapeAnimation(bl3, (List)object);
        this.createFabTranslationYAnimation(bl2, (List)object);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Collection)object);
        this.attachAnimator = animatorSet;
        object = new BottomAppBar$5(this);
        animatorSet.addListener((Animator.AnimatorListener)object);
        this.attachAnimator.start();
    }

    private void maybeAnimateMenuView(int n10, boolean bl2) {
        BottomAppBar$3 bottomAppBar$3;
        AnimatorSet animatorSet;
        boolean bl3 = ViewCompat.isLaidOut((View)this);
        if (!bl3) {
            return;
        }
        Object object = this.menuAnimator;
        if (object != null) {
            object.cancel();
        }
        object = new ArrayList();
        boolean bl4 = this.isVisibleFab();
        if (!bl4) {
            n10 = 0;
            animatorSet = null;
            bl2 = false;
            bottomAppBar$3 = null;
        }
        this.createMenuViewTranslationAnimation(n10, bl2, (List)object);
        animatorSet = new AnimatorSet();
        animatorSet.playTogether((Collection)object);
        this.menuAnimator = animatorSet;
        bottomAppBar$3 = new BottomAppBar$3(this);
        animatorSet.addListener((Animator.AnimatorListener)bottomAppBar$3);
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int n10) {
        int n11 = this.fabAlignmentMode;
        if (n11 != n10 && (n11 = (int)(ViewCompat.isLaidOut((View)this) ? 1 : 0)) != 0) {
            Object object = this.modeAnimator;
            if (object != null) {
                object.cancel();
            }
            object = new ArrayList();
            this.createCradleTranslationAnimation(n10, (List)object);
            this.createFabTranslationXAnimation(n10, (List)object);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether((Collection)object);
            this.modeAnimator = animatorSet;
            object = new BottomAppBar$1(this);
            animatorSet.addListener((Animator.AnimatorListener)object);
            animatorSet = this.modeAnimator;
            animatorSet.start();
        }
    }

    private void removeFabAnimationListeners(FloatingActionButton floatingActionButton) {
        AnimatorListenerAdapter animatorListenerAdapter = this.fabAnimationListener;
        floatingActionButton.removeOnHideAnimationListener((Animator.AnimatorListener)animatorListenerAdapter);
        animatorListenerAdapter = this.fabAnimationListener;
        floatingActionButton.removeOnShowAnimationListener((Animator.AnimatorListener)animatorListenerAdapter);
    }

    private void setCutoutState() {
        float f10;
        Object object = this.topEdgeTreatment;
        float f11 = this.getFabTranslationX();
        ((BottomAppBarTopEdgeTreatment)object).setHorizontalOffset(f11);
        object = this.findDependentFab();
        MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
        boolean bl2 = this.fabAttached;
        boolean bl3 = 1065353216 != 0;
        float f12 = 1.0f;
        if (bl2 && (bl2 = this.isVisibleFab())) {
            bl2 = bl3;
            f10 = f12;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        materialShapeDrawable.setInterpolation(f10);
        if (object != null) {
            f11 = this.getFabTranslationY();
            object.setTranslationY(f11);
            f11 = this.getFabTranslationX();
            object.setTranslationX(f11);
        }
        if ((object = this.getActionMenuView()) != null) {
            object.setAlpha(f12);
            int n10 = this.isVisibleFab();
            if (n10 == 0) {
                n10 = 0;
                f11 = 0.0f;
                materialShapeDrawable = null;
                this.translateActionMenuView((ActionMenuView)object, 0, false);
            } else {
                n10 = this.fabAlignmentMode;
                bl2 = this.fabAttached;
                this.translateActionMenuView((ActionMenuView)object, n10, bl2);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void translateActionMenuView(ActionMenuView var1_1, int var2_2, boolean var3_3) {
        var4_4 = ViewCompat.getLayoutDirection((View)this);
        var4_4 = var4_4 == (var5_5 = 1) ? var5_5 : 0;
        var7_7 = 0;
        for (var6_6 = 0; var6_6 < (var8_8 = this.getChildCount()); ++var6_6) {
            var9_9 = this.getChildAt(var6_6);
            var10_10 /* !! */  = var9_9.getLayoutParams();
            var11_11 = var10_10 /* !! */  instanceof Toolbar$LayoutParams;
            if (var11_11 == 0) ** GOTO lbl-1000
            var10_10 /* !! */  = (Toolbar$LayoutParams)var9_9.getLayoutParams();
            var11_11 = var10_10 /* !! */ .gravity & 0x800007;
            var12_12 = 0x800003;
            if (var11_11 == var12_12) {
                var11_11 = var5_5;
            } else lbl-1000:
            // 2 sources

            {
                var11_11 = 0;
                var10_10 /* !! */  = null;
            }
            if (var11_11 == 0) continue;
            var8_8 = var4_4 != 0 ? var9_9.getLeft() : var9_9.getRight();
            var7_7 = Math.max(var7_7, var8_8);
        }
        var4_4 = var4_4 != 0 ? var1_1.getRight() : var1_1.getLeft();
        var7_7 -= var4_4;
        if (var2_2 == var5_5 && var3_3) {
            var13_13 = var7_7;
        } else {
            var2_2 = 0;
            var13_13 = 0.0f;
        }
        var1_1.setTranslationX(var13_13);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public CoordinatorLayout$Behavior getBehavior() {
        BottomAppBar$Behavior bottomAppBar$Behavior = new BottomAppBar$Behavior();
        return bottomAppBar$Behavior;
    }

    public float getCradleVerticalOffset() {
        return this.topEdgeTreatment.getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public float getFabCradleMargin() {
        return this.topEdgeTreatment.getFabCradleMargin();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.topEdgeTreatment.getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        this.cancelAnimations();
        this.setCutoutState();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2;
        int n10 = parcelable instanceof BottomAppBar$SavedState;
        if (n10 == 0) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (BottomAppBar$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable2);
        this.fabAlignmentMode = n10 = parcelable.fabAlignmentMode;
        this.fabAttached = bl2 = parcelable.fabAttached;
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        Parcelable parcelable = super.onSaveInstanceState();
        BottomAppBar$SavedState bottomAppBar$SavedState = new BottomAppBar$SavedState(parcelable);
        bottomAppBar$SavedState.fabAlignmentMode = n10 = this.fabAlignmentMode;
        n10 = (int)(this.fabAttached ? 1 : 0);
        bottomAppBar$SavedState.fabAttached = n10;
        return bottomAppBar$SavedState;
    }

    public void replaceMenu(int n10) {
        this.getMenu().clear();
        this.inflateMenu(n10);
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        float f11 = this.getCradleVerticalOffset();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
            bottomAppBarTopEdgeTreatment.setCradleVerticalOffset(f10);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabAlignmentMode(int n10) {
        this.maybeAnimateModeChange(n10);
        boolean bl2 = this.fabAttached;
        this.maybeAnimateMenuView(n10, bl2);
        this.fabAlignmentMode = n10;
    }

    public void setFabCradleMargin(float f10) {
        float f11 = this.getFabCradleMargin();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
            bottomAppBarTopEdgeTreatment.setFabCradleMargin(f10);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        float f11 = this.getFabCradleRoundedCornerRadius();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
            bottomAppBarTopEdgeTreatment.setFabCradleRoundedCornerRadius(f10);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabDiameter(int n10) {
        float f10 = n10;
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
        float f11 = bottomAppBarTopEdgeTreatment.getFabDiameter();
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            bottomAppBarTopEdgeTreatment = this.topEdgeTreatment;
            bottomAppBarTopEdgeTreatment.setFabDiameter(f10);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            materialShapeDrawable.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean bl2) {
        this.hideOnScroll = bl2;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }
}

