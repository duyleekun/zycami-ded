/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.zhiyun.device.connection;

import android.content.Context;
import android.text.TextUtils;
import com.zhiyun.common.util.Devices;
import com.zhiyun.device.connection.BleConnection$RESTRICTION_STATE;
import com.zhiyun.device.connection.BleConnection$a;
import com.zhiyun.device.connection.BleConnection$b;
import com.zhiyun.device.connection.BleConnection$c;
import com.zhiyun.device.connection.BleConnection$d;
import com.zhiyun.device.connection.BleConnection$e;
import com.zhiyun.device.connection.BleConnection$f;
import com.zhiyun.device.connection.BleConnection$g;
import com.zhiyun.device.connection.BleConnection$h;
import com.zhiyun.device.connection.BleConnection$i;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.device.connection.BleConnection$k;
import com.zhiyun.device.data.local.entity.ActivationData;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo;
import com.zhiyun.device.data.remote.entity.AppProductionList;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.protocol.constants.Active;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import d.v.e.l.b2;
import d.v.e.l.c1;
import d.v.e.l.m1;
import d.v.e0.ce;
import d.v.e0.td;
import d.v.g.e.c;
import d.v.g.e.d;
import d.v.g.e.e;
import d.v.g.e.f;
import d.v.g.e.g;
import d.v.g.e.h;
import d.v.g.e.i;
import d.v.g.e.j;
import d.v.g.e.k;
import d.v.g.e.l;
import d.v.g.e.m;
import d.v.g.e.n;
import d.v.g.e.o;
import d.v.g.e.p;
import d.v.g.f.c.b;
import d.v.p.a;
import d.v.p.a$c;
import e.a.b0;
import e.a.e0;
import e.a.i0;
import e.a.k0;
import e.a.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k.r;

public class BleConnection {
    private static final int w = 50;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Stabilizer g;
    private List h;
    private d.v.g.f.b.d.c i;
    private d.v.g.f.b.d.a j;
    private d.v.g.f.b.d.g k;
    private a l;
    private a$c m;
    private AppDeviceInfo n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private String u;
    private ActiveInfo v;

    private BleConnection() {
        boolean bl2;
        this.c = bl2 = true;
        this.d = bl2;
        this.f = false;
        Object object = new ArrayList();
        this.h = object;
        this.i = object = d.v.g.f.b.c.b().a().f();
        this.j = object = d.v.g.f.b.c.b().a().e();
        this.k = object = d.v.g.f.b.c.b().a().h();
        this.l = object = d.v.p.a.c(d.v.e.f.a().c());
        this.m = object = new BleConnection$a(this);
        object = new BleConnection$b(this);
        ce.E0().w((d.v.e0.ie.b)object);
    }

    public /* synthetic */ BleConnection(BleConnection$a a10) {
        this();
    }

    public static /* synthetic */ a$c A(BleConnection bleConnection) {
        return bleConnection.m;
    }

    private /* synthetic */ void A0(b0 b02) {
        Object object = new Object[]{};
        String string2 = "----checkRestrictions----";
        m.a.a.b(string2, object);
        boolean bl2 = this.d;
        if (!bl2) {
            this.X0();
            object = Boolean.FALSE;
            b02.onNext(object);
        } else {
            object = Boolean.TRUE;
            b02.onNext(object);
        }
    }

    public static /* synthetic */ boolean B(BleConnection bleConnection, boolean bl2) {
        bleConnection.c = bl2;
        return bl2;
    }

    public static /* synthetic */ a C(BleConnection bleConnection) {
        return bleConnection.l;
    }

