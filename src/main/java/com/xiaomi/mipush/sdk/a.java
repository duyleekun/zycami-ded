/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import java.util.HashSet;
import java.util.Set;

public class a
implements Application.ActivityLifecycleCallbacks {
    private Set a;

    public a() {
        HashSet hashSet;
        this.a = hashSet = new HashSet();
    }

    private static void a(Application application) {
        a a10 = new a();
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)a10);
    }

    public static void a(Context context) {
        com.xiaomi.mipush.sdk.a.a((Application)context.getApplicationContext());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onActivityResumed(Activity activity) {
        int n10;
        String string2;
        String string3;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        Object object = "messageId";
        String string4 = intent.getStringExtra((String)object);
        Object object2 = "eventMessageType";
        int n11 = intent.getIntExtra((String)object2, -1);
        int n12 = TextUtils.isEmpty((CharSequence)string4);
        if (n12 != 0) return;
        if (n11 <= 0) return;
        object = this.a;
        n12 = object.contains(string4);
        if (n12 != 0) return;
        object = this.a;
        object.add(string4);
        n12 = 3000;
        if (n11 == n12) {
            object = activity.getApplicationContext();
            object2 = fb.a((Context)object);
            string3 = activity.getPackageName();
            string2 = fa.a(n11);
            n10 = 3008;
        } else {
            n12 = 1000;
            if (n11 != n12) return;
            object = activity.getApplicationContext();
            object2 = fb.a((Context)object);
            string3 = activity.getPackageName();
            string2 = fa.a(n11);
            n10 = 1008;
        }
        ((fb)object2).a(string3, string2, string4, n10, null);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

