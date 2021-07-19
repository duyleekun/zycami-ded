/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVStatusQuery$SourceType
extends Enum {
    private static final /* synthetic */ AVStatusQuery$SourceType[] $VALUES;
    public static final /* enum */ AVStatusQuery$SourceType INBOX;
    public static final /* enum */ AVStatusQuery$SourceType OWNED;

    static {
        AVStatusQuery$SourceType aVStatusQuery$SourceType;
        AVStatusQuery$SourceType aVStatusQuery$SourceType2;
        INBOX = aVStatusQuery$SourceType2 = new AVStatusQuery$SourceType("INBOX", 0);
        int n10 = 1;
        OWNED = aVStatusQuery$SourceType = new AVStatusQuery$SourceType("OWNED", n10);
        AVStatusQuery$SourceType[] aVStatusQuery$SourceTypeArray = new AVStatusQuery$SourceType[2];
        aVStatusQuery$SourceTypeArray[0] = aVStatusQuery$SourceType2;
        aVStatusQuery$SourceTypeArray[n10] = aVStatusQuery$SourceType;
        $VALUES = aVStatusQuery$SourceTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVStatusQuery$SourceType() {
        void var2_-1;
        void var1_-1;
    }

    public static AVStatusQuery$SourceType valueOf(String string2) {
        return Enum.valueOf(AVStatusQuery$SourceType.class, string2);
    }

    public static AVStatusQuery$SourceType[] values() {
        return (AVStatusQuery$SourceType[])$VALUES.clone();
    }
}

