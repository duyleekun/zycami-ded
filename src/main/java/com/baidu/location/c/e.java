/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.c;

import com.baidu.location.c.e$a;
import com.baidu.location.f;
import com.baidu.location.g.a;
import com.baidu.location.h.b;
import com.baidu.location.h.d;
import com.baidu.location.h.k;
import com.baidu.location.h.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Locale;
import org.json.JSONObject;

public class e {
    private static e i;
    private static final String m;
    private static int n;
    private static int o;
    private static int p;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    private e$a j = null;
    private String k = "https://loc.map.baidu.com/cfgs/loc/commcfgs";
    private long l = 604800L;

    static {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = com.baidu.location.h.k.a;
        stringBuilder.append(string2);
        stringBuilder.append("/conlts.dat");
        m = stringBuilder.toString();
        n = n10 = -1;
        o = n10;
        p = 0;
    }

    private e() {
        boolean bl2;
        this.a = bl2 = true;
        this.b = bl2;
        this.c = false;
        this.d = bl2;
        this.e = bl2;
        this.f = bl2;
        this.g = bl2;
        this.h = false;
    }

    public static e a() {
        e e10 = i;
        if (e10 == null) {
            i = e10 = new e();
        }
        return i;
    }

    private void a(int n10) {
        int n11 = n10 & 1;
        int n12 = 1;
        n11 = n11 == n12 ? n12 : 0;
        this.a = n11;
        n11 = n10 & 2;
        int n13 = 2;
        n11 = n11 == n13 ? n12 : 0;
        this.b = n11;
        n11 = n10 & 4;
        n13 = 4;
        n11 = n11 == n13 ? n12 : 0;
        this.c = n11;
        n11 = n10 & 8;
        n13 = 8;
        n11 = n11 == n13 ? n12 : 0;
        this.d = n11;
        n11 = 65536;
        n13 = n10 & n11;
        n11 = n13 == n11 ? n12 : 0;
        this.f = n11;
        n11 = 131072;
        n13 = n10 & n11;
        if (n13 != n11) {
            n12 = 0;
        }
        this.g = n12;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            this.e = false;
        }
    }

    public static /* synthetic */ void a(e e10) {
        e10.e();
    }

    public static /* synthetic */ void a(e e10, String string2) {
        e10.b(string2);
    }

    public static /* synthetic */ void a(e e10, byte[] byArray) {
        e10.a(byArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(JSONObject jSONObject) {
        int n10;
        int n11;
        boolean bl2;
        String string2;
        block17: {
            block16: {
                int n12;
                String string3;
                block15: {
                    string2 = "ipvn";
                    string3 = "ipvt";
                    String string4 = "ipen";
                    if (jSONObject == null) {
                        return;
                    }
                    bl2 = true;
                    n11 = 14400000;
                    n10 = 10;
                    try {
                        boolean bl3 = jSONObject.has(string4);
                        if (!bl3) break block15;
                    }
                    catch (Exception exception) {
                        return;
                    }
                    n12 = jSONObject.getInt(string4);
                    if (n12 != 0) break block15;
                    bl2 = false;
                }
                n12 = (int)(jSONObject.has(string3) ? 1 : 0);
                if (n12 == 0) break block16;
                n11 = jSONObject.getInt(string3);
            }
            boolean bl4 = jSONObject.has(string2);
            if (!bl4) break block17;
            n10 = jSONObject.getInt(string2);
        }
        jSONObject = com.baidu.location.f.getServiceContext();
        string2 = "MapCoreServicePre";
        jSONObject = jSONObject.getSharedPreferences(string2, 0);
        jSONObject = jSONObject.edit();
        string2 = "ipLocInfoUpload";
        jSONObject.putBoolean(string2, bl2);
        string2 = "ipValidTime";
        jSONObject.putInt(string2, n11);
        string2 = "ipLocInfoUploadTimesPerDay";
        jSONObject.putInt(string2, n10);
        jSONObject.commit();
    }

    /*
     * Unable to fully structure code
     */
    private void a(byte[] var1_1) {
        block34: {
            block33: {
                var2_2 = var1_1;
                var4_4 = 1;
                if (var1_1 == null) break block34;
                var5_5 = var1_1.length;
                var6_6 = 640;
                if (var5_5 >= var6_6) ** GOTO lbl20
                com.baidu.location.h.l.z = false;
                var7_7 = com.baidu.location.h.l.u;
                var9_8 = 4582862980812216730L;
                var11_10 = 0.025;
                var7_7 += var11_10;
                com.baidu.location.h.l.w = var7_7;
                var7_7 = com.baidu.location.h.l.t - var11_10;
                com.baidu.location.h.l.v = var7_7;
                break block33;
lbl20:
                // 1 sources

                com.baidu.location.h.l.z = var4_4;
                var5_5 = 7;
                var5_5 = var1_1[var5_5];
                var9_9 = var5_5;
                var13_12 = 255L;
                var9_9 &= var13_12;
                var15_13 = 56;
                var9_9 <<= var15_13;
                var16_14 = 6;
                var17_15 = (long)var1_1[var16_14] & var13_12;
                var19_16 = 48;
                var9_9 |= (var17_15 <<= var19_16);
                var16_14 = 5;
                var17_15 = (long)var1_1[var16_14] & var13_12;
                var20_17 = 40;
                var9_9 |= (var17_15 <<= var20_17);
                var16_14 = 4;
                var17_15 = (long)var1_1[var16_14] & var13_12;
                var21_18 = 32;
                var9_9 |= (var17_15 <<= var21_18);
                var16_14 = 3;
                var17_15 = (long)var1_1[var16_14] & var13_12;
                var22_19 = 24;
                var9_9 |= (var17_15 <<= var22_19);
                var16_14 = 2;
                var16_14 = var1_1[var16_14];
                var17_15 = (long)var16_14 & var13_12;
                var23_20 = 16;
                var9_9 |= (var17_15 <<= var23_20);
                var16_14 = var1_1[var4_4];
                var17_15 = (long)var16_14 & var13_12;
                var24_21 = 8;
                var9_9 |= (var17_15 <<= var24_21);
                var16_14 = var1_1[0];
                var17_15 = (long)var16_14 & var13_12;
                var9_9 |= var17_15;
                var11_11 = Double.longBitsToDouble(var9_9);
                com.baidu.location.h.l.v = var11_11;
                var5_5 = 15;
                var5_5 = var1_1[var5_5];
                var9_9 = ((long)var5_5 & var13_12) << var15_13;
                var15_13 = 14;
                var25_22 = ((long)var1_1[var15_13] & var13_12) << var19_16;
                var9_9 |= var25_22;
                var15_13 = 13;
                var25_22 = ((long)var1_1[var15_13] & var13_12) << var20_17;
                var9_9 |= var25_22;
                var15_13 = 12;
                var25_22 = ((long)var1_1[var15_13] & var13_12) << var21_18;
                var9_9 |= var25_22;
                var15_13 = 11;
                var25_22 = ((long)var1_1[var15_13] & var13_12) << var22_19;
                var9_9 |= var25_22;
                var15_13 = 10;
                var25_22 = ((long)var1_1[var15_13] & var13_12) << var23_20;
                var9_9 |= var25_22;
                var15_13 = 9;
                var15_13 = var1_1[var15_13];
                var25_22 = ((long)var15_13 & var13_12) << var24_21;
                var9_9 |= var25_22;
                var15_13 = var1_1[var24_21];
                var25_22 = var15_13;
                var9_9 |= (var13_12 &= var25_22);
                var11_11 = Double.longBitsToDouble(var9_9);
                com.baidu.location.h.l.w = var11_11;
                var5_5 = 625;
                var27_23 = new byte[var5_5];
                com.baidu.location.h.l.y = var27_23;
                for (var3_3 = 0; var3_3 < var5_5; ++var3_3) {
                    var27_23 = com.baidu.location.h.l.y;
                    var28_24 = var3_3 + 16;
                    var28_24 = var2_2[var28_24];
                    var27_23[var3_3] = var28_24;
                    continue;
                }
            }
            var3_3 = var4_4;
        }
        if (var3_3 == 0) ** GOTO lbl125
        try {
            this.g();
lbl125:
            // 3 sources

            return;
        }
        catch (Exception v0) {
            ** continue;
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(String var1_1) {
        block317: {
            block315: {
                block277: {
                    block316: {
                        block275: {
                            var2_2 = var1_1;
                            var3_3 = "shak";
                            var4_4 = "gpc";
                            var5_5 = "zxd";
                            var6_6 = "ab";
                            var7_7 = "wf";
                            var8_8 = "up";
                            var9_9 = "gps";
                            var10_10 = "is_check_Per";
                            var11_11 = "ipconf";
                            var12_12 = 1;
                            var13_13 = 0;
                            if (var1_1 == null) break block316;
                            var14_14 = new JSONObject((String)var1_1);
                            var15_15 = var14_14.has((String)var11_11);
                            if (var15_15 == 0) break block275;
                            try {
                                var2_2 = var14_14.getJSONObject((String)var11_11);
                                var11_11 = this;
                            }
                            catch (Exception v0) {}
                            try {
                                this.a((JSONObject)var2_2);
                            }
                            catch (Exception v2) {}
                        }
                        var11_11 = this;
lbl28:
                        // 2 sources

                        while (true) {
                            block276: {
                                var15_15 = var14_14.has((String)var10_10);
                                if (var15_15 == 0) break block276;
                                var15_15 = var14_14.getInt((String)var10_10);
                                if (var15_15 <= 0) break block276;
                                com.baidu.location.h.l.aA = var12_12;
                            }
lbl38:
                            // 2 sources

                            while (true) {
                                block312: {
                                    block314: {
                                        block313: {
                                            block306: {
                                                block311: {
                                                    block310: {
                                                        block309: {
                                                            block308: {
                                                                block307: {
                                                                    block301: {
                                                                        block305: {
                                                                            block304: {
                                                                                block303: {
                                                                                    block302: {
                                                                                        block297: {
                                                                                            block300: {
                                                                                                block299: {
                                                                                                    block298: {
                                                                                                        block293: {
                                                                                                            block296: {
                                                                                                                block295: {
                                                                                                                    block294: {
                                                                                                                        block289: {
                                                                                                                            block292: {
                                                                                                                                block291: {
                                                                                                                                    block290: {
                                                                                                                                        block278: {
                                                                                                                                            block288: {
                                                                                                                                                block287: {
                                                                                                                                                    block286: {
                                                                                                                                                        block285: {
                                                                                                                                                            block284: {
                                                                                                                                                                block283: {
                                                                                                                                                                    block282: {
                                                                                                                                                                        block281: {
                                                                                                                                                                            block280: {
                                                                                                                                                                                block279: {
                                                                                                                                                                                    var2_2 = "ver";
                                                                                                                                                                                    var2_2 = var14_14.getString((String)var2_2);
                                                                                                                                                                                    var15_15 = Integer.parseInt((String)var2_2);
                                                                                                                                                                                    var16_16 = com.baidu.location.h.l.A;
                                                                                                                                                                                    if (var15_15 <= var16_16) break block277;
                                                                                                                                                                                    com.baidu.location.h.l.A = var15_15;
                                                                                                                                                                                    var15_15 = (int)var14_14.has((String)var9_9);
                                                                                                                                                                                    var17_17 = "\\|";
                                                                                                                                                                                    var16_16 = 2;
                                                                                                                                                                                    var18_18 = "";
                                                                                                                                                                                    if (var15_15 == 0) break block278;
                                                                                                                                                                                    var2_2 = var14_14.getString((String)var9_9);
                                                                                                                                                                                    var2_2 = var2_2.split(var17_17);
                                                                                                                                                                                    var19_19 = ((String[])var2_2).length;
                                                                                                                                                                                    var20_20 = 10;
                                                                                                                                                                                    if (var19_19 <= var20_20) break block278;
                                                                                                                                                                                    var9_9 = var2_2[0];
                                                                                                                                                                                    if (var9_9 == null) break block279;
                                                                                                                                                                                    var9_9 = var2_2[0];
                                                                                                                                                                                    var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                                                                                    if (var19_19 != 0) break block279;
                                                                                                                                                                                    var9_9 = var2_2[0];
                                                                                                                                                                                    var21_21 = Float.parseFloat((String)var9_9);
                                                                                                                                                                                    com.baidu.location.h.l.B = var21_21;
                                                                                                                                                                                }
                                                                                                                                                                                var9_9 = var2_2[var12_12];
                                                                                                                                                                                if (var9_9 == null) break block280;
                                                                                                                                                                                var9_9 = var2_2[var12_12];
                                                                                                                                                                                var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                                                                                if (var19_19 != 0) break block280;
                                                                                                                                                                                var9_9 = var2_2[var12_12];
                                                                                                                                                                                var21_21 = Float.parseFloat((String)var9_9);
                                                                                                                                                                                com.baidu.location.h.l.C = var21_21;
                                                                                                                                                                            }
                                                                                                                                                                            var9_9 = var2_2[var16_16];
                                                                                                                                                                            if (var9_9 == null) break block281;
                                                                                                                                                                            var9_9 = var2_2[var16_16];
                                                                                                                                                                            var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                                                                            if (var19_19 != 0) break block281;
                                                                                                                                                                            var9_9 = var2_2[var16_16];
                                                                                                                                                                            var21_21 = Float.parseFloat((String)var9_9);
                                                                                                                                                                            com.baidu.location.h.l.D = var21_21;
                                                                                                                                                                        }
                                                                                                                                                                        var19_19 = 3;
                                                                                                                                                                        var21_21 = 4.2E-45f;
                                                                                                                                                                        var22_22 = var2_2[var19_19];
                                                                                                                                                                        if (var22_22 == null) break block282;
                                                                                                                                                                        var10_10 = var2_2[var19_19];
                                                                                                                                                                        var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                                        if (var16_16 != 0) break block282;
                                                                                                                                                                        var10_10 = var2_2[var19_19];
                                                                                                                                                                        var21_21 = Float.parseFloat((String)var10_10);
                                                                                                                                                                        com.baidu.location.h.l.E = var21_21;
                                                                                                                                                                    }
                                                                                                                                                                    var19_19 = 4;
                                                                                                                                                                    var21_21 = 5.6E-45f;
                                                                                                                                                                    var10_10 = var2_2[var19_19];
                                                                                                                                                                    if (var10_10 == null) break block283;
                                                                                                                                                                    var10_10 = var2_2[var19_19];
                                                                                                                                                                    var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                                    if (var16_16 != 0) break block283;
                                                                                                                                                                    var10_10 = var2_2[var19_19];
                                                                                                                                                                    var19_19 = Integer.parseInt((String)var10_10);
                                                                                                                                                                    com.baidu.location.h.l.F = var19_19;
                                                                                                                                                                }
                                                                                                                                                                var19_19 = 5;
                                                                                                                                                                var21_21 = 7.0E-45f;
                                                                                                                                                                var10_10 = var2_2[var19_19];
                                                                                                                                                                if (var10_10 == null) break block284;
                                                                                                                                                                var10_10 = var2_2[var19_19];
                                                                                                                                                                var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                                if (var16_16 != 0) break block284;
                                                                                                                                                                var10_10 = var2_2[var19_19];
                                                                                                                                                                var19_19 = Integer.parseInt((String)var10_10);
                                                                                                                                                                com.baidu.location.h.l.G = var19_19;
                                                                                                                                                            }
                                                                                                                                                            var19_19 = 6;
                                                                                                                                                            var21_21 = 8.4E-45f;
                                                                                                                                                            var10_10 = var2_2[var19_19];
                                                                                                                                                            if (var10_10 == null) break block285;
                                                                                                                                                            var10_10 = var2_2[var19_19];
                                                                                                                                                            var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                            if (var16_16 != 0) break block285;
                                                                                                                                                            var9_9 = var2_2[var19_19];
                                                                                                                                                            var19_19 = Integer.parseInt((String)var9_9);
                                                                                                                                                            com.baidu.location.h.l.H = var19_19;
                                                                                                                                                        }
                                                                                                                                                        var19_19 = 7;
                                                                                                                                                        var21_21 = 9.8E-45f;
                                                                                                                                                        var10_10 = var2_2[var19_19];
                                                                                                                                                        if (var10_10 == null) break block286;
                                                                                                                                                        var10_10 = var2_2[var19_19];
                                                                                                                                                        var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                        if (var16_16 != 0) break block286;
                                                                                                                                                        var9_9 = var2_2[var19_19];
                                                                                                                                                        var19_19 = Integer.parseInt((String)var9_9);
                                                                                                                                                        com.baidu.location.h.l.I = var19_19;
                                                                                                                                                    }
                                                                                                                                                    var19_19 = 8;
                                                                                                                                                    var21_21 = 1.1E-44f;
                                                                                                                                                    var10_10 = var2_2[var19_19];
                                                                                                                                                    if (var10_10 == null) break block287;
                                                                                                                                                    var10_10 = var2_2[var19_19];
                                                                                                                                                    var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                    if (var16_16 != 0) break block287;
                                                                                                                                                    var9_9 = var2_2[var19_19];
                                                                                                                                                    var19_19 = Integer.parseInt((String)var9_9);
                                                                                                                                                    com.baidu.location.h.l.J = var19_19;
                                                                                                                                                }
                                                                                                                                                var19_19 = 9;
                                                                                                                                                var21_21 = 1.3E-44f;
                                                                                                                                                var10_10 = var2_2[var19_19];
                                                                                                                                                if (var10_10 == null) break block288;
                                                                                                                                                var10_10 = var2_2[var19_19];
                                                                                                                                                var16_16 = (int)var10_10.equals(var18_18);
                                                                                                                                                if (var16_16 != 0) break block288;
                                                                                                                                                var9_9 = var2_2[var19_19];
                                                                                                                                                var19_19 = Integer.parseInt((String)var9_9);
                                                                                                                                                com.baidu.location.h.l.K = var19_19;
                                                                                                                                            }
                                                                                                                                            var9_9 = var2_2[var20_20];
                                                                                                                                            if (var9_9 == null) break block278;
                                                                                                                                            var9_9 = var2_2[var20_20];
                                                                                                                                            var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                                            if (var19_19 != 0) break block278;
                                                                                                                                            var2_2 = var2_2[var20_20];
                                                                                                                                            var15_15 = Integer.parseInt((String)var2_2);
                                                                                                                                            com.baidu.location.h.l.L = var15_15;
                                                                                                                                        }
                                                                                                                                        var15_15 = (int)var14_14.has((String)var8_8);
                                                                                                                                        if (var15_15 == 0) break block289;
                                                                                                                                        var2_2 = var14_14.getString((String)var8_8);
                                                                                                                                        var2_2 = var2_2.split(var17_17);
                                                                                                                                        var23_23 = ((Object)var2_2).length;
                                                                                                                                        var19_19 = 3;
                                                                                                                                        var21_21 = 4.2E-45f;
                                                                                                                                        if (var23_23 <= var19_19) break block289;
                                                                                                                                        var8_8 = var2_2[0];
                                                                                                                                        if (var8_8 == null) break block290;
                                                                                                                                        var8_8 = var2_2[0];
                                                                                                                                        var23_23 = (int)var8_8.equals(var18_18);
                                                                                                                                        if (var23_23 != 0) break block290;
                                                                                                                                        var8_8 = var2_2[0];
                                                                                                                                        var24_24 = Float.parseFloat((String)var8_8);
                                                                                                                                        com.baidu.location.h.l.M = var24_24;
                                                                                                                                    }
                                                                                                                                    var8_8 = var2_2[var12_12];
                                                                                                                                    if (var8_8 == null) break block291;
                                                                                                                                    var8_8 = var2_2[var12_12];
                                                                                                                                    var23_23 = (int)var8_8.equals(var18_18);
                                                                                                                                    if (var23_23 != 0) break block291;
                                                                                                                                    var8_8 = var2_2[var12_12];
                                                                                                                                    var24_24 = Float.parseFloat((String)var8_8);
                                                                                                                                    com.baidu.location.h.l.N = var24_24;
                                                                                                                                }
                                                                                                                                var23_23 = 2;
                                                                                                                                var24_24 = 2.8E-45f;
                                                                                                                                var9_9 = var2_2[var23_23];
                                                                                                                                if (var9_9 == null) break block292;
                                                                                                                                var9_9 = var2_2[var23_23];
                                                                                                                                var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                                if (var19_19 != 0) break block292;
                                                                                                                                var9_9 = var2_2[var23_23];
                                                                                                                                var24_24 = Float.parseFloat((String)var9_9);
                                                                                                                                com.baidu.location.h.l.O = var24_24;
                                                                                                                            }
                                                                                                                            var23_23 = 3;
                                                                                                                            var24_24 = 4.2E-45f;
                                                                                                                            var9_9 = var2_2[var23_23];
                                                                                                                            if (var9_9 == null) break block289;
                                                                                                                            var9_9 = var2_2[var23_23];
                                                                                                                            var19_19 = (int)var9_9.equals(var18_18);
                                                                                                                            if (var19_19 != 0) break block289;
                                                                                                                            var2_2 = var2_2[var23_23];
                                                                                                                            var25_25 = Float.parseFloat((String)var2_2);
                                                                                                                            com.baidu.location.h.l.P = var25_25;
                                                                                                                        }
                                                                                                                        var15_15 = (int)var14_14.has((String)var7_7);
                                                                                                                        if (var15_15 == 0) break block293;
                                                                                                                        var2_2 = var14_14.getString((String)var7_7);
                                                                                                                        var2_2 = var2_2.split(var17_17);
                                                                                                                        var26_26 = ((Object)var2_2).length;
                                                                                                                        var23_23 = 3;
                                                                                                                        var24_24 = 4.2E-45f;
                                                                                                                        if (var26_26 <= var23_23) break block293;
                                                                                                                        var7_7 = var2_2[0];
                                                                                                                        if (var7_7 == null) break block294;
                                                                                                                        var7_7 = var2_2[0];
                                                                                                                        var26_26 = (int)var7_7.equals(var18_18);
                                                                                                                        if (var26_26 != 0) break block294;
                                                                                                                        var7_7 = var2_2[0];
                                                                                                                        var26_26 = Integer.parseInt((String)var7_7);
                                                                                                                        com.baidu.location.h.l.Q = var26_26;
                                                                                                                    }
                                                                                                                    var7_7 = var2_2[var12_12];
                                                                                                                    if (var7_7 == null) break block295;
                                                                                                                    var7_7 = var2_2[var12_12];
                                                                                                                    var26_26 = (int)var7_7.equals(var18_18);
                                                                                                                    if (var26_26 != 0) break block295;
                                                                                                                    var7_7 = var2_2[var12_12];
                                                                                                                    var27_27 = Float.parseFloat((String)var7_7);
                                                                                                                    com.baidu.location.h.l.S = var27_27;
                                                                                                                }
                                                                                                                var26_26 = 2;
                                                                                                                var27_27 = 2.8E-45f;
                                                                                                                var8_8 = var2_2[var26_26];
                                                                                                                if (var8_8 == null) break block296;
                                                                                                                var8_8 = var2_2[var26_26];
                                                                                                                var23_23 = (int)var8_8.equals(var18_18);
                                                                                                                if (var23_23 != 0) break block296;
                                                                                                                var8_8 = var2_2[var26_26];
                                                                                                                var26_26 = Integer.parseInt((String)var8_8);
                                                                                                                com.baidu.location.h.l.T = var26_26;
                                                                                                            }
                                                                                                            var26_26 = 3;
                                                                                                            var27_27 = 4.2E-45f;
                                                                                                            var8_8 = var2_2[var26_26];
                                                                                                            if (var8_8 == null) break block293;
                                                                                                            var8_8 = var2_2[var26_26];
                                                                                                            var23_23 = (int)var8_8.equals(var18_18);
                                                                                                            if (var23_23 != 0) break block293;
                                                                                                            var2_2 = var2_2[var26_26];
                                                                                                            var25_25 = Float.parseFloat((String)var2_2);
                                                                                                            com.baidu.location.h.l.U = var25_25;
                                                                                                        }
                                                                                                        var15_15 = (int)var14_14.has((String)var6_6);
                                                                                                        if (var15_15 == 0) break block297;
                                                                                                        var2_2 = var14_14.getString((String)var6_6);
                                                                                                        var2_2 = var2_2.split(var17_17);
                                                                                                        var28_28 = ((Object)var2_2).length;
                                                                                                        var26_26 = 3;
                                                                                                        var27_27 = 4.2E-45f;
                                                                                                        if (var28_28 <= var26_26) break block297;
                                                                                                        var6_6 = var2_2[0];
                                                                                                        if (var6_6 == null) break block298;
                                                                                                        var6_6 = var2_2[0];
                                                                                                        var28_28 = (int)var6_6.equals(var18_18);
                                                                                                        if (var28_28 != 0) break block298;
                                                                                                        var6_6 = var2_2[0];
                                                                                                        var29_29 = Float.parseFloat((String)var6_6);
                                                                                                        com.baidu.location.h.l.V = var29_29;
                                                                                                    }
                                                                                                    var6_6 = var2_2[var12_12];
                                                                                                    if (var6_6 == null) break block299;
                                                                                                    var6_6 = var2_2[var12_12];
                                                                                                    var28_28 = (int)var6_6.equals(var18_18);
                                                                                                    if (var28_28 != 0) break block299;
                                                                                                    var6_6 = var2_2[var12_12];
                                                                                                    var29_29 = Float.parseFloat((String)var6_6);
                                                                                                    com.baidu.location.h.l.W = var29_29;
                                                                                                }
                                                                                                var28_28 = 2;
                                                                                                var29_29 = 2.8E-45f;
                                                                                                var7_7 = var2_2[var28_28];
                                                                                                if (var7_7 == null) break block300;
                                                                                                var7_7 = var2_2[var28_28];
                                                                                                var26_26 = (int)var7_7.equals(var18_18);
                                                                                                if (var26_26 != 0) break block300;
                                                                                                var7_7 = var2_2[var28_28];
                                                                                                var28_28 = Integer.parseInt((String)var7_7);
                                                                                                com.baidu.location.h.l.X = var28_28;
                                                                                            }
                                                                                            var28_28 = 3;
                                                                                            var29_29 = 4.2E-45f;
                                                                                            var7_7 = var2_2[var28_28];
                                                                                            if (var7_7 == null) break block297;
                                                                                            var7_7 = var2_2[var28_28];
                                                                                            var26_26 = (int)var7_7.equals(var18_18);
                                                                                            if (var26_26 != 0) break block297;
                                                                                            var2_2 = var2_2[var28_28];
                                                                                            var15_15 = Integer.parseInt((String)var2_2);
                                                                                            com.baidu.location.h.l.Y = var15_15;
                                                                                        }
                                                                                        var15_15 = (int)var14_14.has((String)var5_5);
                                                                                        if (var15_15 == 0) break block301;
                                                                                        var2_2 = var14_14.getString((String)var5_5);
                                                                                        var2_2 = var2_2.split(var17_17);
                                                                                        var30_30 = ((Object)var2_2).length;
                                                                                        var28_28 = 4;
                                                                                        var29_29 = 5.6E-45f;
                                                                                        if (var30_30 <= var28_28) break block301;
                                                                                        var5_5 = var2_2[0];
                                                                                        if (var5_5 == null) break block302;
                                                                                        var5_5 = var2_2[0];
                                                                                        var30_30 = (int)var5_5.equals(var18_18);
                                                                                        if (var30_30 != 0) break block302;
                                                                                        var5_5 = var2_2[0];
                                                                                        var31_31 = Float.parseFloat((String)var5_5);
                                                                                        com.baidu.location.h.l.au = var31_31;
                                                                                    }
                                                                                    var5_5 = var2_2[var12_12];
                                                                                    if (var5_5 == null) break block303;
                                                                                    var5_5 = var2_2[var12_12];
                                                                                    var30_30 = (int)var5_5.equals(var18_18);
                                                                                    if (var30_30 != 0) break block303;
                                                                                    var5_5 = var2_2[var12_12];
                                                                                    var31_31 = Float.parseFloat((String)var5_5);
                                                                                    com.baidu.location.h.l.av = var31_31;
                                                                                }
                                                                                var30_30 = 2;
                                                                                var31_31 = 2.8E-45f;
                                                                                var6_6 = var2_2[var30_30];
                                                                                if (var6_6 == null) break block304;
                                                                                var6_6 = var2_2[var30_30];
                                                                                var28_28 = (int)var6_6.equals(var18_18);
                                                                                if (var28_28 != 0) break block304;
                                                                                var6_6 = var2_2[var30_30];
                                                                                var30_30 = Integer.parseInt((String)var6_6);
                                                                                com.baidu.location.h.l.aw = var30_30;
                                                                            }
                                                                            var30_30 = 3;
                                                                            var31_31 = 4.2E-45f;
                                                                            var6_6 = var2_2[var30_30];
                                                                            if (var6_6 == null) break block305;
                                                                            var6_6 = var2_2[var30_30];
                                                                            var28_28 = (int)var6_6.equals(var18_18);
                                                                            if (var28_28 != 0) break block305;
                                                                            var6_6 = var2_2[var30_30];
                                                                            var30_30 = Integer.parseInt((String)var6_6);
                                                                            com.baidu.location.h.l.ax = var30_30;
                                                                        }
                                                                        var30_30 = 4;
                                                                        var31_31 = 5.6E-45f;
                                                                        var6_6 = var2_2[var30_30];
                                                                        if (var6_6 == null) break block301;
                                                                        var6_6 = var2_2[var30_30];
                                                                        var28_28 = (int)var6_6.equals(var18_18);
                                                                        if (var28_28 != 0) break block301;
                                                                        var2_2 = var2_2[var30_30];
                                                                        var15_15 = Integer.parseInt((String)var2_2);
                                                                        com.baidu.location.h.l.ay = var15_15;
                                                                    }
                                                                    var15_15 = (int)var14_14.has((String)var4_4);
                                                                    if (var15_15 == 0) break block306;
                                                                    var2_2 = var14_14.getString((String)var4_4);
                                                                    var2_2 = var2_2.split(var17_17);
                                                                    var32_32 = ((Object)var2_2).length;
                                                                    var30_30 = 5;
                                                                    var31_31 = 7.0E-45f;
                                                                    if (var32_32 <= var30_30) break block306;
                                                                    var4_4 = var2_2[0];
                                                                    if (var4_4 == null) break block307;
                                                                    var4_4 = var2_2[0];
                                                                    var32_32 = (int)var4_4.equals(var18_18);
                                                                    if (var32_32 != 0) break block307;
                                                                    var4_4 = var2_2[0];
                                                                    var32_32 = Integer.parseInt((String)var4_4);
                                                                    if (var32_32 <= 0) ** GOTO lbl591
                                                                    com.baidu.location.h.l.ad = var12_12;
                                                                    break block307;
lbl591:
                                                                    // 1 sources

                                                                    com.baidu.location.h.l.ad = false;
                                                                }
                                                                var4_4 = var2_2[var12_12];
                                                                if (var4_4 == null) break block308;
                                                                var4_4 = var2_2[var12_12];
                                                                var32_32 = (int)var4_4.equals(var18_18);
                                                                if (var32_32 != 0) break block308;
                                                                var4_4 = var2_2[var12_12];
                                                                var32_32 = Integer.parseInt((String)var4_4);
                                                                if (var32_32 <= 0) ** GOTO lbl609
                                                                com.baidu.location.h.l.ae = var12_12;
                                                                break block308;
lbl609:
                                                                // 1 sources

                                                                com.baidu.location.h.l.ae = false;
                                                            }
                                                            var32_32 = 2;
                                                            var5_5 = var2_2[var32_32];
                                                            if (var5_5 == null) break block309;
                                                            var5_5 = var2_2[var32_32];
                                                            var30_30 = (int)var5_5.equals(var18_18);
                                                            if (var30_30 != 0) break block309;
                                                            var5_5 = var2_2[var32_32];
                                                            var32_32 = Integer.parseInt((String)var5_5);
                                                            com.baidu.location.h.l.af = var32_32;
                                                        }
                                                        var32_32 = 3;
                                                        var5_5 = var2_2[var32_32];
                                                        if (var5_5 == null) break block310;
                                                        var5_5 = var2_2[var32_32];
                                                        var30_30 = (int)var5_5.equals(var18_18);
                                                        if (var30_30 != 0) break block310;
                                                        var4_4 = var2_2[var32_32];
                                                        var32_32 = Integer.parseInt((String)var4_4);
                                                        com.baidu.location.h.l.ah = var32_32;
                                                    }
                                                    var32_32 = 4;
                                                    var5_5 = var2_2[var32_32];
                                                    if (var5_5 == null) break block311;
                                                    var5_5 = var2_2[var32_32];
                                                    var30_30 = (int)var5_5.equals(var18_18);
                                                    if (var30_30 != 0) break block311;
                                                    var4_4 = var2_2[var32_32];
                                                    var32_32 = Integer.parseInt((String)var4_4);
                                                    if (var32_32 <= 0) ** GOTO lbl671
                                                    var33_33 = var32_32;
                                                    com.baidu.location.h.l.an = var33_33;
                                                    var33_33 *= 1000L;
                                                    var35_34 = 60;
                                                    var33_33 *= var35_34;
                                                    com.baidu.location.h.l.aj = var33_33;
                                                    var28_28 = 2;
                                                    var29_29 = 2.8E-45f;
                                                    var33_33 >>= var28_28;
                                                    com.baidu.location.h.l.ao = var33_33;
                                                    break block311;
lbl671:
                                                    // 1 sources

                                                    com.baidu.location.h.l.r = false;
                                                }
                                                var32_32 = 5;
                                                var5_5 = var2_2[var32_32];
                                                if (var5_5 == null) break block306;
                                                var5_5 = var2_2[var32_32];
                                                var30_30 = (int)var5_5.equals(var18_18);
                                                if (var30_30 != 0) break block306;
                                                var2_2 = var2_2[var32_32];
                                                var15_15 = Integer.parseInt((String)var2_2);
                                                com.baidu.location.h.l.aq = var15_15;
                                            }
                                            var15_15 = (int)var14_14.has((String)var3_3);
                                            if (var15_15 == 0) break block312;
                                            var2_2 = var14_14.getString((String)var3_3);
                                            var2_2 = var2_2.split(var17_17);
                                            var37_35 = ((Object)var2_2).length;
                                            var32_32 = 2;
                                            if (var37_35 <= var32_32) break block312;
                                            var3_3 = var2_2[0];
                                            if (var3_3 == null) break block313;
                                            var3_3 = var2_2[0];
                                            var37_35 = (int)var3_3.equals(var18_18);
                                            if (var37_35 != 0) break block313;
                                            var3_3 = var2_2[0];
                                            var37_35 = Integer.parseInt((String)var3_3);
                                            com.baidu.location.h.l.ar = var37_35;
                                        }
                                        var3_3 = var2_2[var12_12];
                                        if (var3_3 == null) break block314;
                                        var3_3 = var2_2[var12_12];
                                        var37_35 = (int)var3_3.equals(var18_18);
                                        if (var37_35 != 0) break block314;
                                        var3_3 = var2_2[var12_12];
                                        var37_35 = Integer.parseInt((String)var3_3);
                                        com.baidu.location.h.l.as = var37_35;
                                    }
                                    var37_35 = 2;
                                    var4_4 = var2_2[var37_35];
                                    if (var4_4 == null) break block312;
                                    var4_4 = var2_2[var37_35];
                                    var32_32 = (int)var4_4.equals(var18_18);
                                    if (var32_32 != 0) break block312;
                                    var2_2 = var2_2[var37_35];
                                    var25_25 = Float.parseFloat((String)var2_2);
                                    com.baidu.location.h.l.at = var25_25;
                                }
                                var2_2 = "dmx";
                                var15_15 = (int)var14_14.has((String)var2_2);
                                if (var15_15 == 0) break block315;
                                var2_2 = "dmx";
                                var15_15 = var14_14.getInt((String)var2_2);
                                com.baidu.location.h.l.ap = var15_15;
                                break block315;
                                break;
                            }
                            break;
                        }
                        catch (Exception v1) {
                            var11_11 = this;
                        }
                        break block317;
                    }
                    var11_11 = this;
                }
                var12_12 = 0;
            }
            var13_13 = var12_12;
        }
lbl766:
        // 2 sources

        return (boolean)var13_13;
        ** while (true)
        catch (Exception v3) {
            ** continue;
        }
        catch (Exception v4) {
            ** continue;
        }
    }

    public static /* synthetic */ String b(e e10) {
        return e10.k;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(int n10) {
        int n11;
        int n12;
        int n13;
        Object object = m;
        Object object2 = new File((String)object);
        boolean bl2 = ((File)object2).exists();
        if (!bl2) {
            this.i();
        }
        try {
            String string2 = "rw";
            object = new RandomAccessFile((File)object2, string2);
            long l10 = 4;
            ((RandomAccessFile)object).seek(l10);
            n13 = ((RandomAccessFile)object).readInt();
            n12 = ((RandomAccessFile)object).readInt();
            n11 = p;
            n13 = n13 * n11 + 128;
        }
        catch (Exception exception) {
            return;
        }
        long l11 = n13;
        {
            ((RandomAccessFile)object).seek(l11);
            object2 = new StringBuilder();
            String string3 = com.baidu.location.h.b.e;
            ((StringBuilder)object2).append(string3);
            n11 = 0;
            string3 = null;
            ((StringBuilder)object2).append('\u0000');
            object2 = ((StringBuilder)object2).toString();
            object2 = ((String)object2).getBytes();
            int n14 = ((Object)object2).length;
            ((RandomAccessFile)object).writeInt(n14);
            n14 = ((Object)object2).length;
            ((RandomAccessFile)object).write((byte[])object2, 0, n14);
            ((RandomAccessFile)object).writeInt(n10);
            n10 = p;
            if (n12 == n10) {
                l11 = 8;
                ((RandomAccessFile)object).seek(l11);
                ((RandomAccessFile)object).writeInt(++n12);
            }
            ((RandomAccessFile)object).close();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(String string2) {
        int n10;
        int n11;
        String string3 = "ctr";
        o = n11 = -1;
        if (string2 == null) return;
        try {
            boolean bl2 = this.a(string2);
            if (bl2) {
                this.f();
            }
        }
        catch (Exception exception) {}
        try {
            JSONObject jSONObject = new JSONObject(string2);
            n10 = (int)(jSONObject.has(string3) ? 1 : 0);
            if (n10 != 0) {
                string2 = jSONObject.getString(string3);
                o = n10 = Integer.parseInt(string2);
            }
        }
        catch (Exception exception) {}
        try {
            this.j();
            n10 = o;
            if (n10 != n11) {
                this.b(n10);
            } else {
                n10 = n;
                if (n10 == n11) {
                    n10 = n11;
                }
            }
            if (n10 == n11) return;
            this.a(n10);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void e() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("&ver=");
        int n10 = com.baidu.location.h.l.A;
        charSequence.append(n10);
        charSequence.append("&usr=");
        Object object = com.baidu.location.h.b.a().b();
        charSequence.append((String)object);
        charSequence.append("&app=");
        object = com.baidu.location.h.b.e;
        charSequence.append((String)object);
        charSequence.append("&prod=");
        object = com.baidu.location.h.b.f;
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = this.j;
        if (object == null) {
            this.j = object = new e$a(this);
        }
        if ((n10 = (int)(com.baidu.location.h.l.b() ? 1 : 0)) == 0) {
            object = this.j;
            ((e$a)object).a((String)charSequence, false);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        Object object;
        Object object2;
        Object object3 = new StringBuilder();
        Object object4 = com.baidu.location.h.k.a;
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("/config.dat");
        object3 = ((StringBuilder)object3).toString();
        int n10 = com.baidu.location.h.l.ad;
        int n11 = com.baidu.location.h.l.ae;
        Locale locale = Locale.CHINA;
        int n12 = 39;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object2 = Integer.valueOf(com.baidu.location.h.l.A);
        object2 = Float.valueOf(com.baidu.location.h.l.B);
        boolean bl2 = true;
        objectArray[bl2] = object2;
        objectArray[2] = object = Float.valueOf(com.baidu.location.h.l.C);
        objectArray[3] = object = Float.valueOf(com.baidu.location.h.l.D);
        objectArray[4] = object = Float.valueOf(com.baidu.location.h.l.E);
        objectArray[5] = object = Integer.valueOf(com.baidu.location.h.l.F);
        objectArray[6] = object = Integer.valueOf(com.baidu.location.h.l.G);
        objectArray[7] = object = Integer.valueOf(com.baidu.location.h.l.H);
        objectArray[8] = object = Integer.valueOf(com.baidu.location.h.l.I);
        objectArray[9] = object = Integer.valueOf(com.baidu.location.h.l.J);
        objectArray[10] = object = Integer.valueOf(com.baidu.location.h.l.K);
        objectArray[11] = object = Integer.valueOf(com.baidu.location.h.l.L);
        objectArray[12] = object = Float.valueOf(com.baidu.location.h.l.M);
        objectArray[13] = object = Float.valueOf(com.baidu.location.h.l.N);
        objectArray[14] = object = Float.valueOf(com.baidu.location.h.l.O);
        objectArray[15] = object = Float.valueOf(com.baidu.location.h.l.P);
        objectArray[16] = object = Integer.valueOf(com.baidu.location.h.l.Q);
        objectArray[17] = object = Float.valueOf(com.baidu.location.h.l.S);
        objectArray[18] = object = Integer.valueOf(com.baidu.location.h.l.T);
        objectArray[19] = object = Float.valueOf(com.baidu.location.h.l.U);
        objectArray[20] = object = Float.valueOf(com.baidu.location.h.l.V);
        float f10 = com.baidu.location.h.l.W;
        objectArray[21] = object = Float.valueOf(f10);
        objectArray[22] = object = Integer.valueOf(com.baidu.location.h.l.X);
        int n13 = com.baidu.location.h.l.Y;
        objectArray[23] = object = Integer.valueOf(n13);
        int n14 = 24;
        objectArray[n14] = object4 = Integer.valueOf(n10);
        Comparable<Integer> comparable = n11;
        objectArray[25] = comparable;
        comparable = com.baidu.location.h.l.af;
        objectArray[26] = comparable;
        comparable = com.baidu.location.h.l.ah;
        objectArray[27] = comparable;
        long l10 = com.baidu.location.h.l.an;
        comparable = l10;
        objectArray[28] = comparable;
        comparable = com.baidu.location.h.l.aq;
        objectArray[29] = comparable;
        comparable = Float.valueOf(com.baidu.location.h.l.au);
        objectArray[30] = comparable;
        comparable = Float.valueOf(com.baidu.location.h.l.av);
        objectArray[31] = comparable;
        comparable = com.baidu.location.h.l.aw;
        objectArray[32] = comparable;
        comparable = com.baidu.location.h.l.ax;
        objectArray[33] = comparable;
        comparable = com.baidu.location.h.l.ay;
        objectArray[34] = comparable;
        comparable = com.baidu.location.h.l.ar;
        objectArray[35] = comparable;
        comparable = com.baidu.location.h.l.as;
        objectArray[36] = comparable;
        float f11 = com.baidu.location.h.l.at;
        comparable = Float.valueOf(f11);
        objectArray[37] = comparable;
        int n15 = 38;
        int n16 = com.baidu.location.h.l.ap;
        comparable = n16;
        objectArray[n15] = comparable;
        object4 = String.format(locale, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", objectArray).getBytes();
        try {
            comparable = new Comparable<Integer>((String)object3);
            boolean bl3 = ((File)comparable).exists();
            long l11 = 0L;
            object2 = "rw";
            if (!bl3) {
                object = com.baidu.location.h.k.a;
                object3 = new File((String)object);
                n13 = (int)(((File)object3).exists() ? 1 : 0);
                if (n13 == 0) {
                    ((File)object3).mkdirs();
                }
                if (!(bl3 = ((File)comparable).createNewFile())) return;
                object3 = new RandomAccessFile((File)comparable, (String)object2);
                ((RandomAccessFile)object3).seek(l11);
                ((RandomAccessFile)object3).writeBoolean(false);
                ((RandomAccessFile)object3).writeBoolean(false);
                ((RandomAccessFile)object3).close();
            }
            object3 = new RandomAccessFile((File)comparable, (String)object2);
            ((RandomAccessFile)object3).seek(l11);
            ((RandomAccessFile)object3).writeBoolean(bl2);
            long l12 = 2;
            ((RandomAccessFile)object3).seek(l12);
            int n17 = ((Object)object4).length;
            ((RandomAccessFile)object3).writeInt(n17);
            ((RandomAccessFile)object3).write((byte[])object4);
            ((RandomAccessFile)object3).close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g() {
        Object object = new StringBuilder();
        Object object2 = com.baidu.location.h.k.a;
        ((StringBuilder)object).append((String)object2);
        object2 = "/config.dat";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            object2 = new File((String)object);
            boolean bl2 = ((File)object2).exists();
            String string2 = "rw";
            if (!bl2) {
                String string3 = com.baidu.location.h.k.a;
                object = new File(string3);
                boolean bl3 = ((File)object).exists();
                if (!bl3) {
                    ((File)object).mkdirs();
                }
                if (!(bl2 = ((File)object2).createNewFile())) return;
                object = new RandomAccessFile((File)object2, string2);
                long l10 = 0L;
                ((RandomAccessFile)object).seek(l10);
                bl3 = false;
                string3 = null;
                ((RandomAccessFile)object).writeBoolean(false);
                ((RandomAccessFile)object).writeBoolean(false);
                ((RandomAccessFile)object).close();
            }
            object = new RandomAccessFile((File)object2, string2);
            long l11 = 1L;
            double d10 = Double.MIN_VALUE;
            ((RandomAccessFile)object).seek(l11);
            boolean bl4 = true;
            ((RandomAccessFile)object).writeBoolean(bl4);
            l11 = 1024L;
            d10 = 5.06E-321;
            ((RandomAccessFile)object).seek(l11);
            d10 = com.baidu.location.h.l.v;
            ((RandomAccessFile)object).writeDouble(d10);
            d10 = com.baidu.location.h.l.w;
            ((RandomAccessFile)object).writeDouble(d10);
            bl4 = com.baidu.location.h.l.z;
            ((RandomAccessFile)object).writeBoolean(bl4);
            bl4 = com.baidu.location.h.l.z;
            if (bl4 && (object2 = (Object)com.baidu.location.h.l.y) != null) {
                ((RandomAccessFile)object).write((byte[])object2);
            }
            ((RandomAccessFile)object).close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        boolean bl2;
        Object object = new StringBuilder();
        Object object2 = com.baidu.location.h.k.a;
        ((StringBuilder)object).append((String)object2);
        object2 = "/config.dat";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            object2 = new File((String)object);
            bl2 = ((File)object2).exists();
            if (bl2) {
                byte[] byArray;
                double d10;
                long l10;
                String string2 = "rw";
                object = new RandomAccessFile((File)object2, string2);
                int n10 = ((RandomAccessFile)object).readBoolean();
                string2 = null;
                if (n10 != 0) {
                    l10 = 2;
                    d10 = 1.0E-323;
                    ((RandomAccessFile)object).seek(l10);
                    n10 = ((RandomAccessFile)object).readInt();
                    byArray = new byte[n10];
                    ((RandomAccessFile)object).read(byArray, 0, n10);
                    object2 = new String(byArray);
                    this.a((String)object2);
                }
                l10 = 1L;
                d10 = Double.MIN_VALUE;
                ((RandomAccessFile)object).seek(l10);
                n10 = ((RandomAccessFile)object).readBoolean();
                if (n10 != 0) {
                    l10 = 1024L;
                    d10 = 5.06E-321;
                    ((RandomAccessFile)object).seek(l10);
                    com.baidu.location.h.l.v = d10 = ((RandomAccessFile)object).readDouble();
                    com.baidu.location.h.l.w = d10 = ((RandomAccessFile)object).readDouble();
                    n10 = (int)(((RandomAccessFile)object).readBoolean() ? 1 : 0);
                    com.baidu.location.h.l.z = n10;
                    if (n10 != 0) {
                        n10 = 625;
                        byArray = new byte[n10];
                        com.baidu.location.h.l.y = byArray;
                        ((RandomAccessFile)object).read(byArray, 0, n10);
                    }
                }
                ((RandomAccessFile)object).close();
            }
        }
        catch (Exception exception) {}
        if (bl2 = com.baidu.location.h.l.r) {
            bl2 = com.baidu.location.f.isServing;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        try {
            Object object = m;
            File file = new File((String)object);
            boolean bl2 = file.exists();
            if (bl2) return;
            String string2 = com.baidu.location.h.k.a;
            object = new File(string2);
            int n10 = ((File)object).exists();
            if (n10 == 0) {
                ((File)object).mkdirs();
            }
            if (!(bl2 = file.createNewFile())) {
                file = null;
            }
            string2 = "rw";
            object = new RandomAccessFile(file, string2);
            long l10 = 0L;
            ((RandomAccessFile)object).seek(l10);
            file = null;
            ((RandomAccessFile)object).writeInt(0);
            n10 = 128;
            ((RandomAccessFile)object).writeInt(n10);
            ((RandomAccessFile)object).writeInt(0);
            ((RandomAccessFile)object).close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void j() {
        var2_2 = com.baidu.location.c.e.m;
        var1_1 = new File((String)var2_2);
        var3_3 = var1_1.exists();
        if (!var3_3) ** GOTO lbl58
        var4_4 = "rw";
        var2_2 = new RandomAccessFile(var1_1, var4_4);
        var5_5 = 4;
        var2_2.seek(var5_5);
        var7_6 = var2_2.readInt();
        var8_7 = 3000;
        if (var7_6 <= var8_7) ** GOTO lbl21
        var2_2.close();
        com.baidu.location.c.e.p = 0;
        this.i();
        return;
lbl21:
        // 1 sources

        var8_7 = var2_2.readInt();
        var9_8 = 128L;
        var2_2.seek(var9_8);
        var11_9 = new byte[var7_6];
        for (var12_10 = 0; var12_10 < var8_7; ++var12_10) {
            var13_11 = var7_6 * var12_10 + 128;
            var14_12 = var13_11;
            var2_2.seek(var14_12);
            var13_11 = var2_2.readInt();
            if (var13_11 <= 0 || var13_11 >= var7_6) continue;
            var2_2.read(var11_9, 0, var13_11);
            var13_11 += -1;
            var16_13 = var11_9[var13_11];
            if (var16_13 != 0) continue;
            var17_14 = new String(var11_9, 0, var13_11);
            com.baidu.location.h.b.a();
            var18_15 = com.baidu.location.h.b.e;
            var13_11 = (int)var17_14.equals(var18_15);
            if (var13_11 == 0) continue;
            var7_6 = var2_2.readInt();
            com.baidu.location.c.e.n = var7_6;
            com.baidu.location.c.e.p = var12_10;
            break;
        }
        if (var12_10 != var8_7) ** GOTO lbl57
        try {
            com.baidu.location.c.e.p = var8_7;
lbl57:
            // 2 sources

            var2_2.close();
lbl58:
            // 3 sources

            return;
        }
        catch (Exception v0) {
            ** continue;
        }
    }

    public void b() {
        this.h();
    }

    public void c() {
    }

    public void d() {
        long l10 = System.currentTimeMillis();
        d d10 = com.baidu.location.h.d.a();
        long l11 = d10.d();
        l10 -= l11;
        l11 = this.l;
        long l12 = 1000L;
        long l13 = l10 - (l11 *= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            d d11 = com.baidu.location.h.d.a();
            long l14 = System.currentTimeMillis();
            d11.c(l14);
            d11 = com.baidu.location.g.a.a();
            com.baidu.location.c.f f10 = new com.baidu.location.c.f(this);
            d11.postDelayed(f10, l12);
        }
    }
}

