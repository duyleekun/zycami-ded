/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$Style
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;
import com.huawei.hms.push.k;
import com.huawei.hms.push.n;

public class m {
    public static n a(k k10) {
        n[] nArray;
        int n10;
        Object object = n.a;
        int n11 = k10.w();
        if (n11 >= 0 && (n11 = k10.w()) < (n10 = (nArray = n.values()).length)) {
            object = n.values();
            int n12 = k10.w();
            object = object[n12];
        }
        return object;
    }

    public static void a(Notification.Builder builder, String string2, k object) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        String string3 = ((k)object).h();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            object = ((k)object).h();
            bigTextStyle.setBigContentTitle((CharSequence)object);
        }
        boolean bl3 = false;
        object = null;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = null;
        }
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            bigTextStyle.bigText((CharSequence)string2);
        }
        builder.setStyle((Notification.Style)bigTextStyle);
    }
}

