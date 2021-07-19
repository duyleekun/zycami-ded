/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.wifi.WifiConfiguration
 *  android.os.Handler
 *  android.util.Base64
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.baidu.location.c;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.util.Base64;
import com.baidu.location.c.h$a;
import com.baidu.location.c.h$b;
import com.baidu.location.c.i;
import com.baidu.location.h.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
    private static Object a;
    private static h b;
    private Handler c = null;
    private String d = null;
    private int e = 24;
    private h$a f = null;
    private long g = 0L;

    static {
        Object object;
        a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a() {
        Object object = a;
        synchronized (object) {
            h h10 = b;
            if (h10 != null) return b;
            b = h10 = new h();
            return b;
        }
    }

    private Object a(Object object, String string2) {
        return object.getClass().getField(string2).get(object);
    }

    private List a(List object) {
        ArrayList<Object> arrayList;
        int n10;
        if (object != null && (n10 = object.size()) > 0) {
            int n11;
            arrayList = new ArrayList<Object>();
            object = object.iterator();
            while ((n11 = object.hasNext()) != 0) {
                Object object2 = (WifiConfiguration)object.next();
                String string2 = ((WifiConfiguration)object2).SSID;
                Object object3 = "numAssociation";
                object2 = this.a(object2, (String)object3);
                object2 = (Integer)object2;
                try {
                    n11 = (Integer)object2;
                }
                catch (Throwable throwable) {
                    n11 = 0;
                    object2 = null;
                }
                if (n11 <= 0 || string2 == null) continue;
                object3 = new h$b(this, string2, n11);
                arrayList.add(object3);
            }
        } else {
            n10 = 0;
            arrayList = null;
        }
        return arrayList;
    }

    public static /* synthetic */ void a(h h10) {
        h10.d();
    }

    private void a(boolean bl2, JSONArray jSONArray, JSONArray jSONArray2) {
        boolean bl3;
        h$a h$a = this.f;
        if (h$a == null) {
            this.f = h$a = new h$a(this);
        }
        if (!(bl3 = l.b())) {
            h$a = this.f;
            h$a.a(bl2, jSONArray, jSONArray2);
        }
    }

    public static /* synthetic */ String b(h h10) {
        return h10.d;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d() {
        block27: {
            block26: {
                var1_1 = this;
                var2_2 = "data";
                var3_7 = "frq";
                var4_8 = "tt";
                var5_9 = "cfg";
                var6_10 = "ison";
                var7_11 = this.d;
                if (var7_11 == null) return;
                try {
                    var8_12 = this.d;
                    var9_13 = "wcnf.dat";
                    var7_11 = new File(var8_12, var9_13);
                    var10_14 = System.currentTimeMillis();
                    var12_15 = var7_11.exists();
                    var13_16 = 0L;
                    var15_17 = "num";
                    var16_18 = 0;
                    var17_19 = "ssid";
                    if (var12_15) {
                    }
                    ** GOTO lbl92
                }
                catch (Exception var2_6) {
                    var2_6.printStackTrace();
                    return;
                }
                try {
                    var19_21 = new FileReader((File)var7_11);
                    var18_20 = new BufferedReader((Reader)var19_21);
                    var7_11 = new StringBuffer();
                    while ((var19_21 = var18_20.readLine()) != null) {
                        var7_11.append((String)var19_21);
                    }
                    var18_20.close();
                    var7_11 = var7_11.toString();
                    if (var7_11 != null) {
                        var7_11 = var7_11.getBytes();
                        var7_11 = Base64.decode((byte[])var7_11, (int)0);
                        var18_20 = new String((byte[])var7_11);
                        var7_11 = new JSONObject((String)var18_20);
                        var12_15 = var7_11.has(var6_10);
                        if (var12_15 && (var20_22 = var7_11.getInt(var6_10)) == 0) {
                            var20_22 = 0;
                            var6_10 = null;
                            break block26;
                        } else {
                            var20_22 = 1;
                        }
                    }
                    ** GOTO lbl93
                }
                catch (Exception var2_5) {
                    var21_23 = 0;
                    var3_7 = null;
                    var20_22 = 1;
                    ** GOTO lbl-1000
                }
            }
            try {
                var12_15 = var7_11.has((String)var5_9);
                if (var12_15 && (var12_15 = (var5_9 = var7_11.getJSONObject((String)var5_9)).has((String)var3_7))) {
                    var1_1.e = var21_23 = var5_9.getInt((String)var3_7);
                }
                if ((var21_23 = (int)var7_11.has(var4_8)) != 0) {
                    var10_14 = var7_11.getLong(var4_8);
                }
                if ((var21_23 = (int)var7_11.has(var2_2)) == 0) break block27;
                var2_2 = var7_11.getJSONArray(var2_2);
                var3_7 = new HashMap<Object, Object>();
            }
            catch (Exception var2_4) {
                var21_23 = 0;
                var3_7 = null;
                ** GOTO lbl-1000
            }
            try {
                var22_24 = var2_2.length();
                var5_9 = null;
                for (var23_25 = 0; var23_25 < var22_24; ++var23_25) {
                    var7_11 = var2_2.getJSONObject(var23_25);
                    var12_15 = var7_11.has(var17_19);
                    if (var12_15 && (var12_15 = var7_11.has(var15_17))) {
                        var19_21 = var7_11.getString(var17_19);
                        var16_18 = var7_11.getInt(var15_17);
                        var18_20 = new h$b(var1_1, (String)var19_21, var16_18);
                        var7_11 = var7_11.getString(var17_19);
                        var3_7.put(var7_11, var18_20);
                    }
                    var16_18 = 0;
                }
                ** GOTO lbl96
            }
            catch (Exception var2_3) {
                ** GOTO lbl-1000
            }
        }
        var21_23 = 0;
        var3_7 = null;
        ** GOTO lbl96
lbl-1000:
        // 3 sources

        {
            block28: {
                var2_2.printStackTrace();
                break block28;
lbl92:
                // 1 sources

                var10_14 = var13_16;
lbl93:
                // 2 sources

                var21_23 = 0;
                var3_7 = null;
                var20_22 = 1;
            }
            if (var20_22 != 0) ** GOTO lbl100
            var24_26 = var1_1.e * 4;
        }
        {
            var1_1.e = var24_26;
lbl100:
            // 2 sources

            var25_27 = System.currentTimeMillis() - var10_14;
        }
        {
            var27_28 = var1_1.e * 60 * 60 * 1000;
        }
        var24_26 = (int)(var25_27 == var27_28 ? 0 : (var25_27 < var27_28 ? -1 : 1));
        if (var24_26 <= 0) return;
        {
            block31: {
                block33: {
                    block32: {
                        block30: {
                            block29: {
                                var2_2 = com.baidu.location.f.i.a();
                                var2_2 = var2_2.d();
                                var2_2 = var1_1.a((List)var2_2);
                                var22_24 = var10_14 == var13_16 ? 0 : (var10_14 < var13_16 ? -1 : 1);
                                if (var22_24 != false) break block29;
                                if (var2_2 == null || (var21_23 = var2_2.size()) <= 0) break block30;
                                var3_7 = new HashMap<Object, Object>();
                                var4_8 = new JSONArray();
                                var2_2 = var2_2.iterator();
                                while ((var23_25 = (int)var2_2.hasNext()) != 0) {
                                    var5_9 = var2_2.next();
                                    var5_9 = (h$b)var5_9;
                                    var6_10 = new JSONObject();
                                    var7_11 = var5_9.a;
                                    var6_10.put(var17_19, var7_11);
                                    var23_25 = var5_9.b;
                                    var6_10.put(var15_17, var23_25);
                                    var3_7.put(var6_10);
                                    var4_8.put((Object)var6_10);
                                }
                                var17_19 = var3_7;
                                var16_18 = 1;
                                break block31;
                            }
                            if (var2_2 == null || (var22_24 = (long)var2_2.size()) <= 0) break block30;
                            var4_8 = new JSONArray();
                            if (var3_7 == null || (var23_25 = var3_7.size()) <= 0) break block32;
                            var2_2 = var2_2.iterator();
                            var29_29 = null;
                            while ((var23_25 = (int)var2_2.hasNext()) != 0) {
                                var5_9 = var2_2.next();
                                var5_9 = (h$b)var5_9;
                                var6_10 = new JSONObject();
                                var7_11 = var5_9.a;
                                var6_10.put(var17_19, var7_11);
                                var30_30 = var5_9.b;
                                var6_10.put(var15_17, var30_30);
                                var4_8.put((Object)var6_10);
                                var6_10 = var5_9.a;
                                var20_22 = (int)var3_7.containsKey(var6_10);
                                if (var20_22 == 0) ** GOTO lbl-1000
                                var20_22 = var5_9.b;
                                var7_11 = var5_9.a;
                                var7_11 = var3_7.get(var7_11);
                                var7_11 = (h$b)var7_11;
                                var30_30 = var7_11.b;
                                if (var20_22 == var30_30) {
                                    var20_22 = 0;
                                    var6_10 = null;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var20_22 = 1;
                                }
                                if (var20_22 == 0) continue;
                                if (var29_29 == null) {
                                    var29_29 = new JSONArray();
                                }
                                var6_10 = var29_29;
                                var7_11 = new JSONObject();
                                var8_12 = var5_9.a;
                                var7_11.put(var17_19, (Object)var8_12);
                                var23_25 = var5_9.b;
                                var7_11.put(var15_17, var23_25);
                                var29_29.put(var7_11);
                            }
                            var17_19 = var29_29;
                            break block33;
                        }
                        var22_24 = 0;
                        var4_8 = null;
                    }
                    var17_19 = null;
                }
                var16_18 = 0;
            }
            if (var17_19 == null) return;
            if (var4_8 == null) return;
            var1_1.a((boolean)var16_18, (JSONArray)var17_19, (JSONArray)var4_8);
            return;
        }
    }

    public void b() {
        Object object = this.c;
        if (object == null) {
            this.c = object = new i(this);
        }
        object = l.i();
        this.d = object;
    }

    public void c() {
        Handler handler;
        long l10 = System.currentTimeMillis();
        long l11 = this.g;
        long l12 = (l10 -= l11) - (l11 = 3600000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0 && (handler = this.c) != null) {
            int n10 = 1;
            handler.sendEmptyMessage(n10);
            this.g = l10 = System.currentTimeMillis();
        }
    }
}

