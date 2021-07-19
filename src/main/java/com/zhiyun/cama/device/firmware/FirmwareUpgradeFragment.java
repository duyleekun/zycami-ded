/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.method.MovementMethod
 *  android.text.method.ScrollingMovementMethod
 *  android.util.SparseArray
 *  android.view.View
 *  android.widget.ProgressBar
 */
package com.zhiyun.cama.device.firmware;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.SparseArray;
import android.view.View;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment$a;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment$b;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$FirmwareFailType;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.v0.u.z;
import d.v.c.w0.b9;
import d.v.c.y0.c.a;
import d.v.c.y0.c.b;
import d.v.c.y0.c.c;
import d.v.c.y0.c.e;
import d.v.c.y0.c.f;
import d.v.c.y0.c.g;
import d.v.c.y0.c.h;
import d.v.c.y0.c.i;
import d.v.c.y0.c.j;
import d.v.c.y0.c.k;
import d.v.c.y0.c.l;
import d.v.c.y0.c.m;
import d.v.c.y0.c.n;
import d.v.c.y0.c.o;
import d.v.c.y0.c.p;
import d.v.e.l.b2;
import d.v.e.l.h2;
import d.v.g.g.c1;
import d.v.g.g.e1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import java.net.UnknownHostException;
import java.util.List;

