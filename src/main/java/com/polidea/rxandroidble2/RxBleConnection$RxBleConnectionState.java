/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2;

public final class RxBleConnection$RxBleConnectionState
extends Enum {
    public static final /* enum */ RxBleConnection$RxBleConnectionState CONNECTED;
    public static final /* enum */ RxBleConnection$RxBleConnectionState CONNECTING;
    public static final /* enum */ RxBleConnection$RxBleConnectionState DISCONNECTED;
    public static final /* enum */ RxBleConnection$RxBleConnectionState DISCONNECTING;
    private static final /* synthetic */ RxBleConnection$RxBleConnectionState[] a;
    private final String description;

    static {
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState;
        Object object = "CONNECTING";
        CONNECTING = rxBleConnection$RxBleConnectionState = new RxBleConnection$RxBleConnectionState(object, 0, object);
        Object object2 = "CONNECTED";
        int n10 = 1;
        object = new RxBleConnection$RxBleConnectionState(object2, n10, object2);
        CONNECTED = object;
        Object object3 = "DISCONNECTED";
        int n11 = 2;
        object2 = new RxBleConnection$RxBleConnectionState(object3, n11, object3);
        DISCONNECTED = object2;
        RxBleConnection$RxBleConnectionState[] rxBleConnection$RxBleConnectionStateArray = "DISCONNECTING";
        int n12 = 3;
        object3 = new RxBleConnection$RxBleConnectionState((String)rxBleConnection$RxBleConnectionStateArray, n12, (String)rxBleConnection$RxBleConnectionStateArray);
        DISCONNECTING = object3;
        rxBleConnection$RxBleConnectionStateArray = new RxBleConnection$RxBleConnectionState[4];
        rxBleConnection$RxBleConnectionStateArray[0] = rxBleConnection$RxBleConnectionState;
        rxBleConnection$RxBleConnectionStateArray[n10] = object;
        rxBleConnection$RxBleConnectionStateArray[n11] = object2;
        rxBleConnection$RxBleConnectionStateArray[n12] = object3;
        a = rxBleConnection$RxBleConnectionStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RxBleConnection$RxBleConnectionState() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.description = var3_1;
    }

    public static RxBleConnection$RxBleConnectionState valueOf(String string2) {
        return Enum.valueOf(RxBleConnection$RxBleConnectionState.class, string2);
    }

    public static RxBleConnection$RxBleConnectionState[] values() {
        return (RxBleConnection$RxBleConnectionState[])a.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxBleConnectionState{");
        String string2 = this.description;
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

