/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.ratio.EditorRatioFragment$a;
import d.v.c.w0.j4;

public abstract class j7
extends ViewDataBinding {
    public final j4 a;
    public final CheckBox b;
    public final CheckBox c;
    public final CheckBox d;
    public final CheckBox e;
    public final CheckBox f;
    public final CheckBox g;
    public final CheckBox h;
    public final CheckBox i;
    public final CheckBox j;
    public final CheckBox k;
    public final CheckBox l;
    public final CheckBox m;
    public final CheckBox n;
    public final CheckBox o;
    public EditorRatioFragment$a p;

    public j7(Object object, View view, int n10, j4 j42, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, CheckBox checkBox12, CheckBox checkBox13, CheckBox checkBox14) {
        super(object, view, n10);
        this.a = j42;
        this.b = checkBox;
        this.c = checkBox2;
        this.d = checkBox3;
        this.e = checkBox4;
        this.f = checkBox5;
        this.g = checkBox6;
        this.h = checkBox7;
        this.i = checkBox8;
        this.j = checkBox9;
        this.k = checkBox10;
        this.l = checkBox11;
        this.m = checkBox12;
        this.n = checkBox13;
        this.o = checkBox14;
    }

    public static j7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j7.t(view, dataBindingComponent);
    }

    public static j7 t(View view, Object object) {
        return (j7)ViewDataBinding.bind(object, view, 2131558579);
    }

    public static j7 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j7.y(layoutInflater, dataBindingComponent);
    }

    public static j7 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j7.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j7)ViewDataBinding.inflateInternal(layoutInflater, 2131558579, viewGroup, bl2, object);
    }

    public static j7 y(LayoutInflater layoutInflater, Object object) {
        return (j7)ViewDataBinding.inflateInternal(layoutInflater, 2131558579, null, false, object);
    }

    public EditorRatioFragment$a u() {
        return this.p;
    }

    public abstract void z(EditorRatioFragment$a var1);
}

