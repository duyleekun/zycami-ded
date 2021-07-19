/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzw {
    public static boolean zza(Context context, String string2) {
        String string3;
        int n10;
        int n11 = DynamiteModule.getLocalVersion(context, string2);
        return n11 > (n10 = DynamiteModule.getRemoteVersion(context, string3 = "com.google.android.gms.vision.dynamite"));
    }
}

