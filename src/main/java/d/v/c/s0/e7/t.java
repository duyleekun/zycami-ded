/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 *  d.v.e.l.h1
 */
package d.v.c.s0.e7;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat$Builder;
import d.v.e.l.d1;
import d.v.e.l.h1;
import d.v.e.l.h2;
import d.v.f.i.g;

public class t {
    private static final String a = "NOTIFICATION_CHANNEL_ID_RECORD";
    public static final int b = 16521;

    /*
     * WARNING - void declaration
     */
    public static Notification a(Context object, boolean bl2) {
        void var1_4;
        t.b((Context)object);
        Bitmap bitmap = t.d((Context)object);
        int n10 = 2131951754;
        String string2 = g.m((Context)object, n10);
        if (bl2) {
            int n11 = 2131952451;
        } else {
            int n12 = 2131952446;
        }
        String string3 = g.m((Context)object, (int)var1_4);
        String string4 = d1.d();
        RemoteViews remoteViews = new RemoteViews(string4, 2131558663);
        remoteViews.setTextViewText(2131362950, (CharSequence)string2);
        remoteViews.setTextViewText(2131362946, (CharSequence)string3);
        remoteViews.setImageViewBitmap(2131362947, bitmap);
        string4 = t.e((Context)object);
        string4 = PendingIntent.getActivity((Context)object, (int)0, (Intent)string4, (int)0x8000000);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder((Context)object, a);
        object = notificationCompat$Builder.setSmallIcon(2131231736).setLargeIcon(bitmap).setContentTitle(string2).setContentText(string3);
        long l10 = System.currentTimeMillis();
        return ((NotificationCompat$Builder)object).setWhen(l10).setAutoCancel(false).setPriority(0).setCustomContentView(remoteViews).setContentIntent((PendingIntent)string4).build();
    }

    private static void b(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return;
        }
        Object object = g.m(context, 2131951754);
        n11 = 3;
        String string2 = a;
        NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)object, n11);
        notificationChannel.setDescription("Description");
        n10 = 0;
        notificationChannel.setShowBadge(false);
        object = NotificationManager.class;
        context = (NotificationManager)context.getSystemService((Class)object);
        if (context != null) {
            context.createNotificationChannel(notificationChannel);
        }
    }

    public static void c(Context context) {
        ((NotificationManager)context.getSystemService("notification")).cancel(16521);
    }

    private static Bitmap d(Context context) {
        context = context.getResources();
        int n10 = 2131231735;
        int n11 = 0;
        if ((context = BitmapFactory.decodeResource((Resources)context, (int)n10, null)) == null) {
            return null;
        }
        n10 = context.getWidth();
        n11 = context.getHeight();
        float f10 = h2.b(9.0f);
        return h1.k((int)n10, (int)n11, (Bitmap)context, (float)f10);
    }

    private static Intent e(Context context) {
        context = context.getPackageManager();
        String string2 = d1.d();
        if ((context = context.getLaunchIntentForPackage(string2)) != null) {
            int n10 = 0x10200000;
            context.addFlags(n10);
        }
        return context;
    }
}

