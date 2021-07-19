/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.a;
import i.d.f;
import i.d.h;
import i.d.i;
import i.d.k;
import i.d.l;
import i.d.t.c;
import i.d.t.e$a;
import i.h.d;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.exceptions.WrappedIOException;

public abstract class e
extends a
implements Runnable {
    private static final int o = Runtime.getRuntime().availableProcessors();
    private final i.h.c a;
    private final Collection b;
    private final InetSocketAddress c;
    private ServerSocketChannel d;
    private Selector e;
    private List f;
    private Thread g;
    private final AtomicBoolean h;
    public List i;
    private List j;
    private BlockingQueue k;
    private int l;
    private final AtomicInteger m;
    private k n;

    public e() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(80);
        int n10 = o;
        this(inetSocketAddress, n10, null);
    }

    public e(InetSocketAddress inetSocketAddress) {
        int n10 = o;
        this(inetSocketAddress, n10, null);
    }

    public e(InetSocketAddress inetSocketAddress, int n10) {
        this(inetSocketAddress, n10, null);
    }

    public e(InetSocketAddress inetSocketAddress, int n10, List list) {
        HashSet hashSet = new HashSet();
        this(inetSocketAddress, n10, list, hashSet);
    }

    public e(InetSocketAddress object, int n10, List list, Collection collection) {
        int n11;
        Object object2 = i.h.d.i(e.class);
        this.a = object2;
        this.h = object2 = new AtomicBoolean(false);
        this.l = 0;
        this.m = object2 = new AtomicInteger(0);
        this.n = object2 = new c();
        if (object != null && n10 >= (n11 = 1) && collection != null) {
            this.f = list == null ? (list = Collections.emptyList()) : list;
            this.c = object;
            this.b = collection;
            this.setTcpNoDelay(false);
            this.setReuseAddr(false);
            this.j = object;
            super(n10);
            this.i = object;
            super();
            this.k = object;
            for (int i10 = 0; i10 < n10; ++i10) {
                object = new e$a(this);
                list = this.i;
                list.add(object);
            }
            return;
        }
        super("address and connectionscontainer must not be null and you need at least 1 decoder");
        throw object;
    }

    public e(InetSocketAddress inetSocketAddress, List list) {
        int n10 = o;
        this(inetSocketAddress, n10, list);
    }

    private void A(f object, Exception exception) {
        Object object2 = this.a;
        Object object3 = "Shutdown due to fatal error";
        object2.error((String)object3, exception);
        this.G((f)object, exception);
        object = this.i;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (e$a)object.next();
                ((Thread)object2).interrupt();
            }
        }
        if ((object = this.g) != null) {
            ((Thread)object).interrupt();
        }
        object = null;
        try {
            this.R();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            object3 = this.a;
            String string2 = "Interrupt during stop";
            object3.error(string2, exception);
            this.G(null, interruptedException);
        }
        catch (IOException iOException) {
            object2 = this.a;
            object3 = "Error during shutdown";
            object2.error((String)object3, iOException);
            this.G(null, iOException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void B(SelectionKey object, f object2, IOException object3) {
        if (object != null) {
            ((SelectionKey)object).cancel();
        }
        if (object2 != null) {
            int n10 = 1006;
            object3 = ((Throwable)object3).getMessage();
            object2.closeConnection(n10, (String)object3);
            return;
        }
        if (object == null) return;
        if ((object = ((SelectionKey)object).channel()) == null) return;
        boolean bl2 = ((AbstractInterruptibleChannel)object).isOpen();
        if (!bl2) return;
        try {
            ((AbstractInterruptibleChannel)object).close();
        }
        catch (IOException iOException) {}
        object = this.a;
        object2 = "Connection closed because of exception";
        object.trace((String)object2, (Throwable)object3);
    }

    private void L(ByteBuffer byteBuffer) {
        AtomicInteger atomicInteger;
        int n10;
        BlockingQueue blockingQueue = this.k;
        int n11 = blockingQueue.size();
        if (n11 > (n10 = (atomicInteger = this.m).intValue())) {
            return;
        }
        this.k.put(byteBuffer);
    }

    private ByteBuffer T() {
        return (ByteBuffer)this.k.take();
    }

    public static /* synthetic */ i.h.c a(e e10) {
        return e10.a;
    }

    public static /* synthetic */ void b(e e10, f f10, Exception exception) {
        e10.A(f10, exception);
    }

    public static /* synthetic */ void c(e e10, ByteBuffer byteBuffer) {
        e10.L(byteBuffer);
    }

    private void m(SelectionKey object, Iterator object2) {
        boolean bl2 = this.F((SelectionKey)object);
        if (!bl2) {
            ((SelectionKey)object).cancel();
            return;
        }
        object = this.d.accept();
        if (object == null) {
            return;
        }
        bl2 = false;
        ((AbstractSelectableChannel)object).configureBlocking(false);
        Object object3 = ((SocketChannel)object).socket();
        boolean n10 = this.isTcpNoDelay();
        ((Socket)object3).setTcpNoDelay(n10);
        int n11 = 1;
        ((Socket)object3).setKeepAlive(n11 != 0);
        object3 = this.n;
        Object object4 = this.f;
        object3 = object3.a(this, (List)object4);
        object4 = this.e;
        Object object5 = ((AbstractSelectableChannel)object).register((Selector)object4, n11, object3);
        ((i)object3).v((SelectionKey)object5);
        object5 = this.n;
        object4 = ((i)object3).p();
        object = object5.c((SocketChannel)object, (SelectionKey)object4);
        ((i)object3).u((ByteChannel)object);
        object2.remove();
        try {
            this.e((f)object3);
        }
        catch (IOException iOException) {
            object2 = ((i)object3).p();
            if (object2 != null) {
                object2 = ((i)object3).p();
                ((SelectionKey)object2).cancel();
            }
            object2 = ((i)object3).p();
            bl2 = false;
            object3 = null;
            this.B((SelectionKey)object2, null, iOException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void o() {
        Object object;
        boolean bl2;
        while (!(bl2 = (object = this.j).isEmpty())) {
            object = this.j;
            boolean bl3 = false;
            object = (i)object.remove(0);
            Object object2 = (l)((i)object).n();
            ByteBuffer byteBuffer = this.T();
            try {
                bl3 = i.d.e.c(byteBuffer, (i)object, (l)object2);
                if (bl3) {
                    object2 = this.j;
                    object2.add(object);
                }
                if (bl3 = byteBuffer.hasRemaining()) {
                    object2 = ((i)object).c;
                    object2.put(byteBuffer);
                    this.M((i)object);
                    continue;
                }
                this.L(byteBuffer);
            }
            catch (IOException iOException) {
                this.L(byteBuffer);
                throw iOException;
            }
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void p(Object hashMap, Collection iterator2) {
        Object object;
        boolean bl2 = hashMap instanceof String;
        Object object2 = null;
        if (bl2) {
            object = hashMap;
            object = (String)((Object)hashMap);
        } else {
            bl2 = false;
            object = null;
        }
        boolean bl3 = hashMap instanceof ByteBuffer;
        if (bl3) {
            object2 = hashMap;
            object2 = (ByteBuffer)((Object)hashMap);
        }
        if (object == null && object2 == null) {
            return;
        }
        hashMap = new HashMap();
        // MONITORENTER : iterator2
        Object object3 = new ArrayList(iterator2);
        // MONITOREXIT : iterator2
        iterator2 = object3.iterator();
        while (bl3 = iterator2.hasNext()) {
            object3 = (f)iterator2.next();
            if (object3 == null) continue;
            Object object4 = object3.getDraft();
            this.v((i.d.n.a)object4, hashMap, (String)object, (ByteBuffer)object2);
            try {
                object4 = hashMap.get(object4);
                object4 = (Collection)object4;
                object3.sendFrame((Collection)object4);
            }
            catch (WebsocketNotConnectedException websocketNotConnectedException) {}
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean q() {
        synchronized (this) {
            Object object = this.g;
            if (object != null) {
                CharSequence charSequence = new StringBuilder();
                Object object2 = this.getClass();
                object2 = ((Class)object2).getName();
                charSequence.append((String)object2);
                object2 = " can only be started once.";
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                object = new IllegalStateException((String)charSequence);
                throw object;
            }
            this.g = object = Thread.currentThread();
            object = this.h;
            boolean bl2 = ((AtomicBoolean)object).get();
            return !bl2;
            {
            }
        }
    }

    private boolean r(SelectionKey object, Iterator object2) {
        block17: {
            ByteBuffer byteBuffer;
            block15: {
                block16: {
                    i i10 = (i)((SelectionKey)object).attachment();
                    byteBuffer = this.T();
                    ByteChannel byteChannel = i10.n();
                    if (byteChannel == null) {
                        ((SelectionKey)object).cancel();
                        object2 = new IOException();
                        this.B((SelectionKey)object, i10, (IOException)object2);
                        return false;
                    }
                    try {
                        object = i10.n();
                    }
                    catch (IOException iOException) {
                        this.L(byteBuffer);
                        object2 = new WrappedIOException(i10, iOException);
                        throw object2;
                    }
                    boolean bl2 = i.d.e.b(byteBuffer, i10, (ByteChannel)object);
                    if (!bl2) break block15;
                    bl2 = byteBuffer.hasRemaining();
                    if (!bl2) break block16;
                    object = i10.c;
                    object.put(byteBuffer);
                    this.M(i10);
                    object2.remove();
                    object = i10.n();
                    bl2 = object instanceof l;
                    if (!bl2) break block17;
                    object = i10.n();
                    object = (l)object;
                    bl2 = object.H();
                    if (!bl2) break block17;
                    object = this.j;
                    object.add(i10);
                    break block17;
                }
                this.L(byteBuffer);
                break block17;
            }
            this.L(byteBuffer);
        }
        return true;
    }

    private void s() {
        String string2;
        i.h.c c10;
        e$a e$a;
        boolean bl2;
        this.stopConnectionLostTimer();
        Object object = this.i;
        if (object != null) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                e$a = (e$a)object.next();
                e$a.interrupt();
            }
        }
        object = this.e;
        bl2 = false;
        e$a = null;
        if (object != null) {
            try {
                ((Selector)object).close();
            }
            catch (IOException iOException) {
                c10 = this.a;
                string2 = "IOException during selector.close";
                c10.error(string2, iOException);
                this.G(null, iOException);
            }
        }
        if ((object = this.d) != null) {
            try {
                ((AbstractInterruptibleChannel)object).close();
            }
            catch (IOException iOException) {
                c10 = this.a;
                string2 = "IOException during server.close";
                c10.error(string2, iOException);
                this.G(null, iOException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean t() {
        Thread thread = this.g;
        Iterator iterator2 = new Iterator();
        ((StringBuilder)((Object)iterator2)).append("WebSocketSelector-");
        Object object = this.g;
        long l10 = ((Thread)object).getId();
        ((StringBuilder)((Object)iterator2)).append(l10);
        iterator2 = ((StringBuilder)((Object)iterator2)).toString();
        thread.setName((String)((Object)iterator2));
        thread = null;
        try {
            iterator2 = ServerSocketChannel.open();
            this.d = iterator2;
            ((AbstractSelectableChannel)((Object)iterator2)).configureBlocking(false);
            iterator2 = this.d;
            iterator2 = ((ServerSocketChannel)((Object)iterator2)).socket();
            boolean bl2 = 16384 != 0;
            ((ServerSocket)((Object)iterator2)).setReceiveBufferSize((int)(bl2 ? 1 : 0));
            bl2 = this.isReuseAddr();
            ((ServerSocket)((Object)iterator2)).setReuseAddress(bl2);
            object = this.c;
            ((ServerSocket)((Object)iterator2)).bind((SocketAddress)object);
            iterator2 = Selector.open();
            this.e = iterator2;
            object = this.d;
            int n10 = ((ServerSocketChannel)object).validOps();
            ((SelectableChannel)object).register((Selector)((Object)iterator2), n10);
            this.startConnectionLostTimer();
            iterator2 = this.i;
            iterator2 = iterator2.iterator();
            while (true) {
                if (!(bl2 = iterator2.hasNext())) {
                    this.K();
                    return true;
                }
                object = iterator2.next();
                object = (e$a)object;
                ((Thread)object).start();
            }
        }
        catch (IOException iOException) {
            this.A(null, iOException);
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void u(SelectionKey selectionKey) {
        Object object;
        i i10 = (i)selectionKey.attachment();
        try {
            object = i10.n();
        }
        catch (IOException iOException) {
            object = new WrappedIOException(i10, iOException);
            throw object;
        }
        boolean bl2 = i.d.e.a(i10, (ByteChannel)object);
        if (!bl2) return;
        boolean bl3 = selectionKey.isValid();
        if (!bl3) return;
        int n10 = 1;
        selectionKey.interestOps(n10);
    }

    private void v(i.d.n.a a10, Map map, String string2, ByteBuffer byteBuffer) {
        boolean bl2 = map.containsKey(a10);
        if (!bl2) {
            bl2 = false;
            List list = null;
            if (string2 != null) {
                list = a10.h(string2, false);
            }
            if (byteBuffer != null) {
                list = a10.i(byteBuffer, false);
            }
            if (list != null) {
                map.put(a10, list);
            }
        }
    }

    private Socket y(f f10) {
        return ((SocketChannel)((i)f10).p().channel()).socket();
    }

    public abstract void C(f var1, int var2, String var3, boolean var4);

    public void D(f f10, int n10, String string2) {
    }

    public void E(f f10, int n10, String string2, boolean bl2) {
    }

    public boolean F(SelectionKey selectionKey) {
        return true;
    }

    public abstract void G(f var1, Exception var2);

    public abstract void H(f var1, String var2);

    public void I(f f10, ByteBuffer byteBuffer) {
    }

    public abstract void J(f var1, i.d.q.a var2);

    public abstract void K();

    public void M(i i10) {
        Object object = i10.r();
        if (object == null) {
            int n10;
            object = this.i;
            int n11 = this.l;
            int n12 = object.size();
            object = (e$a)object.get(n11 %= n12);
            i10.w((e$a)object);
            this.l = n10 = this.l + 1;
        }
        i10.r().b(i10);
    }

    public void N(f f10) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean O(f f10) {
        boolean bl2;
        Object object = this.b;
        synchronized (object) {
            Object object2 = this.b;
            boolean bl3 = object2.contains(f10);
            if (bl3) {
                object2 = this.b;
                bl2 = object2.remove(f10);
            } else {
                object2 = this.a;
                String string2 = "Removing connection which is not in the connections collection! Possible no handshake recieved! {}";
                object2.trace(string2, (Object)f10);
                bl2 = false;
                f10 = null;
            }
        }
        object = this.h;
        boolean bl4 = ((AtomicBoolean)object).get();
        if (bl4 && (bl4 = (object = this.b).isEmpty())) {
            object = this.g;
            ((Thread)object).interrupt();
        }
        return bl2;
    }

    public final void P(k k10) {
        k k11 = this.n;
        if (k11 != null) {
            k11.close();
        }
        this.n = k10;
    }

    public void Q() {
        Object object = this.g;
        if (object == null) {
            object = new Thread(this);
            ((Thread)object).start();
            return;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = this.getClass().getName();
        charSequence.append(string2);
        charSequence.append(" can only be started once.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void R() {
        this.S(0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void S(int n10) {
        Object object = this.h;
        boolean bl2 = false;
        Object object2 = null;
        int n11 = 1;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, n11 != 0);
        if (!bl3) {
            return;
        }
        object = this.b;
        synchronized (object) {
            Collection collection = this.b;
            object2 = new ArrayList(collection);
        }
        object = object2.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (f)object.next();
            n11 = 1001;
            object2.close(n11);
        }
        object = this.n;
        object.close();
        synchronized (this) {
            object = this.g;
            if (object != null && (object = this.e) != null) {
                ((Selector)object).wakeup();
                object = this.g;
                long l10 = n10;
                ((Thread)object).join(l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(f f10) {
        Object object = this.h;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (!bl2) {
            object = this.b;
            synchronized (object) {
                Collection collection = this.b;
                return collection.add(f10);
            }
        }
        f10.close(1001);
        return true;
    }

    public void e(f object) {
        Object object2;
        int n10;
        object = this.m;
        int n11 = ((AtomicInteger)object).get();
        if (n11 >= (n10 = (object2 = this.i).size() * 2 + 1)) {
            return;
        }
        this.m.incrementAndGet();
        object = this.k;
        object2 = this.l();
        object.put(object2);
    }

    public void f(String string2) {
        Collection collection = this.b;
        this.g(string2, collection);
    }

    public void g(String object, Collection collection) {
        if (object != null && collection != null) {
            this.p(object, collection);
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection getConnections() {
        Collection collection = this.b;
        synchronized (collection) {
            Collection collection2 = this.b;
            Collection collection3 = new Collection(collection2);
            return Collections.unmodifiableCollection(collection3);
        }
    }

    public InetSocketAddress getLocalSocketAddress(f f10) {
        return (InetSocketAddress)this.y(f10).getLocalSocketAddress();
    }

    public int getPort() {
        ServerSocketChannel serverSocketChannel;
        Object object = this.w();
        int n10 = ((InetSocketAddress)object).getPort();
        if (n10 == 0 && (serverSocketChannel = this.d) != null) {
            object = serverSocketChannel.socket();
            n10 = ((ServerSocket)object).getLocalPort();
        }
        return n10;
    }

    public InetSocketAddress getRemoteSocketAddress(f f10) {
        return (InetSocketAddress)this.y(f10).getRemoteSocketAddress();
    }

    public void h(ByteBuffer byteBuffer) {
        Collection collection = this.b;
        this.i(byteBuffer, collection);
    }

    public void i(ByteBuffer object, Collection collection) {
        if (object != null && collection != null) {
            this.p(object, collection);
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public void j(byte[] byArray) {
        Collection collection = this.b;
        this.k(byArray, collection);
    }

    public void k(byte[] object, Collection collection) {
        if (object != null && collection != null) {
            object = ByteBuffer.wrap(object);
            this.i((ByteBuffer)object, collection);
            return;
        }
        object = new IllegalArgumentException;
        object();
        throw object;
    }

    public ByteBuffer l() {
        return ByteBuffer.allocate(16384);
    }

    public final void onWebsocketClose(f object, int n10, String string2, boolean bl2) {
        block7: {
            Selector selector = this.e;
            selector.wakeup();
            try {
                boolean bl3 = this.O((f)object);
                if (!bl3) break block7;
            }
            catch (Throwable throwable) {
                try {
                    this.N((f)object);
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
                throw throwable;
            }
            this.C((f)object, n10, string2, bl2);
        }
        try {
            this.N((f)object);
        }
        catch (InterruptedException interruptedException) {
            object = Thread.currentThread();
            ((Thread)object).interrupt();
        }
    }

    public void onWebsocketCloseInitiated(f f10, int n10, String string2) {
        this.D(f10, n10, string2);
    }

    public void onWebsocketClosing(f f10, int n10, String string2, boolean bl2) {
        this.E(f10, n10, string2, bl2);
    }

    public final void onWebsocketError(f f10, Exception exception) {
        this.G(f10, exception);
    }

    public final void onWebsocketMessage(f f10, String string2) {
        this.H(f10, string2);
    }

    public final void onWebsocketMessage(f f10, ByteBuffer byteBuffer) {
        this.I(f10, byteBuffer);
    }

    public final void onWebsocketOpen(f f10, i.d.q.f f11) {
        boolean bl2 = this.d(f10);
        if (bl2) {
            f11 = (i.d.q.a)f11;
            this.J(f10, (i.d.q.a)f11);
        }
    }

    public final void onWriteDemand(f object) {
        object = (i)object;
        SelectionKey selectionKey = ((i)object).p();
        int n10 = 5;
        try {
            selectionKey.interestOps(n10);
        }
        catch (CancelledKeyException cancelledKeyException) {
            object = ((i)object).b;
            object.clear();
        }
        this.e.wakeup();
    }

    /*
     * Exception decompiling
     */
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 27[TRYBLOCK] [156 : 388->392)] java.lang.Throwable
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

    public InetSocketAddress w() {
        return this.c;
    }

    public List x() {
        return Collections.unmodifiableList(this.f);
    }

    public final h z() {
        return this.n;
    }
}

