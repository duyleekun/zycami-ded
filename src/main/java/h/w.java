/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q1;
import h.i0;
import h.m;
import h.m0;
import h.r;
import h.w$a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

public final class w
extends r {
    public static final w$a c;
    private final MessageDigest a;
    private final Mac b;

    static {
        w$a w$a;
        c = w$a = new w$a(null);
    }

    public w(m0 object, String string2) {
        f0.p(object, "source");
        f0.p(string2, "algorithm");
        super((m0)object);
        this.a = object = MessageDigest.getInstance(string2);
        this.b = null;
    }

    public w(m0 object, ByteString object2, String string2) {
        f0.p(object, "source");
        f0.p(object2, "key");
        Object object3 = "algorithm";
        f0.p(string2, (String)object3);
        super((m0)object);
        try {
            object = Mac.getInstance(string2);
        }
        catch (InvalidKeyException invalidKeyException) {
            super(invalidKeyException);
            throw object2;
        }
        object2 = ((ByteString)object2).toByteArray();
        object3 = new SecretKeySpec((byte[])object2, string2);
        ((Mac)object).init((Key)object3);
        object2 = q1.a;
        this.b = object;
        object = null;
        this.a = null;
    }

    public static final w B(m0 m02, ByteString byteString) {
        return c.b(m02, byteString);
    }

    public static final w C(m0 m02, ByteString byteString) {
        return c.c(m02, byteString);
    }

    public static final w D(m0 m02) {
        return c.d(m02);
    }

    public static final w E(m0 m02) {
        return c.e(m02);
    }

    public static final w O(m0 m02) {
        return c.f(m02);
    }

    public static final w S(m0 m02) {
        return c.g(m02);
    }

    public static final w q(m0 m02, ByteString byteString) {
        return c.a(m02, byteString);
    }

    public final ByteString a() {
        return this.h();
    }

    public final ByteString h() {
        Object object = this.a;
        if (object != null) {
            object = ((MessageDigest)object).digest();
        } else {
            object = this.b;
            f0.m(object);
            object = ((Mac)object).doFinal();
        }
        f0.o(object, "result");
        ByteString byteString = new ByteString((byte[])object);
        return byteString;
    }

    public long read(m m10, long l10) {
        String string2 = "sink";
        f0.p(m10, string2);
        l10 = super.read(m10, l10);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            long l13;
            long l14;
            int n10;
            long l15;
            l11 = m10.S0() - l10;
            long l16 = m10.S0();
            i0 i02 = m10.a;
            f0.m(i02);
            while ((l15 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1)) > 0) {
                i02 = i02.g;
                f0.m(i02);
                l15 = i02.c;
                n10 = i02.b;
                l14 = l15 -= n10;
                l16 -= l14;
            }
            while ((l15 = (l13 = l16 - (l14 = m10.S0())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                byte[] byArray;
                l15 = i02.b;
                l14 = (long)l15 + l11 - l16;
                l12 = (int)l14;
                Object object = this.a;
                if (object != null) {
                    byArray = i02.a;
                    n10 = i02.c - l12;
                    ((MessageDigest)object).update(byArray, (int)l12, n10);
                } else {
                    object = this.b;
                    f0.m(object);
                    byArray = i02.a;
                    n10 = i02.c - l12;
                    ((Mac)object).update(byArray, (int)l12, n10);
                }
                l12 = i02.c;
                int n11 = i02.b;
                l11 = l12 -= n11;
                l16 += l11;
                i02 = i02.f;
                f0.m(i02);
                l11 = l16;
            }
        }
        return l10;
    }
}

