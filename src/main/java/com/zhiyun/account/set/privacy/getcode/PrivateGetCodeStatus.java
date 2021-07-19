/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.set.privacy.getcode;

public final class PrivateGetCodeStatus
extends Enum {
    public static final /* enum */ PrivateGetCodeStatus BIND;
    public static final /* enum */ PrivateGetCodeStatus CHANGE_BIND_FIRST;
    public static final /* enum */ PrivateGetCodeStatus CHANGE_BIND_SECOND;
    public static final /* enum */ PrivateGetCodeStatus MODIFY_PASS;
    private static final /* synthetic */ PrivateGetCodeStatus[] a;

    static {
        PrivateGetCodeStatus privateGetCodeStatus;
        PrivateGetCodeStatus privateGetCodeStatus2;
        PrivateGetCodeStatus privateGetCodeStatus3;
        PrivateGetCodeStatus privateGetCodeStatus4;
        MODIFY_PASS = privateGetCodeStatus4 = new PrivateGetCodeStatus("MODIFY_PASS", 0);
        int n10 = 1;
        CHANGE_BIND_FIRST = privateGetCodeStatus3 = new PrivateGetCodeStatus("CHANGE_BIND_FIRST", n10);
        int n11 = 2;
        CHANGE_BIND_SECOND = privateGetCodeStatus2 = new PrivateGetCodeStatus("CHANGE_BIND_SECOND", n11);
        int n12 = 3;
        BIND = privateGetCodeStatus = new PrivateGetCodeStatus("BIND", n12);
        PrivateGetCodeStatus[] privateGetCodeStatusArray = new PrivateGetCodeStatus[4];
        privateGetCodeStatusArray[0] = privateGetCodeStatus4;
        privateGetCodeStatusArray[n10] = privateGetCodeStatus3;
        privateGetCodeStatusArray[n11] = privateGetCodeStatus2;
        privateGetCodeStatusArray[n12] = privateGetCodeStatus;
        a = privateGetCodeStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PrivateGetCodeStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static PrivateGetCodeStatus valueOf(String string2) {
        return Enum.valueOf(PrivateGetCodeStatus.class, string2);
    }

    public static PrivateGetCodeStatus[] values() {
        return (PrivateGetCodeStatus[])a.clone();
    }
}

