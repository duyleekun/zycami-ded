/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TXLogView
extends LinearLayout {
    public StringBuffer a;
    private TextView b;
    private TextView c;
    private ScrollView d;
    private ScrollView e;
    private final int f;
    private boolean g;

    public TXLogView(Context context) {
        this(context, null);
    }

    public TXLogView(Context context, AttributeSet object) {
        super(context, object);
        int n10;
        TextView textView;
        super("");
        this.a = object;
        this.f = 3000;
        this.g = false;
        int n11 = 1;
        this.setOrientation(n11);
        this.b = textView = new TextView(context);
        this.c = textView = new TextView(context);
        super(context);
        this.d = textView;
        super(context);
        this.e = textView;
        int n12 = -1;
        super(n12, 0);
        textView.weight = 0.2f;
        this.d.setLayoutParams((ViewGroup.LayoutParams)textView);
        textView = this.d;
        int n13 = 0x60FFFFFF;
        textView.setBackgroundColor(n13);
        this.d.setVerticalScrollBarEnabled(n11 != 0);
        this.d.setScrollbarFadingEnabled(n11 != 0);
        super(n12, n12);
        this.b.setLayoutParams((ViewGroup.LayoutParams)textView);
        textView = this.b;
        int n14 = 2;
        textView.setTextSize(n14, 11.0f);
        textView = this.b;
        int n15 = -16777216;
        textView.setTextColor(n15);
        textView = this.b;
        Typeface typeface = Typeface.MONOSPACE;
        textView.setTypeface(typeface, n11);
        this.b.setLineSpacing(4.0f, 1.0f);
        textView = this.b;
        float f10 = 2.0f;
        int n16 = TXLogView.a(context, f10);
        int n17 = TXLogView.a(context, f10);
        int n18 = TXLogView.a(context, f10);
        int n19 = TXLogView.a(context, f10);
        textView.setPadding(n16, n17, n18, n19);
        textView = this.d;
        TextView textView2 = this.b;
        textView.addView((View)textView2);
        super(n12, 0);
        textView.weight = 0.8f;
        textView.topMargin = n10 = TXLogView.a(context, f10);
        this.e.setLayoutParams((ViewGroup.LayoutParams)textView);
        this.e.setBackgroundColor(n13);
        this.e.setVerticalScrollBarEnabled(n11 != 0);
        this.e.setScrollbarFadingEnabled(n11 != 0);
        super(n12, n12);
        this.c.setLayoutParams((ViewGroup.LayoutParams)object);
        this.c.setTextSize(n14, 13.0f);
        this.c.setTextColor(n15);
        object = this.c;
        n11 = TXLogView.a(context, f10);
        int n20 = TXLogView.a(context, f10);
        n12 = TXLogView.a(context, f10);
        int n21 = TXLogView.a(context, f10);
        object.setPadding(n11, n20, n12, n21);
        context = this.e;
        object = this.c;
        context.addView((View)object);
        context = this.d;
        this.addView((View)context);
        context = this.e;
        this.addView((View)context);
        this.setVisibility(8);
    }

    public static int a(Context context, float f10) {
        float f11 = context.getResources().getDisplayMetrics().density;
        return (int)(f10 * f11 + 0.5f);
    }
}

