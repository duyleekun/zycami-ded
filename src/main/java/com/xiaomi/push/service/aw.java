/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 */
package com.xiaomi.push.service;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.push.ab;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aw {
    private static aw a;
    private int a;
    private Context a = 0;

    private aw(Context context) {
        this.a = context = context.getApplicationContext();
    }

    public static aw a(Context context) {
        aw aw2 = a;
        if (aw2 == null) {
            a = aw2 = new aw(context);
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a() {
        int n10 = this.a;
        if (n10 != 0) {
            return n10;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        String string2 = "device_provisioned";
        if (n10 < n11) {
            this.a = n10 = Settings.Secure.getInt((ContentResolver)this.a.getContentResolver(), (String)string2, (int)0);
            return n10;
        }
        try {
            Context context = this.a;
            context = context.getContentResolver();
            this.a = n10 = Settings.Global.getInt((ContentResolver)context, (String)string2, (int)0);
            return this.a;
        }
        catch (Exception exception) {
            return this.a;
        }
    }

    public Uri a() {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "device_provisioned";
        int n11 = 17;
        if (n10 >= n11) {
            return Settings.Global.getUriFor((String)string2);
        }
        return Settings.Secure.getUriFor((String)string2);
    }

    public boolean a() {
        boolean bl2;
        String string2 = ab.a;
        String string3 = "xmsf";
        boolean bl3 = string2.contains(string3);
        if (!(bl3 || (bl3 = string2.contains(string3 = "xiaomi")) || (bl2 = string2.contains(string3 = "miui")))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

