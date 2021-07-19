/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.j1;
import d.v.c.s0.a7.u0;
import d.v.c.w0.p3;
import d.v.i0.b;

public class i1
extends u0 {
    private static i1 j;
    private p3 h;
    private j1 i;

    public static void B() {
        i1 i12 = j;
        if (i12 != null) {
            try {
                i12.dismissAllowingStateLoss();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static boolean C() {
        boolean bl2;
        i1 i12 = j;
        if (i12 != null && (i12 = i12.getDialog()) != null && (bl2 = (i12 = j.getDialog()).isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            i12 = null;
        }
        return bl2;
    }

    public static i1 D() {
        i1 i12 = new i1();
        i12.setStyle(1, 2132017156);
        Bundle bundle = new Bundle();
        i12.setArguments(bundle);
        return i12;
    }

    public static i1 E(FragmentManager fragmentManager, int n10) {
        boolean bl2 = i1.C();
        if (!bl2) {
            i1 i12;
            j = i12 = i1.D();
            i12.r(fragmentManager, n10);
        }
        return j;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (j1)b.c(this.requireActivity()).get(j1.class);
        this.i = object;
    }

    public int s() {
        return 2131558519;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (p3)viewDataBinding;
        this.h = viewDataBinding;
        j1 j12 = this.i;
        ((p3)viewDataBinding).z(j12);
        int n10 = Windows.l(this.requireContext()).getWidth();
        this.z(n10);
        this.A(true);
    }
}

