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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;

public abstract class b0
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final SwipeRefreshLayout e;
    public final StatusView f;
    public final TextView g;

    public b0(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = recyclerView;
        this.e = swipeRefreshLayout;
        this.f = statusView;
        this.g = textView;
    }

    public static b0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b0.t(view, dataBindingComponent);
    }

    public static b0 t(View view, Object object) {
        return (b0)ViewDataBinding.bind(object, view, 2131558451);
    }

    public static b0 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b0.x(layoutInflater, dataBindingComponent);
    }

    public static b0 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b0.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b0)ViewDataBinding.inflateInternal(layoutInflater, 2131558451, viewGroup, bl2, object);
    }

    public static b0 x(LayoutInflater layoutInflater, Object object) {
        return (b0)ViewDataBinding.inflateInternal(layoutInflater, 2131558451, null, false, object);
    }
}

