/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.stabilizer;

import android.content.Context;
import androidx.core.util.Pair;
import com.google.gson.Gson;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.zhiyun.hw.HWAes;
import com.zhiyun.protocol.constants.Active;
import com.zhiyun.protocol.constants.CameraManufacturer;
import com.zhiyun.protocol.constants.ConnectionMethod;
import com.zhiyun.protocol.constants.DebugMode;
import com.zhiyun.protocol.constants.FunctionEvent;
import com.zhiyun.protocol.constants.IMUControlMode;
import com.zhiyun.protocol.constants.InteractCode;
import com.zhiyun.protocol.constants.JoystickSpeed;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.constants.PhoneControlMode;
import com.zhiyun.protocol.constants.PowerMode;
import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.protocol.constants.Strength;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.core.entities.ErrorStatus;
import com.zhiyun.protocol.core.entities.Functions;
import com.zhiyun.protocol.core.entities.MoveLimit;
import com.zhiyun.protocol.core.entities.MoveLine;
import com.zhiyun.protocol.core.entities.PresetLimit;
import com.zhiyun.protocol.core.entities.StoryAttribute;
import com.zhiyun.protocol.core.entities.StrengthLimit;
import com.zhiyun.protocol.message.bl.active.ActiveState;
import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.protocol.message.bl.file.Direction;
import com.zhiyun.protocol.message.bl.file.FileType;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import com.zhiyun.protocol.message.bl.other.OtherStatus;
import com.zhiyun.protocol.message.bl.other.Status;
import com.zhiyun.protocol.message.bl.otherevent.DeviceType;
import com.zhiyun.protocol.message.bl.otherevent.MoveLineStatus;
import com.zhiyun.protocol.message.bl.wifi.device.CameraBrand;
import com.zhiyun.protocol.message.bl.wifi.device.PhotoInfoNumber;
import com.zhiyun.protocol.message.bl.wifi.hotspot.ChannelMode;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import com.zhiyun.protocol.message.usb.command.Flag;
import com.zhiyun.protocol.message.usb.command.UsbStatus;
import com.zhiyun.protocol.utils.Axis;
import com.zhiyun.stabilizer.Stabilizer$State;
import com.zhiyun.stabilizer.Stabilizer$a;
import com.zhiyun.stabilizer.Stabilizer$b;
import com.zhiyun.stabilizer.Stabilizer$c;
import com.zhiyun.stabilizer.Stabilizer$d;
import com.zhiyun.stabilizer.Stabilizer$e;
import com.zhiyun.stabilizer.Stabilizer$i;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import com.zhiyun.stabilizer.entities.Modules;
import com.zhiyun.stabilizer.entities.PathShot;
import com.zhiyun.stabilizer.exception.UnsupportedException;
import d.v.e0.a2;
import d.v.e0.a3;
import d.v.e0.a4;
import d.v.e0.a5;
import d.v.e0.a6;
import d.v.e0.ac;
import d.v.e0.ad;
import d.v.e0.ae;
import d.v.e0.b2;
import d.v.e0.b3;
import d.v.e0.b4;
import d.v.e0.b5;
import d.v.e0.b6;
import d.v.e0.bc;
import d.v.e0.bd;
import d.v.e0.be;
import d.v.e0.c2;
import d.v.e0.c3;
import d.v.e0.c4;
import d.v.e0.c5;
import d.v.e0.c6;
import d.v.e0.cc;
import d.v.e0.cd;
import d.v.e0.d2;
import d.v.e0.d3;
import d.v.e0.d4;
import d.v.e0.d5;
import d.v.e0.d6;
import d.v.e0.dc;
import d.v.e0.dd;
import d.v.e0.e2;
import d.v.e0.e3;
import d.v.e0.e4;
import d.v.e0.e5;
import d.v.e0.e6;
import d.v.e0.ee;
import d.v.e0.f;
import d.v.e0.f2;
import d.v.e0.f3;
import d.v.e0.f4;
import d.v.e0.f5;
import d.v.e0.f6;
import d.v.e0.fc;
import d.v.e0.fd;
import d.v.e0.g2;
import d.v.e0.g3;
import d.v.e0.g4;
import d.v.e0.g5;
import d.v.e0.g6;
import d.v.e0.gc;
import d.v.e0.gd;
import d.v.e0.ge;
import d.v.e0.h;
import d.v.e0.h2;
import d.v.e0.h3;
import d.v.e0.h4;
import d.v.e0.h5;
import d.v.e0.h6;
import d.v.e0.hc;
import d.v.e0.he;
import d.v.e0.i;
import d.v.e0.i2;
import d.v.e0.i3;
import d.v.e0.i4;
import d.v.e0.i5;
import d.v.e0.i6;
import d.v.e0.ic;
import d.v.e0.j;
import d.v.e0.j2;
import d.v.e0.j3;
import d.v.e0.j4;
import d.v.e0.j5;
import d.v.e0.j6;
import d.v.e0.jc;
import d.v.e0.jd;
import d.v.e0.k2;
import d.v.e0.k3;
import d.v.e0.k4;
import d.v.e0.k5;
import d.v.e0.k6;
import d.v.e0.kc;
import d.v.e0.l2;
import d.v.e0.l3;
import d.v.e0.l4;
import d.v.e0.l5;
import d.v.e0.l6;
import d.v.e0.lc;
import d.v.e0.ld;
import d.v.e0.m2;
import d.v.e0.m3;
import d.v.e0.m4;
import d.v.e0.m5;
import d.v.e0.m6;
import d.v.e0.mc;
import d.v.e0.md;
import d.v.e0.n1;
import d.v.e0.n2;
import d.v.e0.n3;
import d.v.e0.n4;
import d.v.e0.n5;
import d.v.e0.n6;
import d.v.e0.ne.n0;
import d.v.e0.ne.n0$a;
import d.v.e0.ne.p0;
import d.v.e0.o0;
import d.v.e0.o1;
import d.v.e0.o2;
import d.v.e0.o3;
import d.v.e0.o4;
import d.v.e0.o5;
import d.v.e0.o6;
import d.v.e0.p1;
import d.v.e0.p2;
import d.v.e0.p3;
import d.v.e0.p4;
import d.v.e0.p5;
import d.v.e0.p6;
import d.v.e0.q1;
import d.v.e0.q2;
import d.v.e0.q3;
import d.v.e0.q4;
import d.v.e0.q5;
import d.v.e0.q6;
import d.v.e0.qc;
import d.v.e0.r0;
import d.v.e0.r1;
import d.v.e0.r2;
import d.v.e0.r3;
import d.v.e0.r4;
import d.v.e0.r5;
import d.v.e0.r6;
import d.v.e0.rc;
import d.v.e0.rd;
import d.v.e0.s1;
import d.v.e0.s2;
import d.v.e0.s3;
import d.v.e0.s4;
import d.v.e0.s5;
import d.v.e0.s6;
import d.v.e0.sc;
import d.v.e0.sd;
import d.v.e0.t0;
import d.v.e0.t1;
import d.v.e0.t2;
import d.v.e0.t3;
import d.v.e0.t4;
import d.v.e0.t5;
import d.v.e0.t6;
import d.v.e0.tc;
import d.v.e0.u0;
import d.v.e0.u1;
import d.v.e0.u2;
import d.v.e0.u3;
import d.v.e0.u4;
import d.v.e0.u5;
import d.v.e0.ud;
import d.v.e0.v0;
import d.v.e0.v1;
import d.v.e0.v2;
import d.v.e0.v3;
import d.v.e0.v4;
import d.v.e0.v5;
import d.v.e0.w1;
import d.v.e0.w2;
import d.v.e0.w3;
import d.v.e0.w4;
import d.v.e0.w5;
import d.v.e0.wc;
import d.v.e0.wd;
import d.v.e0.x1;
import d.v.e0.x2;
import d.v.e0.x3;
import d.v.e0.x4;
import d.v.e0.x5;
import d.v.e0.xc;
import d.v.e0.y1;
import d.v.e0.y2;
import d.v.e0.y3;
import d.v.e0.y4;
import d.v.e0.y5;
import d.v.e0.yd;
import d.v.e0.z1;
import d.v.e0.z2;
import d.v.e0.z3;
import d.v.e0.z4;
import d.v.e0.z5;
import d.v.e0.zb;
import d.v.y.c.a0;
import d.v.y.c.a1;
import d.v.y.c.b0;
import d.v.y.c.c1;
import d.v.y.c.d1;
import d.v.y.c.e1;
import d.v.y.c.f0;
import d.v.y.c.f1;
import d.v.y.c.g0;
import d.v.y.c.g1;
import d.v.y.c.h0;
import d.v.y.c.h1;
import d.v.y.c.i1;
import d.v.y.c.j0;
import d.v.y.c.j1;
import d.v.y.c.k0;
import d.v.y.c.k1;
import d.v.y.c.l;
import d.v.y.c.l0;
import d.v.y.c.l1;
import d.v.y.c.m;
import d.v.y.c.m1;
import d.v.y.c.n;
import d.v.y.c.p;
import d.v.y.c.q;
import d.v.y.c.q0;
import d.v.y.c.s;
import d.v.y.c.s0;
import d.v.y.c.s1.e.b;
import d.v.y.c.s1.e.c;
import d.v.y.c.s1.n.d;
import d.v.y.c.t;
import d.v.y.c.u;
import d.v.y.c.v;
import d.v.y.c.w;
import d.v.y.c.w0;
import d.v.y.c.x;
import d.v.y.c.x0;
import d.v.y.c.y0;
import d.v.y.d.e;
import d.v.y.d.k;
import e.a.a;
import e.a.d0;
import e.a.e0;
import e.a.i0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import j$.time.LocalDate;
import j$.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stabilizer
implements ud,
n0$a {
    private static final long r = 5000L;
    private static final int s = 255;
    public d.n.a.j0 a;
    public String b;
    private Model c;
    private Model d;
    private float e;
    private float f;
    private String g;
    private int h;
    private boolean i;
    private n0 j;
    private n0 k;
    private Stabilizer$i l;
    private sd m;
    private int n;
    private d o;
    private int p;
    private ee q;

    public Stabilizer(Model model, String string2, String string3, boolean bl2) {
        this(null, model, bl2);
        this.b = string2;
        this.g = string3;
    }

    public Stabilizer(Model model, boolean bl2) {
        this(null, model, bl2);
    }

    public Stabilizer(Stabilizer object) {
        int n10;
        float f10;
        this.p = 255;
        Object object2 = new ee();
        this.q = object2;
        this.a = object2 = ((Stabilizer)object).a;
        this.b = object2 = ((Stabilizer)object).b;
        object2 = ((Stabilizer)object).c;
        this.c = object2;
        this.e = f10 = ((Stabilizer)object).e;
        this.f = f10 = ((Stabilizer)object).f;
        object2 = ((Stabilizer)object).g;
        this.g = object2;
        this.h = n10 = ((Stabilizer)object).h;
        n10 = (int)(((Stabilizer)object).i ? 1 : 0);
        this.i = n10;
        object2 = ((Stabilizer)object).j;
        this.j = object2;
        object2 = ((Stabilizer)object).k;
        this.k = object2;
        object2 = ((Stabilizer)object).l;
        this.l = object2;
        object2 = ((Stabilizer)object).m;
        this.m = object2;
        object2 = ((Stabilizer)object).o;
        this.o = object2;
        this.q = object = ((Stabilizer)object).q;
    }

    public Stabilizer(d.n.a.j0 j02, Model model) {
        this(j02, model, false);
    }

    private Stabilizer(d.n.a.j0 object, Model model, boolean bl2) {
        ee ee2;
        int n10;
        this.p = n10 = 255;
        this.q = ee2 = new ee();
        this.a = object;
        this.c = model;
        this.i = bl2;
        object = object == null ? "" : object.getName();
        this.b = object;
        this.S6();
    }

    public static /* synthetic */ PowerMode A4(rd rd2) {
        return PowerMode.from(rd2.b());
    }

    public static /* synthetic */ Boolean A5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 A6(rd rd2) {
        int n10 = InteractCode.MAKE_INFO_D;
        rd2 = new rd(n10);
        return this.V7(rd2).U4(3);
    }

    public static /* synthetic */ ae B4(rd rd2) {
        return ae.b(rd2.b());
    }

    public static /* synthetic */ Boolean B5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Integer C4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean C5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ String C6(wd wd2, rd rd2) {
        return wd2.d();
    }

    public static /* synthetic */ Float D4(rd rd2) {
        return Float.valueOf((float)rd2.b() / 100.0f);
    }

    public static /* synthetic */ Boolean D5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ void D6(String string2) {
        this.g = string2;
    }

    public static /* synthetic */ Float E4(rd rd2) {
        return Float.valueOf((float)((short)rd2.b()) / 100.0f);
    }

    public static /* synthetic */ Boolean E5(List list) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Integer F4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean F5(q q10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Model F6(rd rd2) {
        return Model.from(rd2.b());
    }

    public static /* synthetic */ Strength G4(rd rd2) {
        return Strength.from(rd2.b());
    }

    public static /* synthetic */ boolean G5(Model model) {
        boolean bl2;
        Model model2 = Model.SMOOTH4;
        if (model == model2) {
            bl2 = true;
        } else {
            bl2 = false;
            model = null;
        }
        return bl2;
    }

    private /* synthetic */ void G6(Model model) {
        this.d = model;
    }

    private z G7() {
        int n10 = InteractCode.VERSION_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        Object object2 = f5.a;
        object = ((z)object).H3((o)object2);
        object2 = new l5(this);
        return ((z)object).f2((g)object2).U4(3);
    }

    public static /* synthetic */ boolean H4(Strength strength) {
        boolean bl2;
        Strength strength2 = Strength.N_CALIBRATION;
        if (strength != strength2 && strength != (strength2 = Strength.N_CALIBRATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            strength = null;
        }
        return bl2;
    }

    public static /* synthetic */ Integer H5(PhoneControlMode phoneControlMode, Model model) {
        return PhoneControlMode.to(phoneControlMode);
    }

    private z H7() {
        Object object = new wd();
        int n10 = InteractCode.MAKE_INFO_A;
        Object object2 = new rd(n10);
        object2 = this.V7((rd)object2).U4(3);
        Object object3 = new jd((wd)object);
        object2 = ((z)object2).f2((g)object3);
        object3 = new a6(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = new jd((wd)object);
        object2 = ((z)object2).f2((g)object3);
        object3 = new d3(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = new jd((wd)object);
        object2 = ((z)object2).f2((g)object3);
        object3 = new l6(this);
        object2 = ((z)object2).T0((o)object3);
        object3 = new jd((wd)object);
        object2 = ((z)object2).f2((g)object3);
        object3 = new o6((wd)object);
        object = ((z)object2).H3((o)object3);
        object2 = new j4(this);
        return ((z)object).f2((g)object2);
    }

    public static /* synthetic */ boolean I3(Stabilizer stabilizer, rd rd2) {
        return stabilizer.x3(rd2);
    }

    public static /* synthetic */ Functions I4(String string2) {
        Gson gson = new Gson();
        return (Functions)gson.fromJson(string2, Functions.class);
    }

    public static /* synthetic */ rd I5(Integer n10) {
        int n11 = InteractCode.PHONE_CONTROL_MODE;
        int n12 = n10;
        rd rd2 = new rd(n11, n12);
        return rd2;
    }

    private /* synthetic */ e0 I6(int n10, String string2) {
        return this.z0(n10);
    }

    public static /* synthetic */ Stabilizer$i J1(Stabilizer stabilizer) {
        return stabilizer.l;
    }

    public static /* synthetic */ Boolean J3(d.v.y.c.d d10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Pair J4(n keyFuncArray) {
        KeyFunc keyFunc = keyFuncArray.o();
        keyFuncArray = keyFuncArray.p();
        return Pair.create((Object)keyFunc, keyFuncArray);
    }

    public static /* synthetic */ Pair J5(m1 object) {
        Integer n10 = ((m1)object).n();
        object = ((m1)object).o();
        return Pair.create(n10, object);
    }

    private x0 J7(p p10) {
        x0 x02 = new x0();
        x02.s(p10);
        return x02;
    }

    public static /* synthetic */ void K1(Stabilizer stabilizer, boolean bl2) {
        stabilizer.L7(bl2);
    }

    public static /* synthetic */ z K3(Stabilizer stabilizer, rd rd2) {
        return stabilizer.V7(rd2);
    }

    public static /* synthetic */ Float K4(rd rd2) {
        return Float.valueOf((float)rd2.b() / 100.0f);
    }

    public static /* synthetic */ Boolean K5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ String[] K6(String string2, Integer n10) {
        return d.v.y.d.k.f(string2, 10, '\u0000');
    }

    private c1 K7(w0 w02) {
        c1 c12 = new c1();
        c12.s(w02);
        return c12;
    }

    public static /* synthetic */ Boolean L3(d.v.y.c.f f10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ WorkingMode L4(rd rd2) {
        return WorkingMode.from(rd2.b());
    }

    public static /* synthetic */ Boolean L5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 L6(String[] stringArray) {
        int n10 = stringArray.length;
        z z10 = z.u4(0, n10);
        s5 s52 = new s5(this, stringArray);
        return z10.T0(s52);
    }

    private void L7(boolean bl2) {
        int n10 = this.t3();
        if (n10 == 0) {
            return;
        }
        Object object = this.d;
        if (object == null || bl2) {
            n10 = InteractCode.DEVICE_CATEGORY_R;
            Object object2 = new rd(n10);
            object2 = this.V7((rd)object2);
            object = l2.a;
            object2 = ((z)object2).H3((o)object);
            object = new d6(this);
            xc xc2 = xc.a;
            ((z)object2).c((g)object, xc2);
        }
    }

    public static /* synthetic */ Pair M3(d.v.y.c.k object) {
        Status status = ((d.v.y.c.k)object).p();
        object = ((d.v.y.c.k)object).o();
        return Pair.create((Object)status, object);
    }

    public static /* synthetic */ Integer M4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean M5(rd rd2) {
        return Boolean.TRUE;
    }

    private z M7(FileType object, String object2) {
        int n10 = ((String)object2).length();
        Object object3 = Direction.SEND;
        object = this.d0((Direction)((Object)object3), (FileType)((Object)object));
        object3 = new z5(this, n10);
        object = ((z)object).T0((o)object3);
        t3 t32 = new t3((String)object2);
        object = ((z)object).H3(t32);
        object2 = new Stabilizer$a(this);
        object = ((z)object).f2((g)object2);
        object2 = new n4(this);
        object = ((z)object).T0((o)object2).e6(1);
        object2 = e3.a;
        return ((z)object).H3((o)object2);
    }

    public static /* synthetic */ Boolean N3(f1 f12) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Float N4(rd rd2) {
        return Float.valueOf((float)rd2.b() / 100.0f);
    }

    public static /* synthetic */ Boolean N5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean N6(String string2) {
        return Boolean.TRUE;
    }

    private z N7(p p10) {
        return this.O7(p10, true);
    }

    public static /* synthetic */ Boolean O3(e1 e12) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Integer O4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean O5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ int O6(Stabilizer stabilizer, rd rd2) {
        return stabilizer.P1(rd2);
    }

    private z O7(p p10, boolean bl2) {
        String string2 = this.m2(null);
        return this.P7(p10, bl2, string2);
    }

    private int P1(rd rd2) {
        int n10 = this.h2();
        int n11 = rd2.b() / n10;
        n10 = 1120403456;
        float f10 = 100.0f;
        int n12 = 325;
        float f11 = 4.55E-43f;
        if (n11 <= n12) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n13 = 400;
            if (n11 < n13) {
                float f12 = (float)(n11 -= n12) * 1.0f;
                n12 = 1117126656;
                f11 = 75.0f;
                f10 *= (f12 /= f11);
            }
        }
        return Math.round(f10);
    }

    public static /* synthetic */ Boolean P3(h1 h12) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 P4(Long object) {
        object = new m();
        int n10 = this.n;
        ((m)object).q(n10);
        return this.O7((p)object, false);
    }

    public static /* synthetic */ Boolean P5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ rd P6(d.v.y.c.e e10) {
        int n10 = e10.o();
        int n11 = e10.p();
        rd rd2 = new rd(n10, n11);
        return rd2;
    }

    private z P7(p object, boolean bl2, String string2) {
        boolean bl3 = this.H3();
        if (bl3) {
            object = this.J7((p)object);
            string2 = this.m2(string2);
            object = this.U7((a1)object, bl2, string2);
            d.v.e0.k0 k02 = d.v.e0.k0.a;
            return ((z)object).H3(k02);
        }
        n0 n02 = this.i2();
        String string3 = this.m2(string2);
        return n02.c((d.v.y.c.r0)object, 5000L, bl2, string3);
    }

    private /* synthetic */ e0 Q3(String string2) {
        return this.I();
    }

    public static /* synthetic */ Boolean Q5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ rd Q6(w0 w02) {
        int n10 = w02.n();
        int n11 = w02.o();
        rd rd2 = new rd(n10, n11);
        return rd2;
    }

    private z Q7(w0 w02) {
        String string2 = this.m2(null);
        return this.R7(w02, true, string2);
    }

    public static /* synthetic */ Boolean R4(m m10) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 R5(PowerMode powerMode, rd rd2) {
        return this.x7(powerMode, rd2);
    }

    public static /* synthetic */ Pair R6(x object) {
        Status status = ((x)object).p();
        object = ((x)object).o();
        return Pair.create((Object)status, object);
    }

    private z R7(w0 object, boolean bl2, String string2) {
        boolean bl3 = this.H3();
        if (bl3) {
            object = this.K7((w0)object);
            string2 = this.m2(string2);
            object = this.U7((a1)object, bl2, string2);
            d.v.e0.e1 e12 = d.v.e0.e1.a;
            return ((z)object).H3(e12);
        }
        n0 n02 = this.i2();
        String string3 = this.m2(string2);
        return n02.c((d.v.y.c.r0)object, 5000L, bl2, string3);
    }

    private d.v.y.c.e S1(rd rd2) {
        d.v.y.c.e e10 = new d.v.y.c.e();
        int n10 = d.v.y.d.e.a();
        e10.q((byte)n10);
        n10 = rd2.a();
        e10.r(n10);
        int n11 = rd2.b();
        e10.s(n11);
        return e10;
    }

    public static /* synthetic */ Integer S3(Integer n10) {
        int n11 = n10 % 10;
        int n12 = n10 / 10;
        if (n11 != 0) {
            ++n12;
        }
        return n12;
    }

    public static /* synthetic */ boolean S4(Strength strength) {
        boolean bl2;
        Strength strength2 = Strength.N_CALIBRATION;
        if (strength != strength2 && strength != (strength2 = Strength.N_CALIBRATED)) {
            bl2 = false;
            strength = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void S6() {
        Object object = new Stabilizer$c(this, this);
        this.m = object;
        object = this.q;
        Stabilizer$d stabilizer$d = new Stabilizer$d(this);
        ((ee)object).j(stabilizer$d);
    }

    private z S7(a1 a12) {
        String string2 = this.m2(null);
        return this.U7(a12, true, string2);
    }

    private w0 T1(rd rd2) {
        w0 w02 = new w0();
        int n10 = rd2.a();
        w02.p(n10);
        int n11 = rd2.b();
        w02.q(n11);
        return w02;
    }

    private /* synthetic */ e0 T3(Integer object) {
        int n10 = (Integer)object;
        object = z.u4(1, n10);
        rc rc2 = new rc(this);
        return ((z)object).T0(rc2);
    }

    public static /* synthetic */ MoveLine T4(Functions functions) {
        return functions.moveline;
    }

    public static /* synthetic */ Boolean T5(Boolean bl2) {
        return Boolean.TRUE;
    }

    private z T7(a1 a12, boolean bl2) {
        String string2 = this.m2(null);
        return this.U7(a12, bl2, string2);
    }

    public static /* synthetic */ Boolean U4(MoveLine moveLine) {
        boolean bl2;
        boolean bl3 = moveLine.move;
        if (!bl3) {
            return Boolean.FALSE;
        }
        bl3 = moveLine.wifi;
        if (!bl3 && !(bl2 = moveLine.ble)) {
            bl2 = false;
            moveLine = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ Boolean U5(rd rd2) {
        return Boolean.TRUE;
    }

    private z U7(a1 a12, boolean bl2, String string2) {
        short s10 = this.t3();
        n0 n02 = s10 != 0 ? this.e3() : this.i2();
        s10 = d.v.y.d.e.b();
        a12.q(s10);
        String string3 = this.m2(string2);
        return n02.c(a12, 5000L, bl2, string3);
    }

    public static /* synthetic */ String V3(StringBuilder stringBuilder, String string2) {
        return stringBuilder.toString();
    }

    public static /* synthetic */ Boolean V4(rd rd2) {
        int n10 = rd2.b();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            rd2 = null;
        }
        return n10 != 0;
    }

    public static /* synthetic */ Boolean V5(rd rd2) {
        return Boolean.TRUE;
    }

    private rd V6(byte[] object) {
        boolean bl2;
        int n10;
        Object object2 = this.c;
        int n11 = object2.isBl();
        if (n11 != 0 && (n10 = ((d.v.y.c.a)(object2 = new d.v.y.c.e())).parseFrom((byte[])object)) != 0) {
            object = new rd;
            n10 = ((d.v.y.c.e)object2).o();
            n11 = ((d.v.y.c.e)object2).p();
            object(n10, n11);
            return object;
        }
        object2 = this.c;
        n11 = object2.isBl();
        if (n11 == 0 && (bl2 = ((d.v.y.c.a)(object2 = new w0())).parseFrom((byte[])object))) {
            object = new rd;
            n10 = ((w0)object2).n();
            n11 = ((w0)object2).o();
            object(n10, n11);
            return object;
        }
        return null;
    }

    private z V7(rd rd2) {
        String string2 = this.m2(null);
        return this.X7(rd2, true, string2);
    }

    public static /* synthetic */ Boolean W3(i1 i12) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 W4(String[] object, Integer n10) {
        int n11 = n10 + 1;
        int n12 = n10;
        object = object[n12];
        return this.D1(n11, (String)object);
    }

    public static /* synthetic */ Boolean W5(rd rd2) {
        return Boolean.TRUE;
    }

    private Pair W6(byte[] object) {
        boolean bl2;
        Object object2 = this.c;
        boolean bl3 = object2.isBl();
        if (bl3 && (bl2 = ((k1)(object2 = new d.v.y.c.o1())).parseFrom((byte[])object))) {
            object = ((d.v.y.c.o1)object2).n();
            object2 = ((d.v.y.c.o1)object2).o();
            return Pair.create(object, object2);
        }
        return null;
    }

    private z W7(rd rd2, boolean bl2) {
        String string2 = this.m2(null);
        return this.X7(rd2, bl2, string2);
    }

    private /* synthetic */ byte[] X3(byte[] byArray) {
        return HWAes.decrypt(this.e2(), byArray);
    }

    public static /* synthetic */ Boolean X5(rd rd2) {
        return Boolean.TRUE;
    }

    private z X7(rd object, boolean bl2, String string2) {
        Model model = this.c;
        boolean bl3 = model.isBl();
        if (bl3) {
            object = this.S1((rd)object);
            string2 = this.m2(string2);
            object = this.P7((p)object, bl2, string2);
            d.v.e0.i1 i12 = d.v.e0.i1.a;
            return ((z)object).H3(i12);
        }
        object = this.T1((rd)object);
        string2 = this.m2(string2);
        object = this.R7((w0)object, bl2, string2);
        p3 p32 = p3.a;
        return ((z)object).H3(p32);
    }

    private /* synthetic */ e0 Y4(byte[] object) {
        if ((object = (Object)this.V6((byte[])object)) == null) {
            return z.l2();
        }
        return z.t3(object);
    }

    public static /* synthetic */ Boolean Y5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ ActiveInfo Z3(d.v.y.c.b object) {
        Object object2;
        int n10;
        ActiveState activeState = ((d.v.y.c.b)object).q();
        int n11 = ((d.v.y.c.b)object).r();
        if (n11 >= (n10 = 2000) && (n11 = ((d.v.y.c.b)object).o()) > 0) {
            n11 = ((d.v.y.c.b)object).r();
            object2 = Year.of(n11);
            n10 = ((d.v.y.c.b)object).o();
            object2 = ((Year)object2).atDay(n10).toString();
        } else {
            object2 = "0000-00-00";
        }
        object = ((d.v.y.c.b)object).p();
        ActiveInfo activeInfo = new ActiveInfo(activeState, (String)object2, (byte[])object);
        return activeInfo;
    }

    public static /* synthetic */ Boolean Z5(rd rd2) {
        return Boolean.TRUE;
    }

    private z a2(FileType object) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = Direction.RECV;
        object = this.d0((Direction)((Object)object2), (FileType)((Object)object));
        object2 = new w1(this);
        object = ((z)object).T0((o)object2);
        object2 = j6.a;
        object = ((z)object).H3((o)object2);
        object2 = new l3(this);
        object = ((z)object).T0((o)object2);
        object2 = new dc(stringBuilder);
        object = ((z)object).f2((g)object2).e6(1);
        object2 = new o2(stringBuilder);
        return ((z)object).H3((o)object2);
    }

    public static /* synthetic */ Float a4(rd rd2) {
        return Float.valueOf((float)((short)rd2.b()) * 1.0f / 100.0f);
    }

    public static /* synthetic */ Boolean a5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean a6(rd rd2) {
        return Boolean.TRUE;
    }

    private z a7(int n10) {
        int n11 = InteractCode.SET_BUTTON_EVENT;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = j5.a;
        return z10.H3((o)object);
    }

    public static /* synthetic */ CameraManufacturer b4(rd rd2) {
        return CameraManufacturer.from(rd2.b());
    }

    public static /* synthetic */ Boolean b5(Boolean bl2, Boolean bl3) {
        boolean bl4 = bl2;
        boolean bl5 = bl3;
        return bl4 & bl5;
    }

    public static /* synthetic */ Boolean b6(rd rd2) {
        return Boolean.TRUE;
    }

    private float c2(float f10, d.v.y.d.i object) {
        Integer n10 = (Integer)((d.v.y.d.i)object).h();
        float f11 = n10.floatValue();
        float f12 = ((Integer)(object = (Integer)((d.v.y.d.i)object).i())).floatValue();
        float f13 = f10 - f12;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            return f11 + (f10 -= f12);
        }
        object2 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object2 < 0) {
            f10 = Math.abs(f10 - f11);
            return f12 - f10;
        }
        return f10;
    }

    private /* synthetic */ void c4(d d10) {
        this.o = d10;
    }

    public static /* synthetic */ Boolean c5(s s10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean c6(rd rd2) {
        return Boolean.TRUE;
    }

    private z c7(int n10, float f10) {
        boolean bl2 = yd.e(f10);
        if (!bl2) {
            return z.t3(Boolean.TRUE);
        }
        int n11 = Math.round(f10 * 100.0f);
        rd rd2 = new rd(n10, n11);
        z z10 = this.V7(rd2);
        j3 j32 = j3.a;
        return z10.H3(j32);
    }

    private /* synthetic */ byte[] d5(byte[] byArray) {
        return HWAes.encrypt(this.e2(), byArray);
    }

    public static /* synthetic */ Boolean d6(SceneMode sceneMode, rd rd2) {
        int n10;
        int n11 = rd2.b();
        if (n11 == (n10 = sceneMode.value)) {
            n10 = 1;
        } else {
            n10 = 0;
            sceneMode = null;
        }
        return n10 != 0;
    }

    private n0 e3() {
        n0 n02 = this.k;
        if (n02 == null) {
            this.k = n02 = p0.g();
            n02.d(this);
            n02 = this.k;
            n02.connect();
        }
        return this.k;
    }

    public static /* synthetic */ DebugMode e4(rd rd2) {
        return DebugMode.from(rd2.b());
    }

    public static /* synthetic */ Boolean e6(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean f4(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 != (n11 = 1)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static /* synthetic */ Boolean f5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 f6(int n10, rd rd2) {
        int n11 = InteractCode.TRACKING_PITCH;
        rd2 = new rd(n11, n10);
        return this.W7(rd2, false);
    }

    private z g2(int n10) {
        Object object = new rd(n10);
        z z10 = this.V7((rd)object);
        object = j2.a;
        return z10.H3((o)object);
    }

    public static /* synthetic */ Pair g4(w object) {
        Status status = ((w)object).p();
        object = ((w)object).o();
        return Pair.create((Object)status, object);
    }

    public static /* synthetic */ Boolean g5(d.v.y.c.q1 q12) {
        return Boolean.TRUE;
    }

    private boolean h3() {
        int n10 = this.p;
        int n11 = 255;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ IMUControlMode h4(rd rd2) {
        return IMUControlMode.from(rd2.b());
    }

    public static /* synthetic */ Boolean h5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean h6(rd rd2) {
        return Boolean.TRUE;
    }

    private n0 i2() {
        return this.j;
    }

    private /* synthetic */ e0 i4(Model enum_) {
        Object object = Stabilizer$e.b;
        int n10 = enum_.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 4) && n11 != (n10 = 5)) {
            object = new UnsupportedException;
            object((Model)enum_);
            return z.m2((Throwable)object);
        }
        enum_ = FileType.MODULES;
        return this.a2((FileType)enum_);
    }

    private /* synthetic */ byte[] i5(byte[] byArray) {
        return HWAes.encrypt(this.e2(), byArray);
    }

    public static /* synthetic */ Boolean i6(rd rd2) {
        return Boolean.TRUE;
    }

    private void i7(d.n.a.j0 j02) {
        this.a = j02;
    }

    public static /* synthetic */ Boolean j6(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ void k4(Modules modules) {
        Model model = this.c;
        modules.setModel(model);
    }

    public static /* synthetic */ Boolean k5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean k6(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean l5(CCSParams cCSParams) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean l6(rd rd2) {
        return Boolean.TRUE;
    }

    private String m2(String string2) {
        return "";
    }

    private /* synthetic */ void m4(Modules modules) {
        float f10;
        this.f = f10 = modules.getVersion();
    }

    public static /* synthetic */ Boolean m5(CCSParams cCSParams) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean m6(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean n5(CCSParams cCSParams) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean n6(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 o4(Modules modules) {
        return this.W();
    }

    public static /* synthetic */ Boolean o5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean o6(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean p5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean p6(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ Modules q4(Modules modules, String string2) {
        modules.setSsid(string2);
        this.b = string2;
        return modules;
    }

    public static /* synthetic */ Boolean q5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean q6(t t10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean r5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean r6(u u10) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ int[] s4(String string2) {
        Gson gson = new Gson();
        return (int[])gson.fromJson(string2, int[].class);
    }

    public static /* synthetic */ Boolean s5(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean s6(rd rd2) {
        return Boolean.TRUE;
    }

    public static /* synthetic */ int[] t4(int[] nArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            nArray[i10] = n10 = Math.abs(nArray[i10]);
        }
        return nArray;
    }

    public static /* synthetic */ Boolean t5(HotspotStatus hotspotStatus) {
        boolean bl2;
        HotspotStatus hotspotStatus2 = HotspotStatus.ERROR;
        if (hotspotStatus != hotspotStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            hotspotStatus = null;
        }
        return bl2;
    }

    public static /* synthetic */ Float t6(rd rd2) {
        return Float.valueOf((float)rd2.b() / 100.0f);
    }

    public static /* synthetic */ Pair u4(d.v.y.c.p1 object) {
        Integer n10 = ((d.v.y.c.p1)object).n();
        object = ((d.v.y.c.p1)object).o();
        return Pair.create(n10, object);
    }

    public static /* synthetic */ Boolean u5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ void u6(Float f10) {
        float f11;
        this.e = f11 = f10.floatValue();
    }

    public static /* synthetic */ Integer v4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean v5(JoystickSpeed joystickSpeed, rd rd2) {
        int n10;
        int n11 = rd2.b();
        if (n11 == (n10 = joystickSpeed.code)) {
            n10 = 1;
        } else {
            n10 = 0;
            joystickSpeed = null;
        }
        return n10 != 0;
    }

    public static /* synthetic */ Float w4(rd rd2) {
        return Float.valueOf((float)rd2.b() / 100.0f);
    }

    public static /* synthetic */ Boolean w5(d.v.y.c.o o10) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 w6(rd rd2) {
        int n10 = InteractCode.MAKE_INFO_B;
        rd2 = new rd(n10);
        return this.V7(rd2).U4(3);
    }

    private a w7(PhoneControlMode object) {
        Object object2 = z.t3((Object)this.H2());
        Object object3 = y2.a;
        object2 = ((z)object2).o2((r)object3);
        object3 = new q5((PhoneControlMode)((Object)object));
        object = ((z)object2).H3((o)object3);
        object2 = w4.a;
        object = ((z)object).H3((o)object2);
        object2 = new u4(this);
        return ((z)object).s2((o)object2).k3();
    }

    private boolean x3(rd rd2) {
        int n10;
        int n11 = rd2.a() & 0xFF;
        if (n11 == (n10 = 32)) {
            n11 = 1;
        } else {
            n11 = 0;
            rd2 = null;
        }
        return n11 != 0;
    }

    public static /* synthetic */ Float x4(rd rd2) {
        return Float.valueOf((float)((short)rd2.b()) / 100.0f);
    }

    public static /* synthetic */ Boolean x5(rd rd2) {
        return Boolean.TRUE;
    }

    private z x7(PowerMode object, rd object2) {
        object2 = PowerMode.ON;
        if (object == object2) {
            return z.t3(Boolean.TRUE);
        }
        int n10 = InteractCode.PowerOff;
        object = new rd(n10, 21930);
        object = this.V7((rd)object);
        object2 = k4.a;
        return ((z)object).H3((o)object2);
    }

    public static /* synthetic */ Integer y4(rd rd2) {
        return rd2.b() / 100;
    }

    public static /* synthetic */ Boolean y5(rd rd2) {
        return Boolean.TRUE;
    }

    private /* synthetic */ e0 y6(rd rd2) {
        int n10 = InteractCode.MAKE_INFO_C;
        rd2 = new rd(n10);
        return this.V7(rd2).U4(3);
    }

    public static /* synthetic */ yd z4(List list) {
        float f10 = ((Float)list.get(0)).floatValue();
        float f11 = ((Float)list.get(1)).floatValue();
        float f12 = ((Float)list.get(2)).floatValue();
        yd yd2 = new yd(f10, f11, f12);
        return yd2;
    }

    public static /* synthetic */ Boolean z5(rd rd2) {
        return Boolean.TRUE;
    }

    public void A(w0 w02) {
    }

    public void A0(d d10) {
        this.o = d10;
        this.q.k(d10);
    }

    public z A1(int n10) {
        Object object = new g1();
        Object object2 = ((g1)object).p(n10);
        object2 = this.N7((p)object2);
        object = o0.a;
        return ((z)object2).H3((o)object);
    }

    public List A2() {
        return this.v2().joystickSpeed;
    }

    public boolean A3() {
        Functions functions = this.v2();
        int n10 = functions.photo;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public a A7(int n10) {
        int n11 = InteractCode.TRACK_SENSITIVITY;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = e.a.c1.b.d();
        return z10.L5((e.a.h0)object).k3();
    }

    public z B() {
        Object object = new d.v.y.c.n0();
        object = this.N7((p)object);
        hc hc2 = hc.a;
        return ((z)object).H3(hc2);
    }

    public z B0() {
        int n10 = InteractCode.PITCH_ANGLE_R;
        return this.g2(n10);
    }

    public z B1() {
        Object object = new g1();
        object = ((g1)object).p(0);
        object = this.N7((p)object);
        d.v.e0.g1 g12 = d.v.e0.g1.a;
        return ((z)object).H3(g12);
    }

    public List B2() {
        return this.v2().sceneModes;
    }

    public boolean B3() {
        Functions functions = this.v2();
        int n10 = functions.showmode;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ e0 B6(rd rd2) {
        return this.A6(rd2);
    }

    public z B7(int n10, int n11) {
        int n12 = InteractCode.TRACKING_YAW;
        Object object = new rd(n12, n10);
        z z10 = this.W7((rd)object, false);
        object = new b2(this, n11);
        z10 = z10.s2((o)object);
        y4 y42 = y4.a;
        return z10.H3(y42);
    }

    public z C(FunctionEvent object) {
        int n10 = InteractCode.FUNCTION_EVENT;
        int n11 = FunctionEvent.to((FunctionEvent)((Object)object));
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = TimeUnit.MILLISECONDS;
        object = ((z)object).E1(1500L, (TimeUnit)((Object)object2));
        object2 = n6.a;
        return ((z)object).H3((o)object2);
    }

    public z C0() {
        Object object = new g0();
        ((g0)object).t(false);
        object = this.N7((p)object);
        gd gd2 = gd.a;
        return ((z)object).H3(gd2);
    }

    public z C1() {
        int n10 = InteractCode.PITCH_DEADBAND_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        w2 w22 = w2.a;
        return ((z)object).H3(w22);
    }

    public z C2() {
        int n10 = InteractCode.MSC_PITCH_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        tc tc2 = tc.a;
        return ((z)object).H3(tc2);
    }

    public boolean C3() {
        Functions functions = this.v2();
        int n10 = functions.storyMode;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void C7(boolean bl2) {
        this.i = bl2;
        if (bl2) {
            this.V1();
        } else {
            this.Z1();
        }
    }

    public z D() {
        int n10 = InteractCode.MOTOR_ROLL_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z D0(float f10) {
        int n10 = InteractCode.YAW_DEADBAND_W;
        int n11 = Math.round(f10 * 100.0f);
        Object object = new rd(n10, n11);
        z z10 = this.V7((rd)object);
        object = s3.a;
        return z10.H3((o)object);
    }

    public z D1(int n10, String object) {
        l l10 = new l();
        Direction direction = Direction.SEND;
        l10.t(direction);
        l10.w(n10);
        l10.s((String)object);
        z z10 = this.N7(l10);
        object = d.v.e0.l0.a;
        return z10.H3((o)object);
    }

    public z D2() {
        int n10 = InteractCode.MSC_ROLL_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        tc tc2 = tc.a;
        return ((z)object).H3(tc2);
    }

    public z D3() {
        z z10 = this.X2();
        o o10 = g6.a;
        z10 = z10.H3(o10);
        o10 = d5.a;
        return z10.H3(o10);
    }

    public z D7(Axis object, long l10) {
        Object object2 = new t();
        ((t)object2).o((Axis)object);
        object = this.O7((p)object2, false);
        object2 = c2.a;
        object = ((z)object).H3((o)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = TimeUnit.MILLISECONDS;
        return ((z)object).E1(l10, (TimeUnit)((Object)object2));
    }

    public z E() {
        int n10 = InteractCode.YAW_SMOOTHNESS_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z E0(int n10) {
        int n11 = InteractCode.ROLL_FOLLOW_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = p2.a;
        return z10.H3((o)object);
    }

    public z E1() {
        int n10 = InteractCode.PITCH_CONTROL_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        b5 b52 = b5.a;
        return ((z)object).H3(b52);
    }

    public z E2() {
        int n10 = InteractCode.MSC_YAW_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        tc tc2 = tc.a;
        return ((z)object).H3(tc2);
    }

    public boolean E3() {
        Functions functions = this.u2();
        int n10 = functions.update;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ void E6(String string2) {
        this.D6(string2);
    }

    public z E7(Axis object, long l10) {
        Object object2 = new u();
        ((u)object2).o((Axis)object);
        object = this.O7((p)object2, false);
        object2 = c6.a;
        object = ((z)object).H3((o)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = TimeUnit.MILLISECONDS;
        return ((z)object).E1(l10, (TimeUnit)((Object)object2));
    }

    public z F() {
        int n10 = InteractCode.IMUAZ_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        ld ld2 = ld.a;
        return ((z)object).H3(ld2);
    }

    public z F0(int n10, int n11) {
        m1 m12 = new m1();
        Object object = m12.p(n10).q(n11);
        object = this.N7((p)object);
        c5 c52 = c5.a;
        return ((z)object).H3(c52);
    }

    public z F1() {
        int n10 = InteractCode.YAW_ANGLE_R;
        return this.g2(n10);
    }

    public String F2() {
        Object object = this.a;
        object = object == null ? "" : object.e();
        return object;
    }

    public boolean F3() {
        Functions functions = this.v2();
        int n10 = functions.video;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public z F7(boolean bl2) {
        void var1_4;
        int n10 = InteractCode.SWITCH_ORIENTATION;
        if (bl2) {
            int n11 = 42405;
        } else {
            int n12 = 21930;
        }
        Object object = new rd(n10, (int)var1_4);
        z z10 = this.V7((rd)object);
        object = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object);
        object = t5.a;
        return z10.H3((o)object);
    }

    public z G(int n10) {
        int n11 = InteractCode.YAW_FOLLOW_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = p6.a;
        return z10.H3((o)object);
    }

    public z G0(int n10) {
        int n11 = InteractCode.ZOOM_CONTROL;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = u2.a;
        return z10.H3((o)object);
    }

    public z G1(IMUControlMode object) {
        int n10 = InteractCode.IMUControlRegister_W;
        int n11 = IMUControlMode.to((IMUControlMode)((Object)object));
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = i6.a;
        return ((z)object).H3((o)object2);
    }

    public String G2() {
        return this.g;
    }

    public boolean G3() {
        Functions functions = this.v2();
        int n10 = functions.wifiChannel;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public z H(int n10) {
        Object object = this.o;
        if (object != null) {
            return z.t3(object);
        }
        object = new HashMap();
        Object object2 = n10;
        ((HashMap)object).put(object2, "");
        object2 = new v();
        byte by2 = d.v.y.d.e.a();
        ((v)object2).q(by2);
        ((v)object2).p((Map)object);
        object2 = this.N7((p)object2);
        object = ic.a;
        object2 = ((z)object2).H3((o)object);
        object = new d.v.e0.l1(this);
        return ((z)object2).f2((g)object);
    }

    public z H0() {
        int n10 = InteractCode.ROCKER_DIRECTION_CONFIG_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        a3 a32 = a3.a;
        return ((z)object).H3(a32);
    }

    public z H1(int n10) {
        int n11 = InteractCode.LOCATION_POINT_CONTROLLER;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = v4.a;
        return z10.H3((o)object);
    }

    public Model H2() {
        return this.c;
    }

    public boolean H3() {
        return this.i;
    }

    public /* synthetic */ void H6(Model model) {
        this.G6(model);
    }

    public z I() {
        Object object = new l();
        Object object2 = Direction.RECV;
        ((l)object).t((Direction)((Object)object2));
        ((l)object).w(0);
        object = this.N7((p)object);
        object2 = d.v.e0.g.a;
        return ((z)object).H3((o)object2);
    }

    public z I0() {
        Object object = new f0();
        object = this.N7((p)object);
        ad ad2 = ad.a;
        return ((z)object).H3(ad2);
    }

    public a I1() {
        PhoneControlMode phoneControlMode = PhoneControlMode.BEGIN;
        return this.w7(phoneControlMode);
    }

    public z I2() {
        z z10 = z.t3((Object)this.c);
        Object object = new q2(this);
        z10 = z10.s2((o)object);
        object = kc.a;
        z10 = z10.H3((o)object);
        object = new q3(this);
        z10 = z10.f2((g)object);
        object = new x3(this);
        z10 = z10.f2((g)object);
        object = new m2(this);
        r4 r42 = new r4(this);
        return z10.u2((o)object, r42);
    }

    public z I7() {
        int n10 = InteractCode.SysReset;
        Object object = new rd(n10, 41299);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z J() {
        int n10 = InteractCode.GET_MOTOR_FORCE;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        q6 q62 = q6.a;
        return ((z)object).H3(q62);
    }

    public z J0(int n10) {
        int n11 = InteractCode.PITCH_FOLLOW_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = y1.a;
        return z10.H3((o)object);
    }

    public MoveLimit J2() {
        return this.v2().moveLimit;
    }

    public /* synthetic */ e0 J6(int n10, String string2) {
        return this.I6(n10, string2);
    }

    public z K() {
        int n10 = InteractCode.YAW_CONTROL_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        r3 r32 = r3.a;
        return ((z)object).H3(r32);
    }

    public z K0() {
        int n10 = InteractCode.ROLL_FOLLOW_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        t2 t22 = t2.a;
        return ((z)object).H3(t22);
    }

    public MoveLine K2() {
        return this.v2().moveline;
    }

    public z L() {
        Object object = new j0();
        object = this.N7((p)object);
        wc wc2 = wc.a;
        return ((z)object).H3(wc2);
    }

    public z L0() {
        double d10;
        int n10;
        Object object = Stabilizer$e.b;
        Object object2 = this.c;
        int n11 = object2.ordinal();
        int n12 = object[n11];
        double d11 = 1.7;
        int n13 = 5;
        float f10 = 7.0E-45f;
        int n14 = 1;
        if (n12 != n14 && n12 != (n10 = 2) && n12 != (n10 = 3) && n12 != (n10 = 4) && n12 != n13) {
            float f11 = this.e;
            d10 = f11;
            double d12 = d10 - d11;
            n12 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
            if (n12 >= 0) {
                n12 = 13;
                f11 = 1.8E-44f;
            } else {
                n12 = 6;
                f11 = 8.4E-45f;
            }
            n13 = 0;
            f10 = 0.0f;
            n12 = d.v.y.b.g.c(0, n12);
        } else {
            n12 = d.v.y.b.g.c(n14, n13);
        }
        f10 = this.e;
        d10 = f10;
        n11 = (int)(d10 == d11 ? 0 : (d10 > d11 ? 1 : -1));
        if (n11 >= 0) {
            return this.a7(n12);
        }
        object2 = this.a7(n12);
        object = this.a7(n12);
        v5 v52 = v5.a;
        return z.W7((e0)object2, (e0)object, v52);
    }

    public z L1() {
        Object object = new d.v.y.c.d();
        object = this.O7((p)object, false);
        Object object2 = r1.a;
        object = ((z)object).H3((o)object2);
        Boolean bl2 = Boolean.TRUE;
        object2 = new d.v.e0.me.a(bl2);
        return ((z)object).G3((d0)object2);
    }

    public z L2() {
        Object object = new q();
        object = this.N7((p)object);
        md md2 = md.a;
        return ((z)object).H3(md2);
    }

    public z M() {
        boolean bl2;
        Object object = new StringBuilder();
        String string2 = this.g;
        ((StringBuilder)object).append(string2);
        string2 = "";
        ((StringBuilder)object).append(string2);
        object = z.t3(((StringBuilder)object).toString());
        z z10 = this.H7();
        String string3 = this.g;
        if (string3 == null || (bl2 = string2.equals(string3))) {
            object = z10;
        }
        return object;
    }

    public z M0() {
        Object object = new h0();
        ((h0)object).q(true);
        object = this.N7((p)object);
        d.v.e0.x0 x02 = d.v.e0.x0.a;
        return ((z)object).H3(x02);
    }

    public z M1() {
        Object object = new d.v.y.c.f();
        object = this.O7((p)object, false);
        Object object2 = g2.a;
        object = ((z)object).H3((o)object2);
        Boolean bl2 = Boolean.TRUE;
        object2 = new d.v.e0.me.a(bl2);
        return ((z)object).G3((d0)object2);
    }

    public String M2() {
        Object object = this.a;
        object = object == null ? this.b : object.getName();
        return object;
    }

    public /* synthetic */ e0 M6(String[] stringArray) {
        return this.L6(stringArray);
    }

    public z N() {
        Object object = new g0();
        ((g0)object).t(true);
        Object object2 = ChannelMode.AUTO;
        ((g0)object).s((ChannelMode)((Object)object2));
        object = this.N7((p)object);
        object2 = ac.a;
        return ((z)object).H3((o)object2);
    }

    public z N0() {
        int n10 = InteractCode.ROLL_CONTROL_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        h4 h42 = h4.a;
        return ((z)object).H3(h42);
    }

    public boolean N1() {
        Functions functions = this.v2();
        int n10 = functions.bhTest;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int N2() {
        int n10 = this.z3();
        if (n10 != 0) {
            Model model = this.w2();
            n10 = model.getOemSerial();
        } else {
            n10 = 0;
            Object var2_3 = null;
        }
        return n10;
    }

    public z O() {
        int n10 = InteractCode.ROLL_SMOOTHNESS_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z O0(int n10) {
        Object object = new g0();
        ((g0)object).t(true);
        ChannelMode channelMode = ChannelMode.MANUAL;
        ((g0)object).s(channelMode);
        ((g0)object).r(n10);
        z z10 = this.N7((p)object);
        object = gd.a;
        return z10.H3((o)object);
    }

    public z O1() {
        Object object = new d.v.y.c.g();
        object = this.N7((p)object);
        v0 v02 = v0.a;
        return ((z)object).H3(v02);
    }

    public z O2() {
        Object object = FileType.PATHPOINT;
        object = this.a2((FileType)((Object)object));
        o o10 = x1.a;
        object = ((z)object).H3(o10);
        o10 = b3.a;
        return ((z)object).H3(o10);
    }

    public z P(CameraBrand object) {
        Object object2 = new d1();
        ((d1)object2).o((CameraBrand)((Object)object));
        object = this.N7((p)object2);
        object2 = zb.a;
        return ((z)object).H3((o)object2);
    }

    public z P0() {
        int n10 = InteractCode.Save;
        Object object = new rd(n10, 41297);
        object = this.V7((rd)object);
        g3 g32 = g3.a;
        return ((z)object).H3(g32);
    }

    public List P2() {
        return this.v2().preset;
    }

    public z Q() {
        int n10 = InteractCode.MOTOR_YAW_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z Q0() {
        boolean bl2 = this.h3();
        if (bl2) {
            return z.t3(this.p);
        }
        int n10 = InteractCode.GET_BATTERY_VOLTAGE;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        m6 m62 = new m6(this);
        return ((z)object).H3(m62);
    }

    public z Q1(int n10) {
        Object object = new d.v.y.c.k();
        ((d.v.y.c.k)object).r(n10);
        z z10 = this.N7((p)object);
        object = t1.a;
        return z10.H3((o)object);
    }

    public PresetLimit Q2() {
        return this.v2().presetLimit;
    }

    public /* synthetic */ e0 Q4(Long l10) {
        return this.P4(l10);
    }

    public z R(int n10) {
        int n11 = InteractCode.ROLL_SMOOTHNESS_W;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = d.v.e0.k1.a;
        return z10.H3((o)object);
    }

    public z R0(int n10) {
        int n11 = InteractCode.YAW_SMOOTHNESS_W;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = w3.a;
        return z10.H3((o)object);
    }

    public z R1(String object) {
        Object object2 = new d.v.y.c.t0();
        ((d.v.y.c.t0)object2).p((String)object);
        object = this.N7((p)object2);
        object2 = mc.a;
        object = ((z)object).H3((o)object2);
        OtherStatus otherStatus = OtherStatus.NONE_ERROR;
        object2 = new d.v.e0.me.a((Object)otherStatus);
        return ((z)object).G3((d0)object2);
    }

    public int R2() {
        return this.v2().resetMethod;
    }

    public /* synthetic */ e0 R3(String string2) {
        return this.Q3(string2);
    }

    public z S() {
        Object object = new h0();
        ((h0)object).q(false);
        object = this.N7((p)object);
        d.v.e0.w0 w02 = d.v.e0.w0.a;
        return ((z)object).H3(w02);
    }

    public void S0(boolean bl2, int n10, ErrorStatus errorStatus) {
        this.p = n10;
        be.m().t(bl2, n10, errorStatus);
    }

    public int S2() {
        return this.h;
    }

    public /* synthetic */ e0 S5(PowerMode powerMode, rd rd2) {
        return this.R5(powerMode, rd2);
    }

    public z T() {
        Object object = new d.v.y.c.j();
        ((d.v.y.c.j)object).o(true);
        object = this.N7((p)object);
        t0 t02 = t0.a;
        return ((z)object).H3(t02);
    }

    public z T0(int n10) {
        int n11 = InteractCode.PITCH_CONTROL_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = s2.a;
        return z10.H3((o)object);
    }

    public z T2() {
        int n10 = InteractCode.SCENE_MODE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = cd.a;
        object = ((z)object).H3((o)object2);
        object2 = bd.a;
        return ((z)object).H3((o)object2);
    }

    public z T6() {
        Object object = this.j;
        Object object2 = he.a(this.c);
        object = object.b((UUID)object2);
        object2 = new r5(this);
        object = ((z)object).s2((o)object2);
        object2 = new m4(this);
        object = ((z)object).o2((r)object2);
        object2 = cd.a;
        object = ((z)object).H3((o)object2);
        object2 = sc.a;
        return ((z)object).H3((o)object2);
    }

    public z U() {
        Object object = new h1();
        object = this.N7((p)object);
        i5 i52 = i5.a;
        return ((z)object).H3(i52);
    }

    public z U0(int n10) {
        Object object = new l();
        Direction direction = Direction.RECV;
        ((l)object).t(direction);
        ((l)object).w(n10);
        z z10 = this.N7((p)object);
        object = d.v.e0.l0.a;
        return z10.H3((o)object);
    }

    public void U1(Context object, Stabilizer$i object2) {
        synchronized (this) {
            this.l = object2;
            object2 = this.m;
            ((sd)object2).x();
            d.n.a.j0 j02 = this.a;
            Model model = this.c;
            object2 = new d.v.e0.ne.k0((Context)object, j02, model);
            this.j = object2;
            object2.d(this);
            object = this.j;
            object.connect();
            return;
        }
    }

    public StoryAttribute U2() {
        return this.v2().storyAttribute;
    }

    public /* synthetic */ e0 U3(Integer n10) {
        return this.T3(n10);
    }

    public z U6() {
        Object object = Boolean.FALSE;
        boolean bl2 = this.H3();
        if (bl2) {
            Object object2 = new d.v.y.c.r();
            object2 = this.N7((p)object2);
            Object object3 = dd.a;
            object2 = ((z)object2).H3((o)object3);
            object3 = new d.v.e0.me.a(object);
            object = ((z)object2).G3((d0)object3);
        } else {
            object = z.t3(object);
        }
        return object;
    }

    public z V(float f10) {
        d.v.y.d.i i10 = this.v2().moveLimit.roll;
        f10 = this.c2(f10, i10);
        int n10 = InteractCode.ROLL_ROTATE_ANGLE_CONTROL;
        return this.c7(n10, f10);
    }

    public z V0(int n10) {
        int n11 = InteractCode.ROLL_CONTROL_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = z2.a;
        return z10.H3((o)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void V1() {
        synchronized (this) {
            n0 n02 = this.k;
            if (n02 != null) {
                boolean bl2 = true;
                n02.a(bl2);
            }
            return;
        }
    }

    public StrengthLimit V2() {
        return this.v2().strengthLimit;
    }

    public z W() {
        Object object = new d.v.y.c.p0();
        object = this.N7((p)object);
        Object object2 = d.v.e0.y0.a;
        object = ((z)object).H3((o)object2);
        object2 = fd.a;
        return ((z)object).f2((g)object2);
    }

    public z W0() {
        Object object = new k0();
        object = this.N7((p)object);
        f f10 = d.v.e0.f.a;
        return ((z)object).H3(f10);
    }

    public Stabilizer W1() {
        Stabilizer stabilizer = new Stabilizer(this);
        return stabilizer;
    }

    public List W2() {
        Stream stream = this.v2().motorStrength.stream();
        Object object = c3.a;
        stream = stream.filter(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public z X(float f10) {
        int n10 = InteractCode.PITCH_DEADBAND_W;
        int n11 = Math.round(f10 * 100.0f);
        Object object = new rd(n10, n11);
        z z10 = this.V7((rd)object);
        object = d.v.e0.j1.a;
        return z10.H3((o)object);
    }

    public z X0(int n10) {
        Object object = this.V2().yaw;
        if (object == null) {
            return z.t3(Boolean.TRUE);
        }
        object = this.V2().yaw;
        Object object2 = n10;
        object2 = (Integer)((d.v.y.d.i)object).a((Comparable)object2);
        int n11 = InteractCode.MOTOR_YAW_W;
        n10 = (Integer)object2;
        object = new rd(n11, n10);
        object2 = this.V7((rd)object);
        object = g5.a;
        return ((z)object2).H3((o)object);
    }

    public Stabilizer X1() {
        Stabilizer stabilizer = this.W1();
        Object object = this.a;
        if (object != null) {
            stabilizer.b = object = object.getName();
        }
        stabilizer.i7(null);
        return stabilizer;
    }

    public z X2() {
        Object object = FileType.SUPPORT;
        object = this.a2((FileType)((Object)object));
        e2 e22 = e2.a;
        return ((z)object).H3(e22);
    }

    public /* synthetic */ e0 X4(String[] stringArray, Integer n10) {
        return this.W4(stringArray, n10);
    }

    /*
     * WARNING - void declaration
     */
    public z X6(boolean bl2) {
        void var1_4;
        int n10 = InteractCode.CALIBRATION_QUICK;
        if (bl2) {
            int n11 = 21930;
        } else {
            int n12 = 42405;
        }
        Object object = new rd(n10, (int)var1_4);
        z z10 = this.V7((rd)object);
        object = e.a.c1.b.d();
        z10 = z10.L5((e.a.h0)object);
        object = i4.a;
        return z10.H3((o)object);
    }

    public z Y() {
        int n10 = InteractCode.ROLL_DEADBAND_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        p4 p42 = p4.a;
        return ((z)object).H3(p42);
    }

    public z Y0(short s10) {
        Object object = new b0();
        ((b0)object).p(s10);
        z z10 = this.N7((p)object);
        object = d.v.e0.b.a;
        return z10.H3((o)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void Y1() {
        synchronized (this) {
            Object object = this.j;
            if (object != null) {
                object.disconnect();
            }
            object = this.m;
            ((sd)object).y();
            return;
        }
    }

    public z Y2(int n10, int n11, int n12) {
        d.v.y.b.a a10 = new d.v.y.b.a(0, n10, n12, n11);
        Object object = new n();
        ((n)object).q(a10);
        object = this.N7((p)object);
        n1 n13 = n1.a;
        return ((z)object).H3(n13);
    }

    public /* synthetic */ byte[] Y3(byte[] byArray) {
        return this.X3(byArray);
    }

    public z Y6() {
        Object object = new s();
        object = this.O7((p)object, false);
        u1 u12 = u1.a;
        return ((z)object).H3(u12);
    }

    public z Y7(short s10, byte[] object) {
        x x10 = new x();
        x10.s(s10);
        x10.r((byte[])object);
        z z10 = this.N7(x10);
        object = d4.a;
        return z10.H3((o)object);
    }

    public z Z(float f10) {
        int n10 = InteractCode.ROLL_FINE_TUNE_W;
        int n11 = Math.round(f10 * 100.0f);
        Object object = new rd(n10, n11);
        z z10 = this.V7((rd)object);
        object = z4.a;
        return z10.H3((o)object);
    }

    public z Z0(float f10) {
        d.v.y.d.i i10 = this.v2().moveLimit.pitch;
        f10 = this.c2(f10, i10);
        int n10 = InteractCode.PITCH_ROTATE_ANGLE_CONTROL;
        return this.c7(n10, f10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void Z1() {
        synchronized (this) {
            n0 n02 = this.k;
            if (n02 != null) {
                n02.a(false);
            }
            return;
        }
    }

    public int Z2() {
        return this.v2().tracking;
    }

    public /* synthetic */ e0 Z4(byte[] byArray) {
        return this.Y4(byArray);
    }

    public z Z6() {
        Object object = new d.v.y.c.c();
        Object object2 = new z3(this);
        ((d.v.y.c.c)object).p((c)object2);
        object2 = new byte[11];
        ((d.v.y.c.c)object).q((byte[])object2);
        object2 = ActiveState.INACTIVATED;
        ((d.v.y.c.c)object).r((ActiveState)((Object)object2));
        object2 = LocalDate.now();
        int n10 = ((LocalDate)object2).getYear();
        ((d.v.y.c.c)object).s(n10);
        int n11 = ((LocalDate)object2).getDayOfYear();
        ((d.v.y.c.c)object).o(n11);
        object = this.N7((p)object);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = cc.a;
        return ((z)object).H3((o)object2);
    }

    public z a() {
        z z10 = this.F1();
        Object object = this.l1();
        z z11 = this.B0();
        z10 = z.D0(z10, (e0)object, z11).I(3);
        object = s4.a;
        return z10.H3((o)object);
    }

    public void a0(d.v.y.c.s1.l.c c10) {
        this.L7(false);
        be.m().w(c10);
    }

    public void a1(int n10, int n11) {
        be.m().z(n10, n11);
    }

    public z a3(int n10) {
        int n11 = InteractCode.UPGRADABLE_DEVICE_ID;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = new Stabilizer$b(this);
        return z10.H3((o)object);
    }

    public z b() {
        int n10;
        int[] nArray = Stabilizer$e.b;
        Model model = this.c;
        int n11 = model.ordinal();
        int n12 = nArray[n11];
        if (n12 != (n11 = 1) && n12 != (n10 = 2) && n12 != (n10 = 3) && n12 != (n10 = 4) && n12 != (n10 = 5)) {
            float f10 = this.e;
            double d10 = f10;
            double d11 = 1.7;
            double d12 = d10 - d11;
            n12 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
            if (n12 >= 0) {
                n12 = 12;
                f10 = 1.7E-44f;
            } else {
                n12 = 6;
                f10 = 8.4E-45f;
            }
            n11 = 0;
            model = null;
            n12 = d.v.y.b.g.c(0, n12);
        } else {
            float f11 = 1.1E-44f;
            n12 = d.v.y.b.g.c(n11, 8);
        }
        return this.a7(n12);
    }

    public z b0() {
        int n10 = d.v.y.b.g.d(0, 8);
        return this.a7(n10);
    }

    public z b1() {
        int n10 = InteractCode.GyroStandardDeviation_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        ld ld2 = ld.a;
        return ((z)object).H3(ld2);
    }

    public z b2() {
        Object object = new s0();
        object = this.N7((p)object);
        u0 u02 = u0.a;
        return ((z)object).H3(u02);
    }

    public z b3() {
        int n10 = InteractCode.UPGRADABLE_MODULE_COUNT;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z b7(byte[] object) {
        Object object2 = new d.v.y.c.c();
        p5 p52 = new p5(this);
        ((d.v.y.c.c)object2).p(p52);
        ((d.v.y.c.c)object2).q((byte[])object);
        object = (Object)ActiveState.ACTIVATED;
        ((d.v.y.c.c)object2).r((ActiveState)((Object)object));
        object = LocalDate.now();
        int n10 = ((LocalDate)object).getYear();
        ((d.v.y.c.c)object2).s(n10);
        int n11 = ((LocalDate)object).getDayOfYear();
        ((d.v.y.c.c)object2).o(n11);
        object = this.N7((p)object2).U4(3);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = cc.a;
        return ((z)object).H3((o)object2);
    }

    public z c() {
        int n10 = InteractCode.WORK_MODE_CODE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        x5 x52 = x5.a;
        return ((z)object).H3(x52);
    }

    public z c0() {
        Object object = new d.v.y.c.r1();
        object = this.N7((p)object);
        d.v.e0.h1 h12 = d.v.e0.h1.a;
        return ((z)object).H3(h12);
    }

    public z c1(String object) {
        Object object2 = new d.v.y.c.o0();
        ((d.v.y.c.o0)object2).o((String)object);
        object = this.N7((p)object2);
        object2 = bc.a;
        object = ((z)object).H3((o)object2);
        object2 = k5.a;
        return ((z)object).H3((o)object2);
    }

    public z c3(int n10) {
        int n11 = InteractCode.UPGRADABLE_VERSION;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = r2.a;
        return z10.H3((o)object);
    }

    public z d() {
        int n10 = InteractCode.ZOOM_VIRTUAL_POS;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z d0(Direction object, FileType object2) {
        l l10 = new l();
        l10.t((Direction)((Object)object));
        l10.w(-1);
        l10.v((FileType)((Object)object2));
        object = this.N7(l10);
        object2 = d.v.e0.l0.a;
        return ((z)object).H3((o)object2);
    }

    public z d1() {
        float f10 = this.e;
        z z10 = z.t3(Float.valueOf(f10));
        z z11 = this.G7();
        float f11 = this.e;
        float f12 = f11 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object <= 0) {
            z10 = z11;
        }
        return z10;
    }

    public z d2() {
        Object object = new d.v.y.c.b();
        Object object2 = new w5(this);
        ((d.v.y.c.b)object).s((b)object2);
        object = this.N7((p)object);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = x4.a;
        return ((z)object).H3((o)object2);
    }

    public int d3() {
        return this.v2().wifiModel;
    }

    public /* synthetic */ void d4(d d10) {
        this.c4(d10);
    }

    public z d7(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("");
        Object object2 = ((StringBuilder)object).toString();
        object2 = this.q0((short)257, (String)object2);
        object = p1.a;
        return ((z)object2).H3((o)object);
    }

    public z e() {
        int n10 = InteractCode.PITCH_SMOOTHNESS_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z e0() {
        Object object = new q0();
        object = this.N7((p)object);
        j j10 = d.v.e0.j.a;
        return ((z)object).H3(j10);
    }

    public z e1(short s10) {
        Object object = new a0();
        ((a0)object).p(s10);
        z z10 = this.N7((p)object);
        object = d.v.e0.d.a;
        return z10.H3((o)object);
    }

    public byte[] e2() {
        return this.v2().activateKey;
    }

    public /* synthetic */ byte[] e5(byte[] byArray) {
        return this.d5(byArray);
    }

    public z e7(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("");
        Object object2 = ((StringBuilder)object).toString();
        object2 = this.q0((short)258, (String)object2);
        object = b4.a;
        return ((z)object2).H3((o)object);
    }

    public void f(CCSParams cCSParams) {
    }

    public z f0() {
        Object object = new l0();
        object = this.N7((p)object);
        Object object2 = gc.a;
        object = ((z)object).H3((o)object2);
        object2 = fd.a;
        return ((z)object).f2((g)object2);
    }

    public z f1(boolean bl2) {
        Object object = new i1();
        Object object2 = ((i1)object).n(bl2);
        object2 = this.N7((p)object2);
        object = m3.a;
        return ((z)object2).H3((o)object);
    }

    public Active f2() {
        return this.v2().activate;
    }

    public float f3() {
        return this.f;
    }

    public z f7(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("");
        Object object2 = ((StringBuilder)object).toString();
        object2 = this.q0((short)256, (String)object2);
        object = z1.a;
        return ((z)object2).H3((o)object);
    }

    public z g(int n10) {
        int n11 = InteractCode.PITCH_SMOOTHNESS_W;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = o3.a;
        return z10.H3((o)object);
    }

    public z g0(PowerMode object) {
        int n10 = InteractCode.Power_W;
        int n11 = PowerMode.to((PowerMode)((Object)object));
        Object object2 = new rd(n10, n11);
        object2 = this.V7((rd)object2);
        v1 v12 = new v1(this, (PowerMode)((Object)object));
        object = ((z)object2).T0(v12);
        object2 = i2.a;
        return ((z)object).H3((o)object2);
    }

    public z g1() {
        int n10 = d.v.y.b.g.d(0, 7);
        return this.a7(n10);
    }

    public List g3() {
        return this.v2().workingModes;
    }

    public /* synthetic */ e0 g6(int n10, rd rd2) {
        return this.f6(n10, rd2);
    }

    public a g7(float f10) {
        int n10;
        int n11 = this.Z2();
        if (n11 != (n10 = 2)) {
            return e.a.a.y();
        }
        int n12 = Math.round(f10 * 100.0f);
        n10 = InteractCode.CAMERA_ZOOM;
        Object object = new rd(n10, n12);
        z z10 = this.W7((rd)object, false);
        object = e.a.c1.b.d();
        return z10.L5((e.a.h0)object).k3();
    }

    public z h(Flag object) {
        Object object2 = new y0();
        ((y0)object2).t((Flag)((Object)object));
        object = UsbStatus.CONNECTED;
        ((y0)object2).u((UsbStatus)((Object)object));
        object = this.T7((a1)object2, false);
        object2 = fc.a;
        return ((z)object).H3((o)object2);
    }

    public z h0() {
        int n10 = InteractCode.Debug_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        e6 e62 = e6.a;
        return ((z)object).H3(e62);
    }

    public z h1(CameraManufacturer object) {
        int n10 = InteractCode.SET_CAMERA_MANUFACTURER;
        int n11 = ((CameraManufacturer)object).value;
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = x2.a;
        return ((z)object).H3((o)object2);
    }

    public int h2() {
        return this.w2().getFunctions().battery;
    }

    public a h7(boolean bl2) {
        int n10 = InteractCode.DEMO_MODE_W;
        Object object = new rd(n10, (int)(bl2 ? 1 : 0));
        z z10 = this.V7((rd)object);
        object = e.a.c1.b.d();
        return z10.L5((e.a.h0)object).k3();
    }

    public z i(int n10) {
        Object object = this.V2().roll;
        if (object == null) {
            return z.t3(Boolean.TRUE);
        }
        object = this.V2().roll;
        Object object2 = n10;
        object2 = (Integer)((d.v.y.d.i)object).a((Comparable)object2);
        int n11 = InteractCode.MOTOR_ROLL_W;
        n10 = (Integer)object2;
        object = new rd(n11, n10);
        object2 = this.V7((rd)object);
        object = d2.a;
        return ((z)object2).H3((o)object);
    }

    public z i0(float f10) {
        int n10 = InteractCode.PITCH_FINE_TUNE_W;
        int n11 = Math.round(f10 * 100.0f);
        Object object = new rd(n10, n11);
        z z10 = this.V7((rd)object);
        object = y5.a;
        return z10.H3((o)object);
    }

    public z i1(int n10) {
        int n11 = InteractCode.PITCH_CONTROL;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = f3.a;
        return z10.H3((o)object);
    }

    public z i3() {
        int n10 = this.p3();
        if (n10 == 0) {
            return z.l2();
        }
        n10 = this.q3();
        n10 = n10 != 0 ? 500 : 1000;
        long l10 = n10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        z z10 = z.n3(l10, timeUnit);
        o o10 = new b6(this);
        z10 = z10.T0(o10);
        o10 = k2.a;
        return z10.H3(o10);
    }

    public z j() {
        int n10 = InteractCode.PITCH_FINE_TUNE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        h3 h32 = h3.a;
        return ((z)object).H3(h32);
    }

    public z j0(WorkingMode object) {
        int n10 = InteractCode.WORK_MODE_CODE_W;
        int n11 = ((WorkingMode)object).code;
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = k3.a;
        return ((z)object).H3((o)object2);
    }

    public z j1() {
        Object object = new l1();
        object = this.N7((p)object);
        h h10 = d.v.e0.h.a;
        return ((z)object).H3(h10);
    }

    public int j2() {
        return this.v2().bleHid;
    }

    public boolean j3() {
        Functions functions = this.v2();
        int n10 = functions.accessory;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ e0 j4(Model model) {
        return this.i4(model);
    }

    public /* synthetic */ byte[] j5(byte[] byArray) {
        return this.i5(byArray);
    }

    public z j7(String object, String object2, boolean bl2, boolean bl3) {
        d.v.y.c.i i10 = new d.v.y.c.i();
        i10.s((String)object2);
        i10.t((String)object);
        i10.v(bl2);
        i10.w(bl3);
        object = this.N7(i10);
        object2 = lc.a;
        return ((z)object).H3((o)object2);
    }

    public z k() {
        int n10 = InteractCode.IMUGX_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z k0() {
        int n10 = InteractCode.MOTOR_PITCH_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z k1() {
        int n10 = InteractCode.YAW_FOLLOW_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        m5 m52 = m5.a;
        return ((z)object).H3(m52);
    }

    public int k2() {
        return this.v2().bleMtu;
    }

    public boolean k3() {
        boolean bl2;
        d d10 = this.o;
        if (d10 != null && (bl2 = d10.p())) {
            bl2 = true;
        } else {
            bl2 = false;
            d10 = null;
        }
        return bl2;
    }

    public void k7(int n10) {
        this.n = n10;
    }

    public z l() {
        int n10 = InteractCode.YAW_DEADBAND_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        v3 v32 = v3.a;
        return ((z)object).H3(v32);
    }

    public z l0(float f10) {
        int n10 = InteractCode.ROLL_DEADBAND_W;
        int n11 = Math.round(f10 * 100.0f);
        Object object = new rd(n10, n11);
        z z10 = this.V7((rd)object);
        object = u5.a;
        return z10.H3((o)object);
    }

    public z l1() {
        int n10 = InteractCode.ROLL_ANGLE_R;
        return this.g2(n10);
    }

    public int l2() {
        return this.v2().calibration;
    }

    public boolean l3() {
        Stream stream = this.v2().motorStrength.stream();
        c4 c42 = c4.a;
        return stream.anyMatch(c42);
    }

    public /* synthetic */ void l4(Modules modules) {
        this.k4(modules);
    }

    public z l7(JoystickSpeed joystickSpeed) {
        int n10 = InteractCode.JOYSTICK_SPEED_W;
        int n11 = joystickSpeed.code;
        Object object = new rd(n10, n11);
        object = this.V7((rd)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = new v2(joystickSpeed);
        return ((z)object).H3((o)object2);
    }

    public z m() {
        int n10 = InteractCode.IMUGY_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z m0(boolean bl2) {
        Object object = new d.v.y.c.q1();
        Object object2 = ((d.v.y.c.q1)object).n(bl2);
        object2 = this.N7((p)object2);
        object = n2.a;
        return ((z)object2).H3((o)object);
    }

    public z m1(PhotoInfoNumber object) {
        Object object2 = new d.v.y.c.n1();
        object = ((d.v.y.c.n1)object2).o((PhotoInfoNumber)((Object)object));
        object = this.N7((p)object);
        object2 = jc.a;
        return ((z)object).H3((o)object2);
    }

    public boolean m3() {
        Functions functions = this.v2();
        int n10 = functions.motorStrengthAdjustNotify;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public z m7(int n10, int n11, int n12, KeyFunc keyFunc) {
        d.v.y.b.a a10 = new d.v.y.b.a(0, n10, n12, n11);
        Object object = new d.v.y.c.o();
        ((d.v.y.c.o)object).p(a10);
        ((d.v.y.c.o)object).q(keyFunc);
        object = this.N7((p)object);
        a4 a42 = a4.a;
        return ((z)object).H3(a42);
    }

    public z n() {
        int n10 = InteractCode.FF_VIRTUAL_POS;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z n0() {
        int n10 = InteractCode.LOCATION_POINT_STATE_REGISTER;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z n1() {
        int n10 = d.v.y.b.g.e(0, 7);
        return this.a7(n10);
    }

    public List n2() {
        return this.u2().cameraList;
    }

    public boolean n3() {
        Functions functions = this.v2();
        int n10 = functions.autoTune;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ void n4(Modules modules) {
        this.m4(modules);
    }

    public z n7(float f10) {
        int n10 = Math.round(ge.j(f10, -90.0f, 90.0f) * 100.0f);
        int n11 = InteractCode.MSC_PITCH_C;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = h2.a;
        return z10.H3((o)object);
    }

    public z o() {
        Object object = new g0();
        ((g0)object).t(false);
        object = this.N7((p)object);
        ac ac2 = ac.a;
        return ((z)object).H3(ac2);
    }

    public z o0() {
        int n10 = InteractCode.WORKING_STATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        g4 g42 = g4.a;
        return ((z)object).H3(g42);
    }

    public z o1(float f10) {
        d.v.y.d.i i10 = this.v2().moveLimit.yaw;
        f10 = this.c2(f10, i10);
        int n10 = InteractCode.YAW_ROTATE_ANGLE_CONTROL;
        return this.c7(n10, f10);
    }

    public ConnectionMethod o2() {
        return this.v2().links;
    }

    public boolean o3() {
        boolean bl2;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState;
        Object object = this.a;
        if (object != null && (object = object.d()) == (rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.CONNECTED)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public z o7(int n10, int n11) {
        n10 = ge.k(n10, 0, 50);
        n11 = ge.k(n11, 0, 100);
        n10 = n10 << 8 & 0xFF00;
        int n12 = InteractCode.MSC_PITCH_W;
        Object object = new rd(n12, n10 |= (n11 &= 0xFF));
        z z10 = this.V7((rd)object);
        object = l4.a;
        return z10.H3((o)object);
    }

    public z p(int n10) {
        Object object = this.V2().pitch;
        if (object == null) {
            return z.t3(Boolean.TRUE);
        }
        object = this.V2().pitch;
        Object object2 = n10;
        object2 = (Integer)((d.v.y.d.i)object).a((Comparable)object2);
        int n11 = InteractCode.MOTOR_PITCH_W;
        n10 = (Integer)object2;
        object = new rd(n11, n10);
        object2 = this.V7((rd)object);
        object = e5.a;
        return ((z)object2).H3((o)object);
    }

    public z p0(Strength object) {
        int n10 = InteractCode.SET_MOTOR_FORCE;
        int n11 = ((Strength)object).value;
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = i3.a;
        return ((z)object).H3((o)object2);
    }

    public z p1() {
        Object object = new d1();
        ((d1)object).p(true);
        object = this.N7((p)object);
        zb zb2 = zb.a;
        return ((z)object).H3(zb2);
    }

    public Stabilizer$State p2() {
        Object object = this.a;
        object = object == null ? RxBleConnection$RxBleConnectionState.DISCONNECTED : object.d();
        int[] nArray = Stabilizer$e.a;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return Stabilizer$State.DISCONNECTED;
                }
                return Stabilizer$State.DISCONNECTING;
            }
            return Stabilizer$State.CONNECTED;
        }
        return Stabilizer$State.CONNECTING;
    }

    public boolean p3() {
        int n10;
        int n11;
        int n12 = this.j2();
        if (n12 != (n11 = 1) && (n12 = this.j2()) != (n10 = 2)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ e0 p4(Modules modules) {
        return this.o4(modules);
    }

    public z p7(float f10) {
        int n10 = Math.round(ge.j(f10, -45.0f, 45.0f) * 100.0f);
        int n11 = InteractCode.MSC_ROLL_C;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = o5.a;
        return z10.H3((o)object);
    }

    public z q() {
        int n10 = InteractCode.ROLL_FINE_TUNE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        s6 s62 = s6.a;
        return ((z)object).H3(s62);
    }

    public z q0(short s10, String object) {
        d.v.y.c.d0 d02 = new d.v.y.c.d0();
        d02.p(s10, (String)object);
        z z10 = this.N7(d02);
        object = d.v.e0.f1.a;
        return z10.H3((o)object);
    }

    public z q1() {
        int n10 = InteractCode.GET_CAMERA_MANUFACTURER;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        o4 o42 = o4.a;
        return ((z)object).H3(o42);
    }

    public i0 q2() {
        int n10 = InteractCode.DEMO_MODE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2).s5();
        object2 = cd.a;
        object = ((i0)object).z0((o)object2);
        object2 = o1.a;
        return ((i0)object).z0((o)object2);
    }

    public boolean q3() {
        int n10;
        int n11 = this.j2();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public z q7(int n10, int n11) {
        n10 = ge.k(n10, 0, 50);
        n11 = ge.k(n11, 0, 100);
        n10 = n10 << 8 & 0xFF00;
        int n12 = InteractCode.MSC_ROLL_W;
        Object object = new rd(n12, n10 |= (n11 &= 0xFF));
        z z10 = this.V7((rd)object);
        object = k6.a;
        return z10.H3((o)object);
    }

    public z r(DeviceType object) {
        Object object2 = this.c;
        Model model = Model.CRANE_M2;
        if (object2 != model) {
            return z.t3(object);
        }
        object2 = new d.v.y.c.j();
        ((d.v.y.c.j)object2).p((DeviceType)((Object)object));
        object = this.N7((p)object2);
        object2 = t0.a;
        return ((z)object).H3((o)object2);
    }

    public z r0(DebugMode object) {
        int n10 = InteractCode.Debug_W;
        int n11 = DebugMode.to((DebugMode)((Object)object));
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = e4.a;
        return ((z)object).H3((o)object2);
    }

    public void r1(CCSParams cCSParams) {
        be.m().q(cCSParams);
    }

    public z r2(byte by2) {
        Object object = new w();
        ((w)object).q(by2);
        z z10 = this.N7((p)object);
        object = q4.a;
        return z10.H3((o)object);
    }

    public boolean r3() {
        Functions functions = this.v2();
        int n10 = functions.carry;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ Modules r4(Modules modules, String string2) {
        this.q4(modules, string2);
        return modules;
    }

    public z r7(float f10) {
        int n10 = Math.round(ge.j(f10, -180.0f, 180.0f) * 100.0f);
        int n11 = InteractCode.MSC_YAW_C;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = a2.a;
        return z10.H3((o)object);
    }

    public z s() {
        int n10 = InteractCode.IMUAX_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        ld ld2 = ld.a;
        return ((z)object).H3(ld2);
    }

    public a s0() {
        PhoneControlMode phoneControlMode = PhoneControlMode.END;
        return this.w7(phoneControlMode);
    }

    public z s1() {
        int n10 = InteractCode.Power_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        u3 u32 = u3.a;
        return ((z)object).H3(u32);
    }

    public float s2() {
        return this.e;
    }

    public boolean s3() {
        Functions functions = this.u2();
        int n10 = functions.ccs;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public z s7(int n10, int n11) {
        n10 = ge.k(n10, 0, 50);
        n11 = ge.k(n11, 0, 100);
        n10 = n10 << 8 & 0xFF00;
        int n12 = InteractCode.MSC_YAW_W;
        Object object = new rd(n12, n10 |= (n11 &= 0xFF));
        z z10 = this.V7((rd)object);
        object = q1.a;
        return z10.H3((o)object);
    }

    public z t(String object) {
        Object object2 = new f1();
        object = ((f1)object2).o((String)object);
        object = this.N7((p)object);
        object2 = y3.a;
        return ((z)object).H3((o)object2);
    }

    public z t0(int n10) {
        int n11 = n10 >>> 16;
        int n12 = InteractCode.POINT_MOTION_TIME_LOW_BIT;
        rd rd2 = new rd(n12, n10 &= (char)-1);
        z z10 = this.V7(rd2);
        n12 = InteractCode.POINT_MOTION_TIME_HIGH_BIT;
        rd2 = new rd(n12, n11);
        Object object = this.V7(rd2);
        z10 = z.C0(z10, (e0)object).I(2);
        object = h5.a;
        return z10.H3((o)object);
    }

    public z t1(int n10) {
        int n11 = InteractCode.YAW_CONTROL_MAX_RATE_W;
        Object object = new rd(n11, n10 *= 100);
        z z10 = this.V7((rd)object);
        object = s1.a;
        return z10.H3((o)object);
    }

    public float t2() {
        return (float)this.v2().forceVersion * 1.0f / 100.0f;
    }

    public boolean t3() {
        boolean bl2 = this.i;
        bl2 = bl2 || (bl2 = this.o3());
        return bl2;
    }

    public void t7(Model model) {
        this.c = model;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stabilizer{name=");
        String string2 = this.M2();
        stringBuilder.append(string2);
        stringBuilder.append("mac=");
        string2 = this.F2();
        stringBuilder.append(string2);
        stringBuilder.append("model=");
        string2 = this.c.toString();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public z u() {
        Object object = new d.v.y.c.i0();
        object = this.N7((p)object);
        r0 r02 = r0.a;
        return ((z)object).H3(r02);
    }

    public void u0(CCSParams cCSParams) {
        be.m().p(cCSParams);
    }

    public z u1(int n10) {
        int n11 = InteractCode.ROLL_CONTROL;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = h6.a;
        return z10.H3((o)object);
    }

    public Functions u2() {
        return this.H2().getFunctions();
    }

    public boolean u3() {
        Functions functions = this.v2();
        int n10 = functions.digitalZoom;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public z u7(MoveLineStatus object) {
        Object object2 = new q();
        ((q)object2).o((MoveLineStatus)((Object)object));
        object = this.N7((p)object2);
        object2 = t6.a;
        return ((z)object).H3((o)object2);
    }

    public z v() {
        int n10 = InteractCode.IMUControlRegister_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        f2 f22 = f2.a;
        return ((z)object).H3(f22);
    }

    public z v0(String object, String object2) {
        e1 e12 = new e1();
        object = e12.o((String)object).n((String)object2);
        object = this.N7((p)object);
        object2 = d.v.e0.m1.a;
        return ((z)object).H3((o)object2);
    }

    public z v1() {
        Object object = new j1();
        object = this.N7((p)object);
        i i10 = d.v.e0.i.a;
        return ((z)object).H3(i10);
    }

    public Functions v2() {
        return this.w2().getFunctions();
    }

    public boolean v3() {
        Functions functions = this.v2();
        int n10 = functions.hvSwitch;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ void v6(Float f10) {
        this.u6(f10);
    }

    public z v7(PathShot object) {
        FileType fileType = FileType.PATHSHOT;
        object = ((PathShot)object).toJsonString();
        return this.M7(fileType, (String)object);
    }

    public z w() {
        int n10 = InteractCode.IMUGZ_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z w0() {
        int n10 = InteractCode.PITCH_FOLLOW_MAX_RATE_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        n5 n52 = n5.a;
        return ((z)object).H3(n52);
    }

    public z w1(int n10) {
        int n11 = InteractCode.FOCUS_CONTROL;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = r6.a;
        return z10.H3((o)object);
    }

    public Model w2() {
        Model model = this.d;
        if (model == null) {
            model = this.H2();
        }
        return model;
    }

    public boolean w3() {
        Functions functions = this.v2();
        int n10 = functions.jsonData;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public z x(int n10) {
        int n11 = InteractCode.YAW_CONTROL;
        Object object = new rd(n11, n10);
        z z10 = this.W7((rd)object, false);
        object = f4.a;
        return z10.H3((o)object);
    }

    public z x0() {
        int n10 = InteractCode.IMUStateRegister_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        cd cd2 = cd.a;
        return ((z)object).H3(cd2);
    }

    public z x1(ae object) {
        int n10 = InteractCode.ROCKER_DIRECTION_CONFIG_W;
        int n11 = ae.c((ae)object);
        Object object2 = new rd(n10, n11);
        object = this.V7((rd)object2);
        object2 = a5.a;
        return ((z)object).H3((o)object2);
    }

    public int x2() {
        return this.v2().identifier;
    }

    public /* synthetic */ e0 x6(rd rd2) {
        return this.w6(rd2);
    }

    public z y(int n10) {
        int n11 = InteractCode.LOCATION_SET_POINT_POWERED;
        Object object = new rd(n11, n10);
        z z10 = this.V7((rd)object);
        object = n3.a;
        return z10.H3((o)object);
    }

    public void y0() {
        be.m().u();
    }

    public z y1(int n10) {
        Object object = new d.v.y.c.p1();
        Object object2 = ((d.v.y.c.p1)object).p(n10);
        object2 = this.N7((p)object2);
        object = t4.a;
        return ((z)object2).H3((o)object);
    }

    public z y2() {
        int n10 = InteractCode.JOYSTICK_SPEED_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = cd.a;
        object = ((z)object).H3((o)object2);
        object2 = qc.a;
        return ((z)object).H3((o)object2);
    }

    public boolean y3() {
        Functions functions = this.v2();
        int n10 = functions.motionControl;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void y7(int n10) {
        this.h = n10;
    }

    public z z() {
        int n10 = InteractCode.IMUAY_R;
        Object object = new rd(n10);
        object = this.V7((rd)object);
        ld ld2 = ld.a;
        return ((z)object).H3(ld2);
    }

    public z z0(int n10) {
        Object object = new l();
        Direction direction = Direction.SEND;
        ((l)object).t(direction);
        ((l)object).w(0);
        ((l)object).u(n10);
        z z10 = this.N7((p)object);
        object = d.v.e0.g.a;
        return z10.H3((o)object);
    }

    public z z1() {
        int n10 = d.v.y.b.g.e(0, 8);
        return this.a7(n10);
    }

    public List z2() {
        return this.v2().keyRedefine;
    }

    public boolean z3() {
        Functions functions = this.v2();
        int n10 = functions.oem;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ e0 z6(rd rd2) {
        return this.y6(rd2);
    }

    public z z7(SceneMode sceneMode) {
        int n10 = InteractCode.SCENE_MODE_W;
        int n11 = sceneMode.value;
        Object object = new rd(n10, n11);
        object = this.V7((rd)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = new f6(sceneMode);
        return ((z)object).H3((o)object2);
    }
}

