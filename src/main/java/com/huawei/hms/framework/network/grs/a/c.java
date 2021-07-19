/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.Map;

public class c {
    private static final String a = "c";
    private PLSharedPreferences b = null;

    public c(Context context, String string2) {
        String string3 = context.getPackageName();
        Object object = a;
        Object[] objectArray = new Object[]{string3};
        Logger.d((String)object, "get pkgname from context is{%s}", objectArray);
        objectArray.append(string2);
        objectArray.append(string3);
        string2 = objectArray.toString();
        this.b = object = new PLSharedPreferences(context, string2);
        this.a(context);
    }

    private void a(Context object) {
        block6: {
            Object object2;
            try {
                object2 = object.getPackageManager();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Logger.w(a, "get app version failed and catch NameNotFoundException");
                return;
            }
            object = object.getPackageName();
            int n10 = 16384;
            object = object2.getPackageInfo((String)object, n10);
            int n11 = ((PackageInfo)object).versionCode;
            long l10 = n11;
            object = Long.toString(l10);
            object2 = "version";
            String string2 = this.a((String)object2, "");
            boolean bl2 = ((String)object).equals(string2);
            if (bl2) break block6;
            String string3 = a;
            int n12 = 2;
            Object[] objectArray = new Object[n12];
            objectArray[0] = string2;
            n10 = 1;
            objectArray[n10] = object;
            string2 = "app version changed! old version{%s} and new version{%s}";
            Logger.i(string3, string2, objectArray);
            this.c();
            this.b((String)object2, (String)object);
        }
    }

    public String a(String string2, String string3) {
        return this.b.getString(string2, string3);
    }

    public Map a() {
        return this.b.getAll();
    }

    public void a(String string2) {
        this.b.remove(string2);
    }

    public String b() {
        return this.a("cp", "");
    }

    public void b(String string2, String string3) {
        this.b.putString(string2, string3);
    }

    public void c() {
        this.b.clear();
    }
}

