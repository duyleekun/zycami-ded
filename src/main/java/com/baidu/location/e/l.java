/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.baidu.location.Address;
import com.baidu.location.Address$Builder;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.e.f;
import com.baidu.location.e.h;
import com.baidu.location.e.l$a;
import com.baidu.location.e.l$b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class l {
    private static final double[] b;
    private final h a;
    private final int c;
    private final SQLiteDatabase d;
    private int e;
    private int f;

    static {
        double[] dArray;
        double[] dArray2 = dArray = new double[4];
        double[] dArray3 = dArray;
        dArray2[0] = 45.0;
        dArray3[1] = 135.0;
        dArray2[2] = 225.0;
        dArray3[3] = 315.0;
        b = dArray;
    }

    public l(h object, SQLiteDatabase sQLiteDatabase, int n10) {
        int n11;
        this.a = object;
        this.e = n11 = -1;
        this.f = n11;
        this.d = sQLiteDatabase;
        this.c = n10;
        if (sQLiteDatabase != null && (n11 = (int)(sQLiteDatabase.isOpen() ? 1 : 0)) != 0) {
            object = "CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))";
            sQLiteDatabase.execSQL((String)object);
            object = "CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)";
            sQLiteDatabase.execSQL((String)object);
            object = "CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)";
            sQLiteDatabase.execSQL((String)object);
            object = "CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)";
            sQLiteDatabase.execSQL((String)object);
            object = "CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))";
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private double a(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d14 - d12;
        double d17 = d10 - d12;
        double d18 = d16 * d17;
        double d19 = d15 - d13;
        double d20 = d11 - d13;
        double d21 = d19 * d20;
        double d22 = (d18 += d21) - (d21 = 0.0);
        Object object = d22 == 0.0 ? 0 : (d22 < 0.0 ? -1 : 1);
        if (object <= 0) {
            d17 *= d17;
            d20 *= d20;
            return Math.sqrt(d17 + d20);
        }
        d17 = d16 * d16;
        d20 = d19 * d19;
        double d23 = d18 - (d17 += d20);
        Object object2 = d23 == 0.0 ? 0 : (d23 > 0.0 ? 1 : -1);
        if (object2 >= 0) {
            d16 = d10 - d14;
            d16 *= d16;
            d17 = d11 - d15;
            d17 *= d17;
            return Math.sqrt(d16 + d17);
        }
        d16 *= (d18 /= d17);
        d16 = d12 + d16;
        d17 = d13 + (d19 *= d18);
        d16 = d10 - d16;
        d16 *= d16;
        d17 -= d11;
        d17 *= d17;
        return Math.sqrt(d16 + d17);
    }

    private static int a(int n10, int n11) {
        int n12;
        double d10;
        int n13 = 100;
        if (n13 > n11) {
            d10 = -0.1;
            n12 = 60000;
        } else {
            n13 = 500;
            if (n13 > n11) {
                d10 = -0.75;
                n12 = 55500;
            } else {
                d10 = -0.5;
                n12 = 0;
            }
        }
        double d11 = n11;
        double d12 = n12;
        return (int)((d10 *= d11) + d12) + n10;
    }

    public static /* synthetic */ String a(int n10, double d10, double d11) {
        return l.b(n10, d10, d11);
    }

    public static /* synthetic */ double[] a(double d10, double d11, double d12, double d13) {
        return l.b(d10, d11, d12, d13);
    }

    private static String b(int n10, double d10, double d11) {
        int n11;
        int n12;
        l$a l$a;
        int n13 = n10;
        int n14 = n10 * 5;
        int n15 = n10 + 1;
        char[] cArray = new char[n15];
        double d12 = 90.0;
        double d13 = -90.0;
        l$a l$a2 = l$a;
        l$a = new l$a(d12, d13, null);
        double d14 = 180.0;
        double d15 = -180.0;
        Object object = l$a2;
        l$a2 = new l$a(d14, d15, null);
        int n16 = n12;
        int n17 = 0;
        for (int i10 = n12 = 1; i10 <= n14; ++i10) {
            if (n16 != 0) {
                d14 = d10;
                object = l$a2;
            } else {
                d14 = d11;
                object = l$a;
            }
            d15 = l$a.a((l$a)object);
            double d16 = l$a.b((l$a)object);
            d15 = (d15 + d16) / 2.0;
            n17 <<= n12;
            d16 = 1000000.0;
            int n18 = (int)(d14 *= d16);
            d12 = d15 * d16;
            n11 = (int)d12;
            if (n18 > n11) {
                l$a.a((l$a)object, d15);
                n17 |= 1;
            } else {
                l$a.b((l$a)object, d15);
            }
            n11 = i10 % 5;
            if (n11 == 0) {
                n11 = i10 / 5;
                n12 = 1;
                object = "0123456789bcdefghjkmnpqrstuvwxyz";
                cArray[n11 -= n12] = n17 = (int)((String)object).charAt(n17);
                n17 = 0;
            } else {
                n12 = 1;
            }
            n16 ^= 1;
        }
        cArray[n13] = '\u0000';
        StringBuffer stringBuffer = new StringBuffer();
        for (n11 = 0; n11 < n13; ++n11) {
            char c10 = cArray[n11];
            stringBuffer.append(c10);
        }
        return stringBuffer.toString();
    }

    private static double[] b(double d10, double d11, double d12, double d13) {
        double[] dArray = new double[2];
        d10 = Math.toRadians(d10);
        d11 = Math.toRadians(d11);
        d13 = Math.toRadians(d13);
        double d14 = Math.sin(d10);
        double d15 = Math.cos(d12 /= 6378137.0);
        d14 *= d15;
        d15 = Math.cos(d10);
        double d16 = Math.sin(d12);
        d15 *= d16;
        d16 = Math.cos(d13);
        d14 = Math.asin(d14 + (d15 *= d16));
        d13 = Math.sin(d13);
        d15 = Math.sin(d12);
        d13 *= d15;
        d15 = Math.cos(d10);
        d13 *= d15;
        d12 = Math.cos(d12);
        d10 = Math.sin(d10);
        d15 = Math.sin(d14);
        d10 = Math.atan2(d13, d12 -= (d10 *= d15));
        d11 += d10;
        dArray[0] = d10 = Math.toDegrees(d14);
        dArray[1] = d10 = Math.toDegrees(d11);
        return dArray;
    }

    private double c(double d10, double d11, double d12, double d13) {
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

    public static /* synthetic */ double[] c() {
        return b;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Address a(double d10, double d11) {
        void var63_139;
        void var39_99;
        void var20_70;
        void var16_48;
        void var39_96;
        void var20_67;
        void var16_45;
        Object object;
        Object object2;
        String string2;
        String string3;
        String string4;
        Object object3;
        String string5;
        block105: {
            block98: {
                void var63_128;
                block102: {
                    void var6_15;
                    int n10;
                    int n11;
                    int n12;
                    block103: {
                        block99: {
                            block100: {
                                block101: {
                                    double d12;
                                    l l10;
                                    block95: {
                                        block94: {
                                            Cursor cursor;
                                            block92: {
                                                void var6_11;
                                                block93: {
                                                    block91: {
                                                        Cursor cursor2;
                                                        int n13;
                                                        block89: {
                                                            double[] dArray;
                                                            double d13;
                                                            double d14;
                                                            double d15;
                                                            Cursor cursor3;
                                                            double d16;
                                                            double d17;
                                                            int n14;
                                                            float f10;
                                                            int n15;
                                                            float f11;
                                                            int n16;
                                                            block90: {
                                                                block88: {
                                                                    block87: {
                                                                        void var6_7;
                                                                        block85: {
                                                                            Cursor cursor4;
                                                                            block83: {
                                                                                block82: {
                                                                                    block86: {
                                                                                        double d18;
                                                                                        block81: {
                                                                                            block84: {
                                                                                                l10 = this;
                                                                                                string5 = "wgs842mc";
                                                                                                n13 = 4;
                                                                                                n16 = 5;
                                                                                                f11 = 7.0E-45f;
                                                                                                n15 = 3;
                                                                                                f10 = 4.2E-45f;
                                                                                                n14 = 2;
                                                                                                d17 = Double.MAX_VALUE;
                                                                                                object3 = null;
                                                                                                l$b l$b = l$b.c;
                                                                                                n12 = this.c;
                                                                                                d16 = d10;
                                                                                                String string6 = l$b.a(l$b, n12, d10, d11);
                                                                                                SQLiteDatabase sQLiteDatabase = this.d;
                                                                                                cursor3 = sQLiteDatabase.rawQuery(string6, null);
                                                                                                try {
                                                                                                    n11 = cursor3.moveToFirst();
                                                                                                    if (n11 != 0) {
                                                                                                        string4 = null;
                                                                                                        string3 = null;
                                                                                                        d18 = d17;
                                                                                                        break block81;
                                                                                                    }
                                                                                                    cursor4 = cursor3;
                                                                                                    string4 = null;
                                                                                                    string3 = null;
                                                                                                    break block82;
                                                                                                }
                                                                                                catch (Throwable throwable) {
                                                                                                    cursor4 = cursor3;
                                                                                                    break block83;
                                                                                                }
                                                                                                catch (Exception exception) {
                                                                                                    cursor4 = cursor3;
                                                                                                    string4 = null;
                                                                                                    break block84;
                                                                                                }
                                                                                                catch (Throwable throwable) {
                                                                                                    // empty catch block
                                                                                                    break block85;
                                                                                                }
                                                                                                catch (Exception exception) {
                                                                                                    cursor3 = null;
                                                                                                    string4 = null;
                                                                                                }
                                                                                            }
                                                                                            string3 = null;
                                                                                            break block87;
                                                                                        }
                                                                                        while (true) {
                                                                                            n11 = cursor3.isAfterLast();
                                                                                            if (n11 != 0) break block86;
                                                                                            String string7 = cursor3.getString(n14);
                                                                                            String string8 = cursor3.getString(n15);
                                                                                            d12 = cursor3.getDouble(n16);
                                                                                            d15 = cursor3.getDouble(n13);
                                                                                            l l11 = this;
                                                                                            d14 = d11;
                                                                                            cursor4 = cursor3;
                                                                                            d13 = this.c(d11, d10, d12, d15);
                                                                                            n10 = (int)(d13 == d18 ? 0 : (d13 < d18 ? -1 : 1));
                                                                                            if (n10 < 0) {
                                                                                                l$b l$b = l$b.c;
                                                                                                d16 = l$b.d(l$b);
                                                                                                n10 = (int)(d13 == d16 ? 0 : (d13 < d16 ? -1 : 1));
                                                                                                if (n10 <= 0) {
                                                                                                    d18 = d13;
                                                                                                    string3 = string7;
                                                                                                    string4 = string8;
                                                                                                }
                                                                                            }
                                                                                            cursor4.moveToNext();
                                                                                            cursor3 = cursor4;
                                                                                            continue;
                                                                                            break;
                                                                                        }
                                                                                        catch (Throwable throwable) {
                                                                                            break block83;
                                                                                        }
                                                                                        catch (Exception exception) {
                                                                                            cursor3 = cursor4;
                                                                                            break block87;
                                                                                        }
                                                                                    }
                                                                                    cursor4 = cursor3;
                                                                                    break block82;
                                                                                    catch (Exception exception) {
                                                                                        cursor4 = cursor3;
                                                                                        break block87;
                                                                                    }
                                                                                }
                                                                                if (cursor4 == null) break block88;
                                                                                try {
                                                                                    cursor4.close();
                                                                                }
                                                                                catch (Exception exception) {}
                                                                            }
                                                                            object3 = cursor4;
                                                                        }
                                                                        if (object3 == null) throw var6_7;
                                                                        try {
                                                                            object3.close();
                                                                        }
                                                                        catch (Exception exception) {
                                                                            throw var6_7;
                                                                        }
                                                                        throw var6_7;
                                                                    }
                                                                    if (cursor3 == null) break block88;
                                                                    cursor3.close();
                                                                }
                                                                cursor3 = null;
                                                                if (string4 == null) {
                                                                    l$b l$b = l$b.b;
                                                                    n12 = l10.c;
                                                                    d16 = d10;
                                                                    String string9 = l$b.a(l$b, n12, d10, d11);
                                                                    SQLiteDatabase sQLiteDatabase = l10.d;
                                                                    cursor2 = sQLiteDatabase.rawQuery(string9, null);
                                                                    try {
                                                                        n11 = cursor2.moveToFirst();
                                                                        if (n11 == 0) break block89;
                                                                        d12 = d10;
                                                                        dArray = Jni.coorEncrypt(d10, d11, string5);
                                                                        break block90;
                                                                    }
                                                                    catch (Throwable throwable) {
                                                                        cursor = cursor2;
                                                                        break block91;
                                                                    }
                                                                    catch (Exception exception) {
                                                                        cursor = cursor2;
                                                                        n13 = 0;
                                                                        string2 = null;
                                                                        break block92;
                                                                    }
                                                                    catch (Throwable throwable) {
                                                                        n13 = 0;
                                                                        Object var54_110 = null;
                                                                        break block93;
                                                                    }
                                                                    catch (Exception exception) {
                                                                        n13 = 0;
                                                                        string2 = null;
                                                                        break block94;
                                                                    }
                                                                }
                                                                n13 = 0;
                                                                string2 = null;
                                                                break block95;
                                                            }
                                                            while ((n11 = cursor2.isAfterLast()) == 0) {
                                                                float f12;
                                                                int n17;
                                                                float f13;
                                                                int n18;
                                                                int n19;
                                                                double d19;
                                                                double d20;
                                                                double d21;
                                                                double d22;
                                                                String string10 = cursor2.getString(n14);
                                                                d13 = cursor2.getDouble(n15);
                                                                try {
                                                                    double d23 = cursor2.getDouble(n13);
                                                                    double[] dArray2 = Jni.coorEncrypt(d13, d23, string5);
                                                                    d14 = cursor2.getDouble(n16);
                                                                    n14 = 6;
                                                                    d23 = cursor2.getDouble(n14);
                                                                    double[] dArray3 = Jni.coorEncrypt(d14, d23, string5);
                                                                    d23 = dArray[0];
                                                                    n10 = 1;
                                                                    d15 = dArray[n10];
                                                                    d22 = dArray2[0];
                                                                    d21 = dArray2[n10];
                                                                    d20 = dArray3[0];
                                                                    d19 = dArray3[n10];
                                                                    l l12 = this;
                                                                    d14 = d23;
                                                                    d12 = d22;
                                                                    n14 = 0;
                                                                    cursor = cursor2;
                                                                    n13 = 0;
                                                                    string2 = null;
                                                                    n19 = 2;
                                                                    d23 = d20;
                                                                    n18 = n16;
                                                                    f13 = f11;
                                                                    n17 = n15;
                                                                    f12 = f10;
                                                                }
                                                                catch (Exception exception) {
                                                                    cursor = cursor2;
                                                                    n13 = 0;
                                                                    string2 = null;
                                                                    break block92;
                                                                }
                                                                d13 = this.a(d14, d15, d22, d21, d20, d19);
                                                                n10 = (int)(d13 == d17 ? 0 : (d13 < d17 ? -1 : 1));
                                                                if (n10 < 0) {
                                                                    l$b l$b = l$b.b;
                                                                    d16 = l$b.d(l$b);
                                                                    n10 = (int)(d13 == d16 ? 0 : (d13 < d16 ? -1 : 1));
                                                                    if (n10 <= 0) {
                                                                        d17 = d13;
                                                                        string3 = string10;
                                                                    }
                                                                }
                                                                try {
                                                                    cursor.moveToNext();
                                                                    d12 = d10;
                                                                    object3 = null;
                                                                    n14 = n19;
                                                                    n16 = n18;
                                                                    f11 = f13;
                                                                    cursor2 = cursor;
                                                                    n15 = n17;
                                                                    f10 = f12;
                                                                    cursor3 = null;
                                                                    n13 = 4;
                                                                }
                                                                catch (Throwable throwable) {
                                                                    break block91;
                                                                }
                                                            }
                                                        }
                                                        cursor = cursor2;
                                                        n13 = 0;
                                                        string2 = null;
                                                        if (cursor2 == null) break block95;
                                                        try {
                                                            cursor2.close();
                                                        }
                                                        catch (Exception exception) {}
                                                    }
                                                    object3 = cursor;
                                                }
                                                if (object3 == null) throw var6_11;
                                                try {
                                                    object3.close();
                                                }
                                                catch (Exception exception) {
                                                    throw var6_11;
                                                }
                                                throw var6_11;
                                                catch (Exception exception) {}
                                            }
                                            object3 = cursor;
                                        }
                                        if (object3 == null) break block95;
                                        object3.close();
                                    }
                                    l$b l$b = l$b.a;
                                    n10 = l10.c;
                                    d12 = d11;
                                    string5 = l$b.a(l$b, n10, d10, d11);
                                    SQLiteDatabase sQLiteDatabase = l10.d;
                                    object3 = sQLiteDatabase.rawQuery(string5, null);
                                    try {
                                        block97: {
                                            block96: {
                                                String string11;
                                                String string12;
                                                String string13;
                                                int n20 = object3.moveToFirst();
                                                if (n20 == 0 || (n20 = object3.isAfterLast()) != 0) break block96;
                                                string5 = "country";
                                                n20 = object3.getColumnIndex(string5);
                                                string5 = object3.getString(n20);
                                                String string14 = "countrycode";
                                                try {
                                                    n11 = object3.getColumnIndex(string14);
                                                    String string15 = object3.getString(n11);
                                                    string13 = "province";
                                                }
                                                catch (Exception exception) {
                                                    n11 = 0;
                                                    Object var16_37 = null;
                                                    break block101;
                                                }
                                                try {
                                                    n12 = object3.getColumnIndex(string13);
                                                    String string16 = object3.getString(n12);
                                                    string12 = "city";
                                                }
                                                catch (Exception exception) {
                                                    n12 = 0;
                                                    Object var20_59 = null;
                                                    break block100;
                                                }
                                                try {
                                                    n10 = object3.getColumnIndex(string12);
                                                    String string17 = object3.getString(n10);
                                                    object2 = "citycode";
                                                }
                                                catch (Exception exception) {
                                                    n10 = 0;
                                                    Object var39_89 = null;
                                                    break block99;
                                                }
                                                try {
                                                    int n21 = object3.getColumnIndex((String)object2);
                                                    object2 = object3.getString(n21);
                                                    string11 = "district";
                                                }
                                                catch (Exception exception) {
                                                    boolean bl2 = false;
                                                    object2 = null;
                                                    break block98;
                                                }
                                                int n22 = object3.getColumnIndex(string11);
                                                String string18 = object3.getString(n22);
                                                string2 = string5;
                                                break block97;
                                            }
                                            n11 = 0;
                                            Object var16_38 = null;
                                            n12 = 0;
                                            Object var20_60 = null;
                                            n10 = 0;
                                            Object var39_90 = null;
                                            boolean bl3 = false;
                                            object2 = null;
                                            boolean bl4 = false;
                                            Object var63_127 = null;
                                        }
                                        if (object3 == null) break block102;
                                    }
                                    catch (Throwable throwable) {
                                        break block103;
                                    }
                                    try {
                                        object3.close();
                                        break block102;
                                    }
                                    catch (Exception exception) {}
                                    catch (Exception exception) {
                                        boolean bl5 = false;
                                        string5 = null;
                                        n11 = 0;
                                        Object var16_40 = null;
                                    }
                                }
                                n12 = 0;
                                Object var20_62 = null;
                            }
                            n10 = 0;
                            Object var39_92 = null;
                        }
                        boolean bl6 = false;
                        object2 = null;
                        break block98;
                        catch (Throwable throwable) {
                            object3 = null;
                        }
                    }
                    if (object3 == null) throw var6_15;
                    try {
                        object3.close();
                    }
                    catch (Exception exception) {
                        throw var6_15;
                    }
                    throw var6_15;
                    catch (Exception exception) {
                        boolean bl7 = false;
                        string5 = null;
                        n11 = 0;
                        Object var16_43 = null;
                        n12 = 0;
                        Object var20_65 = null;
                        n10 = 0;
                        Object var39_94 = null;
                        boolean bl8 = false;
                        object2 = null;
                        object3 = null;
                    }
                    break block98;
                }
                object3 = var63_128;
                break block105;
                catch (Exception exception) {}
            }
            if (object3 != null) {
                try {
                    object3.close();
                }
                catch (Exception exception) {}
            }
            object3 = null;
            string2 = string5;
        }
        if (string2 != null) {
            byte[] byArray = string2.getBytes();
            object = null;
            byte[] byArray2 = Base64.decode((byte[])byArray, (int)0);
            string2 = string5 = new String(byArray2);
        } else {
            object = null;
        }
        if (var16_45 != null) {
            byte[] byArray = Base64.decode((byte[])var16_45.getBytes(), (int)0);
            String string19 = string5 = new String(byArray);
        }
        if (var20_67 != null) {
            byte[] byArray = Base64.decode((byte[])var20_67.getBytes(), (int)0);
            String string20 = string5 = new String(byArray);
        }
        if (var39_96 != null) {
            byte[] byArray = Base64.decode((byte[])var39_96.getBytes(), (int)0);
            String string21 = string5 = new String(byArray);
        }
        if (object2 != null) {
            object2 = Base64.decode((byte[])((String)object2).getBytes(), (int)0);
            string5 = new String((byte[])object2);
            object2 = string5;
        }
        if (object3 != null) {
            byte[] byArray = Base64.decode((byte[])object3.getBytes(), (int)0);
            string5 = new String(byArray);
            object3 = string5;
        }
        if (string3 != null) {
            byte[] byArray = Base64.decode((byte[])string3.getBytes(), (int)0);
            string5 = new String(byArray);
        } else {
            string5 = string3;
        }
        if (string4 != null) {
            byte[] byArray = string4.getBytes();
            object = Base64.decode((byte[])byArray, (int)0);
            String string22 = new String((byte[])object);
        } else {
            String string23 = string4;
        }
        object = new Address$Builder();
        return ((Address$Builder)object).country(string2).countryCode((String)var16_48).province((String)var20_70).city((String)var39_99).cityCode((String)object2).district((String)object3).street(string5).streetNumber((String)var63_139).build();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(JSONObject var1_1) {
        block40: {
            var2_3 = this.d;
            if (var2_3 != null && (var3_4 = var2_3.isOpen())) {
                var2_3 = this.d;
                var2_3.beginTransaction();
                var2_3 = l$b.values();
                var4_5 = var2_3.length;
                block34: for (var5_6 = 0; var5_6 < var4_5; ++var5_6) {
                    block39: {
                        var6_7 = var2_3[var5_6];
                        var7_8 /* !! */  = l$b.a((l$b)var6_7);
                        var8_9 = var1_1.has(var7_8 /* !! */ );
                        if (!var8_9) continue;
                        var7_8 /* !! */  = "";
                        var9_10 = l$b.b((l$b)var6_7);
                        var10_11 = var1_1.has((String)var9_10);
                        if (!var10_11) break block39;
                        var7_8 /* !! */  = l$b.b((l$b)var6_7);
                        var7_8 /* !! */  = var1_1.getString(var7_8 /* !! */ );
                    }
                    var9_10 = new ArrayList();
                    var11_12 = l$b.a((l$b)var6_7);
                    var11_12 = var1_1.getJSONObject(var11_12);
                    var12_13 = l$b.a((l$b)var6_7, (JSONObject)var11_12);
                    var9_10.add(var12_13);
                    var13_14 = l$b.c((l$b)var6_7);
                    var6_7 = var6_7.a((JSONObject)var11_12, var7_8 /* !! */ , var13_14);
                    var9_10.addAll(var6_7);
                    var6_7 = var9_10.iterator();
                    while (true) {
                        var8_9 = var6_7.hasNext();
                        if (!var8_9) continue block34;
                        var7_8 /* !! */  = var6_7.next();
                        ** try [egrp 19[TRYBLOCK] [47, 46 : 217->222)] { 
lbl54:
                        // 2 sources

                        var9_10 = this.d;
                        var9_10.execSQL(var7_8 /* !! */ );
                        continue;
                        break;
                    }
                }
                var1_1 = this.d;
                var1_1.setTransactionSuccessful();
                var14_15 = -1;
                this.e = var14_15;
                try {
                    this.f = var14_15;
                }
lbl73:
                // 25 sources

                catch (Throwable var1_2) {
                    var2_3 = this.d;
                    var2_3.endTransaction();
lbl78:
                    // 2 sources

                    throw var1_2;
                }
lbl67:
                // 2 sources

                while (true) {
                    var1_1 = this.d;
                    var1_1.endTransaction();
                    break block40;
                    break;
                }
                catch (Exception v0) {}
            }
        }
        return;
lbl83:
        // 25 sources

        catch (Exception v1) {
            ** continue;
        }
        {
            catch (Exception v2) {
                ** continue;
            }
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        int n10;
        block22: {
            void var5_12;
            block21: {
                void var5_10;
                f f10;
                block20: {
                    f f11;
                    block17: {
                        block19: {
                            int n11;
                            block18: {
                                int n12;
                                f11 = this.a.l();
                                n10 = f11.l();
                                f10 = null;
                                if (n10 == 0 || (n10 = this.f) != (n11 = -1) || (n10 = this.e) != n11 || (f11 = this.d) == null || (n10 = (int)(f11.isOpen() ? 1 : 0)) == 0) break block22;
                                n10 = 0;
                                f11 = null;
                                SQLiteDatabase sQLiteDatabase = this.d;
                                String string2 = "SELECT COUNT(*) FROM RGCSITE;";
                                Cursor cursor = sQLiteDatabase.rawQuery(string2, null);
                                cursor.moveToFirst();
                                this.f = n12 = cursor.getInt(0);
                                string2 = this.d;
                                String string3 = "SELECT COUNT(*) FROM RGCAREA;";
                                f11 = string2.rawQuery(string3, null);
                                f11.moveToFirst();
                                this.e = n12 = f11.getInt(0);
                                if (cursor == null) break block17;
                                try {
                                    cursor.close();
                                    break block17;
                                }
                                catch (Exception exception) {}
                                catch (Throwable throwable) {
                                    f10 = f11;
                                    f11 = cursor;
                                    Throwable throwable2 = throwable;
                                    break block18;
                                }
                                catch (Exception exception) {
                                    Cursor cursor2 = cursor;
                                    f f12 = f11;
                                    f11 = cursor2;
                                    break block19;
                                }
                                catch (Throwable throwable) {
                                    f10 = null;
                                }
                            }
                            if (f11 == null) break block20;
                            f11.close();
                            break block20;
                            catch (Exception exception) {
                                n11 = 0;
                                Object var5_11 = null;
                            }
                        }
                        if (f11 == null) break block21;
                        f11.close();
                        break block21;
                    }
                    if (f11 == null) break block22;
                    try {
                        f11.close();
                        break block22;
                    }
                    catch (Exception exception) {}
                    catch (Exception exception) {}
                }
                if (f10 == null) throw var5_10;
                try {
                    f10.close();
                }
                catch (Exception exception) {
                    throw var5_10;
                }
                throw var5_10;
                catch (Exception exception) {}
            }
            if (var5_12 == null) break block22;
            var5_12.close();
        }
        if ((n10 = this.f) != 0) return false;
        n10 = this.e;
        if (n10 != 0) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List b(double var1_1, double var3_2) {
        block46: {
            block45: {
                block43: {
                    var5_3 = new ArrayList<Cursor>();
                    var6_7 /* !! */  = l$b.d;
                    var7_8 = this.c;
                    var8_9 = var1_1;
                    var6_7 /* !! */  = l$b.a(var6_7 /* !! */ , var7_8, var1_1, var3_2);
                    var7_8 = 0;
                    var10_10 = null;
                    var11_11 /* !! */  = this.d;
                    var12_12 = var11_11 /* !! */ .rawQuery((String)var6_7 /* !! */ , null);
                    var13_13 = var12_12.moveToFirst();
                    if (var13_13 == 0) break block43;
                    var14_14 = null;
                    var15_15 = 0;
                    while (true) {
                        block44: {
                            var13_13 = var12_12.isAfterLast();
                            if (var13_13 != 0) break;
                            var16_16 = var12_12.getString(0);
                            var13_13 = 2;
                            var17_17 = 2.8E-45f;
                            var18_18 = var12_12.getString(var13_13);
                            var13_13 = 4;
                            var17_17 = 5.6E-45f;
                            var19_19 = var12_12.getDouble(var13_13);
                            var13_13 = 5;
                            var17_17 = 7.0E-45f;
                            var21_20 = var12_12.getDouble(var13_13);
                            var13_13 = 6;
                            var17_17 = 8.4E-45f;
                            var23_21 = var12_12.getInt(var13_13);
                            var6_7 /* !! */  = this;
                            var24_22 = this.c(var3_2, var1_1, var21_20, var19_19);
                            var11_11 /* !! */  = l$b.d;
                            var8_9 = l$b.d((l$b)var11_11 /* !! */ );
                            var26_23 = var24_22 == var8_9 ? 0 : (var24_22 < var8_9 ? -1 : 1);
                            if (var26_23 >= 0) break block44;
                            var28_25 /* !! */  = var16_16.getBytes();
                            var28_25 /* !! */  = Base64.decode((byte[])var28_25 /* !! */ , (int)0);
                            var27_24 = new String(var28_25 /* !! */ );
                            var28_25 /* !! */  = (byte[])new String;
                            var29_26 = var18_18.getBytes();
                            var29_26 = Base64.decode((byte[])var29_26, (int)0);
                            var28_25 /* !! */ (var29_26);
                            var30_27 = 1.0;
                            var32_28 = "";
                            var33_29 = "";
                            var11_11 /* !! */  = new Poi(var27_24, (String)var28_25 /* !! */ , var30_27, var32_28, var33_29);
                            var17_17 = (float)var24_22;
                            var13_13 = Math.round(var17_17);
                            var7_8 = var23_21;
                            var13_13 = l.a(var23_21, var13_13);
                            if (var13_13 <= var15_15) break block44;
                            var15_15 = var13_13;
                            var14_14 = var11_11 /* !! */ ;
                        }
                        var12_12.moveToNext();
                        continue;
                        break;
                    }
                    var10_10 = var14_14;
                }
                if (var12_12 == null) ** GOTO lbl110
                var12_12.close();
                ** GOTO lbl110
                catch (Throwable var5_4) {
                    var10_10 = var12_12;
                    break block45;
                }
                catch (Exception v0) {
                    var14_14 = null;
lbl91:
                    // 2 sources

                    while (true) {
                        var10_10 = var12_12;
                        break block46;
                        break;
                    }
                }
                catch (Throwable var5_5) {
                    // empty catch block
                }
            }
            if (var10_10 != null) {
                var10_10.close();
            }
lbl100:
            // 4 sources

            throw var5_6;
            catch (Exception v1) {
                var14_14 = null;
            }
        }
        if (var10_10 != null) {
            var10_10.close();
        }
lbl108:
        // 4 sources

        while (true) {
            var10_10 = var14_14;
lbl110:
            // 4 sources

            while (true) {
                if (var10_10 != null) {
                    var5_3.add(var10_10);
                }
                return var5_3;
            }
            break;
        }
        catch (Exception v2) {
            ** continue;
        }
        catch (Exception v3) {
            ** continue;
        }
        catch (Exception v4) {
            ** continue;
        }
        catch (Exception v5) {
            ** continue;
        }
    }

    /*
     * Exception decompiling
     */
    public JSONObject b() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 60[TRYBLOCK] [150, 151 : 797->800)] java.lang.Exception
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
}

