/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types$ClassOwnership;

public final class Types$ClassOwnership$1
extends Types$ClassOwnership {
    public Class getOwnerType(Class clazz) {
        return clazz.getEnclosingClass();
    }
}

