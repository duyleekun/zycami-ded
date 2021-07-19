/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.f.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.f.h.b;

public abstract class a
extends b {
    private ViewDataBinding a;

    public abstract int h();

    public void i(ViewDataBinding viewDataBinding) {
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        int n10 = this.h();
        object = DataBindingUtil.inflate((LayoutInflater)object, n10, object2, false);
        this.a = object;
        object2 = this.getViewLifecycleOwner();
        ((ViewDataBinding)object).setLifecycleOwner((LifecycleOwner)object2);
        object = this.a;
        this.i((ViewDataBinding)object);
        return this.a.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ViewDataBinding viewDataBinding = this.a;
        if (viewDataBinding != null) {
            viewDataBinding.unbind();
        }
    }
}

