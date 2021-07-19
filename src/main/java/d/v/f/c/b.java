/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.f.c;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.f.c.c;

public abstract class b
extends c {
    public abstract int d();

    public void f(ViewDataBinding viewDataBinding, Bundle bundle) {
    }

    public void h() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h();
        int n10 = this.d();
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, n10);
        viewDataBinding.setLifecycleOwner(this);
        this.f(viewDataBinding, bundle);
    }
}

