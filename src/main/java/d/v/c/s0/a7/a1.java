/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.a1$a;
import d.v.c.s0.a7.u0;
import d.v.c.s0.a7.z0;
import d.v.c.w0.t0;

public class a1
extends u0 {
    private t0 h;

    public static z0 B() {
        z0 z02 = new z0();
        z02.setStyle(1, 2132017156);
        return z02;
    }

    public int s() {
        return 2131558463;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (t0)viewDataBinding;
        this.h = viewDataBinding;
        a1$a a1$a = new a1$a(this);
        ((t0)viewDataBinding).z(a1$a);
        int n10 = Windows.l(this.requireContext()).getWidth();
        this.z(n10);
        this.A(true);
    }
}

