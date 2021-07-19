/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 */
package com.google.android.gms.common.internal;

import android.net.Uri;

public final class ResourceUtils {
    private static final Uri zza;

    static {
        Uri.Builder builder = new Uri.Builder();
        zza = builder.scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
    }

    private ResourceUtils() {
    }
}

