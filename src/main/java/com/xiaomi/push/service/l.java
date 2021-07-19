/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.au;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.ft;
import com.xiaomi.push.i;
import com.xiaomi.push.o;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.l$a;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l {
    private static k a;
    private static l$a a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a(Context object) {
        Class<l> clazz = l.class;
        synchronized (clazz) {
            boolean bl2;
            Object object2 = a;
            if (object2 != null) {
                return object2;
            }
            object2 = "mipush_account";
            String string2 = null;
            object2 = object.getSharedPreferences((String)object2, 0);
            string2 = "uuid";
            String string3 = null;
            String string4 = object2.getString(string2, null);
            string2 = "token";
            String string5 = object2.getString(string2, null);
            string2 = "security";
            String string6 = object2.getString(string2, null);
            string2 = "app_id";
            String string7 = object2.getString(string2, null);
            string2 = "app_token";
            String string8 = object2.getString(string2, null);
            string2 = "package_name";
            String string9 = object2.getString(string2, null);
            string2 = "device_id";
            string2 = object2.getString(string2, null);
            Object object3 = "env_type";
            int n10 = 1;
            n10 = object2.getInt((String)object3, n10);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3 && (bl3 = i.a(string2))) {
                string2 = i.k(object);
                object2 = object2.edit();
                object3 = "device_id";
                object2 = object2.putString((String)object3, string2);
                object2.commit();
            }
            if (!((bl2 = TextUtils.isEmpty((CharSequence)string4)) || (bl2 = TextUtils.isEmpty((CharSequence)string5)) || (bl2 = TextUtils.isEmpty((CharSequence)string6)))) {
                k k10;
                object2 = i.k(object);
                string3 = "com.xiaomi.xmsf";
                String string10 = object.getPackageName();
                boolean bl4 = string3.equals(string10);
                if (!(bl4 || (bl4 = TextUtils.isEmpty((CharSequence)object2)) || (bl4 = TextUtils.isEmpty((CharSequence)string2)) || (bl4 = string2.equals(object2)))) {
                    String string11 = "read_phone_state permission changes.";
                    b.a(string11);
                }
                object3 = k10;
                a = k10 = new k(string4, string5, string6, string7, string8, string9, n10);
                return k10;
            }
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a(Context var0, String var1_2, String var2_4, String var3_5) {
        var4_5 = l.class;
        synchronized (var4_5) {
            var5_6 = new TreeMap();
            var6_7 = 0;
            var7_8 = null;
            var7_8 = i.a(var0, false);
            var8_9 /* !! */  = new StringBuilder();
            var9_10 = "account register:";
            var8_9 /* !! */ .append((String)var9_10);
            var8_9 /* !! */ .append((String)var7_8);
            var8_9 /* !! */  = var8_9 /* !! */ .toString();
            b.a((String)var8_9 /* !! */ );
            var8_9 /* !! */  = "devid";
            var5_6.put(var8_9 /* !! */ , var7_8);
            var7_8 = "devid1";
            var8_9 /* !! */  = i.a(var0);
            var5_6.put(var7_8, var8_9 /* !! */ );
            var7_8 = l.a;
            var8_9 /* !! */  = null;
            if (var7_8 == null || (var6_7 = TextUtils.isEmpty((CharSequence)(var7_8 = var7_8.a))) != 0) ** GOTO lbl-1000
            var7_8 = "uuid";
            var9_10 = l.a;
            var9_10 = var9_10.a;
            var5_6.put(var7_8, var9_10);
            var7_8 = l.a;
            var7_8 = var7_8.a;
            var9_10 = "/";
            var6_7 = var7_8.lastIndexOf((String)var9_10);
            var10_11 = -1;
            if (var6_7 != var10_11) {
                var9_10 = l.a;
                var9_10 = var9_10.a;
                var7_8 = var9_10.substring(++var6_7);
            } else lbl-1000:
            // 2 sources

            {
                var6_7 = 0;
                var7_8 = null;
            }
            var9_10 = au.a(var0);
            var9_10.a((Map)var5_6);
            var9_10 = i.c(var0);
            if (var9_10 != null) {
                var11_12 = "vdevid";
                var5_6.put(var11_12, var9_10);
            }
            if (!(var12_13 = TextUtils.isEmpty((CharSequence)(var9_10 = i.b(var0))))) {
                var11_12 = "gaid";
                var5_6.put(var11_12, var9_10);
            }
            if ((var10_11 = l.a(var0)) != 0) {
                var2_3 = "1000271";
            }
            var11_12 = var2_3;
            var13_14 = l.a(var0);
            if (var13_14 != 0) {
                var3_4 = "420100086271";
            }
            var14_15 = var3_4;
            var13_14 = l.a(var0);
            if (var13_14 != 0) {
                var1_1 = "com.xiaomi.xmsf";
            }
            var15_16 = var1_1;
            var1_1 = "appid";
            var5_6.put(var1_1, var11_12);
            var1_1 = "apptoken";
            var5_6.put(var1_1, var14_15);
            try {
                var1_1 = var0.getPackageManager();
                var13_14 = 16384;
                var1_1 = var1_1.getPackageInfo((String)var15_16, var13_14);
            }
            catch (Exception var1_2) {
                b.a((Throwable)var1_2);
                var16_17 = 0;
                var1_1 = null;
            }
            var2_3 = "appversion";
            if (var1_1 != null) {
                var16_17 = var1_1.versionCode;
                var1_1 = String.valueOf(var16_17);
            } else {
                var1_1 = "0";
            }
            var5_6.put(var2_3, var1_1);
            var1_1 = "sdkversion";
            var13_14 = 30705;
            var2_3 = Integer.toString(var13_14);
            var5_6.put(var1_1, var2_3);
            var1_1 = "packagename";
            var5_6.put(var1_1, var15_16);
            var1_1 = "model";
            var2_3 = Build.MODEL;
            var5_6.put(var1_1, var2_3);
            var1_1 = "board";
            var2_3 = Build.BOARD;
            var5_6.put(var1_1, var2_3);
            var16_17 = (int)com.xiaomi.push.l.d();
            if (var16_17 == 0) {
                var1_1 = "";
                var2_3 = i.f(var0);
                var17_18 = TextUtils.isEmpty((CharSequence)var2_3);
                if (var17_18 == 0) {
                    var3_4 = new StringBuilder();
                    var3_4.append((String)var1_1);
                    var1_1 = bf.a((String)var2_3);
                    var3_4.append((String)var1_1);
                    var1_1 = var3_4.toString();
                }
                var2_3 = i.h(var0);
                var17_18 = TextUtils.isEmpty((CharSequence)var1_1);
                if (var17_18 == 0 && (var17_18 = TextUtils.isEmpty((CharSequence)var2_3)) == 0) {
                    var3_4 = new StringBuilder();
                    var3_4.append((String)var1_1);
                    var1_1 = ",";
                    var3_4.append((String)var1_1);
                    var3_4.append((String)var2_3);
                    var1_1 = var3_4.toString();
                }
                if ((var13_14 = (int)TextUtils.isEmpty((CharSequence)var1_1)) == 0) {
                    var2_3 = "imei_md5";
                    var5_6.put(var2_3, var1_1);
                }
            }
            var1_1 = "os";
            var2_3 = new StringBuilder();
            var3_4 = Build.VERSION.RELEASE;
            var2_3.append((String)var3_4);
            var3_4 = "-";
            var2_3.append((String)var3_4);
            var3_4 = Build.VERSION.INCREMENTAL;
            var2_3.append((String)var3_4);
            var2_3 = var2_3.toString();
            var5_6.put(var1_1, var2_3);
            var16_17 = i.a();
            if (var16_17 >= 0) {
                var2_3 = "space_id";
                var1_1 = Integer.toString(var16_17);
                var5_6.put(var2_3, var1_1);
            }
            if ((var13_14 = (int)TextUtils.isEmpty((CharSequence)(var1_1 = i.n(var0)))) == 0) {
                var2_3 = "mac_address";
                var1_1 = bf.a((String)var1_1);
                var5_6.put(var2_3, var1_1);
            }
            var1_1 = "android_id";
            var2_3 = i.e(var0);
            var5_6.put(var1_1, var2_3);
            var1_1 = "brand";
            var2_3 = new StringBuilder();
            var3_4 = Build.BRAND;
            var2_3.append((String)var3_4);
            var3_4 = "";
            var2_3.append((String)var3_4);
            var2_3 = var2_3.toString();
            var5_6.put(var1_1, var2_3);
            var1_1 = "ram";
            var2_3 = i.b();
            var5_6.put(var1_1, var2_3);
            var1_1 = "rom";
            var2_3 = i.c();
            var5_6.put(var1_1, var2_3);
            var1_1 = l.a(var0);
            var1_1 = az.a(var0, (String)var1_1, var5_6);
            var2_3 = "";
            if (var1_1 != null) {
                var2_3 = var1_1.a();
            }
            if ((var16_17 = (int)TextUtils.isEmpty((CharSequence)var2_3)) == 0) {
                var1_1 = new JSONObject((String)var2_3);
                var3_4 = "code";
                var17_18 = var1_1.getInt((String)var3_4);
                if (var17_18 == 0) {
                    var2_3 = "data";
                    var1_1 = var1_1.getJSONObject((String)var2_3);
                    var2_3 = "ssecurity";
                    var9_10 = var1_1.getString((String)var2_3);
                    var2_3 = "token";
                    var8_9 /* !! */  = var1_1.getString((String)var2_3);
                    var2_3 = "userId";
                    var2_3 = var1_1.getString((String)var2_3);
                    var17_18 = (int)TextUtils.isEmpty((CharSequence)var7_8);
                    if (var17_18 != 0) {
                        var3_4 = new StringBuilder();
                        var5_6 = "an";
                        var3_4.append((String)var5_6);
                        var18_19 = 6;
                        var5_6 = bf.a(var18_19);
                        var3_4.append((String)var5_6);
                        var7_8 = var3_4.toString();
                    }
                    var5_6 = new StringBuilder();
                    var5_6.append((String)var2_3);
                    var2_3 = "@xiaomi.com/";
                    var5_6.append((String)var2_3);
                    var5_6.append((String)var7_8);
                    var7_8 = var5_6.toString();
                    var19_20 = ab.a();
                    var5_6 = var3_4;
                    var3_4 = new k((String)var7_8, (String)var8_9 /* !! */ , (String)var9_10, var11_12, (String)var14_15, (String)var15_16, var19_20);
                    l.a(var0, (k)var3_4);
                    var2_3 = "vdevid";
                    var1_1 = var1_1.optString((String)var2_3);
                    i.a(var0, (String)var1_1);
                    l.a = var3_4;
                    return var3_4;
                }
                var3_4 = "code";
                var17_18 = var1_1.getInt((String)var3_4);
                var5_6 = "description";
                var1_1 = var1_1.optString((String)var5_6);
                com.xiaomi.push.service.o.a(var0, var17_18, (String)var1_1);
                b.a((String)var2_3);
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String a(Context object) {
        String string2;
        object = com.xiaomi.push.service.a.a((Context)object).a();
        boolean bl2 = ab.b();
        String string3 = "/pass/v2/register";
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("http://");
            string2 = ft.b;
            ((StringBuilder)object).append(string2);
            string2 = ":9085";
        } else {
            string2 = o.a.name();
            bl2 = string2.equals(object);
            if (bl2) {
                object = new StringBuilder();
                string2 = "https://cn.register.xmpush.xiaomi.com";
            } else {
                string2 = o.b.name();
                bl2 = string2.equals(object);
                if (bl2) {
                    object = new StringBuilder();
                    string2 = "https://register.xmpush.global.xiaomi.com";
                } else {
                    string2 = o.c.name();
                    bl2 = string2.equals(object);
                    if (bl2) {
                        object = new StringBuilder();
                        string2 = "https://fr.register.xmpush.global.xiaomi.com";
                    } else {
                        string2 = o.d.name();
                        bl2 = string2.equals(object);
                        if (bl2) {
                            object = new StringBuilder();
                            string2 = "https://ru.register.xmpush.global.xiaomi.com";
                        } else {
                            string2 = o.e.name();
                            boolean bl3 = string2.equals(object);
                            if (bl3) {
                                object = new StringBuilder();
                                string2 = "https://idmb.register.xmpush.global.xiaomi.com";
                            } else {
                                object = new StringBuilder();
                                string2 = "https://";
                                ((StringBuilder)object).append(string2);
                                bl2 = ab.a();
                                string2 = bl2 ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
                            }
                        }
                    }
                }
            }
        }
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        return ((StringBuilder)object).toString();
    }

    public static void a() {
        l$a l$a = a;
        if (l$a != null) {
            l$a.a();
        }
    }

    public static void a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        l.a();
    }

    public static void a(Context object, k k10) {
        SharedPreferences.Editor editor = object.getSharedPreferences("mipush_account", 0).edit();
        String string2 = k10.a;
        editor.putString("uuid", string2);
        string2 = k10.c;
        editor.putString("security", string2);
        string2 = k10.b;
        editor.putString("token", string2);
        string2 = k10.d;
        editor.putString("app_id", string2);
        string2 = k10.f;
        editor.putString("package_name", string2);
        string2 = k10.e;
        editor.putString("app_token", string2);
        object = i.k(object);
        editor.putString("device_id", (String)object);
        int n10 = k10.a;
        editor.putInt("env_type", n10);
        editor.commit();
        l.a();
    }

    public static void a(l$a l$a) {
        a = l$a;
    }

    private static boolean a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}

