/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RadioButton
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.camera.widget.CheckedGroup$b;
import com.zhiyun.cama.camera.widget.CheckedGroup$c;
import com.zhiyun.cama.camera.widget.CheckedGroup$d;
import com.zhiyun.cama.camera.widget.CheckedGroup$e;
import d.v.c.s0.i7.a;

public class CheckedGroup
extends LinearLayout {
    private int a;
    private CompoundButton.OnCheckedChangeListener b;
    private boolean c;
    private CheckedGroup$d d;
    private CheckedGroup$e e;

    public CheckedGroup(Context context) {
        super(context);
        this.a = -1;
        this.c = false;
        this.setOrientation(1);
        this.j();
    }

    public CheckedGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.a = n10 = -1;
        this.c = false;
        int[] nArray = R$styleable.RadioGroup;
        int n11 = 2130969229;
        context = context.obtainStyledAttributes(attributeSet, nArray, n11, 0);
        int n12 = context.getResourceId(0, n10);
        if (n12 != n10) {
            this.a = n12;
        }
        n12 = 1;
        n12 = context.getInt(n12, n12);
        this.setOrientation(n12);
        context.recycle();
        this.j();
    }

    public static /* synthetic */ boolean a(CheckedGroup checkedGroup) {
        return checkedGroup.c;
    }

    public static /* synthetic */ boolean b(CheckedGroup checkedGroup, boolean bl2) {
        checkedGroup.c = bl2;
        return bl2;
    }

    public static /* synthetic */ int c(CheckedGroup checkedGroup) {
        return checkedGroup.a;
    }

    public static /* synthetic */ void d(CheckedGroup checkedGroup, int n10, boolean bl2) {
        checkedGroup.n(n10, bl2);
    }

    public static /* synthetic */ void e(CheckedGroup checkedGroup, int n10, boolean bl2) {
        checkedGroup.m(n10, bl2);
    }

    public static /* synthetic */ CompoundButton.OnCheckedChangeListener f(CheckedGroup checkedGroup) {
        return checkedGroup.b;
    }

    private void j() {
        Object object = new CheckedGroup$b(this, null);
        this.b = object;
        this.e = object = new CheckedGroup$e(this, null);
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)object);
    }

    private /* synthetic */ void k(View view) {
        int n10 = view.getId();
        this.m(n10, true);
    }

    private void m(int n10, boolean bl2) {
        this.a = n10;
        CheckedGroup$d checkedGroup$d = this.d;
        if (checkedGroup$d != null && bl2) {
            checkedGroup$d.a(this, n10);
        }
    }

    private void n(int n10, boolean bl2) {
        boolean bl3;
        View view = this.findViewById(n10);
        if (view != null && (bl3 = view instanceof RadioButton)) {
            view = (RadioButton)view;
            view.setChecked(bl2);
        }
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        boolean bl2 = view instanceof RadioButton;
        if (bl2) {
            View view2 = view;
            view2 = (RadioButton)view;
            int n11 = view2.isChecked();
            if (n11 != 0) {
                this.c = true;
                n11 = this.a;
                int n12 = -1;
                if (n11 != n12) {
                    this.n(n11, false);
                }
                this.c = false;
                n11 = view2.getId();
                this.m(n11, false);
            }
            a a10 = new a(this);
            view2.setOnClickListener((View.OnClickListener)a10);
        }
        super.addView(view, n10, layoutParams);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof CheckedGroup$c;
    }

    public void g(int n10) {
        int n11;
        int n12 = -1;
        if (n10 != n12 && n10 == (n11 = this.a)) {
            return;
        }
        n11 = this.a;
        if (n11 != n12) {
            this.n(n11, false);
        }
        if (n10 != n12) {
            n12 = 1;
            this.n(n10, n12 != 0);
        }
        this.m(n10, false);
    }

    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        CheckedGroup$c checkedGroup$c = new CheckedGroup$c(n10, n10);
        return checkedGroup$c;
    }

    public CharSequence getAccessibilityClassName() {
        return CheckedGroup.class.getName();
    }

    public int getCheckedRadioButtonId() {
        return this.a;
    }

    public void h() {
        this.g(-1);
    }

    public CheckedGroup$c i(AttributeSet attributeSet) {
        Context context = this.getContext();
        CheckedGroup$c checkedGroup$c = new CheckedGroup$c(context, attributeSet);
        return checkedGroup$c;
    }

    public /* synthetic */ void l(View view) {
        this.k(view);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int n10 = this.a;
        int n11 = -1;
        if (n10 != n11) {
            n11 = 1;
            this.c = n11;
            this.n(n10, n11 != 0);
            n10 = 0;
            this.c = false;
            n11 = this.a;
            this.m(n11, false);
        }
    }

    public void setOnCheckedChangeListener(CheckedGroup$d checkedGroup$d) {
        this.d = checkedGroup$d;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        CheckedGroup$e.a(this.e, onHierarchyChangeListener);
    }
}

