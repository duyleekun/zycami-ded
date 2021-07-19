/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package d.v.a.i.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.a.i.b.i;
import java.util.List;

public abstract class h
extends RecyclerView$Adapter {
    private List a;

    public abstract int a(int var1);

    public abstract void b(i var1, int var2);

    public i c(ViewGroup object, int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        n10 = this.a(n10);
        object = DataBindingUtil.inflate(layoutInflater, n10, object, false);
        i i10 = new i((ViewDataBinding)object);
        return i10;
    }

    public void d(List list) {
        this.a = list;
        this.notifyDataSetChanged();
    }

    public List getData() {
        return this.a;
    }

    public Object getItem(int n10) {
        return this.a.get(n10);
    }

    public int getItemCount() {
        return this.a.size();
    }
}

