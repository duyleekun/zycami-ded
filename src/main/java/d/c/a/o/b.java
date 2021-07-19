/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.b$a;
import d.c.a.o.b$b;
import d.c.a.o.b$c;
import d.c.a.o.b$d;
import d.c.a.o.b$e;
import d.c.a.o.b$f;
import d.c.a.o.b$g;
import d.c.a.o.j.m;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class b {
    private static final int a = 0x500000;

    private b() {
    }

    public static int a(List list, m m10, d.c.a.o.k.x.b b10) {
        b$e b$e = new b$e(m10, b10);
        return b.c(list, b$e);
    }

    public static int b(List list, InputStream object, d.c.a.o.k.x.b b10) {
        Object object2;
        if (object == null) {
            return -1;
        }
        boolean bl2 = ((InputStream)object).markSupported();
        if (!bl2) {
            object = object2 = new RecyclableBufferedInputStream((InputStream)object, b10);
        }
        ((InputStream)object).mark(0x500000);
        object2 = new b$d((InputStream)object, b10);
        return b.c(list, (b$f)object2);
    }

    private static int c(List list, b$f b$f) {
        int n10;
        int n11 = list.size();
        int n12 = 0;
        while (true) {
            n10 = -1;
            if (n12 >= n11) break;
            ImageHeaderParser imageHeaderParser = (ImageHeaderParser)list.get(n12);
            int n13 = b$f.a(imageHeaderParser);
            if (n13 != n10) {
                return n13;
            }
            ++n12;
        }
        return n10;
    }

    public static ImageHeaderParser$ImageType d(List list, m m10, d.c.a.o.k.x.b b10) {
        b$c b$c = new b$c(m10, b10);
        return b.g(list, b$c);
    }

    public static ImageHeaderParser$ImageType e(List list, InputStream inputStream, d.c.a.o.k.x.b object) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        boolean bl2 = inputStream.markSupported();
        if (!bl2) {
            RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, (d.c.a.o.k.x.b)object);
            inputStream = recyclableBufferedInputStream;
        }
        inputStream.mark(0x500000);
        object = new b$a(inputStream);
        return b.g(list, (b$g)object);
    }

    public static ImageHeaderParser$ImageType f(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        b$b b$b = new b$b(byteBuffer);
        return b.g(list, b$b);
    }

    private static ImageHeaderParser$ImageType g(List list, b$g b$g) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ImageHeaderParser$ImageType imageHeaderParser$ImageType;
            Object object = (ImageHeaderParser)list.get(i10);
            if ((object = b$g.a((ImageHeaderParser)object)) == (imageHeaderParser$ImageType = ImageHeaderParser$ImageType.UNKNOWN)) continue;
            return object;
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}

