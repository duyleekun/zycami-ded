/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 */
package com.kwai.opensdk.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.kwai.opensdk.sdk.utils.LogUtil;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class LoadingActivity$1
implements Runnable {
    public final /* synthetic */ Intent val$intent;
    public final /* synthetic */ WeakReference val$ref;

    public LoadingActivity$1(WeakReference weakReference, Intent intent) {
        this.val$ref = weakReference;
        this.val$intent = intent;
    }

    public void run() {
        String string2 = "KwaiOpenSdk";
        Object object = this.val$ref.get();
        if (object != null) {
            object = this.val$ref;
            object = ((Reference)object).get();
            object = (Activity)object;
            StringBuilder stringBuilder = this.val$intent;
            try {
                object.startActivity((Intent)stringBuilder);
            }
            catch (SecurityException securityException) {
                stringBuilder = new StringBuilder();
                String string3 = "security exception, ";
                stringBuilder.append(string3);
                stringBuilder.append(securityException);
                String string4 = stringBuilder.toString();
                LogUtil.e(string2, string4);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                stringBuilder = new StringBuilder();
                String string5 = "not found activity, ";
                stringBuilder.append(string5);
                stringBuilder.append((Object)activityNotFoundException);
                String string6 = stringBuilder.toString();
                LogUtil.e(string2, string6);
            }
        }
    }
}

