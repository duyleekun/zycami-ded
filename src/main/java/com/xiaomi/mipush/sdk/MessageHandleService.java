/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.BaseService;
import com.xiaomi.mipush.sdk.MessageHandleService$a;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.aa;
import com.xiaomi.mipush.sdk.ab;
import com.xiaomi.mipush.sdk.an;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.push.ai;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class MessageHandleService
extends BaseService {
    private static ConcurrentLinkedQueue a;
    private static ExecutorService a;

    static {
        Object object = new ConcurrentLinkedQueue();
        a = object;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        a = object = new ThreadPoolExecutor(1, 1, 15, timeUnit, linkedBlockingQueue);
    }

    public static /* synthetic */ void a(Context context) {
        MessageHandleService.c(context);
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        MessageHandleService.b(context);
    }

    public static void addJob(Context context, MessageHandleService$a messageHandleService$a) {
        if (messageHandleService$a != null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = a;
            concurrentLinkedQueue.add(messageHandleService$a);
            MessageHandleService.b(context);
            MessageHandleService.startService(context);
        }
    }

    private static void b(Context context) {
        ExecutorService executorService = a;
        boolean bl2 = executorService.isShutdown();
        if (!bl2) {
            executorService = a;
            ab ab2 = new ab(context);
            executorService.execute(ab2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void c(Context context) {
        try {
            Object object = a;
            object = ((ConcurrentLinkedQueue)object).poll();
            object = (MessageHandleService$a)object;
            if (object == null) {
                return;
            }
            PushMessageReceiver pushMessageReceiver = ((MessageHandleService$a)object).a();
            object = ((MessageHandleService$a)object).a();
            Object object2 = "message_type";
            int n10 = 1;
            int n11 = object.getIntExtra((String)object2, n10);
            long l10 = 0L;
            String string2 = ", reason=";
            String string3 = ", resultCode=";
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 5;
                    if (n11 != n10) {
                        return;
                    }
                    object2 = "error_type";
                    String string4 = "error_lack_of_permission";
                    n11 = (int)(string4.equals(object2 = object.getStringExtra((String)object2)) ? 1 : 0);
                    if (n11 == 0) return;
                    object2 = "error_message";
                    if ((object = object.getStringArrayExtra((String)object2)) == null) return;
                    object2 = "begin execute onRequirePermissions, lack of necessary permissions";
                    b.a((String)object2);
                    pushMessageReceiver.onRequirePermissions(context, (String[])object);
                    return;
                }
                object2 = "key_command";
                object = object.getSerializableExtra((String)object2);
                object = (MiPushCommandMessage)object;
                object2 = new StringBuilder();
                Object object3 = "(Local) begin execute onCommandResult, command=";
                ((StringBuilder)object2).append((String)object3);
                object3 = ((MiPushCommandMessage)object).getCommand();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(string3);
                long l11 = ((MiPushCommandMessage)object).getResultCode();
                ((StringBuilder)object2).append(l11);
                ((StringBuilder)object2).append(string2);
                object3 = ((MiPushCommandMessage)object).getReason();
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                b.a((String)object2);
                pushMessageReceiver.onCommandResult(context, (MiPushCommandMessage)object);
                object2 = ((MiPushCommandMessage)object).getCommand();
                object3 = fg.a;
                object3 = ((fg)object3).a;
                n11 = (int)(TextUtils.equals((CharSequence)object2, (CharSequence)object3) ? 1 : 0);
                if (n11 == 0) return;
                pushMessageReceiver.onReceiveRegisterResult(context, (MiPushCommandMessage)object);
                PushMessageHandler.a(context, (MiPushCommandMessage)object);
                long l12 = ((MiPushCommandMessage)object).getResultCode();
                long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (l13 != false) return;
            } else {
                object2 = an.a(context);
                object2 = ((an)object2).a((Intent)object);
                String string5 = "eventMessageType";
                int n12 = -1;
                int n13 = object.getIntExtra(string5, n12);
                if (object2 == null) return;
                n12 = object2 instanceof MiPushMessage;
                if (n12 != 0) {
                    Object object4;
                    object2 = (MiPushMessage)object2;
                    int n14 = ((MiPushMessage)object2).isArrivedMessage();
                    if (n14 == 0) {
                        pushMessageReceiver.onReceiveMessage(context, (MiPushMessage)object2);
                    }
                    if ((n14 = ((MiPushMessage)object2).getPassThrough()) == n10) {
                        Object object5 = context.getApplicationContext();
                        object5 = fb.a((Context)object5);
                        String string6 = context.getPackageName();
                        int n15 = 2004;
                        ((fb)object5).a(string6, (Intent)object, n15, null);
                        object = new StringBuilder();
                        object5 = "begin execute onReceivePassThroughMessage from ";
                        ((StringBuilder)object).append((String)object5);
                        object5 = ((MiPushMessage)object2).getMessageId();
                        ((StringBuilder)object).append((String)object5);
                        object = ((StringBuilder)object).toString();
                        b.a((String)object);
                        pushMessageReceiver.onReceivePassThroughMessage(context, (MiPushMessage)object2);
                        return;
                    }
                    n10 = (int)(((MiPushMessage)object2).isNotified() ? 1 : 0);
                    if (n10 == 0) {
                        pushMessageReceiver.onNotificationMessageArrived(context, (MiPushMessage)object2);
                        return;
                    }
                    n10 = 1000;
                    if (n13 == n10) {
                        object4 = context.getApplicationContext();
                        object4 = fb.a((Context)object4);
                        String string7 = context.getPackageName();
                        int n16 = 1007;
                        ((fb)object4).a(string7, (Intent)object, n16, null);
                    } else {
                        object4 = context.getApplicationContext();
                        object4 = fb.a((Context)object4);
                        String string8 = context.getPackageName();
                        int n17 = 3007;
                        ((fb)object4).a(string8, (Intent)object, n17, null);
                    }
                    object = new StringBuilder();
                    object4 = "begin execute onNotificationMessageClicked from\u3000";
                    ((StringBuilder)object).append((String)object4);
                    object4 = ((MiPushMessage)object2).getMessageId();
                    ((StringBuilder)object).append((String)object4);
                    object = ((StringBuilder)object).toString();
                    b.a((String)object);
                    pushMessageReceiver.onNotificationMessageClicked(context, (MiPushMessage)object2);
                    return;
                }
                boolean bl2 = object2 instanceof MiPushCommandMessage;
                if (!bl2) return;
                object2 = (MiPushCommandMessage)object2;
                object = new StringBuilder();
                Object object6 = "begin execute onCommandResult, command=";
                ((StringBuilder)object).append((String)object6);
                object6 = ((MiPushCommandMessage)object2).getCommand();
                ((StringBuilder)object).append((String)object6);
                ((StringBuilder)object).append(string3);
                long l14 = ((MiPushCommandMessage)object2).getResultCode();
                ((StringBuilder)object).append(l14);
                ((StringBuilder)object).append(string2);
                object6 = ((MiPushCommandMessage)object2).getReason();
                ((StringBuilder)object).append((String)object6);
                object = ((StringBuilder)object).toString();
                b.a((String)object);
                pushMessageReceiver.onCommandResult(context, (MiPushCommandMessage)object2);
                object = ((MiPushCommandMessage)object2).getCommand();
                object6 = fg.a;
                object6 = ((fg)object6).a;
                bl2 = TextUtils.equals((CharSequence)object, (CharSequence)object6);
                if (!bl2) return;
                pushMessageReceiver.onReceiveRegisterResult(context, (MiPushCommandMessage)object2);
                PushMessageHandler.a(context, (MiPushCommandMessage)object2);
                long l15 = ((MiPushCommandMessage)object2).getResultCode();
                bl2 = l15 == l10 ? 0 : (l15 < l10 ? -1 : 1);
                if (bl2) return;
            }
            h.b(context);
            return;
        }
        catch (RuntimeException runtimeException) {
            b.a(runtimeException);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        Object object = new ComponentName(context, MessageHandleService.class);
        intent.setComponent((ComponentName)object);
        object = ai.a(context);
        aa aa2 = new aa(context, intent);
        ((ai)object).a(aa2);
    }

    public boolean a() {
        boolean bl2;
        ConcurrentLinkedQueue concurrentLinkedQueue = a;
        if (concurrentLinkedQueue != null && (bl2 = concurrentLinkedQueue.size()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            concurrentLinkedQueue = null;
        }
        return bl2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int n10) {
        super.onStart(intent, n10);
    }
}

