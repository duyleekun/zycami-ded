/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.zab;
import com.google.android.gms.signin.zac;

public final class zaa {
    public static final Api API;
    private static final Api$ClientKey CLIENT_KEY;
    public static final Api$AbstractClientBuilder zaph;
    private static final Scope zar;
    private static final Api$ClientKey zars;
    private static final Api$AbstractClientBuilder zart;
    private static final Api zaru;
    private static final Scope zas;

    static {
        Api$ClientKey api$ClientKey;
        Object object = new Api$ClientKey();
        CLIENT_KEY = object;
        zars = api$ClientKey = new Api$ClientKey();
        zab zab2 = new zab();
        zaph = zab2;
        zac zac2 = new zac();
        zart = zac2;
        Object object2 = new Scope("profile");
        zar = object2;
        object2 = new Scope("email");
        zas = object2;
        API = object2 = new Api("SignIn.API", zab2, (Api$ClientKey)object);
        zaru = object = new Api("SignIn.INTERNAL_API", zac2, api$ClientKey);
    }
}

