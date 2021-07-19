/*
 * Decompiled with CFR 0.151.
 */
package g.h0.g;

import f.h2.t.f0;
import f.h2.t.u;
import f.q1;
import g.h0.d;
import g.h0.g.a;
import g.h0.g.b$a;
import g.h0.g.b$b;
import h.m;
import h.m0;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okio.ByteString;
import okio.ByteString$a;

public final class b {
    private static final int k = 1;
    private static final int l = 2;
    public static final ByteString m;
    public static final ByteString n;
    private static final long o = 32L;
    public static final b$a p;
    private Thread a;
    private final m b;
    private boolean c;
    private final m d;
    private int e;
    private RandomAccessFile f;
    private m0 g;
    private long h;
    private final ByteString i;
    private final long j;

    static {
        Object object = new b$a(null);
        p = object;
        object = ByteString.Companion;
        m = ((ByteString$a)object).l("OkHttp cache v1\n");
        n = ((ByteString$a)object).l("OkHttp DIRTY :(\n");
    }

    private b(RandomAccessFile closeable, m0 m02, long l10, ByteString byteString, long l11) {
        boolean bl2;
        this.f = closeable;
        this.g = m02;
        this.h = l10;
        this.i = byteString;
        this.j = l11;
        this.b = closeable;
        closeable = this.g;
        if (closeable == null) {
            bl2 = true;
        } else {
            bl2 = false;
            closeable = null;
        }
        this.c = bl2;
        super();
        this.d = closeable;
    }

    public /* synthetic */ b(RandomAccessFile randomAccessFile, m0 m02, long l10, ByteString byteString, long l11, u u10) {
        this(randomAccessFile, m02, l10, byteString, l11);
    }

    public static final /* synthetic */ void a(b b10, ByteString byteString, long l10, long l11) {
        b10.u(byteString, l10, l11);
    }

    private final void u(ByteString object, long l10, long l11) {
        m m10 = new m();
        m10.W0((ByteString)object);
        m10.g1(l10);
        m10.g1(l11);
        long l12 = m10.S0();
        long l13 = 32;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 == false) {
            l14 = 1;
        } else {
            l14 = 0;
            object = null;
        }
        if (l14 != false) {
            object = this.f;
            f0.m(object);
            object = ((RandomAccessFile)object).getChannel();
            f0.o(object, "file!!.channel");
            a a10 = new a((FileChannel)object);
            a10.b(0L, m10, 32);
            return;
        }
        String string2 = "Failed requirement.".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private final void v(long l10) {
        m m10 = new m();
        Object object = this.i;
        m10.W0((ByteString)object);
        Closeable closeable = this.f;
        f0.m(closeable);
        closeable = closeable.getChannel();
        f0.o(closeable, "file!!.channel");
        object = new a((FileChannel)closeable);
        long l11 = (long)32 + l10;
        long l12 = this.i.size();
        ((a)object).b(l11, m10, l12);
    }

    public final void b(long l10) {
        this.v(l10);
        Object object = this.f;
        f0.m(object);
        ((RandomAccessFile)object).getChannel().force(false);
        ByteString byteString = m;
        object = this.i;
        int n10 = ((ByteString)object).size();
        long l11 = n10;
        this.u(byteString, l10, l11);
        Object object2 = this.f;
        f0.m(object2);
        object2 = ((RandomAccessFile)object2).getChannel();
        ((FileChannel)object2).force(false);
        synchronized (this) {
            block4: {
                boolean bl2 = true;
                this.c = bl2;
                object2 = q1.a;
                object2 = this.g;
                if (object2 == null) break block4;
                g.h0.d.l((Closeable)object2);
            }
            this.g = null;
            return;
            finally {
            }
        }
    }

    public final m c() {
        return this.d;
    }

    public final long d() {
        return this.j;
    }

    public final boolean e() {
        return this.c;
    }

    public final RandomAccessFile f() {
        return this.f;
    }

    public final int g() {
        return this.e;
    }

    public final m0 h() {
        return this.g;
    }

    public final m i() {
        return this.b;
    }

    public final long j() {
        return this.h;
    }

    public final Thread k() {
        return this.a;
    }

    public final boolean l() {
        boolean bl2;
        RandomAccessFile randomAccessFile = this.f;
        if (randomAccessFile == null) {
            bl2 = true;
        } else {
            bl2 = false;
            randomAccessFile = null;
        }
        return bl2;
    }

    public final ByteString m() {
        return this.i;
    }

    public final m0 n() {
        synchronized (this) {
            Closeable closeable;
            block5: {
                closeable = this.f;
                if (closeable != null) break block5;
                return null;
            }
            int n10 = this.e + 1;
            this.e = n10;
            // MONITOREXIT @DISABLED, blocks:[2, 3] lbl11 : MonitorExitStatement: MONITOREXIT : this
            closeable = new b$b(this);
            return closeable;
        }
    }

    public final void o(boolean bl2) {
        this.c = bl2;
    }

    public final void p(RandomAccessFile randomAccessFile) {
        this.f = randomAccessFile;
    }

    public final void q(int n10) {
        this.e = n10;
    }

    public final void r(m0 m02) {
        this.g = m02;
    }

    public final void s(long l10) {
        this.h = l10;
    }

    public final void t(Thread thread) {
        this.a = thread;
    }
}

