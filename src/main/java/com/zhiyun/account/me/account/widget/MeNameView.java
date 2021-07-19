/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.SpannableString
 *  android.text.SpannedString
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.style.AbsoluteSizeSpan
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.account.R$drawable;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.R$styleable;
import com.zhiyun.account.me.account.widget.MeNameView$a;
import com.zhiyun.account.me.account.widget.MeNameView$b;
import d.v.a.g.w;
import d.v.a.i.a.y0.e;
import d.v.e.l.o1;
import d.v.f.i.g;

public class MeNameView
extends FrameLayout {
    private w a;
    private boolean b;
    private Drawable c;
    private ColorStateList d;
    private ColorStateList e;
    private int f;
    private Drawable g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private TextWatcher m;
    private e n;
    private String o;

    public MeNameView(Context context) {
        this(context, null);
    }

    public MeNameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeNameView(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        int[] nArray = R$styleable.MeView;
        context = context.obtainStyledAttributes(object, nArray);
        int n11 = R$styleable.MeView_meNameShowCode;
        n10 = 1;
        n11 = (int)(context.getBoolean(n11, n10 != 0) ? 1 : 0);
        this.b = n11;
        n11 = R$styleable.MeView_meBackground;
        object = context.getDrawable(n11);
        this.c = object;
        n11 = R$styleable.MeView_meTextSize;
        this.f = n11 = context.getInteger(n11, 18);
        n11 = R$styleable.MeView_meTextColor;
        object = context.getColorStateList(n11);
        this.d = object;
        n11 = R$styleable.MeView_meTextColorHint;
        object = context.getColorStateList(n11);
        this.e = object;
        n11 = R$styleable.MeView_meDrawableRight;
        object = context.getDrawable(n11);
        this.g = object;
        object = this.getResources();
        int n12 = R$styleable.MeView_meTextHint;
        n12 = context.getResourceId(n12, -1);
        object = d.v.f.i.g.o((Resources)object, n12);
        this.h = object;
        n11 = R$styleable.MeView_meTextSizeHint;
        this.i = n11 = context.getInteger(n11, 14);
        n11 = R$styleable.MeView_meEditable;
        n11 = (int)(context.getBoolean(n11, n10 != 0) ? 1 : 0);
        this.j = n11;
        n11 = R$styleable.MeView_meIsBlackBg;
        n11 = (int)(context.getBoolean(n11, false) ? 1 : 0);
        this.k = n11;
        n11 = R$styleable.MeView_meDeleteVisible;
        n11 = (int)(context.getBoolean(n11, n10 != 0) ? 1 : 0);
        this.l = n11;
        context.recycle();
        this.e();
    }

    public static /* synthetic */ e a(MeNameView meNameView) {
        return meNameView.n;
    }

    public static /* synthetic */ boolean b(MeNameView meNameView) {
        return meNameView.l;
    }

    public static /* synthetic */ w c(MeNameView meNameView) {
        return meNameView.a;
    }

    public static /* synthetic */ boolean d(MeNameView meNameView) {
        return meNameView.k;
    }

    private void e() {
        boolean bl2;
        Object object = LayoutInflater.from((Context)this.getContext());
        int bl3 = R$layout.me_name_view;
        boolean bl4 = true;
        object = (w)DataBindingUtil.inflate((LayoutInflater)object, bl3, (ViewGroup)this, bl4);
        this.a = object;
        MeNameView$b meNameView$b = new MeNameView$b(this);
        ((w)object).z(meNameView$b);
        object = this.a.a;
        int n10 = this.f;
        float f10 = n10;
        object.setTextSize(f10);
        object = this.c;
        if (object != null) {
            object = this.a.getRoot();
            meNameView$b = this.c;
            object.setBackground((Drawable)meNameView$b);
        }
        if ((object = this.d) != null) {
            this.a.a.setTextColor((ColorStateList)object);
            object = this.a.c;
            meNameView$b = this.d;
            object.setTextColor((ColorStateList)meNameView$b);
        }
        if ((object = this.e) != null) {
            meNameView$b = this.a.a;
            meNameView$b.setHintTextColor((ColorStateList)object);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(object = this.h))) {
            object = this.a.a.getHint();
            this.h = object != null ? (object = this.a.a.getHint().toString()) : (object = "");
        }
        object = this.h;
        this.setNameHint((String)object);
        object = this.g;
        if (object != null) {
            meNameView$b = this.a.c;
            bl4 = false;
            meNameView$b.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, (Drawable)object, null);
        } else {
            object = this.getContext();
            int n11 = R$drawable.ic_zf_zhxt_expand;
            object = o1.m((Context)object, n11);
            this.g = object;
        }
        object = "86";
        this.setCountryCode((String)object);
        bl2 = this.j;
        if (!bl2) {
            object = this.a.b;
            int n12 = 8;
            f10 = 1.1E-44f;
            object.setVisibility(n12);
        }
        object = this.a.a;
        boolean bl5 = this.j;
        object.setEnabled(bl5);
        object = this.a.c;
        boolean bl6 = this.j;
        object.setEnabled(bl6);
        bl2 = this.b;
        this.setShowCode(bl2);
    }

    public boolean f() {
        return this.b;
    }

    public String getCountryCode() {
        int n10 = 8;
        TextView textView = this.a.c;
        int n11 = textView.getVisibility();
        if (n10 == n11) {
            return null;
        }
        return this.o;
    }

    public String getName() {
        return this.a.a.getText().toString().trim();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextWatcher textWatcher = this.m;
        if (textWatcher == null) {
            this.m = textWatcher = new MeNameView$a(this);
        }
        textWatcher = this.a.a;
        TextWatcher textWatcher2 = this.m;
        textWatcher.addTextChangedListener(textWatcher2);
    }

    public void onDetachedFromWindow() {
        EditText editText = this.a.a;
        TextWatcher textWatcher = this.m;
        editText.removeTextChangedListener(textWatcher);
        super.onDetachedFromWindow();
    }

    public void setCountryCode(String string2) {
        this.o = string2;
        string2 = this.a.c;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("+");
        String string3 = this.o;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        string2.setText(charSequence);
    }

    public void setEditable(boolean bl2) {
        ImageView imageView;
        this.j = bl2;
        int bl3 = 8;
        if (!bl2) {
            this.a.b.setVisibility(bl3);
            imageView = this.a.c;
            imageView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        } else {
            Drawable drawable2;
            int n10;
            imageView = this.a.b;
            boolean bl4 = this.l;
            if (bl4) {
                n10 = 0;
                drawable2 = null;
            }
            imageView.setVisibility(n10);
            imageView = this.a.c;
            drawable2 = this.g;
            imageView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable2, null);
        }
        imageView = this.a.a;
        boolean bl5 = this.j;
        imageView.setEnabled(bl5);
        imageView = this.a.c;
        boolean bl6 = this.j;
        imageView.setEnabled(bl6);
    }

    public void setName(CharSequence charSequence) {
        this.a.a.setText(charSequence);
    }

    public void setNameHint(String string2) {
        this.h = string2;
        int n10 = this.i;
        int n11 = this.f;
        if (n10 != n11) {
            String string3 = this.h;
            string2 = new SpannableString((CharSequence)string3);
            n11 = this.i;
            string3 = new AbsoluteSizeSpan(n11, true);
            n11 = 0;
            int n12 = string2.length();
            int n13 = 33;
            string2.setSpan((Object)string3, 0, n12, n13);
            string3 = this.a.a;
            SpannedString spannedString = new SpannedString((CharSequence)string2);
            string3.setHint((CharSequence)spannedString);
        } else {
            EditText editText = this.a.a;
            editText.setHint((CharSequence)string2);
        }
    }

    public void setNameInputType(int n10) {
        this.a.a.setInputType(n10);
    }

    public void setOnTextChangedListener(e e10) {
        this.n = e10;
    }

    /*
     * WARNING - void declaration
     */
    public void setShowCode(boolean bl2) {
        void var1_4;
        Object object;
        this.b = bl2;
        TextView textView = this.a.c;
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            int n10 = 8;
        }
        textView.setVisibility((int)var1_4);
        boolean bl4 = this.b;
        if (bl4) {
            object = this.getResources();
            int n11 = R$string.me_input_phone;
            object = d.v.f.i.g.o(object, n11);
            this.setNameHint((String)object);
            object = this.a.a;
            n11 = 3;
            object.setInputType(n11);
        } else {
            object = this.getResources();
            int n12 = R$string.me_input_email;
            object = d.v.f.i.g.o(object, n12);
            this.setNameHint((String)object);
            object = this.a.a;
            n12 = 32;
            object.setInputType(n12);
        }
    }
}

