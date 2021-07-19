/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1.t;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.zhiyun.cama.main.EditorMainFragment;
import d.v.c.b1.t.f$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.d5;
import d.v.i0.b;

public class f
extends d {
    private d5 j;
    private g k;

    public static /* synthetic */ void x(f f10) {
        f10.z();
    }

    public static /* synthetic */ g y(f f10) {
        return f10.k;
    }

    private void z() {
        boolean bl2;
        Fragment fragment = this.getParentFragment();
        if (fragment != null && (bl2 = (fragment = this.getParentFragment()) instanceof EditorMainFragment)) {
            fragment = (EditorMainFragment)this.getParentFragment();
            ((EditorMainFragment)fragment).A0();
        }
    }

    public int h() {
        return 2131558539;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (d5)object;
        this.j = object;
        this.k = object = (g)d.v.i0.b.c(this.requireActivity()).get(g.class);
        this.j.D((g)object);
        object = this.j;
        Object object2 = this.g;
        ((d5)object).C((i2)object2);
        object = this.j;
        object2 = new f$a(this);
        ((d5)object).B((f$a)object2);
    }
}

