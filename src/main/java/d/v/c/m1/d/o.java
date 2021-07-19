/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.View
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.m1.d;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import d.v.c.m1.d.n;
import d.v.c.m1.d.o$b;
import d.v.c.w0.h5;
import d.v.f.f.a;
import d.v.g0.q;

public class o
extends q {
    private static final String n = "PrimeConfirmDialog";
    public static final int o = 255;
    private n l;
    private h5 m;

    public o() {
        n n10;
        this.l = n10 = new n();
    }

    public static /* synthetic */ n E(o o10) {
        return o10.l;
    }

    public static /* synthetic */ h5 F(o o10) {
        return o10.m;
    }

    public String G() {
        return this.m.b.getText().toString().trim();
    }

    public void H(int n10, int n11) {
        n n12 = this.l;
        n12.n = n10;
        n12.o = n11;
    }

    public void I(String string2) {
        this.l.d = string2;
    }

    public void J(String string2) {
        this.l.e = string2;
    }

    public void K(String string2) {
        this.l.b = string2;
    }

    public void L(String string2, a a10) {
        n n10 = this.l;
        n10.h = string2;
        n10.i = a10;
    }

    public void M() {
        this.setCancelable(false);
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog = this.getDialog();
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    public void N() {
        this.l.g = true;
    }

    public void O(String string2, a a10) {
        n n10 = this.l;
        n10.j = string2;
        n10.k = a10;
    }

    public void P(String string2) {
        this.l.a = string2;
    }

    public void Q(boolean bl2) {
        this.l.c = bl2;
    }

    public void onStart() {
        int n10;
        super.onStart();
        n n11 = this.l;
        int n12 = n11.n;
        int n13 = -1;
        if ((n12 != n13 || (n10 = n11.o) != n13) && (n11 = this.getDialog()) != null && (n11 = this.getDialog().getWindow()) != null) {
            n n14 = this.l;
            n12 = n14.n;
            if (n12 == n13) {
                n14 = n11.getAttributes();
                n12 = ((WindowManager.LayoutParams)n14).width;
            }
            n n15 = this.l;
            int n16 = n15.o;
            if (n16 == n13) {
                WindowManager.LayoutParams layoutParams = n11.getAttributes();
                n16 = layoutParams.height;
            }
            n11.setLayout(n12, n16);
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.l;
        object2 = this.m;
        ((n)object).a((h5)object2);
    }

    public int s() {
        return 2131558552;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (h5)viewDataBinding;
        this.m = viewDataBinding;
        o$b o$b = new o$b(this);
        ((h5)viewDataBinding).z(o$b);
    }
}

