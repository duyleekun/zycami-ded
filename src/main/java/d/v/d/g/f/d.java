/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 *  android.view.Surface
 */
package d.v.d.g.f;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import d.v.d.g.f.b;
import d.v.d.g.f.b$a;
import d.v.d.g.f.d$a;
import d.v.d.g.f.d$b;
import d.v.d.g.f.e;
import d.v.d.g.f.e$b;
import d.v.d.h.f;
import java.io.IOException;

public class d {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private String m;
    private b n;
    private e o;
    private MediaMuxer p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private final b$a u;
    private final e$b v;

    public d() {
        int n10;
        this.k = n10 = 1;
        this.l = n10;
        this.q = n10 = -1;
        this.r = n10;
        this.s = false;
        this.t = false;
        Object object = new d$a(this);
        this.u = object;
        this.v = object = new d$b(this);
    }

    public static /* synthetic */ int a(d d10) {
        return d10.q;
    }

    public static /* synthetic */ int b(d d10, int n10) {
        d10.q = n10;
        return n10;
    }

    public static /* synthetic */ int c(d d10, MediaFormat mediaFormat) {
        return d10.j(mediaFormat);
    }

    public static /* synthetic */ boolean d(d d10) {
        return d10.k();
    }

    public static /* synthetic */ MediaMuxer e(d d10) {
        return d10.p;
    }

    public static /* synthetic */ boolean f(d d10) {
        return d10.t;
    }

    public static /* synthetic */ boolean g(d d10, boolean bl2) {
        d10.t = bl2;
        return bl2;
    }

    public static /* synthetic */ int h(d d10) {
        return d10.r;
    }

    public static /* synthetic */ int i(d d10, int n10) {
        d10.r = n10;
        return n10;
    }

    private int j(MediaFormat mediaFormat) {
        int n10;
        Object object = this.p;
        try {
            n10 = object.addTrack(mediaFormat);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            String string2 = "addTrack failed e=";
            ((StringBuilder)object).append(string2);
            String string3 = exception.toString();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            d.v.d.h.f.a(string3);
            n10 = -1;
        }
        return n10;
    }

    private boolean k() {
        int n10;
        block3: {
            block2: {
                int n11 = this.l;
                int n12 = this.r;
                int n13 = -1;
                n10 = 1;
                if (n11 != (n12 = n12 != n13 ? n10 : 0)) break block2;
                n11 = (int)(this.k ? 1 : 0);
                n12 = this.q;
                n12 = n12 != n13 ? n10 : 0;
                if (n11 == n12 && (n11 = (int)(this.s ? 1 : 0)) != 0) break block3;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    public void A(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B() {
        synchronized (this) {
            Object object = this.p;
            if (object == null) {
                String string2 = "must call prepare before";
                object = new IllegalStateException(string2);
                throw object;
            }
            boolean bl2 = this.k;
            if (bl2) {
                object = this.n;
                ((b)object).i();
            }
            if (bl2 = this.l) {
                object = this.o;
                ((e)object).p();
            }
            this.s = bl2 = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C() {
        synchronized (this) {
            Object object = null;
            this.s = false;
            object = this.n;
            IllegalStateException illegalStateException = null;
            if (object != null) {
                ((b)object).j();
                this.n = null;
            }
            if ((object = this.o) != null) {
                ((e)object).q();
                this.o = null;
            }
            try {
                object = this.p;
                if (object != null) {
                    object.stop();
                    object = this.p;
                    object.release();
                    this.p = null;
                }
                return;
            }
            catch (Exception exception) {
                illegalStateException = new IllegalStateException(exception);
                throw illegalStateException;
            }
        }
    }

    public void l(boolean bl2) {
        this.k = bl2;
    }

    public void m(boolean bl2) {
        this.l = bl2;
    }

    public Surface n() {
        boolean bl2 = this.l;
        if (bl2) {
            return this.o.i();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o() {
        int n10;
        Object object;
        int n11;
        Object object2;
        int n12 = this.k;
        if (n12 != 0) {
            object2 = new b();
            this.n = object2;
            n11 = this.g;
            ((b)object2).h(n11);
            object2 = this.n;
            n11 = this.h;
            ((b)object2).g(n11);
            object2 = this.n;
            n11 = this.i;
            ((b)object2).d(n11);
            object2 = this.n;
            n11 = this.j;
            ((b)object2).e(n11);
            object2 = this.n;
            object = this.u;
            ((b)object2).f((b$a)object);
            object2 = this.n;
            ((b)object2).c();
        }
        if ((n12 = this.l) != 0) {
            this.o = object2 = new e();
            n11 = this.a;
            n10 = this.b;
            ((e)object2).o(n11, n10);
            object2 = this.o;
            n11 = this.c;
            ((e)object2).n(n11);
            object2 = this.o;
            n11 = this.d;
            ((e)object2).k(n11);
            object2 = this.o;
            float f10 = this.f;
            ((e)object2).m(f10);
            object2 = this.o;
            object = this.v;
            ((e)object2).l((e$b)object);
            object2 = this.o;
            ((e)object2).j();
        }
        try {
            object = this.m;
            n10 = 0;
            object2 = new MediaMuxer((String)object, 0);
            this.p = object2;
            object2 = new StringBuilder();
            object = "prepare OrientationHint=";
            ((StringBuilder)object2).append((String)object);
            n11 = this.e;
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            object2 = this.p;
            n11 = this.e;
            object2.setOrientationHint(n11);
            object2 = this.n;
            if (object2 == null) {
                object2 = "mAudioEncoderCore==null,return";
                d.v.d.h.f.a((String)object2);
                return;
            }
            if ((object2 = ((b)object2).b()) == null) {
                object2 = "mAudioEncoderCore.getOutputFormat==null,return";
                d.v.d.h.f.a((String)object2);
                return;
            }
            object2 = this.n;
            object2 = ((b)object2).b();
            this.q = n12 = this.j((MediaFormat)object2);
            object2 = new StringBuilder();
            object = "prepare audio add track mAudioTrackId=";
            ((StringBuilder)object2).append((String)object);
            n11 = this.q;
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a((String)object2);
            return;
        }
        catch (IOException iOException) {
            this.p = null;
            object = new IllegalStateException("file path is error !!! ", iOException);
            throw object;
        }
    }

    public void p() {
        synchronized (this) {
            this.C();
            int n10 = -1;
            this.q = n10;
            this.r = n10;
            n10 = 1;
            this.k = n10;
            this.l = n10;
            return;
        }
    }

    public void q(byte[] byArray) {
        b b10 = this.n;
        if (b10 != null) {
            b10.a(byArray);
        }
    }

    public void r(int n10) {
        this.j = n10;
    }

    public void s(int n10) {
        this.h = n10;
    }

    public void t(int n10) {
        this.i = n10;
    }

    public void u(int n10) {
        this.g = n10;
    }

    public void v(float f10) {
        this.f = f10;
    }

    public void w(int n10) {
        this.e = n10;
    }

    public void x(String string2) {
        this.m = string2;
    }

    public void y(int n10) {
        this.d = n10;
    }

    public void z(int n10) {
        this.c = n10;
    }
}

