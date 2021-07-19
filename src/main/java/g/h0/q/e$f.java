/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import g.a0;
import g.c0;
import g.f0;
import g.g0;
import g.h0.d;
import g.h0.i.c;
import g.h0.q.e;
import g.h0.q.e$d;
import g.h0.q.f;
import g.h0.q.f$a;
import g.s;
import g.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;

public final class e$f
implements g.f {
    public final /* synthetic */ e a;
    public final /* synthetic */ a0 b;

    public e$f(e e10, a0 a02) {
        this.a = e10;
        this.b = a02;
    }

    public void onFailure(g.e e10, IOException iOException) {
        f.h2.t.f0.p(e10, "call");
        f.h2.t.f0.p(iOException, "e");
        this.a.r(iOException, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onResponse(g.e object, c0 object2) {
        Object object3;
        e e10;
        Object object4 = "call";
        f.h2.t.f0.p(object, (String)object4);
        f.h2.t.f0.p(e10, "response");
        object = ((c0)((Object)e10)).w0();
        try {
            object4 = this.a;
            ((e)object4).o((c0)((Object)e10), (c)object);
            f.h2.t.f0.m(object);
            object = ((c)object).m();
            object4 = f.h;
            object3 = ((c0)((Object)e10)).C0();
            object4 = ((f$a)object4).a((s)object3);
        }
        catch (IOException object32) {
            if (object != null) {
                ((c)object).v();
            }
            this.a.r(object32, (c0)((Object)e10));
            d.l((Closeable)((Object)e10));
            return;
        }
        e.l(this.a, (f)object4);
        object3 = this.a;
        boolean bl2 = e.k((e)object3, (f)object4);
        if (!bl2) {
            object4 = this.a;
            synchronized (object4) {
                object3 = this.a;
                object3 = e.i((e)object3);
                ((ArrayDeque)object3).clear();
                object3 = this.a;
                int n10 = 1010;
                String string2 = "unexpected Sec-WebSocket-Extensions in response header";
                ((e)object3).close(n10, string2);
            }
        }
        try {
            object4 = new StringBuilder();
            object3 = d.i;
            ((StringBuilder)object4).append((String)object3);
            object3 = " WebSocket ";
            ((StringBuilder)object4).append((String)object3);
            object3 = this.b;
            object3 = ((a0)object3).q();
            object3 = ((t)object3).V();
            ((StringBuilder)object4).append((String)object3);
            object4 = ((StringBuilder)object4).toString();
            object3 = this.a;
            ((e)object3).t((String)object4, (e$d)object);
            object = this.a;
            object = ((e)object).s();
            object4 = this.a;
            ((g0)object).onOpen((f0)object4, (c0)((Object)e10));
            object = this.a;
            ((e)object).v();
            return;
        }
        catch (Exception exception) {
            e10 = this.a;
            bl2 = false;
            object4 = null;
            e10.r(exception, null);
        }
    }
}

