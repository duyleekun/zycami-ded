/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Floats$FloatConverter
extends Converter
implements Serializable {
    public static final Floats$FloatConverter INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Floats$FloatConverter floats$FloatConverter;
        INSTANCE = floats$FloatConverter = new Floats$FloatConverter();
    }

    private Floats$FloatConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String doBackward(Float f10) {
        return f10.toString();
    }

    public Float doForward(String string2) {
        return Float.valueOf(string2);
    }

    public String toString() {
        return "Floats.stringConverter()";
    }
}

