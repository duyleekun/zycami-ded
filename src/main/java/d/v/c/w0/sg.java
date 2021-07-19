/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.set.SetPrivateFragment$a;
import d.v.c.q1.g0;

public abstract class sg
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final CheckBox c;
    public final ImageView d;
    public SetPrivateFragment$a e;
    public g0 f;

    public sg(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, ImageView imageView) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = checkBox3;
        this.d = imageView;
    }

    public static sg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sg.t(view, dataBindingComponent);
    }

    public static sg t(View view, Object object) {
        return (sg)ViewDataBinding.bind(object, view, 2131558762);
    }

    public static sg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sg.z(layoutInflater, dataBindingComponent);
    }

    public static sg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sg)ViewDataBinding.inflateInternal(layoutInflater, 2131558762, viewGroup, bl2, object);
    }

    public static sg z(LayoutInflater layoutInflater, Object object) {
        return (sg)ViewDataBinding.inflateInternal(layoutInflater, 2131558762, null, false, object);
    }

    public abstract void A(SetPrivateFragment$a var1);

    public abstract void B(g0 var1);

    public SetPrivateFragment$a u() {
        return this.e;
    }

    public g0 v() {
        return this.f;
    }
}

