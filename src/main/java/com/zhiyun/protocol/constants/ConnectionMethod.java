/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class ConnectionMethod
extends Enum {
    private static final /* synthetic */ ConnectionMethod[] $VALUES;
    public static final /* enum */ ConnectionMethod BLE;
    public static final /* enum */ ConnectionMethod BLE_AUTO_SWITCH_WIFI;
    public static final /* enum */ ConnectionMethod BLE_SWITCH_WIFI;
    public static final /* enum */ ConnectionMethod BLE_TO_WIFI;
    public static final /* enum */ ConnectionMethod WIFI;
    public final int value;

    static {
        ConnectionMethod connectionMethod;
        ConnectionMethod connectionMethod2;
        ConnectionMethod connectionMethod3;
        ConnectionMethod connectionMethod4;
        ConnectionMethod connectionMethod5;
        BLE = connectionMethod5 = new ConnectionMethod("BLE", 0, 0);
        int n10 = 1;
        BLE_SWITCH_WIFI = connectionMethod4 = new ConnectionMethod("BLE_SWITCH_WIFI", n10, n10);
        int n11 = 2;
        BLE_TO_WIFI = connectionMethod3 = new ConnectionMethod("BLE_TO_WIFI", n11, n11);
        int n12 = 3;
        WIFI = connectionMethod2 = new ConnectionMethod("WIFI", n12, n12);
        int n13 = 4;
        BLE_AUTO_SWITCH_WIFI = connectionMethod = new ConnectionMethod("BLE_AUTO_SWITCH_WIFI", n13, n13);
        ConnectionMethod[] connectionMethodArray = new ConnectionMethod[5];
        connectionMethodArray[0] = connectionMethod5;
        connectionMethodArray[n10] = connectionMethod4;
        connectionMethodArray[n11] = connectionMethod3;
        connectionMethodArray[n12] = connectionMethod2;
        connectionMethodArray[n13] = connectionMethod;
        $VALUES = connectionMethodArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConnectionMethod() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static ConnectionMethod from(int n10) {
        ConnectionMethod connectionMethod = BLE;
        for (ConnectionMethod connectionMethod2 : ConnectionMethod.values()) {
            int n11 = connectionMethod2.value;
            if (n11 != n10) continue;
            connectionMethod = connectionMethod2;
        }
        return connectionMethod;
    }

    public static ConnectionMethod valueOf(String string2) {
        return Enum.valueOf(ConnectionMethod.class, string2);
    }

    public static ConnectionMethod[] values() {
        return (ConnectionMethod[])$VALUES.clone();
    }
}

