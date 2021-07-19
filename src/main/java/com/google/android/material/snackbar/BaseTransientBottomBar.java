/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityManager
 */
package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar$1;
import com.google.android.material.snackbar.BaseTransientBottomBar$10;
import com.google.android.material.snackbar.BaseTransientBottomBar$11;
import com.google.android.material.snackbar.BaseTransientBottomBar$4;
import com.google.android.material.snackbar.BaseTransientBottomBar$5;
import com.google.android.material.snackbar.BaseTransientBottomBar$6;
import com.google.android.material.snackbar.BaseTransientBottomBar$7;
import com.google.android.material.snackbar.BaseTransientBottomBar$8;
import com.google.android.material.snackbar.BaseTransientBottomBar$9;
import com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback;
import com.google.android.material.snackbar.BaseTransientBottomBar$Behavior;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener;
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;
import com.google.android.material.snackbar.ContentViewCallback;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.snackbar.SnackbarManager$Callback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar {
    public static final int ANIMATION_DURATION = 250;
    public static final int ANIMATION_FADE_DURATION = 180;
    public static final int LENGTH_INDEFINITE = 254;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = 255;
    public static final int MSG_DISMISS = 1;
    public static final int MSG_SHOW;
    private static final int[] SNACKBAR_STYLE_ATTR;
    private static final boolean USE_OFFSET_API;
    public static final Handler handler;
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar$Behavior behavior;
    private List callbacks;
    private final ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    public final SnackbarManager$Callback managerCallback;
    private final ViewGroup targetParent;
    public final BaseTransientBottomBar$SnackbarBaseLayout view;

    static {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        BaseTransientBottomBar$1 baseTransientBottomBar$1 = null;
        int n12 = 16;
        if (n10 >= n12 && n10 <= (n12 = 19)) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        USE_OFFSET_API = n10;
        object = new int[n11];
        object[0] = n11 = R$attr.snackbarStyle;
        SNACKBAR_STYLE_ATTR = object;
        object = new Handler;
        Looper looper = Looper.getMainLooper();
        baseTransientBottomBar$1 = new BaseTransientBottomBar$1();
        object(looper, (Handler.Callback)baseTransientBottomBar$1);
        handler = (Handler)object;
    }

    public BaseTransientBottomBar(ViewGroup object, View object2, ContentViewCallback contentViewCallback) {
        BaseTransientBottomBar$4 baseTransientBottomBar$4 = new BaseTransientBottomBar$4(this);
        this.managerCallback = baseTransientBottomBar$4;
        if (object != null) {
            if (object2 != null) {
                if (contentViewCallback != null) {
                    this.targetParent = object;
                    this.contentViewCallback = contentViewCallback;
                    contentViewCallback = object.getContext();
                    this.context = contentViewCallback;
                    ThemeEnforcement.checkAppCompatTheme((Context)contentViewCallback);
                    baseTransientBottomBar$4 = LayoutInflater.from((Context)contentViewCallback);
                    int n10 = this.getSnackbarBaseLayoutResId();
                    object = (BaseTransientBottomBar$SnackbarBaseLayout)baseTransientBottomBar$4.inflate(n10, (ViewGroup)object, false);
                    this.view = object;
                    object.addView(object2);
                    boolean bl2 = true;
                    ViewCompat.setAccessibilityLiveRegion((View)object, (int)(bl2 ? 1 : 0));
                    ViewCompat.setImportantForAccessibility((View)object, (int)(bl2 ? 1 : 0));
                    ViewCompat.setFitsSystemWindows((View)object, bl2);
                    super(this);
                    ViewCompat.setOnApplyWindowInsetsListener((View)object, (OnApplyWindowInsetsListener)object2);
                    super(this);
                    ViewCompat.setAccessibilityDelegate((View)object, (AccessibilityDelegateCompat)object2);
                    object = (AccessibilityManager)contentViewCallback.getSystemService("accessibility");
                    this.accessibilityManager = object;
                    return;
                }
                super("Transient bottom bar must have non-null callback");
                throw object;
            }
            super("Transient bottom bar must have non-null content");
            throw object;
        }
        super("Transient bottom bar must have non-null parent");
        throw object;
    }

    public static /* synthetic */ ContentViewCallback access$100(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.contentViewCallback;
    }

    public static /* synthetic */ boolean access$200() {
        return USE_OFFSET_API;
    }

    private void animateViewOut(int n10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        int n11 = this.getTranslationYBottom();
        Object object = new int[]{0, n11};
        valueAnimator.setIntValues(object);
        object = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        valueAnimator.setInterpolator((TimeInterpolator)object);
        valueAnimator.setDuration(250L);
        object = (Object)new BaseTransientBottomBar$10;
        object(this, n10);
        valueAnimator.addListener((Animator.AnimatorListener)object);
        BaseTransientBottomBar$11 baseTransientBottomBar$11 = new BaseTransientBottomBar$11(this);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)baseTransientBottomBar$11);
        valueAnimator.start();
    }

    private int getTranslationYBottom() {
        BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout = this.view;
        int n10 = baseTransientBottomBar$SnackbarBaseLayout.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        boolean bl2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            int n11 = layoutParams.bottomMargin;
            n10 += n11;
        }
        return n10;
    }

    public BaseTransientBottomBar addCallback(BaseTransientBottomBar$BaseCallback baseTransientBottomBar$BaseCallback) {
        if (baseTransientBottomBar$BaseCallback == null) {
            return this;
        }
        ArrayList arrayList = this.callbacks;
        if (arrayList == null) {
            this.callbacks = arrayList = new ArrayList();
        }
        this.callbacks.add(baseTransientBottomBar$BaseCallback);
        return this;
    }

    public void animateViewIn() {
        BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout;
        int n10 = this.getTranslationYBottom();
        boolean bl2 = USE_OFFSET_API;
        if (bl2) {
            baseTransientBottomBar$SnackbarBaseLayout = this.view;
            ViewCompat.offsetTopAndBottom((View)baseTransientBottomBar$SnackbarBaseLayout, n10);
        } else {
            baseTransientBottomBar$SnackbarBaseLayout = this.view;
            float f10 = n10;
            baseTransientBottomBar$SnackbarBaseLayout.setTranslationY(f10);
        }
        baseTransientBottomBar$SnackbarBaseLayout = new ValueAnimator();
        Object object = new int[]{n10, 0};
        baseTransientBottomBar$SnackbarBaseLayout.setIntValues((int[])object);
        object = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        baseTransientBottomBar$SnackbarBaseLayout.setInterpolator((TimeInterpolator)object);
        baseTransientBottomBar$SnackbarBaseLayout.setDuration(250L);
        object = (Object)new BaseTransientBottomBar$8;
        object(this);
        baseTransientBottomBar$SnackbarBaseLayout.addListener((Animator.AnimatorListener)object);
        object = new BaseTransientBottomBar$9;
        object(this, n10);
        baseTransientBottomBar$SnackbarBaseLayout.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        baseTransientBottomBar$SnackbarBaseLayout.start();
    }

    public void dismiss() {
        this.dispatchDismiss(3);
    }

    public void dispatchDismiss(int n10) {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        SnackbarManager$Callback snackbarManager$Callback = this.managerCallback;
        snackbarManager.dismiss(snackbarManager$Callback, n10);
    }

    public BaseTransientBottomBar$Behavior getBehavior() {
        return this.behavior;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    public SwipeDismissBehavior getNewBehavior() {
        BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior = new BaseTransientBottomBar$Behavior();
        return baseTransientBottomBar$Behavior;
    }

    public int getSnackbarBaseLayoutResId() {
        int n10 = this.hasSnackbarStyleAttr();
        n10 = n10 != 0 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar;
        return n10;
    }

    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        Context context = this.context;
        int[] nArray = SNACKBAR_STYLE_ATTR;
        context = context.obtainStyledAttributes(nArray);
        boolean bl2 = false;
        nArray = null;
        int n10 = -1;
        int n11 = context.getResourceId(0, n10);
        context.recycle();
        if (n11 != n10) {
            bl2 = true;
        }
        return bl2;
    }

    public final void hideView(int n10) {
        BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout;
        int n11 = this.shouldAnimate();
        if (n11 != 0 && (n11 = (baseTransientBottomBar$SnackbarBaseLayout = this.view).getVisibility()) == 0) {
            this.animateViewOut(n10);
        } else {
            this.onViewHidden(n10);
        }
    }

    public boolean isShown() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        SnackbarManager$Callback snackbarManager$Callback = this.managerCallback;
        return snackbarManager.isCurrent(snackbarManager$Callback);
    }

    public boolean isShownOrQueued() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        SnackbarManager$Callback snackbarManager$Callback = this.managerCallback;
        return snackbarManager.isCurrentOrNext(snackbarManager$Callback);
    }

    public void onViewHidden(int n10) {
        ViewParent viewParent;
        int n11;
        Object object = SnackbarManager.getInstance();
        Object object2 = this.managerCallback;
        ((SnackbarManager)object).onDismissed((SnackbarManager$Callback)object2);
        object = this.callbacks;
        if (object != null) {
            for (n11 = object.size() + -1; n11 >= 0; n11 += -1) {
                object2 = (BaseTransientBottomBar$BaseCallback)this.callbacks.get(n11);
                ((BaseTransientBottomBar$BaseCallback)object2).onDismissed(this, n10);
            }
        }
        if ((n11 = (viewParent = this.view.getParent()) instanceof ViewGroup) != 0) {
            viewParent = (ViewGroup)viewParent;
            object = this.view;
            viewParent.removeView((View)object);
        }
    }

    public void onViewShown() {
        Object object = SnackbarManager.getInstance();
        Object object2 = this.managerCallback;
        ((SnackbarManager)object).onShown((SnackbarManager$Callback)object2);
        object = this.callbacks;
        if (object != null) {
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                object2 = (BaseTransientBottomBar$BaseCallback)this.callbacks.get(i10);
                ((BaseTransientBottomBar$BaseCallback)object2).onShown(this);
            }
        }
    }

    public BaseTransientBottomBar removeCallback(BaseTransientBottomBar$BaseCallback baseTransientBottomBar$BaseCallback) {
        if (baseTransientBottomBar$BaseCallback == null) {
            return this;
        }
        List list = this.callbacks;
        if (list == null) {
            return this;
        }
        list.remove(baseTransientBottomBar$BaseCallback);
        return this;
    }

    public BaseTransientBottomBar setBehavior(BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior) {
        this.behavior = baseTransientBottomBar$Behavior;
        return this;
    }

    public BaseTransientBottomBar setDuration(int n10) {
        this.duration = n10;
        return this;
    }

    public boolean shouldAnimate() {
        boolean bl2;
        Object object = this.accessibilityManager;
        boolean bl3 = true;
        if ((object = object.getEnabledAccessibilityServiceList((int)(bl3 ? 1 : 0))) == null || !(bl2 = object.isEmpty())) {
            bl3 = false;
        }
        return bl3;
    }

    public void show() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        int n10 = this.getDuration();
        SnackbarManager$Callback snackbarManager$Callback = this.managerCallback;
        snackbarManager.show(n10, snackbarManager$Callback);
    }

    public final void showView() {
        Object object;
        Object object2 = this.view.getParent();
        if (object2 == null) {
            object2 = this.view.getLayoutParams();
            int n10 = object2 instanceof CoordinatorLayout$LayoutParams;
            if (n10 != 0) {
                Object object3;
                boolean bl2;
                object2 = (CoordinatorLayout$LayoutParams)((Object)object2);
                object = this.behavior;
                if (object == null) {
                    object = this.getNewBehavior();
                }
                if (bl2 = object instanceof BaseTransientBottomBar$Behavior) {
                    object3 = object;
                    object3 = (BaseTransientBottomBar$Behavior)object;
                    BaseTransientBottomBar$Behavior.access$000((BaseTransientBottomBar$Behavior)object3, this);
                }
                object3 = new BaseTransientBottomBar$5(this);
                ((SwipeDismissBehavior)object).setListener((SwipeDismissBehavior$OnDismissListener)object3);
                ((CoordinatorLayout$LayoutParams)((Object)object2)).setBehavior((CoordinatorLayout$Behavior)object);
                ((CoordinatorLayout$LayoutParams)object2).insetEdge = n10 = 80;
            }
            object2 = this.targetParent;
            object = this.view;
            object2.addView((View)object);
        }
        object2 = this.view;
        object = new BaseTransientBottomBar$6(this);
        ((BaseTransientBottomBar$SnackbarBaseLayout)((Object)object2)).setOnAttachStateChangeListener((BaseTransientBottomBar$OnAttachStateChangeListener)object);
        object2 = this.view;
        boolean bl3 = ViewCompat.isLaidOut((View)object2);
        if (bl3) {
            bl3 = this.shouldAnimate();
            if (bl3) {
                this.animateViewIn();
            } else {
                this.onViewShown();
            }
        } else {
            object2 = this.view;
            object = new BaseTransientBottomBar$7(this);
            ((BaseTransientBottomBar$SnackbarBaseLayout)((Object)object2)).setOnLayoutChangeListener((BaseTransientBottomBar$OnLayoutChangeListener)object);
        }
    }
}

