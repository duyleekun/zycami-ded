/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

public final class AVOKWebSocketClient$Status
extends Enum {
    private static final /* synthetic */ AVOKWebSocketClient$Status[] $VALUES;
    public static final /* enum */ AVOKWebSocketClient$Status CLOSING;
    public static final /* enum */ AVOKWebSocketClient$Status CONNECTED;
    public static final /* enum */ AVOKWebSocketClient$Status CONNECTING;
    public static final /* enum */ AVOKWebSocketClient$Status DISCONNECTED;
    public static final /* enum */ AVOKWebSocketClient$Status RECONNECT;

    static {
        AVOKWebSocketClient$Status aVOKWebSocketClient$Status;
        AVOKWebSocketClient$Status aVOKWebSocketClient$Status2;
        AVOKWebSocketClient$Status aVOKWebSocketClient$Status3;
        AVOKWebSocketClient$Status aVOKWebSocketClient$Status4;
        AVOKWebSocketClient$Status aVOKWebSocketClient$Status5;
        DISCONNECTED = aVOKWebSocketClient$Status5 = new AVOKWebSocketClient$Status("DISCONNECTED", 0);
        int n10 = 1;
        CONNECTED = aVOKWebSocketClient$Status4 = new AVOKWebSocketClient$Status("CONNECTED", n10);
        int n11 = 2;
        CONNECTING = aVOKWebSocketClient$Status3 = new AVOKWebSocketClient$Status("CONNECTING", n11);
        int n12 = 3;
        CLOSING = aVOKWebSocketClient$Status2 = new AVOKWebSocketClient$Status("CLOSING", n12);
        int n13 = 4;
        RECONNECT = aVOKWebSocketClient$Status = new AVOKWebSocketClient$Status("RECONNECT", n13);
        AVOKWebSocketClient$Status[] aVOKWebSocketClient$StatusArray = new AVOKWebSocketClient$Status[5];
        aVOKWebSocketClient$StatusArray[0] = aVOKWebSocketClient$Status5;
        aVOKWebSocketClient$StatusArray[n10] = aVOKWebSocketClient$Status4;
        aVOKWebSocketClient$StatusArray[n11] = aVOKWebSocketClient$Status3;
        aVOKWebSocketClient$StatusArray[n12] = aVOKWebSocketClient$Status2;
        aVOKWebSocketClient$StatusArray[n13] = aVOKWebSocketClient$Status;
        $VALUES = aVOKWebSocketClient$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVOKWebSocketClient$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static AVOKWebSocketClient$Status valueOf(String string2) {
        return Enum.valueOf(AVOKWebSocketClient$Status.class, string2);
    }

    public static AVOKWebSocketClient$Status[] values() {
        return (AVOKWebSocketClient$Status[])$VALUES.clone();
    }
}

