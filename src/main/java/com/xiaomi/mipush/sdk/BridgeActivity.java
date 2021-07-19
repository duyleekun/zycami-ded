/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.WindowManager$LayoutParams
 */
package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;

public class BridgeActivity
extends Activity {
    public void onCreate(Bundle bundle) {
        int n10;
        super.onCreate(bundle);
        bundle = this.getWindow();
        WindowManager.LayoutParams layoutParams = bundle.getAttributes();
        layoutParams.height = n10 = 1;
        layoutParams.width = n10;
        layoutParams.gravity = 51;
        bundle.setAttributes(layoutParams);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onResume() {
        Throwable throwable2;
        block6: {
            block5: {
                super.onResume();
                Intent intent = this.getIntent();
                if (intent == null) break block5;
                String string2 = "mipush_serviceIntent";
                intent = intent.getParcelableExtra(string2);
                if (intent != null) {
                    string2 = this.getApplicationContext();
                    PushMessageHandler.a((Context)string2, intent);
                }
                {
                    catch (Throwable throwable2) {
                        break block6;
                    }
                    catch (Exception exception) {}
                    {
                        b.a(exception);
                    }
                }
            }
            this.finish();
            return;
        }
        this.finish();
        throw throwable2;
    }
}

