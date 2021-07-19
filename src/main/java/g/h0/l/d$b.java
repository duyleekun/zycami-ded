/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.d;
import g.h0.l.d$d;
import g.h0.l.j;
import h.n;
import h.o;
import h.z;
import java.net.Socket;

public final class d$b {
    public Socket a;
    public String b;
    public o c;
    public n d;
    private d$d e;
    private j f;
    private int g;
    private boolean h;
    private final g.h0.h.d i;

    public d$b(boolean bl2, g.h0.h.d d10) {
        f0.p(d10, "taskRunner");
        this.h = bl2;
        this.i = d10;
        Object object = d$d.a;
        this.e = object;
        this.f = object = j.a;
    }

    public static /* synthetic */ d$b z(d$b d$b, Socket socket, String string2, o o10, n n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            string2 = g.h0.d.O(socket);
        }
        if ((n12 = n11 & 4) != 0) {
            o10 = z.d(z.n(socket));
        }
        if ((n11 &= 8) != 0) {
            n10 = z.c(z.i(socket));
        }
        return d$b.y(socket, string2, o10, n10);
    }

    public final d a() {
        d d10 = new d(this);
        return d10;
    }

    public final boolean b() {
        return this.h;
    }

    public final String c() {
        String string2 = this.b;
        if (string2 == null) {
            String string3 = "connectionName";
            f0.S(string3);
        }
        return string2;
    }

    public final d$d d() {
        return this.e;
    }

    public final int e() {
        return this.g;
    }

    public final j f() {
        return this.f;
    }

    public final n g() {
        n n10 = this.d;
        if (n10 == null) {
            String string2 = "sink";
            f0.S(string2);
        }
        return n10;
    }

    public final Socket h() {
        Socket socket = this.a;
        if (socket == null) {
            String string2 = "socket";
            f0.S(string2);
        }
        return socket;
    }

    public final o i() {
        o o10 = this.c;
        if (o10 == null) {
            String string2 = "source";
            f0.S(string2);
        }
        return o10;
    }

    public final g.h0.h.d j() {
        return this.i;
    }

    public final d$b k(d$d d$d) {
        f0.p(d$d, "listener");
        this.e = d$d;
        return this;
    }

    public final d$b l(int n10) {
        this.g = n10;
        return this;
    }

    public final d$b m(j j10) {
        f0.p(j10, "pushObserver");
        this.f = j10;
        return this;
    }

    public final void n(boolean bl2) {
        this.h = bl2;
    }

    public final void o(String string2) {
        f0.p(string2, "<set-?>");
        this.b = string2;
    }

    public final void p(d$d d$d) {
        f0.p(d$d, "<set-?>");
        this.e = d$d;
    }

    public final void q(int n10) {
        this.g = n10;
    }

    public final void r(j j10) {
        f0.p(j10, "<set-?>");
        this.f = j10;
    }

    public final void s(n n10) {
        f0.p(n10, "<set-?>");
        this.d = n10;
    }

    public final void t(Socket socket) {
        f0.p(socket, "<set-?>");
        this.a = socket;
    }

    public final void u(o o10) {
        f0.p(o10, "<set-?>");
        this.c = o10;
    }

    public final d$b v(Socket socket) {
        return d$b.z(this, socket, null, null, null, 14, null);
    }

    public final d$b w(Socket socket, String string2) {
        return d$b.z(this, socket, string2, null, null, 12, null);
    }

    public final d$b x(Socket socket, String string2, o o10) {
        return d$b.z(this, socket, string2, o10, null, 8, null);
    }

    public final d$b y(Socket object, String string2, o o10, n n10) {
        f0.p(object, "socket");
        f0.p(string2, "peerName");
        f0.p(o10, "source");
        String string3 = "sink";
        f0.p(n10, string3);
        this.a = object;
        boolean bl2 = this.h;
        if (bl2) {
            object = new StringBuilder();
            string3 = g.h0.d.i;
            ((StringBuilder)object).append(string3);
            char c10 = ' ';
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            object = new StringBuilder();
            string3 = "MockWebServer ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        this.b = object;
        this.c = o10;
        this.d = n10;
        return this;
    }
}

