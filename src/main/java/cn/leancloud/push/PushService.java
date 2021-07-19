/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ServiceInfo
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 */
package cn.leancloud.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import cn.leancloud.AVException;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.AndroidInitializer;
import cn.leancloud.im.DirectlyOperationTube;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMClient$AVIMClientStatus;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.json.JSON;
import cn.leancloud.push.AVConnectivityListener;
import cn.leancloud.push.AVConnectivityReceiver;
import cn.leancloud.push.AVNotificationManager;
import cn.leancloud.push.AVPushMessageListener;
import cn.leancloud.push.AVShutdownListener;
import cn.leancloud.push.AVShutdownReceiver;
import cn.leancloud.push.AndroidNotificationManager;
import cn.leancloud.push.NotifyUtil;
import cn.leancloud.push.PushService$1;
import cn.leancloud.push.PushService$2;
import cn.leancloud.push.PushService$3;
import cn.leancloud.push.PushService$4;
import cn.leancloud.push.PushService$5;
import cn.leancloud.push.PushService$6;
import cn.leancloud.push.PushService$7;
import cn.leancloud.push.PushService$8;
import cn.leancloud.push.PushService$9;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class PushService
extends Service {
    public static final String AV_PUSH_SERVICE_APPLICATION_ID = "AV_APPLICATION_ID";
    public static final String AV_PUSH_SERVICE_DEFAULT_CALLBACK = "AV_DEFAULT_CALLBACK";
    public static String DefaultChannelId;
    private static final AVLogger LOGGER;
    public static final String SERVICE_RESTART_ACTION = "com.avos.avoscloud.notify.action";
    private static Handler _installationSaveHandler;
    private static Object connecting;
    public static volatile boolean enableForegroundService;
    public static int foregroundIdentifier;
    public static Notification foregroundNotification;
    private static boolean isAutoWakeUp;
    private static boolean isNeedNotifyApplication;
    private static volatile boolean isStarted;
    private Timer cleanupTimer;
    private AVConnectionManager connectionManager = null;
    public AVConnectivityReceiver connectivityReceiver;
    public DirectlyOperationTube directlyOperationTube;
    public AVShutdownReceiver shutdownReceiver;

    static {
        Object object;
        boolean bl2;
        LOGGER = LogUtil.getLogger(PushService.class);
        isNeedNotifyApplication = bl2 = true;
        connecting = object = new Object();
        isStarted = false;
        isAutoWakeUp = bl2;
        DefaultChannelId = "";
        enableForegroundService = false;
        foregroundIdentifier = 0;
        foregroundNotification = null;
        object = Looper.getMainLooper();
        PushService$8 pushService$8 = new PushService$8((Looper)object);
        _installationSaveHandler = pushService$8;
    }

    public PushService() {
        Timer timer;
        this.cleanupTimer = timer = new Timer();
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ AVConnectionManager access$100(PushService pushService) {
        return pushService.connectionManager;
    }

    public static /* synthetic */ Timer access$300(PushService pushService) {
        return pushService.cleanupTimer;
    }

    public static /* synthetic */ void access$400(PushService pushService, Intent intent) {
        pushService.processIMRequests(intent);
    }

    public static /* synthetic */ void access$500(PushService pushService, Intent intent, AVException aVException) {
        pushService.processRequestsWithException(intent, aVException);
    }

    public static /* synthetic */ Handler access$600() {
        return _installationSaveHandler;
    }

    public static void createNotificationChannel(Context object, String string2, String string3, String string4, int n10, boolean bl2, int n11, boolean bl3, long[] lArray) {
        String string5;
        block13: {
            block12: {
                int n12 = Build.VERSION.SDK_INT;
                int n13 = 25;
                if (n12 <= n13) {
                    return;
                }
                string5 = "notification";
                object = object.getSystemService(string5);
                object = (NotificationManager)object;
                string5 = new NotificationChannel(string2, (CharSequence)string3, n10);
                string5.setDescription(string4);
                string5.enableLights(bl2);
                if (!bl2) break block12;
                string5.setLightColor(n11);
            }
            string5.enableVibration(bl3);
            if (!bl3) break block13;
            string5.setVibrationPattern(lArray);
        }
        try {
            object.createNotificationChannel((NotificationChannel)string5);
        }
        catch (Exception exception) {
            object = LOGGER;
            string2 = "failed to create NotificationChannel, then perhaps PushNotification doesn't work well on Android O and newer version.";
            ((AVLogger)object).w(string2);
        }
    }

    private static boolean isPushServiceAvailable(Context object, Class clazz) {
        Intent intent;
        PackageManager packageManager = object.getPackageManager();
        int n10 = (object = packageManager.queryIntentServices(intent = new Intent((Context)object, clazz), 65536)).size();
        return n10 > 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void notifyOtherApplication(String string2) {
        int n10 = isNeedNotifyApplication;
        if (n10 == 0) return;
        String string3 = SERVICE_RESTART_ACTION;
        boolean bl2 = string3.equals(string2);
        if (bl2) return;
        bl2 = false;
        string2 = null;
        isNeedNotifyApplication = false;
        try {
            string3 = this.getApplicationContext();
            string3 = string3.getPackageManager();
            Context context = this.getApplicationContext();
            Class<PushService> clazz = PushService.class;
            ComponentName componentName = new ComponentName(context, clazz);
            string2 = string3.getServiceInfo(componentName, 0);
            bl2 = ((ServiceInfo)string2).exported;
            if (!bl2) return;
            string2 = NotifyUtil.notifyHandler;
            n10 = 1024;
            string2.sendEmptyMessage(n10);
            return;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return;
        }
    }

    private void processIMRequests(Intent intent) {
        Object object = LOGGER;
        String string2 = "processIMRequests...";
        ((AVLogger)object).d(string2);
        if (intent == null) {
            ((AVLogger)object).w("intent is null, invalid operation.");
            return;
        }
        string2 = "com.avoscloud.im.v2.action";
        object = intent.getAction();
        boolean bl2 = string2.equalsIgnoreCase((String)object);
        if (bl2) {
            this.processIMRequestsFromClient(intent);
        } else {
            this.processLiveQueryRequestsFromClient(intent);
        }
    }

    private void processIMRequestsFromClient(Intent object) {
        Object object2 = LOGGER;
        ((AVLogger)object2).d("processIMRequestsFromClient...");
        String string2 = object.getExtras().getString("conversation.client");
        Object object3 = object.getExtras();
        int n10 = object3.getInt("conversation.requestId");
        Object object4 = Conversation$AVIMOperation.getAVIMOperation(object.getExtras().getInt("conversation.operation"));
        Object object5 = object.getExtras();
        Object object6 = "conversation.data";
        HashMap<Object, Object> hashMap = object5.getString((String)object6);
        boolean bl2 = StringUtil.isEmpty((String)((Object)hashMap));
        if (!bl2) {
            object5 = (Map)JSON.parseObject((String)((Object)hashMap), Map.class);
        } else {
            bl2 = false;
            object5 = null;
        }
        object6 = object.getExtras();
        Object object7 = "convesration.id";
        Object object8 = object6.getString((String)object7);
        object6 = object.getExtras();
        Object object9 = "conversation.type";
        int n11 = object6.getInt((String)object9, 1);
        object6 = PushService$9.$SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
        int n12 = object4.ordinal();
        Object object10 = object6[n12];
        switch (object10) {
            default: {
                object = new StringBuilder();
                object3 = "not support operation: ";
                object.append((String)object3);
                object.append(object4);
                object = object.toString();
                ((AVLogger)object2).w((String)object);
                break;
            }
            case 28: {
                object2 = AVIMMessage.parseJSONString((String)((Object)hashMap));
                object = object.getExtras();
                object5 = "conversation.message.ex";
                object = object.getString((String)object5);
                hashMap = AVIMMessage.parseJSONString((String)object);
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                object9 = object2;
                int n13 = n10;
                ((DirectlyOperationTube)object6).updateMessageDirectly((AVConnectionManager)object7, string2, n11, (AVIMMessage)object2, (AVIMMessage)((Object)hashMap), n10);
                break;
            }
            case 27: {
                hashMap = AVIMMessage.parseJSONString((String)((Object)hashMap));
                object = object.getExtras();
                object2 = "conversation.messageoption";
                object = object.getString((String)object2);
                object4 = AVIMMessageOption.parseJSONString((String)object);
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                int n14 = n10;
                ((DirectlyOperationTube)object6).sendMessageDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (AVIMMessage)((Object)hashMap), (AVIMMessageOption)object4, n10);
                break;
            }
            case 26: {
                object = AVIMMessage.parseJSONString((String)((Object)hashMap));
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                object9 = object;
                int n15 = n10;
                ((DirectlyOperationTube)object6).recallMessageDirectly((AVConnectionManager)object7, string2, n11, (AVIMMessage)object, n10);
                break;
            }
            case 25: {
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                hashMap = object5;
                int n16 = n10;
                ((DirectlyOperationTube)object6).markConversationReadDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (Map)object5, n10);
                break;
            }
            case 24: {
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                object4 = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
                int n17 = n10;
                ((DirectlyOperationTube)object6).queryMessagesDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (String)((Object)hashMap), (Conversation$AVIMOperation)((Object)object4), n10);
                break;
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                int n18 = n10;
                ((DirectlyOperationTube)object6).processMembersDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (String)((Object)hashMap), (Conversation$AVIMOperation)((Object)object4), n10);
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                hashMap = object5;
                int n19 = n10;
                ((DirectlyOperationTube)object6).participateConversationDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (Map)object5, (Conversation$AVIMOperation)((Object)object4), n10);
                break;
            }
            case 8: {
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                hashMap = object5;
                int n20 = n10;
                ((DirectlyOperationTube)object6).updateConversationDirectly((AVConnectionManager)object7, string2, (String)object8, n11, (Map)object5, n10);
                break;
            }
            case 7: {
                object = this.directlyOperationTube;
                object2 = this.connectionManager;
                object.queryConversationsDirectly((AVConnectionManager)object2, string2, (String)((Object)hashMap), n10);
                break;
            }
            case 6: {
                int n21;
                int n22;
                int n23;
                int n24;
                int n25;
                object = object5.get("conversation.member");
                object8 = object;
                object8 = (List)object;
                object = "conversation.unique";
                boolean bl3 = object5.containsKey(object);
                object10 = false;
                object6 = null;
                if (bl3) {
                    object = (Boolean)object5.get(object);
                    n24 = n25 = object.booleanValue();
                } else {
                    n24 = 0;
                    object4 = null;
                }
                object = "conversation.transient";
                bl3 = object5.containsKey(object);
                if (bl3) {
                    object = (Boolean)object5.get(object);
                    n23 = n25 = object.booleanValue();
                } else {
                    n23 = 0;
                    hashMap = null;
                }
                object = "conversation.temp";
                bl3 = object5.containsKey(object);
                if (bl3) {
                    object = (Boolean)object5.get(object);
                    n22 = n25 = object.booleanValue();
                } else {
                    n22 = 0;
                }
                if (n22 != 0) {
                    object = (Integer)object5.get("conversation.tempTTL");
                    n21 = n25 = object.intValue();
                } else {
                    n21 = 0;
                }
                object = object5.get("conversation.attributes");
                object9 = object;
                object9 = (Map)object;
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                ((DirectlyOperationTube)object6).createConversationDirectly((AVConnectionManager)object7, string2, (List)object8, (Map)object9, n23 != 0, n24 != 0, n22 != 0, n21, n10);
                break;
            }
            case 5: {
                object = (List)object5.get("client.oneline");
                object2 = this.directlyOperationTube;
                object5 = this.connectionManager;
                ((DirectlyOperationTube)object2).queryOnlineClientsDirectly((AVConnectionManager)object5, string2, (List)object, n10);
                break;
            }
            case 4: {
                object = AVSessionManager.getInstance();
                object2 = AVInstallation.getCurrentInstallation().getInstallationId();
                object5 = this.connectionManager;
                object = object.getOrCreateSession(string2, (String)object2, (AVConnectionManager)object5);
                object2 = AVIMClient$AVIMClientStatus.AVIMClientStatusNone;
                object2 = AVSession$Status.Opened;
                object = object.getCurrentStatus();
                object = object2 != object ? AVIMClient$AVIMClientStatus.AVIMClientStatusPaused : AVIMClient$AVIMClientStatus.AVIMClientStatusOpened;
                hashMap = new HashMap<Object, Object>();
                object = object.getCode();
                object2 = "callbackClientStatus";
                hashMap.put(object2, object);
                object6 = InternalConfiguration.getOperationTube();
                boolean bl4 = false;
                object = null;
                object9 = Conversation$AVIMOperation.CLIENT_STATUS;
                object7 = string2;
                string2 = null;
                object6.onOperationCompletedEx((String)object7, null, n10, (Conversation$AVIMOperation)((Object)object9), hashMap);
                break;
            }
            case 3: {
                object = this.directlyOperationTube;
                object2 = this.connectionManager;
                object.renewSessionTokenDirectly((AVConnectionManager)object2, string2, n10);
                break;
            }
            case 2: {
                object = this.directlyOperationTube;
                object2 = this.connectionManager;
                object.closeClientDirectly((AVConnectionManager)object2, string2, n10);
                break;
            }
            case 1: {
                object = object5.get("client.tag");
                object8 = object;
                object8 = (String)object;
                object = object5.get("client.userSession");
                object9 = object;
                object9 = (String)object;
                object = (Boolean)object5.get("client.reconnect");
                boolean bl5 = object.booleanValue();
                object6 = this.directlyOperationTube;
                object7 = this.connectionManager;
                int n26 = n10;
                ((DirectlyOperationTube)object6).openClientDirectly((AVConnectionManager)object7, string2, (String)object8, (String)object9, bl5, n10);
            }
        }
    }

    private void processLiveQueryRequestsFromClient(Intent object) {
        if (object == null) {
            LOGGER.w("intent is null");
            return;
        }
        Object object2 = "action_live_query_login";
        String string2 = object.getAction();
        boolean bl2 = ((String)object2).equals(string2);
        if (bl2) {
            string2 = object.getExtras();
            int n10 = string2.getInt("conversation.requestId");
            object = object.getExtras().getString("id");
            object2 = this.directlyOperationTube;
            AVConnectionManager aVConnectionManager = this.connectionManager;
            ((DirectlyOperationTube)object2).loginLiveQueryDirectly(aVConnectionManager, (String)object, n10);
        } else {
            object = LOGGER;
            object2 = new StringBuilder();
            String string3 = "unknown action: ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).w(string2);
        }
    }

    private void processRequestsWithException(Intent intent, AVException aVException) {
        String string2;
        String string3;
        int n10;
        if (intent != null && (n10 = (string3 = "com.avoscloud.im.v2.action").equalsIgnoreCase(string2 = intent.getAction())) != 0) {
            string2 = intent.getExtras();
            n10 = string2.getInt("conversation.operation");
            String string4 = intent.getExtras().getString("conversation.client");
            string3 = intent.getExtras();
            String string5 = "convesration.id";
            String string6 = string3.getString(string5);
            intent = intent.getExtras();
            string3 = "conversation.requestId";
            int n11 = intent.getInt(string3);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.getAVIMOperation(n10);
            operationTube.onOperationCompleted(string4, string6, n11, conversation$AVIMOperation, aVException);
        }
    }

    public static void setAutoWakeUp(boolean bl2) {
        isAutoWakeUp = bl2;
    }

    public static void setDefaultChannelId(Context object, String string2) {
        DefaultChannelId = string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 <= n11) {
            return;
        }
        Object object2 = "notification";
        object2 = object.getSystemService((String)object2);
        object2 = (NotificationManager)object2;
        object = object.getPackageName();
        String string3 = "PushNotification";
        int n12 = 3;
        NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)object, n12);
        notificationChannel.setDescription(string3);
        try {
            object2.createNotificationChannel(notificationChannel);
        }
        catch (Exception exception) {
            object = LOGGER;
            string2 = "failed to create NotificationChannel, then perhaps PushNotification doesn't work well on Android O and newer version.";
            ((AVLogger)object).w(string2);
        }
    }

    public static void setDefaultPushCallback(Context object, Class object2) {
        Object object3 = LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setDefaultPushCallback cls=");
        String string2 = ((Class)object2).getName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object3).d((String)charSequence);
        PushService.startServiceIfRequired((Context)object, (Class)object2);
        object = AVPushMessageListener.getInstance().getNotificationManager();
        object3 = cn.leancloud.core.AVOSCloud.getApplicationId();
        object2 = ((Class)object2).getName();
        ((AVNotificationManager)object).addDefaultPushCallback((String)object3, (String)object2);
    }

    public static void setForegroundMode(boolean bl2, int n10, Notification notification) {
        enableForegroundService = bl2;
        foregroundIdentifier = n10;
        foregroundNotification = notification;
    }

    public static void setNotificationIcon(int n10) {
        AVPushMessageListener.getInstance().getNotificationManager().setNotificationIcon(n10);
    }

    public static void startIfRequired(Context context) {
        PushService.startServiceIfRequired(context, null);
    }

    private static void startService(Context context, Class clazz) {
        Class<PushService> clazz2 = PushService.class;
        synchronized (clazz2) {
            PushService$7 pushService$7 = new PushService$7(context, clazz);
            Thread thread = new Thread(pushService$7);
            thread.start();
            return;
        }
    }

    private static void startServiceIfRequired(Context context, Class clazz) {
        int n10 = isStarted;
        if (n10 != 0) {
            return;
        }
        if (context == null) {
            LOGGER.d("context is null");
            return;
        }
        Object object = "android.permission.INTERNET";
        n10 = ContextCompat.checkSelfPermission(context, (String)object);
        if (n10 != 0) {
            LOGGER.e("Please add <uses-permission android:name=\"android.permission.INTERNET\"/> in your AndroidManifest file");
            return;
        }
        object = PushService.class;
        n10 = (int)(PushService.isPushServiceAvailable(context, (Class)object) ? 1 : 0);
        if (n10 == 0) {
            LOGGER.e("Please add <service android:name=\"cn.leancloud.push.PushService\"/> in your AndroidManifest file");
            return;
        }
        object = AppConfiguration.getGlobalNetworkingDetector();
        n10 = (int)(object.isConnected() ? 1 : 0);
        if (n10 == 0) {
            object = LOGGER;
            String string2 = "No network available now";
            ((AVLogger)object).d(string2);
        }
        AndroidInitializer.init(context);
        PushService.startService(context, clazz);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void subscribe(Context object, String string2, Class object2) {
        Class<PushService> clazz = PushService.class;
        synchronized (clazz) {
            String string3;
            String string4;
            PushService.startServiceIfRequired((Context)object, (Class)((Object)string4));
            object = AVInstallation.getCurrentInstallation();
            String string5 = "channels";
            ((AVObject)object).addUnique(string5, string3);
            object = _installationSaveHandler;
            string5 = Message.obtain();
            object.sendMessage((Message)string5);
            if (string4 != null) {
                object = AVPushMessageListener.getInstance();
                object = ((AVPushMessageListener)object).getNotificationManager();
                string5 = ((Class)((Object)string4)).getName();
                ((AVNotificationManager)object).addDefaultPushCallback(string3, string5);
                string3 = cn.leancloud.core.AVOSCloud.getApplicationId();
                string3 = ((AVNotificationManager)object).getDefaultPushCallback(string3);
                if (string3 == null) {
                    string3 = cn.leancloud.core.AVOSCloud.getApplicationId();
                    string4 = ((Class)((Object)string4)).getName();
                    ((AVNotificationManager)object).addDefaultPushCallback(string3, string4);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unsubscribe(Context object, String object2) {
        Class<PushService> clazz = PushService.class;
        synchronized (clazz) {
            Handler handler;
            if (handler == null) {
                return;
            }
            Object object3 = AVPushMessageListener.getInstance();
            object3 = ((AVPushMessageListener)object3).getNotificationManager();
            ((AVNotificationManager)object3).removeDefaultPushCallback((String)handler);
            object3 = AVInstallation.getCurrentInstallation();
            object3 = ((AVObject)object3).getObjectId();
            boolean bl2 = StringUtil.isEmpty((String)object3);
            if (bl2) {
                object3 = AVInstallation.getCurrentInstallation();
                object3 = ((AVObject)object3).saveInBackground();
                PushService$6 pushService$6 = new PushService$6((String)handler);
                ((z)object3).subscribe(pushService$6);
            } else {
                object3 = AVInstallation.getCurrentInstallation();
                String string2 = "channels";
                int n10 = 1;
                String[] stringArray = new String[n10];
                stringArray[0] = handler;
                handler = Arrays.asList(stringArray);
                ((AVObject)object3).removeAll(string2, (Collection)handler);
                handler = _installationSaveHandler;
                object3 = Message.obtain();
                handler.sendMessage((Message)object3);
            }
            return;
        }
    }

    public IBinder onBind(Intent intent) {
        LOGGER.d("PushService#onBind");
        return null;
    }

    public void onCreate() {
        String string2;
        LOGGER.d("PushService#onCreate");
        super.onCreate();
        AndroidNotificationManager.getInstance().setServiceContext((Context)this);
        Object object = AndroidNotificationManager.getInstance();
        ApplicationInfo applicationInfo = this.getApplicationInfo();
        int bl2 = applicationInfo.icon;
        ((AVNotificationManager)object).setNotificationIcon(bl2);
        boolean bl3 = true;
        this.directlyOperationTube = object = new DirectlyOperationTube(bl3);
        this.connectionManager = object = AVConnectionManager.getInstance();
        Object object2 = new PushService$1(this);
        object = new Thread((Runnable)object2);
        ((Thread)object).start();
        object2 = new PushService$2(this);
        object = new AVConnectivityReceiver((AVConnectivityListener)object2);
        this.connectivityReceiver = object;
        CharSequence charSequence = "android.net.conn.CONNECTIVITY_CHANGE";
        object2 = new IntentFilter((String)charSequence);
        try {
            this.registerReceiver((BroadcastReceiver)object, (IntentFilter)object2);
        }
        catch (SecurityException securityException) {
            object2 = LOGGER;
            charSequence = new StringBuilder();
            string2 = "failed to register CONNECTIVITY receiver. cause: ";
            ((StringBuilder)charSequence).append(string2);
            object = securityException.getMessage();
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            ((AVLogger)object2).w((String)object);
        }
        object2 = new PushService$3(this);
        object = new AVShutdownReceiver((AVShutdownListener)object2);
        this.shutdownReceiver = object;
        charSequence = "android.intent.action.ACTION_SHUTDOWN";
        object2 = new IntentFilter((String)charSequence);
        try {
            this.registerReceiver((BroadcastReceiver)object, (IntentFilter)object2);
        }
        catch (SecurityException securityException) {
            object2 = LOGGER;
            charSequence = new StringBuilder();
            string2 = "failed to register SHUTDOWN receiver. cause: ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = securityException.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            ((AVLogger)object2).w(string3);
        }
        isStarted = bl3;
    }

    public void onDestroy() {
        Object object = LOGGER;
        Object object2 = "PushService#onDestroy";
        ((AVLogger)object).i((String)object2);
        object = this.connectionManager;
        ((AVConnectionManager)object).cleanup();
        int n10 = enableForegroundService;
        if (n10 != 0) {
            n10 = 1;
            this.stopForeground(n10 != 0);
        } else {
            int n11;
            String string2;
            Object object3;
            object = this.connectivityReceiver;
            this.unregisterReceiver((BroadcastReceiver)object);
            object = this.shutdownReceiver;
            try {
                this.unregisterReceiver((BroadcastReceiver)object);
            }
            catch (Exception exception) {
                object2 = LOGGER;
                object3 = new StringBuilder();
                string2 = "failed to unregister CONNECTIVITY/SHUTDOWN receiver. cause: ";
                ((StringBuilder)object3).append(string2);
                object = exception.getMessage();
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                ((AVLogger)object2).w((String)object);
            }
            object = null;
            isStarted = false;
            n10 = isAutoWakeUp;
            if (n10 != 0 && (n10 = Build.VERSION.SDK_INT) <= (n11 = 25)) {
                object = LOGGER;
                object2 = "Let's try to wake PushService again";
                ((AVLogger)object).i((String)object2);
                object2 = AVOSCloud.getContext();
                object3 = PushService.class;
                object = new Intent((Context)object2, (Class)object3);
                n11 = 0x10000000;
                object.addFlags(n11);
                try {
                    this.startService((Intent)object);
                }
                catch (Exception exception) {
                    object2 = LOGGER;
                    object3 = new StringBuilder();
                    string2 = "failed to start PushService. cause: ";
                    ((StringBuilder)object3).append(string2);
                    String string3 = exception.getMessage();
                    ((StringBuilder)object3).append(string3);
                    string3 = ((StringBuilder)object3).toString();
                    ((AVLogger)object2).e(string3);
                }
            }
        }
        super.onDestroy();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int onStartCommand(Intent intent, int n10, int n11) {
        boolean bl2;
        Object object;
        Object object2 = LOGGER;
        Object object3 = "PushService#onStartCommand";
        ((AVLogger)object2).i((String)object3);
        n11 = (int)(enableForegroundService ? 1 : 0);
        if (n11 != 0) {
            n11 = foregroundIdentifier;
            object = foregroundNotification;
            this.startForeground(n11, (Notification)object);
        } else {
            if (intent != null) {
                object3 = intent.getAction();
            } else {
                n11 = 0;
                object3 = null;
            }
            this.notifyOtherApplication((String)object3);
        }
        object3 = AppConfiguration.getGlobalNetworkingDetector();
        n11 = (int)(object3.isConnected() ? 1 : 0);
        if (n11 != 0 && !(bl2 = ((AVConnectionManager)(object = this.connectionManager)).isConnectionEstablished())) {
            object3 = "networking is fine and try to start connection to leancloud.";
            ((AVLogger)object2).d((String)object3);
            object = connecting;
            synchronized (object) {
                object2 = this.connectionManager;
                object3 = new PushService$4(this, intent);
                ((AVConnectionManager)object2).startConnection((AVCallback)object3);
                return 1;
            }
        }
        if (n11 != 0) {
            this.processIMRequests(intent);
            return 1;
        }
        object3 = "network is broken, try to re-connect to leancloud for user action.";
        ((AVLogger)object2).d((String)object3);
        object2 = this.connectionManager;
        n10 = (int)(((AVConnectionManager)object2).isConnectionEstablished() ? 1 : 0);
        if (n10 != 0) {
            object2 = this.connectionManager;
            ((AVConnectionManager)object2).cleanup();
        }
        object2 = connecting;
        synchronized (object2) {
            object3 = this.connectionManager;
            object = new PushService$5(this, intent);
            ((AVConnectionManager)object3).startConnection((AVCallback)object);
            return 1;
        }
    }

    public void onTaskRemoved(Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = isAutoWakeUp;
        if (n11 != 0) {
            LOGGER.i("try to restart service on task Removed");
            Object object = this.getApplicationContext();
            Object object2 = ((Object)((Object)this)).getClass();
            Intent intent2 = new Intent(object, object2);
            object = this.getPackageName();
            intent2.setPackage((String)object);
            int n12 = enableForegroundService;
            if (n12 != 0 && n10 >= (n12 = 26)) {
                this.startForegroundService(intent2);
            } else {
                object = this.getApplicationContext();
                int n13 = 0x8000000;
                intent2 = PendingIntent.getService((Context)object, (int)1, (Intent)intent2, (int)n13);
                object = this.getApplicationContext();
                object2 = "alarm";
                object = (AlarmManager)object.getSystemService((String)object2);
                int n14 = 3;
                long l10 = SystemClock.elapsedRealtime();
                long l11 = 500L;
                object.set(n14, l10 += l11, (PendingIntent)intent2);
            }
        }
        if (n10 >= (n11 = 14)) {
            super.onTaskRemoved(intent);
        }
    }
}

