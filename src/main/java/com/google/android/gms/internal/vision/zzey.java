/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Set;

public final class zzey {
    public static int zza(Set object) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            if (e10 != null) {
                n10 = e10.hashCode();
            } else {
                n10 = 0;
                e10 = null;
            }
            n11 = ~(~(n11 + n10));
        }
        return n11;
    }

    public static boolean zza(Set set, Object object) {
        block7: {
            boolean bl2 = true;
            if (set == object) {
                return bl2;
            }
            int n10 = object instanceof Set;
            if (n10 != 0) {
                object = (Set)object;
                n10 = set.size();
                int n11 = object.size();
                if (n10 != n11) break block7;
                try {
                    boolean bl3 = set.containsAll((Collection<?>)object);
                    if (bl3) {
                        return bl2;
                    }
                }
                catch (ClassCastException | NullPointerException runtimeException) {}
            }
        }
        return false;
    }
}

