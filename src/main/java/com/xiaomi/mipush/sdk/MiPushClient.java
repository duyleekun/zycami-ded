/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient$1;
import com.xiaomi.mipush.sdk.MiPushClient$2;
import com.xiaomi.mipush.sdk.MiPushClient$3;
import com.xiaomi.mipush.sdk.MiPushClient$4;
import com.xiaomi.mipush.sdk.MiPushClient$5;
import com.xiaomi.mipush.sdk.MiPushClient$6;
import com.xiaomi.mipush.sdk.MiPushClient$CodeResult;
import com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult;
import com.xiaomi.mipush.sdk.MiPushClient$MiPushClientCallback;
import com.xiaomi.mipush.sdk.MiPushClient$TokenResult;
import com.xiaomi.mipush.sdk.MiPushClient$UPSRegisterCallBack;
import com.xiaomi.mipush.sdk.MiPushClient$UPSTurnCallBack;
import com.xiaomi.mipush.sdk.MiPushClient$UPSUnRegisterCallBack;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.MiTinyDataClient$a;
import com.xiaomi.mipush.sdk.PushConfiguration;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xiaomi.mipush.sdk.a;
import com.xiaomi.mipush.sdk.af;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.aw;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.mipush.sdk.q;
import com.xiaomi.mipush.sdk.r;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.mipush.sdk.x;
import com.xiaomi.push.ai;
import com.xiaomi.push.au;
import com.xiaomi.push.bf;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.ey;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa;
import com.xiaomi.push.fa$a;
import com.xiaomi.push.fg;
import com.xiaomi.push.g;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.i;
import com.xiaomi.push.ia;
import com.xiaomi.push.ig;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.ix;
import com.xiaomi.push.l;
import com.xiaomi.push.m;
import com.xiaomi.push.n;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak$a;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.t;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static boolean isCrashHandlerSuggested = false;
    private static Context sContext;
    private static long sCurMsgId;

    static {
        sCurMsgId = System.currentTimeMillis();
    }

    private static boolean acceptTimeSet(Context object, String string2, String string3) {
        object = MiPushClient.getAcceptTime(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(",");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        return TextUtils.equals((CharSequence)object, (CharSequence)string2);
    }

    public static /* synthetic */ Context access$000() {
        return sContext;
    }

    public static /* synthetic */ void access$100(Context context, String string2, String string3, MiPushClient$MiPushClientCallback miPushClient$MiPushClientCallback, String string4, MiPushClient$ICallbackResult miPushClient$ICallbackResult) {
        MiPushClient.initialize(context, string2, string3, miPushClient$MiPushClientCallback, string4, miPushClient$ICallbackResult);
    }

    public static /* synthetic */ void access$200(Context context, PackageInfo packageInfo) {
        MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
    }

    public static long accountSetTime(Context context, String string2) {
        context = context.getSharedPreferences(PREF_EXTRA, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("account_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return context.getLong(string2, (long)-1);
    }

    public static void addAcceptTime(Context context, String string2, String string3) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            String string4 = PREF_EXTRA;
            StringBuilder stringBuilder = null;
            context = context.getSharedPreferences(string4, 0);
            context = context.edit();
            string4 = "accept_time";
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = ",";
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            context.putString(string4, string2);
            com.xiaomi.push.r.a((SharedPreferences.Editor)context);
            return;
        }
    }

    public static void addAccount(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "account_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            long l10 = System.currentTimeMillis();
            context = context.putLong(string2, l10);
            context.commit();
            return;
        }
    }

    public static void addAlias(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "alias_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            long l10 = System.currentTimeMillis();
            context = context.putLong(string2, l10);
            context.commit();
            return;
        }
    }

    private static void addPullNotificationTime(Context context) {
        context = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        long l10 = System.currentTimeMillis();
        context.putLong("last_pull_notification", l10);
        com.xiaomi.push.r.a((SharedPreferences.Editor)context);
    }

    private static void addRegRequestTime(Context context) {
        context = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        long l10 = System.currentTimeMillis();
        context.putLong("last_reg_request", l10);
        com.xiaomi.push.r.a((SharedPreferences.Editor)context);
    }

    public static void addTopic(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "topic_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            long l10 = System.currentTimeMillis();
            context = context.putLong(string2, l10);
            context.commit();
            return;
        }
    }

    public static long aliasSetTime(Context context, String string2) {
        context = context.getSharedPreferences(PREF_EXTRA, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("alias_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return context.getLong(string2, (long)-1);
    }

    public static void awakeApps(Context context, String[] stringArray) {
        ai ai2 = ai.a(context);
        MiPushClient$4 miPushClient$4 = new MiPushClient$4(stringArray, context);
        ai2.a(miPushClient$4);
    }

    private static void awakePushServiceByPackageInfo(Context context, PackageInfo intent) {
        intent = intent.services;
        if (intent != null) {
            int n10 = ((ServiceInfo[])intent).length;
            String string2 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                String string3;
                String string4;
                ServiceInfo serviceInfo = intent[i10];
                boolean bl2 = serviceInfo.exported;
                if (!bl2 || !(bl2 = serviceInfo.enabled) || !(bl2 = (string4 = "com.xiaomi.mipush.sdk.PushMessageHandler").equals(string3 = serviceInfo.name)) || (bl2 = (string3 = context.getPackageName()).equals(string4 = serviceInfo.packageName))) continue;
                try {
                    d10 = Math.random() * 2.0 + 1.0;
                }
                catch (Throwable throwable) {}
                long l10 = (long)d10;
                long l11 = 1000L;
                l10 *= l11;
                Thread.sleep(l10);
                intent = new Intent();
                String string5 = serviceInfo.packageName;
                string2 = serviceInfo.name;
                intent.setClassName(string5, string2);
                string5 = "com.xiaomi.mipush.sdk.WAKEUP";
                intent.setAction(string5);
                string5 = "waker_pkgname";
                string2 = context.getPackageName();
                intent.putExtra(string5, string2);
                PushMessageHandler.a(context, intent);
                break;
            }
        }
    }

    private static void checkNotNull(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("param ");
        stringBuilder.append(string2);
        stringBuilder.append(" is not nullable");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private static boolean checkPermission(Context context) {
        int n10;
        Object object;
        String string2;
        int n11;
        boolean bl2;
        String string3;
        String[] stringArray;
        block8: {
            block7: {
                block9: {
                    stringArray = "android.permission.WRITE_EXTERNAL_STORAGE";
                    string3 = "android.permission.READ_PHONE_STATE";
                    bl2 = true;
                    if (context == null) break block7;
                    n11 = l.a();
                    if (n11 != 0 || (n11 = (string2 = "com.xiaomi.xmsf").equals(object = context.getPackageName())) != 0 || (n11 = TextUtils.isEmpty((CharSequence)(object = i.b(context)))) == 0) break block8;
                    object = context.getApplicationInfo();
                    n11 = ((ApplicationInfo)object).targetSdkVersion;
                    n10 = 23;
                    if (n11 < n10 || (n11 = Build.VERSION.SDK_INT) < n10) break block9;
                    n11 = (int)(m.a(context, string3) ? 1 : 0);
                    if (n11 == 0 && (n11 = (int)(m.a(context, (String)stringArray) ? 1 : 0)) == 0 && (n11 = (int)(((au)(object = au.a(context))).a() ? 1 : 0)) == 0) break block7;
                    break block8;
                }
                object = i.f(context);
                string2 = i.a();
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n11 == 0 || (n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) break block8;
            }
            bl2 = false;
        }
        if (!bl2) {
            int n12;
            boolean bl3;
            com.xiaomi.channel.commonutils.logger.b.d("Because of lack of necessary information, mi push can't be initialized");
            object = new ArrayList();
            n10 = m.a(context, string3);
            if (n10 == 0) {
                ((ArrayList)object).add(string3);
            }
            if (!(bl3 = m.a(context, (String)stringArray))) {
                ((ArrayList)object).add(stringArray);
            }
            if ((n12 = ((ArrayList)object).isEmpty()) == 0) {
                n12 = ((ArrayList)object).size();
                stringArray = new String[n12];
                ((ArrayList)object).toArray(stringArray);
                string3 = new Intent();
                string3.setAction("com.xiaomi.mipush.ERROR");
                object = context.getPackageName();
                string3.setPackage((String)object);
                n11 = 5;
                string3.putExtra("message_type", n11);
                string2 = "error_lack_of_permission";
                string3.putExtra("error_type", string2);
                object = "error_message";
                string3.putExtra((String)object, stringArray);
                context.sendBroadcast((Intent)string3);
            }
        }
        return bl2;
    }

    public static void clearExtras(Context context) {
        context = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        context.clear();
        context.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        aq.a(context).e();
    }

    public static void clearNotification(Context context) {
        aq.a(context).a(-1);
    }

    public static void clearNotification(Context context, int n10) {
        aq.a(context).a(n10);
    }

    public static void clearNotification(Context context, String string2, String string3) {
        aq.a(context).a(string2, string3);
    }

    public static void disablePush(Context context) {
        aq.a(context).a(true);
    }

    public static void enablePush(Context context) {
        aq.a(context).a(false);
    }

    private static void forceHandleCrash() {
        Object object = ak.a(sContext);
        hr hr2 = hr.av;
        int n10 = hr2.a();
        boolean bl2 = ((ak)object).a(n10, false);
        n10 = (int)(isCrashHandlerSuggested ? 1 : 0);
        if (n10 == 0 && bl2) {
            hr2 = sContext;
            object = new v((Context)hr2);
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
        }
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getString("accept_time", "00:00-23:59");
    }

    public static List getAllAlias(Context object) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = PREF_EXTRA;
        int n10 = 0;
        String string3 = null;
        object = object.getSharedPreferences(string2, 0).getAll().keySet().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (String)object.next();
            n10 = string2.startsWith(string3 = "alias_");
            if (n10 == 0) continue;
            n10 = 6;
            string2 = string2.substring(n10);
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static List getAllTopic(Context object) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = PREF_EXTRA;
        int n10 = 0;
        String string3 = null;
        object = object.getSharedPreferences(string2, 0).getAll().keySet().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (String)object.next();
            n10 = string2.startsWith(string3 = "topic_");
            if (n10 == 0 || (n10 = string2.contains(string3 = "**ALL**")) != 0) continue;
            n10 = 6;
            string2 = string2.substring(n10);
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static List getAllUserAccount(Context object) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = PREF_EXTRA;
        int n10 = 0;
        String string3 = null;
        object = object.getSharedPreferences(string2, 0).getAll().keySet().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (String)object.next();
            n10 = string2.startsWith(string3 = "account_");
            if (n10 == 0) continue;
            n10 = 8;
            string2 = string2.substring(n10);
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        b b10 = b.a(context);
        boolean bl2 = b10.c();
        if (bl2) {
            return b.a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return l.b();
    }

    public static boolean getOpenFCMPush(Context object) {
        MiPushClient.checkNotNull(object, "context");
        object = e.a((Context)object);
        d d10 = d.b;
        return ((e)object).b(d10);
    }

    public static boolean getOpenHmsPush(Context object) {
        MiPushClient.checkNotNull(object, "context");
        object = e.a((Context)object);
        d d10 = d.a;
        return ((e)object).b(d10);
    }

    public static boolean getOpenOPPOPush(Context object) {
        MiPushClient.checkNotNull(object, "context");
        object = e.a((Context)object);
        d d10 = d.c;
        return ((e)object).b(d10);
    }

    public static boolean getOpenVIVOPush(Context object) {
        object = e.a((Context)object);
        d d10 = d.d;
        return ((e)object).b(d10);
    }

    public static String getRegId(Context context) {
        b b10 = b.a(context);
        boolean bl2 = b10.c();
        if (bl2) {
            return b.a(context).c();
        }
        return null;
    }

    private static void initEventPerfLogic(Context context) {
        Object object = new MiPushClient$5();
        fa.a((fa$a)object);
        object = fa.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a("3_7_5");
        Object object2 = new ey(context);
        ez ez2 = new ez(context);
        ClientReportClient.init(context, (Config)object, (IEventProcessor)object2, ez2);
        a.a(context);
        r.a(context, (Config)object);
        object = ak.a(context);
        object2 = new MiPushClient$6(100, "perf event job update", context);
        ((ak)object).a((ak$a)object2);
    }

    public static void initialize(Context context, String string2, String string3, MiPushClient$MiPushClientCallback miPushClient$MiPushClientCallback) {
        MiPushClient.initialize(context, string2, string3, miPushClient$MiPushClientCallback, null, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void initialize(Context var0, String var1_1, String var2_2, MiPushClient$MiPushClientCallback var3_3, String var4_4, MiPushClient$ICallbackResult var5_5) {
        block178: {
            block174: {
                block177: {
                    block176: {
                        block175: {
                            block173: {
                                block172: {
                                    block171: {
                                        var6_6 = var1_1;
                                        var7_8 = var2_2;
                                        var8_9 = var3_3;
                                        var9_10 = "update_devId";
                                        var10_11 = "sdk_version = 3_7_5";
                                        com.xiaomi.channel.commonutils.logger.b.a((String)var10_11);
                                        if (var3_3 == null) break block171;
                                        PushMessageHandler.a(var3_3);
                                    }
                                    if (var5_5 == null) ** GOTO lbl15
                                    PushMessageHandler.a(var5_5);
lbl15:
                                    // 2 sources

                                    var10_11 = MiPushClient.sContext;
                                    var11_12 = t.a((Context)var10_11);
                                    if (!var11_12) ** GOTO lbl23
                                    var10_11 = MiPushClient.sContext;
                                    x.a((Context)var10_11);
lbl23:
                                    // 2 sources

                                    var10_11 = MiPushClient.sContext;
                                    var10_11 = b.a((Context)var10_11);
                                    var11_12 = var10_11.a((String)var6_6, (String)var7_8);
                                    if (var11_12) break block172;
                                    var10_11 = MiPushClient.sContext;
                                    var11_12 = MiPushClient.checkPermission((Context)var10_11);
                                    if (var11_12) break block172;
                                    return;
                                }
                                var10_11 = MiPushClient.sContext;
                                var10_11 = b.a((Context)var10_11);
                                var11_12 = var10_11.a();
                                var12_13 = Constants.a();
                                var13_14 = 1;
                                var14_15 = 0;
                                var15_16 = null;
                                if (var11_12 != var12_13) {
                                    var11_12 = var13_14;
                                } else {
                                    var11_12 = 0;
                                    var10_11 = null;
                                }
                                if (var11_12) break block173;
                                var16_17 /* !! */  = MiPushClient.sContext;
                                var12_13 = (int)MiPushClient.shouldSendRegRequest(var16_17 /* !! */ );
                                if (var12_13 != 0) break block173;
                                var6_6 = MiPushClient.sContext;
                                var6_6 = aq.a((Context)var6_6);
                                var6_6.a();
                                var6_6 = "Could not send  register message within 5s repeatly .";
                                com.xiaomi.channel.commonutils.logger.b.a((String)var6_6);
                                return;
                            }
                            var12_13 = 30705;
                            var17_18 = "3_7_5";
                            if (var11_12) break block174;
                            var18_19 = MiPushClient.sContext;
                            var18_19 = b.a((Context)var18_19);
                            var19_20 = var18_19.a((String)var6_6, (String)var7_8);
                            if (!var19_20) break block174;
                            var18_19 = MiPushClient.sContext;
                            var18_19 = b.a((Context)var18_19);
                            var19_20 = var18_19.e();
                            if (var19_20) break block174;
                            var7_8 = MiPushClient.sContext;
                            var20_21 = PushMessageHelper.getPushMode((Context)var7_8);
                            var11_12 = 0;
                            var10_11 = null;
                            if (var13_14 != var20_21) break block175;
                            var7_8 = "callback";
                            MiPushClient.checkNotNull(var8_9, (String)var7_8);
                            var21_23 = 0L;
                            var7_8 = MiPushClient.sContext;
                            var7_8 = b.a((Context)var7_8);
                            var7_8 = var7_8.c();
                            var8_9.onInitializeResult(var21_23, null, (String)var7_8);
                            ** GOTO lbl127
                        }
                        var23_24 = new ArrayList<Object>();
                        var7_8 = MiPushClient.sContext;
                        var7_8 = b.a((Context)var7_8);
                        var7_8 = var7_8.c();
                        var23_24.add(var7_8);
                        var7_8 = fg.a;
                        var24_25 = var7_8.a;
                        var25_26 = 0L;
                        var7_8 = PushMessageHelper.generateCommandMessage(var24_25, var23_24, var25_26, null, null);
                        var8_9 = MiPushClient.sContext;
                        PushMessageHelper.sendCommandMessageBroadcast((Context)var8_9, (MiPushCommandMessage)var7_8);
lbl127:
                        // 2 sources

                        var7_8 = MiPushClient.sContext;
                        var7_8 = aq.a((Context)var7_8);
                        var7_8.a();
                        var7_8 = MiPushClient.sContext;
                        var7_8 = b.a((Context)var7_8);
                        var20_21 = (int)var7_8.a();
                        if (var20_21 == 0) ** GOTO lbl216
                        var7_8 = new il();
                        var8_9 = MiPushClient.sContext;
                        var8_9 = b.a((Context)var8_9);
                        var8_9 = var8_9.a();
                        var7_8.b((String)var8_9);
                        var8_9 = "client_info_update";
                        var7_8.c((String)var8_9);
                        var8_9 = an.a();
                        var7_8.a((String)var8_9);
                        var8_9 = new HashMap();
                        var7_8.a = var8_9;
                        var18_19 = "app_version";
                        var27_27 /* !! */  = MiPushClient.sContext;
                        var24_25 = var27_27 /* !! */ .getPackageName();
                        var27_27 /* !! */  = g.a(var27_27 /* !! */ , var24_25);
                        var8_9.put(var18_19, var27_27 /* !! */ );
                        var8_9 = var7_8.a;
                        var18_19 = "app_version_code";
                        var27_27 /* !! */  = MiPushClient.sContext;
                        var24_25 = var27_27 /* !! */ .getPackageName();
                        var28_28 = g.a(var27_27 /* !! */ , var24_25);
                        var27_27 /* !! */  = Integer.toString(var28_28);
                        var8_9.put(var18_19, var27_27 /* !! */ );
                        var8_9 = var7_8.a;
                        var18_19 = "push_sdk_vn";
                        var8_9.put(var18_19, var17_18);
                        var8_9 = var7_8.a;
                        var17_18 = "push_sdk_vc";
                        var16_17 /* !! */  = Integer.toString(var12_13);
                        var8_9.put(var17_18, var16_17 /* !! */ );
                        var8_9 = MiPushClient.sContext;
                        var8_9 = b.a((Context)var8_9);
                        var8_9 = var8_9.e();
                        var12_13 = (int)TextUtils.isEmpty((CharSequence)var8_9);
                        if (var12_13 != 0) ** GOTO lbl209
                        var16_17 /* !! */  = var7_8.a;
                        var17_18 = "deviceid";
                        var16_17 /* !! */ .put(var17_18, var8_9);
lbl209:
                        // 2 sources

                        var8_9 = MiPushClient.sContext;
                        var8_9 = aq.a((Context)var8_9);
                        var16_17 /* !! */  = hm.i;
                        var8_9.a((ix)var7_8, (hm)var16_17 /* !! */ , false, null);
lbl216:
                        // 2 sources

                        var7_8 = MiPushClient.sContext;
                        var20_21 = (int)n.a((Context)var7_8, (String)var9_10, false);
                        if (var20_21 != 0) ** GOTO lbl225
                        MiPushClient.updateImeiOrOaid();
                        var7_8 = MiPushClient.sContext;
                        n.a((Context)var7_8, (String)var9_10, (boolean)var13_14);
lbl225:
                        // 2 sources

                        var7_8 = MiPushClient.sContext;
                        var7_8 = i.d((Context)var7_8);
                        var29_29 = TextUtils.isEmpty((CharSequence)var7_8);
                        if (var29_29) ** GOTO lbl282
                        var8_9 = new ig();
                        var9_10 = an.a();
                        var8_9.a((String)var9_10);
                        var8_9.b((String)var6_6);
                        var6_6 = fg.j;
                        var6_6 = var6_6.a;
                        var8_9.c((String)var6_6);
                        var6_6 = new ArrayList();
                        var9_10 = MiPushClient.sContext;
                        var9_10 = i.c((Context)var9_10);
                        var6_6.add(var9_10);
                        var6_6.add(var7_8);
                        var7_8 = Build.MODEL;
                        var9_10 = "";
                        if (var7_8 != null) break block176;
                        var7_8 = var9_10;
                    }
                    var6_6.add(var7_8);
                    var7_8 = Build.BOARD;
                    if (var7_8 == null) break block177;
                    var9_10 = var7_8;
                }
                var6_6.add(var9_10);
                var8_9.a((List)var6_6);
                var6_6 = MiPushClient.sContext;
                var6_6 = aq.a((Context)var6_6);
                var7_8 = hm.j;
                var6_6.a((ix)var8_9, (hm)var7_8, false, null);
lbl282:
                // 2 sources

                var6_6 = MiPushClient.sContext;
                var30_31 = MiPushClient.shouldUseMIUIPush((Context)var6_6);
                if (var30_31 == 0) ** GOTO lbl469
                var6_6 = MiPushClient.sContext;
                var30_31 = (int)MiPushClient.shouldPullNotification((Context)var6_6);
                if (var30_31 == 0) ** GOTO lbl469
                var8_9 = new il();
                var6_6 = MiPushClient.sContext;
                var6_6 = b.a((Context)var6_6);
                var6_6 = var6_6.a();
                var8_9.b((String)var6_6);
                var6_6 = hw.j;
                var6_6 = var6_6.a;
                var8_9.c((String)var6_6);
                var6_6 = an.a();
                var8_9.a((String)var6_6);
                var8_9.a(false);
                var6_6 = MiPushClient.sContext;
                var7_8 = aq.a((Context)var6_6);
                var9_10 = hm.i;
                var11_12 = 0;
                var10_11 = null;
                var12_13 = 0;
                var16_17 /* !! */  = null;
                var13_14 = 0;
                var7_8.a((ix)var8_9, (hm)var9_10, false, null, false);
                var6_6 = MiPushClient.sContext;
                MiPushClient.addPullNotificationTime((Context)var6_6);
                ** GOTO lbl469
            }
            var29_30 = 6;
            var8_9 = bf.a(var29_30);
            var9_10 = MiPushClient.sContext;
            var9_10 = b.a((Context)var9_10);
            var9_10.a();
            var9_10 = MiPushClient.sContext;
            var9_10 = b.a((Context)var9_10);
            var14_15 = Constants.a();
            var9_10.a(var14_15);
            var9_10 = MiPushClient.sContext;
            var9_10 = b.a((Context)var9_10);
            var9_10.a((String)var6_6, (String)var7_8, (String)var8_9);
            var9_10 = MiTinyDataClient$a.a();
            var15_16 = "com.xiaomi.xmpushsdk.tinydataPending.appId";
            var9_10.b(var15_16);
            var9_10 = MiPushClient.sContext;
            MiPushClient.clearExtras((Context)var9_10);
            var9_10 = new im();
            var15_16 = an.a();
            var9_10.a(var15_16);
            var9_10.b((String)var6_6);
            var9_10.e((String)var7_8);
            var6_6 = MiPushClient.sContext;
            var6_6 = var6_6.getPackageName();
            var9_10.d((String)var6_6);
            var9_10.f((String)var8_9);
            var6_6 = MiPushClient.sContext;
            var7_8 = var6_6.getPackageName();
            var6_6 = g.a((Context)var6_6, (String)var7_8);
            var9_10.c((String)var6_6);
            var6_6 = MiPushClient.sContext;
            var7_8 = var6_6.getPackageName();
            var30_31 = g.a((Context)var6_6, (String)var7_8);
            var9_10.b(var30_31);
            var9_10.h(var17_18);
            var9_10.a(var12_13);
            var6_6 = MiPushClient.sContext;
            var6_6 = i.e((Context)var6_6);
            var9_10.i((String)var6_6);
            var6_6 = ia.c;
            var9_10.a((ia)var6_6);
            var30_31 = (int)TextUtils.isEmpty((CharSequence)var4_4);
            if (var30_31 != 0) ** GOTO lbl418
            var6_6 = var4_4;
            var9_10.g(var4_4);
lbl418:
            // 2 sources

            if ((var30_31 = (int)l.d()) != 0) ** GOTO lbl446
            var6_6 = MiPushClient.sContext;
            var6_6 = i.g((Context)var6_6);
            var20_22 = TextUtils.isEmpty((CharSequence)var6_6);
            if (var20_22) ** GOTO lbl446
            var7_8 = new StringBuilder();
            var6_6 = bf.a((String)var6_6);
            var7_8.append((String)var6_6);
            var6_6 = ",";
            var7_8.append((String)var6_6);
            var6_6 = MiPushClient.sContext;
            var6_6 = i.j((Context)var6_6);
            var7_8.append((String)var6_6);
            var6_6 = var7_8.toString();
            var9_10.k((String)var6_6);
lbl446:
            // 3 sources

            var6_6 = i.a();
            var9_10.j((String)var6_6);
            var30_31 = i.a();
            if (var30_31 < 0) ** GOTO lbl455
            var9_10.c(var30_31);
lbl455:
            // 2 sources

            var6_6 = MiPushClient.sContext;
            var6_6 = aq.a((Context)var6_6);
            var6_6.a((im)var9_10, (boolean)var11_12);
            var6_6 = MiPushClient.sContext;
            var7_8 = "mipush_extra";
            var29_30 = 4;
            var6_6 = var6_6.getSharedPreferences((String)var7_8, var29_30);
            var7_8 = "mipush_registed";
            var6_6.getBoolean((String)var7_8, (boolean)var13_14);
lbl469:
            // 4 sources

            var6_6 = MiPushClient.sContext;
            MiPushClient.addRegRequestTime((Context)var6_6);
            MiPushClient.scheduleOcVersionCheckJob();
            var6_6 = MiPushClient.sContext;
            MiPushClient.scheduleDataCollectionJobs((Context)var6_6);
            var6_6 = MiPushClient.sContext;
            MiPushClient.initEventPerfLogic((Context)var6_6);
            var6_6 = MiPushClient.sContext;
            aw.a((Context)var6_6);
            MiPushClient.forceHandleCrash();
            var6_6 = MiPushClient.sContext;
            var6_6 = var6_6.getPackageName();
            var7_8 = "com.xiaomi.xmsf";
            var30_31 = (int)var6_6.equals(var7_8);
            if (var30_31 != 0) ** GOTO lbl503
            var6_6 = Logger.getUserLogger();
            if (var6_6 == null) break block178;
            var6_6 = MiPushClient.sContext;
            var7_8 = Logger.getUserLogger();
            Logger.setLogger((Context)var6_6, (LoggerInterface)var7_8);
        }
        var30_31 = 2;
        try {
            com.xiaomi.channel.commonutils.logger.b.a(var30_31);
lbl503:
            // 2 sources

            MiPushClient.operateSyncAction(var0);
        }
        catch (Throwable var6_7) {
            com.xiaomi.channel.commonutils.logger.b.a(var6_7);
        }
    }

    private static void operateSyncAction(Context context) {
        Object object = ag.a(sContext);
        Object object2 = av.a;
        object2 = "syncing";
        boolean bl2 = ((String)object2).equals(object = ((ag)object).a((av)((Object)object2)));
        if (bl2) {
            object = sContext;
            MiPushClient.disablePush((Context)object);
        }
        object = ag.a(sContext);
        av av2 = av.b;
        bl2 = ((String)object2).equals(object = ((ag)object).a(av2));
        if (bl2) {
            object = sContext;
            MiPushClient.enablePush((Context)object);
        }
        object = ag.a(sContext);
        av2 = av.c;
        bl2 = ((String)object2).equals(object = ((ag)object).a(av2));
        if (bl2) {
            object = sContext;
            MiPushClient.syncAssemblePushToken((Context)object);
        }
        object = ag.a(sContext);
        av2 = av.d;
        bl2 = ((String)object2).equals(object = ((ag)object).a(av2));
        if (bl2) {
            object = sContext;
            MiPushClient.syncAssembleFCMPushToken((Context)object);
        }
        object = ag.a(sContext);
        av2 = av.e;
        bl2 = ((String)object2).equals(object = ((ag)object).a(av2));
        if (bl2) {
            MiPushClient.syncAssembleCOSPushToken(context);
        }
        object = ag.a(sContext);
        av2 = av.f;
        bl2 = ((String)object2).equals(object = ((ag)object).a(av2));
        if (bl2) {
            MiPushClient.syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String string2) {
        MiPushClient.setAcceptTime(context, 0, 0, 0, 0, string2);
    }

    public static void reInitialize(Context context, ia ia2) {
        Object object = b.a(context);
        boolean bl2 = ((b)object).c();
        if (!bl2) {
            return;
        }
        object = bf.a(6);
        String string2 = b.a(context).a();
        String string3 = b.a(context).b();
        b.a(context).a();
        Object object2 = b.a(context);
        int n10 = Constants.a();
        ((b)object2).a(n10);
        b.a(context).a(string2, string3, (String)object);
        object2 = new im();
        String string4 = an.a();
        ((im)object2).a(string4);
        ((im)object2).b(string2);
        ((im)object2).e(string3);
        ((im)object2).f((String)object);
        object = context.getPackageName();
        ((im)object2).d((String)object);
        object = context.getPackageName();
        object = g.a(context, (String)object);
        ((im)object2).c((String)object);
        ((im)object2).a(ia2);
        aq.a(context).a((im)object2, false);
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Context context = sContext;
        v v10 = new v(context, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(v10);
        isCrashHandlerSuggested = true;
    }

    private static void registerNetworkReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        Object object = "android.net.conn.CONNECTIVITY_CHANGE";
        intentFilter.addAction(object);
        object = "android.intent.category.DEFAULT";
        intentFilter.addCategory(object);
        context = context.getApplicationContext();
        object = new NetworkStatusReceiver(null);
        try {
            context.registerReceiver((BroadcastReceiver)object, intentFilter);
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
        }
    }

    public static void registerPush(Context context, String string2, String string3) {
        PushConfiguration pushConfiguration = new PushConfiguration();
        MiPushClient.registerPush(context, string2, string3, pushConfiguration);
    }

    public static void registerPush(Context context, String string2, String string3, PushConfiguration pushConfiguration) {
        MiPushClient.registerPush(context, string2, string3, pushConfiguration, null, null);
    }

    private static void registerPush(Context object, String string2, String string3, PushConfiguration object2, String string4, MiPushClient$ICallbackResult miPushClient$ICallbackResult) {
        Context context;
        MiPushClient.checkNotNull(object, "context");
        MiPushClient.checkNotNull(string2, "appID");
        MiPushClient.checkNotNull(string3, "appToken");
        sContext = context = object.getApplicationContext();
        if (context == null) {
            sContext = object;
        }
        object = sContext;
        t.a((Context)object);
        boolean bl2 = NetworkStatusReceiver.a();
        if (!bl2) {
            context = sContext;
            MiPushClient.registerNetworkReceiver(context);
        }
        e.a(sContext).a((PushConfiguration)object2);
        object = ai.a((Context)object);
        object2 = new MiPushClient$1(string2, string3, string4, miPushClient$ICallbackResult);
        ((ai)object).a((Runnable)object2);
    }

    public static void registerPush(Context context, String string2, String string3, String string4) {
        PushConfiguration pushConfiguration = new PushConfiguration();
        MiPushClient.registerPush(context, string2, string3, pushConfiguration, string4, null);
    }

    public static void registerToken(Context context, String string2, String string3, String string4, MiPushClient$UPSRegisterCallBack miPushClient$UPSRegisterCallBack) {
        PushConfiguration pushConfiguration = new PushConfiguration();
        MiPushClient.registerPush(context, string2, string3, pushConfiguration, null, miPushClient$UPSRegisterCallBack);
    }

    public static void removeAcceptTime(Context context) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            String string2 = PREF_EXTRA;
            context = context.getSharedPreferences(string2, 0);
            context = context.edit();
            string2 = "accept_time";
            context.remove(string2);
            com.xiaomi.push.r.a((SharedPreferences.Editor)context);
            return;
        }
    }

    public static void removeAccount(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "account_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            context = context.remove(string2);
            context.commit();
            return;
        }
    }

    public static void removeAlias(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "alias_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            context = context.remove(string2);
            context.commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeAllAccounts(Context context) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            Object object = MiPushClient.getAllUserAccount(context);
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (String)object2;
                MiPushClient.removeAccount(context, object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeAllAliases(Context context) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            Object object = MiPushClient.getAllAlias(context);
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (String)object2;
                MiPushClient.removeAlias(context, object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeAllTopics(Context context) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            Object object = MiPushClient.getAllTopic(context);
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (String)object2;
                MiPushClient.removeTopic(context, object2);
            }
            return;
        }
    }

    public static void removeTopic(Context context, String string2) {
        Class<MiPushClient> clazz = MiPushClient.class;
        synchronized (clazz) {
            CharSequence charSequence = PREF_EXTRA;
            String string3 = null;
            context = context.getSharedPreferences((String)charSequence, 0);
            context = context.edit();
            charSequence = new StringBuilder();
            string3 = "topic_";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            context = context.remove(string2);
            context.commit();
            return;
        }
    }

    public static void reportAppRunInBackground(Context context, boolean bl2) {
        Object object = b.a(context);
        boolean bl3 = ((b)object).b();
        if (!bl3) {
            return;
        }
        Object object2 = bl2 ? hw.Q : hw.P;
        il il2 = new il();
        object = b.a(context).a();
        il2.b((String)object);
        object2 = object2.a;
        il2.c((String)object2);
        object2 = context.getPackageName();
        il2.d((String)object2);
        object2 = an.a();
        il2.a((String)object2);
        il2.a(false);
        object = aq.a(context);
        hm hm2 = hm.i;
        ((aq)object).a(il2, hm2, false, null, false);
    }

    public static void reportIgnoreRegMessageClicked(Context context, String string2, hz hz2, String string3, String string4) {
        il il2 = new il();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        il2.b(string4);
        il2.c("bar:click");
        il2.a(string2);
        il2.a(false);
        aq aq2 = aq.a(context);
        hm hm2 = hm.i;
        aq2.a(il2, hm2, false, true, hz2, true, string3, string4);
    }

    public static void reportMessageClicked(Context context, MiPushMessage object) {
        hz hz2 = new hz();
        Object object2 = ((MiPushMessage)object).getMessageId();
        hz2.a((String)object2);
        object2 = ((MiPushMessage)object).getTopic();
        hz2.b((String)object2);
        object2 = ((MiPushMessage)object).getDescription();
        hz2.d((String)object2);
        object2 = ((MiPushMessage)object).getTitle();
        hz2.c((String)object2);
        int n10 = ((MiPushMessage)object).getNotifyId();
        hz2.c(n10);
        n10 = ((MiPushMessage)object).getNotifyType();
        hz2.a(n10);
        n10 = ((MiPushMessage)object).getPassThrough();
        hz2.b(n10);
        object2 = ((MiPushMessage)object).getExtra();
        hz2.a((Map)object2);
        object = ((MiPushMessage)object).getMessageId();
        MiPushClient.reportMessageClicked(context, (String)object, hz2, null);
    }

    public static void reportMessageClicked(Context context, String string2) {
        MiPushClient.reportMessageClicked(context, string2, null, null);
    }

    public static void reportMessageClicked(Context object, String string2, hz hz2, String object2) {
        il il2 = new il();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            object2 = b.a((Context)object);
            boolean bl3 = ((b)object2).b();
            if (bl3) {
                object2 = b.a((Context)object).a();
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        }
        il2.b((String)object2);
        il2.c("bar:click");
        il2.a(string2);
        il2.a(false);
        object = aq.a((Context)object);
        object2 = hm.i;
        ((aq)object).a(il2, (hm)((Object)object2), false, hz2);
    }

    public static void resumePush(Context context, String string2) {
        MiPushClient.setAcceptTime(context, 0, 0, 23, 59, string2);
    }

    private static void scheduleDataCollectionJobs(Context object) {
        boolean bl2;
        Object object2 = hr.z;
        int n10 = ((hr)((Object)object2)).a();
        Object object3 = ak.a(sContext);
        n10 = (int)(((ak)object3).a(n10, bl2 = MiPushClient.getDefaultSwitch()) ? 1 : 0);
        if (n10 != 0) {
            object2 = dq.a();
            object3 = new q((Context)object);
            ((dq)object2).a((dp)object3);
            object = ai.a(sContext);
            object2 = new MiPushClient$2();
            int n11 = 10;
            ((ai)object).a((Runnable)object2, n11);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        ak ak2 = ak.a(sContext);
        int n10 = hr.A.a();
        int n11 = ak2.a(n10, 86400);
        ai ai2 = ai.a(sContext);
        Context context = sContext;
        af af2 = new af(context);
        ai2.a(af2, n11, 5);
    }

    public static void setAcceptTime(Context context, int n10, int n11, int n12, int n13, String string2) {
        int n14;
        Object object = context;
        int n15 = n10;
        if (n10 >= 0 && n10 < (n14 = 24) && n12 >= 0 && n12 < n14 && n11 >= 0 && n11 < (n14 = 60) && n13 >= 0 && n13 < n14) {
            Object object2;
            Object object3 = DesugarTimeZone.getTimeZone("GMT+08");
            Object object4 = TimeZone.getDefault();
            long l10 = 1440L;
            int n16 = ((TimeZone)object3).getRawOffset();
            int n17 = ((TimeZone)object4).getRawOffset();
            long l11 = (n16 - n17) / 1000 / n14;
            long l12 = ((long)(n10 * 60 + n11) + l11 + l10) % l10;
            n17 = n12 * 60 + n13;
            long l13 = ((long)n17 + l11 + l10) % l10;
            ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
            n16 = 2;
            object4 = new Object[n16];
            l10 = 60;
            long l14 = l12 / l10;
            Long l15 = l14;
            object4[0] = l15;
            Object object5 = l12 %= l10;
            int n18 = 1;
            object4[n18] = object5;
            object5 = "%1$02d:%2$02d";
            object4 = String.format((String)object5, (Object[])object4);
            arrayList.add((Object[])object4);
            object4 = new Object[n16];
            long l16 = l13 / l10;
            l15 = l16;
            object4[0] = l15;
            Object[] objectArray = Long.valueOf(l13 %= l10);
            object4[n18] = objectArray;
            object4 = String.format((String)object5, (Object[])object4);
            arrayList.add((Object[])object4);
            object4 = new ArrayList();
            objectArray = new Object[n16];
            Object object6 = n10;
            objectArray[0] = object6;
            object6 = n11;
            objectArray[n18] = object6;
            object6 = String.format((String)object5, objectArray);
            ((ArrayList)object4).add(object6);
            object6 = new Object[n16];
            object6[0] = object2 = Integer.valueOf(n12);
            object6[n18] = object2 = Integer.valueOf(n13);
            object6 = String.format((String)object5, object6);
            ((ArrayList)object4).add(object6);
            object6 = (String)arrayList.get(0);
            object2 = (String)arrayList.get(n18);
            n15 = (int)(MiPushClient.acceptTimeSet(context, (String)object6, (String)object2) ? 1 : 0);
            if (n15 != 0) {
                n15 = PushMessageHelper.getPushMode(context);
                if (n18 == n15) {
                    object2 = fg.i.a;
                    long l17 = 0L;
                    n14 = 0;
                    arrayList = null;
                    object6 = string2;
                    object3 = object4;
                    PushMessageHandler.a(context, string2, (String)object2, l17, null, (List)object4);
                } else {
                    object6 = fg.i.a;
                    long l18 = 0L;
                    object6 = PushMessageHelper.generateCommandMessage((String)object6, (List)object4, l18, null, null);
                    PushMessageHelper.sendCommandMessageBroadcast(context, (MiPushCommandMessage)object6);
                }
            } else {
                object6 = fg.i.a;
                object2 = string2;
                MiPushClient.setCommand(context, (String)object6, arrayList, string2);
            }
            return;
        }
        object = new IllegalArgumentException("the input parameter is not valid.");
        throw object;
    }

    public static void setAlias(Context context, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            String string4 = fg.c.a;
            MiPushClient.setCommand(context, string4, string2, string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void setCommand(Context object, String object2, String string2, String string3) {
        ArrayList<String> arrayList;
        block13: {
            int n10;
            Object object3;
            block11: {
                long l10;
                long l11;
                long l12;
                long l13;
                Object object4;
                int n11;
                block12: {
                    long l14;
                    block9: {
                        block8: {
                            int n12;
                            block10: {
                                long l15;
                                block7: {
                                    arrayList = new ArrayList<String>();
                                    n11 = TextUtils.isEmpty((CharSequence)string2);
                                    if (n11 == 0) {
                                        arrayList.add(string2);
                                    }
                                    object4 = fg.c;
                                    object3 = ((fg)object4).a;
                                    boolean bl2 = ((String)object3).equalsIgnoreCase((String)object2);
                                    n12 = 1;
                                    if (!bl2) break block7;
                                    l14 = System.currentTimeMillis();
                                    l13 = MiPushClient.aliasSetTime((Context)object, string2);
                                    long l16 = (l14 = Math.abs(l14 - l13)) - (l13 = 86400000L);
                                    Object object5 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                    if (object5 >= 0) break block7;
                                    int n13 = PushMessageHelper.getPushMode((Context)object);
                                    if (n12 != n13) break block8;
                                    break block9;
                                }
                                object4 = fg.d.a;
                                n11 = ((String)object4).equalsIgnoreCase((String)object2);
                                object3 = " is unseted";
                                n10 = 3;
                                l12 = 0L;
                                if (n11 == 0 || (n11 = (l15 = (l13 = MiPushClient.aliasSetTime((Context)object, string2)) - l12) == 0L ? 0 : (l15 < 0L ? -1 : 1)) >= 0) break block10;
                                object = new StringBuilder();
                                object2 = "Don't cancel alias for ";
                                break block11;
                            }
                            object4 = fg.e;
                            String string4 = ((fg)object4).a;
                            boolean bl3 = string4.equalsIgnoreCase((String)object2);
                            if (!bl3) break block12;
                            l13 = System.currentTimeMillis();
                            long l17 = MiPushClient.accountSetTime((Context)object, string2);
                            long l18 = (l13 = Math.abs(l13 - l17)) - (l17 = 3600000L);
                            Object object6 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                            if (object6 >= 0) break block12;
                            int n14 = PushMessageHelper.getPushMode((Context)object);
                            if (n12 == n14) break block9;
                        }
                        object4 = ((fg)object4).a;
                        long l19 = 0L;
                        object3 = arrayList;
                        object2 = PushMessageHelper.generateCommandMessage((String)object4, arrayList, l19, null, string3);
                        PushMessageHelper.sendCommandMessageBroadcast((Context)object, (MiPushCommandMessage)object2);
                        return;
                    }
                    l14 = 0L;
                    object4 = object;
                    object3 = string3;
                    PushMessageHandler.a((Context)object, string3, (String)object2, l14, null, arrayList);
                    return;
                }
                if ((n11 = (int)(((String)(object4 = fg.f.a)).equalsIgnoreCase((String)object2) ? 1 : 0)) == 0 || (l11 = (l10 = (l13 = MiPushClient.accountSetTime((Context)object, string2)) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) break block13;
                object = new StringBuilder();
                object2 = "Don't cancel account for ";
            }
            ((StringBuilder)object).append((String)object2);
            object2 = bf.a(arrayList.toString(), n10);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((String)object3);
            object = ((StringBuilder)object).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)object);
            return;
        }
        MiPushClient.setCommand((Context)object, (String)object2, arrayList, string3);
    }

    public static void setCommand(Context object, String object2, ArrayList object3, String string2) {
        boolean bl2;
        Object object4 = b.a((Context)object).a();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
        if (bl3) {
            return;
        }
        object4 = new ig();
        String string3 = an.a();
        ((ig)object4).a(string3);
        string3 = b.a((Context)object).a();
        ((ig)object4).b(string3);
        ((ig)object4).c((String)object2);
        object2 = ((ArrayList)object3).iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (String)object2.next();
            ((ig)object4).a((String)object3);
        }
        ((ig)object4).e(string2);
        object2 = object.getPackageName();
        ((ig)object4).d((String)object2);
        object = aq.a((Context)object);
        object2 = hm.j;
        ((aq)object).a((ix)object4, (hm)((Object)object2), null);
    }

    public static void setLocalNotificationType(Context context, int n10) {
        aq.a(context).b(n10 &= 0xFFFFFFFF);
    }

    public static void setUserAccount(Context context, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            String string4 = fg.e.a;
            MiPushClient.setCommand(context, string4, string2, string3);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        boolean bl2 = false;
        context = context.getSharedPreferences(PREF_EXTRA, 0);
        long l10 = System.currentTimeMillis();
        String string2 = "last_pull_notification";
        long l11 = context.getLong(string2, (long)-1);
        long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 300000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean shouldSendRegRequest(Context context) {
        boolean bl2 = false;
        context = context.getSharedPreferences(PREF_EXTRA, 0);
        long l10 = System.currentTimeMillis();
        String string2 = "last_reg_request";
        long l11 = context.getLong(string2, (long)-1);
        long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 5000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return aq.a(context).a();
    }

    public static void subscribe(Context object, String object2, String string2) {
        Object object3 = b.a((Context)object).a();
        Object object4 = TextUtils.isEmpty((CharSequence)object3);
        if (object4 == 0 && (object4 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = MiPushClient.topicSubscribedTime((Context)object, (String)object2);
            long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 86400000L);
            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 > 0) {
                object3 = new iq();
                String string3 = an.a();
                ((iq)object3).a(string3);
                string3 = b.a((Context)object).a();
                ((iq)object3).b(string3);
                ((iq)object3).c((String)object2);
                object2 = object.getPackageName();
                ((iq)object3).d((String)object2);
                ((iq)object3).e(string2);
                object = aq.a((Context)object);
                object2 = hm.c;
                string2 = null;
                ((aq)object).a((ix)object3, (hm)((Object)object2), null);
            } else {
                object4 = 1;
                int n10 = PushMessageHelper.getPushMode((Context)object);
                if (object4 == n10) {
                    long l13 = 0L;
                    String string4 = object2;
                    PushMessageHandler.a((Context)object, string2, l13, null, (String)object2);
                } else {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    arrayList.add((String)object2);
                    String string5 = fg.g.a;
                    long l14 = 0L;
                    object2 = PushMessageHelper.generateCommandMessage(string5, arrayList, l14, null, null);
                    PushMessageHelper.sendCommandMessageBroadcast((Context)object, (MiPushCommandMessage)object2);
                }
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context object) {
        object = aq.a((Context)object);
        av av2 = av.e;
        d d10 = d.c;
        ((aq)object).a(null, av2, d10);
    }

    public static void syncAssembleFCMPushToken(Context object) {
        object = aq.a((Context)object);
        av av2 = av.d;
        d d10 = d.b;
        ((aq)object).a(null, av2, d10);
    }

    public static void syncAssembleFTOSPushToken(Context object) {
        object = aq.a((Context)object);
        av av2 = av.f;
        d d10 = d.d;
        ((aq)object).a(null, av2, d10);
    }

    public static void syncAssemblePushToken(Context object) {
        object = aq.a((Context)object);
        av av2 = av.c;
        d d10 = d.a;
        ((aq)object).a(null, av2, d10);
    }

    public static long topicSubscribedTime(Context context, String string2) {
        context = context.getSharedPreferences(PREF_EXTRA, 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topic_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return context.getLong(string2, (long)-1);
    }

    public static void turnOffPush(Context object, MiPushClient$UPSTurnCallBack miPushClient$UPSTurnCallBack) {
        MiPushClient.disablePush((Context)object);
        if (miPushClient$UPSTurnCallBack != null) {
            object = new MiPushClient$CodeResult();
            long l10 = 0L;
            ((MiPushClient$CodeResult)object).setResultCode(l10);
            ((MiPushClient$CodeResult)object).getResultCode();
            miPushClient$UPSTurnCallBack.onResult(object);
        }
    }

    public static void turnOnPush(Context object, MiPushClient$UPSTurnCallBack miPushClient$UPSTurnCallBack) {
        MiPushClient.enablePush((Context)object);
        if (miPushClient$UPSTurnCallBack != null) {
            object = new MiPushClient$CodeResult();
            long l10 = 0L;
            ((MiPushClient$CodeResult)object).setResultCode(l10);
            ((MiPushClient$CodeResult)object).getResultCode();
            miPushClient$UPSTurnCallBack.onResult(object);
        }
    }

    public static void unRegisterToken(Context object, MiPushClient$UPSUnRegisterCallBack miPushClient$UPSUnRegisterCallBack) {
        MiPushClient.unregisterPush((Context)object);
        if (miPushClient$UPSUnRegisterCallBack != null) {
            object = new MiPushClient$TokenResult();
            ((MiPushClient$TokenResult)object).setToken(null);
            ((MiPushClient$TokenResult)object).getToken();
            long l10 = 0L;
            ((MiPushClient$TokenResult)object).setResultCode(l10);
            ((MiPushClient$TokenResult)object).getResultCode();
            miPushClient$UPSUnRegisterCallBack.onResult(object);
        }
    }

    public static void unregisterPush(Context context) {
        h.c(context);
        ak.a(context).a();
        Object object = b.a(context);
        boolean bl2 = ((b)object).b();
        if (!bl2) {
            return;
        }
        object = new is();
        String string2 = an.a();
        ((is)object).a(string2);
        string2 = b.a(context).a();
        ((is)object).b(string2);
        string2 = b.a(context).c();
        ((is)object).c(string2);
        string2 = b.a(context).b();
        ((is)object).e(string2);
        string2 = context.getPackageName();
        ((is)object).d(string2);
        aq.a(context).a((is)object);
        PushMessageHandler.a();
        PushMessageHandler.b();
        b.a(context).b();
        MiPushClient.clearLocalNotificationType(context);
        MiPushClient.clearNotification(context);
        MiPushClient.clearExtras(context);
    }

    public static void unsetAlias(Context context, String string2, String string3) {
        String string4 = fg.d.a;
        MiPushClient.setCommand(context, string4, string2, string3);
    }

    public static void unsetUserAccount(Context context, String string2, String string3) {
        String string4 = fg.f.a;
        MiPushClient.setCommand(context, string4, string2, string3);
    }

    public static void unsubscribe(Context object, String object2, String string2) {
        long l10;
        Object object3 = b.a((Context)object);
        Object object4 = ((b)object3).b();
        if (object4 == 0) {
            return;
        }
        long l11 = MiPushClient.topicSubscribedTime((Context)object, object2);
        long l12 = l11 - (l10 = 0L);
        object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object4 < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Don't cancel subscribe for ");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" is unsubscribed");
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            return;
        }
        object3 = new iu();
        String string3 = an.a();
        ((iu)object3).a(string3);
        string3 = b.a((Context)object).a();
        ((iu)object3).b(string3);
        ((iu)object3).c((String)object2);
        object2 = object.getPackageName();
        ((iu)object3).d((String)object2);
        ((iu)object3).e(string2);
        object = aq.a((Context)object);
        object2 = hm.d;
        ((aq)object).a((ix)object3, (hm)((Object)object2), null);
    }

    private static void updateImeiOrOaid() {
        MiPushClient$3 miPushClient$3 = new MiPushClient$3();
        Thread thread = new Thread(miPushClient$3);
        thread.start();
    }
}

