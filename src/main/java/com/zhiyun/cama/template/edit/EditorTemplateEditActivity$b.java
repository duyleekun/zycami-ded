/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.template.edit;

import android.util.Size;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import d.v.v.q.h;

public class EditorTemplateEditActivity$b
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public EditorTemplateEditActivity$b(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public void onGlobalLayout() {
        EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).g.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        TemplateEditViewModel templateEditViewModel = EditorTemplateEditActivity.k(this.a);
        int n10 = templateEditViewModel.t0();
        if (n10 == 0) {
            return;
        }
        n10 = EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).h.getWidth();
        int n11 = EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).h.getHeight();
        Size size = h.d0(n10, n11);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).g.getLayoutParams();
        int n12 = size.getHeight();
        marginLayoutParams.bottomMargin = n12 = (n11 - n12) / 2;
        marginLayoutParams.width = n12 = size.getWidth();
        EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).g.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        marginLayoutParams = (ViewGroup.MarginLayoutParams)EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).f.getLayoutParams();
        n12 = size.getHeight();
        marginLayoutParams.bottomMargin = n11 = (n11 - n12) / 2;
        n11 = size.getWidth();
        marginLayoutParams.leftMargin = n10 = (n10 - n11) / 2;
        EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).f.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        templateEditViewModel = EditorTemplateEditActivity.k(this.a);
        n11 = EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).n.getWidth();
        templateEditViewModel.N0(n11);
    }
}

