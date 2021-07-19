/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  android.location.Location
 *  android.net.wifi.ScanResult
 *  android.os.Handler
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.o;
import com.baidu.location.e.a$a;
import com.baidu.location.e.a$b;
import com.baidu.location.e.b;
import com.baidu.location.f;
import com.baidu.location.f.h;
import com.baidu.location.f.i;
import com.baidu.location.h.k;
import com.baidu.location.h.l;
import java.io.File;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class a {
    private static a b;
    private static final String l;
    private static final String m;
    public boolean a;
    private String c = null;
    private boolean d = false;
    private boolean e = false;
    private double f;
    private double g;
    private double h;
    private double i;
    private double j;
    private volatile boolean k;
    private Handler n;

    static {
        l = com.baidu.location.h.k.a;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = com.baidu.location.h.k.a;
        stringBuilder.append(string2);
        stringBuilder.append("/ls.db");
        m = stringBuilder.toString();
    }

    private a() {
        double d10;
        this.f = d10 = 0.0;
        this.g = d10;
        this.h = d10;
        this.i = d10;
        this.j = d10;
        this.k = false;
        this.n = null;
        this.a = false;
        this.b();
    }

    public static a a() {
        Class<a> clazz = a.class;
        synchronized (clazz) {
            a a10 = b;
            if (a10 == null) {
                b = a10 = new a();
            }
            a10 = b;
            return a10;
        }
    }

    public static /* synthetic */ void a(a a10) {
        a10.e();
    }

    public static /* synthetic */ void a(a a10, h h10, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        a10.a(h10, bDLocation, sQLiteDatabase);
    }

    public static /* synthetic */ void a(a a10, String string2, com.baidu.location.f.a a11, SQLiteDatabase sQLiteDatabase) {
        a10.a(string2, a11, sQLiteDatabase);
    }

    /*
     * Exception decompiling
     */
    private void a(h var1_1, BDLocation var2_2, SQLiteDatabase var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [58[SIMPLE_IF_TAKEN]], but top level block is 36[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(String var1_1, SQLiteDatabase var2_3) {
        block25: {
            block24: {
                if (var1_1 == null || (var4_5 = var1_1.equals(var3_4 = this.c))) break block25;
                this.d = false;
                var4_5 = false;
                var3_4 = null;
                var5_6 /* !! */  = new StringBuilder();
                var6_7 = "select * from bdcltb09 where id = \"";
                var5_6 /* !! */ .append(var6_7);
                var5_6 /* !! */ .append(var1_1);
                var6_7 = "\";";
                var5_6 /* !! */ .append(var6_7);
                var5_6 /* !! */  = var5_6 /* !! */ .toString();
                var3_4 = var2_3.rawQuery((String)var5_6 /* !! */ , null);
                this.c = var1_1;
                var7_8 = var3_4.moveToFirst();
                if (var7_8 == 0) break block24;
                var7_8 = 1;
                var8_9 = var3_4.getDouble(var7_8);
                var10_10 = 1235.4323;
                var8_9 -= var10_10;
                this.g = var8_9;
                var12_11 = 2;
                var8_9 = var3_4.getDouble(var12_11);
                var10_10 = 4326.0;
                var8_9 -= var10_10;
                this.f = var8_9;
                var12_11 = 3;
                var8_9 = var3_4.getDouble(var12_11);
                var10_10 = 2367.3217;
                var8_9 -= var10_10;
                this.h = var8_9;
                try {
                    this.d = var7_8;
                }
                catch (Throwable var1_2) {
                    if (var3_4 != null) {
                        var3_4.close();
                    }
lbl58:
                    // 4 sources

                    throw var1_2;
                }
                catch (Exception v0) {
                    if (var3_4 != null) {
                        ** continue;
                    }
                    break block25;
                }
            }
            if (var3_4 == null) break block25;
lbl50:
            // 2 sources

            while (true) {
                var3_4.close();
                break block25;
                break;
            }
            catch (Exception v1) {}
        }
        return;
        {
            catch (Exception v2) {
                ** continue;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, com.baidu.location.f.a a10, SQLiteDatabase sQLiteDatabase) {
        double d10;
        float f10;
        String string3;
        String string4;
        String string5;
        String string6;
        Object object;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        CharSequence charSequence = "clf";
        int n10 = a10.b();
        if (n10 == 0) return;
        Object object2 = o.c();
        n10 = ((o)object2).i();
        if (n10 == 0) {
            return;
        }
        System.currentTimeMillis();
        n10 = 0;
        float f11 = 0.0f;
        object2 = null;
        long l10 = System.currentTimeMillis();
        int n11 = 28;
        float f12 = 3.9E-44f;
        int n12 = (int)(l10 >>= n11);
        String string7 = a10.g();
        try {
            int n13;
            int n14;
            block10: {
                double d11;
                double d12;
                block9: {
                    int n15;
                    block8: {
                        double d13;
                        String string8 = string2;
                        JSONObject jSONObject = new JSONObject(string2);
                        string8 = "result";
                        string8 = jSONObject.getJSONObject(string8);
                        object = "error";
                        string8 = string8.getString((String)object);
                        n15 = Integer.parseInt(string8);
                        int n16 = 161;
                        string6 = "\"";
                        string5 = "id = \"";
                        n14 = 1;
                        d12 = 0.0;
                        string4 = "bdcltb09";
                        if (n15 != n16) break block8;
                        string8 = "content";
                        JSONObject jSONObject2 = jSONObject.getJSONObject(string8);
                        n15 = (int)(jSONObject2.has((String)charSequence) ? 1 : 0);
                        n16 = 0;
                        object = null;
                        if (n15 == 0) break block9;
                        n10 = ((String)(charSequence = jSONObject2.getString((String)charSequence))).equals(object2 = "0");
                        if (n10 != 0) {
                            charSequence = "point";
                            charSequence = jSONObject2.getJSONObject((String)charSequence);
                            object2 = "x";
                            object2 = charSequence.getString((String)object2);
                            double d14 = Double.parseDouble((String)object2);
                            object2 = "y";
                            charSequence = charSequence.getString((String)object2);
                            double d15 = Double.parseDouble((String)charSequence);
                            string8 = "radius";
                            String string9 = jSONObject2.getString(string8);
                            f12 = Float.parseFloat(string9);
                            d12 = d14;
                            n14 = 0;
                            string3 = null;
                            d13 = d15;
                            f11 = f12;
                        } else {
                            object2 = "\\|";
                            charSequence = ((String)charSequence).split((String)object2);
                            object2 = charSequence[0];
                            d11 = Double.parseDouble((String)object2);
                            object2 = charSequence[n14];
                            double d16 = Double.parseDouble((String)object2);
                            n10 = 2;
                            f11 = 2.8E-45f;
                            charSequence = charSequence[n10];
                            f11 = f10 = Float.parseFloat((String)charSequence);
                            d13 = d16;
                            n14 = 0;
                            string3 = null;
                            d12 = d11;
                        }
                        d11 = d13;
                        break block10;
                    }
                    n13 = 167;
                    f10 = 2.34E-43f;
                    if (n15 == n13) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append(string5);
                        ((StringBuilder)charSequence).append(string7);
                        ((StringBuilder)charSequence).append(string6);
                        charSequence = ((StringBuilder)charSequence).toString();
                        sQLiteDatabase.delete(string4, (String)charSequence, null);
                        return;
                    }
                }
                d11 = d12;
            }
            if (n14 != 0) {
                return;
            }
            d10 = 2367.3217;
            n13 = 1166487552;
            f10 = 4326.0f;
        }
        catch (Exception exception) {
            return;
        }
        charSequence = new ContentValues();
        object = d12 += 1235.4323;
        string3 = "time";
        charSequence.put(string3, (Double)object);
        object2 = Float.valueOf(f11 += f10);
        object = "tag";
        charSequence.put((String)object, (Float)object2);
        object2 = d11 += d10;
        String string10 = "type";
        charSequence.put(string10, (Double)object2);
        object2 = n12;
        String string11 = "ac";
        charSequence.put(string11, (Integer)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string5);
        ((StringBuilder)object2).append(string7);
        ((StringBuilder)object2).append(string6);
        object2 = ((StringBuilder)object2).toString();
        n10 = sQLiteDatabase2.update(string4, (ContentValues)charSequence, (String)object2, null);
        if (n10 > 0) return;
        object2 = "id";
        charSequence.put((String)object2, string7);
        sQLiteDatabase2.insert(string4, null, (ContentValues)charSequence);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, List list) {
        boolean bl2;
        this.d = false;
        this.e = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            String string3 = m;
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase((String)string3, null);
        }
        catch (Throwable throwable) {}
        if (string2 != null && sQLiteDatabase != null) {
            this.a(string2, sQLiteDatabase);
        }
        if (list != null && sQLiteDatabase != null) {
            this.a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase != null && (bl2 = sQLiteDatabase.isOpen())) {
            sQLiteDatabase.close();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(List var1_1, SQLiteDatabase var2_2) {
        block66: {
            block62: {
                var3_3 = this;
                var4_4 = var2_2;
                System.currentTimeMillis();
                var5_6 = 0;
                var6_7 = 0.0f;
                var7_8 = null;
                this.e = false;
                if (var1_1 == null || (var8_9 = var1_1.size()) == 0 || var2_2 == null || var1_1 == null) break block66;
                var8_9 = 8;
                var9_10 /* !! */  = new double[var8_9];
                var10_11 = new StringBuffer();
                var11_12 = var1_1.iterator();
                var12_13 = 0;
                var13_14 = null;
                while (var14_15 = var11_12.hasNext()) {
                    var15_16 = (ScanResult)var11_12.next();
                    var16_17 = 10;
                    if (var12_13 > var16_17) break;
                    if (var12_13 > 0) {
                        var17_18 = ",";
                        var10_11.append(var17_18);
                    }
                    ++var12_13;
                    var15_16 = var15_16.BSSID;
                    var18_19 = "";
                    var15_16 = Jni.encode2(var15_16.replace(":", var18_19));
                    var17_18 = "\"";
                    var10_11.append(var17_18);
                    var10_11.append((String)var15_16);
                    var10_11.append(var17_18);
                }
                var11_12 = null;
                var13_14 = new StringBuilder();
                var15_16 = "select * from wof where id in (";
                var13_14.append((String)var15_16);
                var10_11 = var10_11.toString();
                var13_14.append((String)var10_11);
                var10_11 = ");";
                var13_14.append((String)var10_11);
                var10_11 = var13_14.toString();
                var11_12 = var4_4.rawQuery((String)var10_11, null);
                try {
                    var19_20 = var11_12.moveToFirst();
                    if (!var19_20) break block62;
                    var20_21 = 0.0;
                    var19_20 = false;
                    var4_4 = null;
                    var22_22 = false;
                    var10_11 = null;
                    var23_23 = 0;
                    var24_24 = 0;
                    var25_25 = var20_21;
                }
                catch (Throwable var4_5) {
                    if (var11_12 != null) {
                        var11_12.close();
                    }
lbl255:
                    // 4 sources

                    throw var4_5;
                }
                catch (Exception v0) {
                    if (var11_12 != null) {
                        ** continue;
                    }
                    break block66;
                }
                while (true) {
                    block68: {
                        block67: {
                            block65: {
                                block64: {
                                    block63: {
                                        var27_26 = var11_12.isAfterLast();
                                        var28_27 = 1;
                                        if (var27_26 != 0) break;
                                        var29_28 = var11_12.getDouble(var28_27);
                                        var31_29 = 113.2349;
                                        var29_28 -= var31_29;
                                        var27_26 = 2;
                                        var33_30 = 2.8E-45f;
                                        var31_29 = var11_12.getDouble(var27_26);
                                        var34_31 = 432.1238;
                                        var31_29 -= var34_31;
                                        var27_26 = 4;
                                        var33_30 = 5.6E-45f;
                                        var5_6 = var11_12.getInt(var27_26);
                                        var27_26 = 5;
                                        var33_30 = 7.0E-45f;
                                        var27_26 = var11_12.getInt(var27_26);
                                        if (var27_26 <= var8_9 || var27_26 <= var5_6) break block63;
                                        var11_12.moveToNext();
                                        var36_32 = var9_10 /* !! */ ;
                                    }
                                    var5_6 = (int)var3_3.d;
                                    if (var5_6 == 0) break block64;
                                    var7_8 = new float[var28_27];
                                    var36_32 = var9_10 /* !! */ ;
                                    var37_33 = var3_3.h;
                                    var39_34 = var3_3.g;
                                    var34_31 = var31_29;
                                    var41_35 = var37_33;
                                    var43_36 = var39_34;
                                    Location.distanceBetween((double)var31_29, (double)var29_28, (double)var37_33, (double)var39_34, (float[])var7_8);
                                    var8_9 = 0;
                                    var6_7 = var7_8[0];
                                    var45_37 = var6_7;
                                    var39_34 = var3_3.f;
                                    var34_31 = 2000.0;
                                    cfr_temp_0 = var45_37 - (var39_34 += var34_31);
                                    var5_6 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1));
                                    if (var5_6 > 0) lbl-1000:
                                    // 2 sources

                                    {
                                        while (true) {
                                            var11_12.moveToNext();
                                            break block65;
                                            break;
                                        }
                                    }
                                    var25_25 += var29_28;
                                    var20_21 += var31_29;
                                    ++var24_24;
                                    var19_20 = true;
                                    break block67;
                                }
                                var36_32 = var9_10 /* !! */ ;
                                var5_6 = 1148846080;
                                var6_7 = 1000.0f;
                                if (!var19_20) break block68;
                                var8_9 = 1;
                                var9_10 /* !! */  = new float[var8_9];
                                var39_34 = var24_24;
                                var41_35 = var20_21 / var39_34;
                                var43_36 = var25_25 / var39_34;
                                var34_31 = var31_29;
                                Location.distanceBetween((double)var31_29, (double)var29_28, (double)var41_35, (double)var43_36, (float[])var9_10 /* !! */ );
                                var8_9 = 0;
                                var47_38 = (float)var9_10 /* !! */ [0];
                                var5_6 = (int)(var47_38 == var6_7 ? 0 : (var47_38 > var6_7 ? 1 : -1));
                                if (var5_6 > 0) {
                                    ** continue;
                                }
                                break block67;
                            }
                            var9_10 /* !! */  = var36_32;
                            var5_6 = 0;
                            var6_7 = 0.0f;
                            var7_8 = null;
                            var8_9 = 8;
                            continue;
                        }
                        var5_6 = 8;
                        var6_7 = 1.1E-44f;
                        var8_9 = 4;
                        ** GOTO lbl175
                    }
                    if (!var22_22) {
                        var5_6 = var23_23 + 1;
                        var9_10 /* !! */ [var23_23] = var29_28;
                        var23_23 = var5_6 + 1;
                        var9_10 /* !! */ [var5_6] = var31_29;
                        var5_6 = 8;
                        var6_7 = 1.1E-44f;
                        var8_9 = 4;
                        var22_22 = true;
lbl175:
                        // 2 sources

                        var28_27 = 0;
                    } else {
                        for (var8_9 = 0; var8_9 < var23_23; var8_9 += 2) {
                            var48_39 = 1;
                            var47_38 = 1.4E-45f;
                            var49_40 = new float[var48_39];
                            var48_39 = var8_9 + 1;
                            var41_35 = var36_32[var48_39];
                            var43_36 = var36_32[var8_9];
                            var34_31 = var31_29;
                            Location.distanceBetween((double)var31_29, (double)var29_28, (double)var41_35, (double)var43_36, (float[])var49_40);
                            var28_27 = 0;
                            var33_30 = var49_40[0];
                            var27_26 = (int)(var33_30 == var6_7 ? 0 : (var33_30 < var6_7 ? -1 : 1));
                            if (var27_26 >= 0) continue;
                            var34_31 = var36_32[var8_9];
                            var25_25 += var34_31;
                            var34_31 = var36_32[var48_39];
                            var20_21 += var34_31;
                            ++var24_24;
                            var19_20 = true;
                        }
                        var28_27 = 0;
                        if (var19_20) {
                            var25_25 += var29_28;
                            var20_21 += var31_29;
                            ++var24_24;
                            var5_6 = 8;
                            var6_7 = 1.1E-44f;
lbl211:
                            // 2 sources

                            while (true) {
                                var8_9 = 4;
                                break;
                            }
                        } else {
                            var5_6 = 8;
                            var6_7 = 1.1E-44f;
                            if (var23_23 >= var5_6) break;
                            var8_9 = var23_23 + 1;
                            var36_32[var23_23] = var29_28;
                            var23_23 = var8_9 + 1;
                            var36_32[var8_9] = var31_29;
                            ** continue;
                        }
                    }
                    if (var24_24 > var8_9) break;
                    var11_12.moveToNext();
                    var8_9 = var5_6;
                    var5_6 = 0;
                    var7_8 = null;
                    var6_7 = 0.0f;
                    var9_10 /* !! */  = var36_32;
                    continue;
                    break;
                }
                if (var24_24 > 0) {
                    var19_20 = true;
                    var3_3.e = var19_20;
                    var45_37 = var24_24;
                    var25_25 /= var45_37;
                    var3_3.i = var25_25;
                    var20_21 /= var45_37;
                    var3_3.j = var20_21;
                }
            }
            if (var11_12 == null) break block66;
lbl247:
            // 2 sources

            while (true) {
                var11_12.close();
                break block66;
                break;
            }
            catch (Exception v1) {}
        }
        return;
        {
            catch (Exception v2) {
                ** continue;
            }
        }
    }

    public static /* synthetic */ boolean a(a a10, boolean bl2) {
        a10.k = bl2;
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String b(boolean var1_1) {
        var2_2 = this.e;
        var3_3 = 0.0;
        var5_4 = 1;
        var6_5 = 1.4E-45f;
        if (var2_2 != 0) {
            var3_3 = this.i;
            var7_6 = this.j;
            var9_7 = 246.4;
lbl9:
            // 2 sources

            while (true) {
                var2_2 = var5_4;
                break;
            }
        } else {
            var2_2 = this.d;
            if (var2_2 != 0) {
                var3_3 = this.g;
                var7_6 = this.h;
                var9_7 = this.f;
                ** continue;
            }
            var7_6 = var3_3;
            var9_7 = var3_3;
            var2_2 = 0;
            var11_8 = null;
        }
        var12_9 = var2_2;
        var13_10 = "{\"result\":{\"time\":\"";
        if (var2_2 != 0) {
            var2_2 = 3;
            var14_11 = 2;
            var15_12 = 4;
            var16_13 = "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
            var17_14 = "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":";
            if (var1_1) {
                var18_15 /* !! */  = new StringBuilder();
                var18_15 /* !! */ .append((String)var13_10);
                var13_10 = com.baidu.location.h.l.a();
                var18_15 /* !! */ .append((String)var13_10);
                var18_15 /* !! */ .append(var17_14);
                var18_15 /* !! */ .append(var16_13);
                var18_15 /* !! */  = var18_15 /* !! */ .toString();
                var13_10 = Locale.CHINA;
                var19_16 = new Object[var15_12];
                var20_18 /* !! */  = var3_3;
                var19_16[0] = var20_18 /* !! */ ;
                var20_18 /* !! */  = var7_6;
                var19_16[var5_4] = var20_18 /* !! */ ;
                var20_18 /* !! */  = var9_7;
                var19_16[var14_11] = var20_18 /* !! */ ;
                var20_18 /* !! */  = Boolean.TRUE;
                var19_16[var2_2] = var20_18 /* !! */ ;
                var11_8 = String.format((Locale)var13_10, (String)var18_15 /* !! */ , var19_16);
            } else {
                var11_8 = new StringBuilder();
                var11_8.append((String)var13_10);
                var13_10 = com.baidu.location.h.l.a();
                var11_8.append((String)var13_10);
                var11_8.append(var17_14);
                var11_8.append(var16_13);
                var11_8 = var11_8.toString();
                var13_10 = Locale.CHINA;
                var19_17 = new Object[var15_12];
                var20_19 /* !! */  = var3_3;
                var19_17[0] = var20_19 /* !! */ ;
                var20_19 /* !! */  = var7_6;
                var19_17[var5_4] = var20_19 /* !! */ ;
                var20_19 /* !! */  = var9_7;
                var19_17[var14_11] = var20_19 /* !! */ ;
                var20_19 /* !! */  = Boolean.valueOf((boolean)var12_9);
                var21_21 = 3;
                var19_17[var21_21] = var20_19 /* !! */ ;
                var11_8 = String.format((Locale)var13_10, (String)var11_8, var19_17);
            }
        } else {
            if (var1_1) {
                var11_8 = new StringBuilder();
                var11_8.append((String)var13_10);
                var20_20 = com.baidu.location.h.l.a();
                var11_8.append(var20_20);
                var20_20 = "\",\"error\":\"67\"}}";
            } else {
                var11_8 = new StringBuilder();
                var11_8.append((String)var13_10);
                var20_20 = com.baidu.location.h.l.a();
                var11_8.append(var20_20);
                var20_20 = "\",\"error\":\"63\"}}";
            }
            var11_8.append(var20_20);
            var11_8 = var11_8.toString();
        }
        return var11_8;
    }

    public static /* synthetic */ String d() {
        return m;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e() {
        void var3_6;
        int n10 = 0;
        Object[] objectArray = null;
        try {
            String string2 = m;
            SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase((String)string2, null);
        }
        catch (Exception exception) {
            Object var3_5 = null;
        }
        if (var3_6 == null) {
            return;
        }
        Object object = "wof";
        try {
            long l10 = DatabaseUtils.queryNumEntries((SQLiteDatabase)var3_6, (String)object);
            String string3 = "bdcltb09";
            long l11 = DatabaseUtils.queryNumEntries((SQLiteDatabase)var3_6, (String)string3);
            long l12 = 10000L;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            int n11 = 1;
            if (l13 > 0) {
                l13 = n11;
            } else {
                l13 = 0;
                object = null;
            }
            long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l14 > 0) {
                l14 = n11;
            } else {
                l14 = 0;
                string3 = null;
            }
            var3_6.close();
            if (l13 == false) {
                if (l14 == false) return;
            }
            a$a a$a = new a$a(this, null);
            n10 = 2;
            objectArray = new Boolean[n10];
            objectArray[0] = object = Boolean.valueOf((boolean)l13);
            objectArray[n11] = object = Boolean.valueOf((boolean)l14);
            a$a.execute(objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public BDLocation a(String object, List object2, boolean bl2) {
        bl2 = this.a;
        String string2 = "\",\"error\":\"67\"}}";
        String string3 = "{\"result\":{\"time\":\"";
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            object2 = com.baidu.location.h.l.a();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            object2 = new BDLocation((String)object);
            return object2;
        }
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append(string3);
        string3 = com.baidu.location.h.l.a();
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append(string2);
        object3 = ((StringBuilder)object3).toString();
        this.a((String)object, (List)object2);
        boolean bl3 = true;
        try {
            object = this.b(bl3);
            if (object != null) {
                object3 = object;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        object = new BDLocation((String)object3);
        return object;
    }

    public BDLocation a(boolean bl2) {
        int n10;
        CharSequence charSequence;
        int n11;
        bl2 = this.a;
        if (!bl2) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append("{\"result\":{\"time\":\"");
            Object object = com.baidu.location.h.l.a();
            charSequence2.append((String)object);
            charSequence2.append("\",\"error\":\"67\"}}");
            charSequence2 = charSequence2.toString();
            object = new BDLocation((String)charSequence2);
            return object;
        }
        Object object = com.baidu.location.f.b.a().f();
        Object object2 = null;
        if (object != null && (n11 = ((com.baidu.location.f.a)object).e()) != 0) {
            charSequence = ((com.baidu.location.f.a)object).g();
        } else {
            n11 = 0;
            charSequence = null;
        }
        Object object3 = com.baidu.location.f.i.a().o();
        int n12 = 1;
        if (object3 != null) {
            object2 = ((h)object3).a;
            object2 = this.a((String)charSequence, (List)object2, n12 != 0);
        }
        if (object2 != null && (n11 = ((BDLocation)object2).getLocType()) == (n10 = 66)) {
            n10 = 1024;
            charSequence = new StringBuffer(n10);
            Locale locale = Locale.CHINA;
            int n13 = 3;
            Object[] objectArray = new Object[n13];
            double d10 = ((BDLocation)object2).getLatitude();
            Number number = d10;
            objectArray[0] = number;
            double d11 = ((BDLocation)object2).getLongitude();
            number = d11;
            objectArray[n12] = number;
            n12 = 2;
            float f10 = ((BDLocation)object2).getRadius();
            number = Float.valueOf(f10);
            objectArray[n12] = number;
            String string2 = String.format(locale, "&ofl=%f|%f|%f", objectArray);
            ((StringBuffer)charSequence).append(string2);
            if (object3 != null && (n12 = ((h)object3).a()) > 0) {
                string2 = "&wf=";
                ((StringBuffer)charSequence).append(string2);
                n12 = 15;
                object3 = ((h)object3).b(n12);
                ((StringBuffer)charSequence).append((String)object3);
            }
            if (object != null) {
                object = ((com.baidu.location.f.a)object).i();
                ((StringBuffer)charSequence).append((String)object);
            }
            ((StringBuffer)charSequence).append("&uptype=oldoff");
            object = com.baidu.location.h.l.f(com.baidu.location.f.getServiceContext());
            ((StringBuffer)charSequence).append((String)object);
            object = com.baidu.location.h.b.a().a(false);
            ((StringBuffer)charSequence).append((String)object);
            object = com.baidu.location.b.b.a().d();
            ((StringBuffer)charSequence).append((String)object);
            ((StringBuffer)charSequence).toString();
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(String var1_1, com.baidu.location.f.a var2_2, h var3_3, BDLocation var4_4) {
        var5_5 = this.a;
        if (var5_5 == 0) {
            return;
        }
        var5_5 = var2_2.b();
        var6_6 = 1;
        var7_7 = 1.4E-45f;
        if (var5_5 != 0 && (var5_5 = (var8_8 /* !! */  = o.c()).i()) != 0) {
            var5_5 = 0;
            var8_8 /* !! */  = null;
        } else {
            var5_5 = var6_6;
        }
        if (var4_4 == null) ** GOTO lbl-1000
        var9_9 = var4_4.getLocType();
        var10_10 = 161;
        var11_11 = 2.26E-43f;
        if (var9_9 != var10_10) ** GOTO lbl-1000
        var13_13 = "wf";
        var12_12 = var4_4.getNetworkLocationType();
        var9_9 = (int)var13_13.equals(var12_12);
        if (var9_9 != 0) ** GOTO lbl-1000
        var14_14 = var4_4.getRadius();
        var10_10 = 1133903872;
        var11_11 = 300.0f;
        cfr_temp_0 = var14_14 - var11_11;
        var9_9 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
        if (var9_9 < 0) lbl-1000:
        // 2 sources

        {
            var9_9 = 0;
            var12_12 = null;
            var14_14 = 0.0f;
        } else lbl-1000:
        // 3 sources

        {
            var9_9 = var6_6;
            var14_14 = var7_7;
        }
        var13_13 = var3_3.a;
        if (var13_13 == null) {
            var9_9 = var6_6;
            var14_14 = var7_7;
        }
        if (var5_5 != 0 && var9_9 != 0) {
            return;
        }
        var5_5 = (int)this.k;
        if (var5_5 != 0) {
            return;
        }
        this.k = var6_6;
        var8_8 /* !! */  = new a$b(this, null);
        var12_12 = new Object[4];
        var12_12[0] = var1_1;
        var12_12[var6_6] = var2_2;
        var12_12[2] = var3_3;
        var12_12[3] = var4_4;
        var8_8 /* !! */ .execute(var12_12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        try {
            boolean bl2;
            Object object = l;
            File file = new File((String)object);
            String string2 = m;
            object = new File(string2);
            boolean bl3 = file.exists();
            if (!bl3) {
                file.mkdirs();
            }
            if (!(bl2 = ((File)object).exists())) {
                ((File)object).createNewFile();
            }
            bl2 = ((File)object).exists();
            int n10 = 1;
            if (bl2) {
                bl2 = false;
                file = null;
                file = SQLiteDatabase.openOrCreateDatabase((File)object, null);
                object = "CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);";
                file.execSQL((String)object);
                object = "CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);";
                file.execSQL((String)object);
                file.setVersion(n10);
                file.close();
            }
            this.a = n10;
            return;
        }
        catch (Throwable throwable) {
            boolean bl4 = false;
            Object var1_2 = null;
            this.a = false;
        }
    }

    public void c() {
        Handler handler = this.n;
        if (handler == null) {
            this.n = handler = new Handler();
        }
        handler = this.n;
        b b10 = new b(this);
        handler.postDelayed((Runnable)b10, 3000L);
    }
}

