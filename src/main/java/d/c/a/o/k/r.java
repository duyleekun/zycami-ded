/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import d.c.a.o.k.r$a;
import d.c.a.o.k.s;
import d.c.a.u.k;
import d.c.a.u.o.a;
import d.c.a.u.o.a$f;
import d.c.a.u.o.c;

public final class r
implements s,
a$f {
    private static final Pools$Pool e;
    private final c a;
    private s b;
    private boolean c;
    private boolean d;

    static {
        r$a r$a = new r$a();
        e = d.c.a.u.o.a.e(20, r$a);
    }

    public r() {
        c c10;
        this.a = c10 = d.c.a.u.o.c.a();
    }

    private void a(s s10) {
        this.d = false;
        this.c = true;
        this.b = s10;
    }

    public static r c(s s10) {
        r r10 = (r)k.d((r)e.acquire());
        r10.a(s10);
        return r10;
    }

    private void e() {
        this.b = null;
        e.release(this);
    }

    public Class b() {
        return this.b.b();
    }

    public c d() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        synchronized (this) {
            Object object = this.a;
            ((c)object).c();
            boolean bl2 = this.c;
            if (!bl2) {
                String string2 = "Already unlocked";
                object = new IllegalStateException(string2);
                throw object;
            }
            bl2 = false;
            object = null;
            this.c = false;
            bl2 = this.d;
            if (bl2) {
                this.recycle();
            }
            return;
        }
    }

    public Object get() {
        return this.b.get();
    }

    public int getSize() {
        return this.b.getSize();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recycle() {
        synchronized (this) {
            boolean bl2;
            Object object = this.a;
            ((c)object).c();
            this.d = bl2 = true;
            bl2 = this.c;
            if (!bl2) {
                object = this.b;
                object.recycle();
                this.e();
            }
            return;
        }
    }
}

