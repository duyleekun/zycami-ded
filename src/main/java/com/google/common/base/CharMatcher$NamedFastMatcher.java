/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;

public abstract class CharMatcher$NamedFastMatcher
extends CharMatcher$FastMatcher {
    private final String description;

    public CharMatcher$NamedFastMatcher(String string2) {
        this.description = string2 = (String)Preconditions.checkNotNull(string2);
    }

    public final String toString() {
        return this.description;
    }
}

