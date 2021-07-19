/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.media.MediaRecorder
 *  android.os.Handler
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.g.t;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaRecorder;
import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import d.v.d.e;
import d.v.d.g.b;
import d.v.d.g.g.l;
import d.v.d.g.g.m;
import d.v.d.g.g.t.c;
import d.v.d.g.g.t.d;
import d.v.d.g.g.t.f;
import d.v.d.g.g.t.g$a;
import d.v.d.g.g.t.g$b;
import d.v.d.g.h.a;
import d.v.d.i.a.c$a;
import d.v.d.i.f.t;
import d.v.d.i.g.h;
import d.v.d.i.g.j;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.d.i.g.n;
import java.util.List;
import java.util.Map;

public class g
extends m {
    private static final int u = 200;
    private a r;
    private final c$a s;
    private final Runnable t;

    public g(f object, e e10, Context context) {
        super((l)object, e10, context);
        this.s = object = new c(this);
        this.t = object = new g$b(this);
        this.r = object = new a();
        this.p0(true);
    }

    public static /* synthetic */ Handler C0(g g10) {
        return g10.l();
    }

    public static /* synthetic */ int D0(g g10) {
        return g10.G0();
    }

    public static /* synthetic */ Runnable E0(g g10) {
        return g10.t;
    }

    public static /* synthetic */ Handler F0(g g10) {
        return g10.l();
    }

    private int G0() {
        block8: {
            a a10;
            try {
                a10 = this.r;
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
            this.c1();
            return 0;
        }
        double d10 = 20.0;
        a a11 = this.r;
        a11 = a11.b();
        int n10 = a11.getMaxAmplitude();
        float f10 = n10;
        float f11 = 0.1f;
        double d11 = f10 /= f11;
        return (int)(Math.log10(d11) * d10);
    }

    private /* synthetic */ void H(Integer n10, int n11) {
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
                    this.V0();
                }
            } else {
                n10 = this.l();
                object = new d.v.d.g.g.t.e(this);
                n10.post((Runnable)object);
            }
        } else {
            n10 = this.l();
            object = new d(this);
            n10.post((Runnable)object);
        }
    }

    private int R0() {
        int n10 = this.k();
        d.v.d.i.f.l l10 = this.s();
        boolean bl2 = l10.s();
        if (bl2) {
            n10 = (360 - n10) % 360;
        }
        return n10;
    }

    public static /* synthetic */ int T0(Size size, Size size2) {
        int n10 = size2.getWidth();
        int n11 = size2.getHeight();
        n10 *= n11;
        n11 = size.getWidth();
        int n12 = size.getHeight();
        return n10 - (n11 *= n12);
    }

    private void W0(boolean bl2) {
        d.v.d.i.g.f f10 = this.J0();
        c$a c$a = this.s;
        this.b(bl2, f10, c$a);
    }

    private void X0() {
        d.v.d.h.f.a("reset support preview and  record size");
        Object object = this.N0();
        Object object2 = this.c.getSupportedVideoSizes(MediaRecorder.class);
        int n10 = (Integer)this.s().get();
        ((k)object).C((Map)object2, n10);
        object = this.c.getSupportedPreviewSizes(SurfaceTexture.class);
        object2 = d.v.d.g.g.t.b.a;
        object.sort(object2);
        object2 = this.w();
        Size size = (Size)this.z().get();
        ((t)object2).x((List)object, size);
        object2 = this.w();
        size = ((k$a)this.N0().get()).a;
        object = this.u0((List)object, size);
        ((t)object2).v((Size)object);
    }

    private boolean Y0() {
        d.v.d.h.f.a("set up MediaRecorder");
        Object object = this.r;
        boolean bl2 = false;
        Object object2 = null;
        if (object == null) {
            d.v.d.h.f.a("current is mMediaRecorderZy==null,return");
            return false;
        }
        object = (k$a)this.N0().get();
        Object object3 = this.L0();
        double d10 = ((k$a)object).c();
        Object object4 = (Double)this.I0().get();
        double d11 = (Double)object4;
        double d12 = (d10 = Math.abs(d10 - d11)) - (d11 = 3.0);
        Object object5 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object5 > 0) {
            bl2 = true;
        }
        object2 = bl2;
        ((d.v.d.i.a.a)object3).set(object2);
        Size size = ((k$a)object).a;
        object4 = object3 = this.P0().get();
        object4 = (Surface)object3;
        int n10 = this.R0();
        int n11 = ((k$a)object).c();
        double d13 = (Double)this.I0().get();
        object3 = this.H0();
        object = ((k$a)object).a;
        object5 = (Integer)this.s().get();
        int n12 = ((d.v.d.i.g.d)object3).n((Size)object, (int)object5);
        boolean bl3 = (Boolean)this.L0().get();
        String string2 = this.M0().o();
        int n13 = this.K0().n();
        object2 = new b(size, (Surface)object4, n10, n11, d13, n12, bl3, string2, n13);
        object = new g$a(this);
        ((b)object2).i = object;
        return this.r.d((b)object2);
    }

    private void a1() {
        Handler handler = this.l();
        Runnable runnable = this.t;
        handler.postDelayed(runnable, (long)100);
    }

    private void b1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop Record getRecordStatus=");
        Object object2 = this.O0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.r;
        if (object == null) {
            d.v.d.h.f.a("current is mMode=null or mMediaRecorderZy=null,return");
            return;
        }
        object = this.O0();
        boolean bl2 = ((d.v.d.i.g.l)object).p();
        if (!bl2) {
            d.v.d.h.f.a("current is not prepare stop ,return");
            return;
        }
        this.r.h();
        this.c1();
        object = this.O0();
        object2 = 5;
        ((d.v.d.i.g.l)object).s((Integer)object2);
    }

    private void c1() {
        Handler handler = this.l();
        Runnable runnable = this.t;
        handler.removeCallbacks(runnable);
    }

    public d.v.d.i.g.d H0() {
        return this.a.M0();
    }

    public d.v.d.i.g.e I0() {
        return this.a.N0();
    }

    public d.v.d.i.g.f J0() {
        return this.a.O0();
    }

    public d.v.d.i.g.g K0() {
        return this.a.P0();
    }

    public h L0() {
        return this.a.Q0();
    }

    public j M0() {
        return this.a.R0();
    }

    public k N0() {
        return this.a.S0();
    }

    public d.v.d.i.g.l O0() {
        return this.a.T0();
    }

    public d.v.d.i.g.m P0() {
        return this.a.U0();
    }

    public n Q0() {
        return this.a.V0();
    }

    public /* synthetic */ void S0(Integer n10, int n11) {
        this.H(n10, n11);
    }

    public void U0() {
        Object object = new StringBuilder();
        Object object2 = "prepare Record getRecordStatus=";
        ((StringBuilder)object).append((String)object2);
        d.v.d.i.g.l l10 = this.O0();
        ((StringBuilder)object).append(l10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        object2 = this.O0();
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(",getPreviewStatus=");
        object2 = this.x();
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(",getDeviceStatus=");
        object2 = this.i();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O0();
        boolean bl2 = ((d.v.d.i.g.l)object).o();
        if (!bl2 && !(bl2 = ((d.v.d.i.g.l)(object = this.O0())).q())) {
            object = this.P0();
            int n10 = 0;
            object2 = null;
            ((d.v.d.i.a.a)object).set(null);
            bl2 = this.Y0();
            if (bl2) {
                object = this.P0();
                object2 = this.r.c();
                ((d.v.d.i.a.a)object).set(object2);
                object = this.O0();
                n10 = 1;
                object2 = n10;
                ((d.v.d.i.g.l)object).s((Integer)object2);
                object = "prepare Record  finish";
                d.v.d.h.f.a((String)object);
            } else {
                d.v.d.h.f.a("prepare Record error");
                object = this.O0();
                n10 = 6;
                object2 = n10;
                ((d.v.d.i.g.l)object).s((Integer)object2);
            }
            return;
        }
        d.v.d.h.f.a("current is prepare start or start, return");
    }

    public void V0() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("prepare stop getRecordStatus=");
        Object object2 = this.O0();
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.O0();
        boolean bl2 = ((d.v.d.i.g.l)object).q();
        if (!bl2) {
            d.v.d.h.f.a("current is not start,return");
            return;
        }
        object = this.O0();
        object2 = 4;
        ((d.v.d.i.g.l)object).s((Integer)object2);
        this.b1();
    }

    public void Z0() {
        long l10;
        d.v.d.h.f.a("start record ");
        Object object = this.O0();
        Object object2 = ((d.v.d.i.g.l)object).o();
        if (object2 == 0) {
            d.v.d.h.f.a("current is not prepared start,return");
            return;
        }
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = 200L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            d.v.d.h.f.a("current is not enough arm ,return");
            return;
        }
        object = this.r;
        if (object == null) {
            d.v.d.h.f.a("current is mMode=null or mMediaRecorderZy=null,return");
            return;
        }
        object = this.O0();
        Integer n10 = 2;
        ((d.v.d.i.g.l)object).s(n10);
        this.r.g();
        this.a1();
    }

    public void k0() {
        a a10 = this.r;
        if (a10 != null) {
            a10.e();
            a10 = null;
            this.r = null;
        }
    }

    public void p0(boolean bl2) {
        this.W0(bl2);
    }

    public void q0() {
        this.X0();
    }
}

