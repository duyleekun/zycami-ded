/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.c$a;
import i.d.l;
import i.d.r.a;
import i.d.u.b;
import i.h.d;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

public class c
implements l,
ByteChannel,
a {
    private final i.h.c a;
    private final SocketChannel b;
    private final SSLEngine c;
    private ByteBuffer d;
    private ByteBuffer e;
    private ByteBuffer f;
    private ByteBuffer g;
    private ExecutorService h;

    public c(SocketChannel object, SSLEngine object2, ExecutorService object3, SelectionKey selectionKey) {
        Object object4 = i.h.d.i(c.class);
        this.a = object4;
        if (object != null && object2 != null && (object4 = this.h) != object3) {
            this.b = object;
            this.c = object2;
            this.h = object3;
            this.e = object3 = ByteBuffer.allocate(((SSLEngine)object2).getSession().getPacketBufferSize());
            int n10 = ((SSLEngine)object2).getSession().getPacketBufferSize();
            this.g = object3 = ByteBuffer.allocate(n10);
            ((SSLEngine)object2).beginHandshake();
            boolean bl2 = this.q();
            if (bl2) {
                if (selectionKey != null) {
                    int n11 = selectionKey.interestOps() | 4;
                    selectionKey.interestOps(n11);
                }
            } else {
                try {
                    ((AbstractInterruptibleChannel)object).close();
                }
                catch (IOException iOException) {
                    object2 = this.a;
                    object3 = "Exception during the closing of the channel";
                    object2.error((String)object3, iOException);
                }
            }
            return;
        }
        object = new IllegalArgumentException("parameter must not be null");
        throw object;
    }

    private ByteBuffer B(ByteBuffer byteBuffer) {
        int n10 = this.c.getSession().getApplicationBufferSize();
        return this.C(byteBuffer, n10);
    }

    private ByteBuffer C(ByteBuffer byteBuffer, int n10) {
        int n11 = byteBuffer.capacity();
        if (n10 > n11) {
            byteBuffer = ByteBuffer.allocate(n10);
        } else {
            int n12 = byteBuffer.capacity() * 2;
            byteBuffer = ByteBuffer.allocate(n12);
        }
        return byteBuffer;
    }

    private ByteBuffer D(ByteBuffer byteBuffer) {
        int n10 = this.c.getSession().getPacketBufferSize();
        return this.C(byteBuffer, n10);
    }

    private ByteBuffer E(ByteBuffer byteBuffer) {
        int n10;
        Object object = this.c.getSession();
        int n11 = object.getPacketBufferSize();
        if (n11 < (n10 = byteBuffer.limit())) {
            return byteBuffer;
        }
        object = this.D(byteBuffer);
        byteBuffer.flip();
        ((ByteBuffer)object).put(byteBuffer);
        return object;
    }

    private void O() {
        Object object = this.c;
        try {
            ((SSLEngine)object).closeInbound();
        }
        catch (Exception exception) {
            object = this.a;
            String string2 = "This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.";
            object.error(string2);
        }
        this.h();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        SSLEngine sSLEngine = this.c;
        sSLEngine.closeOutbound();
        try {
            this.q();
        }
        catch (IOException iOException) {}
        this.b.close();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean q() {
        Object object;
        int n10 = this.c.getSession().getApplicationBufferSize();
        Object object2 = ByteBuffer.allocate(n10);
        this.d = object2;
        this.f = object = ByteBuffer.allocate(n10);
        this.e.clear();
        this.g.clear();
        object = this.c.getHandshakeStatus();
        object2 = null;
        int n11 = 0;
        Comparable<ByteBuffer> comparable = null;
        while (true) {
            block30: {
                Object object3;
                Object object4;
                int n12;
                block31: {
                    block29: {
                        Object object5;
                        int n13;
                        SSLEngineResult.Status status;
                        Object object6;
                        int n14;
                        int n15;
                        int n16;
                        String string2;
                        block32: {
                            n12 = 1;
                            if (n11 != 0) {
                                return n12 != 0;
                            }
                            object4 = c$a.b;
                            int n17 = ((Enum)object).ordinal();
                            int n18 = object4[n17];
                            if (n18 == n12) break block31;
                            string2 = "Invalid SSL status: ";
                            n16 = 4;
                            n15 = 3;
                            n14 = 2;
                            if (n18 == n14) break block32;
                            if (n18 != n15) {
                                if (n18 != n16) {
                                    n12 = 5;
                                    if (n18 == n12) continue;
                                    comparable = new Comparable<ByteBuffer>();
                                    ((StringBuilder)comparable).append(string2);
                                    ((StringBuilder)comparable).append(object);
                                    object = ((StringBuilder)comparable).toString();
                                    object2 = new IllegalStateException((String)object);
                                    throw object2;
                                }
                                while ((object = this.c.getDelegatedTask()) != null) {
                                    object3 = this.h;
                                    object3.execute((Runnable)object);
                                }
                                object = this.c.getHandshakeStatus();
                                continue;
                            }
                            object = this.e;
                            object.clear();
                            try {
                                object = this.c;
                                object4 = this.d;
                                object6 = this.e;
                                object = ((SSLEngine)object).wrap((ByteBuffer)object4, (ByteBuffer)object6);
                                object4 = (Object)((SSLEngineResult)object).getHandshakeStatus();
                            }
                            catch (SSLException sSLException) {
                                this.c.closeOutbound();
                                object = this.c.getHandshakeStatus();
                            }
                            object6 = c$a.a;
                            status = ((SSLEngineResult)object).getStatus();
                            n13 = status.ordinal();
                            object5 = object6[n13];
                            if (object5 != n12) {
                                if (object5 == n14) {
                                    object = new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                                    throw object;
                                }
                                if (object5 != n15) {
                                    if (object5 != n16) {
                                        comparable = new Comparable<ByteBuffer>();
                                        ((StringBuilder)comparable).append(string2);
                                        object = ((SSLEngineResult)object).getStatus();
                                        ((StringBuilder)comparable).append(object);
                                        object = ((StringBuilder)comparable).toString();
                                        object2 = new IllegalStateException((String)object);
                                        throw object2;
                                    }
                                    try {
                                        object = this.e;
                                        object.flip();
                                        while ((n10 = (int)((object = this.e).hasRemaining() ? 1 : 0)) != 0) {
                                            object = this.b;
                                            object3 = this.e;
                                            ((SocketChannel)object).write((ByteBuffer)object3);
                                        }
                                        object = this.g;
                                        object.clear();
                                        break block29;
                                    }
                                    catch (Exception exception) {
                                        object = this.c.getHandshakeStatus();
                                        continue;
                                    }
                                }
                                object = this.e;
                                object = this.D((ByteBuffer)object);
                                this.e = object;
                                break block29;
                            } else {
                                object = this.e;
                                object.flip();
                                while ((n10 = (int)((object = this.e).hasRemaining() ? 1 : 0)) != 0) {
                                    object = this.b;
                                    object3 = this.e;
                                    ((SocketChannel)object).write((ByteBuffer)object3);
                                }
                            }
                            break block29;
                            continue;
                        }
                        object = this.b;
                        object4 = this.g;
                        n10 = ((SocketChannel)object).read((ByteBuffer)object4);
                        if (n10 < 0) {
                            object = this.c;
                            n10 = (int)(((SSLEngine)object).isInboundDone() ? 1 : 0);
                            if (n10 != 0 && (n10 = (int)(((SSLEngine)(object = this.c)).isOutboundDone() ? 1 : 0)) != 0) {
                                return false;
                            }
                            object = this.c;
                            ((SSLEngine)object).closeInbound();
                            break block30;
                        }
                        object = this.g;
                        object.flip();
                        try {
                            object = this.c;
                            object4 = this.g;
                            object6 = this.f;
                            object = ((SSLEngine)object).unwrap((ByteBuffer)object4, (ByteBuffer)object6);
                            object4 = this.g;
                            object4.compact();
                            object4 = ((SSLEngineResult)object).getHandshakeStatus();
                        }
                        catch (SSLException sSLException) {
                            this.c.closeOutbound();
                            object = this.c.getHandshakeStatus();
                        }
                        object6 = c$a.a;
                        status = ((SSLEngineResult)object).getStatus();
                        n13 = status.ordinal();
                        object5 = object6[n13];
                        if (object5 != n12) {
                            if (object5 != n14) {
                                if (object5 != n15) {
                                    if (object5 != n16) {
                                        comparable = new Comparable<ByteBuffer>();
                                        ((StringBuilder)comparable).append(string2);
                                        object = ((SSLEngineResult)object).getStatus();
                                        ((StringBuilder)comparable).append(object);
                                        object = ((StringBuilder)comparable).toString();
                                        object2 = new IllegalStateException((String)object);
                                        throw object2;
                                    }
                                    object = this.c;
                                    n10 = (int)(((SSLEngine)object).isOutboundDone() ? 1 : 0);
                                    if (n10 != 0) {
                                        return false;
                                    }
                                    this.c.closeOutbound();
                                    object = this.c.getHandshakeStatus();
                                    continue;
                                }
                                object = this.f;
                                object = this.B((ByteBuffer)object);
                                this.f = object;
                            } else {
                                object = this.g;
                                this.g = object = this.E((ByteBuffer)object);
                            }
                        }
                    }
                    object = object4;
                    continue;
                }
                comparable = this.g;
                n11 = ((Buffer)((Object)comparable)).hasRemaining() ^ n12;
                if (n11 != 0) {
                    return n12 != 0;
                }
                object3 = this.b;
                object4 = this.g;
                ((SocketChannel)object3).write((ByteBuffer)object4);
                continue;
                catch (SSLException sSLException) {}
            }
            this.c.closeOutbound();
            object = this.c.getHandshakeStatus();
        }
    }

    public int A(ByteBuffer byteBuffer) {
        return this.read(byteBuffer);
    }

    public boolean F() {
        return false;
    }

    public boolean H() {
        ByteBuffer byteBuffer = this.g;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2 && !(bl2 = (byteBuffer = this.f).hasRemaining())) {
            bl2 = false;
            byteBuffer = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public SSLEngine a() {
        return this.c;
    }

    public void close() {
        this.h();
    }

    public boolean f() {
        return this.b.isBlocking();
    }

    public boolean isOpen() {
        return this.b.isOpen();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(ByteBuffer object) {
        synchronized (this) {
            int n10;
            int n11 = ((Buffer)object).hasRemaining();
            if (n11 == 0) {
                return 0;
            }
            Object object2 = this.f;
            n11 = ((Buffer)object2).hasRemaining();
            if (n11 != 0) {
                object2 = this.f;
                ((ByteBuffer)object2).flip();
                object2 = this.f;
                return i.d.u.b.b((ByteBuffer)object2, (ByteBuffer)object);
            }
            object2 = this.g;
            ((ByteBuffer)object2).compact();
            object2 = this.b;
            Object object3 = this.g;
            n11 = ((SocketChannel)object2).read((ByteBuffer)object3);
            if (n11 <= 0 && (n10 = ((Buffer)(object3 = this.g)).hasRemaining()) == 0) {
                if (n11 < 0) {
                    this.O();
                }
            } else {
                object3 = this.g;
                ((ByteBuffer)object3).flip();
                object3 = this.g;
                n10 = ((Buffer)object3).hasRemaining();
                if (n10 != 0) {
                    Object object4;
                    object2 = this.f;
                    ((ByteBuffer)object2).compact();
                    try {
                        object2 = this.c;
                        object3 = this.g;
                        object4 = this.f;
                        object2 = ((SSLEngine)object2).unwrap((ByteBuffer)object3, (ByteBuffer)object4);
                    }
                    catch (SSLException sSLException) {
                        object2 = this.a;
                        object3 = "SSLExcpetion during unwrap";
                        object2.error((String)object3, sSLException);
                        throw sSLException;
                    }
                    object3 = c$a.a;
                    object4 = ((SSLEngineResult)object2).getStatus();
                    int n12 = ((Enum)object4).ordinal();
                    n10 = object3[n12];
                    n12 = 1;
                    if (n10 == n12) {
                        object2 = this.f;
                        ((ByteBuffer)object2).flip();
                        object2 = this.f;
                        return i.d.u.b.b((ByteBuffer)object2, (ByteBuffer)object);
                    }
                    n12 = 2;
                    if (n10 == n12) {
                        object2 = this.f;
                        ((ByteBuffer)object2).flip();
                        object2 = this.f;
                        return i.d.u.b.b((ByteBuffer)object2, (ByteBuffer)object);
                    }
                    n12 = 3;
                    if (n10 == n12) {
                        object2 = this.f;
                        this.f = object2 = this.B((ByteBuffer)object2);
                        return this.read((ByteBuffer)object);
                    }
                    n12 = 4;
                    if (n10 == n12) {
                        this.h();
                        ((ByteBuffer)object).clear();
                        return -1;
                    }
                    object3 = new StringBuilder();
                    object4 = "Invalid SSL status: ";
                    ((StringBuilder)object3).append((String)object4);
                    object2 = ((SSLEngineResult)object2).getStatus();
                    ((StringBuilder)object3).append(object2);
                    object2 = ((StringBuilder)object3).toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
            }
            object3 = this.f;
            i.d.u.b.b((ByteBuffer)object3, (ByteBuffer)object);
            return n11;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public int write(ByteBuffer object) {
        synchronized (this) {
            int n10;
            CharSequence charSequence = null;
            int n11 = 0;
            Object object2 = null;
            while ((n10 = ((Buffer)object).hasRemaining()) != 0) {
                Object object3 = this.e;
                ((ByteBuffer)object3).clear();
                object3 = this.c;
                Object object4 = this.e;
                object3 = ((SSLEngine)object3).wrap((ByteBuffer)object, (ByteBuffer)object4);
                object4 = c$a.a;
                SSLEngineResult.Status status = ((SSLEngineResult)object3).getStatus();
                int n12 = status.ordinal();
                Object object5 = object4[n12];
                n12 = 1;
                if (object5 != n12) {
                    n12 = 2;
                    if (object5 != n12) {
                        n12 = 3;
                        if (object5 != n12) {
                            int n13 = 4;
                            if (object5 == n13) {
                                this.h();
                                return 0;
                            }
                            charSequence = new StringBuilder();
                            object2 = "Invalid SSL status: ";
                            ((StringBuilder)charSequence).append((String)object2);
                            object2 = ((SSLEngineResult)object3).getStatus();
                            ((StringBuilder)charSequence).append(object2);
                            charSequence = ((StringBuilder)charSequence).toString();
                            object = new IllegalStateException((String)charSequence);
                            throw object;
                        }
                        object3 = this.e;
                        this.e = object3 = this.D((ByteBuffer)object3);
                        continue;
                    }
                    charSequence = "Buffer underflow occured after a wrap. I don't think we should ever get here.";
                    object = new SSLException((String)charSequence);
                    throw object;
                }
                object3 = this.e;
                ((ByteBuffer)object3).flip();
                while ((n10 = ((Buffer)(object3 = this.e)).hasRemaining()) != 0) {
                    object3 = this.b;
                    object4 = this.e;
                    n10 = ((SocketChannel)object3).write((ByteBuffer)object4);
                    n11 += n10;
                }
            }
            return n11;
        }
    }

    public void y() {
    }
}

