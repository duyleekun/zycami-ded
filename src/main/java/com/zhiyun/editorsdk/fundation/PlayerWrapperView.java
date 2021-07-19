/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.zhiyun.editorsdk.fundation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.v.v.g.g;
import m.a.a;

public class PlayerWrapperView
extends FrameLayout {
    private Context a;

    public PlayerWrapperView(Context context) {
        this(context, null);
    }

    public PlayerWrapperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerWrapperView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a = context;
        this.a();
    }

    public void a() {
        this.removeAllViews();
        Context context = this.a;
        g g10 = new g(context);
        int n10 = -1;
        context = new FrameLayout.LayoutParams(n10, n10);
        g10.setLayoutParams((ViewGroup.LayoutParams)context);
        this.addView((View)g10);
    }

    public void b() {
        this.removeAllViews();
    }

    public g getPlayerView() {
        View view = this.getChildAt(0);
        if (view == null) {
            this.a();
        }
        return (g)this.getChildAt(0);
    }

    public void onViewAdded(View objectArray) {
        boolean bl2;
        super.onViewAdded((View)objectArray);
        objectArray = null;
        Object object = this.getChildAt(0);
        int n10 = this.getChildCount();
        int n11 = 1;
        if (n10 != n11 || !(bl2 = object instanceof g)) {
            objectArray = new Object[]{};
            object = "PlayerWrapperView\u53ea\u80fd\u5305\u542b\u4e00\u4e2a\u4e14\u53ea\u80fd\u662fNvsPlayerView";
            m.a.a.i((String)object, objectArray);
            this.a();
        }
    }
}

