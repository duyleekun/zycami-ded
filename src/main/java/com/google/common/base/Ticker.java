/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Ticker$1;

public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER;

    static {
        Ticker$1 ticker$1 = new Ticker$1();
        SYSTEM_TICKER = ticker$1;
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    public abstract long read();
}

