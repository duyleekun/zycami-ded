/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.draft.EditorDraftFragment$a;

public abstract class l6
extends ViewDataBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final StatusView c;
    public final TextView d;
    public EditorDraftFragment$a e;

    public l6(Object object, View view, int n10, ImageView imageView, RecyclerView recyclerView, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = recyclerView;
        this.c = statusView;
        this.d = textView;
    }

    public static l6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l6.t(view, dataBindingComponent);
    }

    public static l6 t(View view, Object object) {
        return (l6)ViewDataBinding.bind(object, view, 2131558567);
    }

    public static l6 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l6.y(layoutInflater, dataBindingComponent);
    }

    public static l6 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l6.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l6)ViewDataBinding.inflateInternal(layoutInflater, 2131558567, viewGroup, bl2, object);
    }

    public static l6 y(LayoutInflater layoutInflater, Object object) {
        return (l6)ViewDataBinding.inflateInternal(layoutInflater, 2131558567, null, false, object);
    }

    public EditorDraftFragment$a u() {
        return this.e;
    }

    public abstract void z(EditorDraftFragment$a var1);
}

