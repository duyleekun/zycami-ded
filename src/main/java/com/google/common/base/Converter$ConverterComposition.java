/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import java.io.Serializable;

public final class Converter$ConverterComposition
extends Converter
implements Serializable {
    private static final long serialVersionUID;
    public final Converter first;
    public final Converter second;

    public Converter$ConverterComposition(Converter converter, Converter converter2) {
        this.first = converter;
        this.second = converter2;
    }

    public Object correctedDoBackward(Object object) {
        Converter converter = this.first;
        object = this.second.correctedDoBackward(object);
        return converter.correctedDoBackward(object);
    }

    public Object correctedDoForward(Object object) {
        Converter converter = this.second;
        object = this.first.correctedDoForward(object);
        return converter.correctedDoForward(object);
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
        boolean bl2 = object instanceof Converter$ConverterComposition;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Converter$ConverterComposition)object;
            Converter converter = this.first;
            Converter converter2 = ((Converter$ConverterComposition)object).first;
            bl2 = converter.equals(converter2);
            if (bl2 && (bl4 = (converter = this.second).equals(object = ((Converter$ConverterComposition)object).second))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.first.hashCode() * 31;
        int n11 = this.second.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Converter converter = this.first;
        stringBuilder.append(converter);
        stringBuilder.append(".andThen(");
        converter = this.second;
        stringBuilder.append(converter);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

