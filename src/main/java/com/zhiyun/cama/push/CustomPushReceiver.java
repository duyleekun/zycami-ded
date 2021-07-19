/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.zhiyun.cama.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.push.CustomPushReceiver$a;
import com.zhiyun.cama.push.CustomPushReceiver$b;
import com.zhiyun.cama.push.PushEntity;
import com.zhiyun.cama.push.PushEntity$Alert;
import com.zhiyun.cama.push.PushEntity$MsgInfo;
import com.zhiyun.cama.push.PushEntity$PushType;
import com.zhiyun.image.Images;
import d.v.a.f.c.b;
import d.v.c.v0.f;
import d.v.e.l.q2.c;
import d.v.f.i.g;

public class CustomPushReceiver
extends BroadcastReceiver {
    public static final String a = "com.zhiyun.zyplay";
    public static final String b = "com.avos.avoscloud.Data";
    public static final String c = "Lightollector";
    private static Class d;

    public static /* synthetic */ void a(CustomPushReceiver customPushReceiver, Context context, String string2, String string3, String string4, int n10, String string5, Bitmap bitmap, PendingIntent pendingIntent) {
        customPushReceiver.f(context, string2, string3, string4, n10, string5, bitmap, pendingIntent);
    }

    private void b(Context context, String string2, String string3, int n10) {
        NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)string3, n10);
        string2 = "notification";
        if ((context = (NotificationManager)context.getSystemService(string2)) != null) {
            context.createNotificationChannel(notificationChannel);
        }
    }

    private void c(Context context, PushEntity pushEntity) {
        int n10;
        int n11;
        int n12;
        int n13;
        Object object;
        String string2;
        Context context2 = context;
        Object object2 = pushEntity;
        if (pushEntity == null) {
            return;
        }
        Object object3 = f.a();
        Object object4 = pushEntity.getAlert();
        Object object5 = "";
        if (object4 != null) {
            string2 = ((PushEntity$Alert)object4).getTitle();
            object4 = ((PushEntity$Alert)object4).getBody();
        } else {
            object4 = pushEntity.getDescription();
            if (object4 != null) {
                object4 = pushEntity.getDescription();
                string2 = ((PushEntity$Alert)object4).getTitle();
                object = ((PushEntity$Alert)object4).getBody();
                pushEntity.setAlert((PushEntity$Alert)object4);
                object4 = object;
            } else {
                object4 = object5;
                string2 = object5;
            }
        }
        String string3 = pushEntity.getBadge();
        object = pushEntity.getMsgInfo();
        if (object == null) {
            return;
        }
        int n14 = -1;
        object2 = ((PushEntity$MsgInfo)object).getNotifyId();
        try {
            n12 = n13 = Integer.parseInt((String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n12 = n14;
        }
        object2 = ((PushEntity$MsgInfo)object).getType_id();
        try {
            n11 = n13 = Integer.parseInt((String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n11 = n14;
        }
        object2 = ((PushEntity$MsgInfo)object).getObjectId();
        try {
            n14 = Integer.parseInt((String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object2 = ((PushEntity$MsgInfo)object).getCreateAt();
        Object object6 = PushEntity$PushType.fromTypeName(((PushEntity$MsgInfo)object).getType());
        if (object6 == null) {
            return;
        }
        Object object7 = CustomPushReceiver$b.a;
        int n15 = object6.ordinal();
        n15 = object7[n15];
        object7 = null;
        switch (n15) {
            default: {
                object6 = string2;
                object5 = null;
                object7 = object4;
                object4 = null;
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                object5 = object4;
            }
            case 2: {
                object4 = MessagePageType.MESSAGE_SYSTEM;
                object6 = string2;
                Object object8 = object5;
                object5 = object4;
                object4 = null;
                object7 = object8;
                break;
            }
            case 1: {
                object7 = (Object)MessagePageType.MESSAGE_LIKE;
                object4 = ((PushEntity$MsgInfo)object).getSourceUrls();
                n10 = 2131952546;
                string2 = g.m(context2, n10);
                object6 = object5;
                object5 = object7;
                object7 = string2;
            }
        }
        n10 = 0;
        string2 = null;
        if (object5 == null) {
            return;
        }
        object3.A((MessagePageType)((Object)object5));
        object5 = d;
        object3 = new Intent(context2, (Class)object5);
        object3.putExtra("title", (String)object6);
        object5 = ((PushEntity$MsgInfo)object).getContent();
        object3.putExtra("content", (String)object5);
        object3.putExtra("createAt", (String)object2);
        object2 = ((PushEntity$MsgInfo)object).getType();
        object3.putExtra("type", (String)object2);
        object3.putExtra("typeId", n11);
        object3.putExtra("objectId", n14);
        object3.putExtra("notifyId", n12);
        object3.setAction("notification_clicked");
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)context2, (int)n12, (Intent)object3, (int)0x8000000);
        object3 = this;
        context2 = context;
        string2 = "";
        object = object6;
        this.d(context, (String)object4, false, string2, (String)object6, (String)object7, n12, string3, pendingIntent);
    }

    private void d(Context context, String string2, boolean bl2, String string3, String string4, String string5, int n10, String string6, PendingIntent pendingIntent) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            CustomPushReceiver$a customPushReceiver$a = new CustomPushReceiver$a(this, context, string3, string4, string5, n10, string6, pendingIntent);
            if (bl2) {
                Images.x(context, string2, customPushReceiver$a);
            } else {
                Images.w(context, string2, customPushReceiver$a);
            }
        } else {
            this.f(context, string3, string4, string5, n10, string6, null, pendingIntent);
        }
    }

    public static void e(Class clazz) {
        d = clazz;
    }

    private void f(Context context, String object, String string2, String string3, int n10, String object2, Bitmap object3, PendingIntent pendingIntent) {
        boolean bl2;
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)string2);
        object2 = "";
        if (n12 != 0) {
            string2 = object2;
        }
        if ((n12 = TextUtils.isEmpty((CharSequence)string3)) != 0) {
            string3 = object2;
        }
        n12 = string2.length();
        object2 = "\u2026";
        int n13 = 30;
        if (n12 > n13) {
            object = new StringBuilder();
            string2 = string2.substring(0, n13);
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((String)object2);
            string2 = ((StringBuilder)object).toString();
        }
        if ((n12 = string3.length()) > (n13 = 40)) {
            object = new StringBuilder();
            string3 = string3.substring(0, n13);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)object2);
            string3 = ((StringBuilder)object).toString();
        }
        n12 = Build.VERSION.SDK_INT;
        int n14 = 26;
        Object object4 = c;
        if (n12 >= n14) {
            n14 = 3;
            this.b(context, (String)object4, (String)object4, n14);
        }
        object2 = new NotificationCompat$Builder(context, (String)object4);
        n13 = 1;
        NotificationCompat$Builder notificationCompat$Builder = ((NotificationCompat$Builder)object2).setOnlyAlertOnce(n13 != 0);
        int n15 = d.v.c.o1.b.b();
        notificationCompat$Builder = notificationCompat$Builder.setSmallIcon(n15);
        n15 = -1;
        notificationCompat$Builder = notificationCompat$Builder.setDefaults(n15);
        notificationCompat$Builder.setAutoCancel(n13 != 0);
        n13 = TextUtils.isEmpty((CharSequence)string2);
        if (n13 == 0) {
            object4 = ((NotificationCompat$Builder)object2).setContentTitle(string2);
            ((NotificationCompat$Builder)object4).setTicker(string2);
        }
        if ((n13 = TextUtils.isEmpty((CharSequence)string3)) == 0) {
            ((NotificationCompat$Builder)object2).setContentText(string3);
        }
        if (pendingIntent != null) {
            ((NotificationCompat$Builder)object2).setContentIntent(pendingIntent);
        }
        if (object3 != null) {
            ((NotificationCompat$Builder)object2).setLargeIcon((Bitmap)object3);
        }
        if (n12 >= (n11 = 24)) {
            object = ((NotificationCompat$Builder)object2).setGroupSummary(false);
            object3 = "group";
            ((NotificationCompat$Builder)object).setGroup((String)object3);
        }
        object = new NotificationCompat$BigTextStyle();
        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n11 == 0) {
            ((NotificationCompat$BigTextStyle)object).setBigContentTitle(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            ((NotificationCompat$BigTextStyle)object).bigText(string3);
        }
        ((NotificationCompat$Builder)object2).setStyle((NotificationCompat$Style)object);
        object = "notification";
        context = (NotificationManager)context.getSystemService((String)object);
        if (context != null) {
            object = ((NotificationCompat$Builder)object2).build();
            context.notify(n10, (Notification)object);
        }
    }

    public void onReceive(Context object, Intent object2) {
        boolean bl2;
        Object object3;
        Object object4 = object2.getAction();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
        if (bl3) {
            return;
        }
        object4 = object2.getAction();
        bl3 = ((String)object4).equals(object3 = a);
        if (bl3 && (object4 = object2.getExtras()) != null) {
            object4 = object2.getExtras().getString(b);
            object3 = PushEntity.class;
            object4 = d.v.e.l.q2.c.a((Class)object3, (String)object4);
            object4 = (PushEntity)object4;
            try {
                this.c((Context)object, (PushEntity)object4);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (bl2 = ((String)(object = object2.getAction())).equals(object2 = "android.intent.action.LOCALE_CHANGED")) {
            object = d.v.a.f.c.b.N();
            ((b)object).p();
        }
    }
}

