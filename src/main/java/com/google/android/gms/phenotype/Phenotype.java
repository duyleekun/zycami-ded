/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$ClientKey;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.phenotype.zzl;
import com.google.android.gms.phenotype.zzm;

public final class Phenotype {
    private static final Api API;
    private static final Api$AbstractClientBuilder CLIENT_BUILDER;
    private static final Api$ClientKey CLIENT_KEY;
    private static final zzm zzaj;

    static {
        Api api;
        Object object = new Api$ClientKey();
        CLIENT_KEY = object;
        zzl zzl2 = new zzl();
        CLIENT_BUILDER = zzl2;
        API = api = new Api("Phenotype.API", zzl2, (Api$ClientKey)object);
        zzaj = object = new zzd();
    }

    private Phenotype() {
    }

    public static Uri getContentProviderUri(String string2) {
        string2 = String.valueOf(Uri.encode((String)string2));
        int n10 = string2.length();
        String string3 = "content://com.google.android.gms.phenotype/";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return Uri.parse((String)string2);
    }
}

