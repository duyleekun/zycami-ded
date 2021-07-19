/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R$string;

public final class zzfd {
    public static String zza(Context object) {
        Resources resources = object.getResources();
        int n10 = R$string.common_google_play_services_unknown_issue;
        try {
            object = resources.getResourcePackageName(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            object = object.getPackageName();
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final String zzb(String string2, Resources resources, String string3) {
        String string4 = "string";
        int n10 = resources.getIdentifier(string2, string4, string3);
        string3 = null;
        if (n10 == 0) {
            return string3;
        }
        try {
            return resources.getString(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            return string3;
        }
    }
}

