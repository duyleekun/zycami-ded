/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwai.auth.common.InternalRequest;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity;
import d.l.a.e.a;

public class H5LoginRequest
extends InternalRequest {
    private String mAuthType;
    private String mScope;
    private String mState;

    public H5LoginRequest(String string2, String string3, String string4) {
        this.mScope = string2;
        this.mState = string3;
        this.mAuthType = string4;
    }

    public Intent buildIntent(Activity activity, String string2) {
        string2 = new Intent((Context)activity, KwaiH5LoginActivity.class);
        return string2;
    }

    public String getCommand() {
        return "kwai.h5.login";
    }

    public void toBundle(Context object, Bundle bundle) {
        String string2 = this.getAppId();
        String string3 = this.mAuthType;
        String string4 = this.mState;
        String string5 = this.mScope;
        object = a.c(string2, string3, string4, string5, object);
        bundle.putString("extra_url", (String)object);
        object = this.mState;
        bundle.putString("extra_state", (String)object);
        bundle.putInt("extra_request_code", 1000);
    }
}

