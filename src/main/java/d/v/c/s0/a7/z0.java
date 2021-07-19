/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.u0;
import d.v.c.s0.a7.z0$a;

public class z0
extends u0 {
    private d.v.c.w0.z0 h;

    public static z0 B() {
        z0 z02 = new z0();
        z02.setStyle(1, 2132017156);
        return z02;
    }

    public int s() {
        return 2131558466;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (d.v.c.w0.z0)viewDataBinding;
        this.h = viewDataBinding;
        z0$a z0$a = new z0$a(this);
        ((d.v.c.w0.z0)viewDataBinding).z(z0$a);
        int n10 = Windows.l(this.requireContext()).getWidth();
        this.z(n10);
        this.A(true);
    }
}

