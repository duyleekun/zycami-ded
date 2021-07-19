/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.TextView
 */
package com.zhiyun.cama.set;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.set.SetAboutFragment$a;
import com.zhiyun.cama.update.DownloadAPKService;
import d.v.c.q1.c;
import d.v.c.q1.d;
import d.v.c.q1.e;
import d.v.c.q1.g0;
import d.v.c.w0.kg;
import d.v.e.i.j;
import d.v.e.l.d1;
import d.v.e.l.n2;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;

public class SetAboutFragment
extends d.v.f.h.a {
    private kg b;
    private g0 c;

    public static /* synthetic */ g0 j(SetAboutFragment setAboutFragment) {
        return setAboutFragment.c;
    }

    private void k() {
        g0 g02;
        this.c = g02 = (g0)d.v.i0.b.c(this.requireActivity()).get(g0.class);
        this.b.B(g02);
    }

    private void l() {
        MutableLiveData mutableLiveData = this.c.q;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new d(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.x();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d.v.c.q1.b(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void m() {
        TextView textView = this.b.b;
        String string2 = d1.a();
        textView.setText((CharSequence)string2);
        textView = this.b.c;
        string2 = this.getResources();
        Object[] objectArray = new Object[2];
        objectArray[0] = "1.2.6";
        Integer n10 = 199;
        objectArray[1] = n10;
        string2 = g.p((Resources)string2, 2131951755, objectArray);
        textView.setText((CharSequence)string2);
    }

    private /* synthetic */ void n(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            n2.e((String)object);
            object = this.c;
            bl2 = false;
            ((g0)object).S(null);
        }
    }

    public static /* synthetic */ void p(SetAboutFragment setAboutFragment, VersionInfo versionInfo) {
        setAboutFragment.t(versionInfo);
    }

    private /* synthetic */ void q(VersionInfo object, DialogFragment activityResultCaller) {
        activityResultCaller = this.getActivity();
        object = ((VersionInfo)object).getFileURL();
        DownloadAPKService.w((Activity)activityResultCaller, (String)object);
    }

    public static /* synthetic */ void s(DialogFragment dialogFragment) {
    }

    private void t(VersionInfo object) {
        Object object2 = this.getContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$a)object3).A(2131953197);
        object2 = new e(this, (VersionInfo)object);
        object = (k$b)((k$a)object3).v(2131953192, (a)object2);
        object3 = d.v.c.q1.c.a;
        object = (k$b)((k$a)object).p((a)object3);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    public int h() {
        return 2131558753;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (kg)viewDataBinding;
        this.b = viewDataBinding;
        SetAboutFragment$a setAboutFragment$a = new SetAboutFragment$a(this);
        ((kg)viewDataBinding).A(setAboutFragment$a);
    }

    public /* synthetic */ void o(String string2) {
        this.n(string2);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.m();
        this.l();
    }

    public /* synthetic */ void r(VersionInfo versionInfo, DialogFragment dialogFragment) {
        this.q(versionInfo, dialogFragment);
    }
}

