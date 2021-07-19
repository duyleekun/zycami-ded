/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.text.InputFilter
 *  android.text.InputFilter$LengthFilter
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package d.v.g0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.zhiyun.ui.R$color;
import d.v.e.l.o1;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k;
import d.v.g0.t.e;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class l {
    public static final int w = 20;
    public String a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public a j;
    public String k;
    public a l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public List t;
    public int u;
    public Consumer v;

    public l() {
        ArrayList arrayList;
        int n10;
        this.m = n10 = -1;
        this.o = n10;
        this.p = n10;
        this.t = arrayList = new ArrayList();
        this.u = 20;
    }

    private void c(e e10) {
        Context context = e10.getRoot().getContext();
        int n10 = R$color.dialog_color_positive;
        int n11 = d.v.f.i.g.c(context, n10);
        e10.g.setTextColor(n11);
    }

    public void a(k k10) {
        a a10;
        int n10;
        Object object = this.a;
        if (object != null) {
            k10.X((String)object);
        }
        if ((object = this.b) != null) {
            k10.O((String)object);
        }
        if ((n10 = this.c) != 0) {
            n10 = 1;
            k10.Z(n10 != 0);
            object = this.d;
            k10.K((String)object);
            object = this.e;
            k10.L((String)object);
        }
        if ((n10 = this.f) != 0) {
            k10.R();
        }
        if ((object = this.i) != null && (a10 = this.j) != null) {
            k10.P((String)object, a10);
        }
        if ((object = this.k) != null && (a10 = this.l) != null) {
            k10.U((String)object, a10);
        }
        if ((n10 = this.n) != 0) {
            k10.u();
        }
        if ((n10 = this.g) != 0) {
            k10.S();
        }
        n10 = this.h;
        k10.W(n10 != 0);
        n10 = this.o;
        int n11 = this.p;
        k10.J(n10, n11);
        n10 = -1;
        n11 = this.m;
        if (n10 != n11) {
            k10.C(n11);
        }
        n10 = (int)(this.q ? 1 : 0);
        k10.Y(n10 != 0);
        n10 = this.r;
        k10.Q(n10 != 0);
        n10 = this.s;
        k10.V(n10 != 0);
        object = this.v;
        k10.T((Consumer)object);
        object = this.t;
        k10.M((List)object);
        n10 = this.u;
        k10.N(n10);
    }

    public void b(e e10) {
        int n10;
        Object object;
        Typeface typeface;
        Object object2;
        int n11;
        this.c(e10);
        Typeface typeface2 = new ArrayList();
        int n12 = this.d();
        if (n12 != 0) {
            n11 = this.u;
            object2 = new InputFilter.LengthFilter(n11);
            typeface2.add(object2);
        }
        object2 = this.t;
        typeface2.addAll(object2);
        n12 = typeface2.size();
        if (n12 > 0) {
            object2 = e10.b;
            n11 = typeface2.size();
            typeface = new InputFilter[n11];
            typeface2 = typeface2.toArray((T[])typeface);
            object2.setFilters((InputFilter[])typeface2);
        }
        int n13 = 1;
        typeface2 = Typeface.defaultFromStyle((int)n13);
        n12 = 0;
        object2 = null;
        typeface = Typeface.defaultFromStyle((int)0);
        Object object3 = this.a;
        int n14 = TextUtils.isEmpty((CharSequence)object3);
        if (n14 == 0) {
            object3 = e10.j;
            object = this.a;
            object3.setText((CharSequence)object);
            e10.j.setVisibility(0);
            object3 = e10.j;
            n10 = (int)(this.q ? 1 : 0);
            object = n10 != 0 ? typeface2 : typeface;
            object3.setTypeface(object);
        }
        object3 = e10.j;
        n10 = this.h;
        int n15 = 17;
        int n16 = 0x800003;
        float f10 = 1.1754948E-38f;
        n10 = n10 != 0 ? n15 : n16;
        object3.setGravity(n10);
        object3 = e10.h;
        n10 = (int)(this.h ? 1 : 0);
        if (n10 == 0) {
            n15 = n16;
        }
        object3.setGravity(n15);
        object3 = e10.h;
        n10 = (int)(this.c ? 1 : 0);
        n15 = 8;
        if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.b)) ? 1 : 0)) == 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = n15;
        }
        object3.setVisibility(n10);
        object3 = e10.b;
        n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = n15;
        }
        object3.setVisibility(n10);
        object3 = e10.i;
        n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = n15;
        }
        object3.setVisibility(n10);
        n14 = this.c;
        if (n14 == 0 && (n14 = TextUtils.isEmpty((CharSequence)(object3 = this.b))) == 0) {
            object3 = e10.h;
            object = this.b;
            object3.setText((CharSequence)object);
        }
        if ((n14 = this.c) != 0) {
            Object object4;
            object3 = e10.b;
            object = this.d;
            object3.setHint((CharSequence)object);
            object3 = e10.b;
            object = this.e;
            object3.setText((CharSequence)object);
            object3 = e10.b.getText().toString().trim();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
            Object object5 = e10.k;
            if (n10 == 0) {
                n15 = 0;
                object4 = null;
            }
            object5.setVisibility(n15);
            n15 = this.u;
            if (n15 > 0 && n10 == 0) {
                object4 = e10.i;
                object5 = new StringBuilder();
                n14 = ((String)object3).length();
                ((StringBuilder)object5).append(n14);
                ((StringBuilder)object5).append("/");
                n14 = this.u;
                ((StringBuilder)object5).append(n14);
                object3 = ((StringBuilder)object5).toString();
                object4.setText((CharSequence)object3);
            } else {
                object3 = e10.i;
                object4 = "";
                object3.setText((CharSequence)object4);
            }
            n14 = n10 != 0 ? R$color.dialog_color_positive_unable : R$color.dialog_color_positive;
            object = e10.g;
            n14 = o1.e((View)object, n14);
            object.setTextColor(n14);
        }
        if ((n14 = TextUtils.isEmpty((CharSequence)(object3 = this.a))) != 0 || (n14 = TextUtils.isEmpty((CharSequence)(object3 = this.b))) != 0 && (n14 = this.c) == 0) {
            object3 = (ViewGroup.MarginLayoutParams)e10.c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)object3).topMargin = 0;
            object = e10.c;
            object.setLayoutParams((ViewGroup.LayoutParams)object3);
        }
        if ((object3 = this.k) != null) {
            object = e10.g;
            object.setText((CharSequence)object3);
            object3 = e10.g;
            n10 = (int)(this.s ? 1 : 0);
            object = n10 != 0 ? typeface2 : typeface;
            object3.setTypeface(object);
        }
        if ((object3 = this.i) != null && (object3 = this.j) != null) {
            e10.f.setVisibility(0);
            object2 = e10.f;
            object3 = this.i;
            object2.setText((CharSequence)object3);
            e10 = e10.f;
            n12 = (int)(this.r ? 1 : 0);
            if (n12 == 0) {
                typeface2 = typeface;
            }
            e10.setTypeface(typeface2);
        }
    }

    public boolean d() {
        int n10 = this.u;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }
}

