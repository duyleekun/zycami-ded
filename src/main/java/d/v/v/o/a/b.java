/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

import d.v.h.i.a.a;
import d.v.h.i.a.a$a;
import d.v.v.o.a.b$a;
import d.v.v.o.a.c;

public class b
implements a {
    private a$a a;
    private c b;
    private String c;

    public static /* synthetic */ a$a e(b b10) {
        return b10.a;
    }

    public void a(String string2) {
        c c10;
        this.b = c10 = d.v.v.o.a.c.d();
        this.c = string2;
    }

    public void b(long l10, long l11, int n10) {
        c c10 = this.b;
        if (c10 == null) {
            IllegalStateException illegalStateException = new IllegalStateException("NvsAudioWaveFetcher should be init");
            a$a a$a = this.a;
            String string2 = illegalStateException.getMessage();
            a$a.b(illegalStateException, string2);
            return;
        }
        String string3 = this.c;
        b$a b$a = new b$a(this, l10, l11);
        c10.j(string3, l10, l11, n10, b$a);
    }

    public void c(a$a a$a) {
        this.a = a$a;
    }

    public void cancel() {
        c c10 = this.b;
        if (c10 != null) {
            c10.b();
        }
    }

    public void d(byte[] byArray, long l10) {
    }

    public void release() {
    }
}

