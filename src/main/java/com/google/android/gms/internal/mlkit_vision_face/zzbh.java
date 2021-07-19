/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Set;

public final class zzbh {
    public static boolean zza(Set set, Iterator iterator2) {
        boolean bl2;
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = set.remove(e10);
            bl3 |= bl2;
        }
        return bl3;
    }
}

