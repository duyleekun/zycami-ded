/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package d.v.c.m1.d;

import android.text.TextUtils;
import android.view.ViewGroup;
import d.v.c.m1.d.o;
import d.v.c.w0.h5;
import d.v.f.f.a;

public final class n {
    public String a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public String h;
    public a i;
    public String j;
    public a k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public n() {
        int n10;
        this.n = n10 = -1;
        this.o = n10;
    }

    public void a(h5 h52) {
        String string2;
        Object object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = h52.i;
            string2 = this.a;
            object.setText((CharSequence)string2);
            object = h52.i;
            object.setVisibility(0);
        }
        object = h52.f;
        int n10 = this.c;
        int n11 = 8;
        if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = this.b)) ? 1 : 0)) == 0) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = n11;
        }
        object.setVisibility(n10);
        object = h52.b;
        n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = n11;
        }
        object.setVisibility(n10);
        bl2 = this.c;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            object = h52.f;
            string2 = this.b;
            object.setText((CharSequence)string2);
        }
        if (bl2 = this.c) {
            object = h52.b;
            string2 = this.d;
            object.setHint((CharSequence)string2);
            object = h52.b;
            string2 = this.e;
            object.setText((CharSequence)string2);
            object = h52.k;
            string2 = this.e;
            n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n10 == 0) {
                n11 = 0;
            }
            object.setVisibility(n11);
        }
        if ((bl2 = TextUtils.isEmpty((CharSequence)(object = this.a))) || (bl2 = TextUtils.isEmpty((CharSequence)(object = this.b))) && !(bl2 = this.c)) {
            object = (ViewGroup.MarginLayoutParams)h52.c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)object).topMargin = 0;
            string2 = h52.c;
            string2.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((object = this.j) != null) {
            string2 = h52.h;
            string2.setText((CharSequence)object);
        }
        if ((object = this.h) != null && (object = this.i) != null) {
            h52.g.setVisibility(0);
            h52 = h52.g;
            object = this.h;
            h52.setText((CharSequence)object);
        }
    }

    public void b(o o10) {
        a a10;
        int n10;
        String string2 = this.a;
        if (string2 != null) {
            o10.P(string2);
        }
        if ((string2 = this.b) != null) {
            o10.K(string2);
        }
        if ((n10 = this.c) != 0) {
            n10 = 1;
            o10.Q(n10 != 0);
            string2 = this.d;
            o10.I(string2);
            string2 = this.e;
            o10.J(string2);
        }
        if ((n10 = this.f) != 0) {
            o10.M();
        }
        if ((string2 = this.h) != null && (a10 = this.i) != null) {
            o10.L(string2, a10);
        }
        if ((string2 = this.j) != null && (a10 = this.k) != null) {
            o10.O(string2, a10);
        }
        if ((n10 = this.m) != 0) {
            o10.u();
        }
        if ((n10 = this.g) != 0) {
            o10.N();
        }
        n10 = this.n;
        int n11 = this.o;
        o10.H(n10, n11);
    }
}

