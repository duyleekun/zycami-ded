/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.openapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.kwai.opensdk.sdk.openapi.KwaiOpenAPI;
import com.kwai.opensdk.sdk.utils.LogUtil;

public class KwaiRouterActivity
extends Activity {
    public void onCreate(Bundle object) {
        super.onCreate(object);
        object = "KwaiRouterActivity";
        String string2 = "create KwaiRouterActivity and finish";
        LogUtil.d((String)object, string2);
        boolean bl2 = KwaiOpenAPI.isKwaiOpenApiInit;
        if (!bl2) {
            string2 = "start launch intent";
            LogUtil.d((String)object, string2);
            object = this.getPackageManager();
            string2 = this.getPackageName();
            object = object.getLaunchIntentForPackage(string2);
            try {
                this.startActivity((Intent)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.finish();
    }
}

