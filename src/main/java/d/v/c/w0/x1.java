/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.dialog.more.GestureModeFragment$a;

public abstract class x1
extends ViewDataBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final TextView c;
    public final TextView d;
    public GestureModeFragment$a e;

    public x1(Object object, View view, int n10, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = textView;
        this.d = textView2;
    }

    public static x1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x1.t(view, dataBindingComponent);
    }

    public static x1 t(View view, Object object) {
        return (x1)ViewDataBinding.bind(object, view, 2131558478);
    }

    public static x1 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x1.y(layoutInflater, dataBindingComponent);
    }

    public static x1 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x1.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x1)ViewDataBinding.inflateInternal(layoutInflater, 2131558478, viewGroup, bl2, object);
    }

    public static x1 y(LayoutInflater layoutInflater, Object object) {
        return (x1)ViewDataBinding.inflateInternal(layoutInflater, 2131558478, null, false, object);
    }

    public GestureModeFragment$a u() {
        return this.e;
    }

    public abstract void z(GestureModeFragment$a var1);
}

