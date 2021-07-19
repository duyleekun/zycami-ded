/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.FrameLayout
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import com.google.android.material.R$styleable;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener;

public class BaseTransientBottomBar$SnackbarBaseLayout
extends FrameLayout {
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar$OnAttachStateChangeListener onAttachStateChangeListener;
    private BaseTransientBottomBar$OnLayoutChangeListener onLayoutChangeListener;
    private final AccessibilityManagerCompat$TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context) {
        this(context, null);
    }

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet object) {
        super(context, object);
        int[] nArray = R$styleable.SnackbarLayout;
        object = context.obtainStyledAttributes(object, nArray);
        int n10 = R$styleable.SnackbarLayout_elevation;
        boolean bl2 = object.hasValue(n10);
        if (bl2) {
            bl2 = false;
            n10 = object.getDimensionPixelSize(n10, 0);
            float f10 = n10;
            ViewCompat.setElevation((View)this, f10);
        }
        object.recycle();
        context = (AccessibilityManager)context.getSystemService("accessibility");
        this.accessibilityManager = context;
        super(this);
        this.touchExplorationStateChangeListener = object;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener((AccessibilityManager)context, (AccessibilityManagerCompat$TouchExplorationStateChangeListener)object);
        boolean bl3 = context.isTouchExplorationEnabled();
        this.setClickableOrFocusableBasedOnAccessibility(bl3);
    }

    public static /* synthetic */ void access$300(BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout, boolean bl2) {
        baseTransientBottomBar$SnackbarBaseLayout.setClickableOrFocusableBasedOnAccessibility(bl2);
    }

    private void setClickableOrFocusableBasedOnAccessibility(boolean bl2) {
        boolean bl3 = bl2 ^ true;
        this.setClickable(bl3);
        this.setFocusable(bl2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener = this.onAttachStateChangeListener;
        if (baseTransientBottomBar$OnAttachStateChangeListener != null) {
            baseTransientBottomBar$OnAttachStateChangeListener.onViewAttachedToWindow((View)this);
        }
        ViewCompat.requestApplyInsets((View)this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener = this.onAttachStateChangeListener;
        if (baseTransientBottomBar$OnAttachStateChangeListener != null) {
            baseTransientBottomBar$OnAttachStateChangeListener.onViewDetachedFromWindow((View)this);
        }
        baseTransientBottomBar$OnAttachStateChangeListener = this.accessibilityManager;
        AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener = this.touchExplorationStateChangeListener;
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener((AccessibilityManager)baseTransientBottomBar$OnAttachStateChangeListener, accessibilityManagerCompat$TouchExplorationStateChangeListener);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        BaseTransientBottomBar$OnLayoutChangeListener baseTransientBottomBar$OnLayoutChangeListener = this.onLayoutChangeListener;
        if (baseTransientBottomBar$OnLayoutChangeListener != null) {
            baseTransientBottomBar$OnLayoutChangeListener.onLayoutChange((View)this, n10, n11, n12, n13);
        }
    }

    public void setOnAttachStateChangeListener(BaseTransientBottomBar$OnAttachStateChangeListener baseTransientBottomBar$OnAttachStateChangeListener) {
        this.onAttachStateChangeListener = baseTransientBottomBar$OnAttachStateChangeListener;
    }

    public void setOnLayoutChangeListener(BaseTransientBottomBar$OnLayoutChangeListener baseTransientBottomBar$OnLayoutChangeListener) {
        this.onLayoutChangeListener = baseTransientBottomBar$OnLayoutChangeListener;
    }
}

