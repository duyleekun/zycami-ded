/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.otherevent;

public final class MoveLineStatus
extends Enum {
    public static final /* enum */ MoveLineStatus MOVING;
    public static final /* enum */ MoveLineStatus PAUSED;
    public static final /* enum */ MoveLineStatus QUERY;
    public static final /* enum */ MoveLineStatus STARTED;
    public static final /* enum */ MoveLineStatus STOPPED;
    private static final /* synthetic */ MoveLineStatus[] a;
    public final int value;

    static {
        MoveLineStatus moveLineStatus;
        MoveLineStatus moveLineStatus2;
        MoveLineStatus moveLineStatus3;
        MoveLineStatus moveLineStatus4;
        MoveLineStatus moveLineStatus5;
        QUERY = moveLineStatus5 = new MoveLineStatus("QUERY", 0, 0);
        int n10 = 1;
        STOPPED = moveLineStatus4 = new MoveLineStatus("STOPPED", n10, n10);
        int n11 = 2;
        PAUSED = moveLineStatus3 = new MoveLineStatus("PAUSED", n11, n11);
        int n12 = 3;
        STARTED = moveLineStatus2 = new MoveLineStatus("STARTED", n12, n12);
        int n13 = 4;
        MOVING = moveLineStatus = new MoveLineStatus("MOVING", n13, n13);
        MoveLineStatus[] moveLineStatusArray = new MoveLineStatus[5];
        moveLineStatusArray[0] = moveLineStatus5;
        moveLineStatusArray[n10] = moveLineStatus4;
        moveLineStatusArray[n11] = moveLineStatus3;
        moveLineStatusArray[n12] = moveLineStatus2;
        moveLineStatusArray[n13] = moveLineStatus;
        a = moveLineStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MoveLineStatus() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static MoveLineStatus toMoveLineStatus(int n10) {
        MoveLineStatus moveLineStatus = PAUSED;
        int n11 = moveLineStatus.value;
        if (n10 == n11) {
            return moveLineStatus;
        }
        moveLineStatus = STARTED;
        n11 = moveLineStatus.value;
        if (n10 == n11) {
            return moveLineStatus;
        }
        moveLineStatus = MOVING;
        n11 = moveLineStatus.value;
        if (n10 == n11) {
            return moveLineStatus;
        }
        moveLineStatus = STOPPED;
        n11 = moveLineStatus.value;
        if (n10 == n11) {
            return moveLineStatus;
        }
        return QUERY;
    }

    public static MoveLineStatus valueOf(String string2) {
        return Enum.valueOf(MoveLineStatus.class, string2);
    }

    public static MoveLineStatus[] values() {
        return (MoveLineStatus[])a.clone();
    }
}

