/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.ShadowSeekBar;

public abstract class d2
extends ViewDataBinding {
    public final RadioGroup a;
    public final ShadowSeekBar b;
    public final TextView c;

    public d2(Object object, View view, int n10, RadioGroup radioGroup, ShadowSeekBar shadowSeekBar, TextView textView) {
        super(object, view, n10);
        this.a = radioGroup;
        this.b = shadowSeekBar;
        this.c = textView;
    }

    public static d2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d2.t(view, dataBindingComponent);
    }

    public static d2 t(View view, Object object) {
        return (d2)ViewDataBinding.bind(object, view, 2131558481);
    }

    public static d2 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d2.x(layoutInflater, dataBindingComponent);
    }

    public static d2 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d2.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d2)ViewDataBinding.inflateInternal(layoutInflater, 2131558481, viewGroup, bl2, object);
    }

    public static d2 x(LayoutInflater layoutInflater, Object object) {
        return (d2)ViewDataBinding.inflateInternal(layoutInflater, 2131558481, null, false, object);
    }
}

