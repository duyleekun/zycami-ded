/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.c;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.c.w0.sc;
import d.v.c.x0.c.c.f;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class e
extends b {
    private f g;

    public e(LifecycleOwner lifecycleOwner, f f10) {
        super(lifecycleOwner, f10);
        this.g = f10;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (sc)viewDataBinding;
        object = this.g;
        ((sc)viewDataBinding).C((f)object);
        object = (Integer)this.d().get(n10);
        ((sc)viewDataBinding).B((Integer)object);
        object = n10;
        ((sc)viewDataBinding).D((Integer)object);
    }

    public int e(int n10) {
        return 2131558655;
    }
}

