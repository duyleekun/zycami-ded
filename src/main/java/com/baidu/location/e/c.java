/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.e.c$a;
import com.baidu.location.e.c$c;
import com.baidu.location.e.d;
import com.baidu.location.e.h;
import com.baidu.location.e.j;
import com.baidu.location.e.j$a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private final h a;
    private int b;
    private double c;
    private double d;
    private Long e;
    private final c$c f;
    private final c$c g;
    private final SQLiteDatabase h;
    private final SQLiteDatabase i;
    private StringBuffer j;
    private StringBuffer k;
    private HashSet l;
    private ConcurrentHashMap m;
    private ConcurrentHashMap n;
    private StringBuffer o;
    private boolean p;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c(h object) {
        String string2;
        StringBuffer stringBuffer;
        this.a = object;
        this.p = false;
        boolean bl2 = true;
        Object object2 = new c$c(this, this, bl2);
        this.f = object2;
        object2 = new c$c(this, this, false);
        this.g = object2;
        this.o = stringBuffer = new StringBuffer();
        stringBuffer = null;
        this.j = null;
        this.k = null;
        object2 = new HashSet();
        this.l = object2;
        this.m = object2;
        super();
        this.n = object2;
        try {
            object = ((h)object).c();
            string2 = "ofl_location.db";
            super((File)object, string2);
            boolean bl3 = ((File)object2).exists();
            if (!bl3) {
                ((File)object2).createNewFile();
            }
            object = SQLiteDatabase.openOrCreateDatabase((File)object2, null);
        }
        catch (Exception exception) {
            boolean bl4 = false;
            object = null;
        }
        this.h = object;
        if (object != null) {
            object2 = "CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);";
            try {
                object.execSQL((String)object2);
                object2 = "CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);";
                object.execSQL((String)object2);
            }
            catch (Exception exception) {}
        }
        try {
            object2 = this.a;
            object2 = ((h)object2).c();
            string2 = "ofl_statistics.db";
            object = new File((File)object2, string2);
            boolean bl5 = ((File)object).exists();
            if (!bl5) {
                ((File)object).createNewFile();
            }
            stringBuffer = SQLiteDatabase.openOrCreateDatabase((File)object, null);
        }
        catch (Exception exception) {}
        this.i = stringBuffer;
        if (stringBuffer == null) return;
        object = "CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);";
        try {
            stringBuffer.execSQL((String)object);
            object = "CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);";
            stringBuffer.execSQL((String)object);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private double a(double d10, double d11, double d12, double d13) {
        double d14 = d13 - d11;
        double d15 = d12 - d10;
        d10 = Math.toRadians(d10);
        Math.toRadians(d11);
        d11 = Math.toRadians(d12);
        Math.toRadians(d13);
        d12 = Math.toRadians(d14);
        d13 = Math.toRadians(d15);
        d14 = 2.0;
        d15 = Math.sin(d13 /= d14);
        d13 = Math.sin(d13);
        d15 *= d13;
        d10 = Math.cos(d10);
        d11 = Math.cos(d11);
        d10 *= d11;
        d11 = Math.sin(d12 /= d14);
        d10 *= d11;
        d11 = Math.sin(d12);
        d10 = Math.sqrt(d15 += (d10 *= d11));
        d11 = Math.sqrt(1.0 - d15);
        return Math.atan2(d10, d11) * d14 * 6378137.0;
    }

    /*
     * Unable to fully structure code
     */
    private int a(ArrayList var1_1, double var2_2) {
        var4_3 = var1_1;
        var5_4 = var1_1.size();
        var6_5 = 0;
        if (var5_4 == 0) {
            return 0;
        }
        var5_4 = 0;
        while (true) {
            if ((var7_6 = var1_1.size()) < (var8_7 = 3)) ** GOTO lbl-1000
            var9_8 = 0.0;
            var12_10 = var9_8;
            for (var11_9 = 0; var11_9 < (var14_11 = var1_1.size()); ++var11_9) {
                var15_12 = ((c$a)var4_3.get((int)var11_9)).a;
                var9_8 += var15_12;
                var17_13 = (c$a)var4_3.get(var11_9);
                var15_12 = var17_13.b;
                var12_10 += var15_12;
            }
            var18_14 = var1_1.size();
            var9_8 /= var18_14;
            var11_9 = var1_1.size();
            var18_14 = var11_9;
            var12_10 /= var18_14;
            var18_14 = -1.0;
            var20_15 = -1;
            var21_16 = 0;
            var22_17 = var20_15;
            while (var21_16 < (var20_15 = var1_1.size())) {
                var23_18 = ((c$a)var4_3.get((int)var21_16)).b;
                var25_19 = (c$a)var4_3.get(var21_16);
                var26_20 = var9_8;
                var28_21 = var25_19.a;
                var25_19 = this;
                var30_22 = var23_18;
                var23_18 = var12_10;
                var8_7 = var21_16;
                cfr_temp_0 = (var28_21 = this.a(var12_10, var9_8, var30_22, var28_21)) - var18_14;
                var20_15 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1));
                if (var20_15 > 0) {
                    var18_14 = var28_21;
                    var22_17 = var21_16;
                }
                var21_16 = var8_7 + 1;
                var9_8 = var26_20;
                var6_5 = 0;
            }
            var6_5 = (int)(var18_14 == var2_2 ? 0 : (var18_14 > var2_2 ? 1 : -1));
            if (var6_5 > 0 && var22_17 >= 0 && var22_17 < (var6_5 = var1_1.size())) {
                ++var5_4;
                var4_3.remove(var22_17);
                var6_5 = 1;
            } else lbl-1000:
            // 2 sources

            {
                var6_5 = 0;
            }
            var7_6 = 1;
            if (var6_5 != var7_6) {
                return var5_4;
            }
            var6_5 = 0;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private BDLocation a(Long l10) {
        int n10;
        double d10;
        double d11;
        int n11;
        Object object;
        String string2;
        block29: {
            double d12;
            Object object2;
            int n12;
            block30: {
                long l11;
                long l12;
                block25: {
                    block26: {
                        void var3_6;
                        boolean bl2;
                        block24: {
                            block23: {
                                block22: {
                                    Object object3;
                                    Object object4;
                                    Long l13;
                                    c c10;
                                    block28: {
                                        c10 = this;
                                        l13 = l10;
                                        n12 = 0;
                                        this.p = false;
                                        object2 = this.e;
                                        string2 = "cl";
                                        object = null;
                                        n11 = 1;
                                        if (object2 == null || !(bl2 = ((Long)object2).equals(l10))) break block28;
                                        d11 = this.c;
                                        d10 = this.d;
                                        n10 = this.b;
                                        break block29;
                                    }
                                    object2 = Locale.US;
                                    int n13 = 3;
                                    Object[] objectArray = new Object[n13];
                                    objectArray[0] = l13;
                                    objectArray[n11] = object4 = Integer.valueOf(15552000);
                                    int n14 = 2;
                                    l12 = System.currentTimeMillis();
                                    long l14 = 1000L;
                                    objectArray[n14] = object3 = Long.valueOf(l12 /= l14);
                                    object4 = "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;";
                                    object2 = String.format((Locale)object2, (String)object4, objectArray);
                                    l11 = 0L;
                                    d10 = 0.0;
                                    object3 = c10.h;
                                    object2 = object3.rawQuery((String)object2, null);
                                    if (object2 == null) break block22;
                                    int n15 = object2.moveToFirst();
                                    if (n15 == 0) break block22;
                                    n15 = object2.getColumnIndex(string2);
                                    d12 = object2.getDouble(n15);
                                    double d13 = d12 - d10;
                                    if ((n15 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1))) <= 0) break block22;
                                    object3 = "x";
                                    try {
                                        n15 = object2.getColumnIndex((String)object3);
                                        d12 = object2.getDouble(n15);
                                        String string3 = "y";
                                        int n16 = object2.getColumnIndex(string3);
                                        d10 = object2.getDouble(n16);
                                        string3 = "r";
                                        n16 = object2.getColumnIndex(string3);
                                        n12 = object2.getInt(n16);
                                        string3 = "timestamp";
                                        n16 = object2.getColumnIndex(string3);
                                        n16 = object2.getInt(n16);
                                        int n17 = 604800;
                                        long l15 = n16 += n17;
                                        long l16 = System.currentTimeMillis();
                                        long l17 = l15 - (l16 /= l14);
                                        long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                                        if (l18 < 0) {
                                            c10.p = n11;
                                        }
                                        l18 = 2000;
                                        int n18 = 300;
                                        if (n12 < n18) {
                                            n12 = n18;
                                        } else if (l18 < n12) {
                                            n12 = (int)l18;
                                        }
                                        c10.c = d12;
                                        c10.d = d10;
                                        c10.b = n12;
                                        c10.e = l13;
                                        double d14 = d10;
                                        d10 = d12;
                                        d12 = d14;
                                        break block23;
                                    }
                                    catch (Throwable throwable) {
                                        object = object2;
                                        break block24;
                                    }
                                    catch (Exception exception) {
                                        n11 = 0;
                                        break block25;
                                    }
                                }
                                n11 = 0;
                                l12 = l11;
                                d12 = d10;
                            }
                            if (object2 == null) break block26;
                            try {
                                object2.close();
                                break block26;
                            }
                            catch (Exception exception) {}
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        if (object == null) throw var3_6;
                        try {
                            object.close();
                        }
                        catch (Exception exception) {
                            throw var3_6;
                        }
                        throw var3_6;
                        catch (Exception exception) {
                            n11 = 0;
                            bl2 = false;
                            object2 = null;
                        }
                        break block25;
                    }
                    n10 = n12;
                    d11 = d10;
                    d10 = d12;
                    break block29;
                    catch (Exception exception) {}
                }
                l12 = l11;
                d12 = d10;
                break block30;
                catch (Exception exception) {}
            }
            if (object2 != null) {
                try {
                    object2.close();
                }
                catch (Exception exception) {}
            }
            n10 = n12;
            d11 = d12;
        }
        if (n11 == 0) return object;
        object = new BDLocation();
        float f10 = n10;
        ((BDLocation)object).setRadius(f10);
        ((BDLocation)object).setLatitude(d10);
        ((BDLocation)object).setLongitude(d11);
        ((BDLocation)object).setNetworkLocationType(string2);
        n10 = 66;
        f10 = 9.2E-44f;
        ((BDLocation)object).setLocType(n10);
        return object;
    }

    /*
     * Exception decompiling
     */
    private BDLocation a(LinkedHashMap var1_1, BDLocation var2_2, int var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 29[TRYBLOCK] [65, 64 : 792->800)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    public static /* synthetic */ h a(c c10) {
        return c10.a;
    }

    public static /* synthetic */ StringBuffer a(c c10, StringBuffer stringBuffer) {
        c10.j = stringBuffer;
        return stringBuffer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String string2, Long l10) {
        SQLiteDatabase sQLiteDatabase;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        SQLiteDatabase sQLiteDatabase2;
        Object object;
        int n10;
        c c10 = this;
        if (bDLocation == null) return;
        int n11 = bDLocation.getLocType();
        if (n11 != (n10 = 161)) return;
        int n12 = 1;
        if (bDLocation2 != null && (object = bDLocation.getNetworkLocationType()) != null && (n11 = (int)(((String)(object = bDLocation.getNetworkLocationType())).equals(sQLiteDatabase2 = "cl") ? 1 : 0)) != 0) {
            d15 = bDLocation2.getLatitude();
            d14 = bDLocation2.getLongitude();
            d13 = bDLocation.getLatitude();
            d12 = bDLocation.getLongitude();
            object = this;
            d11 = this.a(d15, d14, d13, d12);
            double d16 = d11 - (d10 = 300.0);
            n11 = (int)(d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1));
            if (n11 > 0) {
                object = Locale.US;
                sQLiteDatabase2 = new Object[n12];
                sQLiteDatabase2[0] = l10;
                sQLiteDatabase2 = String.format((Locale)object, "UPDATE CL SET cl = 0 WHERE id = %d;", (Object[])sQLiteDatabase2);
                int n13 = 3;
                sQLiteDatabase = new Object[n13];
                sQLiteDatabase[0] = l10;
                sQLiteDatabase[n12] = string2;
                int n14 = 2;
                int n15 = 100000;
                Integer n16 = n15;
                sQLiteDatabase[n14] = n16;
                String string3 = "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);";
                object = String.format((Locale)object, string3, (Object[])sQLiteDatabase);
                try {
                    sQLiteDatabase = this.h;
                    sQLiteDatabase.execSQL((String)sQLiteDatabase2);
                    sQLiteDatabase2 = this.i;
                    sQLiteDatabase2.execSQL((String)object);
                }
                catch (Exception exception) {}
            }
        }
        if (bDLocation3 == null) return;
        object = bDLocation.getNetworkLocationType();
        if (object == null) return;
        object = bDLocation.getNetworkLocationType();
        n11 = (int)(((String)object).equals(sQLiteDatabase2 = "wf") ? 1 : 0);
        if (n11 == 0) return;
        d15 = bDLocation3.getLatitude();
        d14 = bDLocation3.getLongitude();
        d13 = bDLocation.getLatitude();
        d12 = bDLocation.getLongitude();
        object = this;
        d11 = this.a(d15, d14, d13, d12);
        double d17 = d11 - (d10 = 100.0);
        n11 = (int)(d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1));
        if (n11 <= 0) return;
        object = "UPDATE AP SET cl = 0 WHERE id In (%s);";
        try {
            sQLiteDatabase2 = new Object[n12];
            sQLiteDatabase = c10.j;
            sQLiteDatabase = sQLiteDatabase.toString();
            sQLiteDatabase2[0] = sQLiteDatabase;
            object = String.format((String)object, (Object[])sQLiteDatabase2);
            sQLiteDatabase2 = "INSERT OR REPLACE INTO AP VALUES %s;";
            sQLiteDatabase = new Object[n12];
            StringBuffer stringBuffer = c10.k;
            String string4 = stringBuffer.toString();
            sQLiteDatabase[0] = string4;
            sQLiteDatabase2 = String.format((String)sQLiteDatabase2, (Object[])sQLiteDatabase);
            sQLiteDatabase = c10.h;
            sQLiteDatabase.execSQL((String)object);
            object = c10.i;
            object.execSQL((String)sQLiteDatabase2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ void a(c c10, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String string2, Long l10) {
        c10.a(bDLocation, bDLocation2, bDLocation3, string2, l10);
    }

    public static /* synthetic */ void a(c c10, String string2, Long l10, BDLocation bDLocation) {
        c10.a(string2, l10, bDLocation);
    }

    public static /* synthetic */ void a(c c10, String string2, String string3, String string4) {
        c10.a(string2, string3, string4);
    }

    public static /* synthetic */ void a(c c10, LinkedHashMap linkedHashMap) {
        c10.a(linkedHashMap);
    }

    public static /* synthetic */ void a(c c10, String[] stringArray) {
        c10.a(stringArray);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(String var1_1, Long var2_2, BDLocation var3_3) {
        if (var1_1 == null) ** GOTO lbl48
        var4_4 = "UPDATE CL SET frequency=frequency+1 WHERE id = %d;";
        var5_5 = 2;
        var6_6 = 1;
        if (var3_3 != null) {
            var3_3 = Locale.US;
            var7_7 = new Object[var6_6];
            var7_7[0] = var2_2;
            var3_3 = String.format((Locale)var3_3, (String)var4_4, var7_7);
            var4_4 = this.h;
lbl12:
            // 2 sources

            while (true) {
                var4_4.execSQL((String)var3_3);
                break;
            }
        } else {
            var3_3 = Locale.US;
            var7_8 /* !! */  = new Object[var5_5];
            var7_8 /* !! */ [0] = var2_2;
            var7_8 /* !! */ [var6_6] = var1_1;
            var7_8 /* !! */  = String.format((Locale)var3_3, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", var7_8 /* !! */ );
            var8_9 = new Object[var6_6];
            var8_9[0] = var2_2;
            var3_3 = String.format((Locale)var3_3, (String)var4_4, var8_9);
            try {
                var4_4 = this.i;
            }
            catch (Exception v0) {}
            var4_4.execSQL((String)var7_8 /* !! */ );
            var4_4 = this.i;
            ** continue;
        }
        var9_10 = this.p;
        if (!var9_10) ** GOTO lbl48
        var3_3 = Locale.US;
        var10_11 = 3;
        var4_4 = new Object[var10_11];
        var4_4[0] = var2_2;
        var4_4[var6_6] = var1_1;
        var11_12 = 100000;
        var1_1 = var11_12;
        var4_4[var5_5] = var1_1;
        var1_1 = String.format((Locale)var3_3, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", (Object[])var4_4);
        try {
            var2_2 = this.i;
        }
        catch (Exception v1) {
            ** continue;
        }
        var2_2.execSQL((String)var1_1);
lbl48:
        // 4 sources

    }

    private void a(String string2, String string3, String string4) {
        c$c.a(this.f, string2, string3, string4);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(LinkedHashMap serializable) {
        int n10;
        String string2;
        Object object;
        if (serializable == null) return;
        int n11 = ((HashMap)serializable).size();
        if (n11 <= 0) return;
        serializable = new StringBuffer();
        this.j = serializable;
        serializable = new StringBuffer();
        this.k = serializable;
        serializable = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        Object object2 = this.m;
        String string3 = null;
        int n12 = 1;
        if (object2 != null && (object2 = ((ConcurrentHashMap)object2).keySet()) != null) {
            char c10;
            object2 = this.m.keySet().iterator();
            int n13 = n12;
            int n14 = n12;
            while ((c10 = object2.hasNext()) != '\u0000') {
                try {
                    Object object3 = object2.next();
                    object3 = (Long)object3;
                    Object object4 = this.l;
                    boolean bl2 = ((HashSet)object4).contains(object3);
                    char c11 = '(';
                    char c12 = '\"';
                    char c13 = ',';
                    if (bl2) {
                        if (n13 != 0) {
                            n13 = 0;
                            object = null;
                        } else {
                            object4 = this.j;
                            ((StringBuffer)object4).append(c13);
                            object4 = this.k;
                            ((StringBuffer)object4).append(c13);
                        }
                        object4 = this.j;
                        ((StringBuffer)object4).append(object3);
                        object4 = this.n;
                        object4 = ((ConcurrentHashMap)object4).get(object3);
                        object4 = (String)object4;
                        StringBuffer stringBuffer2 = this.k;
                        stringBuffer2.append(c11);
                        stringBuffer2.append(object3);
                        stringBuffer2.append(c13);
                        stringBuffer2.append(c12);
                        stringBuffer2.append((String)object4);
                        stringBuffer2.append(c12);
                        stringBuffer2.append(c13);
                        c10 = '\u186a0';
                        stringBuffer2.append((int)c10);
                        c10 = ')';
                        stringBuffer2.append(c10);
                        continue;
                    }
                    object4 = this.n;
                    object4 = ((ConcurrentHashMap)object4).get(object3);
                    object4 = (String)object4;
                    if (n14 != 0) {
                        n14 = 0;
                        string2 = null;
                    } else {
                        ((StringBuffer)serializable).append(c13);
                        stringBuffer.append(c13);
                    }
                    ((StringBuffer)serializable).append(object3);
                    stringBuffer.append(c11);
                    stringBuffer.append(object3);
                    stringBuffer.append(c13);
                    stringBuffer.append(c12);
                    stringBuffer.append((String)object4);
                    stringBuffer.append(c12);
                    object3 = ",0)";
                    stringBuffer.append((String)object3);
                }
                catch (Exception exception) {}
            }
        }
        object2 = Locale.US;
        object = new Object[n12];
        string2 = this.j.toString();
        object[0] = string2;
        string2 = "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)";
        object2 = String.format(object2, string2, object);
        try {
            object = this.h;
            object.execSQL((String)object2);
        }
        catch (Exception exception) {}
        if ((object2 = this.o) != null && (n10 = ((StringBuffer)object2).length()) > 0) {
            n10 = stringBuffer.length();
            if (n10 > 0) {
                object2 = ",";
                stringBuffer.append((String)object2);
            }
            object2 = this.o;
            stringBuffer.append((StringBuffer)object2);
        }
        object2 = "INSERT OR IGNORE INTO AP VALUES %s;";
        try {
            object = new Object[n12];
            string2 = stringBuffer.toString();
            object[0] = string2;
            object2 = String.format((String)object2, object);
            object = "UPDATE AP SET frequency=frequency+1 WHERE id in (%s);";
            Object[] objectArray = new Object[n12];
            string2 = ((StringBuffer)serializable).toString();
            objectArray[0] = string2;
            string3 = String.format((String)object, objectArray);
            int n15 = stringBuffer.length();
            if (n15 > 0) {
                stringBuffer = this.i;
                stringBuffer.execSQL((String)object2);
            }
            if ((n11 = ((StringBuffer)serializable).length()) <= 0) return;
            serializable = this.i;
            serializable.execSQL(string3);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void a(String[] stringArray) {
        this.a.l().a(stringArray);
    }

    public static /* synthetic */ SQLiteDatabase b(c c10) {
        return c10.h;
    }

    public static /* synthetic */ StringBuffer b(c c10, StringBuffer stringBuffer) {
        c10.k = stringBuffer;
        return stringBuffer;
    }

    public static /* synthetic */ SQLiteDatabase c(c c10) {
        return c10.i;
    }

    public static /* synthetic */ c$c d(c c10) {
        return c10.g;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Cursor a(j$a var1_1) {
        block34: {
            block35: {
                var2_2 = this;
                var3_3 /* !! */  = var1_1;
                var4_4 = new BDLocation();
                var4_4.setLocType(67);
                var5_5 = var1_1.c;
                if (!var5_5) break block34;
                var6_6 = var1_1.b;
                var7_7 = var1_1.i;
                var8_8 = var1_1.f;
                var9_9 = var1_1.g;
                var10_10 = -9223372036854775808L;
                var12_11 = var10_10;
                var13_12 = var6_6 != null && (var13_12 = this.h) != null && (var12_11 = Jni.encode3(var6_6)) != null ? this.a((Long)var12_11) : null;
                if (var7_7 != null && (var14_13 = var7_7.size()) > 0 && (var15_14 = var2_2.h) != null) {
                    var2_2.m.clear();
                    var2_2.l.clear();
                    var2_2.n.clear();
                    var15_14 = var16_15 = var2_2.a(var7_7, (BDLocation)var13_12, var8_8);
                } else {
                    var14_13 = 0;
                    var15_14 = null;
                }
                var16_15 = "gcj02";
                var17_16 = "bd09ll2gcj";
                var18_17 = 1;
                if (var13_12 != null) {
                    var19_18 = var13_12.getLongitude();
                    var21_19 = var19_18;
                    var22_20 = var13_12.getLatitude();
                    var24_21 = var22_20;
                    var25_22 = var9_9;
                    var26_23 = var13_12.getLongitude();
                    var28_24 /* !! */  = var13_12.getLatitude();
                    var30_25 = Jni.coorEncrypt(var26_23, var28_24 /* !! */ , (String)var17_16);
                    var13_12.setCoorType((String)var16_15);
                    var28_24 /* !! */  = (double)var30_25[var18_17];
                    var13_12.setLatitude(var28_24 /* !! */ );
                    var31_26 = 0;
                    var9_9 = null;
                    var28_24 /* !! */  = (double)var30_25[0];
                    var13_12.setLongitude(var28_24 /* !! */ );
                    var30_25 = "cl";
                    var13_12.setNetworkLocationType((String)var30_25);
                } else {
                    var25_22 = var9_9;
                    var21_19 = null;
                    var24_21 = null;
                }
                if (var15_14 != null) {
                    var30_25 = var15_14.getLongitude();
                    var32_27 = var15_14.getLatitude();
                    var9_9 = var32_27;
                    var34_28 = var15_14.getLongitude();
                    var36_29 /* !! */  = var30_25;
                    var26_23 = var15_14.getLatitude();
                    var30_25 = Jni.coorEncrypt(var34_28, var26_23, (String)var17_16);
                    var15_14.setCoorType((String)var16_15);
                    var37_30 = var30_25[1];
                    var15_14.setLatitude((double)var37_30);
                    var8_8 = 0;
                    var39_31 = 0.0f;
                    var37_30 = var30_25[0];
                    var15_14.setLongitude((double)var37_30);
                    var16_15 = "wf";
                    var15_14.setNetworkLocationType((String)var16_15);
                    var30_25 = var36_29 /* !! */ ;
                } else {
                    var30_25 = null;
                    var31_26 = 0;
                    var9_9 = null;
                }
                if (var13_12 != null && var15_14 == null) {
                    var8_8 = 1;
                    var39_31 = 1.4E-45f;
                } else if (var13_12 == null && var15_14 != null) {
                    var8_8 = 2;
                    var39_31 = 2.8E-45f;
                } else if (var13_12 != null && var15_14 != null) {
                    var8_8 = 4;
                    var39_31 = 5.6E-45f;
                } else {
                    var8_8 = 0;
                    var39_31 = 0.0f;
                    var16_15 = null;
                }
                var40_32 = var3_3 /* !! */ .f;
                if (var40_32 > 0) {
                    var40_32 = 1;
                } else {
                    var40_32 = 0;
                    var17_16 = null;
                }
                if (var7_7 != null && (var18_17 = var7_7.size()) > 0) {
                    var18_17 = 0;
                    var41_33 = null;
                } else {
                    var18_17 = 1;
                }
                if (var40_32 == 0) break block35;
                if (var15_14 != null) ** GOTO lbl-1000
                if (var18_17 == 0 || var13_12 == null) ** GOTO lbl-1000
                ** GOTO lbl-1000
            }
            if (var15_14 != null) lbl-1000:
            // 2 sources

            {
                var21_19 = var30_25;
                var24_21 = var9_9;
                var30_25 = var15_14;
            } else if (var13_12 != null) lbl-1000:
            // 2 sources

            {
                var30_25 = var13_12;
            } else lbl-1000:
            // 2 sources

            {
                var30_25 = var4_4;
                var21_19 = null;
                var24_21 = null;
            }
            var31_26 = var3_3 /* !! */ .e;
            if (var31_26 != 0 && (var31_26 = (var9_9 = var2_2.a.l()).l()) != 0 && var24_21 != null && var21_19 != null) {
                var9_9 = var2_2.a.k();
                var34_28 = var21_19.doubleValue();
                var42_34 = var8_8;
                var43_35 = var39_31;
                var36_29 /* !! */  = var12_11;
                var44_37 = var24_21.doubleValue();
                var16_15 = var9_9.a(var34_28, var44_37);
                var30_25.setAddr((Address)var16_15);
            } else {
                var42_34 = var8_8;
                var43_36 = var39_31;
                var36_29 /* !! */  = var12_11;
            }
            if (var40_32 != 0 && (var8_8 = (int)var3_3 /* !! */ .e) != 0 && (var16_15 = var30_25.getAddrStr()) == null) {
                var30_25 = var4_4;
                var31_26 = 0;
                var9_9 = null;
                var21_19 = null;
                var24_21 = null;
            } else {
                var31_26 = var42_34;
            }
            var8_8 = (int)var3_3 /* !! */ .d;
            if ((var8_8 != 0 || (var8_8 = (int)var3_3 /* !! */ .h) != 0) && var24_21 != null && var21_19 != null) {
                var16_15 = var2_2.a.k();
                var34_28 = var21_19.doubleValue();
                var19_18 = var24_21.doubleValue();
                var16_15 = var16_15.b(var34_28, var19_18);
                var46_38 = (int)var3_3 /* !! */ .d;
                if (var46_38 != 0) {
                    var30_25.setPoiList((List)var16_15);
                }
            } else {
                var8_8 = 0;
                var39_31 = 0.0f;
                var16_15 = null;
            }
            if (var40_32 != 0 && (var46_38 = var3_3 /* !! */ .d) != 0 && (var16_15 == null || (var46_38 = var16_15.size()) <= 0)) {
                var30_25 = var4_4;
                var31_26 = 0;
                var9_9 = null;
            }
            if ((var46_38 = var3_3 /* !! */ .h) != 0 && var16_15 != null && (var46_38 = var16_15.size()) > 0) {
                var12_11 = Locale.CHINA;
                var18_17 = 1;
                var41_33 = new Object[var18_17];
                var47_39 = 0;
                var41_33[0] = var16_15 = ((Poi)var16_15.get(0)).getName();
                var16_15 = String.format((Locale)var12_11, "\u5728%s\u9644\u8fd1", var41_33);
                var30_25.setLocationDescribe((String)var16_15);
            } else {
                var47_39 = 0;
                var8_8 = 0;
                var39_31 = 0.0f;
                var16_15 = null;
            }
            if (var40_32 != 0 && (var46_38 = (int)var3_3 /* !! */ .h) != 0 && var16_15 == null) {
                var17_16 = var4_4;
            } else {
                var17_16 = var30_25;
                var47_39 = var31_26;
            }
            var4_4 = new StringBuffer();
            var16_15 = var3_3 /* !! */ .a;
            if (var16_15 != null) {
                var4_4.append((String)var16_15);
                var3_3 /* !! */  = com.baidu.location.e.j.a((BDLocation)var15_14, (BDLocation)var13_12, (j$a)var3_3 /* !! */ );
                var4_4.append((String)var3_3 /* !! */ );
                var3_3 /* !! */  = com.baidu.location.e.j.a((BDLocation)var17_16, var47_39);
                var4_4.append((String)var3_3 /* !! */ );
                var48_40 /* !! */  = var3_3 /* !! */  = var4_4.toString();
            } else {
                var48_40 /* !! */  = null;
            }
            var3_3 /* !! */  = var41_33;
            var4_4 = this;
            var16_15 = var36_29 /* !! */ ;
            var12_11 = var13_12;
            var30_25 = var15_14;
            var9_9 = var25_22;
            var13_12 = var48_40 /* !! */ ;
            var41_33 = new d(this, var6_6, (Long)var36_29 /* !! */ , (BDLocation)var12_11, (BDLocation)var15_14, var25_22, (String)var48_40 /* !! */ , var7_7);
            var41_33.start();
            var4_4 = var17_16;
        }
        return com.baidu.location.e.j.a((BDLocation)var4_4);
    }

    public SQLiteDatabase a() {
        return this.i;
    }

    public void b() {
        this.g.a();
    }
}

