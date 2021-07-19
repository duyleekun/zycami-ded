/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.e.c;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.e.l;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$c
extends f {
    public final /* synthetic */ c a;
    private String b;
    private final String c;
    private String d;
    private c e;
    private boolean f;
    private int q;
    private long r;
    private long s;
    private long t;
    private long u;

    public c$c(c object, c c10, boolean bl2) {
        long l10;
        this.a = object;
        object = null;
        this.f = false;
        this.q = 0;
        this.r = l10 = (long)-1;
        this.s = l10;
        this.t = l10;
        this.u = l10;
        this.e = c10;
        object = bl2 ? "load" : "update";
        this.c = object;
        object = new HashMap();
        this.k = object;
        this.b = object = com.baidu.location.e.h.b;
    }

    public static /* synthetic */ long a(c$c c$c, long l10) {
        c$c.s = l10;
        return l10;
    }

    public static /* synthetic */ c a(c$c c$c) {
        return c$c.e;
    }

    public static /* synthetic */ void a(c$c c$c, String string2, String string3, String string4) {
        c$c.a(string2, string3, string4);
    }

    private void a(String object, String string2, String objectArray) {
        this.d = objectArray;
        objectArray = new Object[]{object, string2};
        object = String.format("http://%s/%s", objectArray);
        this.b = object;
        object = aa.a().c();
        this.a((ExecutorService)object, false, "ofloc.map.baidu.com");
    }

    public static /* synthetic */ boolean a(c$c c$c, boolean bl2) {
        c$c.f = bl2;
        return bl2;
    }

    public static /* synthetic */ void b(c$c c$c) {
        c$c.c();
    }

    private void c() {
        long l10;
        int n10;
        this.q = n10 = this.q + 1;
        this.r = l10 = System.currentTimeMillis();
    }

    private boolean d() {
        int n10 = this.q;
        boolean bl2 = true;
        int n11 = 2;
        if (n10 >= n11) {
            long l10 = this.r + 43200000L;
            long l11 = System.currentTimeMillis();
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 < 0) {
                long l13;
                this.q = 0;
                this.r = l13 = (long)-1;
            } else {
                bl2 = false;
            }
        }
        return bl2;
    }

    private void e() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        Object object;
        Object object2;
        block5: {
            block6: {
                block4: {
                    long l16;
                    long l17;
                    object2 = null;
                    this.d = null;
                    object = this.j();
                    l15 = 86400000L;
                    l14 = -1;
                    if (object == 0) break block4;
                    l13 = this.s;
                    long l18 = l13 - l14;
                    object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object != 0 && (object = (l17 = (l13 += l15) - (l16 = System.currentTimeMillis())) == 0L ? 0 : (l17 < 0L ? -1 : 1)) > 0) break block5;
                    object2 = this.f();
                    break block6;
                }
                object2 = this.g();
            }
            this.d = object2;
        }
        if ((object2 = this.d) == null && ((object = (l12 = (l13 = this.t) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0 || (object = (Object)((l11 = (l13 += l15) - (l10 = System.currentTimeMillis())) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0)) {
            object2 = com.baidu.location.e.c.a(this.a).k();
            object = ((l)object2).a();
            object2 = object != 0 ? this.h() : this.i();
            this.d = object2;
        }
        if ((object2 = this.d) != null) {
            object2 = aa.a().c();
            String string2 = "https://ofloc.map.baidu.com/offline_loc";
            if (object2 != null) {
                this.a((ExecutorService)object2, string2);
            } else {
                this.e(string2);
            }
        }
    }

    private String f() {
        String string2 = null;
        JSONObject jSONObject = new JSONObject();
        String string3 = "type";
        Object object = "0";
        jSONObject.put(string3, object);
        string3 = "cuid";
        object = com.baidu.location.h.b.a();
        object = ((b)object).c;
        jSONObject.put(string3, object);
        string3 = "ver";
        object = "1";
        jSONObject.put(string3, object);
        string3 = "prod";
        object = new StringBuilder();
        String string4 = com.baidu.location.h.b.f;
        ((StringBuilder)object).append(string4);
        string4 = ":";
        ((StringBuilder)object).append(string4);
        string4 = com.baidu.location.h.b.e;
        ((StringBuilder)object).append(string4);
        object = ((StringBuilder)object).toString();
        try {
            jSONObject.put(string3, object);
        }
        catch (Exception exception) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            string2 = Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
        }
        return string2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String g() {
        block91: {
            block92: {
                block93: {
                    block90: {
                        block89: {
                            block88: {
                                block86: {
                                    block87: {
                                        var1_1 = this;
                                        var2_2 = "1";
                                        var3_9 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
                                        var4_10 = "model";
                                        var5_11 = false;
                                        var6_12 = null;
                                        var7_13 = new JSONObject();
                                        var8_14 = new JSONObject();
                                        var9_15 = this.a;
                                        var9_15 = com.baidu.location.e.c.c(var9_15);
                                        var10_16 = 3;
                                        var11_18 /* !! */  = new Object[var10_16];
                                        var12_19 = "CL";
                                        var13_20 = 0;
                                        var11_18 /* !! */ [0] = var12_19;
                                        var14_21 = 5;
                                        var15_22 = var14_21;
                                        var16_23 = 1;
                                        var11_18 /* !! */ [var16_23] = var15_22;
                                        var17_24 = 50;
                                        var18_25 = var17_24;
                                        var19_26 = 2;
                                        var11_18 /* !! */ [var19_26] = var18_25;
                                        var11_18 /* !! */  = String.format(var3_9, var11_18 /* !! */ );
                                        var9_15 = var9_15.rawQuery((String)var11_18 /* !! */ , null);
                                        if (var9_15 == null) break block86;
                                        var20_27 = var9_15.moveToFirst();
                                        if (var20_27 == 0) break block86;
                                        var20_27 = var9_15.getCount();
                                        var18_25 = new JSONArray();
                                        var21_28 = var9_15.isAfterLast();
                                        if (var21_28) break block87;
                                        var6_12 = var9_15.getString(var16_23);
                                        var18_25.put(var6_12);
                                        var9_15.moveToNext();
                                    }
                                    var6_12 = "cell";
                                    try {
                                        var7_13.put((String)var6_12, var18_25);
                                        break block88;
                                    }
                                    catch (Throwable var2_3) {}
                                    catch (Exception v0) {
                                        var3_9 = null;
                                        return var3_9;
                                    }
                                    finally {
                                        var5_11 = false;
                                        var6_12 = null;
                                    }
                                    break block93;
                                }
                                var20_27 = 0;
                                var11_18 /* !! */  = null;
                            }
                            var6_12 = var1_1.a;
                            var6_12 = com.baidu.location.e.c.c((c)var6_12);
                            var22_30 = new Object[var10_16];
                            var18_25 = "AP";
                            var22_30[0] = var18_25;
                            var12_19 = var14_21;
                            var22_30[var16_23] = var12_19;
                            var12_19 = var17_24;
                            var22_30[var19_26] = var12_19;
                            var3_9 = String.format(var3_9, var22_30);
                            var10_16 = 0;
                            var22_30 = null;
                            var3_9 = var6_12.rawQuery(var3_9, null);
                            if (var3_9 == null) break block89;
                            var5_11 = var3_9.moveToFirst();
                            if (!var5_11) break block89;
                            var13_20 = var3_9.getCount();
                            var6_12 = new JSONArray();
                            ** while ((var14_21 = (int)var3_9.isAfterLast()) == 0)
lbl-1000:
                            // 1 sources

                            {
                                var12_19 = var3_9.getString(var16_23);
                                var6_12.put(var12_19);
                                var3_9.moveToNext();
                                continue;
                            }
lbl111:
                            // 1 sources

                            var12_19 = "ap";
                            var7_13.put((String)var12_19, var6_12);
                        }
                        var6_12 = "type";
                        var8_14.put((String)var6_12, (Object)var2_2);
                        var6_12 = "cuid";
                        var12_19 = com.baidu.location.h.b.a();
                        var12_19 = var12_19.c;
                        var8_14.put((String)var6_12, var12_19);
                        var6_12 = "ver";
                        var8_14.put((String)var6_12, (Object)var2_2);
                        var2_2 = "prod";
                        var6_12 = new StringBuilder();
                        var12_19 = com.baidu.location.h.b.f;
                        var6_12.append((String)var12_19);
                        var12_19 = ":";
                        var6_12.append((String)var12_19);
                        var12_19 = com.baidu.location.h.b.e;
                        var6_12.append((String)var12_19);
                        var6_12 = var6_12.toString();
                        var8_14.put(var2_2, var6_12);
                        if (var20_27 == 0 && var13_20 == 0) break block90;
                        try {
                            var8_14.put(var4_10, (Object)var7_13);
                        }
                        catch (Throwable var2_4) {
                            var6_12 = var3_9;
                        }
                    }
                    if (var3_9 != null) {
                        var3_9.close();
                    }
lbl159:
                    // 4 sources

                    while (true) {
                        if (var9_15 == null) break block91;
lbl161:
                        // 2 sources

                        while (true) {
                            var9_15.close();
                            break block91;
                            break;
                        }
                        break;
                    }
                    catch (Throwable var2_5) {
                    }
                    catch (Throwable var2_6) {
                        var10_16 = 0;
                        var22_30 = null;
                    }
                    var5_11 = false;
                    var6_12 = null;
                    break block93;
                    catch (Exception v1) {
                        var10_16 = 0;
                        var22_30 = null;
lbl179:
                        // 2 sources

                        while (true) {
                            var3_9 = null;
                            break;
                        }
                    }
                    {
                        catch (Exception v2) {
                            var10_16 = 0;
                            var22_31 = null;
                            var3_9 = null;
                            var9_15 = null;
                            break block92;
                        }
                    }
                    catch (Throwable var2_8) {
                        var10_16 = 0;
                        var22_32 = null;
                        var9_15 = null;
                    }
                }
                if (var6_12 != null) {
                    var6_12.close();
                }
lbl196:
                // 4 sources

                while (true) {
                    if (var9_15 != null) {
                        var9_15.close();
                    }
lbl200:
                    // 4 sources

                    throw var2_7;
                }
                {
                    catch (Exception v3) {
                        var10_17 = false;
                        var22_33 = null;
                        var3_9 = null;
                        var8_14 = null;
                        var9_15 = null;
                    }
                }
            }
lbl209:
            // 2 sources

            while (true) {
                if (var3_9 != null) {
                    var3_9.close();
                }
lbl213:
                // 4 sources

                while (true) {
                    if (var9_15 != null) {
                        ** continue;
                    }
                    break block91;
                    break;
                }
                break;
            }
            catch (Exception v4) {}
        }
        if (var8_14 != null && (var23_34 = var8_14.has(var4_10)) == 0 && ((var23_34 = (cfr_temp_0 = (var24_35 = var1_1.u) - (var26_36 = (long)-1)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == 0 || (var23_34 = (cfr_temp_1 = (var24_35 += 86400000L) - (var26_36 = System.currentTimeMillis())) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) < 0)) {
            var2_2 = var8_14.toString();
            var6_12 = Jni.encodeOfflineLocationUpdateRequest(var2_2);
            var1_1.u = var28_37 = System.currentTimeMillis();
        } else {
            var5_11 = false;
            var6_12 = null;
        }
        if (var8_14 != null && (var23_34 = var8_14.has(var4_10)) != 0) {
            var2_2 = var8_14.toString();
            var6_12 = Jni.encodeOfflineLocationUpdateRequest(var2_2);
        }
        return var6_12;
        catch (Exception v5) {
            ** continue;
        }
        catch (Exception v6) {
            ** continue;
        }
        catch (Exception v7) {
            ** continue;
        }
        catch (Exception v8) {
            ** continue;
        }
        catch (Exception v9) {
            ** continue;
        }
        catch (Exception v10) {
            ** continue;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String h() {
        JSONObject jSONObject;
        String string2;
        block4: {
            long l10;
            Object object;
            String string3;
            block5: {
                string2 = null;
                jSONObject = new JSONObject();
                string3 = "type";
                object = "2";
                try {}
                catch (Exception exception) {
                    break block4;
                }
                break block5;
                catch (Exception exception) {
                    jSONObject = null;
                }
                break block4;
            }
            jSONObject.put(string3, object);
            string3 = "ver";
            object = "1";
            jSONObject.put(string3, object);
            string3 = "cuid";
            object = com.baidu.location.h.b.a();
            object = ((b)object).c;
            jSONObject.put(string3, object);
            string3 = "prod";
            object = new StringBuilder();
            String string4 = com.baidu.location.h.b.f;
            ((StringBuilder)object).append(string4);
            string4 = ":";
            ((StringBuilder)object).append(string4);
            string4 = com.baidu.location.h.b.e;
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            jSONObject.put(string3, object);
            this.t = l10 = System.currentTimeMillis();
        }
        if (jSONObject == null) return string2;
        return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String i() {
        JSONObject jSONObject;
        String string2;
        block5: {
            block4: {
                Object object;
                String string3;
                Object object2;
                string2 = null;
                try {
                    object2 = this.a;
                    object2 = com.baidu.location.e.c.a((c)object2);
                    object2 = ((h)object2).k();
                    object2 = ((l)object2).b();
                    if (object2 == null) break block4;
                    jSONObject = new JSONObject();
                    string3 = "type";
                    object = "3";
                }
                catch (Exception exception) {}
                try {
                    long l10;
                    jSONObject.put(string3, object);
                    string3 = "ver";
                    object = "1";
                    jSONObject.put(string3, object);
                    string3 = "cuid";
                    object = com.baidu.location.h.b.a();
                    object = ((b)object).c;
                    jSONObject.put(string3, object);
                    string3 = "prod";
                    object = new StringBuilder();
                    String string4 = com.baidu.location.h.b.f;
                    ((StringBuilder)object).append(string4);
                    string4 = ":";
                    ((StringBuilder)object).append(string4);
                    string4 = com.baidu.location.h.b.e;
                    ((StringBuilder)object).append(string4);
                    object = ((StringBuilder)object).toString();
                    jSONObject.put(string3, object);
                    string3 = "rgc";
                    jSONObject.put(string3, object2);
                    this.t = l10 = System.currentTimeMillis();
                    break block5;
                }
                catch (Exception exception) {}
            }
            jSONObject = null;
        }
        if (jSONObject == null) return string2;
        return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean j() {
        Object object;
        boolean bl2;
        block22: {
            c c10;
            block21: {
                c c11;
                block18: {
                    block20: {
                        block19: {
                            int n10;
                            c11 = null;
                            bl2 = true;
                            object = this.a;
                            object = com.baidu.location.e.c.b((c)object);
                            Object object2 = "SELECT COUNT(*) FROM AP;";
                            object = object.rawQuery((String)object2, null);
                            object2 = this.a;
                            object2 = com.baidu.location.e.c.b((c)object2);
                            String string2 = "SELECT COUNT(*) FROM CL";
                            c11 = object2.rawQuery(string2, null);
                            object2 = null;
                            if (object != null && (n10 = object.moveToFirst()) != 0 && c11 != null && (n10 = c11.moveToFirst()) != 0 && ((n10 = object.getInt(0)) != 0 || (n10 = c11.getInt(0)) != 0)) {
                                bl2 = false;
                                Object var7_8 = null;
                            }
                            if (object == null) break block18;
                            try {
                                object.close();
                                break block18;
                            }
                            catch (Exception exception) {}
                            catch (Throwable throwable) {
                                c10 = c11;
                                c11 = object;
                                object = throwable;
                                break block19;
                            }
                            catch (Exception exception) {
                                c c12 = object;
                                object = c11;
                                c11 = c12;
                                break block20;
                            }
                            catch (Throwable throwable) {
                                bl2 = false;
                                c10 = null;
                            }
                        }
                        if (c11 == null) break block21;
                        c11.close();
                        break block21;
                        catch (Exception exception) {
                            object = null;
                        }
                    }
                    if (c11 == null) break block22;
                    c11.close();
                    break block22;
                }
                if (c11 == null) return bl2;
                try {
                    c11.close();
                    return bl2;
                }
                catch (Exception exception) {
                    return bl2;
                }
                catch (Exception exception) {}
            }
            if (c10 == null) throw object;
            try {
                c10.close();
            }
            catch (Exception exception) {
                throw object;
            }
            throw object;
            catch (Exception exception) {}
        }
        if (object == null) return bl2;
        object.close();
        return bl2;
    }

    public void a() {
        boolean bl2 = this.d();
        if (bl2 && !(bl2 = this.f)) {
            c$c c$c = com.baidu.location.e.c.d(this.a);
            c$c.e();
        }
    }

    public void a(boolean bl2) {
        Object object;
        if (bl2 && (object = this.j) != null) {
            object = new e(this);
            ((Thread)object).start();
        } else {
            bl2 = false;
            object = null;
            this.f = false;
            this.c();
        }
    }

    public void b() {
        this.f = true;
        Object object = this.b;
        this.h = object;
        this.k.clear();
        object = this.k;
        String string2 = this.c;
        object.put("qt", string2);
        object = this.k;
        string2 = this.d;
        object.put("req", string2);
    }
}

