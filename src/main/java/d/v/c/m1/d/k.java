/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.m1.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.AccountActivity;
import d.v.a.i.a.m0;
import d.v.c.m1.d.a;
import d.v.c.m1.d.b;
import d.v.c.m1.d.c;
import d.v.c.m1.d.d;
import d.v.c.m1.d.e;
import d.v.c.m1.d.g;
import d.v.c.m1.d.k$a;
import d.v.c.w0.cg;
import d.v.e.i.j;
import d.v.g0.k$b;
import d.v.g0.s;

public class k
extends d.v.f.g.a {
    private cg f;
    private m0 g;

    private /* synthetic */ void B(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private /* synthetic */ void D(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.requireActivity();
            int n10 = 3;
            AccountActivity.i((Activity)object, n10);
        }
    }

    public static k F() {
        k k10 = new k();
        return k10;
    }

    public static /* synthetic */ m0 u(k k10) {
        return k10.g;
    }

    private void v() {
        MutableLiveData mutableLiveData = this.g.b;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = b.a;
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.g.v;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.g.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = d.v.c.m1.d.g.a;
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.g.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.g.C;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.g.w;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    public static /* synthetic */ void w(Boolean bl2) {
    }

    private /* synthetic */ void x(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void z(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((d.v.g0.k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((d.v.g0.k$a)object).D((FragmentManager)object2);
    }

    public /* synthetic */ void A(String string2) {
        this.z(string2);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.g = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.setCancelable(false);
        bundle = this.getDialog().getWindow();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        bundle.setBackgroundDrawable((Drawable)colorDrawable);
        this.v();
    }

    public int s() {
        return 2131558744;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (cg)viewDataBinding;
        this.f = viewDataBinding;
        k$a k$a = new k$a(this);
        ((cg)viewDataBinding).z(k$a);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

