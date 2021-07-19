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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.v0.i;
import d.v.c.y1.f.v.i$a;

public abstract class v5
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final RecyclerView c;
    public final SwipeRefreshLayout d;
    public final StatusView e;
    public final TextView f;
    public MusicListViewModel g;
    public i h;
    public i$a i;

    public v5(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = recyclerView;
        this.d = swipeRefreshLayout;
        this.e = statusView;
        this.f = textView;
    }

    public static v5 A(LayoutInflater layoutInflater, Object object) {
        return (v5)ViewDataBinding.inflateInternal(layoutInflater, 2131558559, null, false, object);
    }

    public static v5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v5.t(view, dataBindingComponent);
    }

    public static v5 t(View view, Object object) {
        return (v5)ViewDataBinding.bind(object, view, 2131558559);
    }

    public static v5 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v5.A(layoutInflater, dataBindingComponent);
    }

    public static v5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v5.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v5 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v5)ViewDataBinding.inflateInternal(layoutInflater, 2131558559, viewGroup, bl2, object);
    }

    public abstract void B(i$a var1);

    public abstract void C(i var1);

    public abstract void D(MusicListViewModel var1);

    public i$a u() {
        return this.i;
    }

    public i v() {
        return this.h;
    }

    public MusicListViewModel w() {
        return this.g;
    }
}

