/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.Objects$ToStringHelper;
import java.util.Arrays;

public final class Objects {
    public Objects() {
        AssertionError assertionError = new AssertionError((Object)"Uninstantiable");
        throw assertionError;
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl2;
        boolean bl3 = true;
        if (object == object2) {
            return bl3;
        }
        if (object == null || !(bl2 = object.equals(object2))) {
            bl3 = false;
        }
        return bl3;
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static Objects$ToStringHelper toStringHelper(Object object) {
        Objects$ToStringHelper objects$ToStringHelper = new Objects$ToStringHelper(object, null);
        return objects$ToStringHelper;
    }
}