    private /* synthetic */ void C0(b0 b02) {
        Object object = new Object[]{};
        Object object2 = "----getDeviceSn----";
        m.a.a.b((String)object2, (Object[])object);
        object = this.s;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = Boolean.TRUE;
            b02.onNext(object);
        } else {
            object = ce.E0();
            object2 = new BleConnection$f(this, b02);
            ((ce)object).z0((d.v.e0.ie.l)object2);
        }
    }

    public static /* synthetic */ boolean D(BleConnection bleConnection, boolean bl2) {
        bleConnection.f = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean E(BleConnection bleConnection, boolean bl2) {
        bleConnection.e = bl2;
        return bl2;
    }

    private /* synthetic */ void E0(b0 b02) {
        Object object = new Object[]{};
        Object object2 = "----getForceUpdateState----";
        m.a.a.b((String)object2, (Object[])object);
        boolean bl2 = this.c;
        if (!bl2) {
            object = Boolean.TRUE;
            b02.onNext(object);
        } else {
            object = ce.E0();
            object2 = new BleConnection$c(this, b02);
            ((ce)object).B1((d.v.e0.ie.l)object2);
        }
    }

    public static /* synthetic */ Stabilizer F(BleConnection bleConnection, Stabilizer stabilizer) {
        bleConnection.g = stabilizer;
        return stabilizer;
    }

    public static /* synthetic */ void G(BleConnection bleConnection, Throwable throwable, Stabilizer stabilizer) {
        bleConnection.T0(throwable, stabilizer);
    }

    private /* synthetic */ void G0(b0 b02) {
        Object object = new Object[]{};
        Object object2 = "----getRestrictState----";
        m.a.a.b((String)object2, (Object[])object);
        boolean bl2 = this.d;
        if (!bl2) {
            this.X0();
            object = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NORMAL;
            b02.onNext(object);
        } else {
            object = this.s;
            if (object != null) {
                object = d.v.e.f.a().c();
                bl2 = b2.m((Context)object);
                if (!bl2) {
                    object = this.s;
                    this.N((String)object);
                    object = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NORMAL;
                    b02.onNext(object);
                } else {
                    object = this.o;
                    object2 = "";
                    Object object3 = object == null ? object2 : object;
                    object = this.p;
                    Object object4 = object == null ? object2 : object;
                    b b10 = d.v.g.f.c.b.a;
                    String string2 = this.s;
                    String string3 = this.q;
                    String string4 = this.r;
                    object = b10.a(string2, string3, string4, (String)object3, (String)object4);
                    object2 = new BleConnection$h(this, b02);
                    object.h((k.f)object2);
                }
            } else {
                object2 = "device sn is null";
                object = new IllegalArgumentException((String)object2);
                b02.onError((Throwable)object);
            }
        }
    }

    public static /* synthetic */ void H(BleConnection bleConnection, Stabilizer stabilizer) {
        bleConnection.S0(stabilizer);
    }

    private void I(AppDeviceInfo appDeviceInfo) {
        Executor executor = c1.b().a();
        h h10 = new h(this, appDeviceInfo);
        executor.execute(h10);
    }

    private /* synthetic */ void I0(k0 k02) {
        Object object = Boolean.TRUE;
        boolean bl2 = this.g0();
        if (!bl2) {
            k02.onSuccess(object);
            return;
        }
        bl2 = this.b0();
        if (bl2) {
            k02.onSuccess(object);
        } else {
            object = new BleConnection$d(this, k02);
            this.L((d.v.e0.ie.l)object);
        }
    }

    private void K(RegionalRestrictionsInfo regionalRestrictionsInfo) {
        Executor executor = c1.b().a();
        d d10 = new d(this, regionalRestrictionsInfo);
        executor.execute(d10);
    }

    private /* synthetic */ void K0(td object) {
        String string2 = Devices.k(d.v.e.f.a().c());
        String string3 = ((td)object).b.getName();
        String string4 = ((td)object).a;
        String string5 = ((td)object).e;
        String string6 = m1.A();
        String string7 = this.o;
        this.n = object = new AppDeviceInfo(string7, string2, string3, string4, string6, string5);
        Object object2 = this.q;
        if (object2 != null && (object2 = this.r) != null) {
            ((AppDeviceInfo)object).setLatitude((String)object2);
            object = this.n;
            object2 = this.q;
            ((AppDeviceInfo)object).setLongitude((String)object2);
            object = this.n;
            this.I((AppDeviceInfo)object);
        } else {
            object = this.l;
            object2 = this.m;
            ((a)object).e((a$c)object2);
        }
    }

    private void L(d.v.e0.ie.l l10) {
        ce ce2 = ce.E0();
        BleConnection$e bleConnection$e = new BleConnection$e(this, l10);
        ce2.i0(bleConnection$e);
    }

    private void M0() {
        Object object = ce.E0().a1();
        if (object != null) {
            List list = d.v.g.f.b.e.a.B().A();
            object = ((Stabilizer)object).F2();
            list.remove(object);
            object = d.v.g.f.b.e.a.B();
            ((d.v.g.f.b.e.a)object).C(list);
        }
    }

    private void N(String object) {
        d.v.g.f.b.d.g g10 = this.k;
        if ((object = g10.b((String)object)) == null) {
            this.X0();
        } else {
            boolean bl2 = ((RegionalRestrictionsInfo)object).isRestrictions();
            if (bl2) {
                bl2 = true;
                this.Y0(bl2);
            } else {
                this.X0();
            }
        }
    }

    private z O() {
        c c10 = new c(this);
        return z.y1(c10);
    }

    private void O0() {
        boolean bl2;
        this.s = null;
        this.b = false;
        this.c = bl2 = true;
        this.d = bl2;
    }

    private void P0(Stabilizer object) {
        String string2;
        List list = d.v.g.f.b.e.a.B().A();
        boolean bl2 = list.contains(string2 = ((Stabilizer)object).F2());
        if (!bl2) {
            object = ((Stabilizer)object).F2();
            list.add(object);
        }
        d.v.g.f.b.e.a.B().C(list);
    }

    private void Q(List list) {
        this.i.g(list);
    }

    private void Q0() {
        boolean bl2 = this.t;
        if (!bl2) {
            ce ce2 = ce.E0();
            f f10 = new f(this);
            ce2.z0(f10);
        }
    }

    private void R0() {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.h();
            }
        }
    }

    private void S0(Stabilizer stabilizer) {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.e(stabilizer);
            }
        }
    }

    private void T0(Throwable throwable, Stabilizer stabilizer) {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.c(throwable, stabilizer);
            }
        }
    }

    private z U() {
        d.v.g.e.b b10 = new d.v.g.e.b(this);
        return z.y1(b10);
    }

    private void U0(Stabilizer stabilizer) {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.d(stabilizer);
            }
        }
    }

    private void V0() {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.a();
            }
        }
    }

    public static BleConnection W() {
        return BleConnection$k.a;
    }

    private void W0(Stabilizer stabilizer) {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.b(stabilizer);
            }
        }
    }

    private z X() {
        BleConnection$g bleConnection$g = new BleConnection$g(this);
        return z.y1(bleConnection$g);
    }

    private void X0() {
        Object object = this.h;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.g();
            }
        }
    }

    private void Y0(boolean bl2) {
        this.M0();
        Object object = this.h;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                BleConnection$j bleConnection$j = (BleConnection$j)object.next();
                bleConnection$j.f(bl2);
            }
        }
    }

    private z Z() {
        g g10 = new g(this);
        return z.y1(g10);
    }

    public static /* synthetic */ AppDeviceInfo a(BleConnection bleConnection) {
        return bleConnection.n;
    }

    public static /* synthetic */ void b(BleConnection bleConnection) {
        bleConnection.O0();
    }

    private void b1() {
        ActivationData activationData = this.j.a();
        if (activationData == null) {
            return;
        }
        Object object = activationData.toString();
        Object object2 = new Object[]{object};
        m.a.a.b("-----uploadActivationData----%s", (Object[])object2);
        object = d.v.g.f.c.a.a;
        int n10 = activationData.getUserId();
        String string2 = activationData.getAccount();
        String string3 = activationData.getSerialNum();
        int n11 = activationData.getDeviceModel();
        String string4 = activationData.getDeviceName();
        String string5 = activationData.getAppVersion();
        String string6 = activationData.getLongitude();
        String string7 = activationData.getLatitude();
        String string8 = activationData.getActiveCode();
        String string9 = activationData.getActiveAt();
        String string10 = activationData.getActiveStatus();
        int n12 = activationData.isVisitor();
        String string11 = activationData.getEx();
        object2 = object.c(n10, string2, string3, n11, string4, string5, string6, string7, string8, string9, string10, n12, string11);
        BleConnection$i bleConnection$i = new BleConnection$i(this, activationData);
        object2.h(bleConnection$i);
    }

    public static /* synthetic */ void c(BleConnection bleConnection, Stabilizer stabilizer) {
        bleConnection.U0(stabilizer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c1() {
        Object object;
        Object[] objectArray = "END WITH ERROR";
        Object[] objectArray2 = this.i.j();
        int n10 = objectArray2.size();
        int n11 = objectArray2.isEmpty();
        if (n11 != 0) {
            objectArray = new Object[]{};
            objectArray2 = "END WITH SUCCESS";
            m.a.a.b((String)objectArray2, objectArray);
            return;
        }
        n10 = Math.min(n10, 50);
        objectArray2 = objectArray2.subList(0, n10);
        n10 = 1;
        Object object2 = new Object[n10];
        n11 = objectArray2.size();
        object2[0] = object = Integer.valueOf(n11);
        object = "total count = %s";
        m.a.a.b((String)object, (Object[])object2);
        try {
            object2 = new AppProductionList();
            object = new ArrayList();
            ((AppProductionList)object2).data = object;
            object.addAll(objectArray2);
            object = d.v.g.f.c.b.a;
            object2 = object.c((AppProductionList)object2);
            object2 = object2.execute();
            object2 = ((r)object2).a();
            object2 = (BaseEntity)object2;
            if (object2 != null && (n10 = ((BaseEntity)object2).errcode) == 0) {
                this.Q((List)objectArray2);
                this.c1();
                return;
            }
            objectArray2 = new Object[]{};
            m.a.a.b((String)objectArray, objectArray2);
            return;
        }
        catch (IOException iOException) {
            object2 = new Object[]{};
            m.a.a.b((String)objectArray, (Object[])object2);
            iOException.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ void d(BleConnection bleConnection, Stabilizer stabilizer) {
        bleConnection.P0(stabilizer);
    }

    public static /* synthetic */ boolean e(BleConnection bleConnection, boolean bl2) {
        bleConnection.t = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean f(BleConnection bleConnection, boolean bl2) {
        bleConnection.a = bl2;
        return bl2;
    }

    public static /* synthetic */ void g(BleConnection bleConnection, Stabilizer stabilizer) {
        bleConnection.W0(stabilizer);
    }

    private boolean g0() {
        boolean bl2;
        Active active;
        Active active2 = ce.E0().a1().f2();
        if (active2 != (active = Active.NONE)) {
            bl2 = true;
        } else {
            bl2 = false;
            active2 = null;
        }
        return bl2;
    }

    public static /* synthetic */ ActiveInfo h(BleConnection bleConnection) {
        return bleConnection.v;
    }

    public static /* synthetic */ void h0(BleConnection bleConnection) {
        bleConnection.Q0();
    }

    public static /* synthetic */ ActiveInfo i(BleConnection bleConnection, ActiveInfo activeInfo) {
        bleConnection.v = activeInfo;
        return activeInfo;
    }

    private /* synthetic */ void i0(AppDeviceInfo appDeviceInfo) {
        int n10 = 1;
        this.t = n10;
        d.v.g.f.b.d.c c10 = this.i;
        AppDeviceInfo[] appDeviceInfoArray = new AppDeviceInfo[n10];
        appDeviceInfoArray[0] = appDeviceInfo;
        c10.h(appDeviceInfoArray);
        this.c1();
        this.b1();
    }

    public static /* synthetic */ void j(BleConnection bleConnection) {
        bleConnection.R0();
    }

    public static /* synthetic */ boolean k(BleConnection bleConnection, boolean bl2) {
        bleConnection.b = bl2;
        return bl2;
    }

    private /* synthetic */ void k0(RegionalRestrictionsInfo regionalRestrictionsInfo) {
        boolean bl2;
        boolean bl3;
        Object object = this.k;
        String string2 = regionalRestrictionsInfo.getDeviceSn();
        if ((object = object.b(string2)) == null || (bl3 = ((RegionalRestrictionsInfo)object).isRestrictions()) != (bl2 = regionalRestrictionsInfo.isRestrictions())) {
            object = this.k;
            object.a(regionalRestrictionsInfo);
        }
    }

    public static /* synthetic */ String l(BleConnection bleConnection) {
        return bleConnection.q;
    }

    public static /* synthetic */ String m(BleConnection bleConnection, String string2) {
        bleConnection.q = string2;
        return string2;
    }

    private /* synthetic */ void m0(BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE) {
        boolean bl2 = false;
        this.e = false;
        this.Q0();
        Object object = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NORMAL;
        if (bleConnection$RESTRICTION_STATE != object) {
            object = ce.E0().y0();
            object = ((td)object).a;
            String string2 = this.s;
            BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE2 = BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_RESTRICT;
            if (bleConnection$RESTRICTION_STATE == bleConnection$RESTRICTION_STATE2) {
                bl2 = true;
            }
            RegionalRestrictionsInfo regionalRestrictionsInfo = new RegionalRestrictionsInfo((String)object, string2, bl2);
            this.K(regionalRestrictionsInfo);
        }
    }

    public static /* synthetic */ void n(BleConnection bleConnection, AppDeviceInfo appDeviceInfo) {
        bleConnection.I(appDeviceInfo);
    }

    public static /* synthetic */ String o(BleConnection bleConnection) {
        return bleConnection.r;
    }

    private /* synthetic */ void o0(Throwable throwable) {
        this.e = false;
        this.Q0();
        this.R();
    }

    public static /* synthetic */ String p(BleConnection bleConnection, String string2) {
        bleConnection.r = string2;
        return string2;
    }

    public static /* synthetic */ void q(BleConnection bleConnection) {
        bleConnection.X0();
    }

    private /* synthetic */ e0 q0(Boolean object) {
        boolean bl2 = (Boolean)object;
        object = bl2 ? this.a0().v1() : z.t3(Boolean.FALSE);
        return object;
    }

    public static /* synthetic */ d.v.g.f.b.d.a r(BleConnection bleConnection) {
        return bleConnection.j;
    }

    public static /* synthetic */ void s(BleConnection bleConnection) {
        bleConnection.b1();
    }

    private /* synthetic */ e0 s0(Boolean object) {
        boolean bl2 = (Boolean)object;
        object = bl2 ? this.O() : z.t3(Boolean.FALSE);
        return object;
    }

    public static /* synthetic */ boolean t(BleConnection bleConnection, boolean bl2) {
        bleConnection.d = bl2;
        return bl2;
    }

    public static /* synthetic */ String u(BleConnection bleConnection) {
        return bleConnection.s;
    }

    private /* synthetic */ e0 u0(Boolean object) {
        boolean bl2 = (Boolean)object;
        object = bl2 ? this.U() : z.t3(Boolean.FALSE);
        return object;
    }

    public static /* synthetic */ String v(BleConnection bleConnection, String string2) {
        bleConnection.s = string2;
        return string2;
    }

    public static /* synthetic */ void w(BleConnection bleConnection, String string2) {
        bleConnection.N(string2);
    }

    private /* synthetic */ e0 w0(Boolean object) {
        boolean bl2 = (Boolean)object;
        object = bl2 ? this.X() : z.t3(Boolean.FALSE);
        return object;
    }

    public static /* synthetic */ String x(BleConnection bleConnection, String string2) {
        bleConnection.u = string2;
        return string2;
    }

    public static /* synthetic */ void y(BleConnection bleConnection, boolean bl2) {
        bleConnection.Y0(bl2);
    }

    private /* synthetic */ e0 y0(Boolean object) {
        boolean bl2 = (Boolean)object;
        object = bl2 ? this.Z() : z.t3((Object)BleConnection$RESTRICTION_STATE.RESTRICTION_STATE_NORMAL);
        return object;
    }

    public static /* synthetic */ void z(BleConnection bleConnection) {
        bleConnection.V0();
    }

    public /* synthetic */ void B0(b0 b02) {
        this.A0(b02);
    }

    public /* synthetic */ void D0(b0 b02) {
        this.C0(b02);
    }

    public /* synthetic */ void F0(b0 b02) {
        this.E0(b02);
    }

    public /* synthetic */ void H0(b0 b02) {
        this.G0(b02);
    }

    public void J(BleConnection$j bleConnection$j) {
        if (bleConnection$j == null) {
            return;
        }
        Object object = this.h;
        boolean bl2 = object.contains(bleConnection$j);
        if (!bl2) {
            object = this.h;
            object.add(bleConnection$j);
        }
        if ((bl2 = ce.z1()) && (object = this.g) != null) {
            bleConnection$j.e((Stabilizer)object);
        }
    }

    public /* synthetic */ void J0(k0 k02) {
        this.I0(k02);
    }

    public /* synthetic */ void L0(td td2) {
        this.K0(td2);
    }

    public void M() {
        z z10 = this.V();
        Object object = new m(this);
        z10 = z10.s2((e.a.v0.o)object);
        object = new k(this);
        z10 = z10.s2((e.a.v0.o)object);
        object = new o(this);
        z10 = z10.s2((e.a.v0.o)object);
        object = new i(this);
        z10 = z10.s2((e.a.v0.o)object);
        object = new l(this);
        z10 = z10.s2((e.a.v0.o)object);
        object = new d.v.g.e.a(this);
        n n10 = new n(this);
        e e10 = new e(this);
        z10.f((e.a.v0.g)object, n10, e10);
    }

    public void N0(BleConnection$j bleConnection$j) {
        this.h.remove(bleConnection$j);
    }

    public void P(Stabilizer stabilizer, String object, String string2) {
        this.o = object;
        this.p = string2;
        this.e = true;
        boolean bl2 = ce.z1();
        if (bl2) {
            object = ce.E0();
            ((ce)object).U();
        }
        this.O0();
        this.u = null;
        ce.E0().K(stabilizer);
    }

    public void R() {
        ce.E0().U();
    }

    public ActiveInfo S() {
        return this.v;
    }

    public Stabilizer T() {
        return this.g;
    }

    public z V() {
        p p10 = new p(this);
        return z.y1(p10);
    }

    public String Y() {
        return this.u;
    }

    public BleConnection Z0(boolean bl2) {
        this.b = bl2;
        return this;
    }

    public i0 a0() {
        j j10 = new j(this);
        return i0.H(j10);
    }

    public void a1(boolean bl2) {
        this.a = bl2;
    }

    public boolean b0() {
        return this.b;
    }

    public boolean c0() {
        return this.f;
    }

    public boolean d0() {
        return this.e;
    }

    public boolean e0() {
        return this.c;
    }

    public boolean f0() {
        return this.a;
    }

    public /* synthetic */ void j0(AppDeviceInfo appDeviceInfo) {
        this.i0(appDeviceInfo);
    }

    public /* synthetic */ void l0(RegionalRestrictionsInfo regionalRestrictionsInfo) {
        this.k0(regionalRestrictionsInfo);
    }

    public /* synthetic */ void n0(BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE) {
        this.m0(bleConnection$RESTRICTION_STATE);
    }

    public /* synthetic */ void p0(Throwable throwable) {
        this.o0(throwable);
    }

    public /* synthetic */ e0 r0(Boolean bl2) {
        return this.q0(bl2);
    }

    public /* synthetic */ e0 t0(Boolean bl2) {
        return this.s0(bl2);
    }

    public /* synthetic */ e0 v0(Boolean bl2) {
        return this.u0(bl2);
    }

    public /* synthetic */ e0 x0(Boolean bl2) {
        return this.w0(bl2);
    }

    public /* synthetic */ e0 z0(Boolean bl2) {
        return this.y0(bl2);
    }
}

