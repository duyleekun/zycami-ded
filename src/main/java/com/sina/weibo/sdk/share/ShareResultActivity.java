/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ShareResultActivity
extends Activity {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            bundle = this.getIntent();
            if (bundle == null) {
                this.finish();
                return;
            }
            String string2 = "start_flag";
            int n10 = -1;
            int n11 = bundle.getIntExtra(string2, n10);
            if (n11 == 0) {
                this.finish();
                return;
            }
            String string3 = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY";
            string2 = bundle.getAction();
            n10 = (int)(string3.equals(string2) ? 1 : 0);
            if (n10 != 0) {
                string2 = "com.sina.weibo.sdk.share.ShareTransActivity";
                bundle.setClassName((Context)this, string2);
            } else {
                string3 = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
                n11 = (int)(string3.equals(string2) ? 1 : 0);
                if (n11 != 0) {
                    string2 = "com.sina.weibo.sdk.share.ShareStoryActivity";
                    bundle.setClassName((Context)this, string2);
                }
            }
            this.startActivity((Intent)bundle);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.finish();
    }
}

