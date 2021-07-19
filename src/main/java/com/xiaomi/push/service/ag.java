/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.hr;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ag$a;
import com.xiaomi.push.service.ag$b;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.ak;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ag {
    private static ag a;

    static {
        ag ag2;
        a = ag2 = new ag();
    }

    private ag() {
    }

    private int a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GroupSummary");
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString().hashCode();
    }

    private NotificationManager a(Context context) {
        return (NotificationManager)context.getSystemService("notification");
    }

    public static ag a() {
        return a;
    }

    private String a(Notification notification) {
        if (notification != null && (notification = notification.extras) != null) {
            return notification.getString("push_src_group_name");
        }
        return null;
    }

    private void a(NotificationManager notificationManager, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("group cancel summary:");
        stringBuilder.append(string3);
        b.b(stringBuilder.toString());
        int n10 = this.a(string2, string3);
        notificationManager.cancel(n10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void a(Context object, int n10, Notification object2, boolean bl2) {
        int n11;
        Object object3;
        int n12;
        String string2;
        Object object4;
        NotificationManager notificationManager;
        block11: {
            block10: {
                block9: {
                    notificationManager = this.a((Context)object);
                    object4 = this.a(notificationManager);
                    if (object4 != null) break block9;
                    object = "group auto not get notifications";
                    break block10;
                }
                string2 = aj.a(object2);
                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl3) break block11;
                object = new StringBuilder();
                String string3 = "group auto not extract pkg from notification:";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
            }
            b.a((String)object);
            return;
        }
        String string4 = this.b((Notification)object2);
        Object object5 = new HashMap();
        int n13 = ((StatusBarNotification[])object4).length;
        Object object6 = null;
        for (n12 = 0; n12 < n13; ++n12) {
            String string5;
            object3 = object4[n12];
            Notification notification = object3.getNotification();
            if (notification == null || (n11 = string2.equals(string5 = aj.a(notification))) == 0 || (n11 = object3.getId()) == n10) continue;
            this.a((Map)object5, (StatusBarNotification)object3);
        }
        object4 = object5.entrySet().iterator();
        boolean bl4;
        while (bl4 = object4.hasNext()) {
            long l10;
            int n14;
            void var4_5;
            object5 = (Map.Entry)object4.next();
            CharSequence charSequence = (String)object5.getKey();
            n12 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
            if (n12 != 0) continue;
            object5 = (ag$a)object5.getValue();
            if (var4_5 != false && (n12 = (int)(((String)charSequence).equals(string4) ? 1 : 0)) != 0 && (n12 = (int)(this.b((Notification)object2) ? 1 : 0)) == 0) {
                object6 = new ag$b(this, n10, (Notification)object2);
                n14 = (int)(this.a((Notification)object2) ? 1 : 0);
                object3 = n14 != 0 ? ((ag$a)object5).b : ((ag$a)object5).a;
                object3.add(object6);
            }
            object6 = ((ag$a)object5).a;
            n12 = object6.size();
            object3 = ((ag$a)object5).b;
            n14 = object3.size();
            n11 = 2;
            if (n14 <= 0) {
                if (n12 < n11) continue;
                this.a((Context)object, notificationManager, string2, (String)charSequence);
                continue;
            }
            if (n12 <= 0) {
                this.a(notificationManager, string2, (String)charSequence);
                continue;
            }
            if (n12 < n11 || (n13 = (int)(this.a((Context)object) ? 1 : 0)) != 0) continue;
            object5 = (ag$b)((ag$a)object5).b.get(0);
            charSequence = new StringBuilder();
            object6 = "group refresh:";
            ((StringBuilder)charSequence).append((String)object6);
            ((StringBuilder)charSequence).append(object5);
            b.b(((StringBuilder)charSequence).toString());
            charSequence = ((ag$b)object5).a;
            ((Notification)charSequence).when = l10 = System.currentTimeMillis();
            n13 = ((ag$b)object5).a;
            object5 = ((ag$b)object5).a;
            notificationManager.notify(n13, (Notification)object5);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Context object, NotificationManager object2, String string2, String string3) {
        String string4 = "GroupSummary";
        String string5 = "groupSummary";
        try {
            int n10;
            NotificationChannel notificationChannel;
            int n11 = TextUtils.isEmpty((CharSequence)string3);
            if (n11 != 0) {
                object = "group show summary group is null";
                b.a((String)object);
                return;
            }
            n11 = aj.a((Context)object, string2);
            if (n11 == 0) {
                object = new StringBuilder();
                object2 = "group show summary not get icon from ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                b.a((String)object);
                return;
            }
            int n12 = Build.VERSION.SDK_INT;
            int n13 = 26;
            if (n12 >= n13) {
                notificationChannel = object2.getNotificationChannel(string5);
                if (notificationChannel == null) {
                    String string6 = "group_summary";
                    int n14 = 3;
                    notificationChannel = new NotificationChannel(string5, (CharSequence)string6, n14);
                    object2.createNotificationChannel(notificationChannel);
                }
                notificationChannel = new Notification.Builder((Context)object, string5);
            } else {
                string5 = new Notification.Builder((Context)object);
                n12 = 0;
                notificationChannel = null;
                string5 = string5.setPriority(0);
                n12 = -1;
                notificationChannel = string5.setDefaults(n12);
            }
            string5 = notificationChannel.setContentTitle((CharSequence)string4);
            string4 = string5.setContentText((CharSequence)string4);
            string5 = Icon.createWithResource((String)string2, (int)n11);
            string4 = string4.setSmallIcon((Icon)string5);
            boolean bl2 = true;
            string4 = string4.setAutoCancel(bl2);
            string4 = string4.setGroup(string3);
            string4 = string4.setGroupSummary(bl2);
            string4 = string4.build();
            bl2 = l.c();
            if (!bl2 && (n10 = (int)((string5 = "com.xiaomi.xmsf").equals(object = object.getPackageName()) ? 1 : 0)) != 0) {
                aj.a((Notification)string4, string2);
            }
            n10 = this.a(string2, string3);
            object2.notify(n10, (Notification)string4);
            object2 = new StringBuilder();
            string2 = "group show summary notify:";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(n10);
            object = ((StringBuilder)object2).toString();
            b.b((String)object);
            return;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            string2 = "group show summary error ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(exception);
            String string7 = ((StringBuilder)object2).toString();
            b.a(string7);
        }
    }

    private void a(Map object, StatusBarNotification object2) {
        Notification notification;
        Object object3 = object2.getNotification();
        ag$a ag$a = (ag$a)object.get(object3 = this.b((Notification)object3));
        if (ag$a == null) {
            notification = null;
            ag$a = new ag$a(this, null);
            object.put(object3, ag$a);
        }
        int n10 = object2.getId();
        notification = object2.getNotification();
        object = new ag$b(this, n10, notification);
        boolean bl2 = this.a((Notification)(object2 = object2.getNotification()));
        object2 = bl2 ? ag$a.b : ag$a.a;
        object2.add(object);
    }

    private boolean a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private boolean a(Notification object) {
        String string2;
        boolean bl2;
        if (object != null && (bl2 = (object = ba.a(object, string2 = "isGroupSummary", null)) instanceof Boolean)) {
            return (Boolean)object;
        }
        return false;
    }

    private boolean a(Context context) {
        this.b(context);
        return false;
    }

    private StatusBarNotification[] a(NotificationManager object) {
        int n10;
        if ((object = object != null ? object.getActiveNotifications() : null) != null && (n10 = ((StatusBarNotification[])object).length) != 0) {
            return object;
        }
        return null;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        String string2 = notification.getGroup();
        boolean bl2 = this.b(notification);
        if (bl2) {
            string2 = this.a(notification);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Context object, int n10, Notification object2) {
        int n11;
        String string2;
        StatusBarNotification[] statusBarNotificationArray;
        NotificationManager notificationManager;
        block8: {
            block7: {
                block6: {
                    notificationManager = this.a((Context)object);
                    statusBarNotificationArray = this.a(notificationManager);
                    if (statusBarNotificationArray != null) break block6;
                    object = "group restore not get notifications";
                    break block7;
                }
                string2 = aj.a(object2);
                n11 = TextUtils.isEmpty((CharSequence)string2);
                if (n11 == 0) break block8;
                object = new StringBuilder();
                String string3 = "group restore not extract pkg from notification:";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
            }
            b.a((String)object);
            return;
        }
        String string4 = this.b((Notification)object2);
        n11 = statusBarNotificationArray.length;
        int n12 = 0;
        while (n12 < n11) {
            int n13;
            String string5;
            int n14;
            StatusBarNotification statusBarNotification = statusBarNotificationArray[n12];
            Object object3 = statusBarNotification.getNotification();
            if (object3 != null && (n14 = string2.equals(string5 = aj.a((Notification)object3))) != 0 && (n13 = this.b((Notification)object3)) != 0 && (n13 = statusBarNotification.getId()) != n10) {
                object3 = statusBarNotification.getNotification();
                object3 = Notification.Builder.recoverBuilder((Context)object, (Notification)object3);
                object3.setGroup(string4);
                n14 = statusBarNotification.getId();
                object3 = object3.build();
                notificationManager.notify(n14, (Notification)object3);
                object3 = new StringBuilder();
                string5 = "group restore notification:";
                ((StringBuilder)object3).append(string5);
                int n15 = statusBarNotification.getId();
                ((StringBuilder)object3).append(n15);
                String string6 = ((StringBuilder)object3).toString();
                b.b(string6);
            }
            ++n12;
        }
        return;
    }

    private boolean b(Notification object) {
        Object object2;
        String string2 = null;
        if (object != null && (object2 = object.getGroup()) != null && (object2 = ((Notification)object).extras) != null) {
            long l10 = object2.getLong("push_src_group_time");
            String string3 = this.a((Notification)object);
            object = object.getGroup();
            object2 = l10;
            Object[] objectArray = new Object[]{object2, string3};
            string2 = String.format("pushmask_%s_%s", objectArray);
            return ((String)object).equals(string2);
        }
        return false;
    }

    private boolean b(Context object) {
        object = ak.a((Context)object);
        int n10 = hr.aW.a();
        return ((ak)object).a(n10, true);
    }

    public String a(Context objectArray, Notification.Builder builder, String string2) {
        boolean bl2;
        boolean bl3 = this.a();
        if (bl3 && (bl2 = this.a((Context)objectArray))) {
            long l10 = System.currentTimeMillis();
            objectArray = builder.getExtras();
            objectArray.putString("push_src_group_name", string2);
            objectArray.putLong("push_src_group_time", l10);
            objectArray = new Object[2];
            Long l11 = l10;
            objectArray[0] = l11;
            objectArray[1] = string2;
            return String.format("pushmask_%s_%s", objectArray);
        }
        return string2;
    }

    public void a(Context context, int n10, Notification object) {
        boolean bl2 = this.a();
        if (!bl2) {
            return;
        }
        bl2 = this.a(context);
        if (bl2) {
            try {
                this.b(context, n10, (Notification)object);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "group notify handle restore error ";
                stringBuilder.append(string2);
                stringBuilder.append(exception);
                String string3 = stringBuilder.toString();
                b.a(string3);
            }
        }
        if (bl2 = this.b(context)) {
            bl2 = true;
            try {
                this.a(context, n10, (Notification)object, bl2);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                object = "group notify handle auto error ";
                stringBuilder.append((String)object);
                stringBuilder.append(exception);
                String string4 = stringBuilder.toString();
                b.a(string4);
            }
        }
    }
}

