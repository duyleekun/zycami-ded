/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.kwai.auth.common.InternalResponse;

public class H5LoginResponse
extends InternalResponse {
    private static final String a = "code";
    private static final String b = "STATE";
    private static final String c = "access_token";
    private static final String d = "result";
    private static final String e = "error_msg";
    private static final String f = "is_new_user";

    public H5LoginResponse(Intent object) {
        String string2;
        String string3;
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string3 = object.getStringExtra(string2 = d))))) {
            CharSequence charSequence;
            block15: {
                string3 = Uri.parse((String)string3);
                charSequence = a;
                charSequence = string3.getQueryParameter((String)charSequence);
                this.code = charSequence;
                string2 = string3.getQueryParameter(string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) break block15;
                bl2 = TextUtils.isDigitsOnly((CharSequence)string2);
                if (!bl2) break block15;
                int bl3 = Integer.parseInt(string2);
                this.setErrorCode(bl3);
            }
            string2 = e;
            string2 = string3.getQueryParameter(string2);
            this.setErrorMsg(string2);
            string2 = f;
            string2 = string3.getQueryParameter(string2);
            boolean bl3 = Boolean.parseBoolean(string2);
            try {
                this.setNewUser(bl3);
            }
            catch (Exception exception) {
                string3 = H5LoginResponse.class.getSimpleName();
                String string4 = "H5LoginResponse init error:";
                ((StringBuilder)charSequence).append(string4);
                string2 = exception.getMessage();
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                Log.e((String)string3, (String)string2);
            }
            string2 = "state";
            this.state = object = object.getStringExtra(string2);
        }
    }

    public boolean isSuccess() {
        String string2;
        int n10 = this.getErrorCode();
        if (!n10 && !(n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = this.code)) ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }
}

