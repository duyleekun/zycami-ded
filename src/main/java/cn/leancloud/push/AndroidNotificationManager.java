/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package cn.leancloud.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat$Builder;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.push.AVNotificationManager;
import cn.leancloud.push.PushService;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.Random;

public class AndroidNotificationManager
extends AVNotificationManager {
    private static final AndroidNotificationManager INSTANCE;
    private static final AVLogger LOGGER;
    private static final String PUSH_INTENT_KEY = "com.avoscloud.push";
    private static final Random random;
    private Context serviceContext;

    static {
        LOGGER = LogUtil.getLogger(AndroidNotificationManager.class);
        Object object = new Random();
        random = object;
        INSTANCE = object = new AndroidNotificationManager();
    }

    private AndroidNotificationManager() {
    }

    private Intent buildUpdateIntent(String string2, String string3, String string4) {
        Intent intent = new Intent();
        if (string4 != null) {
            intent.setAction(string4);
        }
        int n10 = 1;
        String string5 = PUSH_INTENT_KEY;
        intent.putExtra(string5, n10);
        intent.putExtra("com.avos.avoscloud.Channel", string2);
        string4 = "com.avoscloud.Channel";
        intent.putExtra(string4, string2);
        intent.putExtra("com.avos.avoscloud.Data", string3);
        intent.putExtra("com.avoscloud.Data", string3);
        string2 = AVOSCloud.getContext();
        if (string2 != null) {
            string2 = AVOSCloud.getContext().getPackageName();
            intent.setPackage(string2);
        } else {
            string2 = this.serviceContext.getPackageName();
            intent.setPackage(string2);
        }
        return intent;
    }

    public static AndroidNotificationManager getInstance() {
        return INSTANCE;
    }

    public static String getNotificationChannel(String string2) {
        return AVNotificationManager.getJSONValue(string2, "_notificationChannel");
    }

    private void sendNotification(String object, String object2, Intent object3) {
        boolean bl2 = StringUtil.isEmpty((String)(object = this.getDefaultPushCallback((String)object)));
        if (!bl2) {
            int n10;
            Object object4 = AVOSCloud.getContext();
            object4 = object4 != null ? AVOSCloud.getContext() : this.serviceContext;
            Object object5 = ".";
            int n11 = ((String)object).lastIndexOf((String)object5);
            if (n11 != (n10 = -1)) {
                int n12;
                object5 = random;
                n11 = ((Random)object5).nextInt();
                Object object6 = new ComponentName(object4, (String)object);
                object3.setComponent((ComponentName)object6);
                object = PendingIntent.getActivity((Context)object4, (int)n11, (Intent)object3, (int)0);
                object3 = this.getSound((String)object2);
                object6 = this.getTitle((String)object2);
                Object object7 = AndroidNotificationManager.getNotificationChannel((String)object2);
                object2 = AVNotificationManager.getText((String)object2);
                int n13 = Build.VERSION.SDK_INT;
                int n14 = 25;
                int n15 = 3;
                boolean bl3 = true;
                if (n13 <= n14) {
                    object7 = new NotificationCompat$Builder((Context)object4);
                    n13 = this.getNotificationIcon();
                    object7 = ((NotificationCompat$Builder)object7).setSmallIcon(n13);
                    object6 = ((NotificationCompat$Builder)object7).setContentTitle((CharSequence)object6).setAutoCancel(bl3);
                    object = ((NotificationCompat$Builder)object6).setContentIntent((PendingIntent)object).setDefaults(n15).setContentText((CharSequence)object2).build();
                } else {
                    n13 = (int)(StringUtil.isEmpty((String)object7) ? 1 : 0);
                    if (n13 == 0) {
                        Notification.Builder builder = new Notification.Builder(object4);
                        n14 = this.getNotificationIcon();
                        builder = builder.setSmallIcon(n14);
                        object6 = builder.setContentTitle((CharSequence)object6);
                        object2 = object6.setContentText((CharSequence)object2).setAutoCancel(bl3);
                        object = object2.setContentIntent((PendingIntent)object).setChannelId((String)object7).build();
                    } else {
                        object7 = new Notification.Builder(object4);
                        n13 = this.getNotificationIcon();
                        object7 = object7.setSmallIcon(n13);
                        object6 = object7.setContentTitle((CharSequence)object6);
                        object = object6.setContentText((CharSequence)object2).setAutoCancel(bl3).setContentIntent((PendingIntent)object).setDefaults(n15);
                        object2 = PushService.DefaultChannelId;
                        object = object.setChannelId((String)object2).build();
                    }
                }
                if (object3 != null && (n12 = ((String)(object2 = ((String)object3).trim())).length()) > 0) {
                    object2 = new StringBuilder();
                    object6 = "android.resource://";
                    ((StringBuilder)object2).append((String)object6);
                    ((StringBuilder)object2).append((String)object3);
                    object2 = Uri.parse((String)((StringBuilder)object2).toString());
                    ((Notification)object).sound = object2;
                }
                object2 = (NotificationManager)object4.getSystemService("notification");
                object2.notify(n11, (Notification)object);
            } else {
                object2 = LOGGER;
                object3 = new StringBuilder();
                object4 = "Class name is invalid, which must contain '.': ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                ((AVLogger)object2).e((String)object);
            }
            return;
        }
        object = new IllegalArgumentException("No default callback found, did you forget to invoke setDefaultPushCallback?");
        throw object;
    }

    private void sendNotificationBroadcast(String string2, String object, String charSequence) {
        string2 = this.buildUpdateIntent(string2, (String)object, (String)charSequence);
        object = LOGGER;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("action: ");
        String string3 = string2.getAction();
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d((String)charSequence);
        charSequence = AVOSCloud.getContext();
        charSequence = charSequence != null ? AVOSCloud.getContext() : this.serviceContext;
        charSequence.sendBroadcast((Intent)string2);
        ((AVLogger)object).d("sent broadcast");
    }

    public String getApplicationName() {
        Object object = AVOSCloud.getContext();
        object = object != null ? AVOSCloud.getContext() : this.serviceContext;
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        try {
            object = packageManager.getApplicationInfo((String)object, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = null;
        }
        object = object != null ? packageManager.getApplicationLabel((ApplicationInfo)object) : "Notification";
        return (String)object;
    }

    public void porcessMixNotificationArrived(String string2, String string3) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string3))) {
            boolean bl3;
            String string4 = AVNotificationManager.getChannel(string2);
            if (string4 == null || !(bl3 = this.containsDefaultPushCallback(string4))) {
                string4 = cn.leancloud.core.AVOSCloud.getApplicationId();
            }
            this.sendNotificationBroadcast(string4, string2, string3);
        }
    }

    public void processFcmMessage(String string2, String string3, String string4) {
        boolean bl2 = StringUtil.isEmpty(string4);
        if (!bl2) {
            if (string2 == null || !(bl2 = this.containsDefaultPushCallback(string2))) {
                string2 = cn.leancloud.core.AVOSCloud.getApplicationId();
            }
            if (string3 != null) {
                this.sendBroadcast(string2, string4, string3);
            } else {
                this.sendNotification(string2, string4);
            }
        }
    }

    public void processMixNotification(String object, String object2) {
        int n10 = StringUtil.isEmpty((String)object);
        if (n10 != 0) {
            object = LOGGER;
            object2 = "message is empty, ignore.";
            ((AVLogger)object).e((String)object2);
        } else {
            String string2;
            boolean bl2;
            String string3 = AVNotificationManager.getChannel((String)object);
            if (string3 == null || !(bl2 = this.containsDefaultPushCallback(string3))) {
                string3 = cn.leancloud.core.AVOSCloud.getApplicationId();
            }
            if ((string2 = AVNotificationManager.getAction((String)object)) != null) {
                this.sendNotificationBroadcast(string3, (String)object, (String)object2);
            } else {
                object2 = this.getDefaultPushCallback(string3);
                bl2 = StringUtil.isEmpty((String)object2);
                if (bl2) {
                    object = LOGGER;
                    object2 = "className is empty, ignore.";
                    ((AVLogger)object).e((String)object2);
                } else {
                    string2 = AVOSCloud.getContext();
                    string2 = string2 != null ? AVOSCloud.getContext() : this.serviceContext;
                    object = this.buildUpdateIntent(string3, (String)object, null);
                    string3 = new ComponentName((Context)string2, (String)object2);
                    object.setComponent((ComponentName)string3);
                    object.setFlags(0x20000000);
                    object2 = null;
                    n10 = 0x8000000;
                    object = PendingIntent.getActivity((Context)string2, (int)0, (Intent)object, (int)n10);
                    try {
                        object.send();
                    }
                    catch (PendingIntent.CanceledException canceledException) {
                        object2 = LOGGER;
                        string3 = "Ocurred PendingIntent.CanceledException";
                        ((AVLogger)object2).e(string3, canceledException);
                    }
                }
            }
        }
    }

    public void processMixPushMessage(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            boolean bl3;
            Object object = AVNotificationManager.getChannel(string2);
            if (object == null || !(bl3 = this.containsDefaultPushCallback((String)object))) {
                object = cn.leancloud.core.AVOSCloud.getApplicationId();
            }
            CharSequence charSequence = AVNotificationManager.getAction(string2);
            boolean bl4 = AVNotificationManager.getSilent(string2);
            if (charSequence != null) {
                this.sendBroadcast((String)object, string2, (String)charSequence);
            } else if (!bl4) {
                this.sendNotification((String)object, string2);
            } else {
                object = LOGGER;
                charSequence = new StringBuilder();
                String string3 = "ignore push silent message: ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).e(string2);
            }
        }
    }

    public void sendBroadcast(String string2, String object, String charSequence) {
        string2 = this.buildUpdateIntent(string2, (String)object, (String)charSequence);
        object = LOGGER;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("action: ");
        String string3 = string2.getAction();
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d((String)charSequence);
        charSequence = AVOSCloud.getContext();
        charSequence = charSequence != null ? AVOSCloud.getContext() : this.serviceContext;
        charSequence.sendBroadcast((Intent)string2);
        ((AVLogger)object).d("sent broadcast");
    }

    public void sendNotification(String string2, String string3) {
        Intent intent = this.buildUpdateIntent(string2, string3, null);
        this.sendNotification(string2, string3, intent);
    }

    public void setServiceContext(Context context) {
        this.serviceContext = context;
    }
}

