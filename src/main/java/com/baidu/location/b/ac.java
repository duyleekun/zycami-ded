/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Build$VERSION
 */
package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.ac$a;
import com.baidu.location.c.e;
import com.baidu.location.e.h;
import com.baidu.location.e.h$a;
import com.baidu.location.e.h$b;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.b;
import com.baidu.location.f.i;
import com.baidu.location.h.k;
import com.baidu.location.h.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ac {
    private static ac A;
    private static long C;
    private static ArrayList b;
    private static ArrayList c;
    private static ArrayList d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static File j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static double o;
    private static double p;
    private static double q;
    private static double r;
    private static int s;
    private static int t;
    private static int u;
    private static Location v;
    private static Location w;
    private static Location x;
    private static com.baidu.location.f.h y;
    private int B;
    public long a;
    private ac$a z = null;

    static {
        int n10;
        Serializable serializable = new ArrayList();
        b = serializable;
        serializable = new ArrayList();
        c = serializable;
        serializable = new ArrayList();
        d = serializable;
        serializable = new StringBuilder();
        String string2 = com.baidu.location.h.k.a;
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("/yo.dat");
        e = ((StringBuilder)serializable).toString();
        serializable = new StringBuilder();
        string2 = com.baidu.location.h.k.a;
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("/yoh.dat");
        f = ((StringBuilder)serializable).toString();
        serializable = new StringBuilder();
        string2 = com.baidu.location.h.k.a;
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("/yom.dat");
        g = ((StringBuilder)serializable).toString();
        serializable = new StringBuilder();
        string2 = com.baidu.location.h.k.a;
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("/yol.dat");
        h = ((StringBuilder)serializable).toString();
        serializable = new StringBuilder();
        string2 = com.baidu.location.h.k.a;
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("/yor.dat");
        i = ((StringBuilder)serializable).toString();
        j = null;
        k = n10 = 8;
        l = n10;
        m = 16;
        n = 2048;
        o = 0.0;
        p = 0.1;
        q = 30.0;
        r = 100.0;
        s = 0;
        t = 64;
        u = 128;
        v = null;
        w = null;
        x = null;
        y = null;
        A = null;
        C = 0L;
    }

    private ac() {
        long l10;
        String string2 = null;
        this.B = 0;
        this.a = l10 = 0L;
        Object object = new ac$a(this);
        this.z = object;
        this.B = 0;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 > n11 && (string2 = com.baidu.location.h.l.l()) != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("/yo1.dat");
            e = ((StringBuilder)object).toString();
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("/yoh1.dat");
            f = ((StringBuilder)object).toString();
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("/yom1.dat");
            g = ((StringBuilder)object).toString();
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            String string3 = "/yol1.dat";
            ((StringBuilder)object).append(string3);
            h = ((StringBuilder)object).toString();
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("/yor1.dat");
            i = string2 = ((StringBuilder)object).toString();
        }
    }

    /*
     * Exception decompiling
     */
    private static int a(List var0, int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 32[TRYBLOCK] [78 : 494->501)] java.lang.Throwable
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

    public static ac a() {
        Class<ac> clazz = ac.class;
        synchronized (clazz) {
            ac ac2 = A;
            if (ac2 == null) {
                A = ac2 = new ac();
            }
            ac2 = A;
            return ac2;
        }
    }

    /*
     * WARNING - bad return control flow
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(int n10) {
        ArrayList arrayList;
        Object object;
        int n11 = 1;
        String string2 = null;
        if (n10 == n11) {
            object = f;
            arrayList = b;
        } else {
            int n12 = 2;
            if (n10 == n12) {
                object = g;
                arrayList = c;
            } else {
                n12 = 3;
                if (n10 == n12) {
                    object = h;
                } else {
                    n12 = 4;
                    if (n10 != n12) {
                        return null;
                    }
                    object = i;
                }
                arrayList = d;
            }
        }
        if (arrayList == null) {
            return null;
        }
        int n13 = arrayList.size();
        if (n13 < n11) {
            ac.a((String)object, arrayList);
        }
        object = ac.class;
        synchronized (object) {
            Object object2;
            n13 = arrayList.size();
            if (n13 <= 0) return string2;
            n13 -= n11;
            try {
                object2 = arrayList.get(n13);
                object2 = (String)object2;
            }
            catch (Exception exception) {}
            try {
                arrayList.remove(n13);
                return (String)object2;
            }
            catch (Exception exception) {}
            return (String)object2;
            return string2;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void a(int var0, boolean var1_1) {
        block52: {
            block51: {
                var2_2 = 4;
                var3_3 = 1;
                if (var0 == var3_3) {
                    var4_4 = ac.f;
                    if (var1_1) {
                        return;
                    }
                    while (true) {
                        var5_6 = ac.b;
                        break block51;
                        break;
                    }
                }
                var6_5 = 2;
                if (var0 == var6_5) {
                    var4_4 = ac.g;
                    if (var1_1) ** continue;
                    while (true) {
                        var5_6 = ac.c;
                        break block51;
                        break;
                    }
                }
                var6_5 = 3;
                if (var0 == var6_5) {
                    var4_4 = ac.h;
                    if (var1_1) ** continue;
lbl21:
                    // 2 sources

                    while (true) {
                        var5_6 = ac.d;
                        break block51;
                        break;
                    }
                }
                if (var0 == var2_2) {
                    var4_4 = ac.i;
                    if (var1_1) {
                        ** continue;
                    }
                }
                ** GOTO lbl145
            }
            var7_7 = new File((String)var4_4);
            var8_8 = var7_7.exists();
            if (var8_8 == 0) {
                ac.d((String)var4_4);
            }
            var9_9 = "rw";
            var4_4 = new RandomAccessFile(var7_7, var9_9);
            var10_10 = 4;
            var4_4.seek(var10_10);
            var12_11 = var4_4.readInt();
            var8_8 = var4_4.readInt();
            var13_12 = var4_4.readInt();
            var14_13 = var4_4.readInt();
            var15_14 = var4_4.readInt();
            var16_15 = var5_6.size();
            while (true) {
                block54: {
                    block53: {
                        var17_16 = ac.l;
                        var18_17 = 0;
                        if (var16_15 <= var17_16) break block52;
                        if (var1_1) {
                            ++var15_14;
                        }
                        if (var13_12 >= var12_11) break block53;
                        var17_16 = var8_8 * var13_12 + 128;
                        var19_18 = var17_16;
                        var4_4.seek(var19_18);
                        var21_19 = new StringBuilder();
                        var22_20 /* !! */  = var5_6.get(0);
                        var22_20 /* !! */  = (String)var22_20 /* !! */ ;
                        var21_19.append((String)var22_20 /* !! */ );
                        var21_19.append('\u0000');
                        var21_19 = var21_19.toString();
                        var21_19 = var21_19.getBytes();
                        var23_21 = ((Object)var21_19).length;
                        var4_4.writeInt(var23_21);
                        var23_21 = ((Object)var21_19).length;
                        var4_4.write((byte[])var21_19, 0, var23_21);
                        var5_6.remove(0);
                        ++var13_12;
                        break block54;
                    }
                    if (!var1_1) break;
                    var17_16 = var14_13 * var8_8 + 128;
                    var19_18 = var17_16;
                    var4_4.seek(var19_18);
                    var21_19 = new StringBuilder();
                    var22_20 /* !! */  = var5_6.get(0);
                    var22_20 /* !! */  = (String)var22_20 /* !! */ ;
                    var21_19.append((String)var22_20 /* !! */ );
                    var21_19.append('\u0000');
                    var21_19 = var21_19.toString();
                    var21_19 = var21_19.getBytes();
                    var23_21 = ((Object)var21_19).length;
                    var4_4.writeInt(var23_21);
                    var23_21 = ((Object)var21_19).length;
                    var4_4.write((byte[])var21_19, 0, var23_21);
                    var5_6.remove(0);
                    if (++var14_13 <= var13_12) {
                        var18_17 = var14_13;
                    }
                    var14_13 = var18_17;
                }
                var16_15 += -1;
            }
            var18_17 = var3_3;
        }
        var24_22 = 12;
        try {
            var4_4.seek(var24_22);
        }
        catch (Exception v0) {
            ** continue;
        }
        var4_4.writeInt(var13_12);
        var4_4.writeInt(var14_13);
        var4_4.writeInt(var15_14);
        var4_4.close();
        if (var18_17 == 0 || var0 >= var2_2) ** GOTO lbl145
        var0 += var3_3;
        ac.a(var0, (boolean)var3_3);
