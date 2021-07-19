/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Converter$ReverseConverter
extends Converter
implements Serializable {
    private static final long serialVersionUID;
    public final Converter original;

    public Converter$ReverseConverter(Converter converter) {
        this.original = converter;
    }

    public Object correctedDoBackward(Object object) {
        return this.original.correctedDoForward(object);
    }

    public Object correctedDoForward(Object object) {
        return this.original.correctedDoBackward(object);
    }

    public Object doBackward(Object object) {
        object = new AssertionError();
        throw object;
    }

    public Object doForward(Object object) {
        object = new AssertionError();
        throw object;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Converter$ReverseConverter;
        if (bl2) {
            object = (Converter$ReverseConverter)object;
            Converter converter = this.original;
            object = ((Converter$ReverseConverter)object).original;
            return converter.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return ~this.original.hashCode();
    }

    public Converter reverse() {
        return this.original;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Converter converter = this.original;
        stringBuilder.append(converter);
        stringBuilder.append(".reverse()");
        return stringBuilder.toString();
    }
}

