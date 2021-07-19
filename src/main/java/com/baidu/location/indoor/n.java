/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Build$VERSION
 */
package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.location.indoor.mapversion.a;
import com.baidu.location.indoor.n$a;
import com.baidu.location.indoor.o;
import com.baidu.location.indoor.p;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class n {
    private int A;
    private long B;
    private int C;
    private int D;
    private double E;
    private double F;
    private double G;
    private double H;
    private double I;
    private double J;
    private double K;
    private int L;
    private float M;
    private int N;
    private int O;
    private double[] P;
    private boolean Q;
    private double R;
    private String S;
    public Timer a;
    public SensorEventListener b;
    private n$a c;
    private SensorManager d;
    private boolean e;
    private int f;
    private Sensor g;
    private Sensor h;
    private Sensor i;
    private final long j;
    private boolean k;
    private boolean l;
    private boolean m;
    private volatile int n;
    private int o;
    private float[] p;
    private float[] q;
    private double[] r;
    private int s;
    private double[] t;
    private int u;
    private int v;
    private int w;
    private double[] x;
    private int y;
    private double z;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private n(Context object, int n10) {
        int n11;
        double d10;
        int n12;
        double[] dArray;
        float[] fArray;
        long l10;
        this.j = l10 = (long)30;
        int n13 = 1;
        this.k = n13;
        this.l = false;
        this.m = false;
        this.n = n13;
        this.o = n13;
        int n14 = 3;
        float[] fArray2 = new float[n14];
        this.p = fArray2;
        float[] fArray3 = fArray = new float[n14];
        fArray[0] = 0.0f;
        fArray3[1] = 0.0f;
        fArray3[2] = 0.0f;
        this.q = fArray;
        double[] dArray2 = dArray = new double[n14];
        dArray[0] = 0.0;
        dArray2[1] = 0.0;
        dArray2[2] = 0.0;
        this.r = dArray;
        this.s = n12 = 31;
        double[] dArray3 = new double[n12];
        this.t = dArray3;
        this.u = 0;
        double[] dArray4 = new double[6];
        this.x = dArray4;
        this.y = 0;
        this.B = 0L;
        this.C = 0;
        this.D = 0;
        this.E = d10 = 0.0;
        this.F = d10;
        this.G = 100.0;
        this.H = d10 = 0.5;
        this.I = d10;
        this.J = 0.85;
        this.K = 0.42;
        this.L = -1;
        this.M = 0.0f;
        this.N = n12 = 20;
        this.O = 0;
        double[] dArray5 = new double[n12];
        this.P = dArray5;
        this.Q = false;
        this.R = -1.0;
        this.S = null;
        Object object2 = new o(this);
        this.b = object2;
        this.z = d10 = 1.6;
        this.A = n11 = 440;
        object2 = "sensor";
        try {
            Sensor sensor;
            Sensor sensor2;
            int n15;
            SensorManager sensorManager;
            Object object3 = object.getSystemService((String)object2);
            this.d = sensorManager = (SensorManager)object3;
            this.f = n15;
            this.g = sensor2 = sensorManager.getDefaultSensor(n13);
            SensorManager sensorManager2 = this.d;
            this.h = sensor = sensorManager2.getDefaultSensor(n14);
            boolean bl2 = com.baidu.location.indoor.mapversion.a.b();
            if (bl2) {
                Sensor sensor3;
                SensorManager sensorManager3 = this.d;
                n15 = 4;
                this.i = sensor3 = sensorManager3.getDefaultSensor(n15);
            }
            this.j();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public n(Context context, n$a n$a) {
        this(context, 1);
        this.c = n$a;
    }

    private double a(double d10, double d11, double d12) {
        double d13 = -180.0;
        double d14 = (d11 -= d10) - d13;
        Object object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
        double d15 = 360.0;
        if (object < 0) {
            d11 += d15;
        } else {
            double d16 = 180.0;
            double d17 = d11 - d16;
            object = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
            if (object > 0) {
                d11 -= d15;
            }
        }
        return d10 + (d12 *= d11);
    }

    public static /* synthetic */ double a(n n10, double d10, double d11, double d12) {
        return n10.a(d10, d11, d12);
    }

    private double a(double[] dArray) {
        double d10;
        int n10 = dArray.length;
        int n11 = 0;
        double d11 = 0.0;
        double d12 = d11;
        for (int i10 = 0; i10 < n10; ++i10) {
            d10 = dArray[i10];
            d12 += d10;
        }
        d10 = n10;
        d12 /= d10;
        while (n11 < n10) {
            d10 = dArray[n11] - d12;
            double d13 = dArray[n11] - d12;
            d11 += (d10 *= d13);
            ++n11;
        }
        double d14 = n10 + -1;
        return d11 / d14;
    }

    public static /* synthetic */ int a(n n10, int n11) {
        n10.n = n11;
        return n11;
    }

    private void a(double d10) {
        double[] dArray = this.x;
        int n10 = this.y;
        int n11 = n10 % 6;
        dArray[n11] = d10;
        this.y = ++n10;
        this.y = n10 %= 6;
    }

    private void a(int n10) {
        synchronized (this) {
            int n11 = this.o;
            n10 |= n11;
            this.o = n10;
            return;
        }
    }

    public static /* synthetic */ boolean a(n n10) {
        return n10.k;
    }

    public static /* synthetic */ boolean a(n n10, boolean bl2) {
        n10.Q = bl2;
        return bl2;
    }

    private float[] a(float f10, float f11, float f12) {
        float[] fArray = new float[3];
        float[] fArray2 = this.p;
        float f13 = fArray2[0];
        float f14 = 0.8f;
        f13 *= f14;
        float f15 = 0.19999999f;
        float f16 = f10 * f15;
        fArray2[0] = f13 += f16;
        int n10 = 1;
        f16 = fArray2[n10] * f14;
        float f17 = f11 * f15;
        fArray2[n10] = f16 += f17;
        int n11 = 2;
        f17 = fArray2[n11] * f14;
        fArray2[n11] = f17 += (f15 *= f12);
        f14 = fArray2[0];
        fArray[0] = f10 -= f14;
        f10 = fArray2[n10];
        fArray[n10] = f11 -= f10;
        f10 = fArray2[n11];
        fArray[n11] = f12 -= f10;
        return fArray;
    }

    public static /* synthetic */ float[] a(n n10, float f10, float f11, float f12) {
        return n10.a(f10, f11, f12);
    }

    public static /* synthetic */ float[] a(n n10, float[] fArray) {
        n10.q = fArray;
        return fArray;
    }

    public static /* synthetic */ int b(n n10) {
        int n11;
        n10.v = n11 = n10.v + 1;
        return n11;
    }

    public static /* synthetic */ int b(n n10, int n11) {
        n10.O = n11;
        return n11;
    }

    private boolean b(double d10) {
        int n10;
        int n11;
        for (int i10 = n10 = 1; i10 <= (n11 = 5); ++i10) {
            double[] dArray = this.x;
            int n12 = this.y;
            int n13 = (n12 + -1 - i10 + 6 + 6) % 6;
            double d11 = dArray[n13];
            double d12 = dArray[n12 = (n12 - n10 + 6) % 6];
            double d13 = (d11 -= d12) - d10;
            n11 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
            if (n11 <= 0) continue;
            return n10 != 0;
        }
        return false;
    }

    public static /* synthetic */ int c(n n10) {
        return n10.n;
    }

    public static /* synthetic */ double[] d(n n10) {
        return n10.P;
    }

    public static /* synthetic */ int e(n n10) {
        return n10.O;
    }

    public static /* synthetic */ int f(n n10) {
        int n11;
        int n12 = n10.O;
        n10.O = n11 = n12 + 1;
        return n12;
    }

    public static /* synthetic */ int g(n n10) {
        return n10.N;
    }

    public static /* synthetic */ int h(n n10) {
        int n11;
        n10.w = n11 = n10.w + 1;
        return n11;
    }

    private boolean i() {
        int n10;
        boolean bl2 = false;
        for (int i10 = 0; i10 < (n10 = this.N); ++i10) {
            double[] dArray = this.P;
            double d10 = dArray[i10];
            double d11 = 1.0E-7;
            double d12 = d10 - d11;
            n10 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
            if (n10 <= 0) continue;
            bl2 = true;
            break;
        }
        return bl2;
    }

    public static /* synthetic */ boolean i(n n10) {
        return n10.i();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        try {
            int n10;
            Object object = this.d;
            int n11 = -1;
            object = object.getSensorList(n11);
            HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
            int n12 = 1;
            Object object2 = n12;
            int n13 = 0;
            Object object3 = null;
            Integer n14 = 0;
            hashMap.put((Integer)object2, n14);
            int n15 = 10;
            object2 = n15;
            Integer n16 = n12;
            hashMap.put((Integer)object2, n16);
            n12 = 9;
            n16 = n12;
            n15 = 2;
            Integer n17 = n15;
            hashMap.put(n16, n17);
            n12 = 4;
            Integer n18 = n12;
            int n19 = 3;
            Integer n20 = n19;
            hashMap.put(n18, n20);
            object2 = n15;
            n16 = n12;
            hashMap.put((Integer)object2, n16);
            n12 = 11;
            n16 = n12;
            n15 = 5;
            object2 = n15;
            hashMap.put(n16, object2);
            n12 = 6;
            object2 = n12;
            n16 = n12;
            hashMap.put((Integer)object2, n16);
            n12 = Build.VERSION.SDK_INT;
            n15 = 18;
            if (n12 >= n15) {
                n12 = 14;
                n16 = n12;
                n15 = 7;
                object2 = n15;
                hashMap.put(n16, object2);
                n12 = 16;
                n16 = n12;
                n15 = 8;
                object2 = n15;
                hashMap.put(n16, object2);
            }
            n12 = hashMap.size();
            object2 = new char[n12];
            while (n13 < n12) {
                n10 = 48;
                object2[n13] = n10;
                ++n13;
            }
            object = object.iterator();
            while (true) {
                if ((n13 = (int)(object.hasNext() ? 1 : 0)) == 0) {
                    this.S = object = new String((char[])object2);
                    return;
                }
                object3 = object.next();
                n13 = (object3 = (Sensor)object3).getType();
                Integer n21 = n13;
                Object v10 = hashMap.get(n21);
                if (v10 == null) continue;
                object3 = n13;
                object3 = hashMap.get(object3);
                n13 = (Integer)(object3 = (Integer)object3);
                if (n13 >= n12) continue;
                n10 = 49;
                object2[n13] = n10;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static /* synthetic */ boolean j(n n10) {
        return n10.Q;
    }

    public static /* synthetic */ Sensor k(n n10) {
        return n10.h;
    }

    private void k() {
        this.k = false;
    }

    public static /* synthetic */ SensorManager l(n n10) {
        return n10.d;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void l() {
        block19: {
            var1_1 = this;
            var2_2 = this.v;
            var3_3 = 20;
            var4_4 = 2.8E-44f;
            if (var2_2 < var3_3) {
                return;
            }
            var2_2 = (int)this.e;
            if (var2_2 == 0) {
                return;
            }
            var5_5 = System.currentTimeMillis();
            var2_2 = 3;
            var7_6 = new float[var2_2];
            var8_7 /* !! */  = this.q;
            var9_8 = 0;
            System.arraycopy(var8_7 /* !! */ , 0, var7_6, 0, var2_2);
            var8_7 /* !! */  = (float[])new double[var2_2];
            var10_9 = this.r;
            System.arraycopy(var10_9, 0, var8_7 /* !! */ , 0, var2_2);
            var11_10 = var7_6[0];
            var12_11 = var7_6[0];
            var11_10 *= var12_11;
            var13_12 = 1;
            var12_11 = 1.4E-45f;
            var14_13 = var7_6[var13_12];
            var15_14 = var7_6[var13_12];
            var11_10 += (var14_13 *= var15_14);
            var16_15 = 2;
            var14_13 = 2.8E-45f;
            var15_14 = var7_6[var16_15];
            var4_4 = var7_6[var16_15];
            var17_16 = Math.sqrt(var11_10 += (var15_14 *= var4_4));
            var19_17 /* !! */  = this.t;
            var20_18 = this.u;
            var19_17 /* !! */ [var20_18] = var17_16;
            this.a(var17_16);
            this.D = var16_15 = this.D + var13_12;
            var21_19 = this.F;
            var16_15 = (int)(var17_16 == var21_19 ? 0 : (var17_16 > var21_19 ? 1 : -1));
            if (var16_15 > 0) {
                this.F = var17_16;
            } else {
                var21_19 = this.G;
                cfr_temp_0 = var17_16 - var21_19;
                var16_15 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1));
                if (var16_15 < 0) {
                    this.G = var17_16;
                }
            }
            var1_1.u = var16_15 = var1_1.u + var13_12;
            var20_18 = var1_1.s;
            if (var16_15 != var20_18) break block19;
            var1_1.u = 0;
            var19_17 /* !! */  = var1_1.t;
            var21_19 = var1_1.a(var19_17 /* !! */ );
            var23_20 = var1_1.n;
            if (var23_20 != 0) ** GOTO lbl-1000
            var24_21 = 0x3FD3333333333333L;
            var26_22 = 0.3;
            cfr_temp_1 = var21_19 - var26_22;
            var16_15 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 < 0.0 ? -1 : 1));
            if (var16_15 < 0) {
                var1_1.a(0);
                var1_1.n = 0;
            } else lbl-1000:
            // 2 sources

            {
                var1_1.a(var13_12);
                var1_1.n = var13_12;
            }
        }
        var28_23 = var1_1.B;
        var23_20 = var1_1.A;
        var24_21 = var23_20;
        cfr_temp_2 = (var28_23 = var5_5 - var28_23) - var24_21;
        var16_15 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
        if (var16_15 > 0 && (var16_15 = (int)var1_1.b(var21_19 = var1_1.z)) != 0) {
            var1_1.C = var16_15 = var1_1.C + var13_12;
            var1_1.B = var5_5;
            var21_19 = var8_7 /* !! */ [0];
            var26_22 = var8_7 /* !! */ [0];
            var23_20 = (int)var1_1.k;
            var30_24 = 0.0;
            if (var23_20 != 0 && (var23_20 = (int)var1_1.l) != 0 && (var23_20 = (int)com.baidu.location.indoor.mapversion.a.b()) != 0) {
                var19_17 /* !! */  = com.baidu.location.indoor.mapversion.a.c();
                var14_13 = (float)var19_17 /* !! */ [0];
                var21_19 = var14_13;
                var23_20 = (int)Double.isNaN(var21_19);
                if (var23_20 != 0 || (var23_20 = (int)(var21_19 == var30_24 ? 0 : (var21_19 < var30_24 ? -1 : 1))) < 0) {
                    var21_19 = var8_7 /* !! */ [0];
                }
                var9_8 = var13_12;
            }
            if ((var32_25 = var1_1.D) < (var23_20 = 40) && var32_25 > 0) {
                var30_24 = var1_1.F;
                var33_26 = var21_19;
                var35_27 = var1_1.G;
                var30_24 -= var35_27;
                var35_27 = Math.sqrt(Math.sqrt(var30_24));
                var37_28 = var1_1.K;
                var1_1.I = var35_27 *= var37_28;
                var37_28 = var1_1.J;
                cfr_temp_3 = var35_27 - var37_28;
                var39_29 /* !! */  = (double)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 > 0.0 ? 1 : -1));
                if (var39_29 /* !! */  > 0) lbl-1000:
                // 2 sources

                {
                    while (true) {
                        var1_1.I = var37_28;
                        break;
                    }
                } else {
                    var37_28 = var1_1.H;
                    cfr_temp_4 = var35_27 - var37_28;
                    var13_12 = (int)(cfr_temp_4 == 0.0 ? 0 : (cfr_temp_4 < 0.0 ? -1 : 1));
                    if (var13_12 < 0) {
                        ** continue;
                    }
                }
            } else {
                var33_26 = var21_19;
                var1_1.I = var35_27 = var1_1.H;
            }
            var12_11 = var1_1.M;
            var35_27 = var12_11;
            var21_19 = var33_26 + var35_27;
            var30_24 = 360.0;
            var13_12 = (int)(var21_19 == var30_24 ? 0 : (var21_19 > var30_24 ? 1 : -1));
            if (var13_12 > 0) {
                var21_19 -= var30_24;
            }
            if ((var13_12 = (int)((cfr_temp_5 = var21_19 - (var40_30 = 0.0)) == 0.0 ? 0 : (cfr_temp_5 < 0.0 ? -1 : 1))) < 0) {
                var21_19 += var30_24;
            }
            var37_28 = var21_19;
            var1_1.D = var32_25 = 1;
            var1_1.F = var17_16;
            var1_1.G = var17_16;
            var1_1.R = var21_19;
            var2_2 = (int)var1_1.Q;
            if (var2_2 != 0 || var9_8 != 0) {
                var7_6 = var1_1.c;
                var42_31 = var1_1.I;
                var35_27 = var26_22;
                var7_6.a(var42_31, var26_22, var37_28, var5_5);
            }
        }
    }

    public static /* synthetic */ double[] m(n n10) {
        return n10.r;
    }

    public static /* synthetic */ void n(n n10) {
        n10.l();
    }

    public void a() {
        boolean bl2 = this.e;
        if (!bl2) {
            int n10;
            Object object;
            Object object2;
            Object object3 = this.g;
            if (object3 != null) {
                object2 = this.d;
                object = this.b;
                n10 = this.f;
                try {
                    object2.registerListener((SensorEventListener)object, object3, n10);
                }
                catch (Exception exception) {
                    this.k = false;
                }
                object2 = "UpdateData";
                object3 = new Timer((String)object2, false);
                this.a = object3;
                p p10 = new p(this);
                object = this.a;
                long l10 = 500L;
                long l11 = 30;
                ((Timer)object).schedule((TimerTask)p10, l10, l11);
                this.e = bl2 = true;
            }
            if ((object3 = this.h) != null) {
                object2 = this.d;
                object = this.b;
                n10 = this.f;
                try {
                    object2.registerListener((SensorEventListener)object, object3, n10);
                }
                catch (Exception exception) {
                    this.k = false;
                }
            }
        }
    }

    public void a(boolean bl2) {
        this.l = bl2;
        if (bl2 && !(bl2 = this.m)) {
            this.k();
            this.m = bl2 = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        boolean bl2 = this.e;
        boolean bl3 = true;
        if (bl2 == bl3) {
            SensorManager sensorManager;
            bl2 = false;
            this.e = false;
            try {
                sensorManager = this.d;
                SensorEventListener sensorEventListener = this.b;
                sensorManager.unregisterListener(sensorEventListener);
            }
            catch (Exception exception) {}
            this.a.cancel();
            this.a.purge();
            bl3 = false;
            sensorManager = null;
            this.a = null;
            this.m = false;
            bl2 = com.baidu.location.indoor.mapversion.a.b();
            if (bl2) {
                com.baidu.location.indoor.mapversion.a.a();
            }
        }
    }

    public int c() {
        synchronized (this) {
            int n10;
            block5: {
                n10 = this.v;
                int n11 = 20;
                if (n10 >= n11) break block5;
                return 1;
            }
            n10 = this.o;
            return n10;
        }
    }

    public int d() {
        synchronized (this) {
            int n10;
            block5: {
                n10 = this.v;
                int n11 = 20;
                if (n10 >= n11) break block5;
                return -1;
            }
            n10 = this.C;
            return n10;
        }
    }

    public double e() {
        return this.R;
    }

    public void f() {
        synchronized (this) {
            Object var1_1 = null;
            this.o = 0;
            return;
        }
    }

    public boolean g() {
        return this.l;
    }

    public String h() {
        return this.S;
    }
}

