/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.widget.WheelPicker;
import d.v.c.s0.a7.x0$a;

public abstract class t1
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final RadioButton c;
    public final RadioButton d;
    public final RadioGroup e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final View j;
    public final View k;
    public final WheelPicker l;
    public final WheelPicker m;
    public final WheelPicker n;
    public x0.a o;

    public t1(Object object, View view, int n10, ImageView imageView, ImageView imageView2, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4, WheelPicker wheelPicker, WheelPicker wheelPicker2, WheelPicker wheelPicker3) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = radioButton;
        this.d = radioButton2;
        this.e = radioGroup;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = view2;
        this.j = view3;
        this.k = view4;
        this.l = wheelPicker;
        this.m = wheelPicker2;
        this.n = wheelPicker3;
    }

    public static t1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t1.t(view, dataBindingComponent);
    }

    public static t1 t(View view, Object object) {
        return (t1)ViewDataBinding.bind(object, view, 2131558476);
    }

    public static t1 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t1.y(layoutInflater, dataBindingComponent);
    }

    public static t1 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t1.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t1)ViewDataBinding.inflateInternal(layoutInflater, 2131558476, viewGroup, bl2, object);
    }

    public static t1 y(LayoutInflater layoutInflater, Object object) {
        return (t1)ViewDataBinding.inflateInternal(layoutInflater, 2131558476, null, false, object);
    }

    public x0.a u() {
        return this.o;
    }

    public abstract void z(x0.a var1);
}

