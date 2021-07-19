/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.widget.HintLayout$a;
import com.zhiyun.cama.camera.widget.HintLayout$b;

public abstract class qi
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public HintLayout.a e;
    public HintLayout.b f;

    public qi(Object object, View view, int n10, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
        this.d = textView2;
    }

    public static qi s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qi.t(view, dataBindingComponent);
    }

    public static qi t(View view, Object object) {
        return (qi)ViewDataBinding.bind(object, view, 2131558812);
    }

    public static qi w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qi.z(layoutInflater, dataBindingComponent);
    }

    public static qi x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qi.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qi y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qi)ViewDataBinding.inflateInternal(layoutInflater, 2131558812, viewGroup, bl2, object);
    }

    public static qi z(LayoutInflater layoutInflater, Object object) {
        return (qi)ViewDataBinding.inflateInternal(layoutInflater, 2131558812, null, false, object);
    }

    public abstract void A(HintLayout.a var1);

    public abstract void B(HintLayout.b var1);

    public HintLayout.a u() {
        return this.e;
    }

    public HintLayout.b v() {
        return this.f;
    }
}

