/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class AVIMMessageOption$MessagePriority
extends Enum {
    private static final /* synthetic */ AVIMMessageOption$MessagePriority[] $VALUES;
    public static final /* enum */ AVIMMessageOption$MessagePriority High;
    public static final /* enum */ AVIMMessageOption$MessagePriority Low;
    public static final /* enum */ AVIMMessageOption$MessagePriority Normal;
    private int priorityIndex;

    static {
        AVIMMessageOption$MessagePriority aVIMMessageOption$MessagePriority;
        AVIMMessageOption$MessagePriority aVIMMessageOption$MessagePriority2;
        AVIMMessageOption$MessagePriority aVIMMessageOption$MessagePriority3;
        int n10 = 1;
        High = aVIMMessageOption$MessagePriority3 = new AVIMMessageOption$MessagePriority("High", 0, n10);
        int n11 = 2;
        Normal = aVIMMessageOption$MessagePriority2 = new AVIMMessageOption$MessagePriority("Normal", n10, n11);
        int n12 = 3;
        Low = aVIMMessageOption$MessagePriority = new AVIMMessageOption$MessagePriority("Low", n11, n12);
        AVIMMessageOption$MessagePriority[] aVIMMessageOption$MessagePriorityArray = new AVIMMessageOption$MessagePriority[n12];
        aVIMMessageOption$MessagePriorityArray[0] = aVIMMessageOption$MessagePriority3;
        aVIMMessageOption$MessagePriorityArray[n10] = aVIMMessageOption$MessagePriority2;
        aVIMMessageOption$MessagePriorityArray[n11] = aVIMMessageOption$MessagePriority;
        $VALUES = aVIMMessageOption$MessagePriorityArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVIMMessageOption$MessagePriority() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.priorityIndex = var3_1;
    }

    public static AVIMMessageOption$MessagePriority getProiority(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return null;
                }
                return Low;
            }
            return Normal;
        }
        return High;
    }

    public static AVIMMessageOption$MessagePriority valueOf(String string2) {
        return Enum.valueOf(AVIMMessageOption$MessagePriority.class, string2);
    }

    public static AVIMMessageOption$MessagePriority[] values() {
        return (AVIMMessageOption$MessagePriority[])$VALUES.clone();
    }

    public int getNumber() {
        return this.priorityIndex;
    }
}

