/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.q1;
import g.h0.l.d;
import g.h0.l.g$a;
import g.h0.l.g$b;
import g.h0.l.g$c;
import g.h0.l.g$d;
import g.s;
import h.k0;
import h.m0;
import h.o;
import h.o0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class g {
    public static final long o = 16384L;
    public static final g$a p;
    private long a;
    private long b;
    private long c;
    private long d;
    private final ArrayDeque e;
    private boolean f;
    private final g$c g;
    private final g$b h;
    private final g$d i;
    private final g$d j;
    private ErrorCode k;
    private IOException l;
    private final int m;
    private final d n;

    static {
        g$a g$a;
        p = g$a = new g$a(null);
    }

    public g(int n10, d object, boolean bl2, boolean bl3, s s10) {
        Serializable serializable;
        block5: {
            block4: {
                block2: {
                    block3: {
                        g$c g$c;
                        long l10;
                        f0.p(object, "connection");
                        this.m = n10;
                        this.n = object;
                        n10 = ((d)object).G0().e();
                        this.d = l10 = (long)n10;
                        this.e = serializable = new Serializable();
                        int n11 = ((d)object).F0().e();
                        long l11 = n11;
                        this.g = g$c = new g$c(this, l11, bl3);
                        super(this, bl2);
                        this.h = object;
                        this.i = object = new g$d(this);
                        this.j = object = new g$d(this);
                        if (s10 == null) break block2;
                        n11 = this.v() ^ 1;
                        if (n11 == 0) break block3;
                        serializable.add(s10);
                        break block4;
                    }
                    object = "locally-initiated streams shouldn't have headers yet".toString();
                    super((String)object);
                    throw serializable;
                }
                n10 = (int)(this.v() ? 1 : 0);
                if (n10 == 0) break block5;
            }
            return;
        }
        object = "remotely-initiated streams should have headers".toString();
        super((String)object);
        throw serializable;
    }

    private final boolean e(ErrorCode object, IOException object2) {
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" MUST NOT hold lock on ");
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            object = new AssertionError(object2);
            throw object;
        }
        synchronized (this) {
            block12: {
                Object object4;
                block11: {
                    object4 = this.k;
                    if (object4 == null) break block11;
                    return false;
                }
                object4 = this.g;
                bl2 = ((g$c)object4).h();
                if (!bl2) break block12;
                object4 = this.h;
                bl2 = ((g$b)object4).q();
                if (!bl2) break block12;
                return false;
            }
            this.k = object;
            this.l = object2;
            this.notifyAll();
            object = q1.a;
            object = this.n;
            int n10 = this.m;
            ((d)object).a1(n10);
            return true;
            finally {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void A(ErrorCode errorCode) {
        synchronized (this) {
            String string2 = "errorCode";
            f0.p((Object)errorCode, string2);
            ErrorCode errorCode2 = this.k;
            if (errorCode2 == null) {
                this.k = errorCode;
                this.notifyAll();
            }
            return;
        }
    }

    public final void B(ErrorCode errorCode) {
        this.k = errorCode;
    }

    public final void C(IOException iOException) {
        this.l = iOException;
    }

    public final void D(long l10) {
        this.b = l10;
    }

    public final void E(long l10) {
        this.a = l10;
    }

    public final void F(long l10) {
        this.d = l10;
    }

    public final void G(long l10) {
        this.c = l10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final s H() {
        synchronized (this) {
            void var1_13;
            block10: {
                ErrorCode errorCode;
                ArrayDeque arrayDeque;
                boolean bl2;
                g$d g$d = this.i;
                g$d.v();
                while ((bl2 = (arrayDeque = this.e).isEmpty()) && (errorCode = this.k) == null) {
                    this.J();
                }
                arrayDeque = this.e;
                bl2 = arrayDeque.isEmpty() ^ true;
                if (!bl2) break block10;
                ArrayDeque arrayDeque2 = this.e;
                Object e10 = arrayDeque2.removeFirst();
                String string2 = "headersQueue.removeFirst()";
                f0.o(e10, string2);
                return (s)e10;
            }
            IOException iOException = this.l;
            if (iOException != null) {
                throw var1_13;
            }
            ErrorCode errorCode = this.k;
            f0.m((Object)errorCode);
            StreamResetException streamResetException = new StreamResetException(errorCode);
            throw var1_13;
            finally {
                g$d g$d2 = this.i;
                g$d2.D();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public final s I() {
        synchronized (this) {
            block23: {
                var1_1 = this.k;
                if (var1_1 == null) ** GOTO lbl17
                var1_1 = this.l;
                if (var1_1 != null) ** GOTO lbl16
                var2_3 = this.k;
                f0.m((Object)var2_3);
                var1_1 = new StreamResetException(var2_3);
lbl16:
                // 2 sources

                throw var1_1;
lbl17:
                // 1 sources

                var1_1 = this.g;
                var3_5 = var1_1.h();
                if (!var3_5) break block23;
                var1_1 = this.g;
                var1_1 = var1_1.B();
                var3_5 = var1_1.V();
                if (!var3_5) break block23;
                var1_1 = this.g;
                var1_1 = var1_1.q();
                var3_5 = var1_1.V();
                if (!var3_5) break block23;
                var3_5 = true;
            }
            var3_5 = false;
            var1_1 = null;
            if (var3_5) {
                block24: {
                    var1_1 = this.g;
                    var1_1 = var1_1.C();
                    if (var1_1 == null) break block24;
                }
                var1_1 = g.h0.d.b;
                return var1_1;
            }
            var1_1 = "too early; can't read the trailers yet";
            var1_1 = var1_1.toString();
            var2_4 = new IllegalStateException((String)var1_1);
            throw var2_4;
        }
    }

    public final void J() {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            throw interruptedIOException;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void K(List object, boolean bl2, boolean bl3) {
        int n10;
        boolean bl4;
        Object object2;
        void var2_2;
        Object object3 = "responseHeaders";
        f0.p(object, (String)object3);
        boolean bl5 = g.h0.d.h;
        if (bl5 && (bl5 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object4 = Thread.currentThread();
            f0.o(object4, "Thread.currentThread()");
            object4 = ((Thread)object4).getName();
            charSequence.append((String)object4);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        // MONITORENTER : this
        this.f = bl5 = true;
        if (var2_2 != false) {
            object2 = this.h;
            ((g$b)object2).D(bl5);
        }
        object2 = q1.a;
        // MONITOREXIT : this
        if (!bl4) {
            d d10 = this.n;
            // MONITORENTER : d10
            object2 = this.n;
            long l10 = ((d)object2).O0();
            d d11 = this.n;
            long l11 = d11.N0();
            n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n10 < 0) {
                bl5 = false;
                object3 = null;
            }
            // MONITOREXIT : d10
            bl4 = bl5;
        }
        object3 = this.n;
        n10 = this.m;
        ((d)object3).n1(n10, (boolean)var2_2, (List)object);
        if (!bl4) return;
        object = this.n;
        ((d)object).flush();
    }

    public final o0 L() {
        return this.j;
    }

    public final void a(long l10) {
        long l11;
        this.d = l11 = this.d + l10;
        l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.notifyAll();
        }
    }

    public final void b() {
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        synchronized (this) {
            block17: {
                Object object;
                block18: {
                    block15: {
                        block16: {
                            object = this.g;
                            bl2 = ((g$c)object).h();
                            if (bl2) break block15;
                            object = this.g;
                            bl2 = ((g$c)object).a();
                            if (!bl2) break block15;
                            object = this.h;
                            bl2 = ((g$b)object).q();
                            if (bl2) break block16;
                            object = this.h;
                            bl2 = ((g$b)object).h();
                            if (!bl2) break block15;
                        }
                        bl2 = true;
                        break block18;
                    }
                    bl2 = false;
                    object = null;
                }
                int n10 = this.w();
                q1 q12 = q1.a;
                if (bl2) {
                    object = ErrorCode.CANCEL;
                    n10 = 0;
                    Object var3_6 = null;
                    this.d((ErrorCode)((Object)object), null);
                    break block17;
                }
                if (n10 != 0) break block17;
                object = this.n;
                n10 = this.m;
                ((d)object).a1(n10);
            }
            return;
            finally {
            }
        }
    }

    public final void c() {
        Object object = this.h;
        boolean bl2 = ((g$b)object).h();
        if (!bl2) {
            object = this.h;
            bl2 = ((g$b)object).q();
            if (!bl2) {
                object = this.k;
                if (object != null) {
                    object = this.l;
                    if (object == null) {
                        ErrorCode errorCode = this.k;
                        f0.m((Object)errorCode);
                        object = new StreamResetException(errorCode);
                    }
                    throw object;
                }
                return;
            }
            object = new IOException("stream finished");
            throw object;
        }
        object = new IOException("stream closed");
        throw object;
    }

    public final void d(ErrorCode errorCode, IOException object) {
        String string2 = "rstStatusCode";
        f0.p((Object)errorCode, string2);
        boolean bl2 = this.e(errorCode, (IOException)object);
        if (!bl2) {
            return;
        }
        object = this.n;
        int n10 = this.m;
        ((d)object).r1(n10, errorCode);
    }

    public final void f(ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
        d d10 = null;
        boolean bl2 = this.e(errorCode, null);
        if (!bl2) {
            return;
        }
        d10 = this.n;
        int n10 = this.m;
        d10.s1(n10, errorCode);
    }

    public final void g(s object) {
        Object object2 = "trailers";
        f0.p(object, (String)object2);
        synchronized (this) {
            block15: {
                block16: {
                    object2 = this.h;
                    boolean n10 = ((g$b)object2).q();
                    boolean bl2 = true;
                    boolean bl3 = n10 ^ bl2;
                    if (!bl3) break block15;
                    int n11 = ((s)object).size();
                    if (n11 == 0) {
                        bl2 = false;
                    }
                    if (!bl2) break block16;
                    object2 = this.h;
                    ((g$b)object2).E((s)object);
                    object = q1.a;
                    return;
                }
                object = "trailers.size() == 0";
                object = object.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object = "already finished";
            object = object.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
    }

    public final d h() {
        return this.n;
    }

    public final ErrorCode i() {
        synchronized (this) {
            ErrorCode errorCode = this.k;
            return errorCode;
        }
    }

    public final IOException j() {
        return this.l;
    }

    public final int k() {
        return this.m;
    }

    public final long l() {
        return this.b;
    }

    public final long m() {
        return this.a;
    }

    public final g$d n() {
        return this.i;
    }

    public final k0 o() {
        synchronized (this) {
            Object object;
            boolean bl2;
            block10: {
                bl2 = this.f;
                if (bl2) break block10;
                bl2 = this.v();
                if (bl2) break block10;
                bl2 = false;
                object = null;
            }
            bl2 = true;
            if (bl2) {
                object = q1.a;
                return this.h;
            }
            object = "reply before requesting the sink";
            object = object.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
    }

    public final g$b p() {
        return this.h;
    }

    public final m0 q() {
        return this.g;
    }

    public final g$c r() {
        return this.g;
    }

    public final long s() {
        return this.d;
    }

    public final long t() {
        return this.c;
    }

    public final g$d u() {
        return this.j;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean v() {
        void var1_5;
        int bl2 = this.m;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            int n12 = n10;
        } else {
            boolean bl3 = false;
        }
        d d10 = this.n;
        boolean bl4 = d10.A0();
        if (bl4 != var1_5) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public final boolean w() {
        synchronized (this) {
            block14: {
                boolean bl2;
                block15: {
                    Object object;
                    block13: {
                        block12: {
                            object = this.k;
                            if (object == null) break block12;
                            return false;
                        }
                        object = this.g;
                        bl2 = ((g$c)object).h();
                        if (bl2) break block13;
                        object = this.g;
                        bl2 = ((g$c)object).a();
                        if (!bl2) break block14;
                    }
                    object = this.h;
                    bl2 = ((g$b)object).q();
                    if (bl2) break block15;
                    object = this.h;
                    bl2 = ((g$b)object).h();
                    if (!bl2) break block14;
                }
                bl2 = this.f;
                if (!bl2) break block14;
                return false;
            }
            return true;
        }
    }

    public final o0 x() {
        return this.i;
    }

    public final void y(o object, int n10) {
        Object object2 = "source";
        f0.p(object, (String)object2);
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            charSequence.append((String)object2);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        object2 = this.g;
        long l10 = n10;
        ((g$c)object2).D((o)object, l10);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public final void z(s object, boolean bl2) {
        Object object2 = "headers";
        f0.p(object, (String)object2);
        boolean bl3 = g.h0.d.h;
        if (bl3 && (bl3 = Thread.holdsLock(this))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            stringBuilder.append((String)object2);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            String string2 = stringBuilder.toString();
            object = new AssertionError((Object)string2);
            throw object;
        }
        synchronized (this) {
            block8: {
                bl3 = this.f;
                boolean bl4 = true;
                if (bl3 && bl2) {
                    object2 = this.g;
                    ((g$c)object2).S((s)object);
                } else {
                    this.f = bl4;
                    object2 = this.e;
                    object2.add(object);
                }
                if (bl2) {
                    object = this.g;
                    ((g$c)object).O(bl4);
                }
                boolean bl5 = this.w();
                this.notifyAll();
                q1 q12 = q1.a;
                if (bl5) break block8;
                object = this.n;
                int n10 = this.m;
                ((d)object).a1(n10);
            }
            return;
            finally {
            }
        }
    }
}

