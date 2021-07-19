/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVStatusQuery$PaginationDirection
extends Enum {
    private static final /* synthetic */ AVStatusQuery$PaginationDirection[] $VALUES;
    public static final /* enum */ AVStatusQuery$PaginationDirection NEW_TO_OLD;
    public static final /* enum */ AVStatusQuery$PaginationDirection OLD_TO_NEW;
    public int value;

    static {
        AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection;
        AVStatusQuery$PaginationDirection aVStatusQuery$PaginationDirection2;
        NEW_TO_OLD = aVStatusQuery$PaginationDirection2 = new AVStatusQuery$PaginationDirection("NEW_TO_OLD", 0, 0);
        int n10 = 1;
        OLD_TO_NEW = aVStatusQuery$PaginationDirection = new AVStatusQuery$PaginationDirection("OLD_TO_NEW", n10, n10);
        AVStatusQuery$PaginationDirection[] aVStatusQuery$PaginationDirectionArray = new AVStatusQuery$PaginationDirection[2];
        aVStatusQuery$PaginationDirectionArray[0] = aVStatusQuery$PaginationDirection2;
        aVStatusQuery$PaginationDirectionArray[n10] = aVStatusQuery$PaginationDirection;
        $VALUES = aVStatusQuery$PaginationDirectionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVStatusQuery$PaginationDirection() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static AVStatusQuery$PaginationDirection valueOf(String string2) {
        return Enum.valueOf(AVStatusQuery$PaginationDirection.class, string2);
    }

    public static AVStatusQuery$PaginationDirection[] values() {
        return (AVStatusQuery$PaginationDirection[])$VALUES.clone();
    }

    public int value() {
        return this.value;
    }
}

