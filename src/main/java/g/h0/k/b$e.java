/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.d;
import g.h0.k.b;
import g.h0.k.b$a;
import h.m;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnection;

public final class b$e
extends b$a {
    private long d;
    public final /* synthetic */ b e;

    public b$e(b b10, long l10) {
        this.e = b10;
        super(b10);
        this.d = l10;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            this.q();
        }
    }

    public void close() {
        TimeUnit timeUnit;
        Object object = this.a();
        if (object) {
            return;
        }
        long l10 = this.d;
        long l11 = 0L;
        long l12 = l10 - l11;
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object && !(object = g.h0.d.t(this, 100, timeUnit = TimeUnit.MILLISECONDS))) {
            RealConnection realConnection = this.e.c();
            realConnection.G();
            this.q();
        }
        this.B(true);
    }

    public long read(m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        l12 = l12 >= 0 ? (long)n10 : (long)0;
        if (l12 != false) {
            l12 = this.a() ^ n10;
            if (l12 != false) {
                long l13 = this.d;
                long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                long l15 = -1;
                if (l14 == false) {
                    return l15;
                }
                long l16 = super.read((m)object, l10 = Math.min(l13, l10));
                long l17 = l16 - l15;
                Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object2 != false) {
                    this.d = l13 = this.d - l16;
                    object2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                    if (object2 == false) {
                        this.q();
                    }
                    return l16;
                }
                this.e.c().G();
                object = new ProtocolException("unexpected end of stream");
                this.q();
                throw object;
            }
            String string3 = "closed".toString();
            object = new IllegalStateException(string3);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

