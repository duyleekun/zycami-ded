/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Shorts$ShortConverter
extends Converter
implements Serializable {
    public static final Shorts$ShortConverter INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Shorts$ShortConverter shorts$ShortConverter;
        INSTANCE = shorts$ShortConverter = new Shorts$ShortConverter();
    }

    private Shorts$ShortConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String doBackward(Short s10) {
        return s10.toString();
    }

    public Short doForward(String string2) {
        return Short.decode(string2);
    }

    public String toString() {
        return "Shorts.stringConverter()";
    }
}

