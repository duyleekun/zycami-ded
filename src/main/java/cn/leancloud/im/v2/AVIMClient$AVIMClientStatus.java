/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMClient$AVIMClientStatus
extends Enum {
    private static final /* synthetic */ AVIMClient$AVIMClientStatus[] $VALUES;
    public static final /* enum */ AVIMClient$AVIMClientStatus AVIMClientStatusNone;
    public static final /* enum */ AVIMClient$AVIMClientStatus AVIMClientStatusOpened;
    public static final /* enum */ AVIMClient$AVIMClientStatus AVIMClientStatusPaused;
    public int code;

    static {
        AVIMClient$AVIMClientStatus aVIMClient$AVIMClientStatus;
        AVIMClient$AVIMClientStatus aVIMClient$AVIMClientStatus2;
        AVIMClient$AVIMClientStatus aVIMClient$AVIMClientStatus3;
        AVIMClientStatusNone = aVIMClient$AVIMClientStatus3 = new AVIMClient$AVIMClientStatus("AVIMClientStatusNone", 0, 110);
        int n10 = 1;
        AVIMClientStatusOpened = aVIMClient$AVIMClientStatus2 = new AVIMClient$AVIMClientStatus("AVIMClientStatusOpened", n10, 111);
        int n11 = 2;
        AVIMClientStatusPaused = aVIMClient$AVIMClientStatus = new AVIMClient$AVIMClientStatus("AVIMClientStatusPaused", n11, 120);
        AVIMClient$AVIMClientStatus[] aVIMClient$AVIMClientStatusArray = new AVIMClient$AVIMClientStatus[3];
        aVIMClient$AVIMClientStatusArray[0] = aVIMClient$AVIMClientStatus3;
        aVIMClient$AVIMClientStatusArray[n10] = aVIMClient$AVIMClientStatus2;
        aVIMClient$AVIMClientStatusArray[n11] = aVIMClient$AVIMClientStatus;
        $VALUES = aVIMClient$AVIMClientStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMClient$AVIMClientStatus() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static AVIMClient$AVIMClientStatus getClientStatus(int n10) {
        int n11 = 110;
        if (n10 != n11) {
            n11 = 111;
            if (n10 != n11) {
                n11 = 120;
                if (n10 != n11) {
                    return null;
                }
                return AVIMClientStatusPaused;
            }
            return AVIMClientStatusOpened;
        }
        return AVIMClientStatusNone;
    }

    public static AVIMClient$AVIMClientStatus valueOf(String string2) {
        return Enum.valueOf(AVIMClient$AVIMClientStatus.class, string2);
    }

    public static AVIMClient$AVIMClientStatus[] values() {
        return (AVIMClient$AVIMClientStatus[])$VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }
}

