/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

public interface AVLiveQueryConnectionHandler {
    public void onConnectionClose();

    public void onConnectionError(int var1, String var2);

    public void onConnectionOpen();
}

