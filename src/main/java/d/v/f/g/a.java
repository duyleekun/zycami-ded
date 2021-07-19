/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.f.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.f.g.b;

public abstract class a
extends b {
    private ViewDataBinding e;

    public View onCreateView(LayoutInflater object, ViewGroup viewGroup, Bundle bundle) {
        int n10 = this.s();
        object = DataBindingUtil.inflate((LayoutInflater)object, n10, viewGroup, false);
        this.e = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.e;
        this.t((ViewDataBinding)object);
        return this.e.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ViewDataBinding viewDataBinding = this.e;
        if (viewDataBinding != null) {
            viewDataBinding.unbind();
        }
    }

    public abstract int s();

    public void t(ViewDataBinding viewDataBinding) {
    }
}

