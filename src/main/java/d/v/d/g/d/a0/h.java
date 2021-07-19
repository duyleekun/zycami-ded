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
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Range
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.d.a0;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.d.a0.b;
import d.v.d.g.d.a0.c;
import d.v.d.g.d.a0.d;
import d.v.d.g.d.a0.e;
import d.v.d.g.d.a0.f;
import d.v.d.g.d.a0.g;
import d.v.d.g.d.a0.h$a;
import d.v.d.g.d.a0.h$b;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.h.a;
import d.v.d.i.a.c$a;
import d.v.d.i.f.l;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.g.j;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.d.i.g.m;
import java.util.Arrays;
import java.util.List;

public class h
extends o {
    private static final int x = 200;
    private final g s;
    private final a t;
    private final c$a u;
    private final c$a v;
    private final Runnable w;

    public h(g object, d.v.d.e object2) {
        super((d.v.d.e)object2, (n)object);
        this.u = object2 = new c(this);
        this.v = object2 = new e(this);
        this.w = object2 = new h$b(this);
        this.s = object;
        this.t = object = new a();
        this.F0(true);
    }

    public static /* synthetic */ int V0(h h10) {
        return h10.X0();
    }

    public static /* synthetic */ Runnable W0(h h10) {
        return h10.w;
    }

    private int X0() {
        block8: {
            a a10;
            try {
                a10 = this.t;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getCurrentDecibel failed e=");
                String string2 = exception.toString();
                stringBuilder.append(string2);
                d.v.d.h.f.a(stringBuilder.toString());
                return 0;
            }
            a10 = a10.b();
            if (a10 != null) break block8;
            this.x1();
            return 0;
        }
        double d10 = 20.0;
        a a11 = this.t;
        a11 = a11.b();
        int n10 = a11.getMaxAmplitude();
        float f10 = n10;
        float f11 = 0.1f;
        double d11 = f10 /= f11;
        return (int)(Math.log10(d11) * d10);
    }

    private int h1() {
        int n10 = this.r();
        l l10 = this.C();
        boolean bl2 = l10.s();
        if (bl2) {
            n10 = (360 - n10) % 360;
        }
        return n10;
    }

    private d.v.d.g.b i1(k$a object) {
        int n10;
        d.v.d.g.b b10;
        Object object2;
        Size size = ((k$a)object).a;
        Object object3 = object2 = this.f1().get();
        object3 = (Surface)object2;
        int n11 = this.h1();
        int n12 = ((k$a)object).c();
        double d10 = (Double)this.Z0().get();
        object2 = this.Y0();
        object = ((k$a)object).a;
        int n13 = (Integer)this.C().get();
        n13 = ((d.v.d.i.g.d)object2).n((Size)object, n13);
        boolean bl2 = (Boolean)this.c1().get();
        String string2 = this.d1().o();
        int n14 = this.b1().n();
        object2 = b10;
        b10 = new d.v.d.g.b(size, (Surface)object3, n11, n12, d10, n13, bl2, string2, n14);
        b10.j = n10 = ((Integer)this.C().get()).intValue();
        object = new h$a(this);
        b10.i = object;
        return b10;
    }

    public static /* synthetic */ void j1(h h10) {
        h10.u1();
    }

    private /* synthetic */ void k1(k$a object, int n10) {
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

    private /* synthetic */ void m1(Integer n10, int n11) {
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
                    this.q1();
                }
            } else {
                n10 = this.s();
                object = new b(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.s();
            object = new f(this);
            n10.post((Runnable)object);
        }
    }

    public static /* synthetic */ int o1(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void r1(boolean bl2) {
        d.v.d.i.g.f f10 = this.a1();
        c$a c$a = this.v;
        this.b(bl2, f10, c$a);
    }

    private void s1(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add record size listener add=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.e1();
        c$a c$a = this.u;
        this.b(bl2, (d.v.d.i.a.a)object, c$a);
    }

    private void t1() {
        Object object = this.c;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) == null) {
            d.v.d.h.f.a("no support size find");
            return;
        }
        d.v.d.h.f.a("reset support preview and  record size");
        object = Arrays.asList(object.getOutputSizes(SurfaceTexture.class));
        object2 = d.v.d.g.d.a0.d.a;
        object.sort(object2);
        object2 = (Integer)this.A().f();
        int n10 = (Integer)object2;
        int n11 = 60;
        if (n10 < n11) {
            n11 = 30;
        }
        object2 = this.e1();
        int n12 = (Integer)this.C().get();
        ((k)object2).B((List)object, n11, n12);
        object2 = this.H();
        Size size = (Size)this.K().get();
        ((t)object2).x((List)object, size);
        object2 = ((k$a)this.e1().get()).a;
        double d10 = (double)object2.getWidth() * 1.0;
        double d11 = object2.getHeight();
        n10 = object2.getHeight();
        t t10 = this.H();
        object = this.L0((List)object, d10 /= d11, n10);
        t10.v((Size)object);
    }

    private void u1() {
        long l10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("start record getPreviewStatus=");
        Object object2 = this.I().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O();
        Object object3 = ((d.v.d.i.g.l)object).o();
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
            ((d.v.d.i.g.l)object).s((Integer)object2);
            SystemClock.sleep((long)50);
            this.t.g();
            this.v1();
            return;
        }
        d.v.d.h.f.a("current is not enough arm ,return");
    }

    private void v1() {
        Handler handler = this.s();
        Runnable runnable = this.w;
        handler.postDelayed(runnable, (long)100);
    }

    private void w1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop Record getRecordStatus=");
        Object object2 = this.O().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.t;
        if (object == null) {
            d.v.d.h.f.a("current is mMediaRecorderZy=null,return");
            return;
        }
        object = this.O();
        boolean bl2 = ((d.v.d.i.g.l)object).p();
        if (!bl2) {
            d.v.d.h.f.a("current is not prepare stop ,return");
            return;
        }
        d.v.d.h.f.a("stop record");
        this.t.h();
        this.x1();
        object = this.O();
        object2 = 5;
        ((d.v.d.i.g.l)object).s((Integer)object2);
    }

    private void x1() {
        Handler handler = this.s();
        Runnable runnable = this.w;
        handler.removeCallbacks(runnable);
    }

    public void F0(boolean bl2) {
        this.r1(bl2);
        this.s1(bl2);
    }

    public void G0() {
        this.t1();
    }

    public d.v.d.i.g.d Y0() {
        return this.a.M0();
    }

    public d.v.d.i.g.e Z0() {
        return this.a.N0();
    }

    public d.v.d.i.g.f a1() {
        return this.a.O0();
    }

    public d.v.d.i.g.g b1() {
        return this.a.P0();
    }

    public d.v.d.i.g.h c1() {
        return this.a.Q0();
    }

    public j d1() {
        return this.a.R0();
    }

    public k e1() {
        return this.a.S0();
    }

    public m f1() {
        return this.a.U0();
    }

    public d.v.d.i.g.n g1() {
        return this.a.V0();
    }

    public /* synthetic */ void l1(k$a k$a, int n10) {
        this.k1(k$a, n10);
    }

    public /* synthetic */ void n1(Integer n10, int n11) {
        this.m1(n10, n11);
    }

    public void p1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare Record getRecordStatus=");
        Object object2 = this.O().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.s;
        boolean bl2 = ((n)object).i();
        if (bl2) {
            return;
        }
        object = this.O();
        bl2 = ((d.v.d.i.g.l)object).o();
        if (!bl2 && !(bl2 = ((d.v.d.i.g.l)(object = this.O())).q())) {
            object = (k$a)this.e1().get();
            object2 = this.Z0();
            double d10 = ((k$a)object).c();
            double d11 = 1.0;
            Double d12 = d10 *= d11;
            ((d.v.d.i.g.e)object2).n(d12);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("fps set=");
            int n10 = ((k$a)object).c();
            ((StringBuilder)object2).append(n10);
            d.v.d.h.f.a(((StringBuilder)object2).toString());
            object2 = this.u();
            d12 = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            int n11 = 1;
            Integer n12 = n11;
            int n13 = ((k$a)object).c();
            Integer n14 = n13;
            Range range = new Range((Comparable)n12, (Comparable)n14);
            object2.set((CaptureRequest.Key)d12, (Object)range);
            object2 = this.s;
            d12 = this.u();
            range = this.v();
            n12 = this.B();
            ((n)object2).P((CaptureRequest.Builder)d12, (CameraCaptureSession.CaptureCallback)range, (Handler)n12);
            object2 = this.f1();
            n10 = 0;
            d12 = null;
            ((d.v.d.i.a.a)object2).set(null);
            object2 = this.t;
            object = this.i1((k$a)object);
            bl2 = ((a)object2).d((d.v.d.g.b)object);
            if (bl2) {
                object = this.f1();
                object2 = this.t.c();
                ((d.v.d.i.a.a)object).set(object2);
                object = this.O();
                object2 = n11;
                ((d.v.d.i.g.l)object).s((Integer)object2);
            } else {
                object = this.O();
                int n15 = 6;
                object2 = n15;
                ((d.v.d.i.g.l)object).s((Integer)object2);
            }
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void q1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare stop getRecordStatus=");
        Object object2 = this.O().get();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O();
        boolean bl2 = ((d.v.d.i.g.l)object).q();
        if (!bl2) {
            d.v.d.h.f.a("current is not start,return");
            return;
        }
        object = this.O();
        object2 = 4;
        ((d.v.d.i.g.l)object).s((Integer)object2);
        this.w1();
    }

    public void z0() {
        d.v.d.h.f.a("release Source");
    }
}

