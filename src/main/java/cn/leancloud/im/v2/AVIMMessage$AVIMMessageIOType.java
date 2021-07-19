/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMMessage$AVIMMessageIOType
extends Enum {
    private static final /* synthetic */ AVIMMessage$AVIMMessageIOType[] $VALUES;
    public static final /* enum */ AVIMMessage$AVIMMessageIOType AVIMMessageIOTypeIn;
    public static final /* enum */ AVIMMessage$AVIMMessageIOType AVIMMessageIOTypeOut;
    public int ioType;

    static {
        AVIMMessage$AVIMMessageIOType aVIMMessage$AVIMMessageIOType;
        AVIMMessage$AVIMMessageIOType aVIMMessage$AVIMMessageIOType2;
        int n10 = 1;
        AVIMMessageIOTypeIn = aVIMMessage$AVIMMessageIOType2 = new AVIMMessage$AVIMMessageIOType("AVIMMessageIOTypeIn", 0, n10);
        int n11 = 2;
        AVIMMessageIOTypeOut = aVIMMessage$AVIMMessageIOType = new AVIMMessage$AVIMMessageIOType("AVIMMessageIOTypeOut", n10, n11);
        AVIMMessage$AVIMMessageIOType[] aVIMMessage$AVIMMessageIOTypeArray = new AVIMMessage$AVIMMessageIOType[n11];
        aVIMMessage$AVIMMessageIOTypeArray[0] = aVIMMessage$AVIMMessageIOType2;
        aVIMMessage$AVIMMessageIOTypeArray[n10] = aVIMMessage$AVIMMessageIOType;
        $VALUES = aVIMMessage$AVIMMessageIOTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMMessage$AVIMMessageIOType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.ioType = var3_1;
    }

    public static AVIMMessage$AVIMMessageIOType getMessageIOType(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return AVIMMessageIOTypeOut;
            }
            return AVIMMessageIOTypeOut;
        }
        return AVIMMessageIOTypeIn;
    }

    public static AVIMMessage$AVIMMessageIOType valueOf(String string2) {
        return Enum.valueOf(AVIMMessage$AVIMMessageIOType.class, string2);
    }

    public static AVIMMessage$AVIMMessageIOType[] values() {
        return (AVIMMessage$AVIMMessageIOType[])$VALUES.clone();
    }

    public int getIOType() {
        return this.ioType;
    }
}

