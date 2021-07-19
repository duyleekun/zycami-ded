/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package d.v.f.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.f.d.a;
import d.v.f.d.b$a;
import d.v.f.d.b$b;
import d.v.f.d.c;
import java.util.Collection;
import java.util.List;

public abstract class b
extends RecyclerView$Adapter {
    private LifecycleOwner a;
    public ViewModel b;
    private c c;
    private ObservableArrayList d;
    private b$a e;
    private d.v.f.f.b f;

    public b(LifecycleOwner lifecycleOwner, ViewModel viewModel) {
        Object object = new ObservableArrayList();
        this.d = object;
        this.e = object = new b$a(this);
        this.a = lifecycleOwner;
        this.b = viewModel;
        this.d.addOnListChangedCallback((ObservableList$OnListChangedCallback)object);
    }

    public b(LifecycleOwner object, ViewModel viewModel, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        Object object2 = new ObservableArrayList();
        this.d = object2;
        this.e = object2 = new b$a(this);
        this.a = object;
        this.b = viewModel;
        this.c = object = new c(diffUtil$ItemCallback);
    }

    public static /* synthetic */ ObservableArrayList a(b b10) {
        return b10.d;
    }

    private /* synthetic */ void f(int n10, View view) {
        d.v.f.f.b b10 = this.f;
        if (b10 != null) {
            ObservableArrayList observableArrayList;
            int n11;
            if (n10 >= 0 && n10 < (n11 = (observableArrayList = this.d).size())) {
                observableArrayList = this.d.get(n10);
            } else {
                n11 = 0;
                observableArrayList = null;
            }
            b10.a(view, n10, observableArrayList);
        }
    }

    public void addData(Object object) {
        this.d.add(object);
    }

    public abstract void b(b$b var1, int var2, ViewDataBinding var3);

    public void c(b$b b$b, int n10, ViewDataBinding viewDataBinding, List list) {
    }

    public ObservableArrayList d() {
        return this.d;
    }

    public abstract int e(int var1);

    public /* synthetic */ void g(int n10, View view) {
        this.f(n10, view);
    }

    public int getItemCount() {
        return this.d.size();
    }

    public void h(b$b b$b, int n10) {
        Object object = b$b.a;
        this.b(b$b, n10, (ViewDataBinding)object);
        b$b.a.executePendingBindings();
        object = this.f;
        if (object != null) {
            b$b = b$b.itemView;
            object = new a(this, n10);
            b$b.setOnClickListener((View.OnClickListener)object);
        }
    }

    public void i(b$b object, int n10, List list) {
        boolean bl2 = list.isEmpty();
        if (bl2) {
            this.h((b$b)object, n10);
        } else {
            ViewDataBinding viewDataBinding = ((b$b)object).a;
            this.c((b$b)object, n10, viewDataBinding, list);
            object = ((b$b)object).a;
            ((ViewDataBinding)object).executePendingBindings();
        }
    }

    public b$b j(ViewGroup object, int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        n10 = this.e(n10);
        object = DataBindingUtil.inflate(layoutInflater, n10, (ViewGroup)object, false);
        Object object2 = this.a;
        ((ViewDataBinding)object).setLifecycleOwner((LifecycleOwner)object2);
        object2 = new b$b(this, (ViewDataBinding)object);
        return object2;
    }

    public void k() {
        ObservableArrayList observableArrayList = this.d;
        b$a b$a = this.e;
        observableArrayList.removeOnListChangedCallback(b$a);
    }

    public void l(List list) {
        this.d.clear();
        this.d.addAll((Collection)list);
    }

    public void m(List list) {
        c c10 = this.c;
        ObservableArrayList observableArrayList = this.d;
        c10.b(observableArrayList);
        this.c.a(list);
        DiffUtil.calculateDiff(this.c).dispatchUpdatesTo(this);
        this.d.clear();
        this.d.addAll((Collection)list);
    }

    public void n(d.v.f.f.b b10) {
        this.f = b10;
    }
}

