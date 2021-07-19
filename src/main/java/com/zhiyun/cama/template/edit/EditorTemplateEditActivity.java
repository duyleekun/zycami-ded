/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.ViewStub
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.edit;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.meicam.sdk.NvsVideoClip;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$a;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$b;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$c;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$d;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$e;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.MediaConstrainLayout;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.common.util.Windows;
import com.zhiyun.common.widget.RotateTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.d1.e;
import d.v.c.i1.k2;
import d.v.c.k1.a.s;
import d.v.c.q0.c;
import d.v.c.u1.k;
import d.v.c.u1.m.a0;
import d.v.c.u1.m.b0;
import d.v.c.u1.m.c0;
import d.v.c.u1.m.c1;
import d.v.c.u1.m.d0;
import d.v.c.u1.m.d1;
import d.v.c.u1.m.e0;
import d.v.c.u1.m.f0;
import d.v.c.u1.m.t;
import d.v.c.u1.m.u;
import d.v.c.u1.m.w;
import d.v.c.u1.m.x;
import d.v.c.u1.m.y;
import d.v.c.u1.m.z;
import d.v.c.w0.gi;
import d.v.c.w0.ii;
import d.v.c.w0.p;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.g0.n$a;
import d.v.h.e.a;
import d.v.h.e.d;
import d.v.i0.b;
import d.v.j.e.i.f1;
import d.v.v.q.h;
import java.util.ArrayList;
import java.util.List;

