/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.ComposeFragment$a;
import com.zhiyun.cama.publish.ComposeFragment$b;
import com.zhiyun.image.Images;
import d.v.c.i1.k2;
import d.v.c.n1.a;
import d.v.c.n1.b;
import d.v.c.n1.c;
import d.v.c.n1.d;
import d.v.c.n1.f;
import d.v.c.n1.g;
import d.v.c.n1.h;
import d.v.c.n1.i;
import d.v.c.n1.j;
import d.v.c.n1.k;
import d.v.c.n1.l;
import d.v.c.n1.m;
import d.v.c.w0.z5;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.n$a;

public class ComposeFragment
extends d.v.f.h.a {
    private static final float d = 20.0f;
    private static final float e = 14.0f;
    private d.v.c.u0.l b;
    private z5 c;

    private /* synthetic */ void A(RadioGroup object, int n10) {
        String string2 = ((RadioButton)object.findViewById(n10)).getText().toString();
        this.L((RadioGroup)object, string2);
        d.v.c.u0.j.D(string2);
        object = this.c.q;
        int n11 = object.getCheckedRadioButtonId();
        object = ((TextView)object.findViewById(n11)).getText().toString();
        this.b.i((String)object, string2);
    }

    private /* synthetic */ void C(RadioButton radioButton, DialogFragment dialogFragment) {
        d.v.c.u0.j.E(((d.v.c.z0.k)dialogFragment).A());
        this.b.k();
        this.b.L(0);
        radioButton.performClick();
        dialogFragment.dismissAllowingStateLoss();
    }

    private /* synthetic */ void E() {
        n$a n$a = new n$a();
        Object object = this.c.h;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.s(this, 2131952779);
        n$a = n$a.k((String)object).d(2132017752).h(49).g(0).m(0);
        int n10 = this.c.e.getHeight();
        int n11 = this.c.f.getHeight();
        n10 += n11;
        n11 = h2.b(4.0f);
        n$a = n$a.n(n10 += n11).e(0.5f);
        object = new l(this);
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    public static /* synthetic */ void G() {
        k2.e().k(true);
    }

    private void H(RadioButton object) {
        boolean bl2 = d.v.c.u0.j.B();
        if (bl2) {
            this.b.k();
            this.b.L(0);
            object.performClick();
            return;
        }
        Object object2 = new d.v.c.z0.k$b();
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951885);
        object2 = ((d.v.c.z0.k$b)object2).J(string2);
        string2 = d.v.f.i.g.o(this.getResources(), 2131952615);
        object2 = ((d.v.c.z0.k$b)object2).x(string2, true, null);
        string2 = d.v.f.i.g.o(this.getResources(), 2131951833);
        d.v.f.f.a a10 = a.a;
        object2 = ((d.v.c.z0.k$b)object2).D(string2, a10);
        string2 = d.v.f.i.g.o(this.getResources(), 2131951887);
        a10 = new j(this, (RadioButton)object);
        object = ((d.v.c.z0.k$b)object2).G(string2, a10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void I() {
        k2 k22 = k2.e();
        boolean bl2 = k22.c();
        if (bl2) {
            return;
        }
        k22 = this.c.h;
        c c10 = new c(this);
        k22.post(c10);
    }

    private void J() {
        int n10 = this.c.e.getHeight();
        int n11 = this.c.c.getHeight();
        n10 += n11;
        n11 = Math.round(this.c.p.getY());
        n10 += n11;
        n11 = this.c.p.getHeight();
        n10 += n11;
        n11 = h2.b(4.0f);
        Object object = new n$a();
        Object object2 = this.c.p;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.s(this, 2131952022);
        object = ((n$a)object).k((String)object2).d(2132017752).h(0x800033).g(0);
        int n12 = h2.b(20.0f);
        n$a n$a = ((n$a)object).m(n12).n(n10 += n11).e(0.25f);
        object = new b(this);
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    private void K() {
        int n10 = this.c.e.getHeight();
        int n11 = this.c.c.getHeight();
        n10 += n11;
        n11 = (int)this.c.b.getY();
        n10 += n11;
        n11 = this.c.b.getHeight();
        Object object = new n$a();
        Object object2 = this.c.r;
        object = ((n$a)object).c((View)object2);
        object2 = d.v.f.i.g.s(this, 2131952023);
        n$a n$a = ((n$a)object).k((String)object2).d(2132017752).h(49).g(2).m(0).n(n10 -= n11).e(0.5f);
        object = i.a;
        n$a.j((PopupWindow.OnDismissListener)object).o();
    }

    private void L(RadioGroup radioGroup, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = radioGroup.getChildCount()); ++i10) {
            float f10;
            RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i10);
            String string3 = radioButton.getText().toString();
            boolean bl2 = string3.equals(string2);
            if (bl2) {
                radioButton.setTextSize(20.0f);
                bl2 = true;
                f10 = Float.MIN_VALUE;
                radioButton.setChecked(bl2);
                continue;
            }
            bl2 = 1096810496 != 0;
            f10 = 14.0f;
            radioButton.setTextSize(f10);
        }
    }

    public static /* synthetic */ d.v.c.u0.l j(ComposeFragment composeFragment) {
        return composeFragment.b;
    }

    public static /* synthetic */ z5 k(ComposeFragment composeFragment) {
        return composeFragment.c;
    }

    private void l(RadioGroup radioGroup, boolean bl2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = radioGroup.getChildCount()); ++i10) {
            RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i10);
            radioButton.setEnabled(bl2);
        }
    }

    private void m() {
        String string2;
        boolean bl2;
        Object object = d.v.c.u0.j.C();
        Object object2 = d.v.c.u0.j.A();
        int n10 = 2131952837;
        if (object == null) {
            object = o1.R(this, n10);
        }
        if (object2 == null) {
            int n11 = 2131953157;
            object2 = o1.R(this, n11);
        }
        if ((bl2 = ((String)object).equals(string2 = o1.R(this, 2131952836))) && !(bl2 = d.v.c.m1.b.a())) {
            object = o1.R(this, n10);
        }
        Object object3 = this.c.q;
        this.L((RadioGroup)object3, (String)object);
        object3 = this.c.p;
        this.L((RadioGroup)object3, (String)object2);
        this.b.i((String)object, (String)object2);
        this.b.o();
        object = this.b.y();
        object2 = this.getViewLifecycleOwner();
        object3 = new g(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.b.t();
        object2 = this.getViewLifecycleOwner();
        object3 = new f(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.b.j;
        object2 = new d(this);
        ((d.v.e.i.j)object).observe(this, (Observer)object2);
    }

    private void n() {
        k k10 = new k(this);
        this.c.o.setOnTouchListener((View.OnTouchListener)k10);
        this.c.m.setOnTouchListener((View.OnTouchListener)k10);
        this.c.n.setOnTouchListener((View.OnTouchListener)k10);
        this.c.j.setOnTouchListener((View.OnTouchListener)k10);
        this.c.k.setOnTouchListener((View.OnTouchListener)k10);
        this.c.l.setOnTouchListener((View.OnTouchListener)k10);
        k10 = this.c.q;
        Object object = new m(this);
        k10.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
        k10 = this.c.p;
        object = new h(this);
        k10.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
        this.I();
    }

    public static /* synthetic */ void o(ComposeFragment composeFragment) {
        composeFragment.K();
    }

    public static /* synthetic */ void p(ComposeFragment composeFragment) {
        composeFragment.J();
    }

    private /* synthetic */ void q(String string2) {
        if (string2 == null) {
            return;
        }
        Context context = this.requireContext();
        ComposeFragment$a composeFragment$a = new ComposeFragment$a(this);
        Images.w(context, string2, composeFragment$a);
    }

    private /* synthetic */ void s(Integer n10) {
        if (n10 == null) {
            return;
        }
        boolean bl2 = n10.intValue();
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                boolean bl4 = 2 != 0;
                if (bl2 != bl4) {
                    boolean n13 = 3 != 0;
                    if (bl2 == n13) {
                        n10 = this.c.r;
                        Object object = this.getResources();
                        int n12 = 2131951883;
                        object = d.v.f.i.g.o(object, n12);
                        n10.setText((CharSequence)object);
                        n10 = this.c.q;
                        this.l((RadioGroup)n10, bl3);
                        n10 = this.c.p;
                        this.l((RadioGroup)n10, bl3);
                    }
                } else {
                    n10 = this.c.r;
                    Object object = this.getResources();
                    int n14 = 2131952612;
                    object = d.v.f.i.g.o(object, n14);
                    n10.setText((CharSequence)object);
                    n10 = this.c.q;
                    this.l((RadioGroup)n10, bl3);
                    n10 = this.c.p;
                    this.l((RadioGroup)n10, bl3);
                }
            } else {
                n10 = this.c.r;
                Object object = this.getResources();
                int n11 = 2131951881;
                object = d.v.f.i.g.o(object, n11);
                n10.setText((CharSequence)object);
                n10 = this.c.q;
                bl3 = false;
                object = null;
                this.l((RadioGroup)n10, false);
                n10 = this.c.p;
                this.l((RadioGroup)n10, false);
            }
        } else {
            n10 = this.c.r;
            Object object = this.getResources();
            int n12 = 2131951879;
            object = d.v.f.i.g.o(object, n12);
            n10.setText((CharSequence)object);
            n10 = this.c.q;
            this.l((RadioGroup)n10, bl3);
            n10 = this.c.p;
            this.l((RadioGroup)n10, bl3);
        }
    }

    private /* synthetic */ void u(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (!bl2) {
            Object object2 = this.requireContext();
            object = new k$b((Context)object2);
            object2 = this.getResources();
            int n10 = 2131951880;
            object2 = d.v.f.i.g.o((Resources)object2, n10);
            object = (k$b)((k$a)object).B((String)object2);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        }
    }

    private /* synthetic */ boolean w(View view, MotionEvent motionEvent) {
        int n10;
        int n11;
        int n12;
        int n13 = motionEvent.getAction();
        if (n13 == (n12 = 1) && (n11 = view.getId()) == (n10 = 2131363057) && (n11 = (int)(d.v.c.m1.b.c(this) ? 1 : 0)) == 0) {
            return n12 != 0;
        }
        Integer n14 = (Integer)this.b.t().getValue();
        if (n14 != null && (n11 = n14.intValue()) == (n10 = 2)) {
            n14 = this.c.p;
            n11 = n14.getCheckedRadioButtonId();
            if (n11 != (n10 = view.getId()) && (n11 = (n14 = this.c.q).getCheckedRadioButtonId()) != (n10 = view.getId()) && n13 == n12) {
                view = (RadioButton)view;
                this.H((RadioButton)view);
            }
            return n12 != 0;
        }
        return false;
    }

    private /* synthetic */ void y(RadioGroup object, int n10) {
        String string2 = ((RadioButton)object.findViewById(n10)).getText().toString();
        this.L((RadioGroup)object, string2);
        d.v.c.u0.j.F(string2);
        object = this.c.p;
        int n11 = object.getCheckedRadioButtonId();
        object = ((TextView)object.findViewById(n11)).getText().toString();
        this.b.i(string2, (String)object);
    }

    public /* synthetic */ void B(RadioGroup radioGroup, int n10) {
        this.A(radioGroup, n10);
    }

    public /* synthetic */ void D(RadioButton radioButton, DialogFragment dialogFragment) {
        this.C(radioButton, dialogFragment);
    }

    public /* synthetic */ void F() {
        this.E();
    }

    public int h() {
        return 2131558561;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (z5)object;
        this.c = object;
        this.b = object = (d.v.c.u0.l)d.v.i0.b.c(this.requireActivity()).get(d.v.c.u0.l.class);
        this.c.B((d.v.c.u0.l)object);
        object = this.c;
        ComposeFragment$b composeFragment$b = new ComposeFragment$b(this);
        ((z5)object).A(composeFragment$b);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) != 0) {
            Integer n12 = (Integer)this.b.t().getValue();
            if (n12 != null && (n10 = n12.intValue()) == (n11 = 2)) {
                n12 = this.c.n;
                this.H((RadioButton)n12);
            } else {
                n12 = this.c.q;
                n11 = 2131952836;
                String string2 = o1.R(this, n11);
                this.L((RadioGroup)n12, string2);
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.requireActivity().setRequestedOrientation(-1);
    }

    public void onStart() {
        super.onStart();
        this.requireActivity().setRequestedOrientation(1);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m();
        this.n();
    }

    public /* synthetic */ void r(String string2) {
        this.q(string2);
    }

    public /* synthetic */ void t(Integer n10) {
        this.s(n10);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ boolean x(View view, MotionEvent motionEvent) {
        return this.w(view, motionEvent);
    }

    public /* synthetic */ void z(RadioGroup radioGroup, int n10) {
        this.y(radioGroup, n10);
    }
}

