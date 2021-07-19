/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.RadioButton
 */
package com.zhiyun.cama.camera.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.cama.camera.widget.CheckedGroup$a;

public class CheckedGroup$e
implements ViewGroup.OnHierarchyChangeListener {
    private ViewGroup.OnHierarchyChangeListener a;
    public final /* synthetic */ CheckedGroup b;

    private CheckedGroup$e(CheckedGroup checkedGroup) {
        this.b = checkedGroup;
    }

    public /* synthetic */ CheckedGroup$e(CheckedGroup checkedGroup, CheckedGroup$a checkedGroup$a) {
        this(checkedGroup);
    }

    public static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(CheckedGroup$e checkedGroup$e, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        checkedGroup$e.a = onHierarchyChangeListener;
        return onHierarchyChangeListener;
    }

    public void onChildViewAdded(View view, View view2) {
        int n10;
        CheckedGroup checkedGroup = this.b;
        if (view == checkedGroup && (n10 = view2 instanceof RadioButton) != 0) {
            int n11;
            n10 = view2.getId();
            if (n10 == (n11 = -1)) {
                n10 = View.generateViewId();
                view2.setId(n10);
            }
            checkedGroup = view2;
            checkedGroup = (RadioButton)view2;
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = CheckedGroup.f(this.b);
            checkedGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if ((checkedGroup = this.a) != null) {
            checkedGroup.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        boolean bl2;
        CheckedGroup checkedGroup = this.b;
        if (view == checkedGroup && (bl2 = view2 instanceof RadioButton)) {
            bl2 = false;
            checkedGroup = null;
            view2.setOnClickListener(null);
            View view3 = view2;
            view3 = (RadioButton)view2;
            view3.setOnCheckedChangeListener(null);
        }
        if ((checkedGroup = this.a) != null) {
            checkedGroup.onChildViewRemoved(view, view2);
        }
    }
}

