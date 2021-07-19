/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk.help;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.n;

public class HelpService
extends IntentService {
    public HelpService() {
        super("intentService");
    }

    public void onHandleIntent(Intent intent) {
        String string2 = intent.getStringExtra("awake_info");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            bl2 = false;
            string2 = null;
            n.a((Context)this, intent, null);
        }
    }
}

