/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.data.api.entity.sticker.StickerTabInfo;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b;
import d.v.c.x0.b.s;

public abstract class ic
extends ViewDataBinding {
    public s a;
    public StickerTabInfo b;
    public EditorStickerFragment$b c;

    public ic(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static ic A(LayoutInflater layoutInflater, Object object) {
        return (ic)ViewDataBinding.inflateInternal(layoutInflater, 2131558648, null, false, object);
    }

    public static ic s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ic.t(view, dataBindingComponent);
    }

    public static ic t(View view, Object object) {
        return (ic)ViewDataBinding.bind(object, view, 2131558648);
    }

    public static ic x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ic.A(layoutInflater, dataBindingComponent);
    }

    public static ic y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ic.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ic z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ic)ViewDataBinding.inflateInternal(layoutInflater, 2131558648, viewGroup, bl2, object);
    }

    public abstract void B(EditorStickerFragment$b var1);

    public abstract void C(s var1);

    public abstract void D(StickerTabInfo var1);

    public EditorStickerFragment$b u() {
        return this.c;
    }

    public s v() {
        return this.a;
    }

    public StickerTabInfo w() {
        return this.b;
    }
}

