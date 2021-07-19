/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.auth.login.kwailogin.applogin;

import android.os.Bundle;
import com.kwai.auth.common.InternalResponse;

public final class LoginResponse
extends InternalResponse {
    private static final String a = "kwai_response_code";
    private static final String b = "kwai_state";
    private static final String c = "kwai_response_access_token";
    private static final String d = "kwai_response_expires_in";
    private static final String e = "kwai_response_open_id";
    private static final String f = "kwai_response_open_secret";
    private static final String g = "kwai_response_open_service_token";

    public LoginResponse(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public void fromBundle(Bundle object) {
        String string2;
        super.fromBundle((Bundle)object);
        this.code = string2 = object.getString(a);
        this.state = string2 = object.getString(b);
        object = object.getString(c);
        this.accessToken = object;
    }

    public boolean isSuccess() {
        int n10 = 1;
        int n11 = this.getErrorCode();
        if (n10 != n11) {
            n10 = 0;
        }
        return n10 != 0;
    }
}

