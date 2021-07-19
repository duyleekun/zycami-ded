/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.xiaomi.mipush.sdk.help;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.mipush.sdk.n;

public class HelpActivity
extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getIntent();
        n.a((Context)this, (Intent)bundle, null);
        this.finish();
    }
}

