/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bf;
import com.xiaomi.push.i;
import com.xiaomi.push.l;
import java.util.HashMap;

public class ac {
    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap a(Context object, String string2) {
        HashMap<Object, Object> hashMap;
        block42: {
            void var1_3;
            int n10;
            Object object2;
            String string3;
            block41: {
                hashMap = new HashMap<Object, Object>();
                string3 = "appToken";
                try {
                    object2 = b.a(object);
                }
                catch (Throwable throwable) {
                    return hashMap;
                }
                object2 = ((b)object2).b();
                hashMap.put(string3, object2);
                string3 = "regId";
                object2 = MiPushClient.getRegId(object);
                hashMap.put(string3, object2);
                string3 = "appId";
                object2 = b.a(object);
                object2 = ((b)object2).a();
                hashMap.put(string3, object2);
                string3 = "regResource";
                object2 = b.a(object);
                object2 = ((b)object2).e();
                hashMap.put(string3, object2);
                boolean bl2 = l.d();
                if (bl2) break block41;
                string3 = i.g(object);
                n10 = TextUtils.isEmpty((CharSequence)string3);
                if (n10 != 0) break block41;
                object2 = "imeiMd5";
                string3 = bf.a(string3);
                hashMap.put(object2, string3);
            }
            string3 = "isMIUI";
            n10 = l.a();
            object2 = String.valueOf(n10 != 0);
            hashMap.put(string3, object2);
            string3 = "miuiVersion";
            object2 = l.a();
            hashMap.put(string3, object2);
            string3 = "devId";
            n10 = 1;
            object2 = i.a(object, n10 != 0);
            hashMap.put(string3, object2);
            string3 = "model";
            object2 = Build.MODEL;
            hashMap.put(string3, object2);
            string3 = "pkgName";
            object2 = object.getPackageName();
            hashMap.put(string3, object2);
            string3 = "sdkVersion";
            object2 = "3_7_5";
            hashMap.put(string3, object2);
            string3 = "androidVersion";
            n10 = Build.VERSION.SDK_INT;
            object2 = String.valueOf(n10);
            hashMap.put(string3, object2);
            string3 = "os";
            object2 = new StringBuilder();
            String string4 = Build.VERSION.RELEASE;
            ((StringBuilder)object2).append(string4);
            string4 = "-";
            ((StringBuilder)object2).append(string4);
            string4 = Build.VERSION.INCREMENTAL;
            ((StringBuilder)object2).append(string4);
            object2 = ((StringBuilder)object2).toString();
            hashMap.put(string3, object2);
            string3 = "andId";
            String string5 = i.e(object);
            hashMap.put(string3, string5);
            boolean bl3 = TextUtils.isEmpty((CharSequence)var1_3);
            if (bl3) break block42;
            String string6 = "clientInterfaceId";
            hashMap.put(string6, var1_3);
        }
        return hashMap;
    }
}

