/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.c.b1.r;
import d.v.c.b1.s;
import d.v.c.w0.sa;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class q
extends b {
    private s g;

    public q(LifecycleOwner lifecycleOwner, s s10) {
        super(lifecycleOwner, s10);
        this.g = s10;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (sa)viewDataBinding;
        object = (r)this.d().get(n10);
        ((sa)viewDataBinding).B((r)object);
        object = n10;
        ((sa)viewDataBinding).C((Integer)object);
        object = this.g;
        ((sa)viewDataBinding).D((s)object);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558627;
    }
}

