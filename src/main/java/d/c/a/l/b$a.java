/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.b;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class b$a
extends ByteArrayOutputStream {
    public final /* synthetic */ b a;

    public b$a(b b10, int n10) {
        this.a = b10;
        super(n10);
    }

    public String toString() {
        Object object;
        int n10 = this.count;
        if (n10 > 0) {
            object = this.buf;
            int n11 = n10 + -1;
            byte by2 = object[n11];
            if (by2 == (n11 = 13)) {
                n10 += -1;
            }
        }
        try {
            object = new String;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new AssertionError;
            object((Object)unsupportedEncodingException);
            throw object;
        }
        byte[] byArray = this.buf;
        Object object2 = this.a;
        object2 = b.a((b)object2);
        object2 = ((Charset)object2).name();
        object(byArray, 0, n10, (String)object2);
        return object;
    }
}

