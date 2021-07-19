/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

public final class AVSession$Status
extends Enum {
    private static final /* synthetic */ AVSession$Status[] $VALUES;
    public static final /* enum */ AVSession$Status Closed;
    public static final /* enum */ AVSession$Status Opened;
    public static final /* enum */ AVSession$Status Resuming;

    static {
        AVSession$Status aVSession$Status;
        AVSession$Status aVSession$Status2;
        AVSession$Status aVSession$Status3;
        Opened = aVSession$Status3 = new AVSession$Status("Opened", 0);
        int n10 = 1;
        Closed = aVSession$Status2 = new AVSession$Status("Closed", n10);
        int n11 = 2;
        Resuming = aVSession$Status = new AVSession$Status("Resuming", n11);
        AVSession$Status[] aVSession$StatusArray = new AVSession$Status[3];
        aVSession$StatusArray[0] = aVSession$Status3;
        aVSession$StatusArray[n10] = aVSession$Status2;
        aVSession$StatusArray[n11] = aVSession$Status;
        $VALUES = aVSession$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVSession$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static AVSession$Status valueOf(String string2) {
        return Enum.valueOf(AVSession$Status.class, string2);
    }

    public static AVSession$Status[] values() {
        return (AVSession$Status[])$VALUES.clone();
    }
}

