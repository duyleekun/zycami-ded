/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.set.SetFragment$a;
import d.v.c.q1.g0;

public abstract class og
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final CheckBox c;
    public final CheckBox d;
    public final CheckBox e;
    public final ImageView f;
    public final TextView g;
    public SetFragment$a h;
    public g0 i;

    public og(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = checkBox3;
        this.d = checkBox4;
        this.e = checkBox5;
        this.f = imageView;
        this.g = textView;
    }

    public static og s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return og.t(view, dataBindingComponent);
    }

    public static og t(View view, Object object) {
        return (og)ViewDataBinding.bind(object, view, 2131558755);
    }

    public static og w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return og.z(layoutInflater, dataBindingComponent);
    }

    public static og x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return og.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static og y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (og)ViewDataBinding.inflateInternal(layoutInflater, 2131558755, viewGroup, bl2, object);
    }

    public static og z(LayoutInflater layoutInflater, Object object) {
        return (og)ViewDataBinding.inflateInternal(layoutInflater, 2131558755, null, false, object);
    }

    public abstract void A(SetFragment$a var1);

    public abstract void B(g0 var1);

    public SetFragment$a u() {
        return this.h;
    }

    public g0 v() {
        return this.i;
    }
}

