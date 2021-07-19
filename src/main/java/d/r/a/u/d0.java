/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.ComponentInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Process
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.vivo.push.util.VivoPushException;
import d.r.a.p;
import d.r.a.u.s;
import d.r.a.u.w;
import d.r.a.u.x;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

public final class d0 {
    private static String[] a;
    private static String[] b;
    private static Boolean c;
    private static String[] d;
    private static String[] e;
    private static String[] f;

    static {
        String string2 = "com.vivo.push.sdk.RegistrationReceiver";
        String string3 = "com.vivo.push.sdk.service.CommonJobService";
        a = new String[]{string2, "com.vivo.push.sdk.service.PushService", string3};
        b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
        d = new String[]{"com.vivo.push.sdk.service.CommandService", string3};
        e = new String[]{string2};
        f = new String[0];
    }

    public static long a(Context context, String string2) {
        Object object = d0.j(context, string2, "com.vivo.push.sdk_version");
        if (object == null) {
            object = d0.j(context, string2, "sdk_version");
        }
        long l10 = -1;
        String string3 = "Utility";
        if (object != null) {
            try {
                object = object.toString();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                s.b(string3, "getSdkVersionCode error ", exception);
                return l10;
            }
            return Long.parseLong((String)object);
        }
        s.a(string3, "getSdkVersionCode sdk version is null");
        return l10;
    }

    public static Object b(String object, String string2) {
        object = Class.forName((String)object);
        return ((Class)object).getField(string2).get(object);
    }

