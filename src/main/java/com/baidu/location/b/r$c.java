/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 */
package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import com.baidu.location.b.r;
import com.baidu.location.b.r$b;
import java.util.ArrayList;

public class r$c {
    public final /* synthetic */ r a;
    private boolean b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private ArrayList g;
    private int h;
    private double i;
    private double j;
    private double k;
    private int l;
    private r$b m;

    public r$c(r r10, int n10, int n11) {
        r$b r$b;
        double d10;
        this.a = r10;
        this.a(n10, n11);
        this.h = 0;
        this.i = d10 = 0.0;
        this.j = d10;
        this.k = d10;
        this.l = 0;
        this.m = r$b = new r$b(r10);
    }

    private r$b a(int n10, double d10) {
        double d11;
        Object object = r.c();
        object = this.a((double[])object);
        double d12 = -1.0E9;
        double d13 = d10 - d12;
        Object object2 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object2 < 0 || (object2 = (d11 = (d12 = 1.0E9) - d10) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) < 0) {
            d10 = 0.0;
        }
        object2 = object.a;
        n10 *= 604800;
        int n11 = (int)d10;
        object.a = (int)(object2 += (n10 += n11));
        d12 = n11;
        object.b = d10 -= d12;
        return object;
    }

    private r$b a(double[] dArray) {
        int[] nArray;
        int n10 = 12;
        int[] nArray2 = nArray = new int[n10];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 32;
        nArray2[2] = 60;
        nArray3[3] = 91;
        nArray2[4] = 121;
        nArray3[5] = 152;
        nArray2[6] = 182;
        nArray3[7] = 213;
        nArray2[8] = 244;
        nArray3[9] = 274;
        nArray2[10] = 305;
        nArray3[11] = 335;
        r r10 = this.a;
        r$b r$b = new r$b(r10);
        int n11 = 0;
        r10 = null;
        double d10 = dArray[0];
        int n12 = (int)d10;
        int n13 = 1;
        double d11 = dArray[n13];
        int n14 = (int)d11;
        int n15 = 2;
        double d12 = dArray[n15];
        int n16 = (int)d12;
        int n17 = 1970;
        if (n12 >= n17 && (n17 = 2099) >= n12 && n14 >= n13 && n10 >= n14) {
            n10 = (n12 + -1970) * 365;
            n17 = n12 + -1969;
            int n18 = 4;
            n10 += (n17 /= n18);
            n17 = n14 + -1;
            int n19 = nArray[n17];
            n10 = n10 + n19 + n16 - n15;
            n19 = 3;
            if ((n12 %= n18) == 0 && n14 >= n19) {
                n11 = n13;
            }
            n10 += n11;
            n11 = 5;
            d10 = Math.floor(dArray[n11]);
            n12 = (int)d10;
            n13 = 86400;
            n10 *= n13;
            n19 = (int)dArray[n19] * 3600;
            n10 += n19;
            double d13 = dArray[n18];
            n19 = (int)d13 * 60;
            r$b.a = n10 = n10 + n19 + n12;
            double d14 = dArray[n11];
            double d15 = n12;
            r$b.b = d14 -= d15;
        }
        return r$b;
    }

    private String a(GnssNavigationMessage object) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n10 : object.getData()) {
            Object[] objectArray = new Object[1];
            String string2 = Integer.toBinaryString(n10 &= 0xFF);
            objectArray[0] = string2;
            string2 = String.format("%8s", objectArray);
            char c10 = ' ';
            char c11 = '0';
            string2 = string2.replace(c10, c11);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String a(r$c r$c) {
        return r$c.b();
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        var1_1 = this.g;
        var2_2 = var1_1.size();
        var3_3 = true;
        if (var2_2 != 0) {
            var1_1 = null;
            for (var2_2 = 0; var2_2 < (var5_5 = (var4_4 = this.g).size()); ++var2_2) {
                var4_4 = (String)this.g.get(var2_2);
                var5_5 = (int)var4_4.contains(var6_6 = "None");
                if (var5_5 == 0) {
                    continue;
                }
                ** break block4
            }
            var2_2 = (int)var3_3;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = 0;
            var1_1 = null;
        }
        this.c = var2_2 != 0 ? var3_3 : false;
    }

    private void a(int n10, int n11) {
        ArrayList arrayList;
        int n12 = this.f;
        int n13 = 257;
        int n14 = 5;
        if (n12 != n13 && n12 != (n13 = 769)) {
            n13 = 1537;
            if (n12 != n13) {
                n13 = 1281;
                if (n12 != n13) {
                    n13 = 1282;
                    if (n12 != n13) {
                        n14 = 0;
                    }
                } else {
                    n14 = 3;
                }
            } else {
                n14 = 6;
            }
        }
        if ((arrayList = this.g) != null) {
            arrayList.clear();
        } else {
            this.g = arrayList = new ArrayList();
        }
        arrayList = null;
        for (n12 = 0; n12 < n14; ++n12) {
            ArrayList arrayList2 = this.g;
            String string2 = "None";
            arrayList2.add(string2);
        }
        this.e = n10;
        this.f = n11;
        this.b = false;
        this.c = false;
        this.d = 0L;
    }

    private void a(GnssNavigationMessage object, long l10) {
        Object object2;
        ArrayList arrayList;
        int n10 = object.getType();
        int n11 = object.getSvid();
        int n12 = object.getSubmessageId();
        Object object3 = object.getData();
        long l11 = this.d;
        long l12 = 1200L;
        long l13 = (l11 = l10 - l11) - l12;
        Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 > 0 || (object4 = (Object)this.b) != false || (object4 = (Object)(arrayList = this.g).size()) == false || n10 != (object4 = (Object)this.f) || n11 != (object4 = (Object)this.e)) {
            this.a(n11, n10);
        }
        if ((n10 = ((ArrayList)(object2 = this.g)).size()) == 0) {
            return;
        }
        n10 = this.f;
        n11 = 1537;
        object4 = 0;
        arrayList = null;
        int n13 = 1;
        if (n10 == n11) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = n13;
        }
        n12 -= n10;
        object2 = this.g;
        n10 = ((ArrayList)object2).size();
        if (n12 >= n10) {
            return;
        }
        object2 = new StringBuilder();
        for (byte by2 : object3) {
            if (n13 != 0) {
                n13 = 0;
            } else {
                char c10 = ',';
                ((StringBuilder)object2).append(c10);
            }
            ((StringBuilder)object2).append(by2);
        }
        object2 = ((StringBuilder)object2).toString();
        object3 = this.g;
        ((ArrayList)object3).set(n12, object2);
        n10 = this.f;
        if (n10 == n11) {
            object = this.a((GnssNavigationMessage)object);
            this.a((String)object);
        }
        this.a();
        this.d = l10;
    }

    public static /* synthetic */ void a(r$c r$c, GnssNavigationMessage gnssNavigationMessage, long l10) {
        r$c.a(gnssNavigationMessage, l10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(String string2) {
        StringBuilder stringBuilder;
        int n10 = 0;
        String string3 = null;
        int n11 = string2.charAt(0);
        int n12 = string2.charAt(120);
        int n13 = 122;
        int n14 = 48;
        int n15 = 49;
        int n16 = 2;
        if (n11 == n15 && n12 == n14) {
            stringBuilder = new StringBuilder();
            String string4 = string2.substring(n16, 18);
            stringBuilder.append(string4);
            n12 = 234;
        } else {
            if (n11 != n14) return;
            if (n12 != n15) return;
            stringBuilder = new StringBuilder();
            String string5 = string2.substring(n16, 114);
            stringBuilder.append(string5);
            n12 = 138;
        }
        string2 = string2.substring(n13, n12);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        n11 = 6;
        string3 = string2.substring(0, n11);
        n10 = Integer.parseInt(string3, n16);
        if (n10 == 0) {
            this.b(string2);
            return;
        }
        n11 = 1;
        if (n10 == n11) {
            this.c(string2);
            return;
        }
        n11 = 4;
        if (n10 != n11) return;
        this.d(string2);
    }

    public static /* synthetic */ int b(r$c r$c) {
        return r$c.f;
    }

    private String b() {
        Object object;
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = this.c;
        if (n11 == 0) {
            return stringBuilder.toString();
        }
        n11 = this.f;
        int n12 = 1537;
        if (n11 == n12) {
            this.c();
        }
        n11 = this.m.a;
        stringBuilder.append(n11);
        stringBuilder.append('|');
        n11 = 0;
        n12 = 1;
        int n13 = n12;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.g)).size()); ++i10) {
            if (n13 != 0) {
                n13 = 0;
            } else {
                n10 = 44;
                stringBuilder.append((char)n10);
            }
            object = (String)this.g.get(i10);
            stringBuilder.append((String)object);
        }
        this.b = n12;
        return stringBuilder.toString();
    }

    private void b(String string2) {
        double d10;
        int n10;
        int n11 = 108;
        String string3 = string2.substring(96, n11);
        int n12 = 2;
        this.h = n10 = Integer.parseInt(string3, n12);
        this.i = d10 = (double)Long.parseLong(string2.substring(n11, 128), n12);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        r$b r$b;
        double d10;
        int n10;
        block4: {
            block3: {
                double d11;
                double d12;
                block2: {
                    n10 = this.h;
                    d10 = this.i;
                    r$b = this.a(n10, d10);
                    int n11 = this.h;
                    d12 = this.j;
                    r$b r$b2 = this.a(n11, d12);
                    int n12 = r$b2.a;
                    int n13 = r$b.a;
                    d12 = n12 -= n13;
                    double d13 = r$b2.b;
                    d12 += d13;
                    d11 = r$b.b;
                    double d14 = (d12 -= d11) - (d11 = 302400.0);
                    n10 = (int)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
                    if (n10 <= 0) break block2;
                    n10 = this.h + -1;
                    break block3;
                }
                d11 = -302400.0;
                double d15 = d12 - d11;
                n10 = (int)(d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1));
                if (n10 >= 0) break block4;
                n10 = this.h + 1;
            }
            this.h = n10;
        }
        n10 = this.h;
        d10 = this.k;
        this.m = r$b = this.a(n10, d10);
        this.l = n10 = this.h + 1024;
    }

    private void c(String string2) {
        double d10;
        this.j = d10 = (double)Long.parseLong(string2.substring(16, 30), 2) * 60.0;
    }

    private void d(String string2) {
        double d10;
        this.k = d10 = (double)(Long.parseLong(string2.substring(54, 68), 2) * (long)60);
    }
}

