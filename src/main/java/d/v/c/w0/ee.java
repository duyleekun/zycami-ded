/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$c;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.c.s0.e7.s;

public abstract class ee
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public BleViewModel j;
    public DeviceViewModel k;
    public s l;
    public LiveAssistantFragment.c m;

    public ee(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = linearLayout;
        this.g = linearLayout2;
        this.h = textView;
        this.i = textView2;
    }

    public static ee A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ee)ViewDataBinding.inflateInternal(layoutInflater, 2131558680, viewGroup, bl2, object);
    }

    public static ee B(LayoutInflater layoutInflater, Object object) {
        return (ee)ViewDataBinding.inflateInternal(layoutInflater, 2131558680, null, false, object);
    }

    public static ee s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ee.t(view, dataBindingComponent);
    }

    public static ee t(View view, Object object) {
        return (ee)ViewDataBinding.bind(object, view, 2131558680);
    }

    public static ee y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ee.B(layoutInflater, dataBindingComponent);
    }

    public static ee z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ee.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(BleViewModel var1);

    public abstract void D(LiveAssistantFragment.c var1);

    public abstract void E(DeviceViewModel var1);

    public abstract void F(s var1);

    public BleViewModel u() {
        return this.j;
    }

    public LiveAssistantFragment.c v() {
        return this.m;
    }

    public DeviceViewModel w() {
        return this.k;
    }

    public s x() {
        return this.l;
    }
}

