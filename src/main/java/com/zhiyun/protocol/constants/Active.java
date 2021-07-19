/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class Active
extends Enum {
    private static final /* synthetic */ Active[] $VALUES;
    public static final /* enum */ Active AES;
    public static final /* enum */ Active AES_SKIP;
    public static final /* enum */ Active NONE;
    public final int code;

    static {
        Active active;
        Active active2;
        Active active3;
        NONE = active3 = new Active("NONE", 0, 0);
        int n10 = 1;
        AES_SKIP = active2 = new Active("AES_SKIP", n10, n10);
        int n11 = 2;
        AES = active = new Active("AES", n11, n11);
        Active[] activeArray = new Active[3];
        activeArray[0] = active3;
        activeArray[n10] = active2;
        activeArray[n11] = active;
        $VALUES = activeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Active() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static Active from(int n10) {
        Active active = NONE;
        for (Active active2 : Active.values()) {
            int n11 = active2.code;
            if (n11 != n10) continue;
            active = active2;
            break;
        }
        return active;
    }

    public static Active valueOf(String string2) {
        return Enum.valueOf(Active.class, string2);
    }

    public static Active[] values() {
        return (Active[])$VALUES.clone();
    }
}

