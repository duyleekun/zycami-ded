/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.l;
import i.d.r.a;
import i.h.c;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

public class d
implements ByteChannel,
l,
a {
    public static ByteBuffer n = ByteBuffer.allocate(0);
    public static final /* synthetic */ boolean o;
    private final c a;
    public ExecutorService b;
    public List c;
    public ByteBuffer d;
    public ByteBuffer e;
    public ByteBuffer f;
    public SocketChannel g;
    public SelectionKey h;
    public SSLEngine i;
    public SSLEngineResult j;
    public SSLEngineResult k;
    public int l;
    private byte[] m;

    public d(SocketChannel object, SSLEngine object2, ExecutorService object3, SelectionKey selectionKey) {
        c c10;
        this.a = c10 = i.h.d.i(d.class);
        c10 = null;
        this.l = 0;
        SSLEngineResult.HandshakeStatus handshakeStatus = null;
        this.m = null;
        if (object != null && object2 != null && object3 != null) {
            this.g = object;
            this.i = object2;
            this.b = object3;
            object3 = SSLEngineResult.Status.BUFFER_UNDERFLOW;
            handshakeStatus = ((SSLEngine)object2).getHandshakeStatus();
            this.k = object = new SSLEngineResult((SSLEngineResult.Status)((Object)object3), handshakeStatus, 0, 0);
            this.j = object;
            int n10 = 3;
            object = new ArrayList(n10);
            this.c = object;
            if (selectionKey != null) {
                int n11 = selectionKey.interestOps() | 4;
                selectionKey.interestOps(n11);
                this.h = selectionKey;
            }
            object = ((SSLEngine)object2).getSession();
            this.D((SSLSession)object);
            object = this.g;
            object2 = n;
            object2 = this.v0((ByteBuffer)object2);
            ((SocketChannel)object).write((ByteBuffer)object2);
            this.o0();
            return;
        }
        object = new IllegalArgumentException("parameter must not be null");
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C(Future future) {
        Object object;
        ExecutionException executionException2222222;
        while (true) {
            future.get();
            return;
            {
                catch (ExecutionException executionException2222222) {
                    break;
                }
                catch (InterruptedException interruptedException) {}
                {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                    continue;
                }
            }
            break;
        }
        object = new RuntimeException(executionException2222222);
        throw object;
    }

    private boolean S() {
        boolean bl2;
        SSLEngineResult.HandshakeStatus handshakeStatus;
        SSLEngineResult.HandshakeStatus handshakeStatus2 = this.i.getHandshakeStatus();
        if (handshakeStatus2 != (handshakeStatus = SSLEngineResult.HandshakeStatus.FINISHED) && handshakeStatus2 != (handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
            bl2 = false;
            handshakeStatus2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void o0() {
        synchronized (this) {
            int n10;
            block26: {
                Object object;
                Object object2;
                block25: {
                    block22: {
                        block24: {
                            int n11;
                            block23: {
                                object2 = this.i;
                                object2 = ((SSLEngine)object2).getHandshakeStatus();
                                object = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                                if (object2 == object) {
                                    return;
                                }
                                object2 = this.c;
                                n10 = object2.isEmpty();
                                if (n10 == 0) {
                                    object2 = this.c;
                                    object2 = object2.iterator();
                                    while ((n11 = object2.hasNext()) != 0) {
                                        object = object2.next();
                                        boolean bl2 = (object = (Future)object).isDone();
                                        if (bl2) {
                                            object2.remove();
                                            continue;
                                        }
                                        n10 = this.f();
                                        if (n10 != 0) {
                                            this.C((Future)object);
                                        }
                                        return;
                                    }
                                }
                                object2 = this.i;
                                if ((object2 = ((SSLEngine)object2).getHandshakeStatus()) != (object = SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) break block22;
                                n10 = this.f();
                                if (n10 == 0) break block23;
                                object2 = this.j;
                                if ((object2 = ((SSLEngineResult)object2).getStatus()) != (object = SSLEngineResult.Status.BUFFER_UNDERFLOW)) break block24;
                            }
                            object2 = this.f;
                            ((ByteBuffer)object2).compact();
                            object2 = this.g;
                            object = this.f;
                            n10 = ((SocketChannel)object2).read((ByteBuffer)object);
                            n11 = -1;
                            if (n10 == n11) {
                                object = "connection closed unexpectedly by peer";
                                object2 = new IOException((String)object);
                                throw object2;
                            }
                            object2 = this.f;
                            ((ByteBuffer)object2).flip();
                        }
                        object2 = this.d;
                        ((ByteBuffer)object2).compact();
                        this.u0();
                        object2 = this.j;
                        object2 = ((SSLEngineResult)object2).getHandshakeStatus();
                        object = SSLEngineResult.HandshakeStatus.FINISHED;
                        if (object2 == object) {
                            object2 = this.i;
                            object2 = ((SSLEngine)object2).getSession();
                            this.D((SSLSession)object2);
                            return;
                        }
                    }
                    this.B();
                    object2 = this.c;
                    n10 = object2.isEmpty();
                    if (n10 != 0) break block25;
                    object2 = this.i;
                    if ((object2 = ((SSLEngine)object2).getHandshakeStatus()) != (object = SSLEngineResult.HandshakeStatus.NEED_WRAP)) break block26;
                }
                object2 = this.g;
                object = n;
                object = this.v0((ByteBuffer)object);
                ((SocketChannel)object2).write((ByteBuffer)object);
                object2 = this.k;
                object2 = ((SSLEngineResult)object2).getHandshakeStatus();
                object = SSLEngineResult.HandshakeStatus.FINISHED;
                if (object2 == object) {
                    object2 = this.i;
                    object2 = ((SSLEngine)object2).getSession();
                    this.D((SSLSession)object2);
                    return;
                }
            }
            this.l = n10 = 1;
            return;
        }
    }

    private int p0(ByteBuffer byteBuffer) {
        Object object = this.d;
        boolean bl2 = object.hasRemaining();
        if (bl2) {
            object = this.d;
            return this.s0((ByteBuffer)object, byteBuffer);
        }
        object = this.d;
        bl2 = object.hasRemaining();
        if (!bl2) {
            object = this.d;
            object.clear();
        }
        this.t0();
        object = this.f;
        bl2 = object.hasRemaining();
        if (bl2) {
            this.u0();
            object = this.d;
            int n10 = this.s0((ByteBuffer)object, byteBuffer);
            object = this.j.getStatus();
            SSLEngineResult.Status status = SSLEngineResult.Status.CLOSED;
            if (object == status) {
                return -1;
            }
            if (n10 > 0) {
                return n10;
            }
        }
        return 0;
    }

    private void q0() {
        int n10;
        Object object = this.f;
        if (object != null && (n10 = ((Buffer)object).remaining()) > 0) {
            n10 = this.f.remaining();
            object = new byte[n10];
            this.m = (byte[])object;
            ByteBuffer byteBuffer = this.f;
            byteBuffer.get((byte[])object);
        }
    }

    private int s0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 > (n10 = byteBuffer2.remaining())) {
            n11 = Math.min(n11, n10);
            for (n10 = 0; n10 < n11; ++n10) {
                byte by2 = byteBuffer.get();
                byteBuffer2.put(by2);
            }
            return n11;
        }
        byteBuffer2.put(byteBuffer);
        return n11;
    }

    private void t0() {
        Object object = this.m;
        if (object != null) {
            this.f.clear();
            object = this.f;
            byte[] byArray = this.m;
            object.put(byArray);
            this.f.flip();
            object = null;
            this.m = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ByteBuffer u0() {
        synchronized (this) {
            SSLEngineResult.HandshakeStatus handshakeStatus;
            SSLEngine sSLEngine;
            SSLEngineResult.HandshakeStatus handshakeStatus2;
            ByteBuffer byteBuffer;
            int n10;
            int n11;
            SSLEngineResult.Status status;
            SSLEngineResult sSLEngineResult;
            SSLEngineResult.Status status2;
            SSLEngineResult.HandshakeStatus handshakeStatus3;
            SSLEngine sSLEngine2;
            SSLEngineResult.HandshakeStatus handshakeStatus4;
            SSLEngineResult sSLEngineResult2 = this.j;
            SSLEngineResult.Status status3 = sSLEngineResult2.getStatus();
            SSLEngineResult.Status status4 = SSLEngineResult.Status.CLOSED;
            if (status3 == status4 && (handshakeStatus4 = (sSLEngine2 = this.i).getHandshakeStatus()) == (handshakeStatus3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
                try {
                    this.close();
                }
                catch (IOException iOException) {}
            }
            do {
                ByteBuffer byteBuffer2 = this.d;
                n11 = byteBuffer2.remaining();
                SSLEngine sSLEngine3 = this.i;
                ByteBuffer byteBuffer3 = this.f;
                ByteBuffer byteBuffer4 = this.d;
                this.j = sSLEngineResult = sSLEngine3.unwrap(byteBuffer3, byteBuffer4);
            } while ((status2 = sSLEngineResult.getStatus()) == (status = SSLEngineResult.Status.OK) && (n11 != (n10 = (byteBuffer = this.d).remaining()) || (handshakeStatus2 = (sSLEngine = this.i).getHandshakeStatus()) == (handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP)));
            ByteBuffer byteBuffer5 = this.d;
            byteBuffer5.flip();
            return this.d;
        }
    }

    private ByteBuffer v0(ByteBuffer object) {
        synchronized (this) {
            Object object2 = this.e;
            ((ByteBuffer)object2).compact();
            object2 = this.i;
            ByteBuffer byteBuffer = this.e;
            this.k = object = ((SSLEngine)object2).wrap((ByteBuffer)object, byteBuffer);
            object = this.e;
            ((ByteBuffer)object).flip();
            object = this.e;
            return object;
        }
    }

    public int A(ByteBuffer byteBuffer) {
        return this.p0(byteBuffer);
    }

    public void B() {
        Object object;
        while ((object = this.i.getDelegatedTask()) != null) {
            List list = this.c;
            ExecutorService executorService = this.b;
            object = executorService.submit((Runnable)object);
            list.add(object);
        }
    }

    public void D(SSLSession object) {
        String string2;
        int n10;
        ByteBuffer byteBuffer;
        int n11;
        ByteBuffer byteBuffer2;
        this.q0();
        int n12 = object.getPacketBufferSize();
        int n13 = Math.max(object.getApplicationBufferSize(), n12);
        Object object2 = this.d;
        if (object2 == null) {
            this.d = object = ByteBuffer.allocate(n13);
            this.e = object = ByteBuffer.allocate(n12);
            this.f = object = ByteBuffer.allocate(n12);
        } else {
            int n14 = ((Buffer)object2).capacity();
            if (n14 != n13) {
                this.d = object = ByteBuffer.allocate(n13);
            }
            if ((n13 = ((Buffer)(object = this.e)).capacity()) != n12) {
                this.e = object = ByteBuffer.allocate(n12);
            }
            if ((n13 = ((Buffer)(object = this.f)).capacity()) != n12) {
                this.f = object = ByteBuffer.allocate(n12);
            }
        }
        object = this.d;
        n13 = ((Buffer)object).remaining();
        if (n13 != 0 && (n13 = (int)((object = this.a).isTraceEnabled() ? 1 : 0)) != 0) {
            object = this.a;
            object2 = this.d.array();
            byteBuffer2 = this.d;
            n11 = byteBuffer2.position();
            byteBuffer = this.d;
            n10 = byteBuffer.remaining();
            string2 = new String((byte[])object2, n11, n10);
            object.trace(string2);
        }
        this.d.rewind();
        this.d.flip();
        object = this.f;
        n13 = ((Buffer)object).remaining();
        if (n13 != 0 && (n13 = (int)((object = this.a).isTraceEnabled() ? 1 : 0)) != 0) {
            object = this.a;
            object2 = this.f.array();
            byteBuffer2 = this.f;
            n11 = byteBuffer2.position();
            byteBuffer = this.f;
            n10 = byteBuffer.remaining();
            string2 = new String((byte[])object2, n11, n10);
            object.trace(string2);
        }
        this.f.rewind();
        this.f.flip();
        this.e.rewind();
        this.e.flip();
        this.l = n13 = this.l + 1;
    }

    public boolean E() {
        return this.g.finishConnect();
    }

    public boolean F() {
        ByteBuffer byteBuffer = this.e;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2 && (bl2 = this.S())) {
            bl2 = false;
            byteBuffer = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean H() {
        SSLEngineResult.Status status;
        boolean bl2;
        Object object = this.m;
        if (!(object != null || (bl2 = (object = (Object)this.d).hasRemaining()) || (bl2 = (object = this.f).hasRemaining()) && (object = this.j.getStatus()) != (status = SSLEngineResult.Status.BUFFER_UNDERFLOW) && (object = (Object)((Object)this.j.getStatus())) != (status = SSLEngineResult.Status.CLOSED))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean O() {
        return this.g.isConnected();
    }

    public SSLEngine a() {
        return this.i;
    }

    public void close() {
        this.i.closeOutbound();
        this.i.getSession().invalidate();
        SocketChannel socketChannel = this.g;
        boolean bl2 = socketChannel.isOpen();
        if (bl2) {
            socketChannel = this.g;
            ByteBuffer byteBuffer = n;
            byteBuffer = this.v0(byteBuffer);
            socketChannel.write(byteBuffer);
        }
        this.g.close();
    }

    public boolean f() {
        return this.g.isBlocking();
    }

    public SelectableChannel h(boolean bl2) {
        return this.g.configureBlocking(bl2);
    }

    public boolean isOpen() {
        return this.g.isOpen();
    }

    public boolean n0() {
        return this.i.isInboundDone();
    }

    public boolean q(SocketAddress socketAddress) {
        return this.g.connect(socketAddress);
    }

    public Socket r0() {
        return this.g.socket();
    }

    public int read(ByteBuffer byteBuffer) {
        int n10;
        int n11;
        this.t0();
        do {
            n11 = byteBuffer.hasRemaining();
            n10 = 0;
            Object object = null;
            if (n11 == 0) {
                return 0;
            }
            n11 = this.S();
            if (n11 == 0) {
                n11 = this.f();
                if (n11 != 0) {
                    while ((n11 = (int)(this.S() ? 1 : 0)) == 0) {
                        this.o0();
                    }
                } else {
                    this.o0();
                    n11 = (int)(this.S() ? 1 : 0);
                    if (n11 == 0) {
                        return 0;
                    }
                }
            }
            if ((n11 = this.p0(byteBuffer)) != 0) {
                return n11;
            }
            this.d.clear();
            Object object2 = this.f;
            n11 = (int)(((Buffer)object2).hasRemaining() ? 1 : 0);
            if (n11 == 0) {
                object2 = this.f;
                ((ByteBuffer)object2).clear();
            } else {
                object2 = this.f;
                ((ByteBuffer)object2).compact();
            }
            n11 = (int)(this.f() ? 1 : 0);
            if ((n11 != 0 || (object2 = this.j.getStatus()) == (object = SSLEngineResult.Status.BUFFER_UNDERFLOW)) && (n11 = ((SocketChannel)(object2 = this.g)).read((ByteBuffer)(object = this.f))) == (n10 = -1)) {
                return n10;
            }
            this.f.flip();
            this.u0();
            object2 = this.d;
            n11 = this.s0((ByteBuffer)object2, byteBuffer);
        } while (n11 == 0 && (n10 = (int)(this.f() ? 1 : 0)) != 0);
        return n11;
    }

    public int write(ByteBuffer object) {
        SSLEngineResult.Status status;
        boolean bl2 = this.S();
        if (!bl2) {
            this.o0();
            return 0;
        }
        Object object2 = this.g;
        object = this.v0((ByteBuffer)object);
        int n10 = object2.write((ByteBuffer)object);
        object2 = this.k.getStatus();
        if (object2 != (status = SSLEngineResult.Status.CLOSED)) {
            return n10;
        }
        object = new EOFException("Connection is closed");
        throw object;
    }

    public void y() {
        ByteBuffer byteBuffer = this.e;
        this.write(byteBuffer);
    }
}

