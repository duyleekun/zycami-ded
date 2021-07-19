/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.c.v0.i;
import d.v.c.y1.f.w.f$a;

public abstract class b7
extends ViewDataBinding {
    public final RecyclerView a;
    public final SwipeRefreshLayout b;
    public final StatusView c;
    public MusicListViewModel d;
    public i e;
    public f$a f;

    public b7(Object object, View view, int n10, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StatusView statusView) {
        super(object, view, n10);
        this.a = recyclerView;
        this.b = swipeRefreshLayout;
        this.c = statusView;
    }

    public static b7 A(LayoutInflater layoutInflater, Object object) {
        return (b7)ViewDataBinding.inflateInternal(layoutInflater, 2131558575, null, false, object);
    }

    public static b7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b7.t(view, dataBindingComponent);
    }

    public static b7 t(View view, Object object) {
        return (b7)ViewDataBinding.bind(object, view, 2131558575);
    }

    public static b7 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b7.A(layoutInflater, dataBindingComponent);
    }

    public static b7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b7.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b7 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b7)ViewDataBinding.inflateInternal(layoutInflater, 2131558575, viewGroup, bl2, object);
    }

    public abstract void B(f$a var1);

    public abstract void C(i var1);

    public abstract void D(MusicListViewModel var1);

    public f$a u() {
        return this.f;
    }

    public i v() {
        return this.e;
    }

    public MusicListViewModel w() {
        return this.d;
    }
}

