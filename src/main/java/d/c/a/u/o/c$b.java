/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u.o;

import d.c.a.u.o.c;

public class c$b
extends c {
    private volatile RuntimeException b;

    public c$b() {
        super(null);
    }

    public void b(boolean bl2) {
        if (bl2) {
            RuntimeException runtimeException;
            String string2 = "Released";
            this.b = runtimeException = new RuntimeException(string2);
        } else {
            bl2 = false;
            Object var2_3 = null;
            this.b = null;
        }
    }

    public void c() {
        RuntimeException runtimeException = this.b;
        if (runtimeException == null) {
            return;
        }
        RuntimeException runtimeException2 = this.b;
        runtimeException = new IllegalStateException("Already released", runtimeException2);
        throw runtimeException;
    }
}

