/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.enums;

public final class ReadyState
extends Enum {
    public static final /* enum */ ReadyState CLOSED;
    public static final /* enum */ ReadyState CLOSING;
    public static final /* enum */ ReadyState NOT_YET_CONNECTED;
    public static final /* enum */ ReadyState OPEN;
    private static final /* synthetic */ ReadyState[] a;

    static {
        ReadyState readyState;
        ReadyState readyState2;
        ReadyState readyState3;
        ReadyState readyState4;
        NOT_YET_CONNECTED = readyState4 = new ReadyState("NOT_YET_CONNECTED", 0);
        int n10 = 1;
        OPEN = readyState3 = new ReadyState("OPEN", n10);
        int n11 = 2;
        CLOSING = readyState2 = new ReadyState("CLOSING", n11);
        int n12 = 3;
        CLOSED = readyState = new ReadyState("CLOSED", n12);
        ReadyState[] readyStateArray = new ReadyState[4];
        readyStateArray[0] = readyState4;
        readyStateArray[n10] = readyState3;
        readyStateArray[n11] = readyState2;
        readyStateArray[n12] = readyState;
        a = readyStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ReadyState() {
        void var2_-1;
        void var1_-1;
    }

    public static ReadyState valueOf(String string2) {
        return Enum.valueOf(ReadyState.class, string2);
    }

    public static ReadyState[] values() {
        return (ReadyState[])a.clone();
    }
}

