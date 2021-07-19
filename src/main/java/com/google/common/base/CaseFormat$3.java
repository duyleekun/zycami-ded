/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;

public final class CaseFormat$3
extends CaseFormat {
    public CaseFormat$3(CharMatcher charMatcher, String string3) {
    }

    public String normalizeFirstWord(String string2) {
        return Ascii.toLowerCase(string2);
    }

    public String normalizeWord(String string2) {
        return CaseFormat.access$100(string2);
    }
}

