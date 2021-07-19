/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.enums;

public final class HandshakeState
extends Enum {
    public static final /* enum */ HandshakeState MATCHED;
    public static final /* enum */ HandshakeState NOT_MATCHED;
    private static final /* synthetic */ HandshakeState[] a;

    static {
        HandshakeState handshakeState;
        HandshakeState handshakeState2;
        MATCHED = handshakeState2 = new HandshakeState("MATCHED", 0);
        int n10 = 1;
        NOT_MATCHED = handshakeState = new HandshakeState("NOT_MATCHED", n10);
        HandshakeState[] handshakeStateArray = new HandshakeState[2];
        handshakeStateArray[0] = handshakeState2;
        handshakeStateArray[n10] = handshakeState;
        a = handshakeStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HandshakeState() {
        void var2_-1;
        void var1_-1;
    }

    public static HandshakeState valueOf(String string2) {
        return Enum.valueOf(HandshakeState.class, string2);
    }

    public static HandshakeState[] values() {
        return (HandshakeState[])a.clone();
    }
}

