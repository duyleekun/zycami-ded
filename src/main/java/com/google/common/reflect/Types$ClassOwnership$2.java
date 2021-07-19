/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types$ClassOwnership;

public final class Types$ClassOwnership$2
extends Types$ClassOwnership {
    public Class getOwnerType(Class clazz) {
        boolean bl2 = clazz.isLocalClass();
        if (bl2) {
            return null;
        }
        return clazz.getEnclosingClass();
    }
}

