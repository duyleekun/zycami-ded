/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class Types$NativeTypeVariableEquals {
    public static final boolean NATIVE_TYPE_VARIABLE_ONLY;

    static {
        Object object = Types$NativeTypeVariableEquals.class;
        TypeVariable typeVariable = ((Class)object).getTypeParameters()[0];
        Type[] typeArray = new Type[]{};
        object = Types.newArtificialTypeVariable(object, "X", typeArray);
        NATIVE_TYPE_VARIABLE_ONLY = typeVariable.equals(object) ^ true;
    }
}

