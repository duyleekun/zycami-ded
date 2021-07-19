/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonMatcher;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;

public final class JdkPattern$JdkMatcher
extends CommonMatcher {
    public final Matcher matcher;

    public JdkPattern$JdkMatcher(Matcher matcher) {
        this.matcher = matcher = (Matcher)Preconditions.checkNotNull(matcher);
    }

    public int end() {
        return this.matcher.end();
    }

    public boolean find() {
        return this.matcher.find();
    }

    public boolean find(int n10) {
        return this.matcher.find(n10);
    }

    public boolean matches() {
        return this.matcher.matches();
    }

    public String replaceAll(String string2) {
        return this.matcher.replaceAll(string2);
    }

    public int start() {
        return this.matcher.start();
    }
}

