/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushServiceReceiver;
import com.xiaomi.push.hz;
import com.xiaomi.push.ip;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String string2, List list, long l10, String string3, String string4) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(string2);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(l10);
        miPushCommandMessage.setReason(string3);
        miPushCommandMessage.setCategory(string4);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(ip object, hz hz2, boolean bl2) {
        MiPushMessage miPushMessage = new MiPushMessage();
        Object object2 = ((ip)object).a();
        miPushMessage.setMessageId((String)object2);
        object2 = ((ip)object).d();
        boolean n10 = TextUtils.isEmpty((CharSequence)object2);
        if (!n10) {
            int n11 = 1;
            miPushMessage.setMessageType(n11);
            object2 = ((ip)object).d();
            miPushMessage.setAlias((String)object2);
        } else {
            object2 = ((ip)object).c();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                int n12 = 2;
                miPushMessage.setMessageType(n12);
                object2 = ((ip)object).c();
                miPushMessage.setTopic((String)object2);
            } else {
                object2 = ((ip)object).f();
                boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl4) {
                    int n13 = 3;
                    miPushMessage.setMessageType(n13);
                    object2 = ((ip)object).f();
                    miPushMessage.setUserAccount((String)object2);
                } else {
                    boolean bl5 = false;
                    object2 = null;
                    miPushMessage.setMessageType(0);
                }
            }
        }
        object2 = ((ip)object).e();
        miPushMessage.setCategory((String)object2);
        object2 = ((ip)object).a();
        if (object2 != null) {
            object = ((ip)object).a().c();
            miPushMessage.setContent((String)object);
        }
        if (hz2 != null) {
            object = miPushMessage.getMessageId();
            int n14 = TextUtils.isEmpty((CharSequence)object);
            if (n14 != 0) {
                object = hz2.a();
                miPushMessage.setMessageId((String)object);
            }
            if ((n14 = TextUtils.isEmpty((CharSequence)(object = miPushMessage.getTopic()))) != 0) {
                object = hz2.b();
                miPushMessage.setTopic((String)object);
            }
            object = hz2.d();
            miPushMessage.setDescription((String)object);
            object = hz2.c();
            miPushMessage.setTitle((String)object);
            n14 = hz2.a();
            miPushMessage.setNotifyType(n14);
            n14 = hz2.c();
            miPushMessage.setNotifyId(n14);
            n14 = hz2.b();
            miPushMessage.setPassThrough(n14);
            object = hz2.a();
            miPushMessage.setExtra((Map)object);
        }
        miPushMessage.setNotified(bl2);
        return miPushMessage;
    }

    public static hz generateMessage(MiPushMessage object) {
        hz hz2 = new hz();
        String string2 = ((MiPushMessage)object).getMessageId();
        hz2.a(string2);
        string2 = ((MiPushMessage)object).getTopic();
        hz2.b(string2);
        string2 = ((MiPushMessage)object).getDescription();
        hz2.d(string2);
        string2 = ((MiPushMessage)object).getTitle();
        hz2.c(string2);
        int n10 = ((MiPushMessage)object).getNotifyId();
        hz2.c(n10);
        n10 = ((MiPushMessage)object).getNotifyType();
        hz2.a(n10);
        n10 = ((MiPushMessage)object).getPassThrough();
        hz2.b(n10);
        object = ((MiPushMessage)object).getExtra();
        hz2.a((Map)object);
        return hz2;
    }

    public static int getPushMode(Context context) {
        int n10 = pushMode;
        if (n10 == 0) {
            int n11 = PushMessageHelper.isUseCallbackPushMode(context);
            n11 = n11 != 0 ? 1 : 2;
            PushMessageHelper.setPushMode(n11);
        }
        return pushMode;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean isIntentAvailable(Context object, Intent intent) {
        object = object.getPackageManager();
        int n10 = 32;
        boolean bl2 = true;
        try {
            object = object.queryBroadcastReceivers(intent, n10);
            if (object == null) return false;
        }
        catch (Exception exception) {
            return bl2;
        }
        boolean bl3 = object.isEmpty();
        if (bl3) return false;
        return bl2;
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        String string2 = context.getPackageName();
        intent.setClassName(string2, "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return PushMessageHelper.isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage object) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        String string2 = context.getPackageName();
        intent.setPackage(string2);
        intent.putExtra(MESSAGE_TYPE, 3);
        intent.putExtra(KEY_COMMAND, (Serializable)object);
        object = new PushServiceReceiver();
        ((PushServiceReceiver)((Object)object)).onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        Object object = context.getPackageName();
        intent.setPackage((String)object);
        intent.putExtra(MESSAGE_TYPE, 4);
        object = new PushServiceReceiver();
        ((PushServiceReceiver)((Object)object)).onReceive(context, intent);
    }

    private static void setPushMode(int n10) {
        pushMode = n10;
    }
}

