/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

public final class AVConnectionManager$ConnectionPolicy
extends Enum {
    private static final /* synthetic */ AVConnectionManager$ConnectionPolicy[] $VALUES;
    public static final /* enum */ AVConnectionManager$ConnectionPolicy ForceKeep;
    public static final /* enum */ AVConnectionManager$ConnectionPolicy Keep;
    public static final /* enum */ AVConnectionManager$ConnectionPolicy LetItGone;

    static {
        AVConnectionManager$ConnectionPolicy aVConnectionManager$ConnectionPolicy;
        AVConnectionManager$ConnectionPolicy aVConnectionManager$ConnectionPolicy2;
        AVConnectionManager$ConnectionPolicy aVConnectionManager$ConnectionPolicy3;
        Keep = aVConnectionManager$ConnectionPolicy3 = new AVConnectionManager$ConnectionPolicy("Keep", 0);
        int n10 = 1;
        LetItGone = aVConnectionManager$ConnectionPolicy2 = new AVConnectionManager$ConnectionPolicy("LetItGone", n10);
        int n11 = 2;
        ForceKeep = aVConnectionManager$ConnectionPolicy = new AVConnectionManager$ConnectionPolicy("ForceKeep", n11);
        AVConnectionManager$ConnectionPolicy[] aVConnectionManager$ConnectionPolicyArray = new AVConnectionManager$ConnectionPolicy[3];
        aVConnectionManager$ConnectionPolicyArray[0] = aVConnectionManager$ConnectionPolicy3;
        aVConnectionManager$ConnectionPolicyArray[n10] = aVConnectionManager$ConnectionPolicy2;
        aVConnectionManager$ConnectionPolicyArray[n11] = aVConnectionManager$ConnectionPolicy;
        $VALUES = aVConnectionManager$ConnectionPolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVConnectionManager$ConnectionPolicy() {
        void var2_-1;
        void var1_-1;
    }

    public static AVConnectionManager$ConnectionPolicy valueOf(String string2) {
        return Enum.valueOf(AVConnectionManager$ConnectionPolicy.class, string2);
    }

    public static AVConnectionManager$ConnectionPolicy[] values() {
        return (AVConnectionManager$ConnectionPolicy[])$VALUES.clone();
    }
}

