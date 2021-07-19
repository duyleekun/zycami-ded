/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 */
package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog$1;
import com.google.android.material.bottomsheet.BottomSheetDialog$2;
import com.google.android.material.bottomsheet.BottomSheetDialog$3;
import com.google.android.material.bottomsheet.BottomSheetDialog$4;

public class BottomSheetDialog
extends AppCompatDialog {
    private BottomSheetBehavior behavior;
    private BottomSheetBehavior$BottomSheetCallback bottomSheetCallback;
    public boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(Context context, int n10) {
        n10 = BottomSheetDialog.getThemeResId(context, n10);
        super(context, n10);
        int n11 = 1;
        this.cancelable = n11;
        this.canceledOnTouchOutside = n11;
        BottomSheetDialog$4 bottomSheetDialog$4 = new BottomSheetDialog$4(this);
        this.bottomSheetCallback = bottomSheetDialog$4;
        this.supportRequestWindowFeature(n11);
    }

    public BottomSheetDialog(Context context, boolean bl2, DialogInterface.OnCancelListener object) {
        super(context, bl2, (DialogInterface.OnCancelListener)object);
        int n10 = 1;
        this.cancelable = n10;
        this.canceledOnTouchOutside = n10;
        super(this);
        this.bottomSheetCallback = object;
        this.supportRequestWindowFeature(n10);
        this.cancelable = bl2;
    }

    private static int getThemeResId(Context context, int n10) {
        if (n10 == 0) {
            boolean bl2;
            int n11;
            TypedValue typedValue = new TypedValue();
            boolean bl3 = (context = context.getTheme()).resolveAttribute(n11 = R$attr.bottomSheetDialogTheme, typedValue, bl2 = true);
            n10 = bl3 ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
        }
        return n10;
    }

    private View wrapInBottomSheet(int n10, View object, ViewGroup.LayoutParams object2) {
        Context context = this.getContext();
        int n11 = R$layout.design_bottom_sheet_dialog;
        BottomSheetBehavior bottomSheetBehavior = null;
        context = (FrameLayout)View.inflate((Context)context, (int)n11, null);
        n11 = R$id.coordinator;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)context.findViewById(n11);
        if (n10 != 0 && object == null) {
            object = this.getLayoutInflater();
            bottomSheetBehavior = null;
            object = object.inflate(n10, (ViewGroup)coordinatorLayout, false);
        }
        n10 = R$id.design_bottom_sheet;
        FrameLayout frameLayout = (FrameLayout)coordinatorLayout.findViewById(n10);
        this.behavior = bottomSheetBehavior = BottomSheetBehavior.from((View)frameLayout);
        BottomSheetBehavior$BottomSheetCallback bottomSheetBehavior$BottomSheetCallback = this.bottomSheetCallback;
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetBehavior$BottomSheetCallback);
        bottomSheetBehavior = this.behavior;
        boolean bl2 = this.cancelable;
        bottomSheetBehavior.setHideable(bl2);
        if (object2 == null) {
            frameLayout.addView(object);
        } else {
            frameLayout.addView(object, object2);
        }
        int n12 = R$id.touch_outside;
        object = coordinatorLayout.findViewById(n12);
        object2 = new BottomSheetDialog$1(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = new BottomSheetDialog$2(this);
        ViewCompat.setAccessibilityDelegate((View)frameLayout, (AccessibilityDelegateCompat)object);
        object = new BottomSheetDialog$3(this);
        frameLayout.setOnTouchListener((View.OnTouchListener)object);
        return context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getWindow();
        if (bundle != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                bundle.clearFlags(0x4000000);
                n10 = -1 << -1;
                bundle.addFlags(n10);
            }
            n10 = -1;
            bundle.setLayout(n10, n10);
        }
    }

    public void onStart() {
        int n10;
        int n11;
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && (n11 = bottomSheetBehavior.getState()) == (n10 = 5)) {
            bottomSheetBehavior = this.behavior;
            n10 = 4;
            bottomSheetBehavior.setState(n10);
        }
    }

    public void setCancelable(boolean bl2) {
        super.setCancelable(bl2);
        boolean bl3 = this.cancelable;
        if (bl3 != bl2) {
            this.cancelable = bl2;
            BottomSheetBehavior bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(bl2);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean bl2) {
        boolean bl3;
        super.setCanceledOnTouchOutside(bl2);
        boolean bl4 = true;
        if (bl2 && !(bl3 = this.cancelable)) {
            this.cancelable = bl4;
        }
        this.canceledOnTouchOutside = bl2;
        this.canceledOnTouchOutsideSet = bl4;
    }

    public void setContentView(int n10) {
        View view = this.wrapInBottomSheet(n10, null, null);
        super.setContentView(view);
    }

    public void setContentView(View view) {
        view = this.wrapInBottomSheet(0, view, null);
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view = this.wrapInBottomSheet(0, view, layoutParams);
        super.setContentView(view);
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        boolean bl2 = this.canceledOnTouchOutsideSet;
        if (!bl2) {
            boolean bl3;
            int n10;
            Context context = this.getContext();
            boolean bl4 = true;
            int[] nArray = new int[bl4];
            nArray[0] = n10 = 16843611;
            context = context.obtainStyledAttributes(nArray);
            this.canceledOnTouchOutside = bl3 = context.getBoolean(0, bl4);
            context.recycle();
            this.canceledOnTouchOutsideSet = bl4;
        }
        return this.canceledOnTouchOutside;
    }
}

