/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$c;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.ui.ShadowSeekBar;
import d.v.c.s0.u6;

public abstract class z1
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckedGroup b;
    public final RadioGroup c;
    public final CheckedGroup d;
    public final CheckedGroup e;
    public final CheckedTextView f;
    public final CheckedTextView g;
    public final RadioButton h;
    public final RadioButton i;
    public final RadioButton j;
    public final RadioButton k;
    public final RadioButton l;
    public final ShadowSeekBar m;
    public final TextView n;
    public SetStabilizerFragment$c o;
    public BleViewModel p;
    public u6 q;

    public z1(Object object, View view, int n10, CheckBox checkBox, CheckedGroup checkedGroup, RadioGroup radioGroup, CheckedGroup checkedGroup2, CheckedGroup checkedGroup3, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, ShadowSeekBar shadowSeekBar, TextView textView) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkedGroup;
        this.c = radioGroup;
        this.d = checkedGroup2;
        this.e = checkedGroup3;
        this.f = checkedTextView;
        this.g = checkedTextView2;
        this.h = radioButton;
        this.i = radioButton2;
        this.j = radioButton3;
        this.k = radioButton4;
        this.l = radioButton5;
        this.m = shadowSeekBar;
        this.n = textView;
    }

    public static z1 A(LayoutInflater layoutInflater, Object object) {
        return (z1)ViewDataBinding.inflateInternal(layoutInflater, 2131558479, null, false, object);
    }

    public static z1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z1.t(view, dataBindingComponent);
    }

    public static z1 t(View view, Object object) {
        return (z1)ViewDataBinding.bind(object, view, 2131558479);
    }

    public static z1 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z1.A(layoutInflater, dataBindingComponent);
    }

    public static z1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z1.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z1 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z1)ViewDataBinding.inflateInternal(layoutInflater, 2131558479, viewGroup, bl2, object);
    }

    public abstract void B(BleViewModel var1);

    public abstract void C(u6 var1);

    public abstract void D(SetStabilizerFragment$c var1);

    public BleViewModel u() {
        return this.p;
    }

    public u6 v() {
        return this.q;
    }

    public SetStabilizerFragment$c w() {
        return this.o;
    }
}

