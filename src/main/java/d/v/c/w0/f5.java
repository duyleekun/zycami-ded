/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.live.LiveDialog$b;

public abstract class f5
extends ViewDataBinding {
    public final View a;
    public final FrameLayout b;
    public final TextView c;
    public final Button d;
    public final Button e;
    public final TextView f;
    public final View g;
    public LiveDialog.b h;

    public f5(Object object, View view, int n10, View view2, FrameLayout frameLayout, TextView textView, Button button, Button button2, TextView textView2, View view3) {
        super(object, view, n10);
        this.a = view2;
        this.b = frameLayout;
        this.c = textView;
        this.d = button;
        this.e = button2;
        this.f = textView2;
        this.g = view3;
    }

    public static f5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f5.t(view, dataBindingComponent);
    }

    public static f5 t(View view, Object object) {
        return (f5)ViewDataBinding.bind(object, view, 2131558551);
    }

    public static f5 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f5.y(layoutInflater, dataBindingComponent);
    }

    public static f5 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f5.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f5)ViewDataBinding.inflateInternal(layoutInflater, 2131558551, viewGroup, bl2, object);
    }

    public static f5 y(LayoutInflater layoutInflater, Object object) {
        return (f5)ViewDataBinding.inflateInternal(layoutInflater, 2131558551, null, false, object);
    }

    public LiveDialog.b u() {
        return this.h;
    }

    public abstract void z(LiveDialog.b var1);
}

