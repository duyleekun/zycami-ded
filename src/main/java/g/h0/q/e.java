/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.q1;
import f.q2.u;
import f.x1.t;
import g.a0;
import g.a0$a;
import g.c0;
import g.f0;
import g.g0;
import g.h0.d;
import g.h0.h.a;
import g.h0.h.c;
import g.h0.q.e$a;
import g.h0.q.e$b;
import g.h0.q.e$c;
import g.h0.q.e$d;
import g.h0.q.e$e;
import g.h0.q.e$f;
import g.h0.q.e$g;
import g.h0.q.f;
import g.h0.q.g;
import g.h0.q.h;
import g.h0.q.h$a;
import g.h0.q.i;
import g.q;
import g.z;
import g.z$a;
import h.n;
import h.o;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okio.ByteString;
import okio.ByteString$a;

public final class e
implements f0,
h$a {
    private static final long A = 0x1000000L;
    private static final long B = 60000L;
    public static final long C = 1024L;
    public static final e$b D;
    private static final List z;
    private final String a;
    private g.e b;
    private a c;
    private h d;
    private i e;
    private c f;
    private String g;
    private e$d h;
    private final ArrayDeque i;
    private final ArrayDeque j;
    private long k;
    private boolean l;
    private int m;
    private String n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private final a0 t;
    private final g0 u;
    private final Random v;
    private final long w;
    private f x;
    private long y;

    static {
        e$b e$b;
        D = e$b = new e$b(null);
        z = f.x1.t.k((Object)Protocol.HTTP_1_1);
    }

    public e(g.h0.h.d object, a0 object2, g0 object3, Random random, long l10, f f10, long l11) {
        f.h2.t.f0.p(object, "taskRunner");
        f.h2.t.f0.p(object2, "originalRequest");
        f.h2.t.f0.p(object3, "listener");
        String string2 = "random";
        f.h2.t.f0.p(random, string2);
        this.t = object2;
        this.u = object3;
        this.v = random;
        this.w = l10;
        this.x = f10;
        this.y = l11;
        this.f = object = ((g.h0.h.d)object).j();
        object = new ArrayDeque();
        this.i = object;
        object = new ArrayDeque();
        this.j = object;
        this.m = -1;
        object = ((a0)object2).m();
        object3 = "GET";
        boolean bl2 = f.h2.t.f0.g(object3, object);
        if (bl2) {
            object2 = ByteString.Companion;
            object3 = new byte[16];
            random.nextBytes((byte[])object3);
            object = q1.a;
            this.a = object = ByteString$a.p((ByteString$a)object2, (byte[])object3, 0, 0, 3, null).base64();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Request must be GET: ");
        object2 = ((a0)object2).m();
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private final void A() {
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f.h2.t.f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        a a10 = this.c;
        if (a10 != null) {
            c c10 = this.f;
            long l10 = 0L;
            int n10 = 2;
            g.h0.h.c.p(c10, a10, l10, n10, null);
        }
    }

    private final boolean B(ByteString byteString, int n10) {
        synchronized (this) {
            block13: {
                long l10;
                e$c e$c;
                block14: {
                    int n11 = this.o;
                    e$c = null;
                    if (n11 != 0) break block13;
                    n11 = this.l;
                    if (n11 != 0) break block13;
                    l10 = this.k;
                    long l11 = byteString.size();
                    l10 += l11;
                    l11 = 0x1000000L;
                    n11 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (n11 <= 0) break block14;
                    int n12 = 1001;
                    n10 = 0;
                    this.close(n12, null);
                    return false;
                }
                long l12 = this.k;
                int n13 = byteString.size();
                l10 = n13;
                l12 += l10;
                this.k = l12;
                ArrayDeque arrayDeque = this.j;
                e$c = new e$c(n10, byteString);
                arrayDeque.add(e$c);
                this.A();
                return true;
            }
            return false;
        }
    }

    public static final /* synthetic */ f h(e e10) {
        return e10.x;
    }

    public static final /* synthetic */ ArrayDeque i(e e10) {
        return e10.j;
    }

    public static final /* synthetic */ String j(e e10) {
        return e10.g;
    }

    public static final /* synthetic */ boolean k(e e10, f f10) {
        return e10.u(f10);
    }

    public static final /* synthetic */ void l(e e10, f f10) {
        e10.x = f10;
    }

    public static final /* synthetic */ void m(e e10, String string2) {
        e10.g = string2;
    }

    private final boolean u(f object) {
        int n10 = ((f)object).f;
        if (n10 != 0) {
            return false;
        }
        Integer n11 = ((f)object).b;
        if (n11 != null) {
            return false;
        }
        object = ((f)object).d;
        if (object != null) {
            n10 = 15;
            int n12 = 8;
            int n13 = (Integer)object;
            if (n12 > n13 || n10 < n13) {
                return false;
            }
        }
        return true;
    }

    public a0 C() {
        return this.t;
    }

    public final int D() {
        synchronized (this) {
            int n10 = this.p;
            return n10;
        }
    }

    public final void E() {
        this.f.u();
        CountDownLatch countDownLatch = this.f.l();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        countDownLatch.await(10, timeUnit);
    }

    /*
     * Exception decompiling
     */
    public final boolean F() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [64[CATCHBLOCK], 80[SIMPLE_IF_ELSE]], but top level block is 63[MONITOR]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void G() {
        int n10;
        int n11;
        int n12;
        int n13;
        Object object;
        synchronized (this) {
            boolean bl2 = this.o;
            if (bl2) {
                return;
            }
            object = this.e;
            if (object == null) return;
            n13 = this.s;
            n12 = -1;
            n13 = n13 != 0 ? this.p : n12;
            n11 = this.p;
            n10 = 1;
            this.p = n11 += n10;
            this.s = n10;
        }
        n11 = 0;
        if (n13 != n12) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sent ping but didn't receive pong within ");
            long l10 = this.w;
            stringBuilder.append(l10);
            stringBuilder.append("ms (after ");
            stringBuilder.append(n13 -= n10);
            stringBuilder.append(" successful ping/pongs)");
            String string2 = stringBuilder.toString();
            object = new SocketTimeoutException(string2);
            this.r((Exception)object, null);
            return;
        }
        try {
            ByteString string2 = ByteString.EMPTY;
            ((i)object).D(string2);
            return;
        }
        catch (IOException iOException) {
            this.r(iOException, null);
        }
    }

    public boolean a(ByteString byteString) {
        f.h2.t.f0.p(byteString, "bytes");
        return this.B(byteString, 2);
    }

    public void b(ByteString byteString) {
        f.h2.t.f0.p(byteString, "bytes");
        this.u.onMessage((f0)this, byteString);
    }

    public void c(String string2) {
        f.h2.t.f0.p(string2, "text");
        this.u.onMessage((f0)this, string2);
    }

    public void cancel() {
        g.e e10 = this.b;
        f.h2.t.f0.m(e10);
        e10.cancel();
    }

    public boolean close(int n10, String string2) {
        return this.p(n10, string2, 60000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(ByteString byteString) {
        synchronized (this) {
            Object object = "payload";
            f.h2.t.f0.p(byteString, (String)object);
            boolean bl2 = this.o;
            if (!(bl2 || (bl2 = this.l) && (bl2 = ((ArrayDeque)(object = this.j)).isEmpty()))) {
                int n10;
                object = this.i;
                ((ArrayDeque)object).add(byteString);
                this.A();
                this.q = n10 = this.q + 1;
                return;
            }
            return;
        }
    }

    public long e() {
        synchronized (this) {
            long l10 = this.k;
            return l10;
        }
    }

    public void f(ByteString byteString) {
        synchronized (this) {
            String string2 = "payload";
            f.h2.t.f0.p(byteString, string2);
            int n10 = this.r + 1;
            this.r = n10;
            n10 = 0;
            byteString = null;
            this.s = false;
            return;
        }
    }

    public void g(int n10, String object) {
        i i10;
        int n11;
        Object object2 = "reason";
        f.h2.t.f0.p(object, (String)object2);
        int n12 = 1;
        Object object3 = null;
        int n13 = -1;
        if (n10 != n13) {
            n11 = n12;
        } else {
            n11 = 0;
            i10 = null;
        }
        if (n11 != 0) {
            synchronized (this) {
                block32: {
                    h h10;
                    block34: {
                        block33: {
                            n11 = this.m;
                            if (n11 != n13) {
                                n12 = 0;
                                object2 = null;
                            }
                            if (n12 == 0) break block32;
                            this.m = n10;
                            this.n = object;
                            n12 = (int)(this.l ? 1 : 0);
                            object3 = null;
                            if (n12 == 0) break block33;
                            object2 = this.j;
                            n12 = (int)(((ArrayDeque)object2).isEmpty() ? 1 : 0);
                            if (n12 == 0) break block33;
                            object2 = this.h;
                            this.h = null;
                            h10 = this.d;
                            this.d = null;
                            i10 = this.e;
                            this.e = null;
                            object3 = this.f;
                            ((c)object3).u();
                            object3 = object2;
                        }
                        n13 = 0;
                        h10 = null;
                        n11 = 0;
                        i10 = null;
                        object2 = q1.a;
                        object2 = this.u;
                        try {
                            ((g0)object2).onClosing(this, n10, (String)object);
                            if (object3 == null) break block34;
                        }
                        catch (Throwable throwable) {
                            if (object3 != null) {
                                g.h0.d.l(object3);
                            }
                            if (h10 != null) {
                                g.h0.d.l(h10);
                            }
                            if (i10 != null) {
                                g.h0.d.l(i10);
                            }
                            throw throwable;
                        }
                        object2 = this.u;
                        ((g0)object2).onClosed(this, n10, (String)object);
                    }
                    if (object3 != null) {
                        g.h0.d.l(object3);
                    }
                    if (h10 != null) {
                        g.h0.d.l(h10);
                    }
                    if (i10 != null) {
                        g.h0.d.l(i10);
                    }
                    return;
                }
                String string2 = "already closed";
                string2 = string2.toString();
                object = new IllegalStateException(string2);
                throw object;
            }
        }
        String string3 = "Failed requirement.".toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public final void n(long l10, TimeUnit timeUnit) {
        f.h2.t.f0.p((Object)timeUnit, "timeUnit");
        this.f.l().await(l10, timeUnit);
    }

    public final void o(c0 object, g.h0.i.c object2) {
        Object object3 = "response";
        f.h2.t.f0.p(object, (String)object3);
        int n10 = ((c0)object).v0();
        char c10 = '\'';
        int n11 = 101;
        if (n10 == n11) {
            int n12;
            n11 = 0;
            CharSequence charSequence = null;
            String string2 = "Upgrade";
            int n13 = 2;
            object3 = c0.A0((c0)object, "Connection", null, n13, null);
            boolean bl2 = f.q2.u.I1(string2, (String)object3, (n12 = 1) != 0);
            if (bl2) {
                string2 = "websocket";
                object3 = c0.A0((c0)object, string2, null, n13, null);
                boolean bl3 = f.q2.u.I1(string2, (String)object3, n12 != 0);
                if (bl3) {
                    object = c0.A0((c0)object, "Sec-WebSocket-Accept", null, n13, null);
                    object3 = ByteString.Companion;
                    charSequence = new StringBuilder();
                    String string3 = this.a;
                    ((StringBuilder)charSequence).append(string3);
                    string3 = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
                    ((StringBuilder)charSequence).append(string3);
                    charSequence = ((StringBuilder)charSequence).toString();
                    object3 = ((ByteString$a)object3).l((String)charSequence).sha1().base64();
                    n11 = f.h2.t.f0.g(object3, object) ^ n12;
                    if (n11 == 0) {
                        if (object2 != null) {
                            return;
                        }
                        object = new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        throw object;
                    }
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Expected 'Sec-WebSocket-Accept' header value '");
                    ((StringBuilder)charSequence).append((String)object3);
                    ((StringBuilder)charSequence).append("' but was '");
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(c10);
                    object = ((StringBuilder)charSequence).toString();
                    object2 = new ProtocolException((String)object);
                    throw object2;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Expected 'Upgrade' header value 'websocket' but was '");
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(c10);
                object2 = ((StringBuilder)object2).toString();
                object = new ProtocolException((String)object2);
                throw object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Expected 'Connection' header value 'Upgrade' but was '");
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(c10);
            object2 = ((StringBuilder)object2).toString();
            object = new ProtocolException((String)object2);
            throw object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Expected HTTP 101 response but was '");
        n11 = ((c0)object).v0();
        ((StringBuilder)object3).append(n11);
        ((StringBuilder)object3).append(' ');
        object = ((c0)object).E0();
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(c10);
        object = ((StringBuilder)object3).toString();
        object2 = new ProtocolException((String)object);
        throw object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean p(int n10, String object, long l10) {
        synchronized (this) {
            boolean bl2;
            Object object2 = g.h0.q.g.w;
            ((g)object2).d(n10);
            object2 = null;
            e$a e$a = null;
            boolean bl3 = true;
            if (object != null) {
                long l11;
                object2 = ByteString.Companion;
                long l12 = ((ByteString)(object2 = ((ByteString$a)object2).l((String)object))).size();
                long l13 = l12 - (l11 = (long)123);
                Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                object3 = object3 <= 0 ? (Object)bl3 : (Object)0;
                if (object3 == false) {
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "reason.size() > 123: ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((String)object);
                    charSequence = ((StringBuilder)charSequence).toString();
                    charSequence = ((Object)charSequence).toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
            }
            if (!(bl2 = this.o) && !(bl2 = this.l)) {
                this.l = bl3;
                object = this.j;
                e$a = new e$a(n10, (ByteString)object2, l10);
                ((ArrayDeque)object).add(e$a);
                this.A();
                return bl3;
            }
            return false;
        }
    }

    public final void q(z object) {
        f.h2.t.f0.p(object, "client");
        Object object2 = this.t;
        Object object3 = "Sec-WebSocket-Extensions";
        object2 = ((a0)object2).i((String)object3);
        if (object2 != null) {
            object = new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'");
            this.r((Exception)object, null);
            return;
        }
        object = ((z)object).c0();
        object2 = g.q.a;
        object = ((z$a)object).r((q)object2);
        object2 = z;
        object = ((z$a)object).f0((List)object2).f();
        object2 = this.t.n();
        String string2 = "Upgrade";
        object2 = ((a0$a)object2).n(string2, "websocket").n("Connection", string2);
        string2 = this.a;
        object2 = ((a0$a)object2).n("Sec-WebSocket-Key", string2).n("Sec-WebSocket-Version", "13").n((String)object3, "permessage-deflate").b();
        this.b = object3 = new g.h0.i.e((z)object, (a0)object2, true);
        f.h2.t.f0.m(object3);
        object = new e$f(this, (a0)object2);
        object3.S((g.f)object);
    }

    public final void r(Exception exception, c0 c02) {
        Object object = "e";
        f.h2.t.f0.p(exception, (String)object);
        synchronized (this) {
            boolean bl2;
            block16: {
                bl2 = this.o;
                if (!bl2) break block16;
                return;
            }
            bl2 = true;
            this.o = bl2;
            object = this.h;
            Object object2 = null;
            this.h = null;
            h h10 = this.d;
            this.d = null;
            i i10 = this.e;
            this.e = null;
            object2 = this.f;
            ((c)object2).u();
            object2 = q1.a;
            try {
                object2 = this.u;
                ((g0)object2).onFailure(this, exception, c02);
                return;
            }
            finally {
                if (object != null) {
                    g.h0.d.l((Closeable)object);
                }
                if (h10 != null) {
                    g.h0.d.l(h10);
                }
                if (i10 != null) {
                    g.h0.d.l(i10);
                }
            }
        }
    }

    public final g0 s() {
        return this.u;
    }

    public boolean send(String object) {
        f.h2.t.f0.p(object, "text");
        object = ByteString.Companion.l((String)object);
        return this.B((ByteString)object, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void t(String string2, e$d e$d) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object;
        Object object2;
        boolean bl5;
        e e10 = this;
        Object object3 = string2;
        f.h2.t.f0.p(string2, "name");
        Object object4 = "streams";
        f.h2.t.f0.p(e$d, (String)object4);
        f f10 = this.x;
        f.h2.t.f0.m(f10);
        synchronized (this) {
            boolean bl6;
            Object object5;
            this.g = string2;
            this.h = e$d;
            bl5 = e$d.a();
            object2 = e$d.h();
            object = this.v;
            bl4 = f10.a;
            bl3 = e$d.a();
            bl2 = f10.i(bl3);
            long l10 = this.y;
            object4 = object5;
            object5 = new i(bl5, (n)object2, (Random)object, bl4, bl2, l10);
            this.e = object5;
            this.c = object4 = new e$e(this);
            long l11 = this.w;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 != false) {
                object2 = TimeUnit.MILLISECONDS;
                long l14 = ((TimeUnit)((Object)object2)).toNanos(l11);
                c c10 = this.f;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                Object object6 = " ping";
                ((StringBuilder)object4).append((String)object6);
                object2 = ((StringBuilder)object4).toString();
                object4 = object5;
                object6 = object2;
                object3 = object5;
                object5 = f10;
                object4 = new e$g((String)object2, (String)object2, l14, this, string2, e$d, f10);
                c10.n((a)object4, l14);
            }
            if (bl6 = (object3 = e10.j).isEmpty() ^ true) {
                this.A();
            }
            object3 = q1.a;
        }
        bl5 = e$d.a();
        object2 = e$d.q();
        bl4 = f10.a;
        bl3 = e$d.a() ^ true;
        bl2 = f10.i(bl3);
        object4 = object3;
        object = this;
        e10.d = object3 = new h(bl5, (o)object2, this, bl4, bl2);
    }

    public final void v() {
        int n10;
        int n11;
        while ((n11 = this.m) == (n10 = -1)) {
            h h10 = this.d;
            f.h2.t.f0.m(h10);
            h10.h();
        }
    }

    public final boolean w(ByteString byteString) {
        synchronized (this) {
            block8: {
                Object object;
                block9: {
                    object = "payload";
                    f.h2.t.f0.p(byteString, (String)object);
                    boolean bl2 = this.o;
                    if (bl2) break block8;
                    bl2 = this.l;
                    if (!bl2) break block9;
                    object = this.j;
                    bl2 = ((ArrayDeque)object).isEmpty();
                    if (bl2) break block8;
                }
                object = this.i;
                ((ArrayDeque)object).add(byteString);
                this.A();
                return true;
            }
            return false;
        }
    }

    public final boolean x() {
        boolean bl2 = false;
        h h10 = this.d;
        try {
            f.h2.t.f0.m(h10);
            h10.h();
            int n10 = this.m;
            int n11 = -1;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        catch (Exception exception) {
            boolean bl3 = false;
            this.r(exception, null);
        }
        return bl2;
    }

    public final int y() {
        synchronized (this) {
            int n10 = this.q;
            return n10;
        }
    }

    public final int z() {
        synchronized (this) {
            int n10 = this.r;
            return n10;
        }
    }
}

