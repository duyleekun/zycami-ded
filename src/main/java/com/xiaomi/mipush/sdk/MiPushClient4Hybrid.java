/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushClient4Hybrid$MiPushCallback;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xiaomi.mipush.sdk.an;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.b$a;
import com.xiaomi.push.bf;
import com.xiaomi.push.fg;
import com.xiaomi.push.g;
import com.xiaomi.push.g$a;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.i;
import com.xiaomi.push.ia;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.l;
import com.xiaomi.push.service.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiPushClient4Hybrid {
    private static Map dataMap;
    private static MiPushClient4Hybrid$MiPushCallback sCallback;
    private static Map sRegisterTimeMap;

    static {
        HashMap hashMap;
        dataMap = hashMap = new HashMap();
        sRegisterTimeMap = hashMap = new HashMap();
    }

    private static void addPullNotificationTime(Context context, String string2) {
        context = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last_pull_notification_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        context = context.edit();
        long l10 = System.currentTimeMillis();
        context.putLong(string2, l10).commit();
    }

    private static short getDeviceStatus(MiPushMessage object, boolean bl2) {
        Object object2 = ((MiPushMessage)object).getExtra();
        if (object2 == null) {
            object = "";
        } else {
            object = ((MiPushMessage)object).getExtra();
            object2 = "__hybrid_device_status";
            object = (String)object.get(object2);
        }
        int n10 = 0;
        object2 = null;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            object = Integer.valueOf((String)object);
            n10 = (Integer)object;
        }
        if (!bl2) {
            int n11 = n10 & 0xFFFFFFFC;
            g$a g$a = g$a.c;
            int n12 = g$a.a();
            n10 = n11 + n12;
        }
        return (short)n10;
    }

    public static boolean isRegistered(Context object, String string2) {
        boolean bl2;
        if ((object = b.a(object).a(string2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static void onReceiveRegisterResult(Context object, in object2) {
        Object object3;
        String string2;
        Object object4;
        long l10;
        String string3 = ((in)object2).b();
        long l11 = ((in)object2).a();
        long l12 = l11 - (l10 = 0L);
        Object object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object5 == false && (object4 = (b$a)dataMap.get(string3)) != null) {
            string2 = ((in)object2).e;
            object3 = ((in)object2).f;
            ((b$a)object4).a(string2, (String)object3);
            object = b.a((Context)object);
            ((b)object).a(string3, (b$a)object4);
        }
        object = null;
        object4 = ((in)object2).e;
        object5 = TextUtils.isEmpty((CharSequence)object4);
        if (object5 == false) {
            object = new ArrayList();
            object4 = ((in)object2).e;
            object.add(object4);
        }
        object3 = object;
        string2 = fg.a.a;
        long l13 = ((in)object2).a;
        String string4 = ((in)object2).d;
        object = PushMessageHelper.generateCommandMessage(string2, (List)object3, l13, string4, null);
        object2 = sCallback;
        if (object2 != null) {
            ((MiPushClient4Hybrid$MiPushCallback)object2).onReceiveRegisterResult(string3, (MiPushCommandMessage)object);
        }
    }

    public static void onReceiveUnregisterResult(Context object, it object2) {
        Object object3 = fg.b.a;
        long l10 = ((it)object2).a;
        String string2 = ((it)object2).d;
        object = PushMessageHelper.generateCommandMessage((String)object3, null, l10, string2, null);
        object2 = ((it)object2).a();
        object3 = sCallback;
        if (object3 != null) {
            ((MiPushClient4Hybrid$MiPushCallback)object3).onReceiveUnregisterResult((String)object2, (MiPushCommandMessage)object);
        }
    }

    public static void registerPush(Context object, String object2, String object3, String object4) {
        Object object5 = b.a((Context)object);
        boolean n10 = ((b)object5).a((String)object3, (String)object4, (String)object2);
        if (n10) {
            boolean bl5;
            Object object9;
            Object object8 = new Object();
            object4 = b.a((Context)object).a((String)object2);
            if (object4 != null) {
                object4 = ((b$a)object4).c;
                object8.add(object4);
                object9 = fg.a.a;
                long l10 = 0L;
                object4 = PushMessageHelper.generateCommandMessage((String)object9, object8, l10, null, null);
                object5 = sCallback;
                if (object5 != null) {
                    ((MiPushClient4Hybrid$MiPushCallback)object5).onReceiveRegisterResult((String)object2, (MiPushCommandMessage)object4);
                }
            }
            if (bl5 = MiPushClient4Hybrid.shouldPullNotification((Context)object, (String)object2)) {
                object9 = new il();
                ((il)object9).b((String)object3);
                object4 = hw.j.a;
                ((il)object9).c((String)object4);
                object4 = com.xiaomi.push.service.an.a();
                ((il)object9).a((String)object4);
                bl5 = false;
                object4 = null;
                ((il)object9).a(false);
                object5 = aq.a((Context)object);
                object8 = hm.i;
                boolean bl2 = true;
                ((aq)object5).a((ix)object9, (hm)((Object)object8), false, bl2, null, false, (String)object2, (String)object3);
                object3 = "MiPushClient4Hybrid pull offline pass through message";
                com.xiaomi.channel.commonutils.logger.b.b((String)object3);
                MiPushClient4Hybrid.addPullNotificationTime((Context)object, (String)object2);
            }
        } else {
            boolean bl3;
            long l11;
            long l12 = System.currentTimeMillis();
            Object object6 = sRegisterTimeMap.get(object2);
            if (object6 != null) {
                object6 = (Long)sRegisterTimeMap.get(object2);
                l11 = (Long)object6;
            } else {
                l11 = 0L;
            }
            l11 = Math.abs(l12 - l11);
            long l13 = 5000L;
            long l14 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
            if (l14 < 0) {
                com.xiaomi.channel.commonutils.logger.b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
                return;
            }
            object6 = sRegisterTimeMap;
            object5 = l12;
            object6.put(object2, object5);
            int n11 = 6;
            object5 = bf.a(n11);
            Object object7 = new b$a((Context)object);
            ((b$a)object7).c((String)object3, (String)object4, (String)object5);
            dataMap.put(object2, object7);
            object7 = new im();
            object6 = com.xiaomi.push.service.an.a();
            ((im)object7).a((String)object6);
            ((im)object7).b((String)object3);
            ((im)object7).e((String)object4);
            ((im)object7).d((String)object2);
            ((im)object7).f((String)object5);
            object2 = object.getPackageName();
            object2 = g.a((Context)object, (String)object2);
            ((im)object7).c((String)object2);
            object2 = object.getPackageName();
            int n12 = g.a((Context)object, (String)object2);
            ((im)object7).b(n12);
            ((im)object7).h("3_7_5");
            ((im)object7).a(30705);
            object2 = i.e((Context)object);
            ((im)object7).i((String)object2);
            object2 = ia.c;
            ((im)object7).a((ia)((Object)object2));
            n12 = (int)(l.d() ? 1 : 0);
            if (n12 == 0 && !(bl3 = TextUtils.isEmpty((CharSequence)(object2 = i.g((Context)object))))) {
                object2 = bf.a((String)object2);
                ((im)object7).k((String)object2);
            }
            object2 = i.a();
            ((im)object7).j((String)object2);
            n12 = i.a();
            if (n12 >= 0) {
                ((im)object7).c(n12);
            }
            object2 = new il();
            object3 = hw.I.a;
            ((il)object2).c((String)object3);
            object3 = b.a((Context)object).a();
            ((il)object2).b((String)object3);
            object3 = object.getPackageName();
            ((il)object2).d((String)object3);
            object3 = iw.a((ix)object7);
            ((il)object2).a((byte[])object3);
            object3 = com.xiaomi.push.service.an.a();
            ((il)object2).a((String)object3);
            object = aq.a((Context)object);
            object3 = hm.i;
            boolean bl4 = false;
            object4 = null;
            ((aq)object).a((ix)object2, (hm)((Object)object3), null);
        }
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        Object object = miPushMessage.getExtra();
        if (object != null) {
            object = miPushMessage.getExtra();
            String string2 = "jobkey";
            object = (String)object.get(string2);
        } else {
            object = null;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = miPushMessage.getMessageId();
        }
        an.a(context, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void reportMessageArrived(Context object, MiPushMessage miPushMessage, boolean bl2) {
        Object object2;
        String string2 = "__hybrid_device_status";
        String string3 = "__hybrid_message_ts";
        if (miPushMessage != null && (object2 = miPushMessage.getExtra()) != null) {
            try {
                object2 = new ic();
                b b10 = b.a((Context)object);
                String string4 = b10.a();
                ((ic)object2).b(string4);
                String string5 = miPushMessage.getMessageId();
                ((ic)object2).a(string5);
                Map map = miPushMessage.getExtra();
                Object v10 = map.get(string3);
                String string6 = (String)v10;
                Long l10 = Long.valueOf(string6);
                long l11 = l10;
                ((ic)object2).a(l11);
                short s10 = MiPushClient4Hybrid.getDeviceStatus(miPushMessage, bl2);
                ((ic)object2).a(s10);
                Object object3 = miPushMessage.getTopic();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
                if (!bl3) {
                    object3 = miPushMessage.getTopic();
                    ((ic)object2).c((String)object3);
                }
                object3 = PushMessageHelper.generateMessage(miPushMessage);
                object = aq.a((Context)object);
                hm hm2 = hm.f;
                ((aq)object).a((ix)object2, hm2, false, (hz)object3);
                object = new StringBuilder();
                object3 = "MiPushClient4Hybrid ack mina message, messageId is ";
                ((StringBuilder)object).append((String)object3);
                object3 = miPushMessage.getMessageId();
                ((StringBuilder)object).append((String)object3);
                object = ((StringBuilder)object).toString();
                com.xiaomi.channel.commonutils.logger.b.b((String)object);
                return;
            }
            catch (Throwable throwable) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(throwable);
                    return;
                }
                finally {
                    miPushMessage.getExtra().remove(string3);
                    miPushMessage.getExtra().remove(string2);
                }
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushClient4Hybrid$MiPushCallback miPushClient4Hybrid$MiPushCallback) {
        sCallback = miPushClient4Hybrid$MiPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String string2) {
        boolean bl2 = false;
        context = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "last_pull_notification_";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        long l10 = context.getLong(string2, (long)-1);
        l10 = Math.abs(System.currentTimeMillis() - l10);
        long l11 = 300000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static void unregisterPush(Context context, String string2) {
        sRegisterTimeMap.remove(string2);
        Object object = b.a(context).a(string2);
        if (object == null) {
            return;
        }
        Object object2 = new is();
        Object object3 = com.xiaomi.push.service.an.a();
        ((is)object2).a((String)object3);
        ((is)object2).d(string2);
        object3 = ((b$a)object).a;
        ((is)object2).b((String)object3);
        object3 = ((b$a)object).c;
        ((is)object2).c((String)object3);
        object = ((b$a)object).b;
        ((is)object2).e((String)object);
        object = new il();
        object3 = hw.K.a;
        ((il)object).c((String)object3);
        object3 = b.a(context).a();
        ((il)object).b((String)object3);
        object3 = context.getPackageName();
        ((il)object).d((String)object3);
        object2 = iw.a((ix)object2);
        ((il)object).a((byte[])object2);
        object2 = com.xiaomi.push.service.an.a();
        ((il)object).a((String)object2);
        object2 = aq.a(context);
        object3 = hm.i;
        ((aq)object2).a((ix)object, (hm)((Object)object3), null);
        b.a(context).b(string2);
    }

    public static void uploadClearMessageData(Context context, LinkedList linkedList) {
        aa.a(context, linkedList);
    }
}

