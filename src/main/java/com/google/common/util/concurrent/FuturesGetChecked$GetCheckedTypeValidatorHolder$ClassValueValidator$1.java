/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;

public final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1
extends ClassValue {
    public Boolean computeValue(Class clazz) {
        FuturesGetChecked.checkExceptionClassValidity(clazz.asSubclass(Exception.class));
        return Boolean.TRUE;
    }
}

