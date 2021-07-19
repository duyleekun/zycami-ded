/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.s0;

import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.android.CameraView;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.vtpusher.VtDataType;
import com.zhiyun.vtpusher.VtEncoderType;
import d.v.a0.h1;
import d.v.a0.m1;
import d.v.a0.n1.g.w;
import d.v.a0.n1.h.b;
import d.v.b0.b.c;
import d.v.c.s0.e6;
import d.v.c.s0.v6$a;
import d.v.c.s0.v6$b;
import d.v.c.s0.v6$c;
import d.v.c.s0.v6$d;
import d.v.e.h.a;
import d.v.e.h.d;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h0.g;
import d.v.h0.i;
import d.v.z.l.e;
import d.v.z.l.f;

public class v6
extends ViewModel {
    private static final long A = 255L;
    public static final long w = 9000L;
    private static final int x = 5000000;
    private static final int y = 6020;
    private static final int z = 7020;
    private final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final j e;
    private boolean f;
    public final j g;
    public final j h;
    public final j i;
    public final j j;
    public final j k;
    private String l;
    private String m;
    private e n;
    private boolean o;
    private final d.v.z.l.i p;
    private boolean q;
    private int r;
    private int s;
    private c t;
    private boolean u;
    private final w v;

    public v6() {
        Object object = Boolean.FALSE;
        Object object2 = new MutableLiveData(object);
        this.b = object2;
        object2 = new MutableLiveData(object);
        this.c = object2;
        object2 = new MutableLiveData(object);
        this.d = object2;
        this.e = object2;
        super();
        this.g = object2;
        super();
        this.h = object2;
        super();
        this.i = object2;
        super();
        this.j = object2;
        super();
        this.k = object2;
        this.l = null;
        this.o = false;
        this.p = object = new d.v.z.l.i();
        this.q = false;
        this.r = 1920;
        this.s = 1080;
        this.v = object2 = new v6$a(this);
        ((d.v.z.l.i)object).q0("Enable");
        object = d.v.c.v0.n.d.s().z();
        this.a = object2 = new MutableLiveData(object);
        this.A();
    }

    private void A() {
        m1.o().h();
        Object[] objectArray = m1.o();
        Object object = this.v;
        objectArray.j((w)object);
        objectArray = m1.o();
        object = new e6(this);
        objectArray.w((d.v.a0.n1.c)object);
        objectArray = m1.o();
        object = new v6$d(this);
        objectArray.x((b)object);
        objectArray = new Object[]{};
        m.a.a.b("Remote init", objectArray);
    }

    public static /* synthetic */ void G(v6 v62, h1 h12, f f10) {
        v62.J(h12, f10);
    }

    private boolean H() {
        return d.v.e.h.a.c((Boolean)this.b.getValue()) ^ true;
    }

    private void I(boolean bl2) {
        Boolean bl3 = Boolean.TRUE;
        if (bl2) {
            Object object = (Boolean)this.b.getValue();
            bl2 = d.v.e.h.a.c((Boolean)object);
            if (!bl2) {
                object = this.b;
                d.v.e.i.h.e((MutableLiveData)object, bl3);
            }
            if (bl2 = this.f) {
                object = this.c;
                d.v.e.i.h.e((MutableLiveData)object, bl3);
            }
        } else {
            Object object = this.c;
            bl3 = Boolean.FALSE;
            d.v.e.i.h.e((MutableLiveData)object, bl3);
            object = (Boolean)this.b.getValue();
            bl2 = d.v.e.h.a.c((Boolean)object);
            if (bl2) {
                object = this.b;
                d.v.e.i.h.e((MutableLiveData)object, bl3);
            }
            this.l = null;
            this.m = null;
            this.n = null;
            bl2 = false;
            object = null;
            this.q = false;
        }
        d.v.e.i.h.e(this.g, null);
    }

    private void J(h1 h12, f object) {
        Comparable<Boolean> comparable = Boolean.TRUE;
        if (h12 != null && object != null) {
            boolean bl2;
            Object object2 = h12.a();
            String string2 = this.l;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3 && (bl2 = (string2 = this.l).equals(object2))) {
                boolean bl4;
                Object[] objectArray;
                int n10;
                object2 = ((f)object).l();
                bl3 = false;
                string2 = null;
                if (object2 != null && (n10 = object2.size()) > 0) {
                    Integer n11;
                    Integer n12;
                    float f10 = d.v.e.h.c.c((Float)object2.get("pitch"));
                    Float f11 = (Float)object2.get("roll");
                    float f12 = d.v.e.h.c.c(f11);
                    float f13 = d.v.e.h.c.c((Float)object2.get("yaw"));
                    Object object3 = this.k;
                    int n13 = 3;
                    Object object4 = new Integer[n13];
                    object4[0] = n12 = Integer.valueOf(this.u(f10));
                    object4[1] = n11 = Integer.valueOf(this.u(f12));
                    int n14 = 2;
                    int n15 = this.u(f13);
                    object4[n14] = n11 = Integer.valueOf(n15);
                    d.v.e.i.h.e((MutableLiveData)object3, object4);
                    object3 = new StringBuilder();
                    object4 = "setOnEventCallback pitch = ";
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(f10);
                    ((StringBuilder)object3).append(", roll = ");
                    ((StringBuilder)object3).append(f12);
                    ((StringBuilder)object3).append(", yaw =");
                    ((StringBuilder)object3).append(f13);
                    object2 = ((StringBuilder)object3).toString();
                    objectArray = new Object[]{};
                    m.a.a.b((String)object2, objectArray);
                }
                if (bl2 = ((f)object).o()) {
                    objectArray = this.i;
                    d.v.e.i.h.e((MutableLiveData)objectArray, comparable);
                }
                if (bl4 = ((f)object).n()) {
                    objectArray = this.h;
                    d.v.e.i.h.e((MutableLiveData)objectArray, comparable);
                }
                comparable = new Comparable<Boolean>();
                ((StringBuilder)comparable).append("setOnEventCallback ");
                ((StringBuilder)comparable).append(bl2);
                ((StringBuilder)comparable).append(" ");
                ((StringBuilder)comparable).append(bl4);
                object = ((StringBuilder)comparable).toString();
                comparable = new Object[]{};
                m.a.a.b((String)object, comparable);
                m1.o().e(h12);
                return;
            }
            m1.o().f(h12);
            return;
        }
        m1.o().f(h12);
    }

    private void K(h1 h12, d.v.z.l.i object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        int n10;
        Object object2;
        boolean bl12;
        Object object3;
        d.v.z.l.i i10 = new d.v.z.l.i();
        boolean n11 = ((d.v.z.l.i)object).y();
        if (n11 && (object3 = this.p.Q()) != null) {
            object3 = this.p.Q();
            i10.n0((String)object3);
        }
        if ((bl12 = ((d.v.z.l.i)object).s()) && (object3 = this.p.K()) != null) {
            object3 = (Boolean)this.p.K().first;
            boolean bl13 = d.v.e.h.a.c((Boolean)object3);
            object2 = (Integer)this.p.K().second;
            n10 = d.v.e.h.d.c((Integer)object2);
            i10.g0(bl13, n10);
        }
        if ((bl11 = ((d.v.z.l.i)object).t()) && (object3 = this.p.L()) != null) {
            boolean bl14;
            boolean bl15;
            object3 = this.p.L();
            i10.h0((String)object3);
            boolean bl16 = ((d.v.z.l.i)object).r();
            if (bl16 && (bl15 = ((String)(object2 = "Captureing")).equals(object3 = this.p.L())) && (object3 = this.p.J()) != null && !(bl14 = ((String)(object2 = "Smart")).equals(object3 = this.p.M()))) {
                object3 = this.p.J();
                long l10 = object3.longValue();
                i10.f0(l10);
            }
        }
        if ((bl10 = ((d.v.z.l.i)object).u()) && (object3 = this.p.M()) != null) {
            object3 = this.p.M();
            i10.i0((String)object3);
        }
        if ((bl9 = ((d.v.z.l.i)object).v()) && (object3 = this.p.N()) != null) {
            object3 = this.p.N();
            i10.j0((String)object3);
        }
        if ((bl8 = ((d.v.z.l.i)object).q()) && (object3 = this.p.I()) != null) {
            object3 = this.p.I();
            i10.e0((String)object3);
        }
        if ((bl7 = ((d.v.z.l.i)object).n()) && (object3 = this.p.F()) != null) {
            object3 = this.p.F();
            float f10 = object3.floatValue();
            i10.b0(f10);
        }
        if ((bl6 = ((d.v.z.l.i)object).m()) && (object3 = (Object)this.p.E()) != null) {
            object3 = this.p.E();
            i10.a0((float[])object3);
        }
        if ((bl5 = ((d.v.z.l.i)object).A()) && (object3 = (Object)this.p.S()) != null) {
            object3 = this.p.S();
            i10.o0((float[])object3);
        }
        if ((bl4 = ((d.v.z.l.i)object).o()) && (object3 = this.p.G()) != null) {
            object3 = this.p.G();
            i10.c0((String)object3);
        }
        if ((bl3 = ((d.v.z.l.i)object).C()) && (object3 = this.p.U()) != null) {
            object3 = this.p.U();
            i10.q0((String)object3);
        }
        if ((bl2 = ((d.v.z.l.i)object).B()) && (object3 = this.p.T()) != null) {
            object3 = this.p.T();
            int n12 = object3.getWidth();
            object2 = this.p.T();
            n10 = object2.getHeight();
            i10.p0(n12, n10);
        }
        this.N((d.v.z.l.i)object, i10);
        object = new StringBuilder();
        ((StringBuilder)object).append("OnStateInfoCallback onReceiveRead replyStateInfo = ");
        object3 = i10.toString();
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append("--------------- mCurrentInfo =  ");
        object3 = this.p.toString();
        ((StringBuilder)object).append((String)object3);
        object = ((StringBuilder)object).toString();
        object3 = new Object[]{};
        m.a.a.b((String)object, object3);
        object = m1.o();
        object3 = this.l;
        ((m1)object).u((String)object3, h12, i10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void L(h1 object, d.v.z.l.i objectArray) {
        Object object2;
        float f10;
        float f11;
        int n10;
        int n11;
        if (objectArray == null) return;
        Float f12 = objectArray.F();
        if (f12 == null) return;
        f12 = objectArray.F();
        float f13 = d.v.e.h.c.c(f12);
        float[] fArray = this.p.E();
        if (fArray != null && (n11 = fArray.length) >= (n10 = 2) && (n11 = (int)((f11 = (f10 = d.v.e.h.c.c((Float)(object2 = Float.valueOf(fArray[0])))) - f13) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1))) <= 0) {
            n11 = 1;
            f10 = Float.MIN_VALUE;
            Float f14 = Float.valueOf(fArray[n11]);
            float f15 = d.v.e.h.c.c(f14);
            float f16 = f15 - f13;
            Object object3 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object3 >= 0) {
                j j10 = this.j;
                object2 = Float.valueOf(f13);
                d.v.e.i.h.e(j10, object2);
                this.p.b0(f13);
                m1 m12 = m1.o();
                object2 = this.l;
                m12.v((String)object2, (h1)object, (d.v.z.l.i)objectArray);
                object = new StringBuilder();
                ((StringBuilder)object).append("OnStateInfoCallback onReceiveWrite replyStateInfo zoom ");
                ((StringBuilder)object).append(f13);
                object = ((StringBuilder)object).toString();
                objectArray = new Object[]{};
                m.a.a.b((String)object, objectArray);
                return;
            }
        }
        m1.o().f((h1)object);
        object = new Object[]{};
        objectArray = "OnStateInfoCallback onReceiveWrite replyMessageError ";
        m.a.a.b((String)objectArray, (Object[])object);
    }

    private void N(d.v.z.l.i object, d.v.z.l.i i10) {
        Object object2;
        boolean n10 = ((d.v.z.l.i)object).x();
        if (n10 && (object2 = this.p.P()) != null) {
            object2 = this.p.P();
            i10.m0((String)object2);
            boolean bl2 = ((d.v.z.l.i)object).w();
            if (bl2 && (object = this.p.O()) != null && (bl2 = ((String)(object2 = "CanSendData")).equals(object = this.p.P()))) {
                object = (Boolean)this.p.O().first;
                bl2 = d.v.e.h.a.c((Boolean)object);
                object2 = (Integer)this.p.O().second;
                int n11 = d.v.e.h.d.c((Integer)object2);
                i10.l0(bl2, n11);
            }
        }
    }

    private void P(d.v.z.l.i i10, d.v.z.l.i i11) {
    }

    public static /* synthetic */ String b(v6 v62) {
        return v62.l;
    }

    public static /* synthetic */ String c(v6 v62, String string2) {
        v62.l = string2;
        return string2;
    }

    public static /* synthetic */ e d(v6 v62) {
        return v62.n;
    }

    public static /* synthetic */ e e(v6 v62, e e10) {
        v62.n = e10;
        return e10;
    }

    public static /* synthetic */ String f(v6 v62, String string2) {
        v62.m = string2;
        return string2;
    }

    public static /* synthetic */ void g(v6 v62, boolean bl2) {
        v62.I(bl2);
    }

    public static /* synthetic */ boolean i(v6 v62) {
        return v62.q;
    }

    public static /* synthetic */ boolean j(v6 v62, boolean bl2) {
        v62.q = bl2;
        return bl2;
    }

    private void j0() {
        Object[] objectArray = m1.o();
        int n10 = (int)(objectArray.p() ? 1 : 0);
        if (n10 == 0) {
            objectArray = m1.o();
            Object object = new v6$b(this);
            objectArray.l(0, (d.v.a0.n1.b)object);
            n10 = 1;
            objectArray = new Object[n10];
            boolean bl2 = m1.o().p();
            objectArray[0] = object = Boolean.valueOf(bl2);
            object = "Remote start isBroad:%s";
            m.a.a.b((String)object, objectArray);
        }
    }

    public static /* synthetic */ void k(v6 v62) {
        v62.l0();
    }

    public static /* synthetic */ void l(v6 v62, h1 h12, d.v.z.l.i i10) {
        v62.K(h12, i10);
    }

    private void l0() {
        Object[] objectArray = m1.o();
        int n10 = (int)(objectArray.p() ? 1 : 0);
        if (n10 != 0) {
            m1.o().y();
            n10 = 1;
            objectArray = new Object[n10];
            boolean bl2 = m1.o().p();
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            String string2 = "Remote stop isBroad:%s";
            m.a.a.b(string2, objectArray);
        }
    }

    public static /* synthetic */ void m(v6 v62, h1 h12, d.v.z.l.i i10) {
        v62.L(h12, i10);
    }

    private int u(float f10) {
        float f11 = -1.0f;
        float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        float f13 = 1.0f;
        if (f12 < 0 || (f12 = f10 == f13 ? 0 : (f10 > f13 ? 1 : -1)) > 0) {
            f10 = 0.0f;
        }
        return Math.round((f10 + f13) * 2048.0f);
    }

    private String v(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return "LandscapeLeft";
                }
                return "UpsideDown";
            }
            return "LandscapeRight";
        }
        return "Portrait";
    }

    public boolean F(boolean bl2, CameraSet$Mode cameraSet$Mode, boolean bl3) {
        boolean bl4;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.panorama;
        boolean bl5 = false;
        if (!(cameraSet$Mode2 == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.photograph) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.video) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.sport_delay) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.delay_video) == cameraSet$Mode && bl3)) {
            bl4 = false;
            cameraSet$Mode = null;
        } else {
            bl4 = true;
        }
        this.f = bl4;
        if (bl2) {
            bl5 = bl4;
        }
        return bl5;
    }

    public void M() {
        Object object = new Object[]{};
        m.a.a.b("Remote rejectConnect", (Object[])object);
        object = m1.o();
        String string2 = this.l;
        ((m1)object).s(string2, "UserReject");
        this.I(false);
    }

    public void Q() {
        this.V(0);
    }

    public void R(float f10) {
        Object object = this.p.F();
        float f11 = d.v.e.h.c.c((Float)object);
        float f12 = f11 - f10;
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 == false) {
            return;
        }
        object = this.p;
        ((d.v.z.l.i)object).b0(f10);
        object2 = this.H();
        if (object2 != false) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("notifyStateInfo setCameraCurrentZoom:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        Object object3 = new Object[]{};
        m.a.a.b((String)object, object3);
        object = new d.v.z.l.i();
        ((d.v.z.l.i)object).b0(f10);
        m1 m12 = m1.o();
        object3 = this.l;
        m12.r((String)object3, (d.v.z.l.i)object);
    }

    public void S(boolean bl2) {
        Object object = bl2 ? "Front" : "Back";
        Object object2 = this.p;
        ((d.v.z.l.i)object2).c0((String)object);
        boolean bl3 = this.H();
        if (bl3) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("notifyStateInfo setCameraDirection:");
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        Object object3 = new Object[]{};
        m.a.a.b((String)object2, object3);
        object2 = new d.v.z.l.i();
        ((d.v.z.l.i)object2).c0((String)object);
        object = m1.o();
        object3 = this.l;
        ((m1)object).r((String)object3, (d.v.z.l.i)object2);
    }

    public void T(float f10, float f11) {
        d.v.z.l.i i10 = this.p;
        int n10 = 2;
        float[] fArray = new float[n10];
        fArray[0] = f10;
        int n11 = 1;
        fArray[n11] = f11;
        i10.a0(fArray);
        i10 = this.p;
        float[] fArray2 = new float[n10];
        fArray2[0] = f10;
        fArray2[n11] = f11;
        i10.o0(fArray2);
    }

    public void U(boolean bl2) {
        Object object = m1.o().d();
        if (object == null) {
            return;
        }
        object = bl2 ? this.m : m1.o().d().k();
        Object object2 = this.p;
        object2.e0((String)object);
        boolean bl3 = this.H();
        if (bl3) {
            return;
        }
        object2 = new StringBuilder();
        object2.append("notifyStateInfo setControlDevice:");
        object2.append(bl2);
        object2.append(",");
        object2.append((String)object);
        Object object3 = object2.toString();
        object2 = new Object[]{};
        m.a.a.b((String)object3, object2);
        object3 = new d.v.z.l.i();
        ((d.v.z.l.i)object3).e0((String)object);
        object = m1.o();
        object2 = this.l;
        ((m1)object).r((String)object2, (d.v.z.l.i)object3);
    }

    public void V(int n10) {
        String string2 = "Smart";
        Object object = this.p.M();
        boolean bl2 = string2.equals(object);
        if (!bl2 && (bl2 = (string2 = "Captureing").equals(object = this.p.L()))) {
            object = this.p;
            long l10 = n10;
            long l11 = 1000L;
            ((d.v.z.l.i)object).f0(l10 *= l11);
            bl2 = this.H();
            if (bl2) {
                return;
            }
            object = new StringBuilder();
            String string3 = "notifyStateInfo setRecordBeginTime";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(n10);
            Object object2 = ((StringBuilder)object).toString();
            bl2 = false;
            object = new Object[]{};
            m.a.a.b((String)object2, (Object[])object);
            object2 = new d.v.z.l.i();
            ((d.v.z.l.i)object2).f0(l10);
            object = m1.o();
            string2 = this.l;
            ((m1)object).r(string2, (d.v.z.l.i)object2);
        }
    }

    public void W(Pair object) {
        int n10;
        Object object2 = (Boolean)((Pair)object).first;
        int n11 = d.v.e.h.a.c((Boolean)object2);
        object = (Integer)((Pair)object).second;
        Object object3 = null;
        int n12 = d.v.e.h.d.d((Integer)object, 0);
        Object object4 = this.p.K();
        if (object4 != null && (n10 = ((Boolean)(object4 = (Boolean)this.p.K().first)).booleanValue()) == n11 && (n10 = ((Integer)(object4 = (Integer)this.p.K().second)).intValue()) == n12) {
            return;
        }
        object4 = this.p;
        ((d.v.z.l.i)object4).g0(n11 != 0, n12);
        n10 = this.H();
        if (n10 != 0) {
            return;
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("notifyStateInfo setPhoneBattery:");
        ((StringBuilder)object4).append(n11 != 0);
        ((StringBuilder)object4).append(" ");
        ((StringBuilder)object4).append(n12);
        object4 = ((StringBuilder)object4).toString();
        object3 = new Object[]{};
        m.a.a.b((String)object4, (Object[])object3);
        object3 = new d.v.z.l.i();
        ((d.v.z.l.i)object3).g0(n11 != 0, n12);
        object = m1.o();
        object2 = this.l;
        ((m1)object).r((String)object2, (d.v.z.l.i)object3);
    }

    public void X(boolean bl2, boolean bl3) {
        Object object = bl2 ? "Captureing" : "Normal";
        Object object2 = this.p.L();
        boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl4 && (bl4 = ((String)object).equals(object2 = this.p.L()))) {
            return;
        }
        object2 = this.p;
        object2.h0((String)object);
        bl4 = this.H();
        if (bl4) {
            return;
        }
        object2 = new StringBuilder();
        object2.append("notifyStateInfo setPhoneCaptureState:");
        object2.append((String)object);
        object2.append(", recording = ");
        object2.append(bl2);
        Object object3 = object2.toString();
        object2 = new Object[]{};
        m.a.a.b((String)object3, object2);
        object3 = new d.v.z.l.i();
        ((d.v.z.l.i)object3).h0((String)object);
        object = m1.o();
        object2 = this.l;
        ((m1)object).r((String)object2, (d.v.z.l.i)object3);
    }

    public void Y(CameraSet$Mode object, boolean bl2) {
        Object object2;
        String string2 = CameraSet$Mode.fromMode((CameraSet$Mode)((Object)object), bl2);
        boolean bl3 = string2.equals(object2 = this.p.M());
        if (bl3) {
            return;
        }
        object2 = this.p;
        ((d.v.z.l.i)object2).i0(string2);
        bl3 = this.H();
        if (bl3) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("notifyStateInfo setPhoneMode:");
        object = ((Enum)object).name();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(bl2);
        object = ((StringBuilder)object2).toString();
        Object object3 = new Object[]{};
        m.a.a.b((String)object, (Object[])object3);
        object = new d.v.z.l.i();
        ((d.v.z.l.i)object).i0(string2);
        object3 = m1.o();
        string2 = this.l;
        ((m1)object3).r(string2, (d.v.z.l.i)object);
    }

    public void Z(int n10) {
        Object object;
        Object object2 = this.v(n10);
        boolean bl2 = ((String)object2).equals(object = this.p.N());
        if (bl2) {
            return;
        }
        object = this.p;
        object.j0((String)object2);
        bl2 = this.H();
        if (bl2) {
            return;
        }
        object = new StringBuilder();
        object.append("notifyStateInfo setPhoneOrientation:");
        object.append(n10);
        Object object3 = object.toString();
        object = new Object[]{};
        m.a.a.b((String)object3, object);
        object3 = new d.v.z.l.i();
        ((d.v.z.l.i)object3).j0((String)object2);
        object2 = m1.o();
        object = this.l;
        ((m1)object2).r((String)object, (d.v.z.l.i)object3);
    }

    public void a0(int n10, int n11) {
        int n12;
        Object object = this.p.T();
        if (object != null && (n12 = (object = this.p.T()).getWidth()) == n10 && (n12 = (object = this.p.T()).getHeight()) == n11) {
            return;
        }
        object = this.p;
        ((d.v.z.l.i)object).p0(n10, n11);
        n12 = (int)(this.H() ? 1 : 0);
        if (n12 != 0) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("notifyStateInfo setVideoTransResolution:");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" * ");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        object = new d.v.z.l.i();
        ((d.v.z.l.i)object).p0(n10, n11);
        m1 m12 = m1.o();
        String string2 = this.l;
        m12.r(string2, (d.v.z.l.i)object);
    }

    public void b0(int n10) {
        this.s = n10;
    }

    public void c0(int n10) {
        this.r = n10;
    }

    public void d0(boolean bl2) {
        boolean bl3;
        Object object = this.y();
        if (object != null && bl2 != (bl3 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.y().getValue())))) {
            object = this.a;
            Boolean bl4 = bl2;
            d.v.e.i.h.e((MutableLiveData)object, bl4);
            object = d.v.c.v0.n.d.s();
            ((d.v.c.v0.n.d)object).s0(bl2);
        }
    }

    public void e0(long l10, int n10) {
    }

    public void f0(Pair object) {
        int n10;
        Object object2 = (Boolean)((Pair)object).first;
        int n11 = d.v.e.h.a.c((Boolean)object2);
        object = (Integer)((Pair)object).second;
        Object object3 = null;
        int n12 = d.v.e.h.d.d((Integer)object, 0);
        Object object4 = this.p.O();
        if (object4 != null && (n10 = ((Boolean)(object4 = (Boolean)this.p.O().first)).booleanValue()) == n11 && (n10 = ((Integer)(object4 = (Integer)this.p.O().second)).intValue()) == n12) {
            return;
        }
        object4 = this.p;
        ((d.v.z.l.i)object4).l0(n11 != 0, n12);
        n10 = this.H();
        if (n10 != 0) {
            return;
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("notifyStateInfo setStabilizerBattery:");
        ((StringBuilder)object4).append(n11 != 0);
        ((StringBuilder)object4).append(n12);
        object4 = ((StringBuilder)object4).toString();
        object3 = new Object[]{};
        m.a.a.b((String)object4, (Object[])object3);
        object3 = new d.v.z.l.i();
        ((d.v.z.l.i)object3).l0(n11 != 0, n12);
        object = m1.o();
        object2 = this.l;
        ((m1)object).r((String)object2, (d.v.z.l.i)object3);
    }

    public void g0(boolean bl2) {
        Object object = bl2 ? "CanSendData" : "NoConnection";
        Object object2 = this.p;
        ((d.v.z.l.i)object2).m0((String)object);
        boolean bl3 = this.H();
        if (bl3) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("notifyStateInfo setStabilizerState:");
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        Object object3 = new Object[]{};
        m.a.a.b((String)object2, object3);
        object2 = new d.v.z.l.i();
        ((d.v.z.l.i)object2).m0((String)object);
        object = m1.o();
        object3 = this.l;
        ((m1)object).r((String)object3, (d.v.z.l.i)object2);
    }

    public void h0(long l10, int n10) {
    }

    public void i0(CameraSet$DelayInterval cameraSet$DelayInterval, CameraSet$DelayTime cameraSet$DelayTime, int n10) {
    }

    public void k0(CameraView object) {
        Object[] objectArray = null;
        this.u = false;
        Object object2 = this.l;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 != 0) {
            return;
        }
        object2 = d.v.h0.i.f();
        Object object3 = new v6$c(this, (CameraView)object);
        ((i)object2).u((g)object3);
        object2 = VtDataType.SurfaceType;
        int n11 = this.q;
        object3 = n11 != 0 ? VtEncoderType.H265 : VtEncoderType.H264;
        String string2 = this.l;
        object2 = d.v.h0.j.a((VtDataType)((Object)object2), (VtEncoderType)((Object)object3), 6020, string2, 7020);
        n11 = this.r;
        object3 = ((d.v.h0.j)object2).n(n11);
        int n12 = this.s;
        ((d.v.h0.j)object3).m(n12).l(30).k(5000000);
        d.v.h0.i.f().n((d.v.h0.j)object2);
        object2 = d.v.h0.i.f().e();
        this.t = object3 = new c(object2, false, null);
        object = ((CameraView)object).getDisplayRender();
        object2 = this.t;
        ((DisplayRender)object).B0((c)object2);
        d.v.h0.i.f().v();
        object = new StringBuilder();
        ((StringBuilder)object).append("VtPushStart:");
        object2 = this.l;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", mPushVideoWidth = ");
        n10 = this.r;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", mPushVideoHeight = ");
        n10 = this.s;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void m0(CameraView objectArray) {
        boolean bl2;
        this.u = bl2 = true;
        c c10 = this.t;
        if (c10 != null) {
            objectArray = objectArray.getDisplayRender();
            c10 = this.t;
            objectArray.F0(c10);
        }
        d.v.h0.i.f().w();
        objectArray = new Object[]{};
        m.a.a.b("VtPushStop", objectArray);
    }

    public void n() {
        Object object = new Object[]{};
        m.a.a.b("Remote agreeConnect", (Object[])object);
        object = m1.o();
        String string2 = this.l;
        ((m1)object).k(string2);
    }

    public void o(boolean bl2, boolean bl3) {
        if (bl2 && bl3) {
            Boolean bl4 = (Boolean)this.b.getValue();
            bl2 = d.v.e.h.a.c(bl4);
            if (bl2) {
                this.l0();
            } else {
                this.j0();
            }
        } else {
            this.l0();
            this.t();
        }
    }

    public void onCleared() {
        super.onCleared();
        m1.o().i();
        Object[] objectArray = new Object[]{};
        m.a.a.b("remote stop", objectArray);
        d.v.h0.i.f().r();
    }

    public void p() {
        Boolean bl2 = (Boolean)this.b.getValue();
        boolean bl3 = d.v.e.h.a.c(bl2);
        if (bl3) {
            MutableLiveData mutableLiveData;
            bl2 = (Boolean)this.c.getValue();
            bl3 = d.v.e.h.a.c(bl2) ^ true;
            if (!bl3) {
                mutableLiveData = this.d;
                Boolean bl4 = Boolean.TRUE;
                d.v.e.i.h.e(mutableLiveData, bl4);
            }
            mutableLiveData = this.c;
            bl2 = bl3;
            d.v.e.i.h.e(mutableLiveData, bl2);
        }
    }

    public void r(boolean bl2, CameraSet$Mode object, boolean bl3) {
        if (bl2 = this.F(bl2, (CameraSet$Mode)((Object)object), bl3)) {
            this.p();
        } else {
            Object object2 = CameraSet$Mode.delay_video;
            if (object2 == object && !bl3) {
                object2 = this.e;
                int n10 = 2131951815;
                object = n10;
                d.v.e.i.h.e((MutableLiveData)object2, object);
            } else {
                object2 = this.e;
                int n11 = 2131951814;
                object = n11;
                d.v.e.i.h.e((MutableLiveData)object2, object);
            }
        }
    }

    public void s(boolean bl2) {
        String string2 = null;
        if (bl2) {
            Object[] objectArray = (Object[])this.a.getValue();
            bl2 = d.v.e.h.a.c((Boolean)objectArray);
            boolean bl3 = d.v.c.m1.b.a();
            this.o(bl2, bl3);
            bl2 = this.o;
            if (!bl2) {
                m1.o().A();
                this.o = bl2 = true;
                objectArray = new Object[]{};
                string2 = "remote waitConnect";
                m.a.a.b(string2, objectArray);
            }
        } else {
            this.l0();
            Object object = this.l;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                object = (Boolean)this.b.getValue();
                bl2 = d.v.e.h.a.c((Boolean)object);
                if (bl2) {
                    this.t();
                } else {
                    this.M();
                }
            }
            if (bl2 = this.o) {
                m1.o().z();
                this.I(false);
                this.o = false;
                object = new Object[]{};
                string2 = "remote stopConnect";
                m.a.a.b(string2, object);
            }
        }
    }

    public void t() {
        Object object = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Remote disconnect");
            String string2 = this.l;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = null;
            Object object2 = new Object[]{};
            m.a.a.b((String)object, object2);
            object = m1.o();
            object2 = this.l;
            ((m1)object).m((String)object2);
            this.I(false);
        }
    }

    public int w() {
        return this.s;
    }

    public int x() {
        return this.r;
    }

    public MutableLiveData y() {
        return this.a;
    }

    public boolean z() {
        return this.u;
    }
}

