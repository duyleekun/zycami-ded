/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.PackageInfo
 *  android.content.pm.ServiceInfo
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushClient4Hybrid;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.PushMessageHandler$a;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.ah;
import com.xiaomi.mipush.sdk.aj;
import com.xiaomi.mipush.sdk.ao;
import com.xiaomi.mipush.sdk.ap;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.aw;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.mipush.sdk.n;
import com.xiaomi.mipush.sdk.t;
import com.xiaomi.push.ai;
import com.xiaomi.push.bf;
import com.xiaomi.push.bp;
import com.xiaomi.push.df;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.i;
import com.xiaomi.push.ia;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;
import com.xiaomi.push.r;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.at;
import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class an {
    private static an a;
    private static Object a;
    private static Queue a;
    private Context a;

    static {
        Object object;
        a = object = new Object();
    }

    private an(Context context) {
        Context context2;
        this.a = context2 = context.getApplicationContext();
        if (context2 == null) {
            this.a = context;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Intent a(Context object, String object2, Map object3) {
        CharSequence charSequence;
        block37: {
            int n10;
            int n11;
            block32: {
                block33: {
                    CharSequence charSequence2;
                    block40: {
                        block36: {
                            block35: {
                                block38: {
                                    boolean bl2;
                                    String string2;
                                    block39: {
                                        block34: {
                                            block31: {
                                                if (object3 == null) return null;
                                                charSequence2 = "notify_effect";
                                                n11 = object3.containsKey(charSequence2);
                                                if (n11 == 0) return null;
                                                charSequence2 = (String)object3.get(charSequence2);
                                                n11 = -1;
                                                string2 = (String)object3.get("intent_flag");
                                                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                                                if (bl3) break block31;
                                                try {
                                                    n11 = Integer.parseInt(string2);
                                                }
                                                catch (NumberFormatException numberFormatException) {
                                                    charSequence = new StringBuilder();
                                                    String string3 = "Cause by intent_flag: ";
                                                    ((StringBuilder)charSequence).append(string3);
                                                    string2 = numberFormatException.getMessage();
                                                    ((StringBuilder)charSequence).append(string2);
                                                    string2 = ((StringBuilder)charSequence).toString();
                                                    com.xiaomi.channel.commonutils.logger.b.d(string2);
                                                }
                                            }
                                            string2 = at.a;
                                            bl2 = string2.equals(charSequence2);
                                            charSequence = "Cause: ";
                                            if (bl2) {
                                                try {
                                                    object3 = object.getPackageManager();
                                                }
                                                catch (Exception exception) {
                                                    object3 = new StringBuilder();
                                                    ((StringBuilder)object3).append((String)charSequence);
                                                    object2 = exception.getMessage();
                                                    ((StringBuilder)object3).append((String)object2);
                                                    object2 = ((StringBuilder)object3).toString();
                                                    com.xiaomi.channel.commonutils.logger.b.d((String)object2);
                                                    return null;
                                                }
                                                object2 = object3.getLaunchIntentForPackage((String)object2);
                                                break block32;
                                            }
                                            string2 = at.b;
                                            bl2 = string2.equals(charSequence2);
                                            if (!bl2) break block38;
                                            charSequence2 = "intent_uri";
                                            bl2 = object3.containsKey(charSequence2);
                                            if (!bl2) break block39;
                                            if ((object3 = (String)object3.get(charSequence2)) == null) return null;
                                            int n12 = 1;
                                            object3 = Intent.parseUri((String)object3, (int)n12);
                                            try {
                                                object3.setPackage((String)object2);
                                                break block33;
                                            }
                                            catch (URISyntaxException uRISyntaxException) {
                                                break block34;
                                            }
                                            catch (URISyntaxException uRISyntaxException) {
                                                n10 = 0;
                                                object3 = null;
                                            }
                                        }
                                        charSequence2 = new StringBuilder();
                                        ((StringBuilder)charSequence2).append((String)charSequence);
                                        object2 = ((URISyntaxException)object2).getMessage();
                                        break block40;
                                    }
                                    charSequence2 = "class_name";
                                    bl2 = object3.containsKey(charSequence2);
                                    if (!bl2) return null;
                                    object3 = (String)object3.get(charSequence2);
                                    charSequence2 = new Intent();
                                    string2 = new ComponentName((String)object2, (String)object3);
                                    charSequence2.setComponent((ComponentName)string2);
                                    object2 = charSequence2;
                                    break block32;
                                }
                                object2 = at.c;
                                boolean bl4 = ((String)object2).equals(charSequence2);
                                if (!bl4) return null;
                                object2 = (String)object3.get("web_uri");
                                if (object2 == null) return null;
                                boolean bl5 = ((String)(object2 = ((String)object2).trim())).startsWith((String)(object3 = "http://"));
                                if (!bl5 && !(bl5 = ((String)object2).startsWith((String)(charSequence2 = "https://")))) {
                                    charSequence2 = new StringBuilder();
                                    ((StringBuilder)charSequence2).append((String)object3);
                                    ((StringBuilder)charSequence2).append((String)object2);
                                    object2 = ((StringBuilder)charSequence2).toString();
                                }
                                object3 = new URL((String)object2);
                                object3 = ((URL)object3).getProtocol();
                                charSequence2 = "http";
                                bl5 = ((String)charSequence2).equals(object3);
                                if (bl5) break block35;
                                charSequence2 = "https";
                                n10 = (int)(((String)charSequence2).equals(object3) ? 1 : 0);
                                if (n10 == 0) return null;
                            }
                            charSequence2 = "android.intent.action.VIEW";
                            object3 = new Intent((String)charSequence2);
                            try {
                                object2 = Uri.parse((String)object2);
                            }
                            catch (MalformedURLException malformedURLException) {
                                break block36;
                            }
                            object3.setData((Uri)object2);
                            break block33;
                            catch (MalformedURLException malformedURLException) {
                                n10 = 0;
                                object3 = null;
                            }
                        }
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        object2 = ((Throwable)object2).getMessage();
                    }
                    ((StringBuilder)charSequence2).append((String)object2);
                    object2 = ((StringBuilder)charSequence2).toString();
                    com.xiaomi.channel.commonutils.logger.b.d((String)object2);
                }
                object2 = object3;
            }
            if (object2 == null) return null;
            if (n11 >= 0) {
                object2.setFlags(n11);
            }
            n10 = 0x10000000;
            object2.addFlags(n10);
            object = object.getPackageManager();
            n10 = 65536;
            object = object.resolveActivity((Intent)object2, n10);
            if (object == null) break block37;
            return object2;
        }
        object = new StringBuilder();
        object3 = "not resolve activity:";
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        try {
            com.xiaomi.channel.commonutils.logger.b.a((String)object);
            return null;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)charSequence);
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            com.xiaomi.channel.commonutils.logger.b.d(string4);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PushMessageHandler$a a(ii var1_1, boolean var2_2, byte[] var3_3, String var4_4, int var5_5) {
        var6_6 = this;
        var7_7 = var1_1;
        var8_8 = var2_2;
        var9_9 = var3_3;
        var10_10 /* !! */  = var4_4;
        var11_11 = var5_5;
        var12_12 = ag.class;
        var13_13 = null;
        try {
            var14_14 = this.a;
            var14_14 = aj.a((Context)var14_14, var1_1);
            if (var14_14 == null) {
                var15_15 = new StringBuilder();
                var9_9 = "receiving an un-recognized message. ";
                var15_15.append((String)var9_9);
                var9_9 = (Object)var1_1.a;
                var15_15.append(var9_9);
                var15_15 = var15_15.toString();
                com.xiaomi.channel.commonutils.logger.b.d((String)var15_15);
                var15_15 = this.a;
                var15_15 = fb.a((Context)var15_15);
                var9_9 = this.a;
                var9_9 = var9_9.getPackageName();
                var12_12 = fa.a(var5_5);
                var14_14 = "18";
                var15_15.b((String)var9_9, (String)var12_12, var4_4, (String)var14_14);
                return null;
            }
            var16_29 /* !! */  = var1_1.a();
            var17_30 = new StringBuilder();
            var18_31 = "processing a message, action=";
            var17_30.append((String)var18_31);
        }
        catch (jc v0) {
            com.xiaomi.channel.commonutils.logger.b.a(v0);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            var15_27 = fb.a(var6_6.a);
            var7_7 = var6_6.a.getPackageName();
            var9_9 = fa.a(var5_5);
            var15_27.b((String)var7_7, (String)var9_9, var10_10 /* !! */ , "20");
            return null;
        }
        catch (t v1) {
            com.xiaomi.channel.commonutils.logger.b.a(v1);
            this.a(var1_1);
            var15_28 = fb.a(var6_6.a);
            var7_7 = var6_6.a.getPackageName();
            var9_9 = fa.a(var5_5);
            var15_28.b((String)var7_7, (String)var9_9, var10_10 /* !! */ , "19");
            return null;
        }
        var17_30.append((Object)var16_29 /* !! */ );
        com.xiaomi.channel.commonutils.logger.b.a(var17_30.toString());
        var17_30 = ap.a;
        var19_32 /* !! */  = var16_29 /* !! */ .ordinal();
        var19_32 /* !! */  = (int)var17_30[var19_32 /* !! */ ];
        var20_33 = true;
        var21_34 = 0L;
        var23_35 = null;
        switch (var19_32 /* !! */ ) {
            default: {
                return var13_13;
            }
            case 7: {
                var15_16 = this.a.getPackageName();
                var16_29 /* !! */  = this.a;
                var10_10 /* !! */  = hm.i;
                var24_36 = var3_3.length;
                df.a((String)var15_16, (Context)var16_29 /* !! */ , (ix)var14_14, (hm)var10_10 /* !! */ , var24_36);
                var8_8 = var14_14 instanceof id;
                if (var8_8 == 0) ** GOTO lbl186
                var14_14 = (id)var14_14;
                var15_16 = var14_14.a();
                var7_7 = hw.D.a;
                var9_9 = var14_14.d;
                var25_40 /* !! */  = var7_7.equalsIgnoreCase((String)var9_9);
                var24_36 = 10;
                if (var25_40 /* !! */  == 0) ** GOTO lbl119
                var26_47 = var14_14.a;
                cfr_temp_0 = var26_47 - var21_34;
                var25_40 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var25_40 /* !! */  == 0) {
                    synchronized (var12_12) {
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var25_40 /* !! */  = var7_7.a((String)var15_16);
                        if (var25_40 /* !! */  == 0) return var13_13;
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var7_7.c((String)var15_16);
                        var15_16 = "syncing";
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var9_9 = av.a;
                        var7_7 = var7_7.a((av)var9_9);
                        var8_8 = var15_16.equals(var7_7);
                        if (var8_8 == 0) return var13_13;
                        var15_16 = this.a;
                        var15_16 = ag.a((Context)var15_16);
                        var7_7 = "synced";
                        var15_16.a((av)var9_9, (String)var7_7);
                        var15_16 = this.a;
                        MiPushClient.clearNotification((Context)var15_16);
                        var15_16 = this.a;
                        MiPushClient.clearLocalNotificationType((Context)var15_16);
                        PushMessageHandler.a();
                        var15_16 = this.a;
                        var15_16 = aq.a((Context)var15_16);
                        var15_16.b();
                        return var13_13;
                    }
                }
                var7_7 = "syncing";
                var14_14 = ag.a(this.a);
                var16_29 /* !! */  = av.a;
                var25_40 /* !! */  = var7_7.equals(var14_14 = var14_14.a((av)var16_29 /* !! */ ));
                if (var25_40 /* !! */  != 0) {
                    synchronized (var12_12) {
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var25_40 /* !! */  = var7_7.a((String)var15_16);
                        if (var25_40 /* !! */  == 0) return var13_13;
                        var7_7 = this.a;
                        var25_40 /* !! */  = (var7_7 = ag.a((Context)var7_7)).a((String)var15_16);
                        if (var25_40 /* !! */  < var24_36) {
                            var7_7 = this.a;
                            var7_7 = ag.a((Context)var7_7);
                            var7_7.b((String)var15_16);
                            var7_7 = this.a;
                            var7_7 = aq.a((Context)var7_7);
                            var7_7.a(var20_33, (String)var15_16);
                        } else {
                            var7_7 = this.a;
                            var7_7 = ag.a((Context)var7_7);
                            var7_7.c((String)var15_16);
                        }
                        return var13_13;
                    }
                }
                ** GOTO lbl152
lbl119:
                // 1 sources

                var7_7 = hw.E.a;
                var16_29 /* !! */  = var14_14.d;
                var25_40 /* !! */  = var7_7.equalsIgnoreCase((String)var16_29 /* !! */ );
                if (var25_40 /* !! */  == 0) ** GOTO lbl174
                var26_48 = var14_14.a;
                cfr_temp_1 = var26_48 - var21_34;
                var25_40 /* !! */  = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var25_40 /* !! */  == 0) {
                    synchronized (var12_12) {
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var25_40 /* !! */  = var7_7.a((String)var15_16);
                        if (var25_40 /* !! */  == 0) return var13_13;
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var7_7.c((String)var15_16);
                        var15_16 = "syncing";
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var9_9 = (Object)av.b;
                        var7_7 = var7_7.a((av)var9_9);
                        var8_8 = var15_16.equals(var7_7);
                        if (var8_8 == 0) return var13_13;
                        var15_16 = this.a;
                        var15_16 = ag.a((Context)var15_16);
                        var7_7 = "synced";
                        var15_16.a((av)var9_9, (String)var7_7);
                        return var13_13;
                    }
                }
                var7_7 = "syncing";
                var14_14 = ag.a(this.a);
                var16_29 /* !! */  = av.b;
                var25_40 /* !! */  = var7_7.equals(var14_14 = var14_14.a((av)var16_29 /* !! */ ));
                if (var25_40 /* !! */  != 0) ** GOTO lbl155
lbl152:
                // 2 sources

                var7_7 = ag.a(var6_6.a);
                var7_7.c((String)var15_16);
                return var13_13;
lbl155:
                // 1 sources

                synchronized (var12_12) {
                    var7_7 = this.a;
                    var7_7 = ag.a((Context)var7_7);
                    var25_40 /* !! */  = (int)var7_7.a((String)var15_16);
                    if (var25_40 /* !! */  == 0) return var13_13;
                    var7_7 = this.a;
                    var25_40 /* !! */  = (var7_7 = ag.a((Context)var7_7)).a((String)var15_16);
                    if (var25_40 /* !! */  < var24_36) {
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var7_7.b((String)var15_16);
                        var7_7 = this.a;
                        var7_7 = aq.a((Context)var7_7);
                        var7_7.a(false, (String)var15_16);
                    } else {
                        var7_7 = this.a;
                        var7_7 = ag.a((Context)var7_7);
                        var7_7.c((String)var15_16);
                    }
                    return var13_13;
                }
lbl174:
                // 1 sources

                var15_16 = hw.M.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 != 0) {
                    this.b((id)var14_14);
                    return var13_13;
                }
                var15_16 = hw.B.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 == 0) return var13_13;
                this.a((id)var14_14);
                return var13_13;
lbl186:
                // 1 sources

                var8_8 = var14_14 instanceof il;
                if (var8_8 == 0) return var13_13;
                var14_14 = (il)var14_14;
                var15_16 = "registration id expired";
                var9_9 = var14_14.d;
                var8_8 = (int)var15_16.equalsIgnoreCase((String)var9_9);
                if (var8_8 != 0) {
                    var15_16 = MiPushClient.getAllAlias(this.a);
                    var7_7 = MiPushClient.getAllTopic(this.a);
                    var9_9 = MiPushClient.getAllUserAccount(this.a);
                    var12_12 = MiPushClient.getAcceptTime(this.a);
                    var14_14 = this.a;
                    var16_29 /* !! */  = ia.a;
                    MiPushClient.reInitialize((Context)var14_14, (ia)var16_29 /* !! */ );
                    var15_16 = var15_16.iterator();
                    while (var28_50 = var15_16.hasNext()) {
                        var14_14 = (String)var15_16.next();
                        MiPushClient.removeAlias(var6_6.a, (String)var14_14);
                        var16_29 /* !! */  = var6_6.a;
                        MiPushClient.setAlias((Context)var16_29 /* !! */ , (String)var14_14, null);
                    }
                    var15_16 = var7_7.iterator();
                    while ((var25_41 = var15_16.hasNext()) != 0) {
                        var7_7 = (String)var15_16.next();
                        MiPushClient.removeTopic(var6_6.a, (String)var7_7);
                        var14_14 = var6_6.a;
                        MiPushClient.subscribe((Context)var14_14, (String)var7_7, null);
                    }
                    var15_16 = var9_9.iterator();
                    while (true) {
                        if ((var25_41 = var15_16.hasNext()) == 0) {
                            var15_16 = var12_12.split(",");
                            var25_41 = ((String[])var15_16).length;
                            if (var25_41 != (var24_36 = 2)) return var13_13;
                            MiPushClient.removeAcceptTime(var6_6.a);
                            var7_7 = var6_6.a;
                            var9_9 = var15_16[0];
                            var15_16 = var15_16[var20_33];
                            MiPushClient.addAcceptTime((Context)var7_7, (String)var9_9, (String)var15_16);
                            return var13_13;
                        }
                        var7_7 = (String)var15_16.next();
                        MiPushClient.removeAccount(var6_6.a, (String)var7_7);
                        var9_9 = var6_6.a;
                        MiPushClient.setUserAccount((Context)var9_9, (String)var7_7, null);
                    }
                }
                var15_16 = "client_info_update_ok";
                var9_9 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var9_9);
                if (var8_8 != 0) {
                    var15_16 = var14_14.a();
                    if (var15_16 == null) return var13_13;
                    var15_16 = var14_14.a();
                    var8_8 = var15_16.containsKey(var7_7 = "app_version");
                    if (var8_8 == 0) return var13_13;
                    var15_16 = (String)var14_14.a().get("app_version");
                    var7_7 = b.a(this.a);
                    var7_7.a((String)var15_16);
                    return var13_13;
                }
                var15_16 = hw.m.a;
                var9_9 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var9_9);
                if (var8_8 != 0) {
                    var8_8 = var1_1.b();
                    if (var8_8 == 0) return var13_13;
                    var15_16 = var14_14.a();
                    if (var15_16 == null) return var13_13;
                    var15_16 = var14_14.a();
                    var8_8 = var15_16.containsKey(var7_7 = "awake_info");
                    if (var8_8 == 0) return var13_13;
                    var15_16 = (String)var14_14.a().get("awake_info");
                    var7_7 = this.a;
                    var9_9 = b.a((Context)var7_7).a();
                    var12_12 = ak.a(this.a);
                    var14_14 = hr.aF;
                    var28_51 = var14_14.a();
                    var29_52 = var12_12.a(var28_51, 0);
                    n.a((Context)var7_7, (String)var9_9, var29_52, (String)var15_16);
                    return var13_13;
                }
                var15_16 = hw.n.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 != 0) {
                    var15_16 = new ik();
                    var7_7 = var14_14.a();
                    iw.a(var15_16, (byte[])var7_7);
                    var7_7 = this.a;
                    var7_7 = ak.a((Context)var7_7);
                    al.a((ak)var7_7, (ik)var15_16);
                    return var13_13;
                }
                var15_16 = hw.o.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 != 0) {
                    var15_16 = new ij();
                    var7_7 = var14_14.a();
                    iw.a((ix)var15_16, (byte[])var7_7);
                    var7_7 = this.a;
                    var7_7 = ak.a((Context)var7_7);
                    al.a((ak)var7_7, (ij)var15_16);
                    return var13_13;
                }
                var15_16 = hw.w.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 != 0) {
                    var15_16 = this.a;
                    aw.a((Context)var15_16, (il)var14_14);
                    return var13_13;
                }
                var15_16 = hw.x.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equalsIgnoreCase((String)var7_7);
                if (var8_8 != 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("receive force sync notification");
                    var15_16 = this.a;
                    aw.a((Context)var15_16, false);
                    return var13_13;
                }
                var15_16 = hw.C.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equals(var7_7);
                if (var8_8 != 0) {
                    var15_16 = var14_14.a();
                    if (var15_16 == null) return var13_13;
                    var15_16 = var14_14.a();
                    var7_7 = at.J;
                    var8_8 = var15_16.containsKey(var7_7);
                    var25_42 = -2;
                    if (var8_8 != 0) {
                        var15_16 = var14_14.a();
                        var9_9 = at.J;
                        var24_36 = (int)TextUtils.isEmpty((CharSequence)(var15_16 = (String)var15_16.get(var9_9)));
                        if (var24_36 == 0) {
                            try {
                                var25_42 = Integer.parseInt((String)var15_16);
                            }
                            catch (NumberFormatException var15_17) {
                                var9_9 = var15_17;
                                var15_17.printStackTrace();
                            }
                        }
                    }
                    if (var25_42 >= (var8_8 = -1)) {
                        var15_16 = var6_6.a;
                        MiPushClient.clearNotification((Context)var15_16, var25_42);
                        return var13_13;
                    }
                    var15_16 = "";
                    var7_7 = "";
                    var9_9 = var14_14.a();
                    var24_36 = (int)var9_9.containsKey(var12_12 = at.H);
                    if (var24_36 != 0) {
                        var15_16 = var14_14.a();
                        var9_9 = at.H;
                        var15_16 = (String)var15_16.get(var9_9);
                    }
                    if ((var24_36 = (int)(var9_9 = (Object)var14_14.a()).containsKey(var12_12 = at.I)) != 0) {
                        var7_7 = var14_14.a();
                        var9_9 = at.I;
                        var7_7 = (String)var7_7.get(var9_9);
                    }
                    var9_9 = var6_6.a;
                    MiPushClient.clearNotification((Context)var9_9, (String)var15_16, (String)var7_7);
                    return var13_13;
                }
                var15_16 = hw.J.a;
                var7_7 = var14_14.d;
                var8_8 = var15_16.equals(var7_7);
                if (var8_8 != 0) {
                    var15_16 = new in();
                    var7_7 = var14_14.a();
                    iw.a((ix)var15_16, (byte[])var7_7);
                    var7_7 = this.a;
                    MiPushClient4Hybrid.onReceiveRegisterResult((Context)var7_7, (in)var15_16);
                    return var13_13;
                }
                var15_16 = hw.L.a;
                var7_7 = var14_14.d;
                var8_8 = (int)var15_16.equals(var7_7);
                if (var8_8 == 0) ** GOTO lbl368
                try {
                    var15_16 = new it();
                    var7_7 = var14_14.a();
                    iw.a((ix)var15_16, (byte[])var7_7);
                    var7_7 = this.a;
                    MiPushClient4Hybrid.onReceiveUnregisterResult((Context)var7_7, (it)var15_16);
                    return var13_13;
                }
                catch (jc var15_18) {
                    com.xiaomi.channel.commonutils.logger.b.a(var15_18);
                    return var13_13;
                }
