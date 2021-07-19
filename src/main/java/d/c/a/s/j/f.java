/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package d.c.a.s.j;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.R$id;
import d.c.a.s.d;
import d.c.a.s.j.f$a;
import d.c.a.s.j.f$b;
import d.c.a.s.j.o;
import d.c.a.s.j.p;
import d.c.a.u.k;

public abstract class f
implements p {
    private static final String f = "CustomViewTarget";
    private static final int g = R$id.glide_custom_view_target_tag;
    private final f$b a;
    public final View b;
    private View.OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;

    public f(View view) {
        Object object;
        this.b = object = (View)k.d(view);
        super(view);
        this.a = object;
    }

    private Object c() {
        View view = this.b;
        int n10 = g;
        return view.getTag(n10);
    }

    private void e() {
        boolean bl2;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null && !(bl2 = this.e)) {
            boolean bl3;
            View view = this.b;
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.e = bl3 = true;
        }
    }

    private void f() {
        boolean bl2;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null && (bl2 = this.e)) {
            View view = this.b;
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            onAttachStateChangeListener = null;
            this.e = false;
        }
    }

    private void r(Object object) {
        View view = this.b;
        int n10 = g;
        view.setTag(n10, object);
    }

    public final void a(o o10) {
        this.a.k(o10);
    }

    public final f b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener != null) {
            return this;
        }
        this.c = onAttachStateChangeListener = new f$a(this);
        this.e();
        return this;
    }

    public final View d() {
        return this.b;
    }

    public final void g(Drawable drawable2) {
        this.e();
        this.n(drawable2);
    }

    public final d h() {
        Object object = this.c();
        if (object != null) {
            boolean bl2 = object instanceof d;
            if (bl2) {
                return (d)object;
            }
            object = new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
            throw object;
        }
        return null;
    }

    public final void i(Drawable drawable2) {
        f$b f$b = this.a;
        f$b.b();
        this.k(drawable2);
        boolean bl2 = this.d;
        if (!bl2) {
            this.f();
        }
    }

    public abstract void k(Drawable var1);

    public final void l(d d10) {
        this.r(d10);
    }

    public void n(Drawable drawable2) {
    }

    public final void o() {
        d d10 = this.h();
        if (d10 != null) {
            boolean bl2;
            this.d = bl2 = true;
            d10.clear();
            d10 = null;
            this.d = false;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void p(o o10) {
        this.a.d(o10);
    }

    public final void q() {
        boolean bl2;
        d d10 = this.h();
        if (d10 != null && (bl2 = d10.e())) {
            d10.begin();
        }
    }

    public final f s(int n10) {
        return this;
    }

    public final f t() {
        this.a.c = true;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Target for: ");
        View view = this.b;
        stringBuilder.append(view);
        return stringBuilder.toString();
    }
}

