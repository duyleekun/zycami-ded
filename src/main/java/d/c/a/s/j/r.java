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
import d.c.a.s.j.b;
import d.c.a.s.j.o;
import d.c.a.s.j.r$a;
import d.c.a.s.j.r$b;
import d.c.a.u.k;

public abstract class r
extends b {
    private static final String g = "ViewTarget";
    private static boolean h;
    private static int i;
    public final View b;
    private final r$b c;
    private View.OnAttachStateChangeListener d;
    private boolean e;
    private boolean f;

    static {
        i = R$id.glide_custom_view_target_tag;
    }

    public r(View view) {
        Object object;
        this.b = object = (View)k.d(view);
        super(view);
        this.c = object;
    }

    public r(View view, boolean bl2) {
        this(view);
        if (bl2) {
            this.s();
        }
    }

    private Object e() {
        View view = this.b;
        int n10 = i;
        return view.getTag(n10);
    }

    private void f() {
        boolean bl2;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener != null && !(bl2 = this.f)) {
            boolean bl3;
            View view = this.b;
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f = bl3 = true;
        }
    }

    private void k() {
        boolean bl2;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener != null && (bl2 = this.f)) {
            View view = this.b;
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            onAttachStateChangeListener = null;
            this.f = false;
        }
    }

    private void q(Object object) {
        h = true;
        View view = this.b;
        int n10 = i;
        view.setTag(n10, object);
    }

    public static void r(int n10) {
        boolean bl2 = h;
        if (!bl2) {
            i = n10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        throw illegalArgumentException;
    }

    public void a(o o10) {
        this.c.k(o10);
    }

    public final r d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener != null) {
            return this;
        }
        this.d = onAttachStateChangeListener = new r$a(this);
        this.f();
        return this;
    }

    public void g(Drawable drawable2) {
        super.g(drawable2);
        this.f();
    }

    public View getView() {
        return this.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public d h() {
        Object object = this.e();
        if (object == null) return null;
        boolean bl2 = object instanceof d;
        if (bl2) {
            return (d)object;
        }
        object = new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        throw object;
    }

    public void i(Drawable object) {
        super.i((Drawable)object);
        object = this.c;
        ((r$b)object).b();
        boolean bl2 = this.e;
        if (!bl2) {
            this.k();
        }
    }

    public void l(d d10) {
        this.q(d10);
    }

    public void n() {
        d d10 = this.h();
        if (d10 != null) {
            boolean bl2;
            this.e = bl2 = true;
            d10.clear();
            d10 = null;
            this.e = false;
        }
    }

    public void o() {
        boolean bl2;
        d d10 = this.h();
        if (d10 != null && (bl2 = d10.e())) {
            d10.begin();
        }
    }

    public void p(o o10) {
        this.c.d(o10);
    }

    public final r s() {
        this.c.c = true;
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

