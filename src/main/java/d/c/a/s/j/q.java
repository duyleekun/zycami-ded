/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 */
package d.c.a.s.j;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import d.c.a.s.j.i;
import d.c.a.s.j.j;

public abstract class q
extends j {
    public q(ImageView imageView) {
        super(imageView);
    }

    public q(ImageView imageView, boolean bl2) {
        super(imageView, bl2);
    }

    public void u(Object object) {
        int n10;
        ViewGroup.LayoutParams layoutParams = ((ImageView)this.b).getLayoutParams();
        object = this.w(object);
        if (layoutParams != null && (n10 = layoutParams.width) > 0 && (n10 = layoutParams.height) > 0) {
            int n11 = layoutParams.width;
            int n12 = layoutParams.height;
            i i10 = new i((Drawable)object, n11, n12);
            object = i10;
        }
        ((ImageView)this.b).setImageDrawable((Drawable)object);
    }

    public abstract Drawable w(Object var1);
}

