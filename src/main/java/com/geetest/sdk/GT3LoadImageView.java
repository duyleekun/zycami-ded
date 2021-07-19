/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.geetest.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.utils.o;

public class GT3LoadImageView
extends View {
    private int iconRes;
    private int loadViewHeight;
    private int loadViewWidth;

    public GT3LoadImageView(Context context) {
        super(context);
        int n10;
        this.loadViewWidth = n10 = -2;
        this.loadViewHeight = n10;
    }

    public GT3LoadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.loadViewWidth = n10 = -2;
        this.loadViewHeight = n10;
    }

    public GT3LoadImageView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        this.loadViewWidth = n11 = -2;
        this.loadViewHeight = n11;
    }

    public void execute() {
    }

    public int getIconRes() {
        int n10;
        this.iconRes = n10 = o.a(this.getContext(), "gt3_new_bind_logo");
        return n10;
    }

    public int getLoadViewHeight() {
        return this.loadViewHeight;
    }

    public int getLoadViewWidth() {
        return this.loadViewWidth;
    }

    public boolean isGif() {
        return true;
    }

    public void setIconRes(int n10) {
        this.iconRes = n10;
    }

    public void setLoadViewHeight(int n10) {
        this.loadViewHeight = n10;
    }

    public void setLoadViewWidth(int n10) {
        this.loadViewWidth = n10;
    }
}

