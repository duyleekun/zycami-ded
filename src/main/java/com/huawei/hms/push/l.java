/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Builder
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.push.k;
import com.huawei.hms.push.r;
import com.huawei.hms.support.log.HMSLog;

public class l {
    public static int a(Context object) {
        Object object2 = object.getApplicationInfo();
        int n10 = object2.icon;
        if (n10 == 0) {
            object = object.getResources();
            object2 = "btn_star_big_on";
            String string2 = "android";
            n10 = object.getIdentifier((String)object2, "drawable", string2);
            object = "PushSelfShowLog";
            String string3 = "icon is btn_star_big_on ";
            HMSLog.d((String)object, string3);
            if (n10 == 0) {
                n10 = 17301651;
                string3 = "icon is sym_def_app_icon ";
                HMSLog.d((String)object, string3);
            }
        }
        return n10;
    }

    public static Bitmap a(Context object, k object2) {
        Bitmap bitmap;
        block17: {
            String string2 = "";
            String string3 = "PushSelfShowLog";
            bitmap = null;
            if (object != null && object2 != null) {
                int n10;
                block16: {
                    n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
                    int n11 = 11;
                    if (n10 < n11) break block16;
                    object = "huawei phone, and emui5.0, need not show large icon.";
                    HMSLog.i(string3, (String)object);
                    return null;
                }
                CharSequence charSequence = "com.huawei.android.pushagent";
                String string4 = ((k)object2).k();
                n10 = (int)(((String)charSequence).equals(string4) ? 1 : 0);
                if (n10 != 0) break block17;
                charSequence = new StringBuilder();
                string4 = "get left bitmap from ";
                ((StringBuilder)charSequence).append(string4);
                string4 = ((k)object2).k();
                ((StringBuilder)charSequence).append(string4);
                charSequence = ((StringBuilder)charSequence).toString();
                HMSLog.i(string3, (String)charSequence);
                object = object.getPackageManager();
                object2 = ((k)object2).k();
                object = object.getApplicationIcon((String)object2);
                object = (BitmapDrawable)object;
                try {
                    bitmap = object.getBitmap();
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    string2 = exception.toString();
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string3, (String)object2, exception);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    string2 = nameNotFoundException.toString();
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string3, (String)object2, nameNotFoundException);
                }
            }
        }
        return bitmap;
    }

    public static void a(Context context, Notification.Builder builder, k k10) {
        if (context != null && builder != null && k10 != null) {
            int n10 = l.b(context, k10);
            builder.setSmallIcon(n10);
            return;
        }
        HMSLog.e("PushSelfShowLog", "msg is null");
    }

    public static int b(Context context, k object) {
        int n10 = 0;
        String string2 = null;
        if (context != null && object != null) {
            String string3 = object.m();
            int n11 = TextUtils.isEmpty((CharSequence)string3);
            if (n11 == 0) {
                int n12;
                object = object.m();
                string3 = "/";
                n11 = ((String[])(object = object.split(string3))).length;
                if (n11 == (n12 = 3)) {
                    string2 = object[1];
                    n11 = 2;
                    object = object[n11];
                    n10 = r.a(context, string2, (String)object);
                }
            }
            if (n10 == 0) {
                object = "com.huawei.messaging.default_notification_icon";
                n10 = r.a(context, (String)object);
            }
            if (n10 == 0) {
                n10 = l.a(context);
            }
            return n10;
        }
        HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }
}

