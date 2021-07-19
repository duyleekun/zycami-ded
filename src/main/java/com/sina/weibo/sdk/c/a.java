/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.c.a$a;
import com.sina.weibo.sdk.c.d;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean a(Context signatureArray, Intent object) {
        int n10;
        int n11;
        block12: {
            if (signatureArray == null) {
                return false;
            }
            if ((signatureArray = signatureArray.getPackageManager()) == null) {
                return false;
            }
            if ((object = signatureArray.resolveActivity(object, 0)) == null) {
                return false;
            }
            object = object.activityInfo.packageName;
            n11 = 64;
            signatureArray = signatureArray.getPackageInfo((String)object, n11);
            signatureArray = signatureArray.signatures;
            if (signatureArray != null) break block12;
            return false;
        }
        try {
            n10 = signatureArray.length;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return false;
        }
        for (n11 = 0; n11 < n10; ++n11) {
            Object object2 = signatureArray[n11];
            object2 = object2.toByteArray();
            object2 = d.a((byte[])object2);
            String string2 = "18da2bf10352443a00a5e046d9fca6bd";
            boolean bl2 = string2.equals(object2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static a$a c(Context context) {
        Object object = new Intent("com.sina.weibo.action.sdkidentity");
        object.addCategory("android.intent.category.DEFAULT");
        Object object2 = null;
        if (context != null) {
            boolean bl2;
            Object object3 = context.getPackageManager();
            boolean bl3 = false;
            Object object4 = null;
            if ((object = object3.queryIntentServices((Intent)object, 0)) != null && !(bl2 = object.isEmpty())) {
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    ApplicationInfo applicationInfo;
                    object3 = (ResolveInfo)object.next();
                    object4 = object3.serviceInfo;
                    if (object4 == null || (applicationInfo = ((ServiceInfo)object4).applicationInfo) == null || (bl3 = TextUtils.isEmpty((CharSequence)(object4 = ((ServiceInfo)object4).packageName)))) continue;
                    object3 = object3.serviceInfo.packageName;
                    object4 = a.d(context, (String)object3);
                    if (object4 != null) {
                        object2 = object4;
                    }
                    if (!(bl3 = ((String)(object4 = "com.sina.weibo")).equals(object3)) && !(bl2 = ((String)(object4 = "com.sina.weibog3")).equals(object3))) continue;
                }
            }
        }
        return object2;
    }

    private static a$a d(Context object, String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            return null;
        }
        n11 = 2;
        object = object.createPackageContext(string2, n11);
        object = object.getAssets();
        Object object2 = "weibo_for_sdk.json";
        object = object.open((String)object2);
        object2 = new StringBuilder();
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while (true) {
            int n13 = ((InputStream)object).read(byArray, 0, n12);
            n10 = -1;
            if (n13 == n10) break;
            String string3 = new String(byArray, 0, n13);
            ((StringBuilder)object2).append(string3);
            continue;
            break;
        }
        object2 = ((StringBuilder)object2).toString();
        object = new JSONObject((String)object2);
        object2 = new a$a();
        String string4 = "support_api";
        n12 = object.optInt(string4, n10);
        ((a$a)object2).am = n12;
        string4 = "authActivityName";
        object = object.optString(string4, null);
        ((a$a)object2).al = object;
        try {
            ((a$a)object2).packageName = string2;
            return object2;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
        }
        return null;
    }
}

