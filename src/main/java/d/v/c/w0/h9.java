/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import d.v.c.w0.wi;
import d.v.c.y1.f.x.i0$a;

public abstract class h9
extends ViewDataBinding {
    public final RecyclerView a;
    public final SwipeRefreshLayout b;
    public final wi c;
    public final TextView d;
    public final StatusView e;
    public i0$a f;
    public MusicLocalImportViewModel g;

    public h9(Object object, View view, int n10, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, wi wi2, TextView textView, StatusView statusView) {
        super(object, view, n10);
        this.a = recyclerView;
        this.b = swipeRefreshLayout;
        this.c = wi2;
        this.d = textView;
        this.e = statusView;
    }

    public static h9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h9.t(view, dataBindingComponent);
    }

    public static h9 t(View view, Object object) {
        return (h9)ViewDataBinding.bind(object, view, 2131558604);
    }

    public static h9 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h9.z(layoutInflater, dataBindingComponent);
    }

    public static h9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h9.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h9)ViewDataBinding.inflateInternal(layoutInflater, 2131558604, viewGroup, bl2, object);
    }

    public static h9 z(LayoutInflater layoutInflater, Object object) {
        return (h9)ViewDataBinding.inflateInternal(layoutInflater, 2131558604, null, false, object);
    }

    public abstract void A(i0$a var1);

    public abstract void B(MusicLocalImportViewModel var1);

    public i0$a u() {
        return this.f;
    }

    public MusicLocalImportViewModel v() {
        return this.g;
    }
}

