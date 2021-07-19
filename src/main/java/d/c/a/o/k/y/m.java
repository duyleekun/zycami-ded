/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import androidx.core.util.Pools$Pool;
import d.c.a.o.c;
import d.c.a.o.k.y.m$a;
import d.c.a.o.k.y.m$b;
import d.c.a.u.h;
import d.c.a.u.k;
import d.c.a.u.o.a;
import d.c.a.u.o.a$d;
import java.security.MessageDigest;

public class m {
    private final h a;
    private final Pools$Pool b;

    public m() {
        Object object = new h(1000L);
        this.a = object;
        object = new m$a(this);
        this.b = object = d.c.a.u.o.a.e(10, (a$d)object);
    }

    private String a(c object) {
        m$b m$b = (m$b)k.d(this.b.acquire());
        try {
            MessageDigest messageDigest = m$b.a;
            object.b(messageDigest);
            object = m$b.a;
            object = ((MessageDigest)object).digest();
            object = d.c.a.u.m.w((byte[])object);
            return object;
        }
        finally {
            this.b.release(m$b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public String b(c c10) {
        h h10 = this.a;
        // MONITORENTER : h10
        Object object = this.a;
        object = ((h)object).j(c10);
        object = (String)object;
        // MONITOREXIT : h10
        if (object == null) {
            object = this.a(c10);
        }
        h h11 = this.a;
        // MONITORENTER : h11
        h10 = this.a;
        h10.n(c10, object);
        // MONITOREXIT : h11
        return object;
    }
}

