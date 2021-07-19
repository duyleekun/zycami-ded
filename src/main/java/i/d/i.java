/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.f;
import i.d.j;
import i.d.p.b;
import i.d.p.h;
import i.d.r.a;
import i.d.t.e$a;
import i.d.u.c;
import i.h.d;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;

public class i
implements f {
    public static final int v = 80;
    public static final int w = 443;
    public static final int x = 16384;
    public static final /* synthetic */ boolean y;
    private final i.h.c a;
    public final BlockingQueue b;
    public final BlockingQueue c;
    private final j d;
    private SelectionKey e;
    private ByteChannel f;
    private e$a g;
    private boolean h;
    private volatile ReadyState i;
    private List j;
    private i.d.n.a k;
    private Role l;
    private ByteBuffer m;
    private i.d.q.a n;
    private String o;
    private Integer p;
    private Boolean q;
    private String r;
    private long s;
    private final Object t;
    private Object u;

    public i(j object, i.d.n.a a10) {
        long l10;
        Object object2 = i.h.d.i(i.class);
        this.a = object2;
        this.h = false;
        Enum enum_ = ReadyState.NOT_YET_CONNECTED;
        this.i = enum_;
        enum_ = null;
        this.k = null;
        this.m = object2 = ByteBuffer.allocate(0);
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = l10 = System.nanoTime();
        this.t = object2 = new Object();
        if (object != null && (a10 != null || (object2 = this.l) != (enum_ = Role.SERVER))) {
            object2 = new LinkedBlockingQueue();
            this.b = object2;
            object2 = new LinkedBlockingQueue();
            this.c = object2;
            this.d = object;
            object = Role.CLIENT;
            this.l = object;
            if (a10 != null) {
                object = a10.f();
                this.k = object;
            }
            return;
        }
        object = new IllegalArgumentException("parameters must not be null");
        throw object;
    }

    public i(j object, List object2) {
        this((j)object, (i.d.n.a)null);
        boolean bl2;
        object = Role.SERVER;
        this.l = object;
        if (object2 != null && !(bl2 = object2.isEmpty())) {
            this.j = object2;
        } else {
            this.j = object;
            object2 = new i.d.n.b();
            object.add(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void A(List object) {
        Object object2 = this.t;
        synchronized (object2) {
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (ByteBuffer)object3;
                this.z((ByteBuffer)object3);
            }
            return;
        }
    }

    private void f(RuntimeException object) {
        ByteBuffer byteBuffer = this.m(500);
        this.z(byteBuffer);
        object = ((Throwable)object).getMessage();
        this.l(-1, (String)object, false);
    }

    private void g(InvalidDataException object) {
        ByteBuffer byteBuffer = this.m(404);
        this.z(byteBuffer);
        int n10 = ((InvalidDataException)object).getCloseCode();
        object = ((Throwable)object).getMessage();
        this.l(n10, (String)object, false);
    }

    private void i(ByteBuffer iterator2) {
        block13: {
            int n10;
            Object object;
            Object object2 = this.k;
            iterator2 = ((i.d.n.a)object2).x((ByteBuffer)((Object)iterator2));
            try {
                iterator2 = iterator2.iterator();
            }
            catch (InvalidDataException invalidDataException) {
                object2 = this.a;
                object = "Closing due to invalid data in frame";
                object2.error((String)object, invalidDataException);
                object2 = this.d;
                object2.onWebsocketError(this, invalidDataException);
                this.b(invalidDataException);
                break block13;
            }
            catch (LimitExceededException limitExceededException) {
                n10 = limitExceededException.getLimit();
                int n11 = -1 >>> 1;
                if (n10 == n11) {
                    object2 = this.a;
                    object = "Closing due to invalid size of frame";
                    object2.error((String)object, limitExceededException);
                    object2 = this.d;
                    object2.onWebsocketError(this, limitExceededException);
                }
                this.b(limitExceededException);
            }
            while (true) {
                n10 = (int)(iterator2.hasNext() ? 1 : 0);
                if (n10 == 0) break;
                object2 = iterator2.next();
                object2 = (i.d.p.f)object2;
                object = this.a;
                String string2 = "matched frame: {}";
                object.trace(string2, object2);
                object = this.k;
                ((i.d.n.a)object).r(this, (i.d.p.f)object2);
                continue;
                break;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private boolean j(ByteBuffer var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 85[TRYBLOCK] [190 : 1032->1036)] org.java_websocket.exceptions.IncompleteHandshakeException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    private ByteBuffer m(int n10) {
        int n11 = 404;
        String string2 = n10 != n11 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 ");
        stringBuilder.append(string2);
        stringBuilder.append("\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: ");
        int n12 = string2.length() + 48;
        stringBuilder.append(n12);
        stringBuilder.append("\r\n\r\n<html><head></head><body><h1>");
        stringBuilder.append(string2);
        stringBuilder.append("</h1></body></html>");
        return ByteBuffer.wrap(i.d.u.c.a(stringBuilder.toString()));
    }

    private void s(i.d.q.f f10) {
        Object object = this.a;
        i.d.n.a a10 = this.k;
        String string2 = "open using draft: {}";
        object.trace(string2, (Object)a10);
        object = ReadyState.OPEN;
        this.i = object;
        object = this.d;
        try {
            object.onWebsocketOpen(this, f10);
        }
        catch (RuntimeException runtimeException) {
            object = this.d;
            object.onWebsocketError(this, runtimeException);
        }
    }

    private void t(Collection iterator2) {
        boolean bl2 = this.isOpen();
        if (bl2) {
            if (iterator2 != null) {
                boolean bl3;
                ArrayList<Object> arrayList = new ArrayList<Object>();
                iterator2 = iterator2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    Object object = (i.d.p.f)iterator2.next();
                    Object object2 = this.a;
                    String string2 = "send frame: {}";
                    object2.trace(string2, object);
                    object2 = this.k;
                    object = ((i.d.n.a)object2).g((i.d.p.f)object);
                    arrayList.add(object);
                }
                this.A(arrayList);
                return;
            }
            iterator2 = new Iterator();
            throw iterator2;
        }
        iterator2 = new Iterator();
        throw iterator2;
    }

    private void z(ByteBuffer byteBuffer) {
        String string2;
        int n10;
        i.h.c c10 = this.a;
        int n11 = byteBuffer.remaining();
        Integer n12 = n11;
        int n13 = byteBuffer.remaining();
        if (n13 > (n10 = 1000)) {
            string2 = "too big to display";
        } else {
            byte[] byArray = byteBuffer.array();
            string2 = new String(byArray);
        }
        c10.trace("write({}): {}", (Object)n12, (Object)string2);
        this.b.add(byteBuffer);
        this.d.onWriteDemand(this);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int var1_1, String var2_2, boolean var3_3) {
        synchronized (this) {
            block16: {
                block19: {
                    block17: {
                        block18: {
                            var4_4 = this.i;
                            var5_5 = ReadyState.CLOSING;
                            if (var4_4 == var5_5 || (var4_4 = this.i) == (var6_9 /* !! */  = ReadyState.CLOSED)) break block16;
                            var4_4 = this.i;
                            var6_9 /* !! */  = ReadyState.OPEN;
                            if (var4_4 != var6_9 /* !! */ ) break block17;
                            var7_10 = 1006;
                            if (var1_1 == var7_10) {
                                this.i = var5_5;
                                this.l(var1_1, var2_2, false);
                                return;
                            }
                            var5_5 = this.k;
                            if ((var5_5 = var5_5.n()) == (var6_9 /* !! */  = CloseHandshakeType.NONE)) break block18;
                            if (var3_3) ** GOTO lbl24
                            try {
                                try {
                                    var5_5 = this.d;
                                    var5_5.onWebsocketCloseInitiated(this, var1_1, var2_2);
                                }
                                catch (RuntimeException var5_6) {
                                    var6_9 /* !! */  = this.d;
                                    var6_9 /* !! */ .onWebsocketError(this, var5_6);
                                }
lbl24:
                                // 3 sources

                                if (var8_12 = this.isOpen()) {
                                    var5_5 = new b();
                                    var5_5.t(var2_2);
                                    var5_5.s(var1_1);
                                    var5_5.j();
                                    this.sendFrame((i.d.p.f)var5_5);
                                }
                            }
                            catch (InvalidDataException var5_7) {
                                var6_9 /* !! */  = this.a;
                                var9_13 = "generated frame is invalid";
                                var6_9 /* !! */ .error(var9_13, var5_7);
                                var6_9 /* !! */  = this.d;
                                var6_9 /* !! */ .onWebsocketError(this, var5_7);
                                var5_8 = "generated frame is invalid";
                                this.l(var7_10, var5_8, false);
                            }
                        }
                        this.l(var1_1, var2_2, var3_3);
                        break block19;
                    }
                    var7_11 = -3;
                    if (var1_1 == var7_11) {
                        var1_1 = 1;
                        this.l(var7_11, var2_2, (boolean)var1_1);
                    } else {
                        var7_11 = 1002;
                        if (var1_1 == var7_11) {
                            this.l(var1_1, var2_2, var3_3);
                        } else {
                            var1_1 = -1;
                            this.l(var1_1, var2_2, false);
                        }
                    }
                }
                this.i = var10_14 = ReadyState.CLOSING;
                var1_1 = 0;
                var10_14 = null;
                this.m = null;
                return;
            }
            return;
        }
    }

    public void b(InvalidDataException object) {
        int n10 = ((InvalidDataException)object).getCloseCode();
        object = ((Throwable)object).getMessage();
        this.a(n10, (String)object, false);
    }

    public void c() {
        Serializable serializable = this.q;
        if (serializable != null) {
            int n10 = this.p;
            String string2 = this.o;
            boolean bl2 = this.q;
            this.d(n10, string2, bl2);
            return;
        }
        serializable = new IllegalStateException("this method must be used in conjunction with flushAndClose");
        throw serializable;
    }

    public void close() {
        this.close(1000);
    }

    public void close(int n10) {
        this.a(n10, "", false);
    }

    public void close(int n10, String string2) {
        this.a(n10, string2, false);
    }

    public void closeConnection(int n10, String string2) {
        this.d(n10, string2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(int n10, String object, boolean bl2) {
        synchronized (this) {
            int n11;
            Object object2 = this.i;
            Object object3 = ReadyState.CLOSED;
            if (object2 == object3) {
                return;
            }
            object2 = this.i;
            object3 = ReadyState.OPEN;
            if (object2 == object3 && n10 == (n11 = 1006)) {
                object2 = ReadyState.CLOSING;
                this.i = object2;
            }
            if ((object2 = this.e) != null) {
                ((SelectionKey)object2).cancel();
            }
            if ((object2 = this.f) != null) {
                try {
                    object2.close();
                }
                catch (IOException iOException) {
                    String string2;
                    boolean bl3;
                    object3 = iOException.getMessage();
                    if (object3 != null && (bl3 = ((String)(object3 = iOException.getMessage())).equals(string2 = "Broken pipe"))) {
                        object3 = this.a;
                        string2 = "Caught IOException: Broken pipe during closeConnection()";
                        object3.trace(string2, iOException);
                    }
                    object3 = this.a;
                    string2 = "Exception during channel.close()";
                    object3.error(string2, iOException);
                    object3 = this.d;
                    object3.onWebsocketError(this, iOException);
                }
            }
            try {
                object2 = this.d;
                object2.onWebsocketClose(this, n10, (String)object, bl2);
            }
            catch (RuntimeException runtimeException) {
                object = this.d;
                object.onWebsocketError(this, runtimeException);
            }
            Object object4 = this.k;
            if (object4 != null) {
                object4.v();
            }
            n10 = 0;
            object4 = null;
            this.n = null;
            object4 = ReadyState.CLOSED;
            this.i = object4;
            return;
        }
    }

    public void e(int n10, boolean bl2) {
        this.d(n10, "", bl2);
    }

    public Object getAttachment() {
        return this.u;
    }

    public i.d.n.a getDraft() {
        return this.k;
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.d.getLocalSocketAddress(this);
    }

    public ReadyState getReadyState() {
        return this.i;
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.d.getRemoteSocketAddress(this);
    }

    public String getResourceDescriptor() {
        return this.r;
    }

    public SSLSession getSSLSession() {
        boolean bl2 = this.hasSSLSupport();
        if (bl2) {
            return ((a)((Object)this.f)).a().getSession();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
        throw illegalArgumentException;
    }

    public void h(ByteBuffer byteBuffer) {
        Object object;
        String string2;
        int n10;
        Object object2 = this.a;
        int n11 = byteBuffer.remaining();
        Object object3 = n11;
        int n12 = byteBuffer.remaining();
        if (n12 > (n10 = 1000)) {
            string2 = "too big to display";
        } else {
            object = byteBuffer.array();
            int n13 = byteBuffer.position();
            int n14 = byteBuffer.remaining();
            string2 = new String((byte[])object, n13, n14);
        }
        object = "process({}): ({})";
        object2.trace((String)object, object3, (Object)string2);
        object2 = this.i;
        object3 = ReadyState.NOT_YET_CONNECTED;
        if (object2 != object3) {
            object2 = this.i;
            object3 = ReadyState.OPEN;
            if (object2 == object3) {
                this.i(byteBuffer);
            }
        } else {
            boolean bl2 = this.j(byteBuffer);
            if (bl2 && !(bl2 = this.isClosing()) && !(bl2 = this.isClosed())) {
                bl2 = byteBuffer.hasRemaining();
                if (bl2) {
                    this.i(byteBuffer);
                } else {
                    byteBuffer = this.m;
                    boolean bl3 = byteBuffer.hasRemaining();
                    if (bl3) {
                        byteBuffer = this.m;
                        this.i(byteBuffer);
                    }
                }
            }
        }
    }

    public boolean hasBufferedData() {
        return this.b.isEmpty() ^ true;
    }

    public boolean hasSSLSupport() {
        return this.f instanceof a;
    }

    public boolean isClosed() {
        boolean bl2;
        ReadyState readyState = this.i;
        ReadyState readyState2 = ReadyState.CLOSED;
        if (readyState == readyState2) {
            bl2 = true;
        } else {
            bl2 = false;
            readyState = null;
        }
        return bl2;
    }

    public boolean isClosing() {
        boolean bl2;
        ReadyState readyState = this.i;
        ReadyState readyState2 = ReadyState.CLOSING;
        if (readyState == readyState2) {
            bl2 = true;
        } else {
            bl2 = false;
            readyState = null;
        }
        return bl2;
    }

    public boolean isFlushAndClose() {
        return this.h;
    }

    public boolean isOpen() {
        boolean bl2;
        ReadyState readyState = this.i;
        ReadyState readyState2 = ReadyState.OPEN;
        if (readyState == readyState2) {
            bl2 = true;
        } else {
            bl2 = false;
            readyState = null;
        }
        return bl2;
    }

    public void k() {
        Object object = this.i;
        Object object2 = ReadyState.NOT_YET_CONNECTED;
        boolean bl2 = true;
        if (object == object2) {
            int n10 = -1;
            this.e(n10, bl2);
        } else {
            int n11 = this.h;
            if (n11 != 0) {
                object = this.p;
                n11 = (Integer)object;
                object2 = this.o;
                Boolean bl3 = this.q;
                bl2 = bl3;
                this.d(n11, (String)object2, bl2);
            } else {
                object = this.k.n();
                object2 = CloseHandshakeType.NONE;
                int n12 = 1000;
                if (object == object2) {
                    this.e(n12, bl2);
                } else {
                    object = this.k.n();
                    object2 = CloseHandshakeType.ONEWAY;
                    int n13 = 1006;
                    if (object == object2) {
                        object = this.l;
                        object2 = Role.SERVER;
                        if (object == object2) {
                            this.e(n13, bl2);
                        } else {
                            this.e(n12, bl2);
                        }
                    } else {
                        this.e(n13, bl2);
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l(int n10, String object, boolean bl2) {
        synchronized (this) {
            boolean bl3 = this.h;
            if (bl3) {
                return;
            }
            Object object2 = n10;
            this.p = object2;
            this.o = object;
            object2 = bl2;
            this.q = object2;
            this.h = bl3 = true;
            object2 = this.d;
            object2.onWriteDemand(this);
            try {
                object2 = this.d;
                object2.onWebsocketClosing(this, n10, (String)object, bl2);
            }
            catch (RuntimeException runtimeException) {
                object = this.a;
                String string2 = "Exception in onWebsocketClosing";
                object.error(string2, runtimeException);
                object = this.d;
                object.onWebsocketError(this, runtimeException);
            }
            i.d.n.a a10 = this.k;
            if (a10 != null) {
                a10.v();
            }
            n10 = 0;
            a10 = null;
            this.n = null;
            return;
        }
    }

    public ByteChannel n() {
        return this.f;
    }

    public long o() {
        return this.s;
    }

    public SelectionKey p() {
        return this.e;
    }

    public j q() {
        return this.d;
    }

    public e$a r() {
        return this.g;
    }

    public void send(String object) {
        if (object != null) {
            boolean bl2;
            i.d.n.a a10 = this.k;
            Role role = this.l;
            Role role2 = Role.CLIENT;
            if (role == role2) {
                bl2 = true;
            } else {
                bl2 = false;
                role = null;
            }
            object = a10.h((String)object, bl2);
            this.t((Collection)object);
            return;
        }
        object = new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        throw object;
    }

    public void send(ByteBuffer object) {
        if (object != null) {
            boolean bl2;
            i.d.n.a a10 = this.k;
            Role role = this.l;
            Role role2 = Role.CLIENT;
            if (role == role2) {
                bl2 = true;
            } else {
                bl2 = false;
                role = null;
            }
            object = a10.i((ByteBuffer)object, bl2);
            this.t((Collection)object);
            return;
        }
        object = new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        throw object;
    }

    public void send(byte[] object) {
        object = ByteBuffer.wrap(object);
        this.send((ByteBuffer)object);
    }

    public void sendFragmentedFrame(Opcode object, ByteBuffer byteBuffer, boolean bl2) {
        object = this.k.e((Opcode)((Object)object), byteBuffer, bl2);
        this.t((Collection)object);
    }

    public void sendFrame(i.d.p.f object) {
        object = Collections.singletonList(object);
        this.t((Collection)object);
    }

    public void sendFrame(Collection collection) {
        this.t(collection);
    }

    public void sendPing() {
        h h10 = this.d.onPreparePing(this);
        Objects.requireNonNull(h10, "onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        this.sendFrame(h10);
    }

    public void setAttachment(Object object) {
        this.u = object;
    }

    public String toString() {
        return super.toString();
    }

    public void u(ByteChannel byteChannel) {
        this.f = byteChannel;
    }

    public void v(SelectionKey selectionKey) {
        this.e = selectionKey;
    }

    public void w(e$a e$a) {
        this.g = e$a;
    }

    public void x(i.d.q.b object) {
        Object object2 = this.k.p((i.d.q.b)object);
        this.n = object2;
        this.r = object = object.getResourceDescriptor();
        object = this.d;
        object2 = this.n;
        try {
            object.onWebsocketHandshakeSentAsClient(this, (i.d.q.a)object2);
            object = this.k;
            object2 = this.n;
        }
        catch (RuntimeException runtimeException) {
            this.a.error("Exception in startHandshake", runtimeException);
            this.d.onWebsocketError(this, runtimeException);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("rejected because of ");
            stringBuilder.append(runtimeException);
            String string2 = stringBuilder.toString();
            object2 = new InvalidHandshakeException(string2);
            throw object2;
        }
        catch (InvalidDataException invalidDataException) {
            object = new InvalidHandshakeException("Handshake data rejected by client.");
            throw object;
        }
        object = ((i.d.n.a)object).j((i.d.q.f)object2);
        this.A((List)object);
        return;
    }

    public void y() {
        long l10;
        this.s = l10 = System.nanoTime();
    }
}

