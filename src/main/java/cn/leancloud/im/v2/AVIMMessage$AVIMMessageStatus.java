/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMMessage$AVIMMessageStatus
extends Enum {
    private static final /* synthetic */ AVIMMessage$AVIMMessageStatus[] $VALUES;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusFailed;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusNone;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusRecalled;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusReceipt;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusSending;
    public static final /* enum */ AVIMMessage$AVIMMessageStatus AVIMMessageStatusSent;
    public int statusCode;

    static {
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus;
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus2;
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus3;
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus4;
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus5;
        AVIMMessage$AVIMMessageStatus aVIMMessage$AVIMMessageStatus6;
        AVIMMessageStatusNone = aVIMMessage$AVIMMessageStatus6 = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusNone", 0, 0);
        int n10 = 1;
        AVIMMessageStatusSending = aVIMMessage$AVIMMessageStatus5 = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusSending", n10, n10);
        int n11 = 2;
        AVIMMessageStatusSent = aVIMMessage$AVIMMessageStatus4 = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusSent", n11, n11);
        int n12 = 3;
        AVIMMessageStatusReceipt = aVIMMessage$AVIMMessageStatus3 = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusReceipt", n12, n12);
        int n13 = 4;
        AVIMMessageStatusFailed = aVIMMessage$AVIMMessageStatus2 = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusFailed", n13, n13);
        int n14 = 5;
        AVIMMessageStatusRecalled = aVIMMessage$AVIMMessageStatus = new AVIMMessage$AVIMMessageStatus("AVIMMessageStatusRecalled", n14, n14);
        AVIMMessage$AVIMMessageStatus[] aVIMMessage$AVIMMessageStatusArray = new AVIMMessage$AVIMMessageStatus[6];
        aVIMMessage$AVIMMessageStatusArray[0] = aVIMMessage$AVIMMessageStatus6;
        aVIMMessage$AVIMMessageStatusArray[n10] = aVIMMessage$AVIMMessageStatus5;
        aVIMMessage$AVIMMessageStatusArray[n11] = aVIMMessage$AVIMMessageStatus4;
        aVIMMessage$AVIMMessageStatusArray[n12] = aVIMMessage$AVIMMessageStatus3;
        aVIMMessage$AVIMMessageStatusArray[n13] = aVIMMessage$AVIMMessageStatus2;
        aVIMMessage$AVIMMessageStatusArray[n14] = aVIMMessage$AVIMMessageStatus;
        $VALUES = aVIMMessage$AVIMMessageStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMMessage$AVIMMessageStatus() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.statusCode = var3_1;
    }

    public static AVIMMessage$AVIMMessageStatus getMessageStatus(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) {
                                return null;
                            }
                            return AVIMMessageStatusRecalled;
                        }
                        return AVIMMessageStatusFailed;
                    }
                    return AVIMMessageStatusReceipt;
                }
                return AVIMMessageStatusSent;
            }
            return AVIMMessageStatusSending;
        }
        return AVIMMessageStatusNone;
    }

    public static AVIMMessage$AVIMMessageStatus valueOf(String string2) {
        return Enum.valueOf(AVIMMessage$AVIMMessageStatus.class, string2);
    }

    public static AVIMMessage$AVIMMessageStatus[] values() {
        return (AVIMMessage$AVIMMessageStatus[])$VALUES.clone();
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

