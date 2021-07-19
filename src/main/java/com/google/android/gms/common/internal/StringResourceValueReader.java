/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.internal.Preconditions;

public class StringResourceValueReader {
    private final Resources zza;
    private final String zzb;

    public StringResourceValueReader(Context object) {
        Preconditions.checkNotNull(object);
        object = object.getResources();
        this.zza = object;
        int n10 = R$string.common_google_play_services_unknown_issue;
        object = object.getResourcePackageName(n10);
        this.zzb = object;
    }

    public String getString(String string2) {
        Resources resources = this.zza;
        String string3 = "string";
        String string4 = this.zzb;
        int n10 = resources.getIdentifier(string2, string3, string4);
        if (n10 == 0) {
            return null;
        }
        return this.zza.getString(n10);
    }
}

