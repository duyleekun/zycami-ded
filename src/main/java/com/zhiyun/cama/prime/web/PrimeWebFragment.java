/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 */
package com.zhiyun.cama.prime.web;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.App;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.cama.prime.web.PrimeWebFragment$a;
import com.zhiyun.cama.prime.web.PrimeWebFragment$b;
import com.zhiyun.cama.prime.web.PrimeWebFragment$c;
import com.zhiyun.cama.prime.web.PrimeWebFragment$d;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.component.widget.JSWebView;
import com.zhiyun.component.widget.JSWebView$a;
import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.i1.r2;
import d.v.c.i1.t2.f0;
import d.v.c.l0$a;
import d.v.c.l0$b;
import d.v.c.l1.d0;
import d.v.c.l1.e0.b$a;
import d.v.c.l1.e0.c$a;
import d.v.c.l1.e0.d;
import d.v.c.m1.e.a;
import d.v.c.m1.e.b;
import d.v.c.m1.e.c;
import d.v.c.m1.e.j;
import d.v.c.m1.e.k;
import d.v.c.m1.e.l;
import d.v.c.m1.e.m;
import d.v.c.m1.e.n;
import d.v.c.m1.e.o;
import d.v.c.m1.e.p;
import d.v.c.m1.e.q;
import d.v.c.m1.e.r;
import d.v.c.m1.e.t;
import d.v.c.m1.e.u;
import d.v.c.m1.e.v;
import d.v.c.m1.e.w;
import d.v.c.m1.e.x;
import d.v.c.m1.e.y;
import d.v.e.l.d1;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.e0.ce;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.w.c0.e;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeWebFragment
extends f0 {
    private y i;
    private d.v.c.m1.c j;
    private r2 k;
    private d0 l;
    public d.v.c.l1.e0.c m;
    public d.v.c.l1.e0.c n;

    private void A0() {
        Object object = PrimeManager.getLocalPrimeInfo(d.v.a.f.c.b.N().i().getId());
        String string2 = g.m(this.requireContext(), 2131952659);
        Object object2 = this.requireContext();
        Object[] objectArray = new Object[1];
        d.v.c.m1.c c10 = this.j;
        object = ((PrimeInfo)object).getEndTime();
        objectArray[0] = object = c10.m((String)object);
        object = g.n(object2, 2131952656, objectArray);
        object2 = g.m(this.requireContext(), 2131951887);
        this.w0(string2, (String)object, (String)object2);
    }

    private void B0() {
        Object object = g.m(this.requireContext(), 2131952711);
        Object object2 = new c$a();
        object = ((c$a)object2).b((String)object).c();
        object2 = this.getChildFragmentManager();
        this.m = object = ((c$a)object).d((FragmentManager)object2);
    }

    private void C0() {
        Object object = this.n;
        if (object != null) {
            return;
        }
        object = new c$a();
        Object object2 = g.m(this.requireContext(), 2131952693);
        object = ((c$a)object).b((String)object2).c();
        object2 = this.getChildFragmentManager();
        this.n = object = ((c$a)object).d((FragmentManager)object2);
    }

    private void D0() {
        s.t(this.requireActivity());
    }

    private void E0() {
        this.v0(2131952683, 2131952682, 2131951887);
    }

    private void F0() {
        Object object;
        int n10 = d.v.a.f.c.b.N().i().getId();
        Object object2 = PrimeManager.getLocalPrimeInfo(n10);
        int n11 = 1;
        if (object2 == null || (n10 = ((PrimeInfo)object2).getStatus()) != n11) {
            n11 = 0;
            object = null;
        }
        n10 = n11 != 0 ? 2131952709 : 2131952680;
        n11 = n11 != 0 ? 2131952708 : 2131952679;
        PrimeManager.requestPrime(d.v.a.f.c.b.N().P());
        Object object3 = new b$a();
        object2 = g.m(this.requireContext(), n10);
        object2 = ((b$a)object3).f((String)object2);
        object = g.m(this.requireContext(), n11);
        object2 = ((b$a)object2).d((String)object);
        object = g.m(this.requireContext(), 2131952695);
        object3 = new l(this);
        object2 = ((b$a)object2).b((String)object, (d.v.f.f.a)object3);
        object = new r(this);
        object2 = ((b$a)object2).e((d.v.f.f.a)object);
        object = this.getChildFragmentManager();
        ((b$a)object2).g((FragmentManager)object);
    }

    private void G0() {
        this.v0(2131952658, 2131952657, 2131951887);
    }

    public static /* synthetic */ boolean H(PrimeWebFragment primeWebFragment) {
        return primeWebFragment.S();
    }

    private void H0(d.v.w.c0.d object) {
        Object object2 = g.m(this.getContext(), 2131952853);
        Object object3 = this.getContext();
        Object[] objectArray = new Object[]{object2};
        object2 = g.n((Context)object3, 2131952691, objectArray);
        objectArray = this.requireContext();
        object3 = new k$b((Context)objectArray);
        object2 = (k$b)((k$b)((k$a)object3).A(2131952692)).n((String)object2);
        object3 = a.a;
        object2 = (k$b)((k$a)object2).o(2131951833, (d.v.f.f.a)object3);
        object3 = new u(this, (d.v.w.c0.d)object);
        object = (k$b)((k$a)object2).v(2131952838, (d.v.f.f.a)object3);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public static /* synthetic */ d.v.c.m1.c I(PrimeWebFragment primeWebFragment) {
        return primeWebFragment.j;
    }

    private void I0() {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity != null && (fragmentActivity = this.getActivity().getWindow()) != null) {
            this.getActivity().getWindow().getDecorView().setSystemUiVisibility(1280);
            fragmentActivity = this.getActivity().getWindow();
            fragmentActivity.setStatusBarColor(0);
        }
    }

    public static /* synthetic */ d0 J(PrimeWebFragment primeWebFragment) {
        return primeWebFragment.l;
    }

    private void J0(int n10) {
        n2.e(g.m(this.requireContext(), n10));
    }

    public static /* synthetic */ void K(PrimeWebFragment primeWebFragment) {
        primeWebFragment.x0();
    }

    private void K0(String string2) {
        n2.e(string2);
    }

    public static /* synthetic */ void L(PrimeWebFragment primeWebFragment, String string2) {
        primeWebFragment.y0(string2);
    }

    public static /* synthetic */ void M(PrimeWebFragment primeWebFragment, List list) {
        primeWebFragment.t0(list);
    }

    public static /* synthetic */ y N(PrimeWebFragment primeWebFragment) {
        return primeWebFragment.i;
    }

    public static /* synthetic */ void O(PrimeWebFragment primeWebFragment, List list, List list2) {
        primeWebFragment.u0(list, list2);
    }

    private void P() {
        boolean bl2;
        d.v.c.l1.e0.c c10 = this.m;
        if (c10 != null && (bl2 = c10.isAdded())) {
            c10 = this.m;
            c10.dismissAllowingStateLoss();
        }
    }

    private void Q() {
        boolean bl2;
        d.v.c.l1.e0.c c10 = this.n;
        if (c10 != null && (bl2 = c10.isAdded())) {
            this.n.dismissAllowingStateLoss();
            bl2 = false;
            c10 = null;
            this.n = null;
        }
    }

    private void R() {
        s.j();
    }

    private boolean S() {
        FragmentActivity fragmentActivity = this.getActivity();
        boolean bl2 = fragmentActivity instanceof SplashActivity;
        if (!bl2) {
            return false;
        }
        return ((d.v.c.t1.s)d.v.i0.b.c(this.requireActivity()).get(d.v.c.t1.s.class)).j();
    }

    public static /* synthetic */ boolean T(x object, e object2) {
        object = ((x)object).c();
        object2 = object2.d();
        return ((String)object).equals(object2);
    }

    public static /* synthetic */ x U(x x10, e object) {
        object = object.b();
        if ((object = x10.i((String)object)) != null) {
            String string2 = (String)((Pair)object).first;
            x10.h(string2);
            object = (String)((Pair)object).second;
            x10.f((String)object);
        }
        return x10;
    }

    private /* synthetic */ void V(String string2) {
        this.c.loadUrl(string2);
    }

    private /* synthetic */ void X(d.v.w.c0.c c10) {
        if (c10 != null) {
            d0 d02 = this.l;
            FragmentActivity fragmentActivity = this.requireActivity();
            d02.K(fragmentActivity, c10);
        }
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void Z(PayFlowResult var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 6[SWITCH]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1037)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private /* synthetic */ void b0(Pair object) {
        Object object2 = 1;
        Object object3 = new Object[object2];
        int n10 = 0;
        object3[0] = object;
        m.a.a.b("---primepay \u652f\u4ed8\u7ed3\u679c %s", object3);
        object3 = ((Pair)object).first;
        PurchaseResult purchaseResult = PurchaseResult.PURCHASE_LOADING;
        if (object3 == purchaseResult) {
            this.C0();
        } else {
            this.Q();
            object3 = PrimeWebFragment$c.a;
            purchaseResult = (PurchaseResult)((Object)((Pair)object).first);
            n10 = purchaseResult.ordinal();
            object2 = object3[n10];
            switch (object2) {
                default: {
                    break;
                }
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    this.E0();
                    break;
                }
                case 3: 
                case 4: {
                    object = (d.v.w.c0.d)((Pair)object).second;
                    this.H0((d.v.w.c0.d)object);
                    break;
                }
                case 2: {
                    this.F0();
                    break;
                }
                case 1: {
                    int n11 = 2131952701;
                    this.J0(n11);
                }
            }
        }
    }

    private /* synthetic */ void d0(d d10) {
        FragmentManager fragmentManager = this.getChildFragmentManager();
        d10.q(fragmentManager);
    }

    public static /* synthetic */ Stream f0(List stream, x x10) {
        stream = stream.stream();
        Object object = new v(x10);
        stream = stream.filter(object);
        object = new m(x10);
        return stream.map(object);
    }

    private /* synthetic */ void g0(DialogFragment object) {
        ((DialogFragment)object).dismiss();
        object = this.c;
        String string2 = l0$a.l;
        Object[] objectArray = new Object[]{};
        ((JSWebView)((Object)object)).c(string2, objectArray);
    }

    private /* synthetic */ void i0(DialogFragment object) {
        ((DialogFragment)object).dismiss();
        object = this.c;
        String string2 = l0$a.j;
        Object[] objectArray = new Object[]{};
        ((JSWebView)((Object)object)).c(string2, objectArray);
    }

    private /* synthetic */ void k0(DialogFragment object) {
        ((DialogFragment)object).dismiss();
        object = this.c;
        String string2 = l0$a.j;
        Object[] objectArray = new Object[]{};
        ((JSWebView)((Object)object)).c(string2, objectArray);
    }

    private /* synthetic */ void m0(DialogFragment dialogFragment) {
        JSWebView jSWebView = this.c;
        String string2 = l0$a.j;
        Object[] objectArray = new Object[]{};
        jSWebView.c(string2, objectArray);
        dialogFragment.dismiss();
    }

    private /* synthetic */ void o0(DialogFragment dialogFragment) {
        JSWebView jSWebView = this.c;
        String string2 = l0$a.k;
        Object[] objectArray = new Object[]{};
        jSWebView.c(string2, objectArray);
        dialogFragment.dismiss();
    }

    private /* synthetic */ void q0(d.v.w.c0.d d10, DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.l.N(d10);
    }

    public static PrimeWebFragment s0() {
        PrimeWebFragment primeWebFragment = new PrimeWebFragment();
        Bundle bundle = new Bundle();
        primeWebFragment.setArguments(bundle);
        return primeWebFragment;
    }

    private void t0(List list) {
        Object object = list.stream();
        Object object2 = b.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        int n10 = 1;
        object2 = new Object[n10];
        object2[0] = object;
        String string2 = "setSkuIdList,\u83b7\u53d6\u5230\u5546\u54c1ID\u5217\u8868 list: %s";
        m.a.a.b(string2, (Object[])object2);
        object2 = this.l;
        object = ((d0)object2).a((List)object);
        if (object == null) {
            object = this.l.g;
            object2 = new PrimeWebFragment$a(this, list);
            ((LiveData)object).observe(this, (Observer)object2);
        } else {
            this.u0(list, (List)object);
        }
    }

    private void u0(List object, List object2) {
        int n10 = 1;
        Object object3 = new Object[n10];
        object3[0] = object2;
        m.a.a.b("setSkuInfoList,\u83b7\u53d6\u5230\u5546\u54c1\u4ef7\u683c\u4fe1\u606f skuList: %s", object3);
        object = object.stream();
        object3 = new t((List)object2);
        object = object.flatMap(object3);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        object2 = new PrimeWebFragment$b(this);
        object = d.v.e.l.q2.c.i(((TypeToken)object2).getType(), (List)object);
        object2 = new Object[n10];
        object2[0] = object;
        m.a.a.b("\u8fd4\u56de\u7ed9\u524d\u7aef\u4ef7\u683c\u6570\u636e\uff1a%s", (Object[])object2);
        object2 = this.c;
        object3 = l0$a.i;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        ((JSWebView)((Object)object2)).c((String)object3, objectArray);
    }

    private void v0(int n10, int n11, int n12) {
        Context context = this.requireContext();
        k$b k$b = new k$b(context);
        k$b k$b2 = (k$b)((k$b)k$b.A(n10)).m(n11);
        Object object = a.a;
        k$b2 = (k$b)k$b2.v(n12, (d.v.f.f.a)object);
        object = this.getChildFragmentManager();
        k$b2.D((FragmentManager)object);
    }

    private void w0(String object, String object2, String string2) {
        Context context = this.requireContext();
        k$b k$b = new k$b(context);
        object = (k$b)((k$b)k$b.B((String)object)).n((String)object2);
        object2 = a.a;
        object = (k$b)((k$a)object).x(string2, (d.v.f.f.a)object2);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private void x0() {
        b$a b$a = new b$a();
        Object object = g.m(this.requireContext(), 2131952664);
        b$a = b$a.f((String)object);
        object = g.m(this.requireContext(), 2131952663);
        b$a = b$a.d((String)object);
        object = a.a;
        b$a = b$a.e((d.v.f.f.a)object);
        object = g.m(this.requireContext(), 2131952838);
        n n10 = new n(this);
        b$a = b$a.b((String)object, n10);
        object = this.getChildFragmentManager();
        b$a.g((FragmentManager)object);
    }

    private void y0(String object) {
        PrimeManager.requestPrime(d.v.a.f.c.b.N().P());
        Object object2 = new b$a();
        Object object3 = g.m(this.requireContext(), 2131952666);
        object2 = ((b$a)object2).f((String)object3);
        object3 = this.requireContext();
        Object[] objectArray = new Object[]{object};
        object3 = g.n((Context)object3, 2131952665, objectArray);
        object = ((b$a)object2).d((String)object3).c((String)object);
        object2 = new j(this);
        object = ((b$a)object).e((d.v.f.f.a)object2);
        object2 = g.m(this.requireContext(), 2131952716);
        object3 = new p(this);
        object = ((b$a)object).b((String)object2, (d.v.f.f.a)object3);
        object2 = this.getChildFragmentManager();
        ((b$a)object).g((FragmentManager)object2);
    }

    private void z0(int n10) {
        Context context = this.requireContext();
        Object object = new k$b(context);
        k$b k$b = (k$b)((k$a)object).m(n10);
        object = a.a;
        k$b = (k$b)k$b.v(2131951887, (d.v.f.f.a)object);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public /* synthetic */ void W(String string2) {
        this.V(string2);
    }

    public /* synthetic */ void Y(d.v.w.c0.c c10) {
        this.X(c10);
    }

    public /* synthetic */ void a0(PayFlowResult payFlowResult) {
        this.Z(payFlowResult);
    }

    public /* synthetic */ void c0(Pair pair) {
        this.b0(pair);
    }

    public /* synthetic */ void e0(d d10) {
        this.d0(d10);
    }

    public /* synthetic */ void h0(DialogFragment dialogFragment) {
        this.g0(dialogFragment);
    }

    public /* synthetic */ void j0(DialogFragment dialogFragment) {
        this.i0(dialogFragment);
    }

    public /* synthetic */ void l0(DialogFragment dialogFragment) {
        this.k0(dialogFragment);
    }

    public String m() {
        int n10 = d.v.a.f.c.b.N().i().getId();
        PrimeInfoDao primeInfoDao = DatabaseHelper.getInstance().getDataBase().primeInfoDao();
        Object object = primeInfoDao.loadPrimeInfoData(n10);
        if (object != null) {
            int n11;
            int n12 = ((PrimeInfo)object).getStatus();
            if (n12 > (n11 = 1) && (n10 = ((PrimeInfo)object).getInactive()) > 0) {
                n12 = 0;
                primeInfoDao = null;
            }
            object = this.i.b(n12);
        } else {
            object = l0$b.f;
        }
        return object;
    }

    public JSWebView$a n() {
        PrimeWebFragment$d primeWebFragment$d = new PrimeWebFragment$d(this, null);
        return primeWebFragment$d;
    }

    public /* synthetic */ void n0(DialogFragment dialogFragment) {
        this.m0(dialogFragment);
    }

    public UserInfo o() {
        return d.v.a.f.c.b.N().i();
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.a(this);
        this.i = viewModel = (y)((ViewModelProvider)object).get(y.class);
        viewModel = (d0)((ViewModelProvider)object).get(d0.class);
        this.l = viewModel;
        this.j = object = (d.v.c.m1.c)((ViewModelProvider)object).get(d.v.c.m1.c.class);
        this.k = object = (r2)d.v.i0.b.c(this.requireActivity()).get(r2.class);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.I0();
    }

    public void onResume() {
        super.onResume();
        Object object = (ConstraintLayout$LayoutParams)this.d.getLayoutParams();
        float f10 = 20.0f;
        int n10 = h2.b(f10);
        float f11 = 30.0f;
        int n11 = h2.b(f11);
        object.setMargins(n10, n11, 0, 0);
        Object object2 = this.d;
        object2.setLayoutParams((ViewGroup.LayoutParams)object);
        object = this.i;
        boolean bl2 = ((y)object).d;
        if (bl2 && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).s())) {
            this.i.d = false;
            object = this.j;
            object2 = d.v.a.f.c.b.N().P();
            ((d.v.c.m1.c)object).w((String)object2);
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.i.c;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = ((App)this.requireActivity().getApplication()).c();
        if (object != null) {
            object2 = this.getLifecycle();
            ((Lifecycle)object2).addObserver((LifecycleObserver)object);
        }
        object = this.l.a;
        object2 = new o(this);
        ((d.v.e.i.j)object).observe(this, (Observer)object2);
        object = this.l.b;
        object2 = new d.v.c.m1.e.s(this);
        ((d.v.e.i.j)object).observe(this, (Observer)object2);
        object = this.l.c;
        object2 = new k(this);
        ((d.v.e.i.j)object).observe(this, (Observer)object2);
        object = this.l.d;
        object2 = new q(this);
        ((d.v.e.i.j)object).observe(this, (Observer)object2);
        object = this.k.e;
        object2 = this.getViewLifecycleOwner();
        observer = new w(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    public /* synthetic */ void p0(DialogFragment dialogFragment) {
        this.o0(dialogFragment);
    }

    public boolean r() {
        return false;
    }

    public /* synthetic */ void r0(d.v.w.c0.d d10, DialogFragment dialogFragment) {
        this.q0(d10, dialogFragment);
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public void y(WebView object, String object2) {
        super.y((WebView)object, (String)object2);
        object = ce.E0().y0().a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = "wifimac";
        }
        object2 = this.c;
        String string2 = l0$a.h;
        Object[] objectArray = new Object[5];
        String string3 = d1.d();
        objectArray[0] = string3;
        objectArray[1] = "zycami";
        objectArray[2] = "Android";
        objectArray[3] = "google";
        objectArray[4] = object;
        ((JSWebView)((Object)object2)).c(string2, objectArray);
    }
}

