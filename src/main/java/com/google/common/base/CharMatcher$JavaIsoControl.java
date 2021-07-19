/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

public final class CharMatcher$JavaIsoControl
extends CharMatcher$NamedFastMatcher {
    public static final CharMatcher$JavaIsoControl INSTANCE;

    static {
        CharMatcher$JavaIsoControl charMatcher$JavaIsoControl;
        INSTANCE = charMatcher$JavaIsoControl = new CharMatcher$JavaIsoControl();
    }

    private CharMatcher$JavaIsoControl() {
        super("CharMatcher.javaIsoControl()");
    }

    public boolean matches(char n10) {
        int n11 = 31;
        n10 = n10 > n11 && (n10 < (n11 = 127) || n10 > (n11 = 159)) ? 0 : 1;
        return n10 != 0;
    }
}