    public static void c(Context object, Intent intent) {
        String string2 = w.e((Context)object);
        String string3 = intent.getStringExtra("client_pkgname");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string4 = "Utility";
        if (bl2) {
            s.a(string4, "illegality abe adapter : push pkg is null");
            return;
        }
        bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            s.a(string4, "illegality abe adapter : src pkg is null");
            return;
        }
        CharSequence charSequence = object.getPackageName();
        bl2 = string2.equals(charSequence);
        if (bl2) {
            s.a(string4, "illegality abe adapter : abe is not pushservice");
            return;
        }
        bl2 = string2.equals(string3);
        if (!bl2) {
            charSequence = new StringBuilder("proxy to core : intent pkg : ");
            String string5 = intent.getPackage();
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append(" ; src pkg : ");
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(" ; push pkg : ");
            ((StringBuilder)charSequence).append(string2);
            string3 = ((StringBuilder)charSequence).toString();
            s.m(string4, string3);
            intent.setPackage(string2);
            intent.setClassName(string2, "com.vivo.push.sdk.service.PushService");
            object.startService(intent);
            return;
        }
        object = new StringBuilder("illegality abe adapter : pushPkg = ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" ; srcPkg = ");
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        s.a(string4, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d(Context object, String object2, String charSequence, boolean n10) {
        Object object3 = new Intent((String)object2);
        object2 = object.getPackageName();
        object3.setPackage((String)object2);
        try {
            object = object.getPackageManager();
            if (object == null) {
                object2 = "localPackageManager is null";
                object = new VivoPushException((String)object2);
                throw object;
            }
            object2 = " is missing";
            String string2 = "checkModule ";
            int n11 = 576;
            if (n10 != 0) {
                if ((object = object.queryBroadcastReceivers(object3, n11)) != null && (n10 = object.size()) > 0) {
                    Object object4;
                    object = object.iterator();
                    do {
                        if ((n10 = (int)(object.hasNext() ? 1 : 0)) == 0) {
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append((String)charSequence);
                            ((StringBuilder)object4).append((String)object2);
                            object2 = ((StringBuilder)object4).toString();
                            object = new VivoPushException((String)object2);
                            throw object;
                        }
                        object4 = object.next();
                        object4 = (ResolveInfo)object4;
                        object4 = ((ResolveInfo)object4).activityInfo;
                    } while ((n10 = (int)(((String)charSequence).equals(object4 = ((ActivityInfo)object4).name) ? 1 : 0)) == 0);
                    return;
                }
                object2 = new StringBuilder(string2);
                ((StringBuilder)object2).append(object3);
                charSequence = " has no receivers";
                ((StringBuilder)object2).append((String)charSequence);
                object2 = ((StringBuilder)object2).toString();
                object = new VivoPushException((String)object2);
                throw object;
            }
            if ((object = object.queryIntentServices(object3, n11)) != null && (n10 = object.size()) > 0) {
                Object object5;
                boolean bl2;
                object = object.iterator();
                do {
                    if ((n10 = (int)(object.hasNext() ? 1 : 0)) == 0) {
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append((String)charSequence);
                        ((StringBuilder)object5).append((String)object2);
                        object2 = ((StringBuilder)object5).toString();
                        object = new VivoPushException((String)object2);
                        throw object;
                    }
                    object5 = object.next();
                    object5 = (ResolveInfo)object5;
                    object3 = ((ResolveInfo)object5).serviceInfo;
                } while (!(bl2 = ((String)charSequence).equals(object3 = object3.name)));
                object = ((ResolveInfo)object5).serviceInfo;
                boolean bl3 = ((ServiceInfo)object).exported;
                if (bl3) {
                    return;
                }
                object2 = new StringBuilder();
                charSequence = ((ResolveInfo)object5).serviceInfo;
                charSequence = ((ServiceInfo)charSequence).name;
                ((StringBuilder)object2).append((String)charSequence);
                charSequence = " exported is false";
                ((StringBuilder)object2).append((String)charSequence);
                object2 = ((StringBuilder)object2).toString();
                object = new VivoPushException((String)object2);
                throw object;
            }
            object2 = new StringBuilder(string2);
            ((StringBuilder)object2).append(object3);
            charSequence = " has no services";
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            object = new VivoPushException((String)object2);
            throw object;
        }
        catch (Exception exception) {
            object2 = new StringBuilder("error  ");
            charSequence = exception.getMessage();
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            s.a("Utility", (String)object2);
            charSequence = new StringBuilder("checkModule error");
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            object2 = new VivoPushException(string3);
            throw object2;
        }
    }

    private static void e(ComponentInfo object, String object2) {
        CharSequence charSequence = object.applicationInfo.packageName;
        boolean bl2 = ((String)charSequence).equals(object2);
        if (bl2) {
            return;
        }
        object2 = a;
        int n10 = ((String[])object2).length;
        String string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = object2[i10];
            String string4 = object.name;
            boolean bl3 = string3.equals(string4);
            if (!bl3 || (bl3 = (string3 = object.processName).contains(string4 = ":pushservice"))) continue;
            charSequence = new StringBuilder("module : ");
            string2 = object.name;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" process :");
            object = object.processName;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("  check process fail");
            object = ((StringBuilder)charSequence).toString();
            object2 = new VivoPushException((String)object);
            throw object2;
        }
    }

