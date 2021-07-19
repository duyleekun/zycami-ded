/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

public final class TokenResult$ResponseCode
extends Enum {
    private static final /* synthetic */ TokenResult$ResponseCode[] $VALUES;
    public static final /* enum */ TokenResult$ResponseCode AUTH_ERROR;
    public static final /* enum */ TokenResult$ResponseCode BAD_CONFIG;
    public static final /* enum */ TokenResult$ResponseCode OK;

    static {
        TokenResult$ResponseCode tokenResult$ResponseCode;
        TokenResult$ResponseCode tokenResult$ResponseCode2;
        TokenResult$ResponseCode tokenResult$ResponseCode3;
        OK = tokenResult$ResponseCode3 = new TokenResult$ResponseCode("OK", 0);
        int n10 = 1;
        BAD_CONFIG = tokenResult$ResponseCode2 = new TokenResult$ResponseCode("BAD_CONFIG", n10);
        int n11 = 2;
        AUTH_ERROR = tokenResult$ResponseCode = new TokenResult$ResponseCode("AUTH_ERROR", n11);
        TokenResult$ResponseCode[] tokenResult$ResponseCodeArray = new TokenResult$ResponseCode[3];
        tokenResult$ResponseCodeArray[0] = tokenResult$ResponseCode3;
        tokenResult$ResponseCodeArray[n10] = tokenResult$ResponseCode2;
        tokenResult$ResponseCodeArray[n11] = tokenResult$ResponseCode;
        $VALUES = tokenResult$ResponseCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TokenResult$ResponseCode() {
        void var2_-1;
        void var1_-1;
    }

    public static TokenResult$ResponseCode valueOf(String string2) {
        return Enum.valueOf(TokenResult$ResponseCode.class, string2);
    }

    public static TokenResult$ResponseCode[] values() {
        return (TokenResult$ResponseCode[])$VALUES.clone();
    }
}

