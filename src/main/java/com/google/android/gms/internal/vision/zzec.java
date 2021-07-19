/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public final class zzec {
    public static int zzf(Object object) {
        int n10;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return zzec.zzx(n10);
    }

    public static int zzx(int n10) {
        return (int)((long)Integer.rotateLeft((int)((long)n10 * 3432918353L), 15) * 461845907L);
    }
}

