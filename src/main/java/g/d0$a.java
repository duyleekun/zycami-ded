/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.h0.d;
import h.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public final class d0$a
extends Reader {
    private boolean a;
    private Reader b;
    private final o c;
    private final Charset d;

    public d0$a(o o10, Charset charset) {
        f0.p(o10, "source");
        f0.p(charset, "charset");
        this.c = o10;
        this.d = charset;
    }

    public void close() {
        boolean bl2;
        this.a = bl2 = true;
        Closeable closeable = this.b;
        if (closeable != null) {
            ((Reader)closeable).close();
        } else {
            closeable = this.c;
            closeable.close();
        }
    }

    public int read(char[] object, int n10, int n11) {
        Object object2 = "cbuf";
        f0.p(object, (String)object2);
        boolean bl2 = this.a;
        if (!bl2) {
            object2 = this.b;
            if (object2 == null) {
                InputStream inputStream = this.c.l0();
                Object object3 = this.c;
                Charset charset = this.d;
                object3 = g.h0.d.P((o)object3, charset);
                this.b = object2 = new InputStreamReader(inputStream, (Charset)object3);
            }
            return ((Reader)object2).read((char[])object, n10, n11);
        }
        object = new IOException;
        object("Stream closed");
        throw object;
    }
}

