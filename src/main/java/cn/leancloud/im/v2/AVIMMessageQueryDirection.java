/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMMessageQueryDirection
extends Enum {
    private static final /* synthetic */ AVIMMessageQueryDirection[] $VALUES;
    public static final /* enum */ AVIMMessageQueryDirection AVIMMessageQueryDirectionFromNewToOld;
    public static final /* enum */ AVIMMessageQueryDirection AVIMMessageQueryDirectionFromOldToNew;
    public static final /* enum */ AVIMMessageQueryDirection AVIMMessageQueryDirectionUnknown;
    private static String[] descriptions;
    private int code = -1;

    static {
        AVIMMessageQueryDirection aVIMMessageQueryDirection;
        AVIMMessageQueryDirection aVIMMessageQueryDirection2;
        AVIMMessageQueryDirection aVIMMessageQueryDirection3;
        AVIMMessageQueryDirectionUnknown = aVIMMessageQueryDirection3 = new AVIMMessageQueryDirection("AVIMMessageQueryDirectionUnknown", 0, -1);
        int n10 = 1;
        AVIMMessageQueryDirectionFromNewToOld = aVIMMessageQueryDirection2 = new AVIMMessageQueryDirection("AVIMMessageQueryDirectionFromNewToOld", n10, 0);
        int n11 = 2;
        AVIMMessageQueryDirectionFromOldToNew = aVIMMessageQueryDirection = new AVIMMessageQueryDirection("AVIMMessageQueryDirectionFromOldToNew", n11, n10);
        AVIMMessageQueryDirection[] aVIMMessageQueryDirectionArray = new AVIMMessageQueryDirection[3];
        aVIMMessageQueryDirectionArray[0] = aVIMMessageQueryDirection3;
        aVIMMessageQueryDirectionArray[n10] = aVIMMessageQueryDirection2;
        aVIMMessageQueryDirectionArray[n11] = aVIMMessageQueryDirection;
        $VALUES = aVIMMessageQueryDirectionArray;
        descriptions = new String[]{"Unknown", "Old", "New"};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMMessageQueryDirection() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static AVIMMessageQueryDirection parseFromCode(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return AVIMMessageQueryDirectionUnknown;
            }
            return AVIMMessageQueryDirectionFromOldToNew;
        }
        return AVIMMessageQueryDirectionFromNewToOld;
    }

    public static AVIMMessageQueryDirection valueOf(String string2) {
        return Enum.valueOf(AVIMMessageQueryDirection.class, string2);
    }

    public static AVIMMessageQueryDirection[] values() {
        return (AVIMMessageQueryDirection[])$VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        String[] stringArray = descriptions;
        int n10 = this.code + 1;
        return stringArray[n10];
    }
}

