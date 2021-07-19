/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.Size
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.d1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.d1.e;
import d.v.c.d1.f$a;
import d.v.c.d1.h;
import d.v.c.w0.ya;
import d.v.e.l.h2;
import d.v.f.d.b;
import d.v.f.d.b$b;
import d.v.f.i.g;

public class f
extends b {
    private h g;
    private Size h;
    private int i;
    private int j;
    private int k;
    private boolean l;

    public f(LifecycleOwner lifecycleOwner, h h10) {
        this(lifecycleOwner, h10, true);
    }

    public f(LifecycleOwner lifecycleOwner, h h10, boolean bl2) {
        f$a f$a = new f$a();
        super(lifecycleOwner, h10, f$a);
        this.g = h10;
        this.l = bl2;
    }

    private void p(ya ya2) {
        int n10;
        int n11;
        RoundImageView roundImageView;
        Object object = this.h;
        if (object != null) {
            int n12;
            object = ya2.a.getLayoutParams();
            object.width = n12 = h2.b(this.h.getWidth());
            object.height = n12 = h2.b(this.h.getHeight());
            ya2.a.setLayoutParams((ViewGroup.LayoutParams)object);
            object = ya2.c.getLayoutParams();
            object.width = n12 = h2.b(this.h.getWidth() + 3);
            float f10 = this.h.getHeight() + 3;
            object.height = n12 = h2.b(f10);
            roundImageView = ya2.c;
            roundImageView.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((n11 = this.i) != 0) {
            roundImageView = ya2.a;
            roundImageView.setCornerRadius(n11);
        }
        if ((n11 = this.j) != 0) {
            object = ya2.a;
            roundImageView = object.getContext();
            n10 = this.j;
            roundImageView = d.v.f.i.g.f((Context)roundImageView, n10);
            object.setBackground((Drawable)roundImageView);
        }
        if ((n11 = this.k) != 0) {
            object = ya2.c;
            roundImageView = object.getContext();
            n10 = this.k;
            roundImageView = d.v.f.i.g.f((Context)roundImageView, n10);
            object.setBackground((Drawable)roundImageView);
        }
        ya2 = ya2.b;
        n11 = (int)(this.l ? 1 : 0);
        if (n11 != 0) {
            n11 = 0;
            object = null;
        } else {
            n11 = 8;
        }
        ya2.setVisibility(n11);
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (ya)viewDataBinding;
        object = (e)this.d().get(n10);
        ((ya)viewDataBinding).C((e)object);
        object = this.d();
        ((ya)viewDataBinding).E((ObservableList)object);
        object = this.g;
        ((ya)viewDataBinding).D((h)object);
        object = n10;
        ((ya)viewDataBinding).F((Integer)object);
        this.p((ya)viewDataBinding);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558630;
    }

    public void o(Size size, int n10, int n11, int n12) {
        this.h = size;
        this.i = n10;
        this.j = n11;
        this.k = n12;
        this.notifyDataSetChanged();
    }
}

