/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Process
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.lbsapi.auth.ErrorMessage;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.b;
import com.baidu.lbsapi.auth.c;
import com.baidu.lbsapi.auth.c$a;
import com.baidu.lbsapi.auth.e;
import com.baidu.lbsapi.auth.e$a;
import com.baidu.lbsapi.auth.i;
import com.baidu.lbsapi.auth.j;
import com.baidu.lbsapi.auth.k;
import com.baidu.lbsapi.auth.l;
import com.baidu.lbsapi.auth.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = 255;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = 245;
    public static final int CODE_NETWORK_INVALID = 246;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.23";
    private static Context a;
    private static m d;
    private static int e;
    private static Hashtable f;
    private static LBSAuthManager g;
    private c b = null;
    private e c = null;
    private boolean h = false;
    private final Handler i;

    static {
        Hashtable hashtable;
        f = hashtable = new Hashtable();
    }

    private LBSAuthManager(Context object) {
        boolean bl2;
        Looper looper = Looper.getMainLooper();
        i i10 = new i(this, looper);
        this.i = i10;
        a = object;
        object = d;
        if (object != null && !(bl2 = ((Thread)object).isAlive())) {
            d = null;
        }
        com.baidu.lbsapi.auth.a.b("BaiduApiAuth SDK Version:1.0.23");
        this.d();
    }

    /*
     * Unable to fully structure code
     */
    private int a(String var1_1) {
        block25: {
            block24: {
                block23: {
                    block22: {
                        var2_3 = "status";
                        var3_4 = "current";
                        var4_5 = -1;
                        var5_6 = new JSONObject((String)var1_1);
                        var6_7 = var5_6.has(var2_3);
                        if (var6_7 != 0) break block22;
                        var5_6.put(var2_3, var4_5);
                    }
                    var4_5 = var5_6.getInt(var2_3);
                    var6_7 = var5_6.has(var3_4);
                    var7_8 = 601;
                    if (var6_7 == 0 || var4_5 != 0) break block23;
                    var8_9 = var5_6.getLong(var3_4);
                    var10_10 = System.currentTimeMillis();
                    var12_11 = var10_10 - var8_9;
                    var14_12 = (double)var12_11 / 3600000.0;
                    var16_13 = 24.0;
                    var6_7 = (int)(var14_12 == var16_13 ? 0 : (var14_12 > var16_13 ? 1 : -1));
                    if (var6_7 >= 0) {
                        while (true) {
                            var4_5 = var7_8;
                            break block23;
                            break;
                        }
                    }
                    var6_7 = (int)this.h;
                    if (var6_7 == 0) break block23;
                    var18_14 = "yyyy-MM-dd";
                    var1_1 = new SimpleDateFormat(var18_14);
                    var19_15 = var10_10;
                    var19_15 = var1_1.format(var19_15);
                    var20_16 = var8_9;
                    var1_1 = var1_1.format(var20_16);
                    var6_7 = (int)var19_15.equals(var1_1);
                    if (var6_7 == 0) ** continue;
                }
                var6_7 = var5_6.has(var3_4);
                if (var6_7 == 0 || var4_5 != (var6_7 = 602)) break block24;
                var21_17 = var5_6.getLong(var3_4);
                var23_18 = System.currentTimeMillis() - var21_17;
                var21_17 = 1000L;
                var25_19 = 4.94E-321;
                try {
                    var25_19 = var23_18 / var21_17;
                    var23_18 = 4640537203540230144L;
                    var27_20 = 180.0;
                }
                catch (JSONException var1_2) {
                    var1_2.printStackTrace();
                }
                var6_7 = (int)(var25_19 == var27_20 ? 0 : (var25_19 > var27_20 ? 1 : -1));
                if (var6_7 <= 0) break block24;
                break block25;
            }
            var7_8 = var4_5;
        }
        return var7_8;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(int n10) {
        Object object;
        Object object2;
        block27: {
            Object object3;
            Object object4;
            block24: {
                block23: {
                    block26: {
                        block25: {
                            block22: {
                                object2 = null;
                                object4 = new StringBuilder();
                                String string2 = "/proc/";
                                ((StringBuilder)object4).append(string2);
                                ((StringBuilder)object4).append(n10);
                                object = "/cmdline";
                                ((StringBuilder)object4).append((String)object);
                                object = ((StringBuilder)object4).toString();
                                object3 = new File((String)object);
                                object = new FileInputStream((File)object3);
                                object3 = new InputStreamReader((InputStream)object);
                                object4 = new BufferedReader((Reader)object3);
                                try {
                                    object2 = ((BufferedReader)object4).readLine();
                                }
                                catch (Throwable throwable) {
                                    break block22;
                                }
                                ((BufferedReader)object4).close();
                                ((InputStreamReader)object3).close();
                                break block27;
                                catch (Throwable throwable) {
                                    object4 = null;
                                    object2 = throwable;
                                    break block22;
                                }
                                catch (IOException iOException) {
                                    object4 = null;
                                    break block23;
                                }
                                catch (FileNotFoundException fileNotFoundException) {
                                    object4 = null;
                                    break block24;
                                }
                                catch (Throwable throwable) {
                                    object4 = null;
                                    object2 = throwable;
                                    object3 = null;
                                    break block22;
                                }
                                catch (IOException iOException) {
                                    object3 = null;
                                    break block25;
                                }
                                catch (FileNotFoundException fileNotFoundException) {
                                    object3 = null;
                                    break block26;
                                }
                                catch (Throwable throwable) {
                                    object3 = null;
                                    object4 = null;
                                    object2 = throwable;
                                    n10 = 0;
                                    object = null;
                                }
                            }
                            if (object4 != null) {
                                ((BufferedReader)object4).close();
                            }
                            if (object3 != null) {
                                ((InputStreamReader)object3).close();
                            }
                            if (object == null) throw object2;
                            ((FileInputStream)object).close();
                            throw object2;
                            catch (IOException iOException) {
                                n10 = 0;
                                object = null;
                                object3 = null;
                            }
                        }
                        object4 = null;
                        break block23;
                        catch (FileNotFoundException fileNotFoundException) {
                            n10 = 0;
                            object = null;
                            object3 = null;
                        }
                    }
                    object4 = null;
                    break block24;
                    catch (IOException iOException) {}
                }
                if (object4 != null) {
                    ((BufferedReader)object4).close();
                }
                if (object3 != null) {
                    ((InputStreamReader)object3).close();
                }
                if (object == null) return object2;
                break block27;
                catch (FileNotFoundException fileNotFoundException) {}
            }
            if (object4 != null) {
                ((BufferedReader)object4).close();
            }
            if (object3 != null) {
                ((InputStreamReader)object3).close();
            }
            if (object == null) return object2;
        }
        ((FileInputStream)object).close();
        return object2;
    }

    private String a(Context object) {
        int n10 = Process.myPid();
        try {
            object = this.a(n10);
        }
        catch (IOException iOException) {
            n10 = 0;
            object = null;
        }
        if (object != null) {
            return object;
        }
        return a.getPackageName();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(Context var1_1, String var2_2) {
        var3_3 = "\u65e0\u6cd5\u5728AndroidManifest.xml\u4e2d\u83b7\u53d6com.baidu.android.lbs.API_KEY\u7684\u503c";
        var4_4 = "";
        var5_5 = var1_1.getPackageName();
        var6_6 = 101;
        var1_1 = var1_1.getPackageManager();
        var7_7 = 128;
        var1_1 = var1_1.getApplicationInfo(var5_5, var7_7);
        var1_1 = var1_1.metaData;
        if (var1_1 == null) {
            var1_1 = LBSAuthManager.f;
            var1_1 = var1_1.get(var2_2);
            if ((var1_1 = (LBSAuthManagerListener)var1_1) == null) return var4_4;
            var5_5 = "AndroidManifest.xml\u7684application\u4e2d\u6ca1\u6709meta-data\u6807\u7b7e";
            var5_5 = ErrorMessage.a(var6_6, var5_5);
            var1_1.onAuthResult(var6_6, var5_5);
            return var4_4;
        }
        var5_5 = "com.baidu.lbsapi.API_KEY";
        if ((var1_1 = var1_1.getString(var5_5)) == null) ** GOTO lbl24
        {
            catch (PackageManager.NameNotFoundException v0) {}
        }
        try {
            var8_8 = var1_1.equals(var4_4);
            if (var8_8 == false) return var1_1;
lbl24:
            // 2 sources

            var4_4 = LBSAuthManager.f;
            var4_4 = var4_4.get(var2_2);
            if ((var4_4 = (LBSAuthManagerListener)var4_4) == null) return var1_1;
            var5_5 = ErrorMessage.a(var6_6, var3_3);
            var4_4.onAuthResult(var6_6, var5_5);
            return var1_1;
        }
        catch (PackageManager.NameNotFoundException v1) {
            var4_4 = var1_1;
            if ((var1_1 = (LBSAuthManagerListener)LBSAuthManager.f.get(var2_2)) == null) return var4_4;
            var2_2 = ErrorMessage.a(var6_6, var3_3);
            var1_1.onAuthResult(var6_6, var2_2);
        }
        return var4_4;
    }

    public static /* synthetic */ Hashtable a() {
        return f;
    }

    public static /* synthetic */ void a(LBSAuthManager lBSAuthManager, String string2, String string3) {
        lBSAuthManager.a(string2, string3);
    }

    public static /* synthetic */ void a(LBSAuthManager lBSAuthManager, boolean bl2, String string2, Hashtable hashtable, String string3) {
        lBSAuthManager.a(bl2, string2, hashtable, string3);
    }

    public static /* synthetic */ void a(LBSAuthManager lBSAuthManager, boolean bl2, String string2, Hashtable hashtable, String[] stringArray, String string3) {
        lBSAuthManager.a(bl2, string2, hashtable, stringArray, string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String object, String string2) {
        synchronized (this) {
            String string3;
            int n10;
            if (object == null) {
                object = this.e();
            }
            Handler handler = this.i;
            handler = handler.obtainMessage();
            int n11 = -1;
            try {
                Object object2 = new JSONObject((String)object);
                object = "status";
                n10 = object2.has((String)object);
                if (n10 == 0) {
                    object = "status";
                    object2.put((String)object, n11);
                }
                if ((n10 = object2.has((String)(object = "current"))) == 0) {
                    object = "current";
                    long l10 = System.currentTimeMillis();
                    object2.put((String)object, l10);
                }
                object = object2.toString();
                this.c((String)object);
                object = "current";
                n10 = object2.has((String)object);
                if (n10 != 0) {
                    object = "current";
                    object2.remove((String)object);
                }
                object = "status";
                handler.what = n11 = object2.getInt((String)object);
                handler.obj = object = object2.toString();
                object = new Bundle();
                object2 = "listenerKey";
                object.putString((String)object2, string3);
                handler.setData((Bundle)object);
                object = this.i;
                object.sendMessage((Message)handler);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                handler.what = n11;
                handler.obj = object = new JSONObject();
                object = new Bundle();
                String string4 = "listenerKey";
                object.putString(string4, string3);
                handler.setData((Bundle)object);
                object = this.i;
                object.sendMessage((Message)handler);
            }
            object = d;
            if (object != null) {
                ((m)object).c();
            }
            e = n10 = e + -1;
            object = new StringBuilder();
            string3 = "httpRequest called mAuthCounter-- = ";
            ((StringBuilder)object).append(string3);
            int n12 = e;
            ((StringBuilder)object).append(n12);
            object = ((StringBuilder)object).toString();
            com.baidu.lbsapi.auth.a.a((String)object);
            n10 = e;
            if (n10 == 0 && (object = d) != null) {
                ((m)object).a();
                n10 = 0;
                object = null;
                d = null;
            }
            return;
        }
    }

    private void a(boolean bl2, String object, Hashtable object2, String string2) {
        String string3;
        boolean bl3;
        Object object3 = a;
        if ((object3 = this.a((Context)object3, string2)) != null && !(bl3 = ((String)object3).equals(string3 = ""))) {
            Object object4;
            int n10;
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            com.baidu.lbsapi.auth.a.a("url:https://api.map.baidu.com/sdkcs/verify");
            hashMap.put("output", "json");
            hashMap.put("ak", object3);
            CharSequence charSequence = new StringBuilder();
            String string4 = "ak:";
            charSequence.append(string4);
            charSequence.append((String)object3);
            com.baidu.lbsapi.auth.a.a(charSequence.toString());
            object3 = com.baidu.lbsapi.auth.b.a(a);
            hashMap.put("mcode", object3);
            object3 = "from";
            charSequence = "lbs_yunsdk";
            hashMap.put(object3, charSequence);
            if (object2 != null && (n10 = ((Hashtable)object2).size()) > 0) {
                object2 = ((Hashtable)object2).entrySet().iterator();
                while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object3 = (Map.Entry)object2.next();
                    charSequence = (String)object3.getKey();
                    object3 = (String)object3.getValue();
                    boolean bl4 = TextUtils.isEmpty((CharSequence)charSequence);
                    if (bl4 || (bl4 = TextUtils.isEmpty((CharSequence)object3))) continue;
                    hashMap.put(charSequence, object3);
                }
            }
            object2 = a;
            try {
                object2 = CommonParam.a((Context)object2);
            }
            catch (Exception exception) {
                object3 = "get cuid failed";
                com.baidu.lbsapi.auth.a.a((String)object3);
                exception.printStackTrace();
                object2 = string3;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("cuid:");
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            com.baidu.lbsapi.auth.a.a((String)object3);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            charSequence = "cuid";
            if (n10 == 0) {
                hashMap.put(charSequence, object2);
            } else {
                hashMap.put(charSequence, string3);
            }
            object2 = a.getPackageName();
            hashMap.put("pcn", object2);
            object3 = VERSION;
            hashMap.put("version", object3);
            object2 = "macaddr";
            hashMap.put(object2, string3);
            try {
                object2 = com.baidu.lbsapi.auth.b.a();
            }
            catch (Exception exception) {
                object2 = string3;
            }
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            charSequence = "language";
            if (n10 == 0) {
                hashMap.put(charSequence, object2);
            } else {
                hashMap.put(charSequence, string3);
            }
            if (bl2) {
                int n11;
                if (bl2) {
                    object4 = new StringBuilder();
                    n11 = 1;
                } else {
                    object4 = new StringBuilder();
                    n11 = 0;
                    object2 = null;
                }
                ((StringBuilder)object4).append(n11);
                ((StringBuilder)object4).append(string3);
                object4 = ((StringBuilder)object4).toString();
                object2 = "force";
                hashMap.put(object2, object4);
            }
            object4 = "from_service";
            if (object == null) {
                hashMap.put(object4, string3);
            } else {
                hashMap.put(object4, object);
            }
            object = a;
            this.b = object4 = new c((Context)object);
            object = new k(this, string2);
            ((c)object4).a(hashMap, (c$a)object);
        }
    }

    private void a(boolean bl2, String object, Hashtable object2, String[] stringArray, String string2) {
        String string3;
        boolean bl3;
        Object object3 = a;
        if ((object3 = this.a((Context)object3, string2)) != null && !(bl3 = ((String)object3).equals(string3 = ""))) {
            Object object4;
            int n10;
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
            String string4 = "json";
            hashMap.put("output", string4);
            hashMap.put("ak", object3);
            object3 = "from";
            String string5 = "lbs_yunsdk";
            hashMap.put(object3, string5);
            if (object2 != null && (n10 = ((Hashtable)object2).size()) > 0) {
                object2 = ((Hashtable)object2).entrySet().iterator();
                while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object3 = object2.next();
                    string5 = (String)object3.getKey();
                    object3 = (String)object3.getValue();
                    boolean bl4 = TextUtils.isEmpty((CharSequence)string5);
                    if (bl4 || (bl4 = TextUtils.isEmpty((CharSequence)object3))) continue;
                    hashMap.put(string5, object3);
                }
            }
            object2 = a;
            try {
                object2 = CommonParam.a((Context)object2);
            }
            catch (Exception exception) {
                object2 = string3;
            }
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            string5 = "cuid";
            if (n10 == 0) {
                hashMap.put(string5, object2);
            } else {
                hashMap.put(string5, string3);
            }
            object2 = a.getPackageName();
            hashMap.put("pcn", object2);
            object3 = VERSION;
            hashMap.put("version", object3);
            object2 = "macaddr";
            hashMap.put(object2, string3);
            try {
                object2 = com.baidu.lbsapi.auth.b.a();
            }
            catch (Exception exception) {
                object2 = string3;
            }
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            string5 = "language";
            if (n10 == 0) {
                hashMap.put(string5, object2);
            } else {
                hashMap.put(string5, string3);
            }
            if (bl2) {
                int n11;
                if (bl2) {
                    object4 = new StringBuilder();
                    n11 = 1;
                } else {
                    object4 = new StringBuilder();
                    n11 = 0;
                    object2 = null;
                }
                ((StringBuilder)object4).append(n11);
                ((StringBuilder)object4).append(string3);
                object4 = ((StringBuilder)object4).toString();
                object2 = "force";
                hashMap.put(object2, object4);
            }
            object4 = "from_service";
            if (object == null) {
                hashMap.put(object4, string3);
            } else {
                hashMap.put(object4, object);
            }
            object = a;
            this.c = object4 = new e((Context)object);
            object = new l(this, string2);
            ((e)object4).a(hashMap, stringArray, (e$a)object);
        }
    }

    public static /* synthetic */ boolean a(LBSAuthManager lBSAuthManager, String string2) {
        return lBSAuthManager.b(string2);
    }

    public static /* synthetic */ Context b() {
        return a;
    }

    private boolean b(String string2) {
        boolean bl2;
        JSONObject jSONObject;
        boolean bl3;
        String string3;
        block6: {
            string3 = "ak";
            Object object = a;
            string2 = this.a((Context)object, string2);
            object = this.e();
            bl3 = true;
            jSONObject = new JSONObject((String)object);
            boolean bl4 = jSONObject.has(string3);
            if (bl4) break block6;
            return bl3;
        }
        try {
            string3 = jSONObject.getString(string3);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            string3 = "";
        }
        if (string2 != null && string3 != null && !(bl2 = string2.equals(string3))) {
            return bl3;
        }
        return false;
    }

    public static /* synthetic */ m c() {
        return d;
    }

    private void c(String string2) {
        Context context = a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("authStatus_");
        Object object = a;
        object = this.a((Context)object);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        context.getSharedPreferences((String)charSequence, 0).edit().putString("status", string2).commit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d() {
        Class<LBSAuthManager> clazz = LBSAuthManager.class;
        synchronized (clazz) {
            Object object = d;
            if (object == null) {
                String string2 = "auth";
                object = new m(string2);
                d = object;
                ((Thread)object).start();
                while (true) {
                    object = d;
                    object = ((m)object).a;
                    if (object != null) break;
                    object = "wait for create auth thread.";
                    try {
                        com.baidu.lbsapi.auth.a.a((String)object);
                        long l10 = 3;
                        Thread.sleep(l10);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
            return;
        }
    }

    private String e() {
        Context context = a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("authStatus_");
        Object object = a;
        object = this.a((Context)object);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        return context.getSharedPreferences((String)charSequence, 0).getString("status", "{\"status\":601}");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LBSAuthManager getInstance(Context object) {
        Object object2 = g;
        if (object2 == null) {
            object2 = LBSAuthManager.class;
            synchronized (object2) {
                LBSAuthManager lBSAuthManager = g;
                if (lBSAuthManager != null) return g;
                g = lBSAuthManager = new LBSAuthManager((Context)object);
                return g;
            }
        }
        if (object == null) {
            boolean bl2 = com.baidu.lbsapi.auth.a.a;
            if (!bl2) return g;
            com.baidu.lbsapi.auth.a.c("input context is null");
            object2 = "here";
            object = new RuntimeException((String)object2);
            ((Throwable)object).printStackTrace();
            return g;
        }
        a = object;
        return g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int authenticate(boolean bl2, String string2, Hashtable hashtable, LBSAuthManagerListener object) {
        Class<LBSAuthManager> clazz = LBSAuthManager.class;
        synchronized (clazz) {
            int n10;
            Object object2;
            int n11 = 1;
            int n12 = 0;
            Object object3 = null;
            if (hashtable != null) {
                object2 = "zero_auth";
                object2 = hashtable.get(object2);
                if (object2 != null && (n10 = ((Integer)(object2 = Integer.valueOf((String)object2))).intValue()) == n11) {
                    n12 = n11;
                }
            }
            this.h = n12;
            object3 = new StringBuilder();
            long l10 = System.currentTimeMillis();
            ((StringBuilder)object3).append(l10);
            object2 = "";
            ((StringBuilder)object3).append((String)object2);
            String string3 = ((StringBuilder)object3).toString();
            if (object != null) {
                object3 = f;
                ((Hashtable)object3).put(string3, object);
            }
            object = a;
            if ((object = this.a((Context)object, string3)) == null) return 101;
            object3 = "";
            int n13 = ((String)object).equals(object3);
            if (n13 == 0) {
                e = n13 = e + n11;
                object = new StringBuilder();
                Object object4 = " mAuthCounter  ++ = ";
                ((StringBuilder)object).append((String)object4);
                n11 = e;
                ((StringBuilder)object).append(n11);
                object = ((StringBuilder)object).toString();
                com.baidu.lbsapi.auth.a.a((String)object);
                object = this.e();
                object4 = new StringBuilder();
                object3 = "getAuthMessage from cache:";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                com.baidu.lbsapi.auth.a.a((String)object4);
                n13 = this.a((String)object);
                n11 = 601;
                if (n13 == n11) {
                    try {
                        object4 = new JSONObject();
                        object3 = "status";
                        n10 = 602;
                        object4 = object4.put((String)object3, n10);
                        object4 = object4.toString();
                        this.c((String)object4);
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                    }
                }
                this.d();
                object4 = d;
                if (object4 == null) return -1;
                object4 = ((m)object4).a;
                if (object4 == null) return -1;
                object4 = new StringBuilder();
                object3 = "mThreadLooper.mHandler = ";
                ((StringBuilder)object4).append((String)object3);
                object3 = d;
                object3 = ((m)object3).a;
                ((StringBuilder)object4).append(object3);
                object4 = ((StringBuilder)object4).toString();
                com.baidu.lbsapi.auth.a.a((String)object4);
                object4 = d;
                object4 = ((m)object4).a;
                object3 = new j(this, n13, bl2, string3, string2, hashtable);
                object4.post((Runnable)object3);
                return n13;
            }
            return 101;
        }
    }

    public String getCUID() {
        Context context = a;
        String string2 = "";
        if (context == null) {
            return string2;
        }
        try {
            string2 = CommonParam.a(context);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return string2;
    }

    public String getKey() {
        Context context = a;
        String string2 = "";
        if (context == null) {
            return string2;
        }
        try {
            return this.getPublicKey(context);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return string2;
        }
    }

    public String getMCode() {
        Context context = a;
        if (context == null) {
            return "";
        }
        return com.baidu.lbsapi.auth.b.a(context);
    }

    public String getPublicKey(Context context) {
        String string2 = context.getPackageName();
        return context.getPackageManager().getApplicationInfo((String)string2, (int)128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}

