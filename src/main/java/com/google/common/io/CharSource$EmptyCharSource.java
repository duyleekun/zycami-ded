/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.CharSource$StringCharSource;

public final class CharSource$EmptyCharSource
extends CharSource$StringCharSource {
    private static final CharSource$EmptyCharSource INSTANCE;

    static {
        CharSource$EmptyCharSource charSource$EmptyCharSource;
        INSTANCE = charSource$EmptyCharSource = new CharSource$EmptyCharSource();
    }

    private CharSource$EmptyCharSource() {
        super("");
    }

    public static /* synthetic */ CharSource$EmptyCharSource access$000() {
        return INSTANCE;
    }

    public String toString() {
        return "CharSource.empty()";
    }
}

