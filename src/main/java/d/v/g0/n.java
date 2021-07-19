/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.g0;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.FixedPopupWindow;
import com.zhiyun.ui.R$layout;
import d.v.g0.c;
import d.v.g0.d;
import d.v.g0.m;
import d.v.g0.t.i;

public class n {
    private final m a;

    public n() {
        m m10;
        this.a = m10 = new m();
    }

    public static /* synthetic */ FixedPopupWindow b(n n10) {
        return n10.d();
    }

    public static /* synthetic */ void c(n n10, FixedPopupWindow fixedPopupWindow) {
        n10.v(fixedPopupWindow);
    }

    private FixedPopupWindow d() {
        Object object = LayoutInflater.from((Context)this.a.a.getContext());
        int n10 = R$layout.zyui_pop_guide_layout;
        object = i.s(object.inflate(n10, null, false));
        this.a.b((i)object);
        object = ((ViewDataBinding)object).getRoot();
        int n11 = -2;
        FixedPopupWindow fixedPopupWindow = new FixedPopupWindow((View)object, n11, n11);
        int n12 = 1;
        fixedPopupWindow.setOutsideTouchable(n12 != 0);
        Object object2 = this.a;
        n11 = (int)(((m)object2).l ? 1 : 0);
        if (n11 != 0) {
            fixedPopupWindow.setFocusable(false);
        } else {
            fixedPopupWindow.setFocusable(n12 != 0);
        }
        n12 = this.a.c;
        fixedPopupWindow.setAnimationStyle(n12);
        object = this.a.m;
        fixedPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)object);
        object = this.a.a;
        object2 = new c(this, fixedPopupWindow);
        object.post((Runnable)object2);
        return fixedPopupWindow;
    }

    private void e(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            n10 = 5894;
            view.setSystemUiVisibility(n10);
        }
    }

    private /* synthetic */ void f(FixedPopupWindow fixedPopupWindow) {
        m m10 = this.a;
        View view = m10.a;
        int n10 = m10.d;
        int n11 = m10.e;
        int bl2 = m10.f;
        fixedPopupWindow.showAtLocation(view, n10, n11, bl2);
        m10 = this.a;
        boolean bl3 = m10.l;
        if (bl3) {
            m10 = fixedPopupWindow.getContentView();
            this.e((View)m10);
            boolean bl4 = true;
            fixedPopupWindow.setFocusable(bl4);
        }
    }

    private /* synthetic */ void h(FixedPopupWindow fixedPopupWindow) {
        m m10 = this.a;
        Object object = m10.a;
        int n10 = m10.d;
        int n11 = m10.e;
        int bl2 = m10.f;
        fixedPopupWindow.showAtLocation((View)object, n10, n11, bl2);
        m10 = this.a;
        boolean bl3 = m10.l;
        if (bl3) {
            m10 = fixedPopupWindow.getContentView();
            this.e((View)m10);
            boolean bl4 = true;
            fixedPopupWindow.setFocusable(bl4);
        }
        m10 = this.a;
        n10 = m10.e;
        n11 = m10.f;
        object = fixedPopupWindow;
        fixedPopupWindow.update(n10, n11, -2, -2, true);
    }

    private void v(FixedPopupWindow fixedPopupWindow) {
        Object object = (Activity)this.a.a.getContext();
        int n10 = object.isFinishing();
        if (n10 != 0) {
            return;
        }
        if (fixedPopupWindow == null) {
            return;
        }
        object = (i)DataBindingUtil.getBinding(fixedPopupWindow.getContentView());
        if (object == null) {
            return;
        }
        Object object2 = this.a;
        ((m)object2).b((i)object);
        object = this.a;
        n10 = object.l;
        if (n10 != 0) {
            n10 = 0;
            object = null;
            fixedPopupWindow.setFocusable(false);
        } else {
            n10 = 1;
            fixedPopupWindow.setFocusable(n10 != 0);
        }
        n10 = this.a.c;
        fixedPopupWindow.setAnimationStyle(n10);
        object = this.a.m;
        fixedPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)object);
        object = this.a.a;
        object2 = new d(this, fixedPopupWindow);
        object.post((Runnable)object2);
    }

    public void a(View view) {
        this.a.a = view;
    }

    public /* synthetic */ void g(FixedPopupWindow fixedPopupWindow) {
        this.f(fixedPopupWindow);
    }

    public /* synthetic */ void i(FixedPopupWindow fixedPopupWindow) {
        this.h(fixedPopupWindow);
    }

    public void j(int n10) {
        this.a.i = n10;
    }

    public void k(int n10) {
        this.a.c = n10;
    }

    public void l(float f10) {
        this.a.k = f10;
    }

    public void m(int n10) {
        this.a.j = n10;
    }

    public void n(int n10) {
        this.a.g = n10;
    }

    public void o(int n10) {
        this.a.d = n10;
    }

    public void p(boolean bl2) {
        this.a.l = bl2;
    }

    public void q(PopupWindow.OnDismissListener onDismissListener) {
        this.a.m = onDismissListener;
    }

    public void r(String string2) {
        this.a.b = string2;
    }

    public void s(int n10) {
        this.a.h = n10;
    }

    public void t(int n10) {
        this.a.e = n10;
    }

    public void u(int n10) {
        this.a.f = n10;
    }
}

