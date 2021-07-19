/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class zzi {
    private static final Uri zza;
    private static final Uri zzb;

    static {
        Uri uri;
        zza = uri = Uri.parse((String)"https://plus.google.com/");
        zzb = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent zza() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent zza(String string2) {
        string2 = Uri.fromParts((String)"package", (String)string2, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData((Uri)string2);
        return intent;
    }

    public static Intent zza(String string2, String string3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Object object = Uri.parse((String)"market://details").buildUpon();
        String string4 = "id";
        string2 = object.appendQueryParameter(string4, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            object = "pcampaignid";
            string2.appendQueryParameter((String)object, string3);
        }
        string2 = string2.build();
        intent.setData((Uri)string2);
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
}

