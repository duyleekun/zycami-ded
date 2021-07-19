/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import java.util.Arrays;
import java.util.Collection;

public final class Objects {
    private Objects() {
        AssertionError assertionError = new AssertionError((Object)"Uninstantiable");
        throw assertionError;
    }

    public static boolean checkBundlesEquality(Bundle bundle, Bundle bundle2) {
        boolean bl2 = true;
        if (bundle != null && bundle2 != null) {
            Object object;
            int n10;
            int n11 = bundle.size();
            if (n11 != (n10 = bundle2.size())) {
                return false;
            }
            Object object2 = bundle.keySet();
            n10 = (int)(object2.containsAll((Collection<?>)(object = bundle2.keySet())) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
            object2 = object2.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object = (String)object2.next();
                Object object3 = bundle.get((String)object);
                n10 = (int)(Objects.equal(object3, object = bundle2.get((String)object)) ? 1 : 0);
                if (n10 != 0) continue;
                return false;
            }
            return bl2;
        }
        if (bundle == bundle2) {
            return bl2;
        }
        return false;
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl2;
        return object == object2 || object != null && (bl2 = object.equals(object2));
        {
        }
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static Objects$ToStringHelper toStringHelper(Object object) {
        Objects$ToStringHelper objects$ToStringHelper = new Objects$ToStringHelper(object, null);
        return objects$ToStringHelper;
    }
}

