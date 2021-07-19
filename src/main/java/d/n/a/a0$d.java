/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a;

import android.bluetooth.BluetoothDevice;
import c.b.a.c;
import d.n.a.a0;
import d.n.a.a0$a;
import d.n.a.a0$c;
import d.n.a.a0$d$a;
import d.n.a.h;
import d.n.a.j0;
import d.n.a.q0.b;
import d.n.a.q0.d;
import d.n.a.q0.e;
import d.n.a.q0.f;
import d.n.a.q0.g;
import d.n.a.q0.m;
import d.n.a.q0.s.q;
import d.n.a.q0.u.z;
import d.n.a.q0.x.y;

public final class a0$d
implements b {
    private String a;
    private c b;
    private d c;
    private c d;
    private q e;
    private c f;
    private c g;
    private c h;
    private d.n.a.q0.h i;
    public final /* synthetic */ a0 j;

    private a0$d(a0 a02, a0$c a0$c) {
        this.j = a02;
        this.i(a0$c);
    }

    public /* synthetic */ a0$d(a0 a02, a0$c a0$c, a0$a a0$a) {
        this(a02, a0$c);
    }

    public static /* synthetic */ c b(a0$d a0$d) {
        return a0$d.b;
    }

    public static /* synthetic */ d.n.a.q0.h c(a0$d a0$d) {
        return a0$d.i;
    }

    public static /* synthetic */ c d(a0$d a0$d) {
        return a0$d.h;
    }

    public static /* synthetic */ BluetoothDevice e(a0$d a0$d) {
        return a0$d.g();
    }

    public static /* synthetic */ z f(a0$d a0$d) {
        return a0$d.h();
    }

    private BluetoothDevice g() {
        String string2 = this.a;
        y y10 = a0.i(this.j);
        return d.n.a.q0.d.c(string2, y10);
    }

    private z h() {
        return d.n.a.q0.g.c(d.n.a.h.c());
    }

    private void i(a0$c object) {
        c c10 = c.a.l.g.a(a0$c.b((a0$c)object));
        this.b = c10;
        c c11 = a0.j(this.j);
        c10 = d.n.a.q0.d.a(c10, c11);
        this.c = c10;
        c10 = new a0$d$a(this);
        this.d = c10;
        c10 = a0.k(this.j);
        c11 = this.d;
        c c12 = a0.c(this.j);
        c10 = q.a(c10, c11, c12);
        this.e = c10;
        c10 = c.a.l.d.b(d.n.a.q0.f.a());
        this.f = c10;
        c11 = this.c;
        c12 = this.e;
        c10 = c.a.l.d.b(m.a(c11, c12, c10));
        this.g = c10;
        this.a = object = a0$c.b((a0$c)object);
        this.h = object = c.a.l.d.b(d.n.a.q0.e.a(this.f));
        this.i = object = d.n.a.q0.h.a(d.n.a.h.a());
    }

    public j0 a() {
        return (j0)this.g.get();
    }
}

