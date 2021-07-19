/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.View
 *  android.view.WindowManager$LayoutParams
 */
package d.v.g0;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;
import d.v.g0.a;
import d.v.g0.k$c;
import d.v.g0.l;
import d.v.g0.q;
import d.v.g0.t.e;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class k
extends q {
    public static final int n = 255;
    private l l;
    private e m;

    public k() {
        l l10;
        this.l = l10 = new l();
    }

    public static /* synthetic */ l E(k k10) {
        return k10.l;
    }

    public static /* synthetic */ e F(k k10) {
        return k10.m;
    }

    private /* synthetic */ void H(Consumer consumer) {
        e e10 = this.m;
        consumer.accept(e10);
    }

    public String G() {
        return this.m.b.getText().toString().trim();
    }

    public /* synthetic */ void I(Consumer consumer) {
        this.H(consumer);
    }

    public void J(int n10, int n11) {
        l l10 = this.l;
        l10.o = n10;
        l10.p = n11;
    }

    public void K(String string2) {
        this.l.d = string2;
    }

    public void L(String string2) {
        this.l.e = string2;
    }

    public void M(List list) {
        this.l.t = list;
    }

    public void N(int n10) {
        this.l.u = n10;
    }

    public void O(String string2) {
        this.l.b = string2;
    }

    public void P(String string2, d.v.f.f.a a10) {
        l l10 = this.l;
        l10.i = string2;
        l10.j = a10;
    }

    public void Q(boolean bl2) {
        this.l.r = bl2;
    }

    public void R() {
        this.setCancelable(false);
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog = this.getDialog();
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    public void S() {
        this.l.g = true;
    }

    public void T(Consumer consumer) {
        this.l.v = consumer;
    }

    public void U(String string2, d.v.f.f.a a10) {
        l l10 = this.l;
        l10.k = string2;
        l10.l = a10;
    }

    public void V(boolean bl2) {
        this.l.s = bl2;
    }

    public void W(boolean bl2) {
        this.l.h = bl2;
    }

    public void X(String string2) {
        this.l.a = string2;
    }

    public void Y(boolean bl2) {
        this.l.q = bl2;
    }

    public void Z(boolean bl2) {
        this.l.c = bl2;
    }

    public String j() {
        return this.toString();
    }

    public void onStart() {
        int n10;
        super.onStart();
        l l10 = this.l;
        int n11 = l10.o;
        int n12 = -1;
        if ((n11 != n12 || (n10 = l10.p) != n12) && (l10 = this.getDialog()) != null && (l10 = this.getDialog().getWindow()) != null) {
            l l11 = this.l;
            n11 = l11.o;
            if (n11 == n12) {
                l11 = l10.getAttributes();
                n11 = ((WindowManager.LayoutParams)l11).width;
            }
            l l12 = this.l;
            int n13 = l12.p;
            if (n13 == n12) {
                WindowManager.LayoutParams layoutParams = l10.getAttributes();
                n13 = layoutParams.height;
            }
            l10.setLayout(n11, n13);
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.l;
        object2 = this.m;
        ((l)object).b((e)object2);
        object = Optional.ofNullable(this.l.v);
        object2 = new a(this);
        ((Optional)object).ifPresent(object2);
    }

    public int s() {
        return R$layout.zyui_frag_confirm;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (e)viewDataBinding;
        this.m = viewDataBinding;
        k$c k$c = new k$c(this);
        ((e)viewDataBinding).z(k$c);
    }
}

