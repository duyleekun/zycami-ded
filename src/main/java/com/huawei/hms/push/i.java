/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.e;
import com.huawei.hms.push.j;
import com.huawei.hms.push.k;
import com.huawei.hms.push.p;
import com.huawei.hms.push.q;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

public class i {
    public static void a(Context object, Intent object2) {
        block15: {
            String string2 = "PushSelfShowLog";
            if (object != null && object2 != null) {
                block16: {
                    Object object3;
                    Object object4;
                    block14: {
                        object4 = object2.getAction();
                        object3 = "com.huawei.intent.action.PUSH";
                        boolean bl2 = ((String)object3).equals(object4);
                        if (bl2) break block14;
                        object3 = "com.huawei.push.msg.NOTIFY_MSG";
                        bl2 = ((String)object3).equals(object4);
                        if (bl2) break block14;
                        object3 = "com.huawei.intent.action.PUSH_DELAY_NOTIFY";
                        boolean bl3 = ((String)object3).equals(object4);
                        if (!bl3) break block15;
                    }
                    object4 = "selfshow_info";
                    object4 = object2.getByteArrayExtra((String)object4);
                    object3 = "selfshow_token";
                    object3 = object2.getByteArrayExtra((String)object3);
                    if (object4 == null || object3 == null) break block16;
                    int n10 = ((Object)object4).length;
                    if (n10 == 0) break block16;
                    n10 = ((Object)object3).length;
                    if (n10 == 0) break block16;
                    i.a(object, object2, (byte[])object4, (byte[])object3);
                }
                object = "self show info or token is null.";
                HMSLog.i(string2, (String)object);
                return;
            }
            object = "enter SelfShowReceiver receiver, context or intent is null";
            try {
                HMSLog.d(string2, (String)object);
                return;
            }
            catch (Exception exception) {
                object = "onReceive Exception.";
                HMSLog.d(string2, (String)object);
            }
            catch (RuntimeException runtimeException) {
                object2 = "onReceive RuntimeException.";
                HMSLog.e(string2, (String)object2, runtimeException);
            }
        }
    }

    public static void a(Context context, Intent object, k object2) {
        long l10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("receive a selfshow message, the cmd type is ");
        String string2 = ((k)object2).i();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = "PushSelfShowLog";
        HMSLog.i(string2, (String)charSequence);
        charSequence = ((k)object2).i();
        Object object3 = j.b((String)charSequence);
        if (!object3) {
            return;
        }
        charSequence = ((k)object2).c();
        long l11 = q.a((String)charSequence);
        long l12 = l11 - (l10 = 0L);
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object3) {
            object = new p(context, (k)object2);
            ((Thread)object).start();
        } else {
            HMSLog.d(string2, "waiting...");
            object2 = context.getPackageName();
            object.setPackage((String)object2);
            q.a(context, (Intent)object, l11);
        }
    }

    public static void a(Context object, Intent object2, String string2, k object3, int n10) {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("receive a selfshow user handle message eventId = ");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        String string3 = "PushSelfShowLog";
        HMSLog.d(string3, (String)charSequence);
        charSequence = "-1";
        boolean bl2 = ((String)charSequence).equals(string2);
        if (!bl2) {
            q.a(object, (Intent)object2);
        } else {
            q.a(object, n10);
        }
        object2 = "1";
        boolean bl3 = ((String)object2).equals(string2);
        if (bl3) {
            object2 = new j((Context)object, (k)object3);
            ((j)object2).c();
            object2 = ((k)object3).p();
            string2 = ((k)object3).b();
            PluginUtil.onNotificationClicked(object, (String)object2, string2);
        } else {
            object2 = "2";
            boolean bl4 = ((String)object2).equals(string2);
            if (bl4) {
                string2 = ((k)object3).p();
                object3 = ((k)object3).b();
                e.a(object, string2, (String)object3, (String)object2);
            } else {
                object = "other event";
                HMSLog.d(string3, (String)object);
            }
        }
    }

    public static void a(Context context, Intent intent, byte[] object, byte[] object2) {
        String string2 = intent.getStringExtra("selfshow_event_id");
        String string3 = "selfshow_notify_id";
        int n10 = intent.getIntExtra(string3, 0);
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("get notifyId:");
        ((StringBuilder)object3).append(n10);
        object3 = ((StringBuilder)object3).toString();
        String string4 = "PushSelfShowLog";
        HMSLog.i(string4, (String)object3);
        object3 = new k((byte[])object, (byte[])object2);
        boolean bl2 = ((k)object3).z();
        if (!bl2) {
            HMSLog.d(string4, "parseMessage failed");
            return;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("onReceive the msg id = ");
        object2 = ((k)object3).p();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(",and cmd is ");
        object2 = ((k)object3).i();
        ((StringBuilder)object).append((String)object2);
        object2 = ",and the eventId is ";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        HMSLog.i(string4, (String)object);
        if (string2 == null) {
            i.a(context, intent, (k)object3);
        } else {
            i.a(context, intent, string2, (k)object3, n10);
        }
    }
}

