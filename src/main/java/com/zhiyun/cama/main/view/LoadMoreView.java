/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package com.zhiyun.cama.main.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.i.g;

public class LoadMoreView
extends FrameLayout {
    public static final int e = 100;
    public static final int f = 101;
    public static final int g = 102;
    public static final int h = 103;
    public static final int i = 104;
    private int a = 100;
    private ProgressBar b;
    private TextView c;
    private String d;

    public LoadMoreView(Context context) {
        this(context, null);
    }

    public LoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.b(context);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int n10 = this.a;
        int n11 = 0;
        String string2 = null;
        int n12 = 4;
        switch (n10) {
            default: {
                this.b.setVisibility(n12);
                TextView textView = this.c;
                textView.setVisibility(n12);
                break;
            }
            case 103: {
                this.b.setVisibility(n12);
                this.c.setVisibility(0);
                TextView textView = this.c;
                string2 = this.d;
                textView.setText((CharSequence)string2);
                break;
            }
            case 102: {
                this.b.setVisibility(n12);
                this.c.setVisibility(0);
                TextView textView = this.c;
                n11 = 2131952827;
                string2 = d.v.f.i.g.q((View)textView, n11);
                textView.setText((CharSequence)string2);
                break;
            }
            case 101: 
            case 104: {
                this.b.setVisibility(0);
                TextView textView = this.c;
                textView.setVisibility(n12);
            }
        }
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private void b(Context context) {
        ProgressBar progressBar;
        int n10;
        int n11 = h2.b(25.0f);
        int n12 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n12, n11);
        layoutParams.gravity = n10 = 17;
        int n13 = h2.b(8.0f);
        int n14 = n13 * 2;
        layoutParams.setMargins(0, n13, 0, n14);
        this.b = progressBar = new ProgressBar(context);
        n14 = h2.b(52.0f);
        int n15 = h2.b(14.0f);
        progressBar = new FrameLayout.LayoutParams(n14, n15);
        progressBar.gravity = n10;
        ProgressBar progressBar2 = this.b;
        Drawable drawable2 = o1.o(this.getContext().getResources(), 2131230814);
        progressBar2.setIndeterminateDrawable(drawable2);
        progressBar2 = this.b;
        this.addView((View)progressBar2, (ViewGroup.LayoutParams)progressBar);
        progressBar = new TextView(context);
        this.c = progressBar;
        progressBar.setGravity(n10);
        context = this.c;
        n10 = d.v.f.i.g.c(this.getContext(), 2131099994);
        context.setTextColor(n10);
        context = this.c;
        this.addView((View)context, (ViewGroup.LayoutParams)layoutParams);
        context = new ViewGroup.LayoutParams(n12, n11);
        this.setLayoutParams((ViewGroup.LayoutParams)context);
        this.a();
    }

    public int getState() {
        return this.a;
    }

    public String getTipNoMoreText() {
        return this.d;
    }

    public void setState(int n10) {
        this.a = n10;
        this.a();
    }

    public void setTipNoMoreText(String string2) {
        this.d = string2;
    }
}

