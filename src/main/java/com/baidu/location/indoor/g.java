/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.net.wifi.ScanResult
 *  android.os.Bundle
 *  android.os.Message
 *  com.baidu.location.indoor.mapversion.b.a
 */
package com.baidu.location.indoor;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.b;
import com.baidu.location.b.s;
import com.baidu.location.f;
import com.baidu.location.indoor.d;
import com.baidu.location.indoor.g$b;
import com.baidu.location.indoor.g$c;
import com.baidu.location.indoor.g$d;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.g$f;
import com.baidu.location.indoor.g$g;
import com.baidu.location.indoor.g$h;
import com.baidu.location.indoor.g$i;
import com.baidu.location.indoor.h;
import com.baidu.location.indoor.i;
import com.baidu.location.indoor.j;
import com.baidu.location.indoor.l;
import com.baidu.location.indoor.mapversion.b.a;
import com.baidu.location.indoor.mapversion.b.a$c;
import com.baidu.location.indoor.mapversion.b.c;
import com.baidu.location.indoor.mapversion.b.c$b;
import com.baidu.location.indoor.n;
import com.baidu.location.indoor.n$a;
import com.baidu.location.indoor.q;
import com.baidu.location.indoor.q$a;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class g {
    private static g g;
    private String A;
    private String B;
    private int C;
    private int D;
    private com.baidu.location.indoor.c E;
    private int F;
    private com.baidu.location.indoor.c G;
    private double H;
    private double I;
    private double J;
    private boolean K;
    private boolean L;
    private List M;
    private int N;
    private int O;
    private int P;
    private com.baidu.location.indoor.a Q;
    private String R;
    private d S;
    private boolean T;
    private q U;
    private q$a V;
    private int W;
    private BDLocation X;
    private boolean Y;
    private boolean Z;
    public g$d a;
    private boolean aa;
    private boolean ab;
    private g$c ac;
    private g$e ad;
    private g$f ae;
    private g$b af;
    public SimpleDateFormat b;
    private int c = 0;
    private boolean d = false;
    private int e = 32;
    private boolean f;
    private long h;
    private volatile boolean i;
    private n j;
    private g$g k;
    private g$i l;
    private long m;
    private boolean n;
    private boolean o;
    private long p;
    private long q;
    private int r;
    private String s;
    private n$a t;
    private int u;
    private int v;
    private String w;
    private String x;
    private l y;
    private String z;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private g() {
        double d10;
        int n10;
        long l10;
        int n11;
        long l11;
        this.h = l11 = 3000L;
        this.i = n11 = 1;
        n$a n$a = null;
        this.a = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = l10 = 0L;
        this.n = false;
        this.o = false;
        this.p = l10;
        this.q = l10;
        this.r = 0;
        this.s = null;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = 3;
        this.E = null;
        this.F = n10 = 20;
        this.G = null;
        this.H = d10 = 0.0;
        this.I = d10;
        l10 = 4600877379321698714L;
        this.J = d10 = 0.4;
        this.K = false;
        this.L = n11;
        Object object = new ArrayList();
        object = Collections.synchronizedList(object);
        this.M = object;
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.R = null;
        this.S = null;
        this.T = false;
        String string2 = "yyyy-MM-dd HH:mm:ss";
        this.b = object = new SimpleDateFormat(string2);
        this.W = n11 = 2;
        this.X = null;
        this.Y = false;
        this.Z = false;
        this.aa = false;
        this.ab = false;
        this.ac = null;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.f = false;
        Object object2 = new g$d(this);
        this.a = object2;
        try {
            object2 = com.baidu.location.f.getServiceContext();
            com.baidu.location.indoor.mapversion.b.a.a((Context)object2);
        }
        catch (Exception exception) {}
        try {
            object2 = com.baidu.location.f.getServiceContext();
            com.baidu.location.indoor.mapversion.b.c.a((Context)object2);
        }
        catch (Exception exception) {}
        this.U = object2;
        ((q)object2).a(1000L);
        this.V = object2 = new h(this);
        this.t = object2 = new i(this);
        object = com.baidu.location.f.getServiceContext();
        n$a = this.t;
        this.j = object2 = new n((Context)object, n$a);
        this.l = object2 = new g$i(this);
        n11 = this.D;
        this.E = object2 = new com.baidu.location.indoor.c(n11);
        n11 = this.F;
        this.G = object2 = new com.baidu.location.indoor.c(n11);
        object = com.baidu.location.f.getServiceContext();
        this.Q = object2 = new com.baidu.location.indoor.a((Context)object);
        this.ac = object2 = new g$c(this);
        this.ad = object2 = new g$e(this);
        this.ae = object2 = new g$f(this);
        this.af = object2 = new g$b(this);
    }

    public static /* synthetic */ int A(g g10) {
        return g10.u;
    }

    public static /* synthetic */ double B(g g10) {
        return g10.H;
    }

    public static /* synthetic */ double C(g g10) {
        return g10.I;
    }

    public static /* synthetic */ int D(g g10) {
        int n10;
        int n11 = g10.P;
        g10.P = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ String E(g g10) {
        return g10.R;
    }

    public static /* synthetic */ double a(g g10, double d10) {
        g10.J = d10;
        return d10;
    }

    public static /* synthetic */ int a(g g10, int n10) {
        g10.W = n10;
        return n10;
    }

    public static /* synthetic */ long a(g g10, long l10) {
        g10.h = l10;
        return l10;
    }

    public static /* synthetic */ g$e a(g g10) {
        return g10.ad;
    }

    public static g a() {
        Class<g> clazz = g.class;
        synchronized (clazz) {
            g g10 = g;
            if (g10 == null) {
                g = g10 = new g();
            }
            g10 = g;
            return g10;
        }
    }

    private String a(int n10) {
        int n11;
        Object object = this.M;
        int n12 = object.size();
        if (n12 == 0) {
            return "&dr=0:0";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("&dr=");
        Object object2 = this.M;
        int n13 = 0;
        Object object3 = null;
        object2 = (g$h)object2.get(0);
        ((g$h)object2).d = n11 = 1;
        object2 = ((g$h)this.M.get(0)).toString();
        ((StringBuilder)object).append((String)object2);
        object2 = (g$h)this.M.get(0);
        int n14 = ((g$h)object2).a;
        while (n11 < (n13 = (object3 = this.M).size()) && n11 <= n10) {
            int n15;
            object3 = (g$h)this.M.get(n11);
            g$h g$h = (g$h)this.M.get(n11);
            ((g$h)object3).d = n15 = g$h.a - n14;
            ((StringBuilder)object).append(";");
            object2 = ((g$h)this.M.get(n11)).toString();
            ((StringBuilder)object).append((String)object2);
            object2 = (g$h)this.M.get(n11);
            n14 = ((g$h)object2).a;
            ++n11;
        }
        return ((StringBuilder)object).toString();
    }

    private String a(com.baidu.location.f.h object) {
        String string2;
        int n10 = ((com.baidu.location.f.h)object).a();
        int n11 = this.e;
        boolean bl2 = true;
        if (n10 <= n11) {
            StringBuilder stringBuilder = new StringBuilder();
            n11 = this.e;
            object = ((com.baidu.location.f.h)object).a(n11, bl2, bl2);
            stringBuilder.append((String)object);
            stringBuilder.append("&aprk=0");
            return stringBuilder.toString();
        }
        Serializable serializable = new ArrayList();
        ArrayList<String> arrayList = new ArrayList<String>();
        int n12 = 0;
        while (true) {
            boolean bl3;
            string2 = "";
            if (n12 >= n10) break;
            Object object2 = ((ScanResult)object.a.get((int)n12)).BSSID;
            String string3 = ":";
            string2 = ((String)object2).replaceAll(string3, string2).toLowerCase();
            object2 = this.Q;
            if (object2 != null && (bl3 = ((com.baidu.location.indoor.a)object2).b(string2))) {
                string2 = ((com.baidu.location.f.h)object).a.get(n12);
                ((ArrayList)serializable).add(string2);
            } else {
                string2 = ((com.baidu.location.f.h)object).a.get(n12);
                arrayList.add(string2);
            }
            ++n12;
        }
        n10 = ((ArrayList)serializable).size();
        Object object3 = n10 > 0 ? "&aprk=3" : string2;
        n12 = (int)(((String)object3).equals(string2) ? 1 : 0);
        if (n12 != 0) {
            object3 = this.Q;
            object3 = object3 != null && (n10 = (int)(((com.baidu.location.indoor.a)object3).a() ? 1 : 0)) != 0 ? "&aprk=2" : "&aprk=1";
        }
        ((ArrayList)serializable).addAll(arrayList);
        ((com.baidu.location.f.h)object).a = serializable;
        n11 = this.e;
        object = ((com.baidu.location.f.h)object).a(n11, bl2, bl2);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append((String)object3);
        return ((StringBuilder)serializable).toString();
    }

    public static /* synthetic */ String a(g g10, com.baidu.location.f.h h10) {
        return g10.a(h10);
    }

    public static /* synthetic */ String a(g g10, String string2) {
        g10.R = string2;
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(Message object) {
        Object object2;
        int n10 = this.n;
        if (n10 == 0) {
            return;
        }
        n10 = 0;
        Object object3 = null;
        this.o = false;
        object = (BDLocation)((Message)object).obj;
        int n11 = ((BDLocation)object).getLocType();
        int n12 = 161;
        float f10 = 2.26E-43f;
        int n13 = 1;
        float f11 = Float.MIN_VALUE;
        if (n11 == n12) {
            float f12;
            Location location;
            String string2;
            String string3;
            this.l();
            object2 = ((BDLocation)object).getIndoorSurpportPolygon();
            if (object2 != null && (object2 = ((BDLocation)object).getIndoorLocationSurpportBuidlingID()) != null && ((object2 = this.y) == null || (n11 = (int)(((String)(object2 = ((l)object2).a())).equals(string3 = ((BDLocation)object).getBuildingID()) ? 1 : 0)) == 0)) {
                int n14;
                object2 = ((BDLocation)object).getIndoorSurpportPolygon().split("\\|");
                n12 = ((String[])object2).length;
                Location[] locationArray = new Location[n12];
                string2 = null;
                for (int i10 = 0; i10 < (n14 = ((Object)object2).length); ++i10) {
                    Object object4 = ((String)object2[i10]).split(",");
                    location = new Location("gps");
                    Double d10 = Double.valueOf(object4[n13]);
                    double d11 = d10;
                    location.setLatitude(d11);
                    object4 = Double.valueOf(object4[0]);
                    d11 = (Double)object4;
                    location.setLongitude(d11);
                    locationArray[i10] = location;
                }
                string2 = ((BDLocation)object).getIndoorLocationSurpportBuidlingID();
                this.y = object2 = new l(string2, locationArray);
            }
            n11 = (int)(this.L ? 1 : 0);
            n12 = 2;
            f10 = 2.8E-45f;
            if (n11 != 0 && (object2 = this.S) != null) {
                n11 = ((BDLocation)object).getIndoorLocationSource() >> n12 & n13;
                if (n11 == n13) {
                    n11 = n13;
                    f12 = f11;
                } else {
                    n11 = 0;
                    object2 = null;
                    f12 = 0.0f;
                }
                if (n11 != 0 && (n11 = (int)(((d)(object2 = this.S)).a() ? 1 : 0)) != 0) {
                    n11 = n13;
                    f12 = f11;
                } else {
                    n11 = 0;
                    object2 = null;
                    f12 = 0.0f;
                }
                if (n11 != 0) {
                    this.L = false;
                    object2 = this.S;
                    ((d)object2).b();
                }
            }
            this.r = 0;
            object2 = ((BDLocation)object).getBuildingID();
            if (object2 != null) {
                Object object5;
                double d12;
                double d13;
                double d14;
                boolean bl2;
                double d15;
                this.o = n13;
                ((BDLocation)object).setIndoorLocMode(n13 != 0);
                object2 = "tp";
                string2 = ((BDLocation)object).getRetFields((String)object2);
                if (string2 != null && (n11 = (int)(((String)(object2 = ((BDLocation)object).getRetFields((String)object2))).equalsIgnoreCase(string2 = "ble") ? 1 : 0)) != 0) {
                    n11 = 0x41000000;
                    f12 = 8.0f;
                    ((BDLocation)object).setRadius(f12);
                    ((BDLocation)object).setNetworkLocationType(string2);
                    this.T = n13;
                } else {
                    this.T = false;
                }
                object2 = ((BDLocation)object).getRetFields("pdr2");
                if (object2 != null && (n11 = (int)(((String)object2).equals(string2 = "1") ? 1 : 0)) != 0 && (object2 = this.j) != null) {
                    ((n)object2).a(n13 != 0);
                }
                this.x = object2 = ((BDLocation)object).getBuildingID();
                this.z = object2 = ((BDLocation)object).getBuildingName();
                this.B = object2 = ((BDLocation)object).getNetworkLocationType();
                this.C = n11 = ((BDLocation)object).isParkAvailable();
                g$b.a(this.af, (BDLocation)object);
                object2 = ((BDLocation)object).getFloor();
                string2 = this.k();
                n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n11 == 0) {
                    return;
                }
                object2 = this.w;
                if (object2 == null) {
                    this.w = object2 = ((BDLocation)object).getFloor();
                }
                object2 = com.baidu.location.indoor.mapversion.b.a.a();
                double d16 = ((BDLocation)object).getLongitude();
                double d17 = ((BDLocation)object).getLatitude();
                object2.a(d16, d17);
                object2 = ((BDLocation)object).getBuildingName();
                string2 = ((BDLocation)object).getFloor();
                this.a((String)object2, string2);
                object2 = ((BDLocation)object).getFloor();
                string2 = this.k();
                n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n11 == 0) {
                    return;
                }
                object2 = ((BDLocation)object).getFloor();
                n11 = (int)(((String)object2).equalsIgnoreCase(string2 = this.w) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(this.aa ? 1 : 0)) != 0) {
                    g$e.d(this.ad);
                    com.baidu.location.indoor.mapversion.a.a.c();
                    object2 = ((BDLocation)object).getFloor();
                    n11 = (int)(com.baidu.location.indoor.mapversion.a.a.a((String)object2) ? 1 : 0);
                    this.ab = n11;
                }
                this.w = object2 = ((BDLocation)object).getFloor();
                object2 = this.j;
                d16 = 0.0;
                if (object2 != null && (n11 = (int)((d15 = (d17 = ((n)object2).e()) - d16) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1))) >= 0) {
                    f12 = ((BDLocation)object).getDirection();
                    bl2 = false;
                    location = null;
                    float f13 = f12 - 0.0f;
                    n11 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
                    if (n11 <= 0) {
                        object2 = this.j;
                        d17 = ((n)object2).e();
                        f12 = (float)d17;
                        ((BDLocation)object).setDirection(f12);
                    }
                }
                if ((object2 = (Object)com.baidu.location.indoor.mapversion.a.a.a((BDLocation)object)) != null && (bl2 = (d14 = (d17 = (double)object2[0]) - (d13 = -1.0)) == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1)) && (n10 = (int)((d12 = (d17 = (double)object2[0]) - d16) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) == 0) {
                    Object object6 = object2[n13];
                    ((BDLocation)object).setLongitude((double)object6);
                    Object object7 = object2[n12];
                    ((BDLocation)object).setLatitude((double)object7);
                    object3 = "res";
                    ((BDLocation)object).setFusionLocInfo((String)object3, (double[])object2);
                    n10 = 5;
                    f10 = (float)object2[n10];
                    ((BDLocation)object).setRadius(f10);
                    f10 = (float)object2[6];
                    ((BDLocation)object).setDirection(f10);
                    n12 = 8;
                    object7 = object2[n12];
                    f10 = (float)object7;
                    ((BDLocation)object).setSpeed(f10);
                    g$e g$e = this.ad;
                    object5 = object2[n10];
                    String string4 = "wifi";
                    n10 = (int)(g$e.a(g$e, (BDLocation)object, object5, string4) ? 1 : 0);
                    if (n10 == 0) {
                        this.d();
                        return;
                    }
                }
                this.I = object5 = ((BDLocation)object).getLatitude();
                this.H = object5 = ((BDLocation)object).getLongitude();
            }
        } else {
            n11 = ((BDLocation)object).getLocType();
            n12 = 63;
            f10 = 8.8E-44f;
            if (n11 == n12) {
                this.r = n10 = this.r + n13;
                n11 = 10;
                float f14 = 1.4E-44f;
                if (n10 <= n11) return;
                this.d();
            } else {
                this.r = 0;
            }
        }
        if ((n10 = (int)(this.o ? 1 : 0)) != 0) {
            int n15;
            object3 = ((BDLocation)object).getTime();
            if (object3 == null) {
                object3 = new Date();
                object2 = this.b;
                object3 = ((DateFormat)object2).format((Date)object3);
                ((BDLocation)object).setTime((String)object3);
            }
            object3 = new BDLocation((BDLocation)object);
            object = ((BDLocation)object3).getNetworkLocationType();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("2");
            object = ((StringBuilder)object2).toString();
            ((BDLocation)object3).setNetworkLocationType((String)object);
            object = this.U;
            if (object != null && (n15 = (int)(((q)object).c() ? 1 : 0)) != 0) {
                object = this.U;
                ((q)object).a((BDLocation)object3);
            } else {
                n15 = 21;
                this.a((BDLocation)object3, n15);
            }
        }
        this.l.c();
    }

    private void a(BDLocation bDLocation) {
    }

    private void a(BDLocation object, int n10) {
        Object object2;
        if (object == null) {
            return;
        }
        Object object3 = object.getNetworkLocationType();
        String string2 = "vps";
        n10 = (int)(((String)object3).startsWith(string2) ? 1 : 0);
        int n11 = 1;
        if (n10 != 0) {
            double d10;
            double d11;
            double d12 = object.getLongitude();
            double d13 = d12 - (d11 = -1.0);
            n10 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
            if (n10 == 0 && (n10 = (int)((d10 = (d12 = object.getLatitude()) - d11) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1))) == 0) {
                n10 = -1;
                object.setUserIndoorState(n10);
            } else {
                object.setUserIndoorState(n11);
            }
            n10 = this.W;
            object.setIndoorNetworkState(n10);
            com.baidu.location.b.b.a().a((BDLocation)object);
            return;
        }
        object3 = this.X;
        if (object3 != null) {
            object3 = object.getAddrStr();
            if (object3 == null && (object3 = this.X.getAddrStr()) != null) {
                object3 = this.X.getAddress();
                object.setAddr((Address)object3);
                object3 = this.X.getAddrStr();
                object.setAddrStr((String)object3);
            }
            if ((object3 = object.getPoiList()) == null && (object3 = this.X.getPoiList()) != null) {
                object3 = this.X.getPoiList();
                object.setPoiList((List)object3);
            }
            if ((object3 = object.getPoiRegion()) == null && (object3 = this.X.getPoiRegion()) != null) {
                object2 = this.X.getPoiRegion();
                object3 = new PoiRegion((PoiRegion)object2);
                object.setPoiRegion((PoiRegion)object3);
            }
            if ((object3 = object.getLocationDescribe()) == null && (object3 = this.X.getLocationDescribe()) != null) {
                object3 = this.X.getLocationDescribe();
                object.setLocationDescribe((String)object3);
            }
            if ((object3 = object.getNrlResult()) == null) {
                object3 = this.X.getNrlResult();
                object.setNrlData((String)object3);
            }
        }
        if (object == null) {
            return;
        }
        object2 = Locale.US;
        String string3 = "yyyy-MM-dd HH:mm:ss";
        object3 = new SimpleDateFormat(string3, (Locale)object2);
        long l10 = System.currentTimeMillis();
        object2 = new Date(l10);
        object3 = ((DateFormat)object3).format((Date)object2);
        object.setTime((String)object3);
        object3 = object.getNetworkLocationType();
        object2 = "2";
        n10 = (int)(((String)object3).contains((CharSequence)object2) ? 1 : 0);
        if (n10 != 0) {
            float f10;
            object3 = object.getNetworkLocationType();
            object2 = null;
            int n12 = ((String)object3).length() - n11;
            object3 = ((String)object3).substring(0, n12);
            object.setNetworkLocationType((String)object3);
            object.setUserIndoorState(n11);
            n10 = this.W;
            object.setIndoorNetworkState(n10);
            com.baidu.location.b.b.a().a((BDLocation)object);
            object3 = new BDLocation((BDLocation)object);
            int n13 = this.T;
            if (n13 != 0) {
                n13 = 0x41000000;
                f10 = 8.0f;
            } else {
                n13 = 1097859072;
                f10 = 15.0f;
            }
            ((BDLocation)object3).setRadius(f10);
            object = this.a;
            n11 = 801;
            object = object.obtainMessage(n11);
            ((Message)object).obj = object3;
            object.sendToTarget();
        }
    }

    public static /* synthetic */ void a(g g10, Message message) {
        g10.a(message);
    }

    public static /* synthetic */ void a(g g10, BDLocation bDLocation) {
        g10.a(bDLocation);
    }

    public static /* synthetic */ void a(g g10, BDLocation bDLocation, int n10) {
        g10.a(bDLocation, n10);
    }

    private void a(String string2, String string3) {
        boolean bl2;
        String string4 = this.z;
        if (string4 != null && (bl2 = string4.equals(string2)) && (bl2 = this.aa)) {
            return;
        }
        string4 = com.baidu.location.indoor.mapversion.b.a.a();
        string4.a("gcj02");
        j j10 = new j(this, string2, string3);
        string4.a(string2, (a$c)j10);
    }

    public static /* synthetic */ boolean a(g g10, boolean bl2) {
        g10.aa = bl2;
        return bl2;
    }

    public static /* synthetic */ double b(g g10, double d10) {
        g10.I = d10;
        return d10;
    }

    public static /* synthetic */ long b(g g10, long l10) {
        g10.p = l10;
        return l10;
    }

    public static /* synthetic */ BDLocation b(g g10, BDLocation bDLocation) {
        g10.X = bDLocation;
        return bDLocation;
    }

    public static /* synthetic */ g$f b(g g10) {
        return g10.ae;
    }

    public static /* synthetic */ String b(g g10, int n10) {
        return g10.a(n10);
    }

    public static /* synthetic */ String b(g g10, String string2) {
        g10.A = string2;
        return string2;
    }

    public static /* synthetic */ boolean b(g g10, boolean bl2) {
        g10.ab = bl2;
        return bl2;
    }

    public static /* synthetic */ double c(g g10, double d10) {
        g10.H = d10;
        return d10;
    }

    public static /* synthetic */ int c(g g10, int n10) {
        g10.N = n10;
        return n10;
    }

    public static /* synthetic */ boolean c(g g10) {
        return g10.n;
    }

    public static /* synthetic */ boolean c(g g10, boolean bl2) {
        g10.i = bl2;
        return bl2;
    }

    public static /* synthetic */ int d(g g10, int n10) {
        g10.u = n10;
        return n10;
    }

    public static /* synthetic */ String d(g g10) {
        return g10.w;
    }

    public static /* synthetic */ boolean d(g g10, boolean bl2) {
        g10.K = bl2;
        return bl2;
    }

    public static /* synthetic */ List e(g g10) {
        return g10.M;
    }

    public static /* synthetic */ boolean e(g g10, boolean bl2) {
        g10.d = bl2;
        return bl2;
    }

    public static /* synthetic */ n f(g g10) {
        return g10.j;
    }

    public static /* synthetic */ int g(g g10) {
        int n10;
        int n11 = g10.u;
        g10.u = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ String h(g g10) {
        return g10.x;
    }

    public static /* synthetic */ String i(g g10) {
        return g10.z;
    }

    private void i() {
        double d10;
        boolean bl2;
        long l10;
        this.E.clear();
        this.G.clear();
        this.p = l10 = 0L;
        this.r = 0;
        this.C = 0;
        this.v = 0;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.L = bl2 = true;
        this.J = 0.4;
        this.T = false;
        this.H = d10 = 0.0;
        this.I = d10;
        this.K = false;
        this.O = 0;
        this.u = 0;
        this.s = null;
        this.q = l10;
        Object object = this.ad;
        g$e.d((g$e)object);
        com.baidu.location.indoor.mapversion.a.a.c();
        boolean bl3 = this.aa;
        if (bl3) {
            object = com.baidu.location.indoor.mapversion.b.a.a();
            object.b();
        }
        this.ab = false;
        this.aa = false;
        com.baidu.location.b.s.a().b(false);
        object = this.S;
        if (object != null) {
            ((d)object).c();
        }
    }

    public static /* synthetic */ int j(g g10) {
        return g10.C;
    }

    private void j() {
        boolean bl2 = this.n;
        if (bl2) {
            long l10;
            this.i = bl2 = true;
            g$e.f(this.ad);
            g$i g$i = this.l;
            g$i.a();
            this.m = l10 = System.currentTimeMillis();
        }
    }

    /*
     * Exception decompiling
     */
    private String k() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [27[UNCONDITIONALDOLOOP]], but top level block is 13[TRYBLOCK]
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

    public static /* synthetic */ boolean k(g g10) {
        return g10.T;
    }

    public static /* synthetic */ q l(g g10) {
        return g10.U;
    }

    private void l() {
        List list;
        int n10;
        for (int i10 = this.N; i10 >= 0 && (n10 = (list = this.M).size()) > 0; i10 += -1) {
            list = this.M;
            list.remove(0);
        }
        this.N = -1;
    }

    public static /* synthetic */ void m(g g10) {
        g10.j();
    }

    public static /* synthetic */ int n(g g10) {
        return g10.c;
    }

    public static /* synthetic */ boolean o(g g10) {
        return g10.d;
    }

    public static /* synthetic */ long p(g g10) {
        return g10.h;
    }

    public static /* synthetic */ long q(g g10) {
        return g10.q;
    }

    public static /* synthetic */ l r(g g10) {
        return g10.y;
    }

    public static /* synthetic */ com.baidu.location.indoor.a s(g g10) {
        return g10.Q;
    }

    public static /* synthetic */ d t(g g10) {
        return g10.S;
    }

    public static /* synthetic */ com.baidu.location.indoor.c u(g g10) {
        return g10.E;
    }

    public static /* synthetic */ int v(g g10) {
        int n10;
        int n11 = g10.r;
        g10.r = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int w(g g10) {
        return g10.r;
    }

    public static /* synthetic */ int x(g g10) {
        return g10.e;
    }

    public static /* synthetic */ int y(g g10) {
        return g10.O;
    }

    public static /* synthetic */ int z(g g10) {
        int n10;
        int n11 = g10.O;
        g10.O = n10 = n11 + 1;
        return n11;
    }

    public boolean a(double d10, double d11) {
        Object object = com.baidu.location.indoor.mapversion.b.c.a();
        boolean bl2 = ((c)object).c();
        if (bl2 && (bl2 = ((c)object).b())) {
            boolean bl3;
            if ((object = ((c)object).d()) == null) {
                return false;
            }
            bl2 = false;
            String string2 = null;
            Iterator iterator2 = object.keySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                double d12;
                double d13;
                double d14;
                Object object2 = (String)iterator2.next();
                object2 = (c$b)object.get(object2);
                double d15 = ((c$b)object2).e;
                double d16 = d10 - d15;
                Object object3 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
                if (object3 <= 0 || (object3 = (d14 = d10 - (d15 = ((c$b)object2).c)) == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1)) >= 0 || (object3 = (d13 = d11 - (d15 = ((c$b)object2).f)) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1)) <= 0 || (object3 = (d12 = d11 - (d15 = ((c$b)object2).d)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) >= 0) continue;
                string2 = ((c$b)object2).a;
                break;
            }
            if (string2 != null) {
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean a(Location var1_1, ArrayList var2_2) {
        block75: {
            block70: {
                block74: {
                    block73: {
                        block72: {
                            block71: {
                                block69: {
                                    block68: {
                                        var3_3 = this;
                                        var4_4 = "gps";
                                        var5_5 = var2_2.size();
                                        var6_6 = 0;
                                        var7_7 = 0.0f;
                                        var8_8 = null;
                                        if (var5_5 == 0 || (var5_5 = (int)(var9_9 = com.baidu.location.f.f.a()).k()) == 0) break block75;
                                        var5_5 = (int)this.n;
                                        if (var5_5 == 0) {
                                            var10_10 = var1_1.getSpeed();
                                            var11_11 = 0x40400000;
                                            var12_12 = 3.0f;
                                            cfr_temp_0 = var10_10 - var12_12;
                                            var5_5 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                            if (var5_5 > 0) {
                                                return false;
                                            }
                                        }
                                        var13_13 /* !! */  = var1_1.getLongitude();
                                        var15_14 /* !! */  = var1_1.getLatitude();
                                        var9_9 = Jni.coorEncrypt(var13_13 /* !! */ , var15_14 /* !! */ , "gps2gcj");
                                        var17_15 = var9_9[0];
                                        var19_16 = 1;
                                        var20_17 = 1.4E-45f;
                                        var21_18 /* !! */  = var9_9[var19_16];
                                        var23_19 /* !! */  = var1_1.getAccuracy();
                                        var25_20 /* !! */  = var1_1.getBearing();
                                        var27_21 = var1_1.getAltitude();
                                        var10_10 = var1_1.getSpeed();
                                        var29_22 = var10_10;
                                        var5_5 = (int)var3_3.a((double)var17_15, (double)var21_18 /* !! */ );
                                        if (var5_5 == 0 && (var5_5 = var3_3.c) != var19_16) {
                                            var5_5 = 0;
                                            var10_10 = 0.0f;
                                            var9_9 = null;
                                        } else {
                                            var5_5 = var19_16;
                                            var10_10 = var20_17;
                                        }
                                        var19_16 = (int)var3_3.n;
                                        if (var19_16 == 0 && var5_5 == 0) {
                                            return false;
                                        }
                                        var31_23 = var3_3.ad;
                                        var32_24 = var29_22;
                                        var8_8 = var1_1;
                                        g$e.a(var31_23, var1_1, (boolean)var5_5);
                                        var9_9 = var3_3.ad;
                                        var5_5 = g$e.c((g$e)var9_9);
                                        if (var5_5 == 0) break block68;
                                        this.c();
                                        return true;
                                    }
                                    var5_5 = this.e();
                                    if (var5_5 != 0) break block69;
                                    return false;
                                }
                                var34_25 = var3_3.ad;
                                var35_26 = var29_22;
                                var32_24 = var27_21;
                                var27_21 = (double)var17_15;
                                var37_27 = var25_20 /* !! */ ;
                                var25_20 /* !! */  = (double)var21_18 /* !! */ ;
                                var39_28 /* !! */  = var23_19 /* !! */ ;
                                var11_11 = (int)g$e.a((g$e)var34_25, (double)var17_15, (double)var21_18 /* !! */ , var23_19 /* !! */ );
                                if (var11_11 == 0) ** GOTO lbl72
                                com.baidu.location.indoor.mapversion.a.a.c();
lbl72:
                                // 2 sources

                                var34_25 = var3_3.ac;
                                var27_21 = var39_28 /* !! */ ;
                                var25_20 /* !! */  = (double)var17_15;
                                var23_19 /* !! */  = (double)var21_18 /* !! */ ;
                                var39_28 /* !! */  = (double)var21_18 /* !! */ ;
                                var21_18 /* !! */  = var32_24;
                                var41_29 = var34_25.a(var27_21, (double)var17_15, var23_19 /* !! */ , var32_24);
                                var13_13 /* !! */  = (double)var17_15;
                                var15_14 /* !! */  = var23_19 /* !! */ ;
                                var34_25 = com.baidu.location.indoor.mapversion.a.a.a((double)var17_15, var23_19 /* !! */ , var41_29, var37_27, var35_26);
                                if (var34_25 == null) break block70;
                                var43_30 = false;
                                var44_31 = null;
                                var15_14 /* !! */  = (double)var34_25[0];
                                var41_29 = -1.0;
                                var45_32 = var15_14 /* !! */  == var41_29 ? 0 : (var15_14 /* !! */  > var41_29 ? 1 : -1);
                                if (var45_32 == false) break block70;
                                var15_14 /* !! */  = (double)var34_25[0];
                                var41_29 = 0.0;
                                var43_30 = var15_14 /* !! */  == var41_29 ? 0 : (var15_14 /* !! */  > var41_29 ? 1 : -1);
                                if (var43_30) break block70;
                                var44_31 = new BDLocation();
                                var15_14 /* !! */  = var32_24;
                                var44_31.setAltitude(var32_24);
                                var45_32 = 2;
                                var46_33 = 2.8E-45f;
                                var15_14 /* !! */  = (double)var34_25[var45_32];
                                var44_31.setLatitude(var15_14 /* !! */ );
                                var45_32 = (double)true;
                                var46_33 = 1.4E-45f;
                                var25_20 /* !! */  = (double)var34_25[var45_32];
                                var44_31.setLongitude(var25_20 /* !! */ );
                                var45_32 = (double)var3_3.T;
                                if (var45_32 == false) break block71;
                                var45_32 = 0x41000000;
                                var46_33 = 8.0f;
                                var44_31.setRadius(var46_33);
                                break block72;
                            }
                            var45_32 = 1097859072;
                            var46_33 = 15.0f;
                            var44_31.setRadius(var46_33);
                        }
                        var15_14 /* !! */  = var37_27;
                        var46_33 = (float)var37_27;
                        var44_31.setDirection(var46_33);
                        var10_10 = (float)var35_26;
                        var44_31.setSpeed(var10_10);
                        var5_5 = 161;
                        var10_10 = 2.26E-43f;
                        var44_31.setLocType(var5_5);
                        var44_31.setNetworkLocationType(var4_4);
                        var47_34 = System.currentTimeMillis();
                        var49_35 = var3_3.ad;
                        var50_36 = g$e.a((g$e)var49_35);
                        var47_34 -= var50_36;
                        var50_36 = 20000L;
                        var15_14 /* !! */  = 9.8813E-320;
                        var5_5 = (int)(var47_34 == var50_36 ? 0 : (var47_34 < var50_36 ? -1 : 1));
                        if (var5_5 < 0) {
                            var9_9 = var3_3.w;
                            var44_31.setFloor((String)var9_9);
                            var9_9 = var3_3.z;
                            var44_31.setBuildingName((String)var9_9);
                            var9_9 = var3_3.x;
                        } else {
                            var5_5 = 0;
                            var10_10 = 0.0f;
                            var9_9 = null;
                            var44_31.setFloor(null);
                            var44_31.setBuildingName(null);
                        }
                        var44_31.setBuildingID((String)var9_9);
                        var5_5 = 1;
                        var10_10 = 1.4E-45f;
                        var44_31.setIndoorLocMode((boolean)var5_5);
                        var35_26 = var44_31.getLatitude();
                        var3_3.I = var35_26;
                        var35_26 = var44_31.getLongitude();
                        var3_3.H = var35_26;
                        var9_9 = "res";
                        var44_31.setFusionLocInfo((String)var9_9, (double[])var34_25);
                        var5_5 = 5;
                        var10_10 = 7.0E-45f;
                        var15_14 /* !! */  = (double)var34_25[var5_5];
                        var7_7 = (float)var15_14 /* !! */ ;
                        var44_31.setRadius(var7_7);
                        var6_6 = 6;
                        var7_7 = 8.4E-45f;
                        var15_14 /* !! */  = (double)var34_25[var6_6];
                        var7_7 = (float)var15_14 /* !! */ ;
                        var44_31.setDirection(var7_7);
                        var6_6 = 8;
                        var7_7 = 1.1E-44f;
                        var15_14 /* !! */  = (double)var34_25[var6_6];
                        var7_7 = (float)var15_14 /* !! */ ;
                        var44_31.setSpeed(var7_7);
                        var8_8 = new Date();
                        var49_35 = var3_3.b;
                        var8_8 = var49_35.format((Date)var8_8);
                        var44_31.setTime((String)var8_8);
                        var8_8 = new BDLocation(var44_31);
                        var49_35 = var8_8.getNetworkLocationType();
                        var52_37 = new StringBuilder();
                        var52_37.append((String)var49_35);
                        var49_35 = "2";
                        var52_37.append((String)var49_35);
                        var49_35 = var52_37.toString();
                        var8_8.setNetworkLocationType((String)var49_35);
                        var49_35 = var3_3.U;
                        if (var49_35 == null) break block73;
                        var45_32 = (double)var49_35.c();
                        if (var45_32 == false) break block73;
                        var49_35 = var3_3.U;
                        var49_35.a((BDLocation)var8_8);
                        ** GOTO lbl239
                    }
                    var45_32 = 21;
                    var46_33 = 2.9E-44f;
                    var3_3.a((BDLocation)var8_8, (int)var45_32);
lbl239:
                    // 2 sources

                    var8_8 = var3_3.ad;
                    var15_14 /* !! */  = (double)var34_25[var5_5];
                    var53_38 = g$e.a((g$e)var8_8, var44_31, var15_14 /* !! */ , var4_4);
                    if (var53_38) break block74;
                    try {
                        this.d();
                    }
                    catch (Exception v1) {
                        var53_38 = false;
                        var4_4 = null;
                    }
                }
                return true;
            }
            return false;
            catch (Exception v0) {
                var53_39 = false;
                var4_4 = null;
            }
            return false;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        int n10;
        if (bundle == null) {
            return false;
        }
        this.c = n10 = bundle.getInt("mode");
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            boolean bl2 = this.n;
            if (bl2) {
                com.baidu.location.indoor.c c10 = this.E;
                c10.clear();
            }
            return;
        }
    }

    public void c() {
        synchronized (this) {
            boolean bl2;
            block16: {
                bl2 = this.n;
                if (!bl2) break block16;
                return;
            }
            com.baidu.location.indoor.mapversion.a.a.b();
            long l10 = System.currentTimeMillis();
            this.p = l10;
            l10 = System.currentTimeMillis();
            this.q = l10;
            Object object = this.j;
            ((n)object).a();
            object = new g$g(this);
            this.k = object;
            ((Thread)object).start();
            bl2 = false;
            object = null;
            this.o = false;
            boolean bl3 = true;
            this.n = bl3;
            Object object2 = com.baidu.location.f.getServiceContext();
            object2 = com.baidu.location.indoor.d.a(object2);
            this.S = object2;
            this.O = 0;
            this.u = 0;
            object = com.baidu.location.b.s.a();
            ((s)object).b(bl3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        synchronized (this) {
            boolean bl2;
            boolean bl3 = this.n;
            if (!bl3) {
                return;
            }
            bl3 = false;
            b b10 = null;
            this.n = false;
            Object object = this.j;
            ((n)object).b();
            object = this.U;
            if (object != null && (bl2 = ((q)object).c())) {
                object = this.U;
                ((q)object).a();
            }
            if ((object = this.Q) != null) {
                ((com.baidu.location.indoor.a)object).c();
            }
            if ((object = this.S) != null) {
                ((d)object).d();
            }
            if ((object = this.k) != null) {
                g$g.a((g$g)object, false);
                object = this.k;
                ((Thread)object).interrupt();
                bl2 = false;
                object = null;
                this.k = null;
            }
            this.i();
            this.o = false;
            b10 = com.baidu.location.b.b.a();
            b10.c();
            return;
        }
    }

    public boolean e() {
        return this.n;
    }

    public boolean f() {
        g$e g$e;
        boolean bl2 = this.n;
        if (bl2 && (bl2 = g$e.e(g$e = this.ad))) {
            bl2 = true;
        } else {
            bl2 = false;
            g$e = null;
        }
        return bl2;
    }

    public String g() {
        return this.w;
    }

    public String h() {
        return this.x;
    }
}

