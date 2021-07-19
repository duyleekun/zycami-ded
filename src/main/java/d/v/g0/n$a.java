/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.g0;

import android.view.View;
import android.widget.PopupWindow;
import com.zhiyun.ui.FixedPopupWindow;
import d.v.g0.m;
import d.v.g0.n;

public class n$a {
    private final m a;
    private n b;
    private FixedPopupWindow c;

    public n$a() {
        m m10;
        this.a = m10 = new m();
    }

    public void a() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = this.c) != null && (bl2 = object.isShowing())) {
            object = this.c;
            object.dismiss();
        }
    }

    public n$a b(int n10) {
        this.a.i = n10;
        return this;
    }

    public n$a c(View view) {
        this.a.a = view;
        return this;
    }

    public n$a d(int n10) {
        this.a.c = n10;
        return this;
    }

    public n$a e(float f10) {
        this.a.k = f10;
        return this;
    }

    public n$a f(int n10) {
        this.a.j = n10;
        return this;
    }

    public n$a g(int n10) {
        this.a.g = n10;
        return this;
    }

    public n$a h(int n10) {
        this.a.d = n10;
        return this;
    }

    public n$a i(boolean bl2) {
        this.a.l = bl2;
        return this;
    }

    public n$a j(PopupWindow.OnDismissListener onDismissListener) {
        this.a.m = onDismissListener;
        return this;
    }

    public n$a k(String string2) {
        this.a.b = string2;
        return this;
    }

    public n$a l(int n10) {
        this.a.h = n10;
        return this;
    }

    public n$a m(int n10) {
        this.a.e = n10;
        return this;
    }

    public n$a n(int n10) {
        this.a.f = n10;
        return this;
    }

    public n$a o() {
        Object object;
        this.b = object = new n();
        this.a.a((n)object);
        object = n.b(this.b);
        this.c = object;
        return this;
    }

    public n$a p() {
        FixedPopupWindow fixedPopupWindow;
        n n10 = this.b;
        if (n10 != null && (fixedPopupWindow = this.c) != null) {
            this.a.a(n10);
            n10 = this.b;
            fixedPopupWindow = this.c;
            n.c(n10, fixedPopupWindow);
        }
        return this;
    }
}

