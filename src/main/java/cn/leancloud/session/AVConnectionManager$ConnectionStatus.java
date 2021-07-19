/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

public final class AVConnectionManager$ConnectionStatus
extends Enum {
    private static final /* synthetic */ AVConnectionManager$ConnectionStatus[] $VALUES;
    public static final /* enum */ AVConnectionManager$ConnectionStatus Connected;
    public static final /* enum */ AVConnectionManager$ConnectionStatus Connecting;
    public static final /* enum */ AVConnectionManager$ConnectionStatus Offline;

    static {
        AVConnectionManager$ConnectionStatus aVConnectionManager$ConnectionStatus;
        AVConnectionManager$ConnectionStatus aVConnectionManager$ConnectionStatus2;
        AVConnectionManager$ConnectionStatus aVConnectionManager$ConnectionStatus3;
        Offline = aVConnectionManager$ConnectionStatus3 = new AVConnectionManager$ConnectionStatus("Offline", 0);
        int n10 = 1;
        Connecting = aVConnectionManager$ConnectionStatus2 = new AVConnectionManager$ConnectionStatus("Connecting", n10);
        int n11 = 2;
        Connected = aVConnectionManager$ConnectionStatus = new AVConnectionManager$ConnectionStatus("Connected", n11);
        AVConnectionManager$ConnectionStatus[] aVConnectionManager$ConnectionStatusArray = new AVConnectionManager$ConnectionStatus[3];
        aVConnectionManager$ConnectionStatusArray[0] = aVConnectionManager$ConnectionStatus3;
        aVConnectionManager$ConnectionStatusArray[n10] = aVConnectionManager$ConnectionStatus2;
        aVConnectionManager$ConnectionStatusArray[n11] = aVConnectionManager$ConnectionStatus;
        $VALUES = aVConnectionManager$ConnectionStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVConnectionManager$ConnectionStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static AVConnectionManager$ConnectionStatus valueOf(String string2) {
        return Enum.valueOf(AVConnectionManager$ConnectionStatus.class, string2);
    }

    public static AVConnectionManager$ConnectionStatus[] values() {
        return (AVConnectionManager$ConnectionStatus[])$VALUES.clone();
    }
}

