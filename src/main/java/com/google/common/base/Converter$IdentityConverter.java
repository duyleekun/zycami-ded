/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public final class Converter$IdentityConverter
extends Converter
implements Serializable {
    public static final Converter$IdentityConverter INSTANCE;
    private static final long serialVersionUID;

    static {
        Converter$IdentityConverter converter$IdentityConverter;
        INSTANCE = converter$IdentityConverter = new Converter$IdentityConverter();
    }

    private Converter$IdentityConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public Converter doAndThen(Converter converter) {
        return (Converter)Preconditions.checkNotNull(converter, "otherConverter");
    }

    public Object doBackward(Object object) {
        return object;
    }

    public Object doForward(Object object) {
        return object;
    }

    public Converter$IdentityConverter reverse() {
        return this;
    }

    public String toString() {
        return "Converter.identity()";
    }
}

