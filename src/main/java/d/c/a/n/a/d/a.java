/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import d.c.a.m.a$a;
import d.c.a.n.a.d.h;
import d.c.a.n.a.d.i;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.g;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a {
    public static final d.c.a.o.e d;
    private final b a;
    private final e b;
    private final d.c.a.o.m.h.b c;

    static {
        Boolean bl2 = Boolean.FALSE;
        d = d.c.a.o.e.g("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", bl2);
    }

    public a(b b10, e e10) {
        d.c.a.o.m.h.b b11;
        this.a = b10;
        this.b = e10;
        this.c = b11 = new d.c.a.o.m.h.b(e10, b10);
    }

    public s a(InputStream object, int n10, int n11, f f10) {
        if ((object = (Object)h.b((InputStream)object)) == null) {
            return null;
        }
        object = ByteBuffer.wrap((byte[])object);
        return this.b((ByteBuffer)object, n10, n11, f10);
    }

    public s b(ByteBuffer object, int n10, int n11, f object2) {
        int n12 = ((Buffer)object).remaining();
        Object object3 = new byte[n12];
        ((ByteBuffer)object).get((byte[])object3, 0, n12);
        object2 = WebpImage.create(object3);
        int n13 = ((WebpImage)object2).getWidth();
        int n14 = ((WebpImage)object2).getHeight();
        n10 = h.a(n13, n14, n10, n11);
        object3 = this.c;
        i i10 = new i((a$a)object3, (WebpImage)object2, (ByteBuffer)object, n10);
        try {
            i10.b();
            object = i10.a();
            e e10 = this.b;
            object = g.d((Bitmap)object, e10);
            return object;
        }
        finally {
            i10.clear();
        }
    }

    public boolean c(InputStream inputStream, f object) {
        d.c.a.o.e e10 = d;
        boolean bl2 = (Boolean)(object = (Boolean)((f)object).c(e10));
        if (bl2) {
            return false;
        }
        object = this.a;
        return WebpHeaderParser.f(WebpHeaderParser.b(inputStream, (b)object));
    }

    public boolean d(ByteBuffer byteBuffer, f object) {
        d.c.a.o.e e10 = d;
        boolean bl2 = (Boolean)(object = (Boolean)((f)object).c(e10));
        if (bl2) {
            return false;
        }
        return WebpHeaderParser.f(WebpHeaderParser.c(byteBuffer));
    }
}

