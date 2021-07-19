/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  com.baidu.location.indoor.mapversion.b.a
 */
package com.baidu.location.indoor.mapversion.a;

import android.os.Build;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.mapversion.IndoorJni;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static Lock a;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        a = reentrantLock;
    }

    public static boolean a() {
        int n10;
        int n11 = IndoorJni.a;
        n11 = n11 != 0 && (n11 = Build.VERSION.SDK_INT) > (n10 = 19) ? 1 : 0;
        return n11 != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(String var0) {
        var1_1 = var0;
        var2_4 = a.class;
        synchronized (var2_4) {
            block19: {
                var3_5 = com.baidu.location.indoor.mapversion.a.a.a();
                var4_6 = 0;
                var5_7 = null;
                if (var3_5 == 0) {
                    return false;
                }
                var6_8 = com.baidu.location.indoor.mapversion.b.a.a();
                var7_9 = var6_8.b(var0);
                var6_8 = com.baidu.location.indoor.mapversion.b.a.a();
                var8_10 = var6_8.c(var0);
                if (var7_9 == null) {
                    return false;
                }
                var6_8 = "gcj02";
                var7_9.a((String)var6_8);
                var9_11 /* !! */  = var7_9.g;
                var6_8 = var7_9.a();
                var10_12 = var6_8.a;
                var6_8 = var7_9.a();
                var12_13 = var6_8.b;
                var6_8 = com.baidu.location.indoor.mapversion.b.a.a();
                var6_8 = var6_8.c();
                if (var6_8 == null) {
                    return false;
                }
                var5_7 = var7_9.a();
                var14_14 = -var5_7.d;
                var16_15 = var6_8.a(var14_14);
                var5_7 = var7_9.a();
                var18_16 = -var5_7.f;
                var18_16 = var6_8.b(var18_16);
                var6_8 = com.baidu.location.indoor.mapversion.a.a.a;
                var6_8.lock();
                var6_8 = var7_9.f;
                var20_17 = var6_8.g;
                {
                    catch (Throwable var1_2) {
                        break block19;
                    }
                    catch (Exception var1_3) {}
                    {
                        var1_3.printStackTrace();
                        var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
                        ** GOTO lbl62
                    }
                }
                var22_18 = (int)var20_17;
                {
                    var23_19 = var6_8.h;
                }
                var25_20 = (int)var23_19;
                var6_8 = var0;
                var5_7 = var9_11 /* !! */ ;
                var26_21 = var10_12;
                var28_22 = var22_18;
                var22_18 = var25_20;
                {
                    IndoorJni.setPfRdnt(var0, var9_11 /* !! */ , var10_12, var12_13, var28_22, var25_20, var16_15, var18_16);
                    var6_8 = var7_9;
                    var6_8 = var7_9.f;
                    var29_23 = var6_8.g;
                }
                var4_6 = (int)var29_23;
                {
                    var26_21 = var6_8.h;
                }
                var3_5 = (int)var26_21;
                var9_11 /* !! */  = (short[][])var8_10;
                {
                    IndoorJni.setPfGeoMap(var8_10, var0, var4_6, var3_5);
                    var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
lbl62:
                    // 2 sources

                    var1_1.unlock();
                }
                return true;
            }
            var6_8 = com.baidu.location.indoor.mapversion.a.a.a;
            var6_8.unlock();
            throw var1_2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static double[] a(double var0, double var2_2, double var4_3, double var6_4, double var8_1) {
        var10_5 = a.class;
        synchronized (var10_5) {
            block13: {
                var11_6 = com.baidu.location.indoor.mapversion.a.a.a();
                if (!var11_6) {
                    return null;
                }
                var12_7 = com.baidu.location.indoor.mapversion.b.a.a();
                var12_7.a(var0, var2_2);
                var12_7 = com.baidu.location.indoor.mapversion.b.a.a();
                var12_7 = var12_7.c();
                var13_8 = var12_7.a(var0);
                var15_9 = var12_7.b(var2_2);
                var17_10 = 12;
                var18_11 /* !! */  = new double[var17_10];
                var18_11 /* !! */ [0] = var19_12 = -1.0;
                var21_13 = 1;
                var18_11 /* !! */ [var21_13] = var19_12;
                var22_14 = 2;
                var18_11 /* !! */ [var22_14] = var19_12;
                var17_10 = 3;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 4;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 5;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 6;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 7;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 8;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 9;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 10;
                var18_11 /* !! */ [var17_10] = var19_12;
                var17_10 = 11;
                var18_11 /* !! */ [var17_10] = var19_12;
                var23_15 = com.baidu.location.indoor.mapversion.a.a.a;
                var23_15.lock();
                var24_18 = System.currentTimeMillis();
                var19_12 = var4_3;
                var18_11 /* !! */  = IndoorJni.setPfGps(var13_8, var15_9, var4_3, var6_4, var8_1, var24_18);
                var23_15 = com.baidu.location.indoor.mapversion.a.a.a;
lbl44:
                // 2 sources

                while (true) {
                    var23_15.unlock();
                    break;
                }
                {
                    catch (Throwable var23_16) {
                        break block13;
                    }
                    catch (Exception var23_17) {}
                    {
                        var23_17.printStackTrace();
                        var23_15 = com.baidu.location.indoor.mapversion.a.a.a;
                        ** continue;
                    }
                }
                var13_8 = var18_11 /* !! */ [0];
                var15_9 = 0.0;
                var17_10 = (int)(var13_8 == var15_9 ? 0 : (var13_8 > var15_9 ? 1 : -1));
                if (var17_10 == 0) {
                    var13_8 = var18_11 /* !! */ [var21_13];
                    var13_8 = var12_7.c(var13_8);
                    var15_9 = var18_11 /* !! */ [var22_14];
                    var15_9 = var12_7.d(var15_9);
                    var18_11 /* !! */ [var21_13] = var13_8;
                    var18_11 /* !! */ [var22_14] = var15_9;
                }
                return var18_11 /* !! */ ;
            }
            var18_11 /* !! */  = (double[])com.baidu.location.indoor.mapversion.a.a.a;
            var18_11 /* !! */ .unlock();
            throw var23_16;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static double[] a(BDLocation var0) {
        var1_1 = a.class;
        synchronized (var1_1) {
            block15: {
                var2_2 = com.baidu.location.indoor.mapversion.a.a.a();
                if (var2_2 == 0) {
                    return null;
                }
                var3_3 = com.baidu.location.indoor.mapversion.b.a.a();
                var4_6 = var3_3.c();
                var2_2 = 12;
                var5_7 = new double[var2_2];
                var5_7[0] = var6_8 = -1.0;
                var8_9 = 1;
                var5_7[var8_9] = var6_8;
                var9_10 = 2;
                var5_7[var9_10] = var6_8;
                var2_2 = 3;
                var5_7[var2_2] = var6_8;
                var2_2 = 4;
                var5_7[var2_2] = var6_8;
                var2_2 = 5;
                var5_7[var2_2] = var6_8;
                var2_2 = 6;
                var5_7[var2_2] = var6_8;
                var2_2 = 7;
                var5_7[var2_2] = var6_8;
                var2_2 = 8;
                var5_7[var2_2] = var6_8;
                var2_2 = 9;
                var5_7[var2_2] = var6_8;
                var2_2 = 10;
                var5_7[var2_2] = var6_8;
                var2_2 = 11;
                var5_7[var2_2] = var6_8;
                if (var4_6 != null) {
                    block14: {
                        var6_8 = var0.getLongitude();
                        var10_11 = var4_6.a(var6_8);
                        var6_8 = var0.getLatitude();
                        var12_12 = var4_6.b(var6_8);
                        var3_3 = com.baidu.location.indoor.mapversion.a.a.a;
                        var3_3.lock();
                        var14_13 = 8.0;
                        var16_14 = System.currentTimeMillis();
                        var5_7 = IndoorJni.setPfWf(var10_11, var12_12, var14_13, var16_14);
                        var3_3 = com.baidu.location.indoor.mapversion.a.a.a;
lbl45:
                        // 2 sources

                        while (true) {
                            var3_3.unlock();
                            break;
                        }
                        {
                            catch (Throwable var3_4) {
                                break block14;
                            }
                            catch (Exception var3_5) {}
                            {
                                var3_5.printStackTrace();
                                var3_3 = com.baidu.location.indoor.mapversion.a.a.a;
                                ** continue;
                            }
                        }
                        var18_15 = var5_7[0];
                        var10_11 = 0.0;
                        var2_2 = (int)(var18_15 == var10_11 ? 0 : (var18_15 > var10_11 ? 1 : -1));
                        if (var2_2 == 0) {
                            var18_15 = var5_7[var8_9];
                            var18_15 = var4_6.c(var18_15);
                            var10_11 = var5_7[var9_10];
                            var10_11 = var4_6.d(var10_11);
                            var5_7[var8_9] = var18_15;
                            var5_7[var9_10] = var10_11;
                        }
                        break block15;
                    }
                    var4_6 = com.baidu.location.indoor.mapversion.a.a.a;
                    var4_6.unlock();
                    throw var3_4;
                }
            }
            return var5_7;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static double[] a(String var0, double var1_1, double var3_2, double var5_3) {
        var7_4 = a.class;
        synchronized (var7_4) {
            block15: {
                var8_5 = com.baidu.location.indoor.mapversion.a.a.a();
                if (var8_5 == 0) {
                    return null;
                }
                var9_6 = com.baidu.location.indoor.mapversion.b.a.a();
                var10_9 = var9_6.c();
                var8_5 = 12;
                var11_10 = new double[var8_5];
                var11_10[0] = var12_11 = -1.0;
                var14_12 = 1;
                var11_10[var14_12] = var12_11;
                var15_13 = 2;
                var11_10[var15_13] = var12_11;
                var8_5 = 3;
                var11_10[var8_5] = var12_11;
                var8_5 = 4;
                var11_10[var8_5] = var12_11;
                var8_5 = 5;
                var11_10[var8_5] = var12_11;
                var8_5 = 6;
                var11_10[var8_5] = var12_11;
                var8_5 = 7;
                var11_10[var8_5] = var12_11;
                var8_5 = 8;
                var11_10[var8_5] = var12_11;
                var8_5 = 9;
                var11_10[var8_5] = var12_11;
                var8_5 = 10;
                var11_10[var8_5] = var12_11;
                var8_5 = 11;
                var11_10[var8_5] = var12_11;
                if (var10_9 != null) {
                    block14: {
                        var9_6 = com.baidu.location.indoor.mapversion.a.a.a;
                        var9_6.lock();
                        var16_14 = System.currentTimeMillis();
                        var18_15 = var3_2;
                        var11_10 = IndoorJni.setPfDr(var3_2, var5_3, var16_14);
                        var9_6 = com.baidu.location.indoor.mapversion.a.a.a;
lbl41:
                        // 2 sources

                        while (true) {
                            var9_6.unlock();
                            break;
                        }
                        {
                            catch (Throwable var9_7) {
                                break block14;
                            }
                            catch (Exception var9_8) {}
                            {
                                var9_8.printStackTrace();
                                var9_6 = com.baidu.location.indoor.mapversion.a.a.a;
                                ** continue;
                            }
                        }
                        var20_16 = var11_10[0];
                        var18_15 = 0.0;
                        var8_5 = (int)(var20_16 == var18_15 ? 0 : (var20_16 > var18_15 ? 1 : -1));
                        if (var8_5 == 0) {
                            var20_16 = var11_10[var14_12];
                            var20_16 = var10_9.c(var20_16);
                            var18_15 = var11_10[var15_13];
                            var18_15 = var10_9.d(var18_15);
                            var11_10[var14_12] = var20_16;
                            var11_10[var15_13] = var18_15;
                        }
                        break block15;
                    }
                    var10_9 = com.baidu.location.indoor.mapversion.a.a.a;
                    var10_9.unlock();
                    throw var9_7;
                }
            }
            return var11_10;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        var0 = com.baidu.location.indoor.mapversion.a.a.a();
        if (!var0) {
            return;
        }
        var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
        var1_1.lock();
        IndoorJni.initPf();
        var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
        var1_1.unlock();
        return;
        {
            catch (Exception var1_3) {}
            {
                var1_3.printStackTrace();
            }
        }
        ** finally { 
lbl14:
        // 1 sources

        com.baidu.location.indoor.mapversion.a.a.a.unlock();
        throw var1_2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c() {
        var0 = com.baidu.location.indoor.mapversion.a.a.a();
        if (!var0) {
            return;
        }
        var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
        var1_1.lock();
        IndoorJni.resetPf();
        var1_1 = com.baidu.location.indoor.mapversion.a.a.a;
        var1_1.unlock();
        return;
        {
            catch (Exception var1_3) {}
            {
                var1_3.printStackTrace();
            }
        }
        ** finally { 
lbl14:
        // 1 sources

        com.baidu.location.indoor.mapversion.a.a.a.unlock();
        throw var1_2;
    }
}

