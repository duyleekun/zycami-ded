/*
 * Decompiled with CFR 0.151.
 */
package okio;

import f.h2.t.f0;
import f.h2.t.u;
import f.q2.d;
import f.x1.n;
import h.a;
import h.i;
import h.j;
import h.q0.b;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.ByteString;

public final class ByteString$a {
    private ByteString$a() {
    }

    public /* synthetic */ ByteString$a(u u10) {
        this();
    }

    public static /* synthetic */ ByteString k(ByteString$a byteString$a, String string2, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        return byteString$a.j(string2, charset);
    }

    public static /* synthetic */ ByteString p(ByteString$a byteString$a, byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = byArray.length;
        }
        return byteString$a.o(byArray, n10, n11);
    }

    public final ByteString a(String string2) {
        f0.p(string2, "string");
        return this.h(string2);
    }

    public final ByteString b(String string2) {
        f0.p(string2, "string");
        return this.i(string2);
    }

    public final ByteString c(String string2, Charset charset) {
        f0.p(string2, "string");
        f0.p(charset, "charset");
        return this.j(string2, charset);
    }

    public final ByteString d(String string2) {
        f0.p(string2, "string");
        return this.l(string2);
    }

    public final ByteString e(ByteBuffer byteBuffer) {
        f0.p(byteBuffer, "buffer");
        return this.m(byteBuffer);
    }

    public final ByteString f(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "array");
        return this.o(byArray, n10, n11);
    }

    public final ByteString g(InputStream inputStream, int n10) {
        f0.p(inputStream, "inputstream");
        return this.q(inputStream, n10);
    }

    public final ByteString h(String object) {
        Object object2 = "$this$decodeBase64";
        f0.p(object, (String)object2);
        object = a.a((String)object);
        object2 = object != null ? new ByteString((byte[])object) : null;
        return object2;
    }

    public final ByteString i(String object) {
        Object object2 = "$this$decodeHex";
        f0.p(object, (String)object2);
        int n10 = ((String)object).length() % 2;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            n10 = ((String)object).length() / 2;
            byte[] byArray = new byte[n10];
            while (n11 < n10) {
                int n13 = n11 * 2;
                int n14 = b.b(((String)object).charAt(n13)) << 4;
                n13 += n12;
                n13 = b.b(((String)object).charAt(n13));
                n14 += n13;
                byArray[n11] = n13 = (int)((byte)n14);
                ++n11;
            }
            object = new ByteString(byArray);
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected hex string: ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public final ByteString j(String object, Charset charset) {
        f0.p(object, "$this$encode");
        f0.p(charset, "charset");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString((byte[])object);
        return byteString;
    }

    public final ByteString l(String string2) {
        f0.p(string2, "$this$encodeUtf8");
        byte[] byArray = i.a(string2);
        ByteString byteString = new ByteString(byArray);
        byteString.setUtf8$okio(string2);
        return byteString;
    }

    public final ByteString m(ByteBuffer comparable) {
        f0.p(comparable, "$this$toByteString");
        byte[] byArray = new byte[comparable.remaining()];
        comparable.get(byArray);
        comparable = new ByteString(byArray);
        return comparable;
    }

    public final ByteString n(byte ... byArray) {
        f0.p(byArray, "data");
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        ByteString byteString = new ByteString(byArray);
        return byteString;
    }

    public final ByteString o(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$toByteString");
        long l10 = byArray.length;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        byArray = n.G1(byArray, n10, n11 += n10);
        ByteString byteString = new ByteString(byArray);
        return byteString;
    }

    public final ByteString q(InputStream object, int n10) {
        byte[] byArray;
        boolean bl2;
        f0.p(object, "$this$readByteString");
        int n11 = 0;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2) {
            byArray = new byte[n10];
            while (n11 < n10) {
                int n12;
                int n13 = n10 - n11;
                if ((n13 = ((InputStream)object).read(byArray, n11, n13)) != (n12 = -1)) {
                    n11 += n13;
                    continue;
                }
                object = new EOFException();
                throw object;
            }
            object = new ByteString(byArray);
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