lbl145:
        // 4 sources

    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void a(a object, com.baidu.location.f.h h10, Location location, String object2) {
        boolean bl2;
        int n10;
        int n11;
        int n12;
        int n13;
        block36: {
            Object object3;
            block34: {
                String string2;
                block35: {
                    int n14;
                    Object object4;
                    block33: {
                        String string3;
                        block28: {
                            block32: {
                                Object object5;
                                block30: {
                                    block31: {
                                        block29: {
                                            float f10;
                                            int n15;
                                            int n16;
                                            void var13_15;
                                            n13 = Build.VERSION.SDK_INT;
                                            Object object6 = com.baidu.location.c.e.a();
                                            n12 = ((e)object6).a;
                                            if (n12 == 0) {
                                                return;
                                            }
                                            n12 = com.baidu.location.h.l.x;
                                            n11 = 3;
                                            n10 = 0;
                                            Object object7 = null;
                                            if (n12 == n11 && (n12 = (int)(ac.a(location, h10) ? 1 : 0)) == 0 && (n12 = (int)(ac.a(location, false) ? 1 : 0)) == 0) {
                                                return;
                                            }
                                            if (object == null) return;
                                            n12 = (int)(((a)object).c() ? 1 : 0);
                                            if (n12 != 0) {
                                                return;
                                            }
                                            object6 = com.baidu.location.f.getServiceContext();
                                            n12 = (int)(com.baidu.location.h.l.a((Context)object6) ? 1 : 0);
                                            object3 = com.baidu.location.e.h.a();
                                            int n17 = 0;
                                            string2 = null;
                                            if (n12 != 0) {
                                                h$b h$b = h$b.a;
                                            } else {
                                                h$b h$b = h$b.b;
                                            }
                                            Object object8 = h$a.b;
                                            object4 = object;
                                            object6 = ((h)object3).a((a)object, h10, null, (h$b)var13_15, (h$a)((Object)object8));
                                            object3 = "1";
                                            n14 = 2;
                                            n17 = 1;
                                            if (object6 != null && (n16 = ((BDLocation)object6).getLocType()) != (n15 = 67)) {
                                                void var13_20;
                                                String string4;
                                                if (object6 != null && (string4 = ((BDLocation)object6).getNetworkLocationType()) != null) {
                                                    String string5 = ((BDLocation)object6).getNetworkLocationType();
                                                } else {
                                                    n16 = 0;
                                                    Object var13_19 = null;
                                                }
                                                if (var13_20 != null && (n15 = (int)(var13_20.equals(object8 = "cl") ? 1 : 0)) != 0) {
                                                    n16 = n17;
                                                } else if (var13_20 != null && (n16 = (int)(var13_20.equals(object8 = "wf") ? 1 : 0)) != 0) {
                                                    n16 = n14;
                                                } else {
                                                    n16 = 0;
                                                    Object var13_21 = null;
                                                }
                                                if (object6 != null) {
                                                    object8 = new StringBuilder();
                                                    ((StringBuilder)object8).append((String)object2);
                                                    object2 = Locale.CHINA;
                                                    int n18 = 5;
                                                    Object[] objectArray = new Object[n18];
                                                    objectArray[0] = object3;
                                                    objectArray[n17] = object7 = Integer.valueOf(n16);
                                                    objectArray[n14] = object7 = Double.valueOf(((BDLocation)object6).getLongitude());
                                                    double d10 = ((BDLocation)object6).getLatitude();
                                                    objectArray[n11] = object7 = Double.valueOf(d10);
                                                    n10 = 4;
                                                    f10 = ((BDLocation)object6).getRadius();
                                                    n12 = (int)f10;
                                                    objectArray[n10] = object6 = Integer.valueOf(n12);
                                                    object6 = "&ofl=%s|%d|%f|%f|%d";
                                                    object2 = String.format((Locale)object2, (String)object6, objectArray);
                                                    ((StringBuilder)object8).append((String)object2);
                                                    object2 = ((StringBuilder)object8).toString();
                                                }
                                            } else {
                                                object6 = new StringBuilder();
                                                ((StringBuilder)object6).append((String)object2);
                                                object2 = Locale.CHINA;
                                                Object[] objectArray = new Object[n17];
                                                objectArray[0] = object3;
                                                object7 = "&ofl=%s|0";
                                                object2 = String.format((Locale)object2, (String)object7, objectArray);
                                                ((StringBuilder)object6).append((String)object2);
                                                object2 = ((StringBuilder)object6).toString();
                                            }
                                            n12 = 1000;
                                            f10 = 1.401E-42f;
                                            n10 = 28;
                                            if (object != null && (bl2 = ((a)object).a())) {
                                                n11 = (int)(ac.a(location, h10) ? 1 : 0);
                                                if (n11 == 0) {
                                                    h10 = null;
                                                }
                                                if ((object = com.baidu.location.h.l.a((a)object, h10, location, (String)object2, n17)) == null) return;
                                                object = n13 > n10 ? Jni.encodeTp4((String)object) : ((object2 = Jni.encodeTp4((String)object)) != null && (n13 = ((String)object2).length()) < n12 ? object2 : Jni.encode((String)object));
                                                ac.a((String)object);
                                                w = location;
                                                v = location;
                                                if (h10 == null) return;
                                                y = h10;
                                                return;
                                            }
                                            object3 = "&cfr=3";
                                            string2 = "&cfr=2";
                                            string3 = "&cfr=1";
                                            if (h10 == null || (n15 = (int)(h10.m() ? 1 : 0)) == 0 || (n15 = (int)(ac.a(location, h10) ? 1 : 0)) == 0) break block28;
                                            n11 = (int)(ac.a(location) ? 1 : 0);
                                            if (n11 != 0 || (n11 = (int)(((b)(object5 = com.baidu.location.f.b.a())).d() ? 1 : 0)) != 0) break block29;
                                            object5 = new StringBuilder();
                                            ((StringBuilder)object5).append(string3);
                                            break block30;
                                        }
                                        n11 = (int)(ac.a(location) ? 1 : 0);
                                        if (n11 != 0 || (n11 = (int)(((b)(object5 = com.baidu.location.f.b.a())).d() ? 1 : 0)) == 0) break block31;
                                        object5 = new StringBuilder();
                                        ((StringBuilder)object5).append((String)object3);
                                        break block30;
                                    }
                                    object5 = com.baidu.location.f.b.a();
                                    n11 = (int)(((b)object5).d() ? 1 : 0);
                                    if (n11 == 0) break block32;
                                    object5 = new StringBuilder();
                                    ((StringBuilder)object5).append(string2);
                                }
                                ((StringBuilder)object5).append((String)object2);
                                object2 = ((StringBuilder)object5).toString();
                            }
                            object = com.baidu.location.h.l.a((a)object, h10, location, (String)object2, n14);
                            if (object == null) return;
                            object = n13 > n10 ? Jni.encodeTp4((String)object) : ((object2 = Jni.encodeTp4((String)object)) != null && (n13 = ((String)object2).length()) < n12 ? object2 : Jni.encode((String)object));
                            ac.b((String)object);
                            x = location;
                            v = location;
                            if (h10 == null) return;
                            y = h10;
                            return;
                        }
                        n14 = (int)(ac.a(location) ? 1 : 0);
                        if (n14 != 0 || (n14 = (int)(((b)(object4 = com.baidu.location.f.b.a())).d() ? 1 : 0)) != 0) break block33;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                        break block34;
                    }
                    n14 = (int)(ac.a(location) ? 1 : 0);
                    if (n14 != 0 || (n14 = (int)(((b)(object4 = com.baidu.location.f.b.a())).d() ? 1 : 0)) == 0) break block35;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append((String)object2);
                    object2 = ((StringBuilder)object4).toString();
                    break block36;
                }
                object3 = com.baidu.location.f.b.a();
                bl2 = ((b)object3).d();
                if (!bl2) break block36;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
            }
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
        }
        bl2 = ac.a(location, h10);
        if (!bl2) {
            h10 = null;
        }
        if (object == null) {
            if (h10 == null) return;
        }
        if ((object = com.baidu.location.h.l.a((a)object, h10, location, (String)object2, n11)) == null) return;
        object = n13 > n10 ? Jni.encodeTp4((String)object) : ((object2 = Jni.encodeTp4((String)object)) != null && (n13 = ((String)object2).length()) < n12 ? object2 : Jni.encode((String)object));
        ac.c((String)object);
        v = location;
        if (h10 == null) return;
        y = h10;
    }

    private static void a(String string2) {
        ac.e(string2);
    }

    private static boolean a(int n10, int n11, int n12, int n13, long l10) {
        return n10 >= 0 && n10 < n12 && n11 >= 0 && n11 <= n12 && n12 >= 0 && n12 <= (n10 = 1024) && n13 >= (n11 = 128) && n13 <= n10;
        {
        }
    }

    private static boolean a(Location location) {
        Location location2;
        boolean bl2 = false;
        if (location == null) {
            return false;
        }
        Location location3 = w;
        boolean bl3 = true;
        if (location3 != null && (location2 = v) != null) {
            double d10 = location.distanceTo(location3);
            double d11 = (double)com.baidu.location.h.l.V * d10 * d10;
            float f10 = com.baidu.location.h.l.W;
            double d12 = (double)f10 * d10;
            d11 += d12;
            int n10 = com.baidu.location.h.l.X;
            d10 = n10;
            d11 += d10;
            location3 = v;
            float f11 = location.distanceTo(location3);
            d10 = f11;
            double d13 = d10 - d11;
            Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object > 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        w = location;
        return bl3;
    }

    private static boolean a(Location location, com.baidu.location.f.h h10) {
        boolean bl2;
        Object object;
        boolean bl3 = false;
        if (location != null && h10 != null && (object = h10.a) != null && !(bl2 = object.isEmpty())) {
            object = y;
            boolean bl4 = h10.b((com.baidu.location.f.h)object);
            if (bl4) {
                return false;
            }
            h10 = x;
            bl3 = true;
            if (h10 == null) {
                x = location;
            }
        }
        return bl3;
    }

    public static boolean a(Location location, boolean bl2) {
        return com.baidu.location.f.f.a(v, location, bl2);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean a(String var0, List var1_1) {
        var2_2 = new File((String)var0);
        var3_3 = var2_2.exists();
        var4_4 = 0;
        if (!var3_3) {
            return false;
        }
        var5_5 = "rw";
        var0 = new RandomAccessFile(var2_2, var5_5);
        var6_6 = 8;
        var0.seek(var6_6);
        var8_7 = var0.readInt();
        ** try [egrp 3[TRYBLOCK] [4 : 55->59)] { 
lbl15:
        // 2 sources

        var10_9 = var0.readInt();
        var11_10 = ac.n;
        var12_11 = new byte[var11_10];
        var13_12 = ac.l;
        var14_13 = 1;
        var15_14 = 1.4E-45f;
        var13_12 += var14_13;
        var16_15 = 0;
        for (var9_8 = var0.readInt(); var13_12 > 0 && var9_8 > 0; var13_12 += -1, var9_8 += -1) {
            if (var9_8 < var10_9) {
                var10_9 = 0;
            }
            var17_16 = (var9_8 + -1) * var8_7 + 128;
            var18_17 = var17_16;
            var0.seek(var18_17);
            var17_16 = var0.readInt();
            if (var17_16 <= 0 || var17_16 >= var8_7) continue;
            var0.read(var12_11, 0, var17_16);
            var17_16 += -1;
            var20_18 = var12_11[var17_16];
            if (var20_18 != 0) continue;
            var21_19 = new String(var12_11, 0, var17_16);
            var1_1.add(0, var21_19);
            var16_15 = var14_13;
        }
        var22_20 = 12;
        try {
            var0.seek(var22_20);
        }
        catch (Exception v0) {
            var4_4 = var16_15;
lbl53:
            // 2 sources

            return (boolean)var4_4;
        }
        var0.writeInt(var9_8);
        var0.writeInt(var10_9);
        var0.close();
        return (boolean)var16_15;
lbl61:
        // 7 sources

        catch (Exception v1) {
            ** continue;
        }
    }

    public static String b() {
        return ac.f();
    }

    private static void b(String string2) {
        ac.e(string2);
    }

    private static void c(String string2) {
        ac.e(string2);
    }

    public static void d() {
        l = 0;
        ac.a(1, false);
        ac.a(2, false);
        ac.a(3, false);
        l = 8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d(String object) {
        try {
            int n10;
            File file = new File((String)object);
            boolean bl2 = file.exists();
            if (bl2) return;
            String string2 = com.baidu.location.h.k.a;
            object = new File(string2);
            boolean bl3 = ((File)object).exists();
            if (!bl3) {
                ((File)object).mkdirs();
            }
            if (!(bl2 = file.createNewFile())) {
                n10 = 0;
                file = null;
            }
            string2 = "rw";
            object = new RandomAccessFile(file, string2);
            long l10 = 0L;
            ((RandomAccessFile)object).seek(l10);
            n10 = 32;
            ((RandomAccessFile)object).writeInt(n10);
            n10 = 2048;
            ((RandomAccessFile)object).writeInt(n10);
            n10 = 2060;
            ((RandomAccessFile)object).writeInt(n10);
            n10 = 0;
            file = null;
            ((RandomAccessFile)object).writeInt(0);
            ((RandomAccessFile)object).writeInt(0);
            ((RandomAccessFile)object).writeInt(0);
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
    public static String e() {
        Object object;
        Object object2;
        block21: {
            int n10;
            long l10;
            CharSequence charSequence;
            boolean bl2;
            Object object3;
            block20: {
                String string2;
                int n11;
                block18: {
                    object2 = g;
                    object3 = new File((String)object2);
                    bl2 = ((File)object3).exists();
                    charSequence = "rw";
                    l10 = 20;
                    object = null;
                    if (bl2) {
                        block17: {
                            try {
                                object2 = new RandomAccessFile((File)object3, (String)charSequence);
                                ((RandomAccessFile)object2).seek(l10);
                                n10 = ((RandomAccessFile)object2).readInt();
                                n11 = 128;
                                if (n10 <= n11) break block17;
                                StringBuilder stringBuilder = new StringBuilder();
                                string2 = "&p1=";
                                stringBuilder.append(string2);
                                stringBuilder.append(n10);
                                object3 = stringBuilder.toString();
                            }
                            catch (Exception exception) {}
                            try {
                                ((RandomAccessFile)object2).seek(l10);
                                ((RandomAccessFile)object2).writeInt(0);
                                ((RandomAccessFile)object2).close();
                                return object3;
                            }
                            catch (Exception exception) {
                                object = object3;
                            }
                            break block18;
                        }
                        ((RandomAccessFile)object2).close();
                    }
                }
                if (bl2 = ((File)(object3 = new File((String)(object2 = h)))).exists()) {
                    block19: {
                        try {
                            object2 = new RandomAccessFile((File)object3, (String)charSequence);
                            ((RandomAccessFile)object2).seek(l10);
                            n10 = ((RandomAccessFile)object2).readInt();
                            n11 = 256;
                            if (n10 <= n11) break block19;
                            StringBuilder stringBuilder = new StringBuilder();
                            string2 = "&p2=";
                            stringBuilder.append(string2);
                            stringBuilder.append(n10);
                            object3 = stringBuilder.toString();
                        }
                        catch (Exception exception) {}
                        try {
                            ((RandomAccessFile)object2).seek(l10);
                            ((RandomAccessFile)object2).writeInt(0);
                            ((RandomAccessFile)object2).close();
                            return object3;
                        }
                        catch (Exception exception) {
                            object = object3;
                        }
                        break block20;
                    }
                    ((RandomAccessFile)object2).close();
                }
            }
            if (!(bl2 = ((File)(object3 = new File((String)(object2 = i)))).exists())) return object;
            try {
                object2 = new RandomAccessFile((File)object3, (String)charSequence);
                ((RandomAccessFile)object2).seek(l10);
                n10 = ((RandomAccessFile)object2).readInt();
                int n12 = 512;
                if (n10 <= n12) break block21;
                charSequence = new StringBuilder();
                String string3 = "&p3=";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(n10);
                object3 = ((StringBuilder)charSequence).toString();
            }
            catch (Exception exception) {
                return object;
            }
            try {
                ((RandomAccessFile)object2).seek(l10);
                ((RandomAccessFile)object2).writeInt(0);
                ((RandomAccessFile)object2).close();
                return object3;
            }
            catch (Exception exception) {
                return object3;
            }
        }
        ((RandomAccessFile)object2).close();
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void e(String string2) {
        Class<ac> clazz = ac.class;
        synchronized (clazz) {
            int n10;
            ArrayList arrayList;
            String string3 = "err!";
            int n11 = string2.contains(string3);
            if (n11 != 0) {
                return;
            }
            n11 = com.baidu.location.h.l.s;
            int n12 = 1;
            if (n11 == n12) {
                arrayList = b;
            } else {
                n12 = 2;
                if (n11 == n12) {
                    arrayList = c;
                } else {
                    n12 = 3;
                    if (n11 != n12) {
                        return;
                    }
                    arrayList = d;
                }
            }
            if (arrayList == null) {
                return;
            }
            int n13 = arrayList.size();
            if (n13 <= (n10 = m)) {
                arrayList.add(string2);
            }
            int n14 = arrayList.size();
            n13 = m;
            n10 = 0;
            if (n14 >= n13) {
                ac.a(n11, false);
            }
            while ((n14 = arrayList.size()) > (n11 = m)) {
                arrayList.remove(0);
            }
            return;
        }
    }

    private static String f() {
        int n10;
        int n11;
        Object object = null;
        for (n11 = 1; n11 < (n10 = 5); ++n11) {
            object = ac.a(n11);
            if (object == null) continue;
            return object;
        }
        ArrayList arrayList = d;
        n10 = t;
        ac.a(arrayList, n10);
        arrayList = d;
        n11 = arrayList.size();
        n10 = 0;
        if (n11 > 0) {
            arrayList = d.get(0);
            object = arrayList;
            object = (String)((Object)arrayList);
            arrayList = d;
            arrayList.remove(0);
        }
        if (object != null) {
            return object;
        }
        arrayList = d;
        int n12 = s;
        ac.a(arrayList, n12);
        arrayList = d;
        n11 = arrayList.size();
        if (n11 > 0) {
            arrayList = d.get(0);
            object = arrayList;
            object = (String)((Object)arrayList);
            arrayList = d;
            arrayList.remove(0);
        }
        if (object != null) {
            return object;
        }
        arrayList = d;
        n12 = u;
        ac.a(arrayList, n12);
        arrayList = d;
        n11 = arrayList.size();
        if (n11 > 0) {
            arrayList = d.get(0);
            object = arrayList;
            object = (String)((Object)arrayList);
            arrayList = d;
            arrayList.remove(0);
        }
        return object;
    }

    public void c() {
        Object object = com.baidu.location.f.i.a();
        boolean bl2 = ((i)object).j();
        if (!bl2) {
            return;
        }
        bl2 = com.baidu.location.h.l.b();
        if (!bl2) {
            object = this.z;
            ((ac$a)object).a();
        }
    }
}

