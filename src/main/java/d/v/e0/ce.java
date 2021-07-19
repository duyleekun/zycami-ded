/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package d.v.e0;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.core.util.Pair;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleClient$State;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.zhishen.imagetool.Helper;
import com.zhiyun.protocol.constants.CameraManufacturer;
import com.zhiyun.protocol.constants.ConnectionMethod;
import com.zhiyun.protocol.constants.DebugMode;
import com.zhiyun.protocol.constants.FunctionEvent;
import com.zhiyun.protocol.constants.IMUControlMode;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.constants.PowerMode;
import com.zhiyun.protocol.constants.Strength;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.core.entities.Functions;
import com.zhiyun.protocol.core.entities.StrengthLimit;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import com.zhiyun.protocol.message.bl.other.OtherStatus;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.protocol.message.bl.otherevent.DeviceType;
import com.zhiyun.protocol.message.bl.otherevent.MoveLineStatus;
import com.zhiyun.protocol.message.bl.wifi.device.CameraBrand;
import com.zhiyun.protocol.message.bl.wifi.device.PhotoInfoNumber;
import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import com.zhiyun.protocol.message.usb.command.Flag;
import com.zhiyun.protocol.message.usb.command.UsbStatus;
import com.zhiyun.protocol.utils.Axis;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.Stabilizer$f;
import com.zhiyun.stabilizer.Stabilizer$g;
import com.zhiyun.stabilizer.Stabilizer$h;
import com.zhiyun.stabilizer.Stabilizer$j;
import com.zhiyun.stabilizer.Stabilizer$k;
import com.zhiyun.stabilizer.Stabilizer$l;
import com.zhiyun.stabilizer.entities.PathShot;
import com.zhiyun.stabilizer.entities.StoryAxis;
import com.zhiyun.stabilizer.exception.StabilizerDisconnectionException;
import com.zhiyun.stabilizer.exception.UnsupportedException;
import d.n.a.d0;
import d.n.a.d0$a;
import d.n.a.j0;
import d.n.a.r0.b$b;
import d.n.a.r0.e$b;
import d.v.e0.a1;
import d.v.e0.a7;
import d.v.e0.a8;
import d.v.e0.a9;
import d.v.e0.aa;
import d.v.e0.ab;
import d.v.e0.ae;
import d.v.e0.b7;
import d.v.e0.b8;
import d.v.e0.b9;
import d.v.e0.ba;
import d.v.e0.be;
import d.v.e0.c;
import d.v.e0.c1;
import d.v.e0.c7;
import d.v.e0.c8;
import d.v.e0.c9;
import d.v.e0.ca;
import d.v.e0.ce$a;
import d.v.e0.ce$a0;
import d.v.e0.ce$a1;
import d.v.e0.ce$a2;
import d.v.e0.ce$b;
import d.v.e0.ce$b0;
import d.v.e0.ce$b1;
import d.v.e0.ce$b2;
import d.v.e0.ce$c;
import d.v.e0.ce$c0;
import d.v.e0.ce$c1;
import d.v.e0.ce$c2;
import d.v.e0.ce$d;
import d.v.e0.ce$d0;
import d.v.e0.ce$d1;
import d.v.e0.ce$d2;
import d.v.e0.ce$e;
import d.v.e0.ce$e0;
import d.v.e0.ce$e1;
import d.v.e0.ce$e2;
import d.v.e0.ce$f;
import d.v.e0.ce$f0;
import d.v.e0.ce$f1;
import d.v.e0.ce$f2;
import d.v.e0.ce$g;
import d.v.e0.ce$g0;
import d.v.e0.ce$g1;
import d.v.e0.ce$g2;
import d.v.e0.ce$h;
import d.v.e0.ce$h0;
import d.v.e0.ce$h1;
import d.v.e0.ce$h2;
import d.v.e0.ce$i;
import d.v.e0.ce$i0;
import d.v.e0.ce$i1;
import d.v.e0.ce$i2;
import d.v.e0.ce$j;
import d.v.e0.ce$j0;
import d.v.e0.ce$j1;
import d.v.e0.ce$j2;
import d.v.e0.ce$k;
import d.v.e0.ce$k0;
import d.v.e0.ce$k1;
import d.v.e0.ce$l;
import d.v.e0.ce$l0;
import d.v.e0.ce$l1;
import d.v.e0.ce$m;
import d.v.e0.ce$m0;
import d.v.e0.ce$m1;
import d.v.e0.ce$n;
import d.v.e0.ce$n0;
import d.v.e0.ce$n1;
import d.v.e0.ce$o;
import d.v.e0.ce$o0;
import d.v.e0.ce$o1;
import d.v.e0.ce$p;
import d.v.e0.ce$p0;
import d.v.e0.ce$p1;
import d.v.e0.ce$q;
import d.v.e0.ce$q0;
import d.v.e0.ce$q1;
import d.v.e0.ce$r;
import d.v.e0.ce$r0;
import d.v.e0.ce$r1;
import d.v.e0.ce$s;
import d.v.e0.ce$s0;
import d.v.e0.ce$s1;
import d.v.e0.ce$t;
import d.v.e0.ce$t0;
import d.v.e0.ce$t1;
import d.v.e0.ce$u;
import d.v.e0.ce$u0;
import d.v.e0.ce$u1;
import d.v.e0.ce$v;
import d.v.e0.ce$v0;
import d.v.e0.ce$v1;
import d.v.e0.ce$w;
import d.v.e0.ce$w0;
import d.v.e0.ce$w1;
import d.v.e0.ce$x;
import d.v.e0.ce$x0;
import d.v.e0.ce$x1;
import d.v.e0.ce$y;
import d.v.e0.ce$y0;
import d.v.e0.ce$y1;
import d.v.e0.ce$z;
import d.v.e0.ce$z0;
import d.v.e0.ce$z1;
import d.v.e0.d7;
import d.v.e0.d8;
import d.v.e0.d9;
import d.v.e0.da;
import d.v.e0.de;
import d.v.e0.e;
import d.v.e0.e7;
import d.v.e0.e8;
import d.v.e0.e9;
import d.v.e0.ea;
import d.v.e0.ed;
import d.v.e0.f7;
import d.v.e0.f8;
import d.v.e0.f9;
import d.v.e0.fa;
import d.v.e0.g7;
import d.v.e0.g8;
import d.v.e0.g9;
import d.v.e0.ga;
import d.v.e0.ge;
import d.v.e0.h0;
import d.v.e0.h7;
import d.v.e0.h8;
import d.v.e0.h9;
import d.v.e0.ha;
import d.v.e0.hd;
import d.v.e0.i7;
import d.v.e0.i8;
import d.v.e0.i9;
import d.v.e0.ia;
import d.v.e0.ie.d;
import d.v.e0.ie.g;
import d.v.e0.ie.j;
import d.v.e0.ie.l;
import d.v.e0.j7;
import d.v.e0.j8;
import d.v.e0.j9;
import d.v.e0.ja;
import d.v.e0.k7;
import d.v.e0.k8;
import d.v.e0.k9;
import d.v.e0.ka;
import d.v.e0.kd;
import d.v.e0.ke.b;
import d.v.e0.ke.f;
import d.v.e0.l8;
import d.v.e0.l9;
import d.v.e0.la;
import d.v.e0.m0;
import d.v.e0.m7;
import d.v.e0.m8;
import d.v.e0.m9;
import d.v.e0.ma;
import d.v.e0.n7;
import d.v.e0.n8;
import d.v.e0.n9;
import d.v.e0.na;
import d.v.e0.o7;
import d.v.e0.o8;
import d.v.e0.o9;
import d.v.e0.oa;
import d.v.e0.oc;
import d.v.e0.od;
import d.v.e0.oe.q;
import d.v.e0.p0;
import d.v.e0.p8;
import d.v.e0.p9;
import d.v.e0.pa;
import d.v.e0.pc;
import d.v.e0.q0;
import d.v.e0.q8;
import d.v.e0.q9;
import d.v.e0.qa;
import d.v.e0.r7;
import d.v.e0.r8;
import d.v.e0.r9;
import d.v.e0.ra;
import d.v.e0.s7;
import d.v.e0.s8;
import d.v.e0.s9;
import d.v.e0.sa;
import d.v.e0.t7;
import d.v.e0.t8;
import d.v.e0.t9;
import d.v.e0.ta;
import d.v.e0.td;
import d.v.e0.u6;
import d.v.e0.u7;
import d.v.e0.u8;
import d.v.e0.u9;
import d.v.e0.ua;
import d.v.e0.uc;
import d.v.e0.v6;
import d.v.e0.v8;
import d.v.e0.v9;
import d.v.e0.va;
import d.v.e0.vd;
import d.v.e0.w6;
import d.v.e0.w7;
import d.v.e0.w8;
import d.v.e0.w9;
import d.v.e0.wa;
import d.v.e0.wb;
import d.v.e0.x6;
import d.v.e0.x7;
import d.v.e0.x8;
import d.v.e0.x9;
import d.v.e0.xa;
import d.v.e0.xb;
import d.v.e0.xc;
import d.v.e0.y7;
import d.v.e0.y8;
import d.v.e0.y9;
import d.v.e0.ya;
import d.v.e0.yb;
import d.v.e0.yc;
import d.v.e0.yd;
import d.v.e0.z0;
import d.v.e0.z6;
import d.v.e0.z7;
import d.v.e0.z8;
import d.v.e0.z9;
import d.v.e0.za;
import d.v.e0.zc;
import d.v.e0.zd;
import d.v.y.d.k;
import e.a.c0;
import e.a.e0;
import e.a.g0;
import e.a.i0;
import e.a.q0.c.a;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ce {
    private static final int p = 1289;
    private static final String q = "Hi-";
    private final List a;
    private final de b;
    private final Stabilizer c;
    private e.a.s0.b d;
    private Context e;
    private RxBleClient f;
    private Stabilizer g;
    private d.v.e0.oe.l h;
    private d.v.e0.oe.l i;
    private Stabilizer j;
    private Stabilizer k;
    private Stabilizer l;
    private volatile boolean m;
    private List n;
    private LruCache o;

    static {
        Helper.a();
    }

    public ce() {
        Object object = new CopyOnWriteArrayList();
        this.a = object;
        this.b = object = new de();
        Model model = Model.COV_01;
        this.c = object = new Stabilizer(model, true);
        object = new ArrayList();
        this.n = object;
        this.o = object = new LruCache(15);
    }

    private z A() {
        Object object = this.X0();
        Object object2 = e9.a;
        object = ((i0)object).k0((o)object2);
        object2 = TimeUnit.MILLISECONDS;
        return ((z)object).E1(300L, (TimeUnit)((Object)object2));
    }

    public static boolean A1() {
        boolean bl2;
        Stabilizer stabilizer = ce.E0().g;
        if (stabilizer != null && (bl2 = (stabilizer = ce.E0().g).t3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    private /* synthetic */ e0 A2(Float f10) {
        return this.g.l();
    }

    private /* synthetic */ e0 A3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.b;
        return ((Stabilizer)object).E0(n10);
    }

    private /* synthetic */ boolean A4(Model[] modelArray, Stabilizer stabilizer) {
        return this.t5(stabilizer, modelArray);
    }

    private void B() {
        z z10 = this.A();
        i8 i82 = i8.a;
        n9 n92 = n9.a;
        z10.c(i82, n92);
    }

    private z C() {
        Object object;
        Object object2 = this.g.H2();
        if (object2 == (object = Model.SMOOTH4)) {
            object2 = this.g.I1().Z0();
            object = a8.a;
            return ((z)object2).H3((o)object);
        }
        return z.t3(Boolean.TRUE);
    }

    private /* synthetic */ e0 C2(Float f10) {
        return this.g.H0();
    }

    private /* synthetic */ e0 C3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.c;
        return ((Stabilizer)object).G(n10);
    }

    private /* synthetic */ boolean C4(boolean bl2, Stabilizer stabilizer) {
        return this.u5(stabilizer, bl2);
    }

    private void D(Throwable serializable, j j10) {
        boolean bl2 = serializable instanceof BleScanException;
        if (bl2) {
            int n10;
            Throwable throwable = serializable;
            throwable = (BleScanException)serializable;
            int n11 = ((BleScanException)throwable).getReason();
            if (n11 != (n10 = 1)) {
                n10 = 2;
                if (n11 != n10) {
                    n10 = 3;
                    if (n11 != n10) {
                        n10 = 4;
                        if (n11 != n10) {
                            n10 = 0x7FFFFFFE;
                            if (n11 != n10) {
                                j10.onFailed((Throwable)serializable);
                            } else {
                                serializable = ((BleScanException)throwable).getRetryDateSuggestion();
                                j10.h((Date)serializable);
                            }
                        } else {
                            j10.i();
                        }
                    } else {
                        j10.r();
                    }
                } else {
                    j10.q();
                }
            } else {
                j10.n();
            }
        } else {
            j10.onFailed((Throwable)serializable);
        }
    }

    public static ce E0() {
        return ce$j2.a();
    }

    public static /* synthetic */ zd E2(zd zd2, ae ae2) {
        return zd2;
    }

    private /* synthetic */ e0 E3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.d;
        return ((Stabilizer)object).T0(n10);
    }

    private /* synthetic */ void E4(boolean bl2) {
        if (bl2) {
            this.B();
        }
    }

    private boolean F(d.v.e0.ie.c c10) {
        boolean bl2 = ce.A1();
        if (bl2) {
            return true;
        }
        if (c10 != null) {
            StabilizerDisconnectionException stabilizerDisconnectionException = new StabilizerDisconnectionException();
            c10.onFailed(stabilizerDisconnectionException);
        }
        return false;
    }

    public static /* synthetic */ void F2(l l10, Throwable throwable) {
        if (l10 != null) {
            l10.onFailed(throwable);
        }
    }

    public static int G0() {
        Model model = ce.E0().y0().b;
        int[] nArray = ce$g2.a;
        int n10 = model.ordinal();
        int n11 = 5;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 6;
            if (n10 != n11) {
                return 0;
            }
            return 4;
        }
        return 2;
    }

    public static /* synthetic */ e0 G2(Float object) {
        float f10;
        float f11 = ((Float)object).floatValue();
        float f12 = f11 - (f10 = 1.0f);
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            object = z.t3(object);
        } else {
            String string2 = "get version failed!!";
            object = new InvalidParameterException(string2);
            object = z.m2((Throwable)object);
        }
        return object;
    }

    private /* synthetic */ e0 G3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.e;
        return ((Stabilizer)object).V0(n10);
    }

    public static /* synthetic */ e0 G4(List object, g g10, int n10, List list, Stabilizer stabilizer) {
        object = z.W2((Iterable)object);
        ha ha2 = new ha(stabilizer, g10, n10, list);
        return ((z)object).T0(ha2);
    }

    private /* synthetic */ Boolean H2(Float f10) {
        Stabilizer stabilizer;
        float f11;
        float f12 = f10.floatValue();
        float f13 = f12 - (f11 = (stabilizer = this.g).t2());
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f12 = Float.MIN_VALUE;
        } else {
            object = false;
            f12 = 0.0f;
            f10 = null;
        }
        return (boolean)object;
    }

    public static /* synthetic */ void H4(g g10, Boolean bl2) {
        g10.d();
    }

    private z I() {
        return this.g.H1(0);
    }

    public static boolean I1() {
        boolean bl2;
        Stabilizer stabilizer = ce.E0().g;
        if (stabilizer != null && (bl2 = stabilizer.H3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    private /* synthetic */ e0 I3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.f;
        return ((Stabilizer)object).t1(n10);
    }

    private /* synthetic */ e0 I4(Boolean bl2) {
        return this.A();
    }

    private void J() {
        de de2 = this.b;
        List<String> list = Collections.singletonList("connect");
        de2.e(list);
    }

    private boolean J1(WifiStatus wifiStatus) {
        boolean bl2;
        WifiStatus wifiStatus2 = WifiStatus.CONNECTED_AND_SCANNING;
        if (wifiStatus != wifiStatus2 && wifiStatus != (wifiStatus2 = WifiStatus.CONNECTED)) {
            bl2 = false;
            wifiStatus = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ e.a.q J2(ce ce2, j0 j02) {
        return ce2.e5(j02);
    }

    private boolean K1(WifiStatus wifiStatus) {
        boolean bl2;
        WifiStatus wifiStatus2 = WifiStatus.CONNECTED_AND_SCANNING;
        if (wifiStatus != wifiStatus2 && wifiStatus != (wifiStatus2 = WifiStatus.SCANNING)) {
            bl2 = false;
            wifiStatus = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ boolean K2(int[] nArray, WifiStatus wifiStatus) {
        int n10;
        int n11;
        WifiStatus wifiStatus2 = WifiStatus.CONNECTED;
        boolean bl2 = false;
        if (wifiStatus == wifiStatus2 || (n11 = nArray[0]) >= (n10 = 3)) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ e0 K3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.g;
        return ((Stabilizer)object).g(n10);
    }

    public static /* synthetic */ List K4(List list, Stabilizer stabilizer) {
        return list;
    }

    private void K5(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.d7(n10);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public static /* synthetic */ boolean L2(WifiStatus wifiStatus) {
        boolean bl2;
        WifiStatus wifiStatus2 = WifiStatus.CONNECTING;
        if (wifiStatus == wifiStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            wifiStatus = null;
        }
        return bl2;
    }

    private /* synthetic */ e0 L4(String string2, List list) {
        return this.Z4(list, string2);
    }

    private static boolean M1(d.n.a.r0.d object) {
        boolean bl2;
        object = ((d.n.a.r0.d)object).d();
        int n10 = 1289;
        if ((object = (Object)object.b(n10)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ void M2(int[] nArray, WifiStatus wifiStatus) {
        int n10;
        nArray[0] = n10 = nArray[0] + 1;
    }

    private /* synthetic */ e0 M3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.h;
        return ((Stabilizer)object).R(n10);
    }

    private void M5(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.e7(n10);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public static /* synthetic */ boolean N1(ce ce2, WifiStatus wifiStatus) {
        return ce2.K1(wifiStatus);
    }

    private /* synthetic */ boolean N2(int[] nArray, WifiStatus wifiStatus) {
        int n10;
        int n11 = this.K1(wifiStatus);
        boolean bl2 = false;
        if (n11 != 0 || (n10 = nArray[0]) >= (n11 = 2)) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void N4(g g10) {
        this.B();
        g10.onCancel();
    }

    public static /* synthetic */ z O1(ce ce2, int n10) {
        return ce2.b5(n10);
    }

    private /* synthetic */ e0 O3(zd zd2, Boolean object) {
        object = this.g;
        int n10 = zd2.i;
        return ((Stabilizer)object).R0(n10);
    }

    private void O5(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.f7(n10);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    private List O7(List object) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            String string3 = (String)object.next();
            boolean bl3 = string3.startsWith(string2 = "GP");
            if (!bl3 || (bl3 = arrayList.contains(string3))) continue;
            arrayList.add(string3);
        }
        return arrayList;
    }

    private static Stabilizer P(j0 j02) {
        Object object = j02.getName();
        boolean bl2 = d.v.y.d.k.a((String)object);
        if (!bl2) {
            return null;
        }
        object = ((String)object).toLowerCase();
        for (Model model : Model.values()) {
            Object object2 = model.getFunctions();
            int n10 = ((Functions)object2).bleHid;
            int n11 = 1;
            if (n10 != n11 || (n10 = (int)(((String)object).startsWith((String)(object2 = model.getHidName())) ? 1 : 0)) == 0) continue;
            object = new Stabilizer(j02, model);
            return object;
        }
        return null;
    }

    public static /* synthetic */ e.a.q P1(ce ce2, d.n.a.r0.d d10) {
        return ce2.v5(d10);
    }

    private /* synthetic */ e0 P2(Boolean bl2) {
        return this.a0().U4(2);
    }

    private /* synthetic */ void P4(Throwable throwable) {
        this.B();
    }

    private z P7(boolean bl2, short s10, byte[] object) {
        z z10 = z.t3(Boolean.TRUE);
        Object object2 = e.a.c1.b.d();
        z10 = z10.i4((e.a.h0)object2);
        object2 = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object2);
        object2 = new ce$a2(this, (byte[])object, s10);
        object = z10.s2((o)object2);
        long l10 = bl2 ? 0L : (long)100;
        Object object3 = TimeUnit.MILLISECONDS;
        object3 = ((z)object).E1(l10, (TimeUnit)((Object)object3));
        object = new ce$z1(this, s10);
        return ((z)object3).s2((o)object).U4(3);
    }

    private z Q() {
        return this.g.y(0);
    }

    public static /* synthetic */ Integer Q1(Integer n10, Boolean bl2) {
        return n10;
    }

    private /* synthetic */ e0 Q3(zd zd2, Boolean object) {
        object = this.g;
        float f10 = zd2.j;
        return ((Stabilizer)object).X(f10);
    }

    public static /* synthetic */ e0 R1(z z10, Integer n10) {
        return z10;
    }

    private /* synthetic */ e0 R2(Boolean bl2) {
        return this.I().U4(2);
    }

    public static /* synthetic */ void R4(g g10, e.a.s0.b b10) {
        g10.onStart();
    }

    public static /* synthetic */ e0 S1(Stabilizer stabilizer) {
        Object object = new Axis(0.0f, 0.0f, 0.0f);
        object = stabilizer.D7((Axis)object, 0L);
        b8 b82 = new b8(stabilizer);
        return ((z)object).H3(b82);
    }

    private /* synthetic */ e0 S3(zd zd2, Boolean object) {
        object = this.g;
        float f10 = zd2.k;
        return ((Stabilizer)object).l0(f10);
    }

    public static /* synthetic */ void S4(String string2) {
        d.v.e0.oe.q.f("takePanorama: ");
    }

    public static /* synthetic */ void T1(Stabilizer stabilizer) {
    }

    private /* synthetic */ e0 T2(yd yd2, Boolean object) {
        object = this.g;
        int n10 = yd2.c();
        return ((Stabilizer)object).t0(n10).U4(2);
    }

    public static /* synthetic */ void T4(ce ce2, d.v.y.b.a a10) {
        ce2.X(a10);
    }

    public static /* synthetic */ void U1(Throwable throwable) {
    }

    private /* synthetic */ e0 U3(zd zd2, Boolean object) {
        object = this.g;
        float f10 = zd2.l;
        return ((Stabilizer)object).D0(f10);
    }

    private void U4() {
        Object object = this.y0();
        boolean bl2 = ((td)object).h();
        if (!bl2) {
            return;
        }
        object = this.g.T6();
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new ta(this);
        xc xc2 = xc.a;
        object = ((z)object).c((e.a.v0.g)object2, xc2);
        this.b.f("button", (e.a.s0.b)object);
    }

    public static /* synthetic */ Boolean V1(Object object) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 V2(yd yd2, Boolean object) {
        object = this.g;
        float f10 = yd2.a();
        return ((Stabilizer)object).Z0(f10).U4(2);
    }

    private z V4() {
        int[] nArray = new int[1];
        Object object = TimeUnit.SECONDS;
        object = z.n3(2, (TimeUnit)((Object)object));
        Object object2 = new ce$k0(this);
        object = ((z)object).T0((o)object2);
        object2 = new ce$j0(this, nArray);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = new d9(nArray);
        return ((z)object).o2((r)object2).b6(1L);
    }

    public static /* synthetic */ Boolean W1(UsbStatus usbStatus) {
        boolean bl2;
        UsbStatus usbStatus2 = UsbStatus.MEDIA_ENABLE;
        if (usbStatus == usbStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            usbStatus = null;
        }
        return bl2;
    }

    private /* synthetic */ e0 W3(zd object, Boolean object2) {
        object2 = this.g;
        object = ((zd)object).m;
        return ((Stabilizer)object2).x1((ae)object);
    }

    private z W4() {
        Object object = TimeUnit.MILLISECONDS;
        object = z.n3(200L, (TimeUnit)((Object)object));
        Object object2 = new ce$i0(this);
        object = ((z)object).T0((o)object2);
        object2 = f7.a;
        object = ((z)object).o2((r)object2).b6(1L);
        object2 = new ce$h0(this);
        return ((z)object).H3((o)object2);
    }

    private void X(d.v.y.b.a a10) {
        vd vd2 = vd.z;
        Model model = this.g.H2();
        vd2.c(model, a10);
    }

    public static /* synthetic */ void X1(Boolean bl2) {
    }

    private /* synthetic */ e0 X2(yd yd2, Boolean object) {
        object = this.g;
        float f10 = yd2.b();
        return ((Stabilizer)object).V(f10).U4(2);
    }

    private z X4() {
        Object object = TimeUnit.MILLISECONDS;
        object = z.n3(200L, (TimeUnit)((Object)object));
        Object object2 = new ce$d0(this);
        object = ((z)object).s2((o)object2);
        object2 = new ce$c0(this);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = new w7(this);
        return ((z)object).o2((r)object2).b6(1L);
    }

    private void Y(Throwable throwable) {
        boolean bl2;
        d.v.e0.oe.q.d("doOnConnectionError", throwable);
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            d.v.e0.ie.b b10 = (d.v.e0.ie.b)iterator2.next();
            Stabilizer stabilizer = this.g;
            b10.c(throwable, stabilizer);
        }
    }

    private z Y0(int n10) {
        int n11 = 1;
        if (n10 <= 0) {
            n10 = n11;
        }
        z z10 = z.u4(n11, n10);
        Object object = new ce$f0(this);
        z10 = z10.T0((o)object);
        object = z0.a;
        return z10.f2((e.a.v0.g)object).I(n10);
    }

    public static /* synthetic */ void Y1(Throwable throwable) {
    }

    public static /* synthetic */ e.a.g Y3(int n10, Stabilizer stabilizer) {
        return stabilizer.A7(n10);
    }

    private z Y4() {
        int[] nArray = new int[1];
        Object object = TimeUnit.SECONDS;
        long l10 = 1L;
        object = z.n3(l10, (TimeUnit)((Object)object));
        Object object2 = new ce$e0(this);
        object = ((z)object).T0((o)object2);
        object2 = new ia(nArray);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = new e7(this, nArray);
        return ((z)object).o2((r)object2).b6(l10);
    }

    private void Y6(Stabilizer stabilizer, boolean bl2) {
        if (stabilizer != null) {
            stabilizer.C7(bl2);
        }
    }

    private void Z(boolean bl2) {
        if (bl2) {
            boolean bl3;
            Iterator iterator2 = this.a.iterator();
            while (bl3 = iterator2.hasNext()) {
                d.v.e0.ie.b b10 = (d.v.e0.ie.b)iterator2.next();
                Stabilizer stabilizer = this.g;
                b10.b(stabilizer);
            }
        } else {
            boolean bl4;
            Iterator iterator3 = this.a.iterator();
            while (bl4 = iterator3.hasNext()) {
                d.v.e0.ie.b b11 = (d.v.e0.ie.b)iterator3.next();
                Stabilizer stabilizer = this.g;
                b11.d(stabilizer);
            }
        }
    }

    public static /* synthetic */ Boolean Z1(UsbStatus usbStatus) {
        boolean bl2;
        UsbStatus usbStatus2 = UsbStatus.MEDIA_ENABLE;
        if (usbStatus != usbStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            usbStatus = null;
        }
        return bl2;
    }

    private /* synthetic */ e0 Z2(yd yd2, Boolean object) {
        object = this.g;
        float f10 = yd2.d();
        return ((Stabilizer)object).o1(f10).U4(2);
    }

    public static /* synthetic */ void Z3(l l10) {
        l10.call(null);
    }

    private z Z4(List list, String string2) {
        ce$f2 ce$f2 = new ce$f2(this, list, string2);
        return z.y1(ce$f2);
    }

    private z Z6() {
        z z10 = this.g.c();
        ce$y1 ce$y1 = new ce$y1(this);
        return z10.s2(ce$y1);
    }

    public static /* synthetic */ boolean a(ce ce2) {
        return ce2.m;
    }

    private z a0() {
        return this.g.y(1);
    }

    public static /* synthetic */ Boolean a2(Object object) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 a4(Boolean bl2) {
        return this.g.o0();
    }

    private z a5(yd object) {
        boolean bl2 = this.m;
        if (bl2) {
            return z.t3(Boolean.TRUE);
        }
        Object object2 = this.Z6().U4(2);
        o o10 = new a7(this);
        object2 = ((z)object2).T0(o10);
        o10 = new u9(this);
        object2 = ((z)object2).T0(o10);
        o10 = new m7(this, (yd)object);
        object2 = ((z)object2).T0(o10);
        o10 = new z7(this, (yd)object);
        object2 = ((z)object2).T0(o10);
        o10 = new r7(this, (yd)object);
        object2 = ((z)object2).T0(o10);
        o10 = new k9(this, (yd)object);
        object = ((z)object2).T0(o10);
        object2 = new ca(this);
        object = ((z)object).T0((o)object2);
        object2 = ya.a;
        object = ((z)object).T0((o)object2);
        object2 = new y8(this);
        object = ((z)object).T0((o)object2);
        object2 = new ja(this);
        object = ((z)object).o2((r)object2).b6(1L);
        object2 = new wa(this);
        return ((z)object).T0((o)object2);
    }

    public static /* synthetic */ boolean b(ce ce2, boolean bl2) {
        ce2.m = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean b2(WorkingMode workingMode, Boolean bl2) {
        boolean bl3;
        if (workingMode != null) {
            bl3 = true;
        } else {
            bl3 = false;
            workingMode = null;
        }
        return bl3;
    }

    private /* synthetic */ e0 b3(Boolean bl2) {
        return this.l7().U4(2);
    }

    private z b5(int n10) {
        ce$n0 ce$n0 = new ce$n0(this, n10);
        return z.y1(ce$n0);
    }

    public static /* synthetic */ e.a.s0.b c(ce ce2, e.a.s0.b b10) {
        ce2.d = b10;
        return b10;
    }

    public static /* synthetic */ boolean c2(d.n.a.r0.d d10) {
        return ce.M1(d10);
    }

    public static /* synthetic */ boolean c4(OtherStatus otherStatus) {
        boolean bl2;
        OtherStatus otherStatus2 = OtherStatus.NONE_ERROR;
        if (otherStatus2 == otherStatus) {
            bl2 = true;
        } else {
            bl2 = false;
            otherStatus = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private z c5(boolean bl2, d d10) {
        Object object;
        if (bl2) {
            void var2_3;
            object = new ce$w1(this, (d)var2_3);
            object = z.y1((c0)object);
        } else {
            int n10 = -1;
            object = z.t3(n10);
        }
        return object;
    }

    public static /* synthetic */ z d(ce ce2, yd yd2) {
        return ce2.a5(yd2);
    }

    private /* synthetic */ td d2(Float f10, String string2) {
        String string3 = this.g.M2();
        String string4 = this.g.F2();
        Model model = this.g.H2();
        Model model2 = this.g.w2();
        float f11 = this.g.f3();
        float f12 = f10.floatValue();
        td td2 = new td(f12, string3, string4, model, model2, string2, f11);
        return td2;
    }

    public static /* synthetic */ e0 d3(Boolean object) {
        object = TimeUnit.MILLISECONDS;
        return z.n3(300L, (TimeUnit)((Object)object));
    }

    private /* synthetic */ e0 d4(boolean[] blArray, d d10, OtherStatus otherStatus) {
        boolean bl2 = blArray[0];
        return this.x(bl2, d10);
    }

    private z d5() {
        return this.g.H1(3);
    }

    public static /* synthetic */ void e(ce ce2, Runnable runnable) {
        ce2.q5(runnable);
    }

    private /* synthetic */ e0 e3(Long l10) {
        return this.g.n0().U4(2);
    }

    private e.a.q e5(j0 object) {
        Object object2;
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.getName())))) {
            object2 = this.o;
            Object object3 = object.e();
            if ((object2 = (Stabilizer)((LruCache)object2).get(object3)) != null) {
                return e.a.q.B0(object2);
            }
            object2 = ce.P((j0)object);
            if (object2 != null) {
                object3 = this.o;
                object = object.e();
                ((LruCache)object3).put(object, object2);
                return e.a.q.B0(object2);
            }
            return e.a.q.d0();
        }
        return e.a.q.d0();
    }

    public static /* synthetic */ z f(ce ce2, boolean bl2) {
        return ce2.p5(bl2);
    }

    public static /* synthetic */ Pair f2(List list) {
        Object e10 = list.get(0);
        list = list.get(1);
        return Pair.create(e10, list);
    }

    private /* synthetic */ void f4(e.a.s0.b b10) {
        this.R();
    }

    private Model f7(byte[] byArray) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 2)) {
            Model model;
            n11 = 1;
            n10 = byArray[n11] << 8;
            int n12 = 0;
            byte by2 = byArray[0];
            Model model2 = Model.from(n10 |= by2);
            if (model2 == (model = Model.UNKNOWN)) {
                n10 = byArray[0] << 8;
                n11 = byArray[n11] | n10;
                model2 = Model.from(n11);
            }
            if ((n11 = byArray.length) >= (n12 = 5)) {
                n11 = byArray[4] << 8;
                n12 = 3;
                int n13 = byArray[n12] | n11;
                model2.setOemSerial(n13);
            }
            return model2;
        }
        return Model.UNKNOWN;
    }

    public static /* synthetic */ z g(ce ce2, int n10) {
        return ce2.Y0(n10);
    }

    private z g0() {
        Object object;
        Object object2 = this.g.H2();
        if (object2 == (object = Model.SMOOTH4)) {
            object2 = this.g.s0().Z0();
            object = u8.a;
            return ((z)object2).H3((o)object);
        }
        return z.t3(Boolean.TRUE);
    }

    private /* synthetic */ e0 g2(Integer n10) {
        return this.g.K0();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ boolean g3(Integer n10) {
        int n11 = this.m;
        if (n11 != 0) return 1 != 0;
        int n12 = n10;
        n11 = 2;
        if ((n12 = (int)(ge.e(n12, n11) ? 1 : 0)) == 0) return 0 != 0;
        return 1 != 0;
    }

    public static /* synthetic */ z h(ce ce2) {
        return ce2.Y4();
    }

    private void h0(WorkingMode object) {
        Object object2 = z.t3(Boolean.TRUE);
        Object object3 = new ce$n1(this);
        object2 = ((z)object2).s2((o)object3);
        object3 = new c9((WorkingMode)((Object)object));
        object2 = ((z)object2).o2((r)object3);
        object3 = new ce$c1(this, (WorkingMode)((Object)object));
        object = ((z)object2).s2((o)object3);
        object2 = new ce$r0(this);
        object = ((z)object).s2((o)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = new ce$g0(this);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public static /* synthetic */ void h4(WorkingMode[] workingModeArray, WorkingMode workingMode) {
        workingModeArray[0] = workingMode;
    }

    public static /* synthetic */ z i(ce ce2) {
        return ce2.X4();
    }

    private /* synthetic */ e0 i2(Integer n10) {
        return this.g.k1();
    }

    private /* synthetic */ e0 i3(Integer n10) {
        return this.Q().U4(2);
    }

    private /* synthetic */ e0 i4(WorkingMode workingMode) {
        return this.C();
    }

    public static /* synthetic */ z j(ce ce2) {
        return ce2.V4();
    }

    public static /* synthetic */ z k(ce ce2) {
        return ce2.W4();
    }

    private RxBleClient k0() {
        return this.f;
    }

    private /* synthetic */ e0 k2(Integer n10) {
        return this.g.E1();
    }

    public static /* synthetic */ void k3(g g10, int n10, Boolean bl2) {
        g10.c(n10);
    }

    private /* synthetic */ e0 k4(boolean bl2, Boolean bl3) {
        return this.p5(bl2);
    }

    public static /* synthetic */ boolean l(ce ce2, WifiStatus wifiStatus) {
        return ce2.J1(wifiStatus);
    }

    public static /* synthetic */ void l3(List list, g g10, Boolean bl2) {
        g10 = g10.b();
        list.add(g10);
    }

    private z l7() {
        return this.g.H1(1);
    }

    public static /* synthetic */ void m(ce ce2, Throwable throwable, j j10) {
        ce2.D(throwable, j10);
    }

    private /* synthetic */ e0 m2(Integer n10) {
        return this.g.N0();
    }

    public static /* synthetic */ e0 m3(Stabilizer object, g g10, int n10, List list, Axis object2) {
        long l10 = object2.duration;
        object = ((Stabilizer)object).D7((Axis)object2, l10);
        object2 = TimeUnit.SECONDS;
        object = ((z)object).E1(1L, (TimeUnit)((Object)object2));
        r8 r82 = new r8(g10, n10);
        object = ((z)object).f2(r82);
        l10 = n10;
        object = ((z)object).E1(l10, (TimeUnit)((Object)object2));
        o8 o82 = new o8(list, g10);
        return ((z)object).f2(o82);
    }

    public static /* synthetic */ List m4(long l10, List list, Boolean bl2) {
        return ge.c(l10, list);
    }

    public static /* synthetic */ z n(ce ce2, boolean bl2, short s10, byte[] byArray) {
        return ce2.P7(bl2, s10, byArray);
    }

    public static /* synthetic */ Stabilizer n3(Stabilizer stabilizer, Boolean bl2) {
        return stabilizer;
    }

    private /* synthetic */ boolean n4(List list) {
        return this.m ^ true;
    }

    public static /* synthetic */ void o(ce ce2) {
        ce2.U4();
    }

    private /* synthetic */ e0 o2(Integer n10) {
        return this.g.K();
    }

    public static /* synthetic */ Boolean o3(UsbStatus usbStatus) {
        boolean bl2;
        UsbStatus usbStatus2 = UsbStatus.MEDIA_ENABLE;
        if (usbStatus == usbStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            usbStatus = null;
        }
        return bl2;
    }

    public static /* synthetic */ void p(ce ce2, boolean bl2) {
        ce2.Z(bl2);
    }

    private z p1() {
        int[] nArray = ce$g2.a;
        Model model = this.g.w2();
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2) && n11 != (n10 = 3) && n11 != (n10 = 4)) {
            return this.g.c();
        }
        return z.t3((Object)WorkingMode.PF);
    }

    public static /* synthetic */ boolean p3(Integer n10) {
        int n11 = n10;
        if (!n11) {
            n11 = 1;
        } else {
            n11 = 0;
            n10 = null;
        }
        return n11 != 0;
    }

    private /* synthetic */ void p4(WorkingMode[] object) {
        object = object[0];
        this.h0((WorkingMode)((Object)object));
    }

    private z p5(boolean bl2) {
        int n10 = ce.A1();
        if (n10 == 0) {
            return z.t3(Boolean.FALSE);
        }
        if (!bl2) {
            return z.t3(Boolean.TRUE);
        }
        Object object = this.g;
        int n11 = ((Stabilizer)object).R2();
        if (n11 == (n10 = 1)) {
            object = this.g;
            FunctionEvent workingMode = FunctionEvent.BACK_CENTER;
            return ((Stabilizer)object).C(workingMode);
        }
        object = this.g;
        WorkingMode workingMode = WorkingMode.L;
        object = ((Stabilizer)object).j0(workingMode);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return ((z)object).E1(1500L, timeUnit);
    }

    public static /* synthetic */ void q(ce ce2, Throwable throwable) {
        ce2.Y(throwable);
    }

    private /* synthetic */ e0 q2(Integer n10) {
        return this.g.e();
    }

    public static /* synthetic */ Boolean q3(Integer n10) {
        return Boolean.TRUE;
    }

    private void q5(Runnable runnable) {
        Looper looper;
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = Looper.getMainLooper())) {
            runnable.run();
        } else {
            looper = Looper.getMainLooper();
            looper2 = new Handler(looper);
            looper2.post(runnable);
        }
    }

    public static /* synthetic */ z r(ce ce2) {
        return ce2.g0();
    }

    public static /* synthetic */ Boolean r3(Boolean bl2, Boolean bl3) {
        boolean bl4 = bl2;
        boolean bl5 = bl3;
        return bl4 & bl5;
    }

    private /* synthetic */ e0 r4(PathShot object, Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            object = this.w5((PathShot)object);
        } else {
            object = new UnsupportedException();
            object = z.m2((Throwable)object);
        }
        return object;
    }

    public static /* synthetic */ Stabilizer s(ce ce2) {
        return ce2.g;
    }

    private /* synthetic */ e0 s2(Integer n10) {
        return this.g.O();
    }

    private /* synthetic */ e0 s3(int n10, Boolean bl2) {
        return this.g.u1(n10);
    }

    private z s5() {
        return this.g.H1(2);
    }

    public static /* synthetic */ z t(ce ce2) {
        return ce2.d5();
    }

    public static /* synthetic */ void t4(d.v.e0.ie.f f10, Throwable throwable) {
        boolean bl2 = throwable instanceof UnsupportedException;
        if (bl2) {
            f10.d();
        } else {
            f10.onFailed(throwable);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean t5(Stabilizer stabilizer, Model ... modelArray) {
        synchronized (this) {
            int n10;
            void var2_2;
            boolean bl2 = true;
            if (var2_2 == null || (n10 = ((void)var2_2).length) <= 0) {
                return bl2;
            }
            n10 = ((void)var2_2).length;
            int n11 = 0;
            while (n11 < n10) {
                void var6_6 = var2_2[n11];
                Model model = stabilizer.H2();
                if (model == var6_6) {
                    return bl2;
                }
                ++n11;
            }
            return false;
        }
    }

    public static /* synthetic */ de u(ce ce2) {
        return ce2.b;
    }

    private /* synthetic */ e0 u2(Integer n10) {
        return this.g.E();
    }

    private /* synthetic */ e0 u3(int n10, Boolean bl2) {
        return this.g.x(n10);
    }

    public static /* synthetic */ void u4(d.v.e0.ie.f f10) {
        d.v.e0.oe.q.j("Offline completed");
        f10.a();
    }

    private boolean u5(Stabilizer stabilizer, boolean bl2) {
        int n10;
        boolean bl3 = true;
        if (bl2 && !(bl2 = stabilizer.z3()) && (n10 = stabilizer.N2()) <= 0) {
            bl3 = false;
        }
        return bl3;
    }

    private /* synthetic */ RxBleClient v4(Long l10) {
        return this.k0();
    }

    private e.a.q v5(d.n.a.r0.d object) {
        Object object2 = ((d.n.a.r0.d)object).d();
        Object object3 = ((d.n.a.r0.d)object).a();
        Object object4 = this.o;
        String string2 = object3.e();
        if ((object4 = (Stabilizer)((LruCache)object4).get(string2)) != null) {
            int n10 = ((d.n.a.r0.d)object).c();
            ((Stabilizer)object4).y7(n10);
            return e.a.q.B0(object4);
        }
        object4 = object3.getName();
        boolean bl2 = ((String)object4).startsWith(string2 = q);
        if (bl2) {
            object2 = ce.P((j0)object3);
        } else {
            int n11 = 1289;
            object2 = object2.b(n11);
            object2 = this.f7((byte[])object2);
            object4 = ((d.n.a.r0.d)object).a();
            object2 = object3 = new Stabilizer((j0)object4, (Model)((Object)object2));
        }
        if (object2 != null) {
            int n12 = ((d.n.a.r0.d)object).c();
            ((Stabilizer)object2).y7(n12);
            object = this.o;
            object3 = ((Stabilizer)object2).F2();
            ((LruCache)object).put(object3, object2);
        }
        if (object2 == null) {
            return e.a.q.d0();
        }
        return e.a.q.B0(object2);
    }

    private /* synthetic */ e0 w2(Integer n10) {
        return this.g.C1();
    }

    private /* synthetic */ e0 w3(float f10, Boolean bl2) {
        return this.g.p7(f10);
    }

    private z w5(PathShot object) {
        z z10 = this.b5(0);
        Object object2 = o9.a;
        z10 = z10.o2((r)object2);
        object2 = TimeUnit.SECONDS;
        z10 = z10.E6(10, (TimeUnit)((Object)object2));
        object2 = ba.a;
        z10 = z10.H3((o)object2).b6(1L);
        object = this.g.v7((PathShot)object);
        object2 = d7.a;
        return z.W7(z10, (e0)object, (e.a.v0.c)object2);
    }

    private z x(boolean bl2, d object) {
        d.v.e0.oe.q.i("AppGO");
        Object object2 = this.g.L1();
        Object object3 = Boolean.TRUE;
        object2 = ((z)object2).p4(object3);
        z z10 = this.c5(bl2, (d)object);
        object = z10.b6(1L);
        object3 = va.a;
        object = z.W7((e0)object, (e0)object2, (e.a.v0.c)object3);
        object2 = new h7(z10);
        return ((z)object).s2((o)object2);
    }

    public static /* synthetic */ e0 x4(d.n.a.r0.e e10, d.n.a.r0.b b10, RxBleClient rxBleClient) {
        d.n.a.r0.b[] bArray = new d.n.a.r0.b[]{b10};
        return rxBleClient.i(e10, bArray);
    }

    private /* synthetic */ e0 y2(Float f10) {
        return this.g.Y();
    }

    private /* synthetic */ e0 y3(float f10, Boolean bl2) {
        return this.g.r7(f10);
    }

    public static /* synthetic */ e0 y4(z z10, RxBleClient$State state) {
        return z10;
    }

    public static boolean z1() {
        boolean bl2;
        Stabilizer stabilizer = ce.E0().l;
        if (stabilizer != null && (bl2 = (stabilizer = ce.E0().l).o3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean z4(Stabilizer stabilizer) {
        return stabilizer.o3() ^ true;
    }

    public void A0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.f0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void A5(boolean bl2, l l10) {
        boolean bl3 = this.F(l10);
        if (!bl3) {
            return;
        }
        Object object = this.g;
        short s10 = 129;
        Object object2 = bl2 ? "1" : "0";
        object2 = ((Stabilizer)object).q0(s10, (String)object2);
        object = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object);
        object = new d.v.e0.me.e(l10);
        object2 = (e.a.s0.b)((Object)((z)object2).i((g0)object));
    }

    public void A6(int n10, l l10) {
        int n11 = this.F(l10);
        if (n11 != 0) {
            n11 = 2048;
            this.U5(n10, n11, n11, l10);
        }
    }

    public void A7() {
        this.z7();
    }

    public void B0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.W();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void B1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.d1();
        Object object2 = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object2);
        object2 = s7.a;
        z10 = z10.s2((o)object2);
        object2 = new s9(this);
        z10 = z10.H3((o)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
        this.b.f("force_upgrade", (e.a.s0.b)object);
    }

    public /* synthetic */ e0 B2(Float f10) {
        return this.A2(f10);
    }

    public /* synthetic */ e0 B3(zd zd2, Boolean bl2) {
        return this.A3(zd2, bl2);
    }

    public /* synthetic */ boolean B4(Model[] modelArray, Stabilizer stabilizer) {
        return this.A4(modelArray, stabilizer);
    }

    public void B5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)9, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void B6(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.p(n10);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void B7() {
        this.b.d("take_panorama");
    }

    public void C0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.e0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public boolean C1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).y3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public void C5(int n10, String object, String string2, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        Object object2 = ",";
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append(string2);
        object2 = stringBuilder.toString();
        object2 = this.g.q0((short)128, (String)object2);
        object = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object);
        object = new d.v.e0.me.e(l10);
        object2 = (e.a.s0.b)((Object)((z)object2).i((g0)object));
    }

    public void C6(PowerMode object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            object = this.g.g0((PowerMode)((Object)object));
            Object object3 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_power_mode";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void C7() {
        e.a.s0.b b10 = this.d;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.d = null;
        }
    }

    public void D0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.x0();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_imu_control_register";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public boolean D1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).A3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public /* synthetic */ e0 D2(Float f10) {
        return this.C2(f10);
    }

    public /* synthetic */ e0 D3(zd zd2, Boolean bl2) {
        return this.C3(zd2, bl2);
    }

    public /* synthetic */ boolean D4(boolean bl2, Stabilizer stabilizer) {
        return this.C4(bl2, stabilizer);
    }

    public void D5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)3, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void D6(Stabilizer$j stabilizer$j) {
        be.m().L(stabilizer$j);
    }

    public void D7(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.m0(false);
        d.v.e0.me.e e10 = new d.v.e0.me.e((l)object);
        object = (e.a.s0.b)((Object)z10.i(e10));
        this.b.d("start_scan_wifi");
        this.b.f("stop_scan_wifi", (e.a.s0.b)object);
    }

    public void E() {
        this.b.d("FIRMWARE_UPGRADE");
    }

    public boolean E1() {
        boolean bl2 = ce.A1();
        if (!bl2) {
            return false;
        }
        return this.g.u3();
    }

    public void E5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)0, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void E6(b b10) {
        vd.z.l = b10;
    }

    public void E7() {
        this.b.d("story_moving");
    }

    public void F0(int n10, int n11, int n12, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.Y2(n10, n11, n12);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public boolean F1() {
        return this.H0().isEmpty() ^ true;
    }

    public /* synthetic */ e0 F3(zd zd2, Boolean bl2) {
        return this.E3(zd2, bl2);
    }

    public /* synthetic */ void F4(boolean bl2) {
        this.E4(bl2);
    }

    public void F5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)7, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void F6(b b10) {
        vd.z.e = b10;
    }

    public void F7() {
        d.v.e0.oe.l l10 = this.i;
        if (l10 != null) {
            l10.t();
            l10 = null;
            this.i = null;
        }
    }

    public void G(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.u();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public boolean G1() {
        boolean bl2 = ce.A1();
        if (bl2) {
            return this.g.G3();
        }
        return false;
    }

    public void G5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)5, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void G6(int n10, l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = new yd();
            float f10 = n10;
            ((yd)object2).g(f10);
            Object object3 = this.a5((yd)object2);
            object2 = e.a.q0.c.a.c();
            object3 = ((z)object3).i4((e.a.h0)object2);
            object2 = new d.v.e0.me.e((l)object);
            object3 = (e.a.s0.b)((Object)((z)object3).i((g0)object2));
            object = this.b;
            object2 = "set_roll_angle";
            ((de)object).f((String)object2, (e.a.s0.b)object3);
        }
    }

    public void G7(String string2, long l10, List list, g g10) {
        this.H7(true, string2, l10, list, g10);
    }

    public void H(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.t((String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public List H0() {
        boolean bl2 = ce.A1();
        if (!bl2) {
            return Collections.emptyList();
        }
        return this.g.z2();
    }

    public boolean H1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).F3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public /* synthetic */ e0 H3(zd zd2, Boolean bl2) {
        return this.G3(zd2, bl2);
    }

    public void H5(Stabilizer$f stabilizer$f) {
        be.m().H(stabilizer$f);
    }

    public void H6(int n10, l l10) {
        int n11 = this.F(l10);
        if (n11 != 0) {
            n11 = 2048;
            this.U5(n11, n10, n11, l10);
        }
    }

    public void H7(boolean bl2, String string2, long l10, List list, g g10) {
        ArrayList arrayList = new ArrayList();
        int[] nArray = new int[1];
        ce$c ce$c = new ce$c(this, g10, nArray, arrayList, list, string2);
        this.o7(bl2, 0L, l10, list, ce$c);
    }

    public void I0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.p1();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ Boolean I2(Float f10) {
        return this.H2(f10);
    }

    public void I5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)2, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void I6(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.i(n10);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void I7(List object, String object2, int n10, g g10) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(object2);
        Objects.requireNonNull(g10);
        Object object3 = new ArrayList();
        z z10 = this.A();
        b7 b72 = new b7((List)object, g10, n10, (List)object3);
        object = z10.T0(b72).e6(1);
        Object object4 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object4);
        object4 = new ab(g10);
        object = ((z)object).f2((e.a.v0.g)object4);
        object4 = e.a.c1.b.d();
        object = ((z)object).i4((e.a.h0)object4);
        object4 = new d8(this);
        object = ((z)object).s2((o)object4);
        object4 = new pa((List)object3);
        object = ((z)object).H3((o)object4);
        object4 = new t9(this, (String)object2);
        object = ((z)object).s2((o)object4);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new ra(this, g10);
        object = ((z)object).Z1((e.a.v0.a)object2);
        object2 = new r9(this);
        object = ((z)object).d2((e.a.v0.g)object2);
        object2 = new v9(g10);
        object = ((z)object).g2((e.a.v0.g)object2);
        object2 = p8.a;
        g10.getClass();
        object4 = new ed(g10);
        g10.getClass();
        object3 = new p0(g10);
        object = ((z)object).f((e.a.v0.g)object2, (e.a.v0.g)object4, (e.a.v0.a)object3);
        this.b.f("take_panorama", (e.a.s0.b)object);
    }

    public void J0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.T();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 J3(zd zd2, Boolean bl2) {
        return this.I3(zd2, bl2);
    }

    public /* synthetic */ e0 J4(Boolean bl2) {
        return this.I4(bl2);
    }

    public void J5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)8, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void J6(zd object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            Object object3 = this.g;
            int n10 = ((zd)object).a;
            object3 = ((Stabilizer)object3).J0(n10);
            o o10 = new da(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new p9(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new x7(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new x6(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new ma(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new j9(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new na(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new n8(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new q9(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new y7(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new z9(this, (zd)object);
            object3 = ((z)object3).s2(o10);
            o10 = new l9(this, (zd)object);
            object = ((z)object3).s2(o10);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_scene";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void J7(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.b();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "take_photo";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void K(Stabilizer stabilizer) {
        this.l = stabilizer;
        this.g = stabilizer;
        Context context = this.e;
        ce$v ce$v = new ce$v(this);
        stabilizer.U1(context, ce$v);
    }

    public void K0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.C2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void K6(b b10) {
        vd.z.q = b10;
    }

    public void K7(float f10) {
        d.v.e0.oe.l l10 = this.h;
        if (l10 != null) {
            l10.u(f10);
        }
    }

    public void L(String object, String object2, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        z z10 = this.g.m0(false);
        o o10 = new ce$w(this);
        z10 = z10.T0(o10);
        o10 = new ce$u(this, (String)object);
        z10 = z10.T0(o10);
        o10 = new ce$t(this);
        z10 = z10.T0(o10);
        o10 = new ce$s(this, (String)object, (String)object2);
        object = z10.T0(o10);
        object2 = new ce$r(this);
        object = ((z)object).T0((o)object2);
        object2 = new ce$q(this);
        object = ((z)object).T0((o)object2);
        object2 = TimeUnit.SECONDS;
        object = ((z)object).E1(4, (TimeUnit)((Object)object2));
        object2 = new ce$p(this);
        object = ((z)object).T0((o)object2);
        object2 = new ce$o(this);
        object = ((z)object).T0((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void L0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.D2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void L1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            z z10 = this.g.o0();
            Object object2 = e.a.q0.c.a.c();
            z10 = z10.i4((e.a.h0)object2);
            object2 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)z10.i((g0)object2));
        }
    }

    public /* synthetic */ e0 L3(zd zd2, Boolean bl2) {
        return this.K3(zd2, bl2);
    }

    public void L5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)13, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void L6(f f10) {
        vd.z.w = f10;
    }

    public void L7(float f10, float f11) {
        d.v.e0.oe.l l10 = this.h;
        if (l10 != null) {
            l10.v(f10, f11);
        }
    }

    public ce M() {
        Stabilizer stabilizer = ce$j2.a().l;
        if (stabilizer != null) {
            stabilizer = stabilizer.X1();
            return this.N(stabilizer);
        }
        return this;
    }

    public void M0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.E2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 M4(String string2, List list) {
        return this.L4(string2, list);
    }

    public void M6(f f10) {
        vd.z.u = f10;
    }

    public void M7(float f10) {
        d.v.e0.oe.l l10 = this.i;
        if (l10 != null) {
            l10.u(f10);
        }
    }

    public ce N(Stabilizer stabilizer) {
        ce ce2 = ce$j2.a();
        if (stabilizer != null) {
            ce2.g = stabilizer;
            boolean bl2 = true;
            this.Y6(stabilizer, bl2);
            this.k = stabilizer = ce2.g;
        }
        return this;
    }

    public void N0(l object) {
        boolean bl2 = ce.A1();
        if (!bl2) {
            return;
        }
        z z10 = this.g.I2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 N3(zd zd2, Boolean bl2) {
        return this.M3(zd2, bl2);
    }

    public void N5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)1, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void N6(f f10) {
        vd.z.v = f10;
    }

    public void N7(float f10, float f11) {
        d.v.e0.oe.l l10 = this.i;
        if (l10 != null) {
            l10.v(f10, f11);
        }
    }

    public ce O(String string2, Model model, String string3) {
        Stabilizer stabilizer = new Stabilizer(model, string2, string3, true);
        return this.N(stabilizer);
    }

    public void O0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.L2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ boolean O2(int[] nArray, WifiStatus wifiStatus) {
        return this.N2(nArray, wifiStatus);
    }

    public /* synthetic */ void O4(g g10) {
        this.N4(g10);
    }

    public void O6(f f10) {
        vd.z.t = f10;
    }

    public void P0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.O2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 P3(zd zd2, Boolean bl2) {
        return this.O3(zd2, bl2);
    }

    public void P5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)12, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void P6(Strength object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            object = this.g.p0((Strength)((Object)object));
            Object object3 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_strength";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void Q0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.j();
            Object object3 = this.g.q();
            object2 = z.C0((e0)object2, (e0)object3);
            int n10 = 2;
            object2 = ((z)object2).I(n10);
            object3 = z6.a;
            object2 = ((z)object2).H3((o)object3);
            object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_pitch_and_roll_fine_tune";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 Q2(Boolean bl2) {
        return this.P2(bl2);
    }

    public /* synthetic */ void Q4(Throwable throwable) {
        this.P4(throwable);
    }

    public void Q5(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)4, (String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void Q6(b b10) {
        vd.z.p = b10;
    }

    public void Q7(boolean bl2, l l10) {
        boolean bl3 = this.F(l10);
        if (!bl3) {
            return;
        }
        Object object = bl2 ? this.g.b0() : this.g.z1();
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void R() {
        this.b.d("heartbeat");
    }

    public void R0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.B0();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_pitch_angle";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 R3(zd zd2, Boolean bl2) {
        return this.Q3(zd2, bl2);
    }

    public void R5(f f10) {
        vd.z.j = f10;
    }

    public void R6(b b10) {
        vd.z.g = b10;
    }

    public void R7(boolean bl2, l l10) {
        boolean bl3 = this.F(l10);
        if (!bl3) {
            return;
        }
        Object object = bl2 ? this.g.g1() : this.g.n1();
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void S(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.L();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void S0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.k0();
        Object object2 = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 S2(Boolean bl2) {
        return this.R2(bl2);
    }

    public void S5(f f10) {
        vd.z.i = f10;
    }

    public void S6(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.X0();
        Object object2 = new ua(n10);
        e.a.a a10 = ((i0)object).i0((o)object2);
        object = e.a.q0.c.a.c();
        a10 = a10.t0((e.a.h0)object);
        object = new k8(l10);
        l10.getClass();
        object2 = new xb(l10);
        a10.h((e.a.v0.a)object, (e.a.v0.g)object2);
    }

    public void T(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        Object object2 = this.g;
        Object object3 = Flag.DISABLE;
        object2 = ((Stabilizer)object2).h((Flag)((Object)object3));
        object3 = u6.a;
        object2 = ((z)object2).H3((o)object3);
        object3 = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object3);
        object3 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
    }

    public void T0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.Q0();
            long l10 = 2;
            object2 = ((z)object2).U4(l10);
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_power";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 T3(zd zd2, Boolean bl2) {
        return this.S3(zd2, bl2);
    }

    public void T5(CameraManufacturer object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            object = this.g.h1((CameraManufacturer)((Object)object));
            Object object3 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_camera_manufacturer";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void T6(b b10) {
        vd.z.a = b10;
    }

    public void U() {
        boolean bl2;
        this.J();
        Stabilizer stabilizer = this.l;
        if (stabilizer != null && (bl2 = stabilizer.o3())) {
            stabilizer = this.l;
            stabilizer.Y1();
        }
    }

    public void U0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.s1();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_power_mode";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 U2(yd yd2, Boolean bl2) {
        return this.T2(yd2, bl2);
    }

    public void U5(int n10, int n11, int n12, l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            Object object = this.g.i1(n10);
            x9 x92 = new x9(this, n11);
            object = ((z)object).T0(x92);
            Object object2 = new o7(this, n12);
            object = ((z)object).T0((o)object2);
            object2 = new d.v.e0.me.e(l10);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
            object2 = this.b;
            String string2 = "set_control_speed";
            ((de)object2).f(string2, (e.a.s0.b)object);
        }
    }

    public void U6(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.q0((short)120, (String)object);
        Object object2 = d.v.e0.c.a;
        object = ((z)object).H3((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void V(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.U();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void V0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.l1();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_roll_angle";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 V3(zd zd2, Boolean bl2) {
        return this.U3(zd2, bl2);
    }

    public void V5(String object, String object2, boolean bl2, boolean bl3, l l10) {
        boolean bl4 = this.F(l10);
        if (!bl4) {
            return;
        }
        object = this.g.j7((String)object2, (String)object, bl2, bl3).U4(3);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void V6(b b10) {
        vd.z.h = b10;
    }

    public ce W() {
        ce ce2 = ce$j2.a();
        Stabilizer stabilizer = ce2.k;
        this.Y6(stabilizer, false);
        ce2.g = stabilizer = ce2.l;
        return this;
    }

    public void W0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.D();
        Object object2 = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 W2(yd yd2, Boolean bl2) {
        return this.V2(yd2, bl2);
    }

    public void W5(b b10) {
        vd.z.n = b10;
    }

    public ce W6(boolean bl2) {
        Stabilizer stabilizer;
        Stabilizer stabilizer2;
        Object object = ce$j2.a();
        if (bl2 && (stabilizer2 = ((ce)object).g) != (stabilizer = ((ce)object).c)) {
            ((ce)object).j = stabilizer2;
            ((ce)object).g = stabilizer;
        } else if (!bl2 && (stabilizer2 = ((ce)object).g) == (stabilizer = ((ce)object).c)) {
            ((ce)object).g = stabilizer2 = ((ce)object).j;
        }
        object = ((ce)object).c;
        this.Y6((Stabilizer)object, bl2);
        return this;
    }

    public i0 X0() {
        boolean bl2 = ce.A1();
        if (bl2) {
            i0 i02 = i0.x0(ce.E0().a1());
            e.a.h0 h02 = e.a.c1.b.d();
            return i02.f1(h02);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Please connect device. ");
        return i0.e0(illegalStateException);
    }

    public /* synthetic */ e0 X3(zd zd2, Boolean bl2) {
        return this.W3(zd2, bl2);
    }

    public void X5(b b10) {
        vd.z.b = b10;
    }

    public void X6(int n10, int n11, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.F0(n10, n11);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public /* synthetic */ e0 Y2(yd yd2, Boolean bl2) {
        return this.X2(yd2, bl2);
    }

    public void Y5(b b10) {
        vd.z.o = b10;
    }

    public void Z0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = new zd();
            Object object3 = this.g.w0();
            Object object4 = new hd((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new n7(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new yc((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new t7(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new c1((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new s8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new a1((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new c8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new oc((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new j7(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new q0((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new f8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new od((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new l8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new yb((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new v6(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new pc((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new u7(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new zc((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new w8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new h0((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new oa(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new kd((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new z8(this);
            object3 = ((z)object3).T0((o)object4);
            object4 = new m0((zd)object2);
            object3 = ((z)object3).f2((e.a.v0.g)object4);
            object4 = new ga((zd)object2);
            object2 = ((z)object3).H3((o)object4);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_scene";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void Z5(b b10) {
        vd.z.k = b10;
    }

    public Stabilizer a1() {
        return this.g;
    }

    public /* synthetic */ e0 a3(yd yd2, Boolean bl2) {
        return this.Z2(yd2, bl2);
    }

    public void a6(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            Object object = this.g.w1(n10);
            Object object2 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object2);
            object2 = new d.v.e0.me.e(l10);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
        }
    }

    public void a7(WorkingMode object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            object = this.g.j0((WorkingMode)((Object)object));
            Object object3 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_working_mode";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void b0(boolean bl2, l object) {
        boolean bl3 = this.F((d.v.e0.ie.c)object);
        if (!bl3) {
            return;
        }
        if (bl2) {
            Object object2 = this.g;
            Object object3 = PowerMode.OFF;
            object2 = ((Stabilizer)object2).g0((PowerMode)((Object)object3));
            object3 = new ce$e(this);
            object2 = ((z)object2).T0((o)object3);
            object3 = new ce$d(this);
            object2 = ((z)object2).T0((o)object3);
            object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object);
            object2 = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object = this.b;
            object3 = "enable_debug_mode_true";
            ((de)object).f((String)object3, (e.a.s0.b)object2);
        } else {
            Object object4 = this.g;
            Object object5 = IMUControlMode.CLEAR;
            object4 = ((Stabilizer)object4).G1((IMUControlMode)((Object)object5));
            object5 = new ce$f(this);
            object4 = ((z)object4).T0((o)object5);
            object5 = e.a.q0.c.a.c();
            object4 = ((z)object4).i4((e.a.h0)object5);
            object5 = new d.v.e0.me.e((l)object);
            object4 = (e.a.s0.b)((Object)((z)object4).i((g0)object5));
            object = this.b;
            object5 = "enable_debug_mode_false";
            ((de)object).f((String)object5, (e.a.s0.b)object4);
        }
    }

    public void b1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.J();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_strength";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 b4(Boolean bl2) {
        return this.a4(bl2);
    }

    public void b6(f f10) {
        vd.z.s = f10;
    }

    public void b7(int n10, l l10) {
        int n11 = this.F(l10);
        if (n11 != 0) {
            n11 = 2048;
            this.U5(n11, n11, n10, l10);
        }
    }

    public void c0() {
        String string2;
        Object object;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = ((Stabilizer)(object = this.g)).p3()) && (bl2 = ((de)(object = this.b)).c(string2 = "heartbeat"))) {
            object = this.g.i3();
            Object object2 = h9.a;
            i7 i72 = i7.a;
            object = ((z)object).c((e.a.v0.g)object2, i72);
            object2 = this.b;
            ((de)object2).f(string2, (e.a.s0.b)object);
        }
    }

    public List c1() {
        boolean bl2 = ce.A1();
        if (bl2) {
            return this.g.n2();
        }
        return Collections.emptyList();
    }

    public /* synthetic */ e0 c3(Boolean bl2) {
        return this.b3(bl2);
    }

    public void c6(f f10) {
        vd.z.r = f10;
    }

    public void c7(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.X0(n10);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void d0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.W0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void d1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.X2();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void d6(int n10, int n11, l l10) {
        ce$m0 ce$m0 = new ce$m0(this, l10);
        this.X6(n10, n11, ce$m0);
    }

    public void d7(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            Object object = this.g.G0(n10);
            Object object2 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object2);
            object2 = new d.v.e0.me.e(l10);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
        }
    }

    public void e0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        Object object2 = this.g;
        Object object3 = Flag.ENABLE;
        object2 = ((Stabilizer)object2).h((Flag)((Object)object3));
        object3 = k7.a;
        object2 = ((z)object2).H3((o)object3);
        object3 = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object3);
        object3 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
    }

    public List e1() {
        boolean bl2 = ce.A1();
        if (bl2) {
            return this.g.W2();
        }
        return Collections.emptyList();
    }

    public /* synthetic */ td e2(Float f10, String string2) {
        return this.d2(f10, string2);
    }

    public /* synthetic */ e0 e4(boolean[] blArray, d d10, OtherStatus otherStatus) {
        return this.d4(blArray, d10, otherStatus);
    }

    public void e6(Stabilizer$g stabilizer$g) {
        be.m().J(stabilizer$g);
    }

    public void e7() {
        z z10 = this.g.L1();
        ce$x1 ce$x1 = new ce$x1(this);
        d.v.e0.me.b b10 = new d.v.e0.me.b(ce$x1);
        z10.subscribe(b10);
    }

    public void f0(boolean bl2, l l10) {
        boolean bl3 = this.F(l10);
        if (!bl3) {
            return;
        }
        Object object = this.g.f1(bl2);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void f1(l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            boolean bl3;
            Model model;
            z z10 = this.g.I2();
            Object object = new ce$t0(this);
            z10 = z10.H3((o)object);
            object = this.g.b3();
            Object object2 = e.a.c1.b.d();
            object = ((z)object).L5((e.a.h0)object2);
            object2 = new ce$w0(this);
            object = ((z)object).s2((o)object2);
            object2 = new ce$v0(this);
            object = ((z)object).s2((o)object2);
            object2 = new ce$u0(this);
            object = ((z)object).H3((o)object2).X6();
            object2 = this.g.H2();
            if (object2 != (model = Model.COV_01) && (object2 = this.g.H2()) != (model = Model.COV_03)) {
                bl3 = false;
                object2 = null;
            } else {
                bl3 = true;
            }
            if (!bl3) {
                z10 = ((i0)object).v1();
            }
            object = new ce$x0(this, l10);
            object2 = new w6(l10);
            z10.c((e.a.v0.g)object, (e.a.v0.g)object2);
        }
    }

    public /* synthetic */ e0 f3(Long l10) {
        return this.e3(l10);
    }

    public void f5(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            ce$l0 ce$l0 = new ce$l0(this, l10);
            this.l1(n10, ce$l0);
        }
    }

    public void f6(int n10) {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).p3())) {
            stabilizer = this.g;
            stabilizer.k7(n10);
        }
    }

    public void g1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.b3();
            Object object3 = new ce$a1(this);
            object2 = ((z)object2).s2((o)object3);
            object3 = new ce$z0(this);
            object2 = ((z)object2).T0((o)object3).X6();
            object3 = new ce$y0(this, (l)object);
            object = xc.a;
            ((i0)object2).c((e.a.v0.g)object3, (e.a.v0.g)object);
        }
    }

    public /* synthetic */ void g4(e.a.s0.b b10) {
        this.f4(b10);
    }

    public void g5(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        Object object2 = this.g;
        Object object3 = Flag.QUERY;
        object2 = ((Stabilizer)object2).h((Flag)((Object)object3));
        object3 = ka.a;
        object2 = ((z)object2).H3((o)object3);
        object3 = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object3);
        object3 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
    }

    public void g6(String object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.c1((String)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void g7(l l10) {
        this.K5(1, l10);
    }

    public void h1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.Y0((short)767);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 h2(Integer n10) {
        return this.g2(n10);
    }

    public /* synthetic */ boolean h3(Integer n10) {
        return this.g3(n10);
    }

    public void h5(l l10) {
        this.K5(2, l10);
    }

    public void h6(IMUControlMode object, l object2) {
        boolean bl2 = this.F((d.v.e0.ie.c)object2);
        if (bl2) {
            object = this.g.G1((IMUControlMode)((Object)object));
            Object object3 = e.a.q0.c.a.c();
            object = ((z)object).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object2);
            object = (e.a.s0.b)((Object)((z)object).i((g0)object3));
            object2 = this.b;
            object3 = "set_imu_control_register";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void h7(l l10) {
        this.M5(1, l10);
    }

    public void i0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.d2().U4(5);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
        this.b.f("active_info_get", (e.a.s0.b)object);
    }

    public void i1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.j1();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void i5(l l10) {
        this.M5(2, l10);
    }

    public void i6(int n10, int n11, int n12, KeyFunc keyFunc, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.m7(n10, n11, n12, keyFunc);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void i7(l l10) {
        this.O5(1, l10);
    }

    public void j0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.a();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_angles";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void j1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.v1();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 j2(Integer n10) {
        return this.i2(n10);
    }

    public /* synthetic */ e0 j3(Integer n10) {
        return this.i3(n10);
    }

    public /* synthetic */ e0 j4(WorkingMode workingMode) {
        return this.i4(workingMode);
    }

    public void j5(l l10) {
        this.O5(2, l10);
    }

    public void j6(b b10) {
        vd.z.d = b10;
    }

    public void j7(UpgradeLink object, byte[] object2, int n10, String string2, d d10) {
        boolean bl2;
        n10 = (int)(ce.A1() ? 1 : 0);
        if (n10 == 0) {
            object = new ConnectException("Unconnected device!");
            d10.d((Throwable)object);
            return;
        }
        Object object3 = UpgradeLink.WIFI;
        int[] nArray = null;
        boolean bl3 = true;
        if (object == object3) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            this.W6(bl3);
            n10 = 1024;
        } else {
            this.W6(false);
            n10 = 256;
        }
        nArray = new int[4];
        boolean[] blArray = new boolean[bl3];
        z z10 = this.g.U6();
        Object object4 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object4);
        object4 = new ce$v1(this, blArray, d10);
        z10 = z10.H3((o)object4);
        object4 = new za(this);
        z10 = z10.s2((o)object4);
        object4 = new ce$u1(this, d10);
        z10 = z10.T0((o)object4);
        object4 = new ce$t1(this);
        z10 = z10.T0((o)object4);
        object4 = new ce$s1(this);
        z10 = z10.T0((o)object4);
        object4 = new ce$r1(this, nArray);
        z10 = z10.T0((o)object4);
        object4 = new ce$q1(this);
        z10 = z10.o2((r)object4);
        object4 = new ce$p1(this, nArray);
        z10 = z10.T0((o)object4).x1().v1();
        object4 = new ce$o1(this);
        z10 = z10.H3((o)object4);
        object4 = new ce$m1(this);
        z10 = z10.o2((r)object4);
        object4 = new ce$l1(this);
        z10 = z10.T0((o)object4);
        object4 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object4);
        object4 = new ce$k1(this, d10);
        z10 = z10.d2((e.a.v0.g)object4);
        object4 = new ce$j1(this, d10, nArray);
        z10 = z10.H3((o)object4);
        object4 = new ce$i1(this, n10, (byte[])object2, nArray);
        object2 = z10.H3((o)object4);
        object3 = e.a.c1.b.d();
        object2 = ((z)object2).i4((e.a.h0)object3);
        object3 = new ce$h1(this, nArray, bl2, d10);
        object = ((z)object2).s2((o)object3).x1().v1();
        object2 = new ce$g1(this);
        object = ((z)object).o4((o)object2);
        object2 = new ce$f1(this, nArray, d10);
        object = ((z)object).o2((r)object2);
        object2 = new ce$e1(this, string2);
        object = ((z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new ce$d1(this, d10);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = xa.a;
        object = ((z)object).o2((r)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new sa(this, blArray, d10);
        object = ((z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new ce$b1(this, d10);
        object = ((z)object).d2((e.a.v0.g)object2);
        object2 = new e8(this);
        object = ((z)object).g2((e.a.v0.g)object2);
        object2 = new d.v.e0.me.e(null);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
        this.b.f("FIRMWARE_UPGRADE", (e.a.s0.b)object);
    }

    public void k1(PhotoInfoNumber object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.m1((PhotoInfoNumber)((Object)object));
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void k5(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.L0();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "record_video";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void k6(CameraBrand object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.P((CameraBrand)((Object)object));
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void k7() {
        d.v.e0.oe.l l10 = this.h;
        if (l10 == null) {
            this.h = l10 = d.v.e0.oe.l.b(this.a1());
            boolean bl2 = true;
            l10.s(bl2);
        }
    }

    public List l0() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.f.d().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (j0)iterator2.next();
            String string2 = object.e();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) continue;
            object = object.e();
            arrayList.add(object);
        }
        return arrayList;
    }

    public void l1(int n10, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.y1(n10);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public /* synthetic */ e0 l2(Integer n10) {
        return this.k2(n10);
    }

    public /* synthetic */ e0 l4(boolean bl2, Boolean bl3) {
        return this.k4(bl2, bl3);
    }

    public void l5(Stabilizer$k stabilizer$k) {
        be.m().F(stabilizer$k);
    }

    public void l6(DeviceType object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.r((DeviceType)((Object)object));
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void m0(l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        ce$a0 ce$a0 = new ce$a0(this, l10);
        this.r0(ce$a0);
    }

    public void m1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.c0();
        Object object2 = new ce$x(this);
        z10 = z10.s2((o)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void m5(d.v.e0.ie.b b10) {
        if (b10 != null) {
            List list = this.a;
            list.remove(b10);
        }
    }

    public void m6(float f10, float f11, float f12, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.n7(f10);
        g7 g72 = new g7(this, f11);
        object = ((z)object).T0(g72);
        Object object2 = new v8(this, f12);
        object = ((z)object).T0((o)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void m7(long l10, long l11, List list, d.v.e0.ie.e e10) {
        this.o7(false, l10, l11, list, e10);
    }

    public void n0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.Y0((short)255);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void n1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.c0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 n2(Integer n10) {
        return this.m2(n10);
    }

    public void n5() {
        ce$e2 ce$e2 = new ce$e2(this);
        boolean bl2 = this.F(ce$e2);
        if (!bl2) {
            return;
        }
        z z10 = this.g.Z6();
        d.v.e0.me.b b10 = new d.v.e0.me.b(ce$e2);
        z10.subscribe(b10);
    }

    public void n6(int n10, int n11, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.o7(n10, n11);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void n7(long l10, List list, d.v.e0.ie.e e10) {
        this.m7(l10, 0L, list, e10);
    }

    public void o0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.s();
            Object object3 = this.g.z();
            z z10 = this.g.F();
            z z11 = this.g.b1();
            object2 = z.E0((e0)object2, (e0)object3, z10, z11);
            int n10 = 4;
            object2 = ((z)object2).I(n10);
            object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_calibration_angels";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void o1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.c();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_working_mode";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ boolean o4(List list) {
        return this.n4(list);
    }

    public void o5(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.B();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void o6(int n10, int n11, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.q7(n10, n11);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void o7(boolean bl2, long l10, long l11, List list, d.v.e0.ie.e e10) {
        ce$i2 ce$i2;
        boolean bl3 = this.F(e10);
        if (!bl3) {
            return;
        }
        Object object = this.y0();
        bl3 = ((td)object).i();
        if (!bl3) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("The device does not support this operation");
            e10.onFailed(unsupportedOperationException);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Move: \u56de\u4e2d\uff1a ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append("  \u65f6\u957f\uff1a");
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append("\u505c\u70b9\uff1a");
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append("  \u79fb\u52a8\u70b9\uff1a ");
        int n10 = list.size();
        ((StringBuilder)object).append(n10);
        d.v.e0.oe.q.a(((StringBuilder)object).toString());
        this.m = false;
        n10 = list.size();
        int n11 = 1;
        int[] nArray = new int[n11];
        WorkingMode[] workingModeArray = new WorkingMode[n11];
        Object object2 = WorkingMode.L;
        workingModeArray[0] = object2;
        object = this.p1();
        object2 = new m8(workingModeArray);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = new g9(this);
        object = ((z)object).s2((o)object2);
        object2 = new f9(this, bl2);
        Object object3 = ((z)object).s2((o)object2);
        object2 = list;
        object = new la(l10, list);
        object3 = ((z)object3).H3((o)object);
        Object object4 = new i9(this);
        object3 = ((z)object3).o2((r)object4);
        object4 = d.v.e0.e.a;
        object2 = ((z)object3).T0((o)object4);
        object3 = ce$i2;
        object4 = this;
        object = e10;
        ce$i2 = new ce$i2(this, nArray, e10, n10, l11);
        object3 = ((z)object2).T0(ce$i2).e6(n11);
        object4 = new m9(this, workingModeArray);
        object3 = ((z)object3).X1((e.a.v0.a)object4);
        object4 = e.a.q0.c.a.c();
        object3 = ((z)object3).i4((e.a.h0)object4);
        object4 = new ce$h2(this, e10);
        ((z)object3).subscribe((g0)object4);
    }

    public List p0() {
        boolean bl2 = ce.A1();
        List list = bl2 ? this.g.n2() : Collections.emptyList();
        return list;
    }

    public /* synthetic */ e0 p2(Integer n10) {
        return this.o2(n10);
    }

    public void p6(int n10, int n11, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object = this.g.s7(n10, n11);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void p7(PathShot object, d.v.e0.ie.f f10) {
        boolean bl2 = this.F(f10);
        if (!bl2) {
            return;
        }
        d.v.e0.oe.q.a("startOffline");
        Object object2 = this.g.D3();
        Object object3 = new t8(this, (PathShot)object);
        object = ((z)object2).s2((o)object3);
        object2 = new ce$s0(this);
        object = ((z)object).s2((o)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = new ce$q0(this, f10);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = new ce$o0(this);
        object3 = new ce$p0(this);
        object = ((z)object).u2((o)object2, (e.a.v0.c)object3);
        object2 = new h8(this);
        object = ((z)object).s2((o)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        f10.getClass();
        object2 = new wb(f10);
        object3 = new a9(f10);
        fa fa2 = new fa(f10);
        ((z)object).f((e.a.v0.g)object2, (e.a.v0.g)object3, fa2);
    }

    public void q0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.q1();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_camera_manufacturer";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public List q1() {
        boolean bl2 = ce.A1();
        List list = bl2 ? this.g.g3() : Collections.emptyList();
        return list;
    }

    public /* synthetic */ void q4(WorkingMode[] workingModeArray) {
        this.p4(workingModeArray);
    }

    public void q6(l object, int n10) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.O0(n10);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void q7(j j10, long l10, boolean bl2, Model ... object) {
        boolean bl3;
        Object object2 = this.d;
        if (object2 == null || (bl3 = object2.isDisposed())) {
            object2 = new e$b();
            object2 = ((e$b)object2).e(2);
            int n10 = 1;
            object2 = ((e$b)object2).d(n10).b();
            Object object3 = new b$b();
            object3 = ((b$b)object3).a();
            long l11 = 3;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Object object4 = z.O6(l11, timeUnit);
            o o10 = new q8(this);
            object4 = object4.H3(o10);
            o10 = new c7((d.n.a.r0.e)object2, (d.n.a.r0.b)object3);
            object2 = object4.s2(o10);
            object3 = this.k0().h();
            object4 = this.k0().f();
            object3 = ((z)object3).I5(object4);
            object4 = new qa((z)object2);
            object2 = ((z)object3).N5((o)object4);
            object3 = aa.a;
            object2 = ((z)object2).o2((r)object3);
            object3 = new b9(this);
            object2 = ((z)object2).I2((o)object3);
            object3 = this.e;
            object4 = this.f;
            object3 = d.v.e0.je.e.h((Context)object3, (RxBleClient)object4);
            object4 = new ea(this);
            object3 = ((z)object3).I2((o)object4);
            object4 = j8.a;
            object3 = ((z)object3).o2((r)object4);
            object2 = z.L3((e0)object2, (e0)object3);
            object3 = new w9(this, (Model[])object);
            object = ((z)object2).o2((r)object3);
            object2 = new g8(this, bl2);
            z z10 = object.o2((r)object2);
            object = TimeUnit.MILLISECONDS;
            z z11 = z10.c6(l10, (TimeUnit)((Object)object));
            Object object5 = e.a.q0.c.a.c();
            z11 = z11.i4((e.a.h0)object5);
            j10.getClass();
            object5 = new uc(j10);
            z11 = z11.Z1((e.a.v0.a)object5);
            object5 = new ce$k(this, j10);
            z11.subscribe((g0)object5);
        }
    }

    public void r0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.H(0);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void r1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.F1();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "get_yaw_angle";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 r2(Integer n10) {
        return this.q2(n10);
    }

    public void r5(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g.P0();
            Object object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.b((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "SAVE";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public void r6(Stabilizer$h stabilizer$h) {
        be.m().K(stabilizer$h);
    }

    public void r7(j j10, boolean bl2, Model ... modelArray) {
        this.q7(j10, 600000L, bl2, modelArray);
    }

    public void s0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.M0();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z10 = z10.E1(5, timeUnit);
        Object object2 = new ce$b0(this);
        z10 = z10.T0((o)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void s1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.Q();
        Object object2 = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object2);
        object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public /* synthetic */ e0 s4(PathShot pathShot, Boolean bl2) {
        return this.r4(pathShot, bl2);
    }

    public void s6(b b10) {
        vd.z.m = b10;
    }

    public void s7(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        Object object2 = TimeUnit.SECONDS;
        e.a.h0 h02 = e.a.c1.b.a();
        Object object3 = z.m3(0L, 15, (TimeUnit)((Object)object2), h02);
        o o10 = new ce$n(this);
        object3 = ((z)object3).T0(o10);
        o10 = new ce$m(this);
        object3 = ((z)object3).T0(o10);
        o10 = new ce$l(this);
        object2 = ((z)object3).T0(o10).E1(2, (TimeUnit)((Object)object2));
        object3 = new ce$j(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = new ce$i(this);
        object2 = ((z)object2).s2((o)object3);
        object3 = new ce$h(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = new ce$g(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = e.a.q0.c.a.c();
        object2 = ((z)object2).i4((e.a.h0)object3);
        object3 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
        this.b.f("start_scan_wifi", (e.a.s0.b)object);
    }

    public void t0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.o();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void t1(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g;
            Object object3 = FunctionEvent.BACK_HEAD;
            object2 = ((Stabilizer)object2).C((FunctionEvent)((Object)object3));
            object3 = e.a.q0.c.a.c();
            object2 = ((z)object2).i4((e.a.h0)object3);
            object3 = new d.v.e0.me.e((l)object);
            object = (e.a.s0.b)((Object)((z)object2).i((g0)object3));
            object2 = this.b;
            object3 = "head_back";
            ((de)object2).f((String)object3, (e.a.s0.b)object);
        }
    }

    public /* synthetic */ e0 t2(Integer n10) {
        return this.s2(n10);
    }

    public /* synthetic */ e0 t3(int n10, Boolean bl2) {
        return this.s3(n10, bl2);
    }

    public void t6(b b10) {
        vd.z.c = b10;
    }

    public void t7(boolean bl2, StoryAxis[] object, d.v.e0.ie.e e10) {
        object = z.Q2((Object[])object);
        Object object2 = e.a.c1.b.g();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new ce$d2(this);
        object = ((z)object).T0((o)object2);
        object2 = new y9(this, bl2);
        z z10 = ((z)object).X1((e.a.v0.a)object2);
        object = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object);
        object = new ce$c2(this, e10);
        z10 = z10.Z1((e.a.v0.a)object);
        object = new ce$b2(this, e10);
        z10.subscribe((g0)object);
    }

    public void u0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.I0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void u1(Context object, boolean bl2) {
        RxBleClient rxBleClient = this.f;
        if (rxBleClient == null) {
            this.e = object;
            d.v.e0.oe.q.h((Context)object, bl2);
            this.f = object = RxBleClient.a(object.getApplicationContext());
        }
        if (bl2) {
            object = new d0$a();
            int n10 = 3;
            Integer n11 = n10;
            object = ((d0$a)object).b(n11).a();
            RxBleClient.l((d0)object);
        }
    }

    public void u6(PathShot object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.v7((PathShot)object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void u7() {
        d.v.e0.oe.l l10 = this.i;
        if (l10 == null) {
            this.i = l10 = d.v.e0.oe.l.b(this.a1());
            l10.s(false);
        }
    }

    public void v(Stabilizer$k stabilizer$k) {
        be.m().e(stabilizer$k);
    }

    public ConnectionMethod v0() {
        boolean bl2 = ce.A1();
        ConnectionMethod connectionMethod = bl2 ? this.g.o2() : ConnectionMethod.BLE;
        return connectionMethod;
    }

    public boolean v1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).j3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public /* synthetic */ e0 v2(Integer n10) {
        return this.u2(n10);
    }

    public /* synthetic */ e0 v3(int n10, Boolean bl2) {
        return this.u3(n10, bl2);
    }

    public void v6(MoveLineStatus object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.u7((MoveLineStatus)((Object)object));
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void v7(l l10) {
        this.K5(0, l10);
    }

    public void w(d.v.e0.ie.b b10) {
        Object object;
        boolean bl2;
        if (b10 != null && !(bl2 = (object = this.a).contains(b10))) {
            object = this.a;
            object.add(b10);
            bl2 = ce.A1();
            if (bl2) {
                object = this.g;
                b10.e((Stabilizer)object);
            }
        }
    }

    public void w0(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.C0();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public boolean w1(l l10) {
        boolean bl2 = this.F(l10);
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Object object = this.g;
        bl2 = ((Stabilizer)object).j3();
        if (!bl2) {
            return false;
        }
        object = this.g;
        bl2 = ((Stabilizer)object).k3();
        bl3 = true;
        if (bl2) {
            object = Boolean.TRUE;
            l10.call(object);
            return bl3;
        }
        object = new ce$z(this, l10);
        this.r0((l)object);
        return bl3;
    }

    public /* synthetic */ RxBleClient w4(Long l10) {
        return this.v4(l10);
    }

    public void w6(Stabilizer$l stabilizer$l) {
        be.m().N(stabilizer$l);
    }

    public void w7(l l10) {
        this.M5(0, l10);
    }

    public StrengthLimit x0() {
        StrengthLimit strengthLimit;
        boolean bl2 = ce.A1();
        if (bl2) {
            strengthLimit = this.g.V2();
        } else {
            bl2 = false;
            strengthLimit = null;
        }
        return strengthLimit;
    }

    public boolean x1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).l3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public /* synthetic */ e0 x2(Integer n10) {
        return this.w2(n10);
    }

    public /* synthetic */ e0 x3(float f10, Boolean bl2) {
        return this.w3(f10, bl2);
    }

    public void x5(byte[] object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        object = this.g.b7((byte[])object);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
        this.b.f("active_info_set", (e.a.s0.b)object);
    }

    public void x6(PathShot object, l l10) {
        boolean bl2 = this.F(l10);
        if (!bl2) {
            return;
        }
        Object object2 = this.g;
        Objects.requireNonNull(object);
        object = ((Stabilizer)object2).v7((PathShot)object);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void x7(l l10) {
        this.O5(0, l10);
    }

    public void y(l l10) {
        this.z(l10, 0L);
    }

    public td y0() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        float f10;
        Object object5;
        boolean bl2 = ce.A1();
        float f11 = 0.0f;
        if (bl2) {
            float f12;
            object5 = this.g;
            f10 = f12 = ((Stabilizer)object5).s2();
        } else {
            f10 = 0.0f;
        }
        object5 = "";
        if (bl2) {
            object4 = this.g.M2();
            object3 = object4;
        } else {
            object3 = object5;
        }
        if (bl2) {
            object4 = this.g.F2();
            object2 = object4;
        } else {
            object2 = object5;
        }
        object4 = bl2 ? this.g.H2() : Model.UNKNOWN;
        Object object6 = object4;
        object4 = bl2 ? this.g.w2() : Model.UNKNOWN;
        Object object7 = object4;
        if (bl2) {
            object5 = this.g.G2();
        }
        Object object8 = object5;
        if (bl2) {
            object = this.g;
            f11 = ((Stabilizer)object).f3();
        }
        object4 = object;
        object = new td(f10, (String)object3, (String)object2, (Model)((Object)object6), (Model)((Object)object7), (String)object8, f11);
        return object;
    }

    public boolean y1() {
        Stabilizer stabilizer;
        boolean bl2 = ce.A1();
        if (bl2 && (bl2 = (stabilizer = this.g).m3())) {
            bl2 = true;
        } else {
            bl2 = false;
            stabilizer = null;
        }
        return bl2;
    }

    public void y5(l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (!bl2) {
            return;
        }
        z z10 = this.g.N();
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new d.v.e0.me.b((l)object);
        object = (e.a.s0.b)((Object)z10.i((g0)object2));
    }

    public void y6(b b10) {
        vd.z.f = b10;
    }

    public void y7() {
        d.v.e0.oe.l l10 = this.h;
        if (l10 != null) {
            l10.t();
            l10 = null;
            this.h = null;
        }
    }

    public void z(l object, long l10) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            z z10 = this.C();
            Object object2 = new ce$b(this);
            z10 = z10.s2((o)object2);
            object2 = TimeUnit.MILLISECONDS;
            Object object3 = z10.E1(l10, (TimeUnit)((Object)object2));
            Object object4 = new ce$a(this);
            object3 = ((z)object3).s2((o)object4);
            object4 = e.a.q0.c.a.c();
            object3 = ((z)object3).i4((e.a.h0)object4);
            object4 = new d.v.e0.me.e((l)object);
            object = (e.a.s0.b)((Object)((z)object3).i((g0)object4));
            object3 = this.b;
            object4 = "back_center";
            ((de)object3).f((String)object4, (e.a.s0.b)object);
        }
    }

    public void z0(l l10) {
        boolean bl2 = this.F(l10);
        if (bl2) {
            z z10 = this.g.d1();
            Object object = this.g.M();
            x8 x82 = new x8(this);
            z10 = z.W7(z10, (e0)object, x82);
            object = e.a.q0.c.a.c();
            z10 = z10.i4((e.a.h0)object);
            object = new d.v.e0.me.b(l10);
            z10.subscribe((g0)object);
        }
    }

    public /* synthetic */ e0 z2(Float f10) {
        return this.y2(f10);
    }

    public /* synthetic */ e0 z3(float f10, Boolean bl2) {
        return this.y3(f10, bl2);
    }

    public void z5(int n10, int n11, boolean bl2, l l10) {
        boolean bl3 = this.F(l10);
        if (!bl3) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        Object object = stringBuilder.toString();
        object = this.g.q0((short)17, (String)object);
        Object object2 = new ce$y(this, bl2);
        object = ((z)object).T0((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((e.a.h0)object2);
        object2 = new d.v.e0.me.e(l10);
        object = (e.a.s0.b)((Object)((z)object).i((g0)object2));
    }

    public void z6(float f10, float f11, l object) {
        boolean bl2 = this.F((d.v.e0.ie.c)object);
        if (bl2) {
            Object object2 = this.g;
            Object object3 = DebugMode.IMU_COMPENSATE;
            object2 = ((Stabilizer)object2).r0((DebugMode)((Object)object3));
            Object object4 = this.g.i0(f10);
            Object object5 = this.g.Z(f11);
            object3 = this.g;
            DebugMode debugMode = DebugMode.NORMAL;
            object3 = ((Stabilizer)object3).r0(debugMode);
            object4 = z.E0((e0)object2, (e0)object4, (e0)object5, (e0)object3);
            int n10 = 1;
            f11 = Float.MIN_VALUE;
            object4 = ((z)object4).e6(n10);
            object5 = e.a.q0.c.a.c();
            object4 = ((z)object4).i4((e.a.h0)object5);
            object5 = new d.v.e0.me.e((l)object);
            object4 = (e.a.s0.b)((Object)((z)object4).i((g0)object5));
            object5 = this.b;
            object = "set_pitch_and_roll_fine_tune";
            ((de)object5).f((String)object, (e.a.s0.b)object4);
        }
    }

    public void z7() {
        this.m = true;
    }
}

