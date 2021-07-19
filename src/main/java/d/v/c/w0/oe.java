/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.data.database.model.Feedback$Extras;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$b;

public abstract class oe
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public FeedbackEditAddFragment$b e;
    public Feedback$Extras f;

    public oe(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = linearLayout;
    }

    public static oe s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oe.t(view, dataBindingComponent);
    }

    public static oe t(View view, Object object) {
        return (oe)ViewDataBinding.bind(object, view, 2131558696);
    }

    public static oe w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oe.z(layoutInflater, dataBindingComponent);
    }

    public static oe x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oe.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static oe y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (oe)ViewDataBinding.inflateInternal(layoutInflater, 2131558696, viewGroup, bl2, object);
    }

    public static oe z(LayoutInflater layoutInflater, Object object) {
        return (oe)ViewDataBinding.inflateInternal(layoutInflater, 2131558696, null, false, object);
    }

    public abstract void A(FeedbackEditAddFragment$b var1);

    public abstract void B(Feedback$Extras var1);

    public FeedbackEditAddFragment$b u() {
        return this.e;
    }

    public Feedback$Extras v() {
        return this.f;
    }
}

