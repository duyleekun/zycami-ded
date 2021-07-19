/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.kwai.auth.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;

public abstract class InternalRequest
implements Serializable {
    public static final String REQUEST_CALLING_PACKAGE = "kwai_request_calling_package";
    public static final String REQUEST_PROP_APP_ID = "kwai_request_app_id";
    public static final String REQUEST_PROP_COMMAND = "kwai_command";
    private static final long serialVersionUID = -851537070778335822L;
    public String appId;
    public boolean forwardAnime;
    public String packageName;

    public abstract Intent buildIntent(Activity var1, String var2);

    public String getAppId() {
        return this.appId;
    }

    public abstract String getCommand();

    public boolean hasForwardAnime() {
        return this.forwardAnime;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void toBundle(Context object, Bundle bundle) {
        object = this.getCommand();
        bundle.putString("kwai_command", (String)object);
        object = this.getAppId();
        bundle.putString("kwai_request_app_id", (String)object);
        object = this.packageName;
        bundle.putString("kwai_request_calling_package", (String)object);
    }
}

