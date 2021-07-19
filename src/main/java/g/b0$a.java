/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.b0;
import g.b0$a$a;
import g.b0$a$b;
import g.b0$a$c;
import g.h0.d;
import g.v;
import g.v$a;
import java.io.File;
import java.nio.charset.Charset;
import okio.ByteString;

public final class b0$a {
    private b0$a() {
    }

    public /* synthetic */ b0$a(u u10) {
        this();
    }

    public static /* synthetic */ b0 n(b0$a b0$a, File file, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return b0$a.a(file, v10);
    }

    public static /* synthetic */ b0 o(b0$a b0$a, String string2, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return b0$a.b(string2, v10);
    }

    public static /* synthetic */ b0 p(b0$a b0$a, v v10, byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 4;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 8) != 0) {
            n11 = byArray.length;
        }
        return b0$a.h(v10, byArray, n10, n11);
    }

    public static /* synthetic */ b0 q(b0$a b0$a, ByteString byteString, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return b0$a.i(byteString, v10);
    }

    public static /* synthetic */ b0 r(b0$a b0$a, byte[] byArray, v v10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            v10 = null;
        }
        if ((n13 = n12 & 2) != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = byArray.length;
        }
        return b0$a.m(byArray, v10, n10, n11);
    }

    public final b0 a(File file, v v10) {
        f0.p(file, "$this$asRequestBody");
        b0$a$a b0$a$a = new b0$a$a(file, v10);
        return b0$a$a;
    }

    public final b0 b(String object, v object2) {
        int n10;
        f0.p(object, "$this$toRequestBody");
        Charset charset = f.q2.d.a;
        if (object2 != null) {
            n10 = 1;
            StringBuilder stringBuilder = null;
            Object object3 = v.g((v)object2, null, n10, null);
            if (object3 == null) {
                object3 = v.i;
                stringBuilder = new StringBuilder();
                stringBuilder.append(object2);
                stringBuilder.append("; charset=utf-8");
                object2 = stringBuilder.toString();
                object2 = ((v$a)object3).d((String)object2);
            } else {
                charset = object3;
            }
        }
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        n10 = ((Object)object).length;
        return this.m((byte[])object, (v)object2, 0, n10);
    }

    public final b0 c(v v10, File file) {
        f0.p(file, "file");
        return this.a(file, v10);
    }

    public final b0 d(v v10, String string2) {
        f0.p(string2, "content");
        return this.b(string2, v10);
    }

    public final b0 e(v v10, ByteString byteString) {
        f0.p(byteString, "content");
        return this.i(byteString, v10);
    }

    public final b0 f(v v10, byte[] byArray) {
        return b0$a.p(this, v10, byArray, 0, 0, 12, null);
    }

    public final b0 g(v v10, byte[] byArray, int n10) {
        return b0$a.p(this, v10, byArray, n10, 0, 8, null);
    }

    public final b0 h(v v10, byte[] byArray, int n10, int n11) {
        f0.p(byArray, "content");
        return this.m(byArray, v10, n10, n11);
    }

    public final b0 i(ByteString byteString, v v10) {
        f0.p(byteString, "$this$toRequestBody");
        b0$a$b b0$a$b = new b0$a$b(byteString, v10);
        return b0$a$b;
    }

    public final b0 j(byte[] byArray) {
        return b0$a.r(this, byArray, null, 0, 0, 7, null);
    }

    public final b0 k(byte[] byArray, v v10) {
        return b0$a.r(this, byArray, v10, 0, 0, 6, null);
    }

    public final b0 l(byte[] byArray, v v10, int n10) {
        return b0$a.r(this, byArray, v10, n10, 0, 4, null);
    }

    public final b0 m(byte[] byArray, v v10, int n10, int n11) {
        f0.p(byArray, "$this$toRequestBody");
        long l10 = byArray.length;
        long l11 = n10;
        long l12 = n11;
        d.k(l10, l11, l12);
        b0$a$c b0$a$c = new b0$a$c(byArray, v10, n11, n10);
        return b0$a$c;
    }
}

