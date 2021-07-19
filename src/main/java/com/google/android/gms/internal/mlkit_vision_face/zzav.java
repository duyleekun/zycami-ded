/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Iterator;

public final class zzav {
    public static void zza(Iterator iterator2) {
        boolean bl2;
        zzj.zza(iterator2);
        while (bl2 = iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }
}

