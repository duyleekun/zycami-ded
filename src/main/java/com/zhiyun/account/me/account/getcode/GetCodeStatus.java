/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.me.account.getcode;

public final class GetCodeStatus
extends Enum {
    public static final /* enum */ GetCodeStatus FORGET_PASS;
    public static final /* enum */ GetCodeStatus QUICK_LOGIN;
    public static final /* enum */ GetCodeStatus REGISTER;
    public static final /* enum */ GetCodeStatus THIRD_BIND;
    private static final /* synthetic */ GetCodeStatus[] a;

    static {
        GetCodeStatus getCodeStatus;
        GetCodeStatus getCodeStatus2;
        GetCodeStatus getCodeStatus3;
        GetCodeStatus getCodeStatus4;
        REGISTER = getCodeStatus4 = new GetCodeStatus("REGISTER", 0);
        int n10 = 1;
        FORGET_PASS = getCodeStatus3 = new GetCodeStatus("FORGET_PASS", n10);
        int n11 = 2;
        THIRD_BIND = getCodeStatus2 = new GetCodeStatus("THIRD_BIND", n11);
        int n12 = 3;
        QUICK_LOGIN = getCodeStatus = new GetCodeStatus("QUICK_LOGIN", n12);
        GetCodeStatus[] getCodeStatusArray = new GetCodeStatus[4];
        getCodeStatusArray[0] = getCodeStatus4;
        getCodeStatusArray[n10] = getCodeStatus3;
        getCodeStatusArray[n11] = getCodeStatus2;
        getCodeStatusArray[n12] = getCodeStatus;
        a = getCodeStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private GetCodeStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static GetCodeStatus valueOf(String string2) {
        return Enum.valueOf(GetCodeStatus.class, string2);
    }

    public static GetCodeStatus[] values() {
        return (GetCodeStatus[])a.clone();
    }
}

