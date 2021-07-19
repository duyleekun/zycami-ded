/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment$c;
import com.zhiyun.cama.widget.AudioBeatView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.i1.i2;
import d.v.c.w0.j4;
import d.v.c.y1.f.o;

public abstract class r8
extends ViewDataBinding {
    public final AudioBeatView a;
    public final j4 b;
    public final ImageButton c;
    public final ImageButton d;
    public final ImageButton e;
    public final ZYTextView f;
    public final TextView g;
    public final ZYTextView h;
    public final View i;
    public EditorAudioBeatFragment$c j;
    public o k;
    public i2 l;

    public r8(Object object, View view, int n10, AudioBeatView audioBeatView, j4 j42, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ZYTextView zYTextView, TextView textView, ZYTextView zYTextView2, View view2) {
        super(object, view, n10);
        this.a = audioBeatView;
        this.b = j42;
        this.c = imageButton;
        this.d = imageButton2;
        this.e = imageButton3;
        this.f = zYTextView;
        this.g = textView;
        this.h = zYTextView2;
        this.i = view2;
    }

    public static r8 A(LayoutInflater layoutInflater, Object object) {
        return (r8)ViewDataBinding.inflateInternal(layoutInflater, 2131558596, null, false, object);
    }

    public static r8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r8.t(view, dataBindingComponent);
    }

    public static r8 t(View view, Object object) {
        return (r8)ViewDataBinding.bind(object, view, 2131558596);
    }

    public static r8 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r8.A(layoutInflater, dataBindingComponent);
    }

    public static r8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r8.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r8 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r8)ViewDataBinding.inflateInternal(layoutInflater, 2131558596, viewGroup, bl2, object);
    }

    public abstract void B(o var1);

    public abstract void C(EditorAudioBeatFragment$c var1);

    public abstract void D(i2 var1);

    public o u() {
        return this.k;
    }

    public EditorAudioBeatFragment$c v() {
        return this.j;
    }

    public i2 w() {
        return this.l;
    }
}

