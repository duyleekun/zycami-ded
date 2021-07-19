/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.SpannedString
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.style.AbsoluteSizeSpan
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$styleable;
import com.zhiyun.account.me.account.widget.MePassView$a;
import d.v.a.g.y;
import d.v.a.i.a.y0.b;
import d.v.a.i.a.y0.e;
import d.v.f.i.g;

public class MePassView
extends FrameLayout {
    private y a;
    private Drawable b;
    private Drawable c;
    private ColorStateList d;
    private ColorStateList e;
    private int f;
    private String g;
    private int h;
    private e i;
    private TextWatcher j;

    public MePassView(Context context) {
        this(context, null);
    }

    public MePassView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MePassView(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        int[] nArray = R$styleable.MeView;
        context = context.obtainStyledAttributes(object, nArray);
        int n11 = R$styleable.MeView_meTextSize;
        this.f = n11 = context.getInteger(n11, 18);
        n11 = R$styleable.MeView_meBackground;
        object = context.getDrawable(n11);
        this.b = object;
        n11 = R$styleable.MeView_meTextColor;
        object = context.getColorStateList(n11);
        this.d = object;
        n11 = R$styleable.MeView_meTextColorHint;
        object = context.getColorStateList(n11);
        this.e = object;
        object = this.getResources();
        n10 = R$styleable.MeView_meTextHint;
        n10 = context.getResourceId(n10, -1);
        object = d.v.f.i.g.o((Resources)object, n10);
        this.g = object;
        n11 = R$styleable.MeView_meTextSizeHint;
        this.h = n11 = context.getInteger(n11, 14);
        n11 = R$styleable.MeView_meSeeDrawable;
        object = context.getDrawable(n11);
        this.c = object;
        context.recycle();
        this.b();
    }

    public static /* synthetic */ e a(MePassView mePassView) {
        return mePassView.i;
    }

    private void b() {
        Object object;
        int n10;
        String string2;
        int n11;
        Object object2 = LayoutInflater.from((Context)this.getContext());
        int n12 = R$layout.me_pass_view;
        int n13 = 1;
        object2 = (y)DataBindingUtil.inflate(object2, n12, (ViewGroup)this, n13 != 0);
        this.a = object2;
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            object2 = object2.a;
            n11 = 0;
            string2 = null;
            object2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, null, null, null);
        }
        object2 = this.a.b;
        n12 = this.f;
        float f10 = n12;
        object2.setTextSize(f10);
        object2 = this.b;
        if (object2 != null) {
            object2 = this.a.getRoot();
            drawable2 = this.b;
            object2.setBackground(drawable2);
        }
        if ((object2 = this.d) != null) {
            drawable2 = this.a.b;
            drawable2.setTextColor((ColorStateList)object2);
        }
        if ((object2 = this.e) != null) {
            drawable2 = this.a.b;
            drawable2.setHintTextColor((ColorStateList)object2);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object2 = this.g))) != 0 && (object2 = this.a.b.getHint()) != null) {
            object2 = this.a.b.getHint();
            if (object2 != null) {
                object2 = this.a.b.getHint().toString();
                this.g = object2;
            } else {
                object2 = "";
                this.g = object2;
            }
        }
        object2 = this.g;
        n10 = TextUtils.isEmpty((CharSequence)object2);
        n12 = 0;
        f10 = 0.0f;
        drawable2 = null;
        if (n10 == 0 && (n10 = this.h) != (n11 = this.f)) {
            string2 = this.g;
            object2 = new SpannableString((CharSequence)string2);
            int n14 = this.h;
            string2 = new AbsoluteSizeSpan(n14, n13 != 0);
            n13 = object2.length();
            n14 = 33;
            object2.setSpan((Object)string2, 0, n13, n14);
            object = this.a.b;
            string2 = new SpannedString((CharSequence)object2);
            object.setHint((CharSequence)string2);
        } else {
            object2 = this.a.b;
            object = this.g;
            object2.setHint((CharSequence)object);
        }
        object2 = this.a.a;
        object = new b(this);
        object2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        this.a.a.setChecked(false);
        object2 = this.a.b;
        this.e(false, (EditText)object2);
    }

    private /* synthetic */ void c(CompoundButton compoundButton, boolean bl2) {
        compoundButton = this.a.b;
        this.e(bl2, (EditText)compoundButton);
    }

    /*
     * WARNING - void declaration
     */
    private void e(boolean bl2, EditText editText) {
        void var2_4;
        if (bl2) {
            int n10 = 144;
            var2_4.setInputType(n10);
        } else {
            int n11 = 129;
            var2_4.setInputType(n11);
        }
        Typeface typeface = Typeface.DEFAULT;
        var2_4.setTypeface(typeface);
        var2_4.postInvalidate();
        typeface = var2_4.getText();
        if (typeface != null) {
            int n12 = typeface.length();
            Selection.setSelection((Spannable)typeface, (int)n12);
        }
    }

    public /* synthetic */ void d(CompoundButton compoundButton, boolean bl2) {
        this.c(compoundButton, bl2);
    }

    public String getPass() {
        return this.a.b.getText().toString().trim();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextWatcher textWatcher = this.j;
        if (textWatcher == null) {
            this.j = textWatcher = new MePassView$a(this);
        }
        textWatcher = this.a.b;
        TextWatcher textWatcher2 = this.j;
        textWatcher.addTextChangedListener(textWatcher2);
    }

    public void onDetachedFromWindow() {
        EditText editText = this.a.b;
        TextWatcher textWatcher = this.j;
        editText.removeTextChangedListener(textWatcher);
        super.onDetachedFromWindow();
    }

    public void setOnTextChangedListener(e e10) {
        this.i = e10;
    }

    public void setPass(CharSequence charSequence) {
        this.a.b.setText(charSequence);
    }
}

