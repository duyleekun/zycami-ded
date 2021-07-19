/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;

public abstract class qe
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final LinearLayout g;
    public final StatusView h;
    public final TextView i;
    public FeedbackDetailFragment$b j;
    public Feedback k;
    public FeedbackSet$DealStatus l;
    public PagingRequestHelper$Status m;

    public qe(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = linearLayout;
        this.h = statusView;
        this.i = textView;
    }

    public static qe A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qe)ViewDataBinding.inflateInternal(layoutInflater, 2131558697, viewGroup, bl2, object);
    }

    public static qe B(LayoutInflater layoutInflater, Object object) {
        return (qe)ViewDataBinding.inflateInternal(layoutInflater, 2131558697, null, false, object);
    }

    public static qe s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qe.t(view, dataBindingComponent);
    }

    public static qe t(View view, Object object) {
        return (qe)ViewDataBinding.bind(object, view, 2131558697);
    }

    public static qe y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qe.B(layoutInflater, dataBindingComponent);
    }

    public static qe z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qe.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(FeedbackDetailFragment$b var1);

    public abstract void D(FeedbackSet$DealStatus var1);

    public abstract void E(Feedback var1);

    public abstract void F(PagingRequestHelper$Status var1);

    public FeedbackDetailFragment$b u() {
        return this.j;
    }

    public FeedbackSet$DealStatus v() {
        return this.l;
    }

    public Feedback w() {
        return this.k;
    }

    public PagingRequestHelper$Status x() {
        return this.m;
    }
}

