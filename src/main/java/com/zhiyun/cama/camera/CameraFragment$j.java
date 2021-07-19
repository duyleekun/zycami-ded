/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.Size
 *  android.view.View
 */
package com.zhiyun.cama.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.android.CameraView;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantActivity;
import com.zhiyun.cama.data.database.model.CameraParam;
import com.zhiyun.live.data.LivePlatform;
import d.v.c.m1.b;
import d.v.c.s0.a7.c1;
import d.v.c.s0.a7.f1;
import d.v.c.s0.a7.g1;
import d.v.c.s0.a7.h1;
import d.v.c.s0.a7.k1;
import d.v.c.s0.a7.v0;
import d.v.c.s0.a7.w0;
import d.v.c.s0.a7.w0$b;
import d.v.c.s0.a7.x0;
import d.v.c.s0.a7.y0;
import d.v.c.s0.d7.u;
import d.v.c.s0.d7.z;
import d.v.c.s0.e0;
import d.v.c.s0.f0;
import d.v.c.s0.g0;
import d.v.c.s0.h0;
import d.v.c.s0.h7.i0;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.j;
import d.v.c.s0.j0;
import d.v.c.s0.k0;
import d.v.c.s0.l0;
import d.v.c.s0.n0;
import d.v.c.s0.o0;
import d.v.c.s0.p0;
import d.v.c.s0.q0;
import d.v.c.s0.r0;
import d.v.c.s0.s0;
import d.v.c.s0.s6;
import d.v.c.s0.t0;
import d.v.c.s0.u6;
import d.v.c.w0.si;
import d.v.c.w0.yh;
import d.v.c.x1.l;
import d.v.c.y0.b.s;
import d.v.d.i.f.t;
import d.v.d.i.g.k;
import d.v.e.h.a;
import d.v.f.g.b$b;
import d.v.f.g.b$c;
import d.v.f.i.g;
import d.v.g.g.e1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CameraFragment$j {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$j(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    private /* synthetic */ void B() {
        CameraFragment.H(this.a).k2(true);
    }

    private /* synthetic */ void D() {
        CameraFragment.M((CameraFragment)this.a).k.a.setChecked(true);
    }

    private /* synthetic */ void F() {
        Object object = CameraFragment.M((CameraFragment)this.a).k.a;
        boolean bl2 = false;
        Boolean bl3 = null;
        object.setChecked(false);
        object = CameraFragment.P((CameraFragment)this.a).j;
        BleViewModel bleViewModel = CameraFragment.A(this.a);
        boolean bl4 = bleViewModel.G();
        boolean bl5 = true;
        if (bl4 <= bl5) {
            bl2 = bl5;
        }
        bl3 = bl2;
        ((MutableLiveData)object).setValue(bl3);
    }

    private /* synthetic */ void H() {
        CameraFragment.H(this.a).k2(false);
    }

    private /* synthetic */ void J() {
        CameraFragment.H(this.a).k2(true);
    }

    private /* synthetic */ void L() {
        CameraFragment.H(this.a).k2(false);
    }

    private /* synthetic */ void N() {
        Object object = CameraFragment.H(this.a);
        boolean bl2 = true;
        ((u6)object).k2(bl2);
        object = CameraFragment.Q((CameraFragment)this.a).a;
        boolean bl3 = ((ArrayDeque)object).isEmpty();
        if (!bl3) {
            object = CameraFragment.Q(this.a).X();
            Object e10 = CameraFragment.Q((CameraFragment)this.a).a.getFirst();
            ((MutableLiveData)object).setValue(e10);
        }
    }

    private /* synthetic */ void P(List object, int n10) {
        Object object2;
        object = (CameraSet$Panorama)((Object)object.get(n10));
        Object object3 = CameraSet$Panorama.P_CLONE;
        boolean bl2 = ((Enum)object).equals(object3);
        int n11 = 4;
        Object object4 = n11;
        if (bl2 && !(bl2 = CameraFragment.K((CameraFragment)(object2 = this.a)))) {
            CameraFragment.w(this.a).getCameraUpdate().n((Integer)object4);
            object2 = CameraFragment.w(this.a).getPreviewSize();
            object4 = "1.7778";
            ((t)object2).w((String)object4);
            CameraFragment.w(this.a).a();
            object2 = CameraFragment.w(this.a);
            ((CameraView)object2).c();
        } else {
            bl2 = ((Enum)object).equals(object3);
            if (!bl2 && (bl2 = CameraFragment.K((CameraFragment)(object2 = this.a)))) {
                CameraFragment.w(this.a).getCameraUpdate().n((Integer)object4);
                object2 = CameraFragment.w(this.a).getPreviewSize();
                object4 = "1.3333";
                ((t)object2).w((String)object4);
                CameraFragment.w(this.a).a();
                object2 = CameraFragment.w(this.a);
                ((CameraView)object2).c();
            }
        }
        object2 = CameraFragment.H(this.a);
        ((u6)object2).d2((CameraSet$Panorama)((Object)object));
        boolean bl3 = ((Enum)object).equals(object3);
        if (bl3 && (bl3 = ((s6)(object = CameraFragment.P(this.a))).r())) {
            object = h1.F();
            object3 = this.a.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object3);
            object = CameraFragment.P(this.a);
            n10 = 0;
            object3 = null;
            ((s6)object).X(false);
        }
    }

    private /* synthetic */ void R() {
        CameraFragment.H(this.a).k2(false);
    }

    private /* synthetic */ void T() {
        CameraFragment.H(this.a).k2(true);
    }

    private void i0(int n10) {
        Object object;
        if (n10 == 0) {
            object = v0.F();
        } else {
            int n11 = 1;
            if (n10 == n11) {
                object = f1.L();
            } else {
                n10 = 0;
                object = null;
            }
        }
        if (object == null) {
            return;
        }
        Object object2 = new e0(this);
        ((d.v.f.g.b)object).o((b$c)object2);
        object2 = new f0(this);
        ((d.v.f.g.b)object).n((b$b)object2);
        object2 = this.a.getChildFragmentManager();
        int n12 = CameraFragment.L(this.a);
        ((d.v.f.g.b)object).r((FragmentManager)object2, n12);
        object = CameraFragment.Q(this.a).X();
        object2 = 0;
        ((MutableLiveData)object).setValue(object2);
    }

    private /* synthetic */ void p() {
        CameraFragment.M((CameraFragment)this.a).k.z.setVisibility(0);
        CameraFragment.M((CameraFragment)this.a).k.b.setChecked(false);
    }

    private /* synthetic */ void r() {
        CameraFragment.M((CameraFragment)this.a).k.z.setVisibility(4);
        CameraFragment.M((CameraFragment)this.a).k.b.setChecked(true);
    }

    private /* synthetic */ void t() {
        CameraFragment.H(this.a).k2(false);
    }

    private /* synthetic */ void v() {
        CameraFragment.H(this.a).k2(true);
    }

    private /* synthetic */ void x(CameraSet$CountDownTime[] object, int n10) {
        CameraSet$Mode cameraSet$Mode;
        Object object2 = CameraFragment.H(this.a).I();
        if (object2 == (cameraSet$Mode = CameraSet$Mode.panorama)) {
            object2 = CameraFragment.H(this.a);
            object = object[n10];
            ((u6)object2).g2((CameraSet$CountDownTime)((Object)object));
        } else {
            object2 = CameraFragment.H(this.a);
            object = object[n10];
            ((u6)object2).V1((CameraSet$CountDownTime)((Object)object));
        }
    }

    private /* synthetic */ void z() {
        CameraFragment.H(this.a).k2(false);
    }

    public /* synthetic */ void A() {
        this.z();
    }

    public /* synthetic */ void C() {
        this.B();
    }

    public /* synthetic */ void E() {
        this.D();
    }

    public /* synthetic */ void G() {
        this.F();
    }

    public /* synthetic */ void I() {
        this.H();
    }

    public /* synthetic */ void K() {
        this.J();
    }

    public /* synthetic */ void M() {
        this.L();
    }

    public /* synthetic */ void O() {
        this.N();
    }

    public /* synthetic */ void Q(List list, int n10) {
        this.P(list, n10);
    }

    public /* synthetic */ void S() {
        this.R();
    }

    public /* synthetic */ void U() {
        this.T();
    }

    public void V(int n10) {
        CameraFragment.y(this.a).c0(n10);
    }

    public void W() {
        i0 i02 = CameraFragment.D(this.a);
        Context context = this.a.requireContext();
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        i02.j(context, fragmentManager);
    }

    public void X() {
        Object object;
        Object object2 = CameraFragment.A(this.a);
        boolean bl2 = ((BleViewModel)object2).L((BleViewModel$PanoramaState)((Object)(object = (BleViewModel$PanoramaState)((Object)CameraFragment.A((CameraFragment)this.a).r.getValue()))));
        if (!bl2) {
            object2 = h1.F();
            object = this.a.getChildFragmentManager();
            ((d.v.f.g.b)object2).q((FragmentManager)object);
        }
    }

    public void Y() {
        g1 g12 = new g1();
        Object object = new q0(this);
        g12.n((b$b)object);
        object = new l0(this);
        g12.o((b$c)object);
        object = this.a.getChildFragmentManager();
        int n10 = CameraFragment.L(this.a);
        g12.r((FragmentManager)object, n10);
    }

    public void Z() {
        j j10 = CameraFragment.J(this.a);
        d.v.c.s0.h7.k0 k02 = CameraFragment.I(this.a);
        CameraView cameraView = CameraFragment.M((CameraFragment)this.a).a;
        j10.q(k02, cameraView);
    }

    public void a() {
        CameraFragment.l(this.a).d();
    }

    public void a0() {
        j j10 = CameraFragment.J(this.a);
        d.v.c.s0.h7.k0 k02 = CameraFragment.I(this.a);
        CameraView cameraView = CameraFragment.M((CameraFragment)this.a).a;
        j10.r(k02, cameraView);
    }

    public void b(LivePlatform object) {
        Object object2 = LivePlatform.HELPER;
        if (object == object2) {
            object = this.a.requireContext();
            boolean bl2 = b.b((Context)object);
            if (bl2) {
                object = this.a.requireActivity();
                LiveAssistantActivity.d((Activity)object);
            }
            return;
        }
        object2 = CameraFragment.l(this.a);
        String string2 = CameraFragment.F((CameraFragment)this.a).c.b.getText().toString();
        ((u)object2).e((LivePlatform)((Object)object), string2);
    }

    public void b0() {
        Object object;
        boolean bl2;
        Object object2 = (CameraParam)CameraFragment.H(this.a).J().getValue();
        if (object2 != null && (bl2 = k.s((Size)(object2 = object2.getVideoResolution().a))) && !(bl2 = Objects.equals(object2 = CameraFragment.H(this.a).H().getValue(), object = CameraSet$Mode.photograph))) {
            object2 = CameraFragment.H(this.a);
            object = g.o(this.a.getResources(), 2131951769);
            ((u6)object2).o2((String)object);
            return;
        }
        this.i0(0);
    }

    public void c() {
        CameraFragment.l(this.a).f();
    }

    public void c0() {
        x0 x02 = x0.M();
        Object object = new t0(this);
        x02.o((b$c)object);
        object = new d.v.c.s0.m0(this);
        x02.n((b$b)object);
        object = this.a.getChildFragmentManager();
        int n10 = CameraFragment.L(this.a);
        x02.r((FragmentManager)object, n10);
    }

    public void d() {
        s s10 = new s();
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        int n10 = CameraFragment.L(this.a);
        s10.r(fragmentManager, n10);
        CameraFragment.y(this.a).h0(false);
    }

    public void d0() {
        Object object = CameraSet$CountDownTime.values();
        Object object2 = new ArrayList();
        int n10 = ((CameraSet$CountDownTime[])object).length;
        CameraSet$Mode cameraSet$Mode = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object[i10].getText();
            ((ArrayList)object2).add(string2);
        }
        Object object3 = CameraFragment.H(this.a).I();
        object3 = object3 == (cameraSet$Mode = CameraSet$Mode.panorama) ? ((CameraSet$CountDownTime)((Object)CameraFragment.H(this.a).p0().getValue())).getText() : ((CameraSet$CountDownTime)((Object)CameraFragment.H(this.a).R().getValue())).getText();
        object2 = w0.z(object2, (String)object3);
        object3 = new o0(this, (CameraSet$CountDownTime[])object);
        ((w0)object2).B((w0$b)object3);
        object = new n0(this);
        ((d.v.f.g.b)object2).o((b$c)object);
        object = new k0(this);
        ((d.v.f.g.b)object2).n((b$b)object);
        object = this.a.getChildFragmentManager();
        n10 = CameraFragment.L(this.a);
        ((d.v.f.g.b)object2).r((FragmentManager)object, n10);
    }

    public void e() {
        CameraFragment.l(this.a).g();
    }

    public void e0() {
        Object object = (Boolean)CameraFragment.H(this.a).K().getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            object = y0.O();
            Object object2 = new h0(this);
            ((d.v.f.g.b)object).o((b$c)object2);
            object2 = new j0(this);
            ((d.v.f.g.b)object).n((b$b)object2);
            object2 = this.a.getChildFragmentManager();
            CameraFragment cameraFragment = this.a;
            int n10 = CameraFragment.L(cameraFragment);
            ((d.v.f.g.b)object).r((FragmentManager)object2, n10);
        }
    }

    public void f() {
        MutableLiveData mutableLiveData = CameraFragment.Q(this.a).T();
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    public void f0() {
        boolean bl2;
        Object object;
        Object object2 = CameraFragment.H(this.a).I();
        if (object2 == (object = CameraSet$Mode.live)) {
            return;
        }
        object2 = CameraSet$Mode.slow_motion;
        object = CameraFragment.H(this.a).I();
        if (object2 != object && !(bl2 = ((u6)(object2 = CameraFragment.H(this.a))).L())) {
            object2 = k1.O();
            object = new s0(this);
            ((d.v.f.g.b)object2).o((b$c)object);
            object = new r0(this);
            ((d.v.f.g.b)object2).n((b$b)object);
            object = this.a.getChildFragmentManager();
            CameraFragment cameraFragment = this.a;
            int n10 = CameraFragment.L(cameraFragment);
            ((d.v.f.g.b)object2).r((FragmentManager)object, n10);
        }
    }

    public void g() {
        e1.i(false);
        CameraFragment.E(this.a).R();
    }

    public void g0() {
        int n10;
        Object object;
        Object object2 = CameraFragment.m(this.a).p();
        if (object2 == (object = DynamicZoomViewModel$TargetModel.FAR)) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = 1;
        }
        object2 = c1.E(n10);
        object = this.a.getChildFragmentManager();
        ((d.v.f.g.b)object2).q((FragmentManager)object);
    }

    public void h() {
        CameraFragment.l(this.a).i();
    }

    public void h0() {
        CameraFragment.l(this.a).a0();
    }

    public void i() {
        CameraFragment.z(this.a);
    }

    public void j() {
        Boolean bl2 = (Boolean)CameraFragment.Q(this.a).W().getValue();
        boolean bl3 = d.v.e.h.a.c(bl2);
        if (bl3) {
            return;
        }
        l.d(this.a, 2131361889);
    }

    public void j0() {
        int n10;
        Object object = CameraFragment.H(this.a).B0();
        Object object2 = new ArrayList();
        Object object3 = object.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            n10 = ((CameraSet$Panorama)((Object)object3.next())).getDrawableRes();
            Integer n11 = n10;
            ((ArrayList)object2).add(n11);
        }
        object3 = (CameraSet$Panorama)((Object)CameraFragment.H(this.a).k0().getValue());
        n10 = (int)(object.contains(object3) ? 1 : 0);
        int n12 = n10 != 0 ? object.indexOf(object3) : object.size() + -1;
        object2 = w0.y(object2, n12);
        object3 = new Object(this, (List)object);
        ((w0)object2).B((w0$b)object3);
        object = new g0(this);
        ((d.v.f.g.b)object2).o((b$c)object);
        object = new p0(this);
        ((d.v.f.g.b)object2).n((b$b)object);
        object = this.a.getChildFragmentManager();
        n12 = CameraFragment.L(this.a);
        ((d.v.f.g.b)object2).r((FragmentManager)object, n12);
    }

    public void k() {
        int n10;
        int n11;
        CameraSet$Mode cameraSet$Mode;
        Object object = CameraFragment.H(this.a).I();
        if (object == (cameraSet$Mode = CameraSet$Mode.live) && (n11 = ((z)(object = CameraFragment.Q(this.a))).b0()) == (n10 = 1)) {
            return;
        }
        ActivityCompat.finishAfterTransition(this.a.requireActivity());
    }

    public void k0(View view) {
        u u10 = CameraFragment.l(this.a);
        si si2 = CameraFragment.F(this.a);
        boolean bl2 = CameraFragment.G(this.a);
        u10.c0(si2, view, bl2);
    }

    public void l() {
        CameraFragment.l(this.a).n();
    }

    public void l0() {
        CameraFragment.l(this.a).d0();
    }

    public void m() {
        m0 m02 = CameraFragment.y(this.a);
        CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_PERSONAL;
        m02.g0(cameraSet$StoryState);
    }

    public void m0() {
        this.i0(1);
    }

    public void n() {
        CameraFragment.l(this.a).b();
    }

    public void n0() {
        CameraFragment.l(this.a).X(4);
    }

    public void o() {
        Object object = this.a;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.story;
        CameraFragment.B((CameraFragment)object, cameraSet$Mode);
        object = CameraFragment.y(this.a);
        cameraSet$Mode = CameraFragment.H(this.a).I();
        ((m0)object).L(cameraSet$Mode);
    }

    public void o0() {
        u u10 = CameraFragment.l(this.a);
        si si2 = CameraFragment.F(this.a);
        u10.e0(si2);
    }

    public void p0(boolean bl2) {
        CameraFragment.y(this.a).h0(bl2);
        i0 i02 = CameraFragment.D(this.a);
        yh yh2 = CameraFragment.C(this.a);
        int n10 = CameraFragment.y(this.a).j();
        i02.o(yh2, n10, bl2);
    }

    public /* synthetic */ void q() {
        this.p();
    }

    public void q0() {
        i0 i02 = CameraFragment.D(this.a);
        yh yh2 = CameraFragment.C(this.a);
        i02.n(yh2);
    }

    public void r0() {
        e1.a(true);
        ActivityCompat.finishAfterTransition(this.a.requireActivity());
    }

    public /* synthetic */ void s() {
        this.r();
    }

    public /* synthetic */ void u() {
        this.t();
    }

    public /* synthetic */ void w() {
        this.v();
    }

    public /* synthetic */ void y(CameraSet$CountDownTime[] cameraSet$CountDownTimeArray, int n10) {
        this.x(cameraSet$CountDownTimeArray, n10);
    }
}

