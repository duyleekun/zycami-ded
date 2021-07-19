/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import g.c0;
import okio.ByteString;

public interface WsStatusListener {
    public void onClosed(int var1, String var2);

    public void onClosing(int var1, String var2);

    public void onFailure(Throwable var1, c0 var2);

    public void onMessage(String var1);

    public void onMessage(ByteString var1);

    public void onOpen(c0 var1);

    public void onReconnect();
}

