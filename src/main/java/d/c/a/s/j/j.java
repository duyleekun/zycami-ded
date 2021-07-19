/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 */
package d.c.a.s.j;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import d.c.a.s.j.r;
import d.c.a.s.k.f;
import d.c.a.s.k.f$a;

public abstract class j
extends r
implements f$a {
    private Animatable j;

    public j(ImageView imageView) {
        super((View)imageView);
    }

    public j(ImageView imageView, boolean bl2) {
        super((View)imageView, bl2);
    }

    private void t(Object object) {
        boolean bl2 = object instanceof Animatable;
        if (bl2) {
            object = (Animatable)object;
            this.j = object;
            object.start();
        } else {
            object = null;
            this.j = null;
        }
    }

    private void v(Object object) {
        this.u(object);
        this.t(object);
    }

    public void b(Drawable drawable2) {
        ((ImageView)this.b).setImageDrawable(drawable2);
    }

    public Drawable c() {
        return ((ImageView)this.b).getDrawable();
    }

    public void g(Drawable drawable2) {
        super.g(drawable2);
        this.v(null);
        this.b(drawable2);
    }

    public void i(Drawable drawable2) {
        super.i(drawable2);
        Animatable animatable = this.j;
        if (animatable != null) {
            animatable.stop();
        }
        this.v(null);
        this.b(drawable2);
    }

    public void j(Object object, f f10) {
        boolean bl2;
        if (f10 != null && (bl2 = f10.a(object, this))) {
            this.t(object);
        } else {
            this.v(object);
        }
    }

    public void m(Drawable drawable2) {
        super.m(drawable2);
        this.v(null);
        this.b(drawable2);
    }

    public void onStart() {
        Animatable animatable = this.j;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public abstract void u(Object var1);
}

