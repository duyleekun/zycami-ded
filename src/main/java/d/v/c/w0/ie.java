/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$e;

public abstract class ie
extends ViewDataBinding {
    public final EditText a;
    public final EditText b;
    public final FrameLayout c;
    public final ImageView d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public EditProfileFragment$e p;

    public ie(Object object, View view, int n10, EditText editText, EditText editText2, FrameLayout frameLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(object, view, n10);
        this.a = editText;
        this.b = editText2;
        this.c = frameLayout;
        this.d = imageView;
        this.e = textView;
        this.f = imageView2;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
        this.l = textView7;
        this.m = textView8;
        this.n = textView9;
        this.o = textView10;
    }

    public static ie s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ie.t(view, dataBindingComponent);
    }

    public static ie t(View view, Object object) {
        return (ie)ViewDataBinding.bind(object, view, 2131558692);
    }

    public static ie v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ie.y(layoutInflater, dataBindingComponent);
    }

    public static ie w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ie.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ie x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ie)ViewDataBinding.inflateInternal(layoutInflater, 2131558692, viewGroup, bl2, object);
    }

    public static ie y(LayoutInflater layoutInflater, Object object) {
        return (ie)ViewDataBinding.inflateInternal(layoutInflater, 2131558692, null, false, object);
    }

    public EditProfileFragment$e u() {
        return this.p;
    }

    public abstract void z(EditProfileFragment$e var1);
}

