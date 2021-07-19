/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.help.FeedbackEditFragment$c;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import com.zhiyun.cama.me.help.view.ScrollEditText;
import d.v.c.j1.a.o0;

public abstract class ue
extends ViewDataBinding {
    public final EditText a;
    public final ScrollEditText b;
    public final ScrollEditText c;
    public final EditText d;
    public final EditText e;
    public final FrameLayout f;
    public final ImageView g;
    public final AddImageRecyclerView h;
    public final ScrollView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public FeedbackEditFragment$c p;
    public o0 q;

    public ue(Object object, View view, int n10, EditText editText, ScrollEditText scrollEditText, ScrollEditText scrollEditText2, EditText editText2, EditText editText3, FrameLayout frameLayout, ImageView imageView, AddImageRecyclerView addImageRecyclerView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = editText;
        this.b = scrollEditText;
        this.c = scrollEditText2;
        this.d = editText2;
        this.e = editText3;
        this.f = frameLayout;
        this.g = imageView;
        this.h = addImageRecyclerView;
        this.i = scrollView;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = textView6;
    }

    public static ue s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ue.t(view, dataBindingComponent);
    }

    public static ue t(View view, Object object) {
        return (ue)ViewDataBinding.bind(object, view, 2131558699);
    }

    public static ue w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ue.z(layoutInflater, dataBindingComponent);
    }

    public static ue x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ue.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ue y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ue)ViewDataBinding.inflateInternal(layoutInflater, 2131558699, viewGroup, bl2, object);
    }

    public static ue z(LayoutInflater layoutInflater, Object object) {
        return (ue)ViewDataBinding.inflateInternal(layoutInflater, 2131558699, null, false, object);
    }

    public abstract void A(FeedbackEditFragment$c var1);

    public abstract void B(o0 var1);

    public FeedbackEditFragment$c u() {
        return this.p;
    }

    public o0 v() {
        return this.q;
    }
}

