/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$Style
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.media.AudioManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.widget.RemoteViews
 */
package d.r.a.u;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import d.r.a.h$q;
import d.r.a.i.l$b;
import d.r.a.l;
import d.r.a.o;
import d.r.a.u.a;
import d.r.a.u.a0;
import d.r.a.u.e;
import d.r.a.u.f;
import d.r.a.u.g;
import d.r.a.u.s;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class d {
    public static final String a = "vivo_push_channel";
    public static final int b = 0;
    public static final int c = 1;
    private static final String d = "NotifyManager";
    private static final String e = "\u63a8\u9001\u901a\u77e5";
    private static final String f = "PUSH";
    private static final int g = 1;
    private static int h = 20000000;
    private static NotificationManager i;

    public static void a(Context context) {
        int n10 = h;
        d.r.a.u.d.b(context, n10);
    }

    private static boolean b(Context context, int n10) {
        d.r.a.u.d.c(context);
        context = i;
        if (context != null) {
            context.cancel(n10);
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void c(Context object) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            NotificationManager notificationManager;
            int n10;
            int n11;
            NotificationManager notificationManager2 = i;
            if (notificationManager2 == null) {
                NotificationManager notificationManager3;
                String string2 = "notification";
                Object object2 = object.getSystemService(string2);
                i = notificationManager3 = (NotificationManager)object2;
            }
            if ((n11 = Build.VERSION.SDK_INT) >= (n10 = 26) && (notificationManager = i) != null) {
                void var0_3;
                int n12;
                CharSequence charSequence;
                String string3;
                int n13;
                String string4 = "default";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(string4);
                if (notificationChannel != null && ((n13 = (string3 = e).equals(charSequence = notificationChannel.getName())) != 0 || (n11 = (int)((string3 = f).equals(charSequence) ? 1 : 0)) != 0)) {
                    NotificationManager notificationManager4 = i;
                    notificationManager4.deleteNotificationChannel(string4);
                }
                if ((n12 = d.r.a.u.d.d(object)) != 0) {
                    String string5 = e;
                } else {
                    String string6 = f;
                }
                string4 = a;
                n13 = 4;
                NotificationChannel notificationChannel2 = new NotificationChannel(string4, (CharSequence)var0_3, n13);
                n12 = -16711936;
                notificationChannel2.setLightColor(n12);
                n12 = 1;
                notificationChannel2.enableVibration(n12 != 0);
                notificationChannel2.setLockscreenVisibility(n12);
                NotificationManager notificationManager5 = i;
                notificationManager5.createNotificationChannel(notificationChannel2);
            }
            return;
        }
    }

    private static boolean d(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void e(Context context, List list, d.r.a.r.a a10, long l10, int n10, l$b l$b) {
        s.m(d, "pushNotification");
        d.r.a.u.d.c(context);
        a a11 = d.r.a.u.e.a(context);
        int n11 = a11.d(a10);
        Object object = a10.l();
        int n12 = TextUtils.isEmpty((CharSequence)object);
        int n13 = 1;
        if (n12 == 0 && list != null && (n12 = list.size()) > n13 && (object = list.get(n13)) != null) {
            n11 = n13;
        }
        if (n11 == (n12 = 2)) {
            d.r.a.u.d.g(context, list, a10, l10, n10, l$b);
            return;
        }
        if (n11 == n13) {
            a11 = context;
            object = list;
            d.r.a.u.d.f(context, list, a10, l10, l$b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void f(Context context, List list, d.r.a.r.a a10, long l10, l$b l$b) {
        Exception exception2;
        int n10;
        int n11;
        Notification.Builder builder;
        Object object;
        int n12;
        Object object2;
        String string2;
        Object object3;
        long l11;
        Object object4;
        Object object5;
        block32: {
            int n13;
            block30: {
                int n14;
                block31: {
                    int n15;
                    Object object6;
                    String string3;
                    object5 = context;
                    object4 = list;
                    l11 = l10;
                    object3 = context.getResources();
                    string2 = context.getPackageName();
                    object2 = a10.p();
                    a a11 = d.r.a.u.e.a(context);
                    n12 = a11.c();
                    object = context.getApplicationInfo().icon;
                    int n16 = (Integer)object;
                    n13 = Build.VERSION.SDK_INT;
                    int n17 = 26;
                    if (n13 >= n17) {
                        string3 = a;
                        builder = new Notification.Builder(context, string3);
                        if (n12 > 0) {
                            string3 = new Bundle();
                            object6 = "vivo.summaryIconRes";
                            string3.putInt((String)object6, n12);
                            builder.setExtras((Bundle)string3);
                        }
                        builder = builder.build();
                    } else {
                        builder = new Notification();
                    }
                    builder.priority = n15 = 2;
                    builder.flags = n14 = 16;
                    builder.tickerText = object2;
                    a a12 = d.r.a.u.e.a(context);
                    int n18 = a12.b();
                    if (n18 <= 0) {
                        n18 = n16;
                    }
                    builder.icon = n18;
                    int n19 = d.r.a.u.e.b(context).b();
                    a12 = new RemoteViews(string2, n19);
                    Object object7 = "notify_title";
                    String string4 = "id";
                    n15 = object3.getIdentifier((String)object7, string4, string2);
                    a12.setTextViewText(n15, (CharSequence)object2);
                    int n20 = object3.getIdentifier((String)object7, string4, string2);
                    n15 = d.r.a.u.e.b(context).c();
                    a12.setTextColor(n20, n15);
                    object2 = "notify_msg";
                    n20 = object3.getIdentifier((String)object2, string4, string2);
                    string3 = a10.e();
                    a12.setTextViewText(n20, string3);
                    n20 = (int)(a10.s() ? 1 : 0);
                    string3 = "notify_when";
                    if (n20 != 0) {
                        object7 = Locale.CHINA;
                        object2 = new SimpleDateFormat("HH:mm", (Locale)object7);
                        object6 = new Date();
                        object2 = ((DateFormat)object2).format((Date)object6);
                        n14 = object3.getIdentifier(string3, string4, string2);
                        a12.setTextViewText(n14, (CharSequence)object2);
                        n20 = object3.getIdentifier(string3, string4, string2);
                        n14 = 0;
                        object6 = null;
                        a12.setViewVisibility(n20, 0);
                    } else {
                        n14 = 0;
                        object6 = null;
                        n20 = object3.getIdentifier(string3, string4, string2);
                        n15 = 8;
                        a12.setViewVisibility(n20, n15);
                    }
                    object2 = d.r.a.u.e.b(context);
                    n20 = object2.d();
                    a12.setViewVisibility(n20, 0);
                    if (object4 != null && (n15 = (int)(list.isEmpty() ? 1 : 0)) == 0 && (string3 = (Bitmap)object4.get(0)) != null) {
                        a12.setImageViewBitmap(n20, (Bitmap)string3);
                    } else {
                        if (n12 <= 0) {
                            n12 = n16;
                        }
                        a12.setImageViewResource(n20, n12);
                    }
                    n20 = 0;
                    object2 = null;
                    n12 = 1;
                    if (object4 != null && (n16 = list.size()) > n12) {
                        object2 = object4 = object4.get(n12);
                        object2 = (Bitmap)object4;
                    }
                    object4 = "notify_cover";
                    if (object2 != null) {
                        object = a10.l();
                        n16 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                        if (n16 == 0) {
                            object = "notify_content";
                            n16 = object3.getIdentifier((String)object, string4, string2);
                            n15 = 8;
                            a12.setViewVisibility(n16, n15);
                            n11 = object3.getIdentifier((String)object4, string4, string2);
                            a12.setViewVisibility(n11, n15);
                            object4 = "notify_pure_cover";
                            n16 = object3.getIdentifier((String)object4, string4, string2);
                            n15 = 0;
                            string3 = null;
                            a12.setViewVisibility(n16, 0);
                            n11 = object3.getIdentifier((String)object4, string4, string2);
                            a12.setImageViewBitmap(n11, (Bitmap)object2);
                        } else {
                            n15 = 0;
                            string3 = null;
                            n16 = object3.getIdentifier((String)object4, string4, string2);
                            a12.setViewVisibility(n16, 0);
                            n11 = object3.getIdentifier((String)object4, string4, string2);
                            a12.setImageViewBitmap(n11, (Bitmap)object2);
                        }
                    } else {
                        n11 = object3.getIdentifier((String)object4, string4, string2);
                        n10 = 8;
                        a12.setViewVisibility(n11, n10);
                    }
                    builder.contentView = a12;
                    n11 = 16;
                    if (n13 >= n11 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object4 = a10.l())) ? 1 : 0)) != 0) {
                        builder.bigContentView = a12;
                    }
                    object4 = (AudioManager)object5.getSystemService("audio");
                    n10 = object4.getRingerMode();
                    n11 = object4.getVibrateSetting(0);
                    object2 = new StringBuilder("ringMode=");
                    ((StringBuilder)object2).append(n10);
                    ((StringBuilder)object2).append(" callVibrateSetting=");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object = d;
                    s.m((String)object, (String)object2);
                    n20 = a10.j();
                    n13 = 2;
                    if (n20 == n13) break block30;
                    n15 = 3;
                    n14 = 4;
                    if (n20 == n15) break block31;
                    if (n20 == n14) {
                        if (n10 == n13) {
                            builder.defaults = n12;
                        }
                        if (n11 == n12) {
                            builder.defaults = n11 = builder.defaults | n13;
                            Object object8 = object4 = (Object)new long[n14];
                            object8[0] = 0L;
                            object8[1] = (long)100;
                            object8[2] = 200L;
                            object8[3] = 300L;
                            builder.vibrate = (long[])object4;
                        }
                    }
                    break block32;
                }
                if (n11 == n12) {
                    builder.defaults = n13;
                    Object object9 = object4 = (Object)new long[n14];
                    object9[0] = 0L;
                    object9[1] = (long)100;
                    object9[2] = 200L;
                    object9[3] = 300L;
                    builder.vibrate = (long[])object4;
                }
                break block32;
            }
            if (n10 == n13) {
                builder.defaults = n12;
            }
        }
        object4 = new Intent("com.vivo.pushservice.action.RECEIVE");
        object3 = context.getPackageName();
        object4.setPackage((String)object3);
        object3 = context.getPackageName();
        object4.setClassName((String)object3, "com.vivo.push.sdk.service.CommandService");
        object4.putExtra("command_type", "reflect_receiver");
        object2 = a10;
        object3 = new h$q(string2, l11, a10);
        ((o)object3).a((Intent)object4);
        long l12 = SystemClock.uptimeMillis();
        n10 = (int)l12;
        int n21 = 0x10000000;
        object5 = PendingIntent.getService((Context)object5, (int)n10, (Intent)object4, (int)n21);
        builder.contentIntent = object5;
        object5 = i;
        if (object5 == null) return;
        object5 = l.b();
        int n22 = object5.r;
        if (n22 == 0) {
            try {
                object5 = i;
                n11 = h;
                object5.notify(n11, (Notification)builder);
                if (l$b == null) return;
                l$b.a();
                return;
            }
            catch (Exception exception2) {}
        } else {
            if (n22 == n12) {
                object5 = i;
                n11 = (int)l11;
                object5.notify(n11, (Notification)builder);
                if (l$b == null) return;
                l$b.a();
                return;
            } else {
                String string5 = "unknow notify style ";
                object4 = new StringBuilder(string5);
                ((StringBuilder)object4).append(n22);
                object5 = ((StringBuilder)object4).toString();
                s.a((String)object, (String)object5);
            }
            return;
        }
        s.c((String)object, exception2);
        if (l$b == null) return;
        l$b.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void g(Context context, List list, d.r.a.r.a a10, long l10, int n10, l$b l$b) {
        Exception exception2;
        Object object;
        List list2;
        int n11;
        int n12;
        Object object2;
        Object object3;
        String string2;
        long l11;
        Object object4;
        Object object5;
        block31: {
            int n13;
            block29: {
                int n14;
                Object object6;
                block30: {
                    int n15;
                    Bitmap bitmap;
                    int n16;
                    object5 = context;
                    object4 = list;
                    l11 = l10;
                    string2 = context.getPackageName();
                    object3 = a10.p();
                    object2 = a10.e();
                    object6 = context.getApplicationInfo().icon;
                    n12 = (Integer)object6;
                    n13 = a10.s();
                    AudioManager audioManager = (AudioManager)context.getSystemService("audio");
                    a a11 = d.r.a.u.e.a(context);
                    n11 = a11.c();
                    list2 = null;
                    if (list != null && (n16 = list.isEmpty()) == 0) {
                        n16 = 0;
                        bitmap = (Bitmap)list.get(0);
                        if (bitmap != null && n11 > 0 && (object = BitmapFactory.decodeResource((Resources)context.getResources(), (int)n11)) != null) {
                            n14 = object.getWidth();
                            int n17 = object.getHeight();
                            object.recycle();
                            bitmap = d.r.a.u.g.a(bitmap, n14, n17);
                        }
                    } else {
                        n16 = 0;
                        bitmap = null;
                    }
                    if ((n15 = Build.VERSION.SDK_INT) >= (n14 = 26)) {
                        String string3 = a;
                        object = new Notification.Builder((Context)object5, string3);
                        if (n11 > 0) {
                            string3 = new Bundle();
                            String string4 = "vivo.summaryIconRes";
                            string3.putInt(string4, n11);
                            object.setExtras((Bundle)string3);
                        }
                        if (bitmap != null) {
                            object.setLargeIcon(bitmap);
                        }
                    } else {
                        a11 = new Notification.Builder((Context)object5);
                        if (bitmap != null) {
                            a11.setLargeIcon(bitmap);
                        } else {
                            n16 = 22;
                            if (n15 <= n16) {
                                bitmap = BitmapFactory.decodeResource((Resources)context.getResources(), (int)n12);
                                a11.setLargeIcon(bitmap);
                            }
                        }
                        object = a11;
                    }
                    if ((n11 = (a11 = d.r.a.u.e.a(context)).b()) > 0) {
                        n12 = n11;
                    }
                    object.setSmallIcon(n12);
                    n12 = a10.d();
                    n11 = 1;
                    if (n12 != n11) {
                        object.setContentTitle((CharSequence)object3);
                    }
                    n12 = 2;
                    object.setPriority(n12);
                    object.setContentText((CharSequence)object2);
                    long l12 = n13 != 0 ? System.currentTimeMillis() : 0L;
                    object.setWhen(l12);
                    object.setShowWhen(n13 != 0);
                    object.setTicker((CharSequence)object3);
                    n13 = audioManager.getRingerMode();
                    int n18 = a10.j();
                    if (n18 == n12) break block29;
                    n16 = 3;
                    n14 = 4;
                    if (n18 == n16) break block30;
                    if (n18 == n14) {
                        if (n13 == n12) {
                            object.setDefaults(n16);
                            Object object7 = object6 = (Object)new long[n14];
                            object7[0] = 0L;
                            object7[1] = (long)100;
                            object7[2] = 200L;
                            object7[3] = 300L;
                            object.setVibrate((long[])object6);
                            break block31;
                        } else if (n13 == n11) {
                            object.setDefaults(n12);
                            Object object8 = object6 = (Object)new long[n14];
                            object8[0] = 0L;
                            object8[1] = (long)100;
                            object8[2] = 200L;
                            object8[3] = 300L;
                            object.setVibrate((long[])object6);
                        }
                    }
                    break block31;
                }
                if (n13 == n12) {
                    object.setDefaults(n12);
                    Object object9 = object6 = (Object)new long[n14];
                    object9[0] = 0L;
                    object9[1] = (long)100;
                    object9[2] = 200L;
                    object9[3] = 300L;
                    object.setVibrate((long[])object6);
                }
                break block31;
            }
            if (n13 == n12) {
                object.setDefaults(n11);
            }
        }
        if (object4 != null && (n12 = list.size()) > n11) {
            object4 = object4.get(n11);
            list2 = object4;
            list2 = (Bitmap)object4;
        }
        int n19 = n10;
        if (n10 != n11 && list2 != null) {
            object4 = new Notification.BigPictureStyle();
            object4.setBigContentTitle((CharSequence)object3);
            object4.setSummaryText((CharSequence)object2);
            object4.bigPicture((Bitmap)list2);
            object.setStyle((Notification.Style)object4);
        }
        object.setAutoCancel(n11 != 0);
        object4 = new Intent("com.vivo.pushservice.action.RECEIVE");
        object3 = context.getPackageName();
        object4.setPackage((String)object3);
        object3 = context.getPackageName();
        object4.setClassName((String)object3, "com.vivo.push.sdk.service.CommandService");
        object4.putExtra("command_type", "reflect_receiver");
        object2 = a10;
        object3 = new h$q(string2, l11, a10);
        ((o)object3).a((Intent)object4);
        long l13 = SystemClock.uptimeMillis();
        int n20 = (int)l13;
        int n21 = 0x10000000;
        object5 = PendingIntent.getService((Context)object5, (int)n20, (Intent)object4, (int)n21);
        object.setContentIntent((PendingIntent)object5);
        object5 = object.build();
        object4 = l.b();
        n19 = ((l)object4).r;
        string2 = i;
        if (string2 == null) return;
        object3 = d;
        if (n19 == 0) {
            try {
                n19 = h;
                string2.notify(n19, (Notification)object5);
                if (l$b == null) return;
                l$b.a();
                return;
            }
            catch (Exception exception2) {}
        } else {
            if (n19 == n11) {
                n19 = (int)l11;
                string2.notify(n19, (Notification)object5);
                if (l$b == null) return;
                l$b.a();
                return;
            } else {
                String string5 = "unknow notify style ";
                object5 = new StringBuilder(string5);
                ((StringBuilder)object5).append(n19);
                object5 = ((StringBuilder)object5).toString();
                s.a((String)object3, (String)object5);
            }
            return;
        }
        s.c((String)object3, exception2);
        if (l$b == null) return;
        l$b.b();
    }

    public static boolean h(Context object, long l10) {
        Object object2 = l.b();
        int n10 = ((l)object2).r;
        String string2 = d;
        if (n10 == 0) {
            String string3;
            object2 = a0.m();
            long l11 = ((f)object2).i(string3 = "com.vivo.push.notify_key", -1);
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 == 0) {
                object2 = new StringBuilder("undo showed message ");
                ((StringBuilder)object2).append(l10);
                object2 = ((StringBuilder)object2).toString();
                s.m(string2, (String)object2);
                object2 = new StringBuilder("\u56de\u6536\u5df2\u5c55\u793a\u7684\u901a\u77e5\uff1a ");
                ((StringBuilder)object2).append(l10);
                String string4 = ((StringBuilder)object2).toString();
                s.e((Context)object, string4);
                int n11 = h;
                return d.r.a.u.d.b((Context)object, n11);
            }
            object2 = new StringBuilder("current showing message id ");
            ((StringBuilder)object2).append(l11);
            ((StringBuilder)object2).append(" not match ");
            ((StringBuilder)object2).append(l10);
            object2 = ((StringBuilder)object2).toString();
            s.m(string2, (String)object2);
            object2 = new StringBuilder("\u4e0e\u5df2\u5c55\u793a\u7684\u901a\u77e5");
            ((StringBuilder)object2).append(l11);
            ((StringBuilder)object2).append("\u4e0e\u5f85\u56de\u6536\u7684\u901a\u77e5");
            ((StringBuilder)object2).append(l10);
            ((StringBuilder)object2).append("\u4e0d\u5339\u914d");
            String string5 = ((StringBuilder)object2).toString();
            s.e((Context)object, string5);
            return false;
        }
        int n12 = 1;
        if (n10 == n12) {
            int n13 = (int)l10;
            return d.r.a.u.d.b((Context)object, n13);
        }
        object = new StringBuilder("unknow cancle notify style ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        s.a(string2, (String)object);
        return false;
    }

    public static void i(int n10) {
        h = n10;
    }
}

