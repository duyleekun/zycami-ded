/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Collection;

public final class zzac {
    public static boolean zza(Collection collection, Object object) {
        zzj.zza(collection);
        try {
            return collection.contains(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }
}

