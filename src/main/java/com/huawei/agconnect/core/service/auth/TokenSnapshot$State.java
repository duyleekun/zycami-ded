/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.agconnect.core.service.auth;

public final class TokenSnapshot$State
extends Enum {
    public static final /* enum */ TokenSnapshot$State SIGNED_IN;
    public static final /* enum */ TokenSnapshot$State SIGNED_OUT;
    public static final /* enum */ TokenSnapshot$State TOKEN_INVALID;
    public static final /* enum */ TokenSnapshot$State TOKEN_UPDATED;
    private static final /* synthetic */ TokenSnapshot$State[] a;

    static {
        TokenSnapshot$State tokenSnapshot$State;
        TokenSnapshot$State tokenSnapshot$State2;
        TokenSnapshot$State tokenSnapshot$State3;
        TokenSnapshot$State tokenSnapshot$State4;
        SIGNED_IN = tokenSnapshot$State4 = new TokenSnapshot$State("SIGNED_IN", 0);
        int n10 = 1;
        TOKEN_UPDATED = tokenSnapshot$State3 = new TokenSnapshot$State("TOKEN_UPDATED", n10);
        int n11 = 2;
        TOKEN_INVALID = tokenSnapshot$State2 = new TokenSnapshot$State("TOKEN_INVALID", n11);
        int n12 = 3;
        SIGNED_OUT = tokenSnapshot$State = new TokenSnapshot$State("SIGNED_OUT", n12);
        TokenSnapshot$State[] tokenSnapshot$StateArray = new TokenSnapshot$State[4];
        tokenSnapshot$StateArray[0] = tokenSnapshot$State4;
        tokenSnapshot$StateArray[n10] = tokenSnapshot$State3;
        tokenSnapshot$StateArray[n11] = tokenSnapshot$State2;
        tokenSnapshot$StateArray[n12] = tokenSnapshot$State;
        a = tokenSnapshot$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TokenSnapshot$State() {
        void var2_-1;
        void var1_-1;
    }

    public static TokenSnapshot$State valueOf(String string2) {
        return Enum.valueOf(TokenSnapshot$State.class, string2);
    }

    public static TokenSnapshot$State[] values() {
        return (TokenSnapshot$State[])a.clone();
    }
}

