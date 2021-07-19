/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.Size
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.z1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.w0.gd;
import d.v.c.z1.e;
import d.v.e.l.h2;
import d.v.f.d.b;
import d.v.f.d.b$b;
import d.v.f.i.g;

public class d
extends b {
    private Size g;
    private int h;
    private int i;
    private int j;

    public d(LifecycleOwner lifecycleOwner, e e10) {
        super(lifecycleOwner, e10);
    }

    private void p(gd gd2) {
        int n10;
        RoundImageView roundImageView;
        int n11;
        Object object = this.g;
        if (object != null) {
            object = gd2.a.getLayoutParams();
            object.width = n11 = h2.b(this.g.getWidth());
            object.height = n11 = h2.b(this.g.getHeight());
            gd2.a.setLayoutParams((ViewGroup.LayoutParams)object);
            object = gd2.b.getLayoutParams();
            object.width = n11 = h2.b(this.g.getWidth() + 3);
            float f10 = this.g.getHeight() + 3;
            object.height = n11 = h2.b(f10);
            roundImageView = gd2.b;
            roundImageView.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((n10 = this.h) != 0) {
            roundImageView = gd2.a;
            roundImageView.setCornerRadius(n10);
        }
        if ((n10 = this.i) != 0) {
            object = gd2.a;
            roundImageView = object.getContext();
            int n12 = this.i;
            roundImageView = d.v.f.i.g.f((Context)roundImageView, n12);
            object.setBackground((Drawable)roundImageView);
        }
        if ((n10 = this.j) != 0) {
            gd2 = gd2.b;
            object = gd2.getContext();
            n11 = this.j;
            object = d.v.f.i.g.f((Context)object, n11);
            gd2.setBackground((Drawable)object);
        }
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (gd)viewDataBinding;
        object = (WaterMarkBean$WaterMarkDataInfo)this.d().get(n10);
        ((gd)viewDataBinding).D((WaterMarkBean$WaterMarkDataInfo)object);
        object = (e)this.b;
        ((gd)viewDataBinding).C((e)object);
        object = n10;
        ((gd)viewDataBinding).B((Integer)object);
        this.p((gd)viewDataBinding);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558662;
    }

    public void o(Size size, int n10, int n11, int n12) {
        this.g = size;
        this.h = n10;
        this.i = n11;
        this.j = n12;
        this.notifyDataSetChanged();
    }
}

