/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.m.h;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.b;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.h.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j
implements g {
    private static final String d = "StreamGifDecoder";
    private final List a;
    private final g b;
    private final d.c.a.o.k.x.b c;

    public j(List list, g g10, d.c.a.o.k.x.b b10) {
        this.a = list;
        this.b = g10;
        this.c = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] e(InputStream inputStream) {
        int n10 = 16384;
        Object object = new ByteArrayOutputStream(n10);
        try {
            byte[] byArray = new byte[n10];
            while (true) {
                int n11;
                int n12;
                if ((n12 = inputStream.read(byArray)) == (n11 = -1)) {
                    ((OutputStream)object).flush();
                    return ((ByteArrayOutputStream)object).toByteArray();
                }
                n11 = 0;
                ((ByteArrayOutputStream)object).write(byArray, 0, n12);
            }
        }
        catch (IOException iOException) {
            String string2 = d;
            boolean bl2 = Log.isLoggable((String)string2, (int)5);
            if (bl2) {
                object = "Error reading data from stream";
                Log.w((String)string2, (String)object, (Throwable)iOException);
            }
            return null;
        }
    }

    public s c(InputStream object, int n10, int n11, f f10) {
        if ((object = (Object)j.e((InputStream)object)) == null) {
            return null;
        }
        object = ByteBuffer.wrap((byte[])object);
        return this.b.b(object, n10, n11, f10);
    }

    /*
     * WARNING - void declaration
     */
    public boolean d(InputStream object, f object2) {
        boolean bl2;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType;
        List list;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType2;
        void var2_4;
        Object object3 = i.b;
        Boolean bl3 = (Boolean)var2_4.c((e)object3);
        boolean bl4 = bl3;
        if (!bl4 && (imageHeaderParser$ImageType2 = d.c.a.o.b.e(list = this.a, object, (d.c.a.o.k.x.b)(object3 = this.c))) == (imageHeaderParser$ImageType = ImageHeaderParser$ImageType.GIF)) {
            bl2 = true;
        } else {
            bl2 = false;
            Object var1_3 = null;
        }
        return bl2;
    }
}

