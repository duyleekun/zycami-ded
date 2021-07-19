/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.b;
import com.baidu.location.b.m;
import com.baidu.location.b.s;
import com.baidu.location.f.f;
import com.baidu.location.f.h;
import com.baidu.location.f.i;
import com.baidu.location.h.l;
import com.baidu.location.indoor.d;
import com.baidu.location.indoor.d$b;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$a;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.g$f;
import com.baidu.location.indoor.k;
import com.baidu.location.indoor.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class g$i
extends com.baidu.location.h.f {
    public final /* synthetic */ g a;
    private boolean b = false;
    private boolean c = false;
    private String d = null;
    private String e = null;
    private long f;
    private g$a q;
    private long r;
    private long s;

    public g$i(g hashMap) {
        long l10;
        this.a = hashMap;
        this.f = l10 = 0L;
        this.q = null;
        this.r = l10;
        this.s = l10;
        this.k = hashMap = new HashMap();
    }

    public void a() {
        int n10;
        int n11;
        double d10;
        long l10;
        int n12 = this.b;
        int n13 = 1;
        if (n12 != 0) {
            this.c = n13;
            return;
        }
        Object object = this.a;
        n12 = com.baidu.location.indoor.g.n((g)object);
        if (n12 == n13 && (n12 = (int)(com.baidu.location.indoor.g.o((g)(object = this.a)) ? 1 : 0)) == 0) {
            l10 = System.currentTimeMillis();
            long l11 = this.f;
            l10 -= l11;
            l11 = 30000L;
            d10 = 1.4822E-319;
            n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n12 < 0) {
                l10 = System.currentTimeMillis();
                object = com.baidu.location.indoor.g.a(this.a);
                long l12 = g$e.a((g$e)object);
                long l13 = (l10 -= l12) - l11;
                n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n12 > 0) {
                    return;
                }
            }
        }
        int n14 = 1024;
        object = new StringBuffer(n14);
        Object object2 = com.baidu.location.f.b.a().f().i();
        Object object3 = com.baidu.location.f.f.a().f();
        Object object4 = com.baidu.location.f.f.a().m();
        ((StringBuffer)object).append((String)object4);
        object4 = this.a;
        double d11 = 0.5;
        com.baidu.location.indoor.g.a((g)object4, d11);
        object4 = com.baidu.location.f.i.a().q();
        Object object5 = com.baidu.location.indoor.g.a(this.a, (h)object4);
        if (object5 == null) {
            int n15 = com.baidu.location.indoor.g.x(this.a);
            object5 = ((h)object4).a(n15, n13 != 0, false);
        }
        if (object5 != null && (n11 = ((String)object5).length()) >= (n10 = 10)) {
            long l14;
            double d12;
            object4 = this.e;
            if (object4 != null && (n11 = (int)(((String)object4).equals(object5) ? 1 : 0)) != 0) {
                return;
            }
            this.e = object5;
            this.b = n13;
            ((StringBuffer)object).append((String)object2);
            if (object3 != null) {
                ((StringBuffer)object).append((String)object3);
            }
            ((StringBuffer)object).append("&coor=gcj02");
            ((StringBuffer)object).append("&lt=1");
            ((StringBuffer)object).append((String)object5);
            object2 = com.baidu.location.indoor.g.f(this.a);
            int n16 = 2;
            if (object2 != null && (n14 = com.baidu.location.indoor.g.y((g)(object2 = this.a))) <= n16 && (object2 = com.baidu.location.indoor.g.f(this.a).h()) != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("&idsl=");
                object4 = com.baidu.location.indoor.g.f(this.a).h();
                ((StringBuilder)object2).append((String)object4);
                object2 = ((StringBuilder)object2).toString();
                ((StringBuffer)object).append((String)object2);
            }
            n14 = com.baidu.location.indoor.g.e(this.a).size();
            object4 = com.baidu.location.indoor.g.b(this.a, n14);
            ((StringBuffer)object).append((String)object4);
            com.baidu.location.indoor.g.c(this.a, n14);
            com.baidu.location.indoor.g.z(this.a);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("&drsi=");
            n11 = com.baidu.location.indoor.g.y(this.a);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            ((StringBuffer)object).append((String)object2);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("&drc=");
            object4 = this.a;
            n11 = com.baidu.location.indoor.g.A((g)object4);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            ((StringBuffer)object).append((String)object2);
            object2 = this.a;
            d10 = com.baidu.location.indoor.g.B((g)object2);
            double d13 = 0.0;
            n14 = (int)(d10 == d13 ? 0 : (d10 > d13 ? 1 : -1));
            if (n14 != 0 && (n14 = (int)((d12 = (d10 = com.baidu.location.indoor.g.C((g)(object2 = this.a))) - d13) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("&lst_idl=");
                object4 = Locale.CHINA;
                object3 = new Object[n16];
                object3[0] = object5 = Double.valueOf(com.baidu.location.indoor.g.B(this.a));
                d13 = com.baidu.location.indoor.g.C(this.a);
                object3[n13] = object5 = Double.valueOf(d13);
                object5 = "%.5f:%.5f";
                object3 = String.format((Locale)object4, (String)object5, object3);
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                ((StringBuffer)object).append((String)object2);
            }
            com.baidu.location.indoor.g.d(this.a, 0);
            ((StringBuffer)object).append("&idpfv=1");
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("&iflxy=");
            object3 = com.baidu.location.indoor.g.b(this.a).toString();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((StringBuffer)object).append((String)object2);
            g$f.a(com.baidu.location.indoor.g.b(this.a)).clear();
            object2 = com.baidu.location.indoor.g.f(this.a);
            if (object2 != null && (n14 = (int)(((n)(object2 = com.baidu.location.indoor.g.f(this.a))).g() ? 1 : 0)) != 0) {
                object2 = "&pdr2=1";
                ((StringBuffer)object).append((String)object2);
            }
            if ((object2 = com.baidu.location.indoor.g.t(this.a)) != null && (object2 = com.baidu.location.indoor.g.t(this.a).e()) != null && (n14 = (int)(((d)(object2 = com.baidu.location.indoor.g.t(this.a))).g() ? 1 : 0)) != 0) {
                ((StringBuffer)object).append("&bleand=");
                object2 = com.baidu.location.indoor.g.t(this.a).e();
                ((StringBuffer)object).append((String)object2);
                ((StringBuffer)object).append("&bleand_et=");
                object2 = com.baidu.location.indoor.g.t(this.a);
                l10 = ((d)object2).f();
                ((StringBuffer)object).append(l10);
            }
            com.baidu.location.indoor.g.D(this.a);
            object2 = com.baidu.location.indoor.g.E(this.a);
            if (object2 != null) {
                object2 = com.baidu.location.indoor.g.E(this.a);
                ((StringBuffer)object).append((String)object2);
                object2 = this.a;
                n16 = 0;
                object3 = null;
                com.baidu.location.indoor.g.a((g)object2, null);
            }
            if ((object2 = com.baidu.location.b.b.a().d()) != null) {
                ((StringBuffer)object).append((String)object2);
            }
            object2 = com.baidu.location.h.b.a();
            String string2 = ((com.baidu.location.h.b)object2).a(n13 != 0);
            ((StringBuffer)object).append(string2);
            this.d = object = ((StringBuffer)object).toString();
            object = aa.a().b();
            if (object != null) {
                string2 = com.baidu.location.h.l.f;
                this.a((ExecutorService)object, string2);
            } else {
                object = com.baidu.location.h.l.f;
                this.e((String)object);
            }
            this.f = l14 = System.currentTimeMillis();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(boolean var1_1) {
        block61: {
            block62: {
                block63: {
                    block60: {
                        var2_2 = "enc";
                        if (var1_1 == 0 || (var3_4 = this.j) == null) break block62;
                        var4_5 = var3_4.contains((CharSequence)var2_2);
                        if (!var4_5) ** GOTO lbl28
                        {
                            catch (Exception v0) {
                                ** continue;
                            }
                        }
                        var5_6 = com.baidu.location.b.m.a();
                        var4_5 = var5_6.b();
                        if (!var4_5) ** GOTO lbl28
                        var5_6 = new JSONObject((String)var3_4);
                        var6_7 = var5_6.has((String)var2_2);
                        if (var6_7 == 0) ** GOTO lbl28
                        var2_2 = var5_6.getString((String)var2_2);
                        var5_6 = com.baidu.location.b.m.a();
                        try {
                            var3_4 = var5_6.b((String)var2_2);
                            ** GOTO lbl28
                        }
                        catch (Exception var2_3) {
                            var2_3.printStackTrace();
lbl28:
                            // 5 sources

                            var2_2 = this.a;
                        }
                        var7_8 = com.baidu.location.indoor.g.c((g)var2_2);
                        if (var7_8) break block60;
                        this.b = false;
                        return;
                    }
                    var2_2 = new BDLocation((String)var3_4);
                    var1_1 = var2_2.getLocType();
                    var4_5 = 161 != 0;
                    if (var1_1 != var4_5) ** GOTO lbl51
                    var3_4 = var2_2.getBuildingID();
                    if (var3_4 == null) ** GOTO lbl51
                    var3_4 = this.a;
                    var5_6 = new BDLocation((BDLocation)var2_2);
                    com.baidu.location.indoor.g.b((g)var3_4, (BDLocation)var5_6);
lbl51:
                    // 3 sources

                    if ((var3_4 = var2_2.getIndoorLocationSurpportBuidlingName()) == null) ** GOTO lbl68
                    var5_6 = this.a;
                    var5_6 = com.baidu.location.indoor.g.s((g)var5_6);
                    var4_5 = var5_6.a((String)var3_4);
                    if (var4_5) ** GOTO lbl68
                    var5_6 = this.a;
                    var5_6 = com.baidu.location.indoor.g.s((g)var5_6);
                    var6_7 = 0;
                    var8_10 = null;
                    var5_6.a((String)var3_4, null);
lbl68:
                    // 3 sources

                    var3_4 = this.a;
                    var3_4 = com.baidu.location.indoor.g.t((g)var3_4);
                    if (var3_4 == null) ** GOTO lbl81
                    var3_4 = this.a;
                    var3_4 = com.baidu.location.indoor.g.t((g)var3_4);
                    var5_6 = new k(this);
                    var3_4.a((d$b)var5_6);
lbl81:
                    // 2 sources

                    var3_4 = com.baidu.location.b.s.a();
                    var4_5 = true;
                    var3_4.b(var4_5);
                    var3_4 = var2_2.getBuildingName();
                    if (var3_4 == null) ** GOTO lbl94
                    var3_4 = this.a;
                    var8_10 = var2_2.getBuildingName();
                    com.baidu.location.indoor.g.b((g)var3_4, var8_10);
lbl94:
                    // 2 sources

                    if ((var3_4 = var2_2.getFloor()) == null) ** GOTO lbl160
                    var3_4 = this.a;
                    var9_11 = System.currentTimeMillis();
                    com.baidu.location.indoor.g.b((g)var3_4, var9_11);
                    var9_11 = System.currentTimeMillis();
                    this.s = var9_11;
                    var11_12 = this.r;
                    var1_1 = (int)(var9_11 -= var11_12);
                    var6_7 = 10000;
                    if (var1_1 <= var6_7) break block63;
                    var3_4 = this.a;
                    com.baidu.location.indoor.g.a((g)var3_4, 0);
                    ** GOTO lbl129
                }
                var6_7 = 3000;
                if (var1_1 >= var6_7) ** GOTO lbl125
                var3_4 = this.a;
                var6_7 = 2;
                com.baidu.location.indoor.g.a((g)var3_4, var6_7);
                ** GOTO lbl129
lbl125:
                // 1 sources

                var3_4 = this.a;
                com.baidu.location.indoor.g.a((g)var3_4, (int)var4_5);
lbl129:
                // 3 sources

                var3_4 = var2_2.getFloor();
                var8_10 = "-a";
                var1_1 = (int)var3_4.contains(var8_10);
                if (var1_1 == 0) ** GOTO lbl148
                var3_4 = this.a;
                com.baidu.location.indoor.g.d((g)var3_4, var4_5);
                var3_4 = var2_2.getFloor();
                var5_6 = "-";
                var3_4 = var3_4.split((String)var5_6);
                var3_4 = var3_4[0];
                var2_2.setFloor((String)var3_4);
                ** GOTO lbl152
lbl148:
                // 1 sources

                var3_4 = this.a;
                com.baidu.location.indoor.g.d((g)var3_4, false);
lbl152:
                // 2 sources

                var3_4 = this.a;
                var3_4 = com.baidu.location.indoor.g.u((g)var3_4);
                var5_6 = var2_2.getFloor();
                var3_4.add(var5_6);
lbl160:
                // 2 sources

                var3_4 = this.a;
                var3_4 = var3_4.a;
                var4_5 = 21 != 0;
                var3_4 = var3_4.obtainMessage((int)var4_5);
                var3_4.obj = var2_2;
                var3_4.sendToTarget();
                break block61;
            }
            com.baidu.location.indoor.g.v(this.a);
            com.baidu.location.indoor.g.a(this.a, 0);
            this.b = false;
            var3_4 = this.a;
            var1_1 = com.baidu.location.indoor.g.w((g)var3_4);
            var7_9 = 40;
            if (var1_1 <= var7_9) ** GOTO lbl188
            var3_4 = this.a;
            var3_4.d();
        }
lbl183:
        // 2 sources

        while (true) {
            var3_4 = this.k;
            if (var3_4 != null) {
                var3_4.clear();
            }
            this.b = false;
lbl188:
            // 2 sources

            return;
        }
    }

    public void b() {
        long l10;
        String string2;
        boolean bl2;
        Object object = com.baidu.location.h.l.e();
        this.h = object;
        object = com.baidu.location.indoor.g.h(this.a);
        if (object == null || (object = com.baidu.location.indoor.g.r(this.a)) == null || !(bl2 = ((String)(object = com.baidu.location.indoor.g.h(this.a))).equals(string2 = com.baidu.location.indoor.g.r(this.a).a()))) {
            object = new StringBuilder();
            ((StringBuilder)object).append("&nd_idf=1&indoor_polygon=1");
            string2 = this.d;
            ((StringBuilder)object).append(string2);
            this.d = object = ((StringBuilder)object).toString();
        }
        this.i = 1;
        object = com.baidu.location.b.m.a();
        bl2 = ((m)object).b();
        if (bl2) {
            object = new StringBuilder();
            string2 = this.d;
            ((StringBuilder)object).append(string2);
            string2 = "&enc=2";
            ((StringBuilder)object).append(string2);
            this.d = object = ((StringBuilder)object).toString();
        }
        object = Jni.encodeTp4(this.d);
        this.d = null;
        this.k.put("bloc", object);
        this.r = l10 = System.currentTimeMillis();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        synchronized (this) {
            boolean bl2 = this.b;
            if (bl2) {
                return;
            }
            bl2 = this.c;
            if (bl2) {
                bl2 = false;
                Object var2_2 = null;
                this.c = false;
                this.a();
            }
            return;
        }
    }
}

