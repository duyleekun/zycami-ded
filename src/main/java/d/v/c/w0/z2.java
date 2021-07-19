/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.device.connection.BleDevice$State;

public abstract class z2
extends ViewDataBinding {
    public final Button a;
    public final TextView b;
    public BleDevice$State c;
    public boolean d;
    public String e;

    public z2(Object object, View view, int n10, Button button, TextView textView) {
        super(object, view, n10);
        this.a = button;
        this.b = textView;
    }

    public static z2 A(LayoutInflater layoutInflater, Object object) {
        return (z2)ViewDataBinding.inflateInternal(layoutInflater, 2131558510, null, false, object);
    }

    public static z2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z2.t(view, dataBindingComponent);
    }

    public static z2 t(View view, Object object) {
        return (z2)ViewDataBinding.bind(object, view, 2131558510);
    }

    public static z2 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z2.A(layoutInflater, dataBindingComponent);
    }

    public static z2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z2.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z2 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z2)ViewDataBinding.inflateInternal(layoutInflater, 2131558510, viewGroup, bl2, object);
    }

    public abstract void B(boolean var1);

    public abstract void C(String var1);

    public abstract void D(BleDevice$State var1);

    public boolean u() {
        return this.d;
    }

    public String v() {
        return this.e;
    }

    public BleDevice$State w() {
        return this.c;
    }
}

