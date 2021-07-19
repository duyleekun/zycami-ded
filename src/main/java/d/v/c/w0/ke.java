/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.help.view.MaxHeightScrollView;

public abstract class ke
extends ViewDataBinding {
    public final LinearLayout a;
    public final RadioGroup b;
    public final MaxHeightScrollView c;
    public final TextView d;
    public String e;

    public ke(Object object, View view, int n10, LinearLayout linearLayout, RadioGroup radioGroup, MaxHeightScrollView maxHeightScrollView, TextView textView) {
        super(object, view, n10);
        this.a = linearLayout;
        this.b = radioGroup;
        this.c = maxHeightScrollView;
        this.d = textView;
    }

    public static ke s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ke.t(view, dataBindingComponent);
    }

    public static ke t(View view, Object object) {
        return (ke)ViewDataBinding.bind(object, view, 2131558694);
    }

    public static ke v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ke.y(layoutInflater, dataBindingComponent);
    }

    public static ke w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ke.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ke x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ke)ViewDataBinding.inflateInternal(layoutInflater, 2131558694, viewGroup, bl2, object);
    }

    public static ke y(LayoutInflater layoutInflater, Object object) {
        return (ke)ViewDataBinding.inflateInternal(layoutInflater, 2131558694, null, false, object);
    }

    public String u() {
        return this.e;
    }

    public abstract void z(String var1);
}

