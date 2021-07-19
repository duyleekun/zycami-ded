/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.b$a;
import d.c.a.l.c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class b
implements Closeable {
    private static final byte f = 13;
    private static final byte g = 10;
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public b(InputStream object, int n10, Charset charset) {
        if (object != null && charset != null) {
            if (n10 >= 0) {
                Charset charset2 = d.c.a.l.c.a;
                boolean bl2 = charset.equals(charset2);
                if (bl2) {
                    this.a = object;
                    this.b = charset;
                    object = new byte[n10];
                    this.c = (byte[])object;
                    return;
                }
                object = new IllegalArgumentException("Unsupported encoding");
                throw object;
            }
            object = new IllegalArgumentException("capacity <= 0");
            throw object;
        }
        throw null;
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public static /* synthetic */ Charset a(b b10) {
        return b10.b;
    }

    private void h() {
        int n10;
        Object object = this.a;
        byte[] byArray = this.c;
        int n11 = byArray.length;
        int n12 = ((InputStream)object).read(byArray, 0, n11);
        if (n12 != (n10 = -1)) {
            this.d = 0;
            this.e = n12;
            return;
        }
        object = new EOFException();
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String B() {
        InputStream inputStream = this.a;
        synchronized (inputStream) {
            int n10;
            Object object;
            int n11;
            Object object2 = this.c;
            if (object2 == null) {
                object2 = new IOException;
                String string2 = "LineReader is closed";
                ((IOException)object2)(string2);
                throw object2;
            }
            int n12 = this.d;
            int n13 = this.e;
            if (n12 >= n13) {
                this.h();
            }
            n12 = this.d;
            while (true) {
                n13 = this.e;
                n11 = 10;
                if (n12 == n13) break;
                object = this.c;
                n10 = object[n12];
                if (n10 == n11) {
                    n11 = this.d;
                    if (n12 == n11 || (n13 = object[n11 = n12 + -1]) != (n10 = 13)) {
                        n11 = n12;
                    }
                    object = new String;
                    byte[] byArray = this.c;
                    int n14 = this.d;
                    Object object3 = this.b;
                    object3 = ((Charset)object3).name();
                    object(byArray, n14, n11 -= n14, (String)object3);
                    this.d = ++n12;
                    return object;
                }
                ++n12;
            }
            object2 = new b$a;
            n13 = this.e;
            n10 = this.d;
            n13 = n13 - n10 + 80;
            ((b$a)object2)(this, n13);
            block7: while (true) {
                object = this.c;
                n10 = this.d;
                int n15 = this.e - n10;
                ((ByteArrayOutputStream)object2).write((byte[])object, n10, n15);
                this.e = n13 = -1;
                this.h();
                n13 = this.d;
                while (true) {
                    if (n13 == (n10 = this.e)) continue block7;
                    byte[] byArray = this.c;
                    n15 = byArray[n13];
                    if (n15 == n11) {
                        n11 = this.d;
                        if (n13 != n11) {
                            n15 = n13 - n11;
                            ((ByteArrayOutputStream)object2).write(byArray, n11, n15);
                        }
                        this.d = ++n13;
                        return ((ByteArrayOutputStream)object2).toString();
                    }
                    ++n13;
                }
                break;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        InputStream inputStream = this.a;
        synchronized (inputStream) {
            Object object = this.c;
            if (object != null) {
                object = null;
                this.c = null;
                object = this.a;
                ((InputStream)object).close();
            }
            return;
        }
    }

    public boolean q() {
        int n10 = this.e;
        int n11 = -1;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }
}

