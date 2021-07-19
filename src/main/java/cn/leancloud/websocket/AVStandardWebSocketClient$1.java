/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import java.util.HashMap;

public class AVStandardWebSocketClient$1
extends HashMap {
    public final /* synthetic */ String val$subProtocol;

    public AVStandardWebSocketClient$1(String string2) {
        this.val$subProtocol = string2;
        this.put("Sec-WebSocket-Protocol", string2);
    }
}

