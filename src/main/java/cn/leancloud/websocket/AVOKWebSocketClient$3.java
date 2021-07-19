/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.websocket.AVOKWebSocketClient;
import cn.leancloud.websocket.WsStatusListener;
import java.util.TimerTask;

public class AVOKWebSocketClient$3
extends TimerTask {
    public final /* synthetic */ AVOKWebSocketClient this$0;

    public AVOKWebSocketClient$3(AVOKWebSocketClient aVOKWebSocketClient) {
        this.this$0 = aVOKWebSocketClient;
    }

    public void run() {
        WsStatusListener wsStatusListener = AVOKWebSocketClient.access$400(this.this$0);
        if (wsStatusListener != null) {
            wsStatusListener = AVOKWebSocketClient.access$400(this.this$0);
            wsStatusListener.onReconnect();
        }
        AVOKWebSocketClient.access$700(this.this$0);
    }
}

