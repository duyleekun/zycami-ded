/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.b$b;
import d.c.a.o.l.b$d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class b$d$a
implements b$b {
    public final /* synthetic */ b$d a;

    public b$d$a(b$d b$d) {
        this.a = b$d;
    }

    public Class a() {
        return InputStream.class;
    }

    public InputStream c(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }
}

