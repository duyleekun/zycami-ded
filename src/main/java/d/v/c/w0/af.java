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
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;

public abstract class af
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public FeedbackSet$DealStatus d;
    public String e;

    public af(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static af s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return af.t(view, dataBindingComponent);
    }

    public static af t(View view, Object object) {
        return (af)ViewDataBinding.bind(object, view, 2131558702);
    }

    public static af w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return af.z(layoutInflater, dataBindingComponent);
    }

    public static af x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return af.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static af y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (af)ViewDataBinding.inflateInternal(layoutInflater, 2131558702, viewGroup, bl2, object);
    }

    public static af z(LayoutInflater layoutInflater, Object object) {
        return (af)ViewDataBinding.inflateInternal(layoutInflater, 2131558702, null, false, object);
    }

    public abstract void A(FeedbackSet$DealStatus var1);

    public abstract void B(String var1);

    public FeedbackSet$DealStatus u() {
        return this.d;
    }

    public String v() {
        return this.e;
    }
}

