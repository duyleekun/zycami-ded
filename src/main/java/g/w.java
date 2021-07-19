/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.b0;
import g.s;
import g.v;
import g.v$a;
import g.w$b;
import g.w$c;
import h.m;
import h.n;
import java.util.List;
import okio.ByteString;

public final class w
extends b0 {
    public static final v f;
    public static final v g;
    public static final v h;
    public static final v i;
    public static final v j;
    private static final byte[] k;
    private static final byte[] l;
    private static final byte[] m;
    public static final w$b n;
    private final v a;
    private long b;
    private final ByteString c;
    private final v d;
    private final List e;

    static {
        byte by2;
        Object object = new w$b(null);
        n = object;
        object = v.i;
        f = ((v$a)object).c("multipart/mixed");
        g = ((v$a)object).c("multipart/alternative");
        h = ((v$a)object).c("multipart/digest");
        i = ((v$a)object).c("multipart/parallel");
        j = ((v$a)object).c("multipart/form-data");
        int n10 = 2;
        byte[] byArray = new byte[n10];
        byArray[0] = by2 = (byte)58;
        by2 = (byte)32;
        int n11 = 1;
        byArray[n11] = by2;
        k = byArray;
        byArray = new byte[n10];
        byArray[0] = by2 = (byte)13;
        byArray[n11] = by2 = (byte)10;
        l = byArray;
        object = new byte[n10];
        byte by3 = (byte)45;
        object[0] = by3;
        object[n11] = by3;
        m = (byte[])object;
    }

    public w(ByteString object, v object2, List object3) {
        f0.p(object, "boundaryByteString");
        f0.p(object2, "type");
        f0.p(object3, "parts");
        this.c = object;
        this.d = object2;
        this.e = object3;
        object = v.i;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append("; boundary=");
        object2 = this.e();
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        this.a = object = ((v$a)object).c((String)object2);
        this.b = -1;
    }

    private final long j(n n10, boolean bl2) {
        n n11 = bl2 ? (n10 = new m()) : null;
        Object object = this.e;
        int n12 = object.size();
        ByteString byteString = null;
        long l10 = 0L;
        for (int i10 = 0; i10 < n12; ++i10) {
            long l11;
            long l12;
            long l13;
            long l14;
            Object object2;
            Object object3;
            Object object4 = (w$c)this.e.get(i10);
            Object object5 = ((w$c)object4).h();
            object4 = ((w$c)object4).c();
            f0.m(n10);
            Object object6 = m;
            n10.write((byte[])object6);
            object6 = this.c;
            n10.h0((ByteString)object6);
            object6 = l;
            n10.write((byte[])object6);
            if (object5 != null) {
                int n13 = ((s)object5).size();
                object3 = null;
                for (int i11 = 0; i11 < n13; ++i11) {
                    object2 = ((s)object5).h(i11);
                    object2 = n10.r((String)object2);
                    Object object7 = k;
                    object2 = object2.write((byte[])object7);
                    object7 = ((s)object5).n(i11);
                    object2 = object2.r((String)object7);
                    object7 = l;
                    object2.write((byte[])object7);
                }
            }
            if ((object5 = ((b0)object4).contentType()) != null) {
                object6 = n10.r("Content-Type: ");
                object5 = ((v)object5).toString();
                object5 = object6.r((String)object5);
                object6 = l;
                object5.write((byte[])object6);
            }
            if ((l14 = (l13 = (l12 = ((b0)object4).contentLength()) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                object3 = n10.r("Content-Length: ").M(l12);
                object2 = l;
                object3.write((byte[])object2);
            } else if (bl2) {
                f0.m(n11);
                ((m)n11).B();
                return l11;
            }
            object3 = l;
            n10.write((byte[])object3);
            if (bl2) {
                l10 += l12;
            } else {
                ((b0)object4).writeTo(n10);
            }
            n10.write((byte[])object3);
        }
        f0.m(n10);
        object = m;
        n10.write((byte[])object);
        byteString = this.c;
        n10.h0(byteString);
        n10.write((byte[])object);
        object = l;
        n10.write((byte[])object);
        if (bl2) {
            f0.m(n11);
            long l15 = ((m)n11).S0();
            l10 += l15;
            ((m)n11).B();
        }
        return l10;
    }

    public final String a() {
        return this.e();
    }

    public final List b() {
        return this.e;
    }

    public final int c() {
        return this.h();
    }

    public long contentLength() {
        long l10 = this.b;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            boolean bl2 = true;
            this.b = l10 = this.j(null, bl2);
        }
        return l10;
    }

    public v contentType() {
        return this.a;
    }

    public final v d() {
        return this.d;
    }

    public final String e() {
        return this.c.utf8();
    }

    public final w$c f(int n10) {
        return (w$c)this.e.get(n10);
    }

    public final List g() {
        return this.e;
    }

    public final int h() {
        return this.e.size();
    }

    public final v i() {
        return this.d;
    }

    public void writeTo(n n10) {
        f0.p(n10, "sink");
        this.j(n10, false);
    }
}

