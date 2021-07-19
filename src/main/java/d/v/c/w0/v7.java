/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 *  android.widget.RadioGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b;
import d.v.c.w0.j4;

public abstract class v7
extends ViewDataBinding {
    public final j4 a;
    public final HorizontalScrollView b;
    public final RadioGroup c;
    public final StatusView d;
    public final ViewPager2 e;
    public EditorStickerFragment$b f;

    public v7(Object object, View view, int n10, j4 j42, HorizontalScrollView horizontalScrollView, RadioGroup radioGroup, StatusView statusView, ViewPager2 viewPager2) {
        super(object, view, n10);
        this.a = j42;
        this.b = horizontalScrollView;
        this.c = radioGroup;
        this.d = statusView;
        this.e = viewPager2;
    }

    public static v7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v7.t(view, dataBindingComponent);
    }

    public static v7 t(View view, Object object) {
        return (v7)ViewDataBinding.bind(object, view, 2131558585);
    }

    public static v7 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v7.y(layoutInflater, dataBindingComponent);
    }

    public static v7 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v7.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v7)ViewDataBinding.inflateInternal(layoutInflater, 2131558585, viewGroup, bl2, object);
    }

    public static v7 y(LayoutInflater layoutInflater, Object object) {
        return (v7)ViewDataBinding.inflateInternal(layoutInflater, 2131558585, null, false, object);
    }

    public EditorStickerFragment$b u() {
        return this.f;
    }

    public abstract void z(EditorStickerFragment$b var1);
}

