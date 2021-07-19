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
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.y1.f.q;

public abstract class wb
extends ViewDataBinding {
    public final RoundImageView a;
    public final TextView b;
    public final TextView c;
    public final ZYTextView d;
    public q e;
    public Integer f;
    public MusicLocalImportViewModel g;

    public wb(Object object, View view, int n10, RoundImageView roundImageView, TextView textView, TextView textView2, ZYTextView zYTextView) {
        super(object, view, n10);
        this.a = roundImageView;
        this.b = textView;
        this.c = textView2;
        this.d = zYTextView;
    }

    public static wb A(LayoutInflater layoutInflater, Object object) {
        return (wb)ViewDataBinding.inflateInternal(layoutInflater, 2131558642, null, false, object);
    }

    public static wb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wb.t(view, dataBindingComponent);
    }

    public static wb t(View view, Object object) {
        return (wb)ViewDataBinding.bind(object, view, 2131558642);
    }

    public static wb x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wb.A(layoutInflater, dataBindingComponent);
    }

    public static wb y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wb.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wb z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wb)ViewDataBinding.inflateInternal(layoutInflater, 2131558642, viewGroup, bl2, object);
    }

    public abstract void B(MusicLocalImportViewModel var1);

    public abstract void C(q var1);

    public abstract void D(Integer var1);

    public MusicLocalImportViewModel u() {
        return this.g;
    }

    public q v() {
        return this.e;
    }

    public Integer w() {
        return this.f;
    }
}

