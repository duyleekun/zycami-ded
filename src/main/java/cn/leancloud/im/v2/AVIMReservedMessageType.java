/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMReservedMessageType
extends Enum {
    private static final /* synthetic */ AVIMReservedMessageType[] $VALUES;
    public static final /* enum */ AVIMReservedMessageType AudioMessageType;
    public static final /* enum */ AVIMReservedMessageType FileMessageType;
    public static final /* enum */ AVIMReservedMessageType ImageMessageType;
    public static final /* enum */ AVIMReservedMessageType LocationMessageType;
    public static final /* enum */ AVIMReservedMessageType TextMessageType;
    public static final /* enum */ AVIMReservedMessageType UnsupportedMessageType;
    public static final /* enum */ AVIMReservedMessageType VideoMessageType;
    public int type;

    static {
        AVIMReservedMessageType aVIMReservedMessageType;
        AVIMReservedMessageType aVIMReservedMessageType2;
        AVIMReservedMessageType aVIMReservedMessageType3;
        AVIMReservedMessageType aVIMReservedMessageType4;
        AVIMReservedMessageType aVIMReservedMessageType5;
        AVIMReservedMessageType aVIMReservedMessageType6;
        AVIMReservedMessageType aVIMReservedMessageType7;
        UnsupportedMessageType = aVIMReservedMessageType7 = new AVIMReservedMessageType("UnsupportedMessageType", 0, 0);
        int n10 = 1;
        TextMessageType = aVIMReservedMessageType6 = new AVIMReservedMessageType("TextMessageType", n10, -1);
        int n11 = 2;
        ImageMessageType = aVIMReservedMessageType5 = new AVIMReservedMessageType("ImageMessageType", n11, -2);
        int n12 = 3;
        AudioMessageType = aVIMReservedMessageType4 = new AVIMReservedMessageType("AudioMessageType", n12, -3);
        int n13 = 4;
        VideoMessageType = aVIMReservedMessageType3 = new AVIMReservedMessageType("VideoMessageType", n13, -4);
        int n14 = 5;
        LocationMessageType = aVIMReservedMessageType2 = new AVIMReservedMessageType("LocationMessageType", n14, -5);
        int n15 = 6;
        FileMessageType = aVIMReservedMessageType = new AVIMReservedMessageType("FileMessageType", n15, -6);
        AVIMReservedMessageType[] aVIMReservedMessageTypeArray = new AVIMReservedMessageType[7];
        aVIMReservedMessageTypeArray[0] = aVIMReservedMessageType7;
        aVIMReservedMessageTypeArray[n10] = aVIMReservedMessageType6;
        aVIMReservedMessageTypeArray[n11] = aVIMReservedMessageType5;
        aVIMReservedMessageTypeArray[n12] = aVIMReservedMessageType4;
        aVIMReservedMessageTypeArray[n13] = aVIMReservedMessageType3;
        aVIMReservedMessageTypeArray[n14] = aVIMReservedMessageType2;
        aVIMReservedMessageTypeArray[n15] = aVIMReservedMessageType;
        $VALUES = aVIMReservedMessageTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMReservedMessageType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.type = var3_1;
    }

    public static AVIMReservedMessageType getAVIMReservedMessageType(int n10) {
        switch (n10) {
            default: {
                return UnsupportedMessageType;
            }
            case 0: {
                return UnsupportedMessageType;
            }
            case -1: {
                return TextMessageType;
            }
            case -2: {
                return ImageMessageType;
            }
            case -3: {
                return AudioMessageType;
            }
            case -4: {
                return VideoMessageType;
            }
            case -5: {
                return LocationMessageType;
            }
            case -6: 
        }
        return FileMessageType;
    }

    public static AVIMReservedMessageType valueOf(String string2) {
        return Enum.valueOf(AVIMReservedMessageType.class, string2);
    }

    public static AVIMReservedMessageType[] values() {
        return (AVIMReservedMessageType[])$VALUES.clone();
    }

    public int getType() {
        return this.type;
    }
}

