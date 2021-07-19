/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.zhiyun.cama.camera.widget.StringScrollView;
import d.v.c.n0.e;
import d.v.c.s0.i7.j;
import d.v.c.w0.j1;
import java.util.List;

public class StringScrollView$b
extends RecyclerView$Adapter {
    private static final int c = 1;
    private static final int d;
    private List a;
    public final /* synthetic */ StringScrollView b;

    public StringScrollView$b(StringScrollView stringScrollView) {
        this.b = stringScrollView;
    }

    private /* synthetic */ void a(int n10, View view) {
        this.b.smoothScrollToPosition(n10);
    }

    public /* synthetic */ void b(int n10, View view) {
        this.a(n10, view);
    }

    public void c(e e10, int n10) {
        int n11 = this.getItemViewType(n10);
        if (n11 == 0) {
            Object object;
            float f10;
            n11 = n10 + -1;
            j1 j12 = (j1)e10.a;
            StringScrollView stringScrollView = this.b;
            int n12 = StringScrollView.d(stringScrollView);
            int n13 = 1;
            float f11 = Float.MIN_VALUE;
            if (n12 == 0 && n11 != (n12 = StringScrollView.g(stringScrollView = this.b))) {
                n12 = 0;
                stringScrollView = null;
            } else {
                n12 = n13;
            }
            String string2 = n12 != 0 ? (String)this.getData().get(n11) : "";
            j12.z(string2);
            string2 = j12.a;
            n12 = n12 != 0 ? 2131231633 : 2131232234;
            string2.setImageResource(n12);
            e10.a.executePendingBindings();
            stringScrollView = j12.b;
            string2 = j12.a;
            StringScrollView stringScrollView2 = this.b;
            int n14 = StringScrollView.g(stringScrollView2);
            if (n11 == n14) {
                n14 = n13;
            } else {
                n14 = 0;
                stringScrollView2 = null;
            }
            stringScrollView.setSelected(n14 != 0);
            stringScrollView2 = this.b;
            n14 = StringScrollView.g(stringScrollView2);
            if (n11 == n14) {
                n11 = n13;
                f10 = f11;
            } else {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            }
            j12.A(n11 != 0);
            object = this.b;
            f10 = StringScrollView.e((StringScrollView)object);
            j12 = null;
            float f12 = f10 - 0.0f;
            n11 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (n11 != 0) {
                object = this.b;
                f10 = StringScrollView.e((StringScrollView)object);
                stringScrollView.setTextSize(f10);
            }
            if ((n11 = StringScrollView.f((StringScrollView)(object = this.b))) != 0) {
                n11 = 8;
                f10 = 1.1E-44f;
                if (n10 == n13) {
                    string2.setVisibility(0);
                    stringScrollView.setVisibility(n11);
                } else {
                    string2.setVisibility(n11);
                    stringScrollView.setVisibility(0);
                }
            }
            e10 = e10.a.getRoot();
            object = new j(this, n10);
            e10.setOnClickListener((View.OnClickListener)object);
        }
    }

    public e d(ViewGroup object, int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        int n11 = 2131558471;
        layoutInflater = layoutInflater.inflate(n11, object, false);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutInflater.getLayoutParams();
        StringScrollView stringScrollView = this.b;
        int n12 = StringScrollView.k(stringScrollView);
        if (n12 > 0 && (n12 = StringScrollView.l(stringScrollView = this.b)) > 0) {
            marginLayoutParams.width = n12 = StringScrollView.k(this.b);
            stringScrollView = this.b;
            marginLayoutParams.height = n12 = StringScrollView.l(stringScrollView);
            layoutInflater.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        }
        if (n10 == (n12 = 1)) {
            Object object2 = this.b;
            n10 = StringScrollView.m((StringScrollView)object2);
            if (n10 == 0) {
                object2 = this.b;
                n10 = StringScrollView.n((StringScrollView)object2);
                int n13 = marginLayoutParams.width;
                marginLayoutParams.width = n10 = (n10 - n13) / 2;
            } else {
                object2 = this.b;
                n10 = StringScrollView.n((StringScrollView)object2);
                int n14 = marginLayoutParams.height;
                marginLayoutParams.height = n10 = (n10 - n14) / 2;
            }
            object = LayoutInflater.from((Context)object.getContext()).inflate(2131558628, object, false);
            object.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            object = DataBindingUtil.bind((View)object);
            object2 = new e((ViewDataBinding)object);
            return object2;
        }
        float f10 = StringScrollView.c(this.b);
        layoutInflater.setRotation(f10);
        ViewDataBinding viewDataBinding = DataBindingUtil.bind((View)layoutInflater);
        object = new e(viewDataBinding);
        return object;
    }

    public void e(List list) {
        this.a = list;
        this.notifyDataSetChanged();
    }

    public List getData() {
        return this.a;
    }

    public int getItemCount() {
        int n10;
        List list = this.a;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size() + 2;
        }
        return n10;
    }

    public int getItemViewType(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != 0 && n10 != (n11 = this.getItemCount() - n12)) {
            return 0;
        }
        return n12;
    }
}

