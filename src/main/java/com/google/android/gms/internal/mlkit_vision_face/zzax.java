/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Map;

public final class zzax {
    public static Object zza(Map map, Object object) {
        zzj.zza(map);
        try {
            return map.get(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return null;
        }
    }

    public static boolean zzb(Map map, Object object) {
        zzj.zza(map);
        try {
            return map.containsKey(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public static Object zzc(Map map, Object object) {
        zzj.zza(map);
        try {
            return map.remove(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return null;
        }
    }
}

