/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;

public abstract class ih
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final RingProgressBar e;
    public TemplateData f;

    public ih(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RingProgressBar ringProgressBar) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = ringProgressBar;
    }

    public static ih s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ih.t(view, dataBindingComponent);
    }

    public static ih t(View view, Object object) {
        return (ih)ViewDataBinding.bind(object, view, 2131558782);
    }

    public static ih v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ih.y(layoutInflater, dataBindingComponent);
    }

    public static ih w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ih.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ih x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ih)ViewDataBinding.inflateInternal(layoutInflater, 2131558782, viewGroup, bl2, object);
    }

    public static ih y(LayoutInflater layoutInflater, Object object) {
        return (ih)ViewDataBinding.inflateInternal(layoutInflater, 2131558782, null, false, object);
    }

    public TemplateData u() {
        return this.f;
    }

    public abstract void z(TemplateData var1);
}

