/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Size
 *  android.util.SparseArray
 *  android.view.View
 */
package d.v.c.s0.h7.s0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Size;
import android.util.SparseArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.d1.e;
import d.v.c.s0.a7.j1;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.s0.b;
import d.v.c.s0.h7.s0.c;
import d.v.c.s0.h7.s0.f;
import d.v.c.s0.h7.s0.g;
import d.v.c.s0.h7.s0.h;
import d.v.c.s0.h7.s0.i;
import d.v.c.s0.h7.s0.j;
import d.v.c.s0.h7.s0.k;
import d.v.c.s0.h7.s0.l;
import d.v.c.s0.h7.s0.m;
import d.v.c.s0.h7.s0.n;
import d.v.c.s0.h7.s0.o;
import d.v.c.s0.h7.s0.p;
import d.v.c.s0.h7.s0.q;
import d.v.c.s0.h7.s0.r;
import d.v.c.s0.h7.s0.s;
import d.v.c.s0.h7.s0.y$a;
import d.v.c.s0.h7.s0.y$b;
import d.v.c.w0.ai;
import d.v.c.w0.n9;
import d.v.c.z1.d;
import d.v.e.l.a2;
import d.v.e.l.c1;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.e.l.s1;
import java.util.List;
import m.a.a;

public class y
extends d.v.f.h.a {
    private n9 b;
    private StoryReviewViewModel c;
    private TemplateEditViewModel d;
    private m0 e;
    private d.v.c.s0.h7.u0.l f;
    private BleViewModel g;
    private j1 h;
    private SparseArray i;
    private List j;
    private TemplatePOJO k;
    private d.v.c.z1.e l;
    private d.v.c.d1.h m;
    private d n;
    private d.v.c.d1.f o;

    private void A() {
        String string2 = this.d.n0();
        this.l.b(string2);
    }

    private /* synthetic */ void B(Boolean object) {
        if (object == null) {
            return;
        }
        object = this.c;
        int n10 = ((StoryReviewViewModel)object).v() ^ 1;
        this.h0(n10 != 0);
        ViewModel viewModel = this.m;
        boolean bl2 = ((d.v.c.d1.h)viewModel).n();
        if (bl2 && n10 != 0) {
            n10 = this.m.m();
            viewModel = this.d;
            object = this.m.i(n10);
            if ((n10 = (int)(((TemplateEditViewModel)viewModel).r((e)object, false) ? 1 : 0)) != 0) {
                this.d.z0();
                object = this.d;
                ((TemplateEditViewModel)object).D0();
                this.w();
            }
        }
    }

    private /* synthetic */ void D(WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo) {
        Object object;
        if (waterMarkBean$WaterMarkDataInfo == null) {
            return;
        }
        Object object2 = this.c.o();
        if (object2 == (object = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW)) {
            object2 = this.d;
            object = waterMarkBean$WaterMarkDataInfo.getPath();
            boolean bl2 = waterMarkBean$WaterMarkDataInfo.isDefault();
            ((TemplateEditViewModel)object2).P0((String)object, bl2);
            this.A();
        }
    }

    private /* synthetic */ void F(Integer object) {
        if (object == null) {
            return;
        }
        ViewModel viewModel = this.d;
        boolean bl2 = ((TemplateEditViewModel)viewModel).t0();
        if (!bl2) {
            this.m.l().setValue(object);
            return;
        }
        viewModel = this.m;
        int n10 = (Integer)object;
        viewModel = this.d;
        object = ((d.v.c.d1.h)viewModel).i(n10);
        if ((n10 = (int)(((TemplateEditViewModel)viewModel).r((e)object, false) ? 1 : 0)) != 0) {
            this.d.z0();
            object = this.d;
            ((TemplateEditViewModel)object).D0();
            this.w();
        }
    }

    private /* synthetic */ void H(Integer n10) {
        if (n10 == null) {
            return;
        }
        RecyclerView recyclerView = this.b.o.c;
        c c10 = new c(this, n10);
        recyclerView.post(c10);
    }

    private /* synthetic */ void J(List list) {
        list = this.m.b(list);
        this.m.w(list, true);
    }

    private /* synthetic */ void L(List list) {
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus;
        Object object = this.c.o();
        if (object == (storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW)) {
            object = this.o;
            ((d.v.f.d.b)object).m(list);
        }
    }

    private /* synthetic */ void N(Integer n10) {
        TemplateEditViewModel templateEditViewModel = this.d;
        int n11 = templateEditViewModel.r0();
        if (n11 != 0) {
            int n12 = n10;
            if (!n12) {
                n12 = 1;
                this.i0(n12 != 0, 0);
            }
        } else {
            int n13;
            templateEditViewModel = this.i;
            StoryReviewViewModel storyReviewViewModel = this.c;
            int n14 = storyReviewViewModel.r();
            n11 = templateEditViewModel.indexOfKey(n14);
            if (n11 == (n13 = n10.intValue())) {
                this.i0(false, n11);
            }
        }
    }

    private /* synthetic */ void P(Float f10) {
        StoryReviewViewModel storyReviewViewModel = this.c;
        int n10 = (int)(f10.floatValue() * 100.0f);
        storyReviewViewModel.Q(n10);
    }

    private /* synthetic */ void R(Integer n10) {
        StoryProgressBar storyProgressBar = this.b.p;
        int n11 = n10;
        storyProgressBar.q(n11, false);
    }

    private /* synthetic */ void T(String string2) {
        boolean bl2 = s1.q(string2);
        if (bl2) {
            Object object = new Object[]{string2};
            Object object2 = "\u5408\u6210\u5730\u5740:%s";
            a.b((String)object2, (Object[])object);
            object = this.f;
            bl2 = ((d.v.c.s0.h7.u0.l)object).r();
            if (bl2) {
                object = this.requireContext();
                object2 = s1.H(string2);
                a2.f((Context)object, (String)object2);
                object = c1.b().c();
                object2 = new j(this, string2);
                object.execute((Runnable)object2);
            } else {
                this.e.e();
                object = this.requireContext();
                object2 = s1.H(string2);
                a2.f((Context)object, (String)object2);
                PublishActivity.l(this, string2);
            }
        }
    }

    private /* synthetic */ void V(Integer object) {
        int n10 = (Integer)object;
        if (n10 == 0) {
            object = this.h;
            ((j1)object).c();
        } else {
            this.h.b.setValue(object);
            object = this.h.c;
            Object object2 = this.getResources();
            int n11 = 2131952582;
            object2 = d.v.f.i.g.o(object2, n11);
            ((MutableLiveData)object).setValue(object2);
            object = this.h.d;
            object2 = "";
            ((MutableLiveData)object).setValue(object2);
        }
    }

    private /* synthetic */ void X(Boolean bl2) {
        this.b.r.performClick();
    }

    private /* synthetic */ void Z(StoryReviewViewModel$ReviewStatus object) {
        int n10;
        int n11;
        Object object2 = StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW;
        if (object == object2) {
            object2 = this.b.t;
            n11 = 2131099772;
            n10 = d.v.f.i.g.e(this, n11);
            object2.setTextColor(n10);
            object2 = this.b.r;
            n11 = d.v.f.i.g.e(this, n11);
            object2.setTextColor(n11);
        } else {
            object2 = this.b.t;
            n11 = 2131100000;
            n10 = d.v.f.i.g.e(this, n11);
            object2.setTextColor(n10);
            object2 = this.b.r;
            n11 = d.v.f.i.g.e(this, n11);
            object2.setTextColor(n11);
        }
        object2 = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW;
        if (object == object2) {
            boolean bl2;
            boolean bl3;
            object = this.n;
            if (object != null && (bl3 = d.v.j.b.f((List)(object = ((d.v.f.d.b)object).d())))) {
                object = this.n;
                object2 = this.l;
                String string2 = this.c.k();
                object2 = ((d.v.c.z1.e)object2).c(string2);
                ((d.v.f.d.b)object).l((List)object2);
            }
            this.A();
            object = this.o;
            if (object != null && (bl3 = d.v.j.b.f((List)(object = ((d.v.f.d.b)object).d()))) && (object = this.m.k()) != null && !(bl2 = object.isEmpty())) {
                object2 = this.o;
                ((d.v.f.d.b)object2).m((List)object);
            }
            object2 = this.b.o.g;
            n11 = this.j.size();
            n10 = -1;
            int[] nArray = this.e.r();
            object = this.e;
            long[] lArray = ((m0)object).p();
            ((StoryProgressBar)object2).o(n11, n10, false, nArray, lArray);
        }
    }

    private /* synthetic */ void b0(Integer n10) {
        RecyclerView recyclerView = this.b.o.c;
        int n11 = n10;
        recyclerView.smoothScrollToPosition(n11);
    }

    private /* synthetic */ void d0(String object) {
        this.f.i = object;
        object = this.e;
        CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_SAVE;
        ((m0)object).g0(cameraSet$StoryState);
    }

    private /* synthetic */ void f0(TemplatePOJO templatePOJO) {
        if (templatePOJO != null) {
            this.v();
            this.y();
            this.x();
        }
    }

    private void h0(boolean bl2) {
        int n10;
        if (bl2) {
            n10 = 0;
            Object var3_3 = null;
        } else {
            StoryReviewViewModel storyReviewViewModel = this.c;
            n10 = storyReviewViewModel.r();
            SparseArray sparseArray = this.i;
            if (sparseArray == null) {
                return;
            }
            if ((n10 = sparseArray.indexOfKey(n10)) < 0) {
                return;
            }
        }
        this.i0(bl2, n10);
    }

    private void i0(boolean bl2, int n10) {
        this.c.Q(0);
        this.d.F0(n10);
        this.d.H0(bl2);
        this.d.z0();
    }

    public static /* synthetic */ TemplateEditViewModel j(y y10) {
        return y10.d;
    }

    /*
     * WARNING - void declaration
     */
    private void j0() {
        void var2_5;
        Object object = this.j;
        int n10 = object.size();
        Object object2 = this.i;
        int n11 = object2.size();
        int n12 = 1;
        if (n10 == n11) {
            int n13 = n12;
        } else {
            boolean bl2 = false;
            object = null;
        }
        this.c.J((boolean)var2_5);
        object2 = this.c.o();
        Object object3 = this.c;
        boolean bl3 = ((StoryReviewViewModel)object3).v();
        if (bl3) {
            object3 = this.c;
            boolean bl4 = var2_5 ^ n12;
            ((StoryReviewViewModel)object3).K(bl4);
        } else {
            object = this.c;
            object3 = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW;
            ((StoryReviewViewModel)object).M((StoryReviewViewModel$ReviewStatus)((Object)object3));
        }
        object = this.c;
        boolean bl5 = ((StoryReviewViewModel)object).g();
        if (bl5) {
            object = this.c;
            int n14 = -1;
            ((StoryReviewViewModel)object).L(n14);
            object = StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW;
            if (object2 == object) {
                this.l0();
                this.h0(n12 != 0);
            } else {
                object = StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW;
                if (object2 == object) {
                    this.b.o.f.b();
                    object = this.d;
                    object2 = this.b.o.f.getPlayerView();
                    ((TemplateEditViewModel)object).w((d.v.v.g.g)((Object)object2));
                    object = this.d;
                    long l10 = ((TemplateEditViewModel)object).K();
                    ((TemplateEditViewModel)object).G0(l10);
                    object = this.d;
                    ((TemplateEditViewModel)object).z0();
                }
            }
        } else {
            this.k0();
        }
    }

    public static /* synthetic */ StoryReviewViewModel k(y y10) {
        return y10.c;
    }

    private void k0() {
        StoryReviewViewModel storyReviewViewModel = this.c;
        SparseArray sparseArray = this.i;
        List list = this.j;
        int n10 = storyReviewViewModel.l(sparseArray, list);
        this.m0(n10);
    }

    public static /* synthetic */ SparseArray l(y y10) {
        return y10.i;
    }

    private void l0() {
        this.d.z();
        this.b.m.b();
        this.b.l.b();
        this.b.o.f.b();
        this.y();
    }

    public static /* synthetic */ m0 m(y y10) {
        return y10.e;
    }

    private void m0(int n10) {
        this.e.c0(n10);
        m0 m02 = this.e;
        CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_RECORD;
        m02.g0(cameraSet$StoryState);
    }

    public static /* synthetic */ void n(y y10, boolean bl2, int n10) {
        y10.i0(bl2, n10);
    }

    public static /* synthetic */ void o(y y10) {
        y10.l0();
    }

    public static /* synthetic */ void p(y y10, int n10) {
        y10.m0(n10);
    }

    public static /* synthetic */ void q(y y10) {
        y10.j0();
    }

    public static /* synthetic */ d.v.c.s0.h7.u0.l r(y y10) {
        return y10.f;
    }

    public static /* synthetic */ n9 s(y y10) {
        return y10.b;
    }

    private PlayerWrapperView t() {
        Object object = y$a.a;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus = this.c.o();
        int n10 = storyReviewViewModel$ReviewStatus.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n11 = 0;
                    object = null;
                } else {
                    object = (Object)this.b.o.f;
                }
            } else {
                object = (Object)this.b.m;
            }
        } else {
            object = (Object)this.b.l;
        }
        return object;
    }

    public static y u() {
        y y10 = new y();
        return y10;
    }

    private void v() {
        boolean bl2;
        Object object = this.e.o();
        this.k = object;
        this.j = object = ((TemplatePOJO)object).getTemplateVideoList();
        object = this.e.G();
        this.i = object;
        object = this.c;
        Object object2 = this.e;
        int bl22 = ((m0)object2).j();
        ((StoryReviewViewModel)object).L(bl22);
        object = this.c;
        boolean bl3 = true;
        ((StoryReviewViewModel)object).K(bl3);
        object = this.j;
        int n10 = object.size();
        SparseArray sparseArray = this.i;
        int n11 = sparseArray.size();
        if (n10 != n11) {
            bl2 = false;
            object2 = null;
        }
        this.c.J(bl2);
        object2 = this.b.p;
        n11 = this.j.size();
        int n12 = this.c.r();
        int[] nArray = this.e.r();
        long[] lArray = this.e.p();
        ((StoryProgressBar)object2).o(n11, n12, false, nArray, lArray);
        this.z();
    }

    private void w() {
        e e10 = this.d.N();
        this.m.e(e10);
    }

    private void x() {
        Object object = this.d.T();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new g(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.d.I();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new k(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.d.a0();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new r(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.c.p();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new s(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.c.i();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.c.j();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new o(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.g.m;
        lifecycleOwner = this.getViewLifecycleOwner();
        q q10 = new q(this);
        observer = new d.v.e.i.f(q10);
        ((StackLiveData)object).observe(lifecycleOwner, observer);
        object = this.c.n();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new n(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.l.e();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new p(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.m.f();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new m(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.m.l();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new l(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.c;
        boolean bl2 = ((StoryReviewViewModel)object).g();
        if (bl2) {
            object = this.m.u();
            lifecycleOwner = this.getViewLifecycleOwner();
            observer = new h(this);
            ((LiveData)object).observe(lifecycleOwner, observer);
        }
        object = this.m.j();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
    }

    private void y() {
        StoryReviewViewModel storyReviewViewModel = this.c;
        boolean bl2 = storyReviewViewModel.v();
        int n10 = 1;
        Object object = this.d;
        Object object2 = this.k;
        ((TemplateEditViewModel)object).q0((TemplatePOJO)object2, false, bl2 ^= n10);
        object = this.d;
        object2 = this.c;
        Object object3 = this.i;
        object2 = ((StoryReviewViewModel)object2).s((SparseArray)object3);
        object = ((TemplateEditViewModel)object).l0((String[])object2);
        boolean bl3 = object.isEmpty();
        if (bl3) {
            return;
        }
        object2 = this.t();
        ((PlayerWrapperView)((Object)object2)).a();
        object3 = this.d;
        String string2 = this.c.k();
        ((TemplateEditViewModel)object3).F(string2);
        this.d.M0(n10);
        this.d.o0((PlayerWrapperView)((Object)object2), (List)object);
        this.e();
        this.d.w0(bl2);
    }

    private void z() {
        Object object = d.v.i0.b.a(this);
        Object object2 = (d.v.c.z1.e)((ViewModelProvider)object).get(d.v.c.z1.e.class);
        this.l = object2;
        Object object3 = new d((LifecycleOwner)this, (d.v.c.z1.e)object2);
        this.n = object3;
        object2 = this.b.o.d;
        Context context = this.requireContext();
        object3 = new LinearLayoutManager(context, 0, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object3);
        object2 = this.b.o.d;
        float f10 = 4.0f;
        int n10 = h2.b(f10);
        object3 = new d.v.c.k1.a.s(n10, 0, 0);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object3);
        object2 = this.b.o.d;
        object3 = this.n;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object3);
        this.m = object = (d.v.c.d1.h)((ViewModelProvider)object).get(d.v.c.d1.h.class);
        this.o = object2 = new d.v.c.d1.f((LifecycleOwner)this, (d.v.c.d1.h)object, false);
        object = this.b.o.c;
        object3 = this.requireContext();
        object2 = new LinearLayoutManager((Context)object3, 0, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.b.o.c;
        int n11 = h2.b(f10);
        object2 = new d.v.c.k1.a.s(n11, 0, 0);
        ((RecyclerView)object).addItemDecoration((RecyclerView$ItemDecoration)object2);
        object = this.b.o.c;
        object2 = this.o;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void E(WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo) {
        this.D(waterMarkBean$WaterMarkDataInfo);
    }

    public /* synthetic */ void G(Integer n10) {
        this.F(n10);
    }

    public /* synthetic */ void I(Integer n10) {
        this.H(n10);
    }

    public /* synthetic */ void K(List list) {
        this.J(list);
    }

    public /* synthetic */ void M(List list) {
        this.L(list);
    }

    public /* synthetic */ void O(Integer n10) {
        this.N(n10);
    }

    public /* synthetic */ void Q(Float f10) {
        this.P(f10);
    }

    public /* synthetic */ void S(Integer n10) {
        this.R(n10);
    }

    public /* synthetic */ void U(String string2) {
        this.T(string2);
    }

    public /* synthetic */ void W(Integer n10) {
        this.V(n10);
    }

    public /* synthetic */ void Y(Boolean bl2) {
        this.X(bl2);
    }

    public /* synthetic */ void a0(StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus) {
        this.Z(storyReviewViewModel$ReviewStatus);
    }

    public /* synthetic */ void c0(Integer n10) {
        this.b0(n10);
    }

    public void e() {
        Object object = this.d;
        int n10 = d.v.f.i.g.c(this.requireContext(), 2131099762);
        ((TemplateEditViewModel)object).L0(n10);
        object = this.b.q.getPaint();
        n10 = d.v.f.i.g.c(this.requireContext(), 2131099964);
        object.setShadowLayer(3.0f, 0.0f, 0.0f, n10);
        object = this.n;
        int n11 = 80;
        Size size = new Size(n11, n11);
        int n12 = 10;
        int n13 = 2131232224;
        int n14 = 2131232227;
        ((d)object).o(size, n12, n13, n14);
        object = this.o;
        size = new Size(n11, n11);
        ((d.v.c.d1.f)object).o(size, n12, n13, n14);
    }

    public /* synthetic */ void e0(String string2) {
        this.d0(string2);
    }

    public /* synthetic */ void g0(TemplatePOJO templatePOJO) {
        this.f0(templatePOJO);
    }

    public int h() {
        return 2131558607;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (n9)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new y$b(this);
        ((n9)viewDataBinding).C((y$b)object);
        viewDataBinding = this.b;
        object = this.c;
        ((n9)viewDataBinding).F((StoryReviewViewModel)object);
        viewDataBinding = this.b.o;
        object = this.c;
        ((ai)viewDataBinding).G((StoryReviewViewModel)object);
        viewDataBinding = this.b;
        object = this.d;
        ((n9)viewDataBinding).E((TemplateEditViewModel)object);
        viewDataBinding = this.b;
        object = this.h;
        ((n9)viewDataBinding).D((j1)object);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        int n12 = 1;
        if (n10 == n12) {
            Object object;
            n10 = -1;
            if (n11 == n10) {
                n10 = 2131952773;
                object = d.v.f.i.g.s(this, n10);
                n2.e((String)object);
            } else if (n11 == 0) {
                object = this.requireContext();
                n11 = 2131952765;
                object = d.v.f.i.g.m(object, n11);
                n2.e((String)object);
            }
            object = this.e;
            if (object != null) {
                CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
                object.g0(cameraSet$StoryState);
            }
        }
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        ViewModelProvider viewModelProvider = d.v.i0.b.a(this);
        this.e = viewModel = (m0)((ViewModelProvider)object).get(m0.class);
        viewModel = (d.v.c.s0.h7.u0.l)((ViewModelProvider)object).get(d.v.c.s0.h7.u0.l.class);
        this.f = viewModel;
        viewModel = (j1)((ViewModelProvider)object).get(j1.class);
        this.h = viewModel;
        this.g = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.d = object = (TemplateEditViewModel)viewModelProvider.get(TemplateEditViewModel.class);
        this.c = object = (StoryReviewViewModel)viewModelProvider.get(StoryReviewViewModel.class);
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.m.b();
        this.b.l.b();
        this.b.o.f.b();
    }

    public void onPause() {
        super.onPause();
        this.d.y0();
    }

    public void onResume() {
        super.onResume();
        this.d.z0();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        this.b.c.setClipToOutline(true);
        object = this.e.n();
        object2 = this.getViewLifecycleOwner();
        b b10 = new b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, b10);
    }
}

