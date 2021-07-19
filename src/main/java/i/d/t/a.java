/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.d;
import i.d.t.b;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class a
extends b {
    private final String[] c;
    private final String[] d;

    public a(SSLContext sSLContext, ExecutorService executorService, String[] stringArray, String[] stringArray2) {
        super(sSLContext, executorService);
        this.c = stringArray;
        this.d = stringArray2;
    }

    public a(SSLContext sSLContext, String[] stringArray, String[] stringArray2) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this(sSLContext, scheduledExecutorService, stringArray, stringArray2);
    }

    public ByteChannel c(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.a.createSSLEngine();
        Object object = this.c;
        if (object != null) {
            sSLEngine.setEnabledProtocols((String[])object);
        }
        if ((object = this.d) != null) {
            sSLEngine.setEnabledCipherSuites((String[])object);
        }
        sSLEngine.setUseClientMode(false);
        ExecutorService executorService = this.b;
        object = new d(socketChannel, sSLEngine, executorService, selectionKey);
        return object;
    }
}

