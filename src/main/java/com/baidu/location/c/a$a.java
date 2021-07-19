/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.baidu.location.c;

import android.content.ContentValues;
import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.c.a;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class a$a
extends f {
    public int a;
    public int b;
    public int c;
    public int d;
    public double e;
    public final /* synthetic */ a f;

    public a$a(a hashMap) {
        this.f = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(double d10, double d11, double d12) {
        int n10;
        int bl2;
        Object object = this.f;
        int n11 = com.baidu.location.c.a.b((a)object);
        if (n11 != 0) {
            return;
        }
        object = Jni.coorEncrypt(d10, d11, "gcj2wgs");
        Object object2 = object[0];
        double d13 = 100.0;
        object2 = Math.floor((double)(object2 * d13));
        this.a = bl2 = (int)object2;
        boolean bl3 = true;
        double d14 = Math.floor((double)(object[bl3] * d13));
        this.b = n11 = (int)d14;
        this.c = n10 = (int)Math.floor(d10 * d13);
        d10 = Math.floor(d11 *= d13);
        this.d = n10 = (int)d10;
        this.e = d12;
        Object object3 = this.f;
        com.baidu.location.c.a.a((a)object3, bl3);
        n10 = (int)(com.baidu.location.h.l.b() ? 1 : 0);
        if (n10 == 0) {
            object3 = aa.a().c();
            String string2 = "https://loc.map.baidu.com/gpsz";
            this.a((ExecutorService)object3, string2);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(boolean var1_1) {
        block118: {
            block114: {
                block121: {
                    block109: {
                        block120: {
                            block119: {
                                var2_2 = this;
                                var3_3 = "galdata_new";
                                var4_4 = "locStateData";
                                var5_5 = ":";
                                var6_6 = "info";
                                var7_7 = "height";
                                if (!var1_1 || (var8_8 = this.j) == null) break block118;
                                var8_8 = com.baidu.location.c.a.d();
                                var8_8.lock();
                                var9_9 = this.j;
                                var8_8 = new JSONObject((String)var9_9);
                                var10_10 = var8_8.has((String)var7_7);
                                var11_11 = "id";
                                var12_12 = "\"";
                                var13_13 = "id = \"";
                                var14_14 = "%d,%d";
                                var15_15 = "E";
                                var16_16 /* !! */  = ",";
                                var17_17 = 2;
                                var18_18 = 1;
                                if (var10_10 == 0) break block109;
                                var7_7 = var8_8.getString((String)var7_7);
                                var10_10 = var7_7.contains((CharSequence)var16_16 /* !! */ );
                                if (var10_10 == 0) break block109;
                                var7_7 = var7_7.trim();
                                var7_7 = var7_7.split((String)var16_16 /* !! */ );
                                var10_10 = ((String[])var7_7).length;
                                var19_19 = var8_8;
                                var20_20 = var10_10;
                                var20_20 = Math.sqrt(var20_20);
                                var22_21 = (int)var20_20;
                                var23_22 = var22_21 * var22_21;
                                if (var23_22 != var10_10) break block119;
                                var23_22 = this.c;
                                var10_10 = var22_21 + -1;
                                var24_23 = var10_10 / 2;
                                var23_22 -= var24_23;
                                var25_24 = var4_4;
                                var26_25 = this.d;
                                var26_25 -= (var10_10 /= var17_17);
                                var9_9 = null;
                                for (var10_10 = 0; var10_10 < var22_21; ++var10_10) {
                                    var27_26 = null;
                                    block100: for (var17_17 = 0; var17_17 < var22_21; ++var17_17) {
                                        block113: {
                                            block111: {
                                                block112: {
                                                    block110: {
                                                        var28_27 = var16_16 /* !! */ ;
                                                        var16_16 /* !! */  = new ContentValues();
                                                        var29_28 = var10_10 * var22_21 + var17_17;
                                                        var30_29 = var22_21;
                                                        var31_30 = var7_7[var29_28];
                                                        var22_21 = (int)var31_30.contains((CharSequence)var15_15);
                                                        var32_31 = var15_15;
                                                        var15_15 = "sigma";
                                                        var33_32 = var6_6;
                                                        var6_6 = "aldata";
                                                        var34_33 = 4666723172467343360L;
                                                        var36_34 = 10000.0;
                                                        if (var22_21 == 0) break block110;
                                                        var31_30 = var36_34;
                                                        var16_16 /* !! */ .put((String)var6_6, (Double)var31_30);
                                                        var6_6 = var36_34;
lbl79:
                                                        // 2 sources

                                                        while (true) {
                                                            var16_16 /* !! */ .put((String)var15_15, (Double)var6_6);
                                                            var38_35 = var5_5;
                                                            var39_36 = var7_7;
                                                            break block111;
                                                            break;
                                                        }
                                                    }
                                                    var31_30 = var7_7[var29_28];
                                                    var22_21 = (int)var31_30.contains((CharSequence)var5_5);
                                                    if (var22_21 != 0) break block112;
                                                    var31_30 = var7_7[var29_28];
                                                    var31_30 = Double.valueOf((String)var31_30);
                                                    var16_16 /* !! */ .put((String)var6_6, (Double)var31_30);
                                                    var6_6 = var36_34;
                                                    ** continue;
                                                }
                                                var31_30 = var7_7[var29_28];
                                                var31_30 = var31_30.split((String)var5_5);
                                                var38_35 = var5_5;
                                                var40_37 = var31_30.length;
                                                var39_36 = var7_7;
                                                var41_38 = 2;
                                                if (var40_37 != var41_38) ** GOTO lbl123
                                                var40_37 = 0;
                                                var5_5 = null;
                                                var7_7 = var31_30[0];
                                                var5_5 = Double.valueOf((String)var7_7);
                                                var16_16 /* !! */ .put((String)var6_6, (Double)var5_5);
                                                var5_5 = var31_30[var18_18];
                                                var16_16 /* !! */ .put((String)var15_15, (String)var5_5);
                                                break block111;
lbl123:
                                                // 1 sources

                                                var5_5 = var36_34;
                                                var16_16 /* !! */ .put((String)var6_6, (Double)var5_5);
                                                var5_5 = var36_34;
                                                var16_16 /* !! */ .put((String)var15_15, (Double)var5_5);
                                            }
                                            var5_5 = "tt";
                                            var42_39 = System.currentTimeMillis();
                                            var34_33 = 1000L;
                                            var36_34 = 4.94E-321;
                                            ** try [egrp 37[TRYBLOCK] [41 : 575->578)] { 
lbl136:
                                            // 1 sources

                                            var44_40 = (int)(var42_39 /= var34_33);
                                            var6_6 = var44_40;
                                            var16_16 /* !! */ .put((String)var5_5, (Integer)var6_6);
                                            var40_37 = var23_22 + var17_17;
                                            var44_40 = var26_25 + var10_10;
                                            var7_7 = Locale.CHINESE;
                                            var22_21 = 2;
                                            var15_15 = new Object[var22_21];
                                            var5_5 = var40_37;
                                            var22_21 = 0;
                                            var31_30 = null;
                                            var15_15[0] = var5_5;
                                            var5_5 = var44_40;
                                            var15_15[var18_18] = var5_5;
                                            var5_5 = String.format((Locale)var7_7, var14_14, (Object[])var15_15);
                                            var6_6 = var2_2.f;
                                            var6_6 = com.baidu.location.c.a.a((a)var6_6);
                                            var7_7 = new StringBuilder();
                                            var7_7.append(var13_13);
                                            var7_7.append((String)var5_5);
                                            var7_7.append(var12_12);
                                            var7_7 = var7_7.toString();
                                            var22_21 = 0;
                                            var31_30 = null;
                                            var44_40 = var6_6.update((String)var3_3, (ContentValues)var16_16 /* !! */ , (String)var7_7, null);
                                            if (var44_40 > 0) break block113;
                                            var16_16 /* !! */ .put(var11_11, (String)var5_5);
                                            var5_5 = var2_2.f;
                                            var5_5 = com.baidu.location.c.a.a((a)var5_5);
                                            var5_5.insert((String)var3_3, null, (ContentValues)var16_16 /* !! */ );
                                        }
lbl189:
                                        // 2 sources

                                        while (true) {
                                            var16_16 /* !! */  = var28_27;
                                            var5_5 = var38_35;
                                            var22_21 = var30_29;
                                            var15_15 = var32_31;
                                            var6_6 = var33_32;
                                            var7_7 = var39_36;
                                            continue block100;
                                            break;
                                        }
                                    }
                                    var38_35 = var5_5;
                                    var33_32 = var6_6;
                                    var39_36 = var7_7;
                                    var30_29 = var22_21;
                                    var32_31 = var15_15;
                                    var28_27 = var16_16 /* !! */ ;
                                    var17_17 = 2;
                                }
                                break block120;
                            }
                            var25_24 = var4_4;
                        }
                        var33_32 = var6_6;
                        break block121;
                    }
                    var25_24 = var4_4;
                    var33_32 = var6_6;
                    var19_19 = var8_8;
                }
                var32_31 = var15_15;
                var28_27 = var16_16 /* !! */ ;
                var3_3 = var19_19;
                var4_4 = var33_32;
                var40_37 = var19_19.has(var33_32);
                if (var40_37 == 0) break block114;
                var3_3 = var19_19.getString(var33_32);
                var4_4 = var16_16 /* !! */ ;
                var40_37 = var3_3.contains((CharSequence)var16_16 /* !! */ );
                if (var40_37 == 0) break block114;
                var3_3 = var3_3.trim();
                var3_3 = var3_3.split((String)var16_16 /* !! */ );
                var26_25 = ((String[])var3_3).length;
                var45_41 = var26_25;
                var45_41 = Math.sqrt(var45_41);
                var40_37 = (int)var45_41;
                var44_40 = var40_37 * var40_37;
                if (var44_40 == var26_25) {
                    var26_25 = var2_2.c;
                    var44_40 = var40_37 + -1;
                    var41_38 = var44_40 / 2;
                    var26_25 -= var41_38;
                    var41_38 = var2_2.d;
                    var22_21 = 2;
                    var41_38 -= (var44_40 /= var22_21);
                    var6_6 = null;
                    for (var44_40 = 0; var44_40 < var40_37; ++var44_40) {
                        var31_30 = null;
                        block104: for (var22_21 = 0; var22_21 < var40_37; ++var22_21) {
                            block117: {
                                block116: {
                                    block115: {
                                        var8_8 = new ContentValues();
                                        var10_10 = var44_40 * var40_37 + var22_21;
                                        var15_15 = var3_3[var10_10];
                                        var27_26 = var32_31;
                                        var47_42 = var15_15.contains((CharSequence)var32_31);
                                        var16_16 /* !! */  = "state";
                                        if (var47_42 == 0) break block115;
                                        var10_10 = -1;
                                        var9_9 = var10_10;
lbl269:
                                        // 2 sources

                                        while (true) {
                                            var8_8.put((String)var16_16 /* !! */ , (Integer)var9_9);
                                            break block116;
                                            break;
                                        }
                                    }
                                    var9_9 = var3_3[var10_10];
                                    var9_9 = Integer.valueOf((String)var9_9);
                                    var10_10 = var9_9.intValue();
                                    var9_9 = var10_10;
                                    ** continue;
                                }
                                var10_10 = var26_25 + var22_21;
                                var47_42 = var41_38 + var44_40;
                                var16_16 /* !! */  = Locale.CHINESE;
                                var19_19 = var3_3;
                                var48_43 = var26_25;
                                var49_44 = 2;
                                var4_4 = new Object[var49_44];
                                var9_9 = var10_10;
                                var4_4[0] = var9_9;
                                var9_9 = var47_42;
                                var4_4[var18_18] = var9_9;
                                var4_4 = String.format((Locale)var16_16 /* !! */ , var14_14, (Object[])var4_4);
                                var9_9 = var2_2.f;
                                var9_9 = com.baidu.location.c.a.a((a)var9_9);
                                var15_15 = new StringBuilder();
                                var15_15.append(var13_13);
                                var15_15.append((String)var4_4);
                                var15_15.append(var12_12);
                                var15_15 = var15_15.toString();
                                var16_16 /* !! */  = var25_24;
                                var49_44 = 0;
                                var3_3 = null;
                                var10_10 = var9_9.update((String)var25_24, var8_8, (String)var15_15, null);
                                if (var10_10 > 0) break block117;
                                var8_8.put(var11_11, (String)var4_4);
                                var4_4 = var2_2.f;
                                var4_4 = com.baidu.location.c.a.a((a)var4_4);
                                var4_4.insert((String)var25_24, null, var8_8);
                                break block117;
                                catch (Exception v0) {
                                    var16_16 /* !! */  = var25_24;
                                    var49_44 = 0;
                                    var3_3 = null;
                                }
                            }
lbl338:
                            // 2 sources

                            while (true) {
                                var32_31 = var27_26;
                                var25_24 = var16_16 /* !! */ ;
                                var3_3 = var19_19;
                                var26_25 = var48_43;
                                continue block104;
                                break;
                            }
                        }
                        var19_19 = var3_3;
                        var48_43 = var26_25;
                        var16_16 /* !! */  = var25_24;
                        var27_26 = var32_31;
                        var49_44 = 0;
                    }
                }
                break block114;
lbl-1000:
                // 70 sources

                {
                    catch (Exception v1) {}
                    break;
                }
            }
            var3_3 = com.baidu.location.c.a.d();
            var3_3.unlock();
        }
        if ((var3_3 = var2_2.k) != null) {
            var3_3.clear();
        }
        com.baidu.location.c.a.a(var2_2.f, false);
        return;
        catch (Exception v2) {
            ** continue;
        }
        catch (Exception v3) {
            ** continue;
        }
    }

    public void b() {
        Object object;
        this.h = "https://loc.map.baidu.com/gpsz";
        Object object2 = Locale.CHINESE;
        int n10 = 3;
        Object object3 = new Object[n10];
        object3[0] = object = Integer.valueOf(this.a);
        object3[1] = object = Integer.valueOf(this.b);
        object = com.baidu.location.h.b.a().c();
        int n11 = 2;
        object3[n11] = object;
        boolean bl2 = ((String)(object3 = Jni.encode((String)(object2 = String.format((Locale)object2, "&is_vdr=1&x=%d&y=%d%s", (Object[])object3))))).contains((CharSequence)(object = "err!"));
        if (bl2) {
            object2 = ((String)object2).getBytes();
            object2 = Base64.encode((byte[])object2, (int)0);
            object = "UTF-8";
            try {
                object3 = new String((byte[])object2, (String)object);
            }
            catch (Exception exception) {
                object3 = "err2!";
            }
            object2 = this.k;
            object = "gpszb";
        } else {
            object2 = this.k;
            object = "gpsz";
        }
        object2.put(object, object3);
    }
}

