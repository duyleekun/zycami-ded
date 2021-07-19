/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.a7.f1$a;

public abstract class l1
extends ViewDataBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioButton f;
    public final RadioGroup g;
    public final TextView h;
    public f1.a i;
    public BleViewModel j;

    public l1(Object object, View view, int n10, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = imageView;
        this.d = radioButton;
        this.e = radioButton2;
        this.f = radioButton3;
        this.g = radioGroup;
        this.h = textView;
    }

    public static l1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l1.t(view, dataBindingComponent);
    }

    public static l1 t(View view, Object object) {
        return (l1)ViewDataBinding.bind(object, view, 2131558472);
    }

    public static l1 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l1.z(layoutInflater, dataBindingComponent);
    }

    public static l1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l1.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l1)ViewDataBinding.inflateInternal(layoutInflater, 2131558472, viewGroup, bl2, object);
    }

    public static l1 z(LayoutInflater layoutInflater, Object object) {
        return (l1)ViewDataBinding.inflateInternal(layoutInflater, 2131558472, null, false, object);
    }

    public abstract void A(BleViewModel var1);

    public abstract void B(f1.a var1);

    public BleViewModel u() {
        return this.j;
    }

    public f1.a v() {
        return this.i;
    }
}

