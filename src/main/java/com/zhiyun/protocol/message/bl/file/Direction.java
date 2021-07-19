/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.file;

public final class Direction
extends Enum {
    public static final /* enum */ Direction RECV;
    public static final /* enum */ Direction SEND;
    private static final /* synthetic */ Direction[] a;
    public final int value;

    static {
        Direction direction;
        Direction direction2;
        SEND = direction2 = new Direction("SEND", 0, 0);
        int n10 = 1;
        RECV = direction = new Direction("RECV", n10, n10);
        Direction[] directionArray = new Direction[2];
        directionArray[0] = direction2;
        directionArray[n10] = direction;
        a = directionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Direction() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Direction toDirection(int n10) {
        Direction direction = SEND;
        int n11 = direction.value;
        if (n10 == n11) {
            return direction;
        }
        return RECV;
    }

    public static Direction valueOf(String string2) {
        return Enum.valueOf(Direction.class, string2);
    }

    public static Direction[] values() {
        return (Direction[])a.clone();
    }
}

