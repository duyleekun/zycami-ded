/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.widget;

import android.view.View;
import android.view.ViewGroup;
import com.zhiyun.cama.widget.EditorHorizontalScrollView;
import d.v.c.b2.r;

public class EditorHorizontalScrollView$a
implements View.OnScrollChangeListener {
    public int a = -2147483647;
    public final /* synthetic */ EditorHorizontalScrollView b;

    public EditorHorizontalScrollView$a(EditorHorizontalScrollView editorHorizontalScrollView) {
        this.b = editorHorizontalScrollView;
    }

    private void a(View view) {
        int n10 = view instanceof ViewGroup;
        if (n10 != 0) {
            int n11;
            view = (ViewGroup)view;
            Object var3_3 = null;
            for (n10 = 0; n10 < (n11 = view.getChildCount()); ++n10) {
                View view2 = view.getChildAt(n10);
                this.a(view2);
            }
        } else {
            n10 = view instanceof r;
            if (n10 != 0) {
                View view3 = view;
                view3 = (r)view;
                n10 = (int)(view3.k() ? 1 : 0);
                if (n10 != 0) {
                    view.postInvalidateOnAnimation();
                }
            }
        }
    }

    public void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        float f10 = Math.abs(this.a - n10);
        EditorHorizontalScrollView editorHorizontalScrollView = this.b;
        float f11 = editorHorizontalScrollView.c;
        float f12 = 2.0f;
        float f13 = f10 - (f11 /= f12);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0) {
            this.a = n10;
            this.a((View)editorHorizontalScrollView);
        }
    }
}

