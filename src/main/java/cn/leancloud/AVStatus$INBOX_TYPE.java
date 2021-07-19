/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVStatus$INBOX_TYPE
extends Enum {
    private static final /* synthetic */ AVStatus$INBOX_TYPE[] $VALUES;
    public static final /* enum */ AVStatus$INBOX_TYPE PRIVATE;
    public static final /* enum */ AVStatus$INBOX_TYPE TIMELINE;
    private String type;

    static {
        AVStatus$INBOX_TYPE aVStatus$INBOX_TYPE;
        AVStatus$INBOX_TYPE aVStatus$INBOX_TYPE2;
        TIMELINE = aVStatus$INBOX_TYPE2 = new AVStatus$INBOX_TYPE("TIMELINE", 0, "default");
        int n10 = 1;
        PRIVATE = aVStatus$INBOX_TYPE = new AVStatus$INBOX_TYPE("PRIVATE", n10, "private");
        AVStatus$INBOX_TYPE[] aVStatus$INBOX_TYPEArray = new AVStatus$INBOX_TYPE[2];
        aVStatus$INBOX_TYPEArray[0] = aVStatus$INBOX_TYPE2;
        aVStatus$INBOX_TYPEArray[n10] = aVStatus$INBOX_TYPE;
        $VALUES = aVStatus$INBOX_TYPEArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVStatus$INBOX_TYPE() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.type = var3_1;
    }

    public static AVStatus$INBOX_TYPE valueOf(String string2) {
        return Enum.valueOf(AVStatus$INBOX_TYPE.class, string2);
    }

    public static AVStatus$INBOX_TYPE[] values() {
        return (AVStatus$INBOX_TYPE[])$VALUES.clone();
    }

    public String toString() {
        return this.type;
    }
}

