/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package d.c.a.t;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import d.c.a.o.c;
import d.c.a.t.e;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {
    private static final String a = "AppVersionSignature";
    private static final ConcurrentMap b;

    static {
        ConcurrentHashMap concurrentHashMap;
        b = concurrentHashMap = new ConcurrentHashMap();
    }

    private b() {
    }

    private static PackageInfo a(Context object) {
        CharSequence charSequence;
        PackageManager packageManager;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Cannot resolve info for");
            object = object.getPackageName();
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)a, (String)object, (Throwable)nameNotFoundException);
            return null;
        }
        charSequence = object.getPackageName();
        return packageManager.getPackageInfo((String)charSequence, 0);
    }

    private static String b(PackageInfo object) {
        if (object != null) {
            int n10 = object.versionCode;
            object = String.valueOf(n10);
        } else {
            object = UUID.randomUUID().toString();
        }
        return object;
    }

    public static c c(Context object) {
        ConcurrentMap concurrentMap = b;
        String string2 = object.getPackageName();
        c c10 = (c)concurrentMap.get(string2);
        if (c10 == null && (object = concurrentMap.putIfAbsent(string2, c10 = d.c.a.t.b.d(object))) != null) {
            c10 = object;
        }
        return c10;
    }

    private static c d(Context object) {
        object = d.c.a.t.b.b(d.c.a.t.b.a(object));
        e e10 = new e(object);
        return e10;
    }

    public static void e() {
        b.clear();
    }
}

