/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.websocket.AVOKWebSocketClient;
import g.a0;
import g.c0;
import g.u;
import g.u$a;

public class AVOKWebSocketClient$2
implements u {
    public final /* synthetic */ AVOKWebSocketClient this$0;

    public AVOKWebSocketClient$2(AVOKWebSocketClient aVOKWebSocketClient) {
        this.this$0 = aVOKWebSocketClient;
    }

    public c0 intercept(u$a u$a) {
        a0 a02 = u$a.C().n().n("Sec-WebSocket-Protocol", "lc.protobuf2.3").b();
        return u$a.c(a02);
    }
}

