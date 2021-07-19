/*
 * Decompiled with CFR 0.151.
 */
package i.d.m;

import i.d.a;
import i.d.f;
import i.d.i;
import i.d.j;
import i.d.m.b$a;
import i.d.m.b$b;
import i.d.q.d;
import i.d.q.g;
import i.d.q.h;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;

public abstract class b
extends a
implements Runnable,
f {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private i.d.m.a dnsResolver;
    private i.d.n.a draft;
    private i engine;
    private Map headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    public URI uri;
    private Thread writeThread;

    public b(URI uRI) {
        i.d.n.b b10 = new i.d.n.b();
        this(uRI, b10);
    }

    public b(URI uRI, i.d.n.a a10) {
        this(uRI, a10, null, 0);
    }

    public b(URI uRI, i.d.n.a a10, Map map) {
        this(uRI, a10, map, 0);
    }

    public b(URI object, i.d.n.a a10, Map map, int n10) {
        Comparator comparator = null;
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        Object object2 = Proxy.NO_PROXY;
        this.proxy = object2;
        int n11 = 1;
        this.connectLatch = object2 = new CountDownLatch(n11);
        this.closeLatch = object2 = new CountDownLatch(n11);
        object2 = null;
        this.connectTimeout = 0;
        this.dnsResolver = null;
        if (object != null) {
            if (a10 != null) {
                this.uri = object;
                this.draft = a10;
                this.dnsResolver = object = new b$a(this);
                if (map != null) {
                    comparator = String.CASE_INSENSITIVE_ORDER;
                    object = new TreeMap(comparator);
                    this.headers = object;
                    object.putAll(map);
                }
                this.connectTimeout = n10;
                this.setTcpNoDelay(false);
                this.setReuseAddr(false);
                this.engine = object = new i((j)this, a10);
                return;
            }
            super("null as draft is permitted for `WebSocketServer` only!");
            throw object;
        }
        super();
        throw object;
    }

    public b(URI uRI, Map map) {
        i.d.n.b b10 = new i.d.n.b();
        this(uRI, b10, map);
    }

    public static /* synthetic */ void access$000(b b10, IOException iOException) {
        b10.handleIOException(iOException);
    }

    public static /* synthetic */ Thread access$102(b b10, Thread thread) {
        b10.writeThread = thread;
        return thread;
    }

    public static /* synthetic */ i access$200(b b10) {
        return b10.engine;
    }

    public static /* synthetic */ OutputStream access$300(b b10) {
        return b10.ostream;
    }

    public static /* synthetic */ Socket access$400(b b10) {
        return b10.socket;
    }

    private int getPort() {
        int n10;
        Object object = this.uri;
        int n11 = ((URI)object).getPort();
        if (n11 == (n10 = -1)) {
            Object object2 = "wss";
            object = this.uri.getScheme();
            n10 = (int)(((String)object2).equals(object) ? 1 : 0);
            if (n10 != 0) {
                return 443;
            }
            object2 = "ws";
            n10 = (int)(((String)object2).equals(object) ? 1 : 0);
            if (n10 != 0) {
                return 80;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown scheme: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        return n11;
    }

    private void handleIOException(IOException iOException) {
        boolean bl2 = iOException instanceof SSLException;
        if (bl2) {
            this.onError(iOException);
        }
        this.engine.k();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void reset() {
        Object object;
        Object object2 = Thread.currentThread();
        if (object2 != (object = this.writeThread) && object2 != (object = this.connectReadThread)) {
            try {
                this.closeBlocking();
                object2 = this.writeThread;
                int n10 = 0;
                object = null;
                if (object2 != null) {
                    ((Thread)object2).interrupt();
                    this.writeThread = null;
                }
                if ((object2 = this.connectReadThread) != null) {
                    ((Thread)object2).interrupt();
                    this.connectReadThread = null;
                }
                object2 = this.draft;
                ((i.d.n.a)object2).v();
                object2 = this.socket;
                if (object2 != null) {
                    ((Socket)object2).close();
                    this.socket = null;
                }
                n10 = 1;
                this.connectLatch = object2 = new CountDownLatch(n10);
                this.closeLatch = object2 = new CountDownLatch(n10);
                object = this.draft;
                this.engine = object2 = new i((j)this, (i.d.n.a)object);
                return;
            }
            catch (Exception exception) {
                this.onError(exception);
                object = this.engine;
                String string2 = exception.getMessage();
                ((i)object).closeConnection(1006, string2);
                return;
            }
        }
        object2 = new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        throw object2;
    }

    private void sendHandshake() {
        Object object;
        int n10;
        Iterator iterator2 = this.uri.getRawPath();
        Object object2 = this.uri.getRawQuery();
        if (iterator2 == null || (n10 = ((String)((Object)iterator2)).length()) == 0) {
            iterator2 = "/";
        }
        if (object2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)((Object)iterator2));
            char c10 = '?';
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append((String)object2);
            iterator2 = ((StringBuilder)object).toString();
        }
        int n11 = this.getPort();
        object = new StringBuilder();
        CharSequence charSequence = this.uri.getHost();
        ((StringBuilder)object).append((String)charSequence);
        int n12 = 80;
        if (n11 != n12 && n11 != (n12 = 443)) {
            charSequence = new StringBuilder();
            String string2 = ":";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n11);
            object2 = ((StringBuilder)charSequence).toString();
        } else {
            object2 = "";
        }
        ((StringBuilder)object).append((String)object2);
        object2 = ((StringBuilder)object).toString();
        object = new d();
        ((d)object).g((String)((Object)iterator2));
        ((g)object).a("Host", (String)object2);
        iterator2 = this.headers;
        if (iterator2 != null) {
            iterator2 = iterator2.entrySet().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object2 = iterator2.next();
                charSequence = (String)object2.getKey();
                object2 = (String)object2.getValue();
                ((g)object).a((String)charSequence, (String)object2);
            }
        }
        this.engine.x((i.d.q.b)object);
    }

    public void addHeader(String string2, String string3) {
        TreeMap treeMap = this.headers;
        if (treeMap == null) {
            Comparator comparator = String.CASE_INSENSITIVE_ORDER;
            this.headers = treeMap = new TreeMap(comparator);
        }
        this.headers.put(string2, string3);
    }

    public void clearHeaders() {
        this.headers = null;
    }

    public void close() {
        Object object = this.writeThread;
        if (object != null) {
            object = this.engine;
            int n10 = 1000;
            ((i)object).close(n10);
        }
    }

    public void close(int n10) {
        this.engine.close(n10);
    }

    public void close(int n10, String string2) {
        this.engine.close(n10, string2);
    }

    public void closeBlocking() {
        this.close();
        this.closeLatch.await();
    }

    public void closeConnection(int n10, String string2) {
        this.engine.closeConnection(n10, string2);
    }

    public void connect() {
        Object object = this.connectReadThread;
        if (object == null) {
            this.connectReadThread = object = new Thread(this);
            CharSequence charSequence = new StringBuilder();
            charSequence.append("WebSocketConnectReadThread-");
            long l10 = this.connectReadThread.getId();
            charSequence.append(l10);
            charSequence = charSequence.toString();
            ((Thread)object).setName((String)charSequence);
            this.connectReadThread.start();
            return;
        }
        object = new IllegalStateException("WebSocketClient objects are not reuseable");
        throw object;
    }

    public boolean connectBlocking() {
        this.connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    public boolean connectBlocking(long l10, TimeUnit timeUnit) {
        i i10;
        this.connect();
        CountDownLatch countDownLatch = this.connectLatch;
        boolean bl2 = countDownLatch.await(l10, timeUnit);
        if (bl2 && (bl2 = (i10 = this.engine).isOpen())) {
            bl2 = true;
        } else {
            bl2 = false;
            i10 = null;
        }
        return bl2;
    }

    public Object getAttachment() {
        return this.engine.getAttachment();
    }

    public f getConnection() {
        return this.engine;
    }

    public Collection getConnections() {
        return Collections.singletonList(this.engine);
    }

    public i.d.n.a getDraft() {
        return this.draft;
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    public InetSocketAddress getLocalSocketAddress(f object) {
        object = this.socket;
        if (object != null) {
            return (InetSocketAddress)((Socket)object).getLocalSocketAddress();
        }
        return null;
    }

    public ReadyState getReadyState() {
        return this.engine.getReadyState();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    public InetSocketAddress getRemoteSocketAddress(f object) {
        object = this.socket;
        if (object != null) {
            return (InetSocketAddress)((Socket)object).getRemoteSocketAddress();
        }
        return null;
    }

    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public SSLSession getSSLSession() {
        return this.engine.getSSLSession();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    public boolean hasSSLSupport() {
        return this.engine.hasSSLSupport();
    }

    public boolean isClosed() {
        return this.engine.isClosed();
    }

    public boolean isClosing() {
        return this.engine.isClosing();
    }

    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int var1, String var2, boolean var3);

    public void onCloseInitiated(int n10, String string2) {
    }

    public void onClosing(int n10, String string2, boolean bl2) {
    }

    public abstract void onError(Exception var1);

    public abstract void onMessage(String var1);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(h var1);

    public final void onWebsocketClose(f object, int n10, String string2, boolean bl2) {
        this.stopConnectionLostTimer();
        object = this.writeThread;
        if (object != null) {
            ((Thread)object).interrupt();
        }
        this.onClose(n10, string2, bl2);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    public void onWebsocketCloseInitiated(f f10, int n10, String string2) {
        this.onCloseInitiated(n10, string2);
    }

    public void onWebsocketClosing(f f10, int n10, String string2, boolean bl2) {
        this.onClosing(n10, string2, bl2);
    }

    public final void onWebsocketError(f f10, Exception exception) {
        this.onError(exception);
    }

    public final void onWebsocketMessage(f f10, String string2) {
        this.onMessage(string2);
    }

    public final void onWebsocketMessage(f f10, ByteBuffer byteBuffer) {
        this.onMessage(byteBuffer);
    }

    public final void onWebsocketOpen(f f10, i.d.q.f f11) {
        this.startConnectionLostTimer();
        f11 = (h)f11;
        this.onOpen((h)f11);
        this.connectLatch.countDown();
    }

    public final void onWriteDemand(f f10) {
    }

    public void reconnect() {
        this.reset();
        this.connect();
    }

    public boolean reconnectBlocking() {
        this.reset();
        return this.connectBlocking();
    }

    public String removeHeader(String string2) {
        Map map = this.headers;
        if (map == null) {
            return null;
        }
        return (String)map.remove(string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        var1_1 = -1;
        try {
            block16: {
                block14: {
                    block15: {
                        block13: {
                            var2_2 = this.socketFactory;
                            var3_7 = 1;
                            if (var2_2 == null) break block13;
                            this.socket = var2_2 = var2_2.createSocket();
                            break block14;
                        }
                        var2_2 = this.socket;
                        if (var2_2 != null) break block15;
                        var4_8 = this.proxy;
                        this.socket = var2_2 = new Socket((Proxy)var4_8);
                        var5_9 = var3_7;
                        break block16;
                    }
                    var5_9 = var2_2.isClosed();
                    if (var5_9 != 0) ** GOTO lbl-1000
                }
                var5_9 = 0;
                var2_2 = null;
            }
            var4_8 = this.socket;
            var6_10 = this.isTcpNoDelay();
            var4_8.setTcpNoDelay((boolean)var6_10);
            var4_8 = this.socket;
            var6_10 = this.isReuseAddr();
            var4_8.setReuseAddress((boolean)var6_10);
            var4_8 = this.socket;
            var7_11 = var4_8.isConnected();
            if (!var7_11) {
                var8_12 = this.dnsResolver;
                var9_13 = this.uri;
                var8_12 = var8_12.a((URI)var9_13);
                var10_14 = this.getPort();
                var4_8 = new InetSocketAddress((InetAddress)var8_12, var10_14);
                var8_12 = this.socket;
                var10_14 = this.connectTimeout;
                var8_12.connect((SocketAddress)var4_8, var10_14);
            }
            var7_11 = false;
            var4_8 = null;
            if (var5_9 != 0) {
                var2_2 = "wss";
                var8_12 = this.uri;
                var5_9 = var2_2.equals(var8_12 = var8_12.getScheme());
                if (var5_9 != 0) {
                    var2_2 = "TLSv1.2";
                    var2_2 = SSLContext.getInstance((String)var2_2);
                    var2_2.init(null, null, null);
                    var2_2 = var2_2.getSocketFactory();
                    var8_12 = this.socket;
                    var9_13 = this.uri;
                    var9_13 = var9_13.getHost();
                    var11_15 = this.getPort();
                    this.socket = var2_2 = var2_2.createSocket((Socket)var8_12, (String)var9_13, var11_15, (boolean)var3_7);
                }
            }
            var2_2 = this.socket;
            var2_2 = var2_2.getInputStream();
            var12_16 = this.socket;
            var12_16 = var12_16.getOutputStream();
            this.ostream = var12_16;
            this.sendHandshake();
            var8_12 = new b$b(this, this);
            this.writeThread = var12_16 = new Thread((Runnable)var8_12);
            var12_16.start();
            var3_7 = 16384;
        }
        catch (InternalError var2_3) {
            var12_17 = var2_3.getCause();
            var3_7 = var12_17 instanceof InvocationTargetException;
            if (var3_7 != 0 && (var3_7 = (var12_17 = var2_3.getCause().getCause()) instanceof IOException) != 0) {
                var2_4 = (IOException)var2_3.getCause().getCause();
                var12_17 = this.engine;
                this.onWebsocketError((f)var12_17, (Exception)var2_4);
                var12_17 = this.engine;
                var2_4 = var2_4.getMessage();
                var12_17.closeConnection(var1_1, (String)var2_4);
                return;
            }
            throw var2_3;
        }
        catch (Exception var2_5) {
            var12_18 = this.engine;
            this.onWebsocketError(var12_18, var2_5);
            var12_18 = this.engine;
            var2_6 = var2_5.getMessage();
            var12_18.closeConnection(var1_1, var2_6);
            return;
        }
        var12_16 = new byte[var3_7];
        try {
            while ((var6_10 = this.isClosing()) == 0 && (var6_10 = this.isClosed()) == 0 && (var6_10 = var2_2.read((byte[])var12_16)) != var1_1) {
                var9_13 = this.engine;
                var8_12 = ByteBuffer.wrap((byte[])var12_16, 0, var6_10);
                var9_13.h((ByteBuffer)var8_12);
            }
            var13_19 = this.engine;
            var13_19.k();
        }
        catch (RuntimeException var13_20) {
            this.onError(var13_20);
            var2_2 = this.engine;
            var3_7 = 1006;
            var13_21 = var13_20.getMessage();
            var2_2.closeConnection(var3_7, var13_21);
        }
        catch (IOException var13_22) {
            this.handleIOException(var13_22);
        }
        this.connectReadThread = null;
        return;
lbl-1000:
        // 1 sources

        {
            var2_2 = new IOException();
            throw var2_2;
        }
    }

    public void send(String string2) {
        this.engine.send(string2);
    }

    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    public void send(byte[] byArray) {
        this.engine.send(byArray);
    }

    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean bl2) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, bl2);
    }

    public void sendFrame(i.d.p.f f10) {
        this.engine.sendFrame(f10);
    }

    public void sendFrame(Collection collection) {
        this.engine.sendFrame(collection);
    }

    public void sendPing() {
        this.engine.sendPing();
    }

    public void setAttachment(Object object) {
        this.engine.setAttachment(object);
    }

    public void setDnsResolver(i.d.m.a a10) {
        this.dnsResolver = a10;
    }

    public void setProxy(Proxy object) {
        if (object != null) {
            this.proxy = object;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public void setSocket(Socket object) {
        Socket socket = this.socket;
        if (socket == null) {
            this.socket = object;
            return;
        }
        object = new IllegalStateException("socket has already been set");
        throw object;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }
}

