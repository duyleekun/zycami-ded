/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.common.util.Windows;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.n0.f;
import d.v.c.n0.f$a;
import d.v.c.s0.a7.f0;
import d.v.c.s0.a7.h1$a;
import d.v.c.s0.a7.h1$b;
import d.v.c.s0.s6;
import d.v.c.w0.n1;
import d.v.f.g.a;
import d.v.i0.b;

public class h1
extends a {
    private n1 f;
    private boolean g;
    private ExoVideoView h;
    private f$a i;
    private RecyclerView j;

    public static /* synthetic */ f$a A(h1 h12, f$a f$a) {
        h12.i = f$a;
        return f$a;
    }

    public static /* synthetic */ RecyclerView B(h1 h12) {
        return h12.j;
    }

    private void C(View view, int n10, boolean bl2) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)view.getLayoutParams();
        if (bl2) {
            double d10 = n10;
            double d11 = 0.889;
            constraintLayout$LayoutParams.width = n10 = (int)(d10 *= d11);
            constraintLayout$LayoutParams.height = n10 = n10 * 9 / 16;
        } else {
            double d12 = n10;
            double d13 = 0.55;
            constraintLayout$LayoutParams.height = n10 = (int)(d12 *= d13);
            constraintLayout$LayoutParams.width = n10 = n10 * 16 / 9;
        }
        view.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    private /* synthetic */ void D() {
        boolean bl2 = this.g;
        if (bl2) {
            this.g = false;
            return;
        }
        this.f.f.setCurrentItem(1);
    }

    public static h1 F() {
        h1 h12 = new h1();
        return h12;
    }

    private void G() {
        Object object = this.getContext();
        if (object != null && (object = this.getDialog()) != null && (object = this.getDialog().getWindow()) != null) {
            float f10;
            int n10;
            float f11;
            int n11;
            object = this.getDialog().getWindow();
            View view = object.getDecorView();
            int n12 = 0;
            float f12 = 0.0f;
            view.setPadding(0, 0, 0, 0);
            view = object.getAttributes();
            int n13 = 2;
            object.addFlags(n13);
            view.gravity = 48;
            int n14 = this.k();
            if (n14 != 0 && n14 != n13) {
                n11 = 0;
                f11 = 0.0f;
            } else {
                n11 = -90;
                f11 = 0.0f / 0.0f;
            }
            Size size = Windows.l(this.requireContext());
            view.height = n10 = size.getHeight();
            int n15 = size.getWidth();
            Context context = this.getContext();
            n10 = StatusBarUtil.b(context);
            view.width = n15 -= n10;
            n15 = 1062836634;
            view.dimAmount = f10 = 0.85f;
            object.setAttributes((WindowManager.LayoutParams)view);
            size = new ColorDrawable(0);
            object.setBackgroundDrawable((Drawable)size);
            size = this.getView();
            if (size != null) {
                f11 = n11;
                size.setRotation(f11);
                n11 = 2131362616;
                f11 = 1.8345018E38f;
                if (n14 != 0 && n14 != n13) {
                    view.width = n13 = -1;
                    object.setAttributes((WindowManager.LayoutParams)view);
                    size.getLayoutParams().width = n13;
                    object = size.getLayoutParams();
                    object.height = n13 = view.height;
                    object = size.getLayoutParams();
                    size.setLayoutParams((ViewGroup.LayoutParams)object);
                    boolean bl2 = false;
                    float f13 = 0.0f;
                    size.setTranslationX(0.0f);
                    size.setTranslationY(0.0f);
                    object = this.f.f.getRootView().findViewById(n11);
                    if (object != null) {
                        object = this.f.f.getRootView().findViewById(n11);
                        n13 = view.height;
                        this.C((View)object, n13, false);
                    }
                    object = this.f.g;
                    int n16 = view.height;
                    this.C((View)object, n16, false);
                } else {
                    object = size.getLayoutParams();
                    object.width = n12 = view.height;
                    object = size.getLayoutParams();
                    object.height = n12 = view.width;
                    object = size.getLayoutParams();
                    size.setLayoutParams((ViewGroup.LayoutParams)object);
                    int n17 = view.width / n13;
                    n12 = view.height / n13;
                    f12 = n17 -= n12;
                    size.setTranslationX(f12);
                    n17 = -n17;
                    float f14 = n17;
                    size.setTranslationY(f14);
                    object = this.f.f.getRootView().findViewById(n11);
                    n12 = 1;
                    f12 = Float.MIN_VALUE;
                    if (object != null) {
                        object = this.f.f.getRootView().findViewById(n11);
                        n13 = view.height;
                        this.C((View)object, n13, n12 != 0);
                    }
                    object = this.f.g;
                    int n18 = view.height;
                    this.C((View)object, n18, n12 != 0);
                }
            }
        }
    }

    public static /* synthetic */ void u(h1 h12) {
        h12.G();
    }

    public static /* synthetic */ n1 v(h1 h12) {
        return h12.f;
    }

    public static /* synthetic */ boolean w(h1 h12, boolean bl2) {
        h12.g = bl2;
        return bl2;
    }

    public static /* synthetic */ ExoVideoView x(h1 h12) {
        return h12.h;
    }

    public static /* synthetic */ ExoVideoView y(h1 h12, ExoVideoView exoVideoView) {
        h12.h = exoVideoView;
        return exoVideoView;
    }

    public static /* synthetic */ f$a z(h1 h12) {
        return h12.i;
    }

    public /* synthetic */ void E() {
        this.D();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ExoVideoView exoVideoView = this.h;
        if (exoVideoView != null) {
            exoVideoView.J();
        }
    }

    public void onPause() {
        boolean bl2;
        super.onPause();
        ExoVideoView exoVideoView = this.h;
        if (exoVideoView != null && (bl2 = exoVideoView.isPlaying())) {
            exoVideoView = this.h;
            exoVideoView.pause();
        }
    }

    public void onResume() {
        boolean bl2;
        super.onResume();
        this.G();
        ExoVideoView exoVideoView = this.h;
        if (exoVideoView != null && !(bl2 = exoVideoView.isPlaying())) {
            exoVideoView = this.h;
            exoVideoView.start();
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        this.setCancelable(false);
        object2 = (s6)b.c(this.requireActivity()).get(s6.class);
        this.f.A((s6)object2);
        Object object3 = new f(0);
        this.f.f.setAdapter((RecyclerView$Adapter)object3);
        object = (RecyclerView)this.f.f.getChildAt(0);
        this.j = object;
        object = this.f.f;
        object3 = new h1$a(this, (s6)object2);
        ((ViewPager2)((Object)object)).registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object3);
        object = new Handler();
        object2 = new f0(this);
        object.postDelayed((Runnable)object2, 3000L);
    }

    public void p(int n10) {
        super.p(n10);
        this.G();
    }

    public int s() {
        return 2131558473;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (n1)viewDataBinding;
        this.f = viewDataBinding;
        h1$b h1$b = new h1$b(this);
        ((n1)viewDataBinding).B(h1$b);
    }
}

