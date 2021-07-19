/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import f.q2.u;
import g.h0.d;
import g.h0.j.e;
import g.h0.k.b;
import g.h0.k.b$a;
import g.m;
import g.s;
import g.t;
import g.z;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.connection.RealConnection;

public final class b$c
extends b$a {
    private long d;
    private boolean e;
    private final t f;
    public final /* synthetic */ b g;

    public b$c(b b10, t t10) {
        f0.p(t10, "url");
        this.g = b10;
        super(b10);
        this.f = t10;
        this.d = -1;
        this.e = true;
    }

    private final void C() {
        Object object;
        Object object2;
        block25: {
            Object object3;
            long l10;
            Object object4;
            block26: {
                long l11;
                long l12;
                long l13;
                block28: {
                    block27: {
                        l13 = this.d;
                        long l14 = -1;
                        long l15 = l13 - l14;
                        object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                        if (object4 != false) {
                            object2 = b.n(this.g);
                            object2.w();
                        }
                        try {
                            object2 = this.g;
                        }
                        catch (NumberFormatException numberFormatException) {
                            String string2 = numberFormatException.getMessage();
                            object = new ProtocolException(string2);
                            throw object;
                        }
                        object2 = b.n((b)object2);
                        l13 = object2.k0();
                        this.d = l13;
                        object2 = this.g;
                        object2 = b.n((b)object2);
                        object2 = object2.w();
                        if (object2 == null) break block25;
                        object2 = StringsKt__StringsKt.p5((CharSequence)object2);
                        object2 = object2.toString();
                        long l16 = this.d;
                        l10 = 0L;
                        l12 = l16 == l10 ? 0 : (l16 < l10 ? -1 : 1);
                        if (l12 < 0) break block26;
                        l12 = object2.length();
                        object3 = null;
                        if (l12 <= 0) break block27;
                        l12 = 1;
                        break block28;
                    }
                    l12 = 0;
                    object = null;
                }
                if (l12 != false) {
                    object = ";";
                    int n10 = 2;
                    l12 = (long)u.q2((String)object2, (String)object, false, n10, null);
                    if (l12 == false) break block26;
                }
                if ((object4 = (l11 = (l13 = this.d) - l10) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
                    this.e = false;
                    object2 = this.g;
                    object = b.l((b)object2).b();
                    b.r((b)object2, (s)object);
                    object2 = b.k(this.g);
                    f0.m(object2);
                    object2 = ((z)object2).Q();
                    object = this.f;
                    object3 = b.p(this.g);
                    f0.m(object3);
                    g.h0.j.e.g((m)object2, (t)object, (s)object3);
                    this.q();
                }
                return;
            }
            object3 = new StringBuilder();
            String string3 = "expected chunk size and optional extensions";
            ((StringBuilder)object3).append(string3);
            string3 = " but was \"";
            ((StringBuilder)object3).append(string3);
            l10 = this.d;
            ((StringBuilder)object3).append(l10);
            ((StringBuilder)object3).append((String)object2);
            object4 = 34;
            ((StringBuilder)object3).append((char)object4);
            object2 = ((StringBuilder)object3).toString();
            object = new ProtocolException((String)object2);
            throw object;
        }
        object = "null cannot be cast to non-null type kotlin.CharSequence";
        object2 = new NullPointerException((String)object);
        throw object2;
    }

    public void close() {
        TimeUnit timeUnit;
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        bl2 = this.e;
        if (bl2 && !(bl2 = g.h0.d.t(this, 100, timeUnit = TimeUnit.MILLISECONDS))) {
            RealConnection realConnection = this.g.c();
            realConnection.G();
            this.q();
        }
        this.B(true);
    }

    public long read(h.m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        l12 = l12 >= 0 ? (long)n10 : (long)0;
        if (l12 != false) {
            l12 = this.a() ^ n10;
            if (l12 != false) {
                long l13;
                long l14;
                long l15;
                l12 = (long)this.e;
                long l16 = -1;
                if (l12 == false) {
                    return l16;
                }
                long l17 = this.d;
                long l18 = l17 - l11;
                Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object2 == false || (object2 = l17 == l16 ? 0 : (l17 < l16 ? -1 : 1)) == false) {
                    this.C();
                    object2 = this.e;
                    if (object2 == false) {
                        return l16;
                    }
                }
                if ((l15 = (l14 = (l13 = super.read((h.m)object, l10 = Math.min(l10, l11 = this.d))) - l16) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
                    this.d = l11 = this.d - l13;
                    return l13;
                }
                this.g.c().G();
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