public class EditorTemplateEditActivity
extends d.v.c.q0.a
implements c1 {
    public static final int l = 0;
    public static final int m = 1;
    public static final String n = "deleted_position";
    public static final String o = "chooseMediaList";
    public static final String p = "templateMediaArray";
    public static final String q = "templateDataID";
    private final s b;
    private final s c;
    private p d;
    private ii e;
    private gi f;
    private f1 g;
    private TemplateEditViewModel h;
    private k i;
    private d1 j;
    private int k;

    public EditorTemplateEditActivity() {
        s s10;
        float f10 = 7.0f;
        int n10 = h2.b(f10);
        float f11 = 20.0f;
        int n11 = h2.b(f11);
        int n12 = h2.b(76.0f);
        this.b = s10 = new s(n10, n11, n12);
        int n13 = h2.b(f10);
        n10 = h2.b(f11);
        int n14 = h2.b(f11);
        this.c = s10 = new s(n13, n10, n14);
    }

    private /* synthetic */ void B(Integer object) {
        int n10;
        TextView textView = this.d.l.c;
        Object object2 = this.getResources();
        int n11 = (Integer)object;
        n11 = n11 == (n10 = 1) ? 2131951877 : 2131952612;
        object2 = d.v.f.i.g.o(object2, n11);
        textView.setText((CharSequence)object2);
        textView = this.d.l.b;
        int n12 = (Integer)object;
        if (n12 == n10) {
            object2 = this.getResources();
            n11 = 2131952106;
            object2 = d.v.f.i.g.o(object2, n11);
        } else {
            object2 = "";
        }
        textView.setText((CharSequence)object2);
        textView = this.d.l.a;
        n12 = (Integer)object;
        if (n12 == n10) {
            n12 = 8;
        } else {
            n12 = 0;
            object2 = null;
        }
        textView.setVisibility(n12);
        int n13 = (Integer)object;
        if (n13 == 0) {
            object = this.h;
            ((TemplateEditViewModel)object).Z0();
        }
    }

    private /* synthetic */ void D(Long l10) {
        TemplateEditViewModel templateEditViewModel = this.h;
        long l11 = l10;
        templateEditViewModel.G0(l11);
    }

    private /* synthetic */ void F(Integer n10) {
        RecyclerView recyclerView = this.d.i;
        int n11 = n10;
        recyclerView.scrollToPosition(n11);
    }

    private /* synthetic */ void H(Float f10) {
        TemplateEditViewModel templateEditViewModel = this.h;
        int n10 = templateEditViewModel.u0();
        if (n10 != 0) {
            f10 = Float.valueOf(0.0f);
        }
        templateEditViewModel = this.d.e;
        n10 = templateEditViewModel.getWidth();
        float f11 = 68.0f;
        int n11 = h2.b(f11);
        float f12 = n10 - n11;
        float f13 = f10.floatValue();
        f10 = this.d.m.animate().translationX(f12 *= f13);
        float f14 = f12 - 0.0f;
        n10 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
        long l10 = n10 == 0 ? 0L : (long)40;
        f10.setDuration(l10).start();
    }

    private /* synthetic */ void J(Boolean object) {
        if (object != null && (object = this.h.N()) != null) {
            TemplateEditViewModel templateEditViewModel = this.h;
            templateEditViewModel.r((e)object, false);
        }
    }

    public static /* synthetic */ void L(EditorTemplateEditActivity editorTemplateEditActivity) {
        editorTemplateEditActivity.U();
    }

    private /* synthetic */ void M(long l10, TemplatePOJO templatePOJO, List stringArray) {
        stringArray = d.v.j.g.b0.a((List)stringArray);
        this.q(l10, stringArray, templatePOJO);
    }

    private /* synthetic */ void O() {
        Object object = (RotateTextView)LayoutInflater.from((Context)this).inflate(2131558823, null).findViewById(2131363536);
        int n10 = 2131952097;
        Object object2 = d.v.f.i.g.m((Context)this, n10);
        object.setText((CharSequence)object2);
        object.measure(0, 0);
        float f10 = this.f.b.getX();
        float f11 = this.f.b.getWidth();
        float f12 = 2.0f;
        float f13 = (float)object.getMeasuredWidth() / f12;
        int n11 = Math.round((f10 += (f11 /= f12)) - f13);
        object2 = new n$a();
        TextView textView = this.f.b;
        object2 = ((n$a)object2).c((View)textView);
        Object object3 = d.v.f.i.g.m((Context)this, n10);
        object3 = ((n$a)object2).k((String)object3).d(2132017750).h(0x800033).g(2);
        object2 = new u(this);
        object = ((n$a)object3).j((PopupWindow.OnDismissListener)object2).m(n11);
        n10 = Windows.o((Context)this).getHeight();
        int n12 = h2.b(250.0f);
        ((n$a)object).n(n10 -= n12).e(0.5f).o();
    }

    public static /* synthetic */ void Q() {
        k2.e().o(true);
    }

    public static /* synthetic */ void R() {
        k2.e().i(true);
    }

    private void S(boolean bl2, int n10) {
        if (bl2) {
            int n11 = this.k;
            if (n11 == 0) {
                int n12;
                Intent fragmentActivity = new Intent();
                String string2 = n;
                fragmentActivity.putExtra(string2, n12);
                n12 = -1;
                this.setResult(n12, fragmentActivity);
            }
        } else {
            FragmentActivity fragmentActivity = d.v.e.b.i().c(EditorAddVideoActivity.class);
            d.v.e.b b10 = d.v.e.b.i();
            b10.e(fragmentActivity);
        }
        ActivityCompat.finishAfterTransition(this);
    }

    private void T() {
        k2 k22 = k2.e();
        boolean bl2 = k22.a();
        if (bl2) {
            return;
        }
        k22 = this.d.getRoot();
        e0 e02 = new e0(this);
        k22.post(e02);
    }

    private void U() {
        n$a n$a = new n$a();
        Object object = this.d.i;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m((Context)this, 2131952098);
        n$a = n$a.k((String)object).d(2132017750).h(0x800055).g(2);
        object = w.a;
        n$a = n$a.j((PopupWindow.OnDismissListener)object);
        int n10 = -h2.b(10.0f);
        n$a = n$a.m(n10);
        n10 = h2.b(68.0f);
        int n11 = Windows.h((Context)this);
        n$a.n(n10 += n11).e(0.9f).o();
    }

    private void V() {
        n$a n$a = new n$a();
        Object object = this.d.i;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m((Context)this, 2131952103);
        n$a = n$a.k((String)object).d(2132017750).h(0x800033).g(2);
        object = z.a;
        n$a = n$a.j((PopupWindow.OnDismissListener)object);
        int n10 = h2.b(20.0f);
        n$a = n$a.m(n10);
        n10 = Windows.o((Context)this).getHeight();
        int n11 = h2.b(120.0f);
        n$a.n(n10 -= n11).e(0.1f).o();
    }

    private void W() {
        Object object = k2.e();
        boolean bl2 = ((k2)object).h();
        if (bl2) {
            return;
        }
        object = new n$a();
        Object object2 = this.d.a;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.m((Context)this, 2131952107);
        object = ((n$a)object).k((String)object2).d(2132017750).h(81).g(2);
        object2 = new c0(this);
        object = ((n$a)object).j((PopupWindow.OnDismissListener)object2).m(0);
        int n10 = h2.b(140.0f);
        int n11 = Windows.h((Context)this);
        ((n$a)object).n(n10 += n11).e(0.5f).o();
    }

    public static void X(Fragment fragment, String[] stringArray, ArrayList arrayList, long l10) {
        FragmentActivity fragmentActivity = fragment.requireActivity();
        Intent intent = new Intent((Context)fragmentActivity, EditorTemplateEditActivity.class);
        intent.putExtra(p, stringArray);
        intent.putParcelableArrayListExtra(o, arrayList);
        intent.putExtra(q, l10);
        intent.putExtra("templateModeType", 1);
        fragment.startActivity(intent);
    }

    public static void Y(Fragment fragment, String[] stringArray, long l10) {
        FragmentActivity fragmentActivity = fragment.requireActivity();
        Intent intent = new Intent((Context)fragmentActivity, EditorTemplateEditActivity.class);
        intent.putExtra(p, stringArray);
        intent.putExtra(q, l10);
        intent.putExtra("templateModeType", 0);
        fragment.startActivityForResult(intent, 0);
    }

    private void Z(boolean bl2) {
        Object object;
        Object object2;
        Object object3;
        float f10;
        Object object4;
        float f11 = 0.0f;
        ViewPropertyAnimator viewPropertyAnimator = null;
        if (bl2) {
            object4 = this.d.a;
            int n10 = -object4.getHeight();
            f10 = n10;
        } else {
            boolean bl3 = false;
            object4 = null;
            f10 = 0.0f;
        }
        float f12 = 1.0f;
        if (bl2) {
            f11 = f12;
        }
        gi gi2 = this.f;
        ii ii2 = null;
        TextView textView = gi2 == null ? null : (object3 = gi2.b);
        if (gi2 == null && (object3 = this.e) == null) {
            object2 = null;
        } else {
            object3 = this.e;
            object3 = object3 != null ? object3.a : gi2.a;
            object2 = object3;
        }
        if (gi2 == null && (object3 = this.e) == null) {
            object = null;
        } else {
            object3 = this.e;
            object3 = object3 != null ? object3.c : gi2.d;
            object = object3;
        }
        if (gi2 != null || (object3 = this.e) != null) {
            ii2 = this.e;
            ii2 = ii2 != null ? ii2.b : gi2.c;
        }
        if (object2 == null) {
            return;
        }
        gi2 = object2.animate();
        ViewPropertyAnimator viewPropertyAnimator2 = gi2.alpha(f12 -= f11);
        long l10 = 300;
        viewPropertyAnimator2 = viewPropertyAnimator2.setDuration(l10);
        object3 = new EditorTemplateEditActivity$c(this, (ConstraintLayout)((Object)object2), (TextView)object, (TextView)ii2, textView);
        viewPropertyAnimator2.setListener((Animator.AnimatorListener)object3).start();
        this.d.a.setVisibility(0);
        viewPropertyAnimator = this.d.a.animate().translationY(f10).alpha(f11).setDuration(l10);
        object4 = new EditorTemplateEditActivity$d(this, bl2);
        viewPropertyAnimator.setListener((Animator.AnimatorListener)object4).start();
    }

    private void a0(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            this.h.F0(n10);
            this.h.Y0();
            NvsVideoClip nvsVideoClip = d.v.v.q.h.h0().getClipByIndex(n10);
            long l10 = nvsVideoClip.getTrimOut();
            long l11 = nvsVideoClip.getTrimIn();
            long l12 = l10 - l11;
            List list = this.h.X();
            String string2 = ((d)list.get(n10)).e();
            ThumbnailView thumbnailView = this.d.n;
            TemplateEditViewModel templateEditViewModel = this.h;
            long l13 = templateEditViewModel.i0();
            n10 = 0x42040000;
            float f10 = 33.0f;
            int n12 = h2.b(f10);
            long l14 = nvsVideoClip.getTrimIn();
            thumbnailView.V(string2, l13, n12, l12, l14);
        }
    }

    public static /* synthetic */ void i(EditorTemplateEditActivity editorTemplateEditActivity, long l10, String[] stringArray, TemplatePOJO templatePOJO) {
        editorTemplateEditActivity.q(l10, stringArray, templatePOJO);
    }

    public static /* synthetic */ p j(EditorTemplateEditActivity editorTemplateEditActivity) {
        return editorTemplateEditActivity.d;
    }

    public static /* synthetic */ TemplateEditViewModel k(EditorTemplateEditActivity editorTemplateEditActivity) {
        return editorTemplateEditActivity.h;
    }

    public static /* synthetic */ d1 l(EditorTemplateEditActivity editorTemplateEditActivity) {
        return editorTemplateEditActivity.j;
    }

    public static /* synthetic */ void m(EditorTemplateEditActivity editorTemplateEditActivity, boolean bl2, int n10) {
        editorTemplateEditActivity.S(bl2, n10);
    }

    public static /* synthetic */ int n(EditorTemplateEditActivity editorTemplateEditActivity) {
        return editorTemplateEditActivity.k;
    }

    public static /* synthetic */ boolean o(EditorTemplateEditActivity editorTemplateEditActivity) {
        return editorTemplateEditActivity.p();
    }

    private boolean p() {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(2131362359);
        int n10 = 1;
        if (fragment == null) {
            return n10 != 0;
        }
        boolean bl2 = (fragment = fragment.getChildFragmentManager().getPrimaryNavigationFragment()) instanceof c;
        if (bl2) {
            return ((c)fragment).s(n10);
        }
        return n10 != 0;
    }

    private void q(long l10, String[] object, TemplatePOJO object2) {
        this.h.p0((TemplatePOJO)object2);
        object = this.h.l0((String[])object);
        this.j.l((List)object);
        object2 = this.h;
        PlayerWrapperView playerWrapperView = null;
        ((TemplateEditViewModel)object2).M0(0);
        object2 = this.d.h.getPlayerView();
        if (object2 == null) {
            object2 = this.d.h;
            ((PlayerWrapperView)((Object)object2)).a();
        }
        object2 = this.h;
        playerWrapperView = this.d.h;
        ((TemplateEditViewModel)object2).o0(playerWrapperView, (List)object);
        this.h.X0();
        this.i.o(l10);
        ViewTreeObserver viewTreeObserver = this.d.g.getViewTreeObserver();
        EditorTemplateEditActivity$b editorTemplateEditActivity$b = new EditorTemplateEditActivity$b(this);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)editorTemplateEditActivity$b);
    }

    private void s() {
        Object object = this.getIntent();
        if (object != null) {
            int n10;
            String[] stringArray = object.getStringArrayExtra(p);
            long l10 = object.getLongExtra(q, 0L);
            this.k = n10 = object.getIntExtra("templateModeType", 0);
            this.i.k(n10);
            n10 = this.k;
            this.u(n10);
            object = object.getParcelableArrayListExtra(o);
            this.i.l((List)object);
            object = this.g.j(l10);
            EditorTemplateEditActivity$a editorTemplateEditActivity$a = new EditorTemplateEditActivity$a(this, (LiveData)object, l10, stringArray);
            ((LiveData)object).observe(this, editorTemplateEditActivity$a);
            return;
        }
        object = new IllegalStateException("must startActivityForResult by startActivityForResult(Activity activity, String[] mediaArray, int tempId)");
        throw object;
    }

    private void t() {
        Object object = this.j;
        Object object2 = new a0(this);
        ((d1)object).q((d.v.f.f.c)object2);
        object = this.h.d0();
        object2 = new f0(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.h.b0();
        object2 = new t(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.h.L();
        object2 = new d.v.c.u1.m.s(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.h.I();
        object2 = new b0(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.h.a0();
        object2 = new x(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.h.T();
        object2 = new y(this);
        ((LiveData)object).observe(this, (Observer)object2);
    }

    private void u(int n10) {
        ViewStub viewStub = this.d.k.getViewStub();
        if (viewStub == null) {
            return;
        }
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                gi gi2;
                n10 = 2131558794;
                viewStub.setLayoutResource(n10);
                this.f = gi2 = (gi)DataBindingUtil.getBinding(viewStub.inflate());
                this.T();
            }
        } else {
            ii ii2;
            n10 = 2131558795;
            viewStub.setLayoutResource(n10);
            this.e = ii2 = (ii)DataBindingUtil.getBinding(viewStub.inflate());
        }
    }

    private void v() {
        Object object = this.h;
        Object object2 = new d1((LifecycleOwner)this, (TemplateEditViewModel)object);
        this.j = object2;
        object2 = this.d.i;
        object = this.c;
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
        object2 = this.d.i;
        object = new LinearLayoutManager((Context)this, 0, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.d.i;
        object = this.j;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        object2 = this.d.l.c;
        int n10 = o1.c(this.getResources(), 2131099738);
        object2.setTextColor(n10);
    }

    public static /* synthetic */ void w(EditorTemplateEditActivity editorTemplateEditActivity) {
        editorTemplateEditActivity.V();
    }

    private /* synthetic */ boolean x(View view, int n10, a a10, MotionEvent object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        ViewModel viewModel = this.h;
        boolean n12 = ((TemplateEditViewModel)viewModel).Q0(a10);
        if (!n12 && !(bl4 = ((k)(viewModel = this.i)).g()) && (bl3 = object.getAction()) != (bl2 = true)) {
            object = this.d.j;
            ((MediaConstrainLayout)((Object)object)).b(bl2, a10, view, n10);
        }
        return false;
    }

    private /* synthetic */ void z(Integer n10) {
        s s10;
        this.h.y0();
        Object object = this.h;
        int n11 = n10;
        int n12 = 1;
        int n13 = -1;
        if (n11 == n13) {
            n11 = n12;
        } else {
            n11 = 0;
            s10 = null;
        }
        ((TemplateEditViewModel)object).H0(n11 != 0);
        int n14 = n10;
        if (n14 == n13) {
            n12 = 0;
        }
        this.Z(n12 != 0);
        this.h.X0();
        n14 = n10;
        this.a0(n14);
        object = this.i;
        n14 = (int)(((k)object).g() ? 1 : 0);
        if (n14 != 0) {
            this.d.i.removeItemDecorationAt(0);
            object = this.d.i;
            n11 = n10;
            s10 = n11 == n13 ? this.c : this.b;
            ((RecyclerView)object).addItemDecoration(s10);
            int n15 = n10;
            if (n15 != n13) {
                this.W();
            }
        }
    }

    public /* synthetic */ void A(Integer n10) {
        this.z(n10);
    }

    public /* synthetic */ void C(Integer n10) {
        this.B(n10);
    }

    public /* synthetic */ void E(Long l10) {
        this.D(l10);
    }

    public /* synthetic */ void G(Integer n10) {
        this.F(n10);
    }

    public /* synthetic */ void I(Float f10) {
        this.H(f10);
    }

    public /* synthetic */ void K(Boolean bl2) {
        this.J(bl2);
    }

    public /* synthetic */ void N(long l10, TemplatePOJO templatePOJO, List list) {
        this.M(l10, templatePOJO, list);
    }

    public /* synthetic */ void P() {
        this.O();
    }

    public void a(long l10, TemplatePOJO templatePOJO) {
        Object object = this.i;
        boolean bl2 = ((k)object).j(l10);
        if (bl2) {
            return;
        }
        this.h.z();
        this.d.h.b();
        object = new AiUseCase(this, false);
        List list = this.i.c();
        d0 d02 = new d0(this, l10, templatePOJO);
        ((AiUseCase)object).K(templatePOJO, list, d02, null);
    }

    public int d() {
        return 2131558437;
    }

    public void f(ViewDataBinding object, Bundle object2) {
        super.f((ViewDataBinding)object, (Bundle)object2);
        object = (p)object;
        this.d = object;
        object2 = new EditorTemplateEditActivity$e(this);
        ((p)object).B((EditorTemplateEditActivity$e)object2);
        object = this.d;
        object2 = this.h;
        ((p)object).C((TemplateEditViewModel)object2);
        object = this.d;
        object2 = this.i;
        ((p)object).D((k)object2);
        object = this.getLifecycle();
        object2 = this.h;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        this.v();
        this.s();
        this.t();
    }

    public void h() {
        ViewModel viewModel;
        super.h();
        Object object = d.v.i0.b.c(this);
        this.h = viewModel = (TemplateEditViewModel)((ViewModelProvider)object).get(TemplateEditViewModel.class);
        viewModel = (k)((ViewModelProvider)object).get(k.class);
        this.i = viewModel;
        this.g = object = (f1)((ViewModelProvider)object).get(f1.class);
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        Object object2;
        Object object3;
        super.onActivityResult(n10, n11, (Intent)object);
        int n12 = -1;
        if (n11 == n12 && n10 == (n11 = 1) && object != null && (n10 = (int)(((TemplateEditViewModel)(object3 = this.h)).C0((String[])(object2 = object.getStringArrayExtra(p))) ? 1 : 0)) != 0) {
            object2 = this.h;
            n10 = ((TemplateEditViewModel)object2).e0();
            this.a0(n10);
            object3 = (d)this.h.X().get(n10);
            this.j.d().set(n10, object3);
            object = this.i;
            ((k)object).i((a)object3, n10);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        boolean bl2 = this.k;
        boolean bl3 = true;
        if (bl2 != bl3) {
            bl3 = false;
        }
        this.S(bl3, -1);
    }

    public void r() {
        Intent intent = new Intent((Context)this, PublishActivity.class);
        intent.putExtra("publish_from_type", 2);
        this.startActivity(intent);
    }

    public /* synthetic */ boolean y(View view, int n10, a a10, MotionEvent motionEvent) {
        return this.x(view, n10, a10, motionEvent);
    }
}

