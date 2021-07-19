/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity$b;
import d.v.c.w0.wi;

public abstract class g
extends ViewDataBinding {
    public final FrameLayout a;
    public final wi b;
    public EditorAddVideoActivity$b c;
    public Boolean d;

    public g(Object object, View view, int n10, FrameLayout frameLayout, wi wi2) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = wi2;
    }

    public static g s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.t(view, dataBindingComponent);
    }

    public static g t(View view, Object object) {
        return (g)ViewDataBinding.bind(object, view, 2131558433);
    }

    public static g w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.z(layoutInflater, dataBindingComponent);
    }

    public static g x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static g y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (g)ViewDataBinding.inflateInternal(layoutInflater, 2131558433, viewGroup, bl2, object);
    }

    public static g z(LayoutInflater layoutInflater, Object object) {
        return (g)ViewDataBinding.inflateInternal(layoutInflater, 2131558433, null, false, object);
    }

    public abstract void A(EditorAddVideoActivity$b var1);

    public abstract void B(Boolean var1);

    public EditorAddVideoActivity$b u() {
        return this.c;
    }

    public Boolean v() {
        return this.d;
    }
}

