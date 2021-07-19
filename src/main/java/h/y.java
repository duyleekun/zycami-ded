/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import h.j0;
import h.m;
import h.m0;
import h.o0;
import h.z;
import java.io.IOException;
import java.io.InputStream;

public final class y
implements m0 {
    private final InputStream a;
    private final o0 b;

    public y(InputStream inputStream, o0 o02) {
        f0.p(inputStream, "input");
        f0.p(o02, "timeout");
        this.a = inputStream;
        this.b = o02;
    }

    public void close() {
        this.a.close();
    }

    public long read(m object, long l10) {
        Object object2;
        int n10;
        Object object3 = "sink";
        f0.p(object, (String)object3);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return l11;
        }
        int n11 = 1;
        if (l12 >= 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            int n12;
            int n13;
            block22: {
                block23: {
                    Object object4;
                    try {
                        object2 = this.b;
                    }
                    catch (AssertionError assertionError) {
                        n13 = z.e(assertionError);
                        if (n13 != 0) {
                            object4 = new IOException((Throwable)((Object)assertionError));
                            throw object4;
                        }
                        throw assertionError;
                    }
                    ((o0)object2).h();
                    object3 = ((m)object).V0(n11);
                    n10 = ((i0)object3).c;
                    n10 = 8192 - n10;
                    long l13 = n10;
                    l10 = Math.min(l10, l13);
                    n13 = (int)l10;
                    InputStream inputStream = this.a;
                    object2 = ((i0)object3).a;
                    l12 = ((i0)object3).c;
                    n13 = inputStream.read((byte[])object2, (int)l12, n13);
                    n12 = -1;
                    if (n13 != n12) break block22;
                    n13 = ((i0)object3).b;
                    n12 = ((i0)object3).c;
                    if (n13 != n12) break block23;
                    object4 = ((i0)object3).b();
                    ((m)object).a = object4;
                    j0.d((i0)object3);
                }
                return -1;
            }
            n12 = ((i0)object3).c + n13;
            ((i0)object3).c = n12;
            l11 = ((m)object).S0();
            l10 = n13;
            l11 += l10;
            ((m)object).O0(l11);
            return l10;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public o0 timeout() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("source(");
        InputStream inputStream = this.a;
        stringBuilder.append(inputStream);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

