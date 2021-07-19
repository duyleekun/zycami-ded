/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.os.Handler
 *  android.util.Range
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.d.w;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.b;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.d.w.a;
import d.v.d.g.d.w.c;
import d.v.d.g.d.w.d;
import d.v.d.g.d.w.e;
import d.v.d.g.d.w.f;
import d.v.d.g.d.w.g;
import d.v.d.g.d.w.h$a;
import d.v.d.i.a.c$a;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.g.j;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.d.i.g.l;
import d.v.d.i.g.m;
import java.util.Arrays;
import java.util.List;

public class h
extends o {
    private static final int w = 200;
    private final g s;
    private d.v.d.g.f.d t;
    private final c$a u;
    private final c$a v;

    public h(g g10, d.v.d.e object) {
        super((d.v.d.e)object, g10);
        this.u = object = new e(this);
        this.v = object = new f(this);
        this.s = g10;
        this.F0(true);
    }

    private b e1(k$a object) {
        int n10;
        b b10;
        Object object2;
        Size size = ((k$a)object).a;
        Object object3 = object2 = this.c1().get();
        object3 = (Surface)object2;
        int n11 = this.r();
        object2 = this.V0();
        object = ((k$a)object).a;
        int n12 = (Integer)this.C().get();
        int n13 = ((d.v.d.i.g.d)object2).n((Size)object, n12);
        boolean bl2 = (Boolean)this.Z0().get();
        String string2 = this.a1().o();
        int n14 = this.Y0().n();
        object2 = b10;
        b10 = new b(size, (Surface)object3, n11, 30, 240.0, n13, bl2, string2, n14);
        b10.j = n10 = ((Integer)this.C().get()).intValue();
        object = new h$a(this);
        b10.i = object;
        return b10;
    }

    public static /* synthetic */ void f1(h h10) {
        h10.q1();
    }

    private /* synthetic */ void g1(k$a object, int n10) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        String string2 = "record size notify fpsSize=";
        comparable.append(string2);
        object = ((k$a)object).toString();
        comparable.append((String)object);
        comparable.append("\uff0cisPreviewIng=");
        boolean bl2 = this.I().o();
        comparable.append(bl2);
        d.v.d.h.f.a(comparable.toString());
        object = this.I();
        bl2 = ((u)object).o();
        if (bl2) {
            object = this.R();
            n10 = 4;
            comparable = n10;
            ((d.v.d.i.b.e)object).n((Integer)comparable);
            this.g();
            this.o0();
        }
    }

    private /* synthetic */ void i1(Integer n10, int n11) {
        Object object = new StringBuilder();
        String string2 = "record control change integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        int n12 = n10;
        if (n12 != 0) {
            n11 = 1;
            if (n12 != n11) {
                n11 = 2;
                if (n12 == n11) {
                    this.m1();
                }
            } else {
                n10 = this.s();
                object = new d(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.s();
            object = new a(this);
            n10.post((Runnable)object);
        }
    }

    public static /* synthetic */ int k1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void n1(boolean bl2) {
        d.v.d.i.g.f f10 = this.X0();
        c$a c$a = this.v;
        this.b(bl2, f10, c$a);
        this.o1(bl2);
    }

    private void o1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add photo size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b1();
        c$a c$a = this.u;
        this.b(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void p1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) == null) {
            d.v.d.h.f.a("no support size find");
            return;
        }
        d.v.d.h.f.a("reset support preview and  record size");
        object = Arrays.asList(object.getOutputSizes(SurfaceTexture.class));
        object2 = d.v.d.g.d.w.c.a;
        object.sort(object2);
        object2 = (Integer)this.A().f();
        int n10 = (Integer)object2;
        int n11 = 60;
        if (n10 < n11) {
            n11 = 30;
        }
        object2 = this.b1();
        int n12 = (Integer)this.C().get();
        ((k)object2).B((List)object, n11, n12);
        object2 = this.H();
        Size size = (Size)this.K().get();
        ((t)object2).x((List)object, size);
        object2 = ((k$a)this.b1().get()).a;
        double d10 = (double)object2.getWidth() * 1.0;
        double d11 = object2.getHeight();
        n10 = object2.getHeight();
        t t10 = this.H();
        object = this.L0((List)object, d10 /= d11, n10);
        t10.v((Size)object);
    }

    private void q1() {
        long l10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("start record getPreviewStatus=");
        Object object2 = this.I();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O();
        Object object3 = ((l)object).o();
        if (object3 == 0) {
            d.v.d.h.f.a("current is not prepared start,return");
            return;
        }
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = 200L);
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0 && (object3 = (Object)((u)(object = this.I())).o()) != 0) {
            object = this.t;
            if (object == null) {
                d.v.d.h.f.a("current is mMediaRecorderZy==null,return");
                return;
            }
            d.v.d.h.f.a("start record");
            object = this.O();
            object2 = 2;
            ((l)object).s((Integer)object2);
            this.t.B();
            return;
        }
        d.v.d.h.f.a("current is not enough arm ,return");
    }

    private void r1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop Record getRecordStatus=");
        Object object2 = this.O();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.t;
        if (object == null) {
            d.v.d.h.f.a("current is mMediaRecorderZy=null,return");
            return;
        }
        object = this.O();
        boolean bl2 = ((l)object).p();
        if (!bl2) {
            d.v.d.h.f.a("current is not prepare stop ,return");
            return;
        }
        d.v.d.h.f.a("stop record");
        this.t.C();
        object = this.O();
        object2 = 5;
        ((l)object).s((Integer)object2);
    }

    public void F0(boolean bl2) {
        this.n1(bl2);
    }

    public void G0() {
        this.p1();
    }

    public d.v.d.i.g.d V0() {
        return this.a.M0();
    }

    public d.v.d.i.g.e W0() {
        return this.a.N0();
    }

    public d.v.d.i.g.f X0() {
        return this.a.O0();
    }

    public d.v.d.i.g.g Y0() {
        return this.a.P0();
    }

    public d.v.d.i.g.h Z0() {
        return this.a.Q0();
    }

    public j a1() {
        return this.a.R0();
    }

    public k b1() {
        return this.a.S0();
    }

    public m c1() {
        return this.a.U0();
    }

    public d.v.d.i.g.n d1() {
        return this.a.V0();
    }

    public /* synthetic */ void h1(k$a k$a, int n10) {
        this.g1(k$a, n10);
    }

    public /* synthetic */ void j1(Integer n10, int n11) {
        this.i1(n10, n11);
    }

    public void l1() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare Record getRecordStatus=");
        Object object2 = this.O();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.s;
        boolean n10 = ((n)object).i();
        if (n10) {
            return;
        }
        object = this.O();
        boolean bl3 = ((l)object).o();
        if (!bl3 && !(bl2 = ((l)(object = this.O())).q())) {
            object = (k$a)this.b1().get();
            object2 = this.u();
            Object object3 = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            int n11 = 1;
            Integer n12 = n11;
            object = ((k$a)object).c();
            Range range = new Range((Comparable)n12, (Comparable)object);
            object2.set(object3, (Object)range);
            object = this.s;
            object2 = this.u();
            object3 = this.v();
            range = this.B();
            ((n)object).P((CaptureRequest.Builder)object2, (CameraCaptureSession.CaptureCallback)object3, (Handler)range);
            this.t = object = new d.v.d.g.f.d();
            object = (k$a)this.b1().get();
            object = this.e1((k$a)object);
            this.t.l(false);
            object2 = this.t;
            float f10 = (float)((b)object).e;
            ((d.v.d.g.f.d)object2).v(f10);
            object2 = this.t;
            int n13 = ((b)object).c;
            ((d.v.d.g.f.d)object2).w(n13);
            object2 = this.t;
            object3 = ((b)object).h;
            ((d.v.d.g.f.d)object2).x((String)object3);
            object2 = this.t;
            n13 = ((b)object).d;
            ((d.v.d.g.f.d)object2).z(n13);
            object2 = this.t;
            n13 = ((b)object).a.getWidth();
            int n14 = ((b)object).a.getHeight();
            ((d.v.d.g.f.d)object2).A(n13, n14);
            object2 = this.t;
            int n15 = ((b)object).f;
            ((d.v.d.g.f.d)object2).y(n15);
            this.t.o();
            object = this.c1();
            object2 = this.t.n();
            ((d.v.d.i.a.a)object).set(object2);
            object = this.O();
            object2 = n11;
            ((l)object).s((Integer)object2);
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void m1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare stop getRecordStatus=");
        Object object2 = this.O();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O();
        boolean bl2 = ((l)object).q();
        if (!bl2) {
            d.v.d.h.f.a("current is not start,return");
            return;
        }
        object = this.O();
        object2 = 4;
        ((l)object).s((Integer)object2);
        this.r1();
    }

    public void z0() {
    }
}

