/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;

public class Funnels$SinkAsStream
extends OutputStream {
    public final PrimitiveSink sink;

    public Funnels$SinkAsStream(PrimitiveSink primitiveSink) {
        this.sink = primitiveSink = (PrimitiveSink)Preconditions.checkNotNull(primitiveSink);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Funnels.asOutputStream(");
        PrimitiveSink primitiveSink = this.sink;
        stringBuilder.append(primitiveSink);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void write(int n10) {
        PrimitiveSink primitiveSink = this.sink;
        n10 = (byte)n10;
        primitiveSink.putByte((byte)n10);
    }

    public void write(byte[] byArray) {
        this.sink.putBytes(byArray);
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.sink.putBytes(byArray, n10, n11);
    }
}

