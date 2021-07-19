/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 */
package com.zhiyun.cama.speed;

import android.view.View;
import android.widget.PopupWindow;
import com.zhiyun.cama.speed.EditorSpeedFragment;
import com.zhiyun.cama.widget.CurveView;
import com.zhiyun.cama.widget.CurveView$a;
import d.v.c.b1.t.g;
import d.v.e.l.h2;
import d.v.h.e.d;
import d.v.v.q.h;

public class EditorSpeedFragment$a
implements CurveView$a {
    public final /* synthetic */ EditorSpeedFragment a;

    public EditorSpeedFragment$a(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public void a(float f10, float f11) {
        PopupWindow popupWindow = EditorSpeedFragment.Q(this.a);
        boolean bl2 = popupWindow.isShowing();
        if (!bl2) {
            popupWindow = EditorSpeedFragment.Q(this.a);
            CurveView curveView = EditorSpeedFragment.P((EditorSpeedFragment)this.a).b;
            int n10 = (int)f10;
            int n11 = h2.b(20.0f);
            n10 -= n11;
            n11 = h2.b(68.0f);
            CurveView curveView2 = EditorSpeedFragment.P((EditorSpeedFragment)this.a).b;
            int n12 = curveView2.getHeight();
            f11 = -((float)(n11 + n12) - f11);
            int n13 = (int)f11;
            n11 = 80;
            popupWindow.showAsDropDown((View)curveView, n10, n13, n11);
        }
    }

    public void b(boolean bl2, String string2) {
        EditorSpeedFragment.R(this.a).r3(string2);
        EditorSpeedFragment.z(this.a).w3(bl2);
    }

    public void c(String string2) {
        EditorSpeedFragment.x(this.a).L(string2);
    }

    public void d(long l10) {
        Object object = EditorSpeedFragment.y(this.a);
        boolean n10 = ((d)object).R();
        if (n10) {
            object = this.a;
            EditorSpeedFragment.J((EditorSpeedFragment)object, l10);
        } else {
            object = this.a;
            int n11 = EditorSpeedFragment.L((EditorSpeedFragment)object);
            long l11 = h.g0(n11);
            g g10 = EditorSpeedFragment.M(this.a);
            double d10 = g10.W1();
            g g11 = EditorSpeedFragment.N(this.a);
            double d11 = l11;
            double d12 = (double)l10 / d10;
            l10 = (long)(d11 += d12);
            g11.a3(l10);
        }
    }

    public void e(float f10, float f11) {
        PopupWindow popupWindow = EditorSpeedFragment.O(this.a);
        boolean bl2 = popupWindow.isShowing();
        if (!bl2) {
            popupWindow = EditorSpeedFragment.O(this.a);
            CurveView curveView = EditorSpeedFragment.P((EditorSpeedFragment)this.a).b;
            int n10 = (int)f10;
            int n11 = h2.b(20.0f);
            n10 -= n11;
            n11 = h2.b(68.0f);
            CurveView curveView2 = EditorSpeedFragment.P((EditorSpeedFragment)this.a).b;
            int n12 = curveView2.getHeight();
            f11 = -((float)(n11 + n12) - f11);
            int n13 = (int)f11;
            n11 = 48;
            popupWindow.showAsDropDown((View)curveView, n10, n13, n11);
        }
    }
}

