/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.text.TextWatcher
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$drawable;
import com.zhiyun.account.R$styleable;
import com.zhiyun.account.me.account.widget.InputCodeView$a;
import com.zhiyun.account.me.account.widget.InputCodeView$b;
import com.zhiyun.account.me.account.widget.InputCodeView$c;
import d.v.e.l.h2;
import d.v.f.i.g;

public class InputCodeView
extends FrameLayout {
    private Drawable a;
    private int b;
    private ColorStateList c;
    private int d;
    private String e;
    private InputCodeView$c f;
    private InputCodeView$b g;

    public InputCodeView(Context context) {
        this(context, null);
    }

    public InputCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputCodeView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object = R$styleable.InputCodeView;
        attributeSet = context.obtainStyledAttributes(attributeSet, object);
        n10 = R$styleable.InputCodeView_codeBackground;
        object = attributeSet.getDrawable(n10);
        this.a = (Drawable)object;
        n10 = R$styleable.InputCodeView_codeSize;
        this.b = n10 = attributeSet.getInteger(n10, 32);
        n10 = R$styleable.InputCodeView_codeColor;
        object = attributeSet.getColorStateList(n10);
        this.c = (ColorStateList)object;
        n10 = R$styleable.InputCodeView_codeLength;
        this.d = n10 = attributeSet.getInteger(n10, 6);
        attributeSet.recycle();
        this.g(context);
    }

    public static /* synthetic */ String a(InputCodeView inputCodeView) {
        return inputCodeView.e;
    }

    public static /* synthetic */ String b(InputCodeView inputCodeView, String string2) {
        inputCodeView.e = string2;
        return string2;
    }

    public static /* synthetic */ InputCodeView$b c(InputCodeView inputCodeView) {
        return inputCodeView.g;
    }

    public static /* synthetic */ int d(InputCodeView inputCodeView) {
        return inputCodeView.d;
    }

    public static /* synthetic */ InputCodeView$c e(InputCodeView inputCodeView) {
        return inputCodeView.f;
    }

    private TextView f(Context context, boolean bl2) {
        TextView textView = new TextView(context);
        int n10 = this.b;
        float f10 = n10;
        textView.setTextSize(f10);
        ColorStateList colorStateList = this.c;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        } else {
            n10 = R$color.zyui_text_1;
            n10 = d.v.f.i.g.c(context, n10);
            textView.setTextColor(n10);
        }
        colorStateList = this.a;
        if (colorStateList != null) {
            textView.setBackground((Drawable)colorStateList);
        } else {
            n10 = R$drawable.input_get_code_bg;
            context = d.v.f.i.g.f(context, n10);
            textView.setBackground((Drawable)context);
        }
        colorStateList = null;
        int n11 = -1;
        context = new LinearLayout.LayoutParams(0, n11);
        context.weight = 1.0f;
        n10 = 17;
        f10 = 2.4E-44f;
        context.gravity = n10;
        if (bl2) {
            float f11 = 12.0f;
            int n12 = h2.b(f11);
            context.setMarginEnd(n12);
        }
        textView.setGravity(n10);
        textView.setLayoutParams((ViewGroup.LayoutParams)context);
        return textView;
    }

    private void g(Context object) {
        Object object2 = new InputCodeView$b(this, (Context)object);
        this.g = object2;
        int n10 = -1;
        object2 = new FrameLayout.LayoutParams(n10, n10);
        this.g.setTextColor(0);
        InputCodeView$b inputCodeView$b = this.g;
        TextView textView = null;
        inputCodeView$b.setBackground(null);
        inputCodeView$b = this.g;
        int n11 = this.d;
        inputCodeView$b.setMaxEms(n11);
        this.g.setHintTextColor(0);
        this.g.setTextSize(1.0f);
        inputCodeView$b = this.g;
        n11 = 128;
        inputCodeView$b.setInputType(n11);
        this.g.setCursorVisible(false);
        this.g.setLongClickable(false);
        this.g.setLayoutParams((ViewGroup.LayoutParams)object2);
        inputCodeView$b = new LinearLayout(object);
        inputCodeView$b.setLayoutParams((ViewGroup.LayoutParams)object2);
        object2 = null;
        for (int i10 = 0; i10 < (n11 = this.d); ++i10) {
            if (i10 != (n11 += -1)) {
                n11 = 1;
            } else {
                n11 = 0;
                textView = null;
            }
            textView = this.f((Context)object, n11 != 0);
            inputCodeView$b.addView((View)textView);
        }
        object = this.g;
        object2 = new InputCodeView$a(this, (LinearLayout)inputCodeView$b);
        object.addTextChangedListener((TextWatcher)object2);
        object = this.g;
        this.addView((View)object);
        this.addView((View)inputCodeView$b);
    }

    public String getCode() {
        return this.e;
    }

    public void setCode(String string2) {
        this.e = string2;
        this.g.setText("");
    }

    public void setOnInputEndListener(InputCodeView$c inputCodeView$c) {
        this.f = inputCodeView$c;
    }
}

