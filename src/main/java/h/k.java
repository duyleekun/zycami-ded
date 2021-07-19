/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.s.a;
import f.h2.t.c0;
import f.h2.t.f0;
import h.k$a;
import h.k$c;
import h.k$d;
import h.k0;
import h.m0;
import h.o0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class k
extends o0 {
    private static final int i = 65536;
    private static final long j;
    private static final long k;
    private static k l;
    public static final k$a m;
    private boolean f;
    private k g;
    private long h;

    static {
        long l10;
        k$a k$a;
        m = k$a = new k$a(null);
        j = l10 = TimeUnit.SECONDS.toMillis(60);
        k = TimeUnit.MILLISECONDS.toNanos(l10);
    }

    public static final /* synthetic */ k l() {
        return l;
    }

    public static final /* synthetic */ long m() {
        return j;
    }

    public static final /* synthetic */ long n() {
        return k;
    }

    public static final /* synthetic */ k o(k k10) {
        return k10.g;
    }

    public static final /* synthetic */ long p(k k10) {
        return k10.h;
    }

    public static final /* synthetic */ long r(k k10, long l10) {
        return k10.y(l10);
    }

    public static final /* synthetic */ void s(k k10) {
        l = k10;
    }

    public static final /* synthetic */ void t(k k10, k k11) {
        k10.g = k11;
    }

    public static final /* synthetic */ void u(k k10, long l10) {
        k10.h = l10;
    }

    private final long y(long l10) {
        return this.h - l10;
    }

    public final m0 A(m0 m02) {
        f0.p(m02, "source");
        k$d k$d = new k$d(this, m02);
        return k$d;
    }

    public void B() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object C(a object) {
        Throwable throwable2222222;
        int n10;
        block5: {
            String string2 = "block";
            f0.p(object, string2);
            this.v();
            n10 = 1;
            object = object.invoke();
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (IOException iOException) {}
                {
                    IOException iOException;
                    boolean bl2 = this.w();
                    if (!bl2) {
                        throw iOException;
                    }
                    iOException = this.q(iOException);
                    throw iOException;
                }
            }
            c0.d(n10);
            boolean bl3 = this.w();
            if (bl3) throw this.q(null);
            c0.c(n10);
            return object;
        }
        c0.d(n10);
        boolean bl4 = this.w();
        c0.c(n10);
        throw throwable2222222;
    }

    public final IOException q(IOException iOException) {
        return this.x(iOException);
    }

    public final void v() {
        boolean bl2 = this.f;
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            long l10 = this.j();
            bl2 = this.f();
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false && !bl2) {
                return;
            }
            this.f = bl3;
            k$a.b(m, this, l10, bl2);
            return;
        }
        String string2 = "Unbalanced enter/exit".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public final boolean w() {
        boolean bl2 = this.f;
        if (!bl2) {
            return false;
        }
        this.f = false;
        return k$a.a(m, this);
    }

    public IOException x(IOException iOException) {
        String string2 = "timeout";
        InterruptedIOException interruptedIOException = new InterruptedIOException(string2);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final k0 z(k0 k02) {
        f0.p(k02, "sink");
        k$c k$c = new k$c(this, k02);
        return k$c;
    }
}

