/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package com.heytap.mcssdk.b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.heytap.mcssdk.b.a$1;
import com.heytap.mcssdk.f.f;

public class a {
    private static final String a = "Heytap PUSH";
    private static final String b = "System Default Channel";
    private static final int c = 3;

    private boolean a(Context context, String string2, String string3, int n10) {
        NotificationChannel notificationChannel = null;
        if (context == null) {
            return false;
        }
        String string4 = "notification";
        if ((context = (NotificationManager)context.getSystemService(string4)) == null) {
            return false;
        }
        notificationChannel = new NotificationChannel(string2, (CharSequence)string3, n10);
        context.createNotificationChannel(notificationChannel);
        return true;
    }

    public static /* synthetic */ boolean a(a a10, Context context, String string2, String string3, int n10) {
        return a10.a(context, string2, string3, n10);
    }

    public void a(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return;
        }
        a$1 a$1 = new a$1(this, context);
        f.a(a$1);
    }
}

