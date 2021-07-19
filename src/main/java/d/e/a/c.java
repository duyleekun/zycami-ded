/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import d.e.a.d;
import d.e.a.e;
import d.e.a.i;
import d.e.a.k;
import d.e.a.l;
import d.e.a.m;
import d.e.a.n;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static i a;
    private static e b;
    public static boolean c = false;

    public static void a() {
        Object object = b;
        if (object != null) {
            ((e)object).a();
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map b() {
        e e10 = b;
        if (e10 == null) {
            RuntimeException runtimeException = new RuntimeException("Please initialize Logan first");
            throw runtimeException;
        }
        File file = e10.c();
        boolean bl2 = file.exists();
        int n10 = 0;
        if (!bl2) {
            return null;
        }
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return null;
        }
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        n10 = fileArray.length;
        int n11 = 0;
        while (n11 < n10) {
            File file2 = fileArray[n11];
            try {
                String string2 = file2.getName();
                long l10 = Long.parseLong(string2);
                string2 = n.b(l10);
                long l11 = file2.length();
                Long l12 = l11;
                hashMap.put(string2, l12);
            }
            catch (NumberFormatException numberFormatException) {}
            ++n11;
        }
        return hashMap;
    }

    public static void c(d d10) {
        b = e.e(d10);
    }

    public static void d(String string2, int n10) {
        i i10 = a;
        if (i10 != null) {
            i10.a(string2, n10);
        }
    }

    public static void e(String string2, String string3, String string4, String string5, String string6, String string7, String string8, k k10) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("fileDate", string3);
        hashMap.put("appId", string4);
        hashMap.put("unionId", string5);
        hashMap.put("deviceId", string6);
        hashMap.put("buildVersion", string7);
        hashMap.put("appVersion", string8);
        hashMap.put("platform", "1");
        d.e.a.c.f(string2, string3, hashMap, k10);
    }

    public static void f(String object, String string2, Map stringArray, k k10) {
        Object object2 = b;
        if (object2 != null) {
            object2 = new l();
            ((l)object2).i((String)object);
            ((l)object2).h(k10);
            ((l)object2).g((Map)stringArray);
            object = b;
            stringArray = new String[]{string2};
            ((e)object).f(stringArray, (m)object2);
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }

    public static void g(String[] object, m m10) {
        e e10 = b;
        if (e10 != null) {
            e10.f((String[])object, m10);
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }

    public static void h(boolean bl2) {
        c = bl2;
    }

    public static void i(i i10) {
        a = i10;
    }

    public static void j(String object, int n10) {
        e e10 = b;
        if (e10 != null) {
            e10.g((String)object, n10);
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }
}

