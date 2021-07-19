/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 *  android.widget.TextView
 */
package com.zhiyun.cama.speed;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zhiyun.cama.speed.EditorSpeedFragment;
import d.v.c.b1.t.g;
import d.v.c.q0.d$a;
import d.v.c.s1.s;
import d.v.e.l.h2;
import d.v.v.q.h;

public class EditorSpeedFragment$b
extends d$a {
    public final /* synthetic */ EditorSpeedFragment c;

    public EditorSpeedFragment$b(EditorSpeedFragment editorSpeedFragment) {
        this.c = editorSpeedFragment;
        super(editorSpeedFragment);
    }

    public void c() {
        Object object;
        int n10;
        super.c();
        for (int i10 = 0; i10 < (n10 = (object = EditorSpeedFragment.A(this.c).c()).size()); ++i10) {
            g g10;
            object = EditorSpeedFragment.A(this.c).o(i10);
            if (object == null) continue;
            boolean bl2 = ((s)object).c();
            if (bl2) {
                g10 = EditorSpeedFragment.B(this.c);
                object = ((s)object).a();
                g10.K(i10, (String)object, false);
                continue;
            }
            g10 = EditorSpeedFragment.C(this.c);
            double d10 = ((s)object).b();
            g10.d0(i10, d10);
        }
    }

    public void d() {
        super.d();
        EditorSpeedFragment.D(this.c, 4);
        g g10 = EditorSpeedFragment.E(this.c);
        long l10 = h.g0(h.p());
        g10.a3(l10);
    }

    public void f() {
        super.f();
        g g10 = EditorSpeedFragment.F(this.c);
        double d10 = g10.B1();
        double d11 = -1.0;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (d12 == false) {
            return;
        }
        d11 = 1.0;
        int n10 = Double.compare(d10, d11);
        if (n10 >= 0) {
            d10 = d11;
        }
        EditorSpeedFragment.G(this.c, d10);
    }

    public void h() {
        PopupWindow popupWindow = EditorSpeedFragment.I(this.c);
        int n10 = popupWindow.isShowing();
        if (n10 == 0) {
            n10 = EditorSpeedFragment.P((EditorSpeedFragment)this.c).e.getWidth();
            int n11 = EditorSpeedFragment.K(this.c).getMeasuredWidth();
            PopupWindow popupWindow2 = EditorSpeedFragment.I(this.c);
            TextView textView = EditorSpeedFragment.P((EditorSpeedFragment)this.c).e;
            float f10 = 10.0f;
            int n12 = h2.b(f10);
            int n13 = 0x800003;
            popupWindow2.showAsDropDown((View)textView, n10 -= n11, n12, n13);
            popupWindow = EditorSpeedFragment.P((EditorSpeedFragment)this.c).e;
            n11 = 1;
            popupWindow.setSelected(n11 != 0);
        }
    }

    public void i() {
        PopupWindow popupWindow = EditorSpeedFragment.H(this.c);
        int n10 = popupWindow.isShowing();
        if (n10 == 0) {
            popupWindow = EditorSpeedFragment.P((EditorSpeedFragment)this.c).h;
            n10 = popupWindow.getWidth();
            int n11 = EditorSpeedFragment.H(this.c).getContentView().getMeasuredWidth();
            PopupWindow popupWindow2 = EditorSpeedFragment.H(this.c);
            TextView textView = EditorSpeedFragment.P((EditorSpeedFragment)this.c).h;
            float f10 = 10.0f;
            int n12 = h2.b(f10);
            int n13 = 0x800003;
            popupWindow2.showAsDropDown((View)textView, n10 -= n11, n12, n13);
        }
    }
}

