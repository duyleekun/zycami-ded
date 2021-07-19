/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import d.v.c.w1.c$a;

public abstract class ki
extends ViewDataBinding {
    public final Button a;
    public final Button b;
    public final CheckBox c;
    public final TextView d;
    public final View e;
    public c$a f;
    public VersionInfo g;
    public boolean h;

    public ki(Object object, View view, int n10, Button button, Button button2, CheckBox checkBox, TextView textView, View view2) {
        super(object, view, n10);
        this.a = button;
        this.b = button2;
        this.c = checkBox;
        this.d = textView;
        this.e = view2;
    }

    public static ki A(LayoutInflater layoutInflater, Object object) {
        return (ki)ViewDataBinding.inflateInternal(layoutInflater, 2131558804, null, false, object);
    }

    public static ki s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ki.t(view, dataBindingComponent);
    }

    public static ki t(View view, Object object) {
        return (ki)ViewDataBinding.bind(object, view, 2131558804);
    }

    public static ki x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ki.A(layoutInflater, dataBindingComponent);
    }

    public static ki y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ki.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ki z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ki)ViewDataBinding.inflateInternal(layoutInflater, 2131558804, viewGroup, bl2, object);
    }

    public abstract void B(c$a var1);

    public abstract void C(boolean var1);

    public abstract void D(VersionInfo var1);

    public c$a u() {
        return this.f;
    }

    public boolean v() {
        return this.h;
    }

    public VersionInfo w() {
        return this.g;
    }
}

