/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.t.b;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

public class d
extends b {
    private final SSLParameters c;

    public d(SSLContext object, ExecutorService executorService, SSLParameters sSLParameters) {
        super((SSLContext)object, executorService);
        if (sSLParameters != null) {
            this.c = sSLParameters;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public d(SSLContext sSLContext, SSLParameters sSLParameters) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this(sSLContext, scheduledExecutorService, sSLParameters);
    }

    public ByteChannel c(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.a.createSSLEngine();
        sSLEngine.setUseClientMode(false);
        Object object = this.c;
        sSLEngine.setSSLParameters((SSLParameters)object);
        ExecutorService executorService = this.b;
        object = new i.d.d(socketChannel, sSLEngine, executorService, selectionKey);
        return object;
    }
}

