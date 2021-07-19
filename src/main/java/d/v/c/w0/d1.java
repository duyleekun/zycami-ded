/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.me.help.view.MaxHeightScrollView;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.b7.k$a;

public abstract class d1
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final TextView c;
    public final TextView d;
    public final Button e;
    public final ExoVideoView f;
    public final ImageView g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final ConstraintLayout j;
    public final MaxHeightScrollView k;
    public final TextView l;
    public k.a m;
    public DynamicZoomViewModel n;
    public DynamicZoomViewModel.TargetModel o;

    public d1(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, TextView textView2, Button button, ExoVideoView exoVideoView, ImageView imageView, FrameLayout frameLayout2, FrameLayout frameLayout3, ConstraintLayout constraintLayout2, MaxHeightScrollView maxHeightScrollView, TextView textView3) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = textView;
        this.d = textView2;
        this.e = button;
        this.f = exoVideoView;
        this.g = imageView;
        this.h = frameLayout2;
        this.i = frameLayout3;
        this.j = constraintLayout2;
        this.k = maxHeightScrollView;
        this.l = textView3;
    }

    public static d1 A(LayoutInflater layoutInflater, Object object) {
        return (d1)ViewDataBinding.inflateInternal(layoutInflater, 2131558468, null, false, object);
    }

    public static d1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d1.t(view, dataBindingComponent);
    }

    public static d1 t(View view, Object object) {
        return (d1)ViewDataBinding.bind(object, view, 2131558468);
    }

    public static d1 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d1.A(layoutInflater, dataBindingComponent);
    }

    public static d1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d1.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d1 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d1)ViewDataBinding.inflateInternal(layoutInflater, 2131558468, viewGroup, bl2, object);
    }

    public abstract void B(k.a var1);

    public abstract void C(DynamicZoomViewModel.TargetModel var1);

    public abstract void D(DynamicZoomViewModel var1);

    public k.a u() {
        return this.m;
    }

    public DynamicZoomViewModel.TargetModel v() {
        return this.o;
    }

    public DynamicZoomViewModel w() {
        return this.n;
    }
}

