/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package l.a.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import l.a.j.a.d;
import l.a.j.a.h;
import l.a.q.b0;
import l.a.q.g0.t;
import l.a.q.j;
import skin.support.R$styleable;

public class a0
extends j {
    private static final String k = "a0";
    private final t c;
    public final TextView d;
    private int e = 0;
    private int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;

    public a0(TextView textView) {
        t t10;
        this.d = textView;
        this.c = t10 = new t(textView);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e() {
        int n10;
        this.f = n10 = l.a.q.j.b(this.f);
        if (n10 == 0) return;
        try {
            TextView textView = this.d;
            textView = textView.getContext();
            int n11 = this.f;
            textView = l.a.j.a.d.e((Context)textView, n11);
            TextView textView2 = this.d;
            textView2.setHintTextColor((ColorStateList)textView);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        int n10;
        this.e = n10 = l.a.q.j.b(this.e);
        if (n10 == 0) return;
        try {
            TextView textView = this.d;
            textView = textView.getContext();
            int n11 = this.e;
            textView = l.a.j.a.d.e((Context)textView, n11);
            TextView textView2 = this.d;
            textView2.setTextColor((ColorStateList)textView);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static a0 g(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            b0 b02 = new b0(textView);
            return b02;
        }
        a0 a02 = new a0(textView);
        return a02;
    }

    public void a() {
        this.c();
        this.f();
        this.e();
        this.c.b();
    }

    public void c() {
        this.d();
    }

    public void d() {
        int n10;
        Context context;
        int n11;
        Context context2;
        int n12;
        Context context3;
        int n13;
        this.h = n13 = l.a.q.j.b(this.h);
        Context context4 = null;
        if (n13 != 0) {
            context3 = this.d.getContext();
            n12 = this.h;
            context3 = l.a.j.a.h.a(context3, n12);
        } else {
            n13 = 0;
            context3 = null;
        }
        this.j = n12 = l.a.q.j.b(this.j);
        if (n12 != 0) {
            context2 = this.d.getContext();
            n11 = this.j;
            context2 = l.a.j.a.h.a(context2, n11);
        } else {
            n12 = 0;
            context2 = null;
        }
        this.i = n11 = l.a.q.j.b(this.i);
        if (n11 != 0) {
            context = this.d.getContext();
            n10 = this.i;
            context = l.a.j.a.h.a(context, n10);
        } else {
            n11 = 0;
            context = null;
        }
        this.g = n10 = l.a.q.j.b(this.g);
        if (n10 != 0) {
            context4 = this.d.getContext();
            n10 = this.g;
            context4 = l.a.j.a.h.a(context4, n10);
        }
        if ((n10 = this.h) != 0 || (n10 = this.j) != 0 || (n10 = this.i) != 0 || (n10 = this.g) != 0) {
            TextView textView = this.d;
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable)context3, (Drawable)context2, (Drawable)context, (Drawable)context4);
        }
    }

    public int h() {
        return this.e;
    }

    public void i(AttributeSet attributeSet, int n10) {
        boolean bl2;
        Context context = this.d.getContext();
        Object object = R$styleable.SkinCompatTextHelper;
        object = context.obtainStyledAttributes(attributeSet, object, n10, 0);
        int n11 = R$styleable.SkinCompatTextHelper_android_textAppearance;
        n11 = object.getResourceId(n11, 0);
        int n12 = R$styleable.SkinCompatTextHelper_android_drawableLeft;
        boolean bl3 = object.hasValue(n12);
        if (bl3) {
            this.h = n12 = object.getResourceId(n12, 0);
        }
        if (bl3 = object.hasValue(n12 = R$styleable.SkinCompatTextHelper_android_drawableTop)) {
            this.j = n12 = object.getResourceId(n12, 0);
        }
        if (bl3 = object.hasValue(n12 = R$styleable.SkinCompatTextHelper_android_drawableRight)) {
            this.i = n12 = object.getResourceId(n12, 0);
        }
        if (bl3 = object.hasValue(n12 = R$styleable.SkinCompatTextHelper_android_drawableBottom)) {
            this.g = n12 = object.getResourceId(n12, 0);
        }
        t t10 = this.c;
        t10.d((TypedArray)object);
        object.recycle();
        if (n11 != 0) {
            object = R$styleable.SkinTextAppearance;
            n12 = (int)((object = (Object)context.obtainStyledAttributes(n11, object)).hasValue(n11 = R$styleable.SkinTextAppearance_android_textColor) ? 1 : 0);
            if (n12 != 0) {
                this.e = n11 = object.getResourceId(n11, 0);
            }
            if ((n12 = (int)(object.hasValue(n11 = R$styleable.SkinTextAppearance_android_textColorHint) ? 1 : 0)) != 0) {
                this.f = n11 = object.getResourceId(n11, 0);
            }
            t t11 = this.c;
            t11.d((TypedArray)object);
            object.recycle();
        }
        if (bl2 = (attributeSet = context.obtainStyledAttributes(attributeSet, object = R$styleable.SkinTextAppearance, n10, 0)).hasValue(n10 = R$styleable.SkinTextAppearance_android_textColor)) {
            this.e = n10 = attributeSet.getResourceId(n10, 0);
        }
        if (bl2 = attributeSet.hasValue(n10 = R$styleable.SkinTextAppearance_android_textColorHint)) {
            this.f = n10 = attributeSet.getResourceId(n10, 0);
        }
        this.c.d((TypedArray)attributeSet);
        attributeSet.recycle();
        this.a();
    }

    public void j(int n10, int n11, int n12, int n13) {
        this.h = n10;
        this.j = n11;
        this.i = n12;
        this.g = n13;
        this.c();
    }

    public void k(int n10, int n11, int n12, int n13) {
        this.h = n10;
        this.j = n11;
        this.i = n12;
        this.g = n13;
        this.d();
    }

    public void l(Context context, int n10) {
        int[] nArray = R$styleable.SkinTextAppearance;
        boolean bl2 = (context = context.obtainStyledAttributes(n10, nArray)).hasValue(n10 = R$styleable.SkinTextAppearance_android_textColor);
        if (bl2) {
            this.e = n10 = context.getResourceId(n10, 0);
        }
        if (bl2 = context.hasValue(n10 = R$styleable.SkinTextAppearance_android_textColorHint)) {
            this.f = n10 = context.getResourceId(n10, 0);
        }
        context.recycle();
        this.f();
        this.e();
    }
}

