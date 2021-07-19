/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ResolveInfo
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.BaseService;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MessageHandleService$a;
import com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult;
import com.xiaomi.mipush.sdk.MiPushClient$MiPushClientCallback;
import com.xiaomi.mipush.sdk.MiPushClient$TokenResult;
import com.xiaomi.mipush.sdk.MiPushClient$UPSRegisterCallBack;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.mipush.sdk.PushMessageHandler$a;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.am;
import com.xiaomi.mipush.sdk.an;
import com.xiaomi.mipush.sdk.n;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import com.xiaomi.push.hq;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class PushMessageHandler
extends BaseService {
    private static List a;
    private static ThreadPoolExecutor a;
    private static List b;

    static {
        Object object = new ArrayList();
        a = object;
        object = new ArrayList();
        b = object;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        a = object = new ThreadPoolExecutor(1, 1, 15, timeUnit, linkedBlockingQueue);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        List list = b;
        synchronized (list) {
            List list2 = b;
            list2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(long l10, String string2, String string3) {
        List list = b;
        synchronized (list) {
            Object object = b;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (MiPushClient$MiPushClientCallback)object2;
                ((MiPushClient$MiPushClientCallback)object2).onInitializeResult(l10, string2, string3);
            }
            return;
        }
    }

    public static void a(Context object) {
        Intent intent = new Intent();
        Class<PushMessageHandler> clazz = PushMessageHandler.class;
        ComponentName componentName = new ComponentName(object, clazz);
        intent.setComponent(componentName);
        try {
            object.startService(intent);
        }
        catch (Exception exception) {
            object = exception.getMessage();
            com.xiaomi.channel.commonutils.logger.b.a((String)object);
        }
    }

    public static void a(Context context, Intent intent) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "addjob PushMessageHandler ";
        charSequence.append(string2);
        charSequence.append(intent);
        charSequence = charSequence.toString();
        com.xiaomi.channel.commonutils.logger.b.c((String)charSequence);
        if (intent != null) {
            PushMessageHandler.c(context, intent);
            PushMessageHandler.a(context);
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo object) {
        object = object.activityInfo;
        object = object.name;
        object = t.a(context, (String)object);
        object = object.newInstance();
        object = (PushMessageReceiver)((Object)object);
        Object object2 = context.getApplicationContext();
        MessageHandleService$a messageHandleService$a = new MessageHandleService$a(intent, (PushMessageReceiver)((Object)object));
        MessageHandleService.addJob(object2, messageHandleService$a);
        object = context.getApplicationContext();
        object2 = MessageHandleService.class;
        intent = new Intent((Context)object, (Class)object2);
        try {
            MessageHandleService.a(context, intent);
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, MiPushCommandMessage miPushCommandMessage) {
        object = a;
        synchronized (object) {
            Object object2 = a;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                int n10;
                Object object3;
                Object object4 = object2.next();
                boolean bl3 = (object4 = (MiPushClient$ICallbackResult)object4) instanceof MiPushClient$UPSRegisterCallBack;
                if (!bl3) continue;
                MiPushClient$TokenResult miPushClient$TokenResult = new MiPushClient$TokenResult();
                if (miPushCommandMessage != null && (object3 = miPushCommandMessage.getCommandArguments()) != null && (n10 = (object3 = miPushCommandMessage.getCommandArguments()).size()) > 0) {
                    long l10 = miPushCommandMessage.getResultCode();
                    miPushClient$TokenResult.setResultCode(l10);
                    object3 = miPushCommandMessage.getCommandArguments();
                    object3 = object3.get(0);
                    object3 = (String)object3;
                    miPushClient$TokenResult.setToken((String)object3);
                }
                ((MiPushClient$ICallbackResult)object4).onResult(miPushClient$TokenResult);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, MiPushMessage miPushMessage) {
        object = b;
        synchronized (object) {
            Object object2 = b;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                String string2;
                Object object3 = object2.next();
                object3 = (MiPushClient$MiPushClientCallback)object3;
                String string3 = miPushMessage.getCategory();
                boolean bl3 = PushMessageHandler.a(string3, string2 = ((MiPushClient$MiPushClientCallback)object3).getCategory());
                if (!bl3) continue;
                string3 = miPushMessage.getContent();
                string2 = miPushMessage.getAlias();
                String string4 = miPushMessage.getTopic();
                boolean bl4 = miPushMessage.isNotified();
                ((MiPushClient$MiPushClientCallback)object3).onReceiveMessage(string3, string2, string4, bl4);
                ((MiPushClient$MiPushClientCallback)object3).onReceiveMessage(miPushMessage);
            }
            return;
        }
    }

    public static void a(Context object, PushMessageHandler$a pushMessageHandler$a) {
        boolean bl2 = pushMessageHandler$a instanceof MiPushMessage;
        if (bl2) {
            pushMessageHandler$a = (MiPushMessage)pushMessageHandler$a;
            PushMessageHandler.a(object, (MiPushMessage)pushMessageHandler$a);
        } else {
            bl2 = pushMessageHandler$a instanceof MiPushCommandMessage;
            if (bl2) {
                pushMessageHandler$a = (MiPushCommandMessage)pushMessageHandler$a;
                String string2 = ((MiPushCommandMessage)pushMessageHandler$a).getCommand();
                Object object2 = fg.a.a;
                bl2 = ((String)object2).equals(string2);
                String string3 = null;
                Object object3 = null;
                if (bl2) {
                    object = ((MiPushCommandMessage)pushMessageHandler$a).getCommandArguments();
                    if (object != null && !(bl2 = object.isEmpty())) {
                        object3 = object = object.get(0);
                        object3 = (String)object;
                    }
                    long l10 = ((MiPushCommandMessage)pushMessageHandler$a).getResultCode();
                    object = ((MiPushCommandMessage)pushMessageHandler$a).getReason();
                    PushMessageHandler.a(l10, (String)object, object3);
                } else {
                    object2 = fg.c.a;
                    bl2 = ((String)object2).equals(string2);
                    if (!(bl2 || (bl2 = ((String)(object2 = fg.d.a)).equals(string2)) || (bl2 = ((String)(object2 = fg.i.a)).equals(string2)))) {
                        object2 = fg.g.a;
                        bl2 = ((String)object2).equals(string2);
                        if (bl2) {
                            boolean bl3;
                            object2 = ((MiPushCommandMessage)pushMessageHandler$a).getCommandArguments();
                            if (object2 != null && !(bl3 = object2.isEmpty())) {
                                object2 = object2.get(0);
                                object3 = object2;
                                object3 = (String)object2;
                            }
                            String string4 = ((MiPushCommandMessage)pushMessageHandler$a).getCategory();
                            long l11 = ((MiPushCommandMessage)pushMessageHandler$a).getResultCode();
                            String string5 = ((MiPushCommandMessage)pushMessageHandler$a).getReason();
                            PushMessageHandler.a(object, string4, l11, string5, (String)object3);
                        } else {
                            object2 = fg.h.a;
                            bl2 = ((String)object2).equals(string2);
                            if (bl2) {
                                boolean bl4;
                                object2 = ((MiPushCommandMessage)pushMessageHandler$a).getCommandArguments();
                                if (object2 != null && !(bl4 = object2.isEmpty())) {
                                    object2 = object2.get(0);
                                    object3 = object2;
                                    object3 = (String)object2;
                                }
                                String string6 = ((MiPushCommandMessage)pushMessageHandler$a).getCategory();
                                long l12 = ((MiPushCommandMessage)pushMessageHandler$a).getResultCode();
                                String string7 = ((MiPushCommandMessage)pushMessageHandler$a).getReason();
                                PushMessageHandler.b(object, string6, l12, string7, (String)object3);
                            }
                        }
                    } else {
                        string3 = ((MiPushCommandMessage)pushMessageHandler$a).getCategory();
                        long l13 = ((MiPushCommandMessage)pushMessageHandler$a).getResultCode();
                        String string8 = ((MiPushCommandMessage)pushMessageHandler$a).getReason();
                        List list = ((MiPushCommandMessage)pushMessageHandler$a).getCommandArguments();
                        object2 = object;
                        PushMessageHandler.a(object, string3, string2, l13, string8, list);
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, String string2, long l10, String string3, String string4) {
        object = b;
        synchronized (object) {
            Object object2 = b;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                String string5 = ((MiPushClient$MiPushClientCallback)(object3 = (MiPushClient$MiPushClientCallback)object3)).getCategory();
                boolean bl3 = PushMessageHandler.a(string2, string5);
                if (!bl3) continue;
                ((MiPushClient$MiPushClientCallback)object3).onSubscribeResult(l10, string3, string4);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, String string2, String string3, long l10, String string4, List list) {
        object = b;
        synchronized (object) {
            Object object2 = b;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                Object object4 = object3;
                object4 = (MiPushClient$MiPushClientCallback)object3;
                bl2 = PushMessageHandler.a(string2, object3 = ((MiPushClient$MiPushClientCallback)object4).getCategory());
                if (!bl2) continue;
                ((MiPushClient$MiPushClientCallback)object4).onCommandResult(string3, l10, string4, list);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(MiPushClient$ICallbackResult miPushClient$ICallbackResult) {
        List list = a;
        synchronized (list) {
            List list2 = a;
            boolean bl2 = list2.contains(miPushClient$ICallbackResult);
            if (!bl2) {
                list2 = a;
                list2.add(miPushClient$ICallbackResult);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(MiPushClient$MiPushClientCallback miPushClient$MiPushClientCallback) {
        List list = b;
        synchronized (list) {
            List list2 = b;
            boolean bl2 = list2.contains(miPushClient$MiPushClientCallback);
            if (!bl2) {
                list2 = b;
                list2.add(miPushClient$MiPushClientCallback);
            }
            return;
        }
    }

    public static boolean a(String string2, String string3) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)string3)) || (bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)string3))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        List list = a;
        synchronized (list) {
            List list2 = a;
            list2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(Context object, Intent intent) {
        Object object2 = "com.xiaomi.mipush.sdk.WAKEUP";
        try {
            Object object3 = intent.getAction();
            int n10 = ((String)object2).equals(object3);
            object3 = null;
            if (n10 != 0) {
                n.a(object, intent, null);
                return;
            }
            object2 = "com.xiaomi.mipush.SEND_TINYDATA";
            Object object4 = intent.getAction();
            n10 = ((String)object2).equals(object4);
            if (n10 != 0) {
                object2 = new hq();
                object3 = "mipush_payload";
                object3 = intent.getByteArrayExtra((String)object3);
                iw.a((ix)object2, (byte[])object3);
                object3 = new StringBuilder();
                object4 = "PushMessageHandler.onHandleIntent ";
                ((StringBuilder)object3).append((String)object4);
                object4 = ((hq)object2).d();
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                com.xiaomi.channel.commonutils.logger.b.c((String)object3);
                MiTinyDataClient.upload(object, (hq)object2);
                return;
            }
            n10 = 1;
            int n11 = PushMessageHelper.getPushMode(object);
            if (n10 == n11) {
                n10 = (int)(PushMessageHandler.b() ? 1 : 0);
                if (n10 != 0) {
                    object2 = "receive a message before application calling initialize";
                    com.xiaomi.channel.commonutils.logger.b.d((String)object2);
                    return;
                }
                object2 = an.a(object);
                if ((object2 = ((an)object2).a(intent)) == null) return;
                PushMessageHandler.a(object, (PushMessageHandler$a)object2);
                return;
            }
            object2 = "com.xiaomi.mipush.sdk.SYNC_LOG";
            object4 = intent.getAction();
            n10 = (int)(((String)object2).equals(object4) ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                object2 = null;
                Logger.uploadLogFile(object, false);
                return;
            }
            object4 = "com.xiaomi.mipush.RECEIVE_MESSAGE";
            object2 = new Intent((String)object4);
            object4 = object.getPackageName();
            object2.setPackage((String)object4);
            object2.putExtras(intent);
            object4 = object.getPackageManager();
            int n12 = 32;
            try {
                object4 = object4.queryBroadcastReceivers((Intent)object2, n12);
                if (object4 != null) {
                    object4 = object4.iterator();
                    while ((n12 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                        Object object5;
                        boolean bl2;
                        Object object6 = object4.next();
                        object6 = (ResolveInfo)object6;
                        Object object7 = ((ResolveInfo)object6).activityInfo;
                        if (object7 == null || !(bl2 = ((String)(object7 = ((ActivityInfo)object7).packageName)).equals(object5 = object.getPackageName()))) continue;
                        object7 = PushMessageReceiver.class;
                        object5 = ((ResolveInfo)object6).activityInfo;
                        object5 = ((ActivityInfo)object5).name;
                        bl2 = ((Class)object7).isAssignableFrom((Class<?>)(object5 = t.a(object, (String)object5)));
                        if (!bl2) continue;
                        object3 = object6;
                        break;
                    }
                }
                if (object3 != null) {
                    PushMessageHandler.a(object, (Intent)object2, (ResolveInfo)object3);
                    return;
                }
                object2 = "cannot find the receiver to handler this message, check your manifest";
                com.xiaomi.channel.commonutils.logger.b.d((String)object2);
                object2 = fb.a(object);
                object3 = object.getPackageName();
                object4 = "11";
                ((fb)object2).a((String)object3, intent, (String)object4);
                return;
            }
            catch (Exception exception) {
                com.xiaomi.channel.commonutils.logger.b.a(exception);
                fb fb2 = fb.a(object);
                object3 = object.getPackageName();
                object4 = "9";
                fb2.a((String)object3, intent, (String)object4);
                return;
            }
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
            object2 = fb.a(object);
            object = object.getPackageName();
            String string2 = "10";
            ((fb)object2).a((String)object, intent, string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(Context object, String string2, long l10, String string3, String string4) {
        object = b;
        synchronized (object) {
            Object object2 = b;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                String string5 = ((MiPushClient$MiPushClientCallback)(object3 = (MiPushClient$MiPushClientCallback)object3)).getCategory();
                boolean bl3 = PushMessageHandler.a(string2, string5);
                if (!bl3) continue;
                ((MiPushClient$MiPushClientCallback)object3).onUnsubscribeResult(l10, string3, string4);
            }
            return;
        }
    }

    public static boolean b() {
        return b.isEmpty();
    }

    private static void c(Context context, Intent intent) {
        ThreadPoolExecutor threadPoolExecutor;
        boolean bl2;
        if (intent != null && !(bl2 = (threadPoolExecutor = a).isShutdown())) {
            threadPoolExecutor = a;
            am am2 = new am(context, intent);
            threadPoolExecutor.execute(am2);
        }
    }

    public boolean a() {
        int n10;
        Object object = a;
        if (object != null && (object = ((ThreadPoolExecutor)object).getQueue()) != null && (n10 = (object = a.getQueue()).size()) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int n10) {
        super.onStart(intent, n10);
        PushMessageHandler.c(this.getApplicationContext(), intent);
    }
}

