/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import d.c.a.o.b$f;
import d.c.a.o.k.x.b;
import java.io.InputStream;

public class b$d
implements b$f {
    public final /* synthetic */ InputStream a;
    public final /* synthetic */ b b;

    public b$d(InputStream inputStream, b b10) {
        this.a = inputStream;
        this.b = b10;
    }

    public int a(ImageHeaderParser imageHeaderParser) {
        try {
            InputStream inputStream = this.a;
            b b10 = this.b;
            int n10 = imageHeaderParser.d(inputStream, b10);
            return n10;
        }
        finally {
            this.a.reset();
        }
    }
}

