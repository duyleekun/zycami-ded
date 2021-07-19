/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.y1.f.q;

public abstract class ub
extends ViewDataBinding {
    public final CheckBox a;
    public final ImageView b;
    public final RoundImageView c;
    public final ImageView d;
    public final ProgressBar e;
    public final TextView f;
    public final ZYTextView g;
    public final TextView h;
    public q i;
    public Integer j;
    public MusicListViewModel k;
    public Boolean l;

    public ub(Object object, View view, int n10, CheckBox checkBox, ImageView imageView, RoundImageView roundImageView, ImageView imageView2, ProgressBar progressBar, TextView textView, ZYTextView zYTextView, TextView textView2) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = imageView;
        this.c = roundImageView;
        this.d = imageView2;
        this.e = progressBar;
        this.f = textView;
        this.g = zYTextView;
        this.h = textView2;
    }

    public static ub A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ub)ViewDataBinding.inflateInternal(layoutInflater, 2131558641, viewGroup, bl2, object);
    }

    public static ub B(LayoutInflater layoutInflater, Object object) {
        return (ub)ViewDataBinding.inflateInternal(layoutInflater, 2131558641, null, false, object);
    }

    public static ub s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ub.t(view, dataBindingComponent);
    }

    public static ub t(View view, Object object) {
        return (ub)ViewDataBinding.bind(object, view, 2131558641);
    }

    public static ub y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ub.B(layoutInflater, dataBindingComponent);
    }

    public static ub z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ub.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(q var1);

    public abstract void D(MusicListViewModel var1);

    public abstract void E(Integer var1);

    public abstract void F(Boolean var1);

    public q u() {
        return this.i;
    }

    public MusicListViewModel v() {
        return this.k;
    }

    public Integer w() {
        return this.j;
    }

    public Boolean x() {
        return this.l;
    }
}

