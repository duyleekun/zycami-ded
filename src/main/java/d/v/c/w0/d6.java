/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.cama.device.connect.DeviceConnectFragment$c;
import com.zhiyun.device.connection.BleDeviceViewModel;

public abstract class d6
extends ViewDataBinding {
    public final LottieAnimationView a;
    public final ConstraintLayout b;
    public final ImageButton c;
    public final ImageButton d;
    public final RecyclerView e;
    public final TextView f;
    public DeviceConnectFragment$c g;
    public BleDeviceViewModel h;

    public d6(Object object, View view, int n10, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, RecyclerView recyclerView, TextView textView) {
        super(object, view, n10);
        this.a = lottieAnimationView;
        this.b = constraintLayout;
        this.c = imageButton;
        this.d = imageButton2;
        this.e = recyclerView;
        this.f = textView;
    }

    public static d6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d6.t(view, dataBindingComponent);
    }

    public static d6 t(View view, Object object) {
        return (d6)ViewDataBinding.bind(object, view, 2131558563);
    }

    public static d6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d6.z(layoutInflater, dataBindingComponent);
    }

    public static d6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d6)ViewDataBinding.inflateInternal(layoutInflater, 2131558563, viewGroup, bl2, object);
    }

    public static d6 z(LayoutInflater layoutInflater, Object object) {
        return (d6)ViewDataBinding.inflateInternal(layoutInflater, 2131558563, null, false, object);
    }

    public abstract void A(DeviceConnectFragment$c var1);

    public abstract void B(BleDeviceViewModel var1);

    public DeviceConnectFragment$c u() {
        return this.g;
    }

    public BleDeviceViewModel v() {
        return this.h;
    }
}

