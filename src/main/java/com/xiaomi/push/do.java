/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.hu;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class do
implements Application.ActivityLifecycleCallbacks {
    private Context a;
    private String a = "";
    private String b;

    public do(Context context, String string2) {
        this.a = context;
        this.a = string2;
    }

    private void a(String object) {
        hu hu2 = new hu();
        hu2.a((String)object);
        long l10 = System.currentTimeMillis();
        hu2.a(l10);
        object = ho.s;
        hu2.a((ho)((Object)object));
        ed.a(this.a, hu2);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity object) {
        object = object.getLocalClassName();
        String string2 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            CharSequence charSequence;
            this.b = string2 = "";
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3 && !(bl3 = TextUtils.equals((CharSequence)(charSequence = this.b), (CharSequence)object))) {
                this.a = string2;
                return;
            }
            charSequence = new StringBuilder();
            String string3 = this.a.getPackageName();
            ((StringBuilder)charSequence).append(string3);
            string3 = "|";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(":");
            object = this.a;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(",");
            long l10 = System.currentTimeMillis();
            long l11 = 1000L;
            object = String.valueOf(l10 /= l11);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            this.a((String)object);
            this.a = string2;
            this.b = string2;
        }
    }

    public void onActivityResumed(Activity object) {
        String string2 = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = object.getLocalClassName();
            this.b = object;
        }
        object = String.valueOf(System.currentTimeMillis() / 1000L);
        this.a = object;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

