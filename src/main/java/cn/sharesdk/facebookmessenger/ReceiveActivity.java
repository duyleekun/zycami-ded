/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 */
package cn.sharesdk.facebookmessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class ReceiveActivity
extends Activity {
    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getIntent().getAction();
        Object object2 = "android.intent.action.PICK";
        if (object2 == object) {
            boolean bl2;
            object = this.getIntent().getCategories();
            if (object != null && (bl2 = object.contains(object2 = "com.facebook.orca.category.PLATFORM_THREAD_20150314"))) {
                block12: {
                    object = this.getPackageManager();
                    object2 = this.getPackageName();
                    object = object.getLaunchIntentForPackage((String)object2);
                    object2 = this.getIntent();
                    String string2 = "al_applink_data";
                    object2 = object2.getBundleExtra(string2);
                    if (object2 == null) break block12;
                    string2 = "extras";
                    object2 = object2.getBundle(string2);
                    object.putExtras((Bundle)object2);
                }
                try {
                    this.startActivity((Intent)object);
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    ((NLog)object2).d(throwable);
                }
            } else {
                this.finish();
                return;
            }
        }
        this.finish();
    }
}

