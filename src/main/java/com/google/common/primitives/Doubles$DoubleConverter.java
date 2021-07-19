/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Doubles$DoubleConverter
extends Converter
implements Serializable {
    public static final Doubles$DoubleConverter INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Doubles$DoubleConverter doubles$DoubleConverter;
        INSTANCE = doubles$DoubleConverter = new Doubles$DoubleConverter();
    }

    private Doubles$DoubleConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String doBackward(Double d10) {
        return d10.toString();
    }

    public Double doForward(String string2) {
        return Double.valueOf(string2);
    }

    public String toString() {
        return "Doubles.stringConverter()";
    }
}

