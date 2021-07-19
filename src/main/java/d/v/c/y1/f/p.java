/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.Intent
 *  android.util.Size
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.y1.f;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Size;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.common.util.Windows;
import d.v.c.i1.i2;
import d.v.c.k1.b.a;
import d.v.c.m1.d.l;
import d.v.c.m1.d.l$b;
import d.v.c.q0.b;
import d.v.c.w0.z6;
import d.v.c.y1.f.d;
import d.v.c.y1.f.e;
import d.v.c.y1.f.f;
import d.v.c.y1.f.p$a;
import d.v.c.y1.f.p$b;
import d.v.c.y1.f.p$c;
import d.v.c.y1.f.q;
import d.v.c.y1.f.u;
import d.v.c.y1.f.v.j;
import d.v.c.y1.f.x.f0;
import d.v.e.i.h;
import java.util.List;

public class p
extends b {
    private static final int j = 1;
    private final Fragment[] g;
    private z6 h;
    private u i;

    public p() {
        Fragment[] fragmentArray = new Fragment[3];
        this.g = fragmentArray;
    }

    public static p A() {
        p p10 = new p();
        return p10;
    }

    private void B() {
        this.C();
        this.E();
    }

    private void C() {
        Fragment[] fragmentArray = this.g;
        d.v.c.q0.d d10 = new d.v.c.y1.f.w.f();
        fragmentArray[0] = d10;
        fragmentArray = this.g;
        d10 = new j();
        fragmentArray[1] = d10;
        fragmentArray = this.g;
        d10 = new f0();
        fragmentArray[2] = d10;
    }

    private void D() {
        Object object = this.h.j;
        Object object2 = new p$a(this);
        ((ViewPager2)((Object)object)).registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
        object = this.i.b();
        object2 = new e(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.i.e();
        object2 = this.getViewLifecycleOwner();
        f f10 = new f(this);
        ((LiveData)object).observe((LifecycleOwner)object2, f10);
    }

    private void E() {
        Object object = new p$c(this, this);
        ViewPager2 viewPager2 = this.h.j;
        viewPager2.setAdapter((RecyclerView$Adapter)object);
        object = this.i.c().getValue();
        if (object == null) {
            object = this.h.j;
            int n10 = 1;
            ((ViewPager2)((Object)object)).setCurrentItem(n10);
            object = this.i;
            ((u)object).g(n10);
        }
        this.D();
    }

    private /* synthetic */ void F(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.i();
        }
    }

    private /* synthetic */ void H(q object) {
        if (object == null) {
            return;
        }
        Object object2 = ((q)object).G();
        boolean bl2 = ((a)object2).k();
        if (bl2 && !(bl2 = d.v.c.m1.b.a())) {
            int n10 = 1;
            object = l.y(n10);
            object2 = new d(this);
            object = ((l)object).z((l$b)object2);
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        } else {
            this.M((q)object);
        }
    }

    private /* synthetic */ void J() {
        d.v.c.m1.b.e(this);
    }

    private void L() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            float f10;
            int n10;
            dialog = dialog.getWindow();
            dialog.getAttributes().windowAnimations = 2132017745;
            int n11 = 2131232029;
            dialog.setBackgroundDrawableResource(n11);
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            window = dialog.getAttributes();
            window.width = -1;
            Size size = Windows.o(this.requireContext());
            window.height = n10 = size.getHeight() * 2 / 3;
            window.gravity = 80;
            window.dimAmount = f10 = 0.5f;
            window.flags = n10 = window.flags | 2;
            dialog.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    private void M(q object) {
        String string2 = ((q)object).G().g();
        String string3 = ((q)object).G().b();
        if (string3 != null) {
            object = ((q)object).G().b();
        } else {
            boolean bl2 = ((String)(object = ((q)object).G().i())).contains(string3 = ".");
            if (bl2) {
                bl2 = false;
                int n10 = ((String)object).lastIndexOf(string3);
                object = ((String)object).substring(0, n10);
            }
        }
        this.z(string2, (String)object);
    }

    public static /* synthetic */ u w(p p10) {
        return p10.i;
    }

    public static /* synthetic */ z6 x(p p10) {
        return p10.h;
    }

    public static /* synthetic */ Fragment[] y(p p10) {
        return p10.g;
    }

    private void z(String string2, String object) {
        int n10;
        Object object2;
        int n11 = d.v.v.q.h.m();
        boolean bl2 = d.v.j.b.h(n11, (List)(object2 = this.f.H1()));
        if (!bl2 && (n10 = string2.equals(object2 = ((d.v.h.h.b)object2.get(n11)).k())) != 0) {
            return;
        }
        object2 = this.f;
        boolean bl3 = ((i2)object2).P2(string2, (String)object);
        if (bl3) {
            object = this.f;
            n10 = -1;
            long l10 = n11 == n10 ? 0x400000L : 0x2000000L;
            ((i2)object).b3(l10);
        }
        this.i.f(bl3);
    }

    public /* synthetic */ void G(Boolean bl2) {
        this.F(bl2);
    }

    public /* synthetic */ void I(q q10) {
        this.H(q10);
    }

    public /* synthetic */ void K() {
        this.J();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        q q10;
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) != 0 && (q10 = (q)this.i.e().getValue()) != null) {
            this.M(q10);
        }
    }

    public void onDismiss(DialogInterface object) {
        super.onDismiss((DialogInterface)object);
        object = this.f.g1();
        Boolean bl2 = Boolean.TRUE;
        d.v.e.i.h.g((MutableLiveData)object, bl2);
    }

    public int s() {
        return 2131558573;
    }

    public void t(ViewDataBinding object) {
        super.t((ViewDataBinding)object);
        object = (z6)object;
        this.h = object;
        this.i = object = (u)d.v.i0.b.a(this).get(u.class);
        this.h.B((u)object);
        object = this.h;
        p$b p$b = new p$b(this);
        ((z6)object).A(p$b);
        this.L();
        this.B();
    }
}

