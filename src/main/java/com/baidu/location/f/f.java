/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.GnssNavigationMessage$Callback
 *  android.location.GnssStatus$Callback
 *  android.location.GpsStatus
 *  android.location.GpsStatus$Listener
 *  android.location.GpsStatus$NmeaListener
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.location.OnNmeaMessageListener
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.baidu.location.f;

import android.content.Context;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.ac;
import com.baidu.location.b.ad;
import com.baidu.location.b.q;
import com.baidu.location.b.y;
import com.baidu.location.f.a;
import com.baidu.location.f.b;
import com.baidu.location.f.f$a;
import com.baidu.location.f.f$b;
import com.baidu.location.f.f$c;
import com.baidu.location.f.f$d;
import com.baidu.location.f.f$e;
import com.baidu.location.f.f$f;
import com.baidu.location.f.f$g;
import com.baidu.location.f.f$h;
import com.baidu.location.f.g;
import com.baidu.location.f.i;
import com.baidu.location.h.c;
import com.baidu.location.h.e;
import com.baidu.location.h.l;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class f {
    private static String E;
    private static double G = 100.0;
    private static float J = -1.0f;
    public static int a = 0;
    public static String b = "";
    private static f c;
    private static int p;
    private static int q;
    private static long r;
    private double A;
    private long B;
    private long C;
    private long D;
    private f$e F;
    private long H;
    private long I;
    private f$a K;
    private f$b L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private ArrayList P;
    private ArrayList Q;
    private String R;
    private long S;
    private ArrayList T;
    private String U;
    private long V;
    private long W;
    private long X;
    private BDLocation Y;
    private boolean Z;
    private boolean aa;
    private Context d;
    private LocationManager e;
    private Location f;
    private f$f g;
    private f$h h;
    private GpsStatus i;
    private f$c j;
    private boolean k;
    private f$d l;
    private boolean m;
    private GpsStatus.NmeaListener n;
    private OnNmeaMessageListener o;
    private long s;
    private boolean t;
    private boolean u;
    private String v;
    private boolean w;
    private long x;
    private double y;
    private double z;

    private f() {
        ArrayList arrayList;
        double d10;
        long l10;
        String string2 = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.s = l10 = 0L;
        this.t = false;
        this.u = false;
        this.v = null;
        this.w = false;
        this.x = l10;
        this.y = -1.0;
        this.z = d10 = 0.0;
        this.A = d10;
        this.B = l10;
        this.C = l10;
        this.D = l10;
        this.F = null;
        this.H = l10;
        this.I = l10;
        this.K = null;
        this.L = null;
        this.M = arrayList = new ArrayList();
        this.N = arrayList = new ArrayList();
        this.O = arrayList = new ArrayList();
        this.P = arrayList = new ArrayList();
        this.Q = arrayList = new ArrayList();
        this.R = null;
        this.S = l10;
        this.T = arrayList = new ArrayList();
        this.U = null;
        this.V = l10;
        this.W = l10;
        this.X = l10;
        this.Z = false;
        this.aa = false;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            string2 = "android.location.GnssStatus";
            Class.forName(string2);
            n10 = 1;
            try {
                this.k = n10;
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.k = false;
            }
        }
        this.m = false;
    }

    public static /* synthetic */ int a(int n10) {
        p = n10;
        return n10;
    }

    public static /* synthetic */ long a(long l10) {
        r = l10;
        return l10;
    }

    public static /* synthetic */ long a(f f10, long l10) {
        f10.D = l10;
        return l10;
    }

    public static /* synthetic */ GpsStatus a(f f10, GpsStatus gpsStatus) {
        f10.i = gpsStatus;
        return gpsStatus;
    }

    public static f a() {
        Class<f> clazz = f.class;
        synchronized (clazz) {
            f f10 = c;
            if (f10 == null) {
                c = f10 = new f();
            }
            f10 = c;
            return f10;
        }
    }

    public static String a(Location location) {
        Object object;
        if (location == null) {
            boolean bl2 = false;
            float f10 = 0.0f;
            object = null;
        } else {
            float f11;
            int n10;
            double d10 = location.getSpeed();
            double d11 = 3.6;
            float f12 = (float)(d10 *= d11);
            int n11 = location.hasSpeed();
            int n12 = -1082130432;
            float f13 = -1.0f;
            if (n11 == 0) {
                n10 = n12;
                f12 = f13;
            }
            if ((n11 = location.hasAccuracy()) != 0) {
                f11 = location.getAccuracy();
            } else {
                n11 = n12;
                f11 = f13;
            }
            n11 = (int)f11;
            boolean bl3 = location.hasAltitude();
            double d12 = bl3 ? location.getAltitude() : 555.0;
            int n13 = location.hasBearing();
            if (n13 != 0) {
                f13 = location.getBearing();
            }
            float f14 = J;
            float f15 = f14 - -0.01f;
            n13 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            int n14 = 11;
            int n15 = 10;
            int n16 = 9;
            int n17 = 8;
            long l10 = 1000L;
            int n18 = 7;
            int n19 = 6;
            int n20 = 5;
            int n21 = 4;
            int n22 = 3;
            int n23 = 2;
            int n24 = 1;
            Double d13 = null;
            if (n13 < 0) {
                Locale locale = Locale.CHINA;
                Object[] objectArray = new Object[n14];
                double d14 = location.getLongitude();
                Double d15 = d14;
                objectArray[0] = d15;
                double d16 = location.getLatitude();
                d13 = d16;
                objectArray[n24] = d13;
                objectArray[n23] = object = Float.valueOf(f12);
                objectArray[n22] = object = Float.valueOf(f13);
                objectArray[n21] = object = Integer.valueOf(n11);
                objectArray[n20] = object = Integer.valueOf(a);
                objectArray[n19] = object = Double.valueOf(d12);
                long l11 = location.getTime() / l10;
                objectArray[n18] = object = Long.valueOf(l11);
                objectArray[n17] = object = Integer.valueOf(a);
                n10 = p;
                objectArray[n16] = object = Integer.valueOf(n10);
                d10 = G;
                objectArray[n15] = object = Double.valueOf(d10);
                object = String.format(locale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", objectArray);
            } else {
                Locale locale = Locale.CHINA;
                n14 = 12;
                Object[] objectArray = new Object[n14];
                Double d17 = location.getLongitude();
                objectArray[0] = d17;
                double d18 = location.getLatitude();
                d13 = d18;
                objectArray[n24] = d13;
                objectArray[n23] = object = Float.valueOf(f12);
                objectArray[n22] = object = Float.valueOf(f13);
                objectArray[n21] = object = Integer.valueOf(n11);
                objectArray[n20] = object = Integer.valueOf(a);
                objectArray[n19] = object = Double.valueOf(d12);
                long l12 = location.getTime() / l10;
                objectArray[n18] = object = Long.valueOf(l12);
                objectArray[n17] = object = Integer.valueOf(a);
                n10 = p;
                objectArray[n16] = object = Integer.valueOf(n10);
                d10 = G;
                objectArray[n15] = object = Double.valueOf(d10);
                f12 = J;
                object = Float.valueOf(f12);
                n11 = 11;
                f11 = 1.5E-44f;
                objectArray[n11] = object;
                object = String.format(locale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f&ll_bp=%.2f", objectArray);
            }
        }
        return object;
    }

    private String a(ArrayList object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = ((ArrayList)object).size();
        if (n10 == 0) {
            return stringBuilder.toString();
        }
        object = ((ArrayList)object).iterator();
        int n11 = n10 = 1;
        while (bl2 = object.hasNext()) {
            Object[] objectArray;
            int n12;
            Object object2 = (ArrayList)object.next();
            int n13 = ((ArrayList)object2).size();
            if (n13 != (n12 = 6)) continue;
            n13 = 0;
            if (n11 != 0) {
                n11 = 0;
            } else {
                objectArray = "|";
                stringBuilder.append((String)objectArray);
            }
            objectArray = new Object[n10];
            Object object3 = ((ArrayList)object2).get(0);
            objectArray[0] = object3;
            object3 = "%.1f;";
            objectArray = String.format(object3, objectArray);
            stringBuilder.append((String)objectArray);
            objectArray = new Object[n10];
            Object e10 = ((ArrayList)object2).get(n10);
            objectArray[0] = e10;
            objectArray = String.format(object3, objectArray);
            stringBuilder.append((String)objectArray);
            objectArray = new Object[n10];
            e10 = ((ArrayList)object2).get(2);
            objectArray[0] = e10;
            objectArray = String.format(object3, objectArray);
            stringBuilder.append((String)objectArray);
            objectArray = new Object[n10];
            object3 = ((ArrayList)object2).get(3);
            objectArray[0] = object3;
            objectArray = String.format("%.0f;", objectArray);
            stringBuilder.append((String)objectArray);
            objectArray = new Object[n10];
            int n14 = 4;
            object3 = ((ArrayList)object2).get(n14);
            objectArray[0] = object3;
            object3 = "%.0f";
            objectArray = String.format(object3, objectArray);
            stringBuilder.append((String)objectArray);
            objectArray = new Object[n10];
            int n15 = 5;
            objectArray[0] = object2 = ((ArrayList)object2).get(n15);
            object2 = String.format(object3, objectArray);
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ ArrayList a(f f10, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, float f11) {
        return f10.a(bl2, bl3, bl4, bl5, bl6, f11);
    }

    private ArrayList a(ArrayList object, boolean bl2, float f10) {
        ArrayList<ArrayList> arrayList = new ArrayList<ArrayList>();
        int n10 = ((ArrayList)object).size();
        int n11 = 40;
        float f11 = 5.6E-44f;
        if (n10 <= n11 && (n10 = ((ArrayList)object).size()) != 0) {
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                float f12;
                float f13;
                ArrayList arrayList2 = (ArrayList)object.next();
                n11 = arrayList2.size();
                int n12 = 6;
                float f14 = 8.4E-45f;
                if (n11 != n12) continue;
                n11 = 3;
                Float f15 = (Float)arrayList2.get(n11);
                f11 = f15.floatValue();
                n12 = 2;
                Float f16 = (Float)arrayList2.get(n12);
                f14 = f16.floatValue();
                if (bl2 && (n11 = (int)((f13 = f11 - (f12 = 1.0f)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) < 0) continue;
                f11 = 0.0f;
                f15 = null;
                float f17 = f10 - 0.0f;
                n11 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
                if (n11 > 0 && (n11 = (int)(f14 == f10 ? 0 : (f14 < f10 ? -1 : 1))) < 0) continue;
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private ArrayList a(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, float f10) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (bl2) {
            arrayList = this.N;
            arrayList = this.a(arrayList, bl6, f10);
            arrayList2.addAll(arrayList);
        }
        if (bl3) {
            arrayList = this.O;
            arrayList = this.a(arrayList, bl6, f10);
            arrayList2.addAll(arrayList);
        }
        if (bl4) {
            arrayList = this.P;
            arrayList = this.a(arrayList, bl6, f10);
            arrayList2.addAll(arrayList);
        }
        if (bl5) {
            arrayList = this.Q;
            arrayList = this.a(arrayList, bl6, f10);
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    public static /* synthetic */ void a(f f10, Location location) {
        f10.f(location);
    }

    public static /* synthetic */ void a(f f10, String string2) {
        f10.a(string2);
    }

    public static /* synthetic */ void a(f f10, String string2, Location location) {
        f10.a(string2, location);
    }

    public static /* synthetic */ void a(f f10, ArrayList arrayList) {
        f10.b(arrayList);
    }

    public static /* synthetic */ void a(f f10, boolean bl2) {
        f10.b(bl2);
    }

    private void a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (n10 = this.b(string2)) != 0) {
            String string3 = "$GPGGA,";
            n10 = string2.startsWith(string3);
            int n11 = 2;
            if (n10 != 0) {
                n10 = 4;
                int n12 = 6;
                this.a(string2, n11, n10, n12);
            } else {
                string3 = "$GPRMC,";
                n10 = (int)(string2.startsWith(string3) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 3;
                    int n13 = 5;
                    this.a(string2, n10, n13, n11);
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(String var1_1, int var2_2, int var3_3, int var4_4) {
        block36: {
            block35: {
                block40: {
                    block39: {
                        block38: {
                            block37: {
                                var5_5 = TextUtils.isEmpty((CharSequence)var1_1);
                                if (var5_5 || !(var5_5 = this.b((String)var1_1))) break block36;
                                var6_6 = var1_1.split(",");
                                var7_7 = "$GPGGA,";
                                var8_8 = var1_1.startsWith(var7_7);
                                var9_9 = 6;
                                if (var8_8 != 0 ? (var10_10 = var6_6.length) < (var8_8 = 7) : (var10_10 = (int)var1_1.startsWith(var7_7 = "$GPRMC,")) != 0 && (var10_10 = var6_6.length) < var9_9) {
                                    return;
                                }
                                var1_1 = var6_6[var2_2].trim();
                                var10_10 = (int)TextUtils.isEmpty((CharSequence)var1_1);
                                var11_11 = 60.0;
                                var7_7 = ".";
                                var13_12 = true;
                                var14_13 = 2;
                                if (var10_10 != 0 || (var10_10 = (var1_1 = var6_6[var2_2].trim()).length()) <= var14_13 || (var10_10 = (int)(var1_1 = var6_6[var2_2].trim()).contains(var7_7)) == 0) break block37;
                                var1_1 = var6_6[var2_2];
                                var1_1 = var1_1.substring(0, var14_13);
                                var1_1 = Double.valueOf((String)var1_1);
                                var15_14 = var1_1.doubleValue();
                                var1_1 = var6_6[var2_2];
                                var1_1 = var1_1.substring(var14_13);
                                var1_1 = Double.valueOf((String)var1_1);
                                var17_15 = var1_1.doubleValue() / var11_11;
                                var15_14 += var17_15;
                                var1_1 = this.Y;
                                if (var1_1 != null) ** GOTO lbl40
                                var1_1 = new BDLocation();
                                this.Y = var1_1;
lbl40:
                                // 2 sources

                                var1_1 = this.Y;
                                try {
                                    var1_1.setLatitude(var15_14);
                                }
                                catch (NumberFormatException v0) {
                                    this.aa = var13_12;
                                }
                                break block38;
                            }
                            this.Y = null;
                        }
                        if ((var1_1 = this.Y) != null && (var10_10 = (int)TextUtils.isEmpty((CharSequence)(var1_1 = var6_6[var3_3].trim()))) == 0 && (var10_10 = (var1_1 = var6_6[var3_3].trim()).length()) > (var2_2 = 3) && (var10_10 = (int)(var1_1 = var6_6[var3_3].trim()).contains(var7_7)) != 0) {
                            var1_1 = var6_6[var3_3];
                            var1_1 = var1_1.substring(0, var2_2);
                            var1_1 = Double.valueOf((String)var1_1);
                            var15_14 = var1_1.doubleValue();
                            var1_1 = var6_6[var3_3];
                            var1_1 = var1_1.substring(var2_2);
                            var1_1 = Double.valueOf((String)var1_1);
                            var17_15 = var1_1.doubleValue() / var11_11;
                            var15_14 += var17_15;
                            var1_1 = this.Y;
                            try {
                                var1_1.setLongitude(var15_14);
                            }
                            catch (NumberFormatException v1) {
                                this.aa = var13_12;
                            }
                        } else {
                            this.Y = null;
                        }
                        if ((var10_10 = (int)TextUtils.isEmpty((CharSequence)(var1_1 = var6_6[var4_4].trim()))) != 0) break block35;
                        if (var4_4 != var14_13) break block39;
                        var1_1 = var6_6[var4_4];
                        var19_16 = "V";
                        var10_10 = (int)TextUtils.equals((CharSequence)var1_1, (CharSequence)var19_16);
                        if (var10_10 != 0) lbl-1000:
                        // 2 sources

                        {
                            while (true) {
                                this.Z = false;
                                break block35;
                                break;
                            }
                        }
                        var1_1 = var6_6[var4_4];
                        var19_16 = "A";
                        var10_10 = (int)TextUtils.equals((CharSequence)var1_1, (CharSequence)var19_16);
                        if (var10_10 == 0) break block35;
                        break block40;
                    }
                    if (var4_4 != var9_9) break block35;
                    ** while ((var10_10 = (int)TextUtils.equals((CharSequence)(var1_1 = var6_6[var4_4]), (CharSequence)(var19_17 = "0"))) != 0)
                }
                this.Z = var13_12;
            }
            if ((var1_1 = this.Y) != null) {
                this.aa = false;
            }
            this.X = var20_18 = System.currentTimeMillis();
        }
    }

    private void a(String string2, Location object) {
        if (object == null) {
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        string2 = com.baidu.location.b.b.a().d();
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object2 = com.baidu.location.f.i.a();
        boolean bl2 = ((i)object2).f();
        a a10 = com.baidu.location.f.b.a().f();
        a a11 = new a(a10);
        com.baidu.location.b.y.a(a11);
        long l10 = System.currentTimeMillis();
        com.baidu.location.b.y.a(l10);
        a10 = new Location(object);
        com.baidu.location.b.y.a((Location)a10);
        com.baidu.location.b.y.a(string2);
        if (!bl2) {
            object = com.baidu.location.b.y.c();
            bl2 = false;
            object2 = null;
            a10 = com.baidu.location.b.y.d();
            ac.a((a)object, null, (Location)a10, string2);
        }
    }

    public static boolean a(Location location, Location location2, boolean n10) {
        boolean bl2 = false;
        if (location == location2) {
            return false;
        }
        boolean bl3 = true;
        if (location != null && location2 != null) {
            double d10;
            double d11;
            e e10;
            int n11;
            float f10 = location2.getSpeed();
            float f11 = 5.0f;
            if (n10 != 0 && ((n10 = com.baidu.location.h.l.x) == (n11 = 3) || (n10 = (int)((e10 = com.baidu.location.h.e.a()).a(d11 = location2.getLongitude(), d10 = location2.getLatitude()) ? 1 : 0)) == 0) && (n10 = (int)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1))) < 0) {
                return bl3;
            }
            float f12 = location2.distanceTo(location);
            float f13 = com.baidu.location.h.l.N;
            float f14 = f10 - f13;
            Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object > 0) {
                f13 = com.baidu.location.h.l.P;
                float f15 = f12 - f13;
                Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object2 > 0) {
                    bl2 = bl3;
                }
                return bl2;
            }
            f13 = com.baidu.location.h.l.M;
            float f16 = f10 - f13;
            object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object > 0) {
                f13 = com.baidu.location.h.l.O;
                float f17 = f12 - f13;
                Object object3 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                if (object3 > 0) {
                    bl2 = bl3;
                }
                return bl2;
            }
            Object object4 = f12 == f11 ? 0 : (f12 > f11 ? 1 : -1);
            if (object4 > 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        return bl3;
    }

    public static /* synthetic */ boolean a(f f10) {
        return f10.u;
    }

    public static /* synthetic */ int b(int n10) {
        q = n10;
        return n10;
    }

    public static /* synthetic */ long b(f f10, long l10) {
        f10.W = l10;
        return l10;
    }

    public static /* synthetic */ f$e b(f f10) {
        return f10.F;
    }

    public static String b(Location object) {
        if ((object = com.baidu.location.f.f.a(object)) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append("&g_tp=0");
            object = stringBuilder.toString();
        }
        return object;
    }

    public static /* synthetic */ ArrayList b(f f10, ArrayList arrayList) {
        f10.M = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void b(f f10, Location location) {
        f10.d(location);
    }

    private void b(ArrayList object) {
        long l10;
        int n10;
        if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
            object = new StringBuilder(100);
            int n11 = com.baidu.location.h.c.g(this.N);
            ((StringBuilder)object).append(n11);
            Object object2 = "|";
            ((StringBuilder)object).append((String)object2);
            int n12 = com.baidu.location.h.c.f(this.N);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            n12 = com.baidu.location.h.c.a(this.N);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            n12 = com.baidu.location.h.c.h(this.N);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            n12 = com.baidu.location.h.c.b(this.N);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            n12 = com.baidu.location.h.c.c(this.N);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            ArrayList arrayList = this.N;
            n12 = com.baidu.location.h.c.e(arrayList);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object2);
            object2 = this.N;
            n11 = com.baidu.location.h.c.d((ArrayList)object2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
        } else {
            n10 = 0;
            object = null;
        }
        this.R = object;
        this.S = l10 = System.currentTimeMillis();
    }

    private void b(boolean bl2) {
        this.w = bl2;
        J = -1.0f;
    }

    public static /* synthetic */ boolean b(f f10, boolean bl2) {
        f10.t = bl2;
        return bl2;
    }

    private boolean b(String string2) {
        int n10;
        String string3 = "*";
        int n11 = string2.indexOf(string3);
        if (n11 == (n10 = -1)) {
            return false;
        }
        Object object = "$";
        int n12 = string2.indexOf((String)object);
        if (n12 == n10) {
            return false;
        }
        n11 = string2.indexOf((String)object);
        if (n11 > (n12 = string2.indexOf(string3))) {
            return false;
        }
        n11 = string2.length();
        if (n11 >= (n12 = string2.indexOf(string3))) {
            boolean bl2;
            Object object2;
            Object object3;
            n11 = string2.indexOf(string3);
            object = string2.substring(0, n11).getBytes();
            n12 = 1;
            Object object4 = object[n12];
            for (int i10 = 2; i10 < (object3 = ((Object)object).length); ++i10) {
                object3 = object[i10];
                object4 = object4 ^ object3;
            }
            object = new Object[n12];
            object[0] = object2 = Integer.valueOf((int)object4);
            object2 = "%02x";
            object = String.format((String)object2, (Object[])object);
            int n13 = string2.indexOf(string3);
            if (n13 == n10) {
                return false;
            }
            n10 = string2.length();
            if (n10 >= (object4 = (Object)(n13 + 3)) && (bl2 = ((String)object).equalsIgnoreCase(string2 = string2.substring(n13 += n12, (int)object4)))) {
                return n12 != 0;
            }
        }
        return false;
    }

    public static /* synthetic */ long c(f f10) {
        return f10.C;
    }

    public static /* synthetic */ long c(f f10, long l10) {
        f10.B = l10;
        return l10;
    }

    public static String c(Location object) {
        if ((object = com.baidu.location.f.f.a(object)) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = E;
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        return object;
    }

    public static /* synthetic */ String c(f f10, ArrayList arrayList) {
        return f10.a(arrayList);
    }

    public static /* synthetic */ long d(f f10) {
        return f10.I;
    }

    public static /* synthetic */ long d(f f10, long l10) {
        f10.C = l10;
        return l10;
    }

    private void d(Location location) {
        f$e f$e = this.F;
        if (f$e != null) {
            int n10 = 1;
            location = f$e.obtainMessage(n10, location);
            f$e = this.F;
            f$e.sendMessage((Message)location);
        }
    }

    /*
     * Unable to fully structure code
     */
    private int e(Location var1_1) {
        block37: {
            block34: {
                var2_2 = this;
                var3_3 = -1;
                if (var1_1 == null) {
                    return var3_3;
                }
                var4_4 = Build.VERSION.SDK_INT;
                var5_5 = 17;
                var6_6 = 1;
                if (var4_4 <= var5_5) break block34;
                var4_4 = (int)var1_1.isFromMockProvider();
                if (var4_4 == 0) break block34;
                return var6_6;
            }
            var7_7 = var2_2.W;
            var9_8 = var2_2.X;
            var7_7 -= var9_8;
            var7_7 = Math.abs(var7_7);
            cfr_temp_0 = var7_7 - 3000L;
            var4_4 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            var5_5 = 0;
            var9_8 = 0L;
            if (var4_4 < 0) {
                block35: {
                    block36: {
                        var11_9 = var2_2.Y;
                        if (var11_9 != null) break block35;
                        var4_4 = (int)var2_2.Z;
                        if (var4_4 != 0) break block36;
                        return var6_6;
                    }
                    var4_4 = (int)var2_2.aa;
                    if (var4_4 != 0) {
                        return var6_6;
                    }
                    break block37;
                }
                var4_4 = (int)var2_2.aa;
                ** if (var4_4 != 0) goto lbl-1000
lbl-1000:
                // 1 sources

                {
                    var4_4 = (int)var2_2.Z;
                    ** if (var4_4 == 0) goto lbl-1000
lbl-1000:
                    // 1 sources

                    {
                        var11_9 = new float[var6_6];
                        var12_10 = var1_1.getLatitude();
                        var14_11 = var1_1.getLongitude();
                        var16_12 = var2_2.Y;
                        var17_13 = var16_12.getLatitude();
                        var19_14 = var2_2.Y;
                        var20_15 = var19_14.getLongitude();
                        Location.distanceBetween((double)var12_10, (double)var14_11, (double)var17_13, (double)var20_15, (float[])var11_9);
                        var22_16 = var11_9[0];
                        var12_10 = (double)var22_16;
                        var14_11 = com.baidu.location.h.l.n;
                        var4_4 = (int)(var12_10 == var14_11 ? 0 : (var12_10 > var14_11 ? 1 : -1));
                        if (var4_4 > 0) {
                            return var6_6;
                        }
                    }
                }
lbl-1000:
                // 4 sources

                {
                    break block37;
                }
            }
            var23_17 = var2_2.W;
            var4_4 = (int)(var23_17 == var9_8 ? 0 : (var23_17 < var9_8 ? -1 : 1));
            if (var4_4 > 0) {
                var23_17 = var2_2.X;
                var4_4 = (int)(var23_17 == var9_8 ? 0 : (var23_17 < var9_8 ? -1 : 1));
                if (var4_4 == 0) {
                    var4_4 = (int)com.baidu.location.h.l.m();
                    if (var4_4 == 0) break block37;
                    return var6_6;
                }
            }
        }
        var2_2.W = var9_8;
        try {
            var2_2.X = var9_8;
            return 0;
        }
        catch (Error | Exception v0) {
            return var3_3;
        }
    }

    public static /* synthetic */ long e(f f10) {
        return f10.D;
    }

    public static /* synthetic */ long e(f f10, long l10) {
        f10.s = l10;
        return l10;
    }

    public static /* synthetic */ long f(f f10, long l10) {
        f10.I = l10;
        return l10;
    }

    public static /* synthetic */ LocationManager f(f f10) {
        return f10.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f(Location object) {
        int n10;
        double d10;
        long l10;
        long l11;
        int n11 = 0;
        Object var3_3 = null;
        if (object == null) {
            this.f = null;
            return;
        }
        int n12 = a;
        Location location = "satellites";
        if (n12 == 0) {
            try {
                Bundle bundle = object.getExtras();
                n12 = bundle.getInt((String)location);
            }
            catch (Exception exception) {}
        }
        if (n12 == 0) {
            l11 = System.currentTimeMillis();
            l10 = this.I;
            l11 = Math.abs(l11 - l10);
            l10 = 5000L;
            d10 = 2.4703E-320;
            n12 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
            if (n12 > 0 && (n12 = (int)(com.baidu.location.h.l.m ? 1 : 0)) == 0) {
                return;
            }
        }
        if ((n12 = (int)(this.m ? 1 : 0)) != 0) {
            double d11;
            float f10 = object.getSpeed();
            double d12 = f10;
            l10 = 0L;
            d10 = 0.0;
            double d13 = d12 - d10;
            n12 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
            if (n12 == 0 && (n12 = (int)((d11 = (d12 = this.z) - d10) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1))) != 0) {
                l11 = System.currentTimeMillis();
                d12 = l11;
                d10 = this.A;
                d12 -= d10;
                l10 = 4656510908468559872L;
                d10 = 2000.0;
                double d14 = d12 - d10;
                n12 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
                if (n12 < 0) {
                    d12 = this.z;
                    f10 = (float)d12;
                    object.setSpeed(f10);
                }
            }
        }
        Location location2 = new Location((Location)object);
        this.x = l11 = System.currentTimeMillis();
        this.f = object;
        int n13 = a;
        int n14 = 2;
        int n15 = 1;
        if (object == null) {
            this.v = null;
        } else {
            long l12 = System.currentTimeMillis();
            this.f.setTime(l12);
            object = this.f;
            double d15 = object.getSpeed();
            double d16 = 3.6;
            float f11 = (float)(d15 *= d16);
            Location location3 = this.f;
            n11 = (int)(location3.hasSpeed() ? 1 : 0);
            if (n11 == 0) {
                n10 = -1082130432;
                f11 = -1.0f;
            }
            if (n13 == 0) {
                try {
                    Location location4 = this.f;
                    Bundle bundle = location4.getExtras();
                    n13 = bundle.getInt((String)location);
                }
                catch (Exception exception) {}
            }
            Locale locale = Locale.CHINA;
            int n16 = 6;
            location = new Object[n16];
            double d17 = this.f.getLongitude();
            Double d18 = d17;
            location[0] = d18;
            d15 = this.f.getLatitude();
            Double d19 = d15;
            location[n15] = d19;
            object = Float.valueOf(f11);
            location[n14] = object;
            float f12 = this.f.getBearing();
            Float f13 = Float.valueOf(f12);
            location[3] = f13;
            Integer n17 = n13;
            location[4] = n17;
            n10 = 5;
            f11 = 7.0E-45f;
            Long l13 = l12;
            location[n10] = l13;
            this.v = object = String.format(locale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", (Object[])location);
        }
        object = this.f;
        if (object != null) {
            object = com.baidu.location.indoor.g.a();
            n10 = ((com.baidu.location.indoor.g)object).e();
            if (n10 != 0) {
                object = com.baidu.location.indoor.g.a();
                Location location5 = this.f;
                location = this.M;
                ((com.baidu.location.indoor.g)object).a(location5, (ArrayList)location);
            }
            if ((n10 = ((com.baidu.location.indoor.g)(object = com.baidu.location.indoor.g.a())).f()) == 0) {
                object = com.baidu.location.indoor.g.a();
                n10 = (int)(((com.baidu.location.indoor.g)object).f() ? 1 : 0);
                this.n();
            }
            n10 = a;
            if (n10 > n14 && (n10 = (int)(ac.a((Location)(object = this.f), n15 != 0) ? 1 : 0)) != 0) {
                object = com.baidu.location.f.i.a();
                n10 = (int)(((i)object).f() ? 1 : 0);
                a a10 = com.baidu.location.f.b.a().f();
                location = new a(a10);
                com.baidu.location.b.y.a((a)location);
                long l14 = System.currentTimeMillis();
                com.baidu.location.b.y.a(l14);
                location = this.f;
                Location location6 = new Location(location);
                com.baidu.location.b.y.a(location6);
                String string2 = com.baidu.location.b.b.a().d();
                com.baidu.location.b.y.a(string2);
                if (n10 == 0) {
                    object = ad.a();
                    ((ad)object).b();
                }
            }
        }
        object = ad.a();
        n11 = a;
        ((ad)object).a(location2, n11);
    }

    public static /* synthetic */ ArrayList g(f f10) {
        return f10.N;
    }

    public static /* synthetic */ ArrayList h(f f10) {
        return f10.O;
    }

    public static /* synthetic */ ArrayList i(f f10) {
        return f10.P;
    }

    public static /* synthetic */ ArrayList j(f f10) {
        return f10.Q;
    }

    public static /* synthetic */ ArrayList k(f f10) {
        return f10.M;
    }

    public static /* synthetic */ GpsStatus l(f f10) {
        return f10.i;
    }

    public static String l() {
        Object object;
        long l10;
        int n10;
        long l11 = System.currentTimeMillis();
        long l12 = r;
        long l13 = (l11 -= l12) - (l12 = 0L);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 >= 0 && (n10 = (l10 = l11 - (l12 = 3000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
            object = Locale.US;
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            Integer n12 = q;
            objectArray[0] = n12;
            object2 = 1;
            int n13 = a;
            n12 = n13;
            objectArray[object2] = n12;
            String string2 = "&gsvn=%d&gsfn=%d";
            object = String.format((Locale)object, string2, objectArray);
        } else {
            n10 = 0;
            object = null;
        }
        return object;
    }

    public void a(boolean bl2) {
        if (bl2) {
            this.c();
        } else {
            this.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            f$e f$e;
            Context context;
            boolean bl2 = com.baidu.location.f.isServing;
            if (!bl2) {
                return;
            }
            this.d = context = com.baidu.location.f.getServiceContext();
            String string2 = "location";
            try {
                f$h f$h;
                LocationManager locationManager;
                Object object = context.getSystemService(string2);
                this.e = locationManager = (LocationManager)object;
                bl2 = this.k;
                string2 = null;
                if (!bl2) {
                    f$d f$d;
                    this.l = f$d = new f$d(this, null);
                    LocationManager locationManager2 = this.e;
                    locationManager2.addGpsStatusListener((GpsStatus.Listener)f$d);
                } else {
                    f$c f$c;
                    this.j = f$c = new f$c(this, null);
                    LocationManager locationManager3 = this.e;
                    locationManager3.registerGnssStatusCallback((GnssStatus.Callback)f$c);
                }
                this.h = f$h = new f$h(this, null);
                LocationManager locationManager4 = this.e;
                String string3 = "passive";
                long l10 = 9000L;
                locationManager4.requestLocationUpdates(string3, l10, 0.0f, (LocationListener)f$h);
            }
            catch (Exception exception) {}
            this.F = f$e = new f$e(this);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void c() {
        var1_1 = com.baidu.location.h.a.a;
        var2_2 = "start gps...";
        Log.d((String)var1_1, (String)var2_2);
        var3_3 = this.u;
        if (var3_3 != 0) {
            return;
        }
        var2_2 = null;
        var1_1 = new f$f(this, null);
        this.g = var1_1;
        var1_1 = new Bundle();
        var4_4 = this.e;
        var5_5 = "gps";
        var6_6 = "force_xtra_injection";
        try {
            var4_4.sendExtraCommand((String)var5_5, (String)var6_6, (Bundle)var1_1);
        }
        catch (Exception v0) {
            ** continue;
        }
lbl21:
        // 2 sources

        while (true) {
            block43: {
                block44: {
                    var7_7 = this.e;
                    var8_8 = "gps";
                    var9_9 = 1000L;
                    var11_10 = this.g;
                    var7_7.requestLocationUpdates(var8_8, var9_9, 0.0f, (LocationListener)var11_10);
                    var3_3 = this.k;
                    var12_11 = 1;
                    if (var3_3 == 0) ** GOTO lbl50
                    var1_1 = this.L;
                    if (var1_1 != null) ** GOTO lbl50
                    var3_3 = com.baidu.location.h.l.aE;
                    if (var3_3 != var12_11) ** GOTO lbl50
                    var1_1 = new Random();
                    var13_12 = var1_1.nextDouble();
                    var15_13 = com.baidu.location.h.l.aD;
                    var3_3 = (int)(var13_12 == var15_13 ? 0 : (var13_12 < var15_13 ? -1 : 1));
                    if (var3_3 >= 0) ** GOTO lbl50
                    var1_1 = new f$b(this, null);
                    this.L = var1_1;
lbl50:
                    // 5 sources

                    if ((var1_1 = this.L) == null) ** GOTO lbl56
                    var5_5 = this.e;
                    var5_5.registerGnssNavigationMessageCallback((GnssNavigationMessage.Callback)var1_1);
lbl56:
                    // 2 sources

                    var17_14 = System.currentTimeMillis();
                    this.H = var17_14;
                    var3_3 = (int)com.baidu.location.h.l.m;
                    if (var3_3 != 0) break block43;
                    var3_3 = com.baidu.location.h.l.aF;
                    if (var3_3 != var12_11) break block43;
                    var3_3 = Build.VERSION.SDK_INT;
                    var19_15 = 24;
                    if (var3_3 < var19_15) break block44;
                    var1_1 = new g(this);
                    this.o = var1_1;
                    var2_2 = this.e;
                    var2_2.addNmeaListener((OnNmeaMessageListener)var1_1);
                    break block43;
                }
                var1_1 = new f$g(this, null);
                this.n = var1_1;
                var1_1 = "android.location.LocationManager";
                var1_1 = Class.forName((String)var1_1);
                var2_2 = "addNmeaListener";
                var5_5 = new Class[var12_11];
                var6_6 = GpsStatus.NmeaListener.class;
                var7_7 = null;
                var5_5[0] = var6_6;
                var1_1 = var1_1.getMethod(var2_2, (Class<?>[])var5_5);
                var2_2 = this.e;
                var5_5 = new Object[var12_11];
                var6_6 = this.n;
                var5_5[0] = var6_6;
                var1_1.invoke(var2_2, var5_5);
            }
            this.u = var12_11;
lbl108:
            // 2 sources

            return;
            break;
        }
        catch (Exception v1) {
            ** continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        boolean bl2 = this.u;
        if (!bl2) {
            return;
        }
        Object object = this.e;
        if (object != null) {
            try {
                Object object2 = this.g;
                if (object2 != null) {
                    object.removeUpdates((LocationListener)object2);
                }
                if ((object = this.o) != null) {
                    object2 = this.e;
                    object2.removeNmeaListener((OnNmeaMessageListener)object);
                }
                if ((object = this.n) != null) {
                    Class<GpsStatus.NmeaListener> clazz;
                    object = "android.location.LocationManager";
                    object = Class.forName((String)object);
                    object2 = "removeNmeaListener";
                    int n10 = 1;
                    GpsStatus.NmeaListener nmeaListener = new Class[n10];
                    nmeaListener[0] = clazz = GpsStatus.NmeaListener.class;
                    object = ((Class)object).getMethod((String)object2, (Class<?>)nmeaListener);
                    object2 = this.e;
                    Object[] objectArray = new Object[n10];
                    nmeaListener = this.n;
                    objectArray[0] = nmeaListener;
                    ((Method)object).invoke(object2, objectArray);
                }
                if ((object = this.L) != null) {
                    object2 = this.e;
                    object2.unregisterGnssNavigationMessageCallback((GnssNavigationMessage.Callback)object);
                }
            }
            catch (Exception exception) {}
        }
        com.baidu.location.h.l.d = 0;
        com.baidu.location.h.l.x = 0;
        this.g = null;
        this.u = false;
        this.b(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        synchronized (this) {
            boolean bl2;
            Object object;
            this.d();
            Object object2 = this.e;
            if (object2 == null) {
                return;
            }
            try {
                object = this.l;
                if (object != null) {
                    object2.removeGpsStatusListener((GpsStatus.Listener)object);
                }
                if ((bl2 = this.k) && (object2 = this.j) != null) {
                    object = this.e;
                    object.unregisterGnssStatusCallback((GnssStatus.Callback)object2);
                }
                object2 = this.e;
                object = this.h;
                object2.removeUpdates((LocationListener)object);
            }
            catch (Exception exception) {}
            bl2 = false;
            object2 = null;
            try {
                object = this.F;
                if (object != null) {
                    object.removeCallbacksAndMessages(null);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.l = null;
            this.e = null;
            return;
        }
    }

    public String f() {
        Object object;
        boolean bl2 = this.k();
        if (bl2 && (object = this.f) != null) {
            object = com.baidu.location.f.f.a(object).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids=");
            Object[] objectArray = new Object[2];
            objectArray[0] = object;
            String string2 = this.f.getProvider();
            objectArray[1] = string2;
            return String.format("%s&idgps_tp=%s", objectArray);
        }
        return null;
    }

    public String g() {
        Object object = this.f;
        if (object != null) {
            double d10;
            Object object2;
            int n10;
            float f10;
            object = new StringBuilder();
            ((StringBuilder)object).append("{\"result\":{\"time\":\"");
            Object object3 = com.baidu.location.h.l.a();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append("\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":");
            ((StringBuilder)object).append("\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",");
            ((StringBuilder)object).append("\"s\":\"%f\",\"n\":\"%d\"");
            object = ((StringBuilder)object).toString();
            object3 = this.f;
            int n11 = object3.hasAccuracy();
            if (n11 != 0) {
                object3 = this.f;
                f10 = object3.getAccuracy();
            } else {
                n11 = 1092616192;
                f10 = 10.0f;
            }
            n11 = (int)f10;
            Object[] objectArray = this.f;
            double d11 = objectArray.getSpeed();
            double d12 = 3.6;
            float f11 = (float)(d11 *= d12);
            Object object4 = this.f;
            int n12 = object4.hasSpeed();
            if (n12 == 0) {
                n10 = -1082130432;
                f11 = -1.0f;
            }
            n12 = 2;
            float f12 = 2.8E-45f;
            Object object5 = new double[n12];
            e e10 = com.baidu.location.h.e.a();
            Object object6 = this.f;
            double d13 = object6.getLongitude();
            double d14 = this.f.getLatitude();
            Object object7 = e10.a(d13, d14);
            d13 = 0.0;
            int n13 = 1;
            if (object7 != 0) {
                double d15;
                d12 = this.f.getLongitude();
                object2 = this.f;
                d10 = object2.getLatitude();
                String string2 = "gps2gcj";
                object5 = Jni.coorEncrypt(d12, d10, string2);
                double d16 = (d10 = object5[0]) - d13;
                object7 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
                if (object7 <= 0 && (object7 = (Object)((d15 = (d10 = object5[n13]) - d13) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1))) <= 0) {
                    double d17;
                    object5[0] = d17 = this.f.getLongitude();
                    e10 = this.f;
                    object5[n13] = d17 = e10.getLatitude();
                }
                object7 = n13;
            } else {
                double d18;
                object5[0] = d10 = this.f.getLongitude();
                e10 = this.f;
                object5[n13] = d10 = e10.getLatitude();
                d10 = object5[0];
                double d19 = d10 - d13;
                object7 = d19 == 0.0 ? 0 : (d19 > 0.0 ? 1 : -1);
                if (object7 <= 0 && (object7 = (Object)((d18 = (d10 = object5[n13]) - d13) == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1))) <= 0) {
                    double d20;
                    object5[0] = d20 = this.f.getLongitude();
                    e10 = this.f;
                    object5[n13] = d20 = e10.getLatitude();
                }
                object7 = 0;
                e10 = null;
            }
            object6 = Locale.CHINA;
            int n14 = 6;
            Object[] objectArray2 = new Object[n14];
            object2 = object5[0];
            objectArray2[0] = object2;
            d10 = object5[n13];
            object5 = d10;
            objectArray2[n13] = object5;
            objectArray2[n12] = object3 = Integer.valueOf(n11);
            f12 = this.f.getBearing();
            object4 = Float.valueOf(f12);
            objectArray2[3] = object4;
            objectArray = Float.valueOf(f11);
            objectArray2[4] = objectArray;
            n11 = 5;
            f10 = 7.0E-45f;
            n10 = a;
            objectArray = n10;
            objectArray2[n11] = objectArray;
            object = String.format((Locale)object6, (String)object, objectArray2);
            if (object7 == 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(",\"in_cn\":\"0\"");
                object = ((StringBuilder)object3).toString();
            }
            if ((n11 = (int)(com.baidu.location.h.l.m ? 1 : 0)) == 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                object = Locale.CHINA;
                objectArray = new Object[n13];
                object4 = this.f;
                n12 = this.e((Location)object4);
                object4 = n12;
                objectArray[0] = object4;
                object4 = ",\"is_mock\":%d";
                object = String.format((Locale)object, (String)object4, objectArray);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
            }
            if ((n11 = (int)((object3 = this.f).hasAltitude() ? 1 : 0)) != 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                object = Locale.CHINA;
                objectArray = new Object[n13];
                double d21 = this.f.getAltitude();
                object4 = d21;
                objectArray[0] = object4;
                object4 = ",\"h\":%.2f}}";
                object = String.format((Locale)object, (String)object4, objectArray);
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                object = "}}";
            }
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
        } else {
            object = null;
        }
        return object;
    }

    public Location h() {
        Location location = this.f;
        if (location == null) {
            return null;
        }
        long l10 = System.currentTimeMillis();
        location = this.f;
        long l11 = location.getTime();
        long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 60000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return null;
        }
        return this.f;
    }

    public BDLocation i() {
        BDLocation bDLocation = this.Y;
        if (bDLocation == null) {
            return null;
        }
        long l10 = System.currentTimeMillis();
        long l11 = this.X;
        long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 3000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return null;
        }
        return this.Y;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean j() {
        block11: {
            double d10;
            double d11;
            double d12;
            Location location;
            int n10;
            long l10;
            long l11;
            double d13;
            boolean bl2;
            block10: {
                bl2 = true;
                d13 = 0.0;
                try {
                    l11 = System.currentTimeMillis();
                    l10 = this.I;
                    l11 -= l10;
                    n10 = a;
                    if (n10 != 0) break block10;
                }
                catch (Exception exception) {
                    double d14;
                    double d15;
                    double d16;
                    double d17;
                    double d18;
                    Location location2 = this.f;
                    if (location2 != null && (d18 = (d17 = (d16 = location2.getLatitude()) - d13) == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1)) != false && (d15 = (d14 = (d16 = (location2 = this.f).getLongitude()) - d13) == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1)) != false) {
                        return bl2;
                    }
                    return false;
                }
                try {
                    location = this.f;
                    location = location.getExtras();
                    String string2 = "satellites";
                    n10 = location.getInt(string2);
                }
                catch (Exception exception) {}
            }
            location = this.f;
            if (location == null || (d12 = (d11 = (d10 = location.getLatitude()) - d13) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1)) == false) break block11;
            location = this.f;
            d10 = location.getLongitude();
            d12 = d10 == d13 ? 0 : (d10 > d13 ? 1 : -1);
            if (d12 == false) break block11;
            d12 = 2;
            if (n10 <= d12) {
                boolean bl3;
                l11 = Math.abs(l11);
                l10 = 5000L;
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 >= 0 && !(bl3 = com.baidu.location.h.l.m)) break block11;
            }
            return bl2;
        }
        return false;
    }

    public boolean k() {
        Object object = this.j();
        if (object == 0) {
            return false;
        }
        long l10 = System.currentTimeMillis();
        long l11 = this.x;
        long l12 = (l10 -= l11) - (l11 = 10000L);
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return false;
        }
        long l13 = System.currentTimeMillis();
        boolean bl2 = this.t;
        if (bl2) {
            l10 = this.s;
            long l14 = (l13 -= l10) - (l10 = 3000L);
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object < 0) {
                return true;
            }
        }
        return this.w;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String m() {
        synchronized (this) {
            CharSequence charSequence;
            CharSequence charSequence2;
            block6: {
                long l10;
                long l11;
                charSequence2 = "-2";
                try {
                    l11 = System.currentTimeMillis();
                    l10 = this.S;
                    l11 -= l10;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    break block6;
                }
                {
                    l11 = Math.abs(l11);
                    l10 = 3000L;
                    long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                    if (l12 < 0) {
                        charSequence = this.R;
                        charSequence2 = charSequence == null ? "0" : charSequence;
                        break block6;
                    }
                    charSequence2 = "-1";
                }
            }
            charSequence = new StringBuilder();
            String string2 = "&gnsf=";
            charSequence.append(string2);
            charSequence.append((String)charSequence2);
            return charSequence.toString();
        }
    }

    public void n() {
        int n10;
        Object object;
        int n11 = com.baidu.location.h.l.m;
        if (n11 == 0 && (n11 = this.e((Location)(object = this.f))) == (n10 = 1) && (n11 = (int)(com.baidu.location.h.l.o ? 1 : 0)) != 0) {
            object = this.i();
            String string2 = this.g();
            BDLocation bDLocation = new BDLocation(string2);
            if (object == null) {
                object = com.baidu.location.b.q.a();
                ((q)object).b();
            }
            object = com.baidu.location.b.b.a();
            ((com.baidu.location.b.b)object).c(bDLocation);
        } else {
            object = com.baidu.location.b.b.a();
            String string3 = this.g();
            ((com.baidu.location.b.b)object).a(string3);
        }
    }
}

