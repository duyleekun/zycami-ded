/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.me.help.FeedbackDetailAddFragment$b;

public abstract class me
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final TextView e;
    public FeedbackDetailAddFragment$b f;

    public me(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = recyclerView;
        this.e = textView;
    }

    public static me s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return me.t(view, dataBindingComponent);
    }

    public static me t(View view, Object object) {
        return (me)ViewDataBinding.bind(object, view, 2131558695);
    }

    public static me v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return me.y(layoutInflater, dataBindingComponent);
    }

    public static me w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return me.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static me x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (me)ViewDataBinding.inflateInternal(layoutInflater, 2131558695, viewGroup, bl2, object);
    }

    public static me y(LayoutInflater layoutInflater, Object object) {
        return (me)ViewDataBinding.inflateInternal(layoutInflater, 2131558695, null, false, object);
    }

    public FeedbackDetailAddFragment$b u() {
        return this.f;
    }

    public abstract void z(FeedbackDetailAddFragment$b var1);
}

