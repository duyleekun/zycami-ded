/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

public final class zzap {
    public static int zza(Object object) {
        int n10;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return (int)((long)Integer.rotateLeft((int)((long)n10 * 3432918353L), 15) * 461845907L);
    }
}