public class FirmwareUpgradeFragment
extends d.v.f.h.a {
    private b9 b;
    private FirmwareUpgradeViewModel c;
    private o d;
    private c1 e;
    private DeviceInfo f;
    private FirmwareUpgradeFragment$b g;
    private d.v.g0.k h;

    private /* synthetic */ void B(FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType) {
        if (firmwareUpgradeViewModel$FirmwareFailType != null) {
            o o10 = this.d;
            Context context = this.requireContext();
            o10.b(context, firmwareUpgradeViewModel$FirmwareFailType);
        }
    }

    private /* synthetic */ void D(DeviceInfo object) {
        if (object != null) {
            o o10 = this.d;
            object = ((DeviceInfo)object).getDeviceName();
            o10.v((String)object);
        }
    }

    private /* synthetic */ void F(FirmwareInfo firmwareInfo) {
        if (firmwareInfo != null) {
            o o10 = this.d;
            List list = this.c.r();
            o10.c(firmwareInfo, list);
        }
    }

    private /* synthetic */ void H(Throwable object) {
        boolean bl2 = object instanceof UnknownHostException;
        if (bl2) {
            object = this.d.g();
            int n10 = 2131952207;
            String string2 = d.v.f.i.g.s(this, n10);
            ((MutableLiveData)object).setValue(string2);
        }
    }

    private /* synthetic */ void J(Integer object) {
        if (object != null) {
            ProgressBar progressBar = this.b.b;
            int n10 = (Integer)object;
            progressBar.setProgress(n10);
            progressBar = this.b.i;
            n10 = 2131952211;
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            String string2 = this.d.s();
            objectArray[0] = string2;
            int n12 = 1;
            objectArray[n12] = object;
            object = d.v.f.i.g.t(this, n10, objectArray);
            progressBar.setText((CharSequence)object);
        }
    }

    private /* synthetic */ void L(Pair pair) {
        Object object = this.e;
        boolean bl2 = ((c1)object).m(pair);
        if (bl2) {
            this.f = object = (DeviceInfo)pair.first;
            Object object2 = this.b;
            object = ((DeviceInfo)object).getDeviceName();
            ((b9)object2).C((String)object);
            object = this.c;
            object2 = this.f;
            pair = (SparseArray)pair.second;
            ((FirmwareUpgradeViewModel)object).A((DeviceInfo)object2, (SparseArray)pair);
        }
    }

    public static /* synthetic */ void N(Boolean bl2) {
    }

    private /* synthetic */ void O(boolean bl2, DialogFragment dialogFragment) {
        if (bl2) {
            this.t();
        } else {
            NavController navController = NavHostFragment.findNavController(this);
            navController.popBackStack();
        }
    }

    private /* synthetic */ void Q(DialogFragment dialogFragment) {
        this.h.dismissAllowingStateLoss();
    }

    private void S(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).n((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private void T(String object, boolean bl2) {
        Object object2 = new d.v.c.z0.k$b();
        object = ((d.v.c.z0.k$b)object2).y((String)object);
        int n10 = h2.b(240.0f);
        object = ((d.v.c.z0.k$b)object).C(n10).A(true);
        object2 = d.v.f.i.g.m(this.requireContext(), 2131952621);
        k k10 = new k(this, bl2);
        object = ((d.v.c.z0.k$b)object).G((String)object2, k10).v();
        FragmentManager fragmentManager = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q(fragmentManager);
    }

    private void U() {
        Object object = d.v.f.i.g.m(this.getContext(), 2131952853);
        Object object2 = this.getContext();
        Object object3 = new Object[]{object};
        object = d.v.f.i.g.n((Context)object2, 2131951978, (Object[])object3);
        object3 = this.getContext();
        object2 = new k$b((Context)object3);
        object = (k$b)((k$a)object2).n((String)object);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951851);
        object3 = new j(this);
        this.h = object = ((k$b)((k$a)object).x((String)object2, (d.v.f.f.a)object3)).b();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    public static /* synthetic */ b9 j(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        return firmwareUpgradeFragment.b;
    }

    public static /* synthetic */ FirmwareUpgradeFragment$b k(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        return firmwareUpgradeFragment.g;
    }

    public static /* synthetic */ FirmwareUpgradeViewModel l(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        return firmwareUpgradeFragment.c;
    }

    public static /* synthetic */ c1 m(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        return firmwareUpgradeFragment.e;
    }

    public static /* synthetic */ void n(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        firmwareUpgradeFragment.s();
    }

    public static /* synthetic */ void o(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        firmwareUpgradeFragment.U();
    }

    public static /* synthetic */ o p(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        return firmwareUpgradeFragment.d;
    }

    public static /* synthetic */ void q(FirmwareUpgradeFragment firmwareUpgradeFragment, String string2, boolean bl2) {
        firmwareUpgradeFragment.T(string2, bl2);
    }

    public static /* synthetic */ void r(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        firmwareUpgradeFragment.t();
    }

    private void s() {
        Object object = this.e.b.getValue();
        if (object == null) {
            return;
        }
        boolean bl2 = e1.b();
        if (!bl2 && (bl2 = b2.g())) {
            Object object2 = this.getContext();
            object = new k$b((Context)object2);
            object = (k$b)((k$a)object).m(2131953292);
            d.v.f.f.a a10 = a.a;
            object = (k$b)((k$a)object).o(2131951833, a10);
            int n10 = 2131952621;
            a10 = new m(this);
            object = (k$b)((k$a)object).v(n10, a10);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        } else {
            object = this.c;
            ((FirmwareUpgradeViewModel)object).y();
        }
    }

    private void t() {
        Object object = this.e.b.getValue();
        if (object != null) {
            object = this.e;
            boolean bl2 = ((c1)object).u();
            if (bl2) {
                object = this.d.g();
                int n10 = 2131952210;
                String string2 = d.v.f.i.g.s(this, n10);
                ((MutableLiveData)object).setValue(string2);
                object = this.c;
                ((FirmwareUpgradeViewModel)object).z();
            } else {
                this.U();
            }
        }
    }

    private void u() {
        MutableLiveData mutableLiveData = this.c.p();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new g(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.n();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.k();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.o();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new l(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.m();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.t();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new h(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.d.l();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.b;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.a;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = n.a;
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void v() {
        FirmwareUpgradeFragment$a firmwareUpgradeFragment$a = new FirmwareUpgradeFragment$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, firmwareUpgradeFragment$a);
    }

    public static /* synthetic */ void w(FirmwareUpgradeFragment firmwareUpgradeFragment, String string2) {
        firmwareUpgradeFragment.S(string2);
    }

    private /* synthetic */ void x(DialogFragment dialogFragment) {
        e1.h(true);
        this.c.y();
    }

    private /* synthetic */ void z(Integer object) {
        if (object == null) {
            return;
        }
        Object object2 = this.d;
        Context context = this.requireContext();
        int n10 = (Integer)object;
        ((o)object2).d(context, n10);
        int n11 = (Integer)object;
        int n12 = 10;
        if (n11 == n12) {
            this.e.R();
            object = this.e;
            object2 = this.f;
            ((c1)object).n((DeviceInfo)object2);
        }
    }

    public /* synthetic */ void A(Integer n10) {
        this.z(n10);
    }

    public /* synthetic */ void C(FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType) {
        this.B(firmwareUpgradeViewModel$FirmwareFailType);
    }

    public /* synthetic */ void E(DeviceInfo deviceInfo) {
        this.D(deviceInfo);
    }

    public /* synthetic */ void G(FirmwareInfo firmwareInfo) {
        this.F(firmwareInfo);
    }

    public /* synthetic */ void I(Throwable throwable) {
        this.H(throwable);
    }

    public /* synthetic */ void K(Integer n10) {
        this.J(n10);
    }

    public /* synthetic */ void M(Pair pair) {
        this.L(pair);
    }

    public /* synthetic */ void P(boolean bl2, DialogFragment dialogFragment) {
        this.O(bl2, dialogFragment);
    }

    public /* synthetic */ void R(DialogFragment dialogFragment) {
        this.Q(dialogFragment);
    }

    public int h() {
        return 2131558601;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (b9)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new FirmwareUpgradeFragment$b(this);
        this.g = object;
        ((b9)viewDataBinding).B((FirmwareUpgradeFragment$b)object);
        viewDataBinding = this.b;
        object = this.d;
        ((b9)viewDataBinding).D((o)object);
    }

    public void onAttach(Context object) {
        o o10;
        super.onAttach((Context)object);
        Object object2 = d.v.i0.b.a(this);
        this.d = o10 = (o)((ViewModelProvider)object2).get(o.class);
        this.c = object2 = (FirmwareUpgradeViewModel)((ViewModelProvider)object2).get(FirmwareUpgradeViewModel.class);
        this.e = object2 = (c1)d.v.i0.b.c(this.requireActivity()).get(c1.class);
        object2 = this.d.g();
        object = d.v.f.i.g.m(object, 2131952207);
        ((MutableLiveData)object2).setValue(object);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        this.b.getRoot().setKeepScreenOn(true);
    }

    public void onStop() {
        this.b.getRoot().setKeepScreenOn(false);
        super.onStop();
    }

    public void onViewCreated(View object, Bundle object2) {
        boolean bl2;
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.getArguments();
        boolean bl3 = true;
        if (object != null) {
            object = p.b(this.getArguments());
            bl2 = ((p)object).c();
        } else {
            bl2 = bl3;
        }
        this.d.x(bl2);
        this.u();
        object = this.b.e;
        Object object3 = new ScrollingMovementMethod();
        object.setMovementMethod((MovementMethod)object3);
        object = this.e.b.getValue();
        if (object == null) {
            this.e.S(bl3);
            object = z.m();
            bl2 = ((z)object).B();
            object2 = this.e;
            object3 = BleConnection.W().T();
            ((c1)object2).N((Stabilizer)object3, false, bl2);
        }
        this.v();
    }

    public /* synthetic */ void y(DialogFragment dialogFragment) {
        this.x(dialogFragment);
    }
}

