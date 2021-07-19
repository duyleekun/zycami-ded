/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
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
import d.v.c.s0.a7.c1$a;
import d.v.c.s0.a7.c1$b;
import d.v.c.s0.s6;
import d.v.c.w0.b1;
import d.v.f.g.a;
import d.v.i0.b;

public class c1
extends a {
    private static int l;
    private b1 f;
    private s6 g;
    private f h;
    private ExoVideoView i;
    private f$a j;
    private RecyclerView k;

    public static /* synthetic */ f$a A(c1 c12) {
        return c12.j;
    }

    public static /* synthetic */ f$a B(c1 c12, f$a f$a) {
        c12.j = f$a;
        return f$a;
    }

    public static /* synthetic */ RecyclerView C(c1 c12) {
        return c12.k;
    }

    private void D(View view, int n10, boolean bl2) {
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

    public static c1 E(int n10) {
        l = n10;
        c1 c12 = new c1();
        return c12;
    }

    private void F() {
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
                    object = this.f.g.getRootView().findViewById(n11);
                    if (object != null) {
                        object = this.f.g.getRootView().findViewById(n11);
                        n13 = view.height;
                        this.D((View)object, n13, false);
                    }
                    object = this.f.h;
                    int n16 = view.height;
                    this.D((View)object, n16, false);
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
                    object = this.f.g.getRootView().findViewById(n11);
                    n12 = 1;
                    f12 = Float.MIN_VALUE;
                    if (object != null) {
                        object = this.f.g.getRootView().findViewById(n11);
                        n13 = view.height;
                        this.D((View)object, n13, n12 != 0);
                    }
                    object = this.f.h;
                    int n18 = view.height;
                    this.D((View)object, n18, n12 != 0);
                }
            }
        }
    }

    public static /* synthetic */ void u(c1 c12) {
        c12.F();
    }

    public static /* synthetic */ b1 v(c1 c12) {
        return c12.f;
    }

    public static /* synthetic */ int w() {
        return l;
    }

    public static /* synthetic */ s6 x(c1 c12) {
        return c12.g;
    }

    public static /* synthetic */ ExoVideoView y(c1 c12) {
        return c12.i;
    }

    public static /* synthetic */ ExoVideoView z(c1 c12, ExoVideoView exoVideoView) {
        c12.i = exoVideoView;
        return exoVideoView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ExoVideoView exoVideoView = this.i;
        if (exoVideoView != null) {
            exoVideoView.J();
        }
    }

    public void onPause() {
        boolean bl2;
        super.onPause();
        ExoVideoView exoVideoView = this.i;
        if (exoVideoView != null && (bl2 = exoVideoView.isPlaying())) {
            exoVideoView = this.i;
            exoVideoView.pause();
        }
    }

    public void onResume() {
        boolean bl2;
        super.onResume();
        this.F();
        ExoVideoView exoVideoView = this.i;
        if (exoVideoView != null && !(bl2 = exoVideoView.isPlaying())) {
            exoVideoView = this.i;
            exoVideoView.start();
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        this.setCancelable(false);
        object2 = (s6)b.c(this.requireActivity()).get(s6.class);
        this.g = object2;
        this.f.A((s6)object2);
        object2 = new f(1);
        this.h = object2;
        this.f.g.setAdapter((RecyclerView$Adapter)object2);
        object = (RecyclerView)this.f.g.getChildAt(0);
        this.k = object;
        object = this.f.g;
        object2 = new c1$a(this);
        ((ViewPager2)((Object)object)).registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
    }

    public void p(int n10) {
        super.p(n10);
        this.F();
    }

    public int s() {
        return 2131558467;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (b1)viewDataBinding;
        this.f = viewDataBinding;
        c1$b c1$b = new c1$b(this);
        ((b1)viewDataBinding).B(c1$b);
    }
}

