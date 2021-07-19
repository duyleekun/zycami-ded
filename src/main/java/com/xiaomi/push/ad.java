/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.util.Collection;

public class ad {
    public static boolean a(Collection collection) {
        boolean bl2;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            bl2 = false;
            collection = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

