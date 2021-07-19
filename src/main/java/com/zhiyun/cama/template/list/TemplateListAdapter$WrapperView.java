/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.template.list;

import android.view.View;

public class TemplateListAdapter$WrapperView {
    private View a;

    public TemplateListAdapter$WrapperView(View view) {
        this.a = view;
    }

    public int a() {
        return this.a.getLayoutParams().width;
    }

    public void setWidth(int n10) {
        this.a.getLayoutParams().width = n10;
        this.a.requestLayout();
    }
}

