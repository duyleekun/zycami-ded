/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import f.q2.d;
import g.d0;
import g.d0$b$a;
import g.v;
import g.v$a;
import h.m;
import h.o;
import java.nio.charset.Charset;
import okio.ByteString;

public final class d0$b {
    private d0$b() {
    }

    public /* synthetic */ d0$b(u u10) {
        this();
    }

    public static /* synthetic */ d0 i(d0$b d0$b, String string2, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return d0$b.a(string2, v10);
    }

    public static /* synthetic */ d0 j(d0$b d0$b, o o10, v v10, long l10, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            v10 = null;
        }
        if ((n10 &= 2) != 0) {
            l10 = -1;
        }
        return d0$b.f(o10, v10, l10);
    }

    public static /* synthetic */ d0 k(d0$b d0$b, ByteString byteString, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return d0$b.g(byteString, v10);
    }

    public static /* synthetic */ d0 l(d0$b d0$b, byte[] byArray, v v10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            v10 = null;
        }
        return d0$b.h(byArray, v10);
    }

    public final d0 a(String object, v object2) {
        Object object3;
        f0.p(object, "$this$toResponseBody");
        Object object4 = d.a;
        if (object2 != null) {
            int n10 = 1;
            StringBuilder stringBuilder = null;
            object3 = v.g((v)object2, null, n10, null);
            if (object3 == null) {
                object3 = v.i;
                stringBuilder = new StringBuilder();
                stringBuilder.append(object2);
                stringBuilder.append("; charset=utf-8");
                object2 = stringBuilder.toString();
                object2 = ((v$a)object3).d((String)object2);
            } else {
                object4 = object3;
            }
        }
        object3 = new m();
        object = ((m)object3).l1((String)object, (Charset)object4);
        long l10 = ((m)object).S0();
        return this.f((o)object, (v)object2, l10);
    }

    public final d0 b(v v10, long l10, o o10) {
        f0.p(o10, "content");
        return this.f(o10, v10, l10);
    }

    public final d0 c(v v10, String string2) {
        f0.p(string2, "content");
        return this.a(string2, v10);
    }

    public final d0 d(v v10, ByteString byteString) {
        f0.p(byteString, "content");
        return this.g(byteString, v10);
    }

    public final d0 e(v v10, byte[] byArray) {
        f0.p(byArray, "content");
        return this.h(byArray, v10);
    }

    public final d0 f(o o10, v v10, long l10) {
        f0.p(o10, "$this$asResponseBody");
        d0$b$a d0$b$a = new d0$b$a(o10, v10, l10);
        return d0$b$a;
    }

    public final d0 g(ByteString byteString, v v10) {
        f0.p(byteString, "$this$toResponseBody");
        m m10 = new m();
        m10 = m10.W0(byteString);
        long l10 = byteString.size();
        return this.f(m10, v10, l10);
    }

    public final d0 h(byte[] byArray, v v10) {
        f0.p(byArray, "$this$toResponseBody");
        m m10 = new m();
        m10 = m10.Z0(byArray);
        long l10 = byArray.length;
        return this.f(m10, v10, l10);
    }
}

