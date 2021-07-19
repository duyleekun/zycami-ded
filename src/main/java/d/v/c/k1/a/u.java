/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 */
package d.v.c.k1.a;

import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.image.Images;
import d.v.c.k1.a.w;
import d.v.c.w0.qb;
import d.v.f.d.b;
import d.v.f.d.b$b;
import d.v.h.e.a;

public class u
extends b {
    private w g;

    public u(LifecycleOwner lifecycleOwner, w w10) {
        super(lifecycleOwner, w10);
        this.g = w10;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (qb)viewDataBinding;
        object = (a)this.d().get(n10);
        ImageView imageView = ((qb)viewDataBinding).a;
        String string2 = ((a)object).i();
        Images.e(imageView, string2);
        ((qb)viewDataBinding).A((a)object);
        object = this.g;
        ((qb)viewDataBinding).B((w)object);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558639;
    }
}

