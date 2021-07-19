/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.voice.record.EditorRecordFragment$b;
import com.zhiyun.cama.voice.record.widget.RecorderView;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.i1.i2;
import d.v.c.w0.j4;
import d.v.c.y1.g.l;

public abstract class l7
extends ViewDataBinding {
    public final j4 a;
    public final ImageView b;
    public final LinearLayout c;
    public final HorizontalScrollView d;
    public final RecorderView e;
    public final RecyclerView f;
    public final RecordingThumbView g;
    public final ZYTextView h;
    public final ZYTextView i;
    public final View j;
    public l k;
    public i2 l;
    public EditorRecordFragment$b m;

    public l7(Object object, View view, int n10, j4 j42, ImageView imageView, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView, RecorderView recorderView, RecyclerView recyclerView, RecordingThumbView recordingThumbView, ZYTextView zYTextView, ZYTextView zYTextView2, View view2) {
        super(object, view, n10);
        this.a = j42;
        this.b = imageView;
        this.c = linearLayout;
        this.d = horizontalScrollView;
        this.e = recorderView;
        this.f = recyclerView;
        this.g = recordingThumbView;
        this.h = zYTextView;
        this.i = zYTextView2;
        this.j = view2;
    }

    public static l7 A(LayoutInflater layoutInflater, Object object) {
        return (l7)ViewDataBinding.inflateInternal(layoutInflater, 2131558580, null, false, object);
    }

    public static l7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l7.t(view, dataBindingComponent);
    }

    public static l7 t(View view, Object object) {
        return (l7)ViewDataBinding.bind(object, view, 2131558580);
    }

    public static l7 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l7.A(layoutInflater, dataBindingComponent);
    }

    public static l7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l7.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l7 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l7)ViewDataBinding.inflateInternal(layoutInflater, 2131558580, viewGroup, bl2, object);
    }

    public abstract void B(EditorRecordFragment$b var1);

    public abstract void C(i2 var1);

    public abstract void D(l var1);

    public EditorRecordFragment$b u() {
        return this.m;
    }

    public i2 v() {
        return this.l;
    }

    public l w() {
        return this.k;
    }
}

