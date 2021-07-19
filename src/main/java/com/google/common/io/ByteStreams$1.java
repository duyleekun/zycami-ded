/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.OutputStream;

public final class ByteStreams$1
extends OutputStream {
    public String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    public void write(int n10) {
    }

    public void write(byte[] byArray) {
        Preconditions.checkNotNull(byArray);
    }

    public void write(byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(byArray);
    }
}

