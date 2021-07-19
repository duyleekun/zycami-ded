/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.baidu.location.c;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.a$a;
import com.baidu.location.h.l;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static Object b;
    private static a c;
    private static final String d;
    private static Lock f;
    public a$a a = null;
    private SQLiteDatabase e = null;
    private boolean g = false;
    private Map h;
    private String i;
    private int j;
    private String k;
    private double l;
    private double m;

    static {
        Object object;
        b = object = new Object();
        object = new StringBuilder();
        String string2 = com.baidu.location.h.l.j();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("/gal.db");
        d = ((StringBuilder)object).toString();
        f = object = new ReentrantLock();
    }

    public a() {
        double d10;
        HashMap hashMap;
        this.h = hashMap = new HashMap();
        this.i = null;
        this.j = -1;
        this.k = null;
        this.l = d10 = Double.MAX_VALUE;
        this.m = d10;
    }

    public static /* synthetic */ SQLiteDatabase a(a a10) {
        return a10.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object = b;
        synchronized (object) {
            a a10 = c;
            if (a10 != null) return c;
            c = a10 = new a();
            return c;
        }
    }

    private void a(double d10, double d11, double d12) {
        a$a a$a = this.a;
        if (a$a == null) {
            this.a = a$a = new a$a(this);
        }
        this.a.a(d10, d11, d12);
    }

    public static /* synthetic */ boolean a(a a10, boolean bl2) {
        a10.g = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean b(a a10) {
        return a10.g;
    }

    public static /* synthetic */ Lock d() {
        return f;
    }

    public int a(BDLocation object) {
        double d10;
        float f10;
        double d11;
        float f11;
        double d12 = 0.0;
        int n10 = 0;
        if (object != null) {
            f11 = ((BDLocation)object).getRadius();
            d11 = ((BDLocation)object).getAltitude();
        } else {
            d11 = d12;
            f11 = 0.0f;
        }
        SQLiteDatabase sQLiteDatabase = this.e;
        int n11 = 0;
        if (sQLiteDatabase != null && (n10 = (f10 = f11 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0 && (d10 = d11 == d12 ? 0 : (d11 > d12 ? 1 : -1)) > 0 && object != null) {
            d12 = ((BDLocation)object).getLongitude();
            double d13 = ((BDLocation)object).getLatitude();
            object = this.a(d12, d13);
            double d14 = (d12 = (double)object[0]) - (d13 = Double.MAX_VALUE);
            Object object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object2 != false) {
                double d15;
                double d16;
                double d17 = (d12 = Jni.getGpsSwiftRadius(f11, d11, d12)) - (d16 = 50.0);
                object2 = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
                n11 = object2 > 0 ? 3 : ((object2 = (d15 = d12 - (d16 = 20.0)) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1)) > 0 ? 2 : 1);
            }
        }
        return n11;
    }

    /*
     * Unable to fully structure code
     */
    public double[] a(double var1_1, double var3_2) {
        block58: {
            block55: {
                block56: {
                    block61: {
                        block60: {
                            block51: {
                                block53: {
                                    block59: {
                                        block54: {
                                            block49: {
                                                block52: {
                                                    block50: {
                                                        block57: {
                                                            var5_3 = this;
                                                            var6_4 = 2;
                                                            var7_5 = new double[var6_4];
                                                            var8_6 = this.e;
                                                            var9_7 = 1;
                                                            var10_8 = 0x7FEFFFFFFFFFFFFFL;
                                                            var12_9 = 1.7976931348623157E308;
                                                            var14_10 = 10000.0;
                                                            if (var8_6 == null || (var18_12 = (cfr_temp_0 = var1_1 - (var16_11 = 0.1)) == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1)) <= 0 || (var19_13 = var3_2 == var16_11 ? 0 : (var3_2 > var16_11 ? 1 : -1)) <= 0) break block56;
                                                            var8_6 = Locale.CHINESE;
                                                            var20_14 = new Object[var6_4];
                                                            var21_15 = 4636737291354636288L;
                                                            var23_16 = 100.0;
                                                            var25_17 = Math.floor(var1_1 * var23_16);
                                                            var27_18 = (int)var25_17;
                                                            var28_19 = var27_18;
                                                            var20_14[0] = var28_19;
                                                            var23_16 = Math.floor(var23_16 * var3_2);
                                                            var18_12 = (int)var23_16;
                                                            var20_14[var9_7] = var29_20 = Integer.valueOf((int)var18_12);
                                                            var29_20 = "%d,%d";
                                                            var30_21 = String.format((Locale)var8_6, (String)var29_20, (Object[])var20_14);
                                                            var8_6 = this.k;
                                                            if (var8_6 == null || (var19_13 = (double)var8_6.equals(var30_21)) == false) break block57;
                                                            var12_9 = this.l;
                                                            var31_22 = this.m;
                                                            var33_23 = var14_10;
                                                            break block58;
                                                        }
                                                        com.baidu.location.c.a.f.lock();
                                                        var19_13 = (double)false;
                                                        var8_6 = null;
                                                        var20_14 = var5_3.e;
                                                        var29_20 = new StringBuilder();
                                                        var35_24 = "select * from galdata_new where id = \"";
                                                        var29_20.append(var35_24);
                                                        var29_20.append(var30_21);
                                                        var35_24 = "\";";
                                                        var29_20.append(var35_24);
                                                        var29_20 = var29_20.toString();
                                                        var36_25 = var20_14.rawQuery((String)var29_20, null);
                                                        if (var36_25 == null) break block49;
                                                        var19_13 = (double)var36_25.moveToFirst();
                                                        if (var19_13 == false) break block49;
                                                        var16_11 = var36_25.getDouble(var9_7);
                                                        var23_16 = var36_25.getDouble(var6_4);
                                                        var6_4 = 3;
                                                        var6_4 = var36_25.getInt(var6_4);
                                                        var27_18 = (int)(var16_11 == var14_10 ? 0 : (var16_11 > var14_10 ? 1 : -1));
                                                        if (var27_18 == 0) {
                                                            var16_11 = var12_9;
                                                        }
                                                        var37_26 = 0L;
                                                        var39_27 = 0.0;
                                                        cfr_temp_1 = var23_16 - var39_27;
                                                        var27_18 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 < 0.0 ? -1 : 1));
                                                        if (var27_18 > 0) {
                                                            var12_9 = var23_16;
                                                        }
                                                        var21_15 = System.currentTimeMillis();
                                                        var37_26 = 1000L;
                                                        var39_27 = 4.94E-321;
                                                        var21_15 /= var37_26;
                                                        var41_28 = var6_4;
                                                        var21_15 -= var41_28;
                                                        var6_4 = (int)var5_3.g;
                                                        if (var6_4 != 0) break block50;
                                                        var41_28 = 604800L;
                                                        var43_29 = 2.98811E-318;
                                                        var6_4 = (int)(var21_15 == var41_28 ? 0 : (var21_15 < var41_28 ? -1 : 1));
                                                        if (var6_4 > 0) {
                                                            var41_28 = 4620918397448749056L;
                                                            var43_29 = 8.399999618530273;
                                                            var8_6 = this;
                                                            var33_23 = var1_1;
                                                            var14_10 = var16_11;
                                                            var45_30 = var30_21;
                                                            var46_35 = var36_25;
                                                            var47_36 = var43_29;
                                                            this.a(var1_1, var3_2, var43_29);
                                                        }
                                                    }
                                                    var14_10 = var16_11;
                                                    var45_30 = var30_21;
                                                    var46_35 = var36_25;
                                                    var5_3.k = var45_30;
                                                    var5_3.l = var14_10;
                                                    var5_3.m = var12_9;
                                                    var31_22 = var12_9;
                                                    var12_9 = var14_10;
                                                    catch (Exception v0) {
                                                        var14_10 = var16_11;
                                                        var46_35 = var36_25;
lbl113:
                                                        // 2 sources

                                                        while (true) {
                                                            var23_16 = var12_9;
                                                            var12_9 = var14_10;
                                                            break block51;
                                                            break;
                                                        }
                                                    }
                                                    catch (Exception v1) {
                                                        var46_35 = var36_25;
                                                        break block52;
                                                    }
                                                    catch (Exception v2) {
                                                        var46_35 = var36_25;
                                                        var21_15 = var10_8;
                                                        var23_16 = var12_9;
                                                    }
                                                }
                                                var12_9 = var16_11;
                                                break block51;
                                                catch (Throwable var45_31) {
                                                    var46_35 = var36_25;
                                                }
                                                break block59;
                                                catch (Exception v3) {
                                                    var46_35 = var36_25;
                                                    break block53;
                                                }
                                            }
                                            var46_35 = var36_25;
                                            var6_4 = (int)var5_3.g;
                                            if (var6_4 != 0) break block54;
                                            var47_37 = 8.399999618530273;
                                            var8_6 = this;
                                            var33_23 = var1_1;
                                            this.a(var1_1, var3_2, var47_37);
                                        }
                                        var31_22 = var12_9;
                                        if (var46_35 == null) ** GOTO lbl178
                                        var46_35.close();
                                        ** GOTO lbl178
                                        catch (Throwable var45_32) {
                                            // empty catch block
                                        }
                                    }
                                    var8_6 = var46_35;
                                    break block60;
                                    catch (Exception v4) {}
                                }
                                var21_15 = var10_8;
                                var23_16 = var12_9;
                            }
                            var8_6 = var46_35;
                            break block61;
                            catch (Throwable var45_34) {
                                // empty catch block
                            }
                        }
                        if (var8_6 != null) {
                            var8_6.close();
                        }
lbl167:
                        // 4 sources

                        throw var45_33;
                        catch (Exception v5) {
                            var21_15 = var10_8;
                            var23_16 = var12_9;
                        }
                    }
                    if (var8_6 != null) {
                        var8_6.close();
                    }
lbl176:
                    // 4 sources

                    while (true) {
                        var31_22 = var23_16;
lbl178:
                        // 4 sources

                        while (true) {
                            var20_14 = com.baidu.location.c.a.f;
                            var20_14.unlock();
                            break block55;
                            break;
                        }
                        break;
                    }
                }
                var31_22 = var12_9;
            }
            var33_23 = 10000.0;
        }
        var49_38 = var12_9 == var33_23 ? 0 : (var12_9 > var33_23 ? 1 : -1);
        if (var49_38 > 0) {
            var49_38 = (double)false;
            var35_24 = null;
            var7_5[0] = var33_23;
        } else {
            var49_38 = (double)false;
            var35_24 = null;
            var7_5[0] = var12_9;
        }
        var49_38 = var31_22 == var33_23 ? 0 : (var31_22 > var33_23 ? 1 : -1);
        if (var49_38 > 0) {
            var49_38 = (double)true;
            var7_5[var49_38] = var33_23;
        } else {
            var49_38 = (double)true;
            var7_5[var49_38] = var31_22;
        }
        return var7_5;
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
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        try {
            String string2 = d;
            File file = new File(string2);
            int n10 = file.exists();
            if (n10 == 0) {
                file.createNewFile();
            }
            if ((n10 = file.exists()) == 0) return;
            file = SQLiteDatabase.openOrCreateDatabase((File)file, null);
            this.e = file;
            string2 = "SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'";
            n10 = (file = file.rawQuery(string2, null)).moveToFirst();
            if (n10 != 0) {
                n10 = 0;
                string2 = null;
                n10 = file.getInt(0);
                String string3 = "CREATE TABLE IF NOT EXISTS locStateData(id CHAR(40) PRIMARY KEY,state INT);";
                if (n10 == 0) {
                    string2 = this.e;
                    String string4 = "CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    string2.execSQL(string4);
                } else {
                    string2 = this.e;
                    String string5 = "DROP TABLE galdata";
                    string2.execSQL(string5);
                    string2 = this.e;
                    string5 = "CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    string2.execSQL(string5);
                }
                string2 = this.e;
                string2.execSQL(string3);
            }
            string2 = this.e;
            int n11 = 1;
            string2.setVersion(n11);
            file.close();
            return;
        }
        catch (Exception exception) {
            this.e = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.e;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            }
            catch (Throwable throwable) {
                this.e = null;
                throw throwable;
            }
            catch (Exception exception) {}
            this.e = null;
        }
    }
}

