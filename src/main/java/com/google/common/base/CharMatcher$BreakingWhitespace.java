/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$BreakingWhitespace
extends CharMatcher {
    public static final CharMatcher INSTANCE;

    static {
        CharMatcher$BreakingWhitespace charMatcher$BreakingWhitespace = new CharMatcher$BreakingWhitespace();
        INSTANCE = charMatcher$BreakingWhitespace;
    }

    private CharMatcher$BreakingWhitespace() {
    }

    public boolean matches(char n10) {
        int n11 = 32;
        boolean bl2 = true;
        if (n10 != n11 && n10 != (n11 = 133) && n10 != (n11 = 5760)) {
            n11 = 8199;
            if (n10 != n11) {
                n11 = 8287;
                if (n10 != n11 && n10 != (n11 = 12288) && n10 != (n11 = 8232) && n10 != (n11 = 8233)) {
                    switch (n10) {
                        default: {
                            n11 = 8192;
                            if (n10 < n11 || n10 > (n11 = 8202)) {
                                bl2 = false;
                            }
                            return bl2;
                        }
                        case 9: 
                        case 10: 
                        case 11: 
                        case 12: 
                        case 13: {
                            return bl2;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return bl2;
    }

    public String toString() {
        return "CharMatcher.breakingWhitespace()";
    }
}

