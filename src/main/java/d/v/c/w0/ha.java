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
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data;

public abstract class ha
extends ViewDataBinding {
    public final CardView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public TemplateResponse.Data e;

    public ha(Object object, View view, int n10, CardView cardView, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = cardView;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    public static ha s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ha.t(view, dataBindingComponent);
    }

    public static ha t(View view, Object object) {
        return (ha)ViewDataBinding.bind(object, view, 2131558622);
    }

    public static ha v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ha.y(layoutInflater, dataBindingComponent);
    }

    public static ha w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ha.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ha x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ha)ViewDataBinding.inflateInternal(layoutInflater, 2131558622, viewGroup, bl2, object);
    }

    public static ha y(LayoutInflater layoutInflater, Object object) {
        return (ha)ViewDataBinding.inflateInternal(layoutInflater, 2131558622, null, false, object);
    }

    public TemplateResponse.Data u() {
        return this.e;
    }

    public abstract void z(TemplateResponse.Data var1);
}

