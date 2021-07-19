/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment$b;
import com.zhiyun.cama.widget.AudioBarView;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.w0.j4;
import d.v.c.y1.f.y.e;

public abstract class h7
extends ViewDataBinding {
    public final j4 a;
    public final AudioBarView b;
    public final NoOffsetSeekBar c;
    public final NoOffsetSeekBar d;
    public final NoOffsetSeekBar e;
    public final TextView f;
    public final ZYTextView g;
    public final ZYTextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final CheckBox l;
    public final View m;
    public final View n;
    public e o;
    public EditorMusicVolumeFragment$b p;

    public h7(Object object, View view, int n10, j4 j42, AudioBarView audioBarView, NoOffsetSeekBar noOffsetSeekBar, NoOffsetSeekBar noOffsetSeekBar2, NoOffsetSeekBar noOffsetSeekBar3, TextView textView, ZYTextView zYTextView, ZYTextView zYTextView2, TextView textView2, TextView textView3, TextView textView4, CheckBox checkBox, View view2, View view3) {
        super(object, view, n10);
        this.a = j42;
        this.b = audioBarView;
        this.c = noOffsetSeekBar;
        this.d = noOffsetSeekBar2;
        this.e = noOffsetSeekBar3;
        this.f = textView;
        this.g = zYTextView;
        this.h = zYTextView2;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = checkBox;
        this.m = view2;
        this.n = view3;
    }

    public static h7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h7.t(view, dataBindingComponent);
    }

    public static h7 t(View view, Object object) {
        return (h7)ViewDataBinding.bind(object, view, 2131558578);
    }

    public static h7 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h7.z(layoutInflater, dataBindingComponent);
    }

    public static h7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h7.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h7)ViewDataBinding.inflateInternal(layoutInflater, 2131558578, viewGroup, bl2, object);
    }

    public static h7 z(LayoutInflater layoutInflater, Object object) {
        return (h7)ViewDataBinding.inflateInternal(layoutInflater, 2131558578, null, false, object);
    }

    public abstract void A(EditorMusicVolumeFragment$b var1);

    public abstract void B(e var1);

    public EditorMusicVolumeFragment$b u() {
        return this.p;
    }

    public e v() {
        return this.o;
    }
}

