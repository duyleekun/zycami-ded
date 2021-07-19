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
import com.zhiyun.cama.voice.record.volume.EditorRecordVolumeFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.w0.j4;
import d.v.c.y1.g.n.b;

public abstract class n7
extends ViewDataBinding {
    public final j4 a;
    public final NoOffsetSeekBar b;
    public final TextView c;
    public final CheckBox d;
    public b e;
    public EditorRecordVolumeFragment$a f;

    public n7(Object object, View view, int n10, j4 j42, NoOffsetSeekBar noOffsetSeekBar, TextView textView, CheckBox checkBox) {
        super(object, view, n10);
        this.a = j42;
        this.b = noOffsetSeekBar;
        this.c = textView;
        this.d = checkBox;
    }

    public static n7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n7.t(view, dataBindingComponent);
    }

    public static n7 t(View view, Object object) {
        return (n7)ViewDataBinding.bind(object, view, 2131558581);
    }

    public static n7 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n7.z(layoutInflater, dataBindingComponent);
    }

    public static n7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n7.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n7)ViewDataBinding.inflateInternal(layoutInflater, 2131558581, viewGroup, bl2, object);
    }

    public static n7 z(LayoutInflater layoutInflater, Object object) {
        return (n7)ViewDataBinding.inflateInternal(layoutInflater, 2131558581, null, false, object);
    }

    public abstract void A(EditorRecordVolumeFragment$a var1);

    public abstract void B(b var1);

    public EditorRecordVolumeFragment$a u() {
        return this.f;
    }

    public b v() {
        return this.e;
    }
}

