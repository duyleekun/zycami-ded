/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonMatcher;
import com.google.common.base.CommonPattern;
import com.google.common.base.JdkPattern$JdkMatcher;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JdkPattern
extends CommonPattern
implements Serializable {
    private static final long serialVersionUID;
    private final Pattern pattern;

    public JdkPattern(Pattern pattern) {
        this.pattern = pattern = (Pattern)Preconditions.checkNotNull(pattern);
    }

    public int flags() {
        return this.pattern.flags();
    }

    public CommonMatcher matcher(CharSequence object) {
        object = this.pattern.matcher((CharSequence)object);
        JdkPattern$JdkMatcher jdkPattern$JdkMatcher = new JdkPattern$JdkMatcher((Matcher)object);
        return jdkPattern$JdkMatcher;
    }

    public String pattern() {
        return this.pattern.pattern();
    }

    public String toString() {
        return this.pattern.toString();
    }
}

