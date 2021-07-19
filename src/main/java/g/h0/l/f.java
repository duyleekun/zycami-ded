/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import g.h0.d;
import g.h0.l.b$a;
import g.h0.l.c;
import g.h0.l.f$a;
import g.h0.l.f$b;
import g.h0.l.f$c;
import g.h0.l.k;
import h.o;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

public final class f
implements Closeable {
    private static final Logger e;
    public static final f$a f;
    private final f$b a;
    private final b$a b;
    private final o c;
    private final boolean d;

    static {
        Object object = new f$a(null);
        f = object;
        object = Logger.getLogger(c.class.getName());
        f0.o(object, "Logger.getLogger(Http2::class.java.name)");
        e = object;
    }

    public f(o object, boolean bl2) {
        f$b f$b;
        f0.p(object, "source");
        this.c = object;
        this.d = bl2;
        this.a = f$b = new f$b((o)object);
        this.b = object = new b$a(f$b, 4096, 0, 4, null);
    }

    /*
     * WARNING - void declaration
     */
    private final void B(f$c object, int n10, int n11, int n12) {
        if (n12 != 0) {
            boolean bl2;
            int bl22 = n11 & 1;
            int n13 = 0;
            o o10 = null;
            boolean bl3 = true;
            if (bl22 != 0) {
                boolean bl4 = bl3;
            } else {
                boolean bl5 = false;
            }
            int n14 = n11 & 0x20;
            if (n14 == 0) {
                bl2 = false;
            }
            if (!bl2) {
                void var5_8;
                int n15 = n11 & 8;
                if (n15 != 0) {
                    o10 = this.c;
                    n13 = o10.readByte();
                    int n16 = 255;
                    n13 = g.h0.d.b((byte)n13, n16);
                }
                n10 = f.b(n10, n11, n13);
                o o11 = this.c;
                object.g((boolean)var5_8, n12, o11, n10);
                object = this.c;
                long l10 = n13;
                object.skip(l10);
                return;
            }
            object = new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            throw object;
        }
        object = new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        throw object;
    }

    private final void C(f$c object, int n10, int n11, int n12) {
        n11 = 8;
        if (n10 >= n11) {
            if (n12 == 0) {
                o o10 = this.c;
                n12 = o10.readInt();
                Object object2 = this.c;
                int n13 = object2.readInt();
                n10 -= n11;
                ErrorCode errorCode = ErrorCode.Companion.a(n13);
                if (errorCode != null) {
                    object2 = ByteString.EMPTY;
                    if (n10 > 0) {
                        object2 = this.c;
                        long l10 = n10;
                        object2 = object2.Q(l10);
                    }
                    object.l(n12, errorCode, (ByteString)object2);
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("TYPE_GOAWAY unexpected error code: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                object = new IOException((String)charSequence);
                throw object;
            }
            object = new IOException("TYPE_GOAWAY streamId != 0");
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TYPE_GOAWAY length < 8: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IOException(string2);
        throw object;
    }

    private final List D(int n10, int n11, int n12, int n13) {
        this.a.O(n10);
        f$b f$b = this.a;
        int n14 = f$b.h();
        f$b.S(n14);
        this.a.n0(n11);
        this.a.E(n12);
        this.a.o0(n13);
        this.b.l();
        return this.b.e();
    }

    /*
     * WARNING - void declaration
     */
    private final void E(f$c object, int n10, int n11, int n12) {
        if (n12 != 0) {
            void var5_8;
            int bl2 = n11 & 1;
            int n13 = 0;
            o o10 = null;
            if (bl2 != 0) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            int n14 = n11 & 8;
            if (n14 != 0) {
                o10 = this.c;
                n13 = o10.readByte();
                n14 = 255;
                n13 = g.h0.d.b((byte)n13, n14);
            }
            if ((n14 = n11 & 0x20) != 0) {
                this.S((f$c)object, n12);
                n10 += -5;
            }
            n10 = f.b(n10, n11, n13);
            List list = this.D(n10, n13, n11, n12);
            object.b((boolean)var5_8, n12, -1, list);
            return;
        }
        object = new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        throw object;
    }

    private final void O(f$c object, int n10, int n11, int n12) {
        int n13 = 8;
        if (n10 == n13) {
            if (n12 == 0) {
                o o10 = this.c;
                n10 = o10.readInt();
                o o11 = this.c;
                n12 = o11.readInt();
                n13 = 1;
                if ((n11 &= n13) == 0) {
                    n13 = 0;
                }
                object.i(n13 != 0, n10, n12);
                return;
            }
            object = new IOException("TYPE_PING streamId != 0");
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TYPE_PING length != 8: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IOException(string2);
        throw object;
    }

    private final void S(f$c f$c, int n10) {
        o o10 = this.c;
        int n11 = o10.readInt();
        long l10 = 0x80000000L;
        int n12 = (int)l10 & n11;
        int n13 = 1;
        n12 = n12 != 0 ? n13 : 0;
        int n14 = g.h0.d.b(this.c.readByte(), 255) + n13;
        f$c.j(n10, n11 &= -1 >>> 1, n14, n12 != 0);
    }

    public static final /* synthetic */ Logger a() {
        return e;
    }

    private final void n0(f$c object, int n10, int n11, int n12) {
        n11 = 5;
        if (n10 == n11) {
            if (n12 != 0) {
                this.S((f$c)object, n12);
                return;
            }
            object = new IOException("TYPE_PRIORITY streamId == 0");
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TYPE_PRIORITY length: ");
        stringBuilder.append(n10);
        stringBuilder.append(" != 5");
        String string2 = stringBuilder.toString();
        object = new IOException(string2);
        throw object;
    }

    private final void o0(f$c object, int n10, int n11, int n12) {
        if (n12 != 0) {
            int n13;
            int n14 = n11 & 8;
            if (n14 != 0) {
                o o10 = this.c;
                n14 = o10.readByte();
                n13 = 255;
                n14 = g.h0.d.b((byte)n14, n13);
            } else {
                n14 = 0;
                Object var6_7 = null;
            }
            n13 = this.c.readInt() & -1 >>> 1;
            f$a f$a = f;
            n10 += -4;
            n10 = f$a.b(n10, n11, n14);
            List list = this.D(n10, n14, n11, n12);
            object.e(n12, n13, list);
            return;
        }
        object = new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        throw object;
    }

    private final void p0(f$c object, int n10, int n11, int n12) {
        n11 = 4;
        if (n10 == n11) {
            if (n12 != 0) {
                Object object2 = this.c;
                n10 = object2.readInt();
                Object object3 = ErrorCode.Companion.a(n10);
                if (object3 != null) {
                    object.k(n12, (ErrorCode)((Object)object3));
                    return;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("TYPE_RST_STREAM unexpected error code: ");
                ((StringBuilder)object3).append(n10);
                object2 = ((StringBuilder)object3).toString();
                object = new IOException((String)object2);
                throw object;
            }
            object = new IOException("TYPE_RST_STREAM streamId == 0");
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TYPE_RST_STREAM length: ");
        stringBuilder.append(n10);
        stringBuilder.append(" != 4");
        String string2 = stringBuilder.toString();
        object = new IOException(string2);
        throw object;
    }

    private final void q0(f$c object, int n10, int n11, int n12) {
        if (n12 == 0) {
            n12 = 1;
            if ((n11 &= n12) != 0) {
                if (n10 == 0) {
                    object.f();
                    return;
                }
                object = new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                throw object;
            }
            n11 = n10 % 6;
            if (n11 == 0) {
                k k10 = new k();
                Object object2 = q.S0(q.n1(0, n10), 6);
                int n13 = ((i)object2).e();
                int n14 = ((i)object2).f();
                n10 = ((i)object2).g();
                if (n10 >= 0 ? n13 <= n14 : n13 >= n14) {
                    while (true) {
                        o o10 = this.c;
                        int n15 = g.h0.d.c(o10.readShort(), (char)-1);
                        o o11 = this.c;
                        int n16 = o11.readInt();
                        int n17 = 2;
                        int n18 = 4;
                        if (n15 != n17) {
                            n17 = 3;
                            if (n15 != n17) {
                                if (n15 != n18) {
                                    n17 = 5;
                                    if (n15 == n17 && (n16 < (n17 = 16384) || n16 > (n17 = 0xFFFFFF))) {
                                        object2 = new StringBuilder();
                                        ((StringBuilder)object2).append("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ");
                                        ((StringBuilder)object2).append(n16);
                                        object2 = ((StringBuilder)object2).toString();
                                        object = new IOException((String)object2);
                                        throw object;
                                    }
                                } else {
                                    n15 = 7;
                                    if (n16 < 0) {
                                        object = new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        throw object;
                                    }
                                }
                            } else {
                                n15 = n18;
                            }
                        } else if (n16 != 0 && n16 != n12) {
                            object = new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                            throw object;
                        }
                        k10.k(n15, n16);
                        if (n13 == n14) break;
                        n13 += n10;
                    }
                }
                object.a(false, k10);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TYPE_SETTINGS length % 6 != 0: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            object = new IOException(string2);
            throw object;
        }
        object = new IOException("TYPE_SETTINGS streamId != 0");
        throw object;
    }

    private final void r0(f$c object, int n10, int n11, int n12) {
        n11 = 4;
        if (n10 == n11) {
            long l10;
            o o10 = this.c;
            n10 = o10.readInt();
            long l11 = g.h0.d.d(n10, Integer.MAX_VALUE);
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) {
                object.c(n12, l11);
                return;
            }
            object = new IOException("windowSizeIncrement was 0");
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TYPE_WINDOW_UPDATE length !=4: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IOException(string2);
        throw object;
    }

    public void close() {
        this.c.close();
    }

    public final boolean h(boolean n10, f$c object) {
        Object object2 = "handler";
        f0.p(object, (String)object2);
        try {
            object2 = this.c;
        }
        catch (EOFException eOFException) {
            return false;
        }
        long l10 = 9;
        object2.L(l10);
        object2 = this.c;
        int n11 = g.h0.d.R((o)object2);
        int n12 = 16384;
        if (n11 <= n12) {
            n12 = this.c.readByte();
            int n13 = 255;
            int n14 = g.h0.d.b((byte)n12, n13);
            int n15 = g.h0.d.b(this.c.readByte(), n13);
            n12 = this.c.readInt();
            n13 = -1 >>> 1;
            int n16 = n12 & n13;
            Logger logger = e;
            Object object3 = Level.FINE;
            n12 = (int)(logger.isLoggable((Level)object3) ? 1 : 0);
            if (n12 != 0) {
                object3 = g.h0.l.c.x;
                n13 = 1;
                object3 = ((c)object3).c(n13 != 0, n16, n11, n14, n15);
                logger.fine((String)object3);
            }
            if (n10 != 0 && n14 != (n10 = 4)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Expected a SETTINGS frame but was ");
                object2 = g.h0.l.c.x.b(n14);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                IOException iOException = new IOException((String)object);
                throw iOException;
            }
            switch (n14) {
                default: {
                    o o10 = this.c;
                    long l11 = n11;
                    o10.skip(l11);
                    break;
                }
                case 8: {
                    this.r0((f$c)object, n11, n15, n16);
                    break;
                }
                case 7: {
                    this.C((f$c)object, n11, n15, n16);
                    break;
                }
                case 6: {
                    this.O((f$c)object, n11, n15, n16);
                    break;
                }
                case 5: {
                    this.o0((f$c)object, n11, n15, n16);
                    break;
                }
                case 4: {
                    this.q0((f$c)object, n11, n15, n16);
                    break;
                }
                case 3: {
                    this.p0((f$c)object, n11, n15, n16);
                    break;
                }
                case 2: {
                    this.n0((f$c)object, n11, n15, n16);
                    break;
                }
                case 1: {
                    this.E((f$c)object, n11, n15, n16);
                    break;
                }
                case 0: {
                    this.B((f$c)object, n11, n15, n16);
                }
            }
            return true;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("FRAME_SIZE_ERROR: ");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    public final void q(f$c object) {
        Object object2;
        block8: {
            block7: {
                boolean bl2;
                boolean bl3;
                block6: {
                    object2 = "handler";
                    f0.p(object, (String)object2);
                    bl3 = this.d;
                    bl2 = true;
                    if (!bl3) break block6;
                    boolean bl4 = this.h(bl2, (f$c)object);
                    if (!bl4) {
                        object = new IOException("Required SETTINGS preface not received");
                        throw object;
                    }
                    break block7;
                }
                object = this.c;
                object2 = g.h0.l.c.a;
                int n10 = ((ByteString)object2).size();
                long l10 = n10;
                object = object.Q(l10);
                Logger logger = e;
                Object object3 = Level.FINE;
                boolean bl5 = logger.isLoggable((Level)object3);
                if (bl5) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("<< CONNECTION ");
                    Object[] objectArray = ((ByteString)object).hex();
                    ((StringBuilder)object3).append((String)objectArray);
                    object3 = ((StringBuilder)object3).toString();
                    objectArray = new Object[]{};
                    object3 = g.h0.d.v((String)object3, objectArray);
                    logger.fine((String)object3);
                }
                if (bl3 = f0.g(object2, object) ^ bl2) break block8;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a connection header but was ");
        object = ((ByteString)object).utf8();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IOException((String)object);
        throw object2;
    }
}

