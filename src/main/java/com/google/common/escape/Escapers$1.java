/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.CharEscaper;

public final class Escapers$1
extends CharEscaper {
    public String escape(String string2) {
        return (String)Preconditions.checkNotNull(string2);
    }

    public char[] escape(char c10) {
        return null;
    }
}

