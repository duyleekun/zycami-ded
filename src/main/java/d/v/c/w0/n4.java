/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.editor.EditorFragment$b;

public abstract class n4
extends ViewDataBinding {
    public final Button a;
    public final TextView b;
    public EditorFragment$b c;

    public n4(Object object, View view, int n10, Button button, TextView textView) {
        super(object, view, n10);
        this.a = button;
        this.b = textView;
    }

    public static n4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n4.t(view, dataBindingComponent);
    }

    public static n4 t(View view, Object object) {
        return (n4)ViewDataBinding.bind(object, view, 2131558531);
    }

    public static n4 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n4.y(layoutInflater, dataBindingComponent);
    }

    public static n4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n4.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n4)ViewDataBinding.inflateInternal(layoutInflater, 2131558531, viewGroup, bl2, object);
    }

    public static n4 y(LayoutInflater layoutInflater, Object object) {
        return (n4)ViewDataBinding.inflateInternal(layoutInflater, 2131558531, null, false, object);
    }

    public EditorFragment$b u() {
        return this.c;
    }

    public abstract void z(EditorFragment$b var1);
}

