/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.Button
 *  android.widget.FrameLayout
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback;
import com.google.android.material.snackbar.ContentViewCallback;
import com.google.android.material.snackbar.Snackbar$1;
import com.google.android.material.snackbar.Snackbar$Callback;
import com.google.android.material.snackbar.SnackbarContentLayout;

public final class Snackbar
extends BaseTransientBottomBar {
    public static final int LENGTH_INDEFINITE = 254;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = 255;
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar$BaseCallback callback;
    private boolean hasAction;

    static {
        int n10 = R$attr.snackbarButtonStyle;
        int[] nArray = new int[]{n10};
        SNACKBAR_BUTTON_STYLE_ATTR = nArray;
    }

    private Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        viewGroup = (AccessibilityManager)viewGroup.getContext().getSystemService("accessibility");
        this.accessibilityManager = viewGroup;
    }

    private static ViewGroup findSuitableParent(View view) {
        int n10 = 0;
        View view2 = null;
        do {
            int n11;
            if ((n11 = view instanceof CoordinatorLayout) != 0) {
                return (ViewGroup)view;
            }
            n11 = view instanceof FrameLayout;
            if (n11 != 0) {
                n10 = view.getId();
                if (n10 == (n11 = 0x1020002)) {
                    return (ViewGroup)view;
                }
                view2 = view;
                view2 = (ViewGroup)view;
            }
            if (view == null || (n11 = (view = view.getParent()) instanceof View) != 0) continue;
            view = null;
        } while (view != null);
        return view2;
    }

    public static boolean hasSnackbarButtonStyleAttr(Context context) {
        int[] nArray = SNACKBAR_BUTTON_STYLE_ATTR;
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

    public static Snackbar make(View view, int n10, int n11) {
        CharSequence charSequence = view.getResources().getText(n10);
        return Snackbar.make(view, charSequence, n11);
    }

    public static Snackbar make(View object, CharSequence charSequence, int n10) {
        if ((object = Snackbar.findSuitableParent(object)) != null) {
            Object object2 = LayoutInflater.from((Context)object.getContext());
            Object object3 = object.getContext();
            int n11 = Snackbar.hasSnackbarButtonStyleAttr((Context)object3);
            n11 = n11 != 0 ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include;
            object2 = (SnackbarContentLayout)object2.inflate(n11, (ViewGroup)object, false);
            object3 = new Snackbar((ViewGroup)object, (View)object2, (ContentViewCallback)object2);
            ((Snackbar)object3).setText(charSequence);
            ((BaseTransientBottomBar)object3).setDuration(n10);
            return object3;
        }
        object = new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        throw object;
    }

    public void dismiss() {
        super.dismiss();
    }

    public int getDuration() {
        AccessibilityManager accessibilityManager;
        int n10 = this.hasAction;
        n10 = n10 != 0 && (n10 = (int)((accessibilityManager = this.accessibilityManager).isTouchExplorationEnabled() ? 1 : 0)) != 0 ? -2 : super.getDuration();
        return n10;
    }

    public boolean isShown() {
        return super.isShown();
    }

    public Snackbar setAction(int n10, View.OnClickListener onClickListener) {
        CharSequence charSequence = this.getContext().getText(n10);
        return this.setAction(charSequence, onClickListener);
    }

    public Snackbar setAction(CharSequence object, View.OnClickListener onClickListener) {
        Button button = ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && onClickListener != null) {
            this.hasAction = bl2 = true;
            button.setVisibility(0);
            button.setText((CharSequence)object);
            object = new Snackbar$1(this, onClickListener);
            button.setOnClickListener((View.OnClickListener)object);
        } else {
            button.setVisibility(8);
            object = null;
            button.setOnClickListener(null);
            this.hasAction = false;
        }
        return this;
    }

    public Snackbar setActionTextColor(int n10) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(n10);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    public Snackbar setCallback(Snackbar$Callback snackbar$Callback) {
        BaseTransientBottomBar$BaseCallback baseTransientBottomBar$BaseCallback = this.callback;
        if (baseTransientBottomBar$BaseCallback != null) {
            this.removeCallback(baseTransientBottomBar$BaseCallback);
        }
        if (snackbar$Callback != null) {
            this.addCallback(snackbar$Callback);
        }
        this.callback = snackbar$Callback;
        return this;
    }

    public Snackbar setText(int n10) {
        CharSequence charSequence = this.getContext().getText(n10);
        return this.setText(charSequence);
    }

    public Snackbar setText(CharSequence charSequence) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public void show() {
        super.show();
    }
}

