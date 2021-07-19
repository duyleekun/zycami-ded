/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package l.a.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import l.a.j.a.h;
import l.a.q.a0;
import l.a.q.j;
import skin.support.R$styleable;

public class b0
extends a0 {
    private int l = 0;
    private int m = 0;

    public b0(TextView textView) {
        super(textView);
    }

    public void c() {
        Context context;
        int n10;
        Context context2;
        int n11;
        Context context3;
        int n12;
        Context context4;
        int n13;
        Context context5;
        int n14;
        this.h = n14 = l.a.q.j.b(this.h);
        int n15 = 0;
        Context context6 = null;
        if (n14 != 0) {
            context5 = this.d.getContext();
            n13 = this.h;
            context5 = l.a.j.a.h.a(context5, n13);
        } else {
            n14 = 0;
            context5 = null;
        }
        this.j = n13 = l.a.q.j.b(this.j);
        if (n13 != 0) {
            context4 = this.d.getContext();
            n12 = this.j;
            context4 = l.a.j.a.h.a(context4, n12);
        } else {
            n13 = 0;
            context4 = null;
        }
        this.i = n12 = l.a.q.j.b(this.i);
        if (n12 != 0) {
            context3 = this.d.getContext();
            n11 = this.i;
            context3 = l.a.j.a.h.a(context3, n11);
        } else {
            n12 = 0;
            context3 = null;
        }
        this.g = n11 = l.a.q.j.b(this.g);
        if (n11 != 0) {
            context2 = this.d.getContext();
            n10 = this.g;
            context2 = l.a.j.a.h.a(context2, n10);
        } else {
            n11 = 0;
            context2 = null;
        }
        n10 = this.l;
        if (n10 != 0) {
            context = this.d.getContext();
            int n16 = this.l;
            context = l.a.j.a.h.a(context, n16);
        } else {
            n10 = 0;
            context = null;
        }
        if (context != null) {
            context5 = context;
        }
        n10 = this.m;
        if (n10 != 0) {
            context6 = this.d.getContext();
            n10 = this.m;
            context6 = l.a.j.a.h.a(context6, n10);
        }
        if (context6 != null) {
            context3 = context6;
        }
        n15 = this.h;
        if (n15 != 0 || (n15 = this.j) != 0 || (n15 = this.i) != 0 || (n15 = this.g) != 0 || (n15 = this.l) != 0 || (n15 = this.m) != 0) {
            context6 = this.d;
            context6.setCompoundDrawablesWithIntrinsicBounds((Drawable)context5, (Drawable)context4, (Drawable)context3, (Drawable)context2);
        }
    }

    public void i(AttributeSet attributeSet, int n10) {
        int n11;
        Context context = this.d.getContext();
        int[] nArray = R$styleable.SkinCompatTextHelper;
        boolean bl2 = (context = context.obtainStyledAttributes(attributeSet, nArray, n10, 0)).hasValue(n11 = R$styleable.SkinCompatTextHelper_android_drawableStart);
        if (bl2) {
            this.l = n11 = context.getResourceId(n11, 0);
            this.l = n11 = l.a.q.j.b(n11);
        }
        if (bl2 = context.hasValue(n11 = R$styleable.SkinCompatTextHelper_android_drawableEnd)) {
            this.m = n11 = context.getResourceId(n11, 0);
            this.m = n11 = l.a.q.j.b(n11);
        }
        context.recycle();
        super.i(attributeSet, n10);
    }

    public void j(int n10, int n11, int n12, int n13) {
        this.l = n10;
        this.j = n11;
        this.m = n12;
        this.g = n13;
        this.c();
    }
}

