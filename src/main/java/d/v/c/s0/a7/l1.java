/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 */
package d.v.c.s0.a7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.a7.l0;
import d.v.c.s0.a7.l1$a;
import d.v.c.s0.a7.l1$b;
import d.v.c.s0.a7.m0;
import d.v.c.s0.a7.n0;
import d.v.c.s0.a7.o0;
import d.v.c.s0.a7.p0;
import d.v.c.s0.a7.q0;
import d.v.c.s0.a7.t0;
import d.v.c.w0.j2;
import d.v.e.h.c;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.i0.b;
import java.math.BigDecimal;

public class l1
extends t0 {
    private BleViewModel f;
    private j2 g;
    private m2$d h;

    private void A() {
        ImageView imageView = this.g.d;
        Object object = new p0(this);
        imageView.setOnTouchListener((View.OnTouchListener)object);
        imageView = this.g.c;
        object = new n0(this);
        imageView.setOnTouchListener((View.OnTouchListener)object);
        imageView = this.g.b;
        object = new q0(this);
        imageView.setOnTouchListener((View.OnTouchListener)object);
        imageView = this.g.a;
        object = new o0(this);
        imageView.setOnTouchListener((View.OnTouchListener)object);
    }

    private void B() {
        MutableLiveData mutableLiveData = this.f.K;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new m0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.f.J;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new l0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ boolean C(View view, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        motionEvent = null;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11 || n10 == (n11 = 3)) {
                this.R();
            }
        } else {
            this.z(false, false);
        }
        return false;
    }

    private /* synthetic */ boolean E(View view, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        motionEvent = null;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11 || n10 == (n11 = 3)) {
                this.R();
            }
        } else {
            this.z(false, n11 != 0);
        }
        return false;
    }

    private /* synthetic */ boolean G(View view, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        motionEvent = null;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11 || n10 == (n11 = 3)) {
                this.R();
            }
        } else {
            this.z(n11 != 0, false);
        }
        return false;
    }

    private /* synthetic */ boolean I(View view, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11 || n10 == (n11 = 3)) {
                this.R();
            }
        } else {
            this.z(n11 != 0, n11 != 0);
        }
        return false;
    }

    private /* synthetic */ void K(Float f10) {
        BleViewModel bleViewModel = this.f;
        float f11 = f10.floatValue();
        float f12 = c.c((Float)this.f.J.getValue());
        bleViewModel.n1(f11, f12);
    }

    private /* synthetic */ void M(Float f10) {
        BleViewModel bleViewModel = this.f;
        float f11 = c.c((Float)bleViewModel.K.getValue());
        float f12 = f10.floatValue();
        bleViewModel.n1(f11, f12);
    }

    public static l1 O() {
        l1 l12 = new l1();
        return l12;
    }

    private void P() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            int n11;
            int n12;
            dialog = this.getDialog();
            int n13 = 0;
            float f10 = 0.0f;
            dialog.setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            colorDrawable = dialog.getAttributes();
            colorDrawable.gravity = 17;
            float f11 = 300.0f;
            colorDrawable.width = n12 = h2.b(f11);
            colorDrawable.height = n11 = h2.b(f11);
            n11 = 0;
            f11 = 0.0f;
            colorDrawable.dimAmount = 0.0f;
            dialog.setAttributes((WindowManager.LayoutParams)colorDrawable);
            int n14 = this.k();
            if (n14 == 0 || n14 == (n10 = 2)) {
                n13 = -90;
                f10 = 0.0f / 0.0f;
            }
            if ((dialog = this.getView()) != null) {
                f10 = n13;
                dialog.setRotation(f10);
            }
        }
    }

    private void Q(MutableLiveData mutableLiveData, boolean bl2) {
        float f10;
        Float f11 = (Float)mutableLiveData.getValue();
        float f12 = c.c(f11);
        if (bl2) {
            int n10 = -1110651699;
            f10 = -0.1f;
        } else {
            int n11 = 0x3DCCCCCD;
            f10 = 0.1f;
        }
        double d10 = f12 += f10;
        Number number = new BigDecimal(d10);
        number = Float.valueOf(number.setScale(1, 4).floatValue());
        mutableLiveData.postValue(number);
    }

    private void R() {
        m2.a(this.h);
    }

    public static /* synthetic */ BleViewModel w(l1 l12) {
        return l12.f;
    }

    public static /* synthetic */ void x(l1 l12, MutableLiveData mutableLiveData, boolean bl2) {
        l12.Q(mutableLiveData, bl2);
    }

    public static /* synthetic */ void y(l1 l12) {
        l12.R();
    }

    private void z(boolean bl2, boolean bl3) {
        m2$d m2$d;
        l1$a l1$a = new l1$a(this, bl3, bl2);
        this.h = m2$d = m2.i(2000L, 200L, l1$a);
    }

    public /* synthetic */ boolean D(View view, MotionEvent motionEvent) {
        return this.C(view, motionEvent);
    }

    public /* synthetic */ boolean F(View view, MotionEvent motionEvent) {
        return this.E(view, motionEvent);
    }

    public /* synthetic */ boolean H(View view, MotionEvent motionEvent) {
        return this.G(view, motionEvent);
    }

    public /* synthetic */ boolean J(View view, MotionEvent motionEvent) {
        return this.I(view, motionEvent);
    }

    public /* synthetic */ void L(Float f10) {
        this.K(f10);
    }

    public /* synthetic */ void N(Float f10) {
        this.M(f10);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (BleViewModel)b.c(this.requireActivity()).get(BleViewModel.class);
        this.f = object;
        ((BleViewModel)object).r();
    }

    public void onResume() {
        super.onResume();
        this.P();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.B();
        this.A();
    }

    public void p(int n10) {
        super.p(n10);
        this.P();
    }

    public int s() {
        return 2131558484;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (j2)viewDataBinding;
        this.g = viewDataBinding;
        Object object = new l1$b(this);
        ((j2)viewDataBinding).B((l1$b)object);
        viewDataBinding = this.g;
        object = this.f;
        ((j2)viewDataBinding).A((BleViewModel)object);
    }
}

