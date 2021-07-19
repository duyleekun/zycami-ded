/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.util.Log
 */
package com.kwai.auth.login.kwailogin.applogin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.kwai.auth.common.InternalResponse;
import com.kwai.auth.login.kwailogin.applogin.LoginResponse;
import d.l.a.c;

public class RouteHandlerActivity
extends Activity {
    public void onCreate(Bundle object) {
        Object object2;
        String string2;
        int n10;
        String string3;
        c c10;
        block16: {
            super.onCreate((Bundle)object);
            object = this.getIntent();
            try {
                c10 = c.f();
                string3 = "kwai_response_error_msg";
                n10 = -1007;
                string2 = "kwai_response_error_code";
                if (object == null) break block16;
            }
            catch (IllegalStateException illegalStateException) {
                String string4 = RouteHandlerActivity.class.getSimpleName();
                String string5 = illegalStateException.getMessage();
                Log.e((String)string4, (String)string5);
                this.setIntent(null);
                this.finish();
                return;
            }
            object = object.getExtras();
            if (object == null) break block16;
            object2 = this.getIntent();
            object2 = object2.getExtras();
            object = new LoginResponse((Bundle)object2);
            c10.h((InternalResponse)object, this);
        }
        object = RouteHandlerActivity.class;
        object = ((Class)object).getSimpleName();
        object2 = "null intent";
        Log.e((String)object, (String)object2);
        object = new Bundle();
        object.putInt(string2, n10);
        object2 = "route null intent";
        object.putString(string3, (String)object2);
        object2 = new LoginResponse((Bundle)object);
        try {
            c10.h((InternalResponse)object2, this);
            return;
        }
        catch (Throwable throwable) {
            object2 = new Bundle();
            object2.putInt(string2, n10);
            StringBuilder stringBuilder = new StringBuilder();
            string2 = "route exception = ";
            stringBuilder.append(string2);
            Object object3 = throwable.getMessage();
            stringBuilder.append((String)object3);
            object3 = stringBuilder.toString();
            object2.putString(string3, (String)object3);
            object3 = new LoginResponse((Bundle)object2);
            c10.h((InternalResponse)object3, this);
            this.setIntent(null);
            this.finish();
        }
    }
}

