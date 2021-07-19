/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.websocket.AVStandardWebSocketClient;
import cn.leancloud.websocket.HeartBeatPolicy;

public class AVStandardWebSocketClient$2
extends HeartBeatPolicy {
    public final /* synthetic */ AVStandardWebSocketClient this$0;

    public AVStandardWebSocketClient$2(AVStandardWebSocketClient aVStandardWebSocketClient) {
        this.this$0 = aVStandardWebSocketClient;
    }

    public void onTimeOut() {
        this.this$0.closeConnection(3000, "No response for ping");
    }

    public void sendPing() {
        this.this$0.ping();
    }
}

