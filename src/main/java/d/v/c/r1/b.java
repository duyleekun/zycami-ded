/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.r1;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.c.r1.d;
import d.v.c.r1.e;
import d.v.c.w0.cc;
import d.v.f.d.b$b;

public class b
extends d.v.f.d.b {
    private int g;

    public b(LifecycleOwner lifecycleOwner, e e10) {
        super(lifecycleOwner, e10);
        this.k();
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (cc)viewDataBinding;
        object = (d)this.d().get(n10);
        ((cc)viewDataBinding).z((d)object);
        object = viewDataBinding.getRoot().getLayoutParams();
        ((ViewGroup.LayoutParams)object).width = n10 = this.g;
        ((ViewGroup.LayoutParams)object).height = n10;
        viewDataBinding.getRoot().setLayoutParams((ViewGroup.LayoutParams)object);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558645;
    }

    public void o(int n10) {
        this.g = n10;
    }
}

