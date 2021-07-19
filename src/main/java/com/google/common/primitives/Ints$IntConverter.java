/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Ints$IntConverter
extends Converter
implements Serializable {
    public static final Ints$IntConverter INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Ints$IntConverter ints$IntConverter;
        INSTANCE = ints$IntConverter = new Ints$IntConverter();
    }

    private Ints$IntConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String doBackward(Integer n10) {
        return n10.toString();
    }

    public Integer doForward(String string2) {
        return Integer.decode(string2);
    }

    public String toString() {
        return "Ints.stringConverter()";
    }
}

