/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.SpannableString
 *  android.text.SpannedString
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.style.AbsoluteSizeSpan
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.R$styleable;
import com.zhiyun.account.me.account.widget.MeGetCodeView$a;
import d.v.a.g.u;
import d.v.a.i.a.y0.a;
import d.v.a.i.a.y0.c;
import d.v.a.i.a.y0.d;
import d.v.a.i.a.y0.d$b;
import d.v.a.i.a.y0.e;
import d.v.f.i.g;

public class MeGetCodeView
extends FrameLayout {
    private u a;
    private ColorStateList b;
    private ColorStateList c;
    private int d;
    private String e;
    private int f;
    private ColorStateList g;
    private Drawable h;
    private d i;
    private d$b j;
    private c k;
    private e l;
    private TextWatcher m;

    public MeGetCodeView(Context context) {
        this(context, null);
    }

    public MeGetCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeGetCodeView(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        int[] nArray = R$styleable.MeView;
        context = context.obtainStyledAttributes(object, nArray);
        int n11 = R$styleable.MeView_meTextColor;
        object = context.getColorStateList(n11);
        this.b = object;
        n11 = R$styleable.MeView_meTextColorHint;
        object = context.getColorStateList(n11);
        this.c = object;
        n11 = R$styleable.MeView_meTextSize;
        this.d = n11 = context.getInteger(n11, 18);
        object = this.getResources();
        n10 = R$styleable.MeView_meTextHint;
        n10 = context.getResourceId(n10, -1);
        object = d.v.f.i.g.o((Resources)object, n10);
        this.e = object;
        n11 = R$styleable.MeView_meTextSizeHint;
        this.f = n11 = context.getInteger(n11, 14);
        n11 = R$styleable.MeView_meGetCodeBtnTextColor;
        object = context.getColorStateList(n11);
        this.g = object;
        n11 = R$styleable.MeView_meGetCodeBtnBackground;
        object = context.getDrawable(n11);
        this.h = object;
        context.recycle();
        this.c();
    }

    public static /* synthetic */ e a(MeGetCodeView meGetCodeView) {
        return meGetCodeView.l;
    }

    private void b(View object) {
        object = this.j;
        if (object != null) {
            Object object2;
            object = this.i;
            if (object == null) {
                object2 = this.getContext();
                this.i = object = new d((Context)object2);
            }
            object = this.i;
            object2 = this.j;
            ((d)object).g((d$b)object2);
        }
    }

    private void c() {
        int n10;
        Object object;
        Object object2 = LayoutInflater.from((Context)this.getContext());
        int n11 = R$layout.me_get_code_view;
        boolean bl2 = true;
        object2 = (u)DataBindingUtil.inflate(object2, n11, (ViewGroup)this, bl2);
        this.a = object2;
        object2 = object2.b;
        n11 = this.d;
        float f10 = n11;
        object2.setTextSize(f10);
        object2 = this.b;
        if (object2 != null) {
            object = this.a.b;
            object.setTextColor((ColorStateList)object2);
        }
        if ((object2 = this.g) != null) {
            object = this.a.a;
            object.setTextColor((ColorStateList)object2);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object2 = this.e))) != 0 && (object2 = this.a.b.getHint()) != null) {
            object2 = this.a.b.getHint().toString();
            this.e = object2;
        }
        if ((n10 = this.f) != (n11 = this.d)) {
            object = this.e;
            object2 = new SpannableString((CharSequence)object);
            int n12 = this.f;
            object = new AbsoluteSizeSpan(n12, bl2);
            bl2 = false;
            n12 = object2.length();
            int n13 = 33;
            object2.setSpan(object, 0, n12, n13);
            object = this.a.b;
            SpannedString spannedString = new SpannedString((CharSequence)object2);
            object.setHint((CharSequence)spannedString);
        } else {
            object2 = this.a.b;
            object = this.e;
            object2.setHint((CharSequence)object);
        }
        object2 = this.c;
        if (object2 != null) {
            object = this.a.b;
            object.setHintTextColor((ColorStateList)object2);
        }
        if ((object2 = this.h) != null) {
            object = this.a.a;
            object.setBackground((Drawable)object2);
        }
        object2 = this.a.a;
        object = new a(this);
        object2.setOnClickListener((View.OnClickListener)object);
    }

    public static /* synthetic */ void d(MeGetCodeView meGetCodeView, View view) {
        meGetCodeView.b(view);
    }

    public void e() {
        c c10 = this.k;
        if (c10 == null) {
            Button button = this.a.a;
            int n10 = 60;
            this.k = c10 = new c(button, n10);
        }
        this.k.a();
    }

    public void f() {
        c c10 = this.k;
        if (c10 != null) {
            c10.b();
        }
    }

    public String getCode() {
        return this.a.b.getText().toString().trim();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextWatcher textWatcher = this.m;
        if (textWatcher == null) {
            this.m = textWatcher = new MeGetCodeView$a(this);
        }
        textWatcher = this.a.b;
        TextWatcher textWatcher2 = this.m;
        textWatcher.addTextChangedListener(textWatcher2);
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        object = this.i;
        if (object != null) {
            ((d)object).e();
        }
    }

    public void onDetachedFromWindow() {
        Object object = this.a.b;
        TextWatcher textWatcher = this.m;
        object.removeTextChangedListener(textWatcher);
        object = this.k;
        if (object != null) {
            ((c)object).b();
            object = null;
            this.k = null;
        }
        if ((object = this.i) != null) {
            ((d)object).f();
        }
        super.onDetachedFromWindow();
    }

    public void setCode(CharSequence charSequence) {
        this.a.b.setText(charSequence);
    }

    public void setGetCodeClickable(boolean bl2) {
        float f10;
        this.f();
        Button button = this.a.a;
        int n10 = R$string.me_get_code;
        button.setText(n10);
        this.a.a.setClickable(bl2);
        button = this.a.a;
        if (bl2) {
            int n11 = 1065353216;
            f10 = 1.0f;
        } else {
            int n12 = 1050253722;
            f10 = 0.3f;
        }
        button.setAlpha(f10);
    }

    public void setOnClickGetCodeListener(d$b d$b) {
        this.j = d$b;
    }

    public void setOnTextChangedListener(e e10) {
        this.l = e10;
    }
}

