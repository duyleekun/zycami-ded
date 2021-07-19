/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels$ByteArrayFunnel;
import com.google.common.hash.Funnels$IntegerFunnel;
import com.google.common.hash.Funnels$LongFunnel;
import com.google.common.hash.Funnels$SequentialFunnel;
import com.google.common.hash.Funnels$SinkAsStream;
import com.google.common.hash.Funnels$StringCharsetFunnel;
import com.google.common.hash.Funnels$UnencodedCharsFunnel;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class Funnels {
    private Funnels() {
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        Funnels$SinkAsStream funnels$SinkAsStream = new Funnels$SinkAsStream(primitiveSink);
        return funnels$SinkAsStream;
    }

    public static Funnel byteArrayFunnel() {
        return Funnels$ByteArrayFunnel.INSTANCE;
    }

    public static Funnel integerFunnel() {
        return Funnels$IntegerFunnel.INSTANCE;
    }

    public static Funnel longFunnel() {
        return Funnels$LongFunnel.INSTANCE;
    }

    public static Funnel sequentialFunnel(Funnel funnel) {
        Funnels$SequentialFunnel funnels$SequentialFunnel = new Funnels$SequentialFunnel(funnel);
        return funnels$SequentialFunnel;
    }

    public static Funnel stringFunnel(Charset charset) {
        Funnels$StringCharsetFunnel funnels$StringCharsetFunnel = new Funnels$StringCharsetFunnel(charset);
        return funnels$StringCharsetFunnel;
    }

    public static Funnel unencodedCharsFunnel() {
        return Funnels$UnencodedCharsFunnel.INSTANCE;
    }
}

