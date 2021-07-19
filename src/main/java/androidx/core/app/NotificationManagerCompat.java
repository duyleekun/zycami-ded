/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.app.NotificationManager
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 */
package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationChannelGroupCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat$CancelTask;
import androidx.core.app.NotificationManagerCompat$NotifyTask;
import androidx.core.app.NotificationManagerCompat$SideChannelManager;
import androidx.core.app.NotificationManagerCompat$Task;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = 64536;
    public static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static NotificationManagerCompat$SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    static {
        Object object;
        sEnabledNotificationListenersLock = object = new Object();
        object = new HashSet();
        sEnabledNotificationListenerPackages = object;
        sLock = object = new Object();
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        context = (NotificationManager)context.getSystemService("notification");
        this.mNotificationManager = context;
    }

    public static NotificationManagerCompat from(Context context) {
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
        return notificationManagerCompat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Set getEnabledListenerPackages(Context object) {
        object = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object object2 = sEnabledNotificationListenersLock;
        synchronized (object2) {
            if (object == null) return sEnabledNotificationListenerPackages;
            String[] stringArray = sEnabledNotificationListeners;
            boolean bl2 = ((String)object).equals(stringArray);
            if (bl2) return sEnabledNotificationListenerPackages;
            stringArray = ":";
            int n10 = -1;
            stringArray = ((String)object).split((String)stringArray, n10);
            int n11 = stringArray.length;
            HashSet<String> hashSet = new HashSet<String>(n11);
            for (String string2 : stringArray) {
                if ((string2 = ComponentName.unflattenFromString((String)string2)) == null) continue;
                string2 = string2.getPackageName();
                hashSet.add(string2);
            }
            sEnabledNotificationListenerPackages = hashSet;
            sEnabledNotificationListeners = object;
            return sEnabledNotificationListenerPackages;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void pushSideChannelQueue(NotificationManagerCompat$Task notificationManagerCompat$Task) {
        Object object = sLock;
        synchronized (object) {
            NotificationManagerCompat$SideChannelManager notificationManagerCompat$SideChannelManager = sSideChannelManager;
            if (notificationManagerCompat$SideChannelManager == null) {
                Context context = this.mContext;
                context = context.getApplicationContext();
                sSideChannelManager = notificationManagerCompat$SideChannelManager = new NotificationManagerCompat$SideChannelManager(context);
            }
            notificationManagerCompat$SideChannelManager = sSideChannelManager;
            notificationManagerCompat$SideChannelManager.queueTask(notificationManagerCompat$Task);
            return;
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        String string2;
        boolean bl2;
        if ((notification = NotificationCompat.getExtras(notification)) != null && (bl2 = notification.getBoolean(string2 = EXTRA_USE_SIDE_CHANNEL))) {
            bl2 = true;
        } else {
            bl2 = false;
            notification = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean areNotificationsEnabled() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return this.mNotificationManager.areNotificationsEnabled();
        }
        n11 = 19;
        int n12 = 1;
        if (n10 < n11) return n12 != 0;
        Object object = (AppOpsManager)this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String string2 = this.mContext.getApplicationContext().getPackageName();
        n11 = applicationInfo.uid;
        Object object2 = AppOpsManager.class;
        object2 = ((Class)object2).getName();
        object2 = Class.forName((String)object2);
        Object object3 = CHECK_OP_NO_THROW;
        int n13 = 3;
        Class[] classArray = new Class[n13];
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        classArray[n12] = clazz;
        Class<String> clazz2 = String.class;
        int n14 = 2;
        classArray[n14] = clazz2;
        object3 = ((Class)object2).getMethod((String)object3, classArray);
        String string3 = OP_POST_NOTIFICATION;
        object2 = ((Class)object2).getDeclaredField(string3);
        Class<Integer> clazz3 = Integer.class;
        object2 = ((Field)object2).get(clazz3);
        object2 = (Integer)object2;
        int n15 = (Integer)object2;
        Object[] objectArray = new Object[n13];
        object2 = n15;
        objectArray[0] = object2;
        Integer n16 = n11;
        objectArray[n12] = n16;
        objectArray[n14] = string2;
        object = ((Method)object3).invoke(object, objectArray);
        object = (Integer)object;
        try {
            n10 = (Integer)object;
            if (n10 != 0) return 0 != 0;
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException exception) {
            return n12 != 0;
        }
        return n12 != 0;
    }

    public void cancel(int n10) {
        this.cancel(null, n10);
    }

    public void cancel(String string2, int n10) {
        Object object = this.mNotificationManager;
        object.cancel(string2, n10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 <= n12) {
            String string3 = this.mContext.getPackageName();
            object = new NotificationManagerCompat$CancelTask(string3, n10, string2);
            this.pushSideChannelQueue((NotificationManagerCompat$Task)object);
        }
    }

    public void cancelAll() {
        Object object = this.mNotificationManager;
        object.cancelAll();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 <= n11) {
            String string2 = this.mContext.getPackageName();
            object = new NotificationManagerCompat$CancelTask(string2);
            this.pushSideChannelQueue((NotificationManagerCompat$Task)object);
        }
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannel(NotificationChannelCompat notificationChannelCompat) {
        notificationChannelCompat = notificationChannelCompat.getNotificationChannel();
        this.createNotificationChannel((NotificationChannel)notificationChannelCompat);
    }

    public void createNotificationChannelGroup(NotificationChannelGroup notificationChannelGroup) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat notificationChannelGroupCompat) {
        notificationChannelGroupCompat = notificationChannelGroupCompat.getNotificationChannelGroup();
        this.createNotificationChannelGroup((NotificationChannelGroup)notificationChannelGroupCompat);
    }

    public void createNotificationChannelGroups(List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannelGroupsCompat(List object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            n11 = object.size();
            ArrayList<NotificationChannelGroup> arrayList = new ArrayList<NotificationChannelGroup>(n11);
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                NotificationChannelGroup notificationChannelGroup = ((NotificationChannelGroupCompat)object.next()).getNotificationChannelGroup();
                arrayList.add(notificationChannelGroup);
            }
            object = this.mNotificationManager;
            object.createNotificationChannelGroups(arrayList);
        }
    }

    public void createNotificationChannels(List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.createNotificationChannels(list);
        }
    }

    public void createNotificationChannelsCompat(List object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            n11 = object.size();
            ArrayList<NotificationChannel> arrayList = new ArrayList<NotificationChannel>(n11);
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                NotificationChannel notificationChannel = ((NotificationChannelCompat)object.next()).getNotificationChannel();
                arrayList.add(notificationChannel);
            }
            object = this.mNotificationManager;
            object.createNotificationChannels(arrayList);
        }
    }

    public void deleteNotificationChannel(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.deleteNotificationChannel(string2);
        }
    }

    public void deleteNotificationChannelGroup(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.deleteNotificationChannelGroup(string2);
        }
    }

    public void deleteUnlistedNotificationChannels(Collection collection) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            boolean bl2;
            Iterator iterator2 = this.mNotificationManager.getNotificationChannels().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object = (NotificationChannel)iterator2.next();
                String string2 = object.getId();
                int n12 = collection.contains(string2);
                if (n12 != 0 || n10 >= (n12 = 30) && (n12 = (int)(collection.contains(string2 = object.getParentChannelId()) ? 1 : 0)) != 0) continue;
                string2 = this.mNotificationManager;
                object = object.getId();
                string2.deleteNotificationChannel((String)object);
            }
        }
    }

    public int getImportance() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return this.mNotificationManager.getImportance();
        }
        return -1000;
    }

    public NotificationChannel getNotificationChannel(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mNotificationManager.getNotificationChannel(string2);
        }
        return null;
    }

    public NotificationChannel getNotificationChannel(String string2, String string3) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return this.mNotificationManager.getNotificationChannel(string2, string3);
        }
        return this.getNotificationChannel(string2);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (string2 = this.getNotificationChannel(string2)) != null) {
            NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat((NotificationChannel)string2);
            return notificationChannelCompat;
        }
        return null;
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string2, String object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (string2 = this.getNotificationChannel(string2, (String)object)) != null) {
            object = new NotificationChannelCompat((NotificationChannel)string2);
            return object;
        }
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return this.mNotificationManager.getNotificationChannelGroup(string2);
        }
        n11 = 26;
        if (n10 >= n11) {
            Iterator iterator2 = this.getNotificationChannelGroups().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                NotificationChannelGroup notificationChannelGroup = (NotificationChannelGroup)iterator2.next();
                String string3 = notificationChannelGroup.getId();
                boolean bl2 = string3.equals(string2);
                if (!bl2) continue;
                return notificationChannelGroup;
            }
        }
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            if ((string2 = this.getNotificationChannelGroup(string2)) != null) {
                NotificationChannelGroupCompat notificationChannelGroupCompat = new NotificationChannelGroupCompat((NotificationChannelGroup)string2);
                return notificationChannelGroupCompat;
            }
        } else {
            n11 = 26;
            if (n10 >= n11 && (string2 = this.getNotificationChannelGroup(string2)) != null) {
                List list = this.getNotificationChannels();
                NotificationChannelGroupCompat notificationChannelGroupCompat = new NotificationChannelGroupCompat((NotificationChannelGroup)string2, list);
                return notificationChannelGroupCompat;
            }
        }
        return null;
    }

    public List getNotificationChannelGroups() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mNotificationManager.getNotificationChannelGroups();
        }
        return Collections.emptyList();
    }

    public List getNotificationChannelGroupsCompat() {
        Object object;
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12 && (n10 = (object = this.getNotificationChannelGroups()).isEmpty()) == 0) {
            n10 = 28;
            List list = n11 >= n10 ? Collections.emptyList() : this.getNotificationChannels();
            int n13 = object.size();
            ArrayList<NotificationChannelGroupCompat> arrayList = new ArrayList<NotificationChannelGroupCompat>(n13);
            object = object.iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                NotificationChannelGroupCompat notificationChannelGroupCompat;
                NotificationChannelGroup notificationChannelGroup = (NotificationChannelGroup)object.next();
                if (n11 >= n10) {
                    notificationChannelGroupCompat = new NotificationChannelGroupCompat(notificationChannelGroup);
                    arrayList.add(notificationChannelGroupCompat);
                    continue;
                }
                notificationChannelGroupCompat = new NotificationChannelGroupCompat(notificationChannelGroup, list);
                arrayList.add(notificationChannelGroupCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public List getNotificationChannels() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mNotificationManager.getNotificationChannels();
        }
        return Collections.emptyList();
    }

    public List getNotificationChannelsCompat() {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (n11 = (int)((object = this.getNotificationChannels()).isEmpty() ? 1 : 0)) == 0) {
            int n12 = object.size();
            ArrayList<NotificationChannelCompat> arrayList = new ArrayList<NotificationChannelCompat>(n12);
            object = object.iterator();
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                NotificationChannel notificationChannel = (NotificationChannel)object.next();
                NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(notificationChannel);
                arrayList.add(notificationChannelCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void notify(int n10, Notification notification) {
        this.notify(null, n10, notification);
    }

    public void notify(String string2, int n10, Notification notification) {
        boolean bl2 = NotificationManagerCompat.useSideChannelForNotification(notification);
        if (bl2) {
            String string3 = this.mContext.getPackageName();
            NotificationManagerCompat$NotifyTask notificationManagerCompat$NotifyTask = new NotificationManagerCompat$NotifyTask(string3, n10, string2, notification);
            this.pushSideChannelQueue(notificationManagerCompat$NotifyTask);
            notification = this.mNotificationManager;
            notification.cancel(string2, n10);
        } else {
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.notify(string2, n10, notification);
        }
    }
}

