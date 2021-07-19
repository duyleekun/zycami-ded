/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public final class FuturesGetChecked$1
implements Function {
    public Boolean apply(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes()).contains(String.class);
    }
}

