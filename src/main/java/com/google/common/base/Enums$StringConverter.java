/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public final class Enums$StringConverter
extends Converter
implements Serializable {
    private static final long serialVersionUID;
    private final Class enumClass;

    public Enums$StringConverter(Class clazz) {
        this.enumClass = clazz = (Class)Preconditions.checkNotNull(clazz);
    }

    public String doBackward(Enum enum_) {
        return enum_.name();
    }

    public Enum doForward(String string2) {
        return Enum.valueOf(this.enumClass, string2);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Enums$StringConverter;
        if (bl2) {
            object = (Enums$StringConverter)object;
            Class clazz = this.enumClass;
            object = ((Enums$StringConverter)object).enumClass;
            return clazz.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enums.stringConverter(");
        String string2 = this.enumClass.getName();
        stringBuilder.append(string2);
        stringBuilder.append(".class)");
        return stringBuilder.toString();
    }
}