lbl368:
                // 1 sources

                var15_16 = hw.O.a;
                var7_7 = var14_14.d;
                var8_8 = (int)var15_16.equals(var7_7);
                if (var8_8 == 0) return var13_13;
                var15_16 = var14_14.a();
                if (var15_16 == null) return var13_13;
                var15_16 = var14_14.a();
                var8_8 = (int)var15_16.containsKey(var7_7 = "packages");
                if (var8_8 == 0) return var13_13;
                var15_16 = ((String)var14_14.a().get("packages")).split(",");
                var7_7 = this.a.getPackageName();
                var25_43 = TextUtils.equals((CharSequence)var7_7, (CharSequence)(var9_9 = "com.xiaomi.xmsf"));
                if (var25_43) {
                    Logger.uploadLogFile(this.a, var20_33);
                    var7_7 = this.a;
                    this.a((Context)var7_7, (String[])var15_16);
                    return var13_13;
                }
                var15_16 = this.a;
                Logger.uploadLogFile((Context)var15_16, false);
                return var13_13;
            }
            case 6: {
                var15_19 = this.a.getPackageName();
                var7_7 = this.a;
                var12_12 = hm.j;
                var24_37 = var3_3.length;
                df.a((String)var15_19, (Context)var7_7, (ix)var14_14, (hm)var12_12, var24_37);
                var14_14 = (ih)var14_14;
                var30_54 = var14_14.a();
                var15_19 = var14_14.a();
                var31_57 = var14_14.a;
                var25_44 = var31_57 == var21_34 ? 0 : (var31_57 < var21_34 ? -1 : 1);
                if (var25_44 == false) {
                    var7_7 = fg.i.a;
                    var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                    if (var25_44 != false && var15_19 != null && (var25_44 = (long)var15_19.size()) > var20_33) {
                        var7_7 = this.a;
                        var9_9 = (String)var15_19.get(0);
                        var12_12 = (String)var15_19.get((int)var20_33);
                        MiPushClient.addAcceptTime((Context)var7_7, (String)var9_9, (String)var12_12);
                        var7_7 = "00:00";
                        var9_9 = var15_19.get(0);
                        var25_44 = (long)var7_7.equals(var9_9);
                        if (var25_44 != false && (var25_44 = (long)(var7_7 = "00:00").equals(var9_9 = (Object)var15_19.get((int)var20_33))) != false) {
                            var7_7 = b.a(this.a);
                            var7_7.a(var20_33);
                        } else {
                            var7_7 = b.a(var6_6.a);
                            var7_7.a(false);
                        }
                        var7_7 = DesugarTimeZone.getTimeZone("GMT+08");
                        var9_9 = TimeZone.getDefault();
                        var15_19 = var6_6.a((TimeZone)var7_7, (TimeZone)var9_9, (List)var15_19);
                    } else {
                        var7_7 = fg.c.a;
                        var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                        if (var25_44 != false && var15_19 != null && (var25_44 = (long)var15_19.size()) > 0) {
                            var7_7 = var6_6.a;
                            var9_9 = (String)var15_19.get(0);
                            MiPushClient.addAlias((Context)var7_7, (String)var9_9);
                        } else {
                            var7_7 = fg.d.a;
                            var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                            if (var25_44 != false && var15_19 != null && (var25_44 = (long)var15_19.size()) > 0) {
                                var7_7 = var6_6.a;
                                var9_9 = (String)var15_19.get(0);
                                MiPushClient.removeAlias((Context)var7_7, (String)var9_9);
                            } else {
                                var7_7 = fg.e.a;
                                var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                                if (var25_44 != false && var15_19 != null && (var25_44 = (long)var15_19.size()) > 0) {
                                    var7_7 = var6_6.a;
                                    var9_9 = (String)var15_19.get(0);
                                    MiPushClient.addAccount((Context)var7_7, (String)var9_9);
                                } else {
                                    var7_7 = fg.f.a;
                                    var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                                    if (var25_44 != false && var15_19 != null && (var25_44 = (long)var15_19.size()) > 0) {
                                        var7_7 = var6_6.a;
                                        var9_9 = (String)var15_19.get(0);
                                        MiPushClient.removeAccount((Context)var7_7, (String)var9_9);
                                    } else {
                                        var7_7 = fg.j.a;
                                        var25_44 = (long)TextUtils.equals((CharSequence)var30_54, (CharSequence)var7_7);
                                        if (var25_44 != false) {
                                            if (var15_19 == null) return null;
                                            var25_44 = var15_19.size();
                                            if (var25_44 <= 0) return null;
                                            var7_7 = var6_6.a;
                                            var15_19 = (String)var15_19.get(0);
                                            i.a((Context)var7_7, (String)var15_19);
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                var33_62 = var15_19;
                var31_57 = var14_14.a;
                var15_19 = var14_14.d;
                var34_66 = var14_14.b();
                return PushMessageHelper.generateCommandMessage(var30_54, (List)var33_62, var31_57, (String)var15_19, var34_66);
            }
            case 5: {
                var14_14 = (iv)var14_14;
                var31_58 = var14_14.a;
                var8_8 = (int)(var31_58 == var21_34 ? 0 : (var31_58 < var21_34 ? -1 : 1));
                if (var8_8 == 0) {
                    var15_20 /* !! */  = this.a;
                    var7_7 = var14_14.a();
                    MiPushClient.removeTopic(var15_20 /* !! */ , (String)var7_7);
                }
                if ((var8_8 = (int)TextUtils.isEmpty((CharSequence)(var15_20 /* !! */  = var14_14.a()))) == 0) {
                    var13_13 = new ArrayList();
                    var15_20 /* !! */  = var14_14.a();
                    var13_13.add(var15_20 /* !! */ );
                }
                var18_31 = fg.h.a;
                var35_67 = var14_14.a;
                var33_63 = var14_14.d;
                var37_69 = var14_14.b();
                return PushMessageHelper.generateCommandMessage((String)var18_31, var13_13, var35_67, var33_63, var37_69);
            }
            case 4: {
                var14_14 = (ir)var14_14;
                var31_59 = var14_14.a;
                var8_8 = (int)(var31_59 == var21_34 ? 0 : (var31_59 < var21_34 ? -1 : 1));
                if (var8_8 == 0) {
                    var15_21 /* !! */  = this.a;
                    var7_7 = var14_14.a();
                    MiPushClient.addTopic(var15_21 /* !! */ , (String)var7_7);
                }
                if ((var8_8 = (int)TextUtils.isEmpty((CharSequence)(var15_21 /* !! */  = var14_14.a()))) == 0) {
                    var13_13 = new ArrayList();
                    var15_21 /* !! */  = var14_14.a();
                    var13_13.add(var15_21 /* !! */ );
                }
                var18_31 = fg.g.a;
                var35_68 = var14_14.a;
                var33_64 = var14_14.d;
                var37_70 = var14_14.b();
                return PushMessageHelper.generateCommandMessage((String)var18_31, var13_13, var35_68, var33_64, var37_70);
            }
            case 3: {
                var14_14 = (it)var14_14;
                var31_60 = var14_14.a;
                var8_8 = (int)(var31_60 == var21_34 ? 0 : (var31_60 < var21_34 ? -1 : 1));
                if (var8_8 == 0) {
                    b.a(this.a).a();
                    var15_22 = this.a;
                    MiPushClient.clearExtras(var15_22);
                }
                PushMessageHandler.a();
                return var13_13;
            }
            case 2: {
                var15_23 = var14_14;
                var15_23 = (in)var14_14;
                var7_7 = b.a((Context)this.a).a;
                var24_38 = TextUtils.isEmpty((CharSequence)var7_7);
                if (!var24_38 && (var25_45 /* !! */  = TextUtils.equals((CharSequence)var7_7, (CharSequence)(var9_9 = (Object)var15_23.a())))) {
                    var7_7 = b.a(this.a);
                    var7_7.a = null;
                    var31_61 = var15_23.a;
                    cfr_temp_2 = var31_61 - var21_34;
                    var25_45 /* !! */  = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
                    if (!var25_45 /* !! */ ) {
                        var7_7 = b.a(this.a);
                        var9_9 = var15_23.e;
                        var12_12 = var15_23.f;
                        var14_14 = var15_23.l;
                        var7_7.b((String)var9_9, (String)var12_12, (String)var14_14);
                        var7_7 = fb.a(this.a);
                        var9_9 = this.a.getPackageName();
                        var12_12 = fa.a(var5_5);
                        var19_32 /* !! */  = 6006;
                        var17_30 = "1";
                    } else {
                        var7_7 = fb.a(this.a);
                        var9_9 = this.a.getPackageName();
                        var12_12 = fa.a(var5_5);
                        var19_32 /* !! */  = 6006;
                        var17_30 = "2";
                    }
                    var14_14 = var4_4;
                    var7_7.a((String)var9_9, (String)var12_12, var4_4, var19_32 /* !! */ , (String)var17_30);
                    var7_7 = var15_23.e;
                    var25_45 /* !! */  = TextUtils.isEmpty((CharSequence)var7_7);
                    if (!var25_45 /* !! */ ) {
                        var13_13 = new ArrayList();
                        var7_7 = var15_23.e;
                        var13_13.add(var7_7);
                    }
                    var12_12 = var13_13;
                    var9_9 = fg.a.a;
                    var26_49 = var15_23.a;
                    var17_30 = var15_23.d;
                    var15_23 = PushMessageHelper.generateCommandMessage((String)var9_9, var13_13, var26_49, (String)var17_30, null);
                    aq.a(var6_6.a).d();
                    return var15_23;
                }
                com.xiaomi.channel.commonutils.logger.b.a("bad Registration result:");
                var15_23 = fb.a(var6_6.a);
                var7_7 = var6_6.a.getPackageName();
                var9_9 = fa.a(var5_5);
                var15_23.b((String)var7_7, (String)var9_9, var10_10 /* !! */ , "21");
                return null;
            }
            case 1: 
        }
        var29_53 = var1_1.b();
        if (!var29_53) {
            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
            return null;
        }
        var12_12 = b.a(this.a);
        var29_53 = var12_12.d();
        if (var29_53 && var2_2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("receive a message in pause state. drop it");
            var15_24 = fb.a(this.a);
            var7_7 = this.a.getPackageName();
            var9_9 = fa.a(var5_5);
            var15_24.a((String)var7_7, (String)var9_9, var4_4, "12");
            return null;
        }
        var12_12 = (var14_14 = (ip)var14_14).a();
        if (var12_12 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
            var15_25 = fb.a(var6_6.a);
            var7_7 = var6_6.a.getPackageName();
            var9_9 = fa.a(var5_5);
            var15_25.b((String)var7_7, (String)var9_9, var10_10 /* !! */ , "22");
            return null;
        }
        if (var8_8 != 0) {
            var19_32 /* !! */  = (int)aa.a(var1_1);
            if (var19_32 /* !! */  != 0) {
                var16_29 /* !! */  = var6_6.a;
                var17_30 = var12_12.a();
                var23_35 = var1_1.a();
                var30_55 = var7_7.b;
                var33_65 = var12_12.b();
                MiPushClient.reportIgnoreRegMessageClicked((Context)var16_29 /* !! */ , (String)var17_30, var23_35, var30_55, var33_65);
            } else {
                var16_29 /* !! */  = var6_6.a;
                var17_30 = var12_12.a();
                var23_35 = var1_1.a();
                var30_56 = var12_12.b();
                MiPushClient.reportMessageClicked((Context)var16_29 /* !! */ , (String)var17_30, var23_35, var30_56);
            }
        }
        if (var8_8 == 0) {
            var16_29 /* !! */  = var14_14.d();
            var19_32 /* !! */  = (int)TextUtils.isEmpty((CharSequence)var16_29 /* !! */ );
            if (var19_32 /* !! */  == 0 && (var19_32 /* !! */  = (int)((cfr_temp_3 = (var38_71 = MiPushClient.aliasSetTime((Context)(var16_29 /* !! */  = var6_6.a), (String)(var17_30 = var14_14.d()))) - var21_34) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) < 0) {
                var16_29 /* !! */  = var6_6.a;
                var17_30 = var14_14.d();
                MiPushClient.addAlias((Context)var16_29 /* !! */ , (String)var17_30);
            } else {
                var16_29 /* !! */  = var14_14.c();
                var19_32 /* !! */  = (int)TextUtils.isEmpty((CharSequence)var16_29 /* !! */ );
                if (var19_32 /* !! */  == 0 && (var19_32 /* !! */  = (int)((cfr_temp_4 = (var38_71 = MiPushClient.topicSubscribedTime((Context)(var16_29 /* !! */  = var6_6.a), (String)(var17_30 = var14_14.c()))) - var21_34) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) < 0) {
                    var16_29 /* !! */  = var6_6.a;
                    var17_30 = var14_14.c();
                    MiPushClient.addTopic((Context)var16_29 /* !! */ , (String)var17_30);
                }
            }
        }
        if ((var16_29 /* !! */  = var7_7.a) != null && (var16_29 /* !! */  = var16_29 /* !! */ .a()) != null) {
            var16_29 /* !! */  = var7_7.a.a;
            var17_30 = "jobkey";
            var16_29 /* !! */  = (String)var16_29 /* !! */ .get(var17_30);
        } else {
            var19_32 /* !! */  = 0;
            var16_29 /* !! */  = null;
        }
        var20_33 = TextUtils.isEmpty((CharSequence)var16_29 /* !! */ );
        if (var20_33) {
            var16_29 /* !! */  = var12_12.a();
        }
        if (var8_8 == 0 && (var20_33 = an.a((Context)(var17_30 = var6_6.a), (String)var16_29 /* !! */ ))) {
            var9_9 = new StringBuilder;
            var9_9();
            var9_9.append("drop a duplicate message, key=");
            var9_9.append((String)var16_29 /* !! */ );
            com.xiaomi.channel.commonutils.logger.b.a(var9_9.toString());
            var9_9 = fb.a(var6_6.a);
            var12_12 = var6_6.a.getPackageName();
            var17_30 = fa.a(var5_5);
            var40_72 = new StringBuilder();
            var18_31 = "2:";
            var40_72.append((String)var18_31);
            var40_72.append((String)var16_29 /* !! */ );
            var16_29 /* !! */  = var40_72.toString();
            var9_9.c((String)var12_12, (String)var17_30, var10_10 /* !! */ , (String)var16_29 /* !! */ );
        } else {
            var17_30 = var1_1.a();
            var41_73 = (var17_30 = PushMessageHelper.generateMessage((ip)var14_14, (hz)var17_30, (boolean)var8_8)).getPassThrough();
            if (var41_73 == 0 && var8_8 == 0 && (var41_73 = (int)aa.a((Map)(var18_31 = var17_30.getExtra()))) != 0) {
                aa.a(var6_6.a, (ii)var7_7, (byte[])var9_9);
                return null;
            }
            var9_9 = new StringBuilder;
            var9_9();
            var9_9.append("receive a message, msgid=");
            var18_31 = var12_12.a();
            var9_9.append((String)var18_31);
            var18_31 = ", jobkey=";
            var9_9.append((String)var18_31);
            var9_9.append((String)var16_29 /* !! */ );
            var9_9 = var9_9.toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)var9_9);
            if (var8_8 != 0 && (var9_9 = (Object)var17_30.getExtra()) != null && (var24_39 = (var9_9 = (Object)var17_30.getExtra()).containsKey((Object)(var16_29 /* !! */  = "notify_effect")))) {
                var15_26 = var17_30.getExtra();
                var9_9 = var15_26.get("notify_effect");
                var18_31 = var9_9;
                var18_31 = (String)var9_9;
                var24_39 = aa.a(var1_1);
                if (var24_39) {
                    var9_9 = var6_6.a;
                    var7_7 = var7_7.b;
                    var15_26 = an.a((Context)var9_9, (String)var7_7, (Map)var15_26);
                    var15_26.putExtra("eventMessageType", var11_11);
                    var7_7 = "messageId";
                    var15_26.putExtra((String)var7_7, var10_10 /* !! */ );
                    if (var15_26 == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("Getting Intent fail from ignore reg message. ");
                        var15_26 = fb.a(var6_6.a);
                        var7_7 = var6_6.a.getPackageName();
                        var9_9 = fa.a(var5_5);
                        var15_26.b((String)var7_7, (String)var9_9, var10_10 /* !! */ , "23");
                        return null;
                    }
                    var7_7 = var12_12.c();
                    var24_39 = TextUtils.isEmpty((CharSequence)var7_7);
                    if (!var24_39) {
                        var9_9 = "payload";
                        var15_26.putExtra((String)var9_9, (String)var7_7);
                    }
                    var6_6.a.startActivity((Intent)var15_26);
                    var7_7 = fb.a(var6_6.a);
                    var15_26 = var6_6.a;
                    var9_9 = var15_26.getPackageName();
                    var12_12 = fa.a(var5_5);
                    var19_32 /* !! */  = 3006;
                    var14_14 = var4_4;
                    var17_30 = var18_31;
                    var7_7.a((String)var9_9, (String)var12_12, var4_4, var19_32 /* !! */ , (String)var18_31);
                    return null;
                }
                var7_7 = var6_6.a;
                var9_9 = var7_7.getPackageName();
                var15_26 = an.a((Context)var7_7, (String)var9_9, (Map)var15_26);
                if (var15_26 == null) return null;
                var7_7 = at.c;
                var25_46 = var18_31.equals(var7_7);
                if (!var25_46) {
                    var15_26.putExtra("key_message", (Serializable)var17_30);
                    var15_26.putExtra("eventMessageType", var11_11);
                    var7_7 = "messageId";
                    var15_26.putExtra((String)var7_7, var10_10 /* !! */ );
                }
                var6_6.a.startActivity((Intent)var15_26);
                com.xiaomi.channel.commonutils.logger.b.a("start activity succ");
                var7_7 = fb.a(var6_6.a);
                var9_9 = var6_6.a.getPackageName();
                var12_12 = fa.a(var5_5);
                var19_32 /* !! */  = 1006;
                var14_14 = var4_4;
                var17_30 = var18_31;
                var7_7.a((String)var9_9, (String)var12_12, var4_4, var19_32 /* !! */ , (String)var18_31);
                var15_26 = at.c;
                var8_8 = (int)var18_31.equals(var15_26);
                if (var8_8 == 0) return null;
                var15_26 = fb.a(var6_6.a);
                var7_7 = var6_6.a.getPackageName();
                var9_9 = fa.a(var5_5);
                var12_12 = "13";
                var15_26.a((String)var7_7, (String)var9_9, var10_10 /* !! */ , (String)var12_12);
                return null;
            }
            var13_13 = var17_30;
        }
        var9_9 = var1_1.a();
        if (var9_9 != null) return var13_13;
        if (var8_8 != 0) return var13_13;
        var6_6.a((ip)var14_14, (ii)var7_7);
        return var13_13;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PushMessageHandler$a a(ii object, byte[] object2) {
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        object2 = null;
        try {
            object6 = this.a;
            object6 = aj.a((Context)object6, (ii)object);
            if (object6 == null) {
                object6 = new StringBuilder();
                String string2 = "message arrived: receiving an un-recognized message. ";
                ((StringBuilder)object6).append(string2);
                object = ((ii)object).a;
                ((StringBuilder)object6).append(object);
                object = ((StringBuilder)object6).toString();
                com.xiaomi.channel.commonutils.logger.b.d((String)object);
                return null;
            }
            object5 = ((ii)object).a();
            object4 = new StringBuilder();
            object3 = "message arrived: processing an arrived message, action=";
            ((StringBuilder)object4).append((String)object3);
        }
        catch (jc jc2) {
            com.xiaomi.channel.commonutils.logger.b.a(jc2);
            object = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        catch (t t10) {
            com.xiaomi.channel.commonutils.logger.b.a(t10);
            object = "message arrived: receive a message but decrypt failed. report when click.";
        }
        ((StringBuilder)object4).append(object5);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object4).toString());
        object4 = ap.a;
        int n10 = ((Enum)object5).ordinal();
        Object object7 = object4[n10];
        boolean bl2 = true;
        if (object7 != bl2) {
            return null;
        }
        boolean bl3 = ((ii)object).b();
        if (!bl3) {
            object = "message arrived: receiving an un-encrypt message(SendMessage).";
        } else {
            object5 = ((ip)(object6 = (ip)object6)).a();
            if (object5 == null) {
                object = "message arrived: receive an empty message without push content, drop it";
            } else {
                object3 = ((ii)object).a;
                if (object3 != null && (object3 = ((hz)object3).a()) != null) {
                    object2 = object.a.a;
                    object3 = "jobkey";
                    object2 = (String)object2.get(object3);
                }
                object = ((ii)object).a();
                object = PushMessageHelper.generateMessage((ip)object6, (hz)object, false);
                ((MiPushMessage)object).setArrivedMessage(bl2);
                object6 = new StringBuilder();
                ((StringBuilder)object6).append("message arrived: receive a message, msgid=");
                object5 = ((hy)object5).a();
                ((StringBuilder)object6).append((String)object5);
                ((StringBuilder)object6).append(", jobkey=");
                ((StringBuilder)object6).append((String)object2);
                com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object6).toString());
                return object;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.d((String)object);
        return null;
    }

    public static an a(Context context) {
        an an2 = a;
        if (an2 == null) {
            a = an2 = new an(context);
        }
        return a;
    }

    private void a() {
        long l10;
        Context context = this.a;
        String string2 = "mipush_extra";
        context = context.getSharedPreferences(string2, 0);
        long l11 = System.currentTimeMillis();
        String string3 = "last_reinitialize";
        long l12 = context.getLong(string3, 0L);
        long l13 = (l12 = Math.abs(l11 - l12)) - (l10 = 1800000L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            Context context2 = this.a;
            ia ia2 = ia.b;
            MiPushClient.reInitialize(context2, ia2);
            context = context.edit().putLong(string3, l11);
            context.commit();
        }
    }

    private void a(Context context, PackageInfo intent) {
        intent = intent.services;
        if (intent != null) {
            int n10 = ((ServiceInfo[])intent).length;
            String string2 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string3;
                String string4;
                String string5;
                ServiceInfo serviceInfo = intent[i10];
                boolean bl2 = serviceInfo.exported;
                if (!bl2 || !(bl2 = serviceInfo.enabled) || !(bl2 = (string5 = "com.xiaomi.mipush.sdk.PushMessageHandler").equals(string4 = serviceInfo.name)) || (bl2 = (string4 = context.getPackageName()).equals(string5 = serviceInfo.packageName))) continue;
                try {
                    intent = new Intent();
                    string3 = serviceInfo.packageName;
                }
                catch (Throwable throwable) {}
                string2 = serviceInfo.name;
                intent.setClassName(string3, string2);
                string3 = "com.xiaomi.mipush.sdk.SYNC_LOG";
                intent.setAction(string3);
                PushMessageHandler.a(context, intent);
                break;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, String object) {
        Object object2 = a;
        synchronized (object2) {
            Object object3 = a;
            object3.remove(object);
            b.a(context);
            context = b.a(context);
            object = a;
            object3 = ",";
            object = bf.a((Collection)object, (String)object3);
            context = context.edit();
            object3 = "pref_msg_ids";
            context.putString((String)object3, (String)object);
            r.a((SharedPreferences.Editor)context);
            return;
        }
    }

    private void a(Context context, String[] stringArray) {
        ai ai2 = ai.a(context);
        ao ao2 = new ao(this, stringArray, context);
        ai2.a(ao2);
    }

    public static /* synthetic */ void a(an an2, Context context, PackageInfo packageInfo) {
        an2.a(context, packageInfo);
    }

    private void a(id comparable) {
        boolean bl2;
        String string2 = comparable.a();
        Object object = new StringBuilder();
        Object object2 = "receive ack ";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(string2);
        com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object).toString());
        object = comparable.a();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(object2 = "real_source"))))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("receive ack : messageId = ");
            ((StringBuilder)object2).append(string2);
            String string3 = "  realSource = ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append((String)object);
            com.xiaomi.channel.commonutils.logger.b.b(((StringBuilder)object2).toString());
            object2 = bp.a(this.a);
            long l10 = comparable.a;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) {
                l12 = 1;
            } else {
                l12 = 0;
                comparable = null;
            }
            comparable = Boolean.valueOf((boolean)l12);
            ((bp)object2).a(string2, (String)object, (Boolean)comparable);
        }
    }

    private void a(ii object) {
        com.xiaomi.channel.commonutils.logger.b.a("receive a message but decrypt failed. report now.");
        Object object2 = object.a().a;
        il il2 = new il((String)object2, false);
        object2 = hw.u.a;
        il2.c((String)object2);
        object2 = ((ii)object).a();
        il2.b((String)object2);
        object = ((ii)object).b;
        il2.d((String)object);
        object = new HashMap();
        il2.a = object;
        object2 = MiPushClient.getRegId(this.a);
        object.put("regid", object2);
        object = aq.a(this.a);
        object2 = hm.i;
        ((aq)object).a(il2, (hm)((Object)object2), false, null);
    }

    private void a(ip object, ii object2) {
        hz hz2 = object2.a();
        ic ic2 = new ic();
        String string2 = ((ip)object).b();
        ic2.b(string2);
        string2 = ((ip)object).a();
        ic2.a(string2);
        long l10 = ((ip)object).a().a();
        ic2.a(l10);
        string2 = ((ip)object).c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = ((ip)object).c();
            ic2.c(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((ip)object).d())))) {
            object = ((ip)object).d();
            ic2.d((String)object);
        }
        short s10 = iw.a(this.a, object2);
        ic2.a(s10);
        object = aq.a(this.a);
        object2 = hm.f;
        ((aq)object).a((ix)ic2, (hm)((Object)object2), hz2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String object, long l10, d d10) {
        Class<ag> clazz = ag.class;
        av av2 = k.a(d10);
        if (av2 == null) {
            return;
        }
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            synchronized (clazz) {
                Object object3 = this.a;
                object3 = ag.a((Context)object3);
                object2 = ((ag)object3).a((String)object);
                if (object2 == false) return;
                object3 = this.a;
                object3 = ag.a((Context)object3);
                ((ag)object3).c((String)object);
                object = "syncing";
                object3 = this.a;
                object3 = ag.a((Context)object3);
                object3 = ((ag)object3).a(av2);
                boolean bl2 = ((String)object).equals(object3);
                if (!bl2) return;
                object = this.a;
                object = ag.a((Context)object);
                object3 = "synced";
                ((ag)object).a(av2, (String)object3);
                return;
            }
        }
        Object object4 = "syncing";
        String string2 = ag.a(this.a).a(av2);
        object2 = ((String)object4).equals(string2);
        if (object2 == false) {
            object4 = ag.a(this.a);
            ((ag)object4).c((String)object);
            return;
        }
        synchronized (clazz) {
            int n10;
            object4 = this.a;
            object4 = ag.a((Context)object4);
            object2 = ((ag)object4).a((String)object);
            if (object2 == false) return;
            object4 = this.a;
            object2 = ((ag)(object4 = ag.a((Context)object4))).a((String)object);
            if (object2 < (n10 = 10)) {
                object4 = this.a;
                object4 = ag.a((Context)object4);
                ((ag)object4).b((String)object);
                object4 = this.a;
                object4 = aq.a((Context)object4);
                ((aq)object4).a((String)object, av2, d10);
            } else {
                object4 = this.a;
                object4 = ag.a((Context)object4);
                ((ag)object4).c((String)object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean a(Context context, String object) {
        Object object2 = a;
        synchronized (object2) {
            int n10;
            b.a(context);
            context = b.a(context);
            Object object3 = a;
            if (object3 == null) {
                object3 = "pref_msg_ids";
                LinkedList linkedList = "";
                object3 = context.getString((String)object3, (String)((Object)linkedList));
                linkedList = ",";
                object3 = object3.split((String)((Object)linkedList));
                a = linkedList = new LinkedList();
                int n11 = ((String[])object3).length;
                for (int i10 = 0; i10 < n11; ++i10) {
                    String string2 = object3[i10];
                    Queue queue = a;
                    queue.add(string2);
                }
            }
            if ((n10 = (object3 = a).contains(object)) != 0) {
                return true;
            }
            object3 = a;
            object3.add(object);
            object = a;
            int n12 = object.size();
            n10 = 25;
            if (n12 > n10) {
                object = a;
                object.poll();
            }
            object = a;
            object3 = ",";
            object = bf.a((Collection)object, (String)object3);
            context = context.edit();
            object3 = "pref_msg_ids";
            context.putString((String)object3, (String)object);
            r.a((SharedPreferences.Editor)context);
            return false;
        }
    }

    private boolean a(ii object) {
        boolean bl2;
        String string2;
        Object object2 = ((ii)object).b();
        boolean bl3 = TextUtils.equals((CharSequence)"com.miui.hybrid", (CharSequence)object2);
        if (!bl3 && !(bl3 = TextUtils.equals((CharSequence)(string2 = "com.miui.hybrid.loader"), (CharSequence)(object2 = ((ii)object).b())))) {
            return false;
        }
        object2 = ((ii)object).a();
        if (object2 == null) {
            bl2 = false;
            object = null;
        } else {
            object = ((ii)object).a().a();
        }
        if (object == null) {
            return false;
        }
        bl3 = TextUtils.equals((CharSequence)(object = (String)object.get("push_server_action")), (CharSequence)(object2 = "hybrid_message"));
        return bl3 || (bl2 = TextUtils.equals((CharSequence)object, (CharSequence)(object2 = "platform_message")));
        {
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void b(id id2) {
        void var6_9;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ASSEMBLE_PUSH : ");
        Object object = id2.toString();
        stringBuilder.append((String)object);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
        String string2 = id2.a();
        object = id2.a();
        if (object == null) return;
        CharSequence charSequence = "RegInfo";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(charSequence)));
        if (bl2) return;
        charSequence = new StringBuilder();
        String string3 = "brand:";
        ((StringBuilder)charSequence).append(string3);
        String string4 = ah.c.name();
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        bl2 = ((String)object).contains(charSequence);
        if (bl2) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive fcm token sync ack");
            charSequence = this.a;
            d d10 = d.b;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            string4 = ah.a.name();
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            bl2 = ((String)object).contains(charSequence);
            if (bl2) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive hw token sync ack");
                charSequence = this.a;
                d d11 = d.a;
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                string4 = ah.d.name();
                ((StringBuilder)charSequence).append(string4);
                charSequence = ((StringBuilder)charSequence).toString();
                bl2 = ((String)object).contains(charSequence);
                if (bl2) {
                    com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive COS token sync ack");
                    charSequence = this.a;
                    d d12 = d.c;
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string3);
                    String string5 = ah.e.name();
                    ((StringBuilder)charSequence).append(string5);
                    charSequence = ((StringBuilder)charSequence).toString();
                    bl2 = ((String)object).contains(charSequence);
                    if (!bl2) return;
                    com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                    charSequence = this.a;
                    d d13 = d.d;
                }
            }
        }
        h.b((Context)charSequence, (d)var6_9, (String)object);
        long l10 = id2.a;
        this.a(string2, l10, (d)var6_9);
    }

    private void b(ii cloneable) {
        Object object = cloneable.a();
        ic ic2 = new ic();
        Object object2 = cloneable.a();
        ic2.b((String)object2);
        object2 = ((hz)object).a();
        ic2.a((String)object2);
        long l10 = ((hz)object).a();
        ic2.a(l10);
        object2 = ((hz)object).b();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object = ((hz)object).b();
            ic2.c((String)object);
        }
        short s10 = iw.a(this.a, cloneable);
        ic2.a(s10);
        object = aq.a(this.a);
        object2 = hm.f;
        cloneable = cloneable.a();
        ((aq)object).a(ic2, (hm)((Object)object2), false, (hz)cloneable);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PushMessageHandler$a a(Intent var1_1) {
        block34: {
            block33: {
                block31: {
                    var2_2 = this;
                    var3_3 = var1_1;
                    var4_4 /* !! */  = var1_1.getAction();
                    var5_10 /* !! */  = new StringBuilder();
                    var5_10 /* !! */ .append("receive an intent from server, action=");
                    var5_10 /* !! */ .append((String)var4_4 /* !! */ );
                    com.xiaomi.channel.commonutils.logger.b.a(var5_10 /* !! */ .toString());
                    var5_10 /* !! */  = "mrt";
                    var6_11 /* !! */  = var1_1.getStringExtra((String)var5_10 /* !! */ );
                    if (var6_11 /* !! */  == null) {
                        var7_12 = System.currentTimeMillis();
                        var6_11 /* !! */  = Long.toString(var7_12);
                    }
                    var9_13 = var3_3.getStringExtra("messageId");
                    var10_14 = var3_3.getIntExtra("eventMessageType", -1);
                    var11_15 = "com.xiaomi.mipush.RECEIVE_MESSAGE";
                    var12_16 = var11_15.equals(var4_4 /* !! */ );
                    var13_17 = "mipush_payload";
                    if (!var12_16) break block33;
                    var13_17 = var3_3.getByteArrayExtra((String)var13_17);
                    var4_4 /* !! */  = "mipush_notified";
                    var12_16 = var3_3.getBooleanExtra((String)var4_4 /* !! */ , false);
                    if (var13_17 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                        var4_4 /* !! */  = fb.a(var2_2.a);
                        var5_10 /* !! */  = var2_2.a.getPackageName();
                        var4_4 /* !! */ .a((String)var5_10 /* !! */ , var3_3, "12");
                        return null;
                    }
                    var4_4 /* !! */  = new ii();
                    try {
                        iw.a((ix)var4_4 /* !! */ , (byte[])var13_17);
                        var14_18 = var2_2.a;
                        var14_18 = b.a((Context)var14_18);
                        var15_19 = var4_4 /* !! */ .a();
                        var16_20 = var4_4 /* !! */ .a();
                        var17_21 /* !! */  = hm.e;
                        if (var16_20 == var17_21 /* !! */  && var15_19 != null) {
                        }
                        ** GOTO lbl73
                    }
                    catch (Exception var4_5) {
                        var5_10 /* !! */  = fb.a(var2_2.a);
                        var6_11 /* !! */  = var2_2.a.getPackageName();
                        var11_15 = "17";
                        break block31;
                    }
                    catch (jc var4_6) {
                        var5_10 /* !! */  = fb.a(var2_2.a);
                        var6_11 /* !! */  = var2_2.a.getPackageName();
                        var11_15 = "16";
                        break block31;
                    }
                    {
                        var18_22 = var14_18.d();
                        if (var18_22 == 0 && !var12_16) {
                            var15_19.a((String)var5_10 /* !! */ , (String)var6_11 /* !! */ );
                            var5_10 /* !! */  = "mat";
                            var19_23 = System.currentTimeMillis();
                            var6_11 /* !! */  = Long.toString(var19_23);
                            var15_19.a((String)var5_10 /* !! */ , (String)var6_11 /* !! */ );
                            var21_24 = var2_2.a((ii)var4_4 /* !! */ );
                            if (!var21_24) {
                                var2_2.b((ii)var4_4 /* !! */ );
                            } else {
                                var5_10 /* !! */  = "this is a mina's message, ack later";
                                com.xiaomi.channel.commonutils.logger.b.b((String)var5_10 /* !! */ );
                                var5_10 /* !! */  = "__hybrid_message_ts";
                                var19_23 = var15_19.a();
                                var6_11 /* !! */  = String.valueOf(var19_23);
                                var15_19.a((String)var5_10 /* !! */ , (String)var6_11 /* !! */ );
                                var5_10 /* !! */  = "__hybrid_device_status";
                                var6_11 /* !! */  = var2_2.a;
                                var22_26 = iw.a((Context)var6_11 /* !! */ , (ii)var4_4 /* !! */ );
                                var6_11 /* !! */  = String.valueOf(var22_26);
                                var15_19.a((String)var5_10 /* !! */ , (String)var6_11 /* !! */ );
                            }
                        }
lbl73:
                        // 5 sources

                        var5_10 /* !! */  = var4_4 /* !! */ .a();
                        var6_11 /* !! */  = "";
                        var18_22 = 2;
                        var23_28 = 1;
                    }
                    {
                        if (var5_10 /* !! */  != var17_21 /* !! */  || (var21_24 = var4_4 /* !! */ .b())) ** GOTO lbl-1000
                        var21_24 = aa.a((ii)var4_4 /* !! */ );
                        if (var21_24) {
                            var5_10 /* !! */  = "drop an un-encrypted wake-up messages. %1$s, %2$s";
                            var11_15 = new Object[var18_22];
                            var13_17 = var4_4 /* !! */ .b();
                            var11_15[0] = var13_17;
                            if (var15_19 != null) {
                                var6_11 /* !! */  = var15_19.a();
                            }
                            var11_15[var23_28] = var6_11 /* !! */ ;
                            var5_10 /* !! */  = String.format((String)var5_10 /* !! */ , (Object[])var11_15);
                            com.xiaomi.channel.commonutils.logger.b.a((String)var5_10 /* !! */ );
                            var5_10 /* !! */  = var2_2.a;
                            var5_10 /* !! */  = fb.a((Context)var5_10 /* !! */ );
                            var6_11 /* !! */  = var2_2.a;
                            var6_11 /* !! */  = var6_11 /* !! */ .getPackageName();
                            var11_15 = "13: %1$s";
                            var13_17 = new Object[var23_28];
                            var13_17[0] = var4_4 /* !! */  = var4_4 /* !! */ .b();
                            var4_4 /* !! */  = String.format((String)var11_15, var13_17);
lbl97:
                            // 2 sources

                            while (true) {
                                var5_10 /* !! */ .a((String)var6_11 /* !! */ , var3_3, (String)var4_4 /* !! */ );
                                return null;
                            }
                        }
                        var5_10 /* !! */  = "drop an un-encrypted messages. %1$s, %2$s";
                        var11_15 = new Object[var18_22];
                        var13_17 = var4_4 /* !! */ .b();
                        var11_15[0] = var13_17;
                        if (var15_19 != null) {
                            var6_11 /* !! */  = var15_19.a();
                        }
                        var11_15[var23_28] = var6_11 /* !! */ ;
                        var5_10 /* !! */  = String.format((String)var5_10 /* !! */ , (Object[])var11_15);
                        com.xiaomi.channel.commonutils.logger.b.a((String)var5_10 /* !! */ );
                        var5_10 /* !! */  = var2_2.a;
                        var5_10 /* !! */  = fb.a((Context)var5_10 /* !! */ );
                        var6_11 /* !! */  = var2_2.a;
                        var6_11 /* !! */  = var6_11 /* !! */ .getPackageName();
                        var11_15 = "14: %1$s";
                        var13_17 = new Object[var23_28];
                        var13_17[0] = var4_4 /* !! */  = var4_4 /* !! */ .b();
                        var4_4 /* !! */  = String.format((String)var11_15, var13_17);
                        ** continue;
                    }
lbl-1000:
                    // 1 sources

                    {
                        var5_10 /* !! */  = var4_4 /* !! */ .a();
                        if (var5_10 /* !! */  == var17_21 /* !! */  && (var21_24 = var4_4 /* !! */ .b()) && (var21_24 = aa.a((ii)var4_4 /* !! */ )) && (!var12_16 || var15_19 == null || (var5_10 /* !! */  = var15_19.a()) == null || !(var21_24 = (var5_10 /* !! */  = var15_19.a()).containsKey((Object)(var17_21 /* !! */  = "notify_effect"))))) {
                            var5_10 /* !! */  = "drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s";
                            var11_15 = new Object[var18_22];
                            var13_17 = var4_4 /* !! */ .b();
                            var11_15[0] = var13_17;
                            if (var15_19 != null) {
                                var6_11 /* !! */  = var15_19.a();
                            }
                            var11_15[var23_28] = var6_11 /* !! */ ;
                            var5_10 /* !! */  = String.format((String)var5_10 /* !! */ , (Object[])var11_15);
                            com.xiaomi.channel.commonutils.logger.b.a((String)var5_10 /* !! */ );
                            var5_10 /* !! */  = var2_2.a;
                            var5_10 /* !! */  = fb.a((Context)var5_10 /* !! */ );
                            var6_11 /* !! */  = var2_2.a;
                            var6_11 /* !! */  = var6_11 /* !! */ .getPackageName();
                            var11_15 = "25: %1$s";
                            var13_17 = new Object[var23_28];
                            var13_17[0] = var4_4 /* !! */  = var4_4 /* !! */ .b();
                            var4_4 /* !! */  = String.format((String)var11_15, var13_17);
                            var5_10 /* !! */ .a((String)var6_11 /* !! */ , var3_3, (String)var4_4 /* !! */ );
                            return null;
                        }
                        var21_24 = var14_18.c();
                        if (var21_24 || (var5_10 /* !! */  = var4_4 /* !! */ .a) == (var6_11 /* !! */  = hm.a)) ** GOTO lbl156
                    }
                    {
                        var21_24 = aa.a((ii)var4_4 /* !! */ );
                        if (var21_24) {
                            var5_10 /* !! */  = this;
                            var6_11 /* !! */  = var4_4 /* !! */ ;
                            return this.a((ii)var4_4 /* !! */ , var12_16, (byte[])var13_17, var9_13, var10_14);
                        }
                        var4_4 /* !! */  = "receive message without registration. need re-register!";
                        com.xiaomi.channel.commonutils.logger.b.d((String)var4_4 /* !! */ );
                        var4_4 /* !! */  = var2_2.a;
                        var4_4 /* !! */  = fb.a((Context)var4_4 /* !! */ );
                        var5_10 /* !! */  = var2_2.a;
                        var5_10 /* !! */  = var5_10 /* !! */ .getPackageName();
                        var6_11 /* !! */  = "15";
                        var4_4 /* !! */ .a((String)var5_10 /* !! */ , var3_3, (String)var6_11 /* !! */ );
                        this.a();
                        return null;
lbl156:
                        // 1 sources

                        var21_24 = var14_18.c();
                        if (!var21_24 || !(var21_24 = var14_18.e())) ** GOTO lbl169
                        var4_4 /* !! */  = var4_4 /* !! */ .a;
                        var5_10 /* !! */  = hm.b;
                        if (var4_4 /* !! */  != var5_10 /* !! */ ) ** GOTO lbl166
                    }
                    {
                        var14_18.a();
                        var4_4 /* !! */  = var2_2.a;
                        MiPushClient.clearExtras((Context)var4_4 /* !! */ );
                        PushMessageHandler.a();
                        return null;
lbl166:
                        // 1 sources

                        var4_4 /* !! */  = var2_2.a;
                        MiPushClient.unregisterPush((Context)var4_4 /* !! */ );
                        return null;
lbl169:
                        // 1 sources

                        var5_10 /* !! */  = this;
                        var6_11 /* !! */  = var4_4 /* !! */ ;
                        return this.a((ii)var4_4 /* !! */ , var12_16, (byte[])var13_17, var9_13, var10_14);
                    }
                }
                var5_10 /* !! */ .a((String)var6_11 /* !! */ , var3_3, (String)var11_15);
                break block34;
            }
            var5_10 /* !! */  = "com.xiaomi.mipush.ERROR";
            var21_25 = var5_10 /* !! */ .equals(var4_4 /* !! */ );
            if (var21_25 != 0) {
                block32: {
                    var4_4 /* !! */  = new MiPushCommandMessage();
                    var5_10 /* !! */  = new ii();
                    try {
                        var6_11 /* !! */  = var3_3.getByteArrayExtra((String)var13_17);
                        if (var6_11 /* !! */  == null) break block32;
                        iw.a((ix)var5_10 /* !! */ , (byte[])var6_11 /* !! */ );
                    }
                    catch (jc v0) {
                        ** continue;
                    }
                }
lbl188:
                // 2 sources

                while (true) {
                    var5_10 /* !! */  = String.valueOf((Object)var5_10 /* !! */ .a());
                    var4_4 /* !! */ .setCommand((String)var5_10 /* !! */ );
                    var5_10 /* !! */  = "mipush_error_code";
                    var7_12 = var3_3.getIntExtra((String)var5_10 /* !! */ , 0);
                    var4_4 /* !! */ .setResultCode(var7_12);
                    var6_11 /* !! */  = "mipush_error_msg";
                    var11_15 = var3_3.getStringExtra((String)var6_11 /* !! */ );
                    var4_4 /* !! */ .setReason((String)var11_15);
                    var11_15 = new StringBuilder();
                    var11_15.append("receive a error message. code = ");
                    var21_25 = var3_3.getIntExtra((String)var5_10 /* !! */ , 0);
                    var11_15.append(var21_25);
                    var11_15.append(", msg= ");
                    var5_10 /* !! */  = var3_3.getStringExtra((String)var6_11 /* !! */ );
                    var11_15.append((String)var5_10 /* !! */ );
                    com.xiaomi.channel.commonutils.logger.b.d(var11_15.toString());
                    return var4_4 /* !! */ ;
                }
            }
            var5_10 /* !! */  = "com.xiaomi.mipush.MESSAGE_ARRIVED";
            var24_29 = var5_10 /* !! */ .equals(var4_4 /* !! */ );
            if (var24_29 == false) return null;
            var4_4 /* !! */  = var3_3.getByteArrayExtra((String)var13_17);
            if (var4_4 /* !! */  == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            var5_10 /* !! */  = new ii();
            try {
                block35: {
                    iw.a((ix)var5_10 /* !! */ , (byte[])var4_4 /* !! */ );
                    var6_11 /* !! */  = var2_2.a;
                    var6_11 /* !! */  = b.a((Context)var6_11 /* !! */ );
                    var12_16 = aa.a((ii)var5_10 /* !! */ );
                    if (var12_16) {
                        var4_4 /* !! */  = "message arrived: receive ignore reg message, ignore!";
lbl225:
                        // 3 sources

                        while (true) {
                            com.xiaomi.channel.commonutils.logger.b.d((String)var4_4 /* !! */ );
                            return null;
                        }
                    }
                    var12_16 = var6_11 /* !! */ .c();
                    if (var12_16) break block35;
                    var4_4 /* !! */  = "message arrived: receive message without registration. need unregister or re-register!";
                    ** GOTO lbl225
                }
                var12_16 = var6_11 /* !! */ .c();
                if (var12_16 == false) return var2_2.a((ii)var5_10 /* !! */ , (byte[])var4_4 /* !! */ );
                var22_27 = var6_11 /* !! */ .e();
                if (var22_27 == false) return var2_2.a((ii)var5_10 /* !! */ , (byte[])var4_4 /* !! */ );
                var4_4 /* !! */  = "message arrived: app info is invalidated";
                ** continue;
            }
            catch (Exception var4_8) {
            }
            catch (jc var4_9) {
                // empty catch block
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a((Throwable)var4_7);
        return null;
    }

    public List a(TimeZone timeZone, TimeZone timeZone2, List arrayList) {
        Object object;
        ArrayList<Object[]> arrayList2 = arrayList;
        int n10 = timeZone.equals(timeZone2);
        if (n10 != 0) {
            return arrayList;
        }
        long l10 = 1440L;
        int n11 = timeZone.getRawOffset();
        int n12 = timeZone2.getRawOffset();
        long l11 = (n11 - n12) / 1000 / 60;
        String[] stringArray = (String[])arrayList.get(0);
        String string2 = ":";
        long l12 = Long.parseLong(stringArray.split(string2)[0]);
        stringArray = ((String)arrayList.get(0)).split(string2);
        int n13 = 1;
        long l13 = Long.parseLong(stringArray[n13]);
        long l14 = Long.parseLong(((String)arrayList.get(n13)).split(string2)[0]);
        long l15 = Long.parseLong(((String)arrayList.get(n13)).split(string2)[n13]);
        long l16 = 60;
        l12 = (l12 * l16 + l13 - l11 + l10) % l10;
        l14 = (l14 * l16 + l15 - l11 + l10) % l10;
        arrayList2 = new ArrayList<Object[]>();
        n10 = 2;
        Object object2 = new Object[n10];
        object2[0] = object = Long.valueOf(l12 / l16);
        object2[n13] = object = Long.valueOf(l12 % l16);
        object = "%1$02d:%2$02d";
        object2 = String.format((String)object, object2);
        arrayList2.add((Object[])object2);
        Object object3 = new Object[n10];
        object3[0] = object2 = Long.valueOf(l14 / l16);
        object3[n13] = object2 = Long.valueOf(l14 % l16);
        object3 = String.format((String)object, object3);
        arrayList2.add((Object[])object3);
        return arrayList2;
    }
}

