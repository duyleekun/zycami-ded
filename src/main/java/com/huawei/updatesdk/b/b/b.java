/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build$VERSION
 */
package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.updatesdk.a.a.c.a.a.a;

public class b {
    private SharedPreferences a;

    private b(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public static b a(String string2, Context object) {
        int n10;
        block4: {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if (n10 < n11) break block4;
            object = object.createDeviceProtectedStorageContext();
        }
        n10 = 0;
        try {
            string2 = object.getSharedPreferences(string2, 0);
        }
        catch (Exception exception) {
            object = "getSharedPreference error";
            com.huawei.updatesdk.a.a.c.a.a.a.b("SharedPreferencesWrapper", (String)object);
            string2 = null;
        }
        object = new b((SharedPreferences)string2);
        return object;
    }

    public long a(String string2, long l10) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.a;
        }
        catch (Exception exception) {
            return l10;
        }
        return sharedPreferences.getLong(string2, l10);
    }

    public String a(String string2, String string3) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.a;
        }
        catch (Exception exception) {
            return string3;
        }
        return sharedPreferences.getString(string2, string3);
    }

    public void a(String string2) {
        Object object;
        block6: {
            object = this.a;
            boolean bl2 = object.contains(string2);
            if (bl2) break block6;
            return;
        }
        object = this.a;
        object = object.edit();
        try {
            object.remove(string2);
            object.commit();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            String string3 = "remove error!!key:";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = "SharedPreferencesWrapper";
            com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string2);
        }
    }

    public void b(String string2, long l10) {
        Object object = this.a;
        object = object.edit();
        try {
            object.putLong(string2, l10);
            object.commit();
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            object = "putLong error!!key:";
            charSequence.append((String)object);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = "SharedPreferencesWrapper";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)charSequence, string2, exception);
        }
    }

    public void b(String string2, String string3) {
        Object object = this.a;
        object = object.edit();
        try {
            object.putString(string2, string3);
            object.commit();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            String string4 = "putString error!!key:";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = "SharedPreferencesWrapper";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, string2, exception);
        }
    }
}

