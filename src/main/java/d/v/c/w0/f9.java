/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantHelpFragment$b;

public abstract class f9
extends ViewDataBinding {
    public final FrameLayout a;
    public final FragmentContainerView b;
    public final ImageView c;
    public LiveAssistantHelpFragment.b d;

    public f9(Object object, View view, int n10, FrameLayout frameLayout, FragmentContainerView fragmentContainerView, ImageView imageView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = fragmentContainerView;
        this.c = imageView;
    }

    public static f9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f9.t(view, dataBindingComponent);
    }

    public static f9 t(View view, Object object) {
        return (f9)ViewDataBinding.bind(object, view, 2131558603);
    }

    public static f9 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f9.y(layoutInflater, dataBindingComponent);
    }

    public static f9 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f9.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f9)ViewDataBinding.inflateInternal(layoutInflater, 2131558603, viewGroup, bl2, object);
    }

    public static f9 y(LayoutInflater layoutInflater, Object object) {
        return (f9)ViewDataBinding.inflateInternal(layoutInflater, 2131558603, null, false, object);
    }

    public LiveAssistantHelpFragment.b u() {
        return this.d;
    }

    public abstract void z(LiveAssistantHelpFragment.b var1);
}

