/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package d.c.a.s.j;

import android.graphics.drawable.Drawable;
import d.c.a.s.d;
import d.c.a.s.j.o;
import d.c.a.s.j.p;
import d.c.a.u.m;

public abstract class e
implements p {
    private final int a;
    private final int b;
    private d c;

    public e() {
        int n10 = -1 << -1;
        this(n10, n10);
    }

    public e(int n10, int n11) {
        boolean bl2 = m.v(n10, n11);
        if (bl2) {
            this.a = n10;
            this.b = n11;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(n10);
        stringBuilder.append(" and height: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final void a(o o10) {
    }

    public void g(Drawable drawable2) {
    }

    public final d h() {
        return this.c;
    }

    public final void l(d d10) {
        this.c = d10;
    }

    public void m(Drawable drawable2) {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void p(o o10) {
        int n10 = this.a;
        int n11 = this.b;
        o10.d(n10, n11);
    }
}

