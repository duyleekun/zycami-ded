/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.zhiyun.cama.device.active;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.device.active.ActivationPrepareFragment$a;
import com.zhiyun.cama.device.active.ActivationPrepareFragment$b;
import com.zhiyun.cama.device.active.ActivationPrepareFragment$c;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;
import d.v.c.w0.n5;
import d.v.c.y0.a.b;
import d.v.c.y0.a.c;
import d.v.c.y0.a.d;
import d.v.c.y0.a.e;
import d.v.c.y0.a.f;
import d.v.c.y0.a.g;
import d.v.c.y0.a.h;
import d.v.c.y0.a.i;
import d.v.c.y0.a.p;
import d.v.c.z0.k$b;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.g0.s;
import m.a.a;

public class ActivationPrepareFragment
extends d.v.f.h.a {
    private n5 b;
    private ActivationViewModel c;
    private p d;
    private boolean e;

    private /* synthetic */ void B(DialogFragment dialogFragment) {
        this.b.a.setChecked(false);
    }

    private /* synthetic */ void D(boolean bl2, DialogFragment object) {
        if (bl2) {
            ActivationPrepareFragment$a activationPrepareFragment$a;
            Object object2 = d.v.e.f.a().c();
            boolean bl3 = b2.m((Context)object2);
            if (bl3) {
                s.o(this.requireActivity());
                object2 = this.d;
                activationPrepareFragment$a = new ActivationPrepareFragment$a(this);
                ((p)object2).b(activationPrepareFragment$a);
            } else {
                object2 = this.b.a;
                activationPrepareFragment$a = null;
                object2.setChecked(false);
                int n10 = 2131953261;
                object2 = d.v.f.i.g.s(this, n10);
                n2.e((String)object2);
            }
        }
    }

    private /* synthetic */ void F(DialogFragment dialogFragment) {
        this.e = true;
        AccountActivity.h(this.getActivity());
    }

    private void H() {
        Object object = new k$b();
        Object object2 = d.v.f.i.g.s(this, 2131951912);
        object = ((k$b)object).J((String)object2);
        object2 = d.v.f.i.g.s(this, 2131951913);
        object = ((k$b)object).y((String)object2);
        object2 = d.v.f.i.g.s(this, 2131952621);
        b b10 = new b(this);
        object = ((k$b)object).G((String)object2, b10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void I(boolean bl2) {
        Object object = new k$b();
        Object object2 = d.v.f.i.g.s(this, 2131951929);
        object = ((k$b)object).J((String)object2);
        int n10 = 2131951930;
        object2 = d.v.f.i.g.s(this, n10);
        object = ((k$b)object).y((String)object2);
        if (bl2) {
            n10 = 2131951967;
            object2 = d.v.f.i.g.s(this, n10);
        } else {
            n10 = 2131951833;
            object2 = d.v.f.i.g.s(this, n10);
        }
        c c10 = new c(this, bl2);
        Object object3 = ((k$b)object).D((String)object2, c10);
        object = d.v.f.i.g.s(this, 2131952534);
        object2 = new f(this);
        object3 = ((k$b)object3).G((String)object, (d.v.f.f.a)object2).v();
        object = this.getChildFragmentManager();
        ((d.v.f.g.b)object3).q((FragmentManager)object);
    }

    public static /* synthetic */ ActivationViewModel j(ActivationPrepareFragment activationPrepareFragment) {
        return activationPrepareFragment.c;
    }

    public static /* synthetic */ void k(ActivationPrepareFragment activationPrepareFragment) {
        activationPrepareFragment.H();
    }

    public static /* synthetic */ String l(ActivationPrepareFragment activationPrepareFragment, UserInfo userInfo) {
        return activationPrepareFragment.o(userInfo);
    }

    public static /* synthetic */ n5 m(ActivationPrepareFragment activationPrepareFragment) {
        return activationPrepareFragment.b;
    }

    private void n() {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((d.v.a.f.c.b)object).s();
        if (bl2) {
            s.j();
            object = d.v.a.f.c.b.N().i();
            MutableLiveData mutableLiveData = this.c.R();
            int n10 = ((UserInfo)object).getId();
            Integer n11 = n10;
            mutableLiveData.setValue(n11);
            mutableLiveData = this.c.Q();
            object = this.o((UserInfo)object);
            mutableLiveData.setValue(object);
            object = NavHostFragment.findNavController(this);
            int n12 = 2131361868;
            ((NavController)object).navigate(n12);
        } else {
            object = this.c;
            ((ActivationViewModel)object).M();
        }
    }

    private String o(UserInfo object) {
        boolean bl2;
        String string2 = ((UserInfo)object).getMobile();
        object = string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((UserInfo)object).getMobile()))) ? ((UserInfo)object).getMobile() : ((string2 = ((UserInfo)object).getMail()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((UserInfo)object).getMail()))) ? ((UserInfo)object).getMail() : ((UserInfo)object).getNickname());
        return object;
    }

    private void p() {
        p p10 = this.d;
        Context context = this.requireContext();
        p10.c(context);
    }

    private void q() {
        Object object = this.b.a;
        Object object2 = new i(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.c.J();
        object2 = this.getViewLifecycleOwner();
        Observer observer = new g(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.y();
        object2 = this.getViewLifecycleOwner();
        observer = new h(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.A();
        object2 = this.getViewLifecycleOwner();
        observer = new d(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.d.f();
        object2 = this.getViewLifecycleOwner();
        observer = new e(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private /* synthetic */ void r(CompoundButton compoundButton, boolean bl2) {
        this.d.g(bl2);
    }

    private /* synthetic */ void t(ActivationViewModel$ProcessStatus objectArray) {
        block5: {
            Object object;
            block4: {
                if (objectArray == null) {
                    return;
                }
                object = ActivationPrepareFragment$b.a;
                int n10 = objectArray.ordinal();
                int n11 = 1;
                if ((n10 = object[n10]) == n11) break block4;
                n11 = 2;
                if (n10 != n11) break block5;
                objectArray = new Object[]{};
                object = "-----get location fail---";
                a.b((String)object, objectArray);
            }
            objectArray = new Object[]{};
            a.b("-----get location success---", objectArray);
            objectArray = this.c.J();
            object = (Object)ActivationViewModel$ProcessStatus.PROCESS_STATUS_NONE;
            objectArray.setValue(object);
            this.n();
        }
    }

    private /* synthetic */ void v(ActivationViewModel$ProcessStatus object) {
        if (object == null) {
            return;
        }
        Object object2 = ActivationPrepareFragment$b.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                s.j();
                this.H();
                object = this.c.y();
                object2 = (Object)ActivationViewModel$ProcessStatus.PROCESS_STATUS_NONE;
                d.v.e.i.h.g((MutableLiveData)object, object2);
            }
        } else {
            this.c.h0();
            object = this.c.y();
            object2 = (Object)ActivationViewModel$ProcessStatus.PROCESS_STATUS_NONE;
            d.v.e.i.h.g((MutableLiveData)object, object2);
        }
    }

    private /* synthetic */ void x(ActivationViewModel$ProcessStatus object) {
        int n10;
        if (object == null) {
            return;
        }
        Object object2 = ActivationPrepareFragment$b.a;
        int n11 = ((Enum)object).ordinal();
        n11 = object2[n11];
        if (n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 == n12) {
                this.H();
                s.j();
                object = this.c.A();
                object2 = (Object)ActivationViewModel$ProcessStatus.PROCESS_STATUS_NONE;
                d.v.e.i.h.g((MutableLiveData)object, object2);
            }
        } else {
            s.j();
            boolean bl3 = this.c.P();
            this.I(bl3);
            object = this.c.A();
            object2 = (Object)ActivationViewModel$ProcessStatus.PROCESS_STATUS_NONE;
            d.v.e.i.h.g((MutableLiveData)object, object2);
        }
    }

    private /* synthetic */ void z(UserInfo object) {
        Object object2;
        int n10;
        if (object != null && (n10 = this.e) != 0 && (n10 = ((d.v.a.f.c.b)(object2 = d.v.a.f.c.b.N())).s()) != 0) {
            this.e = false;
            object2 = this.c.R();
            int n11 = ((UserInfo)object).getId();
            Integer n12 = n11;
            ((MutableLiveData)object2).setValue(n12);
            object2 = this.c.Q();
            object = this.o((UserInfo)object);
            ((MutableLiveData)object2).setValue(object);
            object = NavHostFragment.findNavController(this);
            n10 = 2131361868;
            ((NavController)object).navigate(n10);
        }
    }

    public /* synthetic */ void A(UserInfo userInfo) {
        this.z(userInfo);
    }

    public /* synthetic */ void C(DialogFragment dialogFragment) {
        this.B(dialogFragment);
    }

    public /* synthetic */ void E(boolean bl2, DialogFragment dialogFragment) {
        this.D(bl2, dialogFragment);
    }

    public /* synthetic */ void G(DialogFragment dialogFragment) {
        this.F(dialogFragment);
    }

    public int h() {
        return 2131558555;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (n5)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new ActivationPrepareFragment$c(this);
        ((n5)viewDataBinding).A((ActivationPrepareFragment$c)object);
        viewDataBinding = this.b;
        object = this.d;
        ((n5)viewDataBinding).B((p)object);
    }

    public void onAttach(Context object) {
        ActivationViewModel activationViewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = activationViewModel = (ActivationViewModel)((ViewModelProvider)object).get(ActivationViewModel.class);
        this.d = object = (p)((ViewModelProvider)object).get(p.class);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p();
        this.q();
    }

    public /* synthetic */ void s(CompoundButton compoundButton, boolean bl2) {
        this.r(compoundButton, bl2);
    }

    public /* synthetic */ void u(ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus) {
        this.t(activationViewModel$ProcessStatus);
    }

    public /* synthetic */ void w(ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus) {
        this.v(activationViewModel$ProcessStatus);
    }

    public /* synthetic */ void y(ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus) {
        this.x(activationViewModel$ProcessStatus);
    }
}

