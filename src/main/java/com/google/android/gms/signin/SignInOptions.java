/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api$ApiOptions$Optional;
import com.google.android.gms.signin.SignInOptions$zaa;

public final class SignInOptions
implements Api$ApiOptions$Optional {
    public static final SignInOptions DEFAULT;
    private final boolean zaaa;
    private final String zaab;
    private final String zaac;
    private final boolean zarv;
    private final boolean zarw;
    private final Long zarx = null;
    private final Long zary = null;
    private final boolean zay;

    static {
        SignInOptions signInOptions;
        new SignInOptions$zaa();
        DEFAULT = signInOptions = new SignInOptions(false, false, null, false, null, false, null, null);
    }

    private SignInOptions(boolean bl2, boolean bl3, String string2, boolean bl4, String string3, boolean bl5, Long l10, Long l11) {
        this.zarv = false;
        this.zay = false;
        this.zaab = null;
        this.zaaa = false;
        this.zarw = false;
        this.zaac = null;
    }

    public final Long getAuthApiSignInModuleVersion() {
        return this.zarx;
    }

    public final String getHostedDomain() {
        return this.zaac;
    }

    public final Long getRealClientLibraryVersion() {
        return this.zary;
    }

    public final String getServerClientId() {
        return this.zaab;
    }

    public final boolean isForceCodeForRefreshToken() {
        return this.zaaa;
    }

    public final boolean isIdTokenRequested() {
        return this.zay;
    }

    public final boolean isOfflineAccessRequested() {
        return this.zarv;
    }

    public final boolean waitForAccessTokenRefresh() {
        return this.zarw;
    }
}

