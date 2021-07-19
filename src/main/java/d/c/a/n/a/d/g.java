/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.n.a.d;

import com.bumptech.glide.integration.webp.WebpHeaderParser;
import d.c.a.n.a.d.h;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class g
implements d.c.a.o.g {
    public static final e c;
    private final d.c.a.o.g a;
    private final b b;

    static {
        Boolean bl2 = Boolean.FALSE;
        c = e.g("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", bl2);
    }

    public g(d.c.a.o.g g10, b b10) {
        this.a = g10;
        this.b = b10;
    }

    public s c(InputStream object, int n10, int n11, f f10) {
        if ((object = (Object)h.b((InputStream)object)) == null) {
            return null;
        }
        object = ByteBuffer.wrap((byte[])object);
        return this.a.b(object, n10, n11, f10);
    }

    public boolean d(InputStream inputStream, f object) {
        e e10 = c;
        boolean bl2 = (Boolean)(object = (Boolean)((f)object).c(e10));
        if (bl2) {
            return false;
        }
        object = this.b;
        return WebpHeaderParser.f(WebpHeaderParser.b(inputStream, (b)object));
    }
}

