/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.geetest.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.geetest.sdk.ad;
import com.geetest.sdk.ae;
import com.geetest.sdk.aj;
import com.geetest.sdk.am;
import com.geetest.sdk.an;
import com.geetest.sdk.ao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ac {
    private static aj a;
    private static ae b;
    public static boolean c = false;

    public static void a() {
        Object object = b;
        if (object != null) {
            ((ae)object).a();
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
    public static void a(Context object, String string2, String string3, String string4, String string5, am am2) {
        Object object2;
        Object object3;
        HashMap<String, Object> hashMap;
        String string6;
        block5: {
            block4: {
                string6 = "";
                hashMap = new HashMap<String, Object>();
                try {
                    object3 = object.getPackageManager();
                    object = object.getPackageName();
                    object2 = null;
                    object = object3.getPackageInfo((String)object, 0);
                    object3 = ((PackageInfo)object).versionName;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object3 = string6;
                    break block4;
                }
                try {
                    int n10 = ((PackageInfo)object).versionCode;
                    string6 = String.valueOf(n10);
                    break block5;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            }
            object.printStackTrace();
        }
        object = new SimpleDateFormat("yyyy-MM-dd");
        long l10 = System.currentTimeMillis();
        object2 = new Date(l10);
        object = ((DateFormat)object).format((Date)object2);
        object2 = String.valueOf(System.currentTimeMillis());
        hashMap.put("fileDate", object2);
        hashMap.put("appId", string3);
        hashMap.put("unionId", string4);
        hashMap.put("deviceId", string5);
        hashMap.put("buildVersion", string6);
        hashMap.put("appVersion", object3);
        hashMap.put("platform", "1");
        hashMap.put("X-AUTH-KEY", "191254678");
        ac.a(string2, (String)object, hashMap, am2);
    }

    public static void a(ad ad2) {
        b = ae.a(ad2);
    }

    public static void a(aj aj2) {
        a = aj2;
    }

    public static void a(String string2, int n10) {
        aj aj2 = a;
        if (aj2 != null) {
            aj2.a(string2, n10);
        }
    }

    private static void a(String object, String string2, Map stringArray, am am2) {
        Object object2 = b;
        if (object2 != null) {
            object2 = new an();
            ((an)object2).a((String)object);
            ((an)object2).a(am2);
            ((an)object2).a((Map)stringArray);
            object = b;
            stringArray = new String[]{string2};
            ((ae)object).a(stringArray, (ao)object2);
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }

    public static void a(boolean bl2) {
        c = bl2;
    }

    public static void b(String object, int n10) {
        ae ae2 = b;
        if (ae2 != null) {
            ae2.a((String)object, n10);
            return;
        }
        object = new RuntimeException("Please initialize Logan first");
        throw object;
    }
}

