/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types$JavaVersion;
import java.lang.reflect.Type;

public final class Types$1
implements Function {
    public String apply(Type type) {
        return Types$JavaVersion.CURRENT.typeName(type);
    }
}

