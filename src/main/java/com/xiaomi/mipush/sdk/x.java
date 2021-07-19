/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PermissionInfo
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.x$a;
import com.xiaomi.mipush.sdk.x$b;
import com.xiaomi.mipush.sdk.y;
import com.xiaomi.push.service.at;
import com.xiaomi.push.t;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class x {
    private static ActivityInfo a(PackageManager object, Intent intent, Class clazz) {
        boolean bl2;
        int n10 = 16384;
        object = object.queryBroadcastReceivers(intent, n10).iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            String string3;
            intent = ((ResolveInfo)object.next()).activityInfo;
            if (intent == null || (n10 = (int)((string3 = clazz.getCanonicalName()).equals(string2 = intent.name) ? 1 : 0)) == 0) continue;
            return intent;
        }
        return null;
    }

    public static void a(Context context) {
        y y10 = new y(context);
        Thread thread = new Thread(y10);
        thread.start();
    }

    public static /* synthetic */ void a(Context context, PackageInfo packageInfo) {
        x.d(context, packageInfo);
    }

    private static void a(Context object, String string2, String string3) {
        int n10;
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        Object object3 = new Intent(string2);
        object3.setPackage((String)object);
        int n11 = 16384;
        object = object2.queryBroadcastReceivers(object3, n11).iterator();
        string2 = null;
        int n12 = 0;
        object2 = null;
        do {
            boolean bl2 = object.hasNext();
            n10 = 1;
            if (!bl2) break;
            object2 = ((ResolveInfo)object.next()).activityInfo;
            if (object2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object3 = ((ActivityInfo)object2).name))) && (n12 = ((String)(object2 = ((ActivityInfo)object2).name)).equals(string3)) != 0) {
                n12 = n10;
                continue;
            }
            n12 = 0;
            object2 = null;
        } while (n12 == 0);
        if (n12 != 0) {
            return;
        }
        object2 = new Object[n10];
        object2[0] = string3;
        string2 = String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", (Object[])object2);
        object = new x$a(string2);
        throw object;
    }

    private static void a(ActivityInfo object, Boolean[] booleanArray) {
        Serializable serializable = booleanArray[0];
        boolean bl2 = (Boolean)serializable;
        boolean bl3 = object.enabled;
        int n10 = 2;
        int n11 = 1;
        if (bl2 == bl3) {
            serializable = booleanArray[n11];
            bl2 = (Boolean)serializable;
            if (bl2 == (bl3 = object.exported)) {
                return;
            }
            Object[] objectArray = new Object[n10];
            object = object.name;
            objectArray[0] = object;
            object = booleanArray[n11];
            objectArray[n11] = object;
            object = String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", objectArray);
            serializable = new x$a((String)object);
            throw serializable;
        }
        Object[] objectArray = new Object[n10];
        object = object.name;
        objectArray[0] = object;
        object = booleanArray[0];
        objectArray[n11] = object;
        object = String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", objectArray);
        serializable = new x$a((String)object);
        throw serializable;
    }

    private static boolean a(PackageInfo serviceInfoArray, String[] stringArray) {
        serviceInfoArray = serviceInfoArray.services;
        int n10 = serviceInfoArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = serviceInfoArray[i10].name;
            boolean bl2 = x.a(stringArray, string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static boolean a(String[] stringArray, String string2) {
        if (stringArray != null && string2 != null) {
            for (String string3 : stringArray) {
                boolean bl2 = TextUtils.equals((CharSequence)string3, (CharSequence)string2);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void b(Context context) {
        x.c(context);
    }

    public static /* synthetic */ void b(Context context, PackageInfo packageInfo) {
        x.c(context, packageInfo);
    }

    private static void c(Context object) {
        boolean bl2;
        int n10;
        Object object2;
        Object object3;
        ActivityInfo activityInfo;
        Object object4;
        Object object5;
        block32: {
            int n11;
            Object[] objectArray;
            block28: {
                block29: {
                    object5 = Boolean.FALSE;
                    object4 = Boolean.TRUE;
                    activityInfo = "com.xiaomi.push.service.receivers.PingReceiver";
                    object3 = object.getPackageManager();
                    object2 = object.getPackageName();
                    String string2 = at.o;
                    objectArray = new Intent(string2);
                    objectArray.setPackage((String)object2);
                    n10 = 1;
                    Class clazz = t.a(object, (String)activityInfo);
                    objectArray = x.a((PackageManager)object3, (Intent)objectArray, clazz);
                    boolean bl3 = MiPushClient.shouldUseMIUIPush(object);
                    n11 = 2;
                    if (bl3) break block28;
                    if (objectArray == null) break block29;
                    activityInfo = new Boolean[n11];
                    activityInfo[0] = object4;
                    activityInfo[n10] = object5;
                    x.a((ActivityInfo)objectArray, (Boolean[])activityInfo);
                }
                object4 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.";
                objectArray = new Object[n10];
                objectArray[0] = activityInfo;
                object4 = String.format((String)object4, objectArray);
                object5 = new x$a((String)object4);
                throw object5;
            }
            if (objectArray == null) break block32;
            activityInfo = new Boolean[n11];
            activityInfo[0] = object4;
            activityInfo[n10] = object5;
            try {
                x.a((ActivityInfo)objectArray, (Boolean[])activityInfo);
            }
            catch (ClassNotFoundException classNotFoundException) {
                b.a(classNotFoundException);
            }
        }
        object5 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        object5.setPackage((String)object2);
        object5 = object3.queryBroadcastReceivers((Intent)object5, 16384).iterator();
        int n12 = 0;
        object4 = null;
        while (bl2 = object5.hasNext()) {
            block31: {
                block30: {
                    activityInfo = ((ResolveInfo)object5.next()).activityInfo;
                    if (activityInfo != null) {
                        try {
                            object3 = activityInfo.name;
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            b.a(classNotFoundException);
                            continue;
                        }
                        boolean bl4 = TextUtils.isEmpty((CharSequence)object3);
                        if (bl4) break block30;
                        object3 = PushMessageReceiver.class;
                        object2 = activityInfo.name;
                        object2 = t.a(object, (String)object2);
                        bl4 = ((Class)object3).isAssignableFrom((Class<?>)object2);
                        if (!bl4) break block30;
                        n12 = activityInfo.enabled;
                        if (n12 == 0) break block30;
                        n12 = n10;
                        break block31;
                    }
                }
                n12 = 0;
                object4 = null;
            }
            if (n12 == 0) continue;
        }
        if (n12 != 0) {
            boolean bl5 = MiPushClient.getOpenHmsPush(object);
            if (bl5) {
                x.a(object, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
                object5 = "com.huawei.intent.action.PUSH";
                object4 = "com.huawei.hms.support.api.push.PushEventReceiver";
                x.a(object, (String)object5, (String)object4);
            }
            if (bl5 = MiPushClient.getOpenVIVOPush(object)) {
                object5 = "com.vivo.pushclient.action.RECEIVE";
                object4 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver";
                x.a(object, (String)object5, (String)object4);
            }
            return;
        }
        object = new x$a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        throw object;
    }

    private static void c(Context object, PackageInfo object2) {
        int n10;
        String string2;
        Object object3 = new HashSet();
        Object object4 = new StringBuilder();
        object = object.getPackageName();
        object4.append((String)object);
        object4.append(".permission.MIPUSH_RECEIVE");
        object = object4.toString();
        int n11 = 7;
        object4 = new String[n11];
        object4[0] = "android.permission.INTERNET";
        String string3 = "android.permission.ACCESS_NETWORK_STATE";
        int n12 = 1;
        object4[n12] = string3;
        object4[2] = object;
        object4[3] = "android.permission.ACCESS_WIFI_STATE";
        object4[4] = "android.permission.READ_PHONE_STATE";
        object4[5] = "android.permission.GET_TASKS";
        int n13 = 6;
        object4[n13] = string2 = "android.permission.VIBRATE";
        object4 = Arrays.asList(object4);
        object3.addAll(object4);
        object4 = object2.permissions;
        if (object4 != null) {
            n13 = ((String[])object4).length;
            string2 = null;
            for (n10 = 0; n10 < n13; ++n10) {
                String string4 = ((PermissionInfo)object4[n10]).name;
                boolean bl2 = object.equals(string4);
                if (!bl2) continue;
                n11 = n12;
                break;
            }
        } else {
            n11 = 0;
            object4 = null;
        }
        if (n11 != 0) {
            boolean bl3;
            object = object2.requestedPermissions;
            if (object != null) {
                int n14 = ((String[])object).length;
                object4 = null;
                for (n11 = 0; n11 < n14; ++n11) {
                    string3 = object[n11];
                    n10 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0);
                    if (n10 != 0 || (n10 = (int)(object3.contains(string3) ? 1 : 0)) == 0) continue;
                    object3.remove(string3);
                    n13 = (int)(object3.isEmpty() ? 1 : 0);
                    if (n13 != 0) break;
                }
            }
            if (bl3 = object3.isEmpty()) {
                return;
            }
            object2 = new Object[n12];
            object2[0] = object3 = object3.iterator().next();
            object2 = String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", object2);
            object = new x$a((String)object2);
            throw object;
        }
        object3 = new Object[n12];
        object3[0] = object;
        object = String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", (Object[])object3);
        object2 = new x$a((String)object);
        throw object2;
    }

    private static void d(Context object, PackageInfo object2) {
        boolean bl2;
        String string2;
        Object object3 = new HashMap();
        Object object4 = new HashMap();
        Object object5 = PushMessageHandler.class.getCanonicalName();
        String string3 = PushMessageHandler.class.getCanonicalName();
        int n10 = 1;
        String string4 = "";
        Object object6 = new x$b(string3, n10 != 0, n10 != 0, string4);
        object4.put(object5, object6);
        object5 = MessageHandleService.class.getCanonicalName();
        string3 = MessageHandleService.class.getCanonicalName();
        object6 = new x$b(string3, n10 != 0, false, string4);
        object4.put(object5, object6);
        int n11 = MiPushClient.shouldUseMIUIPush((Context)object);
        object6 = "com.xiaomi.push.service.XMPushService";
        string3 = "com.xiaomi.push.service.XMJobService";
        if (n11 == 0 || (n11 = x.a((PackageInfo)object2, object5 = new String[]{string3, object6})) != 0) {
            string2 = "android.permission.BIND_JOB_SERVICE";
            object5 = new x$b(string3, n10 != 0, false, string2);
            object4.put(string3, object5);
            object5 = new x$b((String)object6, n10 != 0, false, string4);
            object4.put(object6, object5);
        }
        if ((n11 = MiPushClient.getOpenFCMPush((Context)object)) != 0) {
            string2 = "com.xiaomi.assemble.control.MiFireBaseInstanceIdService";
            object5 = new x$b(string2, n10 != 0, false, string4);
            object4.put(string2, object5);
            string2 = "com.xiaomi.assemble.control.MiFirebaseMessagingService";
            object5 = new x$b(string2, n10 != 0, false, string4);
            object4.put(string2, object5);
        }
        if (bl2 = MiPushClient.getOpenOPPOPush((Context)object)) {
            object5 = "com.xiaomi.assemble.control.COSPushMessageService";
            string4 = "com.coloros.mcs.permission.SEND_MCS_MESSAGE";
            object = new x$b((String)object5, n10 != 0, n10 != 0, string4);
            object4.put(object5, object);
        }
        object = object2.services;
        int n12 = 2;
        if (object != null) {
            n11 = ((ServiceInfo[])object).length;
            string4 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                string2 = object[i10];
                Object object7 = ((ServiceInfo)string2).name;
                boolean bl3 = TextUtils.isEmpty((CharSequence)object7);
                if (bl3 || !(bl3 = object4.containsKey(object7 = ((ServiceInfo)string2).name))) continue;
                object7 = ((ServiceInfo)string2).name;
                object7 = (x$b)object4.remove(object7);
                boolean bl4 = ((x$b)object7).a;
                boolean bl5 = ((x$b)object7).b;
                object7 = ((x$b)object7).b;
                boolean bl6 = ((ServiceInfo)string2).enabled;
                if (bl4 == bl6) {
                    bl4 = ((ServiceInfo)string2).exported;
                    if (bl5 == bl4) {
                        String string5;
                        bl4 = TextUtils.isEmpty((CharSequence)object7);
                        if (!bl4 && !(bl4 = TextUtils.equals((CharSequence)object7, (CharSequence)(string5 = ((ServiceInfo)string2).permission)))) {
                            object2 = new Object[n12];
                            object2[0] = object3 = ((ServiceInfo)string2).name;
                            object2[n10] = object7;
                            object2 = String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", object2);
                            object = new x$a((String)object2);
                            throw object;
                        }
                        object7 = ((ServiceInfo)string2).name;
                        string2 = ((ServiceInfo)string2).processName;
                        object3.put(object7, string2);
                        boolean bl7 = object4.isEmpty();
                        if (!bl7) continue;
                        break;
                    }
                    object2 = new Object[n12];
                    object2[0] = object3 = ((ServiceInfo)string2).name;
                    object2[n10] = object3 = Boolean.valueOf(bl5);
                    object2 = String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", object2);
                    object = new x$a((String)object2);
                    throw object;
                }
                object2 = new Object[n12];
                object2[0] = object3 = ((ServiceInfo)string2).name;
                object2[n10] = object3 = Boolean.valueOf(bl4);
                object2 = String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", object2);
                object = new x$a((String)object2);
                throw object;
            }
        }
        if (bl2 = object4.isEmpty()) {
            object = PushMessageHandler.class.getCanonicalName();
            object = (CharSequence)object3.get(object);
            object4 = MessageHandleService.class.getCanonicalName();
            object4 = (CharSequence)object3.get(object4);
            bl2 = TextUtils.equals((CharSequence)object, (CharSequence)object4);
            object4 = "\"%1$s\" and \"%2$s\" must be running in the same process.";
            if (bl2) {
                bl2 = object3.containsKey(string3);
                if (bl2 && (bl2 = object3.containsKey(object6)) && !(bl2 = TextUtils.equals((CharSequence)(object = (CharSequence)object3.get(string3)), (CharSequence)(object3 = (CharSequence)object3.get(object6))))) {
                    object2 = new Object[n12];
                    object2[0] = string3;
                    object2[n10] = object6;
                    object2 = String.format((String)object4, object2);
                    object = new x$a((String)object2);
                    throw object;
                }
                return;
            }
            object2 = new Object[n12];
            object2[0] = object3 = PushMessageHandler.class.getCanonicalName();
            object2[n10] = object3 = MessageHandleService.class.getCanonicalName();
            object2 = String.format((String)object4, object2);
            object = new x$a((String)object2);
            throw object;
        }
        object2 = new Object[n10];
        object3 = object4.keySet().iterator().next();
        object2[0] = object3;
        object2 = String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", object2);
        object = new x$a((String)object2);
        throw object;
    }
}

