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
import com.zhiyun.cama.voice.EditorVolumeFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.y1.e;

public abstract class t8
extends ViewDataBinding {
    public final j4 a;
    public final b5 b;
    public final NoOffsetSeekBar c;
    public final TextView d;
    public final CheckBox e;
    public e f;
    public EditorVolumeFragment$a g;

    public t8(Object object, View view, int n10, j4 j42, b5 b52, NoOffsetSeekBar noOffsetSeekBar, TextView textView, CheckBox checkBox) {
        super(object, view, n10);
        this.a = j42;
        this.b = b52;
        this.c = noOffsetSeekBar;
        this.d = textView;
        this.e = checkBox;
    }

    public static t8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t8.t(view, dataBindingComponent);
    }

    public static t8 t(View view, Object object) {
        return (t8)ViewDataBinding.bind(object, view, 2131558597);
    }

    public static t8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t8.z(layoutInflater, dataBindingComponent);
    }

    public static t8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t8)ViewDataBinding.inflateInternal(layoutInflater, 2131558597, viewGroup, bl2, object);
    }

    public static t8 z(LayoutInflater layoutInflater, Object object) {
        return (t8)ViewDataBinding.inflateInternal(layoutInflater, 2131558597, null, false, object);
    }

    public abstract void A(EditorVolumeFragment$a var1);

    public abstract void B(e var1);

    public EditorVolumeFragment$a u() {
        return this.g;
    }

    public e v() {
        return this.f;
    }
}

