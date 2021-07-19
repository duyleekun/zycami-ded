/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q1;
import h.i0;
import h.j;
import h.k0;
import h.m;
import h.q;
import h.v$a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

public final class v
extends q {
    public static final v$a d;
    private final MessageDigest b;
    private final Mac c;

    static {
        v$a v$a;
        d = v$a = new v$a(null);
    }

    public v(k0 object, String string2) {
        f0.p(object, "sink");
        f0.p(string2, "algorithm");
        super((k0)object);
        this.b = object = MessageDigest.getInstance(string2);
        this.c = null;
    }

    public v(k0 object, ByteString object2, String string2) {
        f0.p(object, "sink");
        f0.p(object2, "key");
        Object object3 = "algorithm";
        f0.p(string2, (String)object3);
        super((k0)object);
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
        this.c = object;
        object = null;
        this.b = null;
    }

    public static final v C(k0 k02, ByteString byteString) {
        return d.a(k02, byteString);
    }

    public static final v D(k0 k02, ByteString byteString) {
        return d.b(k02, byteString);
    }

    public static final v E(k0 k02, ByteString byteString) {
        return d.c(k02, byteString);
    }

    public static final v O(k0 k02) {
        return d.d(k02);
    }

    public static final v S(k0 k02) {
        return d.e(k02);
    }

    public static final v n0(k0 k02) {
        return d.f(k02);
    }

    public static final v o0(k0 k02) {
        return d.g(k02);
    }

    public final ByteString B() {
        Object object = this.b;
        if (object != null) {
            object = ((MessageDigest)object).digest();
        } else {
            object = this.c;
            f0.m(object);
            object = ((Mac)object).doFinal();
        }
        f0.o(object, "result");
        ByteString byteString = new ByteString((byte[])object);
        return byteString;
    }

    public final ByteString q() {
        return this.B();
    }

    public void t(m m10, long l10) {
        long l11;
        f0.p(m10, "source");
        long l12 = m10.S0();
        long l13 = 0L;
        long l14 = l10;
        j.e(l12, l13, l10);
        i0 i02 = m10.a;
        f0.m(i02);
        l12 = 0L;
        while ((l11 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) < 0) {
            byte[] byArray;
            l13 = l10 - l12;
            int n10 = i02.c;
            int n11 = i02.b;
            l14 = n10 -= n11;
            l13 = Math.min(l13, l14);
            l11 = (int)l13;
            Object object = this.b;
            if (object != null) {
                byArray = i02.a;
                n11 = i02.b;
                ((MessageDigest)object).update(byArray, n11, (int)l11);
            } else {
                object = this.c;
                f0.m(object);
                byArray = i02.a;
                n11 = i02.b;
                ((Mac)object).update(byArray, n11, (int)l11);
            }
            l13 = l11;
            l12 += l13;
            i02 = i02.f;
            f0.m(i02);
        }
        super.t(m10, l10);
    }
}

