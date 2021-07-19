/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.PopupWindow$OnDismissListener
 */
package com.zhiyun.cama.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import com.zhiyun.cama.main.EditorMainActivity$a;
import com.zhiyun.cama.main.EditorMainActivity$b;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.i1.d;
import d.v.c.i1.e;
import d.v.c.i1.f;
import d.v.c.i1.g;
import d.v.c.i1.h;
import d.v.c.i1.i;
import d.v.c.i1.i2;
import d.v.c.i1.j;
import d.v.c.i1.k2;
import d.v.c.i1.l;
import d.v.c.i1.m;
import d.v.c.q0.c;
import d.v.c.w0.k;
import d.v.c.w0.ui;
import d.v.e.l.h2;
import d.v.e.l.s1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.n$a;
import d.v.i0.b;
import d.v.j.e.i.f1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.a.a;

public class EditorMainActivity
extends d.v.c.q0.a {
    public static final String e = "media_list";
    public static final String f = "draft_id";
    private k b;
    private d.v.c.b1.t.g c;
    private NavController$OnDestinationChangedListener d;

    private /* synthetic */ void A(DialogFragment dialogFragment) {
        boolean bl2 = this.n(2);
        if (bl2) {
            bl2 = true;
            this.N(bl2);
        }
    }

    private /* synthetic */ void C(DialogFragment dialogFragment) {
        this.N(false);
    }

    private /* synthetic */ void E(boolean bl2, Boolean object) {
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.c;
            ((i2)object).x2((int)((bl2 ^= true) ? 1 : 0));
            ActivityCompat.finishAfterTransition(this);
        }
    }

    private /* synthetic */ void G() {
        int n10 = this.b.e.getHeight();
        int n11 = h2.b(44.0f);
        n$a n$a = new n$a();
        Object object = this.b.d;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m((Context)this, 2131952057);
        n$a = n$a.k((String)object).d(2132017750).h(49).g(2).m(0).n(n10 += n11).e(0.5f);
        object = new f(this, n10);
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    public static /* synthetic */ void I() {
        k2.e().l(true);
    }

    private void J() {
        Object object = this.c;
        boolean bl2 = ((i2)object).A0();
        if (bl2) {
            bl2 = this.n(2);
            if (bl2) {
                bl2 = true;
                this.N(bl2);
            }
            return;
        }
        object = new k$b((Context)this);
        object = (k$b)((k$a)object).A(2131952089);
        d.v.f.f.a a10 = new i(this);
        object = (k$b)((k$a)object).v(2131952143, a10);
        a10 = new e(this);
        object = (k$b)((k$a)object).o(2131952142, a10);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        ((k$a)object).D(fragmentManager);
    }

    private void L() {
        Intent intent = new Intent((Context)this, PublishActivity.class);
        intent.putExtra("publish_from_type", 3);
        this.startActivity(intent);
    }

    private void M() {
        Object object = this.d;
        if (object == null) {
            return;
        }
        int n10 = 2131362356;
        Object object2 = this.findViewById(n10);
        if (object2 != null) {
            object = Navigation.findNavController(this, n10);
            object2 = this.d;
            ((NavController)object).removeOnDestinationChangedListener((NavController$OnDestinationChangedListener)object2);
        }
    }

    private void O() {
        Object object = k2.e();
        boolean bl2 = ((k2)object).d();
        if (bl2) {
            return;
        }
        object = new n$a();
        Object object2 = this.b.b;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.m((Context)this, 2131952056);
        object = ((n$a)object).k((String)object2).d(2132017752).h(0x800033).g(0);
        int n10 = h2.b(20.0f);
        object = ((n$a)object).m(n10);
        n10 = h2.b(44.0f);
        object = ((n$a)object).n(n10);
        n10 = h2.b(12.0f);
        object = ((n$a)object).f(n10);
        object2 = new h(this);
        ((n$a)object).j((PopupWindow.OnDismissListener)object2).o();
    }

    private void P() {
        FrameLayout frameLayout = this.b.d;
        l l10 = new l(this);
        frameLayout.post((Runnable)l10);
    }

    private void Q(int n10) {
        Object object = new n$a();
        Object object2 = this.b.d;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.m((Context)this, 2131952058);
        object = ((n$a)object).k((String)object2).d(2132017752).h(49).g(0).m(0);
        int n11 = h2.b(40.0f);
        n$a n$a = ((n$a)object).n(n10 += n11).e(0.5f);
        object = d.v.c.i1.k.a;
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    private void R() {
        n$a n$a = new n$a();
        Object object = this.b.a;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m((Context)this, 2131952059);
        n$a = n$a.k((String)object).d(2132017752).h(8388661).g(0).b(1);
        int n10 = h2.b(20.0f);
        n$a = n$a.m(n10);
        n10 = h2.b(44.0f);
        n$a = n$a.n(n10);
        n10 = h2.b(12.0f);
        n$a = n$a.f(n10);
        object = new d.v.c.i1.a(this);
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    public static void S(Activity activity, long l10) {
        Intent intent = new Intent((Context)activity, EditorMainActivity.class);
        intent.putExtra(f, l10);
        activity.startActivity(intent);
    }

    public static void T(Activity activity, ArrayList arrayList) {
        Intent intent = new Intent((Context)activity, EditorMainActivity.class);
        intent.putParcelableArrayListExtra(e, arrayList);
        activity.startActivity(intent);
    }

    private void U() {
        int n10 = this.getRequestedOrientation();
        int n11 = 1;
        int n12 = 6;
        if (n10 == n12) {
            this.setRequestedOrientation(n11);
            MutableLiveData mutableLiveData = this.c.z1();
            Boolean bl2 = Boolean.FALSE;
            d.v.e.i.h.g(mutableLiveData, bl2);
        } else {
            n10 = this.getRequestedOrientation();
            if (n10 == n11) {
                this.setRequestedOrientation(n12);
                MutableLiveData mutableLiveData = this.c.z1();
                Boolean bl3 = Boolean.TRUE;
                d.v.e.i.h.g(mutableLiveData, bl3);
                this.M();
            }
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g i(EditorMainActivity editorMainActivity) {
        return editorMainActivity.c;
    }

    public static /* synthetic */ void j(EditorMainActivity editorMainActivity) {
        editorMainActivity.U();
    }

    public static /* synthetic */ void k(EditorMainActivity editorMainActivity) {
        editorMainActivity.J();
    }

    public static /* synthetic */ boolean l(EditorMainActivity editorMainActivity, int n10) {
        return editorMainActivity.n(n10);
    }

    public static /* synthetic */ void m(EditorMainActivity editorMainActivity) {
        editorMainActivity.L();
    }

    private boolean n(int n10) {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(2131362356);
        boolean bl2 = true;
        if (fragment == null) {
            return bl2;
        }
        boolean bl3 = (fragment = fragment.getChildFragmentManager().getPrimaryNavigationFragment()) instanceof c;
        if (bl3) {
            return ((c)fragment).s(n10);
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private void o() {
        Object object = this.c;
        boolean n10 = ((i2)object).l2();
        if (n10) {
            object = this.c;
            d.v.v.g.g g10 = this.b.i.getPlayerView();
            ((i2)object).W(g10);
            object = this.c;
            long l10 = ((i2)object).U0();
            ((i2)object).a3(l10);
            object = this.b;
            g10 = ((k)object).a;
            if (g10 == null) {
                object = ((k)object).n;
                g10 = ((ui)object).a;
            }
            if (g10 != null) {
                void var2_6;
                object = this.c;
                boolean bl2 = ((i2)object).A1();
                if (bl2) {
                    int n11 = 8;
                } else {
                    boolean bl3 = false;
                    object = null;
                }
                g10.setVisibility((int)var2_6);
            }
            return;
        }
        object = this.getIntent();
        if (object != null) {
            Object object2 = object.getParcelableArrayListExtra(e);
            String string2 = f;
            long l11 = object.getLongExtra(string2, 0L);
            if (object2 != null) {
                object = this.c;
                PlayerWrapperView playerWrapperView = this.b.i;
                ((d.v.c.b1.t.g)object).k2(playerWrapperView, (List)object2);
            } else {
                object = ((f1)d.v.i0.b.c(this).get(f1.class)).j(l11);
                object2 = new g(this, l11);
                ((LiveData)object).observe(this, (Observer)object2);
            }
        }
    }

    private void p() {
        Object object;
        Object object2 = this.d;
        if (object2 == null) {
            object2 = new d(this);
            this.d = object2;
        }
        object2 = this.getResources().getConfiguration();
        int n10 = ((Configuration)object2).orientation;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 2131362356;
            object2 = Navigation.findNavController(this, n10);
            object = this.d;
            ((NavController)object2).addOnDestinationChangedListener((NavController$OnDestinationChangedListener)object);
        }
        object2 = this.getOnBackPressedDispatcher();
        object = new EditorMainActivity$a(this, n11 != 0);
        ((OnBackPressedDispatcher)object2).addCallback(this, (OnBackPressedCallback)object);
        object2 = this.c.V1();
        m m10 = new m(this);
        ((d.v.e.i.j)object2).observe(this, m10);
    }

    public static /* synthetic */ void q(EditorMainActivity editorMainActivity) {
        editorMainActivity.P();
    }

    public static /* synthetic */ void r(EditorMainActivity editorMainActivity) {
        editorMainActivity.R();
    }

    private /* synthetic */ void s(long l10, TemplatePOJO object) {
        int n10;
        int n11;
        block3: {
            boolean bl2;
            n11 = 1;
            if (object == null) {
                object = new Object[n11];
                Long l11 = l10;
                object[0] = l11;
                a.e("\u5f53\u524d\u8349\u7a3f\u4e0d\u5b58\u5728\u6216\u8005\u88ab\u5220\u9664,id=%d", object);
                return;
            }
            Iterator iterator2 = object.getTemplateVideoList().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = (TemplateVideo)iterator2.next();
                boolean bl3 = ((TemplateVideo)object2).isReverse();
                object2 = bl3 ? ((TemplateVideo)object2).getReversePath() : ((TemplateVideo)object2).getVideoPath();
                bl2 = s1.q((String)object2);
                if (!bl2) continue;
                n10 = n11;
                break block3;
            }
            n10 = 0;
            iterator2 = null;
        }
        if (n10 == 0) {
            object = new Object[n11];
            Long l12 = l10;
            object[0] = l12;
            a.e("\u8349\u7a3f\u6240\u6709\u89c6\u9891\u8d44\u6e90\u90fd\u4e0d\u5b58\u5728,id=%d", object);
            ActivityCompat.finishAfterTransition(this);
            return;
        }
        this.c.j2((TemplatePOJO)object);
        d.v.c.b1.t.g g10 = this.c;
        PlayerWrapperView playerWrapperView = this.b.i;
        object = g10.g2((TemplatePOJO)object);
        g10.k2(playerWrapperView, (List)object);
    }

    private /* synthetic */ void u(NavController object, NavDestination navDestination, Bundle object2) {
        int n10;
        d.v.c.b1.t.g g10;
        int n11;
        int n12 = navDestination.getId();
        int n13 = 1;
        int n14 = 2131362338;
        if (n12 != n14 && (n12 = navDestination.getId()) != (n14 = 2131362343) && (n12 = navDestination.getId()) != (n14 = 2131362336) && (n12 = navDestination.getId()) != (n14 = 2131362344)) {
            n12 = navDestination.getId();
            if (n12 != (n14 = 2131362331) && (n12 = navDestination.getId()) != (n14 = 2131362334)) {
                n12 = 0;
                object = null;
            } else {
                n12 = n13;
            }
        } else {
            n12 = 2;
        }
        n14 = navDestination.getId();
        int n15 = 2131362333;
        if (n14 != n15 && (n14 = navDestination.getId()) != (n11 = 2131362337)) {
            n14 = 0;
            g10 = null;
        } else {
            n14 = n13;
        }
        n11 = navDestination.getId();
        int n16 = 2131362330;
        n15 = n11 != n16 && (n11 = navDestination.getId()) != (n10 = 2131362332) && (n11 = navDestination.getId()) != n15 ? 0 : n13;
        d.v.c.b1.t.g g11 = this.c;
        g11.y2(n12, n14 != 0, n15 != 0);
        g10 = this.c;
        if (n12 == 0) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        g10.L3(n12 != 0);
        this.c.A2();
        object = this.c.g1();
        n14 = navDestination.getId();
        if (n14 != n16) {
            n13 = 0;
            object2 = null;
        }
        object2 = n13 != 0;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        n12 = navDestination.getId();
        if (n12 == n16) {
            object = this.c;
            ((i2)object).I();
            this.O();
        }
    }

    private /* synthetic */ void w(Long l10) {
        d.v.c.b1.t.g g10 = this.c;
        long l11 = l10;
        g10.z3(l11);
    }

    private /* synthetic */ void y(int n10) {
        this.Q(n10);
    }

    public /* synthetic */ void B(DialogFragment dialogFragment) {
        this.A(dialogFragment);
    }

    public /* synthetic */ void D(DialogFragment dialogFragment) {
        this.C(dialogFragment);
    }

    public /* synthetic */ void F(boolean bl2, Boolean bl3) {
        this.E(bl2, bl3);
    }

    public /* synthetic */ void H() {
        this.G();
    }

    public void K() {
        d.v.c.b1.t.g g10 = this.c;
        boolean bl2 = g10.F();
        if (!bl2) {
            return;
        }
        this.L();
    }

    public void N(boolean bl2) {
        j j10 = new j(this, bl2);
        this.c.A3(0x40000000L, j10);
    }

    public int d() {
        return 2131558435;
    }

    public void f(ViewDataBinding viewDataBinding, Bundle object) {
        super.f(viewDataBinding, (Bundle)object);
        viewDataBinding = (k)viewDataBinding;
        this.b = viewDataBinding;
        object = this.c;
        ((k)viewDataBinding).B((i2)object);
        viewDataBinding = this.b;
        object = new EditorMainActivity$b(this);
        ((k)viewDataBinding).A((EditorMainActivity$b)object);
        this.o();
        this.p();
    }

    public void h() {
        d.v.c.b1.t.g g10;
        super.h();
        this.c = g10 = (d.v.c.b1.t.g)d.v.i0.b.c(this).get(d.v.c.b1.t.g.class);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) != 0) {
            this.K();
        }
    }

    public void onNewIntent(Intent object) {
        int n10;
        super.onNewIntent((Intent)object);
        Object object2 = e;
        object = object.getParcelableArrayListExtra((String)object2);
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (d.v.h.e.a)object.next();
                d.v.c.b1.t.g g10 = this.c;
                boolean bl2 = TemplateUseCase.w;
                g10.r((d.v.h.e.a)object2, bl2);
            }
            object = this.c;
            long l10 = 512L;
            ((i2)object).b3(l10);
        }
    }

    public void onPause() {
        super.onPause();
        this.c.A2();
    }

    public /* synthetic */ void t(long l10, TemplatePOJO templatePOJO) {
        this.s(l10, templatePOJO);
    }

    public /* synthetic */ void v(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.u(navController, navDestination, bundle);
    }

    public /* synthetic */ void x(Long l10) {
        this.w(l10);
    }

    public /* synthetic */ void z(int n10) {
        this.y(n10);
    }
}

