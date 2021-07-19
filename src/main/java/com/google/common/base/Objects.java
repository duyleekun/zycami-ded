/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.ExtraObjectsMethodsForWeb;
import java.util.Arrays;

public final class Objects
extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }
}

