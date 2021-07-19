/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.ad;
import com.baidu.location.b.b;
import com.baidu.location.b.c;
import com.baidu.location.b.l;
import com.baidu.location.b.l$a;
import com.baidu.location.b.l$b;
import com.baidu.location.b.o$a;
import com.baidu.location.b.o$b;
import com.baidu.location.b.p;
import com.baidu.location.b.q;
import com.baidu.location.b.s;
import com.baidu.location.e.h;
import com.baidu.location.e.h$a;
import com.baidu.location.e.h$b;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.e;
import com.baidu.location.f.i;
import com.baidu.location.indoor.g;
import java.util.List;

public class o
extends l {
    public static String f = "0";
    public static boolean h = false;
    private static o i;
    private double A;
    private double B;
    private boolean C;
    private long D;
    private long E;
    private o$a F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private o$b L;
    private boolean M;
    private int N;
    private long O;
    private boolean P;
    private String Q;
    private boolean R;
    private boolean S;
    public l$b e;
    public final Handler g;
    private boolean j;
    private String k;
    private BDLocation l;
    private BDLocation m;
    private com.baidu.location.f.h n;
    private a o;
    private com.baidu.location.f.h p;
    private a q;
    private boolean r;
    private volatile boolean s;
    private boolean t;
    private long u;
    private long v;
    private Address w;
    private String x;
    private List y;
    private PoiRegion z;

    private o() {
        l$b l$b;
        long l10;
        boolean bl2;
        this.j = bl2 = true;
        this.e = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = bl2;
        this.s = false;
        this.t = false;
        this.u = l10 = 0L;
        this.v = l10;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = false;
        this.D = l10;
        this.E = l10;
        this.F = null;
        this.G = false;
        this.H = false;
        this.I = bl2;
        l$a l$a = new l$a(this);
        this.g = l$a;
        this.J = false;
        this.K = false;
        this.L = null;
        this.M = false;
        this.N = 0;
        this.O = l10;
        this.P = false;
        this.Q = null;
        this.R = false;
        this.S = bl2;
        this.e = l$b = new l$b(this);
    }

    public static /* synthetic */ void a(o o10, Message message) {
        o10.g(message);
    }

    public static /* synthetic */ boolean a(o o10) {
        return o10.M;
    }

    public static /* synthetic */ boolean a(o o10, boolean bl2) {
        o10.M = bl2;
        return bl2;
    }

    private boolean a(a a10) {
        a a11;
        this.b = a11 = com.baidu.location.f.b.a().f();
        if (a11 == a10) {
            return false;
        }
        boolean bl2 = true;
        if (a11 != null && a10 != null) {
            return a10.a(a11) ^ bl2;
        }
        return bl2;
    }

    private boolean a(com.baidu.location.f.h h10) {
        com.baidu.location.f.h h11;
        this.a = h11 = com.baidu.location.f.i.a().p();
        if (h10 == h11) {
            return false;
        }
        boolean bl2 = true;
        if (h11 != null && h10 != null) {
            return h10.c(h11) ^ bl2;
        }
        return bl2;
    }

    public static /* synthetic */ void b(o o10, Message message) {
        o10.h(message);
    }

    public static /* synthetic */ boolean b(o o10) {
        return o10.t;
    }

    public static /* synthetic */ boolean b(o o10, boolean bl2) {
        o10.t = bl2;
        return bl2;
    }

    private boolean b(a a10) {
        if (a10 == null) {
            return false;
        }
        a a11 = this.q;
        boolean bl2 = true;
        if (a11 == null) {
            return bl2;
        }
        return a10.a(a11) ^ bl2;
    }

    public static o c() {
        Class<o> clazz = o.class;
        synchronized (clazz) {
            o o10 = i;
            if (o10 == null) {
                i = o10 = new o();
            }
            o10 = i;
            return o10;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(Message object) {
        Object[] objectArray;
        Object object2;
        int n10 = com.baidu.location.h.l.aA;
        if (n10 != 0 && (n10 = com.baidu.location.h.l.d((Context)(object2 = com.baidu.location.f.getServiceContext()))) == 0) {
            object = new BDLocation();
            ((BDLocation)object).setLocType(62);
            com.baidu.location.b.b.a().a((BDLocation)object);
            return;
        }
        n10 = com.baidu.location.h.l.b();
        if (n10 != 0) {
            object2 = com.baidu.location.h.a.a;
            objectArray = "isInforbiddenTime on request location ...";
            Log.d((String)object2, (String)objectArray);
        }
        object2 = object.getData();
        objectArray = "isWaitingLocTag";
        n10 = object2.getBoolean((String)objectArray, false);
        int n11 = 1;
        if (n10 != 0) {
            h = n11;
        }
        if ((n10 = ((g)(object2 = com.baidu.location.indoor.g.a())).f()) != 0) {
            return;
        }
        object2 = com.baidu.location.b.b.a();
        n10 = ((b)object2).d((Message)object);
        if (n10 == n11) {
            this.d((Message)object);
            return;
        }
        int n12 = 2;
        if (n10 == n12) {
            this.g((Message)object);
            return;
        }
        n12 = 3;
        if (n10 == n12) {
            object2 = com.baidu.location.f.f.a();
            n10 = (int)(((com.baidu.location.f.f)object2).k() ? 1 : 0);
            if (n10 == 0) return;
            this.e((Message)object);
            return;
        }
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n10);
        object2 = String.format("this type %d is illegal", objectArray);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static /* synthetic */ boolean c(o o10) {
        return o10.G;
    }

    public static /* synthetic */ boolean c(o o10, boolean bl2) {
        o10.G = bl2;
        return bl2;
    }

    private void d(Message object) {
        com.baidu.location.f.f f10 = com.baidu.location.f.f.a();
        boolean bl2 = f10.k();
        if (bl2) {
            this.e((Message)object);
            object = com.baidu.location.b.s.a();
            ((s)object).c();
        } else {
            this.g((Message)object);
            object = com.baidu.location.b.s.a();
            ((s)object).b();
        }
    }

    private void d(BDLocation bDLocation) {
        int n10;
        int n11 = com.baidu.location.h.l.m;
        if (n11 == 0 && (n11 = bDLocation.isMockGps()) == (n10 = 1) && (n11 = (int)(com.baidu.location.h.l.o ? 1 : 0)) != 0) {
            Object object = com.baidu.location.f.f.a().i();
            if (object == null) {
                object = com.baidu.location.b.q.a();
                ((q)object).b();
            }
            object = com.baidu.location.b.b.a();
            ((b)object).c(bDLocation);
        } else {
            b b10 = com.baidu.location.b.b.a();
            b10.a(bDLocation);
        }
    }

    public static /* synthetic */ boolean d(o o10) {
        return o10.H;
    }

    private void e(Message object) {
        boolean bl2;
        boolean bl3;
        object = com.baidu.location.f.f.a().g();
        BDLocation bDLocation = new BDLocation((String)object);
        object = com.baidu.location.h.l.g;
        boolean n10 = object.equals("all");
        if (n10 || (bl3 = com.baidu.location.h.l.h) || (bl2 = com.baidu.location.h.l.j)) {
            object = new float[2];
            double d10 = this.B;
            double d11 = this.A;
            double d12 = bDLocation.getLatitude();
            double d13 = bDLocation.getLongitude();
            Location.distanceBetween((double)d10, (double)d11, (double)d12, (double)d13, (float[])object);
            Object object2 = object[0];
            float f10 = 100.0f;
            reference var3_6 = object2 == f10 ? 0 : (object2 < f10 ? -1 : 1);
            if (var3_6 < 0) {
                object = this.w;
                if (object != null) {
                    bDLocation.setAddr((Address)object);
                }
                if ((object = this.x) != null) {
                    bDLocation.setLocationDescribe((String)object);
                }
                if ((object = this.y) != null) {
                    bDLocation.setPoiList((List)object);
                }
                if ((object = this.z) != null) {
                    bDLocation.setPoiRegion((PoiRegion)object);
                }
            } else {
                boolean bl4 = true;
                object2 = Float.MIN_VALUE;
                this.C = bl4;
                this.g(null);
            }
        }
        this.l = bDLocation;
        this.m = null;
        this.d(bDLocation);
    }

    private void f(Message message) {
        Object object = com.baidu.location.f.i.a();
        boolean bl2 = ((i)object).g();
        if (bl2) {
            o$b o$b;
            boolean bl3;
            this.t = bl3 = true;
            object = this.L;
            if (object == null) {
                o$b = null;
                this.L = object = new o$b(this, null);
            }
            if ((bl2 = this.M) && (object = this.L) != null) {
                o$b = this.g;
                o$b.removeCallbacks((Runnable)object);
            }
            object = this.g;
            o$b = this.L;
            long l10 = 3500L;
            object.postDelayed((Runnable)o$b, l10);
            this.M = bl3;
        } else {
            this.h(message);
        }
    }

    private void g(Message message) {
        i i10 = null;
        this.N = 0;
        boolean bl2 = this.r;
        if (bl2) {
            long l10;
            this.N = 1;
            this.E = l10 = SystemClock.uptimeMillis();
            i10 = com.baidu.location.f.i.a();
            bl2 = i10.k();
            if (bl2) {
                this.f(message);
            } else {
                this.h(message);
            }
        } else {
            long l11;
            this.f(message);
            this.E = l11 = SystemClock.uptimeMillis();
        }
    }

    private void h(Message object) {
        int n10;
        Object object2;
        int n11;
        float f10;
        s s10;
        long l10;
        long l11;
        o$a o$a;
        int n12;
        Object object3;
        Object object4;
        int n13;
        long l12;
        block29: {
            long l13;
            int n14;
            long l14;
            long l15;
            block31: {
                block30: {
                    long l16;
                    long l17 = System.currentTimeMillis();
                    l12 = this.u;
                    l17 -= l12;
                    n13 = this.s;
                    if (n13 != 0 && (object4 = (l16 = l17 - (l12 = 12000L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) <= 0) {
                        return;
                    }
                    l17 = System.currentTimeMillis();
                    l12 = this.u;
                    long l18 = (l17 -= l12) - (l12 = 0L);
                    object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object4 > 0) {
                        l17 = System.currentTimeMillis();
                        long l19 = this.u;
                        long l20 = (l17 -= l19) - (l19 = 1000L);
                        object4 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                        if (object4 < 0) {
                            object = this.l;
                            if (object != null) {
                                object = com.baidu.location.b.b.a();
                                BDLocation bDLocation = this.l;
                                ((b)object).a(bDLocation);
                            }
                            this.n();
                            return;
                        }
                    }
                    object4 = 1;
                    this.s = object4;
                    object3 = this.o;
                    this.j = n12 = this.a((a)object3);
                    object3 = this.n;
                    n12 = this.a((com.baidu.location.f.h)object3);
                    o$a = null;
                    if (n12 != 0 || (n12 = this.j) != 0 || (object3 = this.l) == null || (n12 = this.C) != 0) break block29;
                    object3 = this.m;
                    if (object3 != null) {
                        l11 = System.currentTimeMillis();
                        l10 = this.v;
                        long l21 = (l11 -= l10) - (l10 = 30000L);
                        n12 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                        if (n12 > 0) {
                            object3 = this.m;
                            this.l = object3;
                            this.m = null;
                        }
                    }
                    if ((n12 = ((s)(object3 = com.baidu.location.b.s.a())).d()) != 0) {
                        object3 = this.l;
                        s10 = com.baidu.location.b.s.a();
                        f10 = s10.e();
                        ((BDLocation)object3).setDirection(f10);
                    }
                    object3 = this.l;
                    n12 = ((BDLocation)object3).getLocType();
                    n11 = 62;
                    f10 = 8.7E-44f;
                    if (n12 != n11) break block30;
                    l15 = System.currentTimeMillis();
                    l14 = this.O;
                    long l22 = (l15 -= l14) - l12;
                    n12 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                    if (n12 > 0) break block31;
                }
                l15 = l12;
            }
            if ((n12 = ((BDLocation)(object3 = this.l)).getLocType()) == (n14 = 61) || (n12 = ((BDLocation)(object3 = this.l)).getLocType()) == (n14 = 161) || (n12 = ((BDLocation)(object3 = this.l)).getLocType()) == n11 && (n12 = (int)((l13 = l15 - (l14 = 15000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) < 0) {
                object = com.baidu.location.b.b.a();
                BDLocation bDLocation = this.l;
                ((b)object).a(bDLocation);
                this.n();
                return;
            }
        }
        this.u = l11 = System.currentTimeMillis();
        object3 = this.a((String)null);
        n11 = 0;
        f10 = 0.0f;
        s10 = null;
        this.K = false;
        int n15 = 2;
        if (object3 == null) {
            CharSequence charSequence;
            this.K = object4;
            this.O = l10 = System.currentTimeMillis();
            object3 = new String[n15];
            try {
                object3 = this.m();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            l10 = System.currentTimeMillis();
            long l23 = this.D;
            l23 = l10 - l23;
            long l24 = 60000L;
            long l25 = l23 == l24 ? 0 : (l23 < l24 ? -1 : 1);
            if (l25 > 0) {
                this.D = l10;
            }
            if ((object2 = com.baidu.location.f.i.a().m()) != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                object2 = this.b();
                ((StringBuilder)charSequence).append((String)object2);
                object3 = object3[0];
                ((StringBuilder)charSequence).append((String)object3);
                object3 = ((StringBuilder)charSequence).toString();
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("");
                charSequence = this.b();
                ((StringBuilder)object2).append((String)charSequence);
                object3 = object3[0];
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
            }
            object2 = this.b;
            if (object2 != null && (object2 = ((a)object2).i()) != null) {
                object2 = new StringBuilder();
                charSequence = this.b.i();
                ((StringBuilder)object2).append((String)charSequence);
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
            }
            if ((object2 = com.baidu.location.h.b.a().a((boolean)object4)) != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object3);
                ((StringBuilder)charSequence).append((String)object2);
                object3 = ((StringBuilder)charSequence).toString();
            }
        }
        if ((object2 = this.k) != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            object3 = this.k;
            ((StringBuilder)object2).append((String)object3);
            object3 = ((StringBuilder)object2).toString();
            this.k = null;
        }
        if ((object2 = this.a) != null) {
            l12 = ((com.baidu.location.f.h)object2).f();
        }
        object2 = this.e;
        ((l$b)object2).a((String)object3, l12);
        object3 = this.b;
        this.o = object3;
        this.n = object3 = this.a;
        object3 = com.baidu.location.f.f.a();
        n12 = (int)(((com.baidu.location.f.f)object3).k() ? 1 : 0);
        if (n12 == 0) {
            this.l();
        }
        if ((n12 = (int)(((h)(object3 = com.baidu.location.e.h.a())).h() ? 1 : 0)) != 0) {
            object3 = this.F;
            if (object3 == null) {
                this.F = object3 = new o$a(this, null);
            }
            object3 = com.baidu.location.e.h.a();
            n13 = com.baidu.location.f.b.a().e();
            String string2 = com.baidu.location.f.e.a(n13);
            long l26 = ((h)object3).a(string2);
            Handler handler = this.g;
            o$a = this.F;
            handler.postDelayed((Runnable)o$a, l26);
            this.G = object4;
        }
        if ((n12 = (int)(this.r ? 1 : 0)) == object4) {
            this.r = false;
            Object object5 = com.baidu.location.f.i.a();
            object4 = ((i)object5).j();
            if (object4 != false && object != null && (n10 = ((b)(object5 = com.baidu.location.b.b.a())).e((Message)object)) < (object4 = (Object)1000) && (n10 = (int)(((h)(object = com.baidu.location.e.h.a())).d() ? 1 : 0)) != 0) {
                object = com.baidu.location.e.h.a();
                ((h)object).i();
            }
            object = com.baidu.location.c.b.a();
            ((com.baidu.location.c.b)object).b();
        }
        if ((n10 = this.N) > 0) {
            if (n10 == n15) {
                object = com.baidu.location.f.i.a();
                ((i)object).g();
            }
            this.N = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean l() {
        int n10;
        Object object;
        BDLocation bDLocation;
        int n11;
        BDLocation bDLocation2;
        int n12;
        block9: {
            block11: {
                block10: {
                    h$a h$a;
                    h$b h$b;
                    com.baidu.location.f.h h10;
                    a a10;
                    double d10;
                    double d11;
                    double d12;
                    long l10;
                    long l11;
                    int n13;
                    int n14;
                    double d13 = Math.random();
                    SystemClock.uptimeMillis();
                    Object object2 = com.baidu.location.f.b.a().f();
                    Object object3 = com.baidu.location.f.i.a().o();
                    long l12 = object3 != null && (n14 = ((com.baidu.location.f.h)object3).a()) > 0 ? ((com.baidu.location.f.h)object3).g() : 0L;
                    n12 = 1;
                    if (object2 != null && (n13 = ((a)object2).e()) != 0 && (object3 == null || (n13 = ((com.baidu.location.f.h)object3).a()) == 0)) {
                        n13 = n12;
                    } else {
                        n13 = 0;
                        object2 = null;
                    }
                    object3 = com.baidu.location.e.h.a();
                    int n15 = ((h)object3).d();
                    bDLocation2 = null;
                    if (n15 == 0 || (n15 = ((h)(object3 = com.baidu.location.e.h.a())).f()) == 0 || (n15 = (l11 = l12 - (l10 = (long)60)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0 || n13 == 0 && ((n13 = (d12 = (d11 = 0.0) - d13) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) >= 0 || (n11 = (int)((d10 = d13 - (d11 = ((h)(object2 = com.baidu.location.e.h.a())).o())) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1))) >= 0)) break block9;
                    h h11 = com.baidu.location.e.h.a();
                    bDLocation = h11.a(a10 = com.baidu.location.f.b.a().f(), h10 = com.baidu.location.f.i.a().o(), null, h$b = h$b.a, h$a = h$a.a);
                    if (bDLocation == null) break block10;
                    object = com.baidu.location.h.l.g;
                    object2 = "all";
                    n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                    if (n10 != 0 && (object = bDLocation.getAddrStr()) == null) {
                        n10 = 0;
                        object = null;
                    } else {
                        n10 = n12;
                    }
                    n13 = (int)(com.baidu.location.h.l.h ? 1 : 0);
                    if (n13 != 0 && (object2 = bDLocation.getLocationDescribe()) == null) {
                        n10 = 0;
                        object = null;
                    }
                    if ((n13 = (int)(com.baidu.location.h.l.j ? 1 : 0)) == 0 || (object2 = bDLocation.getPoiList()) != null) break block11;
                }
                n10 = 0;
                object = null;
            }
            if (n10 != 0) {
                bDLocation2 = bDLocation;
            }
        }
        if (bDLocation2 == null) return 0 != 0;
        n11 = bDLocation2.getLocType();
        if (n11 != (n10 = 66)) return 0 != 0;
        n11 = (int)(this.s ? 1 : 0);
        if (n11 == 0) return 0 != 0;
        bDLocation = new BDLocation(bDLocation2);
        bDLocation.setLocType(161);
        n10 = (int)(this.s ? 1 : 0);
        if (n10 == 0) return 0 != 0;
        this.H = n12;
        object = com.baidu.location.b.b.a();
        ((b)object).a(bDLocation);
        this.l = bDLocation;
        return n12 != 0;
    }

    /*
     * Unable to fully structure code
     */
    private String[] m() {
        var1_1 = "Location failed beacuse we can not get any loc information!";
        var2_2 = new String[]{"", var1_1};
        var3_3 = new StringBuffer();
        var3_3.append("&apl=");
        var4_4 = com.baidu.location.f.getServiceContext();
        var5_5 = com.baidu.location.h.l.b((Context)var4_4);
        var6_6 = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        var7_7 = 1;
        if (var5_5 == var7_7) {
            var2_2[var7_7] = var6_6;
        }
        var3_3.append(var5_5);
        var8_8 = com.baidu.location.h.l.e(com.baidu.location.f.getServiceContext());
        var9_9 = "0|0|";
        var10_10 = var8_8.contains(var9_9);
        var11_11 = "Location failed beacuse we can not get any loc information without any location permission!";
        if (var10_10 != 0) {
            var2_2[var7_7] = var11_11;
        }
        var3_3.append(var8_8);
        var10_10 = Build.VERSION.SDK_INT;
        var12_12 = 23;
        var13_13 = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
        if (var10_10 >= var12_12) {
            var3_3.append("&loc=");
            var14_14 = com.baidu.location.f.getServiceContext();
            var12_12 = com.baidu.location.h.l.c((Context)var14_14);
            if (var12_12 == 0) {
                var2_2[var7_7] = var13_13;
                var15_15 = var7_7;
            } else {
                var15_15 = 0;
            }
            var3_3.append(var12_12);
        } else {
            var15_15 = 0;
        }
        var12_12 = 19;
        if (var10_10 >= var12_12) {
            var3_3.append("&lmd=");
            var16_16 = com.baidu.location.f.getServiceContext();
            var10_10 = com.baidu.location.h.l.c((Context)var16_16);
            if (var10_10 >= 0) {
                var3_3.append(var10_10);
            }
        }
        var16_16 = com.baidu.location.f.b.a().g();
        var14_14 = com.baidu.location.f.i.a().h();
        var3_3.append((String)var14_14);
        var3_3.append(var16_16);
        var17_17 = com.baidu.location.h.l.f(com.baidu.location.f.getServiceContext());
        var3_3.append(var17_17);
        var18_18 = 62;
        if (var5_5 == var7_7) {
            var1_1 = com.baidu.location.b.c.a();
            var5_5 = 7;
lbl61:
            // 2 sources

            while (true) {
                var1_1.a(var18_18, var5_5, var6_6);
                break;
            }
        } else {
            var5_5 = (int)var8_8.contains(var9_9);
            if (var5_5 != 0) {
                var1_1 = com.baidu.location.b.c.a();
                var5_5 = 4;
                var1_1.a(var18_18, var5_5, var11_11);
            } else if (var15_15 != 0) {
                var1_1 = com.baidu.location.b.c.a();
                var5_5 = 5;
                var1_1.a(var18_18, var5_5, var13_13);
            } else {
                if (var16_16 != null && var14_14 != null && (var5_5 = (int)var16_16.equals(var4_4 = "&sim=1")) != 0 && (var5_5 = (int)var14_14.equals(var4_4 = "&wifio=1")) == 0) {
                    var1_1 = com.baidu.location.b.c.a();
                    var5_5 = 6;
                    var6_6 = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
                    ** continue;
                }
                var4_4 = com.baidu.location.b.c.a();
                var19_19 = 9;
                var4_4.a(var18_18, var19_19, (String)var1_1);
            }
        }
        var2_2[0] = var1_1 = var3_3.toString();
        return var2_2;
    }

    private void n() {
        this.s = false;
        this.H = false;
        this.I = false;
        this.C = false;
        this.o();
        boolean bl2 = this.S;
        if (bl2) {
            this.S = false;
        }
    }

    private void o() {
        boolean bl2;
        Object object = this.l;
        if (object != null && (bl2 = ((i)(object = com.baidu.location.f.i.a())).j())) {
            object = ad.a();
            ((ad)object).d();
        }
    }

    public Address a(BDLocation object) {
        boolean bl2;
        boolean bl3;
        Object object2 = com.baidu.location.h.l.g;
        boolean n10 = ((String)object2).equals("all");
        if (n10 || (bl3 = com.baidu.location.h.l.h) || (bl2 = com.baidu.location.h.l.j)) {
            int n11 = 2;
            object2 = new float[n11];
            double d10 = this.B;
            double d11 = this.A;
            double d12 = ((BDLocation)object).getLatitude();
            double d13 = ((BDLocation)object).getLongitude();
            Location.distanceBetween((double)d10, (double)d11, (double)d12, (double)d13, (float[])object2);
            d10 = 100.0;
            object = null;
            Object object3 = object2[0];
            d11 = (double)object3;
            double d14 = d11 == d10 ? 0 : (d11 < d10 ? -1 : 1);
            if (d14 < 0) {
                object = this.w;
                if (object != null) {
                    return object;
                }
            } else {
                this.x = null;
                this.y = null;
                this.z = null;
                d14 = 1.0;
                object3 = Float.MIN_VALUE;
                this.C = d14;
                object = this.g;
                object2 = new p(this);
                object.post((Runnable)object2);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        block23: {
            float f10;
            int n10;
            int n11;
            String string2;
            Object object;
            Object object2;
            Object object3;
            boolean bl2;
            BDLocation bDLocation;
            float f11;
            int n12;
            Object object4;
            block25: {
                block24: {
                    boolean bl3;
                    block22: {
                        boolean bl4;
                        boolean bl5;
                        object4 = this.F;
                        n12 = 0;
                        f11 = 0.0f;
                        bDLocation = null;
                        if (object4 != null && (bl2 = this.G)) {
                            this.G = false;
                            object3 = this.g;
                            object3.removeCallbacks((Runnable)object4);
                        }
                        object4 = com.baidu.location.f.f.a();
                        boolean bl6 = ((com.baidu.location.f.f)object4).k();
                        object3 = "all";
                        if (!bl6) break block22;
                        object4 = com.baidu.location.f.f.a().g();
                        BDLocation bDLocation2 = new BDLocation((String)object4);
                        object4 = com.baidu.location.h.l.g;
                        boolean bl7 = ((String)object4).equals(object3);
                        if (bl7 || (bl5 = com.baidu.location.h.l.h) || (bl4 = com.baidu.location.h.l.j)) {
                            object4 = new float[2];
                            double d10 = this.B;
                            double d11 = this.A;
                            double d12 = bDLocation2.getLatitude();
                            double d13 = bDLocation2.getLongitude();
                            Location.distanceBetween((double)d10, (double)d11, (double)d12, (double)d13, (float[])object4);
                            Object object5 = object4[0];
                            n12 = 1120403456;
                            f11 = 100.0f;
                            reference var7_11 = object5 == f11 ? 0 : (object5 < f11 ? -1 : 1);
                            if (var7_11 < 0) {
                                object4 = this.w;
                                if (object4 != null) {
                                    bDLocation2.setAddr((Address)object4);
                                }
                                if ((object4 = this.x) != null) {
                                    bDLocation2.setLocationDescribe((String)object4);
                                }
                                if ((object4 = this.y) != null) {
                                    bDLocation2.setPoiList((List)object4);
                                }
                                if ((object4 = this.z) != null) {
                                    bDLocation2.setPoiRegion((PoiRegion)object4);
                                }
                            }
                        }
                        object4 = com.baidu.location.b.b.a();
                        ((b)object4).a(bDLocation2);
                        break block23;
                    }
                    boolean bl8 = this.H;
                    if (bl8) {
                        this.n();
                        return;
                    }
                    object4 = com.baidu.location.e.h.a();
                    boolean bl9 = ((h)object4).d();
                    Object var8_17 = null;
                    if (!bl9 || !(bl3 = ((h)(object4 = com.baidu.location.e.h.a())).e())) break block24;
                    Object object6 = com.baidu.location.e.h.a();
                    object2 = com.baidu.location.f.b.a().f();
                    object = com.baidu.location.f.i.a().o();
                    string2 = null;
                    h$b h$b = h$b.b;
                    h$a h$a = h$a.a;
                    object4 = ((h)object6).a((a)object2, (com.baidu.location.f.h)object, null, h$b, h$a);
                    if (object4 != null) {
                        n11 = ((BDLocation)object4).getLocType();
                        n10 = 66;
                        f10 = 9.2E-44f;
                        if (n11 == n10) {
                            object6 = com.baidu.location.b.b.a();
                            ((b)object6).a((BDLocation)object4);
                        }
                    }
                    break block25;
                }
                boolean bl10 = false;
                object4 = null;
                float f12 = 0.0f;
            }
            n11 = 67;
            if (object4 == null || (n10 = ((BDLocation)object4).getLocType()) == n11) {
                n10 = (int)(this.j ? 1 : 0);
                if (n10 == 0 && (object2 = this.l) != null) {
                    object4 = com.baidu.location.b.b.a();
                    bDLocation = this.l;
                    ((b)object4).a(bDLocation);
                } else {
                    object2 = com.baidu.location.e.a.a();
                    n10 = (int)(((com.baidu.location.e.a)object2).a ? 1 : 0);
                    if (n10 != 0) {
                        object4 = com.baidu.location.e.a.a().a(false);
                    } else if (object4 == null) {
                        object4 = new BDLocation();
                        ((BDLocation)object4).setLocType(n11);
                    }
                    if (object4 != null) {
                        object2 = com.baidu.location.b.b.a();
                        ((b)object2).a((BDLocation)object4);
                        n10 = ((BDLocation)object4).getLocType();
                        if (n10 == n11 && (n10 = (int)(this.K ? 1 : 0)) == 0) {
                            object2 = com.baidu.location.b.c.a();
                            int n13 = 3;
                            string2 = "Offline location failed, please check the net (wifi/cell)!";
                            ((c)object2).a(n11, n13, string2);
                        }
                        n10 = 1;
                        f10 = Float.MIN_VALUE;
                        object = com.baidu.location.h.l.g;
                        bl2 = ((String)object).equals(object3);
                        if (bl2 && (object3 = ((BDLocation)object4).getAddrStr()) == null) {
                            n10 = 0;
                            object2 = null;
                            f10 = 0.0f;
                        }
                        if ((bl2 = com.baidu.location.h.l.h) && (object3 = ((BDLocation)object4).getLocationDescribe()) == null) {
                            n10 = 0;
                            object2 = null;
                            f10 = 0.0f;
                        }
                        if (!(bl2 = com.baidu.location.h.l.j) || (object3 = ((BDLocation)object4).getPoiList()) != null) {
                            n12 = n10;
                            f11 = f10;
                        }
                        if (n12 == 0) {
                            ((BDLocation)object4).setLocType(n11);
                        }
                    }
                }
            }
            this.m = null;
        }
        this.n();
    }

    public void a(Message object) {
        int n10;
        int n11;
        o$a o$a = this.F;
        if (o$a != null && (n11 = this.G) != 0) {
            n11 = 0;
            this.G = false;
            Handler handler = this.g;
            handler.removeCallbacks((Runnable)o$a);
        }
        if ((object = (BDLocation)((Message)object).obj) != null && (n10 = ((BDLocation)object).getLocType()) == (n11 = 167) && (n10 = (int)(this.K ? 1 : 0)) != 0) {
            n10 = 62;
            ((BDLocation)object).setLocType(n10);
        }
        this.b((BDLocation)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(boolean n10, boolean bl2) {
        Object object;
        int n11;
        Object object2;
        Object object3;
        int n12;
        Object object4;
        block5: {
            block6: {
                block4: {
                    int n13;
                    h$a h$a;
                    h$b h$b;
                    com.baidu.location.f.h h10;
                    object4 = com.baidu.location.e.h.a();
                    boolean bl3 = ((h)object4).d();
                    n12 = 0;
                    if (!bl3 || !(bl3 = ((h)(object4 = com.baidu.location.e.h.a())).g())) break block4;
                    object3 = com.baidu.location.e.h.a();
                    object4 = ((h)object3).a((a)(object2 = com.baidu.location.f.b.a().f()), h10 = com.baidu.location.f.i.a().o(), null, h$b = h$b.b, h$a = h$a.a);
                    if (object4 != null && (n11 = ((BDLocation)object4).getLocType()) != (n13 = 67) || n10 == 0) break block5;
                    object = com.baidu.location.e.a.a();
                    n10 = (int)(((com.baidu.location.e.a)object).a ? 1 : 0);
                    if (n10 == 0) break block5;
                    break block6;
                }
                if (n10 == 0) return;
                object = com.baidu.location.e.a.a();
                n10 = (int)(((com.baidu.location.e.a)object).a ? 1 : 0);
                if (n10 == 0) return;
            }
            object = com.baidu.location.e.a.a();
            object4 = ((com.baidu.location.e.a)object).a(false);
        }
        if (object4 == null) return;
        n10 = ((BDLocation)object4).getLocType();
        if (n10 != (n11 = 66)) return;
        n10 = 1;
        object3 = com.baidu.location.h.l.g;
        object2 = "all";
        n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
        if (n11 != 0 && (object3 = ((BDLocation)object4).getAddrStr()) == null) {
            n10 = 0;
            object = null;
        }
        if ((n11 = (int)(com.baidu.location.h.l.h ? 1 : 0)) != 0 && (object3 = ((BDLocation)object4).getLocationDescribe()) == null) {
            n10 = 0;
            object = null;
        }
        if ((n11 = (int)(com.baidu.location.h.l.j ? 1 : 0)) == 0 || (object3 = ((BDLocation)object4).getPoiList()) != null) {
            n12 = n10;
        }
        if (n12 == 0) {
            if (!bl2) return;
        }
        object = com.baidu.location.b.b.a();
        ((b)object).a((BDLocation)object4);
    }

    public void b(Message message) {
        boolean bl2 = this.J;
        if (!bl2) {
            return;
        }
        this.c(message);
    }

    public void b(BDLocation bDLocation) {
        boolean bl2;
        boolean bl3;
        Enum enum_;
        long l10;
        Object object;
        float f10;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        float f11;
        Object object6;
        Object object7;
        Object object8;
        BDLocation bDLocation2;
        Object object9;
        o o10;
        block37: {
            block39: {
                block40: {
                    block38: {
                        double d10;
                        o10 = this;
                        object9 = bDLocation;
                        bDLocation2 = new BDLocation(bDLocation);
                        object8 = bDLocation.hasAddr();
                        if (object8 != 0) {
                            this.w = object7 = bDLocation.getAddress();
                            if (object7 != null && (object7 = ((Address)object7).cityCode) != null) {
                                f = object7;
                            }
                            o10.A = d10 = bDLocation.getLongitude();
                            o10.B = d10 = bDLocation.getLatitude();
                        }
                        if ((object7 = bDLocation.getLocationDescribe()) != null) {
                            o10.x = object7 = bDLocation.getLocationDescribe();
                            o10.A = d10 = bDLocation.getLongitude();
                            o10.B = d10 = bDLocation.getLatitude();
                        }
                        if ((object7 = bDLocation.getPoiList()) != null) {
                            o10.y = object7 = bDLocation.getPoiList();
                            o10.A = d10 = bDLocation.getLongitude();
                            o10.B = d10 = bDLocation.getLatitude();
                        }
                        if ((object7 = bDLocation.getPoiRegion()) != null) {
                            o10.z = object7 = bDLocation.getPoiRegion();
                            o10.A = d10 = bDLocation.getLongitude();
                            o10.B = d10 = bDLocation.getLatitude();
                        }
                        object7 = com.baidu.location.f.f.a();
                        object8 = ((com.baidu.location.f.f)object7).k();
                        object6 = 1120403456;
                        f11 = 100.0f;
                        object5 = 2;
                        object4 = 0;
                        object3 = null;
                        if (object8 != 0) {
                            boolean bl4;
                            boolean bl22;
                            object9 = com.baidu.location.f.f.a().g();
                            object7 = new BDLocation((String)object9);
                            object9 = com.baidu.location.h.l.g;
                            String string2 = "all";
                            boolean n10 = ((String)object9).equals(string2);
                            if (n10 || (bl22 = com.baidu.location.h.l.h) || (bl4 = com.baidu.location.h.l.j)) {
                                object9 = new float[object5];
                                double d11 = o10.B;
                                double d12 = o10.A;
                                double d13 = ((BDLocation)object7).getLatitude();
                                double d14 = ((BDLocation)object7).getLongitude();
                                Location.distanceBetween((double)d11, (double)d12, (double)d13, (double)d14, (float[])object9);
                                Object object10 = object9[0];
                                reference var15_18 = object10 == f11 ? 0 : (object10 < f11 ? -1 : 1);
                                if (var15_18 < 0) {
                                    object9 = o10.w;
                                    if (object9 != null) {
                                        ((BDLocation)object7).setAddr((Address)object9);
                                    }
                                    if ((object9 = o10.x) != null) {
                                        ((BDLocation)object7).setLocationDescribe((String)object9);
                                    }
                                    if ((object9 = o10.y) != null) {
                                        ((BDLocation)object7).setPoiList((List)object9);
                                    }
                                    if ((object9 = o10.z) != null) {
                                        ((BDLocation)object7).setPoiRegion((PoiRegion)object9);
                                    }
                                }
                            }
                            o10.d((BDLocation)object7);
                            this.n();
                            return;
                        }
                        object8 = o10.H;
                        if (object8 == 0) break block37;
                        object7 = new float[object5];
                        BDLocation bDLocation3 = o10.l;
                        if (bDLocation3 != null) {
                            double d15 = bDLocation3.getLatitude();
                            bDLocation3 = o10.l;
                            double d16 = bDLocation3.getLongitude();
                            double d17 = bDLocation.getLatitude();
                            double d18 = bDLocation.getLongitude();
                            Location.distanceBetween((double)d15, (double)d16, (double)d17, (double)d18, (float[])object7);
                        }
                        reference var34_33 = object7[0];
                        object6 = 1092616192;
                        f11 = 10.0f;
                        reference cfr_temp_0 = var34_33 - f11;
                        object8 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 > 0 ? 1 : -1);
                        if (object8 <= 0) break block38;
                        o10.l = object9;
                        object8 = o10.I;
                        if (object8 != 0) break block39;
                        o10.I = false;
                        break block40;
                    }
                    object8 = bDLocation.getUserIndoorState();
                    object6 = -1;
                    f11 = 0.0f / 0.0f;
                    if (object8 <= object6) break block39;
                    o10.l = object9;
                }
                object7 = com.baidu.location.b.b.a();
                ((b)object7).a((BDLocation)object9);
            }
            this.n();
            return;
        }
        object8 = bDLocation.getLocType();
        int n10 = 167;
        Object object11 = 1;
        float f12 = Float.MIN_VALUE;
        String string2 = "cl";
        Object object12 = 161;
        if (object8 == n10) {
            object7 = com.baidu.location.b.c.a();
            object6 = 8;
            f11 = 1.1E-44f;
            object2 = "NetWork location failed because baidu location service can not caculate the location!";
            ((c)object7).a(n10, (int)object6, (String)object2);
        } else {
            object8 = bDLocation.getLocType();
            if (object8 == object12) {
                object8 = Build.VERSION.SDK_INT;
                n10 = 19;
                if (object8 >= n10 && ((object8 = com.baidu.location.h.l.c((Context)(object7 = com.baidu.location.f.getServiceContext()))) == 0 || object8 == object5)) {
                    object8 = object11;
                    f10 = f12;
                } else {
                    object8 = 0;
                    object7 = null;
                    f10 = 0.0f;
                }
                if (object8 != 0) {
                    object7 = com.baidu.location.b.c.a();
                    object = "NetWork location successful, open gps will be better!";
                    ((c)object7).a((int)object12, (int)object11, (String)object);
                } else {
                    f10 = bDLocation.getRadius();
                    float f13 = f10 - f11;
                    object8 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                    if (object8 >= 0 && (object7 = bDLocation.getNetworkLocationType()) != null && (object8 = (Object)((String)(object7 = bDLocation.getNetworkLocationType())).equals(string2)) != 0 && (object7 = com.baidu.location.f.i.a().h()) != null && (object8 = (Object)((String)object7).equals(object = "&wifio=1")) == 0) {
                        object7 = com.baidu.location.b.c.a();
                        object = "NetWork location successful, open wifi will be better!";
                        ((c)object7).a((int)object12, (int)object5, (String)object);
                    }
                }
            }
        }
        object8 = 0;
        f10 = 0.0f;
        object7 = null;
        o10.m = null;
        object6 = bDLocation.getLocType();
        String string3 = "wf";
        if (object6 == object12 && (object6 = (Object)string2.equals(object = bDLocation.getNetworkLocationType())) != 0 && (object = o10.l) != null && (object6 = ((BDLocation)object).getLocType()) == object12 && (object6 = (Object)string3.equals(object = o10.l.getNetworkLocationType())) != 0) {
            l10 = System.currentTimeMillis();
            long l11 = o10.v;
            l10 -= l11;
            l11 = 30000L;
            double d19 = 1.4822E-319;
            object6 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object6 < 0) {
                o10.m = object9;
                object4 = object11;
            }
        }
        object = com.baidu.location.b.b.a();
        if (object4 != 0) {
            object2 = o10.l;
            ((b)object).a((BDLocation)object2);
        } else {
            ((b)object).a((BDLocation)object9);
            o10.v = l10 = System.currentTimeMillis();
        }
        object6 = com.baidu.location.h.l.a(bDLocation);
        if (object6 != 0) {
            if (object4 == 0) {
                o10.l = object9;
            }
        } else {
            o10.l = null;
        }
        if ((object6 = com.baidu.location.h.l.a((String)(object = com.baidu.location.b.l.c), (String)(object2 = "ssid\":\""), object3 = "\"")) != (object5 = -1 << -1) && (object2 = o10.n) != null) {
            object7 = ((com.baidu.location.f.h)object2).c((int)object6);
        }
        o10.k = object7;
        object7 = com.baidu.location.e.h.a();
        object8 = ((h)object7).d();
        if (object8 != 0 && (object8 = bDLocation.getLocType()) == object12 && (object8 = (Object)string2.equals(object7 = bDLocation.getNetworkLocationType())) != 0 && (object8 = (Object)o10.b((a)(object7 = o10.o))) != 0) {
            object7 = com.baidu.location.e.h.a();
            object = o10.o;
            object5 = 0;
            object2 = null;
            enum_ = h$b.b;
            h$a h$a = h$a.b;
            object3 = bDLocation2;
            ((h)object7).a((a)object, null, bDLocation2, (h$b)enum_, h$a);
            o10.q = object7 = o10.o;
        }
        if ((object8 = (Object)((h)(object7 = com.baidu.location.e.h.a())).d()) != 0 && (object8 = bDLocation.getLocType()) == object12 && (bl3 = string3.equals(object9 = bDLocation.getNetworkLocationType()))) {
            object9 = com.baidu.location.e.h.a();
            object8 = 0;
            f10 = 0.0f;
            object7 = null;
            object = o10.n;
            object3 = h$b.b;
            enum_ = h$a.b;
            object2 = bDLocation2;
            ((h)object9).a(null, (com.baidu.location.f.h)object, bDLocation2, (h$b)((Object)object3), (h$a)enum_);
            o10.p = object9 = o10.n;
        }
        if ((object9 = o10.o) != null) {
            object9 = com.baidu.location.e.a.a();
            object7 = com.baidu.location.b.l.c;
            object = o10.o;
            object2 = o10.n;
            ((com.baidu.location.e.a)object9).a((String)object7, (a)object, (com.baidu.location.f.h)object2, bDLocation2);
        }
        if (bl2 = ((i)(object9 = com.baidu.location.f.i.a())).j()) {
            com.baidu.location.e.h.a().i();
            object9 = com.baidu.location.e.h.a();
            ((h)object9).m();
        }
        this.n();
    }

    public void c(BDLocation bDLocation) {
        BDLocation bDLocation2;
        this.l = bDLocation2 = new BDLocation(bDLocation);
    }

    public void d() {
        boolean bl2;
        this.r = bl2 = true;
        this.s = false;
        this.J = bl2;
    }

    public void e() {
        this.s = false;
        this.t = false;
        this.H = false;
        this.I = true;
        this.k();
        this.J = false;
    }

    public String f() {
        return this.x;
    }

    public List g() {
        return this.y;
    }

    public PoiRegion h() {
        return this.z;
    }

    public boolean i() {
        return this.j;
    }

    public void j() {
        boolean bl2 = this.t;
        if (bl2) {
            this.h(null);
            bl2 = false;
            Object var2_2 = null;
            this.t = false;
        } else {
            com.baidu.location.c.b b10 = com.baidu.location.c.b.a();
            b10.d();
        }
    }

    public void k() {
        this.l = null;
    }
}

