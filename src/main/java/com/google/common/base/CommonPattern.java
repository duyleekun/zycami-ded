/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonMatcher;
import com.google.common.base.Platform;

public abstract class CommonPattern {
    public static CommonPattern compile(String string2) {
        return Platform.compilePattern(string2);
    }

    public static boolean isPcreLike() {
        return Platform.patternCompilerIsPcreLike();
    }

    public abstract int flags();

    public abstract CommonMatcher matcher(CharSequence var1);

    public abstract String pattern();

    public abstract String toString();
}

