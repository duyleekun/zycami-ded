/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 */
package com.kwai.auth.login.kwailogin.applogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.kwai.auth.common.InternalRequest;

public final class LoginRequest
extends InternalRequest {
    private static final String a = "kwai_request_scope";
    private static final String b = "kwai_state";
    private static final String c = "kwai_request_type";
    private String mScope;
    private String mState;
    private String mType;

    public LoginRequest(String string2, String string3, String string4) {
        this.mScope = string2;
        this.mState = string3;
        this.mType = string4;
        this.forwardAnime = true;
    }

    public Intent buildIntent(Activity object, String string2) {
        object = "kwai_app";
        boolean bl2 = ((String)object).equals(string2);
        String string3 = "android.intent.action.VIEW";
        if (bl2) {
            string2 = Uri.parse((String)"kwai://authorization");
            object = new Intent(string3, (Uri)string2);
            return object;
        }
        object = "nebula_app";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            string2 = Uri.parse((String)"ksnebula://authorization");
            object = new Intent(string3, (Uri)string2);
            return object;
        }
        object = new IllegalStateException("Platform must be corrected.");
        throw object;
    }

    public String getCommand() {
        return "kwai.login";
    }

    public void toBundle(Context object, Bundle bundle) {
        super.toBundle((Context)object, bundle);
        object = this.mScope;
        bundle.putString(a, (String)object);
        object = this.mState;
        bundle.putString(b, (String)object);
        object = this.mType;
        bundle.putString(c, (String)object);
    }
}

