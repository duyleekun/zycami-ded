/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.PopupWindow$OnDismissListener
 */
package com.zhiyun.cama.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.main.MainFragment$a;
import com.zhiyun.cama.main.MainFragment$b;
import com.zhiyun.cama.main.MainFragment$c;
import com.zhiyun.cama.main.MainFragment$d;
import com.zhiyun.cama.publish.CreationActivity;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.permission.Permission;
import d.v.a.i.a.m0;
import d.v.c.i1.a2;
import d.v.c.i1.o1;
import d.v.c.i1.p1;
import d.v.c.i1.p2;
import d.v.c.i1.q1;
import d.v.c.i1.q2;
import d.v.c.i1.r1;
import d.v.c.i1.r2;
import d.v.c.i1.t1;
import d.v.c.i1.t2.i0;
import d.v.c.i1.u1;
import d.v.c.i1.v1;
import d.v.c.i1.w1;
import d.v.c.i1.x1;
import d.v.c.i1.y1;
import d.v.c.i1.z1;
import d.v.c.n1.j2;
import d.v.c.w0.ge;
import d.v.c.w1.c;
import d.v.e.i.j;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.e.l.s1;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.g0.n$a;
import d.v.x.b;
import d.v.x.c$b;

public class MainFragment
extends a {
    private ge b;
    private boolean c;
    private j2 d;
    private PublishWorks e;
    private PublishState f;
    private boolean g = false;
    private r2 h;
    private m0 i;
    private i0 j;
    private n$a k = null;

    private /* synthetic */ void A(VersionInfo object) {
        object = d.v.c.w1.c.z((VersionInfo)object);
        FragmentManager fragmentManager = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q(fragmentManager);
    }

    private /* synthetic */ void C(Boolean object) {
        int n10;
        int n11;
        boolean n112 = (Boolean)object;
        if (n112 && (n11 = ((ViewPager)((Object)(object = this.b.e))).getCurrentItem()) == (n10 = 1)) {
            object = this.b.a;
            n10 = 2131362877;
            ((BottomNavigationView)((Object)object)).setSelectedItemId(n10);
        }
    }

    private /* synthetic */ void E() {
        CreationActivity.d((Context)this.requireActivity());
    }

    private /* synthetic */ void G(int[] nArray) {
        this.X(nArray);
    }

    private /* synthetic */ void I() {
        r2 r22 = this.h;
        int n10 = -1;
        int n11 = r22.o;
        if (n10 != n11) {
            FrameLayout frameLayout = this.b.c;
            int n12 = r22.q;
            int n13 = r22.r;
            int n14 = r22.p;
            frameLayout.layout(n12, n11, n13, n14);
        }
    }

    private /* synthetic */ void K() {
        this.k = null;
        this.h.m(true);
        this.n();
    }

    private /* synthetic */ void M() {
        int n10 = 2;
        int[] nArray = new int[n10];
        this.b.e.getLocationOnScreen(nArray);
        Object object = new n$a();
        Object object2 = this.b.a;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.m(this.requireContext(), 2131952252);
        n$a n$a = ((n$a)object).k((String)object2).d(2132017750).h(49).g(n10).m(0);
        int n11 = nArray[1];
        int n12 = this.b.e.getHeight();
        n11 += n12;
        n12 = h2.b(48.0f);
        n$a = n$a.n(n11 -= n12).e(0.5f);
        object = new p1(this, nArray);
        this.k = n$a = n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    private /* synthetic */ void O(int[] nArray) {
        this.V(nArray);
    }

    private /* synthetic */ void Q() {
        this.s();
        this.e = null;
    }

    public static /* synthetic */ boolean S(MainFragment mainFragment, MenuItem menuItem) {
        return mainFragment.U(menuItem);
    }

    private void T() {
        boolean bl2;
        this.g = bl2 = true;
        Object object = this.f;
        if (object != null) {
            object = this.getActivity();
            PublishActivity.i((Activity)object);
        } else {
            Object object2 = Permission.STORAGE_GROUP;
            object = new c$b((Permission)((Object)object2));
            object2 = new d.v.c.i1.s1(this);
            object = ((c$b)object).a((b)object2);
            object2 = this.getChildFragmentManager();
            ((c$b)object).b((FragmentManager)object2);
        }
    }

    private boolean U(MenuItem object) {
        int n10 = object.getItemId();
        boolean bl2 = true;
        int n11 = 2131362877;
        if (n10 == n11) {
            object = this.h.l;
            Boolean bl3 = Boolean.TRUE;
            object.setValue(bl3);
            this.b.e.setCurrentItem(0);
            return bl2;
        }
        int n12 = object.getItemId();
        if (n12 == (n10 = 2131362878)) {
            object = this.h.l;
            Boolean bl4 = Boolean.FALSE;
            object.setValue(bl4);
            object = d.v.a.f.c.b.N();
            n12 = (int)(object.s() ? 1 : 0);
            if (n12 != 0) {
                object = this.b.e;
                object.setCurrentItem((int)(bl2 ? 1 : 0));
            } else {
                this.c = bl2;
                object = this.getActivity();
                AccountActivity.h((Activity)object);
            }
            return bl2;
        }
        return false;
    }

    private void V(int[] object) {
        Object object2 = this.k;
        if (object2 == null) {
            return;
        }
        Object object3 = this.b.a;
        object2 = ((n$a)object2).c((View)object3);
        object3 = d.v.f.i.g.m(this.requireContext(), 2131952251);
        object2 = ((n$a)object2).k((String)object3).d(2132017753).h(8388661).g(0);
        int n10 = 1;
        object2 = ((n$a)object2).b(n10);
        int n11 = h2.b(20.0f);
        object2 = ((n$a)object2).m(n11);
        int n12 = object[n10];
        n10 = h2.b(50.0f);
        object = ((n$a)object2).n(n12 += n10);
        int n13 = h2.b(10.0f);
        object = ((n$a)object).f(n13).e(0.0f);
        object2 = new t1(this);
        ((n$a)object).j((PopupWindow.OnDismissListener)object2).p();
    }

    private void W() {
        Object object = this.k;
        if (object != null) {
            return;
        }
        object = this.b.e;
        r1 r12 = new r1(this);
        object.post(r12);
    }

    private void X(int[] nArray) {
        n$a n$a = this.k;
        if (n$a == null) {
            return;
        }
        Object object = this.b.a;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m(this.requireContext(), 2131952250);
        n$a = n$a.k((String)object).d(2132017752).h(0x800033).g(0);
        int n10 = h2.b(20.0f);
        n$a = n$a.m(n10);
        n10 = nArray[1];
        int n11 = h2.b(50.0f);
        n$a = n$a.n(n10 += n11);
        n10 = h2.b(10.0f);
        n$a = n$a.f(n10).e(0.0f);
        object = new q1(this, nArray);
        n$a.j((PopupWindow.OnDismissListener)object).p();
    }

    private void Y() {
        boolean bl2;
        MutableLiveData mutableLiveData = this.h.i;
        Object object = this.e;
        if (object != null && (bl2 = s1.q((String)(object = ((PublishWorks)object).getFilePath())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        mutableLiveData.setValue(object);
        mutableLiveData = this.h.h;
        object = Boolean.TRUE;
        mutableLiveData.setValue(object);
        mutableLiveData = this.b.b;
        object = new u1(this);
        mutableLiveData.postDelayed((Runnable)object, 5000L);
    }

    private void Z(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            n2.e(string2);
        }
    }

    public static /* synthetic */ void j(MainFragment mainFragment, String string2) {
        mainFragment.Z(string2);
    }

    public static /* synthetic */ void k(MainFragment mainFragment) {
        mainFragment.T();
    }

    public static /* synthetic */ void l(MainFragment mainFragment) {
        mainFragment.s();
    }

    public static /* synthetic */ void m(MainFragment mainFragment, ThirdPlatform thirdPlatform) {
        mainFragment.r(thirdPlatform);
    }

    private void n() {
        this.h.b();
    }

    private void o() {
        this.b.a.setSelectedItemId(2131362877);
    }

    private void q(ThirdPlatform thirdPlatform) {
        ShareInfo shareInfo;
        int n10 = this.e.getWorksId();
        int n11 = this.e.getCircleId();
        String string2 = this.e.getWorksDes();
        String string3 = this.e.getPostUrl();
        String string4 = this.e.getSmallImgUrl();
        String string5 = this.e.getFileUrl();
        Object object = shareInfo;
        shareInfo = new ShareInfo(n10, n11, string2, string3, string4, string5);
        object = this.d;
        MainFragment$b mainFragment$b = new MainFragment$b(this);
        ((j2)object).T(thirdPlatform, shareInfo, mainFragment$b);
    }

    private void r(ThirdPlatform object) {
        this.s();
        Object object2 = this.e;
        if (object2 == null) {
            return;
        }
        object2 = ThirdPlatform.KWAI_UPLOAD;
        if (object == object2) {
            j2 j22 = this.d;
            FragmentActivity fragmentActivity = this.getActivity();
            int n10 = this.e.getWorksId();
            int n11 = this.e.getCircleId();
            String string2 = this.e.getFilePath();
            object = this.e;
            String string3 = ((PublishWorks)object).getCoverPath();
            MainFragment$a mainFragment$a = new MainFragment$a(this);
            j22.f0(fragmentActivity, n10, n11, string2, string3, mainFragment$a);
        } else {
            this.q((ThirdPlatform)((Object)object));
        }
    }

    private void s() {
        MutableLiveData mutableLiveData = this.h.h;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    private void t() {
        Object object = this.h.j;
        Object object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        object2 = this.b;
        Object object3 = this.h;
        object = new q2((ge)object2, (r2)object3);
        object = this.h.d;
        object2 = this.getViewLifecycleOwner();
        object3 = new o1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        this.j.J(true);
        object = this.i.l();
        object2 = this.getViewLifecycleOwner();
        object3 = new w1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.d.G();
        object2 = this.getViewLifecycleOwner();
        object3 = new x1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.h.f;
        object2 = this.getViewLifecycleOwner();
        object3 = new v1(this);
        ((j)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.h.k;
        object2 = this.getViewLifecycleOwner();
        object3 = new z1(this);
        ((j)object).observe((LifecycleOwner)object2, (Observer)object3);
    }

    private /* synthetic */ void u(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.W();
        } else {
            this.n();
        }
    }

    private /* synthetic */ void w(UserInfo userInfo) {
        if (userInfo != null) {
            i0 i02 = this.j;
            int n10 = userInfo.getId();
            i02.L(n10);
        }
    }

    private /* synthetic */ void y(PublishWorks object) {
        if (object != null) {
            int n10;
            PublishState publishState = this.f;
            if (publishState == null && (n10 = this.g) != 0) {
                this.p();
            }
            publishState = object.getState();
            this.e = object;
            this.f = publishState;
            object = MainFragment$c.a;
            n10 = publishState.ordinal();
            PublishWorks publishWorks = object[n10];
            if (publishWorks != (n10 = 1) && publishWorks != (n10 = 2) && publishWorks != (n10 = 3) && publishWorks != (n10 = 4)) {
                n10 = 5;
                if (publishWorks == n10) {
                    this.Y();
                }
            } else {
                this.s();
            }
        } else {
            object = this.f;
            PublishState publishState = PublishState.STATE_SUCCESS;
            if (object == publishState) {
                this.f = null;
                this.Y();
            } else {
                this.f = null;
                this.s();
            }
        }
        this.g = false;
    }

    public /* synthetic */ void B(VersionInfo versionInfo) {
        this.A(versionInfo);
    }

    public /* synthetic */ void D(Boolean bl2) {
        this.C(bl2);
    }

    public /* synthetic */ void F() {
        this.E();
    }

    public /* synthetic */ void H(int[] nArray) {
        this.G(nArray);
    }

    public /* synthetic */ void J() {
        this.I();
    }

    public /* synthetic */ void L() {
        this.K();
    }

    public /* synthetic */ void N() {
        this.M();
    }

    public /* synthetic */ void P(int[] nArray) {
        this.O(nArray);
    }

    public /* synthetic */ void R() {
        this.Q();
    }

    public int h() {
        return 2131558681;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ge)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new MainFragment$d(this);
        ((ge)viewDataBinding).A((MainFragment$d)object);
        viewDataBinding = this.b;
        object = this.h;
        ((ge)viewDataBinding).B((r2)object);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.h = viewModel = (r2)((ViewModelProvider)object).get(r2.class);
        viewModel = (j2)((ViewModelProvider)object).get(j2.class);
        this.d = viewModel;
        viewModel = (m0)((ViewModelProvider)object).get(m0.class);
        this.i = viewModel;
        this.j = object = (i0)((ViewModelProvider)object).get(i0.class);
    }

    public void onResume() {
        d.v.a.f.c.b b10;
        super.onResume();
        boolean bl2 = this.c;
        if (bl2) {
            this.c = false;
            b10 = d.v.a.f.c.b.N();
            bl2 = b10.s();
            if (bl2) {
                this.p();
            } else {
                this.o();
            }
        } else {
            b10 = d.v.a.f.c.b.N();
            bl2 = b10.s();
            if (!bl2) {
                this.o();
            }
        }
        this.h.e();
        b10 = this.b.c;
        y1 y12 = new y1(this);
        b10.post(y12);
    }

    public void onViewCreated(View object, Bundle object2) {
        object = this.b.a;
        object2 = new a2(this);
        ((BottomNavigationView)((Object)object)).setOnNavigationItemSelectedListener((BottomNavigationView$OnNavigationItemSelectedListener)object2);
        object = this.b.e;
        FragmentManager fragmentManager = this.getChildFragmentManager();
        object2 = new p2(fragmentManager);
        ((ViewPager)((Object)object)).setAdapter((PagerAdapter)object2);
        this.t();
    }

    public void p() {
        this.b.a.setSelectedItemId(2131362878);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void x(UserInfo userInfo) {
        this.w(userInfo);
    }

    public /* synthetic */ void z(PublishWorks publishWorks) {
        this.y(publishWorks);
    }
}

