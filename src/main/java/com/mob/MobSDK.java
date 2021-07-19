/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler$Callback
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.mob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.mob.MobSDK$1;
import com.mob.MobSDK$2;
import com.mob.MobSDK$3;
import com.mob.MobSDK$4;
import com.mob.MobSDK$5;
import com.mob.MobSDK$6;
import com.mob.MobUser;
import com.mob.MobUser$OnUserGotListener;
import com.mob.MobUser$UserWatcher;
import com.mob.OperationCallback;
import com.mob.PrivacyPolicy;
import com.mob.PrivacyPolicy$OnPolicyListener;
import com.mob.commons.InternationalDomain;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.b;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.commons.dialog.entity.MobPolicyUi;
import com.mob.commons.f;
import com.mob.commons.h;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
import java.util.Locale;

public class MobSDK
implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int POLICY_TYPE_TXT = 2;
    public static final int POLICY_TYPE_URL = 1;
    public static final int SDK_VERSION_CODE = 0;
    public static final String SDK_VERSION_NAME;
    private static Context a;
    private static String b;
    private static String c;
    private static volatile boolean d = false;
    private static InternationalDomain e;
    private static volatile boolean f = false;
    private static volatile boolean g = false;
    private static volatile boolean h = false;

    static {
        int n10;
        String string2 = "-";
        String string3 = "2020-12-17";
        String string4 = "1.0.0";
        String string5 = ".";
        string4 = string3.replace(string2, string5);
        string5 = "";
        string2 = string3.replace(string2, string5);
        try {
            n10 = Integer.parseInt(string2);
        }
        catch (Throwable throwable) {
            n10 = 1;
        }
        SDK_VERSION_CODE = n10;
        SDK_VERSION_NAME = string4;
    }

    public static /* synthetic */ Context a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(String string2, String string3) {
        if (string2 == null || string3 == null) {
            Bundle bundle = null;
            try {
                Context context = a;
                context = context.getPackageManager();
                Object object = a;
                object = object.getPackageName();
                int n10 = 128;
                context = context.getPackageInfo((String)object, n10);
                context = context.applicationInfo;
                bundle = context.metaData;
            }
            catch (Throwable throwable) {}
            if (string2 == null && bundle != null) {
                string2 = bundle.getString("Mob-AppKey");
            }
            if (string3 == null && bundle != null) {
                string3 = bundle.getString("Mob-AppSecret");
            }
            if (string3 == null && bundle != null) {
                string3 = bundle.getString("Mob-AppSeret");
            }
        }
        b = string2;
        c = string3;
    }

    public static void addUserWatcher(MobUser$UserWatcher mobUser$UserWatcher) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            if (mobUser$UserWatcher != null) {
                MobUser.a(mobUser$UserWatcher);
            }
            return;
        }
    }

    public static /* synthetic */ void b() {
        MobSDK.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void c() {
        String string2 = "===============================";
        Object object = (DefaultLogsCollector)NLog.setDefaultCollector(DefaultLogsCollector.get());
        int n10 = SDK_VERSION_CODE;
        String string3 = "MOBSDK";
        ((DefaultLogsCollector)object).addSDK(string3, n10);
        try {
            object = NLog.getInstance(string3);
            string3 = null;
        }
        catch (Throwable throwable) {
            return;
        }
        Object object2 = new Object[]{};
        ((NLog)object).d(string2, (Object[])object2);
        object2 = new StringBuilder();
        String string4 = "MobCommons name: ";
        ((StringBuilder)object2).append(string4);
        string4 = SDK_VERSION_NAME;
        ((StringBuilder)object2).append(string4);
        string4 = ", code: ";
        ((StringBuilder)object2).append(string4);
        ((StringBuilder)object2).append(n10);
        Object[] objectArray = ((StringBuilder)object2).toString();
        object2 = new Object[]{};
        ((NLog)object).d(objectArray, (Object[])object2);
        objectArray = new Object[]{};
        ((NLog)object).d(string2, objectArray);
    }

    public static void canIContinueBusiness(MobProduct object, InternalPolicyUi internalPolicyUi, OperationCallback operationCallback) {
        if (operationCallback != null) {
            MobSDK$5 mobSDK$5 = new MobSDK$5((MobProduct)object, operationCallback, internalPolicyUi);
            Thread thread = new Thread(mobSDK$5);
            thread.start();
            return;
        }
        object = new IllegalArgumentException("callback can not be null");
        throw object;
    }

    public static boolean checkForceHttps() {
        MobSDK.e();
        return f;
    }

    public static boolean checkPpNecessary() {
        MobSDK.e();
        return g;
    }

    public static String checkRequestUrl(String string2) {
        return j.a(string2);
    }

    public static boolean checkV6() {
        MobSDK.e();
        return h;
    }

    public static void clearUser() {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobUser.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean d() {
        boolean bl2;
        block4: {
            bl2 = false;
            try {
                int n10;
                Thread thread = Thread.currentThread();
                StackTraceElement[] stackTraceElementArray = thread.getStackTrace();
                boolean bl3 = true;
                if (stackTraceElementArray == null || (n10 = stackTraceElementArray.length) <= 0) break block4;
                n10 = stackTraceElementArray.length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    boolean bl4;
                    boolean bl5;
                    String string2 = "android.app.Instrumentation";
                    Object object = stackTraceElementArray[i10];
                    String string3 = ((StackTraceElement)object).getClassName();
                    boolean bl6 = string2.equals(string3);
                    if (!(bl6 ? (bl5 = (string3 = "callApplicationOnCreate").equals(object = ((StackTraceElement)object).getMethodName())) : (bl4 = (string2 = "android.app.ActivityThread").equals(string3)) && (bl5 = (string3 = "handleBindApplication").equals(object = ((StackTraceElement)object).getMethodName())))) continue;
                    bl2 = bl3;
                    break;
                }
            }
            catch (Throwable throwable) {}
        }
        if (!bl2) {
            String string4 = "MobSDK";
            String string5 = "Please invoke MobSDK.init(context) method in your application onCreate()";
            Log.e((String)string4, (String)string5);
        }
        return bl2;
    }

    public static String dynamicModifyUrl(String string2) {
        return j.b(string2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void e() {
        block23: {
            boolean bl2;
            Context context;
            boolean bl3;
            Object object;
            String string2;
            block24: {
                Object object2;
                string2 = "Mob-Https";
                object = a;
                if (object == null) {
                    Log.e((String)"MobSDK", (String)"Please invoke MobSDK.init(context) method firstly.");
                    return;
                }
                bl3 = d;
                if (bl3) break block23;
                d = true;
                bl3 = false;
                object = null;
                try {
                    context = a;
                    context = context.getPackageManager();
                    object2 = a;
                    object2 = object2.getPackageName();
                    int n10 = 128;
                    context = context.getPackageInfo((String)object2, n10);
                    context = context.applicationInfo;
                    context = context.metaData;
                }
                catch (Throwable throwable) {
                    context = null;
                }
                object2 = e;
                if (object2 == null) {
                    if (context != null) {
                        object2 = "Domain";
                        try {
                            object2 = context.getString((String)object2);
                            e = object2 = InternationalDomain.domainOf((String)object2);
                        }
                        catch (Throwable throwable) {
                            e = object2 = InternationalDomain.DEFAULT;
                        }
                    } else {
                        e = object2 = InternationalDomain.DEFAULT;
                    }
                }
                if (context != null) {
                    try {
                        object = context.getString(string2);
                    }
                    catch (Throwable throwable) {}
                    if (object == null) {
                        f = bl2 = context.getBoolean(string2);
                    }
                    string2 = "yes";
                    f = bl2 = string2.equalsIgnoreCase((String)object);
                    break block24;
                    catch (Throwable throwable) {}
                }
            }
            bl2 = false;
            string2 = null;
            if (context != null) {
                object = "Mob-PpNecessary";
                try {
                    g = bl3 = context.getBoolean((String)object, false);
                }
                catch (Throwable throwable) {}
            }
            if (context != null) {
                object = "Mob-V6";
                try {
                    h = bl2 = context.getBoolean((String)object, false);
                }
                catch (Throwable throwable) {}
            }
            i.I();
        }
    }

    public static HashMap exchangeIds(String[] stringArray) {
        return MobUser.a(stringArray);
    }

    private static boolean f() {
        return com.mob.commons.b.Z();
    }

    private static boolean g() {
        return com.mob.commons.b.b();
    }

    public static String getAppSecret() {
        return c;
    }

    public static String getAppkey() {
        return b;
    }

    public static Context getContext() {
        block7: {
            Object object = a;
            if (object == null) {
                object = DeviceHelper.currentActivityThread();
                if (object == null) break block7;
                Object object2 = "getApplication";
                Object[] objectArray = null;
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                if (object == null) break block7;
                try {
                    MobSDK.init(object);
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
        }
        return a;
    }

    public static InternationalDomain getDomain() {
        InternationalDomain internationalDomain = e;
        if (internationalDomain == null) {
            MobSDK.e();
        }
        if ((internationalDomain = e) == null) {
            internationalDomain = InternationalDomain.DEFAULT;
        }
        return internationalDomain;
    }

    public static PrivacyPolicy getPrivacyPolicy(int n10) {
        return MobSDK.getPrivacyPolicy(n10, null);
    }

    public static PrivacyPolicy getPrivacyPolicy(int n10, Locale locale) {
        h h10;
        int n11 = 2;
        int n12 = 1;
        if (n10 == n12) {
            n11 = n12;
        }
        try {
            h10 = new h();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return null;
        }
        return h10.a(n11, locale);
    }

    public static void getPrivacyPolicyAsync(int n10, PrivacyPolicy$OnPolicyListener privacyPolicy$OnPolicyListener) {
        MobSDK.getPrivacyPolicyAsync(n10, null, privacyPolicy$OnPolicyListener);
    }

    public static void getPrivacyPolicyAsync(int n10, Locale locale, PrivacyPolicy$OnPolicyListener privacyPolicy$OnPolicyListener) {
        if (privacyPolicy$OnPolicyListener != null) {
            MobSDK$2 mobSDK$2 = new MobSDK$2(n10, locale, privacyPolicy$OnPolicyListener);
            Thread thread = new Thread(mobSDK$2);
            thread.start();
        }
    }

    public static void getUser(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobSDK$6 mobSDK$6 = new MobSDK$6(mobUser$OnUserGotListener);
            MobUser.a(mobSDK$6);
            return;
        }
    }

    private static void h() {
        MobProductCollector.syncInit();
        try {
            MobSDK$1 mobSDK$1 = new MobSDK$1();
            mobSDK$1.start();
            com.mob.commons.a.a();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
    }

    private static void i() {
        long l10;
        long l11 = i.G();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l11 = System.currentTimeMillis();
            i.j(l11);
        }
    }

    public static void init(Context context) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobSDK.init(context, null, null);
            return;
        }
    }

    public static void init(Context context, String string2) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobSDK.init(context, string2, null);
            return;
        }
    }

    public static void init(Context object, String string2, String string3) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            Context context = a;
            if (context == null) {
                a = object = object.getApplicationContext();
                MobSDK.a(string2, string3);
                MobSDK.e();
                MobSDK.c();
                MobSDK.d();
                MobSDK.h();
            } else {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    object = b;
                    bl2 = TextUtils.isEmpty((CharSequence)object);
                    b = string2;
                    c = string3;
                    if (bl2) {
                        com.mob.commons.b.an();
                    }
                }
            }
            return;
        }
    }

    public static final int isAuth() {
        int n10 = com.mob.commons.a.c();
        NLog nLog = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isAuth(). ppNece: ");
        ((StringBuilder)charSequence).append(n10 != 0);
        charSequence = ((StringBuilder)charSequence).toString();
        Object[] objectArray = null;
        Object[] objectArray2 = new Object[]{};
        nLog.d(charSequence, objectArray2);
        if (n10 != 0) {
            Boolean bl2 = com.mob.commons.a.k();
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isAuth(). isAgreePp: ");
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray2 = new Object[]{};
            nLog.d(charSequence, objectArray2);
            if (bl2 == null) {
                n10 = 0;
                bl2 = null;
            } else {
                n10 = (int)(bl2.booleanValue() ? 1 : 0);
                n10 = n10 != 0 ? 1 : -1;
            }
        } else {
            n10 = 2;
        }
        nLog = MobLog.getInstance();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isAuth(). isAuth: ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append("[2:ppms-off\uff0c1:agr\uff0c0:unkwn\uff0c-1:disagr]");
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray = new Object[]{};
        nLog.d(charSequence, objectArray);
        return n10;
    }

    public static final boolean isForb() {
        boolean bl2 = com.mob.commons.a.c();
        NLog nLog = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isForb(). ppNece: ");
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        Object[] objectArray = null;
        Object[] objectArray2 = new Object[]{};
        nLog.d(charSequence, objectArray2);
        if (bl2) {
            bl2 = com.mob.commons.a.d();
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isForb(). isAgrPp: ");
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray2 = new Object[]{};
            nLog.d(charSequence, objectArray2);
            if (bl2) {
                bl2 = MobSDK.f();
            } else {
                bl2 = com.mob.commons.a.i();
                nLog = MobLog.getInstance();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("isForb(). funcStch: ");
                ((StringBuilder)charSequence).append(bl2);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray2 = new Object[]{};
                nLog.d(charSequence, objectArray2);
                bl2 = bl2 ? MobSDK.f() : true;
            }
        } else {
            bl2 = MobSDK.f();
        }
        nLog = MobLog.getInstance();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isForb(). isForb: ");
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray = new Object[]{};
        nLog.d(charSequence, objectArray);
        return bl2;
    }

    public static final Boolean isGpAvailable() {
        return null;
    }

    public static final boolean isGppVer() {
        return false;
    }

    public static final boolean isMob() {
        boolean bl2 = com.mob.commons.a.c();
        NLog nLog = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isMob(). ppNece: ");
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        Object[] objectArray = null;
        Object[] objectArray2 = new Object[]{};
        nLog.d(charSequence, objectArray2);
        if (bl2) {
            bl2 = com.mob.commons.a.d();
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isMob(). isAgrPp: ");
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray2 = new Object[]{};
            nLog.d(charSequence, objectArray2);
            if (bl2) {
                bl2 = MobSDK.g();
            } else {
                bl2 = com.mob.commons.a.j();
                nLog = MobLog.getInstance();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("isMob(). cltSch: ");
                ((StringBuilder)charSequence).append(bl2);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray2 = new Object[]{};
                nLog.d(charSequence, objectArray2);
                bl2 = bl2 ? MobSDK.g() : false;
            }
        } else {
            bl2 = MobSDK.g();
        }
        nLog = MobLog.getInstance();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("isMob(). isMob: ");
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray = new Object[]{};
        nLog.d(charSequence, objectArray);
        return bl2;
    }

    public static void removeUserWatcher(MobUser$UserWatcher mobUser$UserWatcher) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            if (mobUser$UserWatcher != null) {
                MobUser.b(mobUser$UserWatcher);
            }
            return;
        }
    }

    public static void setAllowDialog(boolean bl2) {
    }

    public static void setChannel(MobProduct mobProduct, int n10) {
        com.mob.commons.f.a().a(mobProduct, n10);
    }

    public static void setDomain(InternationalDomain internationalDomain) {
        e = internationalDomain;
    }

    public static void setPolicyUi(MobPolicyUi mobPolicyUi) {
    }

    public static void setUser(String string2, String string3, String string4, HashMap hashMap) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobSDK.setUser(string2, string3, string4, hashMap, null);
            return;
        }
    }

    public static void setUser(String string2, String string3, String string4, HashMap hashMap, String string5) {
        Class<MobSDK> clazz = MobSDK.class;
        synchronized (clazz) {
            MobUser.a(string2, string3, string4, hashMap, string5);
            return;
        }
    }

    public static void submitPermissionGrantResult(boolean bl2, MobProduct object, OperationCallback operationCallback) {
        if (operationCallback != null) {
            object = new MobSDK$4(operationCallback);
            UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
        }
    }

    public static void submitPolicyGrantResult(boolean bl2, OperationCallback operationCallback) {
        MobSDK$3 mobSDK$3 = new MobSDK$3(bl2, operationCallback);
        Thread thread = new Thread(mobSDK$3);
        thread.start();
    }
}

