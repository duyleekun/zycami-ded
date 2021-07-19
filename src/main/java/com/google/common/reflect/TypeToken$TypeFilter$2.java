/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken$TypeFilter;

public final class TypeToken$TypeFilter$2
extends TypeToken$TypeFilter {
    public boolean apply(TypeToken typeToken) {
        return typeToken.getRawType().isInterface();
    }
}

