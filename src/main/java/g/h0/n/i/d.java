/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.i.c;
import g.h0.n.i.e;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public final class d
extends Handler {
    public static final d a;

    static {
        d d10;
        a = d10 = new d();
    }

    private d() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord serializable) {
        f0.p(serializable, "record");
        c c10 = c.d;
        String string2 = serializable.getLoggerName();
        f0.o(string2, "record.loggerName");
        int n10 = e.a(serializable);
        String string3 = serializable.getMessage();
        f0.o(string3, "record.message");
        serializable = serializable.getThrown();
        c10.a(string2, n10, string3, (Throwable)serializable);
    }
}

