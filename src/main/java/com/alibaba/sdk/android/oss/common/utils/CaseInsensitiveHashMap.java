/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import java.util.HashMap;

public class CaseInsensitiveHashMap
extends HashMap {
    public Object get(Object object) {
        boolean bl2;
        if (object != null && !(bl2 = this.containsKey(object)) && (bl2 = object instanceof String)) {
            bl2 = this.containsKey(object = ((String)object).toLowerCase());
            if (bl2) {
                return this.get(object);
            }
            return null;
        }
        return super.get(object);
    }
}

