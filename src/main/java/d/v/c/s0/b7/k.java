/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 */
package d.v.c.s0.b7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.b7.a;
import d.v.c.s0.b7.b;
import d.v.c.s0.b7.c;
import d.v.c.s0.b7.d;
import d.v.c.s0.b7.e;
import d.v.c.s0.b7.f;
import d.v.c.s0.b7.g;
import d.v.c.s0.b7.h;
import d.v.c.s0.b7.i;
import d.v.c.s0.b7.k$a;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.w0.x5;
import d.v.e.l.h2;
import d.v.j0.d$c;

public class k
extends d.v.f.h.c {
    private x5 a;
    private k$a b;
    private s6 c;
    private u6 d;
    private DynamicZoomViewModel e;
    private BleViewModel f;
    private int g = 3;
    private boolean h;
    private ExoVideoView i;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void A(Boolean object) {
        void var3_6;
        LottieAnimationView lottieAnimationView = this.a.b.f;
        boolean n10 = (Boolean)object;
        if (n10) {
            boolean bl2 = false;
        } else {
            int n11 = 4;
        }
        lottieAnimationView.setVisibility((int)var3_6);
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.a.b.f;
            ((LottieAnimationView)object).playAnimation();
        } else {
            object = this.a.b.f;
            ((LottieAnimationView)object).cancelAnimation();
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void C(Boolean object) {
        void var3_6;
        LottieAnimationView lottieAnimationView = this.a.b.h;
        boolean n10 = (Boolean)object;
        if (n10) {
            boolean bl2 = false;
        } else {
            int n11 = 4;
        }
        lottieAnimationView.setVisibility((int)var3_6);
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.a.b.h;
            ((LottieAnimationView)object).playAnimation();
        } else {
            object = this.a.b.h;
            ((LottieAnimationView)object).cancelAnimation();
        }
    }

    private /* synthetic */ boolean E(d.v.j0.d d10, int n10, int n11) {
        int n12 = 3;
        if (n10 == n12) {
            d10 = this.a.c.g;
            n10 = 8;
            d10.setVisibility(n10);
        }
        return false;
    }

    private /* synthetic */ void G() {
        View view = this.a.b.n;
        if (view != null) {
            int n10 = view.getLeft();
            int n11 = view.getTop();
            int n12 = view.getRight();
            int n13 = view.getBottom();
            if (n10 > 0 && n11 > 0 && n12 > 0 && n13 > 0) {
                DynamicZoomViewModel dynamicZoomViewModel = this.e;
                float f10 = n10;
                float f11 = n11;
                float f12 = n12;
                float f13 = n13;
                RectF rectF = new RectF(f10, f11, f12, f13);
                dynamicZoomViewModel.M(rectF);
            }
        }
    }

    private void I(View view, int n10, int n11) {
        float f10 = n10;
        f10 = n11;
        float[] fArray = new float[]{f10, f10};
        ObjectAnimator.ofFloat((Object)view, (String)"rotation", (float[])fArray).setDuration(0L).start();
    }

    private void J(ViewGroup viewGroup, int n10, int n11) {
        int n12;
        for (int i10 = 0; i10 < (n12 = viewGroup.getChildCount()); ++i10) {
            ConstraintLayout constraintLayout;
            int n13;
            View view = viewGroup.getChildAt(i10);
            int n14 = view.getId();
            if (n14 == (n13 = (constraintLayout = this.a.b.d).getId())) continue;
            n14 = view instanceof ViewGroup;
            if (n14 != 0) {
                n14 = view.getId();
                if (n14 != (n13 = (constraintLayout = this.a.b.e).getId()) && (n14 = view.getId()) != (n13 = (constraintLayout = this.a.c.a).getId())) {
                    view = (ViewGroup)view;
                    this.J((ViewGroup)view, n10, n11);
                    continue;
                }
                this.I(view, n10, n11);
                continue;
            }
            this.I(view, n10, n11);
        }
    }

    private void K() {
        int n10 = this.h;
        int n11 = 0;
        if (n10 != 0) {
            n10 = -90;
        } else {
            n11 = 90;
            n10 = 0;
        }
        ConstraintLayout constraintLayout = this.a.a;
        this.J(constraintLayout, n11, n10);
    }

    private void L() {
        int n10;
        Object object;
        Object object2;
        int n11 = this.h;
        if (n11 != 0) {
            object2 = this.a.b.k;
            n11 = object2.getTop();
            object = this.a.b.l;
            n10 = object.getTop();
        } else {
            object2 = this.a.b.s;
            n11 = object2.getLeft();
            object = this.a.b.q;
            n10 = object.getLeft();
        }
        object = this.c.e;
        object2 = n11 -= n10;
        ((MutableLiveData)object).setValue(object2);
    }

    public static /* synthetic */ s6 h(k k10) {
        return k10.c;
    }

    public static /* synthetic */ x5 i(k k10) {
        return k10.a;
    }

    public static /* synthetic */ DynamicZoomViewModel j(k k10) {
        return k10.e;
    }

    public static /* synthetic */ ExoVideoView k(k k10) {
        return k10.i;
    }

    public static k l() {
        k k10 = new k();
        return k10;
    }

    private void m() {
        ExoVideoView exoVideoView;
        this.i = exoVideoView = this.a.c.f;
        exoVideoView.setLoopPlay(true);
        this.i.F(false);
        this.i.L(false);
        this.i.setMediaControllerDefault(false);
        this.i.A();
        this.i.setVolume(0.0f);
        exoVideoView = this.i;
        f f10 = new f(this);
        exoVideoView.setOnInfoListener(f10);
    }

    private void n() {
        MutableLiveData mutableLiveData = this.c.b;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new a(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.d.Z;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.t();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.o();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.h;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.f;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new h(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void o() {
        int n10;
        Object object = this.a.c.b.getLayoutParams();
        ((ViewGroup.LayoutParams)object).height = n10 = this.c.c / 2;
        this.a.c.b.setLayoutParams((ViewGroup.LayoutParams)object);
        int n11 = this.a.c.l.getLayoutParams().height;
        n10 = this.a.c.c.getLayoutParams().height;
        int n12 = this.c.c / 2 - n11 - n10;
        n11 = h2.b(80.0f);
        this.a.c.k.setMaxHeight(n12 -= n11);
        object = this.a.c.f;
        this.i = object;
        ((ExoVideoView)object).setLoopPlay(true);
        this.i.F(false);
        this.i.L(false);
        this.i.setMediaControllerDefault(false);
        this.i.A();
        this.i.setVolume(0.0f);
        object = this.i;
        Object object2 = new g(this);
        ((ExoVideoView)object).setOnInfoListener((d$c)object2);
        object = this.a.b.n;
        object2 = new b(this);
        object.post((Runnable)object2);
    }

    private /* synthetic */ boolean q(d.v.j0.d d10, int n10, int n11) {
        int n12 = 3;
        if (n10 == n12) {
            d10 = this.a.c.g;
            n10 = 8;
            d10.setVisibility(n10);
        }
        return false;
    }

    private /* synthetic */ void s(Integer n10) {
        int n11;
        int n12;
        this.g = n12 = n10.intValue();
        if (n12 != 0 && n12 != (n11 = 2)) {
            n12 = 0;
            n10 = null;
        } else {
            n12 = 1;
        }
        this.h = n12;
        this.L();
        this.K();
    }

    private /* synthetic */ void u(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.i.pause();
            object = this.i;
            int n10 = 1;
            String[] stringArray = new String[n10];
            Object object2 = ResConfig$AppResType.APP_ASSETS;
            String string2 = "hitchcock_preview_far_away.mp4";
            stringArray[0] = object2 = d.v.e.j.b.h((d.v.e.j.a)object2, string2);
            ((ExoVideoView)object).setVideoPath(stringArray);
            object = this.i;
            ((ExoVideoView)object).start();
        }
    }

    private /* synthetic */ void w(Float object) {
        TextView textView = this.a.b.i;
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objectArray = new Object[]{object};
        object = String.format("%.1f", objectArray);
        stringBuilder.append((String)object);
        stringBuilder.append("X");
        object = stringBuilder.toString();
        textView.setText((CharSequence)object);
    }

    private /* synthetic */ void y(DynamicZoomViewModel$TargetModel object) {
        Object object2 = DynamicZoomViewModel$TargetModel.FAR;
        if (object == object2) {
            object2 = this.a.b.f;
            String string2 = "dolly_zoom_backward.json";
            ((LottieAnimationView)object2).setAnimation(string2);
        }
        if (object == (object2 = DynamicZoomViewModel$TargetModel.NEAR)) {
            object = this.a.b.f;
            object2 = "dolly_zoom_forward.json";
            ((LottieAnimationView)object).setAnimation((String)object2);
        }
    }

    public /* synthetic */ void B(Boolean bl2) {
        this.A(bl2);
    }

    public /* synthetic */ void D(Boolean bl2) {
        this.C(bl2);
    }

    public /* synthetic */ boolean F(d.v.j0.d d10, int n10, int n11) {
        return this.E(d10, n10, n11);
    }

    public /* synthetic */ void H() {
        this.G();
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = viewModel = (s6)((ViewModelProvider)object).get(s6.class);
        viewModel = (u6)((ViewModelProvider)object).get(u6.class);
        this.d = viewModel;
        viewModel = (DynamicZoomViewModel)((ViewModelProvider)object).get(DynamicZoomViewModel.class);
        this.e = viewModel;
        this.f = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup object, Bundle object2) {
        layoutInflater = layoutInflater.inflate(2131558560, (ViewGroup)object, false);
        object = x5.s((View)layoutInflater);
        this.a = object;
        object = new k$a(this);
        this.b = object;
        this.a.E((k$a)object);
        object = this.a;
        object2 = this.d;
        ((x5)object).H((u6)object2);
        object = this.a;
        object2 = this.f;
        ((x5)object).D((BleViewModel)object2);
        object = this.a;
        object2 = this.e;
        ((x5)object).G((DynamicZoomViewModel)object2);
        this.a.setLifecycleOwner(this);
        return layoutInflater;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.o();
        this.m();
        this.n();
    }

    public boolean p() {
        ConstraintLayout constraintLayout = this.a.c.j;
        int n10 = constraintLayout.getVisibility();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            constraintLayout = null;
        }
        return n10 != 0;
    }

    public /* synthetic */ boolean r(d.v.j0.d d10, int n10, int n11) {
        return this.q(d10, n10, n11);
    }

    public /* synthetic */ void t(Integer n10) {
        this.s(n10);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void x(Float f10) {
        this.w(f10);
    }

    public /* synthetic */ void z(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.y(dynamicZoomViewModel$TargetModel);
    }
}

