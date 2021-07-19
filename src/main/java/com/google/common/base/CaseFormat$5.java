/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;

public final class CaseFormat$5
extends CaseFormat {
    public CaseFormat$5(CharMatcher charMatcher, String string3) {
    }

    public String convert(CaseFormat caseFormat, String string2) {
        CaseFormat caseFormat2 = CaseFormat.LOWER_HYPHEN;
        if (caseFormat == caseFormat2) {
            return Ascii.toLowerCase(string2.replace('_', '-'));
        }
        caseFormat2 = CaseFormat.LOWER_UNDERSCORE;
        if (caseFormat == caseFormat2) {
            return Ascii.toLowerCase(string2);
        }
        return super.convert(caseFormat, string2);
    }

    public String normalizeWord(String string2) {
        return Ascii.toUpperCase(string2);
    }
}

