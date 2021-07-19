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
import com.zhiyun.cama.camera.liveassistant.LiveAssistantOpenSuccessDialog$a;

public abstract class ce
extends ViewDataBinding {
    public final CheckBox a;
    public final TextView b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public LiveAssistantOpenSuccessDialog.a f;

    public ce(Object object, View view, int n10, CheckBox checkBox, TextView textView, View view2, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = textView;
        this.c = view2;
        this.d = textView2;
        this.e = textView3;
    }

    public static ce s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ce.t(view, dataBindingComponent);
    }

    public static ce t(View view, Object object) {
        return (ce)ViewDataBinding.bind(object, view, 2131558679);
    }

    public static ce v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ce.y(layoutInflater, dataBindingComponent);
    }

    public static ce w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ce.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ce x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ce)ViewDataBinding.inflateInternal(layoutInflater, 2131558679, viewGroup, bl2, object);
    }

    public static ce y(LayoutInflater layoutInflater, Object object) {
        return (ce)ViewDataBinding.inflateInternal(layoutInflater, 2131558679, null, false, object);
    }

    public LiveAssistantOpenSuccessDialog.a u() {
        return this.f;
    }

    public abstract void z(LiveAssistantOpenSuccessDialog.a var1);
}

