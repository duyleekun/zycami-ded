/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwai.opensdk.sdk.openapi.KwaiOpenAPI;

public class KwaiHandlerActivity
extends Activity {
    private void handlerIntent(Intent intent) {
        KwaiOpenAPI kwaiOpenAPI = new KwaiOpenAPI((Context)this);
        try {
            kwaiOpenAPI.handleIntent(intent);
        }
        catch (Throwable throwable) {
            intent = null;
            this.setIntent(null);
        }
        return;
        {
            finally {
                this.finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getIntent();
        this.handlerIntent((Intent)bundle);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.handlerIntent(intent);
    }
}

