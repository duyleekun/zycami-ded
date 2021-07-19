/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.d;
import i.d.g;
import i.d.i;
import i.d.j;
import i.d.k;
import i.d.n.a;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class b
implements k {
    public SSLContext a;
    public ExecutorService b;

    public b(SSLContext sSLContext) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this(sSLContext, scheduledExecutorService);
    }

    public b(SSLContext object, ExecutorService executorService) {
        if (object != null && executorService != null) {
            this.a = object;
            this.b = executorService;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public i a(g g10, List list) {
        i i10 = new i((j)g10, list);
        return i10;
    }

    public i b(g g10, a a10) {
        i i10 = new i((j)g10, a10);
        return i10;
    }

    public ByteChannel c(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.a.createSSLEngine();
        Object object = Arrays.asList(sSLEngine.getEnabledCipherSuites());
        Object object2 = new ArrayList(object);
        object2.remove("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        object = new String[object2.size()];
        object2 = object2.toArray((T[])object);
        sSLEngine.setEnabledCipherSuites((String[])object2);
        sSLEngine.setUseClientMode(false);
        object = this.b;
        object2 = new d(socketChannel, sSLEngine, (ExecutorService)object, selectionKey);
        return object2;
    }

    public void close() {
        this.b.shutdown();
    }
}

