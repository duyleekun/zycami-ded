/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.geetest.sdk.utils.a;
import com.geetest.sdk.utils.b;
import com.geetest.sdk.utils.e;
import com.geetest.sdk.utils.f;
import com.geetest.sdk.utils.j;
import com.geetest.sdk.utils.p;
import com.geetest.sdk.utils.v;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONObject;

public class ar {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context context) {
        String string7;
        String string8;
        float f10;
        String string2;
        int n10;
        CharSequence charSequence2;
        CharSequence charSequence;
        Object object;
        String string3;
        String string4;
        String string5;
        String string6;
        block16: {
            block14: {
                block15: {
                    string6 = "uuid";
                    string5 = "null";
                    string4 = "";
                    string3 = "unknown";
                    object = context.getPackageManager();
                    charSequence = null;
                    try {
                        charSequence2 = context.getPackageName();
                        charSequence2 = object.getPackageInfo((String)charSequence2, 0);
                        n10 = ((PackageInfo)charSequence2).versionCode;
                    }
                    catch (Exception exception) {
                        string2 = string5;
                        charSequence2 = string3;
                        n10 = 0;
                        f10 = 0.0f;
                        break block14;
                    }
                    try {
                        string2 = ((PackageInfo)charSequence2).packageName;
                    }
                    catch (Exception exception) {
                        string2 = string5;
                        break block15;
                    }
                    try {
                        charSequence2 = ((PackageInfo)charSequence2).versionName;
                    }
                    catch (Exception exception) {
                        break block15;
                    }
                    try {
                        string8 = context.getApplicationInfo();
                        object = object.getApplicationLabel((ApplicationInfo)string8);
                        object = (String)object;
                        string5 = object;
                        break block16;
                    }
                    catch (Exception exception) {
                        break block14;
                    }
                }
                charSequence2 = string3;
            }
            object.printStackTrace();
        }
        object = Build.BRAND;
        if (object == null) {
            object = string3;
        }
        string8 = (string8 = Locale.getDefault().getLanguage()) == null ? string3 : Locale.getDefault().getLanguage();
        String string9 = Build.VERSION.RELEASE;
        if (string9 == null) {
            string9 = string3;
        }
        string7 = (string7 = Locale.getDefault().getCountry()) == null ? string3 : Locale.getDefault().getCountry();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int n11 = displayMetrics.widthPixels;
        int n12 = displayMetrics.heightPixels;
        JSONObject jSONObject = new JSONObject();
        String string10 = "build";
        try {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            jSONObject.put(string10, (Object)charSequence);
            charSequence = "release";
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "br";
            charSequence2 = new StringBuilder();
            f10 = j.a(context);
            ((StringBuilder)charSequence2).append(f10);
            ((StringBuilder)charSequence2).append(string4);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "bs";
            charSequence2 = j.b(context);
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "cell";
            charSequence2 = p.b(context);
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "coun";
            jSONObject.put((String)charSequence, (Object)string7);
            charSequence = "dh";
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(n12);
            ((StringBuilder)charSequence2).append(string4);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "dm";
            jSONObject.put((String)charSequence, object);
            object = "dns";
            charSequence = j.b();
            jSONObject.put((String)object, (Object)charSequence);
            object = "dw";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            jSONObject.put((String)object, (Object)charSequence);
            object = "lang";
            jSONObject.put((String)object, (Object)string8);
            object = "mems";
            charSequence = j.a();
            jSONObject.put((String)object, (Object)charSequence);
            object = "ostype";
            charSequence = "android";
            jSONObject.put((String)object, (Object)charSequence);
            object = "osver";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string9);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            jSONObject.put((String)object, (Object)charSequence);
            boolean bl2 = j.c(context);
            charSequence = "py";
            if (bl2) {
                object = "1";
                jSONObject.put((String)charSequence, object);
            } else {
                object = "0";
                jSONObject.put((String)charSequence, object);
            }
            object = "ts";
            charSequence = new StringBuilder();
            long l10 = System.currentTimeMillis();
            ((StringBuilder)charSequence).append(l10);
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            jSONObject.put((String)object, (Object)string4);
            object = "vendor";
            jSONObject.put((String)object, (Object)string2);
            object = "app";
            string4 = "UTF-8";
            string5 = URLEncoder.encode(string5, string4);
            jSONObject.put((String)object, (Object)string5);
            object = "gt3";
            string5 = "4.3.3";
            jSONObject.put((String)object, (Object)string5);
            object = "mydata";
            string4 = null;
            string5 = context;
            object = context.getSharedPreferences((String)object, 0);
            object = object.getString(string6, string3);
            jSONObject.put(string6, object);
            object = "jbd";
            int n13 = b.b(context);
            jSONObject.put((String)object, n13);
            object = "sim";
            n13 = a.a(context);
            jSONObject.put((String)object, n13);
            object = "deb";
            n13 = e.b(context);
            jSONObject.put((String)object, n13);
            object = "tam";
            n13 = v.c(context);
            jSONObject.put((String)object, n13);
            return jSONObject.toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void a(Context object, JSONObject jSONObject) {
        CharSequence charSequence;
        String string2;
        CharSequence charSequence2;
        block6: {
            block5: {
                if (jSONObject == null) {
                    return;
                }
                jSONObject.put("os", (Object)"android");
                charSequence2 = Build.BRAND;
                string2 = "null";
                if (charSequence2 == null) break block5;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                charSequence2 = Build.MODEL;
                ((StringBuilder)charSequence).append((String)charSequence2);
                charSequence = ((StringBuilder)charSequence).toString();
                if (charSequence != null) break block6;
            }
            charSequence2 = string2;
        }
        charSequence = "mo";
        jSONObject.put((String)charSequence, (Object)charSequence2);
        charSequence2 = Build.VERSION.RELEASE;
        if (charSequence2 != null) {
            string2 = charSequence2;
        }
        jSONObject.put("ver", (Object)string2);
        charSequence2 = p.b((Context)object);
        jSONObject.put("net", (Object)charSequence2);
        charSequence2 = new StringBuilder();
        int n10 = f.b((Context)object);
        ((StringBuilder)charSequence2).append(n10);
        string2 = "";
        ((StringBuilder)charSequence2).append(string2);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        jSONObject.put("build", (Object)charSequence2);
        charSequence2 = new StringBuilder();
        int n11 = f.b((Context)object);
        ((StringBuilder)charSequence2).append(n11);
        ((StringBuilder)charSequence2).append(".0");
        charSequence2 = ((StringBuilder)charSequence2).toString();
        jSONObject.put("release", (Object)charSequence2);
        object = f.a((Context)object);
        jSONObject.put("vendor", object);
        object = new StringBuilder();
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        jSONObject.put("time", object);
        jSONObject.put("gt3", (Object)"4.3.3");
    }
}

