/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import i.d.m.b;
import java.nio.ByteBuffer;

public interface AVStandardWebSocketClient$WebSocketClientMonitor {
    public void onClose(b var1, int var2, String var3, boolean var4);

    public void onError(b var1, Exception var2);

    public void onMessage(b var1, ByteBuffer var2);

    public void onOpen(b var1);
}

