/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.c.s1.r$a;
import d.v.c.s1.t;
import d.v.c.s1.u;
import d.v.c.w0.ec;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class r
extends b {
    private u g;

    public r(LifecycleOwner lifecycleOwner, u u10) {
        r$a r$a = new r$a();
        super(lifecycleOwner, u10, r$a);
        this.g = u10;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (ec)viewDataBinding;
        object = (t)this.d().get(n10);
        ((ec)viewDataBinding).C((t)object);
        object = n10;
        ((ec)viewDataBinding).B((Integer)object);
        object = this.g;
        ((ec)viewDataBinding).D((u)object);
    }

    public int e(int n10) {
        return 2131558646;
    }
}

