/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import d.v.c.s0.a7.f1;

public class f1$a {
    public final /* synthetic */ f1 a;

    public f1$a(f1 f12) {
        this.a = f12;
    }

    public void a() {
        Object object = f1.B((f1)this.a).h;
        int n10 = object.getVisibility();
        if (n10 == 0) {
            object = NavHostFragment.findNavController(f1.C(this.a));
            ((NavController)object).navigateUp();
        } else {
            object = this.a;
            ((DialogFragment)object).dismissAllowingStateLoss();
        }
    }
}

