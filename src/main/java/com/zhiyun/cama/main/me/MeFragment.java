/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package com.zhiyun.cama.main.me;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.main.home.ExViewPager;
import com.zhiyun.cama.main.me.MeFragment$a;
import com.zhiyun.cama.main.me.MeFragment$b;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.common.util.Times;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import com.zhiyun.image.Images;
import d.v.c.i1.t2.d;
import d.v.c.i1.t2.e;
import d.v.c.i1.t2.f;
import d.v.c.i1.t2.h;
import d.v.c.i1.t2.h0;
import d.v.c.i1.t2.i;
import d.v.c.i1.t2.i0;
import d.v.c.j1.b.o0;
import d.v.c.m1.c;
import d.v.c.n1.j2;
import d.v.c.w0.cf;
import d.v.e.i.j;
import d.v.e.l.h2;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.i0.b;
import d.v.j.e.h.k;

public class MeFragment
extends a {
    public static final String k = "MeFragment";
    private cf b;
    private i0 c;
    private o0 d;
    private c e;
    private j2 f;
    private DeviceViewModel g;
    private PublishWorks h;
    private boolean i = true;
    private CompoundButton.OnCheckedChangeListener j;

    public MeFragment() {
        d.v.c.i1.t2.j j10 = d.v.c.i1.t2.j.a;
        this.j = j10;
    }

    private /* synthetic */ void A(k object) {
        boolean bl2 = false;
        Object object2 = null;
        String string2 = "";
        if (object != null && (object = ((k)object).c) != null) {
            int n10;
            String string3;
            Object object3;
            object = (UserInfo)object;
            int n11 = this.i;
            int n12 = 1;
            if (n11 != 0) {
                this.e.v();
                object3 = this.e;
                string3 = ((UserInfo)object).getToken();
                ((c)object3).w(string3);
            } else {
                n11 = ((UserInfo)object).getPrime();
                if (n11 == n12) {
                    object3 = this.b.k;
                    n10 = 2131231140;
                    object3.setBackgroundResource(n10);
                } else {
                    object3 = this.b.k;
                    n10 = 2131231141;
                    object3.setBackgroundResource(n10);
                }
            }
            object3 = this.b.f;
            string3 = ((UserInfo)object).getAvatar();
            int n13 = 2131231027;
            Images.A((ImageView)object3, string3, n13);
            n11 = ((UserInfo)object).getSex();
            if (n12 == n11) {
                object2 = this.b.n;
                n11 = 2131231337;
                object2.setImageResource(n11);
            } else {
                n12 = 2;
                if (n12 == n11) {
                    object2 = this.b.n;
                    n11 = 2131231341;
                    object2.setImageResource(n11);
                } else {
                    object3 = this.b.n;
                    object3.setImageDrawable(null);
                }
            }
            object2 = this.b.v;
            object3 = ((UserInfo)object).getNickname();
            object2.setText((CharSequence)object3);
            object2 = this.b.s;
            object3 = ((UserInfo)object).getCountry();
            object2.setText((CharSequence)object3);
            object2 = this.b.s;
            object3 = ((UserInfo)object).getCountry();
            n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
            n12 = 8;
            n10 = 0;
            string3 = null;
            if (n11 != 0) {
                n11 = n12;
            } else {
                n11 = 0;
                object3 = null;
            }
            object2.setVisibility(n11);
            object2 = ((UserInfo)object).getIntroduction();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                this.b.t.setVisibility(0);
                object2 = this.b.t;
                object = ((UserInfo)object).getIntroduction();
                object3 = "\n";
                object = ((String)object).replace((CharSequence)object3, string2);
                object2.setText((CharSequence)object);
            } else {
                boolean bl3 = this.i;
                if (bl3) {
                    this.b.t.setVisibility(0);
                    object = this.b.t;
                    object2 = this.getResources();
                    int n14 = 2131952530;
                    object2 = d.v.f.i.g.o((Resources)object2, n14);
                    object.setText((CharSequence)object2);
                } else {
                    object = this.b.t;
                    object.setVisibility(n12);
                }
            }
        } else {
            this.b.f.setImageDrawable(null);
            this.b.n.setImageDrawable(null);
            this.b.v.setText((CharSequence)string2);
            this.b.s.setText((CharSequence)string2);
            object = this.b.t;
            object.setText((CharSequence)string2);
        }
    }

    private /* synthetic */ void C(PrimeInfo object) {
        String string2;
        Object object2;
        Object object3;
        int n10 = this.i;
        if (n10 == 0) {
            return;
        }
        n10 = ((PrimeInfo)object).getStatus();
        int n11 = 1;
        int n12 = 8;
        if (n10 == n11 && (n10 = (int)(((c)(object3 = this.e)).o((Context)(object2 = this.getActivity()), string2 = ((PrimeInfo)object).getEndTime()) ? 1 : 0)) != 0) {
            object3 = this.b.k;
            int n13 = 2131231140;
            object3.setBackgroundResource(n13);
            n10 = ((PrimeInfo)object).getInactive();
            if (n10 > 0) {
                object3 = this.b.x;
                object3.setVisibility(0);
            } else {
                object3 = this.b.x;
                object3.setVisibility(n12);
            }
            object3 = this.b.y;
            object2 = d.v.f.i.g.m(this.requireContext(), 2131952667);
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Times.getTimeZoneDescribe(((PrimeInfo)object).getEndTime());
            object = String.format((String)object2, objectArray);
            object3.setText((CharSequence)object);
            this.b.z.setVisibility(0);
            this.b.w.setVisibility(n12);
            return;
        }
        object3 = this.e;
        n10 = (int)(((c)object3).p() ? 1 : 0);
        int n14 = 2131231141;
        if (n10 != 0) {
            this.b.k.setBackgroundResource(n14);
            this.b.x.setVisibility(n12);
            object = this.b.y;
            object3 = d.v.f.i.g.s(this, 2131952674);
            object.setText((CharSequence)object3);
            this.b.z.setVisibility(n12);
            this.b.w.setVisibility(0);
            object = this.b.w;
            object3 = d.v.f.i.g.s(this, 2131952669);
            object.setText((CharSequence)object3);
            return;
        }
        this.b.k.setBackgroundResource(n14);
        object3 = this.b.x;
        object3.setVisibility(n12);
        n10 = ((PrimeInfo)object).getOverdueTime();
        if (n10 > 0) {
            n10 = 2131952673;
            Object[] objectArray = new Object[n11];
            int n15 = ((PrimeInfo)object).getOverdueTime();
            objectArray[0] = object = Integer.valueOf(n15);
            object = d.v.f.i.g.t(this, n10, objectArray);
        } else {
            int n16 = 2131952675;
            object = d.v.f.i.g.s(this, n16);
        }
        this.b.y.setText((CharSequence)object);
        this.b.z.setVisibility(n12);
        this.b.w.setVisibility(0);
        object = this.b.w;
        object3 = d.v.f.i.g.s(this, 2131952651);
        object.setText((CharSequence)object3);
    }

    private /* synthetic */ void E(DeviceViewModel$NetWorkEvent object) {
        object = d.v.a.f.c.b.N().i().getToken();
        this.e.w((String)object);
    }

    private /* synthetic */ void G(PublishWorks publishWorks) {
        this.h = publishWorks;
        if (publishWorks != null) {
            PublishState publishState = publishWorks.getState();
            Object object = publishWorks.getCoverPath();
            Object object2 = TextUtils.isEmpty((CharSequence)object);
            object = object2 != 0 ? publishWorks.getFilePath() : publishWorks.getCoverPath();
            ImageView imageView = this.b.h;
            float f10 = 4.0f;
            int n10 = h2.b(f10);
            Images.G(imageView, object, n10);
            imageView = this.b.i;
            int n11 = h2.b(f10);
            Images.G(imageView, object, n11);
            object = MeFragment$a.a;
            Object object3 = publishState.ordinal();
            object3 = object[object3];
            object2 = 1;
            if (object3 != object2) {
                object2 = 2;
                if (object3 != object2) {
                    Object object4 = 3;
                    if (object3 == object4 || object3 == (object4 = 4) || object3 == (object4 = 5)) {
                        this.p();
                    }
                } else {
                    this.q();
                    this.M();
                    int n12 = publishWorks.getPercent();
                    this.O(n12);
                }
            } else {
                this.N();
                this.o();
                int n13 = publishWorks.getPercent();
                this.O(n13);
            }
        } else {
            this.p();
        }
    }

    /*
     * Unable to fully structure code
     */
    private /* synthetic */ void I(k var1_1) {
        var2_2 = 0;
        if (var1_1 == null || (var3_3 = var1_1.c) == null) ** GOTO lbl-1000
        var3_3 = (MessageUnReadCount)var3_3;
        var4_4 = var3_3.getLike();
        var5_5 = (MessageUnReadCount)var1_1.c;
        var6_6 = var5_5.getNotice();
        var4_4 += var6_6;
        var1_1 = (MessageUnReadCount)var1_1.c;
        var7_7 = var1_1.getPersonal();
        if ((var4_4 += var7_7) > 0) {
            var7_7 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var7_7 = 0;
            var1_1 = null;
        }
        var3_3 = this.b.B;
        if (var7_7 == 0) {
            var2_2 = 4;
        }
        var3_3.setVisibility(var2_2);
    }

    public static /* synthetic */ void K(CompoundButton compoundButton, boolean bl2) {
        if (bl2) {
            int n10 = 1101004800;
            float f10 = 20.0f;
            compoundButton.setTextSize(f10);
        } else {
            int n11 = 1098907648;
            float f11 = 16.0f;
            compoundButton.setTextSize(f11);
        }
    }

    private void L(RadioGroup object, int n10) {
        int n11 = 2131363067;
        if (n10 == n11) {
            object = this.b.C;
            n10 = 0;
            ((ExViewPager)((Object)object)).setCurrentItem(0);
        } else {
            n11 = 2131363039;
            if (n10 == n11) {
                object = this.b.C;
                n10 = 1;
                ((ExViewPager)((Object)object)).setCurrentItem(n10);
            }
        }
    }

    private void M() {
        this.b.c.setVisibility(0);
    }

    private void N() {
        this.b.e.setVisibility(0);
    }

    private void O(int n10) {
        this.b.p.setVisibility(0);
        this.b.p.setProgress(n10);
    }

    public static /* synthetic */ boolean j(MeFragment meFragment) {
        return meFragment.i;
    }

    public static /* synthetic */ j2 k(MeFragment meFragment) {
        return meFragment.f;
    }

    public static /* synthetic */ void l(MeFragment meFragment) {
        meFragment.p();
    }

    public static /* synthetic */ PublishWorks m(MeFragment meFragment) {
        return meFragment.h;
    }

    public static /* synthetic */ c n(MeFragment meFragment) {
        return meFragment.e;
    }

    private void o() {
        this.b.c.setVisibility(8);
    }

    private void p() {
        this.q();
        this.o();
        this.r();
    }

    private void q() {
        this.b.e.setVisibility(8);
    }

    private void s() {
        Object object = this.b;
        Object object2 = this.e;
        ((cf)object).C((c)object2);
        object = this.b;
        object2 = this.c;
        ((cf)object).D((i0)object2);
        object = this.c.d();
        object2 = this.getViewLifecycleOwner();
        Observer observer = new d.v.c.i1.t2.c(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.k();
        object2 = this.getViewLifecycleOwner();
        observer = new h(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void t() {
        MutableLiveData mutableLiveData = this.e.l();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new f(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.g.c;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    private void u() {
        Object object = (j2)d.v.i0.b.c(this.requireActivity()).get(j2.class);
        this.f = object;
        object = ((j2)object).G();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        i i10 = new i(this);
        ((LiveData)object).observe(lifecycleOwner, i10);
    }

    private void v() {
        LiveData liveData = this.d.g();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        d.v.c.i1.t2.g g10 = new d.v.c.i1.t2.g(this);
        liveData.observe(lifecycleOwner, g10);
    }

    private void w() {
        RadioGroup radioGroup = this.b.a;
        e e10 = new e(this);
        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)e10);
        radioGroup = this.b.r;
        e10 = this.j;
        radioGroup.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)e10);
        radioGroup = this.b.q;
        e10 = this.j;
        radioGroup.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)e10);
    }

    public static /* synthetic */ void x(MeFragment meFragment, RadioGroup radioGroup, int n10) {
        meFragment.L(radioGroup, n10);
    }

    private /* synthetic */ void y(Boolean object) {
        Object object2;
        int n10;
        this.i = n10 = ((Boolean)object).booleanValue();
        if (n10 != 0) {
            this.u();
            this.v();
            object = this.b.b;
            boolean bl2 = false;
            object2 = null;
            object.setVisibility(0);
        } else {
            object = this.b.b;
            int n11 = 8;
            object.setVisibility(n11);
        }
        object2 = this.getChildFragmentManager();
        object = new h0((FragmentManager)object2);
        this.b.C.setAdapter((PagerAdapter)object);
        object2 = this.b.C;
        n10 = ((h0)object).getCount();
        ((ViewPager)((Object)object2)).setOffscreenPageLimit(n10);
    }

    public /* synthetic */ void B(k k10) {
        this.A(k10);
    }

    public /* synthetic */ void D(PrimeInfo primeInfo) {
        this.C(primeInfo);
    }

    public /* synthetic */ void F(DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent) {
        this.E(deviceViewModel$NetWorkEvent);
    }

    public /* synthetic */ void H(PublishWorks publishWorks) {
        this.G(publishWorks);
    }

    public /* synthetic */ void J(k k10) {
        this.I(k10);
    }

    public int h() {
        return 2131558703;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (cf)viewDataBinding;
        this.b = viewDataBinding;
        MeFragment$b meFragment$b = new MeFragment$b(this, null);
        ((cf)viewDataBinding).B(meFragment$b);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = viewModel = (i0)((ViewModelProvider)object).get(i0.class);
        viewModel = (o0)((ViewModelProvider)object).get(o0.class);
        this.d = viewModel;
        viewModel = (c)((ViewModelProvider)object).get(c.class);
        this.e = viewModel;
        this.g = object = (DeviceViewModel)((ViewModelProvider)object).get(DeviceViewModel.class);
    }

    public void onResume() {
        boolean bl2;
        Object object;
        super.onResume();
        Object object2 = d.v.a.f.c.b.N();
        boolean n10 = ((d.v.a.f.c.b)object2).s();
        if (!n10) {
            object2 = this.b;
            object = ((cf)object2).a;
            object2 = ((cf)object2).r;
            int n11 = object2.getId();
            object.check(n11);
        }
        if (bl2 = this.i) {
            object2 = this.d;
            ((o0)object2).L();
        }
        if ((object2 = d.v.a.f.c.b.N().i()) != null) {
            object = this.e;
            object2 = ((UserInfo)object2).getToken();
            ((c)object).w((String)object2);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.s();
        this.t();
        this.w();
    }

    public void r() {
        this.b.p.setVisibility(8);
    }

    public /* synthetic */ void z(Boolean bl2) {
        this.y(bl2);
    }
}