    private static void f(String object, ComponentInfo[] object2, String charSequence) {
        int n10 = ((ComponentInfo[])object2).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            ComponentInfo componentInfo = object2[i10];
            String string2 = componentInfo.name;
            boolean bl2 = ((String)object).equals(string2);
            if (!bl2) continue;
            boolean bl3 = componentInfo.enabled;
            if (bl3) {
                d0.e(componentInfo, (String)charSequence);
                return;
            }
            object2 = new StringBuilder();
            charSequence = componentInfo.name;
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append(" module Push-SDK need is illegitmacy !");
            object2 = ((StringBuilder)object2).toString();
            object = new VivoPushException((String)object2);
            throw object;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" module Push-SDK need is not exist");
        object = ((StringBuilder)charSequence).toString();
        object2 = new VivoPushException((String)object);
        throw object2;
    }

    public static boolean g(Context object) {
        boolean bl2;
        int n10;
        int n11;
        String string2;
        Boolean bl3 = c;
        if (bl3 != null) {
            return bl3;
        }
        bl3 = null;
        if (object == null) {
            s.m("Utility", "isPushProcess context is null");
            return false;
        }
        String string3 = w.e((Context)object);
        if (object != null && (string2 = object.getPackageName()) != null && (n11 = (int)((string2 = object.getPackageName()).equals(string3) ? 1 : 0)) != 0) {
            c = Boolean.TRUE;
            return true;
        }
        n11 = Process.myPid();
        object = (ActivityManager)object.getSystemService("activity");
        string2 = null;
        if (object != null && (object = object.getRunningAppProcesses()) != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)object.next();
                int n12 = runningAppProcessInfo.pid;
                if (n12 != n11) continue;
                string2 = runningAppProcessInfo.processName;
                break;
            }
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        c = object = Boolean.valueOf(string2.contains(":pushservice"));
        return (Boolean)object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean h(Context var0, String var1_5, String var2_8) {
        block16: {
            block15: {
                block14: {
                    var3_9 = "close";
                    var4_10 = "Utility";
                    var5_11 = null;
                    if (var0 /* !! */  != null) ** GOTO lbl10
                    var0 /* !! */  = "context is null";
                    s.a(var4_10, (String)var0 /* !! */ );
                    return false;
lbl10:
                    // 1 sources

                    var6_12 = var0 /* !! */ .getContentResolver();
                    var7_13 = p.c;
                    var8_14 = "appPkgName = ? and regId = ? sdkVersion = ? ";
                    var9_15 = 3 != 0;
                    var10_16 = new String[var9_15];
                    var10_16[0] = var1_5;
                    var9_15 = true;
                    var10_16[var9_15] = var2_8;
                    var9_15 = 2 != 0;
                    var10_16[var9_15] = var1_5 = "305";
                    var5_11 = var6_12.query(var7_13, null, var8_14, var10_16, null);
                    if (var5_11 != null) break block14;
                    var0 /* !! */  = "cursor is null";
                    s.a(var4_10, (String)var0 /* !! */ );
                    if (var5_11 == null) return false;
                    try {
                        var5_11.close();
                        return false;
                    }
                    catch (Exception var0_1) {
                        s.b(var4_10, var3_9, var0_1);
                    }
                    return false;
                }
                var9_15 = var5_11.moveToFirst();
                if (!var9_15) break block15;
                var0 /* !! */  = "clientState";
                var9_15 = var5_11.getColumnIndex((String)var0 /* !! */ );
                var0 /* !! */  = var5_11.getString((int)var9_15);
                var9_15 = Boolean.parseBoolean((String)var0 /* !! */ );
                if (var5_11 == null) return var9_15;
                try {
                    var5_11.close();
                    return var9_15;
                }
                catch (Exception var1_6) {
                    s.b(var4_10, var3_9, var1_6);
                }
                return var9_15;
            }
            if (var5_11 == null) return false;
            ** try [egrp 4[TRYBLOCK] [28 : 214->224)] { 
lbl-1000:
            // 1 sources

            {
                catch (Exception var0_4) {
                    s.b(var4_10, var3_9, var0_4);
                    return false;
                }
            }
lbl-1000:
            // 1 sources

            {
                var5_11.close();
                return false;
                catch (Throwable var0_2) {
                    break block16;
                }
                catch (Exception var0_3) {}
                var1_5 = "isOverdue";
                {
                    s.b(var4_10, var1_5, var0_3);
                    if (var5_11 == null) return false;
                }
                {
                    var5_11.close();
                    return false;
                }
            }
        }
        if (var5_11 == null) throw var0_2;
        try {
            var5_11.close();
            throw var0_2;
        }
        catch (Exception var1_7) {
            s.b(var4_10, var3_9, var1_7);
        }
        throw var0_2;
    }

    public static long i(Context context) {
        String string2 = w.e(context);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            s.a("Utility", "systemPushPkgName is null");
            return -1;
        }
        return d0.a(context, string2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object j(Context object, String string2, String string3) {
        void var1_7;
        void var3_11;
        Object var3_9 = null;
        if (object == null) return var3_11;
        int n10 = TextUtils.isEmpty((CharSequence)var1_7);
        if (n10 != 0) {
            return var3_11;
        }
        try {
            void var2_8;
            Object object2;
            void var0_5;
            PackageManager packageManager = object.getPackageManager();
            n10 = 128;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo((String)var1_7, n10);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
            } else {
                Object var0_4 = null;
            }
            if (var0_5 == null) return var3_11;
            Object object3 = object2 = var0_5.get((String)var2_8);
            return var3_11;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return var3_11;
        }
    }

    public static String k(Context object, String string2) {
        Object object2 = d0.j((Context)object, string2, "com.vivo.push.app_id");
        if (object2 != null) {
            return object2.toString();
        }
        object2 = "app_id";
        if ((object = d0.j((Context)object, string2, (String)object2)) != null) {
            return object.toString();
        }
        return "";
    }

    public static String l(String object, String string2) {
        int n10;
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        String string3 = "get";
        int n11 = 1;
        Class[] classArray = new Class[n11];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object2 = ((Class)object2).getMethod(string3, classArray);
        string3 = null;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = ((Method)object2).invoke(null, objectArray);
        try {
            object = (String)object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = string2;
        }
        if (object != null && (n10 = ((String)object).length()) != 0) {
            string2 = object;
        }
        return string2;
    }

    public static void m(Context context) {
        Object object;
        block16: {
            long l10;
            Object object2;
            block17: {
                long l11;
                String[] stringArray;
                String string2;
                String string3;
                boolean bl2;
                String string4;
                boolean bl3;
                block15: {
                    String string5;
                    object = context;
                    s.m("Utility", "check PushService AndroidManifest declearation !");
                    object2 = w.e(context);
                    String string6 = context.getPackageName();
                    bl3 = w.d(context, string6, "com.vivo.pushservice.action.RECEIVE");
                    String string7 = context.getPackageName();
                    string4 = "com.vivo.pushservice.action.METHOD";
                    bl2 = w.d(context, string7, string4);
                    Object object3 = context.getPackageName();
                    boolean bl4 = w.d(context, (String)object3, "com.vivo.pushclient.action.RECEIVE");
                    String string8 = "com.vivo.push.sdk.service.CommandService";
                    string3 = "com.vivo.push.sdk.service.PushService";
                    string2 = "com.vivo.push.sdk.RegistrationReceiver";
                    if (bl2) {
                        object3 = "com.vivo.push.sdk.service.CommonJobService";
                        a = new String[]{string2, string3, object3};
                        String string9 = "android.permission.INTERNET";
                        String string10 = "android.permission.READ_PHONE_STATE";
                        String string11 = "android.permission.ACCESS_NETWORK_STATE";
                        string5 = "android.permission.WRITE_SETTINGS";
                        String string12 = "android.permission.VIBRATE";
                        String string13 = "android.permission.WRITE_EXTERNAL_STORAGE";
                        String string14 = "android.permission.ACCESS_WIFI_STATE";
                        String string15 = "android.permission.WAKE_LOCK";
                        String string16 = "android.permission.GET_ACCOUNTS";
                        String string17 = "com.bbk.account.permission.READ_ACCOUNTINFO";
                        String string18 = "android.permission.AUTHENTICATE_ACCOUNTS";
                        String string19 = "android.permission.MOUNT_UNMOUNT_FILESYSTEMS";
                        String string20 = "android.permission.GET_TASKS";
                        stringArray = new String[]{string9, string10, string11, string5, string12, string13, string14, string15, string16, string17, string18, string19, string20};
                        b = stringArray;
                        d = new String[]{string8, object3};
                        object3 = new String[]{string2};
                        e = object3;
                    } else {
                        if (!bl4 && !bl3) {
                            object = new VivoPushException("AndroidManifest.xml\u4e2dreceiver\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8be6\u89c1\u63a5\u5165\u6587\u6863");
                            throw object;
                        }
                        if (bl4) {
                            object3 = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
                            d = object3;
                        } else {
                            object3 = new String[]{string8};
                            d = object3;
                        }
                        e = new String[0];
                        a = new String[0];
                        object3 = "android.permission.INTERNET";
                        if (bl3) {
                            string8 = "android.permission.WRITE_SETTINGS";
                            object3 = new String[]{object3, string8};
                            b = object3;
                        } else {
                            object3 = new String[]{object3};
                            b = object3;
                        }
                    }
                    l11 = -1;
                    if (!bl3 && !bl2) break block15;
                    stringArray = context.getPackageName();
                    long l12 = d0.a(object, (String)stringArray);
                    l10 = 305L;
                    string5 = context.getPackageName();
                    boolean bl5 = string5.equals(object2);
                    if (bl5) {
                        l10 = 1305L;
                    }
                    if (!(bl5 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1))) break block16;
                    Object object4 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                    if (object4 != false) break block17;
                }
                d0.s(context);
                d0.q(object, (String)object2);
                d0.n(object, (String)object2);
                d0.p(object, (String)object2);
                object2 = context.getPackageName();
                stringArray = d0.j(object, (String)object2, "com.vivo.push.api_key");
                object2 = stringArray != null ? stringArray.toString() : ((object2 = d0.j(object, (String)object2, (String)(stringArray = "api_key"))) != null ? object2.toString() : "");
                boolean bl6 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl6) {
                    object2 = context.getPackageName();
                    bl6 = TextUtils.isEmpty((CharSequence)(object2 = d0.k(object, (String)object2)));
                    if (!bl6) {
                        long l13;
                        long l14;
                        if (!bl3 && !bl2 || (bl6 = (l14 = (l13 = d0.a(object, (String)(object2 = context.getPackageName()))) - l11) == 0L ? 0 : (l14 < 0L ? -1 : 1))) {
                            if (bl2) {
                                bl6 = true;
                                d0.d(object, string4, string2, bl6);
                                object2 = "com.vivo.pushservice.action.PUSH_SERVICE";
                                d0.d(object, (String)object2, string3, false);
                            }
                            return;
                        }
                        object = new VivoPushException("sdkversion is null");
                        throw object;
                    }
                    object = new VivoPushException("com.vivo.push.app_id is null");
                    throw object;
                }
                object = new VivoPushException("com.vivo.push.api_key is null");
                throw object;
            }
            object2 = new StringBuilder("AndroidManifest.xml\u4e2dsdk_version\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8bf7\u914d\u7f6e\u5f53\u524dsdk_version\u7248\u672c\u4e3a:");
            ((StringBuilder)object2).append(l10);
            object2 = ((StringBuilder)object2).toString();
            object = new VivoPushException((String)object2);
            throw object;
        }
        object = new VivoPushException("AndroidManifest.xml\u4e2d\u672a\u914d\u7f6esdk_version");
        throw object;
    }

    private static void n(Context object, String object2) {
        block14: {
            Object object3;
            block15: {
                object3 = object.getPackageManager();
                if (object3 == null) break block14;
                object3 = object.getPackageManager();
                object = object.getPackageName();
                int n10 = 4;
                object = object3.getPackageInfo((String)object, n10);
                object = object.services;
                if (object == null) break block15;
                object3 = d;
                n10 = ((Object)object3).length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    Object object4 = object3[i10];
                    d0.f((String)object4, (ComponentInfo[])object, (String)object2);
                    continue;
                }
                return;
            }
            object2 = "serviceInfos is null";
            try {
                object = new VivoPushException((String)object2);
                throw object;
            }
            catch (Exception exception) {
                object3 = new StringBuilder("error ");
                String string2 = exception.getMessage();
                ((StringBuilder)object3).append(string2);
                string2 = ((StringBuilder)object3).toString();
                object2 = new VivoPushException(string2);
                throw object2;
            }
        }
        object2 = "localPackageManager is null";
        object = new VivoPushException((String)object2);
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PublicKey o(Context context) {
        Throwable throwable2;
        block14: {
            block13: {
                Object object;
                block12: {
                    int n10;
                    object = context.getContentResolver();
                    Object object2 = p.a;
                    int n11 = 0;
                    String string2 = null;
                    CharSequence charSequence = null;
                    String string3 = null;
                    context = object.query((Uri)object2, null, null, null, null);
                    object = null;
                    if (context == null) {
                        return null;
                    }
                    while ((n10 = context.moveToNext()) != 0) {
                        object2 = "pushkey";
                        string2 = "name";
                        n11 = context.getColumnIndex(string2);
                        n10 = ((String)object2).equals(string2 = context.getString(n11));
                        if (n10 == 0) continue;
                        object2 = "value";
                        n10 = context.getColumnIndex((String)object2);
                        object2 = context.getString(n10);
                        string2 = "Utility";
                        string3 = "result key : ";
                        charSequence = new StringBuilder(string3);
                        charSequence.append((String)object2);
                        charSequence = charSequence.toString();
                        s.m(string2, (String)charSequence);
                        object = x.a((String)object2);
                        break block12;
                    }
                    break block13;
                    {
                        catch (Throwable throwable2) {
                            break block14;
                        }
                        catch (Exception exception) {}
                        {
                            exception.printStackTrace();
                            break block13;
                        }
                    }
                }
                try {
                    context.close();
                    return object;
                }
                catch (Exception exception) {
                    return object;
                }
            }
            try {
                context.close();
                return null;
            }
            catch (Exception exception) {}
            return null;
        }
        try {
            context.close();
            throw throwable2;
        }
        catch (Exception exception) {
            throw throwable2;
        }
    }

    private static void p(Context object, String object2) {
        block15: {
            Object object3;
            block16: {
                object3 = f;
                int n10 = ((String[])object3).length;
                if (n10 <= 0) {
                    return;
                }
                object3 = object.getPackageManager();
                if (object3 == null) break block15;
                object3 = object.getPackageManager();
                object = object.getPackageName();
                int n11 = 1;
                object = object3.getPackageInfo((String)object, n11);
                object = object.activities;
                if (object == null) break block16;
                object3 = f;
                n11 = ((Object)object3).length;
                for (int i10 = 0; i10 < n11; ++i10) {
                    Object object4 = object3[i10];
                    d0.f((String)object4, (ComponentInfo[])object, (String)object2);
                    continue;
                }
                return;
            }
            object2 = "activityInfos is null";
            try {
                object = new VivoPushException((String)object2);
                throw object;
            }
            catch (Exception exception) {
                object3 = new StringBuilder("error ");
                String string2 = exception.getMessage();
                ((StringBuilder)object3).append(string2);
                string2 = ((StringBuilder)object3).toString();
                object2 = new VivoPushException(string2);
                throw object2;
            }
        }
        object2 = "localPackageManager is null";
        object = new VivoPushException((String)object2);
        throw object;
    }

    private static void q(Context object, String object2) {
        block14: {
            block15: {
                String[] stringArray = object.getPackageManager();
                if (stringArray == null) break block14;
                stringArray = object.getPackageManager();
                object = object.getPackageName();
                int n10 = 2;
                object = stringArray.getPackageInfo((String)object, n10);
                object = object.receivers;
                if (object == null) break block15;
                stringArray = e;
                n10 = stringArray.length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String string2 = stringArray[i10];
                    d0.f(string2, (ComponentInfo[])object, (String)object2);
                    continue;
                }
                return;
            }
            object2 = "receivers is null";
            try {
                object = new VivoPushException((String)object2);
                throw object;
            }
            catch (Exception exception) {
                String string3 = exception.getMessage();
                object2 = new VivoPushException(string3);
                throw object2;
            }
        }
        object2 = "localPackageManager is null";
        object = new VivoPushException((String)object2);
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean r(Context var0) {
        block16: {
            block15: {
                block14: {
                    var1_5 = "close";
                    var2_6 = null;
                    var3_9 = "Utility";
                    var4_10 = null;
                    if (var0 /* !! */  != null) ** GOTO lbl11
                    var0 /* !! */  = "context is null";
                    s.a(var3_9, (String)var0 /* !! */ );
                    return false;
lbl11:
                    // 1 sources

                    var5_11 = var0 /* !! */ .getPackageName();
                    var6_12 /* !! */  = var0 /* !! */ .getPackageManager();
                    var6_12 /* !! */  = var6_12 /* !! */ .getPackageInfo(var5_11, 0);
                    var7_13 = var6_12 /* !! */ .versionCode;
                    var8_14 = var0 /* !! */ .getContentResolver();
                    var9_15 = p.b;
                    var10_16 = "pushVersion = ? and appPkgName = ? and appCode = ? ";
                    var11_17 = 3;
                    var12_18 = new String[var11_17];
                    var0 /* !! */  = "305";
                    var12_18[0] = var0 /* !! */ ;
                    var11_17 = 1;
                    var12_18[var11_17] = var5_11;
                    var13_19 = 2;
                    var6_12 /* !! */  = String.valueOf(var7_13);
                    var12_18[var13_19] = var6_12 /* !! */ ;
                    var4_10 = var8_14.query(var9_15, null, var10_16, var12_18, null);
                    if (var4_10 != null) break block14;
                    var0 /* !! */  = "cursor is null";
                    s.a(var3_9, (String)var0 /* !! */ );
                    if (var4_10 == null) return false;
                    try {
                        var4_10.close();
                        return false;
                    }
                    catch (Exception var0_1) {
                        s.b(var3_9, var1_5, var0_1);
                    }
                    return false;
                }
                var13_19 = (int)var4_10.moveToFirst();
                if (var13_19 == 0) break block15;
                var5_11 = "permission";
                var13_19 = var4_10.getColumnIndex(var5_11);
                if ((var13_19 = var4_10.getInt(var13_19) & var11_17) == 0) break block15;
                if (var4_10 == null) return (boolean)var11_17;
                try {
                    var4_10.close();
                    return (boolean)var11_17;
                }
                catch (Exception var2_7) {
                    s.b(var3_9, var1_5, var2_7);
                }
                return (boolean)var11_17;
            }
            if (var4_10 == null) return false;
            ** try [egrp 4[TRYBLOCK] [36 : 254->264)] { 
lbl-1000:
            // 1 sources

            {
                catch (Exception var0_4) {
                    s.b(var3_9, var1_5, var0_4);
                    return false;
                }
            }
lbl-1000:
            // 1 sources

            {
                var4_10.close();
                return false;
                catch (Throwable var0_2) {
                    break block16;
                }
                catch (Exception var0_3) {}
                var5_11 = "isSupport";
                {
                    s.b(var3_9, var5_11, var0_3);
                    if (var4_10 == null) return false;
                }
                {
                    var4_10.close();
                    return false;
                }
            }
        }
        if (var4_10 == null) throw var0_2;
        try {
            var4_10.close();
            throw var0_2;
        }
        catch (Exception var2_8) {
            s.b(var3_9, var1_5, var2_8);
        }
        throw var0_2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void s(Context object) {
        try {
            Object object2 = object.getPackageManager();
            if (object2 == null) {
                object2 = "localPackageManager is null";
                object = new VivoPushException((String)object2);
                throw object;
            }
            object = object.getPackageName();
            int n10 = 4096;
            object = object2.getPackageInfo((String)object, n10);
            object = object.requestedPermissions;
            if (object == null) {
                object2 = "Permissions is null!";
                object = new VivoPushException((String)object2);
                throw object;
            }
            object2 = b;
            n10 = ((String[])object2).length;
            String string2 = null;
            int n11 = 0;
            while (true) {
                if (n11 >= n10) {
                    return;
                }
                String string3 = object2[n11];
                int n12 = ((String[])object).length;
                int n13 = 0;
                while (true) {
                    if (n13 >= n12) {
                        string2 = "permission : ";
                        StringBuilder stringBuilder = new StringBuilder(string2);
                        stringBuilder.append(string3);
                        string2 = "  check fail : ";
                        stringBuilder.append(string2);
                        object = Arrays.toString(object);
                        stringBuilder.append((String)object);
                        object = stringBuilder.toString();
                        object2 = new VivoPushException((String)object);
                        throw object2;
                    }
                    String string4 = object[n13];
                    boolean bl2 = string3.equals(string4);
                    if (bl2) break;
                    ++n13;
                }
                ++n11;
            }
        }
        catch (Exception exception) {
            String string5 = exception.getMessage();
            VivoPushException vivoPushException = new VivoPushException(string5);
            throw vivoPushException;
        }
    }
}

