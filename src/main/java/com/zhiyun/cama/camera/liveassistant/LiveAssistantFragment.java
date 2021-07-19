/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.PowerManager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.camera.liveassistant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.liveassistant.FloatWindowPermissionHelper;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$a;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$b;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$c;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantState;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.c.s0.e7.a;
import d.v.c.s0.e7.i;
import d.v.c.s0.e7.k;
import d.v.c.s0.e7.l;
import d.v.c.s0.e7.m;
import d.v.c.s0.e7.n;
import d.v.c.s0.e7.q$b;
import d.v.c.s0.e7.s;
import d.v.c.s0.e7.t;
import d.v.c.v0.u.z;
import d.v.c.w0.ee;
import d.v.e.l.n2;
import d.v.f.h.c;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class LiveAssistantFragment
extends c {
    private static final int e = 1083;
    private static final int f = 1084;
    private ee a;
    private DeviceViewModel b;
    private BleViewModel c;
    private s d;

    private void B() {
        this.G();
        Object object = this.d;
        Object object2 = this.o();
        ((s)object).d((q$b)object2);
        object = this.a.i;
        object2 = new i(this);
        long l10 = 1500L;
        object.postDelayed((Runnable)object2, l10);
        object = z.m();
        boolean n10 = ((z)object).n();
        if (n10) {
            object = this.d;
            boolean bl2 = ((s)object).d;
            if (!bl2) {
                ((s)object).d = bl2 = true;
                int n11 = 2131361810;
                d.v.c.x1.l.d(this, n11);
            }
        }
    }

    private void C() {
        s s10 = this.d;
        boolean bl2 = s10.p();
        if (bl2) {
            this.B();
            return;
        }
        s10 = this.d;
        LiveAssistantState liveAssistantState = LiveAssistantState.OPENING;
        s10.s(liveAssistantState);
        s10 = d.v.c.s0.e7.u.m.d(this.requireContext()).createScreenCaptureIntent();
        this.startActivityForResult((Intent)s10, 1083);
    }

    private void D() {
        boolean bl2 = this.m();
        if (!bl2) {
            return;
        }
        s s10 = this.d;
        bl2 = s10.c;
        if (!bl2 && !(bl2 = FloatWindowPermissionHelper.d((Context)(s10 = this.requireContext())))) {
            this.d.c = true;
            this.F();
            return;
        }
        bl2 = this.q();
        if (bl2) {
            this.C();
        } else {
            this.E();
        }
    }

    private void E() {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package:");
        String string2 = this.requireContext().getPackageName();
        stringBuilder.append(string2);
        stringBuilder = Uri.parse((String)stringBuilder.toString());
        intent.setData((Uri)stringBuilder);
        this.startActivityForResult(intent, 1084);
    }

    private void F() {
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)((k$b)k$b.A(2131952447)).m(2131952449);
        object = d.v.c.s0.e7.a.a;
        k$b = (k$b)k$b.o(2131951833, (d.v.f.f.a)object);
        object = new l(this);
        k$b = (k$b)k$b.v(2131952450, (d.v.f.f.a)object);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    private void G() {
        Object object = this.requireContext();
        Intent intent = new Intent(object, LiveAssistantService.class);
        object = LiveAssistantService.m;
        intent.putExtra((String)object, 16521);
        object = LiveAssistantService.l;
        Context context = this.requireContext();
        boolean bl2 = true;
        context = t.a(context, bl2);
        intent.putExtra((String)object, (Parcelable)context);
        object = LiveAssistantService.n;
        int n10 = this.d.m();
        intent.putExtra((String)object, n10);
        object = LiveAssistantService.o;
        context = this.d.n();
        intent.putExtra((String)object, (Parcelable)context);
        int n11 = Build.VERSION.SDK_INT;
        n10 = 26;
        if (n11 >= n10) {
            object = this.requireContext();
            object.startForegroundService(intent);
        } else {
            object = this.requireContext();
            object.startService(intent);
        }
    }

    private void H() {
        Context context = this.requireContext();
        Intent intent = new Intent(context, LiveAssistantService.class);
        this.requireContext().stopService(intent);
    }

    public static /* synthetic */ void h(LiveAssistantFragment liveAssistantFragment) {
        liveAssistantFragment.l();
    }

    public static /* synthetic */ s i(LiveAssistantFragment liveAssistantFragment) {
        return liveAssistantFragment.d;
    }

    public static /* synthetic */ void j(LiveAssistantFragment liveAssistantFragment) {
        liveAssistantFragment.D();
    }

    public static /* synthetic */ void k(LiveAssistantFragment liveAssistantFragment) {
        liveAssistantFragment.n();
    }

    private void l() {
        Object object = LiveAssistantFragment$b.a;
        Object object2 = this.d.l();
        int n10 = object2.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2) && n11 != (n10 = 3)) {
            object = this.requireActivity();
            object.finish();
        } else {
            object = new k$b;
            object2 = this.getContext();
            ((k$b)object)((Context)object2);
            object = (k$b)((k$a)object).m(2131952436);
            d.v.f.f.a a10 = d.v.c.s0.e7.a.a;
            object = (k$b)((k$a)object).o(2131951833, a10);
            n10 = 2131951887;
            a10 = new n(this);
            object = (k$b)((k$a)object).v(n10, a10);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        }
    }

    private boolean m() {
        Boolean bl2 = (Boolean)this.c.L.getValue();
        boolean bl3 = d.v.e.h.a.c(bl2);
        if (bl3) {
            return true;
        }
        n2.e(g.s(this, 2131951950));
        return false;
    }

    private void n() {
        this.H();
        this.d.c();
    }

    private q$b o() {
        k k10 = new k(this);
        return k10;
    }

    private void p() {
        LiveData liveData = this.c.L;
        m m10 = new m(this);
        liveData.observeForever(m10);
    }

    private boolean q() {
        Context context = this.requireContext();
        String string2 = context.getPackageName();
        return ((PowerManager)context.getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(string2);
    }

    private /* synthetic */ void r(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.n();
        this.requireActivity().finish();
    }

    private /* synthetic */ void t(boolean bl2) {
        if (bl2) {
            bl2 = this.m();
            if (!bl2) {
                this.d.i();
                return;
            }
            this.G();
            s s10 = this.d;
            boolean bl3 = true;
            s10.e(bl3);
        } else {
            this.H();
            s s11 = this.d;
            boolean bl4 = false;
            s11.e(false);
        }
    }

    private /* synthetic */ void v(Boolean object) {
        Object object2 = (Boolean)object;
        if (object2 != 0) {
            return;
        }
        object = LiveAssistantFragment$b.a;
        LiveAssistantState liveAssistantState = this.d.l();
        int n10 = liveAssistantState.ordinal();
        object2 = object[n10];
        if (object2 == (n10 = 1) || object2 == (n10 = 2) || object2 == (n10 = 3)) {
            object2 = 2131952437;
            n2.e(g.s(this, object2));
            this.n();
            object = this.d;
            ((s)object).f();
        }
    }

    private /* synthetic */ void x() {
        s s10 = this.d;
        LiveAssistantState liveAssistantState = LiveAssistantState.OPEN;
        s10.s(liveAssistantState);
    }

    private /* synthetic */ void z(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        FloatWindowPermissionHelper.h(this.requireContext());
    }

    public /* synthetic */ void A(DialogFragment dialogFragment) {
        this.z(dialogFragment);
    }

    public void onActivityCreated(Bundle object) {
        super.onActivityCreated((Bundle)object);
        object = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        LiveAssistantFragment$a liveAssistantFragment$a = new LiveAssistantFragment$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback(lifecycleOwner, liveAssistantFragment$a);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        int n12 = 1083;
        if (n10 != n12) {
            n11 = 1084;
            if (n10 == n11) {
                this.C();
            }
        } else {
            n10 = -1;
            if (n11 == n10 && intent != null) {
                s s10 = this.d;
                s10.r(n11, intent);
                this.B();
            } else {
                s s11 = this.d;
                LiveAssistantState liveAssistantState = LiveAssistantState.CLOSE;
                s11.s(liveAssistantState);
            }
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        FragmentActivity fragmentActivity = this.requireActivity();
        object = new ViewModelProvider(fragmentActivity);
        this.b = object = (DeviceViewModel)((ViewModelProvider)object).get(DeviceViewModel.class);
        fragmentActivity = this.requireActivity();
        object = new ViewModelProvider(fragmentActivity);
        this.c = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        fragmentActivity = this.requireActivity();
        object = new ViewModelProvider(fragmentActivity);
        this.d = object = (s)((ViewModelProvider)object).get(s.class);
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        object = (ee)DataBindingUtil.inflate((LayoutInflater)object, 2131558680, object2, false);
        this.a = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.a;
        object2 = new LiveAssistantFragment$c(this);
        ((ee)object).D((LiveAssistantFragment$c)object2);
        object = this.a;
        object2 = this.c;
        ((ee)object).C((BleViewModel)object2);
        object = this.a;
        object2 = this.b;
        ((ee)object).E((DeviceViewModel)object2);
        object = this.a;
        object2 = this.d;
        ((ee)object).F((s)object2);
        return this.a.getRoot();
    }

    public void onResume() {
        super.onResume();
        this.c.u1();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p();
    }

    public /* synthetic */ void s(DialogFragment dialogFragment) {
        this.r(dialogFragment);
    }

    public /* synthetic */ void u(boolean bl2) {
        this.t(bl2);
    }

    public /* synthetic */ void w(Boolean bl2) {
        this.v(bl2);
    }

    public /* synthetic */ void y() {
        this.x();
    }
}

