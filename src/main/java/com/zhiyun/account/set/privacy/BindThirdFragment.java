/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.data.NetworkState;
import com.zhiyun.account.set.privacy.BindThirdFragment$a;
import com.zhiyun.account.set.privacy.BindThirdFragment$b;
import com.zhiyun.account.widget.StatusView;
import d.v.a.g.e0;
import d.v.a.j.c.f;
import d.v.a.j.c.i;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.e.l.n2;
import d.v.f.h.a;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class BindThirdFragment
extends a {
    private e0 b;
    private y c;

    public static /* synthetic */ y j(BindThirdFragment bindThirdFragment) {
        return bindThirdFragment.c;
    }

    private void k() {
        Object object = this.b;
        Object object2 = this.c;
        ((e0)object).B((y)object2);
        this.c.m(true);
        object = this.c.j;
        object2 = this.getViewLifecycleOwner();
        i i10 = new i(this);
        ((j)object).observe((LifecycleOwner)object2, i10);
    }

    private void l() {
        StatusView statusView = this.b.c;
        f f10 = new f(this);
        statusView.setOnClickErrorListener(f10);
    }

    private /* synthetic */ void m(NetworkState object) {
        if (object == null) {
            return;
        }
        Object object2 = BindThirdFragment$a.a;
        Object object3 = ((NetworkState)object).a;
        int n10 = ((Enum)object3).ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    object2 = (Object)this.b.c;
                    ((StatusView)((Object)object2)).a();
                    s.j();
                    n11 = 208;
                    n10 = ((NetworkState)object).b;
                    if (n11 == n10) {
                        object3 = this.getContext();
                        object2 = new k$b((Context)object3);
                        object = ((NetworkState)object).c;
                        object = (k$b)((k$a)object2).B((String)object);
                        object2 = this.getChildFragmentManager();
                        ((k$a)object).D((FragmentManager)object2);
                    } else {
                        object3 = "show_error_page";
                        object2 = ((NetworkState)object).c;
                        n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
                        if (n11 != 0) {
                            object = this.b.c;
                            ((StatusView)((Object)object)).d();
                        } else {
                            object2 = ((NetworkState)object).c;
                            n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                            if (n11 == 0) {
                                object = ((NetworkState)object).c;
                                n2.e((String)object);
                            }
                        }
                    }
                }
            } else {
                this.b.c.a();
                s.j();
                object2 = ((NetworkState)object).c;
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n11 == 0) {
                    object = ((NetworkState)object).c;
                    n2.e((String)object);
                }
            }
        } else {
            this.b.c.a();
            object = this.getActivity();
            s.t((FragmentActivity)object);
        }
    }

    private /* synthetic */ void o(View view) {
        this.c.m(true);
    }

    public int h() {
        return R$layout.set_private_bind_third_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (e0)viewDataBinding;
        this.b = viewDataBinding;
        BindThirdFragment$b bindThirdFragment$b = new BindThirdFragment$b(this);
        ((e0)viewDataBinding).A(bindThirdFragment$b);
    }

    public /* synthetic */ void n(NetworkState networkState) {
        this.m(networkState);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (y)d.v.i0.b.c(this.requireActivity()).get(y.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.l();
    }

    public /* synthetic */ void p(View view) {
        this.o(view);
    }
}

