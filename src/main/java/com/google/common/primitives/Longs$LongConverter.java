/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Longs$LongConverter
extends Converter
implements Serializable {
    public static final Longs$LongConverter INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Longs$LongConverter longs$LongConverter;
        INSTANCE = longs$LongConverter = new Longs$LongConverter();
    }

    private Longs$LongConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String doBackward(Long l10) {
        return l10.toString();
    }

    public Long doForward(String string2) {
        return Long.decode(string2);
    }

    public String toString() {
        return "Longs.stringConverter()";
    }
}

